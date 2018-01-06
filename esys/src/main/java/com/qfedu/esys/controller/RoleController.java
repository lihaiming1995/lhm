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
import org.springframework.web.servlet.ModelAndView;
import com.qfedu.common.entity.WoResultCode;
import com.qfedu.esys.entity.Role;
import com.qfedu.esys.service.IRoleService;
import com.qfedu.esys.vo.GridEuiVo;

/**
 * @author cailei
 *
 */
@RestController
@RequestMapping(value="/sys/role")
public class RoleController {
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(RoleController.class);
	@Resource
	private IRoleService roleService;
	
	@ResponseBody
	@RequestMapping(value="/list",produces="application/json")
	private GridEuiVo<Role> getList(){
		List<Role> roles=roleService.getList();
		GridEuiVo<Role> gridEuiVo=new GridEuiVo<Role>(Long.valueOf(roles.size()),roles);
		return gridEuiVo;
	}
	@RequestMapping(value="/crud")
	public ModelAndView toMain () {
		ModelAndView m = new ModelAndView();
		m.setViewName("role");
		return m;
	}
	@ResponseBody
	@RequestMapping(value="/create", produces = "application/json")
	public WoResultCode create (Role role) {
		roleService.create(role);
		return WoResultCode.getSuccessCode();
	}
	@ResponseBody
	@RequestMapping (value = "/delete", produces = "application/json")
	public WoResultCode delete (String id) {
		Role role= roleService.findRoleById(id);
		roleService.delete(role);
		return WoResultCode.getSuccessCode();
	}
	@ResponseBody
	@RequestMapping(value="/update",produces = "application/json")
	public WoResultCode update(Role role){
		System.out.println(role.toString());
		roleService.update(role);
		return WoResultCode.getSuccessCode();
	}

}
