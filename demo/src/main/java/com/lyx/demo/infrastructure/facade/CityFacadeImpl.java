package com.lyx.demo.infrastructure.facade;

import com.lyx.demo.domain.facade.CityFacade;
import com.lyx.demo.domain.model.valueobject.CityVO;
import org.springframework.stereotype.Service;

/**
 * @author Ryan
 */
@Service
public class CityFacadeImpl implements CityFacade {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CityVO loadCityVO(String cityCode) {
		return null;
	}
}
