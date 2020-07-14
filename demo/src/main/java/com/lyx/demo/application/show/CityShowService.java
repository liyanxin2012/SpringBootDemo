package com.lyx.demo.application.show;

import com.lyx.demo.domain.model.condition.CityCondition;
import com.lyx.demo.domain.model.valueobject.CityVO;
import com.lyx.demo.domain.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ryan
 */
@Service
public class CityShowService {

	/**
	 * 用户资源库
	 */
	@Autowired
	private CityRepository cityRepository;

	/**
	 * 根据用户编号获取用户
	 *
	 * @param cityCode
	 * @return
	 */
	public CityVO loadCityVO(String cityCode) {
		return cityRepository.loadCityVO(cityCode);
	}

	/**
	 * 查询用户信息
	 *
	 * @param condition 查询对象
	 * @return
	 */
	public List<CityVO> findCityVO(CityCondition condition) {
		return cityRepository.findCityVO(condition);
	}

}
