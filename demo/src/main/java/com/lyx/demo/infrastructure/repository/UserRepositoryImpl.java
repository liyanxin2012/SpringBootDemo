package com.lyx.demo.infrastructure.repository;

import com.lyx.demo.domain.model.QueryResult;
import com.lyx.demo.domain.model.condition.QueryUserCondition;
import com.lyx.demo.domain.model.entity.UserEntity;
import com.lyx.demo.domain.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 用户资源库实现
 *
 * @author Ryan
 */
@Service
public class UserRepositoryImpl implements UserRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveUser(UserEntity user) {
		user.setUserId(UUID.randomUUID().toString());
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());

		logger.info("Save user success,user={}", "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserEntity loadUser(String userId) {
		// TODO
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserEntity loadUserByUserName(String userName) {
		// TODO
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void disableUser(UserEntity userEntity) {
		// TODO
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void activeUser(UserEntity userEntity) {
		// TODO
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryResult<UserEntity> queryUserForResult(QueryUserCondition condition) {
		// TODO
		return null;
	}
}
