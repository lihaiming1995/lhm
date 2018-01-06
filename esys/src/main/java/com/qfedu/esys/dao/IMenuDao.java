/**
 * 
 */
package com.qfedu.esys.dao;
import java.util.List;

import com.qfedu.esys.dto.MenuDto;
import com.qfedu.esys.entity.Menu;

/**
 * @author cailei
 *
 */
public interface IMenuDao {
	
	List<Menu> getChildren(String id);
	void create(Menu menu);
	MenuDto getfindMenuDto();
}
