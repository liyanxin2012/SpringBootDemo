package com.lyx.demo.domain.service.impl;

import com.lyx.demo.domain.event.external.UserEventPublisher;
import com.lyx.demo.domain.exception.ErrorCodeEnum;
import com.lyx.demo.domain.model.entity.UserEntity;
import com.lyx.demo.domain.model.enums.UserStatusEnum;
import com.lyx.demo.domain.repository.UserRepository;
import com.lyx.demo.domain.service.UserDomainService;
import com.lyx.demo.domain.util.UserUtil;
import com.lyx.demo.domain.event.external.enums.UserChangedTypes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
	@Resource
	private UserRepository userRepository;

	/**
	 * 用户事件发布器
	 */
	@Resource
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
		userEntity.setStatus(UserStatusEnum.ACTIVATED.getCode());
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
	public void deleteUser(String userId) {
		UserEntity userEntity = userRepository.loadUser(userId);
		if (userEntity == null) {
			ErrorCodeEnum.NOT_EXIST_USER.throwException(new Object[]{userId});
		}

		if (UserStatusEnum.DELETED.getCode().equals(userEntity.getStatus())) {
			ErrorCodeEnum.DELETED_USER.throwException(new Object[]{userId});
		}

		userEntity.setStatus(UserStatusEnum.DELETED.getCode());
		userEntity.setUpdateTime(new Date());

		userRepository.updateUser(userEntity);

		// 发布领域事件
		userEventPublisher.deletedUser(userEntity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void activeUser(String userId) {
		UserEntity userEntity = userRepository.loadUser(userId);
		if (userEntity == null) {
			ErrorCodeEnum.NOT_EXIST_USER.throwException(new Object[]{userId});
		}

		if (UserStatusEnum.DELETED.getCode().equals(userEntity.getStatus())) {
			ErrorCodeEnum.DELETED_USER.throwException(new Object[]{userId});
		}

		userEntity.setStatus(UserStatusEnum.ACTIVATED.getCode());
		userEntity.setUpdateTime(new Date());

		userRepository.updateUser(userEntity);

		// 发布领域事件
		userEventPublisher.activatedUser(userEntity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void disableUser(String userId) {
		UserEntity userEntity = userRepository.loadUser(userId);
		if (userEntity == null) {
			ErrorCodeEnum.NOT_EXIST_USER.throwException(new Object[]{userId});
		}

		if (UserStatusEnum.DELETED.getCode().equals(userEntity.getStatus())) {
			ErrorCodeEnum.DELETED_USER.throwException(new Object[]{userId});
		}

		userEntity.setStatus(UserStatusEnum.DISABLED.getCode());
		userEntity.setUpdateTime(new Date());

		userRepository.updateUser(userEntity);

		// 发布领域事件
		userEventPublisher.disabledUser(userEntity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateStatus(String userId, String userStatus) {
		UserStatusEnum userStatusEnum = UserStatusEnum.valueOf(userStatus);
		if (userStatusEnum == null) {
			ErrorCodeEnum.ILLEGAL_USER_STATUS.throwException(new Object[]{userId, userStatus});
		}

		UserEntity userEntity = userRepository.loadUser(userId);
		if (userEntity == null) {
			ErrorCodeEnum.NOT_EXIST_USER.throwException(new Object[]{userId});
		}

		if (UserStatusEnum.DELETED.getCode().equals(userEntity.getStatus())) {
			ErrorCodeEnum.DELETED_USER.throwException(new Object[]{userId});
		}

		userEntity.setStatus(userStatus);
		userEntity.setUpdateTime(new Date());

		userRepository.updateUser(userEntity);

		// 发布领域事件
		userEventPublisher.changedUser(UserChangedTypes.STATUS, userEntity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateUser(String userId, String userName, String cityCode) {
		UserEntity userEntity = userRepository.loadUser(userId);
		if (userEntity == null) {
			ErrorCodeEnum.NOT_EXIST_USER.throwException(new Object[]{userId});
		}

		if (UserStatusEnum.DELETED.getCode().equals(userEntity.getStatus())) {
			ErrorCodeEnum.DELETED_USER.throwException(new Object[]{userId});
		}

		userEntity.setUserName(userName);
		userEntity.setCityCode(cityCode);
		userEntity.setUpdateTime(new Date());

		userRepository.updateUser(userEntity);

		// 发布领域事件
		userEventPublisher.changedUser(UserChangedTypes.BASIC, userEntity);
	}
}
