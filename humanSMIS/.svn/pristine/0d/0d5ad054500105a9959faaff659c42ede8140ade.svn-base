package com.qf.manager.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qf.manager.dao.IDeptDao;
import com.qf.manager.pojo.Dept;
import com.qf.manager.utils.DbUtils;

public class DeptDao implements IDeptDao{

	 public DeptDao() {
		// TODO Auto-generated constructor stub	 
	}

	@Override
	public  void insertDept(Dept dept) throws SQLException {
		String sql="insert into t_dept(dName,dDes)values(?,?)";
		DbUtils.getObject().update(sql,dept.getdName(),dept.getdDes());
	}

	@Override
	public  void deleteDept(Dept dept) throws SQLException {
		// TODO Auto-generated method stub
		String sql="delete from t_dept where dId=?";
		DbUtils.getObject().update(sql,dept.getdId());
	}

	

	@Override
	public Dept selectDept(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select *from t_dept where dId=?";
		return	DbUtils.getObject().query(sql,new BeanHandler<Dept>(Dept.class),id);
		
	}

	@Override
	public void updateDept(Dept dept) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update t_dept set dName=?,dDes=? where dId=?";
		DbUtils.getObject().update(sql,dept.getdName(),dept.getdDes(),dept.getdId());
	}

	@Override
	public List<Dept> selectAllDept() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select *from t_dept";
		return DbUtils.getObject().query(sql, new BeanListHandler<Dept>(Dept.class));
	}
	
}
