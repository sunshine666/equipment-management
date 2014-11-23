<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
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
<s:textfield name="bi.operator" key="审批人"></s:textfield>
<s:textfield name="jingshou" key="经手人"></s:textfield>
<s:hidden name="bi.buyDate" value=""></s:hidden>
<s:textfield name="bi.unit" key="所属机构"></s:textfield>
<s:file name="upload" label="图片"></s:file>
<s:submit name="submit" key="pro.user.btn"></s:submit>
</s:form></center>
  </body>
</html>
