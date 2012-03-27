package com.dao;

import java.util.List;

import com.pojo.Dept;

public interface DeptDao extends BaseDao {
	
	public List<Dept> getDept();
	public Dept getDeptByID(Integer id);
	
}