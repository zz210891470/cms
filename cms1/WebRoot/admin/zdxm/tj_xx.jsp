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
<title>�ص���Ŀ����������</title>
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
                <input type="hidden" id="title" name="title" value="������${dq }${lb1 }${lb2}${nd}���ص�${condition }��Ŀ����������"/>
                <input type="hidden" id="content" name="content" value=""/>
                               
                <input type="button" onclick="xlsexport()" name="Submit" value=" �� �� ">
			&nbsp;&nbsp;</label>
			<input name="" type="button" onClick="window.open('','_parent','');top.window.close();" value=" �� �� ">
			</form>
	  </td>
	</tr>
</table>
<table border="1" cellpadding="0" cellspacing="0" width="2000" align="center" id="tdata">
	<tr style="height:28px;">
		<td align="center" colspan="28" 
			style="height:35px; line-height:35px;  font-size:14px; font-weight:bolder; color:#336699;">������${dq }${lb1 }${lb2}${nd}���ص�${condition }��Ŀ����������</td>
	</tr>
	<tr bgcolor="#eaeaea">
		<td align="center" width="30" height="70" rowspan="2">���</td>
		<td align="center" rowspan="2" width="160px">��Ŀ����</td>
		<td align="center" width="80" rowspan="2">��ĿͶ������</td>
		<td align="center" style="width:70px;" rowspan="2">����ص�</td>
		<td align="center" style="width:80px;" rowspan="2">��Ŀ��������׼�������ĺ�</td>
		<td align="center" style="width:160px;" rowspan="2">�����ģ������</td>
		<td align="center" width="80" rowspan="2">��������</td>
		<td align="center" style="width:80px;" rowspan="2">��Ŀҵ��</td>
		<td align="center" width="80" rowspan="2">��Ͷ��(��Ԫ)</td>
		<td align="center"  colspan="3" height="28">�ʽ���Դ</td>
		<td align="center" width="80" rowspan="2">�������Ͷ��(��Ԫ)</td>
		<td align="center"  colspan="2">����ƻ�Ͷ��(��Ԫ)</td>
		<td align="center"  colspan="3">��Ŀ���ɴ����������Ч��</td>
		<td align="center"  colspan="4">��Ŀ���轨���õ�(Ķ)</td>
		<td align="center"  colspan="3">Ԥ��������</td>
		<td align="center" style="width:80px;" rowspan="2">�ҹ����ż��쵼</td>
		<td align="center" width="50" rowspan="2">��ע</td>
	</tr>
	<tr bgcolor="#eaeaea">
		<td align="center" width="60">ҵ���Գ�(��Ԫ)</td>
		<td align="center" width="60">���д���(��Ԫ)</td>
        <td align="center" width="60">����Ͷ��(��Ԫ)</td>
		<td align="center" width="60">Ͷ��(��Ԫ)</td>
		<td align="center" style="width:160px;">��Ҫ�������ݼ�Ŀ��</td>
		<td align="center" width="90">��ֵ(��Ԫ)</td>
		<td align="center" width="60">˰��(��Ԫ)</td>
		<td align="center" width="50">�ṩ��ҵ��λ(��)</td>
		<td align="center" width="50">�ϼ�</td>
		<td align="center" width="50">ũ�õ�</td>
		<td align="center" width="50">���У�����ũ��</td>
		<td align="center" width="50">���У��ֵ�</td>
		<td align="center" width="50">ʩ������(��)</td>
		<td align="center" width="50">����Ʒ(��)</td>
		<td align="center" width="50">���д���(��Ԫ)</td>
	</tr>
    ${tabledata }
</table>
</body>
</html>