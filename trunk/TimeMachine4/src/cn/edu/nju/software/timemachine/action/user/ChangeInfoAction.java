package cn.edu.nju.software.timemachine.action.user;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.nju.software.timemachine.action.BaseAction;
import cn.edu.nju.software.timemachine.entity.User;
import cn.edu.nju.software.timemachine.service.IUserService;

@Controller
@Scope("prototype")
public class ChangeInfoAction extends BaseAction{

	/**
	 * 
	 */
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
	
	public void changeInfo() throws Exception{
		JSONObject jsonObject = new JSONObject(json);
		System.out.println(jsonObject.toString());
		String sex = jsonObject.getString("sex");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = jsonObject.getString("birthday");
		Date birthday = format.parse(dateStr);
		Calendar c=Calendar.getInstance();
		c.setTime(birthday);
		
		String city = jsonObject.getString("city");
		String otherStuff = jsonObject.getString("remark");
		String password = jsonObject.getString("password");
		
		User user = userService.getUser((Long)session.get("userId"));
		if(dateStr!="" && dateStr!=null){
			user.getUserMeta().setBirthday(c);
		}
		if(sex!=null && sex !=""){
			user.getUserMeta().setSex(sex);
		}
		
		if(city!=null && city!=""){
			user.getUserMeta().setCity(city);
		}
		if(otherStuff != null && otherStuff !=""){
			user.getUserMeta().setOtherStuff(otherStuff);
		}
		
	    if(password!="" && password !=null){
	    	user.setPassword(password);
	    }
		
	    if(userService.update(user)){
	    	json = "{\"msg\":\"1\"}";
	    }else{
	    	json = "{\"msg\":\"2\"}";
	    }
	    sendMsg(json);
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getJson() {
		return json;
	}

}
