package cn.edu.nju.software.timemachine.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

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
	
	public Constraint(String sex,Integer minAge,Integer maxAge,String city,String country,String minBirthday,String maxBirthday){
		this.sex = sex;
		this.minAge=minAge;
		this.maxAge=maxAge;
		this.city=city;
		this.country=country;
		Calendar c=new GregorianCalendar();
		c.set(2000, 0, 1);
		
	}

}
