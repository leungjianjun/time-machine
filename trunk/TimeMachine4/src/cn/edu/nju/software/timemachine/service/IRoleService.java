package cn.edu.nju.software.timemachine.service;

import cn.edu.nju.software.timemachine.entity.Role;

public interface IRoleService<T extends Role> extends IService<T> {
	
	public boolean addRole(T role);

}
