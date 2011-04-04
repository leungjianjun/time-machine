package cn.edu.nju.software.timemachine.service;

import java.util.List;

import cn.edu.nju.software.timemachine.entity.Message;

public interface IMessageService<T extends Message> extends IService<T> {
	
	public void addMessage(T message);
	
	public void isRead(T message,boolean isRead);
	
	public List<T> getMessageList(long userId);
	
	public List<T> getUnreadMessageList(long userId);

}
