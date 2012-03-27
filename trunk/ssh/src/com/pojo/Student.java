package com.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//--------跟数据库字段对应的属性------------//
	private Integer id;                  
	private String studentName;                //学生姓名
	private String password;             //密码
	private Integer sex;                 //性别 0:男,1:女
	private Date birthday;               //出生日期
	private Integer orientation;         //政治面貌 1:团员,2:党员,3:其他
	private Date enrollDate;             //入学时间
	private String telephone;            //联系电话
	private Integer schooling;           //学制
	private Integer studyState;          //学习状态 0:在读,1:休学
	private Classes classes;             //所在班级
	private Dept dept;                   //所在学院
	private String memo;                 //备注
	
	private Set<Grade> gradeSet;       //学生成绩
	//--------跟数据库字段对应的属性------------//
	
	//--------不跟数据库映射的属性，只用于显示的-----------//
	
	private String sexStr;
	private String birthdayStr;
	private String enrollDateStr;
	private String orientationStr;
	private String studyStateStr;
	
	
	//--------不跟数据库映射的属性，只用于显示的-----------//
	public Student() {
	}
	public Student(Integer id) {
		this.id = id;
	}
	public Student(String studentName, String password) {
		this.studentName = studentName;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getOrientation() {
		return orientation;
	}
	public void setOrientation(Integer orientation) {
		this.orientation = orientation;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getSchooling() {
		return schooling;
	}
	public void setSchooling(Integer schooling) {
		this.schooling = schooling;
	}
	public Integer getStudyState() {
		return studyState;
	}
	public void setStudyState(Integer studyState) {
		this.studyState = studyState;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getBirthdayStr() {
		return birthdayStr;
	}
	public void setBirthdayStr(String birthdayStr) {
		this.birthdayStr = birthdayStr;
	}
	public String getEnrollDateStr() {
		return enrollDateStr;
	}
	public void setEnrollDateStr(String enrollDateStr) {
		this.enrollDateStr = enrollDateStr;
	}
	public String getOrientationStr() {
		return orientationStr;
	}
	public void setOrientationStr(String orientationStr) {
		this.orientationStr = orientationStr;
	}
	public String getStudyStateStr() {
		return studyStateStr;
	}
	public void setStudyStateStr(String studyStateStr) {
		this.studyStateStr = studyStateStr;
	}
	public String getSexStr() {
		return sexStr;
	}
	public void setSexStr(String sexStr) {
		this.sexStr = sexStr;
	}
	public Set<Grade> getGradeSet() {
		return gradeSet;
	}
	public void setGradeSet(Set<Grade> gradeSet) {
		this.gradeSet = gradeSet;
	}
	
	
}
