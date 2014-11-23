<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<link href="css/css.css" rel="stylesheet" type="text/css">
  <body>
<center>
<h2><s:text name="pro.admin.userlist"/></h2>
<table border="1">
<tr>
<td><s:text name="pro.admin.userid"/></td>
<td><s:text name="pro.admin.username"/></td>
<td><s:text name="pro.admin.userrole"/></td>
<td><s:text name="pro.admin.editrole"/></td>
<td><s:text name="pro.admin.deluser"/></td>
</tr>
<s:iterator value="userList">
<s:set name="roleId" value="roleID" />
<tr>
<td><s:property value="id" /></td>
<td><s:property value="name" /></td>
<td><s:if test="#roleId == 1"><s:text name="pro.admin"/></s:if><s:elseif test="#roleId == 2"><s:text name="pro.opterator"/></s:elseif></td>
<td><a href='<s:url action="getUser" namespace="/admin">
<s:param name="loginname" value="name"></s:param>
</s:url>'><s:text name="pro.admin.editrole"/></a>
</td>
<td><a href='<s:url action="delUser" namespace="/admin">
<s:param name="id" value="id"></s:param>
</s:url>'><s:text name="pro.admin.deluser"/></a>
</td>
</tr>
</s:iterator>
</table>
</center>
<br>
<center>
<a href='addUser.action'><s:text name="pro.admin.adduser"/></a>
</center>

  </body>
</html>
