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
<th><s:text name="pro.book.ISBN" /></th>
<th><s:text name="pro.book.name" /></th>
<th><s:text name="上报日期" /></th>
<th><s:text name="经办人" /></th>
<th><s:text name="审批人" /></th>
<th><s:text name="添加该项" /></th>
<th><s:text name="删除该项" /></th>
</thead>
<tbody>
<s:iterator value="bookoutList">
<tr class=" trLight">
<td><s:property value="book.bookISBN" /></td>
<td><s:property value="book.bookName" /></td>
<td><s:property value="saleDate" /></td>
<td><s:property value="jingshou" /></td>
<td><s:property value="operator" /></td>
<td>
    <a href='<s:url action="getBookout" namespace="/admin">
    <s:param name="bookISBN" value="book.bookISBN"></s:param>
    </s:url>'>确定</a>
</td>
<td>
    <a href='<s:url action="shan2" namespace="/admin">
    <s:param name="bookISBN" value="book.bookISBN"></s:param>
    </s:url>'>确定</a>
</td>
</tr>
</s:iterator>
</tbody>
</table>
</div></div>
  </body>
</html>
