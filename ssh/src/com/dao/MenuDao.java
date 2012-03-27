package com.dao;

import java.util.List;

import com.pojo.Admin;
import com.pojo.system.SysMenu;

public interface MenuDao extends BaseDao {

	public List<SysMenu> getMenuList();

	public Admin adminLogin(Admin bean);

	/**
	 * parentMenuId is null
	 * @return
	 */
	public List<SysMenu> querySysMenuList();

	public SysMenu getSysMenuByID(Integer sysMenuID);
	
	/**
     * 根据菜单ID获取
     * @param menuIDs  数据ID序列，格式如:"1,2,3,4"
     * @return
     */
	public List getMenuList(String menuIDs);
	
	public List<SysMenu> getMenuListByParentID(Integer parentID);
	
}
