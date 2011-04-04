package cn.edu.nju.software.timemachine.action.message;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.nju.software.timemachine.action.BaseAction;
import cn.edu.nju.software.timemachine.entity.Friend;
import cn.edu.nju.software.timemachine.entity.Message;
import cn.edu.nju.software.timemachine.service.IFriendService;
import cn.edu.nju.software.timemachine.service.IMessageService;

@Controller
@Scope("prototype")
public class ResponseMessageAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IMessageService<Message> messageService;
	
	private IFriendService<Friend> friendService;
	
	private String json;

	public IMessageService<Message> getMessageService() {
		return messageService;
	}

	public void setMessageService(IMessageService<Message> messageService) {
		this.messageService = messageService;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getJson() {
		return json;
	}
	
	public void setFriendService(IFriendService<Friend> friendService) {
		this.friendService = friendService;
	}

	public IFriendService<Friend> getFriendService() {
		return friendService;
	}
	
	public void responseMessage() throws JSONException{
		JSONObject jsonObject = new JSONObject(json);
		long messageId = jsonObject.getLong("message_id");
		boolean accept = jsonObject.getBoolean("accept");
		if(accept){
			
		}else{
			
		}
	}

}
