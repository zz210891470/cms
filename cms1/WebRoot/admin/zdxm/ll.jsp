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
	            document.all.form.action='<%=basePath%>admin/zdxm/ZdxmServlet?action=shtg&id='+i; 
	            document.all.form.submit(); 
	       }
	   }
	 
	   function thsq(i){
	   	   if(confirm("项目退回说明项目信息错误，退回修改！")){
	       	    document.all.form.action='<%=basePath%>admin/zdxm/ZdxmServlet?action=thsq&id='+i; 
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
    	<div class="navigation"><a href="javascript:back();"  class="back">返回</a>首页 &gt; 重点项目管理 &gt; 项目信息详情</div>
    	<div class="tab_con" style="display:block;">
    		<table width="100%" border="1" cellpadding="0" cellspacing="0" style="border:solid 1px #EDECFF;" >
				  <tr>
				    <td height="35" align="center">项目类别</td>
				    <td colspan="4" bgcolor="#FFFFFF">
			        &nbsp;&nbsp;${item.lb }
				    </td>
				  </tr>
				  
				  <tr>
				    <td height="35" align="center">项目年度</td>
				    <td colspan="2" bgcolor="#FFFFFF">&nbsp;&nbsp;${item.nd}</td>
				    <td height="35" align="center">项目编号</td>
				    <td colspan="2"  width="350px;" bgcolor="#FFFFFF">&nbsp;&nbsp;${item.bh}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="widtd:120px;">项目名称</td>
				    <td colspan="4">&nbsp;&nbsp;${item.mc}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="widtd:120px;">所属地域</td>
				    <td colspan="2">&nbsp;&nbsp;${item.dq}</td>
				    <td align="center" widtd="80">开工日期</td>
				        <td width="130">&nbsp;&nbsp;${item.kgn} 年 ${item.kgy} 月</td>
				  </tr>
				<tr>
					<td height="35" align="center" style="width:120px;">所属行业</td>
					<td colspan="4">&nbsp;&nbsp;${item.lb1} - ${item.lb2}
					</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">建设地点</td>
				    <td colspan="4">&nbsp;&nbsp;龙岩市  ${item.dq} ${item.jsdd}
				    </td>
				  </tr>
				  <tr>
				    <td height="100" align="center" style="width:120px;">建设内容及规模</td>
				    <td colspan="4" valign="top" style=" padding:10px;">${item.jsgm}
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">项目审批、核准、<br>备案文号</td>
				    <td colspan="2">&nbsp;&nbsp;${item.bawh}</td>
				    <td align="center" width="80">建设年限</td>
				    <td width="130">&nbsp;&nbsp;${item.jsnx1} 年 - ${item.jsnx2} 年
				    </td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">总投资(万元)</td>
				    <td colspan="4">&nbsp;&nbsp;${item.ztz}</td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">至去年底预计<br>进展情况</td>
				    <td height="35" align="center" style="width:110px;"><div style="width:110px;">至去年底累计<br>完成投资(万元)</div></td>
				    <td height="28" colspan="3" style="width:470px;">&nbsp;&nbsp;${item.wctz}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">工作或工程<br>进展情况</td>
				    <td height="28" colspan="3" style="padding:10px;">&nbsp;&nbsp;${item.jzqk} </td>
				  </tr>
				  <tr>
				    <td rowspan="3" align="center" style="width:120px;">今年工作目标</td>
				    <td height="35" align="center" style="width:110px;">计划投资(万元)</td>
				    <td height="28" colspan="3">&nbsp;&nbsp;${item.jhtz}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">其中(万元)</td>
				    <td height="28" colspan="3">
				    <table border="0" cellspacing="0" cellpadding="0" style="display:;">
				      <tr>
				        <td height="25" align="center" bgcolor="White" style="width:39px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">1月</td>
				        <td align="center" bgcolor="White" style="width:50px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">2月</td>
				        <td align="center" bgcolor="White" style="width:50px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">3月</td>
				        <td align="center" bgcolor="White" style="width:50px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">4月</td>
				        <td align="center" bgcolor="White" style="width:50px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">5月</td>
				        <td align="center" bgcolor="White" style="width:50px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">6月</td>
				        <td align="center" bgcolor="White" style="width:50px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">7月</td>
				        <td align="center" bgcolor="White" style="width:50px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">8月</td>
				        <td align="center" bgcolor="White" style="width:50px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">9月</td>
				        <td align="center" bgcolor="White" style="width:50px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">10月</td>
				        <td align="center" bgcolor="White" style="width:50px;border-right:solid 1px #d5d5d5; border-bottom:solid 1px #d5d5d5;">11月</td>
				        <td align="center" bgcolor="White" style="width:50px;border-bottom:solid 1px #d5d5d5;">12月</td>
				      </tr>
				      <tr>
				        <td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">${item.tz1}</td>
				        <td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">${item.tz2}</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">${item.tz3}</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">${item.tz4}</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">${item.tz5}</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">${item.tz6}</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">${item.tz7}</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">${item.tz8}</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">${item.tz9}</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">${item.tz10}</td>
						<td height="25" align="center" bgcolor="White" style="border-right:solid 1px #d5d5d5;">${item.tz11}</td>
				        <td align="center" bgcolor="White">${item.tz12}</td>
				      </tr>
				    </table></td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">工程进度</td>
				    <td height="28" colspan="3" style="padding:10px;">${item.gcjd}</td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">项目业主(建设、<br />筹建、代建单位)</td>
				    <td height="35" align="center" style="width:110px;">单位名称</td>
				    <td height="28" colspan="3">&nbsp;&nbsp;${item.dwmc}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:110px;">责任人及<br> 联系电话</td>
				    <td height="28" colspan="3">&nbsp;&nbsp;${item.zrr}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">分级管理单位<br>及领导</td>
				    <td colspan="4">&nbsp;&nbsp;${item.gldw}</td>
				  </tr>
				  <tr>
				    <td rowspan="3" align="center" style="width:120px;">资金拼盘</td>
				    <td height="35" align="center">业主自筹(万元)</td>
				    <td height="35" colspan="3">&nbsp;&nbsp;${item.zjppzc}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center">银行贷款(万元)</td>
				    <td height="35" colspan="3">&nbsp;&nbsp;${item.zjppdk}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center">政府投资(万元)</td>
				    <td height="35" colspan="3">&nbsp;&nbsp;${item.zjppzf}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">投资主体性质</td>
				    <td colspan="4">&nbsp;&nbsp;${item.tzztxz}</td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">今年计划开工、<br>建成或部分建成</td>
				    <td height="35" align="center">开工、建成或<br>部分建成</td>
				    <td height="35" colspan="3">&nbsp;&nbsp;${item.sfkg}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center">月份</td>
				    <td height="35" colspan="3">&nbsp;&nbsp;${item.kgyf}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">项目建成达产后<br>年新增效益</td>
				    <td colspan="4">&nbsp;&nbsp;产值&nbsp;${item.cz}(万元)&nbsp;税收&nbsp;${item.ss}(万元)&nbsp;提供就业岗位&nbsp;${item.jy}(个)
				</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">项目总占地(亩)</td>
				    <td height="28" colspan="4">&nbsp;&nbsp;${item.zd}</td>
				  </tr>
				  <tr>
				    <td rowspan="2" align="center" style="width:120px;">今年各类要素<br />预计需求量</td>
				    <td height="35" colspan="4">&nbsp;&nbsp;农用地 ${item.nyd}(亩)&nbsp;&nbsp;其中：基本农田${item.nt}(亩)&nbsp;&nbsp; 林地 ${item.ld}(亩)</td>
				  </tr>
				  <tr>
				    <td height="35" colspan="4">&nbsp;&nbsp;施工用油  ${item.sgyy}(吨)&nbsp;&nbsp;火工用品  ${item.hgyp}(吨)&nbsp;&nbsp;银行贷款  ${item.yhdk}(万元)</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">是否生产性项目</td>
				    <td height="28" colspan="4">&nbsp;&nbsp;${item.sfscx}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">是否重中之重项目</td>
				    <td height="28" colspan="4">&nbsp;&nbsp;${item.sfzz}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">是否省属重点项目</td>
				    <td height="28" colspan="4">&nbsp;&nbsp;${item.sfss}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;">是否资源型项目</td>
				    <td height="28" colspan="4">&nbsp;&nbsp;${item.sfzy}</td>
				  </tr>
				  <tr>
				    <td height="35" align="center" style="width:120px;"><div style="width:120px;">产业分类</div></td>
				    <td height="28" colspan="4" style="line-height:30px;">&nbsp;&nbsp;${item.sjslb}</td>
				  </tr>
				  <tr>
					<td height="35" align="center" style="width:120px;"><div style="width:120px;">审核意见</div></td>
					<td colspan='4'><textarea name="shyj"  rows="5" cols="50" id="webdescription" class="small">${item.shyj }</textarea></td>
				</tr>
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
