package com.yc.dao;

import java.util.List;
import java.util.Map;

import com.yc.bean.Person;

public interface BasicDao<T>  {
	//各种dao的查询接口
	 public List<T> findAll ( T t,String sqlId);
	 
	 public List<T> findAll(T t,Map map,String sqlId);
	 
	 //添加
	 public void add (T t,String sqlId);
	 
	 public void add (T t,Map map,String sqlId);
	 
	 public void add (T t,List list,String sqlId);
	 
	 //修改
	 public void update (T t,String sqlId);
	 
	 public void update (T t,Map map,String sqlId);
	 
	 public void update (T t,List list,String sqlId);
	 
	 //删除
	 public void delete (T t,String sqlId);
	 
	 public void delete (T t,Map map,String sqlId);
	 
	 public void delete (T t,List list,String sqlId);
	 
	 //数量
	 public double findFunc(T t,String sqlId);
	 
	 public double findFunc(T t,Map map,String sqlId);
	 
	 
}
