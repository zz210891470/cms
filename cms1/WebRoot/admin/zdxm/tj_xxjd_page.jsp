<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>�ޱ����ĵ�</title>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<link rel="stylesheet" type="text/css" href="../images/style.css"/>
	<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script> 
    <script type="text/javascript" src="../js/function.js"></script>
    
    <script type="text/javascript" language="javascript">
    // ���
    $(function(){
		var NowDate=new Date();
		var NowYear=NowDate.getFullYear();
		// �������
		var outHtml="<option value='' selected>--��ѡ�����--</option>";
		for(var i=2010;i<=NowYear;i++){
			if(i<NowYear)
				{outHtml += "<option value='"+i+"'>"+i+"</option>";}
			else 
				{outHtml += "<option value='"+i+"' selected>"+i+"</option>";}
		}
        $("#nd").html(outHtml);
        // ��Ŀ������
        var kgYearHtml = "<option value=''> </option>";
        for(var i=2010;i<=NowYear;i++){
        	kgYearHtml += "<option value='"+i+"'>"+i+"</option>";
		}
        $("#kgFromNd").html(kgYearHtml);
        $("#kgToNd").html(kgYearHtml);
     	// �����·�
        var monthHtml = "";
        for(var i=1; i<13; i++){
			monthHtml += "<option value='"+i+"'>"+i+"</option>";
        }
        $("#fromMonth").html(monthHtml);
        $("#toMonth").html(monthHtml);
     	// ��Ŀ������
        var kgMonthHtml = "<option value=''></option>" + monthHtml;
        $("#kgFromMonth").html(kgMonthHtml);
        $("#kgToMonth").html(kgMonthHtml);
        
     });
     
       var lblist ;
       // ��ҵ���С��
       function lbchange(t){
           var lb2html ='<option value="" selected>--��ѡ����ҵС��--</option>'; 
           for(var i=0;i<lblist.length; i++){
                if(lblist[i].mc==$(t).val()){
                    var tempid = lblist[i].id;
                    for(var j=0;j<lblist.length; j++){
                        if(tempid == lblist[j].pid){
                            lb2html += '<option value="'+lblist[j].mc+'">'+lblist[j].mc+'</option>';
                        }
                    }
                    $("#lb2").html(lb2html);
               }
           }
       }
       // ��ҵ������
       $(function(){
           var temp = $("#lblist").val() ;
           if(temp != ""){             
               lblist = eval(temp);  
               var lb1html ='<option value="" selected>--��ѡ����ҵ����--</option>';
               for(var i=0;i<lblist.length; i++){
                   if(lblist[i].pid==0){
                      lb1html += '<option value="'+lblist[i].mc+'">'+lblist[i].mc+'</option>';
                   }
               }
               $('#lb1').html(lb1html);
           }
       });
	</script>
      
</head>

