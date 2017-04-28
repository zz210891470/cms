<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030" />
<title>龙岩市重点项目开发建设管理办公室</title>
<link href="style.css" rel="stylesheet" type="text/css" />

<style>
   .div_lb{
   	  width:700px;
      background:url(images/bgDotLine.gif) repeat-x bottom;
      height:35px;
      line-height:35px;
      font-size:14px;
   }
   .div_lb a{
      float:left;
   }
   .div_lb span{
      float:right;
   }
   #bottom{
      margin-top:20px;
   }

#div_bt{font-size:18px;width:700px; font-weight:600;line-height:50px; text-align:center;}
#div_nr{text-align:left;width:700px; margin-top:10px;}

</style>
<script type="text/javascript" src="js/js.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script src="Scripts/swfobject_modified.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript">
   $(function(){
        var kk=window.location.hash;
        kk=kk.substring(1,kk.length);
        if(kk!=""){
          getMainData(kk);       
        }
   });

   function getMainData(lb){
       $.post('zfxxgk.htm?loc='+lb,function(data){
          if(data[0]=='SUCCESS'){
             $('#main').html(data[1]);
          }
       },'json');
   }
   
	function gopage(pageno,lb){
      if(pageno!=0){
      var num=$('#pagecount').data('num');
      if(pageno!=num){
	       $.post('zfxxgk.htm?loc='+lb+'&pageNo='+pageno,function(data){         
	          if(data[0]=='SUCCESS'){
	             $('#main').html(data[1]);
	          }
	       },'json');
	       }else{
	       alert("这已经是最后一页了");
	       }
       }else{
          alert("这已经是第一页了！");
       }
   }
</script>
</head>

<body>
	<div style="width:1020px;background-image:url(images/line_bg.png); margin:auto;">
	<div style=" text-align:center;"><iframe src="top.html" style="width:1000px;height:230px;" frameborder="0" scrolling="no"></iframe></div>
    <div class="mainbody" align="center">
    	<div class="infolist_left">
       	  <div class="infolist_left_top" style="background-image:url(images/info_xxgk.jpg);"></div>
          <div class="infolist_left_link1"><a href="javascript:getMainData('gkzn')" target="_self" class="info_a">政府信息公开指南</a></div>
          <div class="infolist_left_link1"><a href="javascript:getMainData('gkml')" target="_self" class="info_a">政府信息公开目录</a></div>
          <div class="infolist_left_link1"><a href="javascript:getMainData('gkgd')" target="_self" class="info_a">政府信息公开规定</a></div>
          <div class="infolist_left_link1"><a href="javascript:getMainData('ysqgk');" target="_self" class="info_a">依申请公开</a></div>
          <div class="infolist_left_link1"><a href="javascript:getMainData('ndbg')" target="_self" class="info_a">政府信息公开年度报告</a></div>
          <div class="infolist_left_link1"><a href="myzj.html" target="_self" class="info_a">政府信息公开意见箱</a></div>
        </div>
        <div class="infolist_right">
       	<div class="address"><span>当前位置：<a href="#" target="_self">网站首页</a> > 政府信息公开专栏</span></div>
        <div id="main" style="padding-top:20px; ">
          ${item }
        </div>
       
        </div>

    </div>
	<div style=" text-align:center;">
	    <iframe src="footer.html" style="width:1000px;height:90px;margin-top:10px;" frameborder="0" scrolling="no"></iframe>
	</div>    
</div>
</body>
</html>