<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>'cbArticle'</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="js/js.js">
</script>
		<script type="text/javascript" src="js/index.js">
</script>
		<script src="Scripts/swfobject_modified.js" type="text/javascript">
</script>
		<script type="text/javascript" src="js/jquery.min.js">
</script>

		<script type="text/javascript">
$(function() {

	getMainData();

});

function getMainData() {

	$.post('cbArticle', function(data) {
		if (data[0] == 'SUCCESS') {
			$('#main').html(data[1]);
		}
	}, 'json');
}
function gopage(pageno) {
	if (pageno != 0) {
		var num = $('#pagecount').data('num');
		if (pageno != num) {
			$.post('cbArticle?pageNo=' + pageno, function(data) {
				if (data[0] == 'SUCCESS') {
					$('#main').html(data[1]);
				}
			}, 'json');
		} else {
			alert("这已经是最后一页了");
		}
	} else {
		alert("这已经是第一页了！");
	}
}
</script>
		<style type="text/css">
a:link {
	color: #000000;
	text-decoration: none
}

a:hover {
	color: #0000FF;
	text-decoration: none
}

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
      margin-left:100px;
   }
</style>
	</head>

	<body>
		<div id="main"></div>

	</body>
</html>
