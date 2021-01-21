package com.lyx.demo.infrastructure.exception;

import com.lyx.demo.access.GenericResponse;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

/**
 * Message Source Translator
 *
 * @author Ryan
 */
@Service
public class MessageSourceTranslator {

	/**
	 * Message Source
	 */
	private MessageSource messageSource;

	/**
	 * 构造方法注入
	 *
	 * @param messageSource
	 */
	public MessageSourceTranslator(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	/**
	 * 转换翻译错误码
	 *
	 * @param response
	 * @param args
	 * @param defaultMsg
	 * @param <T>
	 * @return
	 */
	public <T> GenericResponse<T> transferErrorMessage(GenericResponse<T> response, Object[] args, String defaultMsg) {
		response.setErrMsg(messageSource.getMessage(response.getErrNo(), args, defaultMsg, LocaleContextHolder.getLocale()));
		return response;
	}
}
