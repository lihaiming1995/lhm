/**
 * 2017��12��31��
 */
package com.qf.manager.service;

import java.sql.SQLException;
import java.util.List;

import com.qf.manager.pojo.Employee;

/**
 * @author Administrator
 *2017��12��31��
 * 
 */
public interface IEmployeeService {
	/**
	 * ���Ա��
	 * @throws SQLException 
	 */
		 void insertEmployee(Employee employee) throws SQLException;
	/**
	 * �޸�Ա����Ϣ
	 */
		 void updateEmployee(Employee employee)throws SQLException;
	/**
	 * ɾ��Ա��
	 */
		 void deleteEmployee(Employee employee)throws SQLException;
	/**
	 * ��ѯԱ��
	 */
		 Employee selectEmployee(Integer id)throws SQLException;
	/**
	 * ��ѯ����Ա��
	 */
		 List<Employee> selectAllEmployee()throws SQLException;
	/**
	 * ͨ�����ֲ�ѯԱ��	 
	 */
		 Employee selectEmployeeByName(String employeeName)throws SQLException;
}
