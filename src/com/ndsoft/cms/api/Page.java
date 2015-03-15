package com.ndsoft.cms.api;

public class Page {

	/** 数据总条数 */
	private Integer total;
	/** 当前页码 */
	private Integer index;
	/** 每页显示条数 */
	private Integer size;
	/** 总页数 */
	private Integer count;

	public Page() {

	}

	public Page(Integer index, Integer size) {
		this.index = index;
		this.size = size;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
