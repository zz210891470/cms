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
<title>数据备份列表</title>
<link rel="stylesheet" type="text/css" href="../images/style.css"/>
<script type="text/javascript">var basePath = '<%=basePath%>';</script>
<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script>  
<script type="text/javascript" src="../js/function.js"></script>
</head>

<body class="mainbody">

<div class="navigation">首页 &gt; 系统设置管理 &gt; 系统数据备份 </div>
<form name="pageform"  method="post">
    <div class="tools_box">
	    <div class="tools_bar">
		    <a href="javascript:void(0);" onclick="backup();" class="tools_btn"><span><b class="all">一键备份</b></span></a>
		    <div align="center" id="loadDiv" style="display:none;">
	    	<span><img src="../images/loading.gif"/><br/>
	    	数据备份中，请稍后.....</span>
	    </div>
        </div>
    </div>
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="msgtable">
      <tr>
        <th width="15%" align="left">用户名</th>
        <th width="15%" align="left">备份时间</th>
        <th width="18%" align="left">文件名</th>
      </tr>
     <c:forEach items="${pager.resultList}" var="item">
     <tr>
        <td>${item.userName}</td>
        <td>${item.createTime}</td>
        <td>${item.fileName}</td>
      </tr>
     </c:forEach> 
	 </table>
 </form>
	  <div class="line15"></div>
	  <div class="page_box">
      <div id="PageContent" class="flickr right">
	  <c:choose>
	   <c:when test="${pager.pageNo==1}">
   		   <span class="disabled">首页</span> 
		   <span class="disabled">上一页</span> 
	   </c:when> 
	   <c:otherwise> 
		  <a href="javascript:gopage(${pager.firstPageNo})">首页</a>
	      <a href="javascript:gopage(${pager.prePageNo})">上一页</a> 
	   </c:otherwise>
	  </c:choose>
      
      <span class="current">${pager.pageNo}页/${pager.pageCount}页</span>
      <c:choose>
	   <c:when test="${pager.pageNo==pager.pageCount||page.pageCount==0}">
   		   <span class="disabled">下一页</span> 
		   <span class="disabled">尾页</span> 
	   </c:when> 
	   <c:otherwise> 
           <a href="javascript:gopage(${pager.nextPageNo})">下一页</a>
           <a href="javascript:gopage(${pager.lastPageNo})">尾页</a>
	   </c:otherwise>
	  </c:choose>

      </div>
      <script type="text/javascript">
      function gopage(i){
	    var pagesize=$('#txtPageNum').val();      
      	document.location.href='<%=basePath%>admin/setting/SysDataServlet?act=list&pageNo='+i+'&pageSize='+pagesize;
		return false;
      }
      
      
     $(function(){
     
        $('#btnDelete').click(function(){
        
            var pagesize=$('#txtPageNum').val();
		    document.all.pageform.action='<%=basePath%>admin/setting/SysLogServlet?act=deleteItems&pageNo=1&pageSize='+pagesize;     
			document.all.pageform.submit();   
        });
        
	    $('#txtPageNum').keypress(function (e) {
	    var keycode;
		if (navigator.appName == "Microsoft Internet Explorer") {  // IE
			key = e.keyCode;
		} else {             // Netscape/Firefox/Opera
			key = e.which;
		}

	    if (key == 13) {
	       var pagesize=$('#txtPageNum').val();      
      	   document.location.href='<%=basePath%>admin/setting/SysLogServlet?act=list&pageNo=1&pageSize='+pagesize;
		   return false;
	    }
	    });

	 }); 
      </script>
      <div class="left">
         显示<input  id="txtPageNum" name="txtPageNum" type="text" value="${pager.pageSize}" onchange=""  class="txtInput2 small2" />条/页
      </div>
    </div>
	  <div class="line10"></div>
</body>
</html>