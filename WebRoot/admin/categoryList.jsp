<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(img/new.jpg);   
}
-->
</style>

  <body>
<center>
<h2><s:text name="pro.admin.categorylist"/></h2>
<table border="1">
<tr>
<td><s:text name="pro.admin.categoryid"/></td>
<td><s:text name="pro.admin.categoryname"/></td>
<td><s:text name="pro.admin.categorydesc"/></td>
<td><s:text name="pro.admin.editcategory"/></td>
</tr>
<s:iterator value="categoryList">
<tr>
<td><s:property value="id" /></td>
<td><s:property value="name" /></td>
<td><s:property value="desc" /></td>
<td><a href='<s:url action="getCategory" namespace="/admin">
<s:param name="id" value="id"></s:param>
</s:url>'><s:text name="pro.admin.editcategory"/></a>
</td>
</tr>
</s:iterator>
</table>
</center>
<br>
<center>
<a href='addCategory.action'><s:text name="pro.admin.addcategory"/></a>
</center>

  </body>
</html>
