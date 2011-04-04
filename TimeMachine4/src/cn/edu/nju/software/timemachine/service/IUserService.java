package cn.edu.nju.software.timemachine.service;

import java.util.List;

import cn.edu.nju.software.timemachine.entity.User;
import cn.edu.nju.software.timemachine.util.Constraint;

public interface IUserService<T extends User> extends IService<T> {
	
	public boolean addUser(T user);
	
	public T getUser(long id);
	
	public T getUser(String email,String password);
	
	public List<T> searchUserByName(String name);
	
	public T searchUserByEmail(String email);
	
	public List<T> serchUser(Constraint constraint);
	
	public T getUser(String email);
	
	
}
