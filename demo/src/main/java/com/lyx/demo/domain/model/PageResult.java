package com.lyx.demo.domain.model;

import java.util.List;

/**
 * 查询结果类
 *
 * @author Ryan
 *
 * @param <T>
 */
public class PageResult<T> {
	/**
	 * 查询结果记录数量
	 */
	private long totalItems;

	/**
	 * 起始记录数
	 */
	private long totalPages;

	/**
	 * 单元列表
	 */
	private List<T> elements;

	public long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(long totalItems) {
		this.totalItems = totalItems;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public List<T> getElements() {
		return elements;
	}

	public void setElements(List<T> elements) {
		this.elements = elements;
	}

}
