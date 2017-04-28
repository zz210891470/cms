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
	<title>咨询回复</title>
	  	<style>
	    body{
	        background-color:#ffffff;
	    }
	
	</style>
	
	<script type="text/javascript">
       function save(){
           $("#replyform").submit();
       }
       
       function back(){
           window.parent.hideFrame();
       }
    
    </script>
</head>
<body class="mainbody">
<form name="replyform" method="post" action="PeopleMailServlet?act=reply" >
<div class="navigation"><a href="javascript:back();" class="back">后退</a>首页 &gt; 公众参与管理 &gt; 咨询投诉管理</div>
    <div id="contentTab">
    <ul class="tab_nav">
        <li class="selected"><a onclick="tabs('#contentTab',0);" href="javascript:;">咨询投诉信息</a></li>
    </ul>
    
    <div class="tab_con" style="display:block;">
        <table class="form_table">
            <col width="150px"></col>
            <tbody>
            <tr>
                <th>姓名：</th>
                <td>${item.xm }</td>
            </tr>
            <tr>
                <th>联系方式：</th>
                <td>${item.lxfs }</td>
            </tr>
            <tr>
                <th>信件编号：</th>
                <td>${item.id }<input type="hidden" name="id" value="${item.id }"/></td>
            </tr>
            <tr>
                <th>信件标题：</th>
                <td>${item.bt }</td>
            </tr>
            <tr>
                <th height="300">信件内容：</th>
                <td>${item.nr }</td>
            </tr>
            <tr>
                <th height="100">答复内容：</th>
                <td>   <textarea name="hfnr" id="txtContent" cols="100" rows="4" style="width:99%;height:100px;"></textarea>
               </td>
            </tr>
                        <tr>
                <th>批转情况：</th>
                <td></td>
            </tr>
         </tbody>
       </table>
    </div>
        <div class="foot_btn_box">
    <input type="submit" name="btnSubmit" value="提 交" id="btnSubmit" class="btnSubmit" />
    &nbsp;<input  type="reset" class="btnSubmit"  onclick="back()" value="返 回" />
    </div>
    
</div>
</form>
</body>
</html>
