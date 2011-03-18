package cn.edu.nju.software.timemachine.action.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.nju.software.timemachine.entity.User;
import cn.edu.nju.software.timemachine.service.IUserService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@SuppressWarnings("serial")
public class RegisterAction extends ActionSupport{
	//entity
	private User user;
	//service
	@Autowired
	private IUserService<User> userService;
	
	//getter and setter
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public IUserService<User> getUserService() {
		return userService;
	}
	public void setUserService(IUserService<User> userService) {
		this.userService = userService;
	}
		
	public String execute(){
		/*
		 * call isUsernameExisted() and validate other
		 * attributes. give toast or register successfully
		 */
		return SUCCESS;
	}
	
	private boolean isUsernameExisted(){
		/*
		 * call userService.searchUserByName()
		 * if returns null, return false;
		 * else return true, give a toast
		 */
		return false;
	}
	
	

}
