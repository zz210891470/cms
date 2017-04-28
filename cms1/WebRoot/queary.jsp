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
   	  width:750px;
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
</style>
<script type="text/javascript" src="js/js.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script src="Scripts/swfobject_modified.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	
   $(function(){
        getMainData('${keyword}');
   });

   function getMainData(keyword){
       $.post('subcolumn.htm?loc=showQueary&keyword='+escape(escape(keyword))+'&pageNo=1',function(data){         
          if(data[0]=='SUCCESS'){
             $('#main').html(data[1]);
          }
       },'json');
   }
 function gopage(pageno,keyword){
      if(pageno!=0){
      var num=$('#pagecount').data('num');
      if(pageno!=num){
	       $.post('subcolumn.htm?loc=showQueary&keyword='+keyword+'&pageNo='+pageno,function(data){         
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
        <div class="infolist_right" style="width:970px;height:500px;">
       	<div class="address"><span>当前位置：<a href="#" target="_self">网站首页</a> > 站内搜索</span></div>
        <div id="main" style="height:400px; margin:30px;">${item }</div>
        </div>

    </div>
	<div style=" text-align:center;">
	    <iframe src="footer.html" style="width:1000px;height:90px;margin-top:10px;" frameborder="0" scrolling="no"></iframe>
	</div>    
</div>
</body>
</html>