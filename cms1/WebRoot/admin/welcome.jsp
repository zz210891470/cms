<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
	<link href="images/style.css" rel="stylesheet" type="text/css" />
	<style>
	body{padding:10px;}
	#div_welcome{
		line-height:30px;
		padding:10px;
	}
	#div_loginip{
		line-height:30px;
		padding:10px;
		height:30px;
	}
	#div_loginip li{
		width:250px;
		float:left;
		line-height:30px;
	}
	#div_siteinfo{
		width:95%;
		border:solid 1px #eaeaea;
		padding:0 10px 0 10px;
		margin-top:20px;
		background-color:#EDECFF;
	}
	#div_siteinfo li{
		float:left;
		width:250px;
		line-height:40px;
	}
	</style>
</head>
<body>
	<div class="navigation">首页 &gt; 管理中心</div>
	<div id="div_welcome">你好，<b>${uname }</b>，欢迎进入后台管理中心！</div>
	<div id="div_loginip">
		<ul>
			<c:forEach items="${weblog }" var="item">
			<li>本次登录IP：${item.ip }</li>
			</c:forEach>
			<c:forEach items="${webloglast }" var="item">
			<li>上次登录IP：${item.ip }</li>
			<li>上次登录时间：<fmt:formatDate value="${item.sj }" pattern="yyyy-MM-dd" type="date" dateStyle="long" /></li>
			</c:forEach>
		</ul>
	</div>
	<div style=" margin-top:50px;" align="center">
		<img src="images/welcome.jpg" alt="" title="" />
	</div>
</body>
</html>
