/**
 * 2018年1月3日
 */
package com.qfedu.esys.controller;

import java.util.List;


import javax.annotation.Resource;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qfedu.common.entity.WoResultCode;
import com.qfedu.esys.entity.User;
import com.qfedu.esys.service.IUserService;
import com.qfedu.esys.vo.GridEuiVo;

/**
 * @author Administrator
 *2018年1月3日
 * 
 */
@Controller
@RequestMapping("/sys/user")
public class UserController {
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(UserController.class);
	@Resource
	private IUserService userService;
	public UserController() {
		
	}
	@ResponseBody
	@RequestMapping(value="/list",produces="application/json")
	private GridEuiVo<User> getList(){
		List<User> users=userService.getList();
		GridEuiVo<User> gridEuiVo=new GridEuiVo<User>(Long.valueOf(users.size()),users);
		return gridEuiVo;
	}
	@RequestMapping(value="/crud")
	public ModelAndView toMain () {
		ModelAndView m = new ModelAndView();
		m.setViewName("user");
		return m;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/create", produces = "application/json")
	public WoResultCode create (User u) {
		userService.create(u);
		return WoResultCode.getSuccessCode();
	}
	@ResponseBody
	@RequestMapping (value = "/delete", produces = "application/json")
	public WoResultCode delete (int id) {
		User user= userService.findUserById(id);
		userService.delete(user);
		return WoResultCode.getSuccessCode();
	}
	@ResponseBody
	@RequestMapping(value="/update",produces = "application/json")
	public WoResultCode update(User user){
		return WoResultCode.getSuccessCode();
		
			
		
	}
}
