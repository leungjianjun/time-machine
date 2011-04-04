package cn.edu.nju.software.timemachine.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.nju.software.timemachine.entity.Album;
import cn.edu.nju.software.timemachine.service.IAlbumService;

@Service("albumService")
@Transactional
@SuppressWarnings("unchecked")
public class AlbumServiceImp<T extends Album> extends ServiceImpl<T> implements IAlbumService<T> {

	public List<T> getAlbumList(long userId) {
		return (List<T>)dao.createQuery("from Album as album where album.owner.id = :id")
		                  .setParameter("id", userId).list();
	}

	/**
	 * 由于album的的文件夹以album命名的，所以album的名字不能重复，<br>
	 * 当然这个方法只要返回boolean，检查album是否有重命名的方法已在这函数中
	 */
	public boolean addAlbum(T album) {
		if((dao.createQuery("from Album as album where album.name = :name")
		               .setParameter("name", album.getName()).uniqueResult() != null) || //判断命名是否重复
		               (album.getName()==null) ||
		               (album.getOwner()==null)){
			return false;
		}else{
			dao.create(album);
			return true;
		}
	}

	public T getAlbum(String name,long userId) {
		return (T) dao.createQuery("from Album as album where album.name = :name and album.owner.id = :id")
		               .setParameter("name", name).setParameter("id", userId).uniqueResult();
	}

}
