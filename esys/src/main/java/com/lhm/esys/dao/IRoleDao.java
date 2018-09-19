/**
 * 
 */
package com.qfedu.esys.dao;

import java.util.List;

import com.qfedu.esys.entity.Role;

/**
 * @author cailei
 *
 */
public interface IRoleDao {
	
	List<Role> findAll();

	void create(Role role);
	
	Role findRoleById(String id);
	
	void delete(Role role);
	
	void update(Role role);
	
}
