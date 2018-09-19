/**
 * 
 */
package com.qfedu.esys.dao.impl;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qfedu.esys.dao.IDeptDao;
import com.qfedu.esys.entity.Dept;

@Repository
public class DeptDao implements IDeptDao{
	@SuppressWarnings("unused")
	
	private final static Logger LOG = LogManager.getLogger(DeptDao.class);
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public void createDept(Dept dept) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(dept);
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.dao.IDeptDao#deleteDept()
	 */
	@Override
	public void deleteDept(Dept dept) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(dept);
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.dao.IDeptDao#findDeptById()
	 */
	@Override
	public Dept findDeptById(int id) {
		// TODO Auto-generated method stub
		/*String hql="from Dept dept where dept.id=:id";*/
		return sessionFactory.getCurrentSession().get(Dept.class,id);
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.dao.IDeptDao#findAllDept()
	 */
	@Override
	public List<Dept> findAllDept() {
		// TODO Auto-generated method stub
		String sql = "from Dept dept";
		List<Dept> depts = sessionFactory.getCurrentSession().createQuery(sql, Dept.class).list();
		return depts;
	}

	
	
}
