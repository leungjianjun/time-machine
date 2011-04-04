package cn.edu.nju.software.timemachine.action;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Map<String,Object> session;

	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
	
	public boolean isLogin(){
		if(session.get("id")==null){
			return false;
		}else{
			return true;
		}
	}
	
	public void sendMsg(String msg){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(msg);
			out.flush();
			out.close();
		}catch(Exception e){
			
		}
	}

}
