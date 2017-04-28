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
<link rel="stylesheet" type="text/css" href="../images/style.css"/>
<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script>  
<script type="text/javascript" src="../js/function.js"></script>
<title>无标题文档</title>


    <style>
    
    .showDiv{
        display:block;
        z-index:5;
        position:absolute;
        top:0;
        left:0;
        width:100%;
        height:auto;
    }
    
    .hideDiv{
        display:none;
    }
    
    </style>
    <script type="text/javascript">

        function update(i){
            $("#theFrame").attr("src","<%=basePath%>admin/public/PeopleVoteServlet?act=updatepage&id="+i);
            $("#frameDiv").removeClass("hideDiv");
            $("#frameDiv").addClass("showDiv");
        }

        function add(){
            $("#theFrame").attr("src","<%=basePath%>admin/public/PeopleVoteServlet?act=addpage");
            $("#frameDiv").removeClass("hideDiv");
            $("#frameDiv").addClass("showDiv");
        }
        
        //post提交刷新页面 隐藏editFrame
        function hideEditFrame(){
            document.all.pageform.submit();
        }
        
        //get刷新页面 隐藏addFrame
        function hideAddFrame(){
             document.location.href='<%=basePath%>admin/public/PeopleVoteServlet?act=list';
        }
    
        //隐藏子框架
        function hideFrame(){
            $("#frameDiv").removeClass("showDiv");
            $("#frameDiv").addClass("hideDiv");
        }
        
        //删除列表项 单个删除
        function del(i){
            $('#item'+i).attr("checked","true");
            document.all.pageform.action='<%=basePath%>admin/public/PeopleQuestionServlet?act=deleteItems'; 
            document.all.pageform.submit(); 
        }
        
        //批量删除列表项
        function delItems(){
            var num = 0;
            $("input[name='itemList']").each(function(){   
			    if($(this).attr("checked") != false){
	                num++; 
	            } 
			});
            
            if(num>0){
                if(confirm("确定要删除选中项?")){
		            document.all.pageform.action='<%=basePath%>admin/public/PeopleVoteServlet?act=deleteItems'; 
		            document.all.pageform.submit(); 
		        }
		    }else{
			    alert("请至少选中一项");
			}   
        }

        
        //跳转页面
        function goPage(i){
        	$("#pageNo").val(i);
      	    document.all.pageform.action='<%=basePath%>admin/public/PeopleVoteServlet?act=list';
		    document.all.pageform.submit();    
        }
        
        //指定页面跳转
        function goThePage(){
            var pageNo = $("#pageNoTemp").val();
        	if( pageNo != "" && /^[0-9]*$/.test(pageNo) ){
			    if( pageNo > 0 && pageNo <= ${pager.pageCount} ) {  
			        $("#pageNo").val($("#pageNoTemp").val());
		      	    document.all.pageform.action='<%=basePath%>admin/public/PeopleVoteServlet?act=list';
				    document.all.pageform.submit();    		    
				}else{
                    alert("请输入正确的页码！");
			    }
		    }else{
		            alert("请输入数字！");
		    }
        }
        
        //设置页面
        function setPageSize(){
            var pageSize = $("#pageSizeTemp").val();
	        if( pageSize != "" && /^[0-9]*$/.test(pageSize) ){
	            $("#pageSize").val(pageSize);
	      	    document.all.pageform.action='<%=basePath%>admin/public/PeopleVoteServlet?act=list';
			    document.all.pageform.submit();
            }else{
		        alert("请输入数字！");
		    }   
        }
        
        //搜索设置
        function search(){
            $("#btnSearch").val($.trim($("#btnSearch").val()));
            document.all.pageform.action='<%=basePath%>admin/public/PeopleVoteServlet?act=list';
		    document.all.pageform.submit();  
        }
    </script>
</head>

<body class="mainbody">
<form  name="pageform"   method="post">
<div class="navigation">首页 &gt; 公众参与管理 &gt; 网上调查管理</div>
    <div class="tools_box">
	    <div class="tools_bar">
	        <a href="javascript:add();" class="tools_btn"><span><b class="add">新建调查</b></span></a>
		    <a href="javascript:void(0);" onclick="checkAll(this);" class="tools_btn"><span><b class="all">全选</b></span></a>
            <a  id="btnDelete" class="tools_btn" href="javascript:delItems();"><span><b class="delete">批量删除</b></span></a>
        </div>
    </div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="msgtable">
      <tr>
        <th width="6%">选择</th>
        <th align="left">主题</th>
        <th width="15%" align="center">开始时间</th>
        <th width="15%" align="center">结束时间</th>
        <th width="10%" align="center">调查状态</th>
        <th width="100" align="center">操作</th>
      </tr>
       <c:forEach items="${pager.resultList}" var="item">  
      <tr>
        <td align="center"><span class="checkall">
        <input id="rptList_ctl01_chkId" type="checkbox" name="itemList" value="${item.id}" />
        </span></td>
        <td >${item.zt }</td>
        <td align="center">${item.kssj }</td>
        <td align="center">${item.jssj }</td>
        <td align="center">${item.status }</td>
        <td align="center">
        <!-- 	<a href="" target="_self">浏览</a> | -->
            <a href="javascript:update(${item.id });" target="_self">编辑</a>
        </td>
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
			  <a href="javascript:goPage(${pager.firstPageNo})">首页</a>
		      <a href="javascript:goPage(${pager.prePageNo})">上一页</a> 
		   </c:otherwise>
		  </c:choose>
	      
	      <span class="current">${pager.pageNo}页/${pager.pageCount}页</span>
	      <c:choose>
		   <c:when test="${pager.pageNo==pager.pageCount||page.pageCount==0}">
	   		   <span class="disabled">下一页</span> 
			   <span class="disabled">尾页</span> 
		   </c:when> 
		   <c:otherwise> 
	           <a href="javascript:goPage(${pager.nextPageNo})">下一页</a>
	           <a href="javascript:goPage(${pager.lastPageNo})">尾页</a>
		   </c:otherwise>
		  </c:choose>
		        &nbsp;&nbsp;
                           跳转到<input type="text" id="pageNoTemp" name="pageNoTemp" value="${pager.pageNo }" size="3"/>
               <input type="hidden" id="pageNo" name="pageNo" value="${pager.pageNo }" />
           <a href="javascript:goThePage()" class="btnSearch">GO</a>
		  </div>
      
      	<div class="left">
                     显示<input  id="pageSizeTemp" name="pageSizeTemp" type="text" value="${pager.pageSize}"  class="txtInput2 small2" />条/页
      	   <input  id="pageSize" name="pageSize" type="hidden" value="${pager.pageSize}"/>
      	<a href="javascript:setPageSize()" class="btnSearch">SET</a>
      	</div>

     </div>

	 <div class="line10"></div>
     </form>

      
      <div id="frameDiv" class="hideFrame" >
      
          <iframe  src="" width="100%" height="1000px" scrolling="auto" frameborder="0" name="theFrame" id="theFrame"></iframe>
      
      </div>


  </body>
</html>

