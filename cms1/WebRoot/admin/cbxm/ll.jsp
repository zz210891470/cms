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
		
	   function shtg(i){
	       if(confirm("审核通过说明项目填写正确，确认通过！")){
	            document.all.form.action='<%=basePath%>admin/cbxm/CbxmServlet?action=shtg&id='+i; 
	            document.all.form.submit(); 
	       }
	   }
	 
	   function thsq(i){
	   	   if(confirm("项目退回说明项目信息错误，退回修改！")){
	       	    document.all.form.action='<%=basePath%>admin/cbxm/CbxmServlet?action=thsq&id='+i; 
	            document.all.form.submit(); 
	       
	       }
	   }
	   
	   function back(){
           window.parent.hideFrame();
       }
	</script>
  </head>
  <body class="mainbody">
	<form name="form" method="post" action="<%=basePath%>admin/zdxm/ZdxmServlet?action=add" id="form">
    	<div class="navigation"><a href="javascript:back();"  class="back">返回</a>首页 &gt; 重点项目管理 &gt; 项目信息详情</div>
    	<div class="tab_con" style="display:block;">
    		<table class="form_table">
				<col width="150px"></col>
				<tbody>
				<tr>
					<th>项目年度：</th>
					<td colspan="5">${item.nd }</td>
				</tr>
				<tr>
					<th>项目名称：</th>
					<td colspan="5">${item.mc }</td>
				</tr>
				<tr>
					<th>地区：</th>
					<td colspan="2">
						${item.dq}
					</td>
					<th>建设地点：</th>
					<td colspan="2">${item.jsdd }</td>
				</tr>
				<tr>
					<th>项目类别：</th>
					<td colspan="2">						
					    ${item.lb1}<br />
					    ${item.lb2}
					</td>
					<th>报告书类别：</th>
					<td colspan="2">
						${item.bgs}
					</td>
				</tr>
				
				<tr>
					<th>申报单位：</th>
					<td colspan="5">${item.sbdw }</td>
				</tr>
				<tr>
					<th>联系人：</th>
					<td>${item.lxr }</td>
					<th>联系电话：</th>
					<td>${item.lxdh }</td>
					<th>电子邮箱：</th>
					<td>${item.dzyx }</td>
				</tr>
				<tr>
					<th>策划单位：</th>
					<td colspan="3">${item.chdw }</td>
					<th>资质等级：</th>
					<td>${item.zzdj }</td>
				</tr>
				<tr>
					<th>联系人：</th>
					<td>${item.lxr1 }</td>
					<th>联系电话：</th>
					<td>${item.lxdh1 }</td>
					<th>电子邮箱：</th>
					<td>${item.dzyx1 }</td>
				</tr>
				<tr>
					<th>承办单位：</th>
					<td colspan="5">${item.cbdw }</td>
				</tr>
				<tr>
					<th>联系人：</th>
					<td>${item.lxr2 }</td>
					<th>联系电话：</th>
					<td>${item.lxdh2 }</td>
					<th>电子邮箱：</th>
					<td>${item.dzyx2 }</td>
				</tr>
				<tr>
					<th>合作方式：</th>
					<td colspan="5">
						${item.hzfs}
					</td>
				</tr>
				<tr>
					<th>项目提出的理由与过程：</th>
					<td colspan="5">${item.lygc }</td>
				</tr>
				<tr>
					<th>项目总投资（万元）：</th>
					<td colspan="5">${item.ztz }</td>
				</tr>
				<tr>
					<th>建设规模及内容：</th>
					<td colspan="5">${item.jsgm }</td>
				</tr>
				<tr>
					<th>项目主要建设条件：</th>
					<td colspan="5">${item.jstj }</td>
				</tr>
				<tr>
					<th>项目经济效益分析：</th>
					<td colspan="5">${item.xyfx }</td>
				</tr>
				<tr>
					<th>主要技术经济指标：</th>
					<td colspan="5">${item.jsjjzb }</td>
				</tr>
				<tr>
					<th>项目前期推进状况：</th>
					<td colspan="5">${item.tjzk }</td>
				</tr>
				<tr>
					<th>报送时间：</th>
					<td>${item.bssj }</td>
				</tr>
				<tr>
					<th> 审核意见：</th>
					<td><textarea name="shyj"  rows="8" cols="30" id="webdescription" class="small" style="width:80%;">${item.shyj }</textarea></td>
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
