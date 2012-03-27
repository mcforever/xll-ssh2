package com.service;

import com.pojo.system.SysRole;

public interface SysRoleManager extends BaseManager {

	/**
	 * 根据id查询SysRole
	 * @param id
	 * @return SysRole
	 */
	public SysRole getRoleById(Integer id);

}
