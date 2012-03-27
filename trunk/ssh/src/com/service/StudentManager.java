package com.service;

import java.util.List;

import com.common.tools.Page;
import com.pojo.Student;
import com.pojo.system.SysDictionary;
import com.vo.DegreeVo;

public interface StudentManager extends BaseManager {

	/**
	 * 登录
	 * @param stu
	 * @return
	 */
	public Student doLogin(String username, String password);

	public Page queryStudentPage(Page page);

	public Page getStudentPage(Page page,Student student);

	public Student getStudentBySName(String studentName);

	public Student getStudentByID(Integer id);

	public void saveStudent(Student student);
	
	public List<DegreeVo> countByYear() throws Exception;

	public void deleteStudent(Integer id);

}
