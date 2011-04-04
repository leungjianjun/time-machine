<%@ page language="java" contentType="text/html; charset=UTF-8"  
        pageEncoding="UTF-8"%>  
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>登录页</title>  
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script> 
<script type="text/javascript">  
      $(function(){   
   
         $("#submit").click(function(){   
             var loginName1 = $("input[name='loginName']").val();    //获取账号   
             var password1 = $("input[name='password']").val();        //获取密码   
   
             var jsonUser = {loginName:loginName1, password:password1};    //JSON对象   
                           
                                  //注意:jsonUser.toString()这种方法错误,javaScript中的toString是用于布尔型变量的,而应用以下方法   
               var strUser = JSON.stringify(jsonUser);    //将JSON对象转变成JSON格式的字符串,   
               $.post("login!login.action", {json: strUser}, callback, "json"); 
               alert(strUser);
               /*jQuery.post("/user/register!register.action",{json:strSend},function(data){
					alert("You Have Registered Successfully!");
					
				},"json");*/
           });   
           
           
     
           function callback(json){   
               alert(json.msg);    //显示反馈信息   
               if(json.suc == 1){    //如果返回"登录成功"   
                   window.location.href = "admin/index.action";    //跳转到后台主页   
               }   
           }   
              
       });   
   </script>  
   </head>  
   <body>  
     
   <s:form action="login.action" method="post">  
       账号<input type="text" name="loginName"/><br/>  
       密码<input type="password" name="password"><br/>  
       <input type="button" id="submit" value="submit"/>  
   </s:form>  
     
   </body>  
  </html>  
