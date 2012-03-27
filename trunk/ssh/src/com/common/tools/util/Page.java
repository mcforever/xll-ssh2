package com.common.tools.util;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int PAGE_SIZE = 20;
	
	private int resultCount;      //总记录数
	private int pageCount;        //总页数
	private int pageSize = PAGE_SIZE;         //每页条数
	private int curPage;          //当前页数
	private int prevPage;          //前一页
	private int nextPage;         //下一页
	private StringBuffer pageInfo;
	private List<Object> result;  //结果集
	
	
	public Page() {
	}

	public Page(int resultCount, int pageCount, int pageSize, int curPage, int prevPage, int nextPage,
			StringBuffer pageInfo, List<Object> result) {
		super();
		this.resultCount = resultCount;
		this.pageCount = pageCount;
		this.pageSize = pageSize;
		this.curPage = curPage;
		this.prevPage = prevPage;
		this.nextPage = nextPage;
		this.pageInfo = pageInfo;
		this.result = result;
	}

	public int getResultCount() {
		return resultCount;
	}


	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}


	public int getPageCount() {
		pageCount = (int)Math.ceil((float)getResultCount()/(float)getPageSize());
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
		if(curPage > getPageCount())
			curPage = getPageCount();
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPrevPage() {
		if(getCurPage() > 1)
			prevPage = getCurPage() - 1;
		else
			prevPage = getCurPage();
		return prevPage;
	}


	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		if(getCurPage() < getPageCount())
			nextPage = getCurPage() + 1;
		else
			nextPage = getCurPage();
		return nextPage;
	}


	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}


	public StringBuffer getPageInfo() {
		pageInfo.append("共"+getResultCount()+"条 ");
		pageInfo.append("共"+getPageCount()+"页 ");
		pageInfo.append("每页"+getPageSize()+"条 ");
		pageInfo.append("第"+getCurPage()+"页 ");
		if(getPrevPage() > 1)
			pageInfo.append("<a href=\"javascript:pageSubmit("+getPrevPage()+")\">上一页</a> ");
		else
			pageInfo.append("<span class=\"note\">上一页</span> ");
		if(getNextPage() < getPageCount())
			pageInfo.append("<a href=\"javascript:pageSubmit("+getNextPage()+")\">下一页</a> ");
		else
			pageInfo.append("<span class=\"note\">下一页</span>");
		pageInfo.append("<select name=\"curPage\">");
		for(int i = 1;i <= getPageCount(); i++)
			pageInfo.append("<option value=\""+i+"\">"+i+"</option>");
		pageInfo.append("</select>");
		return pageInfo;
	}


	public void setPageInfo(StringBuffer pageInfo) {
		this.pageInfo = pageInfo;
	}


	public List<Object> getResult() {
		return result;
	}


	public void setResult(List<Object> result) {
		this.result = result;
	}
	
	
	
}
