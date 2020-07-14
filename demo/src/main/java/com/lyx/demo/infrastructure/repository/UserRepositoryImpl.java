package com.lyx.demo.infrastructure.repository;

import com.lyx.demo.domain.model.condition.UserCondition;
import com.lyx.demo.domain.model.entity.UserEntity;
import com.lyx.demo.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户资源库实现
 *
 * @author Ryan
 */
@Service
public class UserRepositoryImpl implements UserRepository {

	@Override
	public void saveUser(UserEntity user) {
		// TODO
	}

	@Override
	public UserEntity loadUser(String userId) {
		// TODO
		return null;
	}

	@Override
	public UserEntity loadUserForUpdate(String userId) {
		// TODO
		return null;
	}

	@Override
	public UserEntity loadUserByUserName(String userName) {
		// TODO
		return null;
	}

	@Override
	public void disableUser(UserEntity userEntity) {
		// TODO
	}

	@Override
	public void activeUser(UserEntity userEntity) {
		// TODO
	}

	@Override
	public List<UserEntity> findUser(UserCondition condition) {
		// TODO
		return null;
	}
}
