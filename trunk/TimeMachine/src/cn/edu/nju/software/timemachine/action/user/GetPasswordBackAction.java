package cn.edu.nju.software.timemachine.action.user;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class GetPasswordBackAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//the user's mailbox
	private String userMailAddress;
	
	//getter and setter
	public String getUserMailAddress() {
		return userMailAddress;
	}

	public void setUserMailAddress(String userMailAddress) {
		this.userMailAddress = userMailAddress;
	}

	
	public String execute(){
		/*
		 * validate the mail address first,
		 * if not pass validation, give a toast
		 * else call sendEmail
		 */
		sendEmail();
		return SUCCESS;
	}
	
	
	public void sendEmail(){
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
		
		Session session = Session.getDefaultInstance(props);
		
		session.setDebug(true);
		
		try{
		//get the message and set the from-address and to-address
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//set subject and text of the mail
		message.setSubject("Hello!");
		message.setText("i am vincent");
		
		message.saveChanges();
		
		Transport transport = session.getTransport("smtp");
		transport.connect(host,username, password);
		//send message
		transport.sendMessage(message, message.getAllRecipients());
		
		transport.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}


}
