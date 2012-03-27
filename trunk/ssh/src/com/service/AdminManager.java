package com.service;

import com.pojo.Admin;

public interface AdminManager extends BaseManager {

	/**
	 * 管理员登录
	 * @param userName  用户名
	 * @param password  密码
	 * @return
	 */
	public Admin doLogin(String userName, String password);

	public Admin getAdminByID(Integer id);

	public void saveOrUpdateAdmin(Admin admin);

}
