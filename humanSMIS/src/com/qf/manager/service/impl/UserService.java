/**
 * 2017年12月31日
 */
package com.qf.manager.service.impl;
import java.sql.SQLException;

import java.util.List;
import com.qf.manager.dao.impl.UserDao;
import com.qf.manager.pojo.User;
import com.qf.manager.service.IUserSevice;
import com.qf.manager.utils.ObjectUtils;

/**
 * @author Administrator
 *2017年12月31日
 * 
 */
public class UserService implements IUserSevice{
	private static UserDao userdao=null;
	static{
		try {
			userdao=(UserDao) ObjectUtils.getObject("userDao");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public  void insertUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		if(user!=null&&user.getuName()!=null&&user.getuLoginName()!=null&&user.getuLoginName()!=null){
			userdao.insertUser(user);
		}else{
			System.out.println("参数错误,登录名和密码不能为空！");
		}
		
	}

	@Override
	public void updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		if(user.getuId()!=null){
			userdao.updateUser(user);
		}else{
			System.out.println("id为空！");
		}
		
	}

	

	@Override
	public User selectUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		if(user.getuLoginName()!=null&&user.getuPwd()!=null){
			return userdao.selectUser(user);
		}else{
			System.out.println("密码或登录名不能为空！");
			return null;
		}
		
	}

	@Override
	public List<User> selectUserALL() throws SQLException {
		// TODO Auto-generated method stub
		return userdao.selectUserALL();
	}

	@Override
	public void deleteUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		if(user.getuId()!=null){
			userdao.deleteUser(user);
		}else{
			System.out.println("id为空！");
		}
	}

	@Override
	public User selectUserById(Integer id) throws SQLException {
		if (id!=null) {
			return userdao.selectUserById(id);
		}else{
			System.out.println("未选中目标，id为空！");
			return null;
		}
		
		
	}

}
