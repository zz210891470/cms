<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>admin/images/style.css"/>
	<style type="text/css">
	.table{width:100%; font-family:Verdana, Geneva, sans-serif; }
	
	</style>
	<script type="text/javascript" src="<%=basePath%>admin/lib/jquery/jquery-1.3.2.min.js"></script>  
	<script type="text/javascript" src="<%=basePath%>admin/js/function.js"></script>
  	<style>
	    body{
	        background-color:#ffffff;
	    }
	</style>
  </head>
  <body class="mainbody">
	<form name="form" method="post" action="<%=basePath%>admin/zdxm/ZdxmServlet?action=add" id="form">
    	<div class="navigation"><a href="javascript:back();"  class="back">����</a>��ҳ &gt; �ص���Ŀ���� &gt; ��Ŀ��Ϣ����</div>
    	<div class="tab_con" style="display:block;">
    		<table width="100%" border="1" cellpadding="0" cellspacing="0" style="border:solid 1px #EDECFF;" >
				<tr>
				    <td height="35" align="center">��Ŀ���</td>
				    <td colspan="4" bgcolor="#FFFFFF"></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="widtd:120px;">��Ŀ����</td>
				    <td colspan="2"></td>
				    <td align="center" widtd="80">��Ŀ���</td>
				    <td widtd="130"></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="widtd:120px;">��������</td>
				    <td colspan="2">
				    	
				    </td>
				    <td align="center" widtd="80">��������</td>
				        <td width="130">
				        	 �� ��
				        </td>
				  </tr>
				<tr>
					<td height="35" align="center" style="width:120px;">������ҵ</td>
					<td colspan="4">
						 - 
					</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">����ص�</td>
				    <td colspan="4">
				    	���� - ��(��/��) -��ҵ԰��������
				    </td>
				  </tr>
				  <tr>
				    <td height="100" align="center" style="width:120px;">�������ݼ���ģ</td>
				    <td colspan="4" valign="top" style=" padding:10px;">
				    	
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">��Ŀ��������׼��<br>�����ĺ�</td>
				    <td colspan="2"></td>
				    <td align="center" width="80">��������</td>
				    <td width="130"> �� - ��
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">��Ͷ��(��Ԫ)</td>
				    <td colspan="4"></td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">��2013���Ԥ��<br>��չ���</td>
				    <td height="35" align="center" style="width:110px;"><div style="width:110px;">��2013����ۼ�<br>���Ͷ��(��Ԫ)</div></td>
				    <td height="28" colspan="3" style="width:470px;"></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">�����򹤳�<br>��չ���</td>
				    <td height="28" colspan="3" style="padding:10px;">
				    	
				    </td>
				  </tr>
				  <tr>
				    <td rowspan="3" align="center" style="width:120px;">2014 �깤��Ŀ��</td>
				    <td height="35" align="center" style="width:110px;">�ƻ�Ͷ��(��Ԫ)</td>
				    <td height="28" colspan="3"></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">����(��Ԫ)</td>
				    <td height="28" colspan="3">
				    <table border="0" cellspacing="0" cellpadding="0" style="display:;">
				      <tr>
				        <td height="25" align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">1��</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">2��</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">3��</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">4��</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">5��</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">6��</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">7��</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">8��</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">9��</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">10��</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">11��</td>
				        <td align="center" bgcolor="White" style="width:39px;border-bottom:solid 1px #d5d5d5;">12��</td>
				      </tr>
				      <tr>
				        <td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							
						</td>
				        <td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							
						</td>
				        <td align="center" bgcolor="White">
							
						</td>
				      </tr>
				    </table></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">���̽���</td>
				    <td height="28" colspan="3" style="padding:10px;">
				    	
				    </td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">��Ŀҵ��(���衢<br />�ｨ��������λ)</td>
				    <td height="35" align="center" style="width:110px;">��λ����</td>
				    <td height="28" colspan="3"></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">�����˼�<br> ��ϵ�绰</td>
				    <td height="28" colspan="3"></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">�ּ�����λ<br>���쵼</td>
				    <td colspan="4"></td>
				  </tr>
				  <tr>
				    <td rowspan="3" align="center" style="width:120px;">�ʽ�ƴ��</td>
				    <td height="35" align="center">ҵ���Գ�(��Ԫ)</td>
				    <td height="35" colspan="3"></td>
				  </tr>
				  <tr>
				    <td height="35" align="center">���д���(��Ԫ)</td>
				    <td height="35" colspan="3"></td>
				  </tr>
				  <tr>
				    <td height="35" align="center">����Ͷ��(��Ԫ)</td>
				    <td height="35" colspan="3"></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">Ͷ����������</td>
				    <td colspan="4">
				    	
				    </td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">2014��ƻ�������<br>���ɻ򲿷ֽ���</td>
				    <td height="35" align="center">���������ɻ�<br>���ֽ���</td>
				    <td height="35" colspan="3">
				    	
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center">�·�</td>
				    <td height="35" colspan="3">
				    	
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">��Ŀ���ɴ����<br>������Ч��</td>
				    <td colspan="4">&nbsp;&nbsp;
					��ֵ&nbsp;(��Ԫ)&nbsp;
					˰��&nbsp;(��Ԫ)&nbsp;
					�ṩ��ҵ��λ&nbsp;(��)
				</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">��Ŀ��ռ��(Ķ)</td>
				    <td height="28" colspan="4"></td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">2014�����Ҫ��<br>Ԥ��������</td>
				    <td height="35" colspan="4">&nbsp;&nbsp; 
				    ũ�õ� (Ķ)&nbsp;&nbsp;
				    ���У�����ũ�� (Ķ)&nbsp;&nbsp;
				    �ֵأ� (Ķ)</td>
				  </tr>
				  <tr>
				    <td height="35" colspan="4">&nbsp;&nbsp;
				        ʩ������ (��)&nbsp;&nbsp;
				        ����Ʒ (��)&nbsp;&nbsp;
				        ���д��� (��Ԫ)</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">�Ƿ���������Ŀ</td>
				    <td height="28" colspan="4">
				    	
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">�Ƿ�����֮����Ŀ</td>
				    <td height="28" colspan="4">
				    	
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">�Ƿ�ʡ���ص���Ŀ</td>
				    <td height="28" colspan="4">
				    	
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">�Ƿ���Դ����Ŀ</td>
				    <td height="28" colspan="4">
				    	
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;"><div style="width:120px;">��ҵ����</div></td>
				    <td height="28" colspan="4" style="line-height:30px;">
				    	
				    </td>
				  </tr>
			</table>
    	</div>
    	<div class="foot_btn_box">
             <input  type="button" value="����"  onclick="back()" class="btnSubmit"/>
		</div>
    </form>
  </body>
</html>
