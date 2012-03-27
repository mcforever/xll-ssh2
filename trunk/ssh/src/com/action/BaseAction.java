package com.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.tools.Page;
import com.common.tools.util.DateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.SysUser;

public class BaseAction extends ActionSupport {

	private String titleFlowMenu;                  //bhj 主页面标题跟随菜单名称
	private SysUser currentUser;                   //当前登录用户
	private Integer currentUserLevel;              //当前用户级别   0:学生;1:导员;2:讲师;3:管理员
	private String msg;                            //向页面上返回消息
	private HttpServletRequest request;
	private HttpServletResponse response;
	private int currentYear;                       //当前年份
	private Page page;
	
	public SysUser getCurrentUser() {
		return (SysUser)ActionContext.getContext().getSession().get("sessionUser");
	}
	public void setCurrentUser(SysUser currentUser) {

		this.currentUser = currentUser;
	}
	
	public Integer getCurrentUserLevel() {
		return (Integer) ActionContext.getContext().getSession().get("sessionLevel");
	}
	public void setCurrentUserLevel(Integer currentUserLevel) {
		this.currentUserLevel = currentUserLevel;
	}
	/**
	 * 得到当前年份
	 * @return
	 */
	public int getCurrentYear() {
		return DateUtil.getYear(getCurrentSysDate());
	}
	
	/**
	 * 返回服务器日期
	 * 
	 * @return
	 */
	public Date getCurrentSysDate() {

		return new Date();
	}
	
	public HttpServletRequest getRequest() {
		
		return request;
	}

	public void setRequest(HttpServletRequest request) {

		this.request = request;
	}

	public HttpServletResponse getResponse() {

		return response;
	}

	public void setResponse(HttpServletResponse response) {

		this.response = response;
	}

	public HttpSession getSession() {

		return getRequest().getSession();
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	
	
}
