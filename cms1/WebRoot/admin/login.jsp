<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="org.jasig.cas.client.authentication.AttributePrincipal"%>
<%@page import="com.trunko.cms.session.SessionManager"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//CAS单点登录成功后传递的信息
AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();  
String userLoginName = ""; //用户登录名称
if(principal!=null){
	// 设置用户管理中心用户对象和平台的用户对象至session中，跳转至系统首页
	userLoginName = principal.getName();
	SessionManager sessionManager = new SessionManager();
	request.setAttribute("userLoginName", userLoginName);
	request.setAttribute("userType", "sys");
	sessionManager.setSession(request, response);
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>龙岩市重点项目开发建设管理办公室 - CMS内容管理系统</title>
<style type="text/css">
body,td,th {
	font-size: 12px;
}
body {
	padding:0;
	margin:0;
	background-image: url(images/login_bg.jpg);
	background-repeat: repeat;
}
#login_top{
	width:100%;
	height:70px;
	background-image:url(images/login_top_bg.png);
	position: absolute;
	top: 0;
	}
	
#login_depart{
	width:550px;
	height:70px;
	background-image:url(images/login_depart.png);
	margin:0px 10px;
	}
#login_middle{
	width:550px;
	height:300px;
	background-image:url(images/login_bg.png);
	}
#login_footer{
	width:100%;
	height:30px;
	background-image:url(images/login_top_bg.png);
	position:fixed;
	bottom: 0;
	font-size:12px;
	text-align:center;
	color:#FFF;
	font-family:"microsoft yahhei";
	line-height:30px;
	}
</style>

<style type="text/css">
#login_middle1{width:498px; height:100px;padding:4px 10px 10px;background-color:#FFFFFF;border:1px solid #05549d;color:#333333;line-height:24px;text-align:left;-webkit-box-shadow:5px 2px 6px #000;-moz-box-shadow:3px 3px 6px #555;}
</style>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript">
//判断浏览器ie6创建的div的样式和非ie6创建的div的样式
//创建div
function showid(idname){
var isIE = (document.all) ? true : false;
var isIE6 = isIE && ([/MSIE (\d)\.0/i.exec(navigator.userAgent)][0][1] == 6);
var newbox=document.getElementById(idname);
newbox.style.zIndex="9999";
newbox.style.display="block"
newbox.style.position = !isIE6 ? "fixed" : "absolute";
newbox.style.top =newbox.style.left = "50%";
newbox.style.marginTop = - newbox.offsetHeight / 2 + "px";
newbox.style.marginLeft = - newbox.offsetWidth / 2 + "px";  
var layer=document.createElement("div");
layer.id="layer";
layer.style.width=layer.style.height="100%";
layer.style.position= !isIE6 ? "fixed" : "absolute";
layer.style.top=layer.style.left=0;
//layer.style.backgroundColor="#000";
layer.style.zIndex="9998";
layer.style.opacity="0.6";
document.body.appendChild(layer);
var sel=document.getElementsByTagName("select");
for(var i=0;i<sel.length;i++){        
sel[i].style.visibility="hidden";
}
function layer_iestyle(){      
layer.style.width=Math.max(document.documentElement.scrollWidth, document.documentElement.clientWidth)
+ "px";
layer.style.height= Math.max(document.documentElement.scrollHeight, document.documentElement.clientHeight) +
"px";
}
function newbox_iestyle(){      
newbox.style.marginTop = document.documentElement.scrollTop - newbox.offsetHeight / 2 + "px";
newbox.style.marginLeft = document.documentElement.scrollLeft - newbox.offsetWidth / 2 + "px";
}
if(isIE){layer.style.filter ="alpha(opacity=60)";}
if(isIE6){  
layer_iestyle()
newbox_iestyle();
window.attachEvent("onscroll",function(){                              
newbox_iestyle();
})
window.attachEvent("onresize",layer_iestyle)          
}  
//layer.onclick=function(){
//	newbox.style.display="none";layer.style.display="none";for(var i=0;i<sel.length;i++){sel[i].style.visibility="visible";
//	}}
}
function LoadCode(i){
	if(i==0){
		if(document.getElementById("createCheckCode").style.display=="none"){
			document.getElementById("createCheckCode").style.display="";
			document.getElementById("createCheckCode").src="PictureCheckCode?nocache="+new Date().getTime();
		}
	}else{
		document.getElementById("createCheckCode").src="PictureCheckCode?nocache="+new Date().getTime();
	}
 }

function checkform(){
	var yhm1=document.getElementById("yhm").value;
	var mm1=document.getElementById("mm").value;
	var yzm1=document.getElementById("yzm").value;
	var yhlx1="sys";
	if(yhm1==""||yhm1==null){
		alert("请输入用户名");
		$("#yhm").focus();
	}else if(mm1==""||mm1==null)
	{
	alert("请输入密码!");
	$("#mm").focus();
	}else if(yzm1==""||yzm1==null){
	alert("请输入验证码!");
	$("#yzm").focus();
	}
	else{
        yhm1 = escape(yhm1);
		$.post('LoginServlet',{yhm:yhm1,mm:mm1,yzm:yzm1,yhlx:yhlx1},function(data){  
          if(data[0]=='SUCCESS'){
             if(data[1]=="yzmErr"){
             	alert("验证码错误，请重新输入！\n\n");
             }else if(data[1]=="yhmErr"){
             	alert("用户名或密码错误，请重新输入！");
             }else if(data[1]=="ok"){
             	location.href="AjaxServlet?act=index&lb=sys";
             }
          }
       },'json');
	}
	return false;
}
</script>
</head>

<body onload="showid('login_middle');">
<form action="#" method="post" onsubmit="return checkform();">
<div style="width: 100%;height: 100%;position: relative;">
    <div id="login_top">
        <div id="login_depart"></div>
    </div>
    <div id="login_middle">
    	<div style="margin:140px 0 0 355px; width:150px; height:24px; text-align:left;">
        	<div style="height:100%"><input type="text" name="yhm" id="yhm" style="background:transparent;border:none; height:24px; line-height:24px;" value="" /></div>
        </div>
        <div style="margin:9px 0 0 355px; width:150px; height:24px;text-align:left;">
        	<div style="height:100%"><input type="password" name="mm" id="mm" style="background:transparent;border:none; height:24px; line-height:24px;" value="" /></div>
        </div>
        <div style="margin:9px 0 0 355px; width:170px; height:24px;text-align:left;">
        	<div style="width:80px;float:left;"><input type="text" name="yzm" id="yzm" style="background:transparent;border:none; width:70px; height:24px; line-height:24px;" value="" title="验证码区分大小写" onmouseup="LoadCode(0);" onfocus="LoadCode(0);" /></div>
            <div style="width:60px;float:left;"><img src="" id="createCheckCode" style="border:#dddddd solid 1px;cursor:pointer; display:none;" onClick="LoadCode(1)" title="看不清楚？点击图片换一个"></div>
        </div>
        <div style="margin:12px 0 0 320px;text-align:left;">
        	<input name="" type="image" src="images/login_sub.jpg" title="登录" />
        </div>
    </div>
    <div id="login_footer">
		版权所有：龙岩市重点项目开发建设管理办公室&nbsp;&nbsp;
    	技术支持：龙岩市创高科技有限公司&nbsp;&nbsp;
       	服务热线：0597-2335106
    </div>
</div>
</form>
</body>
</html>