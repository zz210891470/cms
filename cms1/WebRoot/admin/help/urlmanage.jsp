<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<title>友情链接管理</title>
</head>

<body class="mainbody">
<form name="pageform" method="post" action="UrlManageServlet?act=save" id="pageform">
	<div class="navigation">首页 &gt; 辅助功能管理 &gt; 友情链接管理</div>
	
	<div id="contentTab">
		<ul class="tab_nav">
			<li class="selected" id="li1"><a onclick="tabs('#contentTab',0);" href="UrlManageServlet?act=list&lb=1">国家、省各级部门导航链接</a></li>
			<li id="li2"><a onclick="tabs('#contentTab',1);" href="UrlManageServlet?act=list&lb=2">市级各级部门导航链接</a></li>
			<li id="li3"><a onclick="tabs('#contentTab',2);" href="UrlManageServlet?act=list&lb=3">县区各级部门导航链接</a></li>
			<li id="li4"><a onclick="tabs('#contentTab',3);" href="UrlManageServlet?act=list&lb=4">其他导航链接</a></li>
		</ul>
		<div class="tab_con" style="display:block;">
			<input type="hidden" value="${lb}" name="lb" id="lb" />
			<script type="text/javascript">
			
			
			
			if("${lb}"=="1"){
				document.getElementById("li1").className="selected";
			}
			if("${lb}"=="2"){
				document.getElementById("li1").className="";
				document.getElementById("li2").className="selected";
			}
			if("${lb}"=="3"){
				document.getElementById("li1").className="";
				document.getElementById("li3").className="selected";
			}
			if("${lb}"=="4"){
				document.getElementById("li1").className="";
				document.getElementById("li4").className="selected";
			}
			function update(id,mc,url,pxh){
				document.getElementById("id").value=id;
				document.getElementById("mc").value=mc;
				document.getElementById("url").value=url;
				document.getElementById("pxh").value=pxh;
			}
			
			$(function(){
		        $('#btnDelete').click(function(){
		        	if(confirm('确定要删除选中数据？')){
				    	document.all.pageform.action="<%=basePath%>admin/help/UrlManageServlet?act=delete&lb="+document.getElementById("lb").value;     
						document.all.pageform.submit();   
					}
		        });
	        }); 
			</script>
			
			<script type="text/javascript">
			
			function save(){
			    
			    if($("#mc").val()=="" || $("#url").val()=="" || $("#pxh").val()=="" ){
			    
			       alert("名称，网址，排序都不能为空，排序必须为数字！");
			    }else{
			       document.all.pageform.action="<%=basePath%>admin/help/UrlManageServlet?act=save";     
			       document.all.pageform.submit();  
			    }
			
			
			}
			
			</script>
			<div class="tools_box">
			    <div class="tools_bar">
				    <a href="javascript:void(0);" onclick="checkAll(this);" class="tools_btn"><span><b class="all">全选</b></span></a>
		            <a id="btnDelete" class="tools_btn" href="#%20"><span><b class="delete">批量删除</b></span></a>
		        </div>
		    </div>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="msgtable">
		      <tr>
		        <th width="6%">选择</th>
		        <th align="left">名称</th>
		        <th align="left">网址</th>
		        <th width="20%" align="left">排序号</th>
		        <th width="6%">操作</th>
		      </tr>
		     <c:forEach items="${urllist}" var="item">
		     <tr>
		        <td align="center"><span class="checkall">
		        <input type="checkbox" name="itemList" value="${item.id}"/>
		        </span></td>
		        <td>${item.mc }</td>
		        <td>${item.url }</td>
		        <td>${item.pxh }</td>
		        <td align="center"><a href="#%20" onclick="update('${item.id }','${item.mc }','${item.url }','${item.pxh}')" target="_self">修改</a></td>
		      </tr>
		     </c:forEach> 
			 </table>
		</div>
		<div class="foot_btn_box" style="text-align:left;">
		<input type="hidden" value="" name="id" id="id" />
		名称：<input type="text" value="" name="mc" id="mc" />
		网址：<input type="text" value="" name="url" id="url" />
		排序：<input type="text" value="" name="pxh" id="pxh" onkeyup="clearNoNum(this);" />
		<input type="button"  onclick="save()" name="btnSubmit" value="提交保存" id="btnSubmit" class="btnSubmit" />
		&nbsp;<input name="重置" type="reset" class="btnSubmit" value="重 置" />
		</div>
		<div class="line10"></div>
	</div>
</form>
</body>
</html>

