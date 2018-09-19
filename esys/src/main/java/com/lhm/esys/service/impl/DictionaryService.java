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

import com.qfedu.esys.dao.IDictionaryDao;
import com.qfedu.esys.entity.Dictionary;
import com.qfedu.esys.service.IDictionaryService;

/**
 * @author cailei
 *
 */
@Service
@Transactional
public class DictionaryService implements IDictionaryService {
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(DictionaryService.class);
	@Resource
	private IDictionaryDao dictionaryDao;
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qfedu.esys.service.IDictionaryService#getAllDictionary()
	 */

	@Override
	public List<Dictionary> getAllDictionary() {
		// TODO Auto-generated method stub
		return dictionaryDao.getAllDictionary();
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IDictionaryService#deleteDictionary()
	 */
	@Override
	public void deleteDictionary(Dictionary dictionary) {
		// TODO Auto-generated method stub
		dictionaryDao.deleteDictionary(dictionary);
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IDictionaryService#createDictionary()
	 */
	@Override
	public void createDictionary(Dictionary dictionary) {
		// TODO Auto-generated method stub
		dictionaryDao.createDictionary(dictionary);
	}

	/* (non-Javadoc)
	 * @see com.qfedu.esys.service.IDictionaryService#findDictionaryById(java.lang.String)
	 */
	@Override
	public Dictionary findDictionaryById(String id) {
		// TODO Auto-generated method stub
		return dictionaryDao.findDictionaryById(id);
	}
}
