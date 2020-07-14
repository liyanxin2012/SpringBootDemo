package com.lyx.demo.domain.repository;

import com.lyx.demo.domain.model.condition.UserCondition;
import com.lyx.demo.domain.model.entity.UserEntity;

import java.util.List;

/**
 * 用户资源库
 *
 * @author Ryan
 */
public interface UserRepository {

	/**
	 * 保存用户
	 *
	 * @param user 用户信息
	 * @return
	 */
	void saveUser(UserEntity user);

	/**
	 * 获取用户
	 *
	 * @param userId 用户编号
	 * @return 用户信息
	 */
	UserEntity loadUser(String userId);

	/**
	 * 获取用户
	 *
	 * @param userId
	 * @return
	 */
	UserEntity loadUserForUpdate(String userId);

	/**
	 * 加载用户信息
	 *
	 * @param userName
	 * @return
	 */
	UserEntity loadUserByUserName(String userName);

	/**
	 * 激活用户
	 *
	 * @param user
	 */
	void activeUser(UserEntity user);

	/**
	 * 禁用用户
	 *
	 * @param user
	 */
	void disableUser(UserEntity user);

	/**
	 * 查询用户信息
	 *
	 * @param condition 查询对象
	 * @return
	 */
	List<UserEntity> findUser(UserCondition condition);
}
