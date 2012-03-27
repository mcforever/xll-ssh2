package com.service;

import java.util.List;
import java.util.Map;

import com.common.tools.Page;
import com.pojo.Grade;

public interface GradeManager extends BaseManager {
	
	public Page getGradePage(Page page,Grade grade);
	
	public List<Grade> getStuScore(Integer studentid);
	
	public Map<String, Double> getStuAvgScore(Integer stuid);

	public void saveOrUpdateGrade(Grade grade);

	public Grade checkGrade(Integer studentid, Integer courseid);
	
	public Grade checkGrade(Grade grade);
	
	public Grade getGradeById(Integer id);

	public void deleteGrade(Integer id);

}
