/**
 * 2017��12��31��
 */
package com.qf.manager.service;

import java.sql.SQLException;
import java.util.List;

import com.qf.manager.pojo.User;

/**
 * @author Administrator
 *2017��12��31��
 * 
 */
public interface IUserSevice {
	/**
	 * ����û�
	 * @throws SQLException 
	 */
	public void insertUser(User user) throws SQLException;
	
	/**
	 * �޸��û�
	 */
	public  void updateUser(User user)throws SQLException;
	
	/**
	 * ͨ��idɾ���û�
	 */
	public  void deleteUser(User user)throws SQLException;
	
	/**
	 * ͨ�����ֲ�ѯ�û�
	 */
	public  User selectUser(User user)throws SQLException;

	/**
	 * ��ѯ�����û�
	 */
	public  List<User>selectUserALL()throws SQLException;
	
	/**
	 * ͨ��id��ѯ�û�
	 */
	public User selectUserById(Integer id)throws SQLException;
}
