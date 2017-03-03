package com.yc.bean.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.yc.bean.Person;
import com.yc.dao.PersonDao;

public class PersonDaoImpl<T> extends SqlSessionDaoSupport implements PersonDao<T> {
	//拼接查询的id
	private String mapperLocation="com.yc.mapper.";

	//注入一个sqlsessionFactory，之后好从父类得到一个sqlsession
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public List<T> findAll(T t, String sqlId) {
		//通过父类的模板得到一个sqlsession
		// 获取类名	                       //mapper中的id号
		return super.getSqlSession().selectList(mapperLocation + t.getClass().getSimpleName() + "Mapper." + sqlId);
	}


}
