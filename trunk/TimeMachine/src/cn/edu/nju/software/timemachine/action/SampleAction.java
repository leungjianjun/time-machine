package cn.edu.nju.software.timemachine.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.nju.software.timemachine.entity.User;
import cn.edu.nju.software.timemachine.service.IUserService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@SuppressWarnings("serial")
public class SampleAction extends ActionSupport {
	
	@Autowired
	private IUserService<User> userService;

	public void setUserService(IUserService<User> userService) {
		this.userService = userService;
	}

	public IUserService<User> getUserService() {
		return userService;
	}
	
	public String execute(){
		
		return null;	
	}

}
