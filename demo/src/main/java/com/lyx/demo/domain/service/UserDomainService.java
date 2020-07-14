package com.lyx.demo.domain.service;

import com.lyx.demo.domain.model.entity.UserEntity;

/**
 * 用户领域服务
 *
 * @author Ryan
 */
public interface UserDomainService {

	/**
	 * 添加用户
	 *
	 * @param user
	 */
	String addUser(UserEntity user);

	/**
	 * 激活用户
	 *
	 * @param userId 用户编号
	 */
	void activeUser(String userId);

	/**
	 * 禁用用户
	 *
	 * @param userId
	 */
	void disableUser(String userId);
}
