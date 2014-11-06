<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
  <style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(img/8.jpg);    
    background-repeat: repeat-x; 
}
-->
</style>
     <title><s:text name="pro.bookshop" /></title>
  </head> 
  <body>
  
<s:set name="roleId" value="#session.roleId" />
<s:if test="#roleId == 1">
<iframe align="center" frameborder="0" id="topFrame" scrolling="no" src="admin/top.action" width="779"  height="122"/>
</s:if>
<s:elseif test="#roleId == 2">
<iframe align="center" frameborder="0" id="topFrame" scrolling="no" src="user/top.action" width="779"  height="120"/>
</s:elseif>

<iframe align="center" frameborder="0" id="middleFrame" scrolling="auto" 
src="middle.html" width="779" name="middleFrame" height="450"/>

<iframe align="center" frameborder="0" id="bottomFrame" scrolling="no" src="bottom.action" width="779"  height="30"/>
  </body>
</html>
