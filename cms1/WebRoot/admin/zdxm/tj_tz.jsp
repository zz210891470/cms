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
<iframe id="ifra" name="ifra" style="display:none;"></iframe>
<TABLE width="750" height="40" border="0" align="center" cellPadding="0" cellSpacing="0">
	<tr style="height:50px;">
		<td align="right">
			<form name="frm" id="frm" method="post" action="ProjectHz_fhyhz_excel.asp" target="_blank" style=" margin:0px; padding:0px;">
			<textarea name="content" id="content" cols="" rows="" style="display:none;"></textarea>
			<input type="button" name="Submit" value=" �� �� " onClick="document.getElementById('content').value=document.getElementById('divcontent').innerHTML;frm.submit();">
			&nbsp;&nbsp;</label>
			<input name="" type="button" onClick="window.open('','_parent','');top.window.close();" value=" �� �� ">
			</form>
	  </td>
	</tr>
</table>
<div id="divcontent">
<TABLE border="1" cellSpacing="0" cellPadding="0" width="1300" align="center">
	<tr>
		<td align="center" colspan="13" style="height:35px; line-height:35px; font-size:14px; font-weight:bolder; color:#336699;">
			������2014���ص���Ŀ��Ͷ�ʹ�ģ�������
		</td>
	</tr>
    <tr bgcolor="#eaeaea">
		<td align="center" width="30" height="70" rowspan="2">���</td>
		<td align="center" rowspan="2">��Ŀ����</td>
		<td align="center" width="80" rowspan="2">��ĿͶ������</td>
		<td align="center" style="width:50px;" rowspan="2">����ص�</td>
		<td align="center" style="width:80px;" rowspan="2">��Ŀ��������׼�������ĺ�</td>
		<td align="center" style="width:160px;" rowspan="2">�����ģ������</td>
		<td align="center" width="80" rowspan="2">��������</td>
		<td align="center" style="width:80px;" rowspan="2">��Ŀҵ��</td>
		<td align="center" width="80" rowspan="2">��Ͷ��(��Ԫ)</td>
		<td height="30"  colspan="2" align="center">����ƻ�Ͷ��(��Ԫ)</td>
		<td align="center" style="width:80px;" rowspan="2">�ҹ����ż��쵼</td>
		<td align="center" width="50" rowspan="2">��ע</td>
	</tr>
		<tr bgcolor="#eaeaea">
		<td width="60" height="30" align="center">Ͷ��(��Ԫ)</td>
		<td align="center" style="width:160px;">��Ҫ�������ݼ�Ŀ��</td>
	</tr>
</TABLE>
</div>

</body>
</html>