package com.lyx.demo.domain.model.condition;

/**
 * 用户查询对象
 *
 * @author Ryan
 */
public class UserCondition {

	private String userId;

	private String cityCode;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
}
