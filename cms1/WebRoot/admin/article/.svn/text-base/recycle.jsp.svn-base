<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
<title>栏目管理</title>
<link rel="stylesheet" type="text/css" href="../images/style.css"/>
<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script>  
<script type="text/javascript" src="../js/function.js"></script>
    
    <style>
	    body{
	        background-color:#ffffff;
	    
	    }
	
	</style>
      <script type="text/javascript">
      
                  //       <input type="button" name="btnSearch" value="搜 索" onclick="dosearch();" id="btnSearch" class="btnSearch" />
      function dosearch(){
         $("#pageNo").val("1");
         document.all.pageform.action='<%=basePath%>admin/article/ArticleServlet?act=recyclepage';
         document.all.pageform.submit();
      }
       
              //设置页面
        function setPageSize(){
            var pageSize = $("#pageSizeTemp").val();
            var pid = $("#pid").val();
	        if( pageSize != "" && /^[0-9]*$/.test(pageSize) ){
	            $("#pageSize").val(pageSize);
	      	    document.all.pageform.action='<%=basePath%>admin/article/ArticleServlet?act=recyclepage&pid='+pid;
			    document.all.pageform.submit();
            }else{
		        alert("请输入数字！");
		    }   
        }
       
       function back(){
           window.parent.hideFrameR();
       }

      
      function gopage(i){    
      	document.all.pageform.action='<%=basePath%>admin/article/ArticleServlet?act=recyclepage&pageNo='+i;
		document.all.pageform.submit(); 
      }
      
      
      function goThePage(){
          var pageNo = $("#pageNoTemp").val();
          if( pageNo != "" && /^[0-9]*$/.test(pageNo) ){
			    if( pageNo > 0 && pageNo <= ${pager.pageCount} ) {  
			        $("#pageNo").val($("#pageNoTemp").val());     
		        document.all.pageform.action='<%=basePath%>admin/article/ArticleServlet?act=recyclepage';
			    document.all.pageform.submit(); 
		  }else{
                alert("请输入正确的页码！");
		  }
		}else{
		    alert("请输入数字！");
		}
      }
      
      
      function onDelete(){
           
            var num = 0;
            $("input[name='itemList']").each(function(){   
          
			     if($(this).attr("checked") != false){
	                 num++; 
	             } 
			});
            
             if(num>0){
                 if(confirm("确定要删除选中项?")){

			         document.all.pageform.action='<%=basePath%>admin/article/ArticleServlet?act=RdeleteItems';     
				     document.all.pageform.submit();   
			     }
		     }else{
			     alert("请至少选中一项");
			 }
      }
      
           function resume(){
           
            var num = 0;
            $("input[name='itemList']").each(function(){   
          
			     if($(this).attr("checked") != false){
	                 num++; 
	             } 
			});
            
             if(num>0){
                 if(confirm("确定要恢复选中项?")){

			         document.all.pageform.action='<%=basePath%>admin/article/ArticleServlet?act=resume';     
				     document.all.pageform.submit();   
			     }
		     }else{
			     alert("请至少选中一项");
			 }
      }

      </script>
</head>

<body class="mainbody">
<form name="pageform"  method="post">
   	<div class="navigation">首页 &gt; 文章管理 &gt; 回收站列表</div>
    <div class="tools_box">
	    <div class="tools_bar">
            <div class="search_box">
			    <input name="search" type="text" id="txtKeywords" class="txtInput" value="${search }"/>
                <input type="button" name="btnSearch" value="搜 索" onclick="dosearch();" id="btnSearch" class="btnSearch" />
 
		    </div>

		    <a href="javascript:void(0);" onclick="checkAll(this);" class="tools_btn"><span><b class="all">全选</b></span></a>
            <a href="javascript:onDelete();"  id="btnDelete" class="tools_btn" ><span><b class="delete">批量删除</b></span></a>
            <a href="javascript:resume()" class="tools_btn"><span><b class="add">批量恢复</b></span></a>
            <a href="javascript:back()" class="tools_btn"><span><b class="return">返回</b></span></a>
        </div>
    </div>
   
   
   	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="msgtable">
      <tr>
        <th width="6%">选择</th>
        <th width="40%" align="left">标题</th>
        <th width="10%" align="left">发布人</th>
        <th width="15%" align="left">发布时间</th>
        <th width="16%" align="left">来源</th>
      
      </tr>
    
     <c:forEach items="${pager.resultList}" var="item">
     <tr>
        <td align="center"><span class="checkall">
        <input id="rptList_ctl01_chkId" type="checkbox" name="itemList" value="${item.id}"/>
        </span></td>
       
        <td>${item.bt }</td>
        <td>${item.fbr }</td>

        <td >${item.rq} </td>
        <td align="center">${item.ly }</td>

      </tr>
     </c:forEach>  
    
	  </table>

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
	   <c:when test="${pager.pageNo==pager.pageCount||pager.pageCount==0}">
   		   <span class="disabled">下一页</span> 
		   <span class="disabled">尾页</span> 
	   </c:when> 
	   <c:otherwise> 
	              <a href="javascript:gopage(${pager.nextPageNo})">下一页</a>
           <a href="javascript:gopage(${pager.lastPageNo})">尾页</a>


	   </c:otherwise>
	  </c:choose>
      &nbsp;&nbsp;
               跳转到<input type="text" id="pageNoTemp" name="pageNoTemp" value="${pager.pageNo }" size="3"/>
           <input type="hidden" id="pageNo" name="pageNo" value="${pager.pageNo }" />
           <a href="javascript:goThePage()" >GO</a>
      </div>

      <div class="left">
         显示
     <input  id="pageSizeTemp" name="pageSizeTemp" type="text" value="${pager.pageSize}"  class="txtInput2 small2" />条/页
      	   <input  id="pageSize" name="pageSize" type="hidden" value="${pager.pageSize}"/>
     <a href="javascript:setPageSize()" class="btnSearch">SET</a>
      </div>
	  <input type="hidden" id="pid" name="pid" value="${pid }"/>
    </div>
	  <div class="line10"></div>
</form>

  
  </body>
  
</html>
