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
	<style type="text/css">
	.table{width:100%; font-family:Verdana, Geneva, sans-serif; }
	
	</style>
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
	<form name="form" method="post" action="" id="form">
    	<div class="navigation"><a href="javascript:back();"  class="back">����</a>��ҳ &gt; ������Ŀ���� &gt; ��Ŀ��Ϣ����</div>
    	<div class="tab_con" style="display:block;">
    		<table class="form_table">
    			<h3 align="center"> ${item.mc }���</h3>
				<col width="200px"></col>
				<tbody>
				<!-- 
				<tr>
					<th>��Ŀ��ȣ�</th>
					<td>${item.nd }</td>
				</tr>
				 -->
				 
				<tr>
					<th>��������</th>
					<td>����ʡ������</td>
				</tr>
				<tr>
					<th>��Ŀ���ƣ�</th>
					<td>${item.mc }</td>
				</tr>
				<tr>
					<th>��ҵ���</th>
					<td>${item.lb1 }<br />${item.lb2 }
					</td>
				</tr>
				<tr>
					<th>��ϵ��λ��</th>
					<td>${item.sbdw }</td>
				</tr>
				<tr>
					<th>��ϵ��ʽ��</th>
					<td>��ϵ�ˣ�${item.lxr }��&nbsp;&nbsp;�绰��${item.lxdh }<br/>�������䣺${item.dzyx}</td>
				</tr>
				<tr>
					<th>�а쵥λ��</th>
					<td>${item.cbdw }</td>
				</tr>
				<tr>
					<th>��ϵ��ʽ��</th>
					<td>��ϵ�ˣ�${item.lxr2 }��&nbsp;&nbsp;�绰��${item.lxdh2 }<br/>�������䣺${item.dzyx2}</td>
				</tr>
				<tr>
					<th>������ʽ��</th>
					<td>${item.hzfs }</td>
				</tr>
				<tr>
					<th>��������&nbsp;&nbsp;&nbsp;</th>
					<td align="center"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					����</b></td>
				</tr>
				<tr>
					<th>��Ŀ�������������̣�</th>
					<td>${item.lygc }</td>
				</tr>
				<tr>
					<th>��Ŀ�ſ���</th>
					<td>
						����ص㣺${item.dq }&nbsp;${item.jsdd }<br />
						��Ͷ�ʣ�${item.ztz }��Ԫ<br />
						�����ģ�����ݣ�${item.jsgm }<br />
						��Ҫ����������${item.jstj }<br />
						����Ч�������${item.xyfx }<br />
						��Ҫ��������ָ�꣺${item.jsjjzb }
					</td>
				</tr>
				<tr>
					<th>��Ŀǰ���ƽ�״����</th>
					<td>${item.tjzk }</td>
				</tr>
				</tbody>
			</table>
    	</div>
    	<div class="foot_btn_box">

             <input  type="button" value="����"  onclick="back()" class="btnSubmit"/>
		</div>
    </form>
  </body>
</html>
