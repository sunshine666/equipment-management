<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <body>
  <h2><center><s:text name="�豸����" /></center></h2>
  <center>
<s:form action="delBook" namespace="/user" method="post">
<s:textfield name="bo.book.bookISBN" key="pro.book.ISBN" id="bookISBN" onblur="getBook()" ></s:textfield>
<s:textfield name="bo.book.bookName" key="pro.book.name" readonly="true"></s:textfield>
<s:textarea  name="desc" key="����ԭ��" rows="6"></s:textarea>
<s:textfield name="bo.operator" key="������"></s:textfield>
<s:textfield name="jingshou" key="������"></s:textfield>
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
		alert("�豸��Ų���Ϊ��!");
		return false;
	}
	else
		parent.middleFrame.location="getBook1.action?bookISBN="+document.getElementById("bookISBN").value;
}
</script>
