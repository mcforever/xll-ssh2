package com.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Dept implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//--------跟数据库字段对应的属性------------//
	private Integer id;
	private String deptName;
	private String memo;
	
	private Set<Student> studentSet = new HashSet<Student>();
	//--------跟数据库字段对应的属性------------//
	
	//--------不跟数据库映射的属性，只用于显示的-----------//
	
	//--------不跟数据库映射的属性，只用于显示的-----------//
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
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
	

}
