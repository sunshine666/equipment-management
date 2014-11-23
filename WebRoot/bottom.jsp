<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html><style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(img/z3.jpg);   
}
-->
</style>
<link href="css/css.css" rel="stylesheet" type="text/css">
<body>
<center>
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
  </tr>
  <tr>
    <td width="17%" align="right" style="color:#3399FF"><s:text name="pro.user.logintype" />：</td>
    <td width="10%" align="left">
		<s:set name="roleId" value="#session.roleId" />
		<s:if test="#roleId == 1">
		<b><s:text name="pro.admin" /></b></s:if>
		<s:elseif test="#roleId == 2">
		<b><s:text name="pro.opterator" /></b></s:elseif>
    </td>
    <td width="16%" align="right" style="color:#3399FF"><s:text name="pro.user.loginname" />：</td>
    <td width="11%" align="left"><b><s:property value="#session.loginname" /></b></td>
    <td width="15%" align="right" style="color:#3399FF"><s:text name="pro.user.logintime" />：</td>
    <td width="21%" align="left">
    <b><s:property value="#session.loginTime" /></b></td>
    <td width="10%" align="center"><a href='<s:url action="exit.action" namespace="/sys"/>' target="_parent">
	<s:text name="pro.user.exit" /></a></td>
  </tr>
</table>
</center>
  </body>
</html>
