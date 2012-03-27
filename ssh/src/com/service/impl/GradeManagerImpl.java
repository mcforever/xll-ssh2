package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.tools.Page;
import com.dao.GradeDao;
import com.pojo.Course;
import com.pojo.Grade;
import com.service.BaseManager;
import com.service.GradeManager;

public class GradeManagerImpl extends BaseManagerImpl implements GradeManager {
	private GradeDao gradeDao;
	
	public List<Grade> getStuScore(Integer stuid){
		return this.gradeDao.getStuScore(stuid);
	}

	@Override
	public Map<String, Double> getStuAvgScore(Integer stuid) {
		try {
			return this.gradeDao.getStuAvgScore(stuid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveOrUpdateGrade(Grade grade) {
		this.gradeDao.saveOrUpdate(grade);
		
	}

	@Override
	public Grade checkGrade(Integer studentid, Integer courseid) {
		return this.gradeDao.checkGrade(studentid,courseid);
	}

	@Override
	public Grade checkGrade(Grade grade) {
		return this.gradeDao.checkGrade(grade);
	}

	public GradeDao getGradeDao() {
		return gradeDao;
	}

	public void setGradeDao(GradeDao gradeDao) {
		this.gradeDao = gradeDao;
	}

	@Override
	public Page getGradePage(Page page, Grade grade) {
		List<Grade> list = null;
		Map<String, Object> paramMap = null;
		
		if(grade != null){
			if(grade.getStudent() != null && grade.getStudent().getId() != null){
				if(paramMap == null){
					paramMap = new HashMap<String, Object>();
				}
				paramMap.put("student.id", grade.getStudent().getId());
			}
			if(grade.getCourse() != null && grade.getCourse().getId() != null){
				if(paramMap == null){
					paramMap = new HashMap<String, Object>();
				}
				paramMap.put("course.id", grade.getCourse().getId());
			}
		}
		
		int count = this.gradeDao.getResultCount(Grade.class, paramMap);
		if(count != 0){
			if(count != 0){
				if(count % page.getPageSize() > 0){
					page.setPageCount(count / page.getPageSize() + 1);
				}else{
					page.setPageCount(count / page.getPageSize());
				}
				page.setResultCount(count);
			}
		}
		
		list = this.gradeDao.findPageByCriteria(Grade.class, list, paramMap, null, page.getStart(), page.getPageSize());
		if(list != null){
			page.setResult(list);
		}
		return page;
		
	}

	@Override
	public Grade getGradeById(Integer id) {
		return this.gradeDao.getGradeById(id);
	}

	@Override
	public void deleteGrade(Integer id) {
		this.gradeDao.delete(Grade.class, id);
		
	}
	
	
}
