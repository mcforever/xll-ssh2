package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.tools.Page;
import com.dao.TeacherDao;
import com.pojo.Teacher;
import com.service.TeacherManager;

public class TeacherManagerImpl extends BaseManagerImpl implements TeacherManager {
	
	private TeacherDao teacherDao;

	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Override
	public Teacher doLogin(String userName, String password) {
		return this.teacherDao.doLogin(userName,password);
	}

	@Override
	public List<Teacher> getTeacher() {
		return this.teacherDao.getTeacher();
	}

	@Override
	public List<Teacher> getTeacherByDeptID(Integer deptID) {
		return this.teacherDao.getTeacherByDeptID(deptID);
	}

	@Override
	public Teacher getTeacherByID(Integer id) {
		return this.teacherDao.getTeacherByID(id);
	}

	@Override
	public List<Teacher> getTeacherByTeaPosition(int teaPosition) {
		return this.teacherDao.getTeacherByTeaPosition(teaPosition);
	}

	@Override
	public Page getTeacherPage(Page page, Teacher teacher) {
		List<Teacher> list = null;
		Map<String, Object> paramMap = null;
		
		if(teacher != null){
			if(teacher.getTeacherName() != null && !"".equals(teacher.getTeacherName())){
				if(paramMap == null){
					paramMap = new HashMap<String, Object>();
				}
				paramMap.put("teacherName", teacher.getTeacherName());
			}
			
			if(teacher.getTposition() != null && !"".equals(teacher.getTposition())){
				if(paramMap == null){
					paramMap = new HashMap<String, Object>();
				}
				paramMap.put("tposition", teacher.getTposition());
			}
			
		}
		
		int count = this.teacherDao.getResultCount(Teacher.class, paramMap);
		if(count != 0){
			if(count % page.getPageSize() > 0){
				page.setPageCount(count / page.getPageSize() + 1);
			}else{
				page.setPageCount(count / page.getPageSize());
			}
			page.setResultCount(count);
		}
		
//		List<Student> list = this.studentDao.findStudent(page.getStart(), page.getPageSize());
		list = this.teacherDao.findPageByCriteria(Teacher.class,list,paramMap,null,page.getStart(), page.getPageSize());
		if(list != null){
			page.setResult(list);
		}
		return page;
		
	}

	@Override
	public void saveOrUpdateTeacher(Teacher teacher) {
		this.teacherDao.saveOrUpdate(teacher);
		
	}
	
}
