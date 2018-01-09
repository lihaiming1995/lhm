package com.qf.manager.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qf.manager.dao.IEmployeeDao;
import com.qf.manager.pojo.Employee;
import com.qf.manager.utils.DbUtils;

public class EmployeeDao implements IEmployeeDao{

	public EmployeeDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into t_emp(dId,eId,eAddress,eCreateTime,eDes,eEmail,eGender,eQQNum,eName,ePostCode,eIdCard,eStu,etelNum)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		DbUtils.getObject().update(sql,employee.getdId(),employee.geteId(),employee.geteAddress(),new Date(System.currentTimeMillis()),employee.geteDes(),employee.geteEmail(),employee.geteGender(),employee.geteQQNum(),employee.geteName(),employee.getePostCode(),employee.geteIdCard(),employee.geteStu(),employee.geteTelNum());
	
	}

	@Override
	public void updateEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update t_emp set eName=?,eAddress=?,eCreateTime=?,eEmail=?,eGender=?,eTelNum=?,dId=?,jId=?,eStu=? where eId=?";
		DbUtils.getObject().update(sql,
				
				employee.geteName(),
				employee.geteAddress(),
				employee.geteCreateTime(),
				employee.geteEmail(),
				employee.geteGender(),
				employee.geteTelNum(),
				employee.getdId(),
				employee.getjId(),
				employee.geteStu(),
				employee.geteId()
				);
	}

	@Override
	public void deleteEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		String sql="delete from t_emp where eId=?";
		DbUtils.getObject().update(sql,employee.geteId());
	}

	@Override
	public Employee selectEmployee(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select *from t_emp where eId=?";
		return DbUtils.getObject().query(sql, new BeanHandler<Employee>(Employee.class),id);
	}

	@Override
	public List<Employee> selectAllEmployee() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select *from t_emp";
		return DbUtils.getObject().query(sql, new BeanListHandler<Employee>(Employee.class));
	}

	@Override
	public Employee selectEmployeeByName(String employeeName) throws SQLException {
		String sql="select *from t_emp where eName=?";
		return DbUtils.getObject().query(sql, new BeanHandler<Employee>(Employee.class),employeeName);

	}

	
	

}
