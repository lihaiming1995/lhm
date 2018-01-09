package com.qf.manager.dao;

import java.sql.SQLException;
import java.util.List;

import com.qf.manager.pojo.Employee;

public interface IEmployeeDao {
	/**
	 * 添加员工
	 * @throws SQLException 
	 */
		 void insertEmployee(Employee employee) throws SQLException;
	/**
	 * 修改员工信息
	 */
		 void updateEmployee(Employee employee)throws SQLException;
	/**
	 * 删除员工
	 */
		 void deleteEmployee(Employee employee)throws SQLException;
	/**
	 * 查询员工
	 */
		 Employee selectEmployee(Integer id)throws SQLException;
	/**
	 * 查询所有员工
	 */
		 List<Employee> selectAllEmployee()throws SQLException;
	/**
	 * 根据姓名查询员工	 
	 */
		 Employee selectEmployeeByName(String employeeName)throws SQLException;
}
