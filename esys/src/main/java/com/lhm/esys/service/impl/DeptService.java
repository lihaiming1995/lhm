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

import com.qfedu.esys.dao.IDeptDao;
import com.qfedu.esys.entity.Dept;
import com.qfedu.esys.service.IDeptService;

/**
 * @author cailei
 *
 */
@Service
@Transactional
public class DeptService implements IDeptService{
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(DeptService.class);
	@Resource
	private IDeptDao deptDao;
	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IDeptService#createDept()
	 */
	@Override
	public void createDept(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.createDept(dept);
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IDeptService#deleteDept()
	 */
	@Override
	public void deleteDept(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.deleteDept(dept);
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IDeptService#findDeptById()
	 */
	@Override
	public Dept findDeptById(int id) {
		// TODO Auto-generated method stub
		return deptDao.findDeptById(id);
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IDeptService#findAllDept()
	 */
	@Override
	public List<Dept> findAllDept() {
		// TODO Auto-generated method stub	
		System.out.println(deptDao.findAllDept().toString());
		return deptDao.findAllDept();
	}
}
