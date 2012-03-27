package com.service;

import java.util.List;

import com.pojo.system.SysMenu;

public interface SysMenuManager extends BaseManager {

	/**
	 * query菜单表中的parentMenuId=0的菜单List
	 * @return
	 */
	public List<SysMenu> querySysMenuList();

	/**
	 * 根据ID获取Mune
	 * @param id
	 * @return
	 */
	public SysMenu getSysMenuByID(Integer sysMenuID);
	
	/**
     * 根据菜单ID获取
     * @param menuIDs  数据ID序列，格式如:"1,2,3,4"
     * @return
     */
	public List<SysMenu> getMenuList(String menuIDs);

	public List<SysMenu> getMenuListByParentID(Integer parentID);
}
