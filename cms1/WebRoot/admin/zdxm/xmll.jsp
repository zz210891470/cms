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
	<style type="text/css">
	.table{width:100%; font-family:Verdana, Geneva, sans-serif; }
	</style>
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
	<form name="form" method="post">
    	<div class="navigation"><a href="javascript:back();"  class="back">����</a>��ҳ &gt; �ص���Ŀ���� &gt; �ص���Ŀ��Ϣ����</div>
    	<div class="tab_con" style="display:block;">
    		<table width="100%" border="1" cellpadding="0" cellspacing="0" style="border:solid 1px #EDECFF;" >
    			<tr>
				    <td height="35" align="center">��Ŀ���</td>
				    <td colspan="4" bgcolor="#FFFFFF">
				    &nbsp;&nbsp;${item.lb}
				    </td>
				  </tr>
				<tr>
				    <td height="35" align="center">��Ŀ���</td>
				    <td colspan="2" bgcolor="#FFFFFF">&nbsp;&nbsp;${item.nd}</td>
				    <td height="35" align="center">��Ŀ���</td>
				    <td colspan="2" width="350px;" bgcolor="#FFFFFF">&nbsp;&nbsp;${item.bh}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="widtd:120px;">��Ŀ����</td>
				    <td colspan="4">&nbsp;&nbsp;${item.mc}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="widtd:120px;">��������</td>
				    <td colspan="2">&nbsp;&nbsp;${item.dq}</td>
				    <td align="center" widtd="80">��������</td>
				        <td width="130">&nbsp;&nbsp;${item.kgn} �� ${item.kgy} ��</td>
				  </tr>
				<tr>
					<td height="35" align="center" style="width:120px;">������ҵ</td>
					<td colspan="4">&nbsp;&nbsp;${item.lb1} - ${item.lb2}
					</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">����ص�</td>
				    <td colspan="4">&nbsp;&nbsp;������  ${item.dq} ${item.jsdd}
				    </td>
				  </tr>
				  <tr>
				    <td height="100" align="center" style="width:120px;">�������ݼ���ģ</td>
				    <td colspan="4" valign="top" style=" padding:10px;">${item.jsgm}
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">��Ŀ��������׼��<br>�����ĺ�</td>
				    <td colspan="2">&nbsp;&nbsp;${item.bawh}</td>
				    <td align="center" width="80">��������</td>
				    <td width="130">&nbsp;&nbsp;${item.jsnx1} �� - ${item.jsnx2} ��
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">��Ͷ��(��Ԫ)</td>
				    <td colspan="4">&nbsp;&nbsp;${item.ztz}</td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">��ȥ�����Ԥ��<br>��չ���</td>
				    <td height="35" align="center" style="width:110px;"><div style="width:110px;">��ȥ������ۼ�<br>���Ͷ��(��Ԫ)</div></td>
				    <td height="28" colspan="3" style="width:470px;">&nbsp;&nbsp;${item.wctz}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">�����򹤳�<br>��չ���</td>
				    <td height="28" colspan="3">&nbsp;&nbsp;${item.jzqk} </td>
				  </tr>
				  <tr>
				    <td rowspan="3" align="center" style="width:120px;">���깤��Ŀ��</td>
				    <td height="35" align="center" style="width:110px;">�ƻ�Ͷ��(��Ԫ)</td>
				    <td height="28" colspan="3">&nbsp;&nbsp;${item.jhtz}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">����(��Ԫ)</td>
				    <td height="28" colspan="3">
				    <table border="0" cellspacing="0" cellpadding="0" style="display:;">
				      <tr>
				        <td height="25" align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">1��</td>
				        <td align="center" bgcolor="White" style="width:50px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">2��</td>
				        <td align="center" bgcolor="White" style="width:50px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">3��</td>
				        <td align="center" bgcolor="White" style="width:50px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">4��</td>
				        <td align="center" bgcolor="White" style="width:50px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">5��</td>
				        <td align="center" bgcolor="White" style="width:50px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">6��</td>
				        <td align="center" bgcolor="White" style="width:50px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">7��</td>
				        <td align="center" bgcolor="White" style="width:50px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">8��</td>
				        <td align="center" bgcolor="White" style="width:50px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">9��</td>
				        <td align="center" bgcolor="White" style="width:50px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">10��</td>
				        <td align="center" bgcolor="White" style="width:50px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">11��</td>
				        <td align="center" bgcolor="White" style="width:50px;border-bottom:solid 1px #d5d5d5;">12��</td>
				      </tr>
				      <tr>
				        <td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">${item.tz1}</td>
				        <td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">${item.tz2}</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">${item.tz3}</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">${item.tz4}</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">${item.tz5}</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">${item.tz6}</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">${item.tz7}</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">${item.tz8}</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">${item.tz9}</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">${item.tz10}</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">${item.tz11}</td>
				        <td align="center" bgcolor="White">${item.tz12}</td>
				      </tr>
				    </table></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">���̽���</td>
				    <td height="28" colspan="3" style="padding:10px;">${item.gcjd}</td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">��Ŀҵ��(���衢<br />�ｨ��������λ)</td>
				    <td height="35" align="center" style="width:110px;">��λ����</td>
				    <td height="28" colspan="3">&nbsp;&nbsp;${item.dwmc}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">�����˼�<br> ��ϵ�绰</td>
				    <td height="28" colspan="3">&nbsp;&nbsp;${item.zrr}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">�ּ�������λ<br>���쵼</td>
				    <td colspan="4">&nbsp;&nbsp;${item.gldw}</td>
				  </tr>
				  <tr>
				    <td rowspan="3" align="center" style="width:120px;">�ʽ�ƴ��</td>
				    <td height="35" align="center">ҵ���Գ�(��Ԫ)</td>
				    <td height="35" colspan="3">&nbsp;&nbsp;${item.zjppzc}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center">���д���(��Ԫ)</td>
				    <td height="35" colspan="3">&nbsp;&nbsp;${item.zjppdk}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center">����Ͷ��(��Ԫ)</td>
				    <td height="35" colspan="3">&nbsp;&nbsp;${item.zjppzf}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">Ͷ����������</td>
				    <td colspan="4">&nbsp;&nbsp;${item.tzztxz}</td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">����ƻ�������<br>���ɻ򲿷ֽ���</td>
				    <td height="35" align="center">���������ɻ�<br>���ֽ���</td>
				    <td height="35" colspan="3">&nbsp;&nbsp;${item.sfkg}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center">�·�</td>
				    <td height="35" colspan="3">&nbsp;&nbsp;${item.kgyf}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">��Ŀ���ɴ����<br>������Ч��</td>
				    <td colspan="4">&nbsp;&nbsp;��ֵ&nbsp;${item.cz}(��Ԫ)&nbsp;˰��&nbsp;${item.ss}(��Ԫ)&nbsp;�ṩ��ҵ��λ&nbsp;${item.jy}(��)
				</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">��Ŀ��ռ��(Ķ)</td>
				    <td height="28" colspan="4">&nbsp;&nbsp;${item.zd}</td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">�������Ҫ��<br />Ԥ��������</td>
				    <td height="35" colspan="4">&nbsp;&nbsp;ũ�õ� ${item.nyd}(Ķ)&nbsp;&nbsp;���У�����ũ��${item.nt}(Ķ)&nbsp;&nbsp; �ֵ� ${item.ld}(Ķ)</td>
				  </tr>
				  <tr>
				    <td height="35" colspan="4">&nbsp;&nbsp;ʩ������  ${item.sgyy}(��)&nbsp;&nbsp;����Ʒ  ${item.hgyp}(��)&nbsp;&nbsp;���д���  ${item.yhdk}(��Ԫ)</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">�Ƿ���������Ŀ</td>
				    <td height="28" colspan="4">&nbsp;&nbsp;${item.sfscx}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">�Ƿ�����֮����Ŀ</td>
				    <td height="28" colspan="4">&nbsp;&nbsp;${item.sfzz}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">�Ƿ�ʡ���ص���Ŀ</td>
				    <td height="28" colspan="4">&nbsp;&nbsp;${item.sfss}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">�Ƿ���Դ����Ŀ</td>
				    <td height="28" colspan="4">&nbsp;&nbsp;${item.sfzy}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;"><div style="width:120px;">��ҵ����</div></td>
				    <td height="28" colspan="4" style="line-height:30px;">&nbsp;&nbsp;${item.sjslb}</td>
				  </tr>
				  <tr>
					<td height="35" align="center" style="width:120px;"><div style="width:120px;">������</div></td>
					<td colspan='4'>&nbsp;&nbsp;${item.shyj }</td>
				</tr>
			</table>
    	</div>
    	<div class="foot_btn_box">
             <input  type="button" value="����"  onclick="back()" class="btnSubmit"/>
		</div>
    </form>
  </body>
</html>