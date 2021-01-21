package com.lyx.demo.domain.model.valueobject;

import java.io.Serializable;

/**
 * 城市VO对象
 *
 * @author Ryan
 */
public class CityVO implements Serializable {

	private String cityCode;

	private String cityName;

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "CityVO{" +
				"cityCode='" + cityCode + '\'' +
				", cityName='" + cityName + '\'' +
				'}';
	}
}
