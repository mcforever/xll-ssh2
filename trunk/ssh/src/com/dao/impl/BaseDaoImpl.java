package com.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.BaseDao;

public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao {
	
	public List<Object> listAll(Class clazz) {
		return getHibernateTemplate().loadAll(clazz);
	}

	public void saveOrUpdate(Object entity) throws DataAccessException {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	public void update(Object entity) throws DataAccessException {
		getHibernateTemplate().merge(entity);
	}

	public void delete(Class<?> clazz, Serializable id)
			throws DataAccessException {
		getHibernateTemplate().delete(get(clazz,id));
	}

	public Object get(Class<?> clazz, Serializable id) {
		return getHibernateTemplate().get(clazz, id);
	}

	// --基本查询方法
	public <T> List<T> findByHQL(String hsql) {
		return getHibernateTemplate().find(hsql);
	}
	
	public <T> List<T> findByHQL(String hsql, Object arg) {
		// 在oracle中，如果arg是null，会报错
		if (arg == null) {
			return new ArrayList();
		}
		return getHibernateTemplate().find(hsql, arg);
	}
	
	public <T> List<T> findByHQL(String hsql, Object[] args) {
		return getHibernateTemplate().find(hsql, args);
	}

	public <T> List<T> findByCriteria(DetachedCriteria criteria) {
		return getHibernateTemplate().findByCriteria(criteria);
	}

	public <T> List<T> findByCriteria(DetachedCriteria criteria,
			int firstResult, int maxResults) {
		return getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
	}

	public <T> List<T> findByExample(Object entity) {
		return getHibernateTemplate().findByExample(entity);
	}

	public <T> List<T> findByExample(Object entity, int firstResult,
			int maxResults) {
		return getHibernateTemplate().findByExample(entity, firstResult, maxResults);
	}


	public <T> List<T> getDictionary(String typeCode) {
		String hql = "from SysDictionary where dataTypeCode= ? order by dataID asc";
		List list = getHibernateTemplate().find(hql, typeCode);
		return list;
	}

	public Object getDictionary(String typeCode, Integer dataID) {
		String hql = "from SysDictionary where dataTypeCode= ? and dataID = ? order by dataID asc";
		List list = getHibernateTemplate().find(hql, new Object[] { typeCode, dataID });
		Object dic = null;
		if (list != null && list.size() > 0) {
			dic = list.get(0);
		}
		return dic;
	}

	public <T> List<T> getDictionary(String typeCode, String dataIDs) {
		String hql = "from SysDictionary where dataTypeCode= ? and dataID in (" + dataIDs
				+ ") order by dataID asc";
		return getHibernateTemplate().find(hql, typeCode);
	}

	@Override
	public List queryByPage(final String hql, final Map<String, Object> param , final int beginIndex, final int pageSize) {
		List list = new ArrayList<Object>();
		list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult(beginIndex);
				query.setMaxResults(pageSize);
				Set<String> key = param.keySet();
				for (Iterator it = key.iterator(); it.hasNext();) {
					String s = (String) it.next();
					query.setParameter(s, param.get(s));
				}
				return query.list();
			}
		});
		return list;
	}
	@Override
	public List queryByPage(final String hql, final int beginIndex, final int pageSize) {
		List list = new ArrayList<Object>();
		list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult(beginIndex);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
		return list;
	}

	@Override
	public int getResultCount(final String hql, final Map<String, Object> param) {
		int count = (Integer)this.getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				Set<String> key = param.keySet();
				for (Iterator it = key.iterator(); it.hasNext();) {
					String s = (String) it.next();
					query.setParameter(s, param.get(s));
				}
				return query.list().get(0);
			}
		});
		return count;
	}

	@Override
	public int getResultCount(final String hql) {
		Long count = (Long)this.getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				return query.list().get(0);
			}
		});
		return Integer.parseInt(count.toString());
	}

	@Override
	public List findPageByCriteria(Class clazz, Object obj, Map<String, Object> paramMap, String[] orders, int beginIndex, int pageSize) {
		List list = null;
		DetachedCriteria criteria=DetachedCriteria.forClass(clazz);
		if(obj != null){
			Example example = Example.create(obj);
		    example.enableLike(MatchMode.ANYWHERE);// 匹配模式,使用模糊查询必填项。
		    example.excludeNone();// 空的不做查询条件
		    example.excludeZeroes();// 0不要查询
		    example.ignoreCase(); // 不区分大小写
			criteria.add(example);

		}
		if(paramMap != null){
			Set<String> keySet = paramMap.keySet();
			for (String key : keySet) {
				criteria.add(Restrictions.eq(key, paramMap.get(key)));
			}
		}
		// 判断是否有排序请求，如果有加入到排序方法中
	   if (orders != null) {
		   for (int i = 0; i < orders.length; i++){
			   criteria.addOrder(Order.desc(orders[i]));
		   }
	   }
	   list = this.findByCriteria(criteria, beginIndex, pageSize);
	   return list;
	}

	@Override
	public int getResultCount(Class clazz, Map<String, Object> paramMap) {
		DetachedCriteria criteria=DetachedCriteria.forClass(clazz);
		if(paramMap != null){
			Set<String> keySet = paramMap.keySet();
			for (String key : keySet) {
				criteria.add(Restrictions.eq(key, paramMap.get(key)));
			}
		}
		return this.findByCriteria(criteria).size();
	}
	
	
}
