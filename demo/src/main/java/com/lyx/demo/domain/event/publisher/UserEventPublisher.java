package com.lyx.demo.domain.event.publisher;

import com.lyx.demo.domain.model.entity.UserEntity;

/**
 * 用户事件发布器
 *
 * @author Ryan
 */
public interface UserEventPublisher {

	/**
	 * 激活用户
	 *
	 * @param userEntity
	 */
	void activeUser(UserEntity userEntity);

	/**
	 * 禁用用户
	 *
	 * @param userEntity
	 */
	void disableUser(UserEntity userEntity);

	/**
	 * 注册用户信息
	 *
	 * @param userEntity
	 */
	void registeredUser(UserEntity userEntity);
}
