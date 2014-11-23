<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <body>
  <h2><center><s:text name="pro.admin.addpublisher"/></center></h2>
  <center>
<s:form action="addPublisher" namespace="/admin" method="post">
	<s:textfield name="p.name" key="pro.admin.publishername"></s:textfield>
	<s:submit name="submit" key="pro.user.btn"></s:submit>
</s:form>
</center>
  </body>
</html>
