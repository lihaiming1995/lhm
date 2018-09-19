/**
 * 
 */
package com.qfedu.esys.service.impl;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.qfedu.common.util.WoUtil;
import com.qfedu.esys.dao.IMenuDao;
import com.qfedu.esys.dto.MenuDto;
import com.qfedu.esys.entity.Menu;
import com.qfedu.esys.service.IMenuService;

/**
 * @author cailei
 *
 */
@Service
@Transactional
public class MenuService implements IMenuService{
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(MenuService.class);

	@Resource
	private IMenuDao menuDao;
	public MenuService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Menu> getChildren(String id) {
		// TODO Auto-generated method stub
		return menuDao.getChildren(id);
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IMenuService#create(com.qfedu.esys.entity.Menu)
	 */


	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IMenuService#create(com.qfedu.esys.dto.MenuDto)
	 */
	@Override
	public void create(Menu menu) {
		menu.setId(WoUtil.uuid());
		menuDao.create(menu);
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IMenuService#findMenuDto()
	 */
	@Override
	public MenuDto findMenuDto() {
		// TODO Auto-generated method stub
		
		return null;
	}
	
}
