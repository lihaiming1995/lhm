/**
 * 2017��12��31��
 */
package com.qf.manager.service;

import java.sql.SQLException;
import java.util.List;

import com.qf.manager.pojo.Dept;

/**
 * @author Administrator
 *2017��12��31��
 * 
 */
public interface IDeptService {
	/**
	 * ��Ӳ���
	 * @throws SQLException 
	 */
	 void insertDept(Dept dept) throws SQLException;
	
	/**
	 * ɾ������
	 */
	 void deleteDept(Dept dept)throws SQLException;
	
	/**
	 * �޸Ĳ���
	 */
	 void updateDept(Dept dept)throws SQLException;
	/**
	 * ��ѯ����
	 */
	 Dept selectDept(Integer id)throws SQLException;

	/**
	 * ��ѯ���в���
	 * @throws SQLException 
	 */
	 List<Dept> selectAllDept() throws SQLException;
}
