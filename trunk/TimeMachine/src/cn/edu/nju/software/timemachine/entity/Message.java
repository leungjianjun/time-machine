package cn.edu.nju.software.timemachine.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Message extends BaseEntity {
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn
	private User inviter;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn
	private User invitor;
	
	private String content;
	
	private boolean isRead;

	public User getInviter() {
		return inviter;
	}

	public void setInviter(User inviter) {
		this.inviter = inviter;
	}

	public User getInvitor() {
		return invitor;
	}

	public void setInvitor(User invitor) {
		this.invitor = invitor;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

}
