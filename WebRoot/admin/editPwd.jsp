<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <style type="text/css">
<!--
body {
	background-image: url(../img/back1.jpg);    
}
-->
</style>
<body>
<h3><center><s:text name="pro.admin.editpwd" /></center></h3>
<center>
<s:form action="editPwd" namespace="/admin" method="post" >
<s:textfield value="%{#session.loginname}" name="loginname" readonly="true" key="pro.user.loginname"/>
<s:password name="loginpwd" key="pro.user.oldpwd" ></s:password>
<s:password name="newPwd" key="pro.user.newpwd" ></s:password>
<s:password name="newPwd1" key="pro.user.confirmpwd" ></s:password>
<s:submit name="submit" key="pro.user.btn"></s:submit>
</s:form>
</center>
</body>
</html>
