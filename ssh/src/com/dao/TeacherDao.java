package com.dao;

import java.util.List;

import com.pojo.Teacher;

public interface TeacherDao extends BaseDao {

	public Teacher doLogin(String userName, String password);

	public List<Teacher> getTeacher();

	public List<Teacher> getTeacherByDeptID(Integer deptID);

	public Teacher getTeacherByID(Integer id);

	public List<Teacher> getTeacherByTeaPosition(int teaPosition);

}
