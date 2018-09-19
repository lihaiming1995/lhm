/**
 * 
 */
package com.qfedu.esys.controller;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qfedu.esys.entity.Dictionary;
import com.qfedu.esys.service.IDictionaryService;
import com.qfedu.esys.util.ESysConstant;

/**
 * @author cailei
 *
 */
@RestController
@RequestMapping(value="/sys/dictionary/",produces = ESysConstant.APP_JSON)
public class DictionaryController {
	@Resource
	private IDictionaryService dictionaryService;
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(DictionaryController.class);

	@RequestMapping(value="/list")
	public List<Dictionary> getList(){
		System.out.println("输出数据字典！");
		return dictionaryService.getAllDictionary();
	}
	
	
	




}
