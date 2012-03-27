package com.pojo.system;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class SysMenu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String menuName;                                  //菜单名称
	private String url;                                       //url
	private Integer menuIndex;                                //菜单序号
	private Integer parentID;                                 //父级菜单ID
//	private SysMenu parent;                                   //父级菜单
//	private Set<SysMenu> childMenuSet;                        //子节点
	
	private List<SysMenu> childMenuList;                      //子节点
	
	public SysMenu() {
	}

	public SysMenu(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getMenuIndex() {
		return menuIndex;
	}
	public void setMenuIndex(Integer menuIndex) {
		this.menuIndex = menuIndex;
	}

//	public SysMenu getParent() {
//		return parent;
//	}
//
//	public void setParent(SysMenu parent) {
//		this.parent = parent;
//	}
//
//	public Set<SysMenu> getChildMenuSet() {
//		return childMenuSet;
//	}
//
//	public void setChildMenuSet(Set<SysMenu> childMenuSet) {
//		this.childMenuSet = childMenuSet;
//	}

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	public List<SysMenu> getChildMenuList() {
		return childMenuList;
	}

	public void setChildMenuList(List<SysMenu> childMenuList) {
		this.childMenuList = childMenuList;
	}
	
	

}
