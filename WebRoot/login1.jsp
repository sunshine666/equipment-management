<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="images/login.css" rel="stylesheet" type="text/css" />


</head>

<body>
<div id="wrap">
	<div id="header"> </div>
    <div id="content-wrap">
    	<div class="space"> </div>
   	  <s:form  action="checkLogin" namespace="/sys" ><div class="content">
        <div class="field"><label>账　户：</label><input class="loginname" name="" type="text" /></div>
		<div class="field"><label>密　码：</label><input class="loginpwd" name="" type="password" /><br /></div>
        <div class="btn"><input name="" type="submit" class="login-btn" value="" /></div>
      </div></s:form>
    </div>
    <div id="footer"> </div>
</div>
</body>
</html>