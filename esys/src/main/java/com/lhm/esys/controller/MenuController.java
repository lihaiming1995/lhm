/**
 * 
 */
package com.qfedu.esys.controller;
import java.util.List;



import javax.annotation.Resource;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qfedu.common.entity.WoResultCode;
import com.qfedu.esys.dto.MenuDto;
import com.qfedu.esys.entity.Menu;
import com.qfedu.esys.service.IMenuService;
import com.qfedu.esys.vo.MenuEuiVo;

/**
 * @author cailei
 *
 */
@RestController
@RequestMapping(value="sys/menu",produces="application/json")
public class MenuController {
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(MenuController.class);

	@Resource
	private IMenuService menuService;	
	@RequestMapping(value="/getChildren")
	public List<MenuEuiVo> getChildren(String id){
		System.out.println("执行查询！");
		List<Menu> menus=menuService.getChildren(id);	
		return MenuEuiVo.getVos(menus);
	}
	
	
	public MenuController() {
		// TODO Auto-generated constructor stub
	}
	@ResponseBody
	@RequestMapping(value="/list")
	public List<MenuDto> getList(String id){
		List<Menu> lists =menuService.getChildren(id);
		return MenuDto.getDtos(lists);
	}
	@ResponseBody
	@RequestMapping(value = "/create")
    public WoResultCode create (MenuDto m) {
		
    	return WoResultCode.getSuccessCode();
    }

	
}
