package com.yc.dao;

import java.util.List;


import com.yc.bean.Person;

public interface PersonDao<T>  {
	//各种dao的查询接口
	 public List<T> findAll ( T t,String sqlId);
	
}
