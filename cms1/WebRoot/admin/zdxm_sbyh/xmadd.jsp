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
       function save(){
    	   var pname = $("#mc").val();
           var pyear = $("#nd").val();
           if(pname == "" || pname == null || pyear == "" || pyear == null){
               alert("��Ŀ���ƺ���Ŀ��ݾ�����Ϊ�գ�");
               return;
           }
           $("#form").submit();
       }
       
       function back(){
           window.parent.hideFrame();
       }

   	   // ҳ�������ɺ��Զ���ʾ��ҵ�����ṩѡ��
       var lblist ; 	// ��ҵ��𼯺�
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
       $(function(){
           var NowDate=new Date();
           var NowYear=NowDate.getFullYear();
           var outHtml="";
	       for(var  i = NowYear-5 ; i < NowYear+5; i++){
				if(i != NowYear){
					outHtml += "<option value='"+i+"'>"+i+"</option>";
				}else{
					outHtml += "<option value='"+i+"' selected>"+i+"</option>";
				}
		   }
	       $("#kgn").html(outHtml);
	       $("#jsnx1").html(outHtml);
	       $("#jsnx2").html(outHtml);
       });
       // ��ѡ��ĳ������ʱ���Զ���ʾ�����µ�С��
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
       // ��ѡ�����ʱ���Զ�Ҳѡ�������
       function dqchange(t,id){
           // ѡ�еĵ���
    	   var selectDq = $(t).val();
           $("#"+id).find("option[text='"+ selectDq +"']").attr("selected",true); 
       }
    </script>
  </head>
  <body class="mainbody">
	<form name="form" method="post" action="<%=basePath%>admin/zdxm_sbyh/ZdxmSbyhServlet?action=add" id="form">
    	<div class="navigation"><a href="javascript:back();"  class="back">����</a>��ҳ &gt; �ص���Ŀ���� &gt; �ص���Ŀ����</div>
    	<div class="tab_con" style="display:block;">
    		<table width="100%" border="1" cellpadding="0" cellspacing="0" style="border:solid 1px #EDECFF;" >
				<tr>
				    <td height="35" align="center">��Ŀ���</td>
				    <td colspan="4" bgcolor="#FFFFFF">
				    <input type="radio" name="lb" checked value="�ڽ�"/>�ڽ�&nbsp;
				    <input type="radio" name="lb" value="Ԥ��"/>Ԥ��
				    &nbsp;<input type="radio" name="lb" value="ǰ��"/>ǰ��</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="widtd:120px;">��Ŀ����</td>
				    <td colspan="4"><input id="mc" name="mc" type="text" value="" maxlength="100"  class="txtInput normal required" /><font color="red"> *</font> </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="widtd:120px;">��Ŀ���</td>
				    <td colspan="2"><input id="nd" name="nd" type="text" value="" onkeyup="clearNoNum(this)" size="4" style="width: 130px;"  class="txtInput normal required" /><font color="red"> *</font> </td>
				    <td align="center" width="80">��Ŀ���</td>
				    <td width="130"><input name="bh" type="text" value="" maxlength="100"  class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="widtd:120px;">��������</td>
				    <td colspan="2">
				    	<input id="dqlist" value="${dqlist }" type="hidden"/>
				    	<select name="dq" id="dq" onchange="dqchange(this,'jsdq')";>
                		<option value="">--��ѡ�����--</option>
					    <c:forEach  items="${dqlist}" var="item">
					        <option value="${item }">${item }</option>
					    </c:forEach>
					    </select>
				    </td>
				    <td align="center" widtd="80">��������</td>
				        <td width="130">
				        	<select name="kgn" id="kgn" class="select2">
								<option value=""></option>
							</select> ��
							<select name="kgy" id="kgy" class="select2">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
							</select> ��
				        </td>
				  </tr>
				<tr>
					<td height="35" align="center" style="width:120px;">������ҵ</td>
					<td colspan="4">
						<input id="lblist" value="${lblist }" type="hidden"/>
	 				    <select name="lb1" id="lb1" onchange="lbchange(this)"; >
						</select>&nbsp;&nbsp;&nbsp;
						<select name="lb2" id="lb2"  >
						</select>
					</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">����ص�</td>
				    <td colspan="4">
				    	<select name="jscs" id="jscs" class="select2">
							<option value="������">����</option>
						</select>
						<select name="jsdq" id="jsdq" onchange="dqchange(this,'dq')">
                		<option value="">--��ѡ�����--</option>
					    <c:forEach  items="${dqlist}" var="item">
					        <option value="${item }">${item }</option>
					    </c:forEach>
					    </select> ��(��/��)
				    	<input name="jsdd" type="text" value="" maxlength="100"  class="txtInput normal required" /> ��ҵ԰��������
				    </td>
				  </tr>
				  <tr>
				    <td height="100" align="center" style="width:120px;">�������ݼ���ģ</td>
				    <td colspan="4" valign="top" style=" padding:10px;">
				    	<textarea name="jsgm"  rows="5" cols="20" id="jsgm" class="small" style="width:80%;"></textarea>
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">��Ŀ��������׼��<br>�����ĺ�</td>
				    <td colspan="2"><input name="bawh" type="text" value="" maxlength="100"  class="txtInput normal required" /></td>
				    <td align="center" width="80">��������</td>
				    <td width="130">
				    	<select name="jsnx1" id="jsnx1" class="select2">
							<option value=""></option>
						</select> �� -
						<select name="jsnx2" id="jsnx2" class="select2">
							<option value=""></option>
						</select> ��
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">��Ͷ��(��Ԫ)</td>
				    <td colspan="4"><input name="ztz" type="text" value="" onkeyup="clearNoNum(this)" maxlength="100"  class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">��2013���Ԥ��<br>��չ���</td>
				    <td height="35" align="center" style="width:110px;"><div style="width:110px;">��2013����ۼ�<br>���Ͷ��(��Ԫ)</div></td>
				    <td height="28" colspan="3" style="width:470px;"><input name="wctz" type="text" value="" maxlength="100" onkeyup="clearNoNum(this)"   class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">�����򹤳�<br>��չ���</td>
				    <td height="28" colspan="3" style="padding:10px;">
				    	<textarea name="jzqk"  rows="4" cols="20" id="jzqk" class="small" style="width:80%;"></textarea>
				    </td>
				  </tr>
				  <tr>
				    <td rowspan="3" align="center" style="width:120px;">2014 �깤��Ŀ��</td>
				    <td height="35" align="center" style="width:110px;">�ƻ�Ͷ��(��Ԫ)</td>
				    <td height="28" colspan="3"><input name="jhtz" type="text" value="" maxlength="100"  onkeyup="clearNoNum(this)"   class="txtInput normal required" /></td>
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
							<input name="tz1" type="text" value="" maxlength="100"  class="txtInput normal required" onkeyup="clearNoNum(this)"  style="width:100%;border:0;" />
						</td>
				        <td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							<input name="tz2" type="text" value="" maxlength="100"  class="txtInput normal required" onkeyup="clearNoNum(this)"  style="width:100%;border:0;" />
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							<input name="tz3" type="text" value="" maxlength="100"  class="txtInput normal required" onkeyup="clearNoNum(this)"  style="width:100%;border:0;" />
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							<input name="tz4" type="text" value="" maxlength="100"  class="txtInput normal required" onkeyup="clearNoNum(this)"  style="width:100%;border:0;" />
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							<input name="tz5" type="text" value="" maxlength="100"  class="txtInput normal required" onkeyup="clearNoNum(this)"  style="width:100%;border:0;" />
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							<input name="tz6" type="text" value="" maxlength="100"  class="txtInput normal required" onkeyup="clearNoNum(this)"  style="width:100%;border:0;" />
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							<input name="tz7" type="text" value="" maxlength="100"  class="txtInput normal required" onkeyup="clearNoNum(this)"  style="width:100%;border:0;" />
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							<input name="tz8" type="text" value="" maxlength="100"  class="txtInput normal required" onkeyup="clearNoNum(this)"  style="width:100%;border:0;" />
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							<input name="tz9" type="text" value="" maxlength="100"  class="txtInput normal required" onkeyup="clearNoNum(this)"  style="width:100%;border:0;" />
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							<input name="tz10" type="text" value="" maxlength="100"  class="txtInput normal required" onkeyup="clearNoNum(this)"  style="width:100%;border:0;" />
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							<input name="tz11" type="text" value="" maxlength="100"  class="txtInput normal required" onkeyup="clearNoNum(this)"  style="width:100%;border:0;" />
						</td>
				        <td align="center" bgcolor="White">
							<input name="tz12" type="text" value="" maxlength="100"  class="txtInput normal required" onkeyup="clearNoNum(this)"  style="width:100%;border:0;" />
						</td>
				      </tr>
				    </table></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">���̽���</td>
				    <td height="28" colspan="3" style="padding:10px;">
				    	<textarea name="gcjd" id="gcjd" rows="4" cols="20"  class="txtInput normal required" style="font-family:����;height:80px;width:80%;"></textarea>
				    </td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">��Ŀҵ��(���衢<br />�ｨ��������λ)</td>
				    <td height="35" align="center" style="width:110px;">��λ����</td>
				    <td height="28" colspan="3"><input name="dwmc" id="dwmc" type="text" value="" maxlength="100"  class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">�����˼�<br> ��ϵ�绰</td>
				    <td height="28" colspan="3"><input name="zrr" id="zrr" type="text" value="" maxlength="100"  class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">�ּ�������λ<br>���쵼</td>
				    <td colspan="4"><input name="gldw" id="gldw" type="text" value="" maxlength="100"  class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td rowspan="3" align="center" style="width:120px;">�ʽ�ƴ��</td>
				    <td height="35" align="center">ҵ���Գ�(��Ԫ)</td>
				    <td height="35" colspan="3"><input name="zjppzc" id="zjppzc" type="text" value="" maxlength="100" onkeyup="clearNoNum(this)"   class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td height="35" align="center">���д���(��Ԫ)</td>
				    <td height="35" colspan="3"><input name="zjppdk" id="zjppdk" type="text" value="" maxlength="100" onkeyup="clearNoNum(this)"   class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td height="35" align="center">����Ͷ��(��Ԫ)</td>
				    <td height="35" colspan="3"><input name="zjppzf" id="zjppzf" type="text" value="" maxlength="100" onkeyup="clearNoNum(this)"   class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">Ͷ����������</td>
				    <td colspan="4">
				    	<select name="ztxz" id="ztxz" class="select2">
							<option value=""></option>
							<option selected="selected" value="���ж���">���ж���</option>
							<option value="���пع������ʺ���">���пع������ʺ���</option>
							<option value="���пع�����Ӫ����">���пع�����Ӫ����</option>
							<option value="��Ӫ����">��Ӫ����</option>
							<option value="��Ӫ�ع������ʺ���">��Ӫ�ع������ʺ���</option>
							<option value="��Ӫ�ع�����к���">��Ӫ�ع�����к���</option>
							<option value="���ʶ���">���ʶ���</option>
							<option value="���ʿع�����к���">���ʿع�����к���</option>
							<option value="���ʿع�����Ӫ����">���ʿع�����Ӫ����</option>
							<option value="����">����</option>
						</select>
				    </td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">2014��ƻ�������<br>���ɻ򲿷ֽ���</td>
				    <td height="35" align="center">���������ɻ�<br>���ֽ���</td>
				    <td height="35" colspan="3">
				    	<label><input id="sfkg1" type="radio" name="sfkg" value="����" />����</label>
				    	<label><input id="sfkg2" type="radio" name="sfkg" value="���ֽ���" />���ֽ���</label>
				    	<label><input id="sfkg3" type="radio" name="sfkg" value="����" />����</label>
				    	<label><input id="sfkg4" type="radio" name="sfkg" value="��" />��</label>
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center">�·�</td>
				    <td height="35" colspan="3">
				    	<select name="kgyf" id="kgyf" class="select2">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
						</select>
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">��Ŀ���ɴ����<br>������Ч��</td>
				    <td colspan="4">&nbsp;&nbsp;
					��ֵ&nbsp;<input name="cz" id="cz" type="text" value="" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(��Ԫ)&nbsp;
					˰��&nbsp;<input name="ss" id="ss" type="text" value="" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(��Ԫ)&nbsp;
					�ṩ��ҵ��λ&nbsp;<input name="jy" id="jy" type="text" value="" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(��)
				</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">��Ŀ��ռ��(Ķ)</td>
				    <td height="28" colspan="4"><input name="zd" id="zd" type="text" value="" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">2014�����Ҫ��<br>Ԥ��������</td>
				    <td height="35" colspan="4">&nbsp;&nbsp; 
				    ũ�õ� <input name="nyd" id="nyd" type="text" value="" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(Ķ)&nbsp;&nbsp;
				    ���У�����ũ��<input name="nt" id="nt" type="text" value="" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(Ķ)&nbsp;&nbsp;
				    �ֵ� <input name="ld" id="ld" type="text" value="" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(Ķ)</td>
				  </tr>
				  <tr>
				    <td height="35" colspan="4">&nbsp;&nbsp;
				        ʩ������ <input name="sgyy" id="sgyy" type="text" value="" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(��)&nbsp;&nbsp;
				        ����Ʒ <input name="hgyp" id="hgyp" type="text" value="" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(��)&nbsp;&nbsp;
				        ���д��� <input name="yhdk" id="yhdk" type="text" value="" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(��Ԫ)</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">�Ƿ���������Ŀ</td>
				    <td height="28" colspan="4">
				    	<label><input id="sfscx1" type="radio" name="sfscx" value="��" />��</label>
				    	<label><input id="sfscx2" type="radio" name="sfscx" value="��" />��</label>
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">�Ƿ�����֮����Ŀ</td>
				    <td height="28" colspan="4">
				    	<label><input id="sfzz1" type="radio" name="sfzz" value="��" />��</label>
				    	<label><input id="sfzz2" type="radio" name="sfzz" value="��" />��</label>
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">�Ƿ�ʡ���ص���Ŀ</td>
				    <td height="28" colspan="4">
				    	<label><input id="sfss" type="radio" name="sfss" value="��" />��</label>
				    	<label><input id="sfss" type="radio" name="sfss" value="��" />��</label>
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">�Ƿ���Դ����Ŀ</td>
				    <td height="28" colspan="4">
				    	<label><input id="sfzy1" type="radio" name="sfzy" value="��" />��</label>
				    	<label><input id="sfzy2" type="radio" name="sfzy" value="��" />��</label>
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;"><div style="width:120px;">��ҵ����</div></td>
				    <td height="28" colspan="4" style="line-height:30px;">
				    	      <label><input id="sjslb2" type="radio" name="sjslb" value="��е" />��е</label>
				       <label><input id="sjslb3" type="radio" name="sjslb" value="��ɫ����" />��ɫ����</label>
				       <label><input id="sjslb1" type="radio" name="sjslb" value="�̲�" />�̲�</label>
						<label><input id="sjslb4" type="radio" name="sjslb" value="��Դ����" />��Դ����</label><br />
						<label><input id="sjslb6" type="radio" name="sjslb" value="��֯" />��֯</label>
						<label><input id="sjslb5" type="radio" name="sjslb" value="����" />����</label>
						<label><input id="sjslb7" type="radio" name="sjslb" value="����²���" />����²���</label>
						<label><input id="sjslb11" type="radio" name="sjslb" value="����ּ��ظ�" />����ּ��ظ�</label>
						<label><input id="sjslb9" type="radio" name="sjslb" value="ũ��Ʒ�ӹ�" />ũ��Ʒ�ӹ�</label>
						<label><input id="sjslb8" type="radio" name="sjslb" value="��ó����" />��ó����</label>	
						<label><input id="sjslb10" type="radio" name="sjslb" value="���μ��Ļ�����" />���μ��Ļ�����</label>
						<label><input id="sjslb12" type="radio" name="sjslb" value="��������" />��������</label>
				    </td>
				  </tr>
			</table>
    	</div>
    	<div class="foot_btn_box">
			 <input  type="button" value="�� ��"  onclick="save()" class="btnSubmit"/>
		</div>
    </form>
  </body>
</html>