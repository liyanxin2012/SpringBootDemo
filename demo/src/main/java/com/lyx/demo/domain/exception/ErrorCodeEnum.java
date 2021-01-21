package com.lyx.demo.domain.exception;

/**
 * @author Ryan
 */
public enum ErrorCodeEnum {

	SUCCESS("0", "Success!"),
	DELETED_USER("DEMO.001", "Deleted user userId=%s!"),
	NOT_EXIST_USER("DEMO.002", "Not exist user userId=%s"),
	ILLEGAL_USER_NAME("DEMO.003", "Illegal user name userName=%s"),
	ILLEGAL_USER_STATUS("DEMO.004", "Illegal user status userId/status=%s/%s"),
	EXIST_USER_NAME("DEMO.005", "Exist user name userName=%s"),
	SYSTEM_ERROR("DEMO.096", "System error!");

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
