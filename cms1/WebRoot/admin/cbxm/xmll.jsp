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
	<style type="text/css">
	.table{width:100%; font-family:Verdana, Geneva, sans-serif; }
	
	</style>
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
	<form name="form" method="post" action="" id="form">
    	<div class="navigation"><a href="javascript:back();"  class="back">返回</a>首页 &gt; 储备项目管理 &gt; 项目信息详情</div>
    	<div class="tab_con" style="display:block;">
    		<table class="form_table">
    			<h3 align="center"> ${item.mc }简介</h3>
				<col width="200px"></col>
				<tbody>
				<!-- 
				<tr>
					<th>项目年度：</th>
					<td>${item.nd }</td>
				</tr>
				 -->
				 
				<tr>
					<th>行政区域：</th>
					<td>福建省龙岩市</td>
				</tr>
				<tr>
					<th>项目名称：</th>
					<td>${item.mc }</td>
				</tr>
				<tr>
					<th>行业类别：</th>
					<td>${item.lb1 }<br />${item.lb2 }
					</td>
				</tr>
				<tr>
					<th>联系单位：</th>
					<td>${item.sbdw }</td>
				</tr>
				<tr>
					<th>联系方式：</th>
					<td>联系人：${item.lxr }；&nbsp;&nbsp;电话：${item.lxdh }<br/>电子邮箱：${item.dzyx}</td>
				</tr>
				<tr>
					<th>承办单位：</th>
					<td>${item.cbdw }</td>
				</tr>
				<tr>
					<th>联系方式：</th>
					<td>联系人：${item.lxr2 }；&nbsp;&nbsp;电话：${item.lxdh2 }<br/>电子邮箱：${item.dzyx2}</td>
				</tr>
				<tr>
					<th>合作方式：</th>
					<td>${item.hzfs }</td>
				</tr>
				<tr>
					<th>事项名称&nbsp;&nbsp;&nbsp;</th>
					<td align="center"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					内容</b></td>
				</tr>
				<tr>
					<th>项目提出的理由与过程：</th>
					<td>${item.lygc }</td>
				</tr>
				<tr>
					<th>项目概况：</th>
					<td>
						建设地点：${item.dq }&nbsp;${item.jsdd }<br />
						总投资：${item.ztz }万元<br />
						建设规模及内容：${item.jsgm }<br />
						主要建设条件：${item.jstj }<br />
						经济效益情况：${item.xyfx }<br />
						主要技术经济指标：${item.jsjjzb }
					</td>
				</tr>
				<tr>
					<th>项目前期推进状况：</th>
					<td>${item.tjzk }</td>
				</tr>
				</tbody>
			</table>
    	</div>
    	<div class="foot_btn_box">

             <input  type="button" value="返回"  onclick="back()" class="btnSubmit"/>
		</div>
    </form>
  </body>
</html>
