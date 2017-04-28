<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
	<link rel="stylesheet" type="text/css" href="../images/style.css"/>
	<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script>  
	<script type="text/javascript" src="../js/function.js"></script>
	<title>编辑问题</title>
	
	<script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = '<%=basePath%>admin/editor/';
    </script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>admin/editor/themes/default/css/ueditor.css"/>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>admin/editor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>admin/editor/ueditor.all.min.js"></script>
	<script type="text/javascript" language="javascript" src="../My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
	function checkform(){
		if(document.getElementById("tb").value==""){
			alert("标题不能为空！");
			document.getElementById("tb").focus();
			return false;
			}
		if(document.getElementById("fl").value==""){
			alert("分类不能为空！");
			document.getElementById("fl").focus();
			return false;
			}
		if(document.getElementById("syh").value==""){
			alert("索引号不能为空！");
			document.getElementById("syh").focus();
			return false;
			}
		if(document.getElementById("fbjg").value==""){
			alert("发布机构不能为空！");
			document.getElementById("fbjg").focus();
			return false;
			}
		if(document.getElementById("fwrq").value==""){
			alert("发文日期不能为空！");
			document.getElementById("fwrq").focus();
			return false;
			}
		if(document.getElementById("wh").value==""){
			alert("文号不能为空！");
			document.getElementById("wh").focus();
			return false;
			}
		if(document.getElementById("ztc").value==""){
			alert("主题词不能为空！");
			document.getElementById("ztc").focus();
			return false;
			}
		return true;w
	}
	</script>
</head>

<body class="mainbody">
<form name="form1" method="post" action="<%=basePath%>admin/infoopen/InfoOpenServlet?act=update" id="form1" onsubmit="return checkform();">
	<div class="navigation">首页 &gt; 政府信息公开专栏 &gt; 信息公开目录 &gt; 编辑信息</div>
    
    <div class="tab_con" style="display:block;">
    
        <input type="hidden" value="${item.id }" name="id"/>
		<table class="form_table">
				<col width="100px"></col>
				<tbody>
				<tr>
					<th width="150px;">标题</th>
					<td><input name="bt" id="bt" type="text" value="${item.bt }" maxlength="100"  class="txtInput normal required" /><label>*</label></td>
				</tr>
				<tr>
					<th>分类</th>
					<td><input name="fl" id="fl" type="text" value="${item.fl }" maxlength="100"  class="txtInput normal required" /><label>*</label></td>
				</tr>
				<tr>
					<th>索引号</th>
					<td><input name="syh" id="syh" type="text" value="${item.syh }" maxlength="100" class="txtInput normal required" /><label>*</label></td>
				</tr>
				<tr>
					<th>发布机构</th>
					<td><input name="fbjg" id="fbjg" type="text" value="${item.fbjg }" maxlength="100" class="txtInput normal required" /><label>*</label></td>
				</tr>
				<tr>
					<th>发文日期</th>
					<td><input name="fwrq" id="fwrq" type="text" value="${item.fwrq }" maxlength="100" class="Wdate" onClick="WdatePicker()" /><label>*</label></td>
				</tr>
				<tr>
					<th>文号</th>
					<td><input name="wh" id="wh" type="text" value="${item.wh }" maxlength="100"  class="txtInput normal required" /><label>*</label></td>
				</tr>
				<tr>
					<th>主题词</th>
					<td><input name="ztc" id="ztc" type="text" value="${item.ztc }" maxlength="100"  class="txtInput normal required" /><label>*</label></td>
				</tr>
				<tr>
                <th valign="top">内容</th>
                <td>
	               <div style="height:450px;">
	                <script type="text/plain" id="editor" name="nr">
                         ${item.nr }
                   </script> 
	                   <script type="text/javascript">
						var editor;
		                var noteEditor;
		                $(document).ready(function(){
		                        editor = new baidu.editor.ui.Editor({
		                        autoHeightEnabled: false,
		                        initialFrameHeight:320,
		                        initialFrameWidth:800,
		                        textarea:'descriptionEditor'
		                    });
		                    editor.render("editor");
		               });
						</script>
	                   </div>
                </td>
            </tr>
				</tbody>
			</table>
		</div>
    		<div class="foot_btn_box">
		<input type="submit" name="btnSubmit" value="提交保存" id="btnSubmit" class="btnSubmit" />
		&nbsp;<input  type="button" class="btnSubmit" value="返回" onclick="javascript:history.go(-1);" />
		</div>
</form> 
</body>
</html>