<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<link href="../images/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body {
	background:#FFF
}
</style>
</head>
  <body>
<div id="contentWrap">
<div class="pageTitle"></div>
<div class="pageColumn">
<div class="pageButton"></div>
<center><h2>设备记录</h2></center>
<table>
<thead>
<th><s:text name="pro.book.ISBN"/></th>
<th><s:text name="设备图片"/></th>
<th><s:text name="pro.book.name"/></th>
<th><s:text name="生产厂商"/></th>
<th><s:text name="出厂编号"/></th>
<th><s:text name="出厂日期"/></th>
<th><s:text name="型号"/></th>
<th><s:text name="pro.book.publisher"/></th>
<th><s:text name="pro.book.author"/></th>
<th><s:text name="pro.book.category"/></th>
<th><s:text name="pro.book.saleprice"/></th>
<th><s:text name="pro.admin.nownum"/></th>
<th>报废</th>
</thead>
<tbody>
<s:set name="publisherMap" value="#session.publisherMap" />
<s:set name="categoryMap" value="#session.categoryMap" />
<s:iterator value="bookstoreList">
<s:set name="pubID" value="%{publisherID}"/>
<s:set name="cateID" value="%{categoryID}"/>
<tr class=" trLight">
<td><s:property value="bookISBN" /></td>
<td><img src="<s:property value="'../uploadList/'+picadr"/>" width="100" height="100" /></td>
<td><s:property value="bookName" /></td>
<td><s:property value="bookDesccs" /></td>
<td><s:property value="bookDescid" /></td>
<td><s:property value="bookDescrq" /></td>
<td><s:property value="bookDescxh" /></td>
    <s:iterator value="#publisherMap.keySet()" id="id">
		<s:if test="#id==#pubID">
         <td><s:property value="#publisherMap.get(#id)"/></td>
		</s:if>
    </s:iterator>
<td><s:property value="author" /></td>
    <s:iterator value="#categoryMap.keySet()" id="id">
		<s:if test="#id==#cateID">
         <td><s:property value="#categoryMap.get(#id)"/></td>
		</s:if>
    </s:iterator>
<td><s:property value="salePrice" /></td>
<td>
<s:set name="num" value="%{nowNum}"/>
<s:if test="#num==1">
	<s:property value="nowNum"/>
</s:if>
<s:if test="#num==0">
	待审核<s:property value="待审核"/>
</s:if>
<s:if test="#num==-1">
	已报废<s:property value="已报废"/>
</s:if>
</td>
 <td>
 <s:if test="#num==1">
 <a href='<s:url action="getBook" namespace="/user">
    <s:param name="bookISBN" value="bookISBN"></s:param>
    </s:url>'>报废</a>
    </s:if> 
    </td>
</tr>
</s:iterator>
<tr>
<td>数量共计：</td>
<td><s:property value="nnn" /></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>总价：</td>
<td><s:property value="allprice"/></td>
<td></td>
</tr>
</tbody>
</table>
</div></div>
  </body>
</html>



            