package com.lyx.demo.domain.repository;

import com.lyx.demo.domain.model.PageResult;
import com.lyx.demo.domain.model.QueryResult;
import com.lyx.demo.domain.model.condition.QueryUserCondition;
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
	 * 加载用户信息
	 *
	 * @param userName
	 * @return
	 */
	UserEntity loadUserByUserName(String userName);

	/**
	 * 更新用户
	 *
	 * @param userEntity
	 */
	void updateUser(UserEntity userEntity);

	/**
	 * 查询用户信息（模式1）
	 *
	 * @param condition
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	QueryResult<UserEntity> queryUserForResult(QueryUserCondition condition, int firstResult, int maxResults);

	/**
	 * 查询用户信息（模式2）
	 *
	 * @param condition
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	PageResult<UserEntity> queryUserForResult2(QueryUserCondition condition, int pageNo, int pageSize);
}
