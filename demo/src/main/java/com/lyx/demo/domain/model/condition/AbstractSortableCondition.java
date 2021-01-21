package com.lyx.demo.domain.model.condition;

/**
 * 抽象可排序查询条件对象
 *
 * @author Ryan
 */
public abstract class AbstractSortableCondition implements Sortable {

	/**
	 * 排序语句
	 */
	private String sort;

	@Override
	public String getSort() {
		return sort;
	}

	@Override
	public void setSort(String sort) {
		this.sort = sort;
	}
}
