/**
 * 
 */
package com.qfedu.esys.service;
import java.util.List;
import com.qfedu.esys.entity.Dictionary;

/**
 * @author cailei
 *
 */
public interface IDictionaryService {
	
	List<Dictionary> getAllDictionary();
	
	void deleteDictionary(Dictionary dictionary);
	
	void createDictionary(Dictionary dictionary);
	
	Dictionary findDictionaryById(String id);
}
