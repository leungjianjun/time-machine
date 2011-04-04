package cn.edu.nju.software.timemachine.action.message;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.nju.software.timemachine.action.BaseAction;
import cn.edu.nju.software.timemachine.entity.Message;
import cn.edu.nju.software.timemachine.entity.User;
import cn.edu.nju.software.timemachine.service.IMessageService;
import cn.edu.nju.software.timemachine.service.IUserService;

@Controller
@Scope("prototype")
public class SendMessageAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String json;
	
	@Autowired
	private IMessageService<Message> messageService;
	
	@Autowired
	private IUserService<User> userService;

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public IMessageService<Message> getMessageService() {
		return messageService;
	}

	public void setMessageService(IMessageService<Message> messageService) {
		this.messageService = messageService;
	}

	public void setUserService(IUserService<User> userService) {
		this.userService = userService;
	}

	public IUserService<User> getUserService() {
		return userService;
	}
	
	public void send() throws JSONException{
		JSONObject jsonObject = new JSONObject(json);
		Message message = new Message();
		message.setContent(jsonObject.getString("content"));
		message.setDateCreated(new Date());
		message.setInviter(userService.searchUserByEmail(jsonObject.getString("email")));
		message.setInvitee(userService.getUser((Long) session.get("id")));
		message.setRead(false);
		messageService.addMessage(message);
		sendMsg("{\"msg\":\"1\"}");
	}


}
