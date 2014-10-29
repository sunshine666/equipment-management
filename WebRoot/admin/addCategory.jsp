<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <body>
  <h2><center><s:text name="pro.admin.addcategory" /></center></h2>
  <center>
<s:form action="addCategory" namespace="/admin" method="post">
	<s:textfield name="c.name" key="pro.admin.categoryname"></s:textfield>
	<s:textarea name="c.desc" key="pro.admin.categorydesc"></s:textarea>
	<s:submit name="submit" key="pro.user.btn"></s:submit>
</s:form>
</center>
  </body>
</html>
