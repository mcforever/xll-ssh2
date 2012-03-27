package com.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.common.tools.Page;
import com.common.tools.util.DateUtil;
import com.common.tools.util.NumberUtil;
import com.pojo.Classes;
import com.pojo.Student;
import com.pojo.Teacher;
import com.service.ClassesManager;
import com.service.GradeManager;
import com.service.TeacherManager;

public class ClassesAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ClassesManager classesManager;
	private TeacherManager teacherManager;
	private GradeManager gradeManager; 
	
	private List<Classes> classesList;
	private List<Teacher> teacherList;
	
	private Classes classes;
	private Classes queryClasses;
	private Page page;
	
	private String option;
	private String msg;
	

	public String execute(){
		return SUCCESS;
	}
	
	public String queryClassesPage() {
		if(page == null){
			page = new Page();
		}
		page = classesManager.getClassesPage(page,queryClasses);
		List<Classes> result = page.getResult();
		for (Classes cla : result) {
			cla.setCreateDateStr(DateUtil.getStringDate(cla.getCreateDate()));
		}
		//获取导员列表
		teacherList = teacherManager.getTeacherByTeaPosition(0);
		return SUCCESS;
	}
	
	public String classesDetail(){
		classes = classesManager.getClassesByID(classes.getId());
		if(classes != null){
			this.setClassesStr(classes);
			Set<Student> set = classes.getStudentSet();
			Double classesAvgScore = 0.0;
			Double max = 0.0;
			Double min = 100.0;
			int count = 0;
			
			for (Student stu : set) {
				Map<String, Double> map = this.gradeManager.getStuAvgScore(stu.getId());
				if(map != null && map.get("stuavgscore") != 0.0){
					classesAvgScore += map.get("stuavgscore");
					if(max < map.get("stuavgscore")){
						max = map.get("stuavgscore");
					}
					if(min > map.get("stuavgscore")){
						min = map.get("stuavgscore");
					}
					count++;
				}
			}
			if(count != 0){
				classes.setAverageScore(NumberUtil.to2dec(classesAvgScore / count ,2));
			}
			classes.setMaxScore(NumberUtil.to2dec(max, 2));
			classes.setMinScore(NumberUtil.to2dec(min, 2));
			
		}
		
		return SUCCESS;
	}
	
	public String classesEdit(){
		if("add".equals(option)){
			classes = null;
			//获取导员列表
			teacherList = teacherManager.getTeacherByTeaPosition(0);
		}
		if("edit".equals(option)){
			classes = classesManager.getClassesByID(classes.getId());
			//获取导员列表
			teacherList = teacherManager.getTeacherByTeaPosition(0);
		}
		
		return SUCCESS;
	}
	
	public String classesSave(){
		try{
			this.classesManager.saveClasses(classes);
			msg = "1";
			return SUCCESS;
			
		} catch (Exception e){
			e.printStackTrace();
			msg = "2";
			return INPUT;
		}
	}
	
	public String classesDelete(){
		return SUCCESS;
	}
	
	public String compareClassesPage(){
		
		
		return SUCCESS;
	}
	
	/**
	 * 设置classes非关联字段
	 * @param cla
	 */
	private void setClassesStr(Classes cla){
		if(cla.getCreateDate() != null){
			cla.setCreateDateStr(DateUtil.getStringDate(cla.getCreateDate()));
		}
	}
	
	public ClassesManager getClassesManager() {
		return classesManager;
	}
	public void setClassesManager(ClassesManager classesManager) {
		this.classesManager = classesManager;
	}
	public List<Classes> getClassesList() {
		return classesList;
	}
	public void setClassesList(List<Classes> classesList) {
		this.classesList = classesList;
	}
	public List<Teacher> getTeacherList() {
		return teacherList;
	}
	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Classes getQueryClasses() {
		return queryClasses;
	}

	public void setQueryClasses(Classes queryClasses) {
		this.queryClasses = queryClasses;
	}
	
	
}
