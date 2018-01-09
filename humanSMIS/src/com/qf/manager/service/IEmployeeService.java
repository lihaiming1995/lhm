/**
 * 2017年12月31日
 */
package com.qf.manager.service;

import java.sql.SQLException;
import java.util.List;

import com.qf.manager.pojo.Employee;

/**
 * @author Administrator
 *2017年12月31日
 * 
 */
public interface IEmployeeService {
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
	 * 通过名字查询员工	 
	 */
		 Employee selectEmployeeByName(String employeeName)throws SQLException;
}
