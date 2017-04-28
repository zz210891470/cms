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
					<th>审核意见: </th>
					<td>${item.shyj }</td>
				</tr>
				</tbody>
			</table>
    	</div>
    	<div class="foot_btn_box">
			 
             <input  type="button" value="返回"  onclick="back()" class="btnSubmit"/>
		</div>
   
  </body>
</html>
