package com.action;

import java.util.ArrayList;
import java.util.List;


import com.common.tools.Page;
import com.common.tools.util.DateUtil;
import com.pojo.Classes;
import com.pojo.Dept;
import com.pojo.Student;
import com.pojo.system.SysDictionary;
import com.service.ClassesManager;
import com.service.DeptManager;
import com.service.GradeManager;
import com.service.StudentManager;
import com.service.TeacherManager;
import com.vo.DegreeVo;

public class StudentAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private StudentManager studentManager;
	private ClassesManager classesManager;
	private TeacherManager teacherManager;
	private DeptManager deptManager;
	private GradeManager gradeManager;
	
	private List<Student> studentList;
	private List<Classes> classesList;
	private List<SysDictionary> studyStateList;
	private List<SysDictionary> orientationList;
	private List<DegreeVo> degreeVoList;
	private List<Dept> deptList;
	private Student student;
	private Page page;
	
	private String option; //增加修改判断标识
	private String title;  //页面标题  暂时没用上
	private String msg;    //成功:单数  失败:双数
	private Student queryStudent;   //学生信息查询条件

	
	
	public String queryStudentPage() {
		if(page == null){
			page = new Page();
		}
//		String hql1 = "select count(*) from Student";
//		StringBuffer sb = new StringBuffer("from Student s where 1 = 1");
//		String hql2 = sb.toString();
//		page.setHql1(hql1);
//		page.setHql2(hql2);
//		page = studentManager.queryStudentPage(page);
		
		page = studentManager.getStudentPage(page,queryStudent);
		List<Student> result = page.getResult();
		for (Student stu : result) {
			this.setStudentStr(stu);
		}
		page.setResult(result);
		
		//获取全部班级信息
		if(this.getCurrentUser().getUserLevel() == 1){
			Student stu = studentManager.getStudentByID(this.getCurrentUser().getId());
			Classes cla = classesManager.getClassesByID(stu.getClasses().getId());
			classesList = new ArrayList<Classes>();
			classesList.add(cla);
		}
		if(this.getCurrentUser().getUserLevel() == 2){
			classesList = classesManager.getClasses();
		}
		if(this.getCurrentUser().getUserLevel() == 3){
			classesList = classesManager.getClasses();
		}
		
		//获取学习状态
		studyStateList = studentManager.getDictionary("studyState");
		
		return "success";
	}
	
	//查看学生的详细信息
	public String studentDetail(){
		student = studentManager.getStudentByID(student.getId());
		
		if(student != null){
			this.setStudentStr(student);
		}
		
		return "success";
	}
	
	//修改和新增学生信息页面显示
	public String studentEdit(){
		if("add".equals(option)){
			student = null;
			//获取班级列表
			classesList = classesManager.getClasses();
			//获取学习状态
			studyStateList = studentManager.getDictionary("studyState");
			//获取政治面貌
			orientationList = studentManager.getDictionary("orientation");
			//获取学院列表
			deptList = deptManager.getDept();
			
		}else if("edit".equals(option)){
			student = studentManager.getStudentByID(student.getId());
			//获取班级列表
			classesList = classesManager.getClasses();
			//获取学习状态
			studyStateList = studentManager.getDictionary("studyState");
			//获取政治面貌
			orientationList = studentManager.getDictionary("orientation");
			//获取学院列表
			deptList = deptManager.getDept();
			
		}
		return "success";
	}
	
	//修改和新增学生信息
	public String studentSave(){
		try {
			if(student.getId() == null){
				this.student.setPassword("123456");  //设置默认密码是123456
				msg = "1";
			}else{
				msg = "3";
			}
			this.studentManager.saveStudent(student);
			
			return SUCCESS;
		} catch (Exception e){
			e.printStackTrace();
			msg = "2";
			return INPUT;
		}
		
	}
	
	public String studentDelete(){
		try {
			if(student != null && student.getId() != null){
				this.studentManager.deleteStudent(student.getId());
				msg = "5";
			}
			return SUCCESS;
		} catch (Exception e){
			e.printStackTrace();
			msg = "6";
			return INPUT;
		}
	}
	
	//修改学生的在校状态
	public String studyStateUpdate(){
		try {
			Student stu = studentManager.getStudentByID(student.getId());
			stu.setStudyState(student.getStudyState());
			this.studentManager.saveStudent(stu);
			msg = "1";
			return SUCCESS;
		} catch (Exception e){
			e.printStackTrace();
			msg = "2";
			return SUCCESS;
		}
	}
	
	public String compareYear(){
		try {
			degreeVoList = this.studentManager.countByYear();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 设置student非关联字段
	 * @param stu  学生对象
	 */
	private void setStudentStr(Student stu){
		if(stu.getSex() != null){
			SysDictionary newSysDictionary = (SysDictionary) studentManager.getDictionary("sex",stu.getSex());
			stu.setSexStr(newSysDictionary.getDataDescription());
		}
		if(stu.getBirthday() != null){
			stu.setBirthdayStr(DateUtil.getStringDate(stu.getBirthday()));
		}
		if(stu.getEnrollDate() != null){
			stu.setEnrollDateStr(DateUtil.getStringDate(stu.getEnrollDate()));
		}
		if(stu.getOrientation() != null){
			SysDictionary newSysDictionary = (SysDictionary) studentManager.getDictionary("orientation",stu.getOrientation());
			stu.setOrientationStr(newSysDictionary.getDataDescription());
		}
		if(stu.getStudyState() != null){
			SysDictionary newSysDictionary = (SysDictionary) studentManager.getDictionary("studyState",stu.getStudyState());
			stu.setStudyStateStr(newSysDictionary.getDataDescription());
		}
	}
	
	public StudentManager getStudentManager() {
		return studentManager;
	}
	public void setStudentManager(StudentManager studentManager) {
		this.studentManager = studentManager;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	public List<Classes> getClassesList() {
		return classesList;
	}
	public void setClassesList(List<Classes> classesList) {
		this.classesList = classesList;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public ClassesManager getClassesManager() {
		return classesManager;
	}

	public void setClassesManager(ClassesManager classesManager) {
		this.classesManager = classesManager;
	}

	public TeacherManager getTeacherManager() {
		return teacherManager;
	}

	public void setTeacherManager(TeacherManager teacherManager) {
		this.teacherManager = teacherManager;
	}
	
	public DeptManager getDeptManager() {
		return deptManager;
	}

	public void setDeptManager(DeptManager deptManager) {
		this.deptManager = deptManager;
	}

	public List<SysDictionary> getStudyStateList() {
		return studyStateList;
	}

	public void setStudyStateList(List<SysDictionary> studyStateList) {
		this.studyStateList = studyStateList;
	}
	
	public List<Dept> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Dept> deptList) {
		this.deptList = deptList;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public List<SysDictionary> getOrientationList() {
		return orientationList;
	}

	public void setOrientationList(List<SysDictionary> orientationList) {
		this.orientationList = orientationList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public GradeManager getGradeManager() {
		return gradeManager;
	}

	public void setGradeManager(GradeManager gradeManager) {
		this.gradeManager = gradeManager;
	}

	public Student getQueryStudent() {
		return queryStudent;
	}

	public void setQueryStudent(Student queryStudent) {
		this.queryStudent = queryStudent;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<DegreeVo> getDegreeVoList() {
		return degreeVoList;
	}

	public void setDegreeVoList(List<DegreeVo> degreeVoList) {
		this.degreeVoList = degreeVoList;
	}
	
	
}
