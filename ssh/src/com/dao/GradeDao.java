package com.dao;

import java.util.List;
import java.util.Map;

import com.pojo.Grade;

public interface GradeDao extends BaseDao {

	public List<Grade> getStuScore(Integer stuid);
	
	public Map<String, Double> getStuAvgScore(Integer stuid) throws Exception;
	
	public Grade checkGrade(Integer studentid, Integer courseid);
	
	public Grade checkGrade(Grade grade);
	
	public Grade getGradeById(Integer id);
	

}
