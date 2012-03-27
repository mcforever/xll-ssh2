package com.pojo;

import java.io.Serializable;
import java.util.Set;

public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//--------跟数据库字段对应的属性------------//
	private Integer id;
	private String courseName;
	private Teacher teacher;
	private Integer courseTime;
	private Double credit;
	private String memo;
	
	private Set<Grade> gradeSet;
	//--------跟数据库字段对应的属性------------//
	
	//--------不跟数据库映射的属性，只用于显示的-----------//
	private String courseTimeStr;
	//--------不跟数据库映射的属性，只用于显示的-----------//
	
	public Course() {
	}
	public Course(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Integer getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(Integer courseTime) {
		this.courseTime = courseTime;
	}
	public Double getCredit() {
		return credit;
	}
	public void setCredit(Double credit) {
		this.credit = credit;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Set<Grade> getGradeSet() {
		return gradeSet;
	}
	public void setGradeSet(Set<Grade> gradeSet) {
		this.gradeSet = gradeSet;
	}
	public String getCourseTimeStr() {
		return courseTimeStr;
	}
	public void setCourseTimeStr(String courseTimeStr) {
		this.courseTimeStr = courseTimeStr;
	}
	

}
