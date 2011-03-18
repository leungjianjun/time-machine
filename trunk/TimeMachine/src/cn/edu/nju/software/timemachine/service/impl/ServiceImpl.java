package cn.edu.nju.software.timemachine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.nju.software.timemachine.dao.IDao;
import cn.edu.nju.software.timemachine.entity.BaseEntity;
import cn.edu.nju.software.timemachine.service.IService;

@Service("baseService")
@Transactional
public class ServiceImpl<T extends BaseEntity> implements IService<T> {
	
	@Autowired
	protected IDao<T> dao;

	public boolean add(T baseEntity) {
		dao.create(baseEntity);
		return true;
	}

	public boolean delete(T baseEntity) {
		// TODO Auto-generated method stub
		dao.delete(baseEntity);
		return true;
	}

	public boolean update(T baseEntity) {
		// TODO Auto-generated method stub
		dao.save(baseEntity);
		return true;
	}

}
