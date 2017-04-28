<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>${column.lmmc }内容列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  <h5>${column.lmmc }内容列表</h5>
  <ul>
         <c:forEach items="${itemlist}" var="item">  
         <li><a href="<%=basePath%>Article?url=${item.ljwz }">${item.bt }</a>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;时间：${item.sj }  </li>        
         </c:forEach>
  </ul>
  </body>
</html>
