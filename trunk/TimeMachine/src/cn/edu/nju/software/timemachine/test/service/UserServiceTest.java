package cn.edu.nju.software.timemachine.test.service;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import cn.edu.nju.software.timemachine.entity.User;
import cn.edu.nju.software.timemachine.service.IUserService;

@RunWith(SpringJUnit45ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class UserServiceTest {
	
	@Autowired
	private IUserService<User> userService;

	public void setUserSerivce(IUserService<User> userSerivce) {
		this.userService = userSerivce;
	}

	public IUserService<User> getUserSerivce() {
		return userService;
	}
	
	@Test
	public void addTest(){
		User user=new User();
		user.setEmail("a@gmail.com");
		user.setName("ljj");
		user.setPassword("123456");
		Calendar c=new GregorianCalendar();
		c.set(2000, 0, 1);
		user.getUserMeta().setBirthday(c);
		user.getUserMeta().setCity("nanjing");
		userService.add(user);
		
	}
	
	@Test
	public void getUserTest(){
		User user = userService.getUser("a@gmail.com","123456");
		Assert.assertNotNull(user);
	}
	
}
