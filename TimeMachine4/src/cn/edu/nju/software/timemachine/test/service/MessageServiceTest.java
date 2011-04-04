package cn.edu.nju.software.timemachine.test.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.nju.software.timemachine.entity.Album;
import cn.edu.nju.software.timemachine.entity.Category;
import cn.edu.nju.software.timemachine.entity.Friend;
import cn.edu.nju.software.timemachine.entity.Message;
import cn.edu.nju.software.timemachine.entity.Picture;
import cn.edu.nju.software.timemachine.entity.Role;
import cn.edu.nju.software.timemachine.entity.SimpleComment;
import cn.edu.nju.software.timemachine.entity.User;
import cn.edu.nju.software.timemachine.service.IAlbumService;
import cn.edu.nju.software.timemachine.service.ICategoryService;
import cn.edu.nju.software.timemachine.service.ICommentService;
import cn.edu.nju.software.timemachine.service.IFriendService;
import cn.edu.nju.software.timemachine.service.IMessageService;
import cn.edu.nju.software.timemachine.service.IPictureService;
import cn.edu.nju.software.timemachine.service.IRoleService;
import cn.edu.nju.software.timemachine.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MessageServiceTest {
	
	@Autowired
	private IAlbumService<Album> albumService;
	
	@Autowired
	private ICategoryService<Category> categoryService;
	
	@Autowired
	private ICommentService<SimpleComment> commentService;
	
	@Autowired
	private IFriendService<Friend> friendService;
	
	@Autowired
	private IMessageService<Message> messageService;
	
	@Autowired
	private IPictureService<Picture> pictureService;
	
	@Autowired
	private IUserService<User> userService;
	
	@Autowired
	private IRoleService<Role> roleService;
	
	public void setRoleService(IRoleService<Role> roleService) {
		this.roleService = roleService;
	}

	public IRoleService<Role> getRoleService() {
		return roleService;
	}
	
	public IAlbumService<Album> getAlbumService() {
		return albumService;
	}

	public void setAlbumService(IAlbumService<Album> albumService) {
		this.albumService = albumService;
	}

	public ICategoryService<Category> getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(ICategoryService<Category> categoryService) {
		this.categoryService = categoryService;
	}

	public ICommentService<SimpleComment> getCommentService() {
		return commentService;
	}

	public void setCommentService(ICommentService<SimpleComment> commentService) {
		this.commentService = commentService;
	}

	public IFriendService<Friend> getFriendService() {
		return friendService;
	}

	public void setFriendService(IFriendService<Friend> friendService) {
		this.friendService = friendService;
	}

	public IMessageService<Message> getMessageService() {
		return messageService;
	}

	public void setMessageService(IMessageService<Message> messageService) {
		this.messageService = messageService;
	}

	public IPictureService<Picture> getPictureService() {
		return pictureService;
	}

	public void setPictureService(IPictureService<Picture> pictureService) {
		this.pictureService = pictureService;
	}

	public IUserService<User> getUserService() {
		return userService;
	}

	public void setUserService(IUserService<User> userService) {
		this.userService = userService;
	}

	public void setUserSerivce(IUserService<User> userSerivce) {
		this.userService = userSerivce;
	}

	public IUserService<User> getUserSerivce() {
		return userService;
	}
	
	@Before
	public void iniDatabase(){
		Init.initDatabase(albumService, categoryService, commentService, friendService, messageService, pictureService, userService, roleService);
	}
	
	@After
	public void clearDatabase(){
		
	}
	
	@Test
	public void nothingTest(){
		
	}

}
