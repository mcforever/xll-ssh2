package com.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Classes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//--------跟数据库字段对应的属性------------//
	private Integer id;
	private String classesName;                                         //班级名称
	private Date createDate;                                      //成立时间
	private Teacher teacher;                                     //导员
	private String memo;                                          //备注
	
	private Set<Student> studentSet = new HashSet<Student>();
	//--------跟数据库字段对应的属性------------//
	
	
	
	//--------不跟数据库映射的属性，只用于显示的-----------//
	private String createDateStr;
	private Double maxScore;
	private Double minScore;
	private Double averageScore;
	//--------不跟数据库映射的属性，只用于显示的-----------//
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public String getClassesName() {
		return classesName;
	}
	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Set<Student> getStudentSet() {
		return studentSet;
	}
	public void setStudentSet(Set<Student> studentSet) {
		this.studentSet = studentSet;
	}
	public String getCreateDateStr() {
		return createDateStr;
	}
	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}
	public Double getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(Double maxScore) {
		this.maxScore = maxScore;
	}
	public Double getMinScore() {
		return minScore;
	}
	public void setMinScore(Double minScore) {
		this.minScore = minScore;
	}
	public Double getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(Double averageScore) {
		this.averageScore = averageScore;
	}
	
	
}
