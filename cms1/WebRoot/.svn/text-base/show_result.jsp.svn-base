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
<style type="text/css">
.vote_zt{width:800px;line-height:50px;font-size:20px;color:#336699;font-weight:bold;}
.vote_nr{width:800px;line-height:2;font-size:13px; margin-bottom:30px;text-align:left;}
.vote_item{width:800px;text-align:left;}
.vote_wt{line-height:28px;font-size:13px;font-weight:bold;text-align:left;}
.vote_da{line-height:28px;font-size:13px;text-align:left;}
</style>
<script type="text/javascript" src="js/js.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
   $(function(){
        $("#save").click(function(){
            var idstr="";

            $("input").each(function(){
               if($(this).attr("checked")=='checked'){            
                     idstr+=$(this).attr('value')+"-";                    
               }
            });
            $("#voteitem").attr("value",idstr);
            $("#voteform").submit();
        });
   });
</script>
</head>

<body>
<form  id="voteform" action="Vote?act=savevote" method="post">
	<div style="width:1020px;background-image:url(images/line_bg.png); margin:auto;">
	<div style=" text-align:center;"><iframe src="top.html" style="width:1000px;height:230px;" frameborder="0" scrolling="no"></iframe></div>
    <div class="mainbody" align="center" style="width:980px;min-height:500px;_height:500px;">
        <div id="main"> 
           <div class="vote_zt">${vote.zt }</div>
           <div class="vote_nr">${vote.nr }</div>
           <div class="vote_nr"><font size="5">活动已结束...</font><a href="Vote?act=show&id=${vote.id }" target="_self"/><font color="red">>>查看结果</font></a></div>
           
           
        </div>
    </div>
	<div style=" text-align:center;">
	    <iframe src="footer.html" style="width:1000px;height:90px;margin-top:10px;" frameborder="0" scrolling="no"></iframe>
	</div>    
</div>

</form>
</body>
</html>