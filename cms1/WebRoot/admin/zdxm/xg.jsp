<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="com.trunko.cms.util.FavoritesHelper"%>
<%@page import="com.trunko.project.entity.ProZdxm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
// �ص���Ŀ��Ϣ����
ProZdxm item = (ProZdxm)request.getAttribute("item");
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

       $(function(){
		   // �����ꡢ��������1����������2ֵ����
           var NowDate=new Date();
           var NowYear=NowDate.getFullYear();
           var kgnHtml="";
           var jsnx1Html="";
           var jsnx2Html="";
           var kgn = $("#kgnTemp").val();
	       var jsnx1 = $("#jsnx1Temp").val();
	       var jsnx2 = $("#jsnx2Temp").val();
	       	kgnHtml = "<option value='"+kgn+"'selected>"+kgn+"</option>";
	       	kgnHtml+="<option value='��'>��</option>";
	       // �����ꡢ��������1����������2
	       for(var  i = NowYear-5 ; i < NowYear+5; i++){
		       	if((kgn != null && kgn != "")||(jsnx1 != null && jsnx1 != "")||(jsnx2 != null && jsnx2 != "")){ // ������ݲ�Ϊ��
			       	if(i == kgn){
			       		//kgnHtml += "<option value='"+kgn+"' selected>"+kgn+"</option>";
			       	}
			    	if(i == jsnx1){
			       		jsnx1Html += "<option value='"+jsnx1+"' selected>"+jsnx1+"</option>";
			       	}
			    	if(i == jsnx2){
			       		jsnx2Html += "<option value='"+jsnx2+"' selected>"+jsnx2+"</option>";
			       	}
		       	}else{
					if(i == NowYear){
						kgnHtml += "<option value='"+i+"' selected>"+i+"</option>";
						jsnx1Html += "<option value='"+jsnx1+"' selected>"+jsnx1+"</option>";
						jsnx2Html += "<option value='"+jsnx2+"' selected>"+jsnx2+"</option>";
					}
		       	}
		       	kgnHtml += "<option value='"+i+"'>"+i+"</option>";
				jsnx1Html += "<option value='"+i+"'>"+i+"</option>";
				jsnx2Html += "<option value='"+i+"'>"+i+"</option>";
		   }
	       $("#kgn").html(kgnHtml);
	       $("#jsnx1").html(jsnx1Html);
	       $("#jsnx2").html(jsnx2Html);
	       // ��������
	       var ztxz = ["","���ж���","���пع������ʺ���","���пع�����Ӫ����","��Ӫ����","��Ӫ�ع������ʺ���","��Ӫ�ع�����к���","���ʶ���","���ʿع�����к���","���ʿع�����Ӫ����","����"];
	       var ztxzHtml = "";
	       var ztxzVal = "<%=item.getTzztxz() %>";
	       for(var index=0; index<ztxz.length; index++){
	    	   if(ztxzVal == ztxz[index]){
	    		   ztxzHtml += "<option value='"+ztxz[index]+"' selected>"+ztxz[index]+"</option>";
		       }else{
		    	   ztxzHtml += "<option value='"+ztxz[index]+"'>"+ztxz[index]+"</option>";
			   }
		   }
	       $("#ztxz").html(ztxzHtml);
	       
	       // ����ѡ��Ļ���
	       // �Ƿ񿪹�
	       checkBack("sfkg","<%=item.getSfkg() %>");
	       // �Ƿ�������
	       checkBack("sfscx","<%=item.getSfscx() %>");
	       // �Ƿ�����֮��
	       checkBack("sfzz","<%=item.getSfzz() %>");
	       // �Ƿ��ص���Ŀ
	       checkBack("sfss","<%=item.getSfss() %>");
	       // �Ƿ���Դ����Ŀ
	       checkBack("sfzy","<%=item.getSfzy() %>");
	       // ����ҵ����
	       checkBack("sjslb","<%=item.getSjslb() %>");
       });
       
       var lblist ; 	// ��ҵ��𼯺�
       // ҳ�������ɺ��Զ���ʾ��ҵ�����ṩѡ��
       $(function(){
           var temp = $("#lblist").val() ;
           if(temp != ""){             
               lblist = eval(temp);  
               var lb1html ='';
               var lb2html =""; 
               
               for(var i=0;i<lblist.length; i++){
                   if(lblist[i].pid==0){
                       if(lblist[i].mc==$('#itemlb1').val()){
                           lb1html += '<option value="'+lblist[i].mc+'" selected>'+lblist[i].mc+'</option>';
                       }else{
                           lb1html += '<option value="'+lblist[i].mc+'">'+lblist[i].mc+'</option>';
                       }
                   }
                   if(lblist[i].mc==$('#itemlb2').val()){
                       var tempid = lblist[i].pid;
                       for(var j=0;j<lblist.length; j++){
                        if(tempid == lblist[j].pid){
                            if(lblist[j].mc==$('#itemlb2').val()){
                                lb2html += '<option value="'+lblist[j].mc+'" selected>'+lblist[j].mc+'</option>';
                            }else{
                                lb2html += '<option value="'+lblist[j].mc+'" >'+lblist[j].mc+'</option>';
                            }
                        }
                    }
                   }
               }
               $('#lb1').append(lb1html);
               $("#lb2").html(lb2html);    
           }
           
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
	<form name="form" method="post" action="<%=basePath%>admin/zdxm/ZdxmServlet?action=update" id="form">
	<input id="itemlb1" value="${item.lb1 }" type="hidden"/>
    <input id="itemlb2" value="${item.lb2 }" type="hidden"/>
	<input id="kgnTemp" value="${item.kgn }" type="hidden"/>
	<input id="jsnx1Temp" value="${item.jsnx1 }" type="hidden"/>
    <input id="jsnx2Temp" value="${item.jsnx2 }" type="hidden"/>
    <input id="lblist" value="${lblist }" type="hidden"/>
	<input type="hidden" name="id" value="${item.id }"/>
    	<div class="navigation"><a href="javascript:back();"  class="back">����</a>��ҳ &gt; �ص���Ŀ���� &gt; �ص���Ŀ��Ϣ�޸�</div>
    	<div class="tab_con" style="display:block;">
    		<table width="100%" border="1" cellpadding="0" cellspacing="0" style="border:solid 1px #EDECFF;" >
				  <tr>
				    <td height="35" align="center">��Ŀ���</td>
				    <td colspan="4" bgcolor="#FFFFFF">
			        <c:if test="${item.lb=='�ڽ�'}">
				    <input type="radio" name="lb" checked value="�ڽ�"/>�ڽ�
				    <input type="radio" name="lb" value="Ԥ��"/>Ԥ��
				    <input type="radio" name="lb" value="ǰ��"/>ǰ��
				    </c:if>
				    <c:if test="${item.lb=='Ԥ��'}">
				    <input type="radio" name="lb" value="�ڽ�"/>�ڽ�
				    <input type="radio" name="lb" checked value="Ԥ��"/>Ԥ��
				    <input type="radio" name="lb" value="ǰ��"/>ǰ��
				    </c:if>
				    <c:if test="${item.lb=='ǰ��'}">
				    <input type="radio" name="lb" value="�ڽ�"/>�ڽ�
				    <input type="radio" name="lb" value="Ԥ��"/>Ԥ��
				    <input type="radio" name="lb" checked value="ǰ��"/>ǰ��
				    </c:if>
				    </td>
				  </tr>
				  
				  <tr>
				    <td height="35" align="center" style="widtd:120px;">��Ŀ����</td>
				    <td colspan="4"><input id="mc" name="mc" type="text" value="${item.mc }" maxlength="100"  class="txtInput normal required" /><font color="red"> *</font> </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="widtd:120px;">��Ŀ���</td>
				    <td colspan="2"><input id="nd" name="nd" type="text" value="${item.nd }" onkeyup="clearNoNum(this)"  size="4" style="width: 130px;"  class="txtInput normal required" /><font color="red"> *</font> </td>
				    <td align="center" width="80">��Ŀ���</td>
				    <td width="130"><input name="bh" type="text" value="${item.bh }" maxlength="100" class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="widtd:120px;">��������</td>
				    <td colspan="2">
				    	<select name="dq" id="dq" onchange="dqchange(this,'jsdq')" >
						<c:if test="${item.dq==null||item.dq==''}"><option value="" selected >δѡ��</option></c:if>
					    <c:forEach  items="${dqlist}" var="dq">
					        <c:if test="${dq==item.dq}"><option value="${dq }" selected >${dq }</option></c:if>
					        <c:if test="${dq!=item.dq}"><option value="${dq }" >${dq }</option></c:if>
					    </c:forEach>
					    </select>
				    </td>
				    <td align="center" widtd="80">��������</td>
				        <td width="130">
				        	<select name="kgn" id="kgn" class="select2">
								<option value=""></option>
							</select> ��
							<select name="kgy" id="kgy" class="select2">
							<option value="${item.kgy}" selected>${item.kgy}</option>
							<option value="��">��</option>
								<%
									
									for(int i=1; i<13; i++){
					
										
											%>
												<option value="<%=i %>" ><%=i %></option>
											<%
										}

								%>
							</select> ��
				        </td>
				  </tr>
				<tr>
					<td height="35" align="center" style="width:120px;">������ҵ</td>
					<td colspan="4">
						<select name="lb1" id="lb1" onchange="lbchange(this)" >
					    <c:if test="${item.lb1==null||item.lb1==''}"><option value="" selected >--��ѡ����ҵ����--</option></c:if>
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
							<c:if test="${item.dq==null||item.dq==''}"><option value="" selected >δѡ��</option></c:if>
						    <c:forEach  items="${dqlist}" var="dq">
						        
						        <c:if test="${dq==item.dq}"><option value="${dq }" selected >${dq }</option></c:if>
						        <c:if test="${dq!=item.dq}"><option value="${dq }" >${dq }</option></c:if>
						    </c:forEach>
					    </select> ��(��/��)
				    	<input name="jsdd" type="text" value="${item.jsdd }" maxlength="100"  class="txtInput normal required" /> ��ҵ԰��������
				    </td>
				  </tr>
				  <tr>
				    <td height="100" align="center" style="width:120px;">�������ݼ���ģ</td>
				    <td colspan="4" valign="top" style=" padding:10px;">
				    	<textarea name="jsgm"  rows="5" cols="20" id="jsgm" class="small" style="width:80%;">${item.jsgm }</textarea>
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">��Ŀ��������׼��<br>�����ĺ�</td>
				    <td colspan="2"><input name="bawh" type="text" value="${item.bawh }" maxlength="100"  class="txtInput normal required" /></td>
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
				    <td colspan="4"><input name="ztz" type="text" value="${item.ztz }" onblur="validNum(this)" maxlength="100"  class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">��ȥ���Ԥ��<br>��չ���</td>
				    <td height="35" align="center" style="width:110px;"><div style="width:110px;">��ȥ����ۼ�<br>���Ͷ��(��Ԫ)</div></td>
				    <td height="28" colspan="3" style="width:470px;"><input name="wctz" type="text" value="${item.wctz} " maxlength="100" onblur="validNum(this)"   class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">�����򹤳�<br>��չ���</td>
				    <td height="28" colspan="3" style="padding:10px;">
				    	<textarea name="jzqk"  rows="4" cols="20" id="jzqk" class="small" style="width:80%;">${item.jzqk }</textarea>
				    </td>
				  </tr>
				  <tr>
				    <td rowspan="3" align="center" style="width:120px;">���깤��Ŀ��</td>
				    <td height="35" align="center" style="width:110px;">�ƻ�Ͷ��(��Ԫ)</td>
				    <td height="28" colspan="3"><input name="jhtz" type="text" value="${item.jhtz }" maxlength="100"  onblur="validNum(this)"   class="txtInput normal required" /></td>
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
							<input name="tz1" type="text" value="${item.tz1 }" maxlength="100"  class="txtInput normal required" onblur="validNum(this)"  style="width:100%;border:0;" />
						</td>
				        <td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							<input name="tz2" type="text" value="${item.tz2 }" maxlength="100"  class="txtInput normal required" onblur="validNum(this)"  style="width:100%;border:0;" />
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							<input name="tz3" type="text" value="${item.tz3 }" maxlength="100"  class="txtInput normal required" onblur="validNum(this)"  style="width:100%;border:0;" />
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							<input name="tz4" type="text" value="${item.tz4 }" maxlength="100"  class="txtInput normal required" onblur="validNum(this)"  style="width:100%;border:0;" />
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							<input name="tz5" type="text" value="${item.tz5 }" maxlength="100"  class="txtInput normal required" onblur="validNum(this)"  style="width:100%;border:0;" />
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							<input name="tz6" type="text" value="${item.tz6 }" maxlength="100"  class="txtInput normal required" onblur="validNum(this)"  style="width:100%;border:0;" />
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							<input name="tz7" type="text" value="${item.tz7 }" maxlength="100"  class="txtInput normal required" onblur="validNum(this)"  style="width:100%;border:0;" />
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							<input name="tz8" type="text" value="${item.tz8 }" maxlength="100"  class="txtInput normal required" onblur="validNum(this)"  style="width:100%;border:0;" />
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							<input name="tz9" type="text" value="${item.tz9 }" maxlength="100"  class="txtInput normal required" onblur="validNum(this)"  style="width:100%;border:0;" />
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							<input name="tz10" type="text" value="${item.tz10 }" maxlength="100"  class="txtInput normal required" onblur="validNum(this)"  style="width:100%;border:0;" />
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							<input name="tz11" type="text" value="${item.tz11 }" maxlength="100"  class="txtInput normal required" onblur="validNum(this)"  style="width:100%;border:0;" />
						</td>
				        <td align="center" bgcolor="White">
							<input name="tz12" type="text" value="${item.tz12 }" maxlength="100"  class="txtInput normal required" onblur="validNum(this)"  style="width:100%;border:0;" />
						</td>
				      </tr>
				    </table></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">���̽���</td>
				    <td height="28" colspan="3" style="padding:10px;">
				    	<textarea name="gcjd" id="gcjd" rows="4" cols="20"  class="txtInput normal required" style="font-family:����;height:80px;width:80%;">${item.gcjd }</textarea>
				    </td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">��Ŀҵ��(���衢<br />�ｨ��������λ)</td>
				    <td height="35" align="center" style="width:110px;">��λ����</td>
				    <td height="28" colspan="3"><input name="dwmc" id="dwmc" type="text" value="${item.dwmc }" maxlength="100"  class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">�����˼�<br> ��ϵ�绰</td>
				    <td height="28" colspan="3"><input name="zrr" id="zrr" type="text" value="${item.zrr }" maxlength="100"  class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">�ּ�����λ<br>���쵼</td>
				    <td colspan="4"><input name="gldw" id="gldw" type="text" value="${item.gldw }" maxlength="100"  class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td rowspan="3" align="center" style="width:120px;">�ʽ�ƴ��</td>
				    <td height="35" align="center">ҵ���Գ�(��Ԫ)</td>
				    <td height="35" colspan="3"><input name="zjppzc" id="zjppzc" type="text" value="${item.zjppzc }" maxlength="100" onblur="validNum(this)"   class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td height="35" align="center">���д���(��Ԫ)</td>
				    <td height="35" colspan="3"><input name="zjppdk" id="zjppdk" type="text" value="${item.zjppdk }" maxlength="100" onblur="validNum(this)"   class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td height="35" align="center">����Ͷ��(��Ԫ)</td>
				    <td height="35" colspan="3"><input name="zjppzf" id="zjppzf" type="text" value="${item.zjppzf }" maxlength="100" onblur="validNum(this)"   class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">Ͷ����������</td>
				    <td colspan="4">
				    	<select name="ztxz" id="ztxz" class="select2">
						</select>
				    </td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">����ƻ�������<br>���ɻ򲿷ֽ���</td>
				    <td height="35" align="center">���������ɻ�<br>���ֽ���</td>
				    <td height="35" colspan="3">
				    	<label><input id="sfkg1" type="radio" name="sfkg" value="����" />����</label>
				    	<label><input id="sfkg2" type="radio" name="sfkg" value="���ֽ���" />���ֽ���</label>
				    	<label><input id="sfkg3" type="radio" name="sfkg" value="����" />����</label>
				    	<label><input id="sfkg4" type="radio" name="sfkg" value="��"/>��</label>
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center">�·�</td>
				    <td height="35" colspan="3">
				    	<select name="kgyf" id="kgyf" class="select2">
				    	<option value="${item.kgyf}" selected>${item.kgyf}</option>
						<option value="��">��</option>
								<%
									
									for(int i=1; i<13; i++){
					
										
											%>
												<option value="<%=i %>" ><%=i %></option>
											<%
										}

								%>
							</select> ��
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">��Ŀ���ɴ����<br>������Ч��</td>
				    <td colspan="4">&nbsp;&nbsp;
					��ֵ&nbsp;<input name="cz" id="cz" type="text" value="${item.cz }" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(��Ԫ)&nbsp;
					˰��&nbsp;<input name="ss" id="ss" type="text" value="${item.ss }" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(��Ԫ)&nbsp;
					�ṩ��ҵ��λ&nbsp;<input name="jy" id="jy" type="text" value="${item.jy }" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(��)
				</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">��Ŀ��ռ��(Ķ)</td>
				    <td height="28" colspan="4"><input name="zd" id="zd" type="text" value="${item.zd }" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">�������Ҫ��<br>Ԥ��������</td>
				    <td height="35" colspan="4">&nbsp;&nbsp; 
				    ũ�õ� <input name="nyd" id="nyd" type="text" value="${item.nyd }" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(Ķ)&nbsp;&nbsp;
				    ���У�����ũ��<input name="nt" id="nt" type="text" value="${item.nt }" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(Ķ)&nbsp;&nbsp;
				    �ֵ� <input name="ld" id="ld" type="text" value="${item.ld }" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(Ķ)</td>
				  </tr>
				  <tr>
				    <td height="35" colspan="4">&nbsp;&nbsp;
				        ʩ������ <input name="sgyy" id="sgyy" type="text" value="${item.sgyy }" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(��)&nbsp;&nbsp;
				        ����Ʒ <input name="hgyp" id="hgyp" type="text" value="${item.hgyp }" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(��)&nbsp;&nbsp;
				        ���д��� <input name="yhdk" id="yhdk" type="text" value="${item.yhdk }" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(��Ԫ)</td>
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
				    	<label><input id="sfss1" type="radio" name="sfss" value="��" />��</label>
				    	<label><input id="sfss2" type="radio" name="sfss" value="��" />��</label>
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
						<label><input id="sjslb13" type="radio" name="sjslb" value="ȡ��ѡ��" />ȡ��ѡ��</label>



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
