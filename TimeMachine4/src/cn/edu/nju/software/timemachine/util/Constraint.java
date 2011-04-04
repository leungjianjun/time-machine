package cn.edu.nju.software.timemachine.util;

import java.util.Calendar;

public class Constraint {
	
	/**
	 * When sex = "male" or "female", the condition is sex = "male" or "female".<br>
	 * <i>When sex = null, the condition won't be set.</i>   
	 */
	private String sex;
	
	/**
	 * When minAge != null,the person's age > minAge<br>
	 * <i>When minAge = null,the condition won't be set. </i>
	 */
	private Integer minAge;
	
	/**
	 * When maxAge != null,the person's age < maxAge. <br>
	 * <i>When maxAge = null,the condition won't be set. </i>
	 */
	private Integer maxAge;
	
	/**
	 * <i>When city = null,the condition won't be set. </i>
	 */
	private String city;
	
	/**
	 * <i>When country = null,the condition won't be set. </i>
	 */
	private String country;
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getMinAge() {
		return minAge;
	}

	public void setMinAge(Integer minAge) {
		this.minAge = minAge;
	}

	public Integer getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}

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

	public Calendar getMinBirthday() {
		return minBirthday;
	}

	public void setMinBirthday(Calendar minBirthday) {
		this.minBirthday = minBirthday;
	}

	public Calendar getMaxBirthday() {
		return maxBirthday;
	}

	public void setMaxBirthday(Calendar maxBirthday) {
		this.maxBirthday = maxBirthday;
	}

	/**
	 * <i>When minBirthday = null,the condition won't be set. </i><br>
	 * the format should be like "1990-08-20"
	 */
	private Calendar minBirthday;
	
	/**
	 * <i>When maxBirthday = null,the condition won't be set. </i><br>
	 * the format should be like "1990-08-20"
	 */
	private Calendar maxBirthday;
	
	public Constraint(String sex,Integer minAge,Integer maxAge,String city,String country,Calendar minBirthday,Calendar maxBirthday){
		this.sex = sex;
		this.minAge=minAge;
		this.maxAge=maxAge;
		this.city=city;
		this.country=country;
		this.maxBirthday=maxBirthday;
		this.minBirthday=minBirthday;
	}
}
