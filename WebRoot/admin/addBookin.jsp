<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<script type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>
  <style type="text/css">
<!--
body {
	background-image: url(../img/back1.jpg);   
}
-->
</style>
  <body>
  <h2><center><s:text name="pro.bookin" /></center></h2>
  <center>
<s:form action="addBookin" namespace="/admin" method="post" enctype="multipart/form-data">
<s:textfield name="bi.book.bookISBN" key="pro.book.ISBN"></s:textfield>
<s:textfield name="bi.book.bookName" key="pro.book.name"></s:textfield>
<s:textfield name="bi.book.bookDesccs" key="生产厂商" ></s:textfield>
<s:textfield name="bi.book.bookDescid" key="出厂编号"></s:textfield>
<tr>
<td>设备生产日期:</td>
<td>
      <input id="d12" name="bi.book.bookDescrq" type="text"/>
     <img onclick="WdatePicker({el:$dp.$('d12')})" src="../My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
    </td> </tr>
<s:textfield name="bi.book.bookDescxh" key="设备型号"></s:textfield>
<s:textfield name="bi.book.author" key="pro.book.author"></s:textfield>
<s:select key="pro.book.publisher" name="bi.book.publisherID"  list="#session.publisherMap" listKey="key" listValue="value"></s:select>
<s:select key="pro.book.category" name="bi.book.categoryID"  list="#session.categoryMap" listKey="key" listValue="value"></s:select>
<s:textfield name="bi.book.salePrice" key="pro.book.saleprice"></s:textfield>
<s:textfield name="bi.buyNum" key="pro.book.innum"></s:textfield>
<s:textfield name="bi.operator" key="审批人"></s:textfield>
<s:textfield name="jingshou" key="经办人"></s:textfield>
<tr>
<td>日期:</td>
<td>
      <input id="d13" name="bi.buyDate" type="text"/>
     <img onclick="WdatePicker({el:$dp.$('d13')})" src="../My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
    </td> </tr>
<s:textfield name="bi.unit" key="所属机构"></s:textfield>
<s:file name="upload" label="图片"></s:file>
<s:submit name="submit" key="pro.user.btn"></s:submit>
</s:form></center>
  </body>
</html>
