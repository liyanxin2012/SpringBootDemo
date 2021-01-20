package com.lyx.demo.access.controller;

import com.lyx.demo.access.GenericResponse;
import com.lyx.demo.access.controller.bean.request.CreateUserRequest;
import com.lyx.demo.access.controller.bean.request.UpdateUserRequest;
import com.lyx.demo.application.show.UserShowService;
import com.lyx.demo.domain.model.QueryResult;
import com.lyx.demo.domain.model.condition.QueryUserCondition;
import com.lyx.demo.domain.model.entity.UserEntity;
import com.lyx.demo.domain.service.UserDomainService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ryan
 */
@RestController
@RequestMapping("/users")
@Api(tags = "用户管理")
public class UserController {

	/**
	 * 用户展示服务
	 */
	@Autowired
	private UserShowService userShowService;

	/**
	 * 用户领域服务
	 */
	@Autowired
	private UserDomainService userDomainService;


	/**
	 * 创建用户
	 *
	 * @param request
	 * @return
	 */
	@PostMapping
	public GenericResponse<UserEntity> createUser(@RequestBody CreateUserRequest request) {
		return GenericResponse.responseOf(userDomainService.createUser(request.getUserName(), request.getUserName()));
	}

	/**
	 * 删除用户
	 *
	 * @param userId
	 * @return
	 */
	@DeleteMapping(value = "/{userId}")
	public GenericResponse<Void> deleteUser(@PathVariable String userId) {

		userDomainService.deleteUser(userId);

		return GenericResponse.success();
	}

	/**
	 * 禁用用户
	 *
	 * @param userId
	 * @return
	 */
	@PutMapping(value = "/{userId}")
	public GenericResponse<Void> disableUser(@PathVariable String userId) {

		userDomainService.disableUser(userId);

		return GenericResponse.success();
	}

	/**
	 * 激活用户
	 *
	 * @param userId
	 * @return
	 */
	@PutMapping(value = "/{userId}")
	public GenericResponse<Void> activateUser(@PathVariable String userId) {

		userDomainService.activeUser(userId);

		return GenericResponse.success();
	}

	/**
	 * 更新用户
	 *
	 * @param userId
	 * @param request
	 * @return
	 */
	@PutMapping(value = "/{userId}")
	public GenericResponse<Void> updateUser(@PathVariable String userId, @RequestBody UpdateUserRequest request) {
		userDomainService

		return null;
	}

	/**
	 * 获取用户集合
	 *
	 * @return
	 */
	@GetMapping
	public GenericResponse<QueryResult<UserEntity>> queryUserForResult(@RequestBody QueryUserCondition cond, @RequestParam("firstResult") int firstResult, @RequestParam("maxResults") int maxResults) {
		return GenericResponse.responseOf(userShowService.queryUserForResult(cond, firstResult, maxResults));
	}

	/**
	 * 获取用户
	 *
	 * @param userId
	 * @return
	 */
	@GetMapping(value = "/{userId}")
	public GenericResponse<UserEntity> getUser(@PathVariable String userId) {
		return GenericResponse.responseOf(userShowService.loadUser(userId));
	}
}
