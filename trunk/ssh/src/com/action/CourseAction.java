package com.action;

import java.util.List;

import com.common.tools.Page;
import com.pojo.Course;
import com.pojo.Grade;
import com.pojo.Student;
import com.pojo.Teacher;
import com.pojo.system.SysDictionary;
import com.service.CourseManager;
import com.service.GradeManager;
import com.service.StudentManager;
import com.service.TeacherManager;

public class CourseAction extends BaseAction {
	private CourseManager courseManager;
	private TeacherManager teacherManager;
	private GradeManager gradeManager;
	private StudentManager studentManager;
	
	private List<Course> courseList;
	private List<Teacher> teacherList;
	private List<SysDictionary> courseTimeList;
	private List<Grade> gradeList;
	
	private Course course;
	private Grade grade;
	private Page page;
	
	private String coursename;
	private Integer teacherid;
	private String msg;
	
	public String queryCoursePage() {
		if(page == null){
			page = new Page();
		}
		
		Course cou = new Course();
		if(coursename != null && !"".equals(coursename)){
			cou.setCourseName(coursename);
		}
		if(teacherid != null){
			Teacher tea = new Teacher();
			tea.setId(teacherid);
			cou.setTeacher(tea);
		}
		page = courseManager.getCoursePage(page,cou);
		List<Course> result = page.getResult();
		for (Course c : result) {
			this.setCourseStr(c);
		}
		page.setResult(result);
		//获取授课时间
		courseTimeList = courseManager.getDictionary("coutime");
		//获取讲师列表
		teacherList = teacherManager.getTeacherByTeaPosition(1);
		
		return SUCCESS;
	}
	
	public String courseDetail(){
		return SUCCESS;
	}
	
	public String studentSelectCourse(){
		Grade grade = new Grade();
		if(course != null && course.getId() != null){
			course = courseManager.getCourseByID(course.getId());
			grade.setCourse(course);
		}
		Student stu = null;
		if(this.getCurrentUserLevel() == 0){
			stu = studentManager.getStudentByID(this.getCurrentUser().getId());
			grade.setStudent(stu);
		}
		
		if(gradeManager.checkGrade(stu.getId(),course.getId()) != null){
			msg = "3";
			return SUCCESS;
		}
		
		try {
			gradeManager.saveOrUpdateGrade(grade);
			msg = "1";
			return SUCCESS;
		} catch (Exception e){
			e.printStackTrace();
			msg = "2";
			return INPUT;
		}
		
	}
	
	public String selectedCourse(){
		page = new Page();
		grade = new Grade();
		if(this.getCurrentUserLevel() == 0 && this.getCurrentUser().getUserLevel() == 1){   //根据学生ID
			grade.setStudent(this.studentManager.getStudentByID(this.getCurrentUser().getId()));   
		}
		page = gradeManager.getGradePage(page, grade);
		List<Grade> result = page.getResult();
		for (Grade grade : result) {
			this.setCourseStr(grade.getCourse());
		}
		return SUCCESS;
	}

	private void setCourseStr(Course cou) {
		if(cou.getCourseTime() != null){
			SysDictionary newSysDictionary = (SysDictionary) courseManager.getDictionary("coutime",cou.getCourseTime());
			cou.setCourseTimeStr(newSysDictionary.getDataDescription());
		}
		
	}

	public CourseManager getCourseManager() {
		return courseManager;
	}

	public void setCourseManager(CourseManager courseManager) {
		this.courseManager = courseManager;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public Integer getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(Integer teacherid) {
		this.teacherid = teacherid;
	}

	public List<SysDictionary> getCourseTimeList() {
		return courseTimeList;
	}

	public void setCourseTimeList(List<SysDictionary> courseTimeList) {
		this.courseTimeList = courseTimeList;
	}

	public TeacherManager getTeacherManager() {
		return teacherManager;
	}

	public void setTeacherManager(TeacherManager teacherManager) {
		this.teacherManager = teacherManager;
	}

	public GradeManager getGradeManager() {
		return gradeManager;
	}

	public void setGradeManager(GradeManager gradeManager) {
		this.gradeManager = gradeManager;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public StudentManager getStudentManager() {
		return studentManager;
	}

	public void setStudentManager(StudentManager studentManager) {
		this.studentManager = studentManager;
	}

	public List<Grade> getGradeList() {
		return gradeList;
	}

	public void setGradeList(List<Grade> gradeList) {
		this.gradeList = gradeList;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
