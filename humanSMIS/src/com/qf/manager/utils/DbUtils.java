package com.qf.manager.utils;

import java.beans.PropertyVetoException;


import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbUtils {
	private static ComboPooledDataSource dataSource;
	static {
		dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");

		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dataSource.setJdbcUrl("jdbc:mysql://120.79.17.133:3306/humanresources?useUnicode=true&characterEncoding=utf-8");
		dataSource.setUser("root");
		dataSource.setPassword("123456");

	}
	
	public ComboPooledDataSource getConnection(){
		return dataSource;
	}
	
	public static QueryRunner getObject(){		
		return new QueryRunner(dataSource);
	}
	
	
}
