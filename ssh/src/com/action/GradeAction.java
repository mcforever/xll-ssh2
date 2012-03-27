package com.action;

import java.util.List;

import com.common.tools.Page;
import com.common.tools.util.NumberUtil;
import com.pojo.Course;
import com.pojo.Grade;
import com.pojo.Student;
import com.service.CourseManager;
import com.service.GradeManager;
import com.service.StudentManager;

public class GradeAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GradeManager gradeManager;
	private StudentManager studentManager;
	private CourseManager courseManager;
	
	private Page page;
	private Grade grade;
	
	private String studentname;  //成绩查询条件
	private String coursename;   //成绩查询条件
	private String gradeid;
	private String msg;    //成功:单数 失败:双数
	
	public String queryGradePage(){
		page = new Page();
		grade = new Grade();
		
		if(studentname != null && !"".equals(studentname)){
			Student stu = studentManager.getStudentBySName(studentname);
			if(stu != null && stu.getId() != null){
				grade.setStudent(stu);
			}
		}
		if(coursename != null && !"".equals(coursename)){
			Course cou = courseManager.getCourseByName(coursename);
			if(cou != null && cou.getId() != null){
				grade.setCourse(cou);
			}
		}
		
		page = gradeManager.getGradePage(page, grade);
		List<Grade> result = page.getResult();
		for (Grade newGrade : result) {
			if(newGrade.getFinalScore() != null && newGrade.getMidScore() != null){
				newGrade.setTotalScore(NumberUtil.to2dec((newGrade.getFinalScore() * 0.5 + newGrade.getMidScore() * 0.5), 2));
			}
		}
		
		return SUCCESS;
	}
	
	public String scoreEnter() {
		if(grade != null && grade.getId() != null){
			grade = gradeManager.getGradeById(grade.getId());
		}
		return SUCCESS;
	}
	
	public String gradeSave(){
		Grade newgrade = gradeManager.getGradeById(Integer.parseInt(gradeid.toString()));
		newgrade.setMidScore(NumberUtil.to2dec(grade.getMidScore(),2));
		newgrade.setFinalScore(NumberUtil.to2dec(grade.getFinalScore(),2));
		
		try{
			this.gradeManager.saveOrUpdateGrade(newgrade);
			msg = "1";
			return SUCCESS;
			
		} catch (Exception e){
			e.printStackTrace();
			msg = "2";
			return INPUT;
		} 
	}
	
	public String deleteGrade(){
		if(grade != null && grade.getId() != null){
			grade = gradeManager.getGradeById(grade.getId());
			this.gradeManager.deleteGrade(grade.getId());
			msg = "3";
		}else{
			msg = "4";
		}
		return SUCCESS;
	}
	
	public GradeManager getGradeManager() {
		return gradeManager;
	}

	public void setGradeManager(GradeManager gradeManager) {
		this.gradeManager = gradeManager;
	}

	public StudentManager getStudentManager() {
		return studentManager;
	}

	public void setStudentManager(StudentManager studentManager) {
		this.studentManager = studentManager;
	}

	public CourseManager getCourseManager() {
		return courseManager;
	}

	public void setCourseManager(CourseManager courseManager) {
		this.courseManager = courseManager;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getGradeid() {
		return gradeid;
	}

	public void setGradeid(String gradeid) {
		this.gradeid = gradeid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
