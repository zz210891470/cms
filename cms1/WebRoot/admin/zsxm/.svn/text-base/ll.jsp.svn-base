<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<link rel="stylesheet" type="text/css" href="../images/style.css"/>
	<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script>  
	<script type="text/javascript" src="../js/function.js"></script>
	
	<style>
	    body{
	        background-color:#ffffff;
	    }
	
	</style>
	
	<script type="text/javascript">

       function back(){
           window.parent.hideFrame();
       }
    
    </script>
  </head>
  <body class="mainbody">
    	<div class="navigation"><a href="javascript:back();"  class="back">返回</a>首页 &gt; 招商项目管理 &gt; 项目信息修改</div>
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
					<th>总投资(万元)：</th>
					<td>${item.ztz }</td>
				</tr>
				<tr>
					<th>建设规模及内容：</th>
					<td>${item.jsgm }</td>
				</tr>
				<tr>
					<th>合作方式：</th>
					<td>${item.hzfs }</td>
				</tr>
				<tr>
					<th>联系单位：</th>
					<td>${item.lxdw }</td>
				</tr>
				<tr>
					<th>联系人：</th>
					<td>${item.lxr}</td>
				</tr>
				<tr>
					<th>联系电话：</th>
					<td>${item.lxdh }</td>
				</tr>
				<tr>
					<th>前期工作进展情况：</th>
					<td>${item.qqgz }</td>
				</tr>
				</tbody>
			</table>
    	</div>
    	<div class="foot_btn_box">
			 
             <input  type="button" value="返回"  onclick="back()" class="btnSubmit"/>
		</div>
   
  </body>
</html>
