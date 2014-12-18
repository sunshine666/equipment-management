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

<table width="1078" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td height="88" colspan="10"><img src="../img/logo3.gif" width="1076" border="0"/></td>
  </tr>
  <tr>
    <td width="25%" align="center">
	<a href="editPwd.action" target="middleFrame"><s:text name="pro.user.editpwd" /></a>
	</td>
	    <td width="25%" align="center">
	<a href="delBook.jsp" target="middleFrame"><s:text name="设备报废申请"/></a>
	</td>
   <!--<td width="20%" align="center"><a href="addBookin.action" target="middleFrame"><s:text name="pro.bookin" /></a></td>--> 
    <!-- <td width="20%" align="center"><a href="addBookout.action" target="middleFrame"><s:text name="pro.bookout" /></a></td>-->
    <td width="25%" align="center"><a href="selectBookstore.action" target="middleFrame">
    <s:text name="设备查询" /></a></td>
  </tr>
</table>

  </body>
</html>
