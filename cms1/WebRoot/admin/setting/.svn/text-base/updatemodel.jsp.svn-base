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
	<title>修改模型</title>
</head>

<body class="mainbody">
<form name="form1" method="post" action="SysModelServlet?act=update" id="form1">
	<div class="navigation"><a href="javascript:window.top.home.history.go(-1);" class="back">后退</a>首页 &gt; 系统设置管理 &gt;修改模型</div>
    
    <div class="tab_con" style="display:block;">
		<table class="form_table">
				<col width="180px"></col>
				<tbody>
				<tr>
					<input name="id" type="hidden" value="${item.id }"/>
					<th>模型标题：</th>
					<td><input name="mxbt" value="${item.mxbt}" type="text" value="" maxlength="100"  class="txtInput normal required" /><span style="color:red;">*</span></td>
				</tr>
				<tr>
					<th>模型排序：</th>
					<td><input name="mxpx" value="${item.mxpx}" type="text" value="" maxlength="100"  class="txtInput normal required" /><label>*</label></td>
				</tr>
				<tr>
					<th>是否默认：</th>
					<td>
					   <c:choose>
					   <c:when test="${xtmr=='是'}">
						<input type="radio" name="xtmr" value="是" checked="checked" />是&nbsp;&nbsp;
						<input type="radio" name="xtmr" value="否" />否 
					   </c:when> 
					   <c:otherwise> 
						<input type="radio" name="xtmr" value="是" />是&nbsp;&nbsp;
						<input type="radio" name="xtmr" value="否"  checked="checked" />否 
					   </c:otherwise>
					  </c:choose>				
					</td>
				</tr>
				</tbody>
			</table>
		</div>
    		<div class="foot_btn_box">
		<input type="submit" name="btnSubmit" value="提交保存" id="btnSubmit" class="btnSubmit" />
		&nbsp;<input  type="button" class="btnSubmit" value="返回" onclick="javascript:window.top.home.history.go(-1);" />
		</div>
</form> 
</body>
</html>
