<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<link rel="stylesheet" type="text/css" href="../images/style.css"/>
	<script src="../lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>  
	<link href="../lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />  
	<script src="../lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="../lib/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
    <script src="../lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
    <script src="../lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
    
    <script src="../js/function.js" type="text/javascript"></script>
  </head>
  <body class="mainbody" style="font-family:����;">
    <div class="navigation">��ҳ &gt; �ص���Ŀ���� &gt; ��Ŀ���ù���</div>
    <div style="padding:30px;">
   		<span style="font-family:����;" onclick="$.ligerDialog.open({ url: 'sz_fl.jsp',title: '��Ŀ��������', width:600, height: 400, modal:false, isResize:true });"  class="spantjbb">��Ŀ��������</span><br /><br /><br />
   		<span style="font-family:����;" onclick="$.ligerDialog.open({ url: 'sz_dq.jsp',title: '��Ŀ������������', width:600, height: 400, modal:false, isResize:true });"  class="spantjbb">��Ŀ������������</span><br /><br /><br />
   		<span style="font-family:����;" onclick="$.ligerDialog.open({ url: 'sz_bh.jsp',title: '��Ŀ�������', width:800, height: 400, modal:false, isResize:true });"  class="spantjbb">��Ŀ�������</span><br /><br /><br />
   		<span style="font-family:����;" onclick="$.ligerDialog.open({ url: 'sz_gly.jsp',title: '��Ŀ��Ϣ���±��ϱ��û�����', width:800, height: 400, modal:false, isResize:true });" class="spantjbb">��Ŀ��Ϣ���±��ϱ��û�����</span>
   	</div>
  </body>
</html>