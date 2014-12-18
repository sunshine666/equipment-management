<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
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

<table width="1078" border="1"  align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="70" colspan="11"><img src="../img/logo3.gif" width="1077" border="0"/></td>
  </tr>
  <tr>
    <td width="9%" align="center">
	<a href="editPwd.action" target="middleFrame">
	<s:text name="pro.user.editpwd" /></a>
	</td>
    <td width="9%" align="center"><a href='<s:url action="userList" namespace="/admin" />' target="middleFrame">
    <s:text name="pro.admin.usermanager" /></a></td>
    <s:hidden name="unit" value="#session.unit"></s:hidden>
    <td width="9%" align="center"><a href='<s:url action="publisherList" namespace="/admin" />' target="middleFrame">
    <s:text name="pro.admin.publishermanager" /></a></td>
    <td width="9%" align="center"><a href='<s:url action="categoryList" namespace="/admin" />' target="middleFrame">
    <s:text name="pro.admin.categorymanager" /></a></td>
    <td width="9%" align="center"><a href="addBookin.action" target="middleFrame">
    <s:text name="添加设备" /></a></td>
    <td width="9%" align="center"><a href="addBookout.action" target="middleFrame">
    <s:text name="设备修改" /></a></td>
    <td width="9%" align="center"><a href='<s:url action="delBook1" namespace="/admin" />' target="middleFrame">
    <s:text name="报废审核" /></a></td>
    <td width="9%" align="center"><a href="selectBook.jsp" target="middleFrame">
    <s:text name="报废查询" /></a></td>
    <td width="9%" align="center"><a href="selectBookin.action" target="middleFrame">
    <s:text name="pro.admin.selectbookin" /></a></td>
    <td width="9%" align="center"><a href="selectBookout.action" target="middleFrame">
    <s:text name="pro.admin.selectbookout" /></a></td>
    <td width="9%" align="center"><a href="selectBookstore.action" target="middleFrame">
    <s:text name="pro.admin.selectbookstore" /></a></td>

  </tr>
</table>

  </body>
</html>
