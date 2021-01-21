package com.lyx.demo.domain.event.external.enums;

/**
 * 用户已变更属性类型
 *
 * @author Ryan
 */
public enum UserChangedTypes {
	BASIC("0", "基础信息"),
	STATUS("1", "变更状态");

	private String code;

	private String message;

	UserChangedTypes(String code, String message) {
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
