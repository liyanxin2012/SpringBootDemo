package com.lyx.demo.domain.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ryan
 */
public class UserUtilTest {

	@Test
	public void testIsValidUserName(){
		Assert.assertTrue(UserUtil.isValidUserName("12311111111"));
		Assert.assertFalse(UserUtil.isValidUserName("xxx"));
	}
}
