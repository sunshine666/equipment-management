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
<center><h2>设备添加记录</h2></center>
<table>
<thead>
<th><s:text name="pro.book.ISBN" /></th>
<th><s:text name="pro.book.name" /></th>
<th><s:text name="pro.admin.publishername" /></th>
<th><s:text name="pro.book.author" /></th>
<th><s:text name="pro.book.category" /></th>
<th><s:text name="pro.book.saleprice" /></th>
<th><s:text name="pro.book.innum" /></th>
<th><s:text name="pro.book.buydate" /></th>
<th><s:text name="审批人" /></th>
<th><s:text name="经手人" /></th>
</thead>
<tbody>
<s:set name="publisherMap" value="#session.publisherMap" />
<s:set name="categoryMap" value="#session.categoryMap" />
<s:iterator value="bookinList">
<s:set name="pubID" value="%{book.publisherID}"/>
<s:set name="cateID" value="%{book.categoryID}"/>
<tr class=" trLight">
<td><s:property value="book.bookISBN" /></td>
<td><s:property value="book.bookName" /></td>
<td>
	<s:iterator value="#publisherMap.keySet()" id="id">
		<s:if test="#id==#pubID">
          <s:property value="#publisherMap.get(#id)"/> 
		</s:if>
    </s:iterator>
</td>
<td><s:property value="book.author" /></td>
    <s:iterator value="#categoryMap.keySet()" id="id">
		<s:if test="#id==#cateID">
         <td><s:property value="#categoryMap.get(#id)"/></td>
		</s:if>
    </s:iterator>
<td><s:property value="book.salePrice" /></td>
<td><s:property value="buyNum" /></td>
<td><s:property value="buyDate" /></td>
<td><s:property value="operator" /></td>
<td><s:property value="jingshou" /></td>
</tr>
</s:iterator>
</tbody>
</table>
</div></div>
  </body>
</html>
