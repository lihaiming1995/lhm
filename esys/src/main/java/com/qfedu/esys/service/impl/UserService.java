
package com.qfedu.esys.service.impl;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.qfedu.common.entity.WoResultCode;
import com.qfedu.esys.dao.IUserDao;
import com.qfedu.esys.entity.User;
import com.qfedu.esys.service.IUserService;

/**
 * @author cailei
 *
 */
@Service
@Transactional
public class UserService implements IUserService{
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(UserService.class);
	@Resource
	private IUserDao userDao;
	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IUserService#getList()
	 */
	@Override
	public List<User> getList() {
		// TODO Auto-generated method stub
		List<User> users= userDao.findAll();
		return users;
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IUserService#create(com.qfedu.esys.entity.User)
	 */
	@Override
	public void create(User u) {
		// TODO Auto-generated method stub
		if(u.getLoginName()!=null||!u.equals("")){
			userDao.create(u);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IUserService#delete(com.qfedu.esys.entity.User)
	 */
	@Override
	public void delete(User u) {
		// TODO Auto-generated method stub
		userDao.delete(u);
		
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IUserService#findUserById(int)
	 */
	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
			System.out.println("选中项id的值为"+id);
			return userDao.findUserById(id);
		
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IUserService#login()
	 */
	@Override
	public WoResultCode login() {
		// TODO Auto-generated method stub
		return WoResultCode.getSuccessCode();
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IUserService#findUserByNameAndPwd(com.qfedu.esys.entity.User)
	 */
	@Override
	public User findUserByNameAndPwd(User user) {
		// TODO Auto-generated method stub
		
		return userDao.findUserByNameAndPwd(user);
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IUserService#update(com.qfedu.esys.entity.User)
	 */
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}
}
