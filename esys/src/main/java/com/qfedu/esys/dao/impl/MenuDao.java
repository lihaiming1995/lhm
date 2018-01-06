
package com.qfedu.esys.dao.impl;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qfedu.esys.dao.IMenuDao;
import com.qfedu.esys.dto.MenuDto;
import com.qfedu.esys.entity.Menu;

/**
 * @author cailei
 *
 */
@Repository
public class MenuDao implements IMenuDao{
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(MenuDao.class);
	@Resource
	private SessionFactory sessionFactory; 
	public MenuDao() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public List<Menu> getChildren(String id) {

		if (id==null||"".equals(id)) {
			System.out.println("主菜单");
			String hql="from Menu m where m.parent.id is null";
			return sessionFactory.getCurrentSession().createQuery(hql,Menu.class).list();
			

		}else{

			String hql="from Menu menu where parent.id=:id";
			List<Menu> childmenus=sessionFactory.getCurrentSession().createQuery(hql,Menu.class).setParameter("id",id).list();
			System.out.println("标记");
			return childmenus;
		}
	
	}


	/* (non-Javadoc)
	 * @see com.qfedu.esys.dao.IMenuDao#create(com.qfedu.esys.dto.MenuDto)
	 */
	@Override
	public void create(Menu menu) {
		sessionFactory.getCurrentSession().persist(menu);
	}


	/* (non-Javadoc)
	 * @see com.qfedu.esys.dao.IMenuDao#getfindMenuDto()
	 */
	@Override
	public MenuDto getfindMenuDto() {
		return null;
		
	
	}
	
}
	
