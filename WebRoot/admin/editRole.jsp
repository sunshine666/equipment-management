<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <body>
  <h2><center><s:text name="pro.admin.editrole" /></center></h2>
  <center>
<s:form action="editRole" namespace="/admin" method="post">
	<s:textfield name="u.name" key="pro.user.loginname" readonly="true"></s:textfield>
	<s:hidden name="u.name"></s:hidden>
	<s:radio name="u.roleID"
    key="pro.admin.editrole"
	list="#session.roleMap"
	listKey="key"
	listValue="value">
	</s:radio>
	<s:submit name="submit" key="pro.user.btn"></s:submit>
</s:form>
</center>
  </body>
</html>
