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
	<link rel="stylesheet" type="text/css" href="<%=basePath%>admin/images/style.css"/>
	<script type="text/javascript" src="<%=basePath%>admin/lib/jquery/jquery-1.3.2.min.js"></script>  
	<script type="text/javascript" src="<%=basePath%>admin/js/function.js"></script>
    <script type="text/javascript">
       function back(){
           window.parent.hideFrame();
       }
    
    </script>
  </head>
  <body class="mainbody">
  	<form name="form" method="post" action="" id="form">
    <table width="100%" border="0" align="center" cellspacing="0">
			<tr>
			<td width="85%" height="30" align="center">
            	<b><font color="#336699">�������ش���Ŀ����Ϣ����  ${zdaxmyb.yf }�·�</font></b>    
            </td>
			</tr>
	  </table>
  <table border="1" width="100%"  align="center" cellspacing="0">
    <tr>
      <td height="25" style="width: 16%" align="center">��Ŀ����</td>
      <td width="75%" colspan="2">&nbsp;${zdaxm.mc }</td>
    </tr>
    <tr>
      <td height="50" style="width: 16%" align="center">�����ģ������</td>
      <td width="75%" colspan="2" style=" padding:5px; line-height:1.5;">${zdaxm.jsgm }</td>
    </tr>
    <tr>
      <td height="25" style="width: 16%" align="center">��Ͷ�ʣ���Ԫ��</td>
      <td width="75%" colspan="2">&nbsp;${zdaxm.ztz }</td>
    </tr>
    <tr>
      <td height="25" style="width: 16%" align="center">��������</td>
      <td width="75%" colspan="2">&nbsp;${zdaxm.kgn }��${zdaxm.kgy }��</td>
    </tr>
    <tr>
      <td width="100%" colspan="3" height="25" bgcolor="#FFCCCC" align="center">Ͷ������������λ����Ԫ��</td>
    </tr>
    <tr>
      <td height="25" align="center">�������</td>
      <td align="center">�����ۼ����</td>
      <td align="center">���������ۼ����</td>
    </tr>
    <tr>
      <td align="center" height="25">${zdaxmyb.bywc}</td>
      <td align="center">${zdaxmyb.nczbywc}</td>
      <td  align="center">${zdaxmyb.kgljwc}</td>
    </tr>
    <tr>
      <td width="100%" colspan="3" height="25" align="left">����ɹ����ڵ�</td>
    </tr>
    <tr>
      <td width="100%" colspan="3" height="50" style="line-height:1.5; padding:5px;">${zdaxmyb.wcgzjd}</td>
    </tr>
    <tr>
      <td width="100%" colspan="3" height="25" align="left">��Ŀ��չ���</td>
    </tr>
    <tr>
      <td width="100%" colspan="3" height="50" style="line-height:1.5; padding:5px;">${zdaxmyb.xxjd}</td>
    </tr>
    <tr>
      <td width="100%" colspan="3" height="25" align="left">��������</td>
    </tr>
    <tr>
      <td width="100%" colspan="3" height="50" style="line-height:1.5; padding:5px;">${zdaxmyb.czwt}</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="3" height="25" align="left">���¹����ƻ�</td>
    </tr>
    <tr>
      <td width="100%" colspan="3" height="50" style="line-height:1.5; padding:5px;">${zdaxmyb.gzjh}</td>
    </tr>
    <tr>
      <td width="100%" colspan="3" height="25" align="left">��ע</td>
    </tr>
    <tr>
      <td width="100%" colspan="3" height="50" style="line-height:1.5; padding:5px;">${zdaxmyb.bz}</td>
    </tr>
  </table>
  
  <div class="foot_btn_box">
    <input  type="button" value="����"  onclick="back()" class="btnSubmit"/>
    </div>
  </form>
  </body>
</html>
