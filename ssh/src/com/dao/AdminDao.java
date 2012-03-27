package com.dao;

import com.pojo.Admin;

public interface AdminDao extends BaseDao {

	public Admin doLogin(String userName, String password);

	public Admin getAdminByID(Integer id);

}
