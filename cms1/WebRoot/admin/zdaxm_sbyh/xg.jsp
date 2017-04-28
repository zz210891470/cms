<%@page import="com.trunko.project.entity.ProZdaxm"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	ProZdaxm item = (ProZdaxm) request.getAttribute("item");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<link rel="stylesheet" type="text/css" href="../images/style.css"/>
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

<script type="text/javascript">
	function save() {
		$("#form").submit();
	}

	function back() {
		window.parent.hideFrame();
	}

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
	$(function() {
		var NowDate = new Date();
		var NowYear = NowDate.getFullYear();
		var kgnHtml = "";
		var jgnHtml = "";
		var jsnx1Html = "";
		var jsnx2Html = "";
		var kgn = $("#kgnTemp").val();
		var jgn = $("#jgnTemp").val();
		var jsnx1 = $("#jsnx1Temp").val();
		var jsnx2 = $("#jsnx2Temp").val();

		// �����ꡢ��������1����������2
		for ( var i = NowYear - 5; i < NowYear + 5; i++) {
			if ((kgn != null && kgn != "") || (jgn != null && jgn != "")
					|| (jsnx1 != null && jsnx1 != "")
					|| (jsnx2 != null && jsnx2 != "")) { // ������ݲ�Ϊ��
				if (i == kgn) {
					kgnHtml += "<option value='"+kgn+"' selected>" + kgn
							+ "</option>";
				}
				if (i == jgn) {
					jgnHtml += "<option value='"+jgn+"' selected>" + jgn
							+ "</option>";
				}
				if (i == jsnx1) {
					jsnx1Html += "<option value='"+jsnx1+"' selected>" + jsnx1
							+ "</option>";
				}
				if (i == jsnx2) {
					jsnx2Html += "<option value='"+jsnx2+"' selected>" + jsnx2
							+ "</option>";
				}
			} else {
				if (i == NowYear) {
					kgnHtml += "<option value='"+i+"' selected>" + i
							+ "</option>";
					jgnHtml += "<option value='"+i+"' selected>" + i
							+ "</option>";
					jsnx1Html += "<option value='"+jsnx1+"' selected>" + jsnx1
							+ "</option>";
					jsnx2Html += "<option value='"+jsnx2+"' selected>" + jsnx2
							+ "</option>";
				}
			}
			kgnHtml += "<option value='"+i+"'>" + i + "</option>";
			jgnHtml += "<option value='"+i+"'>" + i + "</option>";
			jsnx1Html += "<option value='"+i+"'>" + i + "</option>";
			jsnx2Html += "<option value='"+i+"'>" + i + "</option>";
		}
		$("#kgn").html(kgnHtml);
		$("#jgn").html(jgnHtml);
		$("#jsnx1").html(jsnx1Html);
		$("#jsnx2").html(jsnx2Html);

	});

	// ��ѡ�����ʱ���Զ�Ҳѡ�������
    function dqchange(t,id){
        // ѡ�еĵ���
 	   var selectDq = $(t).val();
        $("#"+id).find("option[text='"+ selectDq +"']").attr("selected",true); 
    }
