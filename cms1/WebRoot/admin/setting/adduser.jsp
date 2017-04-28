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
	<title>添加用户</title>
	<script>
	function checkform(){
	if(document.getElementById("username").value==""){
		alert("用户名不能为空！");
		document.getElementById("username").focus();
		return false;
		}
	if(document.getElementById("password").value==""){
		alert("密码不能为空！");
		document.getElementById("password").focus();
		return false;
		}
	if(document.getElementById("truename").value==""){
		alert("姓名不能为空！");
		document.getElementById("truename").focus();
		return false;
		}
	return true;
	}
	</script>
</head>

<body class="mainbody">
<form name="form1" method="post" action="SysUserServlet?act=add" id="form1">
	<div class="navigation"><a href="javascript:window.top.home.history.go(-1);" class="back">后退</a>首页 &gt; 系统设置管理 &gt; 系统帐号管理 &gt; 添加用户</div>
    
    <div class="tab_con" style="display:block;">
		<table class="form_table">
			<col width="120px"></col>
				<tbody>
				<tr>
					<th>用户名：</th>
					<td><input name="username" id="username" type="text" value="" maxlength="100"  class="txtInput normal required" /><font color="red"> *</font> </td>
				</tr>
				<tr>
					<th>密码：</th>
					<td><input name="password" id="password" type="text" value="" maxlength="100"  class="txtInput normal required" /><font color="red"> *</font></td>
				</tr>
				<tr>
					<th>姓名：</th>
					<td><input name="truename" id="truename" type="text" value="" maxlength="250" class="txtInput normal required url" /><font color="red"> *</font></td>
				</tr>
				<tr>
					<th>用户状态：</th>
					<td>
						<label style="margin:0px;padding:0px;"><input type="radio" name="state" id="state1" value="1" checked />启用</label>
						<label style="margin:0px;padding:0px;"><input type="radio" name="state" id="state2" value="0" />禁用</label>
					</td>
				</tr>
				<tr>
					<th>栏目内容权限：</th>
					<td>
						<c:forEach items="${lmqx}" var="lmqx" >
							<label style="margin:0px;padding:0px;"><input type="checkbox" name="qx" value="lm${lmqx.id }" /><b>${lmqx.lmmc }</b></label>
							<c:forEach items="${lmqx1}" var="lmqx1" ><c:if test="${lmqx.id==lmqx1.sjid}"><label style="margin:0px;padding:0px;"><input type="checkbox" name="qx" value="lm${lmqx1.id }" />${lmqx1.lmmc }</label></c:if></c:forEach>
							<br/>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th>专题内容权限：</th>
					<td>
						<c:forEach items="${ztqx}" var="ztqx" ><label style="margin:0px;padding:0px;"><input type="checkbox" name="qx" value="zt${ztqx.id }" /><b>${ztqx.lmmc }</b></label>
							<c:forEach items="${ztqx1}" var="ztqx1" ><c:if test="${ztqx.id==ztqx1.ztid}"><label style="margin:0px;padding:0px;"><input type="checkbox" name="qx" value="zt${ztqx1.id }" />${ztqx1.lmmc }</label></c:if></c:forEach>
							<br/>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th>审核发布权限：</th>
					<td><label style="margin:0px;padding:0px;"><input type="checkbox" name="qx" value="shfb" />审核发布</label></td>
				</tr>
				<tr>
					<th>其它权限：</th>
					<td>
						<label style="margin:0px;padding:0px;"><input type="checkbox" name="qx" id="qx3" value="@zf" />政府信息公开专栏管理</label>
						<label style="margin:0px;padding:0px;"><input type="checkbox" name="qx" id="qx4" value="@gz" />公众参与管理</label>
						<label style="margin:0px;padding:0px;"><input type="checkbox" name="qx" id="qx5" value="@fz" />辅助功能管理</label>
						<label style="margin:0px;padding:0px;"><input type="checkbox" name="qx" id="qx6" value="@zt" />系统设置管理</label>
					</td>
				</tr>
				<tr>
					<th>项目管理权限：</th>
					<td>
						<label style="margin:0px;padding:0px;"><input type="checkbox" name="qx" id="qx3" value="@cbxm" />储备项目管理</label>
						<label style="margin:0px;padding:0px;"><input type="checkbox" name="qx" id="qx4" value="@zsxm" />招商项目管理</label>
						<label style="margin:0px;padding:0px;"><input type="checkbox" name="qx" id="qx5" value="@zdxm" />重点项目管理</label>
						<label style="margin:0px;padding:0px;"><input type="checkbox" name="qx" id="qx6" value="@zdaxm" />重大项目管理</label>
					</td>
				</tr>
				<tr>
					<th>联系电话：</th>
					<td><input name="phone"  type="text" value="" maxlength="50" id="webtel" class="txtInput normal" /></td>
				</tr>
				<tr>
					<th>邮箱：</th>
					<td><input name="mail" type="text" value="" maxlength="100" id="webmail" class="txtInput normal email" /></td>
				</tr>
				</tbody>
			</table>
		</div>
   		<div class="foot_btn_box">
			<input type="submit" name="btnSubmit" value="提交保存" id="btnSubmit" class="btnSubmit" />
			&nbsp;<input type="button" class="btnSubmit" value="返 回" onclick="javascript:window.top.home.history.go(-1);" />
		</div>
</form> 
</body>
</html>
