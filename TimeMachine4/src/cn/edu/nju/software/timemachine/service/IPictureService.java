package cn.edu.nju.software.timemachine.service;

import cn.edu.nju.software.timemachine.entity.Picture;

public interface IPictureService<T extends Picture> extends IService<T> {
	
	public long addPicture(T picture);
	
	public T getPicture(long id);
	
	

}
