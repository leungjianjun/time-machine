package cn.edu.nju.software.timemachine.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.nju.software.timemachine.entity.Message;
import cn.edu.nju.software.timemachine.service.IMessageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MessageServiceTest {
	
	@Autowired
	private IMessageService<Message> messageService;
	
	protected String[] getConfigLocations() {
		return new String[] { "classpath:applicationContext.xml" };

	}

	public void setMessageService(IMessageService<Message> messageService) {
		this.messageService = messageService;
	}

	public IMessageService<Message> getMessageService() {
		return messageService;
	}
	
	@Test
	public void nothingTest(){
		
	}

}
