<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <body>
  <h2><center><s:text name="pro.bookout" /></center></h2>
  <center><a href="selectBookstore.action">设备查询</a></center>
  <center>
<s:form action="addBookout" namespace="/user" method="post">
<s:textfield name="bo.book.bookISBN" key="pro.book.ISBN" id="bookISBN" onblur="getBook()" ></s:textfield>
<s:textfield name="bo.book.bookName" key="pro.book.name" readonly="true"></s:textfield>
<s:textfield name="bo.book.author" key="pro.book.author" readonly="true"></s:textfield>
<s:textfield name="bo.book.bookDesc" key="pro.book.desc" readonly="true"></s:textfield>
<s:textfield name="bo.book.salePrice" key="pro.book.saleprice" readonly="true" id="saleprice"></s:textfield>
<s:textfield name="bo.SaleNum" key="pro.book.salenum" onblur="jisuan()" id="salenum"></s:textfield>
<s:hidden name="bo.allPrice" key="pro.book.allprice" readonly="true" id="zj"></s:hidden>
<input type="hidden" value="<% out.print(session.getAttribute("loginname")); %>" name="bo.operator">
<input type="hidden" value="<% out.print(session.getAttribute("unit")); %>" name="bo.unit">
<tr>
<td>日期:</td>
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
		alert("设备编号不能为空!");
		return false;
	}
	else
		parent.middleFrame.location="getBook.action?bookISBN="+document.getElementById("bookISBN").value;
}

function jisuan()
{
	if(document.getElementById("salenum").value=="" || isNaN(document.getElementById("salenum").value))
	{
		alert("借出数量不能为空,而且必须是数字！");
		return false;
	}
	else
	{
		document.getElementById("zj").value=document.getElementById("saleprice").value*document.getElementById("salenum").value;
	}
}
</script>
