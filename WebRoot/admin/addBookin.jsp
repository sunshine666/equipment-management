<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <body>
  <h2><center><s:text name="pro.bookin" /></center></h2>
  <center>
<s:form action="addBookin" namespace="/user" method="post" enctype="multipart/form-data">
<s:textfield name="bi.book.bookISBN" key="pro.book.ISBN"></s:textfield>
<s:textfield name="bi.book.bookName" key="pro.book.name"></s:textfield>
<s:textarea name="bi.book.bookDesc" key="pro.book.desc" rows="6"/>
<s:textfield name="bi.book.author" key="pro.book.author"></s:textfield>
<s:select key="pro.book.publisher" name="bi.book.publisherID"  list="#session.publisherMap" listKey="key" listValue="value"></s:select>
<s:select key="pro.book.category" name="bi.book.categoryID"  list="#session.categoryMap" listKey="key" listValue="value"></s:select>
<s:textfield name="bi.book.salePrice" key="pro.book.saleprice"></s:textfield>
<s:textfield name="bi.buyNum" key="pro.book.innum"></s:textfield>
<input type="hidden" value="<% out.print(session.getAttribute("loginname")); %>" name="bi.operator">
<s:hidden name="bi.buyDate" value=""></s:hidden>
<s:textfield name="bi.unit" key="所属机构"></s:textfield>
<s:file name="upload" label="图片"></s:file>
<s:submit name="submit" key="pro.user.btn"></s:submit>
</s:form></center>
  </body>
</html>
