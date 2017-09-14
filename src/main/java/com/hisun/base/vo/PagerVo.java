package com.hisun.base.vo;

import java.util.List;

public class PagerVo<T> {

	/**
	 * 总数
	 */
	private int total;
	
	/**
	 * 当前页数
	 */
	private int pageNum;
	
	/**
	 * 数据
	 */
	private List<T> datas;
	
	/**
	 * 分页大小
	 */
	private int pageSize;
	
	/**
	 * 总页数
	 */
	private int pageCount;
	
	public PagerVo(List<T> datas,int total, int pageNum,int pageSize){
		this.datas = datas;
		this.total = total;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.pageCount = (int)Math.ceil((double)total/pageSize);
	}

	public int getTotal() {
		return total;
	}

	public int getPageNum() {
		return pageNum;
	}
	public List<T> getDatas() {
		return datas;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}
	
}
