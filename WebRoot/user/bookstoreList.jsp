<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <body>
<center>
<h2>设备库存记录列表</h2>
<table border="1">
<tr>
<td><s:text name="pro.book.ISBN"/></td>
<td><s:text name="设备图片"/></td>
<td><s:text name="pro.book.name"/></td>
<td><s:text name="pro.book.publisher"/></td>
<td><s:text name="pro.book.author"/></td>
<td><s:text name="pro.book.category"/></td>
<td><s:text name="pro.book.saleprice"/></td>
<td><s:text name="pro.admin.nownum"/></td>
<td><s:text name="pro.admin.bookstatus"/></td>
</tr>
<s:set name="publisherMap" value="#session.publisherMap" />
<s:set name="categoryMap" value="#session.categoryMap" />
<s:iterator value="bookstoreList">
<s:set name="pubID" value="%{publisherID}"/>
<s:set name="cateID" value="%{categoryID}"/>
<tr>
<td><s:property value="bookISBN" /></td>
<td><img src="<s:property value="'../uploadList/'+picadr"/>" width="100" height="100" /></td>
<td><s:property value="bookName" /></td>
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
<td><s:property value="nowNum" /></td>
<td>
<s:set name="statu" value="%{status}"/>
<s:if test="#statu==0">
	停止暂停<s:property value="停止销售"/>
</s:if>
<s:if test="#statu==1">
	正常使用<s:property value="正常销售"/>
</s:if>
</td>
</tr>
</s:iterator>
</table>
</center>
  </body>
</html>


            