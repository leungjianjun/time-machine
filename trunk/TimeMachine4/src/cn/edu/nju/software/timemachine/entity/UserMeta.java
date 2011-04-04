package cn.edu.nju.software.timemachine.entity;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class UserMeta extends BaseEntity {
	
	private String city;
	
	private String country;
	
	private Calendar birthday;
	
	private String otherStuff;
	
	private String sex;
	
	@OneToOne(mappedBy = "userMeta")
	private User user;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public String getOtherStuff() {
		return otherStuff;
	}

	public void setOtherStuff(String otherStuff) {
		this.otherStuff = otherStuff;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return sex;
	}

}
