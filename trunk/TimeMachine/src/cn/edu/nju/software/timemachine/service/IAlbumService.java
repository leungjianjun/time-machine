package cn.edu.nju.software.timemachine.service;

import java.util.List;

import cn.edu.nju.software.timemachine.entity.Album;

public interface IAlbumService<T extends Album> extends IService<T> {
	
	/**
	 * 你可以在获取user实体后，使用user.getAlbumList(),当然也可以使用此处的函数
	 * @param id
	 * @return
	 */
	public List<Album> getAlbumList(long userId);
	
	

}
