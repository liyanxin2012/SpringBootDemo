package com.lyx.demo.application.model;

import com.lyx.demo.domain.model.entity.UserEntity;

/**
 * 全量用户信息
 *
 * @author Ryan
 */
public class UserInfo extends UserEntity {

	/**
	 * 城市名称
	 */
	private String cityName;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
