<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//分级统计信息集合
	Map<String, List<String>> areaInfoMap = (Map)request.getAttribute("areaInfoMap");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title></title>
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
<iframe id="ifra" name="ifra" style="display:none;"></iframe>
<TABLE width="750" height="40" border="0" align="center" cellPadding="0" cellSpacing="0">
	<tr style="height:50px;">
		<td align="right">
			<form name="frm" id="frm" method="post" action="<%=basePath%>admin/AjaxServlet?act=gbxls" target="_blank" style=" margin:0px; padding:0px;">
                <input type="hidden" id="title" name="title" value="储备项目分级汇总"/>
                <input type="hidden" id="content" name="content" value=""/>
                <input type="button" onclick="xlsexport()" name="export" value=" 导 出 ">&nbsp;&nbsp;
                <input name="" type="button" onClick="window.open('','_parent','');top.window.close();" value=" 关 闭 ">
			</form>
	  </td>
	</tr>
</table>
<div id="divcontent">
<TABLE border="1" cellSpacing="0" cellPadding="0" width="750" align="center"  id="tdata">
	<tr>
		<td align="center" colspan="8" style="height:35px; line-height:35px; font-size:14px; font-weight:bolder; color:#336699;">
			储备项目分级汇总
		</td>
	</tr>
    <TR bgColor="#eaeaea">
      <TD height="40" align="middle">地区名称</TD>
      <TD width="80" align="center">项目数</TD>
      <TD width="80" align="center">总投资</TD>
    </TR>
    <%
	    if(!areaInfoMap.isEmpty()){
	    	// 遍历分级统计信息
		    for (Iterator iterator = areaInfoMap.keySet().iterator(); iterator.hasNext();) {
				String areaName = (String) iterator.next(); // 地区名称
				List<String> countList = areaInfoMap.get(areaName); // 地区所对应的统计信息：项目总数、总投资值
	%> 
		<TR>
	    <TD height="40" align="middle"><%=areaName %></TD>
	    <TD width="80" align="center"><%=countList.get(0) %></TD>
	    <TD width="80" align="center"><%=countList.get(1) %></TD>
	  </TR>
	<%			
			}
	    }
    
    %>
</TABLE>
</div>

</body>
</html>