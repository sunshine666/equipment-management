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
            <li class="first">����</li>
            <li><s:property value="#session.loginname" /></li>
            <li><s:text name="pro.user.logintype" />��</li>
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
        	<li class="subMenuTitle">�����б�</li>
        	<li class="subMenu"><a href="admin/editPwd.action" target="right">�޸�����</a></li>
            <li class="subMenu"><a href='<s:url action="userList" namespace="/admin" />' target="right">�û�����</a></li>
            <li class="subMenu"><a href='<s:url action="publisherList" namespace="/admin" />' target="right">�����˹���</a></li>
            <li class="subMenu"><a href='<s:url action="categoryList" namespace="/admin" />' target="right">������</a></li>
            <li class="subMenu"><a href="admin/addBookin.action" target="right">������豸</a></li>
            <li class="subMenu"><a href="admin/addBookout.action" target="right">�豸�޸�</a></li>
            <li class="subMenu"><a href="#">���ϴ���</a>
            	<ul>
                	<li><a href='<s:url action="delBook1" namespace="/admin" />' target="right">��������</a></li>
                    <li><a href="admin/selectBook.jsp" target="right">�ѱ�����</a></li>
                </ul>
            </li>
            <li class="subMenu"><a href="#">�豸��¼��ѯ</a>
            	<ul>
                	<li><a href="admin/selectBookin.action" target="right">��Ӽ�¼</a></li>
                    <li><a href="admin/selectBookout.action" target="right">�޸ļ�¼</a></li>
                    <li><a href="admin/selectBookstore.action" target="right">�豸��¼</a></li>
                </ul>
            </li>
        </ul>
    </s:if>
    <s:elseif test="#roleId == 2">
    <ul>
        	<li class="subMenuTitle">�����б�</li>
            <li class="subMenu"><a href="user/editPwd.action" target="right">�޸�����</a> </li>
            <li class="subMenu"><a href="user/delBook.jsp" target="right">�豸��������</a></li>
            <li class="subMenu"><a href="user/selectBookstore.action" target="right">�豸��ѯ</a></li>
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
<p>��лʹ��</p>
</div>
</body>
</html>
