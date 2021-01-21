package com.lyx.demo.access.controller;

import com.lyx.demo.access.GenericResponse;
import com.lyx.demo.access.controller.model.request.CreateUserRequest;
import com.lyx.demo.access.controller.model.request.UpdateUserRequest;
import com.lyx.demo.application.show.UserShowService;
import com.lyx.demo.application.model.UserInfo;
import com.lyx.demo.domain.model.QueryResult;
import com.lyx.demo.domain.model.condition.QueryUserCondition;
import com.lyx.demo.domain.model.entity.UserEntity;
import com.lyx.demo.domain.service.UserDomainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户信息管理
 *
 * @author Ryan
 */
@RestController
@RequestMapping("/users")
@Api(tags = "用户管理")
public class UserController {

	/**
	 * 用户展示服务
	 */
	@Resource
	private UserShowService userShowService;

	/**
	 * 用户领域服务
	 */
	@Resource
	private UserDomainService userDomainService;

	/**
	 * 创建用户
	 *
	 * @param request
	 * @return
	 */
	@PostMapping
	@ApiOperation(value = "创建用户", notes = "创建用户")
	public GenericResponse<UserEntity> createUser(@RequestBody CreateUserRequest request) {
		return GenericResponse.responseOf(userDomainService.createUser(request.getUserName(), request.getUserName()));
	}

	/**
	 * 更新用户状态
	 *
	 * @param userId
	 * @return
	 */
	@PatchMapping(value = "/{userId}")
	@ApiOperation(value = "更新用户状态", notes = "更新用户状态")
	public GenericResponse<Void> updateStatus(@PathVariable String userId, @RequestParam("userStatus") String userStatus) {

		userDomainService.updateStatus(userId, userStatus);

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
	@ApiOperation(value = "更新用户基础信息", notes = "更新用户基础信息")
	public GenericResponse<Void> updateUser(@PathVariable String userId, @RequestBody UpdateUserRequest request) {

		userDomainService.updateUser(userId, request.getUserName(), request.getCityCode());

		return null;
	}

	/**
	 * 获取用户
	 *
	 * @param userId
	 * @return
	 */
	@GetMapping(value = "/{userId}")
	@ApiOperation(value = "查询用户信息", notes = "查询用户信息")
	public GenericResponse<UserInfo> getUser(@PathVariable String userId) {
		return GenericResponse.responseOf(userShowService.loadUser(userId));
	}

	/**
	 * 获取用户集合
	 *
	 * @return
	 */
	@GetMapping
	@ApiOperation(value = "批量查询用户信息", notes = "批量查询用户信息")
	public GenericResponse<QueryResult<UserInfo>> queryUserForResult(@RequestBody QueryUserCondition cond, @RequestParam("firstResult") int firstResult, @RequestParam("maxResults") int maxResults) {
		return GenericResponse.responseOf(userShowService.queryUserForResult(cond, firstResult, maxResults));
	}

	//	/**
//	 * 删除用户
//	 *
//	 * @param userId
//	 * @return
//	 */
//	@DeleteMapping(value = "/{userId}")
//	public GenericResponse<Void> deleteUser(@PathVariable String userId) {
//
//		userDomainService.deleteUser(userId);
//
//		return GenericResponse.success();
//	}
//
//	/**
//	 * 禁用用户
//	 *
//	 * @param userId
//	 * @return
//	 */
//	@PutMapping(value = "/{userId}")
//	public GenericResponse<Void> disableUser(@PathVariable String userId) {
//
//		userDomainService.disableUser(userId);
//
//		return GenericResponse.success();
//	}
//

//	/**
//	 * 获取用户集合
//	 *
//	 * @return
//	 */
//	@GetMapping
//	public GenericResponse<PageResult<UserEntity>> queryUserForResult(@RequestBody QueryUserCondition cond, @RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize) {
//		return GenericResponse.responseOf(userShowService.queryUserForResult(cond, firstResult, maxResults));
//	}
}
