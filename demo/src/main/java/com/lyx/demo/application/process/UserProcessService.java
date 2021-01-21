package com.lyx.demo.application.process;

import com.lyx.demo.application.model.UserInfo;
import com.lyx.demo.domain.facade.CityFacade;
import com.lyx.demo.domain.model.entity.UserEntity;
import com.lyx.demo.domain.model.valueobject.CityVO;
import com.lyx.demo.domain.service.UserDomainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户处理服务
 *
 * @author Ryan
 */
@Service
public class UserProcessService {

	/**
	 * City Facade
	 */
	@Resource
	private CityFacade cityFacade;

	/**
	 * 用户领域服务
	 */
	@Resource
	private UserDomainService userDomainService;

	/**
	 * 创建用户
	 *
	 * @param userName
	 * @param cityCode
	 * @return
	 */
	public UserInfo createUser(String userName, String cityCode) {
		return convertUserEntity2UserInfo(userDomainService.createUser(userName, cityCode));
	}

	/**
	 * 转换用户信息
	 *
	 * @param userEntity
	 * @return
	 */
	private UserInfo convertUserEntity2UserInfo(UserEntity userEntity) {
		if (userEntity == null) {
			return null;
		}

		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(userEntity.getUserId());
		userInfo.setUserName(userEntity.getUserName());
		userInfo.setCityCode(userEntity.getCityCode());
		userInfo.setStatus(userEntity.getStatus());
		userInfo.setCreateTime(userEntity.getCreateTime());
		userInfo.setUpdateTime(userEntity.getUpdateTime());

		if (userInfo.getCityCode() != null) {
			CityVO cityVO = cityFacade.loadCityVO(userInfo.getCityCode());
			if (cityVO != null) {
				userInfo.setCityName(cityVO.getCityName());
			}
		}

		return userInfo;
	}
}
