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
  <h2><center><s:text name="pro.bookout" /></center></h2>
  <center>
<s:form action="addBookout" namespace="/admin" method="post">
<s:textfield name="bo.book.bookISBN" key="pro.book.ISBN" id="bookISBN" onblur="getBook()" ></s:textfield>
<s:textfield name="bo.book.bookName" key="pro.book.name" readonly="true"></s:textfield>
<s:textarea  name="desc" key="�޸���˵��" rows="4"></s:textarea>
<td>���޸������£�</td>
<s:textfield name="bo.book.author" key="pro.book.author" ></s:textfield>
<s:select key="pro.book.publisher" name="bo.book.publisherID"  list="#session.publisherMap" listKey="key" listValue="value"></s:select>
<s:select key="pro.book.category" name="bo.book.categoryID"  list="#session.categoryMap" listKey="key" listValue="value"></s:select>
<s:textfield name="bo.book.bookDesccs" key="��������" ></s:textfield>
<s:textfield name="bo.book.bookDescid" key="�������"></s:textfield>
<s:textfield name="bo.book.bookDescrq" key="�豸��������"></s:textfield>
<s:textfield name="bo.book.bookDescxh" key="�豸�ͺ�"></s:textfield>
<s:hidden name="bo.allPrice" key="pro.book.allprice" readonly="true" id="zj"></s:hidden>
<td> </td>
<s:textfield name="bo.operator" key="������"></s:textfield>
<s:textfield name="jingshou" key="������"></s:textfield>
<s:textfield name="bo.book.unit" key="��������" ></s:textfield>
<tr>
<td>����:</td>
<td>
      <input id="d13" name="bo.saleDate" type="text"/>
     <img onclick="WdatePicker({el:$dp.$('d13')})" src="../My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
    </td> </tr>
<s:submit name="submit" key="pro.user.btn"></s:submit>
</s:form></center>
  </body>
</html>

<script language="javascript">
function getBook()
{
	if(document.getElementById("bookISBN").value=="")
	{
		alert("�豸��Ų���Ϊ��!");
		return false;
	}
	else
		parent.middleFrame.location="getBook.action?bookISBN="+document.getElementById("bookISBN").value;
}

function jisuan()
{
	if(document.getElementById("salenum").value=="" || isNaN(document.getElementById("salenum").value))
	{
		alert("�����������Ϊ��,���ұ��������֣�");
		return false;
	}
	else
	{
		document.getElementById("zj").value=document.getElementById("saleprice").value*document.getElementById("salenum").value;
	}
}
</script>
