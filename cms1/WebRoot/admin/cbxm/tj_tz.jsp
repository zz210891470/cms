<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>�ص���Ŀ�����Ͷ�ʹ�ģ�������</title>
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
        $.post("CbxmServlet?action=getGmxxInfo&year=${year}&fz=${fz}",function(data){
        
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
			<form name="frm" id="frm" method="post" action="<%=basePath%>admin/AjaxServlet?act=gbxls" target="_blank" style=" margin:0px; padding:0px;">
                <input type="hidden" id="title" name="title" value="�ص���Ŀ�������"/>
                <input type="hidden" id="content" name="content" value=""/>
                <input type="button" onclick="xlsexport()" name="export" value=" �� �� ">
			&nbsp;&nbsp;</label>
			<input name="" type="button" onClick="window.open('','_parent','');top.window.close();" value=" �� �� ">
			</form>
	  </td>
	</tr>
</table>
<div id="divcontent">
<table border="1" cellpadding="0" cellspacing="0" width="1800" align="center"  id="tdata">
	<tr style="height:28px;">
		<td align="center" colspan="8" 
			style="height:35px; line-height:35px;  font-size:14px; font-weight:bolder; color:#336699;">������ĿͶ�ʹ�ģ����</td>
	</tr>
	<tr bgcolor="#eaeaea">
		<td height="40"  style="width:40;" align="center" style="width:30px;">���</td>
		<td  style="width:300;" align="center">��Ŀ����</td>
		<td  align="center" style="width:200;">��Ŀ�����ģ������</td>
		<td  align="center" style="width:200;">����Ч�����</td>
		<td  align="center" style="width:80;">��Ͷ��</td>
		<td align="center" style="width:40;">����ʱ��</td>
	    <td align="center" style="width:40;"  >��ϵ��</td>
	    <td align="center" style="width:40;" >��ϵ�绰</td>
		
	</tr>
	
	
</table>
</div>

</body>
</html>