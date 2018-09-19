/**
 * 
 */
package com.qfedu.esys.dao;
import java.util.List;

import com.qfedu.esys.entity.User;

public interface IUserDao {

	List<User> findAll();

	void create(User u);
	
	User findUserById(int id);
	
	void delete(User user);
	
	void update(User user);
	/**
	 * @param user
	 * @return
	 */
	User findUserByNameAndPwd(User user);
}
