package com.qf.manager.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qf.manager.dao.IUserDao;
import com.qf.manager.pojo.User;
import com.qf.manager.utils.DbUtils;


public class UserDao implements IUserDao {
	
	public UserDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertUser(User user) throws SQLException {
		String sql="insert into t_user(uName,uPwd,uLoginName,uState,uCreateTime) values (?,?,?,?,?)";
		DbUtils.getObject().update(sql,user.getuName(),user.getuPwd(),user.getuLoginName(),user.getuState(),new Date(System.currentTimeMillis()));
	}

	@Override
	public void updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update t_user set uName=?,uPwd=?,uLoginName=?,uState=? where uId=?";
		DbUtils.getObject().update(sql,user.getuName(),user.getuPwd(),user.getuLoginName(),user.getuState(),user.getuId());
	}

	@Override
	public void deleteUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql="delete from t_user where uId=?";
		DbUtils.getObject().update(sql, user.getuId());
	}

	@Override
	public User selectUser(User user) throws SQLException {
		
		String sql="select *from t_user where uLoginName=? and uPwd=?";
		return	DbUtils.getObject().query(sql, new BeanHandler<User>(User.class),user.getuLoginName(),user.getuPwd());
		  
		
		
	}

	@Override
	public List<User> selectUserALL() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select *from t_user";
		return DbUtils.getObject().query(sql,new BeanListHandler<User>(User.class));
		
	}

	@Override
	public User selectUserById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select *from t_user where uId=?";
		return	DbUtils.getObject().query(sql, new BeanHandler<User>(User.class),id);
	}

	

}
