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
    	<div class="navigation"><a href="javascript:back();"  class="back">����</a>��ҳ &gt; �ش���Ŀ���� &gt; ��Ŀ��Ϣ����</div>
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
					<th>����ص㣺</th>
					<td>${item.jsdd }</td>
				</tr>
				<tr>
					<th>�����ģ�����ݣ�</th>
					<td>${item.jsgm }</td>
				</tr>
				<tr>
					<th>��Ͷ��(��Ԫ)��</th>
					<td>${item.ztz }</td>
				</tr>
				<tr>
					<th>�������ޣ�</th>
					<td>${item.jsnx1}��--${item.jsnx2 }��</td>
				</tr>
				<tr>
					<th>����ƻ�Ͷ�ʣ���Ԫ����</th>
					<td>${item.jhtz}</td>
				</tr>
				<tr>
					<th>����Ŀ�꣺</th>
					<td>${item.jdmb}</td>
				</tr>
				<tr>
					<th>���������ƻ���</th>
					<td>����${item.kgn}��&nbsp;&nbsp;&nbsp;${item.kgy}��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;����${item.kgn}��&nbsp;&nbsp;&nbsp;${item.kgy}��</td>
				</tr>
				<tr>
					<th>����Ҫ������</th>
					<td>�õ����${item.yd}Ķ&nbsp;&nbsp;&nbsp;�������${item.ld}Ķ</td>
				</tr>
				<tr>
					<th>�ۼ������Ͷ�ʣ�</th>
					<td>${item.wctz}</td>
				</tr>
				<tr>
					<th>������: </th>
					<td>${item.shyj }</td>
				</tr>
				</tbody>
			</table>
    	</div>
    	<div class="foot_btn_box">
			 
             <input  type="button" value="����"  onclick="back()" class="btnSubmit"/>
		</div>
   
  </body>
</html>
