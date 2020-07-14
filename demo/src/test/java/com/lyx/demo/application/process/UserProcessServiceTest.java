package com.lyx.demo.application.process;

import com.lyx.demo.domain.exception.AppRtException;
import com.lyx.demo.domain.exception.ErrorCodeEnum;
import com.lyx.demo.domain.model.entity.UserEntity;
import com.lyx.demo.domain.service.UserDomainService;
import com.lyx.demo.domain.util.UserUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

/**
 * <pre>
 * 用户管理服务实现测试类 - 模拟静态方法
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
@PrepareForTest(UserUtil.class)
public class UserProcessServiceTest {

	@Mock
	private UserDomainService userDomainService;

	@InjectMocks
	private UserProcessService userProcessService;

	/**
	 * 测试合法用户名
	 */
	@Test
	public void testAddUserForValidUserName() {
		// TODO
	}

	/**
	 * 测试不合法用户名
	 */
	@Test
	public void testAddUserForInvalidUserName() {
		// TODO
	}
}
