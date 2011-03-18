package cn.edu.nju.software.timemachine.util;

public class Constraint {
	
	/**
	 * When sex = "male" or "female", the condition is sex = "male" or "female".<br>
	 * <i>When sex = null, the condition won't be set.</i>   
	 */
	public String sex;
	
	/**
	 * When minAge != null,the person's age > minAge<br>
	 * <i>When minAge = null,the condition won't be set. </i>
	 */
	public Integer minAge;
	
	/**
	 * When maxAge != null,the person's age < maxAge. <br>
	 * <i>When maxAge = null,the condition won't be set. </i>
	 */
	public Integer maxAge;
	
	/**
	 * <i>When city = null,the condition won't be set. </i>
	 */
	public String city;
	
	/**
	 * <i>When country = null,the condition won't be set. </i>
	 */
	public String country;
	
	/**
	 * <i>When minBirthday = null,the condition won't be set. </i><br>
	 * the format should be like "1990-08-20"
	 */
	public String minBirthday;
	
	/**
	 * <i>When maxBirthday = null,the condition won't be set. </i><br>
	 * the format should be like "1990-08-20"
	 */
	public String maxBirthday;

}
