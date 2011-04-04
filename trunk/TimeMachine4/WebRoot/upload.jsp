<%@ page language="java" contentType="text/html;UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'upload.jsp' starting page</title>

  </head>
  
  <body>
    <s:form action="upload.action" method="post" enctype="multipart/form-data">
    	<s:file name="upload"></s:file>
    	<s:file name="upload"></s:file>
    	<s:textfield name = "json"></s:textfield>
    	<s:submit value="submit"></s:submit>
    </s:form>
  </body>
</html>
