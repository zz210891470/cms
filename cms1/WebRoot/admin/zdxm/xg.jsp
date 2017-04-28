<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="com.trunko.cms.util.FavoritesHelper"%>
<%@page import="com.trunko.project.entity.ProZdxm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
// 重点项目信息对象
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
               alert("项目名称和项目年份均不可为空！");
               return;
           }
           $("#form").submit();
       }
       
       function back(){
           window.parent.hideFrame();
       }

       $(function(){
		   // 开工年、建设年限1、建设年限2值回填
           var NowDate=new Date();
           var NowYear=NowDate.getFullYear();
           var kgnHtml="";
           var jsnx1Html="";
           var jsnx2Html="";
           var kgn = $("#kgnTemp").val();
	       var jsnx1 = $("#jsnx1Temp").val();
	       var jsnx2 = $("#jsnx2Temp").val();
	       	kgnHtml = "<option value='"+kgn+"'selected>"+kgn+"</option>";
	       	kgnHtml+="<option value='无'>无</option>";
	       // 开工年、建设年限1、建设年限2
	       for(var  i = NowYear-5 ; i < NowYear+5; i++){
		       	if((kgn != null && kgn != "")||(jsnx1 != null && jsnx1 != "")||(jsnx2 != null && jsnx2 != "")){ // 开工年份不为空
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
	       // 主体性质
	       var ztxz = ["","国有独资","国有控股与外资合资","国有控股与民营合资","民营独资","民营控股与外资合资","民营控股与国有合资","外资独资","外资控股与国有合资","外资控股与民营合资","其他"];
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
	       
	       // 各单选框的回填
	       // 是否开工
	       checkBack("sfkg","<%=item.getSfkg() %>");
	       // 是否生产性
	       checkBack("sfscx","<%=item.getSfscx() %>");
	       // 是否重中之重
	       checkBack("sfzz","<%=item.getSfzz() %>");
	       // 是否重点项目
	       checkBack("sfss","<%=item.getSfss() %>");
	       // 是否资源型项目
	       checkBack("sfzy","<%=item.getSfzy() %>");
	       // 按产业分类
	       checkBack("sjslb","<%=item.getSjslb() %>");
       });
       
       var lblist ; 	// 行业类别集合
       // 页面加载完成后，自动显示行业大类提供选择
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
       // 当选择某个大类时，自动显示大类下的小类
       function lbchange(t){
           var lb2html ='<option value="" selected>--请选择行业小类--</option>'; 
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
    	// 当选择地区时，自动也选择建设地区
       function dqchange(t,id){
           // 选中的地区
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
    	<div class="navigation"><a href="javascript:back();"  class="back">返回</a>首页 &gt; 重点项目管理 &gt; 重点项目信息修改</div>
    	<div class="tab_con" style="display:block;">
    		<table width="100%" border="1" cellpadding="0" cellspacing="0" style="border:solid 1px #EDECFF;" >
				  <tr>
				    <td height="35" align="center">项目类别</td>
				    <td colspan="4" bgcolor="#FFFFFF">
			        <c:if test="${item.lb=='在建'}">
				    <input type="radio" name="lb" checked value="在建"/>在建
				    <input type="radio" name="lb" value="预备"/>预备
				    <input type="radio" name="lb" value="前期"/>前期
				    </c:if>
				    <c:if test="${item.lb=='预备'}">
				    <input type="radio" name="lb" value="在建"/>在建
				    <input type="radio" name="lb" checked value="预备"/>预备
				    <input type="radio" name="lb" value="前期"/>前期
				    </c:if>
				    <c:if test="${item.lb=='前期'}">
				    <input type="radio" name="lb" value="在建"/>在建
				    <input type="radio" name="lb" value="预备"/>预备
				    <input type="radio" name="lb" checked value="前期"/>前期
				    </c:if>
				    </td>
				  </tr>
				  
				  <tr>
				    <td height="35" align="center" style="widtd:120px;">项目名称</td>
				    <td colspan="4"><input id="mc" name="mc" type="text" value="${item.mc }" maxlength="100"  class="txtInput normal required" /><font color="red"> *</font> </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="widtd:120px;">项目年份</td>
				    <td colspan="2"><input id="nd" name="nd" type="text" value="${item.nd }" onkeyup="clearNoNum(this)"  size="4" style="width: 130px;"  class="txtInput normal required" /><font color="red"> *</font> </td>
				    <td align="center" width="80">项目编号</td>
				    <td width="130"><input name="bh" type="text" value="${item.bh }" maxlength="100" class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="widtd:120px;">所属地域</td>
				    <td colspan="2">
				    	<select name="dq" id="dq" onchange="dqchange(this,'jsdq')" >
						<c:if test="${item.dq==null||item.dq==''}"><option value="" selected >未选择</option></c:if>
					    <c:forEach  items="${dqlist}" var="dq">
					        <c:if test="${dq==item.dq}"><option value="${dq }" selected >${dq }</option></c:if>
					        <c:if test="${dq!=item.dq}"><option value="${dq }" >${dq }</option></c:if>
					    </c:forEach>
					    </select>
				    </td>
				    <td align="center" widtd="80">开工日期</td>
				        <td width="130">
				        	<select name="kgn" id="kgn" class="select2">
								<option value=""></option>
							</select> 年
							<select name="kgy" id="kgy" class="select2">
							<option value="${item.kgy}" selected>${item.kgy}</option>
							<option value="无">无</option>
								<%
									
									for(int i=1; i<13; i++){
					
										
											%>
												<option value="<%=i %>" ><%=i %></option>
											<%
										}

								%>
							</select> 月
				        </td>
				  </tr>
				<tr>
					<td height="35" align="center" style="width:120px;">所属行业</td>
					<td colspan="4">
						<select name="lb1" id="lb1" onchange="lbchange(this)" >
					    <c:if test="${item.lb1==null||item.lb1==''}"><option value="" selected >--请选择行业大类--</option></c:if>
						</select>&nbsp;&nbsp;&nbsp;
						<select name="lb2" id="lb2"  >
						</select>
					</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">建设地点</td>
				    <td colspan="4">
				    	<select name="jscs" id="jscs" class="select2">
							<option value="龙岩市">龙岩</option>
						</select>
						<select name="jsdq" id="jsdq" onchange="dqchange(this,'dq')">
							<c:if test="${item.dq==null||item.dq==''}"><option value="" selected >未选择</option></c:if>
						    <c:forEach  items="${dqlist}" var="dq">
						        
						        <c:if test="${dq==item.dq}"><option value="${dq }" selected >${dq }</option></c:if>
						        <c:if test="${dq!=item.dq}"><option value="${dq }" >${dq }</option></c:if>
						    </c:forEach>
					    </select> 县(市/区)
				    	<input name="jsdd" type="text" value="${item.jsdd }" maxlength="100"  class="txtInput normal required" /> 工业园区或乡镇
				    </td>
				  </tr>
				  <tr>
				    <td height="100" align="center" style="width:120px;">建设内容及规模</td>
				    <td colspan="4" valign="top" style=" padding:10px;">
				    	<textarea name="jsgm"  rows="5" cols="20" id="jsgm" class="small" style="width:80%;">${item.jsgm }</textarea>
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">项目审批、核准、<br>备案文号</td>
				    <td colspan="2"><input name="bawh" type="text" value="${item.bawh }" maxlength="100"  class="txtInput normal required" /></td>
				    <td align="center" width="80">建设年限</td>
				    <td width="130">
				    	<select name="jsnx1" id="jsnx1" class="select2">
							<option value=""></option>
						</select> 年 -
						<select name="jsnx2" id="jsnx2" class="select2">
							<option value=""></option>
						</select> 年
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">总投资(万元)</td>
				    <td colspan="4"><input name="ztz" type="text" value="${item.ztz }" onblur="validNum(this)" maxlength="100"  class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">至去年底预计<br>进展情况</td>
				    <td height="35" align="center" style="width:110px;"><div style="width:110px;">至去年底累计<br>完成投资(万元)</div></td>
				    <td height="28" colspan="3" style="width:470px;"><input name="wctz" type="text" value="${item.wctz} " maxlength="100" onblur="validNum(this)"   class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">工作或工程<br>进展情况</td>
				    <td height="28" colspan="3" style="padding:10px;">
				    	<textarea name="jzqk"  rows="4" cols="20" id="jzqk" class="small" style="width:80%;">${item.jzqk }</textarea>
				    </td>
				  </tr>
				  <tr>
				    <td rowspan="3" align="center" style="width:120px;">今年工作目标</td>
				    <td height="35" align="center" style="width:110px;">计划投资(万元)</td>
				    <td height="28" colspan="3"><input name="jhtz" type="text" value="${item.jhtz }" maxlength="100"  onblur="validNum(this)"   class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">其中(万元)</td>
				    <td height="28" colspan="3">
				    <table border="0" cellspacing="0" cellpadding="0" style="display:;">
				      <tr>
				        <td height="25" align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">1月</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">2月</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">3月</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">4月</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">5月</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">6月</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">7月</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">8月</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">9月</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">10月</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">11月</td>
				        <td align="center" bgcolor="White" style="width:39px;border-bottom:solid 1px #d5d5d5;">12月</td>
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
				    <td height="35" align="center" style="width:110px;">工程进度</td>
				    <td height="28" colspan="3" style="padding:10px;">
				    	<textarea name="gcjd" id="gcjd" rows="4" cols="20"  class="txtInput normal required" style="font-family:宋体;height:80px;width:80%;">${item.gcjd }</textarea>
				    </td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">项目业主(建设、<br />筹建、代建单位)</td>
				    <td height="35" align="center" style="width:110px;">单位名称</td>
				    <td height="28" colspan="3"><input name="dwmc" id="dwmc" type="text" value="${item.dwmc }" maxlength="100"  class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">责任人及<br> 联系电话</td>
				    <td height="28" colspan="3"><input name="zrr" id="zrr" type="text" value="${item.zrr }" maxlength="100"  class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">分级管理单位<br>及领导</td>
				    <td colspan="4"><input name="gldw" id="gldw" type="text" value="${item.gldw }" maxlength="100"  class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td rowspan="3" align="center" style="width:120px;">资金拼盘</td>
				    <td height="35" align="center">业主自筹(万元)</td>
				    <td height="35" colspan="3"><input name="zjppzc" id="zjppzc" type="text" value="${item.zjppzc }" maxlength="100" onblur="validNum(this)"   class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td height="35" align="center">银行贷款(万元)</td>
				    <td height="35" colspan="3"><input name="zjppdk" id="zjppdk" type="text" value="${item.zjppdk }" maxlength="100" onblur="validNum(this)"   class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td height="35" align="center">政府投资(万元)</td>
				    <td height="35" colspan="3"><input name="zjppzf" id="zjppzf" type="text" value="${item.zjppzf }" maxlength="100" onblur="validNum(this)"   class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">投资主体性质</td>
				    <td colspan="4">
				    	<select name="ztxz" id="ztxz" class="select2">
						</select>
				    </td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">今年计划开工、<br>建成或部分建成</td>
				    <td height="35" align="center">开工、建成或<br>部分建成</td>
				    <td height="35" colspan="3">
				    	<label><input id="sfkg1" type="radio" name="sfkg" value="开工" />开工</label>
				    	<label><input id="sfkg2" type="radio" name="sfkg" value="部分建成" />部分建成</label>
				    	<label><input id="sfkg3" type="radio" name="sfkg" value="建成" />建成</label>
				    	<label><input id="sfkg4" type="radio" name="sfkg" value="无"/>无</label>
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center">月份</td>
				    <td height="35" colspan="3">
				    	<select name="kgyf" id="kgyf" class="select2">
				    	<option value="${item.kgyf}" selected>${item.kgyf}</option>
						<option value="无">无</option>
								<%
									
									for(int i=1; i<13; i++){
					
										
											%>
												<option value="<%=i %>" ><%=i %></option>
											<%
										}

								%>
							</select> 月
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">项目建成达产后<br>年新增效益</td>
				    <td colspan="4">&nbsp;&nbsp;
					产值&nbsp;<input name="cz" id="cz" type="text" value="${item.cz }" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(万元)&nbsp;
					税收&nbsp;<input name="ss" id="ss" type="text" value="${item.ss }" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(万元)&nbsp;
					提供就业岗位&nbsp;<input name="jy" id="jy" type="text" value="${item.jy }" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(个)
				</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">项目总占地(亩)</td>
				    <td height="28" colspan="4"><input name="zd" id="zd" type="text" value="${item.zd }" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" /></td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">今年各类要素<br>预计需求量</td>
				    <td height="35" colspan="4">&nbsp;&nbsp; 
				    农用地 <input name="nyd" id="nyd" type="text" value="${item.nyd }" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(亩)&nbsp;&nbsp;
				    其中：基本农田<input name="nt" id="nt" type="text" value="${item.nt }" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(亩)&nbsp;&nbsp;
				    林地 <input name="ld" id="ld" type="text" value="${item.ld }" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(亩)</td>
				  </tr>
				  <tr>
				    <td height="35" colspan="4">&nbsp;&nbsp;
				        施工用油 <input name="sgyy" id="sgyy" type="text" value="${item.sgyy }" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(吨)&nbsp;&nbsp;
				        火工用品 <input name="hgyp" id="hgyp" type="text" value="${item.hgyp }" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(吨)&nbsp;&nbsp;
				        银行贷款 <input name="yhdk" id="yhdk" type="text" value="${item.yhdk }" maxlength="50" onkeyup="clearNoNum(this)"   class="txtInput normal required" style="width:50px;" />(万元)</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">是否生产性项目</td>
				    <td height="28" colspan="4">
				    	<label><input id="sfscx1" type="radio" name="sfscx" value="是" />是</label>
				    	<label><input id="sfscx2" type="radio" name="sfscx" value="否" />否</label>
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">是否重中之重项目</td>
				    <td height="28" colspan="4">
				    	<label><input id="sfzz1" type="radio" name="sfzz" value="是" />是</label>
				    	<label><input id="sfzz2" type="radio" name="sfzz" value="否" />否</label>
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">是否省属重点项目</td>
				    <td height="28" colspan="4">
				    	<label><input id="sfss1" type="radio" name="sfss" value="是" />是</label>
				    	<label><input id="sfss2" type="radio" name="sfss" value="否" />否</label>
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">是否资源型项目</td>
				    <td height="28" colspan="4">
				    	<label><input id="sfzy1" type="radio" name="sfzy" value="是" />是</label>
				    	<label><input id="sfzy2" type="radio" name="sfzy" value="否" />否</label>
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;"><div style="width:120px;">产业分类</div></td>
				    <td height="28" colspan="4" style="line-height:30px;">
				    
                        <label><input id="sjslb2" type="radio" name="sjslb" value="机械" />机械</label>
				        <label><input id="sjslb3" type="radio" name="sjslb" value="有色金属" />有色金属</label>
				        <label><input id="sjslb1" type="radio" name="sjslb" value="烟草" />烟草</label>
						<label><input id="sjslb4" type="radio" name="sjslb" value="能源精化" />能源精化</label><br />
						<label><input id="sjslb6" type="radio" name="sjslb" value="纺织" />纺织</label>
						<label><input id="sjslb5" type="radio" name="sjslb" value="建材" />建材</label>
						<label><input id="sjslb7" type="radio" name="sjslb" value="光电新材料" />光电新材料</label>
						<label><input id="sjslb11" type="radio" name="sjslb" value="不锈钢及特钢" />不锈钢及特钢</label>
						<label><input id="sjslb9" type="radio" name="sjslb" value="农产品加工" />农产品加工</label>
						<label><input id="sjslb8" type="radio" name="sjslb" value="商贸物流" />商贸物流</label>	
						<label><input id="sjslb10" type="radio" name="sjslb" value="旅游及文化创意" />旅游及文化创意</label>
						<label><input id="sjslb12" type="radio" name="sjslb" value="电子商务" />电子商务</label>
						<label><input id="sjslb13" type="radio" name="sjslb" value="取消选择" />取消选择</label>



				    </td>
				  </tr>
			</table>
    	</div>
    	<div class="foot_btn_box">
			 <input  type="button" value="保 存"  onclick="save()" class="btnSubmit"/>
		</div>
    </form>
  </body>
</html>
