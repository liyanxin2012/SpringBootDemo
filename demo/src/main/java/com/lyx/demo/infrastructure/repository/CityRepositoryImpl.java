package com.lyx.demo.infrastructure.repository;

import com.lyx.demo.domain.model.condition.CityCondition;
import com.lyx.demo.domain.model.valueobject.CityVO;
import com.lyx.demo.domain.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ryan
 */
@Service
public class CityRepositoryImpl implements CityRepository {

	@Override
	public void addCity(CityVO cityVO) {

	}

	@Override
	public CityVO loadCityVO(String cityCode) {
		return null;
	}

	@Override
	public List<CityVO> findCityVO(CityCondition condition) {
		return null;
	}
}
