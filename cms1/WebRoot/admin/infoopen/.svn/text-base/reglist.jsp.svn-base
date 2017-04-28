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
<title>政府信息公开规定</title>
<link rel="stylesheet" type="text/css" href="../images/style.css"/>
<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script>  
<script type="text/javascript" src="../js/function.js"></script>
</head>

<body class="mainbody">
<div class="navigation">首页 &gt; 政府信息公开专栏  &gt; 政府信息公开规定</div>
    <form name="pageform"  method="post">
    <div class="tools_box">
	    <div class="tools_bar">
	        <a href="javascript:add();" class="tools_btn"><span><b class="add">添加信息</b></span></a>
		    <a href="javascript:void(0);" onclick="checkAll(this);" class="tools_btn"><span><b class="all">全选</b></span></a>
            <a  id="btnDelete" class="tools_btn" href="javascript:__doPostBack('btnDelete','')"><span><b class="delete">批量删除</b></span></a>
        </div>
    </div>
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="msgtable">
      <tr>
        <th style="width:40px;">选择</th>
        <th>标题</th>
        <th style="width:100px;">发布时间</th>
        <th style="width:60px;">操作</th>
      </tr>
     <c:forEach items="${pager.resultList}" var="item">
     <tr>
        <td align="center"><span class="checkall"><input id="id" type="checkbox" name="itemList" value="${item.id}"/></span></td>
        <td style="text-align:left;"><a href="<%=basePath%>admin/infoopen/InfoRegServlet?act=updatepage&id=${item.id}">${item.topic }</a></td>
        <td>${item.time }</td>
        <td><a href="<%=basePath%>admin/infoopen/InfoRegServlet?act=updatepage&id=${item.id}">修改</a></td>

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
	   <c:when test="${pager.pageNo==pager.pageCount}">
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
      function add(){
        document.location.href='<%=basePath%>admin/infoopen/InfoRegServlet?act=addpage';
		return false;   
      }
      function gopage(i){
	    var pagesize=$('#txtPageNum').val();      
      	document.location.href='<%=basePath%>admin/infoopen/InfoRegServlet?act=list&pageNo='+i+'&pageSize='+pagesize;
		return false;
      }
      
     $(function(){
     
        $('#btnDelete').click(function(){
        	if(confirm("确定要删除选中数据？")){
	            var pagesize=$('#txtPageNum').val();
			    document.all.pageform.action='<%=basePath%>admin/infoopen/InfoRegServlet?act=deleteItems&pageNo=1&pageSize='+pagesize;     
				document.all.pageform.submit();   
			}
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
      	   document.location.href='<%=basePath%>admin/infoopen/InfoRegServlet?act=list&pageNo=1&pageSize='+pagesize;
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