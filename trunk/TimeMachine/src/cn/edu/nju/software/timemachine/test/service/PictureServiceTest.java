package cn.edu.nju.software.timemachine.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.nju.software.timemachine.entity.Picture;
import cn.edu.nju.software.timemachine.service.IPictureService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class PictureServiceTest {
	
	@Autowired
	private IPictureService<Picture> pictureService;

	public void setPictureService(IPictureService<Picture> pictureService) {
		this.pictureService = pictureService;
	}

	public IPictureService<Picture> getPictureService() {
		return pictureService;
	}
	
	@Test
	public void nothingTest(){
		
	}

}
