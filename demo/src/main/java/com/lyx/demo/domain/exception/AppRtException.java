package com.lyx.demo.domain.exception;

/**
 * 应用运行时异常
 *
 * @author Ryan
 */
public class AppRtException extends RuntimeException {

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

	public AppRtException(String code) {
		super(String.format("AppRtException[%s]", code));
		this.code = code;
	}

	public AppRtException(String code, String msg) {
		super(String.format("AppRtException[%s]:%s", code, msg));
		this.code = code;
		this.msg = msg;
	}

	public AppRtException(String code, String msg, Throwable t) {
		super(String.format("AppRtException[%s]:%s", code, msg), t);
		this.code = code;
		this.msg = msg;
	}

	public AppRtException(String code, String msg, Object[] args) {
		super(String.format("AppRtException[%s]:%s", code, msg));
		this.code = code;
		this.msg = String.format(msg, args);
		this.args = args;
	}

	public AppRtException(String code, String msg, Object[] args, Throwable t) {
		super(String.format("AppRtException[%s]:%s", code, msg), t);
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
