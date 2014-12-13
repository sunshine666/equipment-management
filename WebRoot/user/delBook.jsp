<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <body>
  <h2><center><s:text name="设备报废" /></center></h2>
  <center>
<s:form action="delBook" namespace="/user" method="post">
<s:textfield name="bo.book.bookISBN" key="pro.book.ISBN" id="bookISBN" onblur="getBook()" ></s:textfield>
<s:textfield name="bo.book.bookName" key="pro.book.name" readonly="true"></s:textfield>
<s:textarea  name="desc" key="报废原因" rows="6"></s:textarea>
<s:textfield name="bo.operator" key="审批人"></s:textfield>
<s:textfield name="jingshou" key="经手人"></s:textfield>
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
		parent.middleFrame.location="getBook1.action?bookISBN="+document.getElementById("bookISBN").value;
}
</script>
