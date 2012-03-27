package com.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.dao.MenuDao;
import com.pojo.Admin;
import com.pojo.system.SysMenu;

public class MenuDaoImpl extends BaseDaoImpl implements MenuDao {

	public List<SysMenu> getMenuList() {
		String hql = "from SysMenu order by id";
		return this.findByHQL(hql);
	}
	
	@Override
	public Admin adminLogin(Admin bean) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Admin.class);
		criteria.add(Restrictions.eq("adminName", bean.getAdminName()));
		criteria.add(Restrictions.eq("password", bean.getPassword()));
		return (Admin) this.findByCriteria(criteria).get(0);
	}

	@Override
	public List<SysMenu> querySysMenuList() {
		String hql = "from SysMenu where parentMenuId is null order by id,menuIndex";
		return this.findByHQL(hql);
	}

	@Override
	public SysMenu getSysMenuByID(Integer sysMenuID) {
		DetachedCriteria criteria=DetachedCriteria.forClass(SysMenu.class);
		criteria.add(Restrictions.eq("id", sysMenuID));
		return (SysMenu) this.findByCriteria(criteria).get(0);
	}

	public List<SysMenu> getMenuList(String menuIDs) {
		String hql = "from SysMenu m where m.id in (" + menuIDs + ") order by menuindex asc";
		return getHibernateTemplate().find(hql);
	}

	@Override
	public List<SysMenu> getMenuListByParentID(Integer parentID) {
		String hql = "from SysMenu m where m.parentID in (" + parentID + ") order by menuindex asc";
		return getHibernateTemplate().find(hql);
	}
	
	

	
}
