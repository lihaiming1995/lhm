/**
 * 
 */
package com.qfedu.esys.service;
import java.util.List;

import com.qfedu.esys.dto.MenuDto;
import com.qfedu.esys.entity.Menu;

/**
 * @author cailei
 *
 */
public interface IMenuService {

	List<Menu> getChildren(String id);
	void create(Menu menu);
	MenuDto findMenuDto();
	
}
