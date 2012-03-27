package com.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.dao.SysRoleDao;
import com.pojo.system.SysRole;

public class SysRoleDaoImpl  extends BaseDaoImpl implements SysRoleDao {

	@Override
	public SysRole getRoleById(Integer id) {
		DetachedCriteria criteria=DetachedCriteria.forClass(SysRole.class);
		criteria.add(Restrictions.eq("id", id));
		return (SysRole) this.findByCriteria(criteria).get(0);
	}
	
}
