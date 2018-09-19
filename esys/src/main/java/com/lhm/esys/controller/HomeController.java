/**
 * 
 */
package com.qfedu.esys.controller;

import javax.annotation.Resource;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qfedu.common.entity.WoResultCode;
import com.qfedu.esys.entity.User;
import com.qfedu.esys.service.IMenuService;
import com.qfedu.esys.service.IUserService;

/**
 * @author cailei
 *
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {
	boolean woLogin=false;
	@Resource
	private IUserService userService;
	@Resource
	private IMenuService menuService;
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(HomeController.class);

	@RequestMapping(value = "/")
	public ModelAndView toMain(HttpServletRequest request) {
		String msg=" ";
		
		ModelAndView m = new ModelAndView();
		User user=(User) request.getSession().getAttribute("user");
		if (user!=null) {
			msg="欢迎您！"+user.getLoginName();
			woLogin=true;
		}
		m.addObject("woWelcomeMsg", msg);
		m.addObject("woLogin",woLogin);
		m.setViewName("main");
		return m;
		
	}
	@ResponseBody
	@RequestMapping(value = "authentication")
	public WoResultCode login(User user,HttpServletRequest request) {
		System.out.println(user.toString());
		User user2=userService.findUserByNameAndPwd(user);
		if (user2!=null) {
			System.out.println(user2.toString());
			request.getSession().setAttribute("user", user2);
			return WoResultCode.getSuccessCode();
		}else{
			System.out.println("没有此用户！");
			return WoResultCode.getUnknownCode();
		}
		
	}
	
}
