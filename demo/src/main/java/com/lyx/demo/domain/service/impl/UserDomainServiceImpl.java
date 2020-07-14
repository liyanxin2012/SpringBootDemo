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
	public String addUser(UserEntity user) {
		if (user == null) {
			ErrorCodeEnum.NOT_EXIST_USER.throwException();
		}

		if (UserUtil.isValidUserName(user.getUserName()) == false) {
			ErrorCodeEnum.ILLEGAL_USER_NAME.throwException(new Object[]{user.getUserName()});
		}

		UserEntity existUser = userRepository.loadUserByUserName(user.getUserName());
		if (existUser != null) {
			ErrorCodeEnum.EXIST_USER_NAME.throwException(new Object[]{user.getUserName()});
		}

		user.setUserId(UUID.randomUUID().toString().replaceAll("-", ""));
		user.setStatus(UserStatusEnum.ACTIVE.getCode());
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());

		userRepository.saveUser(user);

		// 发布领域事件
		userEventPublisher.registeredUser(user);

		return user.getUserId();
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
