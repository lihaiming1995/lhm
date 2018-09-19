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

import com.qfedu.esys.dao.IRoleDao;
import com.qfedu.esys.entity.Role;
import com.qfedu.esys.entity.User;

/**
 * @author cailei
 *
 */
@Repository
public class RoleDao implements IRoleDao{
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(RoleDao.class);
@Resource
private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.qfedu.esys.dao.IRoleDao#findAll()
	 */
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		String sql = "from Role role";
		List<Role> roles = sessionFactory.getCurrentSession().createQuery(sql, Role.class).list();
		return roles;
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.dao.IRoleDao#create(com.qfedu.esys.entity.Role)
	 */
	@Override
	public void create(Role role) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(role);
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.dao.IRoleDao#findRoleById(int)
	 */
	@Override
	public Role findRoleById(String id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Role.class,id);
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.dao.IRoleDao#delete(com.qfedu.esys.entity.Role)
	 */
	@Override
	public void delete(Role role) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(role);
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.dao.IRoleDao#update(com.qfedu.esys.entity.Role)
	 */
	@Override
	public void update(Role role) {
		
		sessionFactory.getCurrentSession().merge(role);
	}
}
