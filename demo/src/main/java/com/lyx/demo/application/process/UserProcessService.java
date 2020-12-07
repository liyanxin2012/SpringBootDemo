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

	/**
	 * 用户领域服务
	 */
	@Autowired
	private UserDomainService userDomainService;

	/**
	 * 创建用户
	 *
	 * @param userName
	 * @param cityCode
	 * @return
	 */
	public UserEntity createUser(String userName, String cityCode) {
		return userDomainService.createUser(userName, cityCode);
	}
}
