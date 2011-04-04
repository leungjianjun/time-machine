<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/regstyle.css" />
		<script type="text/javascript" src="js/jquery-1.5.1.js"></script>
		<script type="text/javascript" src="js/reg.js"></script>
		<title>Register Now!</title>
		
	</head>
	<body>
		<img src="images/regbg.jpg" width="100%" heigth="100%"/>
		<div id="headbar">
			<p align="top"><h1>Register Now And Enjoy your Life!</h1></p>
		</div>
		<div id="body">
			<div id="part1">
				<h2><p style="font-weight:bolder;">Enter Your Email Address:</p></h2>
				<table id="tb1">
					<tr>
						<td>Address Of Email:</td>
						<td><input type="text" name="user_email" id="mail" size="50" />* Necessary</td>
						<td><input type="button" value="Check Email" onclick="check()"></td>
					</tr>
					<tr>
						<td></td>
						<td><p style="color:#808080">You can user gmail,hotmail or other email to complete this step.</p></td>
					</tr>
				</table>
			</div>
			<div id="part2">
				<p><h2>Account Info   <span class="ornage">    You should complete following ones carefully!</span></h2></p>
				<table id="tb2">
					<tr>
						<td align="right">UserName:</td>
						<td><input type="text" name="user_name" id="user_name_id" size="15" /></td>
						<td><p style="color:red">* Necessary</p></td>
					
					</tr>
					<tr>
						<td align="right">Password:</td>
						<td><input type="password" name="user_password" id="user_password_id" size="12" /></td>
						<td><p style="color:red">* Necessary</p></td>
					</tr>
					<tr>
						<td></td><td><p style="color:#808080">6-10 characters</p></td>
					</tr>
					<tr>
						<td align="right">Repeate:</td>
						<td><input type="password" name="user_repass" id="user_repass_id"size="12"/></td>
					</tr>
				</table>
				<table id="tb3">
					<tr>
						<td>Sex:</td>
						<td><select name="sex" id="choose_sex">
							<option value="male">Male</option>
							<option value="female">Female</option>
						</select></td>
					</tr>
					<tr>
						<td><p>Country:</p></td>
						<td>
							<input type="text" name="user_country" id="user_country_id"size="8"/>
						</td>
					</tr>
					<tr>
						<td><p>City</p></td>
						<td>
							<input type="text" name="user_city" id="user_city_id" size="8" />
						</td>
					</tr>
				</table>
				<!--<div id="remark">
					<textarea id="inputarea" cols="30" rows="7"></textarea>
				</div>-->
			</div>
			<div id="part3">
				<div id="accept">
					<p style="color:#0000FF;font-size:large;"align="center"><input type="checkbox" name="isaccept" />I Accept the Protocal of This Site.<a href="">What's The Protocol?</a></p>
				</div>
				
				<div id="submit">
				<s:form action="register.action"  method="post">
					<input type="button" value="submit" id="submit">
				</s:form>	    
				</div>
				
			</div>
		</div>
	</body>
</html>

