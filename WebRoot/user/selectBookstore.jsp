<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<s:head />
  <body>
  <h2><center><s:text name="设备库存记录查询"/></center></h2>
  <center>
<s:form action="getBookstoreList" namespace="/user" method="post">
	<s:textfield key="pro.book.ISBN" name="b.bookISBN"></s:textfield>
	<s:textfield key="pro.book.name" name="b.bookName"></s:textfield>
	<s:select key="pro.book.publisher" name="b.publisherID"  list="#session.publisherMap" 
	 emptyOption="true" 
	 listKey="key" listValue="value">
	</s:select>
	<s:select key="pro.book.category" name="b.categoryID"  list="#session.categoryMap"
	emptyOption="true"  
	listKey="key" listValue="value">
	</s:select>
	<input type="hidden" value="<% out.print(session.getAttribute("unit")); %>" name="b.unit">
<s:submit key="pro.user.btn"></s:submit>
</s:form>
</center>
  </body>
</html>
