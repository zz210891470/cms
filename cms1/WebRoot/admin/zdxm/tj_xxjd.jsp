<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>重点项目建设形象进度</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script> 
	<script>
	    
	    function xlsexport(){
		    var tdataHtml = document.getElementById("tdata").innerHTML;
		    alert(tdataHtml);
		    document.getElementById("content").value = tdataHtml;
		    document.getElementById("frm").submit();
	    }
	
	
	</script>
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
	
  </head>
  
  <body>
	  <TABLE width="1800" height="40" border="0" align="center" cellPadding="0" cellSpacing="0">
		<tr style="height:50px;">
			<td align="right">
				<form name="frm" id="frm" method="post" action="<%=basePath%>admin/AjaxServlet?act=utfxls" target="_blank" style=" margin:0px; padding:0px;">
	                <input type="hidden" id="title" name="title" value="龙岩市${nd }年重点项目建设基本情况"/>
	                <input type="hidden" id="content" name="content" value=""/>
	                               
	                <input type="button" onclick="xlsexport()" name="Submit" value=" 导 出 ">
				&nbsp;&nbsp;</label>
				<input name="" type="button" onClick="window.open('','_parent','');top.window.close();" value=" 关 闭 ">
				</form>
		  </td>
		</tr>
	</table>
    <table border="1" cellpadding="0" cellspacing="0" width="1800" align="center" id="tdata">
	<tr style="height:28px;">
		<td align="center" colspan="19"style=" font-size:14px; font-weight:bolder; color:#336699;">
			龙岩市${nd }年重点项目建设形象进度
		</td>
	</tr>
	<tr bgcolor="#eaeaea">
		<td align="center" width="30" height="70" rowspan="2">序号</td>
		<td align="center" rowspan="2" width="8%">项目名称</td>
		<td align="center" width="80" rowspan="2">总投资(万元)</td>
		<td align="center" width="80" rowspan="2">至${nd-1 }年底完成投资(万元)</td>
		<td align="center" width="80" rowspan="2">年度计划投资(万元)</td>
		<td align="center" colspan="4" height="28">${fromMonth }～${toMonth }月完成投资(万元)</td>
		<td align="center" colspan="4">开工累计</td>
		<td align="center" style="width:150px;" rowspan="2">年初至本月的主要形象进度</td>
		<td align="center"  width="8%" rowspan="2">开工、竣工投产时间、内容及新增生产能力</td>
		<td align="center" style="width:80px;" rowspan="2">项目推进中存在的问题及拟采取的措施和办法</td>
		<td align="center" style="width:80px;" rowspan="2">需要政府及有关部门协调解决的问题</td>
		<td align="center" style="width:80px;" rowspan="2">下个月（季度）工作计划、安排</td>
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
  </body>
</html>
