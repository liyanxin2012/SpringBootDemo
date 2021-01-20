package com.lyx.demo.access.controller.bean.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Ryan
 */
public class CreateUserRequest implements Serializable {

	/**
	 * 用户名（必须全局唯一）
	 */
	@NotNull
	@Size(max = 32)
	private String userName;

	/**
	 * 城市编号
	 */
	@Size(max = 6)
	private String cityCode;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
}
