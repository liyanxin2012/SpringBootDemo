package com.lyx.demo.domain.service.impl;

import com.lyx.demo.domain.exception.ErrorCodeEnum;
import com.lyx.demo.domain.model.enums.UserStatusEnum;
import com.lyx.demo.domain.event.publisher.UserEventPublisher;
import com.lyx.demo.domain.model.entity.UserEntity;
import com.lyx.demo.domain.repository.UserRepository;
import com.lyx.demo.domain.service.UserDomainService;

import com.lyx.demo.domain.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * 用户领域服务实现类
 *
 * @author Ryan
 */
@Service
public class UserDomainServiceImpl implements UserDomainService {

	/**
	 * 用户资源库
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * 用户事件发布器
	 */
	@Autowired
	private UserEventPublisher userEventPublisher;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserEntity createUser(String userName, String cityCode) {
		if (UserUtil.isValidUserName(userName) == false) {
			ErrorCodeEnum.ILLEGAL_USER_NAME.throwException(new Object[]{userName});
		}

		UserEntity existUser = userRepository.loadUserByUserName(userName);
		if (existUser != null) {
			ErrorCodeEnum.EXIST_USER_NAME.throwException(new Object[]{userName});
		}

		UserEntity userEntity = new UserEntity();

		userEntity.setUserName(userName);
		userEntity.setCityCode(cityCode);
		userEntity.setUserId(UUID.randomUUID().toString().replaceAll("-", ""));
		userEntity.setStatus(UserStatusEnum.ACTIVE.getCode());
		userEntity.setCreateTime(new Date());
		userEntity.setUpdateTime(new Date());

		userRepository.saveUser(userEntity);

		// 发布领域事件
		userEventPublisher.registeredUser(userEntity);

		return userEntity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void activeUser(String userId) {
		UserEntity userEntity = userRepository.loadUser(userId);
		if (userEntity == null) {
			ErrorCodeEnum.NOT_FOUND_USER.throwException(new Object[]{userId});
		}

		userEntity.setStatus(UserStatusEnum.ACTIVE.getCode());
		userEntity.setUpdateTime(new Date());

		userRepository.activeUser(userEntity);

		// 发布领域事件
		userEventPublisher.activeUser(userEntity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void disableUser(String userId) {
		UserEntity userEntity = userRepository.loadUser(userId);
		if (userEntity == null) {
			ErrorCodeEnum.NOT_FOUND_USER.throwException(new Object[]{userId});
		}

		userEntity.setStatus(UserStatusEnum.DISABLE.getCode());
		userEntity.setUpdateTime(new Date());

		userRepository.disableUser(userEntity);

		// 发布领域事件
		userEventPublisher.disableUser(userEntity);
	}
}
