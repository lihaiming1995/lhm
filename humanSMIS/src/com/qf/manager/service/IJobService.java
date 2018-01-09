/**
 * 2017年12月31日
 */
package com.qf.manager.service;

import java.sql.SQLException;
import java.util.List;

import com.qf.manager.pojo.Job;

/**
 * @author Administrator
 *2017年12月31日
 * 
 */
public interface IJobService {
	/**
	 * 添加职位
	 * @throws SQLException 
	 */
	 void insertJob(Job Job) throws SQLException;
	
	/**
	 * 删除职位
	 */
	 void deleteJob(Job Job) throws SQLException;
	
	/**
	 * 修改职位信息
	 */
	abstract void updateJob(Job Job) throws SQLException;
	/**
	 * 查询职位
	 */
	abstract Job selectJob(Integer id) throws SQLException;
	/**
	 * 查询所有职位
	 * @return
	 * @throws SQLException
	 */
	abstract List<Job> selectAllJob() throws SQLException;
}
