/**
 * 
 */
package com.qfedu.esys.dao;

import java.util.List;

import com.qfedu.esys.entity.Dictionary;


public interface IDictionaryDao {
	List<Dictionary> getAllDictionary();
	
	void deleteDictionary(Dictionary dictionary);
	
	void createDictionary(Dictionary dictionary);
	
	Dictionary findDictionaryById(String id);
}
