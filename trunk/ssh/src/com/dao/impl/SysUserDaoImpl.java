package com.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.dao.SysUserDao;
import com.pojo.SysUser;

public class SysUserDaoImpl extends BaseDaoImpl implements SysUserDao {

	@Override
	public SysUser userLogin(SysUser bean) {
		DetachedCriteria criteria=DetachedCriteria.forClass(SysUser.class);
		criteria.add(Restrictions.eq("userName", bean.getUserName()));
		criteria.add(Restrictions.eq("userLevel", bean.getUserLevel()));
		criteria.add(Restrictions.eq("password", bean.getPassword()));
		return (SysUser) this.findByCriteria(criteria).get(0);
	}

}
