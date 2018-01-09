/**
 * 2017年12月31日
 */
package com.qf.manager.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @author Administrator
 *2017年12月31日
 * 
 */
public class GetObjectUtils {
		
	/**
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * 
	 */
	public static <T>T getObject(HttpServletRequest request,Class<T> clazz) throws InstantiationException, IllegalAccessException, InvocationTargetException{
		
		T t=clazz.newInstance();
		BeanUtils.populate(t,request.getParameterMap());
		return t;
		
	}
}
