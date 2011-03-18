package cn.edu.nju.software.timemachine.service;

import java.util.List;

import cn.edu.nju.software.timemachine.entity.User;
import cn.edu.nju.software.timemachine.util.Constraint;

public interface IUserService<T extends User> extends IService<T> {
	
	public User getUser(long id);
	
	public User getUser(String email,String password);
	
	public List<User> searchUserByName(String name);
	
	public List<User> searchUserByEmail(String email);
	
	public List<User> serchUser(Constraint constraint);
	
}
