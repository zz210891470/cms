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
	
	<script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = '<%=basePath%>admin/editor/';
    </script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>admin/editor/themes/default/css/ueditor.css"/>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>admin/editor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>admin/editor/ueditor.all.min.js"></script>
    <script type="text/javascript" language="javascript" src="../My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript">
    function checkform(){
	if(document.getElementById("topic").value==""){
		alert("标题不能为空！");
		document.getElementById("topic").focus();
		return false;
		}
	if(document.getElementById("time").value==""){
		alert("发布日期不能为空！");
		document.getElementById("time").focus();
		return false;
		}
	return true;
	}
    </script>
</head>

<body class="mainbody">
<form name="form1" method="post" action="<%=basePath%>admin/infoopen/InfoRegServlet?act=update" id="form1" onsubmit="return checkform();">
	<div class="navigation">首页 &gt; 政府信息公开专栏 &gt; 信息公开规定 &gt; 编辑信息</div>
    <div class="tab_con" style="display:block;">
    
        <input type="hidden" value="${item.id }" name="id"/>
		<table class="form_table">
				<col width="100px"></col>
				<tbody>
				<tr >
					<th width="150px;">标题</th>
					<td><input name="topic" id="topic" type="text" value="${item.topic }" maxlength="100"  class="txtInput normal required" /><label>*</label></td>
				</tr>
				<tr>
					<th>发布日期</th>
					<td><input name="time" id="time" type="text" value="${item.time }" maxlength="100" class="Wdate"  onClick="WdatePicker()" /><label>*</label></td>
				</tr>
				<tr>
                <th valign="top">内容</th>
                <td>
	               <div style="height:450px;">
	                <script type="text/plain" id="editor" name="content">
                         ${item.content }
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