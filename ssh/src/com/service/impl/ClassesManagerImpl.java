package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.tools.Page;
import com.dao.ClassesDao;
import com.pojo.Classes;
import com.service.ClassesManager;

public class ClassesManagerImpl extends BaseManagerImpl implements ClassesManager {
	
	private ClassesDao classesDao;

	@Override
	public List<Classes> getClasses() {
		return this.classesDao.getClasses();
	}

	@Override
	public Classes getClassesByID(Integer id) {
		return this.classesDao.getClassesByID(id);
	}

	@Override
	public List<Classes> getClassesBydeptID(Integer deptID) {
		return this.classesDao.getClassesBydeptID(deptID);
	}

	public ClassesDao getClassesDao() {
		return classesDao;
	}

	public void setClassesDao(ClassesDao classesDao) {
		this.classesDao = classesDao;
	}

	@Override
	public Page getClassesPage(Page page, Classes classes) {
		List<Classes> list = null;
		Map<String, Object> paramMap = null;
		if(classes != null){
			if(classes.getClassesName() != null && !"".equals(classes.getClassesName())){
				if(paramMap == null){
					paramMap = new HashMap<String, Object>();
				}
				paramMap.put("classesName", classes.getClassesName());
			}
		}
		int count = this.classesDao.getResultCount(Classes.class, paramMap);
		if(count > 0){
			if(count % page.getPageSize() > 0){
				page.setPageCount(count / page.getPageSize() + 1);
			}else{
				page.setPageCount(count / page.getPageSize());
			}
			page.setResultCount(count);
		}
		list = this.classesDao.findPageByCriteria(Classes.class, list, paramMap, null,page.getStart(), page.getPageSize());
		if(list!= null && list.size() > 0){
			page.setResult(list);
		}
		
		return page;
	}

	@Override
	public void saveClasses(Classes classes) {
		this.classesDao.saveOrUpdate(classes);
		
	}
	
	
	
}
