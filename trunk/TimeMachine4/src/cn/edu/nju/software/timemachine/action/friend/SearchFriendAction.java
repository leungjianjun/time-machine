package cn.edu.nju.software.timemachine.action.friend;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.nju.software.timemachine.action.BaseAction;
import cn.edu.nju.software.timemachine.entity.User;
import cn.edu.nju.software.timemachine.service.IUserService;
import cn.edu.nju.software.timemachine.util.Constraint;

@Controller
@Scope("prototype")
public class SearchFriendAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IUserService<User> userService;
	
	private String json;

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
	
	public void setUserService(IUserService<User> userService) {
		this.userService = userService;
	}

	public IUserService<User> getUserService() {
		return userService;
	}
	
	public void searchByEmail() throws JSONException{
		JSONObject jsonObject = new JSONObject(json);
		JSONObject result = new JSONObject();
		User user = userService.searchUserByEmail(jsonObject.getString("email"));
		if(user!=null){
			result.accumulate("name", user.getName());
			result.accumulate("email", user.getEmail());
			result.accumulate("city", user.getUserMeta().getCity());
			result.accumulate("country", user.getUserMeta().getCountry());
			result.accumulate("birthday", user.getUserMeta().getBirthday());
			result.accumulate("sex", user.getUserMeta().getSex());
			
		}
		sendMsg(result.toString());
	}
	
	public void searchByName() throws JSONException{
		JSONObject jsonObject = new JSONObject(json);
		JSONObject result = new JSONObject();
		List<User> userList = userService.searchUserByName(jsonObject.getString("name"));
		for(User user:userList){
			JSONObject ujson = new JSONObject();
			ujson.accumulate("name", user.getName());
			ujson.accumulate("email", user.getEmail());
			ujson.accumulate("city", user.getUserMeta().getCity());
			ujson.accumulate("country", user.getUserMeta().getCountry());
			ujson.accumulate("birthday", user.getUserMeta().getBirthday());
			ujson.accumulate("sex", user.getUserMeta().getSex());
			result.append("userList", ujson);
		}
		sendMsg(result.toString());
	}
	
	/**
	 * String sex,Integer minAge,Integer maxAge,String city,String country,Calendar minBirthday,Calendar maxBirthday
	 * @throws JSONException 
	 */
	public void searchByDetail() throws Exception {
		JSONObject jsonObject = new JSONObject(json);
		JSONObject result = new JSONObject();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String minDateStr = jsonObject.getString("minBirthday");
		Date minBirthday = format.parse(minDateStr);
		Calendar minCan=Calendar.getInstance();
		minCan.setTime(minBirthday);
		String maxDateStr = jsonObject.getString("maxBirthday");
		Date maxBirthday = format.parse(maxDateStr);
		Calendar maxCan=Calendar.getInstance();
		maxCan.setTime(maxBirthday);
		Constraint constraint = new Constraint(jsonObject.getString("sex"),jsonObject.getInt("minAge"),
				                               jsonObject.getInt("maxAge"),jsonObject.getString("city"),
				                               jsonObject.getString("country"),minCan,maxCan);
		List<User> userList = userService.serchUser(constraint);
		for(User user:userList){
			JSONObject ujson = new JSONObject();
			ujson.accumulate("name", user.getName());
			ujson.accumulate("email", user.getEmail());
			ujson.accumulate("city", user.getUserMeta().getCity());
			ujson.accumulate("country", user.getUserMeta().getCountry());
			ujson.accumulate("birthday", user.getUserMeta().getBirthday());
			ujson.accumulate("sex", user.getUserMeta().getSex());
			result.append("userList", ujson);
		}
		sendMsg(result.toString());
	}


	

}
