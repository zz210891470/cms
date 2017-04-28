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
	<title>添加问题</title>
	
	<script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = '<%=basePath%>admin/editor/';
    </script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>admin/editor/themes/default/css/ueditor.css"/>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>admin/editor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>admin/editor/ueditor.all.min.js"></script>
        <script language="javascript" type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript">
       function save(){
         
           if($("#bt").val() != "" && $("#time").val() !=""){
               document.all.form1.submit();
           
           }else{
               alert("标题,发布时间不能为空！");
           }
       }
           function back(){
           window.parent.hideFrame();
       }
    </script>
      	<style>
	    body{
	        background-color:#ffffff;
	    }
	
	</style>
	
	
</head>

<body class="mainbody">
<form name="form1" method="post" action="PeopleQuestionServlet?act=add" id="form1">
	<div class="navigation"><a href="javascript:back();" class="back">后退</a>首页 &gt;公众参与管理&gt; 常见问题管理 &gt; 添加问题</div>
    
    <div class="tab_con" style="display:block;">
		<table class="form_table">
				<col width="180px"></col>
				<tbody>
				<tr>
					<th>问题</th>
					<td><input id="bt" name="question" type="text" value="" maxlength="100"  class="txtInput normal required" /><span style="color:red;">*</span></td>
				</tr>
				<tr>
					<th>作者</th>
					<td><input name="author" type="text" value="" maxlength="100"  class="txtInput normal required" /></td>
				</tr>
		 		<tr>
					<th>发布时间</th>
					<td><input class="Wdate" type="text" onClick="WdatePicker()" id="time" name="time"/> <span style="color:red;">*</span></td>
				</tr> 
				<tr>
                <th valign="top">内容</th>
                <td>
	               <div style="height:450px;">
	                <script type="text/plain" id="editor" name="answer">
                         
                   </script> 
	                   <script type="text/javascript">
						var editor;
		                var noteEditor;
		                $(document).ready(function(){
		                        editor = new baidu.editor.ui.Editor({
		                        initialFrameWidth:800,
		                        initialFrameHeight:320,
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
		<input type="button" onclick="save()" name="btnSubmit" value="提交保存" id="btnSubmit" class="btnSubmit" />
		&nbsp;<input  type="button" class="btnSubmit" value="返回" onclick="javascript:back();" />
		</div>
</form> 
</body>
</html>
