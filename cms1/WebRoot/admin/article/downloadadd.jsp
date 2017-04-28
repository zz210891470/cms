<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
		<title>添加下载</title>
		<link rel="stylesheet" type="text/css" href="../images/style.css" />
		<script type="text/javascript" src="../js/jquery.js">
</script>
		<script type="text/javascript" src="../js/function.js">
</script>
		<script type="text/javascript" src="../js/ajaxfileupload.js">
</script>
		<style>
body {
	background-color: #ffffff;
}
</style>
		<script type="text/javascript">

function saveandrelease() {
	if ($("#bt").val() != "" && $("#rq").val()) {
		document.all.articleForm.target = "_self";
		document.all.articleForm.action = "<%=basePath%>admin/article/ArticleServlet?act=saveandrelease";
		document.all.articleForm.submit();
	} else {
		alert("标题和日期必须填写！");
	}

}

function saveandcontinue() {
	if ($("#bt").val() != "") {
		document.all.articleForm.target = "_self";
		document.all.articleForm.action = "<%=basePath%>admin/article/ArticleServlet?act=saveandcontinue&showType=download";
		document.all.articleForm.submit();
	} else {
		alert("标题和日期必须填写！");
	}

}

function save() {
	if ($("#bt").val() != "" && $("#rq").val()) {
		document.all.articleForm.target = "_self";
		document.all.articleForm.action = "<%=basePath%>admin/article/ArticleServlet?act=add";

		document.all.articleForm.submit();
	} else {
		alert("标题和日期必须填写！");
	}
}

function back() {
	window.parent.hideFrame();
}

String.prototype.EndWith = function(s) {
	if (s == null || s == "" || this.length == 0 || s.length > this.length) {
		return false;
	}

	if (this.substring(this.length - s.length) == s) {
		return true;
	} else {
		return false;
	}
	return true;
}

function download(){
     var filename=$('#ljwz').attr("value");
    document.location.href='<%=basePath%>action/filedownload.do?downloadname='+escape(escape(filename));
     return false;
    }
    
    function ajaxFileUpload(){  
    
      var path=$("#file").val();
      if(path.EndWith(".zip")||path.EndWith(".doc")||path.EndWith(".xls")||path.EndWith(".ppt")){
        $("#loading")  
        .ajaxStart(function(){  
            $(this).show();  
        })//开始上传文件时显示一个图片  
        .ajaxComplete(function(){  
            $(this).hide();  
           
        });//文件上传完成将图片隐藏起来
    
    
        var filename=$('#file').attr('value');
        filename=filename.substring(0,filename.indexOf('.'));
        filename=filename.replace("\\","a");    
        filename=filename.replace("\\",",");
        filename=filename.substring(filename.indexOf(',')+1,filename.lentht);
    $.ajaxFileUpload({  
                url:'<%=basePath%>action/fileupload.do?ajaxfilename='+escape(escape(filename)),//用于文件上传的服务器端请求地址  
                secureuri:false,//一般设置为false  
                fileElementId:'file',//文件上传空间的id属性  <</span>input type="file" id="file" name="file" />  
                dataType: 'json',//返回值类型 一般设置为json  
                success: function (data, status)  //服务器成功响应处理函数  
                {  
                    $('#ljwz').attr("value",data[1]);
                    $('#filesize').attr("value",data[2]);
                  
                    $('#flag').html('<a href="javascript:download();">'+data[1]+'</a>');
                },  
                error: function (data, status, e)//服务器响应失败处理函数  
                {  
                   alert('文件格式不支持！');
                }  
            })  
        return false;  
    }else{
        alert("请上传格式为doc,xls,ppt等文档类文件，其他格式文件请压缩为zip类型压缩包上传！");
    }
 }  
    
    
    </script>

	</head>

	<body class="mainbody">
		<form name="articleForm" method="post"
			action="<%=basePath%>admin/article/ArticleServlet?act=addload"
			id="form1">

			<div class="navigation">
				<a href="javascript:back();" class="back">后退</a>首页 &gt; 下载管理 &gt;
				添加信息
			</div>
			<div id="contentTab">
				<ul class="tab_nav">
					<li class="selected">
						<a onclick="tabs('#contentTab',0);" href="javascript:;">基本信息</a>
					</li>

				</ul>

				<div class="tab_con" style="display: block;">
					<input type="hidden" name="pid" value="${pid}" />
					<table class="form_table">
						<col width="150px"></col>
						<tbody>
							<tr>
								<th>
									标题名称：
								</th>
								<td>
									<input name="bt" type="text" maxlength="100" id="bt"
										class="txtInput normal required" />
									<span style="color: red;">*</span>
								</td>
							</tr>

							<script language="javascript" type="text/javascript"
								src="../My97DatePicker/WdatePicker.js">
</script>
							<tr>
								<th>
									发布日期：
								</th>
								<td>
									<input class="Wdate" type="text" onClick="WdatePicker()"
										id="rq" name="rq" />
									<span style="color: red;">*</span>
								</td>
							</tr>
							<tr>
								<th>
									文件说明：
								</th>
								<td>
									<textarea name="nr" rows="2" cols="20" id="nr" class="small"></textarea>
								</td>
							</tr>
							<tr>
								<th valign="top" style="padding-top: 10px;">
									附件上传：
								</th>
								<td>

									<input name="ljwz" type="hidden" id="ljwz" />
									<input name="fbt" type="hidden" id="filesize" />
									<input type="file" id="file" name="file" />
									<img src="../images/loading.gif" id="loading"
										style="display: none;" />
									<div class="upload_btn" onclick="ajaxFileUpload()">
										<span id="upload">上传&nbsp;</span>
									</div>
									<span id="flag"></span><span style="color: red">&nbsp;*请上传doc,xls,ppt等文档类文件，其他格式文件请压缩为zip类型压缩包上传</span>
								</td>
							</tr>


						</tbody>
					</table>
				</div>


				<div class="foot_btn_box">

					<c:if test="${fn:contains(sessionScope.qx,'shfb')}">
						<input type="button" onclick="saveandrelease()" name="btnSubmit"
							value="保存并发布" id="sd" class="btnSubmit" />
					</c:if>
					&nbsp;
					<input type="button" onclick="saveandcontinue()" name="btnSubmit"
						value="保存并继续" id="sd" class="btnSubmit" />
					&nbsp;
					<input type="button" onclick="save()" name="btnSubmit"
						value="保存并返回" id="sd" class="btnSubmit" />
					&nbsp;
					<input name="sdfe" onclick="javascript:back();" type="button"
						class="btnSubmit" value="返回" />
				</div>

			</div>
		</form>
	</body>
</html>