<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(img/new3.jpg);    
}
-->
</style>
<center>
<table border="0">
<tr>
<td> </td>
</tr>
<tr>
<td> </td>
</tr>
<tr>
<td> </td>
</tr>
<tr>
<td> </td>
</tr>
</table>
</center>
  <h1><center><s:text name="pro.login.loginTitle" /></center></h1>
  <!--<center><a href='new.jsp'>点击注册</a></center>-->
  <center>
  <h2><center><s:text name="你好，请输入信息" /></center></h2>
<s:form  action="checkLogin" namespace="/sys" >
<s:textfield  name="loginname" key="pro.login.loginName" cssStyle="width:120" ></s:textfield>
<s:password name="loginpwd" key="pro.login.loginPwd" cssStyle="width:120"></s:password>
<s:submit name="submit" key="pro.user.btn"></s:submit>
</s:form></center>
<center><s:include value="/changeLocale.jsp"/></center>
  </body>
</html>

