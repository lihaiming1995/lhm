package com.qf.manager.utils;

import javax.servlet.http.HttpServletRequest;

import com.qf.manager.pojo.User;




/**
 * �û���һ��������
 * @ClassName:  UserUtils   
 * @Description:TODO
 * @author: ǧ�����
 * @date:   2018��2��7�� ����10:02:02   
 *     
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved. 
 * ע�⣺������ʵ���Լ���������������
 */
public class LoginUserUtils {
    /**
     * ��ȡ��½�û���id
     * @Title: getLoginUserId   
     * @Description: TODO(������һ�仰�����������������)   
     * @param: @param request      
     * @return: void      
     * @throws
     */
	public static Integer getLoginUserId(HttpServletRequest request){
		User loginUser=(User) request.getSession().getAttribute("user");
		return loginUser.getuId();
	}
	
	
}
