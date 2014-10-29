<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <body>
  <h2><center><s:text name="pro.admin.editpublisher"/></center></h2>
  <center>
<s:form action="editPublisher" namespace="/admin" method="post">
	<s:textfield name="p.name" key="pro.admin.publishername"></s:textfield>
	<s:hidden name="p.id"></s:hidden>
	<s:submit name="submit" key="pro.user.btn"></s:submit>
</s:form>
</center>
  </body>
</html>