<body class="mainbody">
	<form name="frm" id="frm" method="post" target="_blank" action="<%=basePath%>admin/zdxm/ZdxmServlet?action=xxjdhzpage">
        <table border="1" align="center" cellSpacing="0" borderColorLight="#cccccc" borderColorDark="#ffffff" style="width:500px;">
            <tbody>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4" style="width:85px;">�������</th>
                <td>
                    <select name="nd" class="select2" id="nd">
                    </select>&nbsp;��&nbsp;
                    <select name="fromMonth" id="fromMonth" class="select2" onclick="setMonth('fromMonth','toMonth');">
                    </select>&nbsp;�� &nbsp;�� &nbsp;
                    <select name="toMonth" id="toMonth" class="select2">
                    </select>&nbsp;��
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">��ҵ����</th>
                <td>
                  <input id="lblist" value="${lblist }" type="hidden"/>
 				    <select name="lb1" id="lb1" onchange="lbchange(this)"; >
					</select>&nbsp;&nbsp;&nbsp;
					<select name="lb2" id="lb2"  >
					</select>
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">��������</th>
                <td>
                		<select name="dq"  >
                		<option value="">--��ѡ�����--</option>
					    <c:forEach  items="${dqlist}" var="item">
					        <option value="${item }">${item }</option>
					    </c:forEach>
					    </select>
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">��Ͷ��</th>
                <td>
                	<SELECT name="ztz1" id="ztz1" class="select2">
                      <OPTION value="">ȫ��</OPTION>
                      <OPTION value="dydy" >���ڵ���</OPTION>
                      <OPTION value="dy" >����</OPTION>
                    </SELECT>
                      <INPUT name="ztz2" id="ztz2" value="" size="15" onkeyup="clearNoNum(this);" class="txtInput normal required" style="width:60px;"> ��Ԫ ��&nbsp;
                    <SELECT name="ztz3" id="ztz3" class="select2">
                      <OPTION value="" selected>ȫ��</OPTION>
                      <OPTION value="xy">С��</OPTION>
                    </SELECT>
                    <INPUT name="ztz4" id="ztz4" value="" size="15" onkeyup="clearNoNum(this);" class="txtInput normal required" style="width:60px;"> ��Ԫ
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">�������Ͷ��</th>
                <td>
                	<SELECT name="wctz1" id="wctz1" class="select2">
                      <OPTION value="">ȫ��</OPTION>
                      <OPTION value="dydy" >���ڵ���</OPTION>
                      <OPTION value="dy" >����</OPTION>
                    </SELECT>
                      <INPUT name="wctz2" id="wctz2" value="" size="15" onkeyup="clearNoNum(this);" class="txtInput normal required" style="width:60px;"> ��Ԫ ��&nbsp;
                    <SELECT name="wctz3" id="wctz3" class="select2">
                      <OPTION value="" selected>ȫ��</OPTION>
                      <OPTION value="xy">С��</OPTION>
                    </SELECT>
                    <INPUT name="wctz4" id="wctz4" value="" size="15" onkeyup="clearNoNum(this);" class="txtInput normal required" style="width:60px;"> ��Ԫ
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">����ƻ�Ͷ��</th>
                <td>
                	<SELECT name="jhtz1" id="jhtz1" class="select2">
                      <OPTION value="">ȫ��</OPTION>
                      <OPTION value="dydy" >���ڵ���</OPTION>
                      <OPTION value="dy" >����</OPTION>
                    </SELECT>
                      <INPUT name="jhtz2" id="jhtz2" value="" size="15" onkeyup="clearNoNum(this);" class="txtInput normal required" style="width:60px;"> ��Ԫ ��&nbsp;
                    <SELECT name="jhtz3" id="jhtz3" class="select2">
                      <OPTION value="" selected>ȫ��</OPTION>
                      <OPTION value="xy" >С��</OPTION>
                    </SELECT>
                    <INPUT name="jhtz4" id="jhtz4" value="" size="15" onkeyup="clearNoNum(this);" class="txtInput normal required" style="width:60px;"> ��Ԫ
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">�����ȼƻ�</th>
                <td>
                	<SELECT name="wcjhtz1" id="wcjhtz1" class="select2">
                      <OPTION value="">ȫ��</OPTION>
                      <OPTION value="dydy" >���ڵ���</OPTION>
                      <OPTION value="dy" >����</OPTION>
                    </SELECT>
                      <INPUT name="wcjhtz2" id="wcjhtz2" value="" size="15" onkeyup="clearNoNum(this);" class="txtInput normal required" style="width:60px;"> % &nbsp;&nbsp;&nbsp;��&nbsp;
                    <SELECT name="wcjhtz3" id="wcjhtz3" class="select2">
                      <OPTION value="" selected>ȫ��</OPTION>
                      <OPTION value="xy" >С��</OPTION>
                    </SELECT>
                    <INPUT name="wcjhtz4" id="wcjhtz4" value="" size="15" onkeyup="clearNoNum(this);" class="txtInput normal required" style="width:60px;"> %
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">��������Ŀ</th>
                <td>
                	<INPUT value="" type="radio" name="sfscx" checked>ȫ����
                    <INPUT value="��" type="radio" name="sfscx" >�ǡ�
                    <INPUT value="��" type="radio" name="sfscx" >�� 
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">����֮����Ŀ</th>
                <td>
                	<INPUT value="" type="radio" name="sfzz" checked>ȫ����
                    <INPUT value="��" type="radio" name="sfzz" >�ǡ�
                    <INPUT value="��" type="radio" name="sfzz" >��
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">ʡ���ص���Ŀ</th>
                <td>
                	<INPUT value="" type="radio" name="sfss" checked>ȫ����
                    <INPUT value="��" type="radio" name="sfss" >�ǡ�
                    <INPUT value="��" type="radio" name="sfss" >��
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">��Դ����Ŀ </th>
                <td>
                	<INPUT value="" type="radio" name="sfzy" checked>ȫ����
                    <INPUT value="��" type="radio" name="sfzy" >�ǡ�
                    <INPUT value="��" type="radio" name="sfzy" >��
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">��ҵ���� </th>
                <td>
                	<SELECT name="sjslb" class="select2">
                           <OPTION value="">ȫ��</OPTION>
                      <OPTION value="��е" >��е</OPTION>
                      <OPTION value="��ɫ����" >��ɫ����</OPTION>
                      <OPTION value="�̲�" >�̲�</OPTION>
                      <OPTION value="��Դ����" >��Դ����</OPTION>
                      <OPTION value="��֯" >��֯</OPTION>
                      <OPTION value="����" >����</OPTION>                    
                      <OPTION value="����²���" >����²���</OPTION>
                      <OPTION value="����ּ��ظ�" >����ּ��ظ�</OPTION>
                      <OPTION value="ũ��Ʒ�ӹ�" >ũ��Ʒ�ӹ�</OPTION>
                      <OPTION value="��ó����" >��ó����</OPTION>
                      <OPTION value="���μ��Ļ�����" >���μ��Ļ�����</OPTION>
                      <OPTION value="��������" >��������</OPTION>
                    
                  </SELECT>
              </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">��ĿͶ������</th>
                <td>
                	<SELECT id="tzzt" name="tzztxz" class="select2">
                      <OPTION value="">ȫ��</OPTION>
                      <OPTION value="���ж���" >���ж���</OPTION>
                      <OPTION value="���пع������ʺ���" >���пع������ʺ���</OPTION>
                      <OPTION value="���пع�����Ӫ����" >���пع�����Ӫ����</OPTION>
                      <OPTION value="��Ӫ����" >��Ӫ����</OPTION>
                      <OPTION value="��Ӫ�ع������ʺ���" >��Ӫ�ع������ʺ���</OPTION>
                      <OPTION value="��Ӫ�ع�����к���" >��Ӫ�ع�����к���</OPTION>
                      <OPTION value="���ʶ���" >���ʶ���</OPTION>
                      <OPTION value="���ʿع�����к���" >���ʿع�����к���</OPTION>
                      <OPTION value="���ʿع�����Ӫ����" >���ʿع�����Ӫ����</OPTION>
                      <OPTION value="����" >����</OPTION>
                  </SELECT>
                </td>
            </tr>
             <tr>
                <th height="25" align="left" bgcolor="#F4F4F4" style="width:85px;">��Ŀ����ʱ��</th>
                <td>
                    <select name="kgFromNd" class="select2" id="kgFromNd">
                    </select>&nbsp;��&nbsp;
                    <select name="kgFromMonth" id="kgFromMonth" class="select2">
                    </select>&nbsp;�� &nbsp;�� &nbsp;<select name="kgToNd" class="select2" id="kgToNd"></select>&nbsp;��&nbsp;
                    <select name="kgToMonth" id="kgToMonth" class="select2">
                    </select>&nbsp;��
                </td>
            </tr>
            <tr>
            	<td height="30" colSpan="2" align="center">
                	<input type="submit" value="ȷ ��" class="btnSearch" />
                </td>
            </tr>
            </tbody>
        </table>
</form>
</body>
</html>