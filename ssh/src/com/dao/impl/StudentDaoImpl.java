package com.dao.impl;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import oracle.jdbc.OracleTypes;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.dao.StudentDao;
import com.pojo.Student;
import com.vo.DegreeVo;

public class StudentDaoImpl extends BaseDaoImpl implements StudentDao {

	public Student doLogin(String username, String password) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Student.class);
		criteria.add(Restrictions.eq("studentName", username));
		criteria.add(Restrictions.eq("password", password));
		List list = this.findByCriteria(criteria);
		if(list.size() != 0){
			return (Student) list.get(0);
		}else{
			return null;
		}
	}

	public List<Student> findStudent(int start, int pageSize) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Student.class);
		return this.findByCriteria(criteria, start, pageSize);
	}
	
	public int getStudenttCount(Map paramMap) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Student.class);
		if(paramMap != null){
			Set<String> keySet = paramMap.keySet();
			for (String key : keySet) {
				criteria.add(Restrictions.eq(key, paramMap.get(key)));
			}
		}
		return this.findByCriteria(criteria).size();
	}

	@Override
	public Student getStudentBySName(String studentName) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Student.class);
		criteria.add(Restrictions.eq("studentName", studentName));
		List list = this.findByCriteria(criteria);
		if(list.size() != 0){
			return (Student) list.get(0);
		}
		return null;
	}

	@Override
	public Student getStudentByID(Integer id) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Student.class);
		criteria.add(Restrictions.eq("id", id));
		List list = this.findByCriteria(criteria);
		if(list.size() != 0){
			return (Student) list.get(0);
		}
		return null;
	}

	@Override
	public List<DegreeVo> countByYear() throws Exception {
		List<DegreeVo> degreeVoList = new ArrayList<DegreeVo>();
		org.hibernate.Session session = this.getSession();
		java.sql.Connection conn = null;
		ResultSet rs = null;
		CallableStatement cs = null;
		String procedure = "{call pro_yearcompare(?)}";
		try {
			
			conn = SessionFactoryUtils.getDataSource(getSessionFactory()).getConnection();
			cs = conn.prepareCall(procedure);
			
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			rs = (ResultSet) cs.getObject(1);
			while(rs.next()){
				DegreeVo bean = new DegreeVo();
				bean.setCreatYear(rs.getString("years"));
				bean.setAllNumber(rs.getInt("allCount"));
				bean.setDegreeNumber(rs.getInt("xuewei"));
				bean.setEducationLevelNumber(rs.getInt("xueli"));
				degreeVoList.add(bean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			rs.close();
			cs.close();
			conn.close();
			
		}
		
		
		return degreeVoList;
	}

}
