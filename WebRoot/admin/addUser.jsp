<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <body>
  <h2><center><s:text name="pro.admin.adduser"/></center></h2>
  <center>
<s:form action="addUser" namespace="/admin" method="post">
	<s:textfield name="u.name" key="pro.login.loginName"></s:textfield>
	<s:textfield name="u.pwd" key="pro.login.loginPwd" ></s:textfield>
	<s:textfield name="u.unit" key="ËùÊô»ú¹¹" ></s:textfield>
	<s:radio name="u.roleID"
	key="pro.admin.setrole"
	list="#session.roleMap"
	listKey="key"
	listValue="value"
	value="'2'" >
	</s:radio>
	<s:submit name="submit" key="pro.user.btn"></s:submit>
</s:form>
</center>
  </body>
</html>
