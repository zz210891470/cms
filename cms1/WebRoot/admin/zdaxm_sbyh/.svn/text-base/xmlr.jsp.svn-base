<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
		if ($("#nd").val() == "" || $("#mc").val() == "") {
			alert("项目年度，项目名称必须要填写！");
		} else {
			$("#form").submit();
		}
	}

    function back(){
        window.parent.hideFrame();
    }

	   // 页面加载完成后，自动显示行业大类提供选择
    var lblist ; 	// 行业类别集合
    $(function(){
    	if($("#status").val()=="ok"){
            alert("保存成功");
        }
        
        var temp = $("#lblist").val() ;
        if(temp != ""){             
            lblist = eval(temp);  
            var lb1html ='<option value="" selected>--请选择行业大类--</option>';
            for(var i=0;i<lblist.length; i++){
                if(lblist[i].pid==0){
                   lb1html += '<option value="'+lblist[i].mc+'">'+lblist[i].mc+'</option>';
                }
            }
            $('#lb1').html(lb1html);
        }

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

		// 开工年、建设年限1、建设年限2
		for ( var i = NowYear - 5; i < NowYear + 5; i++) {
			if ((kgn != null && kgn != "") || (jgn != null && jgn != "")
					|| (jsnx1 != null && jsnx1 != "")
					|| (jsnx2 != null && jsnx2 != "")) { // 开工年份不为空
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
					jsnx1Html += "<option value='"+i+"' selected>" + i
							+ "</option>";
					jsnx2Html += "<option value='"+i+"' selected>" + i
							+ "</option>";
				}
			}
			if(i != NowYear){
				kgnHtml += "<option value='"+i+"'>" + i + "</option>";
				jgnHtml += "<option value='"+i+"'>" + i + "</option>";
				jsnx1Html += "<option value='"+i+"'>" + i + "</option>";
				jsnx2Html += "<option value='"+i+"'>" + i + "</option>";
			}
		}
		$("#kgn").html(kgnHtml);
		$("#jgn").html(jgnHtml);
		$("#jsnx1").html(jsnx1Html);
		$("#jsnx2").html(jsnx2Html);
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
	<input id="status" value="${status }" type="hidden" />
	<input id="lblist" value="${lblist }" type="hidden" />
	<input id="kgnTemp" value="${item.kgn }" type="hidden" />
	<input id="jgnTemp" value="${item.jgn }" type="hidden" />
	<input id="kgyTemp" value="${item.kgy }" type="hidden" />
	<input id="jgyTemp" value="${item.jgy }" type="hidden" />
	<input id="jsnx1Temp" value="${item.jsnx1 }" type="hidden" />
	<input id="jsnx2Temp" value="${item.jsnx2 }" type="hidden" />
		<form name="form" method="post" action="<%=basePath%>admin/zdaxm_sbyh/ZdaxmSbyhServlet?action=xmlr" id="form">
		<div class="navigation">
			<a href="javascript:back();" class="back">返回</a>首页 &gt; 重大项目管理 &gt;
			项目信息录入
		</div>
		<div class="tab_con" style="display:block;">
			<table class="form_table">
				<col width="150px"></col>
				<tbody>
					<tr>
						<th height="35" align="center">项目年度：
							<td><input name="nd" id="nd" type="text" value=""
								maxlength="4" class="txtInput normal required"
								onkeyup="clearNoNum(this);" /><span style="color:red;">*</span>
						</td>
					</tr>
					<tr>
						<th>项目名称：</th>
						<td><input name="mc" id="mc" type="text" value=""
							maxlength="100" class="txtInput normal required" /><span
							style="color:red;">*</span></td>
					</tr>
					<tr>
						<th>所属区域：</th>
						<td><select name="dq" id="dq" class="select2" onchange="dqchange(this,'jsdq')">
								<c:forEach items="${dqlist}" var="item">
									<option value="${item }">${item }</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th>项目类别：</th>
						<td><select name="lb1" id="lb1" class="select2" onchange="lbchange(this)">
						</select>&nbsp;&nbsp;&nbsp;
						<select name="lb2" id="lb2"  >
						</select>
						</td>
					</tr>
					<tr>
						<th>建设地点：</th>
						<td>龙岩市 <select name="jsdq" id="jsdq" class="select2" onchange="dqchange(this,'dq')">
								<c:forEach items="${dqlist}" var="item">
									<option value="${item }">${item }</option>
								</c:forEach>
						</select> 县(市/区) <input name="jsdd" id="jsdd" type="text" value=""
							maxlength="100" class="txtInput normal required" /> 工业园区或乡镇</td>
					</tr>
					<tr>
						<th>建设规模及内容：</th>
						<td><textarea name="jsgm" id="jsgm" rows="8" cols="20"
								class="small" style="width:80%;"></textarea></td>
					</tr>
					<tr>
						<th height="35" align="center" style="width:120px;">项目审批、核准、<br>
							备案文号 ：
							</td>
							<td><input name="bawh" id="bawh" type="text" value=""
								maxlength="100" class="txtInput normal required" /></td>
					</tr>
					<tr>
						<th>总投资（万元）：</th>
						<td><input name="ztz" id="ztz" type="text" value=""
							maxlength="100" class="txtInput normal required"
							onkeyup="clearNoNum(this);" /></td>
					</tr>
					<tr>
						<th>建设年限：</th>
						<td><select name="jsnx1" id="jsnx1" class="select2">
								<option value=""></option>
						</select> 年 - <select name="jsnx2" id="jsnx2" class="select2">
								<option value=""></option>
						</select> 年</td>
					</tr>
					<tr>
						<th>本年计划投资（万元）：</th>
						<td><input name="jhtz" id="jhtz" type="text" value=""
							maxlength="100" class="txtInput normal required"
							onkeyup="clearNoNum(this);" /></td>
					</tr>
					<tr>
						<th>进度目标：</th>
						<td><textarea name="jdmb" rows="8" cols="30" id="jdmb"
								class="small" style="width:80%;"></textarea></td>
					</tr>
					<tr>
						<th>开工竣工计划：</th>
						<td>开工年月<select name="kgn" id="kgn" class="select2">
								<option value=""></option>
						</select> 年 <select name="kgy" id="kgy" class="select2">
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
						</select> 月&nbsp;&nbsp;&nbsp;&nbsp; 竣工年月<select name="jgn" id="jgn"
							class="select2">
								<option value=""></option>
						</select> 年 <select name="jgy" id="jgy" class="select2">
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
						</select> 月</td>
					</tr>
					<tr>
						<th>建设要素需求：</th>
						<td>用地面积<input name="yd" id="yd" type="text" value=""
							maxlength="100" style="width:50px;"
							class="txtInput normal required" onkeyup="clearNoNum(this);" />亩
							用林面积<input name="ld" id="ld" type="text" value="" maxlength="100"
							style="width:50px;" class="txtInput normal required"
							onkeyup="clearNoNum(this);" />亩</td>
					</tr>
					<tr>
						<th>累计已完成投资：</th>
						<td><input name="wctz" id="wctz" type="text" value=""
							maxlength="100" class="txtInput normal required"
							onkeyup="clearNoNum(this);" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="foot_btn_box">
			<input type="button" value="保存" onclick="save()" class="btnSubmit" />&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
	</form>
</body>
</html>

