package com.pojo;

import java.io.Serializable;
import java.util.Set;

public class Teacher implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//--------跟数据库字段对应的属性------------//
	private Integer id;
	private String teacherName;
	private String password;
	private Integer tposition;
	private Dept dept;
	private String memo;
	
	private Set<Classes> classesSet;
	//--------跟数据库字段对应的属性------------//
	
	//--------不跟数据库映射的属性，只用于显示的-----------//
	
	private String tpositionStr;
	
	//--------不跟数据库映射的属性，只用于显示的-----------//
	
	public Teacher() {
	}
	public Teacher(Integer id) {
		super();
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Integer getTposition() {
		return tposition;
	}
	public void setTposition(Integer tposition) {
		this.tposition = tposition;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public String getTpositionStr() {
		return tpositionStr;
	}
	public void setTpositionStr(String tpositionStr) {
		this.tpositionStr = tpositionStr;
	}
	public Set<Classes> getClassesSet() {
		return classesSet;
	}
	public void setClassesSet(Set<Classes> classesSet) {
		this.classesSet = classesSet;
	}
	
	
}
