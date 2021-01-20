package com.lyx.demo.domain.service;

import com.lyx.demo.domain.model.entity.UserEntity;

/**
 * 用户领域服务
 *
 * @author Ryan
 */
public interface UserDomainService {

	/**
	 * 创建用户
	 *
	 * @param userName
	 * @param cityCode
	 * @return
	 */
	UserEntity createUser(String userName, String cityCode);

	/**
	 * 禁用用户
	 *
	 * @param userId
	 */
	void deleteUser(String userId);

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

	/**
	 * 更新用户信息
	 */
	void updateUser(String userId, String userName, String cityCode);
}
