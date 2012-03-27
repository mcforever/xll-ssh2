package com.service;

import java.util.List;

import com.common.tools.Page;
import com.pojo.Classes;

public interface ClassesManager extends BaseManager {

	/**
	 * 根据ID查询Classes对象
	 * @param id  key
	 * @return Classes对象
	 */
	public Classes getClassesByID(Integer id);

	/**
	 * 根据学院ID查询
	 * @param deptID 学院ID
	 * @return 班级列表
	 */
	public List<Classes> getClassesBydeptID(Integer deptID);

	/**
	 * 查询班级列表
	 * @return 班级列表
	 */
	public List<Classes> getClasses();

	/**
	 * 获取classes的分页
	 * @param page
	 * @param classes 班级查询条件
	 * @return page
	 */
	public Page getClassesPage(Page page, Classes classes);

	/**
	 * 保存班级信息
	 * @param classes
	 */
	public void saveClasses(Classes classes);

}
