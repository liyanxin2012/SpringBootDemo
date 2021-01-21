package com.lyx.demo.domain.model.condition;

/**
 * 抽象可分页查询条件对象
 *
 * @author Ryan
 */
public abstract class AbstractPageableCondition implements Pageable {

	/**
	 * 当前页码，从1开始
	 */
	private int pageNo = 1;

	/**
	 * 每页记录，默认为10
	 */
	private int pageSize = 10;

	@Override
	public int getPageNo() {
		return pageNo;
	}

	@Override
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	@Override
	public int getPageSize() {
		return pageSize;
	}

	@Override
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
