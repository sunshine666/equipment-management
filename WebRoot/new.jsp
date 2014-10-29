<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head> 
  <body>
  <h2><center>添加用户</center></h2>
    <center>
    <a href='login.jsp'>返回登陆界面</a>
    <s:form action="addnewone" namespace="/" method="post">
    <s:textfield name="u.name" label="名字"></s:textfield>
    <s:textfield name="u.pwd" label="密码"></s:textfield>
    <s:hidden name="u.roleID" value='1'></s:hidden>
    <s:textfield name="u.unit" label="单位名"></s:textfield>
    <s:submit value="确定"></s:submit>
    </s:form>
    </center>
  </body>
</html>
