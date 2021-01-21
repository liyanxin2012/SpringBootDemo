package com.lyx.demo.domain.service;

import com.lyx.demo.domain.model.entity.UserEntity;

/**
 * 用户领域服务
 *
 * @author Ryan
 */
public interface UserDomainService {

	/**
	 * 禁用用户
	 *
	 * @param userId
	 */
	@Deprecated
	void deleteUser(String userId);

	/**
	 * 激活用户
	 *
	 * @param userId 用户编号
	 */
	@Deprecated
	void activeUser(String userId);

	/**
	 * 禁用用户
	 *
	 * @param userId
	 */
	@Deprecated
	void disableUser(String userId);

	/**
	 * 创建用户
	 *
	 * @param userName
	 * @param cityCode
	 * @return
	 */
	UserEntity createUser(String userName, String cityCode);

	/**
	 * 更新用户状态
	 *
	 * @param userId
	 * @param userStatus
	 */
	void updateStatus(String userId, String userStatus);

	/**
	 * 更新用户信息
	 *
	 * @param userId
	 * @param userName
	 * @param cityCode
	 */
	void updateUser(String userId, String userName, String cityCode);
}
