package cn.edu.nju.software.timemachine.action.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nju.software.timemachine.entity.User;
import cn.edu.nju.software.timemachine.service.IUserService;

@Controller
@Scope("prototype")
@SuppressWarnings("serial")
public class LoginAction extends ActionSupport{
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
	
	//execute
	public String execute(){
		/*call userService.getUser(user)
		 * if null, give a toast and login again
		 * else forward personal home page
		 */
		return SUCCESS;
	}
	
	
	

}
