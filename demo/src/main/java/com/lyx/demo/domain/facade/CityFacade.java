package com.lyx.demo.domain.facade;

import com.lyx.demo.domain.model.valueobject.CityVO;

/**
 * @author Ryan
 */
public interface CityFacade {

	/**
	 * 获取CityVO
	 *
	 * @param cityCode
	 * @return
	 */
	CityVO loadCityVO(String cityCode);
}
