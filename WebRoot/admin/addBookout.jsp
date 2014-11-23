<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <body>
  <h2><center><s:text name="pro.bookout" /></center></h2>
  <center>
<s:form action="addBookout" namespace="/admin" method="post">
<s:textfield name="bo.book.bookISBN" key="pro.book.ISBN" id="bookISBN" onblur="getBook()" ></s:textfield>
<s:textfield name="bo.book.bookName" key="pro.book.name" readonly="true"></s:textfield>
<s:textarea  name="desc" key="修改项说明" rows="4"></s:textarea>
<s:textfield name="bo.book.author" key="pro.book.author" ></s:textfield>
<s:select key="pro.book.publisher" name="bo.book.publisherID"  list="#session.publisherMap" listKey="key" listValue="value"></s:select>
<s:select key="pro.book.category" name="bo.book.categoryID"  list="#session.categoryMap" listKey="key" listValue="value"></s:select>
<s:textarea  name="bo.book.bookDesc" key="pro.book.desc" rows="6"></s:textarea>
<s:textfield name="bo.book.salePrice" key="pro.book.saleprice" readonly="true" id="saleprice"></s:textfield>
<s:hidden name="bo.allPrice" key="pro.book.allprice" readonly="true" id="zj"></s:hidden>
<s:textfield name="bo.operator" key="审批人"></s:textfield>
<s:textfield name="jingshou" key="经手人"></s:textfield>
<s:textfield name="bo.unit" key="机构名称" ></s:textfield>
<s:hidden name="bo.saleDate" value=""></s:hidden>
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
