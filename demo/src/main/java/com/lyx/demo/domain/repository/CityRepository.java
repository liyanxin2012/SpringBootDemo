package com.lyx.demo.domain.repository;

import com.lyx.demo.domain.model.condition.CityCondition;
import com.lyx.demo.domain.model.valueobject.CityVO;

import java.util.List;

/**
 * @author Ryan
 */
public interface CityRepository {

	/**
	 * 新增城市
	 *
	 * @param cityVO
	 */
	void addCity(CityVO cityVO);

	/**
	 * 加载城市
	 *
	 * @param cityCode
	 * @return
	 */
	CityVO loadCityVO(String cityCode);

	/**
	 * 查询城市
	 *
	 * @param condition
	 * @return
	 */
	List<CityVO> findCityVO(CityCondition condition);
}
