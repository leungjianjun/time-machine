package cn.edu.nju.software.timemachine.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.nju.software.timemachine.entity.Message;
import cn.edu.nju.software.timemachine.service.IMessageService;

@Service("messageService")
@Transactional
@SuppressWarnings("unchecked")
public class MessageService<T extends Message> extends ServiceImpl<T> implements IMessageService<T> {

	/**
	 * message不要指定isread属性，目前message就是邀请为好友
	 */
	public void addMessage(T message) {
		message.setRead(false);
		dao.create(message);
		
	}

	/**
	 * 这个方法可以设置message是否被阅读，就算读过的message也可以标志为未读，<br>
	 * 当然也可以通过update函数来处理
	 * @see update(T basebean)
	 */
	public void isRead(T message, boolean isRead) {
		message.setRead(isRead);
		dao.save(message);
	}

	public List<T> getMessageList(long userId) {
		return (List<T>) dao.createQuery("from Message as message wherer message.inviter.id = :id")
		                 .setParameter("id", userId).list();
	}

	public List<T> getUnreadMessageList(long userId) {
		return (List<T>) dao.createQuery("from Message as message wherer message.inviter.id = :id and message.isRead = false")
		                  .setParameter("id", userId).list();
	}

}
