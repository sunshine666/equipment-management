<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="images/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="javascript/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	//setMenuHeight
	$('.menu').height($(window).height()-51-27-26);
	$('.sidebar').height($(window).height()-51-27-26);
	$('.page').height($(window).height()-51-27-26);
	$('.page iframe').width($(window).width()-15-168);
	
	//menu on and off
	$('.btn').click(function(){
		$('.menu').toggle();
		
		if($(".menu").is(":hidden")){
			$('.page iframe').width($(window).width()-15+5);
			}else{
			$('.page iframe').width($(window).width()-15-168);
				}
		});
		
	//
	$('.subMenu a[href="#"]').click(function(){
		$(this).next('ul').toggle();
		return false;
		});
})
</script>


</head>

<body>
<div id="wrap">
	<div id="header">
    <div class="logo fleft"></div>
    <div class="nav fleft">
    	<ul>
        	<div class="nav-left fleft"></div>
            <li class="first">您好</li>
            <li><s:property value="#session.loginname" /></li>
            <li><s:text name="pro.user.logintype" />：</li>
            <li>
            <s:set name="roleId" value="#session.roleId" />
		    <s:if test="#roleId == 1">
		    <s:text name="pro.admin" /></s:if>
		    <s:elseif test="#roleId == 2">
		    <s:text name="pro.opterator" /></s:elseif>
            </li>
            <div class="nav-right fleft"></div>
        </ul>
    </div>
    <a class="logout fright" href='<s:url action="exit.action" namespace="/sys"/>'> </a>
    <div class="clear"></div>
    <div class="subnav">
    	<div class="subnavLeft fleft"></div>
        <div class="fleft"></div>
        <div class="subnavRight fright"></div>
    </div>
    </div><!--#header -->
    <div id="content">
    <div class="space"></div>
    <div class="menu fleft">
    <s:set name="roleId" value="#session.roleId" />
    <s:if test="#roleId == 1">
    <ul>
        	<li class="subMenuTitle">功能列表</li>
        	<li class="subMenu"><a href="admin/editPwd.action" target="right">修改密码</a></li>
            <li class="subMenu"><a href='<s:url action="userList" namespace="/admin" />' target="right">用户管理</a></li>
            <li class="subMenu"><a href='<s:url action="publisherList" namespace="/admin" />' target="right">负责人管理</a></li>
            <li class="subMenu"><a href='<s:url action="categoryList" namespace="/admin" />' target="right">类别管理</a></li>
            <li class="subMenu"><a href="admin/addBookin.action" target="right">添加新设备</a></li>
            <li class="subMenu"><a href="admin/addBookout.action" target="right">设备修改</a></li>
            <li class="subMenu"><a href="#">报废处理</a>
            	<ul>
                	<li><a href='<s:url action="delBook1" namespace="/admin" />' target="right">待报废项</a></li>
                    <li><a href="admin/selectBook.jsp" target="right">已报废项</a></li>
                </ul>
            </li>
            <li class="subMenu"><a href="#">设备记录查询</a>
            	<ul>
                	<li><a href="admin/selectBookin.action" target="right">添加记录</a></li>
                    <li><a href="admin/selectBookout.action" target="right">修改记录</a></li>
                    <li><a href="admin/selectBookstore.action" target="right">设备记录</a></li>
                </ul>
            </li>
        </ul>
    </s:if>
    <s:elseif test="#roleId == 2">
    <ul>
        	<li class="subMenuTitle">功能列表</li>
            <li class="subMenu"><a href="user/editPwd.action" target="right">修改密码</a> </li>
            <li class="subMenu"><a href="user/delBook.jsp" target="right">设备报废申请</a></li>
            <li class="subMenu"><a href="user/selectBookstore.action" target="right">设备查询</a></li>
        </ul>
    </s:elseif>
    </div>
    <div class="sidebar fleft"><div class="btn"></div></div>
    <div class="page">
    <iframe width="100%" scrolling="auto" height="100%" frameborder="false" allowtransparency="true" style="border: medium none;" src="main1.html" id="rightMain" name="right"></iframe>
    </div>
    </div><!--#content -->
    <div class="clear"></div>
    <div id="footer"></div><!--#footer -->
</div><!--#wrap -->
<div style="text-align:center;">
<p>感谢使用</p>
</div>
</body>
</html>
