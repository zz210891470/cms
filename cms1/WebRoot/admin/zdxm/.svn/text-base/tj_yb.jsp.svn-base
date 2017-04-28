<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.trunko.cms.util.FavoritesHelper"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String nd = (String)request.getAttribute("nd"); // 年度
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
<title>重点项目建设完成投资及资金到位情况</title>
	<script type="text/javascript" src="../js/jquery.js"></script>  
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
	color: #030303;
}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<script>
    
    function xlsexport(){
    
        $("#content").val($('#tdata').html());
        $("#frm").submit();
    }


</script>
</head>

<body>

<TABLE width="1000" height="40" border="0" align="center" cellPadding="0" cellSpacing="0">
	<tr style="height:50px;">
		<td align="right">

				<form name="frm" id="frm" method="post" action="<%=basePath%>admin/AjaxServlet?act=utfxls" target="_blank" style=" margin:0px; padding:0px;">
                <input type="hidden" id="title" name="title" value="龙岩市2014年重点项目建设完成投资及资金到位情况"/>
                <input type="hidden" id="content" name="content" value=""/>
                      <div id="divHidden" style="display:none;"></div>         
                <input type="button" onclick="xlsexport()" name="Submit" value=" 导 出 ">
			&nbsp;&nbsp;
			<input name="" type="button" onClick="window.open('','_parent','');top.window.close();" value=" 关 闭 ">
			</form>
	  </td>
	</tr>
</table>
<div id="divcontent">
<table border="1" cellpadding="0" cellspacing="0" width="1000" align="center" id="tdata">
	<tr style="height:28px;">
		<td align="center" colspan="14"style="height:35px; line-height:35px; font-size:14px; font-weight:bolder; color:#336699;">
			龙岩市<%=nd %>年重点项目建设完成投资及资金到位情况
		</td>
	</tr>
	<tr bgcolor="#eaeaea">
		<td align="center" width="30" height="70" rowspan="2">序号</td>
		<td align="center" rowspan="2">项目名称</td>
		<td align="center" width="80" rowspan="2">总投资(万元)</td>
		<td align="center" width="80" rowspan="2">至<%=FavoritesHelper.isNotNull(nd)?(FavoritesHelper.stringTolong(nd)-1):"" %>年底完成投资(万元)</td>
		<td align="center" width="80" rowspan="2">年度计划投资(万元)</td>
		<td align="center" colspan="4" height="28">${fromMonth }～${toMonth }月完成投资(万元)</td>
		<td align="center" colspan="4">开工累计</td>
		<td align="center" width="50" rowspan="2">备注</td>
	</tr>
	<tr bgcolor="#eaeaea">
		<td align="center" width="60">完成投资(万元)</td>
		<td align="center" width="50">占年度计划(%)</td>
		<td align="center" width="60">到位资金(万元)</td>
		<td align="center" width="50">占年度计划(%)</td>
		<td align="center" width="60">完成投资(万元)</td>
		<td align="center" width="50">占总投资(%)</td>
		<td align="center" width="60">到位资金(万元)</td>
		<td align="center" width="50">占总投资(%)</td>
	</tr>
    ${tabledata }

</table>
</div>
</body>
</html>