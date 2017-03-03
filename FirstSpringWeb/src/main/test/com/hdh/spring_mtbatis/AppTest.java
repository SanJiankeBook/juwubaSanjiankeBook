package com.hdh.spring_mtbatis;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.bean.Person;
import com.yc.biz.PersonBiz;
import com.yc.dao.BasicDao;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
extends TestCase
{
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest( String testName )
	{
		super( testName );
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( AppTest.class );
	}

	/**
	 * Rigourous Test :-)
	 * @throws SQLException 
	 */
	public void testDataSource() throws SQLException
	{
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		assertNotNull(ac.getBean("dataSource"));
		System.out.println(ac.getBean("dataSource"));

		DataSource ds=(DataSource) ac.getBean("dataSource");
		Connection con=ds.getConnection();
		System.out.println(con);
	}
	public void testSqlSessionFactory() throws SQLException
	{
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		assertNotNull(ac.getBean("sqlSessionFactory"));
		System.out.println(ac.getBean("sqlSessionFactory"));

		SqlSessionFactory ds=(SqlSessionFactory) ac.getBean("sqlSessionFactory");
		System.out.println(ds);
	}
	
	public void testbasicDaoMybatisImpl() throws SQLException
	{
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		assertNotNull(ac.getBean("basicDaoImpl"));
		Person p=new Person();

		BasicDao<Person> pd=(BasicDao<Person>) ac.getBean("basicDaoImpl");
		List<Person> list=pd.findAll(p, "find");
		for( Person ps:list){
			System.out.println(ps);
		}
	}
	public void testCache() throws SQLException
	{
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		assertNotNull(ac.getBean("basicDaoImpl"));

		Person p=new Person();

		BasicDao<Person> pd=(BasicDao<Person>) ac.getBean("basicDaoImpl");
		List<Person> list=pd.findAll(p, "find");
		for( Person ps:list){
			System.out.println(ps);
		}
		list=pd.findAll(p, "find");
		for( Person ps:list){
			System.out.println(ps);
		}
	}
	public void test1() throws SQLException
	{
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		Person p=new Person();
		BasicDao<Person> pd=(BasicDao<Person>) ac.getBean("basicDaoImpl");
		double num=pd.findFunc(p, "findCount");
		System.out.println(num);
	}
	public void test2() throws SQLException
	{
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		Map <String,Integer> map=new HashMap<String,Integer>();
		map.put("start", 0);
		map.put("end", 9);
		Person p=new Person();
		BasicDao<Person> pd=(BasicDao<Person>) ac.getBean("basicDaoImpl");
		List<Person> list=pd.findAll(p, map,"findByPage");
		System.out.println(list);
	}
	
	public void test3() throws SQLException
	{
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		Map <String,Integer> map=new HashMap<String,Integer>();
		map.put("typeid",1);
		Person p=new Person();
		p.setTypeid(2);
		BasicDao<Person> pd=(BasicDao<Person>) ac.getBean("basicDaoImpl");
		pd.delete(p, "delete1");
		pd.delete(p,map, "delete2");
	
	}
	public void test4() throws SQLException
	{
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");

		PersonBiz pd=(PersonBiz) ac.getBean("personBizImpl");
		List<Person> list=pd.findAll();
		for( Person ps:list){
			System.out.println(ps);
		}
	}
}
