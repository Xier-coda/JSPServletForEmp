package com.bh.db;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBHelper {
	
	public static String DRIVER;
	public static String URL;
	public static String USERNAME;
	public static String USERPASS;
	public static ComboPooledDataSource ds;
	static{
		
		InputStream in=DBHelper.class.getClassLoader().getResourceAsStream("db.properties");
		Properties pro=new Properties();
		try {
			pro.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DRIVER=pro.getProperty("DRIVER");
		URL=pro.getProperty("URL");
		USERNAME=pro.getProperty("USERNAME");
		USERPASS=pro.getProperty("USERPASS");	
		//
		ds=new ComboPooledDataSource();
		try {
			ds.setDriverClass(DRIVER);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch blocwwwwwwwwwwwk
			e.printStackTrace();
		}
		ds.setJdbcUrl(URL);
		ds.setUser(USERNAME);
		ds.setPassword(USERPASS);
		ds.setInitialPoolSize(10);
		ds.setMaxPoolSize(100);
		ds.setAcquireIncrement(10);

	}

}
