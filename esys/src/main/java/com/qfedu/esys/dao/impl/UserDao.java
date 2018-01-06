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
import com.qfedu.esys.dao.IUserDao;
import com.qfedu.esys.entity.User;

/**
 * @author cailei
 *
 */
@Repository
public class UserDao implements IUserDao {
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(UserDao.class);
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		String sql = "from User u";
		List<User> users = sessionFactory.getCurrentSession().createQuery(sql, User.class).list();
		return users;
	}

	
	@Override
	public void create(User u) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(u);

	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		
		/*String hql="from User u where u.id=:id";*/
		return sessionFactory.getCurrentSession().get(User.class,id);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(user);
	}


	/* (non-Javadoc)
	 * @see com.qfedu.esys.dao.IUserDao#findUserByNameAndPwd(com.qfedu.esys.entity.User)
	 */
	@Override
	public User findUserByNameAndPwd(User user){
		// TODO Auto-generated method stub
		User user2=new User();
		String hql="from User u where u.loginName=:loginName and password=:password";
		try {
			user2=sessionFactory.getCurrentSession().createQuery(hql,User.class)
			.setParameter("loginName", user.getLoginName()).setParameter("password", user.getPassword()).
			getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			user2=null;
		}
		return user2;	
	}


	/* (non-Javadoc)
	 * @see com.qfedu.esys.dao.IUserDao#update(com.qfedu.esys.entity.User)
	 */
	@Override
	public void update(User user) {
		sessionFactory.getCurrentSession().merge(user);
	}
}
