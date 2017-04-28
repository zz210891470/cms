<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>重点项目分级管理汇总</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
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

    $(function(){
        $.post("ZdxmServlet?action=getXxfjhzInfo&year=${year}&fromMonth=${fromMonth}&toMonth=${toMonth}",function(data){
        
            $('#tdata').append(data);
            $("td[name]").each(function(){
                $(this).html( unescape($(this).attr("name").replace(/\\u/g,'%u')));
               
                
            })
            
        });
    
    });
    
    function show(j){
        alert(j);
    }
    
    function xlsexport(){
    
        $("#content").val($('#tdata').html());
        $("#frm").submit();
    }


</script>
</head>

<body>
<iframe id="ifra" name="ifra" style="display:none;"></iframe>
<TABLE width="750" height="40" border="0" align="center" cellPadding="0" cellSpacing="0">
	<tr style="height:50px;">
		<td align="right">
			<form name="frm" id="frm" method="post" action="<%=basePath%>admin/AjaxServlet?act=utfxls" target="_blank" style=" margin:0px; padding:0px;">
                <input type="hidden" id="title" name="title" value="龙岩市${year }年重点项目分级管理汇总"/>
                <input type="hidden" id="content" name="content" value=""/>
                <input type="button" onclick="xlsexport()" name="export" value=" 导 出 ">&nbsp;&nbsp;
                <input name="" type="button" onClick="window.open('','_parent','');top.window.close();" value=" 关 闭 ">
			</form>
	  </td>
	</tr>
</table>
<div id="divcontent">
<table border="1" cellSpacing="0" cellPadding="0" width="750" align="center" id="tdata">
	<tr>
		<td align="center" colspan="8" style="height:35px; line-height:35px; font-size:14px; font-weight:bolder; color:#336699;">
			龙岩市${year }年重点项目分级管理汇总
		</td>
	</tr>
    <tr bgColor="#eaeaea">
      <td height="40" width="250"  align="middle">地区</td>
      <td width="150" align="center">项目数</td>
      <td width="150" align="center">总投资(万元)</td>
      <td width="150" align="center">年度计划投资<br/>(万元)</td>
      <td width="150" align="center">${fromMonth }～${toMonth }月完成投资(万元)</td>
      <td width="150" align="center">占年度计划(%)</td>  
      <td width="150" align="center">${fromMonth }～${toMonth }月到位资金(万元)</td>
      <td width="150" align="center">占年度计划(%)</td>
    </tr>
    
    

     
    
</table>
</div>

</body>
</html>