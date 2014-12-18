<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<link href="../images/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body {
	background:#FFF
}
</style>
</head>
  <body>
  <div id="contentWrap">
<div class="pageTitle"></div>
<div class="pageColumn">
<div class="pageButton"></div>
<table>
<thead>
<th><s:text name="pro.admin.userid"/></th>
<th><s:text name="pro.admin.username"/></th>
<th><s:text name="pro.admin.userrole"/></th>
<th><s:text name="pro.admin.editrole"/></th>
<th><s:text name="pro.admin.deluser"/></th>
</thead>
<tbody>
<s:iterator value="userList">
<s:set name="roleId" value="roleID" />
<tr class=" trLight">
<td><s:property value="id" /></td>
<td><s:property value="name" /></td>
<td><s:if test="#roleId == 1"><s:text name="pro.admin"/></s:if><s:elseif test="#roleId == 2"><s:text name="pro.opterator"/></s:elseif></td>
<td><a href='<s:url action="getUser" namespace="/admin">
<s:param name="loginname" value="name"></s:param>
</s:url>'><s:text name="设置"/></a>
</td>
<td><a href='<s:url action="delUser" namespace="/admin">
<s:param name="id" value="id"></s:param>
</s:url>'><s:text name="删除"/></a>
</td>
</tr>
</s:iterator>
<tr>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>添加新用户：</td>
<td><a href='addUser.action'><s:text name="pro.admin.adduser"/></a></td>
<td></td>
<td></td>
<td></td>
</tr>
</tbody>
</table>

</div></div>
  </body>
</html>
