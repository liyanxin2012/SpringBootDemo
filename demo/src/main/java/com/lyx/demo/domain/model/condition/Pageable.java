package com.lyx.demo.domain.model.condition;

/**
 * 可分页的
 *
 * @author Ryan
 */
public interface Pageable {

	/**
	 * 获取页号
	 *
	 * @return
	 */
	default int getPageNo() {
		return 0;
	}

	/**
	 * 设置页号
	 *
	 * @param pageNo
	 */
	void setPageNo(int pageNo);

	/**
	 * 获取每页记录数
	 *
	 * @return
	 */
	default int getPageSize() {
		return 10;
	}

	/**
	 * 设置每页记录数
	 *
	 * @param pageSize
	 */
	void setPageSize(int pageSize);
}