</script>
</head>
<body class="mainbody">
	<input id="itemlb1" value="${item.lb1 }" type="hidden" />
	<input id="itemlb2" value="${item.lb2 }" type="hidden" />
	<input id="lblist" value="${lblist }" type="hidden" />
	<input id="kgnTemp" value="${item.kgn }" type="hidden" />
	<input id="jgnTemp" value="${item.jgn }" type="hidden" />
	<input id="kgyTemp" value="${item.kgy }" type="hidden" />
	<input id="jgyTemp" value="${item.jgy }" type="hidden" />
	<input id="jsnx1Temp" value="${item.jsnx1 }" type="hidden" />
	<input id="jsnx2Temp" value="${item.jsnx2 }" type="hidden" />
	<form name="form" method="post"
		action="<%=basePath%>admin/zdaxm/ZdaxmServlet?action=update" id="form">
		<div class="navigation">
			<a href="javascript:back();" class="back">����</a>��ҳ &gt; �ش���Ŀ���� &gt;
			��Ŀ��Ϣ�޸�
		</div>
		<div class="tab_con" style="display:block;">
			<table class="form_table">
				<col width="150px"></col>
				<tbody>
					<tr>
						<th height="35" align="center">��Ŀ��ȣ�<input type="hidden"
							value="${item.id }" name="id" />
						</th>
						<td><input name="nd" id="nd" type="text" value="${item.nd}"
							maxlength="4" class="txtInput normal required"
							onkeyup="clearNoNum(this);" />
						</td>
					</tr>
					<tr>
						<th>��Ŀ���ƣ�</th>
						<td><input name="mc" id="mc" type="text" value="${item.mc}"
							maxlength="100" class="txtInput normal required" />
						</td>
					</tr>
					<tr>
						<th>��������</th>
						<td colspan="2">
				    	<select name="dq" id="dq" onchange="dqchange(this,'jsdq')" >
						<c:if test="${item.dq==null||item.dq==''}"><option value="" selected >δѡ��</option></c:if>
					    <c:forEach  items="${dqlist}" var="dq">
					        <c:if test="${dq==item.dq}"><option value="${dq }" selected >${dq }</option></c:if>
					        <c:if test="${dq!=item.dq}"><option value="${dq }" >${dq }</option></c:if>
					    </c:forEach>
					    </select>
				    </td>
					</tr>
					<tr>
						<th>��Ŀ���</th>
						<td><select name="lb1" id="lb1" onchange="lbchange(this)">
								<c:if test="${item.lb1==null||item.lb1==''}">
									<option value="" selected>--��ѡ����ҵ����--</option>
								</c:if>
						</select>&nbsp;&nbsp;&nbsp; <select name="lb2" id="lb2">
						</select></td>
					</tr>
					<tr>
						<th>����ص㣺</th>
						<td>������ <select name="jsdq" id="jsdq" onchange="dqchange(this,'dq')">
							<c:if test="${item.jsdq==null||item.jsdq==''}"><option value="" selected >δѡ��</option></c:if>
						    <c:forEach  items="${dqlist}" var="jsdq">
						        <c:if test="${jsdq==item.dq}"><option value="${jsdq }" selected >${jsdq }</option></c:if>
						        <c:if test="${jsdq!=item.dq}"><option value="${jsdq }" >${jsdq }</option></c:if>
						    </c:forEach>
					    </select> ��(��/��) <input name="jsdd" id="jsdd" type="text"
							value="${item.jsdd }" maxlength="100"
							class="txtInput normal required" /> ��ҵ԰��������</td>
					</tr>
					<tr>
						<th>�����ģ�����ݣ�</th>
						<td><textarea name="jsgm" id="jsgm" rows="8" cols="20"
								class="small" style="width:80%;">${item.jsgm }</textarea>
						</td>
					</tr>
					<tr>
						<th height="35" align="center" style="width:120px;">��Ŀ��������׼��<br>
							�����ĺ� ��
							</td>
							<td><input name="bawh" id="bawh" type="text"
								value="${item.bawh }" maxlength="100"
								class="txtInput normal required" />
						</td>
					</tr>
					<tr>
						<th>��Ͷ�ʣ���Ԫ����</th>
						<td><input name="ztz" id="ztz" type="text"
							value="${item.ztz }" maxlength="100"
							class="txtInput normal required" onkeyup="clearNoNum(this);" />
						</td>
					</tr>
					<tr>
						<th>�������ޣ�</th>
						<td><select name="jsnx1" id="jsnx1" class="select2">
								<option value=""></option>
						</select> �� - <select name="jsnx2" id="jsnx2" class="select2">
								<option value=""></option>
						</select> ��</td>
					</tr>
					<tr>
						<th>����ƻ�Ͷ�ʣ���Ԫ����</th>
						<td><input name="jhtz" id="jhtz" type="text"
							value="${item.jhtz }" maxlength="100"
							class="txtInput normal required" onkeyup="clearNoNum(this);" />
						</td>
					</tr>
					<tr>
						<th>����Ŀ�꣺</th>
						<td><textarea name="jdmb" rows="8" cols="30" id="jdmb"
								class="small" style="width:80%;">${item.jdmb }</textarea>
						</td>
					</tr>
					<tr>
						<th>���������ƻ���</th>
						<td>��������<select name="kgn" id="kgn" class="select2">
								<option value=""></option>
						</select> ��
							 <select name="kgy"
							id="kgy" class="select2">
								<%
									for (int i = 1; i < 13; i++) {
										if (i == Integer.parseInt(item.getKgy())) {
								%>
								<option value="<%=i%>" selected><%=i%></option>
								<%
									} else {
								%>
								<option value="<%=i%>"><%=i%></option>
								<%
									}
									}
								%>
						</select> ��&nbsp;&nbsp;&nbsp;&nbsp; ��������<select name="jgn" id="jgn"
							class="select2">
								<option value=""></option>
						</select> ��<select name="jgy"
							id="jgy" class="select2">
								<%
									for (int i = 1; i < 13; i++) {
										if (i == Integer.parseInt(item.getJgy())) {
								%>
								<option value="<%=i%>" selected><%=i%></option>
								<%
									} else {
								%>
								<option value="<%=i%>"><%=i%></option>
								<%
									}
									}
								%>
						</select>  ��</td>
					</tr>
					<tr>
						<th>����Ҫ������</th>
						<td>�õ����<input name="yd" id="yd" type="text"
							value="${item.yd }" maxlength="100" style="width:50px;"
							class="txtInput normal required" onkeyup="clearNoNum(this);" />Ķ
							�������<input name="ld" id="ld" type="text" value="${item.ld }"
							maxlength="100" style="width:50px;"
							class="txtInput normal required" onkeyup="clearNoNum(this);" />Ķ
						</td>
					</tr>
					<tr>
						<th>�ۼ������Ͷ�ʣ�</th>
						<td><input name="wctz" id="wctz" type="text"
							value="${item.wctz }" maxlength="100"
							class="txtInput normal required" onkeyup="clearNoNum(this);" />
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="foot_btn_box">
			<input type="button" value="����" onclick="save()" class="btnSubmit" />&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="����" onclick="back()" class="btnSubmit" />
		</div>
	</form>
</body>
</html>
