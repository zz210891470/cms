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
    <script type="text/javascript">
       function back(){
           window.parent.hideFrame();
       }
    
    </script>
  </head>
  <body class="mainbody" style="background:#FFFFFF;">
  	<form name="form" method="post" action="" id="form">
    <table width="95%" border="0" align="center" cellspacing="0">
			<tr>
			<td width="85%" height="30">
				<b><font color="#336699">�������ص���Ŀ����Ϣ����  ${yf }�·�</font></b>
			</td>
			</tr>
	  </table>
  <table border="1" width="100%"  align="center" cellspacing="0">
    <tr>
      <td height="25" style="width: 16%" align="center">��Ŀ����</td>
      <td width="75%" colspan="5">&nbsp;${zdxm.mc }</td>
    </tr>
    <tr>
      <td height="50" style="width: 16%" align="center">�����ģ������</td>
      <td width="75%" colspan="5" style=" padding:5px; line-height:1.5;">${zdxm.jsgm }</td>
    </tr>
    <tr>
      <td height="25" style="width: 16%" align="center">��Ͷ�ʣ���Ԫ��</td>
      <td width="75%" colspan="5">&nbsp;${zdxm.ztz }</td>
    </tr>
    <tr>
      <td height="25" style="width: 16%" align="center">��������</td>
      <td width="75%" colspan="5">&nbsp;${zdxm.kgn }��${zdxm.kgy }��</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25" bgcolor="#FFCCCC">
        <p align="left">�ʽ���Դ����λ�������λ����Ԫ��</p>
      </td>
    </tr>
    <tr>
      <td style="width: 16%" height="25" align="center">��Ͷ����Դ������</td>
      <td width="15%" align="center">��Ͷ��</td>
      <td width="14%" align="center">����ƻ�Ͷ��</td>
      <td width="15%" align="center">���µ�λ�ʽ�</td>
      <td width="15%" align="center">�����ۼ�<br/>��λ�ʽ�</td>
      <td width="19%" align="center">���������ۼ�<br/>��λ�ʽ�</td>
    </tr>
    <tr>
      <td align="center" style="width: 16%" height="25">ҵ���Գ�</td>
      <td width="15%" align="center">${zdxm.zjppzc }</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">${zdxmyb.dwzj1}</td>
      <td width="15%" align="center">${zdxmyb.dnljdw1}</td>
      <td width="15%" align="center">${zdxmyb.kgljdw1}</td>
    </tr>
    <tr>
      <td align="center" style="width: 16%" height="25">���д���</td>
      <td width="15%" align="center">${zdxm.zjppdk }</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">${zdxmyb.dwzj2}</td>
      <td width="15%" align="center">${zdxmyb.dnljdw2}</td>
      <td width="15%" align="center">${zdxmyb.kgljdw2}</td>
    </tr>
     <tr>
      <td align="center" style="width: 16%" height="25">����Ͷ��</td>
      <td width="15%" align="center">${zdxm.zjppzf }</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">${zdxmyb.dwzj3}</td>
      <td width="15%" align="center">${zdxmyb.dnljdw3}</td>
      <td width="15%" align="center">${zdxmyb.kgljdw3}</td>
    </tr>
    <tr>
      <td height="25" style="width: 16%" align="center">��&nbsp;&nbsp;&nbsp;�� </td>
      <td width="15%" align="center">${zdxm.ztz }</td>
      <td width="15%" align="center">${zdxm.jhtz }</td>
      <td width="15%" align="center">${zdxmyb.dwzjhj }</td>
      <td width="15%" align="center">${zdxmyb.dnljdwhj }</td>
      <td width="15%" align="center">${zdxmyb.kgljdwhj }</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25" bgcolor="#FFCCCC" align="center">Ͷ������������λ����Ԫ��</td>
    </tr>
    <tr>
      <td width="40%" colspan="2" height="25" align="center">�������</td>
      <td width="30%" colspan="2" align="center">�����ۼ����</td>
      <td width="30%" colspan="2" align="center">���������ۼ����</td>
    </tr>
    <tr>
      <td width="40%" colspan="2" align="center" height="25">${zdxmyb.bywc}</td>
      <td width="30%" colspan="2" align="center">${zdxmyb.nczbywc}</td>
      <td width="30%" colspan="2" align="center">${zdxmyb.kgljwc}</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25" align="left">��������������Ⱥ��ѿ�չ����Ҫ����      </td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="50" style="line-height:1.5; padding:5px;">${zdxmyb.xxjd}</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25" align="left">����������Ͷ��ʱ�䡢���ݼ�������������</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="50" style="line-height:1.5; padding:5px;">${zdxmyb.scnl}</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25" align="left">��Ŀ�ƽ��д��ڵ����⼰���ȡ�Ĵ�ʩ�Ͱ취
      </td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="50" style="line-height:1.5; padding:5px;">${zdxmyb.czwt}</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6" height="25" align="left">��Ҫ�������йز���Э�����������</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6" height="50" style="line-height:1.5; padding:5px;">${zdxmyb.xtjj}</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6" height="25" align="left">�¸��£����ȣ������ƻ�������</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="50" style="line-height:1.5; padding:5px;">${zdxmyb.gzjh}</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25" align="left">�ν���λ�½������</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="50" style="line-height:1.5; padding:5px;">${zdxmyb.jcqk}</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25" align="left">�ʽ�˵���������ʽ��Ƿ���ʵ����λ�ʽ��Ƿ����㽨����Ҫ����ڵ������ʽ����⣩</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="50" style="line-height:1.5; padding:5px;">${zdxmyb.zjsm}</td>
    </tr>
  </table>
  <div class="foot_btn_box">
  		<input type="hidden" id="zt" name="zt" value="" />
         <input  type="button" value="�� ��"  onclick="back()" class="btnSubmit"/>
    </div>
  </form>
  </body>
</html>