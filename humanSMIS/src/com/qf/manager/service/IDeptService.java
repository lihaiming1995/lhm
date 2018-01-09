/**
 * 2017年12月31日
 */
package com.qf.manager.service;

import java.sql.SQLException;
import java.util.List;

import com.qf.manager.pojo.Dept;

/**
 * @author Administrator
 *2017年12月31日
 * 
 */
public interface IDeptService {
	/**
	 * 添加部门
	 * @throws SQLException 
	 */
	 void insertDept(Dept dept) throws SQLException;
	
	/**
	 * 删除部门
	 */
	 void deleteDept(Dept dept)throws SQLException;
	
	/**
	 * 修改部门
	 */
	 void updateDept(Dept dept)throws SQLException;
	/**
	 * 查询部门
	 */
	 Dept selectDept(Integer id)throws SQLException;

	/**
	 * 查询所有部门
	 * @throws SQLException 
	 */
	 List<Dept> selectAllDept() throws SQLException;
}
