/**
 * 
 */
package com.qfedu.esys.dao.impl;
import java.util.List;


import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qfedu.esys.dao.IDictionaryDao;
import com.qfedu.esys.entity.Dictionary;

/**
 * @author cailei
 *
 */
@Repository
public class DictionaryDao implements IDictionaryDao{
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(DictionaryDao.class);
	@Resource
	private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IDictionaryService#getAllDictionary()
	 */
	@Override
	public List<Dictionary> getAllDictionary() {
		// TODO Auto-generated method stub
		String hql="from Dictionary dictionary";
		return sessionFactory.getCurrentSession().createQuery(hql,Dictionary.class).list();
	}
	/* (non-Javadoc)
	 * @see com.qfedu.esys.dao.IDictionaryDao#deleteDictionary()
	 */
	@Override
	public void deleteDictionary(Dictionary dictionary) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(dictionary);
	}
	/* (non-Javadoc)
	 * @see com.qfedu.esys.dao.IDictionaryDao#createDictionary()
	 */
	@Override
	public void createDictionary(Dictionary dictionary) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(dictionary);
	}
	/* (non-Javadoc)
	 * @see com.qfedu.esys.dao.IDictionaryDao#findDictionaryById(java.lang.String)
	 */
	@Override
	public Dictionary findDictionaryById(String id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Dictionary.class, id);
	}
	
	
	

}
