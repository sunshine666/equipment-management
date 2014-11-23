<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <body>
<center>
<h2><s:text name="pro.book.salelist" /></h2>
<table border="1">
<tr>
<td><s:text name="pro.book.ISBN" /></td>
<td><s:text name="pro.book.name" /></td>
<td><s:text name="修改项" /></td>
<td><s:text name="pro.admin.publishername" /></td>
<td><s:text name="pro.book.author" /></td>
<td><s:text name="pro.book.category" /></td>
<td><s:text name="pro.book.saleprice" /></td>
<td><s:text name="pro.book.saledate" /></td>
<td><s:text name="审批人" /></td>
<td><s:text name="经手人" /></td>
</tr>
<s:set name="publisherMap" value="#session.publisherMap" />
<s:set name="categoryMap" value="#session.categoryMap" />
<s:iterator value="bookoutList">
<s:set name="pubID" value="%{book.publisherID}"/>
<s:set name="cateID" value="%{book.categoryID}"/>
<tr>
<td><s:property value="book.bookISBN" /></td>
<td><s:property value="book.bookName" /></td>
<td><s:property value="deldesc" /></td>
<td>
	<s:iterator value="#publisherMap.keySet()" id="id">
		<s:if test="#id==#pubID">
          <s:property value="#publisherMap.get(#id)"/> 
		</s:if>
    </s:iterator>
</td>
<td><s:property value="book.author" /></td>
<td>
    <s:iterator value="#categoryMap.keySet()" id="id">
		<s:if test="#id==#cateID">
         <s:property value="#categoryMap.get(#id)"/>
		</s:if>
    </s:iterator>
</td>
<td><s:property value="book.salePrice" /></td>
<td><s:property value="saleDate" /></td>
<td><s:property value="operator" /></td>
<td><s:property value="jingshou" /></td>
</tr>
</s:iterator>
</table>
</center>


  </body>
</html>
