<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <body>
<center>
<h2>�豸����¼�б�</h2>
<table border="1">
<tr>
<td><s:text name="pro.book.ISBN"/></td>
<td><s:text name="�豸ͼƬ"/></td>
<td><s:text name="pro.book.name"/></td>
<td><s:text name="�豸��ϸ����"/></td>
<td><s:text name="pro.book.publisher"/></td>
<td><s:text name="pro.book.author"/></td>
<td><s:text name="pro.book.category"/></td>
<td><s:text name="pro.book.saleprice"/></td>
<td><s:text name="pro.admin.nownum"/></td>
<td><s:text name="pro.admin.bookstatus"/></td>
<td><s:text name="ɾ��/�ָ�"/></td>
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
<td><s:property value="bookDesc" /></td>
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
<s:if test="#num==-1">
	�ѱ���<s:property value="�ѱ���"/>
</s:if>
</td>
<td>
<s:set name="statu" value="%{status}"/>
<s:if test="#statu==0">
	ɾ��״̬<s:property value="ֹͣ����"/>
</s:if>
<s:if test="#statu==1">
	����<s:property value="��������"/>
</s:if>
</td>
 <td><a href='<s:url action="delep" namespace="/admin">
    <s:param name="myid" value="bookISBN"></s:param>
    <s:param name="mystatus" value="status"></s:param>
    </s:url>'>ɾ��/�ָ�</a></td>
</tr>
</s:iterator>
</table>
</center>
  </body>
</html>


            