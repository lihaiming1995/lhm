/**
 * 2017年12月31日
 */
package com.qf.manager.utils;

import java.io.IOException;


import java.util.Properties;

/**
 * @author Administrator 2017年12月31日
 * 
 */
public class ObjectUtils {

	private static Properties properties;

	static {
		properties = new Properties();

		try {
			properties.load(ObjectUtils.class.getClassLoader().getResourceAsStream("object.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Object getObject(String name)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println(properties.getProperty(name));
		Class<?> class1 = Class.forName(properties.getProperty(name));
		Object object = class1.newInstance();
		return object;

	}

}
