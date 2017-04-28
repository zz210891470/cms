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
<title>重点项目建设基本情况</title>
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
<TABLE width="2000" height="40" border="0" align="center" cellPadding="0" cellSpacing="0">
	<tr style="height:50px;">
		<td align="right">
			<form name="frm" id="frm" method="post" action="<%=basePath%>admin/AjaxServlet?act=utfxls" target="_blank" style=" margin:0px; padding:0px;">
                <input type="hidden" id="title" name="title" value="龙岩市${dq }${lb1 }${lb2}${nd}年重点${condition }项目建设基本情况"/>
                <input type="hidden" id="content" name="content" value=""/>
                               
                <input type="button" onclick="xlsexport()" name="Submit" value=" 导 出 ">
			&nbsp;&nbsp;</label>
			<input name="" type="button" onClick="window.open('','_parent','');top.window.close();" value=" 关 闭 ">
			</form>
	  </td>
	</tr>
</table>
<table border="1" cellpadding="0" cellspacing="0" width="2000" align="center" id="tdata">
	<tr style="height:28px;">
		<td align="center" colspan="28" 
			style="height:35px; line-height:35px;  font-size:14px; font-weight:bolder; color:#336699;">龙岩市${dq }${lb1 }${lb2}${nd}年重点${condition }项目建设基本情况</td>
	</tr>
	<tr bgcolor="#eaeaea">
		<td align="center" width="30" height="70" rowspan="2">序号</td>
		<td align="center" rowspan="2" width="160px">项目名称</td>
		<td align="center" width="80" rowspan="2">项目投资主体</td>
		<td align="center" style="width:70px;" rowspan="2">建设地点</td>
		<td align="center" style="width:80px;" rowspan="2">项目审批、核准、备案文号</td>
		<td align="center" style="width:160px;" rowspan="2">建设规模及内容</td>
		<td align="center" width="80" rowspan="2">建设年限</td>
		<td align="center" style="width:80px;" rowspan="2">项目业主</td>
		<td align="center" width="80" rowspan="2">总投资(万元)</td>
		<td align="center"  colspan="3" height="28">资金来源</td>
		<td align="center" width="80" rowspan="2">上年完成投资(万元)</td>
		<td align="center"  colspan="2">今年计划投资(万元)</td>
		<td align="center"  colspan="3">项目建成达产后年新增效益</td>
		<td align="center"  colspan="4">项目共需建设用地(亩)</td>
		<td align="center"  colspan="3">预计年用量</td>
		<td align="center" style="width:80px;" rowspan="2">挂钩部门及领导</td>
		<td align="center" width="50" rowspan="2">备注</td>
	</tr>
	<tr bgcolor="#eaeaea">
		<td align="center" width="60">业主自筹(万元)</td>
		<td align="center" width="60">银行贷款(万元)</td>
        <td align="center" width="60">政府投资(万元)</td>
		<td align="center" width="60">投资(万元)</td>
		<td align="center" style="width:160px;">主要建设内容及目标</td>
		<td align="center" width="90">产值(万元)</td>
		<td align="center" width="60">税收(万元)</td>
		<td align="center" width="50">提供就业岗位(个)</td>
		<td align="center" width="50">合计</td>
		<td align="center" width="50">农用地</td>
		<td align="center" width="50">其中：基本农田</td>
		<td align="center" width="50">其中：林地</td>
		<td align="center" width="50">施工用油(吨)</td>
		<td align="center" width="50">火工用品(吨)</td>
		<td align="center" width="50">银行贷款(万元)</td>
	</tr>
    ${tabledata }
</table>
</body>
</html>