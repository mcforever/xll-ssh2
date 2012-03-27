package com.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.pojo.Admin;
import com.pojo.Student;
import com.pojo.SysUser;
import com.pojo.Teacher;
import com.pojo.system.SysMenu;
import com.pojo.system.SysRole;
import com.service.AdminManager;
import com.service.StudentManager;
import com.service.SysMenuManager;
import com.service.SysRoleManager;
import com.service.TeacherManager;

public class LoginAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SysMenuManager sysMenuManager;
	private SysRoleManager sysRoleManager; 
	private StudentManager studentManager;
	private TeacherManager teacherManager;
	private AdminManager adminManager;
	
	private List<SysMenu> moduleList;
	private SysMenu sysMenu;
	private SysRole sysRole;
	private Admin admin;
	private Student student;
	private Teacher teacher;
	private SysUser sysUser;
	private String msg;
	
	private String newPassword;
	
	
	public String doLoginAction(){
		String forward = "";
		if(sysUser.getUserLevel() == 1){
			forward = this.studentLogin(sysUser.getUserName(),sysUser.getPassword());
		}else if(sysUser.getUserLevel() == 2){
			forward = this.teacherLogin(sysUser.getUserName(),sysUser.getPassword());
		}else if(sysUser.getUserLevel() == 3){
			forward = this.adminLogin(sysUser.getUserName(),sysUser.getPassword());
		}
		
		return forward;
	}
	
	private String studentLogin(String userName, String password) {
		String forward = "";
		Student bean = studentManager.doLogin(userName, password);
		if(bean != null){
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("sessionUser", new SysUser(bean.getId(), bean.getStudentName(), 1, bean.getPassword()));
			session.put("sessionLevel", new Integer(0));
//			sysRole = sysRoleManager.getRoleById(1);
//			moduleList = sysMenuManager.querySysMenuList();
			forward = "success";
		}else{
			forward = "input";
		}
		return forward;
	}

	private String teacherLogin(String userName, String password) {
		String forward = "";
		Teacher bean = teacherManager.doLogin(userName, password);
		if(bean != null){
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("sessionUser", new SysUser(bean.getId(), bean.getTeacherName(), 2, bean.getPassword()));
//			sysRole = sysRoleManager.getRoleById(2);
//			moduleList = sysMenuManager.querySysMenuList();
			if(bean.getTposition() == 0){
				session.put("sessionLevel",new Integer(1));
			}
			if(bean.getTposition() == 1){
				session.put("sessionLevel",new Integer(2));
			}
			
			forward = "success";
		}else{
			forward = "input";
		}
		return forward;
	}

	
	private String adminLogin(String userName, String password) {
		String forward = "";
		Admin bean = adminManager.doLogin(userName, password);
		if(bean != null){
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("sessionUser", new SysUser(bean.getId(), bean.getAdminName(), 3, bean.getPassword()));
			session.put("sessionLevel",new Integer(3));
//			sysRole = sysRoleManager.getRoleById(4);
//			if(sysRole.getMenus().contains(",")){
//				List<SysMenu> menuList = sysMenuManager.getMenuList(sysRole.getMenus());
//				sysRole.setMenuList(menuList);
//			}
//			moduleList = sysMenuManager.querySysMenuList();
			forward = "success";
		}else{
			forward = "input";
		}
		return forward;
	}
	
	public String logoutAction() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("sessionUser");
		session.remove("sessionLevel");
		return SUCCESS;
	}
	
	public String queryMainMenu(){
		moduleList = sysMenuManager.querySysMenuList();
		return "success";
	}
	public String queryLeftMenu(){
		if(sysMenu == null){
			sysMenu = new SysMenu(1);
		}
		sysMenu = sysMenuManager.getSysMenuByID(sysMenu.getId());
		sysMenu.setChildMenuList(sysMenuManager.getMenuListByParentID(sysMenu.getId()));
		return "success";
	}
	

	public String modifyPassword(){
		return SUCCESS;
	}
	
	public String savePassword(){
		if(sysUser.getUserLevel() == 1){
			Student bean = this.studentManager.getStudentByID(sysUser.getId());
			bean.setPassword(newPassword);
			
			try {
				this.studentManager.saveStudent(bean);
				msg = "1";
				return SUCCESS;
			} catch (Exception e){
				e.printStackTrace();
				msg = "2";
				return INPUT;
			}
		}
		if(sysUser.getUserLevel() == 2){
			Teacher bean = this.teacherManager.getTeacherByID(sysUser.getId());
			bean.setPassword(newPassword);
			try {
				this.teacherManager.saveOrUpdateTeacher(bean);
				msg = "1";
				return SUCCESS;
			} catch (Exception e){
				e.printStackTrace();
				msg = "2";
				return INPUT;
			}
		}
		if(sysUser.getUserLevel() == 3){
			Admin bean = this.adminManager.getAdminByID(sysUser.getId());
			bean.setPassword(newPassword);
			try {
				this.adminManager.saveOrUpdateAdmin(bean);
				msg = "1";
				return SUCCESS;
			} catch (Exception e){
				e.printStackTrace();
				msg = "2";
				return INPUT;
			}
		}
		return SUCCESS;
	}
	
	public List<SysMenu> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<SysMenu> moduleList) {
		this.moduleList = moduleList;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public SysMenuManager getSysMenuManager() {
		return sysMenuManager;
	}

	public void setSysMenuManager(SysMenuManager sysMenuManager) {
		this.sysMenuManager = sysMenuManager;
	}

	public SysRoleManager getSysRoleManager() {
		return sysRoleManager;
	}

	public void setSysRoleManager(SysRoleManager sysRoleManager) {
		this.sysRoleManager = sysRoleManager;
	}

	public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public StudentManager getStudentManager() {
		return studentManager;
	}

	public void setStudentManager(StudentManager studentManager) {
		this.studentManager = studentManager;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public TeacherManager getTeacherManager() {
		return teacherManager;
	}

	public void setTeacherManager(TeacherManager teacherManager) {
		this.teacherManager = teacherManager;
	}

	public AdminManager getAdminManager() {
		return adminManager;
	}

	public void setAdminManager(AdminManager adminManager) {
		this.adminManager = adminManager;
	}

	public SysMenu getSysMenu() {
		return sysMenu;
	}

	public void setSysMenu(SysMenu sysMenu) {
		this.sysMenu = sysMenu;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	
//	public String leftMenuAction(SysMenu bean){
//		if(bean != null && bean != null){
//			SysMenu tempSysMenu = loginManager.querySysMenuByID(bean);
//		}
//		return "success";
//	}
}
