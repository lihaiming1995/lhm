/**
 * 
 */
package com.qfedu.esys.service;
import java.util.List;


import com.qfedu.common.entity.WoResultCode;
import com.qfedu.esys.entity.User;

/**
 * @author cailei
 *
 */
public interface IUserService {
	List<User> getList();
	
	void create(User u);

	User findUserById(int id);
	void delete(User u);
	
	void update(User user);
	/**
	 * 
	 */
	WoResultCode login();

	/**
	 * @param user
	 * @return
	 */
	User findUserByNameAndPwd(User user);
}
