/**
 * 
 */
package com.qfedu.esys.service;
import java.util.List;


import com.qfedu.esys.entity.Role;

/**
 * @author cailei
 *
 */

public interface IRoleService {
	
List<Role> getList();
	
	void create(Role role);

	Role findRoleById(String id);
	void delete(Role role);
	
	void update(Role role);
	
	
}
