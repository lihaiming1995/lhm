/**
 * 2017年12月31日
 */
package com.qf.manager.service;

import java.sql.SQLException;
import java.util.List;

import com.qf.manager.pojo.User;

/**
 * @author Administrator
 *2017年12月31日
 * 
 */
public interface IUserSevice {
	/**
	 * 添加用户
	 * @throws SQLException 
	 */
	public void insertUser(User user) throws SQLException;
	
	/**
	 * 修改用户
	 */
	public  void updateUser(User user)throws SQLException;
	
	/**
	 * 通过id删除用户
	 */
	public  void deleteUser(User user)throws SQLException;
	
	/**
	 * 通过名字查询用户
	 */
	public  User selectUser(User user)throws SQLException;

	/**
	 * 查询所有用户
	 */
	public  List<User>selectUserALL()throws SQLException;
	
	/**
	 * 通过id查询用户
	 */
	public User selectUserById(Integer id)throws SQLException;
}
