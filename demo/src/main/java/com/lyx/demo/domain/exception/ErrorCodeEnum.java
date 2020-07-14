package com.lyx.demo.domain.exception;

/**
 * @author Ryan
 */
public enum ErrorCodeEnum {

	SUCCESS("DEMO.000", "Success"),
	NOT_EXIST_USER("DEMO.001", "Not exit user!"),
	NOT_FOUND_USER("DEMO.002", "Not found user userId=%s"),
	ILLEGAL_USER_NAME("DEMO.003", "Illegal user name userName=%s"),
	EXIST_USER_NAME("DEMO.004", "Exist user name userName=%s");

	private String code;

	private String msg;

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	ErrorCodeEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public void throwException() {
		throw new AppRtException(getCode(), getMsg());
	}

	public void throwException(Throwable t) {
		throw new AppRtException(getCode(), getMsg(), t);
	}

	public void throwException(Object[] args) {
		throw new AppRtException(getCode(), getMsg(), args);
	}
}
