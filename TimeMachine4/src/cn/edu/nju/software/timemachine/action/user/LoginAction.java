package cn.edu.nju.software.timemachine.action.user;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.nju.software.timemachine.action.BaseAction;
import cn.edu.nju.software.timemachine.entity.User;
import cn.edu.nju.software.timemachine.service.IUserService;

@Controller
@Scope("prototype")
public class LoginAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;

	private User user;
	
	private String json;

	@Autowired
	private IUserService<User> userService;
	
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
	
	
	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public void login() throws Exception{
		JSONObject jsonObject = new JSONObject(json);
		System.out.println(json);
		String email = jsonObject.getString("loginName");
		String password = jsonObject.getString("password");
		
		User _user = userService.getUser(email, password);
		if(_user != null){
			session.put("id", _user.getId());
			json = "{\"msg\":\"1\"}";
		}else{
			json = "{\"msg\":\"2\"}";
		}
		
		sendMsg(json);
	}
}
