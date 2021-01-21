package com.lyx.demo.domain.model.condition;

/**
 * 可排序的
 *
 * @author Ryan
 */
public interface Sortable {

	/**
	 * 获取排序语句
	 *
	 * @return
	 */
	String getSort();

	/**
	 * 设置排序语句
	 *
	 * @param sort
	 */
	void setSort(String sort);
}
