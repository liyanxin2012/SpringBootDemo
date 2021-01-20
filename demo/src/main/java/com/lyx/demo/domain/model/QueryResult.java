package com.lyx.demo.domain.model;

import java.util.List;

/**
 * 查询结果类
 *
 * @author Ryan
 *
 * @param <T>
 */
public class QueryResult<T> {
	/**
	 * 查询结果记录数量
	 */
	private long count;

	/**
	 * 起始记录数
	 */
	private long first;

	/**
	 * 单元列表
	 */
	private List<T> elements;

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public List<T> getElements() {
		return elements;
	}

	public void setElements(List<T> elements) {
		this.elements = elements;
	}

	public long getFirst() {
		return first;
	}

	public void setFirst(long first) {
		this.first = first;
	}
}
