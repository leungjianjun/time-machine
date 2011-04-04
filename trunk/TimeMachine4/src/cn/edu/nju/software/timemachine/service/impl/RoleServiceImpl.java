package cn.edu.nju.software.timemachine.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.nju.software.timemachine.entity.Role;
import cn.edu.nju.software.timemachine.service.IRoleService;

@Service("roleService")
@Transactional 
public class RoleServiceImpl<T extends Role> extends ServiceImpl<T> implements IRoleService<T> {

	/**
	 * role 的name不能重复
	 */
	public boolean addRole(T role) {
		if(dao.createQuery("from Role as role where role.name =:name")
				          .setParameter("name", role.getName()).uniqueResult()!=null){
			return false;
		}else{
			dao.create(role);
			return true;
		}
		
	}

}
