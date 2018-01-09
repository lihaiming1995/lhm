/**
 * 2017��12��31��
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
 *2017��12��31��
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
			System.out.println("�������Ʋ���Ϊ�գ�");
		}
		
		
	}

	@Override
	public void deleteDept(Dept dept) throws SQLException {
		// TODO Auto-generated method stub
		if(dept.getdId()!=null){
			deptdao.deleteDept(dept);
		}else{
			System.err.println("����id����Ϊ�գ�");
		}
		
	}

	@Override
	public void updateDept(Dept dept) throws SQLException {
		// TODO Auto-generated method stub
		if(dept.getdId()!=null){
			deptdao.updateDept(dept);
		}else{
			System.out.println("����id����Ϊ�գ�");
		}
	}

	@Override
	public Dept selectDept(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		if (id!=null) {
			return	deptdao.selectDept(id);
		}else{
			System.out.println("��ѯʧ�ܣ�idΪ�գ�");
			return null;
		}
		 
	}

	@Override
	public List<Dept> selectAllDept() throws SQLException {
		// TODO Auto-generated method stub
		
			return deptdao.selectAllDept();
		
			
	}

}
