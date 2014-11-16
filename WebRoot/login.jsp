<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>   
    <title><s:text name="pro.login.loginTitle"/></title>
  </head>
  <body>
  <h3><center><s:text name="pro.login.loginTitle" /></center></h3>
  <!--<center><a href='new.jsp'>点击注册</a></center>-->
  <center>
<s:form action="checkLogin" namespace="/sys" >
<s:textfield name="loginname" key="pro.login.loginName" cssStyle="width:100"></s:textfield>
<s:password name="loginpwd" key="pro.login.loginPwd" cssStyle="width:100"></s:password>
<s:submit name="submit" key="pro.user.btn"></s:submit>
</s:form></center>
<center><s:include value="/changeLocale.jsp"/></center>
  </body>
</html>

