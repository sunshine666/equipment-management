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
<th><s:text name="pro.admin.publisherid"/></th>
<th><s:text name="pro.admin.publishername"/></th>
<th><s:text name="pro.admin.editpublisher"/></th>
</thead>
<tbody>
<s:iterator value="publisherList">
<tr class=" trLight">
<td align="center"><s:property value="id" /></td>
<td><s:property value="name" /></td>
<td><a href='<s:url action="getPublisher" namespace="/admin">
<s:param name="id" value="id"></s:param>
</s:url>'><s:text name="点击修改"/></a>
</td>
</tr>
</s:iterator>
<tr>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>添加新负责机构：</td>
<td><a href='addPublisher.action'><s:text name="pro.admin.addpublisher"/></a></td>
<td></td>
</tr>
</tbody>
</table>
</div></div>
  </body>
</html>
