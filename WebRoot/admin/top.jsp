<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html><style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="../css/css.css" rel="stylesheet" type="text/css">
  <body>

<table width="778" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td height="88" colspan="10"><img src="../img/logo.gif" width="776" border="0"/></td>
  </tr>
  <tr>
    <td width="13%" align="center">
	<a href="editPwd.action" target="middleFrame">
	<s:text name="pro.user.editpwd" /></a>
	</td>
    <td width="14%" align="center"><a href='<s:url action="userList" namespace="/admin" />' target="middleFrame">
    <s:text name="pro.admin.usermanager" /></a></td>
    <s:hidden name="unit" value="#session.unit"></s:hidden>
    <td width="14%" align="center"><a href='<s:url action="publisherList" namespace="/admin" />' target="middleFrame">
    <s:text name="pro.admin.publishermanager" /></a></td>
    <td width="14%" align="center"><a href='<s:url action="categoryList" namespace="/admin" />' target="middleFrame">
    <s:text name="pro.admin.categorymanager" /></a></td>
    <td width="15%" align="center"><a href="selectBookin.action" target="middleFrame">
    <s:text name="pro.admin.selectbookin" /></a></td>
    <td width="16%" align="center"><a href="selectBookout.action" target="middleFrame">
    <s:text name="pro.admin.selectbookout" /></a></td>
    <td width="14%" align="center"><a href="selectBookstore.action" target="middleFrame">
    <s:text name="pro.admin.selectbookstore" /></a></td>

  </tr>
</table>

  </body>
</html>
