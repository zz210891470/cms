<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>admin/images/style.css"/>
	<style type="text/css">
	.table{width:100%; font-family:Verdana, Geneva, sans-serif; }
	</style>
  	<style>
	    body{
	        background-color:#ffffff;
	    }
	</style>
	<script type="text/javascript">

	   function shtg(i){
	       if(confirm("审核通过说明项目填写正确，确认通过！")){
	            document.all.form.action='<%=basePath%>admin/zdaxm/ZdaxmServlet?action=shtg&id='+i; 
	            document.all.form.submit(); 
	       }
	   }
	 
	   function thsq(i){
	   	   if(confirm("项目退回说明项目信息错误，退回修改！")){
	       	    document.all.form.action='<%=basePath%>admin/zdaxm/ZdaxmServlet?action=thsq&id='+i; 
	            document.all.form.submit(); 
	       
	       }
	   }
       function back(){
           window.parent.hideFrame();
       }
    </script>
  </head>
  <body class="mainbody">
	<form name="form" method="post">
    	<div class="navigation"><a href="javascript:back();"  class="back">返回</a>首页 &gt; 重大项目管理 &gt; 项目信息详情</div>
    	<div class="tab_con" style="display:block;">
    		<table class="form_table">
				<col width="150px"></col>
				<tbody>
				<tr>
					<th>项目年度：</th>
					<td>${item.nd }</td>
				</tr>
				<tr>
					<th>项目名称：</th>
					<td>${item.mc }</td>
				</tr>
				<tr>
					<th>地区：</th>
					<td>${item.dq }</td>
				</tr>
				<tr>
					<th>项目类别：</th>
					<td>${item.lb1 }&nbsp;&nbsp;&nbsp;${item.lb2 }
					</td>
				</tr>
				<tr>
					<th>建设地点：</th>
					<td>${item.jsdd }</td>
				</tr>
				<tr>
					<th>建设规模及内容：</th>
					<td>${item.jsgm }</td>
				</tr>
				<tr>
					<th>总投资(万元)：</th>
					<td>${item.ztz }</td>
				</tr>
				<tr>
					<th>建设年限：</th>
					<td>${item.jsnx1}年--${item.jsnx2 }年</td>
				</tr>
				<tr>
					<th>本年计划投资（万元）：</th>
					<td>${item.jhtz}</td>
				</tr>
				<tr>
					<th>进度目标：</th>
					<td>${item.jdmb}</td>
				</tr>
				<tr>
					<th>开工竣工计划：</th>
					<td>开工${item.kgn}年&nbsp;&nbsp;&nbsp;${item.kgy}月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;竣工${item.kgn}年&nbsp;&nbsp;&nbsp;${item.kgy}月</td>
				</tr>
				<tr>
					<th>建设要素需求：</th>
					<td>用地面积${item.yd}亩&nbsp;&nbsp;&nbsp;用林面积${item.ld}亩</td>
				</tr>
				<tr>
					<th>累计已完成投资：</th>
					<td>${item.wctz}</td>
				</tr>
				<tr>
					<th>审核意见</th>
					<td ><textarea name="shyj"  rows="5" cols="50" id="webdescription" class="small">${item.shyj }</textarea></td>
				</tr>
				</tbody>
			</table>
    	</div>
    	<div class="foot_btn_box">
    		 <input  type="button" value="审核通过"  onclick="shtg(${item.id })" class="btnSubmit"/>
    	     <input  type="button" value="退回申请"  onclick="thsq(${item.id })" class="btnSubmit"/>
             <input  type="button" value="返回"  onclick="back()" class="btnSubmit"/>
		</div>
    </form>
  </body>
</html>
