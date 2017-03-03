package com.yc.bean.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.yc.bean.Person;
import com.yc.dao.BasicDao;

@Service
public class BasicDaoImpl<T> extends SqlSessionDaoSupport implements BasicDao<T> {
	//拼接查询的id
	private String mapperLocation="com.yc.mapper.";

	private String getMapperId(T t,String sqlId){
		// 获取类名	                       //mapper中的id号
		return mapperLocation + t.getClass().getSimpleName() + "Mapper." + sqlId;
	}
	//注入一个sqlsessionFactory，之后好从父类得到一个sqlsession
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public List<T> findAll(T t, String sqlId) {
		//通过父类的模板得到一个sqlsession
		return super.getSqlSession().selectList(this.getMapperId(t, sqlId));
	}

	@Override
	public List<T> findAll(T t, Map map, String sqlId) {
		
		return super.getSqlSession().selectList(this.getMapperId(t, sqlId),map);
	}

	@Override
	public void add(T t, String sqlId) {
		 super.getSqlSession().insert(this.getMapperId(t, sqlId),t);
		
	}

	@Override
	//传一个集合
	public void add(T t, Map map, String sqlId) {
		 super.getSqlSession().insert(this.getMapperId(t, sqlId),map);
		
	}

	@Override
	//要添加多条数据,mapper那边用foreach解决
	public void add(T t, List list, String sqlId) {
		 super.getSqlSession().insert(this.getMapperId(t, sqlId),list);
		
	}

	@Override
	public void update(T t, String sqlId) {
		 super.getSqlSession().update(this.getMapperId(t, sqlId),t);
		
	}

	@Override
	public void update(T t, Map map, String sqlId) {
		super.getSqlSession().update(this.getMapperId(t, sqlId),map);
	}

	@Override
	public void update(T t, List list, String sqlId) {
		super.getSqlSession().update(this.getMapperId(t, sqlId),list);
	}

	@Override
	public void delete(T t, String sqlId) {
		super.getSqlSession().delete(this.getMapperId(t, sqlId),t);
		
	}

	@Override
	public void delete(T t, Map map, String sqlId) {
		super.getSqlSession().delete(this.getMapperId(t, sqlId),map);
		
	}

	@Override
	public void delete(T t, List list, String sqlId) {
		super.getSqlSession().delete(this.getMapperId(t, sqlId),list);
	}
	@Override
	public double findFunc(T t, String sqlId) {
		return super.getSqlSession().selectOne(this.getMapperId(t, sqlId));
	}
	@Override
	public double findFunc(T t, Map map, String sqlId) {
		return super.getSqlSession().selectOne(this.getMapperId(t, sqlId),map);
	}



}
