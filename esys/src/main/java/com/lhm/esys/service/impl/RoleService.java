/**
 * 
 */
package com.qfedu.esys.service.impl;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.qfedu.esys.dao.IRoleDao;
import com.qfedu.esys.entity.Role;
import com.qfedu.esys.service.IRoleService;

/**
 * @author cailei
 *
 */
@Service
@Transactional
public class RoleService implements IRoleService{
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(RoleService.class);
	@Resource
	private IRoleDao roleDao;
	
	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IRoleService#getList()
	 */
	@Override
	public List<Role> getList() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IRoleService#create(com.qfedu.esys.entity.Role)
	 */
	@Override
	public void create(Role role) {
		// TODO Auto-generated method stub
		roleDao.create(role);
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IRoleService#findRoleById(int)
	 */
	@Override
	public Role findRoleById(String id) {
		// TODO Auto-generated method stub
		return roleDao.findRoleById(id);
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IRoleService#delete(com.qfedu.esys.entity.Role)
	 */
	@Override
	public void delete(Role role) {
		// TODO Auto-generated method stub
		roleDao.delete(role);
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IRoleService#update(com.qfedu.esys.entity.Role)
	 */
	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
		roleDao.update(role);
	}
}
