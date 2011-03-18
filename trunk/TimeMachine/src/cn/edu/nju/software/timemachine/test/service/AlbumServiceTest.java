package cn.edu.nju.software.timemachine.test.service;

import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

import cn.edu.nju.software.timemachine.entity.Album;
import cn.edu.nju.software.timemachine.service.IAlbumService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class AlbumServiceTest {
	
	@Autowired  
	private IAlbumService<Album> albumService;

	public void setAlbumService(IAlbumService<Album> albumService) {
		this.albumService = albumService;
	}

	public IAlbumService<Album> getAlbumService() {
		return albumService;
	}
	
	@Test
	public void nothingTest(){
		
	}
	
}