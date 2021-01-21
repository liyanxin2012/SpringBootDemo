package com.lyx.demo.infrastructure.repository;

import com.alibaba.fastjson.JSON;
import com.lyx.demo.domain.model.PageResult;
import com.lyx.demo.domain.model.QueryResult;
import com.lyx.demo.domain.model.condition.QueryUserCondition;
import com.lyx.demo.domain.model.entity.UserEntity;
import com.lyx.demo.domain.model.enums.UserStatusEnum;
import com.lyx.demo.domain.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

		logger.info("Save user success,user={}", JSON.toJSONString(user));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserEntity loadUser(String userId) {
		UserEntity userEntity = buildMockUserEntity(userId, "Test0101");

		logger.info("Load user success,user={}", JSON.toJSONString(userEntity));

		return userEntity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserEntity loadUserByUserName(String userName) {
		UserEntity userEntity = buildMockUserEntity(UUID.randomUUID().toString(), userName);

		logger.info("Load user by username success,user={}", JSON.toJSONString(userEntity));

		return userEntity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateUser(UserEntity userEntity) {
		logger.info("Update user success,user={}", JSON.toJSONString(userEntity));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryResult<UserEntity> queryUserForResult(QueryUserCondition condition, int firstResult, int maxResults) {
		List<UserEntity> userEntityList = new ArrayList<>();
		userEntityList.add(buildMockUserEntity(UUID.randomUUID().toString(), "Test0101"));
		userEntityList.add(buildMockUserEntity(UUID.randomUUID().toString(), "Test0102"));

		QueryResult<UserEntity> queryResult = new QueryResult<>();
		queryResult.setFirst(firstResult);
		queryResult.setCount(userEntityList.size());
		queryResult.setElements(userEntityList);

		return queryResult;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PageResult<UserEntity> queryUserForResult2(QueryUserCondition condition, int pageNo, int pageSize) {
		List<UserEntity> userEntityList = new ArrayList<>();
		userEntityList.add(buildMockUserEntity(UUID.randomUUID().toString(), "Test0101"));
		userEntityList.add(buildMockUserEntity(UUID.randomUUID().toString(), "Test0102"));

		PageResult<UserEntity> pageResult = new PageResult<>();
		pageResult.setElements(userEntityList);
		pageResult.setTotalPages(userEntityList.size() / pageSize + 1);
		pageResult.setTotalItems(userEntityList.size());

		return pageResult;
	}

	private UserEntity buildMockUserEntity(String userId, String userName) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(userId);
		userEntity.setCityCode("010101");
		userEntity.setUserName(userName);
		userEntity.setStatus(UserStatusEnum.ACTIVATED.getCode());
		userEntity.setCreateTime(new Date());
		userEntity.setUpdateTime(new Date());

		return userEntity;
	}
}
