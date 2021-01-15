package com.lyx.demo.specification.oop;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ryan
 */
public class OOPTest {

	/**
	 * 测试Integer - 所有的相同类型的包装类对象之间值的比较，全部使用 equals 方法比较
	 */
	@Test
	public void testInteger() {
		Integer a = 127;
		Integer b = 127;
		Assert.assertTrue(a == b);
		Assert.assertTrue(a.equals(b));

		Integer a1 = -128;
		Integer b1 = -128;
		Assert.assertTrue(a1 == b1);
		Assert.assertTrue(a1.equals(b1));

		Integer a2 = -129;
		Integer b2 = -129;
		Assert.assertFalse(a2 == b2);
		Assert.assertTrue(a2.equals(b2));

		Integer a3 = 128;
		Integer b3 = 128;
		Assert.assertFalse(a3 == b3);
		Assert.assertTrue(a3.equals(b3));

		Integer a4 = new Integer(100);
		Integer b4 = new Integer(100);
		Assert.assertFalse(a4 == b4);
		Assert.assertTrue(a4.equals(b4));

		Integer a5 = new Integer(100);
		Assert.assertTrue(a5.equals(100));
	}
}
