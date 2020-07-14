package com.lyx.demo.application.process;

import com.lyx.demo.domain.model.entity.UserEntity;
import com.lyx.demo.domain.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ryan
 */
@Service
public class UserProcessService {

	@Autowired
	private UserDomainService userDomainService;

	/**
	 * 添加用户
	 *
	 * @param user
	 * @return 用户编号
	 */
	public String addUser(UserEntity user) {
		return userDomainService.addUser(user);
	}
}
