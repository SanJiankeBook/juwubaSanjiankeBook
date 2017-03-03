package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.Person;
import com.yc.biz.PersonBiz;
import com.yc.dao.BasicDao;
@Service
public class PersonBizImpl implements PersonBiz {
	private BasicDao<Person> basidao;
	
	
	public BasicDao<Person> getBasidao() {
		return basidao;
	}

	@Resource(name ="basicDaoImpl")
	public void setBasidao(BasicDao<Person> basidao) {
		this.basidao = basidao;
	}


	@Override
	public List<Person> findAll() {
		Person p =new Person();
		return this.basidao.findAll(p, "findAll");
	}

}
