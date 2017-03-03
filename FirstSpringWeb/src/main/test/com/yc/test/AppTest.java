package com.yc.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;


import org.springframework.context.support.ClassPathXmlApplicationContext;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase {
	public AppTest(String testName){
		super(testName);
	}
	public static Test suite(){
		return new TestSuite(AppTest.class);
	}
	public void testApp() throws SQLException{
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		assertNotNull(ac.getBean("dataSource"));
		System.out.println(ac.getBean("dataSource"));
		DataSource ds=(DataSource) ac.getBean("dataSource");
		Connection con=ds.getConnection();
		System.out.println(con);
	}

}
