package com.dao;

import com.pojo.system.SysRole;

public interface SysRoleDao extends BaseDao {

	/**
	 * 根据id查询SysRole
	 * @param id
	 * @return SysRole
	 */
	SysRole getRoleById(Integer id);

}
