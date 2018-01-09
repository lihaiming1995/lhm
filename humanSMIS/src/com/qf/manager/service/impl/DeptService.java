/**
 * 2017年12月31日
 */
package com.qf.manager.service.impl;
import java.sql.SQLException;
import java.util.List;
import com.qf.manager.dao.impl.DeptDao;
import com.qf.manager.pojo.Dept;
import com.qf.manager.service.IDeptService;
import com.qf.manager.utils.ObjectUtils;

/**
 * @author Administrator
 *2017年12月31日
 * 
 */
public class DeptService implements IDeptService{
	private static DeptDao deptdao=null;
	static{
		try {
//			deptdao=DeptDao.class.newInstance();
		deptdao=(DeptDao) ObjectUtils.getObject("deptDao");
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void insertDept(Dept dept) throws SQLException {
		// TODO Auto-generated method stub
		if(dept.getdName()!=null){
			deptdao.insertDept(dept);
		}else{
			System.out.println("部门名称不能为空！");
		}
		
		
	}

	@Override
	public void deleteDept(Dept dept) throws SQLException {
		// TODO Auto-generated method stub
		if(dept.getdId()!=null){
			deptdao.deleteDept(dept);
		}else{
			System.err.println("部门id不能为空！");
		}
		
	}

	@Override
	public void updateDept(Dept dept) throws SQLException {
		// TODO Auto-generated method stub
		if(dept.getdId()!=null){
			deptdao.updateDept(dept);
		}else{
			System.out.println("部门id不能为空！");
		}
	}

	@Override
	public Dept selectDept(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		if (id!=null) {
			return	deptdao.selectDept(id);
		}else{
			System.out.println("查询失败，id为空！");
			return null;
		}
		 
	}

	@Override
	public List<Dept> selectAllDept() throws SQLException {
		// TODO Auto-generated method stub
		
			return deptdao.selectAllDept();
		
			
	}

}
