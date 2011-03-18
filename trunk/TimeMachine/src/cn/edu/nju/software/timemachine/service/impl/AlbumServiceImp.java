package cn.edu.nju.software.timemachine.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.edu.nju.software.timemachine.entity.Album;
import cn.edu.nju.software.timemachine.service.IAlbumService;

@Service("albumService")
public class AlbumServiceImp<T extends Album> extends ServiceImpl<T> implements IAlbumService<T> {

	public List<Album> getAlbumList(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
