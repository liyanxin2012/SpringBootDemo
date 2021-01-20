package com.lyx.demo.application.show;

import com.lyx.demo.domain.model.QueryResult;
import com.lyx.demo.domain.model.condition.QueryUserCondition;
import com.lyx.demo.domain.model.entity.UserEntity;
import com.lyx.demo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ryan
 */
@Service
public class UserShowService {

	/**
	 * 用户资源库
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * 根据用户编号获取用户
	 *
	 * @param userId
	 * @return
	 */
	public UserEntity loadUser(String userId) {
		return userRepository.loadUser(userId);
	}

	/**
	 * 查询用户信息
	 *
	 * @param condition
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public QueryResult<UserEntity> queryUserForResult(QueryUserCondition condition, int firstResult, int maxResults) {
		return userRepository.queryUserForResult(condition);
	}

}
