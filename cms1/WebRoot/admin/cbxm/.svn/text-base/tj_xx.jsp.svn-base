<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>储备项目信息汇总</title>

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
	<script type="text/javascript" src="../js/jquery.js"></script>  
	<script>

    function xlsexport(){
    
        $("#content").val($('#tdata').html());
        $("#frm").submit();
    }


</script>
</head>

<body>
<table width="1800" height="40" border="0" align="center" cellPadding="0" cellSpacing="0">
	<tr style="height:50px;">
		<td align="right">
			<form name="frm" id="frm" method="post" action="<%=basePath%>admin/AjaxServlet?act=gbxls" target="_blank" style=" margin:0px; padding:0px;">
                <input type="hidden" id="title" name="title" value="储备项目分级汇总"/>
                <input type="hidden" id="content" name="content" value=""/>
                <input type="button" onclick="xlsexport()" name="export" value=" 导 出 ">&nbsp;&nbsp;
                <input name="" type="button" onClick="window.open('','_parent','');top.window.close();" value=" 关 闭 "/>
			</form>
	  </td>
	</tr>
</table>
<table border="1" cellpadding="0" cellspacing="0" width="1800" align="center"  id="tdata">
	<tr style="height:28px;">
		<td align="center" colspan="30" style="height:35px; line-height:35px;  font-size:14px; font-weight:bolder; color:#336699;">储备项目信息汇总</td>
	</tr>
	<tr bgcolor="#eaeaea">
		<td height="70" rowspan="2" align="center" style="width:30px;">序号</td>
		<td rowspan="2" align="center">项目名称</td>
		<td rowspan="2" align="center" style="width:80px;">所属地区</td>
		<td rowspan="2" align="center" style="width:100px;">项目类别</td>
		<td rowspan="2" align="center" style="width:100px;">建设地点</td>
		<td rowspan="2" align="center" style="width:200px;">建设规模及内容</td>
		<td rowspan="2" align="center" style="width:80px;">总投资</td>
		<td rowspan="2" align="center" style="width:200px;">经济效益分析</td>
		<td height="30" colspan="3" align="center">项目申报单位</td>
        <td colspan="3" align="center">项目策划单位</td>
		<td rowspan="2" align="center" style="width:80px;">报告书类别</td>
		<td rowspan="2" align="center" style="width:80px;">报送时间</td>
	</tr>
	<tr bgcolor="#eaeaea">
	  <td height="30" align="center" style="width:100px;">单位名称</td>
	  <td align="center" style="width:80px;">联系人</td>
	  <td align="center" style="width:80px;">联系电话</td>
	  <td align="center" style="width:100px;">单位名称</td>
	  <td align="center" style="width:80px;">联系人</td>
	  <td align="center" style="width:80px;">联系电话</td>
    </tr>
    <c:forEach items="${itemList}" var="item"  varStatus="s">
    <tr >
          <td height="25" align="center">${s.index+1 }</td>
          <td>${item.mc }</td>
          <td>${item.dq }</td>
          <td>${item.lb1 }&nbsp;${item.lb2 }</td>
          <td>${item.jsdd }</td>
          <td>${item.jsgm }</td>
          <td>${item.ztz }</td>
          <td>${item.xyfx }</td>
          <td>${item.sbdw }</td>
          <td>${item.lxr }</td>
          <td>${item.lxdh }</td>
          <td>${item.chdw }</td>
          <td>${item.lxr1 }</td>
          <td>${item.lxdh1 }</td>
          <td>${item.bgs }</td>
          <td>${item.bssj }</td>

    </tr>
    </c:forEach>
  
  
  
</table>
</body>
</html>