package com.lyx.demo.infrastructure.facade;

import com.alibaba.fastjson.JSON;
import com.lyx.demo.domain.facade.CityFacade;
import com.lyx.demo.domain.model.valueobject.CityVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * City Facade
 *
 * @author Ryan
 */
@Service
public class CityFacadeImpl implements CityFacade {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CityVO loadCityVO(String cityCode) {
		CityVO cityVO = buildMockCityVO(cityCode);

		logger.info("Load city success,user={}", JSON.toJSONString(cityVO));

		return cityVO;
	}

	/**
	 * Mock构建城市信息
	 *
	 * @param cityCode
	 * @return
	 */
	private CityVO buildMockCityVO(String cityCode) {
		CityVO cityVO = new CityVO();
		cityVO.setCityCode(cityCode);
		cityVO.setCityName("上海市");

		return cityVO;
	}
}
