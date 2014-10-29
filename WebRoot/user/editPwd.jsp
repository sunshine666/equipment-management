<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<h3><center><s:text name="pro.user.editpwd" /></center></h3>
<center>
<s:form action="editPwd" namespace="/user" method="post" >
<s:textfield value="%{#session.loginname}" name="loginname" readonly="true" key="pro.user.loginname"/>
<s:password name="loginpwd" key="pro.user.oldpwd" ></s:password>
<s:password name="newPwd" key="pro.user.newpwd" ></s:password>
<s:password name="newPwd1" key="pro.user.confirmpwd" ></s:password>
<s:submit name="submit" key="pro.user.btn"></s:submit>
</s:form>
</center>
</body>
</html>
