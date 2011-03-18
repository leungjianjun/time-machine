package cn.edu.nju.software.timemachine.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Role extends BaseEntity {
	
	private String name;
	
	@OneToMany(mappedBy="role")
	private List<User> userList = new ArrayList<User>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
