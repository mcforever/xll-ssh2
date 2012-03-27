package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.tools.Page;
import com.dao.StudentDao;
import com.pojo.Student;
import com.pojo.system.SysDictionary;
import com.service.BaseManager;
import com.service.StudentManager;
import com.vo.DegreeVo;

public class StudentManagerImpl extends BaseManagerImpl implements StudentManager {
	private StudentDao studentDao;

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public Student doLogin(String username, String password) {
		return this.studentDao.doLogin(username,password);
	}

	@Override
	public Page queryStudentPage(Page page) {
		int count = this.studentDao.getResultCount(page.getHql1());
		if(count != 0){
			if(count % page.getPageSize() > 0){
				page.setPageCount(count / page.getPageSize() + 1);
			}else{
				page.setPageCount(count / page.getPageSize());
			}
			page.setResultCount(count);
		}
		List<Student> list = this.studentDao.queryByPage(page.getHql2(), page.getStart(), page.getPageSize());
		if(list != null){
			page.setResult(list);
		}
		return page;
	}

	@Override
	public Page getStudentPage(Page page,Student student) {
		List<Student> list = null;
		Map<String, Object> paramMap = null;
		
		if(student != null){
			if(student.getStudentName() != null && !"".equals(student.getStudentName())){
				if(paramMap == null){
					paramMap = new HashMap<String, Object>();
				}
				paramMap.put("studentName", student.getStudentName());
			}
			if(student.getClasses() != null && student.getClasses().getId() != null){
				if(paramMap == null){
					paramMap = new HashMap<String, Object>();
				}
				paramMap.put("classes.id", student.getClasses().getId());
			}
			if(student.getDept() != null && student.getDept().getId() != null){
				if(paramMap == null){
					paramMap = new HashMap<String, Object>();
				}
				paramMap.put("dept.id", student.getDept().getId());
			}
			if(student.getPassword() != null && !"".equals(student.getPassword())){
				if(paramMap == null){
					paramMap = new HashMap<String, Object>();
				}
				paramMap.put("password", student.getPassword());
			}
			if(student.getStudyState() != null && !"".equals(student.getStudyState())){
				if(paramMap == null){
					paramMap = new HashMap<String, Object>();
				}
				paramMap.put("studyState", student.getStudyState());
			}
		}
		
		//int count = this.studentDao.getStudenttCount(paramMap);
		int count = this.studentDao.getResultCount(Student.class, paramMap);
		if(count != 0){
			if(count % page.getPageSize() > 0){
				page.setPageCount(count / page.getPageSize() + 1);
			}else{
				page.setPageCount(count / page.getPageSize());
			}
			page.setResultCount(count);
		}
//		List<Student> list = this.studentDao.findStudent(page.getStart(), page.getPageSize());
		list = this.studentDao.findPageByCriteria(Student.class,list,paramMap,null,page.getStart(), page.getPageSize());
		if(list != null){
			page.setResult(list);
		}
		return page;
	}

	@Override
	public Student getStudentBySName(String studentName) {
		return this.studentDao.getStudentBySName(studentName);
	}

	@Override
	public Student getStudentByID(Integer id) {
		return this.studentDao.getStudentByID(id);
	}

	@Override
	public void saveStudent(Student student) {
		this.studentDao.saveOrUpdate(student);
		
	}

	@Override
	public List<DegreeVo> countByYear() throws Exception {
		
		return this.studentDao.countByYear();
	}

	@Override
	public void deleteStudent(Integer id) {
		this.studentDao.delete(Student.class, id);
		
	}
}
