package cn.edu.nju.software.timemachine.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.nju.software.timemachine.entity.Friend;
import cn.edu.nju.software.timemachine.service.IFriendService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class FriendServiceTest {
	
	@Autowired
	private IFriendService<Friend> friendService;
	
	protected String[] getConfigLocations() {
		return new String[] { "classpath:applicationContext.xml" };

	}

	public void setFriendService(IFriendService<Friend> friendService) {
		this.friendService = friendService;
	}

	public IFriendService<Friend> getFriendService() {
		return friendService;
	}
	@Test
	public void nothingTest(){
		
	}

}
