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
<th><s:text name="报废日期" /></th>
<th><s:text name="审批人" /></th>
<th><s:text name="经手人" /></th>
<th><s:text name="删除该项" /></th>
</thead>
<tbody>
<s:iterator value="bookoutList">
<tr class=" trLight">
<td><s:property value="book.bookISBN" /></td>
<td><s:property value="book.bookName" /></td>
<td><s:property value="saleDate" /></td>
<td><s:property value="operator" /></td>
<td><s:property value="jingshou" /></td>
<td>
<s:set name="num" value="%{book.nowNum}"/>
<s:if test="#num==0">
    <a href='<s:url action="shan" namespace="/user">
    <s:param name="bookISBN" value="book.bookISBN"></s:param>
    </s:url>'>确定</a>
</s:if>
<s:if test="#num==-1">
	已报废<s:property value="已报废"/>
</s:if>
</td>
</tr>
</s:iterator>
</tbody>
</table>
</div></div>
  </body>
</html>
