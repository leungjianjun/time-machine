package cn.edu.nju.software.timemachine.action.user;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.nju.software.timemachine.action.BaseAction;
import cn.edu.nju.software.timemachine.entity.User;
import cn.edu.nju.software.timemachine.service.IUserService;


@Controller
@Scope("prototype")
public class GetPasswordBackAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	//the user's mailbox
	private String userMailAddress;
	
	@Autowired
	private IUserService<User> userService;
	
	private String json;
	
	//getter and setter
	public String getUserMailAddress() {
		return userMailAddress;
	}

	public void setUserMailAddress(String userMailAddress) {
		this.userMailAddress = userMailAddress;
	}

	public IUserService<User> getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(IUserService<User> userService) {
		this.userService = userService;
	}
	
	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public void getPwdBack() throws Exception{
		JSONObject jsonObject  = new JSONObject(json);
		
		String destAddress = jsonObject.getString("email");
		sendEmail(destAddress);
	}
	
	
	private void sendEmail(String destAddress){
		//the mailbox server
		String host = "smtp.sina.com.cn";
		//the sender mailbox
		String from = "timemachinenju@sina.com";
		//the receiver mailbox
		String to = userMailAddress;
		//sender username and password
		String username="timemachinenju";
		String password = "timemachine";
		
		//the environment
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		
		Session pwdSession = Session.getDefaultInstance(props);
		
		pwdSession.setDebug(true);
		
		try{
		//get the message and set the from-address and to-address
		MimeMessage message = new MimeMessage(pwdSession);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//set subject and text of the mail
		message.setSubject("Your password!");
		
		//get the password
		String pwd = getPwd(destAddress);
		message.setText("Your password: "+pwd);
		
		message.saveChanges();
		
		Transport transport = pwdSession.getTransport("smtp");
		transport.connect(host,username, password);
		//send message
		transport.sendMessage(message, message.getAllRecipients());
		
		transport.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private String getPwd(String userEmail){
		String password = userService.getUser(userEmail).getPassword();
		return password;
	}
}
