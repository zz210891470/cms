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
<TABLE width="1600" height="40" border="0" align="center" cellPadding="0" cellSpacing="0">
	<tr style="height:50px;">
		<td align="right">
			<form name="frm" id="frm" method="post" action="" target="_blank" style=" margin:0px; padding:0px;">
                <input type="submit" name="Submit" value=" �� �� ">&nbsp;&nbsp;
              <input name="" type="button" onClick="window.open('','_parent','');top.window.close();" value=" �� �� ">
			</form>
	  </td>
	</tr>
</table>
<div id="divcontent">
<table border="1" cellpadding="0" cellspacing="0" width="1600" align="center">
	<tr style="height:28px;">
		<td align="center" colspan="28" 
			style="height:35px; line-height:35px;  font-size:14px; font-weight:bolder; color:#336699;">�ش���ĿͶ�ʹ�ģ����</td>
	</tr>
	<tr bgcolor="#eaeaea">
		<td height="70" rowspan="2" align="center" style="width:30px;">���</td>
		<td align="center" rowspan="2">��Ŀ����</td>
		<td rowspan="2" align="center" style="width:80px;">��������</td>
		<td rowspan="2" align="center" style="width:100px;">��Ŀ���</td>
		<td rowspan="2" align="center" style="width:100px;">����ص�</td>
        <td rowspan="2" align="center" style="width:80px;">��Ͷ��</td>
		<td rowspan="2" align="center" style="width:120px;">��������</td>
		<td rowspan="2" align="center" style="width:200px;">�����ģ������</td>
        <td rowspan="2" align="center" style="width:100px;">��Ŀ��������׼�������ĺ�</td>
		<td height="30" colspan="2" align="center">����Ŀ��</td>
        <td colspan="2" align="center">�����������ƻ�</td>
		<td rowspan="2" align="center" style="width:80px;">��ע</td>
	</tr>
	<tr bgcolor="#eaeaea">
	  <td height="30" align="center" style="width:80px;">�ƻ�Ͷ��(��Ԫ)</td>
	  <td align="center" style="width:200px;">����Ŀ��</td>
	  <td align="center" style="width:80px;">��������</td>
	  <td align="center" style="width:80px;">��������</td>
    </tr>
</table>
</div>

</body>
</html>