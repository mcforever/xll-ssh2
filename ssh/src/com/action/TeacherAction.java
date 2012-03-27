package com.action;

import java.util.List;

import com.common.tools.Page;
import com.pojo.Dept;
import com.pojo.Teacher;
import com.pojo.system.SysDictionary;
import com.service.DeptManager;
import com.service.TeacherManager;

public class TeacherAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TeacherManager teacherManager;
	private DeptManager deptManager;
	
	private List<Teacher> teacherList;
	private List<SysDictionary> tpositionList;
	private Teacher teacher;
	private Teacher queryTeacher;
	private Page page;
	
	private String msg;
	
	
	public String execute (){
		return SUCCESS;
	}
	
	public String queryTeacherPage() {
		if(page == null){
			page = new Page();
		}
		page = teacherManager.getTeacherPage(page,queryTeacher);
		List<Teacher> result = page.getResult();
		
		for (Teacher teacher : result) {
			if(teacher != null && teacher.getTposition() != null){
				setTeacherStr(teacher);
			}
			
		}
		
		tpositionList = this.teacherManager.getDictionary("teaPosition");
		return SUCCESS;
	}
	
	public void setTeacherStr(Teacher bean){
		if(bean.getTposition() != null){
			SysDictionary dictionary = (SysDictionary) this.teacherManager.getDictionary("teaPosition", bean.getTposition());
			bean.setTpositionStr(dictionary.getDataDescription());
		}
	}

	public TeacherManager getTeacherManager() {
		return teacherManager;
	}

	public void setTeacherManager(TeacherManager teacherManager) {
		this.teacherManager = teacherManager;
	}

	public DeptManager getDeptManager() {
		return deptManager;
	}

	public void setDeptManager(DeptManager deptManager) {
		this.deptManager = deptManager;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	public List<SysDictionary> getTpositionList() {
		return tpositionList;
	}

	public void setTpositionList(List<SysDictionary> tpositionList) {
		this.tpositionList = tpositionList;
	}

	public Teacher getQueryTeacher() {
		return queryTeacher;
	}

	public void setQueryTeacher(Teacher queryTeacher) {
		this.queryTeacher = queryTeacher;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
