package cn.edu.nju.software.timemachine.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.nju.software.timemachine.entity.User;
import cn.edu.nju.software.timemachine.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class UserServiceTest {
	
	@Autowired
	private IUserService<User> userSerivce;

	public void setUserSerivce(IUserService<User> userSerivce) {
		this.userSerivce = userSerivce;
	}

	public IUserService<User> getUserSerivce() {
		return userSerivce;
	}
	
	@Test
	public void nothingTest(){
		
	}
	

}
