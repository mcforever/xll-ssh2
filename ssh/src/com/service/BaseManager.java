package com.service;

import java.util.List;

public interface BaseManager {
	// 通用查询方法
    public List findByHQL(String hql);
    public List findByHQL(String hql,Object arg);
    public List findByHQL(String hql,Object[] args);
    public <T> List<T> getDictionary(String typeCode);
    public Object getDictionary( String typeCode, Integer dataID);
    public <T> List<T> getDictionary(String typeCode, String dataIDs);
}
