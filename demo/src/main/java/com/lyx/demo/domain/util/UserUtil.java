package com.lyx.demo.domain.util;

import java.util.regex.Pattern;

/**
 * Demo工具类
 *
 * @author Ryan
 */
public final class UserUtil {
	/**
	 * 用户名格式
	 */
	private static final Pattern USER_NAME_PATTERN = Pattern.compile("1\\d{10}");

	/**
	 * 检查用户名是否是有效格式
	 * 
	 * @param userName
	 * @return
	 */
	public static boolean isValidUserName(String userName) {
		return (userName != null && USER_NAME_PATTERN.matcher(userName).matches());
	}

	private UserUtil() {
	}
}
