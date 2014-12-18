<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<script type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>
  <style type="text/css">
<!--
body {
	background-image: url(../img/back1.jpg);    
}
-->
</style>
</head>
  <body>
  <h2><center><s:text name="设备修改记录查询" /></center></h2>
  <center>
<s:form action="getBookoutList" namespace="/admin" method="post">
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
	<tr>
	<td>起始日期:</td>
	<td>
	 <input id="d12" name="saleDate_s" type="text"/>
     <img onclick="WdatePicker({el:$dp.$('d12')})" src="../My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
     </td></tr>
     <tr>
     <td>结束日期:</td>
     <td>
      <input id="d13" name="saleDate_e" type="text"/>
     <img onclick="WdatePicker({el:$dp.$('d13')})" src="../My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
     </td></tr>
     <input type="hidden" value="<% out.print(session.getAttribute("unit")); %>" name="b.unit">
<s:submit name="submit" key="pro.user.btn"></s:submit>
</s:form>
</center>
  </body>
</html>
