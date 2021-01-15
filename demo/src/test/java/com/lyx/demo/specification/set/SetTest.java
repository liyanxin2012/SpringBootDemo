package com.lyx.demo.specification.set;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 */
public class SetTest {

	/**
	 * ArrayList的subList结果不可强转成ArrayList，否则会抛出ClassCastException 异常
	 */
	@Test
	public void testArrayList() {
		List<String> originList = new ArrayList<>();
		originList.add("1");
		originList.add("2");

		ArrayList<String> subList = (ArrayList<String>) originList.subList(0, 1);
	}

	/**
	 *
	 */
	@Test
	public void testArrayList2() {
		List<String> originList = new ArrayList<>();
		originList.add("1");
		originList.add("2");

		List<String> subList = originList.subList(0, 1);

		subList.add("3");

		Assert.assertEquals(3, originList.size());
		Assert.assertEquals("class java.util.ArrayList$SubList", subList.getClass());
	}
}
