<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
	<link rel="stylesheet" type="text/css" href="../images/style.css"/>
	<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script>  
	<script type="text/javascript" src="../js/function.js"></script>
	<title>咨询详情</title>
		<style>
	    body{
	        background-color:#ffffff;
	    }
	
	</style>
	
	<script type="text/javascript">
       
       function back(){
           window.parent.hideFrame();
       }
    
    </script>
</head>
<body class="mainbody">
<div class="navigation"><a href="javascript:window.parent.hideFrame();" class="back">后退</a>首页 &gt; 公众参与管理 &gt; 咨询投诉管理</div>
    <div id="contentTab">
    <ul class="tab_nav">
        <li class="selected"><a onclick="tabs('#contentTab',0);" href="javascript:;">咨询投诉信息</a></li>
    </ul>
    
    <div class="tab_con" style="display:block;">
        <table class="form_table">
            <col width="150px"></col>
            <tbody>
            <tr>
                <th>姓名：</th>
                <td>${item.xm }</td>
            </tr>
            <tr>
                <th>联系方式：</th>
                <td>${item.lxfs }</td>
            </tr>
            <tr>
                <th>编号：</th>
                <td>${item.id }</td>
            </tr>
            <tr>
                <th>标题：</th>
                <td>${item.bt }</td>
            </tr>
            <tr>
                <th height="300">内容：</th>
                <td>${item.nr }</td>
            </tr>
            <tr>
                <th height="100">答复内容：</th>
                <td>${item.hfnr }
                </td>
            </tr>
            <tr>
                <th>答复用户：</th>
                <td></td>
            </tr>
            <tr>
                <th>答复时间：</th>
                <td>${item.hfsj }</td>
            </tr>
         </tbody>
       </table>
    </div>
</div>
</body>
</html>
