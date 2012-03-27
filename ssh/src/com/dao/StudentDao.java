package com.dao;

import java.util.List;
import java.util.Map;

import com.common.tools.Page;
import com.pojo.Student;
import com.vo.DegreeVo;

public interface StudentDao extends BaseDao {

	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	public Student doLogin(String username, String password);

	public List<Student> findStudent(int start, int pageSize);
	
	public int getStudenttCount(Map paramMap);

	public Student getStudentBySName(String studentName);

	public Student getStudentByID(Integer id);
	
	public List<DegreeVo> countByYear() throws Exception;


}
