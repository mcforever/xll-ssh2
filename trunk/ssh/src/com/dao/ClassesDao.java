package com.dao;

import java.util.List;

import com.pojo.Classes;

public interface ClassesDao extends BaseDao {

	public List<Classes> getClasses();

	public Classes getClassesByID(Integer id);

	public List<Classes> getClassesBydeptID(Integer deptID);

}
