/**
 * 2017��12��31��
 */
package com.qf.manager.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.qf.manager.dao.IEmployeeDao;
import com.qf.manager.pojo.Employee;
import com.qf.manager.service.IEmployeeService;
import com.qf.manager.utils.ObjectUtils;

/**
 * @author Administrator
 *2017��12��31��
 * 
 */
public class EmployeeService implements IEmployeeService{
	private static IEmployeeDao employeeDao=null;
	static{
		try {
			employeeDao=(IEmployeeDao) ObjectUtils.getObject("employeeDao");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void insertEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
	
			employeeDao.insertEmployee(employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		if (employee.geteId()!=null||employee.geteTelNum()!=null) {
			employeeDao.updateEmployee(employee);
		}else{
			System.out.println("id��绰���벻��Ϊ�գ�");
		}
	}

	@Override
	public void deleteEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		if (employee.geteId()!=null) {
			employeeDao.deleteEmployee(employee);
		}else{
			System.out.println("idΪ�գ�");
		}
	}

	@Override
	public Employee selectEmployee(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		if (id!=null) {
		return employeeDao.selectEmployee(id);
		}else{
			System.out.println("idΪ�գ�");
			return null;
		}
	
	}

	@Override
	public List<Employee> selectAllEmployee() throws SQLException {
		// TODO Auto-generated method stub
		return employeeDao.selectAllEmployee();
	}

	@Override
	public Employee selectEmployeeByName(String employeeName) throws SQLException {
		// TODO Auto-generated method stub
		return employeeDao.selectEmployeeByName(employeeName);
	}

}
