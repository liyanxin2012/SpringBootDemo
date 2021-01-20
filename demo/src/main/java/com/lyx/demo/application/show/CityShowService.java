package com.lyx.demo.application.show;

import com.lyx.demo.domain.facade.CityFacade;
import com.lyx.demo.domain.model.valueobject.CityVO;
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
	private CityFacade cityFacade;

	/**
	 * 根据用户编号获取用户
	 *
	 * @param cityCode
	 * @return
	 */
	public CityVO loadCityVO(String cityCode) {
		return cityFacade.loadCityVO(cityCode);
	}
}
