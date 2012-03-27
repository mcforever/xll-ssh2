package com.dao.impl;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.jdbc.OracleTypes;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.dao.GradeDao;
import com.pojo.Grade;

public class GradeDaoImpl extends BaseDaoImpl implements GradeDao {

	@Override
	public List<Grade> getStuScore(Integer stuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> getStuAvgScore(final Integer stuid) throws Exception{
		Map<String, Double> map = null;
//		StringBuffer sb = new StringBuffer();
//		sb.append("select studentid, stuallscore , stuallcredit , stuallscore / stuallcredit as stuavgscore from ");
//		sb.append("(select g.student.id as studentid, sum((g.midScore * 0.5 + g.finalScore * 0.5) * c.credit) as stuallscore , sum(c.credit) as stuallcredit , ");
//		sb.append("sum((g.midScore * 0.5 + g.finalScore * 0.5) * c.credit) / sum(c.credit) ");
//		sb.append("from Grade g ");
//		sb.append("left join Course c on c.id = g.course.id ");
//		sb.append(" where g.student.id = ");
//		sb.append(stuid);
//		sb.append("group by g.student.id )");
//		String hql = sb.toString();
		
//		this.getHibernateTemplate().execute(new HibernateCallback() {
//			
//			@Override
//			public Object doInHibernate(org.hibernate.Session session) throws HibernateException, SQLException {
//				SQLQuery sqlQuery = session.createSQLQuery("{call pro_stuavgscore(?,?,?,?)}");
//				sqlQuery.setInteger("stuid", stuid);
//				
//				return null;
//			}
//		});
		org.hibernate.Session session = this.getSession();
		java.sql.Connection conn = null;
		ResultSet rs = null;
		CallableStatement cs = null;
		String procedure = "{call pro_stuavgscore(?,?)}";
		try {
			
			conn = SessionFactoryUtils.getDataSource(getSessionFactory()).getConnection();
			cs = conn.prepareCall(procedure);
			cs.setInt(1, stuid);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			rs = (ResultSet) cs.getObject(2);
			if(rs.next()){
				map = new HashMap<String, Double>(); 
				map.put("stuavgscore", rs.getDouble("stuavgscore"));
				map.put("stuallscore", rs.getDouble("stuallscore"));
				map.put("stuallcredit", rs.getDouble("stuallcredit"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			rs.close();
			cs.close();
			conn.close();
			
		}
		
		
		return map;
	}

	@Override
	public Grade checkGrade(Integer studentid, Integer courseid) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Grade.class);
		criteria.add(Restrictions.eq("course.id", courseid));
		criteria.add(Restrictions.eq("student.id", studentid));
		List list = this.findByCriteria(criteria);
		if(list.size() != 0){
			return (Grade) list.get(0);
		}else{
			return null;
		}
	}

	/**
	 * 方法有问题，暂不使用
	 */
	public Grade checkGrade(Grade grade) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Grade.class);
		
		if(grade.getId() != null){
			criteria.add(Restrictions.eq("id", grade.getId()));
		}
		if(grade.getClass() != null && grade.getCourse().getId() != null){
			criteria.add(Restrictions.eq("course.id", grade.getCourse().getId()));
		}
		if(grade.getStudent() != null && grade.getStudent().getId() != null){
			criteria.add(Restrictions.eq("student.id", grade.getStudent().getId()));
		}
		
		List list = this.findByCriteria(criteria);
		if(list.size() != 0){
			return (Grade) list.get(0);
		}else{
			return null;
		}
	}

	/**
	 * 根据成绩ID查询
	 */
	public Grade getGradeById(Integer id) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Grade.class);
		criteria.add(Restrictions.eq("id", id));
		List list = this.findByCriteria(criteria);
		if(list.size() != 0){
			return (Grade) list.get(0);
		}else{
			return null;
		}
	}
	
}
