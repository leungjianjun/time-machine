package cn.edu.nju.software.timemachine.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

@Entity
public class User extends BaseEntity {
	
	private String name;
	
	private String password;
	
	private String email;
	
	@OneToMany(mappedBy="owner",cascade = CascadeType.ALL)
	private List<Category> categoryList = new ArrayList<Category>();
	
	@OneToMany(mappedBy="owner")
	@OrderBy("customDate")
	private List<Album> albumList = new ArrayList<Album>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Role role;
	
	@OneToOne (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn
	private UserMeta userMeta = new UserMeta();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public List<Album> getAlbumList() {
		return albumList;
	}

	public void setAlbumList(List<Album> albumList) {
		this.albumList = albumList;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserMeta getUserMeta() {
		return userMeta;
	}

	public void setUserMeta(UserMeta userMeta) {
		this.userMeta = userMeta;
	}

	

}
