package com.lyx.demo.infrastructure.exception;

import com.lyx.demo.access.GenericResponse;
import com.lyx.demo.domain.exception.AppBizException;
import com.lyx.demo.domain.exception.AppRtException;
import com.lyx.demo.domain.exception.ErrorCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Generic Response Handler
 *
 * @author Ryan
 */
@Service
public class GenericResponseHandler implements HandlerExceptionResolver {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Message Source Translator
	 */
	private MessageSourceTranslator messageSourceTranslator;

	/**
	 * 构造方法注入
	 *
	 * @param messageSourceTranslator
	 */
	public GenericResponseHandler(MessageSourceTranslator messageSourceTranslator) {
		this.messageSourceTranslator = messageSourceTranslator;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		return new ModelAndView(GenericResponseViewResolver.VIEW_NAME);
	}

	/**
	 * 构建错误应答
	 *
	 * @param ex
	 * @param <T>
	 * @return
	 */
	private <T> GenericResponse<T> buildErrorGenericResponse(Exception ex) {
		logger.error("[GenericResponseHandler]Error msg!", ex);

		if (ex instanceof AppRtException) {
			return handleAppRtException((AppRtException) ex);
		}

		if (ex instanceof AppBizException) {
			return handleAppBizException((AppBizException) ex);
		}

		return GenericResponse.responseOf(ErrorCodeEnum.SYSTEM_ERROR.getCode(), ErrorCodeEnum.SYSTEM_ERROR.getMsg());
	}

	/**
	 * 处理应用运行时异常
	 *
	 * @param rtEx
	 * @param <T>
	 * @return
	 */
	private <T> GenericResponse<T> handleAppRtException(AppRtException rtEx) {
		return messageSourceTranslator.transferErrorMessage(GenericResponse.responseOf(rtEx.getCode(), rtEx.getMsg()), rtEx.getArgs(), ErrorCodeEnum.SYSTEM_ERROR.getMsg());
	}

	/**
	 * 处理应用业务异常
	 *
	 * @param bizEx
	 * @param <T>
	 * @return
	 */
	private <T> GenericResponse<T> handleAppBizException(AppBizException bizEx) {
		return messageSourceTranslator.transferErrorMessage(GenericResponse.responseOf(bizEx.getCode(), bizEx.getMsg()), bizEx.getArgs(), ErrorCodeEnum.SYSTEM_ERROR.getMsg());
	}

}
