<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <body>
<center>
<h2><s:text name="pro.book.salelist" /></h2>
<table border="1">
<tr>
<td><s:text name="pro.book.ISBN" /></td>
<td><s:text name="pro.book.name" /></td>
<td><s:text name="pro.admin.publishername" /></td>
<td><s:text name="pro.book.author" /></td>
<td><s:text name="pro.book.category" /></td>
<td><s:text name="pro.book.saleprice" /></td>
<td><s:text name="pro.book.salenum" /></td>
<td><s:text name="pro.book.allprice" /></td>
<td><s:text name="pro.book.saledate" /></td>
<td><s:text name="pro.opterator" /></td>
</tr>
<s:set name="publisherMap" value="#session.publisherMap" />
<s:set name="categoryMap" value="#session.categoryMap" />
<s:iterator value="bookoutList">
<s:set name="pubID" value="%{book.publisherID}"/>
<s:set name="cateID" value="%{book.categoryID}"/>
<tr>
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
<td>
    <s:iterator value="#categoryMap.keySet()" id="id">
		<s:if test="#id==#cateID">
         <s:property value="#categoryMap.get(#id)"/>
		</s:if>
    </s:iterator>
</td>
<td><s:property value="book.salePrice" /></td>
<td><s:property value="SaleNum" /></td>
<td><s:property value="allPrice" /></td>
<td><s:property value="saleDate" /></td>
<td><s:property value="operator" /></td>
</tr>
</s:iterator>
</table>
</center>


  </body>
</html>
