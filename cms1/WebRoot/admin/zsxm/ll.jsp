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
	<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script>  
	<script type="text/javascript" src="../js/function.js"></script>
	
	<style>
	    body{
	        background-color:#ffffff;
	    }
	
	</style>
	
	<script type="text/javascript">

       function back(){
           window.parent.hideFrame();
       }
    
    </script>
  </head>
  <body class="mainbody">
    	<div class="navigation"><a href="javascript:back();"  class="back">����</a>��ҳ &gt; ������Ŀ���� &gt; ��Ŀ��Ϣ�޸�</div>
    	<div class="tab_con" style="display:block;">
    		<table class="form_table">
				<col width="150px"></col>
				<tbody>
				<tr>
					<th>��Ŀ��ȣ�</th>
					<td>${item.nd }</td>
				</tr>
				
				<tr>
					<th>��Ŀ���ƣ�</th>
					<td>${item.mc }</td>
				</tr>
				<tr>
					<th>������</th>
					<td>${item.dq }</td>
				</tr>
				<tr>
					<th>��Ŀ���</th>
					<td>${item.lb1 }&nbsp;&nbsp;&nbsp;${item.lb2 }
					</td>
				</tr>
				<tr>
					<th>��Ͷ��(��Ԫ)��</th>
					<td>${item.ztz }</td>
				</tr>
				<tr>
					<th>�����ģ�����ݣ�</th>
					<td>${item.jsgm }</td>
				</tr>
				<tr>
					<th>������ʽ��</th>
					<td>${item.hzfs }</td>
				</tr>
				<tr>
					<th>��ϵ��λ��</th>
					<td>${item.lxdw }</td>
				</tr>
				<tr>
					<th>��ϵ�ˣ�</th>
					<td>${item.lxr}</td>
				</tr>
				<tr>
					<th>��ϵ�绰��</th>
					<td>${item.lxdh }</td>
				</tr>
				<tr>
					<th>ǰ�ڹ�����չ�����</th>
					<td>${item.qqgz }</td>
				</tr>
				</tbody>
			</table>
    	</div>
    	<div class="foot_btn_box">
			 
             <input  type="button" value="����"  onclick="back()" class="btnSubmit"/>
		</div>
   
  </body>
</html>
