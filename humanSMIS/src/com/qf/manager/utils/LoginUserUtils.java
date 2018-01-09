package com.qf.manager.utils;

import javax.servlet.http.HttpServletRequest;

import com.qf.manager.pojo.User;




/**
 * 用户的一个帮助类
 * @ClassName:  UserUtils   
 * @Description:TODO
 * @author: 千锋教育
 * @date:   2018年2月7日 上午10:02:02   
 *     
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved. 
 * 注意：做最真实的自己、用良心作教育
 */
public class LoginUserUtils {
    /**
     * 获取登陆用户的id
     * @Title: getLoginUserId   
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @param request      
     * @return: void      
     * @throws
     */
	public static Integer getLoginUserId(HttpServletRequest request){
		User loginUser=(User) request.getSession().getAttribute("user");
		return loginUser.getuId();
	}
	
	
}
