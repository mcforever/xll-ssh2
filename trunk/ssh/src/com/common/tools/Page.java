package com.common.tools;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int PAGE_SIZE = 10;
	
	private int resultCount;      //总记录数
	private int pageCount = -1;        //总页数
	private int pageSize = PAGE_SIZE;         //每页条数
	private int curPage = 1;          //当前页数，默认是1
	private List result;  //结果集
	
	/** hibernate hql语句 */
	private String hql1;
	private String hql2;
	/** 过滤条件 */
	private Object[] conditions;
	/** 排序条件 */
	private String orderBy;
	/** 当前页第一条数据的位置,从0开始 */
	private int start;
	
	public int getStart() {
		return (this.curPage -1) * pageSize;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public Page() {
	}
	
	public Page(int resultCount, int pageSize, int page){
		this.resultCount = resultCount;
		this.pageSize = pageSize;
		
	}

	public int getResultCount() {
		return resultCount;
	}


	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}


	public int getPageCount() {
		if(resultCount != 0){
			if(resultCount % pageSize > 0){
				return resultCount / pageSize + 1;
			}else{
				return resultCount / pageSize;
			}
		}
		return pageCount;
	}


	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getCurPage() {
		return curPage;
	}


	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}


	public List getResult() {
		return result;
	}


	public void setResult(List result) {
		this.result = result;
	}

	public String getHql1() {
		return hql1;
	}

	public void setHql1(String hql1) {
		this.hql1 = hql1;
	}

	public String getHql2() {
		return hql2;
	}

	public void setHql2(String hql2) {
		this.hql2 = hql2;
	}

	public Object[] getConditions() {
		return conditions;
	}

	public void setConditions(Object[] conditions) {
		this.conditions = conditions;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
}
