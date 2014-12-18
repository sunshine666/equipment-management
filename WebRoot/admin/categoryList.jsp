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
      <th width=""><s:text name="pro.admin.categoryid"/></th>
      <th width=""><s:text name="pro.admin.categoryname"/></th>
      <th width=""><s:text name="pro.admin.categorydesc"/></th>
      <th width=""><s:text name="pro.admin.editcategory"/></th>
       </thead>
<tbody>
<s:iterator value="categoryList">
<tr class=" trLight">
<td><s:property value="id" /></td>
<td><s:property value="name" /></td>
<td><s:property value="desc" /></td>
<td><a href='<s:url action="getCategory" namespace="/admin">
<s:param name="id" value="id"></s:param>
</s:url>'><s:text name="点击修改"/></a>
</td>
</tr>
</s:iterator>
<tr>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>点击添加新类别：</td>
<td><a href='addCategory.action'><s:text name="pro.admin.addcategory"/></a></td>
<td></td>
<td></td>
</tr>
</tbody>
</table>

</div></div>

  </body>
</html>
