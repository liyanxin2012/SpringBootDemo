package com.lyx.demo.domain.exception;

/**
 * 应用业务异（必须catch）
 *
 * @author Ryan
 */
public class AppBizException extends Exception {

	/**
	 * 错误码
	 */
	private String code;

	/**
	 * 错误描述
	 */
	private String msg;

	/**
	 * 异常描述参数数组
	 */
	private Object[] args;

	public AppBizException(String code) {
		super(String.format("AppBizException[%s]", code));
		this.code = code;
	}

	public AppBizException(String code, Throwable t) {
		super(String.format("AppBizException[%s]", code), t);
		this.code = code;
	}

	public AppBizException(String code, String msg) {
		super(String.format("AppBizException[%s]:%s", code, msg));
		this.code = code;
		this.msg = msg;
	}

	public AppBizException(String code, String msg, Throwable t) {
		super(String.format("AppBizException[%s]:%s", code, msg), t);
		this.code = code;
		this.msg = msg;
	}

	public AppBizException(String code, String msg, Object[] args) {
		super(String.format("AppBizException[%s]:%s", code, msg));
		this.code = code;
		this.msg = String.format(msg, args);
		this.args = args;
	}

	public AppBizException(String code, String msg, Object[] args, Throwable t) {
		super(String.format("AppBizException[%s]:%s", code, msg), t);
		this.code = code;
		this.msg = String.format(msg, args);
		this.args = args;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}
}
