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
	<link rel="stylesheet" type="text/css" href="../images/style.css"/>
	<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script>  
	<script type="text/javascript" src="../js/function.js"></script>
	<title>���ר����Ŀ</title>
	<script type="text/javascript">
	function checkform(){
	if(document.getElementById("lmmc").value==""){
		alert("��Ŀ���Ʋ���Ϊ�գ�");
		document.getElementById("lmmc").focus();
		return false;
	}
	if(document.getElementById("lmpx").value==""){
		alert("��Ŀ������Ϊ�գ�");
		document.getElementById("lmpx").focus();
		return false;
	}
	return true;
	}
	</script>
</head>

<body class="mainbody">
<form name="form1" method="post" action="SpecialColumnServlet?act=addSub" id="form1" onsubmit="return checkform();">
	<div class="select_box">
		<input type="submit" name="btnSubmit" value="�� ��" id="btnSubmit" class="btnSearch" />&nbsp;
		<input type="button" value="ȡ ��" class="btnSearch" onclick="parent.$.ligerDialog.close();" />
		<input type="hidden" value="${pid }" id="pid" name="pid"/>
	</div>
    <div class="tab_con" style="display:block;">
		<table class="form_table">
			<col width="150px"></col>
			<tbody>
			<tr>
				<th>ר����Ŀģ�ͣ�</th>
				<td><select name="lmmx">
				     <option value="�б�ģ��">�б�ģ��</option>
				     <option value="����ģ��">����ģ��</option>
				     <option value="����ģ��">����ģ��</option>
				    </select> *
				</td>
			</tr>
			<tr>
				<th>ר����Ŀ���ƣ�</th>
				<td><input name="lmmc" id="lmmc" type="text" value="" maxlength="100"  class="txtInput normal required" /><label>*</label></td>
			</tr>
			<tr>
				<th>ר����Ŀ����</th>
				<td><input name="lmpx" id="lmpx" type="text" value="" maxlength="100"  class="txtInput normal required" onkeyup="clearNoNum(this)" /><label>*</label></td>
			</tr>
			</tbody>
		</table>
	</div>
</form> 
</body>
</html>
