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
	<title>政府信息公开指南</title>
	
	<script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = '<%=basePath%>admin/editor/';
    </script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>admin/editor/themes/default/css/ueditor.css"/>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>admin/editor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>admin/editor/ueditor.all.min.js"></script>
</head>

<body class="mainbody">
<form name="form1" method="post" action="<%=basePath%>admin/infoopen/InfoGuideServlet?act=update&topic=gkzn" id="form1">
<div class="navigation">首页 &gt; 政府信息公开专栏  &gt; 政府信息公开指南</div>
<div style="height:450px;">
<input type="hidden" value="公开指南" name="topic"/>
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
	         textarea:'descriptionEditor'
	     });
	     editor.render("editor");
	});
</script>
</div>
<div class="foot_btn_box" style="width::800px;" align="left">
	<input type="submit" name="btnSubmit" value="提交保存" id="btnSubmit" class="btnSubmit" />
&nbsp;<input  type="button" class="btnSubmit" value="返回" onclick="javascript:history.go(-1);" />
</div>
</form>
</body>
</html>
