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
  li{
      font-size:14px;
      margin:4px;
      margin-top:15px;
      
      padding:3px;
      height:10px;
      display:block;
   }
   li a{
      cursor:pointer;
      float:left;
      display:block;
      margin-left:20px;
   }
   li span{
      float:right;
      display:block;
      margin-right:30px;
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

   function getMainData(id){
   
       $.post('subcolumn.htm?loc=getmaindata&id='+id,function(data){         
          if(data[0]=='SUCCESS'){
             $('#main').html(data[1]);
          }
       },'json');
   }

</script>
</head>

<body>
	<div style="width:1020px;background-image:url(images/line_bg.png); margin:auto;">
	<div style=" text-align:center;"><iframe src="top.html" style="width:1000px;height:230px;" frameborder="0" scrolling="no"></iframe></div>
    <div class="mainbody" align="center">
    	<div class="infolist_left" >
       	  <div class="infolist_left_top" style="background-image:url(images/info_jggk.jpg);width:202px"></div>
       	  <c:forEach items="${itemList}" var="item" >
          <div class="infolist_left_link"><a href="javascript:getMainData(${item.id })" target="_self" class="info_a">${item.lmmc }</a></div>
          </c:forEach>
        </div>
        <div class="infolist_right">
	       	<div class="address"><span>当前位置：<a href="#" target="_self">网站首页</a> > 机构概况</span></div>
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