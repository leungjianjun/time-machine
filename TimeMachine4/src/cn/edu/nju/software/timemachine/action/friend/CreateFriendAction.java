package cn.edu.nju.software.timemachine.action.friend;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.nju.software.timemachine.action.BaseAction;
import cn.edu.nju.software.timemachine.entity.Friend;
import cn.edu.nju.software.timemachine.entity.User;
import cn.edu.nju.software.timemachine.service.IFriendService;
import cn.edu.nju.software.timemachine.service.IUserService;

@Controller
@Scope("prototype")
public class CreateFriendAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IFriendService<Friend> friendService;
	
	@Autowired
	private IUserService<User> userService;
	
	private String json;

	public IUserService<User> getUserService() {
		return userService;
	}

	public void setUserService(IUserService<User> userService) {
		this.userService = userService;
	}

	public IFriendService<Friend> getFriendService() {
		return friendService;
	}

	public void setFriendService(IFriendService<Friend> friendService) {
		this.friendService = friendService;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
	
	public void addFriend(){
		
		Friend friend = new Friend();
		friend.setCategory(userService.getUser(1).getCategoryList().get(0));
		friend.setDateCreated(new Date());
		friend.setNikename("ljj");
		friend.setUser(userService.getUser(2));
		friendService.addFriend(friend, userService.getUser(2).getCategoryList().get(0));
		
		Friend friend2 = new Friend();
		friend2.setCategory(userService.getUser(1).getCategoryList().get(0));
		friend2.setDateCreated(new Date());
		friend2.setNikename("ljj");
		friend2.setUser(userService.getUser(3));
		friendService.addFriend(friend2, userService.getUser(3).getCategoryList().get(0));
	}

}
