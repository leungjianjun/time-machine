package cn.edu.nju.software.timemachine.service;

public interface IService<T> {
	
	public boolean add(T baseEntity);
	
	public boolean delete(T baseEntity);
	
	public boolean update(T baseEntity);

}
