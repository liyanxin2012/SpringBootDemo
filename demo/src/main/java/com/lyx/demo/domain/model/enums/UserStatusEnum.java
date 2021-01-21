package com.lyx.demo.domain.model.enums;

/**
 * 用户状态枚举类
 *
 * @author Ryan
 */
public enum UserStatusEnum {

	DISABLED("0", "已禁用"),
	ACTIVATED("1", "已激活"),
	DELETED("2", "已删除");

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
