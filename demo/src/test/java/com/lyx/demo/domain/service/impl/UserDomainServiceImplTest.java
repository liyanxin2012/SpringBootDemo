package com.lyx.demo.domain.service.impl;

import com.lyx.demo.domain.event.publisher.UserEventPublisher;
import com.lyx.demo.domain.exception.AppRtException;
import com.lyx.demo.domain.exception.ErrorCodeEnum;
import com.lyx.demo.domain.model.entity.UserEntity;
import com.lyx.demo.domain.model.enums.UserStatusEnum;
import com.lyx.demo.domain.repository.UserRepository;
import com.lyx.demo.domain.util.UserUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

/**
 * <pre>
 * 用户领域服务实现测试类 - 模拟静态方法
 *
 * Mockito 2.23.4 + PowerMockito 2.0.2 + Junit4
 *
 * ================ Maven Dependency ================
 * org.powermock 	powermock-api-mockito	2 2.0.2
 * org.mockito 		mockito-core 			2.23.4
 *
 * @author Ryan
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserDomainServiceImpl.class, UserUtil.class})
public class UserDomainServiceImplTest {

	@Mock
	private UserRepository userRepository;

	@Mock
	private UserEventPublisher userEventPublisher;

	@InjectMocks
	private UserDomainServiceImpl userDomainService;

	/**
	 * 测试 - 新增用户失败 - 不存在
	 */
	@Test
	public void testAddUserForFailureNotExistUser() {
		try {
			// invoke
			userDomainService.addUser(null);
		} catch (AppRtException abe) {
			assertEquals(ErrorCodeEnum.NOT_EXIST_USER.getCode(), abe.getCode());
			assertEquals("Not exit user!", abe.getMsg());
		}
	}

	/**
	 * 测试 - 新增用户失败 - 用户名不合法
	 */
	@Test
	public void testAddUserForFailureIllegalUserName() {
		// init
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName("123");
		userEntity.setCityCode("123123");

		// replay
		mockStatic(UserUtil.class);
		when(UserUtil.isValidUserName(userEntity.getUserName())).thenReturn(false);

		try {
			// invoke
			userDomainService.addUser(userEntity);
		} catch (AppRtException abe) {
			assertEquals(ErrorCodeEnum.ILLEGAL_USER_NAME.getCode(), abe.getCode());
			assertEquals("Illegal user name userName=123", abe.getMsg());
		}
	}

	/**
	 * 测试 - 新增用户失败 - 用户名已存在
	 */
	@Test
	public void testAddUserForFailureExistUserName() {
		// init
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName("123");
		userEntity.setCityCode("123123");

		UserEntity existEntity = new UserEntity();
		existEntity.setUserName("123");
		existEntity.setCityCode("123123");

		// replay
		mockStatic(UserUtil.class);
		when(UserUtil.isValidUserName(userEntity.getUserName())).thenReturn(true);
		when(userRepository.loadUserByUserName(userEntity.getUserName())).thenReturn(existEntity);

		try {
			// invoke
			userDomainService.addUser(userEntity);
		} catch (AppRtException abe) {
			assertEquals(ErrorCodeEnum.EXIST_USER_NAME.getCode(), abe.getCode());
			assertEquals("Exist user name userName=123", abe.getMsg());
		}
	}

	/**
	 * 测试 - 新增用户成功
	 */
	@Test
	public void testAddUserForSuccess() {
		// init
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName("123");
		userEntity.setCityCode("123123");

		ArgumentCaptor<UserEntity> userEntityCaptor = ArgumentCaptor.forClass(UserEntity.class);

		// replay
		mockStatic(UserUtil.class);
		when(UserUtil.isValidUserName(userEntity.getUserName())).thenReturn(true);
		when(userRepository.loadUserByUserName(userEntity.getUserName())).thenReturn(null);

		// invoke
		String actUserId = userDomainService.addUser(userEntity);

		// verify
		verify(userRepository, Mockito.times(1)).loadUserByUserName(eq(userEntity.getUserName()));
		verify(userRepository, Mockito.times(1)).saveUser(userEntityCaptor.capture());
		verify(userEventPublisher, Mockito.times(1)).registeredUser(userEntityCaptor.capture());

		List<UserEntity> userEntityList = userEntityCaptor.getAllValues();
		assertEquals(2, userEntityList.size());

		UserEntity dbUserEntity = userEntityList.get(0);
		assertEquals(actUserId, dbUserEntity.getUserId());
		assertEquals(UserStatusEnum.ACTIVE.getCode(), dbUserEntity.getStatus());
		assertTrue((System.currentTimeMillis() - dbUserEntity.getCreateTime().getTime()) < 100l);
		assertTrue((System.currentTimeMillis() - dbUserEntity.getUpdateTime().getTime()) < 100l);
		assertEquals(userEntity.getUserName(), dbUserEntity.getUserName());
		assertEquals(userEntity.getCityCode(), dbUserEntity.getCityCode());

		UserEntity eventUserEntity = userEntityList.get(1);
		assertSame(eventUserEntity, dbUserEntity);
	}

	/**
	 * 测试 - 激活用户失败 - 用户名已存在
	 */
	@Test
	public void testActiveUserForFailureNotFoundUser() {
		// init
		String userId = "123";

		// replay
		when(userRepository.loadUser(eq(userId))).thenReturn(null);

		try {
			// invoke
			userDomainService.activeUser(userId);
		} catch (AppRtException abe) {
			assertEquals(ErrorCodeEnum.NOT_FOUND_USER.getCode(), abe.getCode());
			assertEquals("Not found user userId=123", abe.getMsg());
		}
	}

	/**
	 * 测试 - 激活用户成功
	 */
	@Test
	public void testActiveUserForSuccess() {
		// init
		String userId = "123";

		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(userId);
		userEntity.setUserName("123");
		userEntity.setCityCode("123123");
		userEntity.setStatus(UserStatusEnum.DISABLE.getCode());
		userEntity.setCreateTime(new Date());

		ArgumentCaptor<UserEntity> userEntityCaptor = ArgumentCaptor.forClass(UserEntity.class);

		// replay
		when(userRepository.loadUser(eq(userId))).thenReturn(userEntity);

		// invoke
		userDomainService.activeUser(userId);

		// verify
		verify(userRepository, Mockito.times(1)).loadUser(eq(userId));
		verify(userRepository, Mockito.times(1)).activeUser(userEntityCaptor.capture());
		verify(userEventPublisher, Mockito.times(1)).activeUser(userEntityCaptor.capture());

		List<UserEntity> userEntityList = userEntityCaptor.getAllValues();
		assertEquals(2, userEntityList.size());

		UserEntity dbUserEntity = userEntityList.get(0);
		assertEquals(userId, dbUserEntity.getUserId());
		assertEquals(UserStatusEnum.ACTIVE.getCode(), dbUserEntity.getStatus());
		assertTrue(userEntity.getCreateTime().equals(dbUserEntity.getCreateTime()));
		assertTrue((System.currentTimeMillis() - dbUserEntity.getUpdateTime().getTime()) < 100l);
		assertEquals(userEntity.getUserName(), dbUserEntity.getUserName());
		assertEquals(userEntity.getCityCode(), dbUserEntity.getCityCode());

		UserEntity eventUserEntity = userEntityList.get(1);
		assertSame(eventUserEntity, dbUserEntity);
	}

	/**
	 * 测试 - 禁用用户失败 - 用户名已存在
	 */
	@Test
	public void testDisableUserForFailureNotFoundUser() {
		// init
		String userId = "123";

		// replay
		when(userRepository.loadUser(eq(userId))).thenReturn(null);

		try {
			// invoke
			userDomainService.disableUser(userId);
		} catch (AppRtException abe) {
			assertEquals(ErrorCodeEnum.NOT_FOUND_USER.getCode(), abe.getCode());
			assertEquals("Not found user userId=123", abe.getMsg());
		}
	}

	/**
	 * 测试 - 禁用用户成功
	 */
	@Test
	public void testDisableUserForSuccess() {
		// init
		String userId = "123";

		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(userId);
		userEntity.setUserName("123");
		userEntity.setCityCode("123123");
		userEntity.setStatus(UserStatusEnum.ACTIVE.getCode());
		userEntity.setCreateTime(new Date());

		ArgumentCaptor<UserEntity> userEntityCaptor = ArgumentCaptor.forClass(UserEntity.class);

		// replay
		when(userRepository.loadUser(eq(userId))).thenReturn(userEntity);

		// invoke
		userDomainService.disableUser(userId);

		// verify
		verify(userRepository, Mockito.times(1)).loadUser(eq(userId));
		verify(userRepository, Mockito.times(1)).disableUser(userEntityCaptor.capture());
		verify(userEventPublisher, Mockito.times(1)).disableUser(userEntityCaptor.capture());

		List<UserEntity> userEntityList = userEntityCaptor.getAllValues();
		assertEquals(2, userEntityList.size());

		UserEntity dbUserEntity = userEntityList.get(0);
		assertEquals(userId, dbUserEntity.getUserId());
		assertEquals(UserStatusEnum.DISABLE.getCode(), dbUserEntity.getStatus());
		assertTrue(userEntity.getCreateTime().equals(dbUserEntity.getCreateTime()));
		assertTrue((System.currentTimeMillis() - dbUserEntity.getUpdateTime().getTime()) < 100l);
		assertEquals(userEntity.getUserName(), dbUserEntity.getUserName());
		assertEquals(userEntity.getCityCode(), dbUserEntity.getCityCode());

		UserEntity eventUserEntity = userEntityList.get(1);
		assertSame(eventUserEntity, dbUserEntity);
	}
}
