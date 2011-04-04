package cn.edu.nju.software.timemachine.action.message;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.nju.software.timemachine.action.BaseAction;
import cn.edu.nju.software.timemachine.entity.Message;
import cn.edu.nju.software.timemachine.service.IMessageService;

@Controller
@Scope("prototype")
public class ListeningMessageAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IMessageService<Message> messageService;

	public IMessageService<Message> getMessageService() {
		return messageService;
	}

	public void setMessageService(IMessageService<Message> messageService) {
		this.messageService = messageService;
	}
	
	public void getUnreadMessages() throws JSONException{
		List<Message> messageList = messageService.getUnreadMessageList((Long)session.get("id"));
		JSONObject result = new JSONObject();
		for(Message message:messageList){
			JSONObject mjson = new JSONObject();
			mjson.accumulate("message_id", message.getId());
			mjson.accumulate("invitor_name", message.getInviter().getName());
			mjson.accumulate("invitor_email", message.getInviter().getEmail());
			mjson.accumulate("content", message.getContent());
			mjson.accumulate("create_date", message.getDateCreated());
			result.append("messageList", mjson);
		}
		sendMsg(result.toString());
	}
	
	public void getAllMessage() throws JSONException {
		List<Message> messageList = messageService.getMessageList((Long)session.get("id"));
		JSONObject result = new JSONObject();
		for(Message message:messageList){
			JSONObject mjson = new JSONObject();
			mjson.accumulate("invitor_name", message.getInviter().getName());
			mjson.accumulate("invitor_email", message.getInviter().getEmail());
			mjson.accumulate("content", message.getContent());
			mjson.accumulate("create_date", message.getDateCreated());
			result.append("messageList", mjson);
		}
		sendMsg(result.toString());
	}

}
