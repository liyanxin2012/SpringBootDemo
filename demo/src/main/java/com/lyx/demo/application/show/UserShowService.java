package com.lyx.demo.application.show;

import com.lyx.demo.domain.model.condition.UserCondition;
import com.lyx.demo.domain.model.entity.UserEntity;
import com.lyx.demo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
	 * @param condition 查询对象
	 * @return
	 */
	public List<UserEntity> findUser(UserCondition condition) {
		return userRepository.findUser(condition);
	}

}
