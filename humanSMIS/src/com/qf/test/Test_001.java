/**
 * 2018��1��8��
 */
package com.qf.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.qf.manager.utils.DbUtils;

/**
 * @author Administrator
 *2018��1��8��
 * 
 */
public class Test_001 {

	/**
	 * 
	 */
	public static void main(String[] args) {
		ComboPooledDataSource dataSource=new DbUtils().getConnection();
		System.out.println(dataSource);
	}

}
