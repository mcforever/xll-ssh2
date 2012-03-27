package com.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;

public interface BaseDao {
	public void saveOrUpdate(Object entity) throws DataAccessException;
	
	public void update(Object entity) throws DataAccessException;
	
	public void delete(Class<?> clazz,Serializable id) throws DataAccessException;
	
	public Object get(Class<?> clazz,Serializable id);
	
	public <T> List<T> findByHQL(String hql);
	
	public <T> List<T> findByHQL(String hql,Object arg);
	
	public <T> List<T> findByHQL(String hql,Object[] arg);
	
	public <T> List<T> findByCriteria(DetachedCriteria criteria);
	
	public <T> List<T> findByCriteria(DetachedCriteria criteria,int firstResult,int maxResults);
	
	public <T> List<T> findByExample(Object entity);
	
	public <T> List<T> findByExample(Object entity,int firstResult,int maxResults);
	
	public int getResultCount(Class clazz,Map<String, Object> paramMap);
	
	/**
	  * 根据类型码获得数据字典列表
	  * @param typeCode 类型码
	  * @return
	  */
	public <T> List<T> getDictionary(String typeCode);
	    
	/**
	  * 根据类型码和数据ID获得数据字典列表
	  * @param typeCode 类型码
	  * @param dataID 数据ID
	  * @return
	  */
	public Object getDictionary( String typeCode, Integer dataID);
	
    /**
     * 根据类型码和数据ID序列获得数据字典列表
     * @param typeCode 类型码
     * @param dataIDs 数据ID序列，格式如:"1,2,3,4"
     * @return
     */
    public <T> List<T> getDictionary(String typeCode, String dataIDs);
    
    public int getResultCount(final String hql, final Map<String, Object> param);
    
    public int getResultCount(final String hql);
   
    public List queryByPage(final String hql, final Map<String, Object> param, final int beginIndex, final int pageSize);
    
    public List queryByPage(final String hql, final int beginIndex, final int pageSize);
    
    /**
     * 
     * @param clazz 查询的类
     * @param obj查询的对象
     * @param orders按那个字段排序
     * @param beginIndex开始数
     * @param pageSize每页大小
     * @return
     */
    public List findPageByCriteria(Class clazz, Object obj, Map<String, Object> paramMap, String[] orders , int beginIndex, int pageSize);

   
}
