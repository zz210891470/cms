<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=18030" />
<title>龙岩市重点项目开发建设管理办公室</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body{ background:url("body_bg.jpg") repeat-x scroll center top #E8E8E8;font-family:"宋体";color:#000000;}
#div_bt{font-size:18px;width:900px; font-weight:600;line-height:50px; text-align:center;}
#div_sx{font-size:12px;width:900px; color:#666;line-height:25px; text-align:center; border-bottom:solid 1px #aaa;}
#div_nr{text-align:left;width:900px; margin-top:20px;}
</style>
<script type="text/javascript" src="js/js.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>

</head>

<body>
	<div style="width:1020px;background-image:url(line_bg.png); margin:auto;">
	<div style=" text-align:center;"><iframe src="<%=basePath%>top.html" style="width:1000px;height:230px;" frameborder="0" scrolling="no"></iframe></div>
    <div class="mainbody" align="center" style="width:980px;min-height:500px;_height:500px;">
        <div id="main">
            <div id="div_bt">${item.bt }</div>
            <div id="div_sx">来源：${item.ly }&nbsp;日期：${item.sj }</div>
            <div id="div_nr">${item.nr }</div>
        </div>
    </div>
	<div style=" text-align:center;">
	    <iframe src="<%=basePath%>footer.html" style="width:1000px;height:90px;margin-top:10px;" frameborder="0" scrolling="no"></iframe>
	</div>    
</div>
</body>
</html>
