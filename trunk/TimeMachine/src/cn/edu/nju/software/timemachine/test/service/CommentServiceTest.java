package cn.edu.nju.software.timemachine.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.nju.software.timemachine.entity.SimpleComment;
import cn.edu.nju.software.timemachine.service.ICommentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class CommentServiceTest {
	
	@Autowired
	private ICommentService<SimpleComment> commentService;
	
	protected String[] getConfigLocations() {
		return new String[] { "classpath:applicationContext.xml" };

	}

	public void setCommentService(ICommentService<SimpleComment> commentService) {
		this.commentService = commentService;
	}

	public ICommentService<SimpleComment> getCommentService() {
		return commentService;
	}
	
	@Test
	public void nothingTest(){
		
	}

}
