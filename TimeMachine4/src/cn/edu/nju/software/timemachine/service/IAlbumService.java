package cn.edu.nju.software.timemachine.service;

import java.util.List;

import cn.edu.nju.software.timemachine.entity.Album;

public interface IAlbumService<T extends Album> extends IService<T> {
	
	/**
	 * 你可以在获取user实体后，使用user.getAlbumList(),当然也可以使用此处的函数<br>
	 * 注意如果出现任何的错误都将返回null，如用户id不存在
	 * @param 
	 * @return
	 */
	public List<T> getAlbumList(long userId);
	
	public boolean addAlbum(T album);
	
	public T getAlbum(String name,long userId);
	
	

}
