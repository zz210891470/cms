<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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
	<script type="text/javascript" src="<%=basePath%>admin/lib/jquery/jquery-1.3.2.min.js"></script>  
	<script type="text/javascript" src="<%=basePath%>admin/js/function.js"></script>
  	<style>
	    body{
	        background-color:#ffffff;
	    }
	</style>
  </head>
  <body class="mainbody">
	<form name="form" method="post" action="<%=basePath%>admin/zdxm/ZdxmServlet?action=add" id="form">
    	<div class="navigation"><a href="javascript:back();"  class="back">返回</a>首页 &gt; 重点项目管理 &gt; 项目信息详情</div>
    	<div class="tab_con" style="display:block;">
    		<table width="100%" border="1" cellpadding="0" cellspacing="0" style="border:solid 1px #EDECFF;" >
				<tr>
				    <td height="35" align="center">项目编号</td>
				    <td colspan="4" bgcolor="#FFFFFF"></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="widtd:120px;">项目名称</td>
				    <td colspan="2"></td>
				    <td align="center" widtd="80">项目年份</td>
				    <td widtd="130"></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="widtd:120px;">所属地域</td>
				    <td colspan="2">
				    	
				    </td>
				    <td align="center" widtd="80">开工日期</td>
				        <td width="130">
				        	 年 月
				        </td>
				  </tr>
				<tr>
					<td height="35" align="center" style="width:120px;">所属行业</td>
					<td colspan="4">
						 - 
					</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">建设地点</td>
				    <td colspan="4">
				    	龙岩 - 县(市/区) -工业园区或乡镇
				    </td>
				  </tr>
				  <tr>
				    <td height="100" align="center" style="width:120px;">建设内容及规模</td>
				    <td colspan="4" valign="top" style=" padding:10px;">
				    	
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">项目审批、核准、<br>备案文号</td>
				    <td colspan="2"></td>
				    <td align="center" width="80">建设年限</td>
				    <td width="130"> 年 - 年
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">总投资(万元)</td>
				    <td colspan="4"></td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">至2013年底预计<br>进展情况</td>
				    <td height="35" align="center" style="width:110px;"><div style="width:110px;">至2013年底累计<br>完成投资(万元)</div></td>
				    <td height="28" colspan="3" style="width:470px;"></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">工作或工程<br>进展情况</td>
				    <td height="28" colspan="3" style="padding:10px;">
				    	
				    </td>
				  </tr>
				  <tr>
				    <td rowspan="3" align="center" style="width:120px;">2014 年工作目标</td>
				    <td height="35" align="center" style="width:110px;">计划投资(万元)</td>
				    <td height="28" colspan="3"></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">其中(万元)</td>
				    <td height="28" colspan="3">
				    <table border="0" cellspacing="0" cellpadding="0" style="display:;">
				      <tr>
				        <td height="25" align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">1月</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">2月</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">3月</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">4月</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">5月</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">6月</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">7月</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">8月</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">9月</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">10月</td>
				        <td align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">11月</td>
				        <td align="center" bgcolor="White" style="width:39px;border-bottom:solid 1px #d5d5d5;">12月</td>
				      </tr>
				      <tr>
				        <td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							
						</td>
				        <td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							
						</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">
							
						</td>
				        <td align="center" bgcolor="White">
							
						</td>
				      </tr>
				    </table></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">工程进度</td>
				    <td height="28" colspan="3" style="padding:10px;">
				    	
				    </td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">项目业主(建设、<br />筹建、代建单位)</td>
				    <td height="35" align="center" style="width:110px;">单位名称</td>
				    <td height="28" colspan="3"></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">责任人及<br> 联系电话</td>
				    <td height="28" colspan="3"></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">分级管理单位<br>及领导</td>
				    <td colspan="4"></td>
				  </tr>
				  <tr>
				    <td rowspan="3" align="center" style="width:120px;">资金拼盘</td>
				    <td height="35" align="center">业主自筹(万元)</td>
				    <td height="35" colspan="3"></td>
				  </tr>
				  <tr>
				    <td height="35" align="center">银行贷款(万元)</td>
				    <td height="35" colspan="3"></td>
				  </tr>
				  <tr>
				    <td height="35" align="center">政府投资(万元)</td>
				    <td height="35" colspan="3"></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">投资主体性质</td>
				    <td colspan="4">
				    	
				    </td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">2014年计划开工、<br>建成或部分建成</td>
				    <td height="35" align="center">开工、建成或<br>部分建成</td>
				    <td height="35" colspan="3">
				    	
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center">月份</td>
				    <td height="35" colspan="3">
				    	
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">项目建成达产后<br>年新增效益</td>
				    <td colspan="4">&nbsp;&nbsp;
					产值&nbsp;(万元)&nbsp;
					税收&nbsp;(万元)&nbsp;
					提供就业岗位&nbsp;(个)
				</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">项目总占地(亩)</td>
				    <td height="28" colspan="4"></td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">2014年各类要素<br>预计需求量</td>
				    <td height="35" colspan="4">&nbsp;&nbsp; 
				    农用地 (亩)&nbsp;&nbsp;
				    其中：基本农田 (亩)&nbsp;&nbsp;
				    林地： (亩)</td>
				  </tr>
				  <tr>
				    <td height="35" colspan="4">&nbsp;&nbsp;
				        施工用油 (吨)&nbsp;&nbsp;
				        火工用品 (吨)&nbsp;&nbsp;
				        银行贷款 (万元)</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">是否生产性项目</td>
				    <td height="28" colspan="4">
				    	
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">是否重中之重项目</td>
				    <td height="28" colspan="4">
				    	
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">是否省属重点项目</td>
				    <td height="28" colspan="4">
				    	
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">是否资源型项目</td>
				    <td height="28" colspan="4">
				    	
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;"><div style="width:120px;">产业分类</div></td>
				    <td height="28" colspan="4" style="line-height:30px;">
				    	
				    </td>
				  </tr>
			</table>
    	</div>
    	<div class="foot_btn_box">
             <input  type="button" value="返回"  onclick="back()" class="btnSubmit"/>
		</div>
    </form>
  </body>
</html>
