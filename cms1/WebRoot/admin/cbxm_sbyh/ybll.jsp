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
	<link rel="stylesheet" type="text/css" href="../images/style.css"/>
	<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script>  
	<script type="text/javascript" src="../js/function.js"></script>
    <script type="text/javascript">
       function save(){
           $("#form").submit();
       }
       
       function back(){
           window.parent.hideFrame();
       }
    
    </script>
  </head>
  <body class="mainbody">
  	<form name="form" method="post" action="" id="form">
    <table width="100%" border="0" align="center" cellspacing="0">
			<tr>
			<td width="85%" height="30">
			<p align="center"><b><font color="#336699">�������ص���Ŀ����Ϣ����   
                <span id="ctl00_ContentPlaceHolder1_lbl_year">2014��3��</span></font></b></td>
			</tr>
	  </table>
  <table border="1" width="100%"  align="center" cellspacing="0" bgcolor="#f0f8ff" 
                    bordercolorlight="#666666" bordercolordark="#FFFFFF">
    <tr>
      <td height="30" style="width: 16%">
        <p align="center">��Ŀ����</p>
      </td>
      <td width="75%" colspan="5">&nbsp;</td>
    </tr>
    <tr>
      <td height="30" style="width: 16%">
        <p align="center">�����ģ������</p>
      </td>
      <td width="75%" colspan="5" style=" padding:5px; line-height:1.5;">&nbsp;</td>
    </tr>
    <tr>
      <td height="30" style="width: 16%">
        <p align="center">��Ͷ�ʣ���Ԫ��</p>
      </td>
      <td width="75%" colspan="5">&nbsp;</td>
    </tr>
    <tr>
      <td height="30" style="width: 16%">
        <p align="center">��������</p>
      </td>
      <td width="75%" colspan="5">&nbsp;</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="30" bgcolor="#FFCCCC">
        <p align="left">�ʽ���Դ����λ�������λ����Ԫ��</p>
      </td>
    </tr>
    <tr>
      <td style="width: 16%" height="28">
        <p align="center">��Ͷ����Դ������</p>
      </td>
      <td width="15%">
        <p align="center">��Ͷ��</p>
      </td>
      <td width="14%">
        <p align="center">����ƻ�Ͷ��</p>
      </td>
      <td width="15%">
        <p align="center">���µ�λ�ʽ�</p>
      </td>
      <td width="15%">
        <p align="center">�����ۼƵ�λ�ʽ�</p>
      </td>
      <td width="19%" align="center">���������ۼƵ�λ�ʽ�</td>
    </tr>
    <tr>
      <td align="center" style="width: 16%" height="28">
          ҵ���Գ�</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
    </tr>
    
    <tr>
      <td align="center" style="width: 16%" height="28">
          ���д���</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
    </tr>
 
     <tr>
      <td align="center" style="width: 16%" height="28">
          ����Ͷ��</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
    </tr>
 
    <tr>
      <td height="28" style="width: 16%">
        <p align="center">��&nbsp;&nbsp;&nbsp; ��</p>
      </td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="30" bgcolor="#FFCCCC">
        <p align="left">Ͷ������������λ����Ԫ��</p>
      </td>
    </tr>
    <tr>
      <td width="40%" colspan="2" height="30">
        <p align="center">�������</p>
      </td>
      <td width="30%" colspan="2">
        <p align="center">�����ۼ����</p>
      </td>
      <td width="30%" colspan="2">
        <p align="center">���������ۼ����</p>
      </td>
    </tr>
    <tr>
      <td width="40%" height="28" colspan="2" align="center">&nbsp;</td>
      <td width="30%" colspan="2" align="center">&nbsp;</td>
      <td width="30%" colspan="2" align="center">&nbsp;</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25">
        <p align="left">��������������Ⱥ��ѿ�չ����Ҫ����</p>
      </td>
    </tr>
    <tr>
      <td width="100%" height="60" colspan="6">&nbsp;</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25">
        <p align="left">����������Ͷ��ʱ�䡢���ݼ�������������</td>
    </tr>
    <tr>
      <td width="100%" height="60" colspan="6">&nbsp;</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25">
        <p align="left">��Ŀ�ƽ��д��ڵ����⼰���ȡ�Ĵ�ʩ�Ͱ취</p>
      </td>
    </tr>
    <tr>
      <td width="100%" height="60" colspan="6">&nbsp;</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6" height="25">
        <p align="left">��Ҫ�������йز���Э�����������</td>
    </tr>
    
    <tr>
      <td width="100%" height="60" colspan="6">&nbsp;</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6" height="25">
        <p align="left">�¸��£����ȣ������ƻ�������</td>
    </tr>
    
    <tr>
      <td width="100%" height="60" colspan="6">&nbsp;</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6" height="25">
        <p align="left">�ν���λ�½������</td>
    </tr>
    
    <tr>
      <td width="100%" height="60" colspan="6">&nbsp;</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6" height="25">
        <p align="left">�ʽ�˵���������ʽ��Ƿ���ʵ����λ�ʽ��Ƿ����㽨����Ҫ����ڵ������ʽ����⣩</td>
    </tr>
    
    <tr>
      <td width="100%" height="60" colspan="6">&nbsp;</td>
    </tr>
    
  </table>
  
  <div class="foot_btn_box">
    <input  type="button" value="����"  onclick="back()" class="btnSubmit"/>
    </div>
  </form>
  </body>
</html>
