package com.service;

import java.util.List;

import com.pojo.Dept;

public interface DeptManager extends BaseManager {
	
	public List<Dept> getDept();
	
	public Dept getDeptByID(Integer id);

}
