package cn.edu.nju.software.timemachine.action.user;

import java.io.File;

import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.nju.software.timemachine.action.BaseAction;
import cn.edu.nju.software.timemachine.entity.User;
import cn.edu.nju.software.timemachine.service.IUserService;

@Controller
@Scope("prototype")
public class RegisterAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;

	
	private String json;
	
	@Autowired
	private IUserService<User> userService;
		
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

	public void register() throws Exception{
		System.out.println("***********************************8");
		System.out.println(json);
		JSONObject jsonObject = new JSONObject(json);
		String email = jsonObject.getString("email");
		String name = jsonObject.getString("name");
		String password = jsonObject.getString("password");
		String sex = jsonObject.getString("sex");
		String country = jsonObject.getString("country");
		String city = jsonObject.getString("city");
		
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		user.getUserMeta().setSex(sex);
		user.getUserMeta().setCountry(country);
		user.getUserMeta().setCity(city);
		
		if(userService==null){
			System.out.println("the userService");
		}
		
		if(userService.addUser(user)){
			String realPath = ServletActionContext.getServletContext().getRealPath("/data");
			String filePath = realPath + "/"+user.getId();
			File userFile = new File(filePath);
			userFile.mkdir();
			json="{\"msg\":\"1\"}";
		}else{
			json="{\"msg\":\"2\"}";
		}
		sendMsg(json);
	}
}
