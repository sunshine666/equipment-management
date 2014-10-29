<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<link href="css/css.css" rel="stylesheet" type="text/css">
  <body>
<center>
<h2><s:text name="pro.admin.publisherlist"/></h2>
<table border="1">
<tr>
<td><s:text name="pro.admin.publisherid"/></td>
<td align="center"><s:text name="pro.admin.publishername"/></td>
<td><s:text name="pro.admin.editpublisher"/></td>
</tr>
<s:iterator value="publisherList">
<tr>
<td align="center"><s:property value="id" /></td>
<td><s:property value="name" /></td>
<td><a href='<s:url action="getPublisher" namespace="/admin">
<s:param name="id" value="id"></s:param>
</s:url>'><s:text name="pro.admin.editpublisher"/></a>
</td>
</tr>
</s:iterator>
</table>
</center>
<br>
<center>
<a href='addPublisher.action'><s:text name="pro.admin.addpublisher"/></a>
</center>

  </body>
</html>
