package com.lyx.demo.domain.model.enums;

/**
 * 用户状态枚举类
 *
 * @author Ryan
 */
public enum UserStatusEnum {

	DISABLE("0", "禁用"),
	ACTIVE("1", "激活");

	private String code;

	private String message;

	UserStatusEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
