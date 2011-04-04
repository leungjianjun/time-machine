<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
    This is my index page. <br>
    <s:form action="/user/register.action">
    	<input type="submit" value="submit">
    </s:form>
  </body>
</html>
