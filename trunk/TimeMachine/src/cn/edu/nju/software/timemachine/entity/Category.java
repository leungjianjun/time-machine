package cn.edu.nju.software.timemachine.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category extends BaseEntity {
	
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn
	private User owner;
	
	@OneToMany(mappedBy="category")
	private List<Friend> friendList = new ArrayList<Friend>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<Friend> getFriendList() {
		return friendList;
	}

	public void setFriendList(List<Friend> friendList) {
		this.friendList = friendList;
	}

}
