<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
	    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<link rel="stylesheet" type="text/css" href="../images/style.css"/>
		<script type="text/javascript" src="<%=basePath%>admin/lib/jquery/jquery-1.3.2.min.js"></script>  
	<script type="text/javascript" src="<%=basePath%>admin/js/function.js"></script>
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
    $(function(){
        //项目年份
        var NowDate=new Date();
        var NowYear=NowDate.getFullYear();
        var outYearHtml="";
        var nd = '${nd}';
    	for(var  i = NowYear+4 ; i >= 2000; i--){
			if(i <= NowYear+4 && i != nd ){
				outYearHtml += "<option value='"+i+"'>"+i+"</option>";
			}else if(i == nd ){
				outYearHtml += "<option value='"+i+"' selected>"+i+"</option>";
			}
		}
        $("#nd").html(outYearHtml);
        
        // 项目类别
        var lb = '${xmlb}';
        var outLbHtml="";
        if(lb=='' || lb=='在建'){
        	outLbHtml += "<option value='在建' selected>在建</option>";
        	outLbHtml += "<option value='预备'>预备</option>";
        	outLbHtml += "<option value='前期'>前期</option>";
        }else if(lb=='预备' ){
        	outLbHtml += "<option value='在建'>在建</option>";
        	outLbHtml += "<option value='预备' selected>预备</option>";
        	outLbHtml += "<option value='前期'>前期</option>";
        }else if(lb=='前期' ){
        	outLbHtml += "<option value='在建'>在建</option>";
        	outLbHtml += "<option value='预备'>预备</option>";
        	outLbHtml += "<option value='前期' selected>前期</option>";
		}
        $("#lb").html(outLbHtml);
    });
        //--------
        //编辑列表项
        //--------
        function edit(i){
            $("#theFrame").attr("src","<%=basePath%>admin/zdxm/ZdxmServlet?action=toEdit&id="+i);
            $("#frameDiv").removeClass("hideDiv");
            $("#frameDiv").addClass("showDiv");
        }
        
        //查看项目详情
        function read(i){
            $("#theFrame").attr("src","<%=basePath%>admin/zdxm/ZdxmServlet?action=toRead&id="+i);
            $("#frameDiv").removeClass("hideDiv");
            $("#frameDiv").addClass("showDiv");
        }
        
        //添加列表项
        function add(){
            $("#theFrame").attr("src","<%=basePath%>admin/zdxm/ZdxmServlet?action=toAdd&type=1");
            $("#frameDiv").removeClass("hideDiv");
            $("#frameDiv").addClass("showDiv");
        }
        
        //post提交刷新页面 隐藏editFrame
        function hideEditFrame(){
            document.all.pageform.submit();
        }
        
        //get刷新页面 隐藏addFrame
        function hideAddFrame(){
             document.location.href='<%=basePath%>admin/zdxm/ZdxmServlet?action=list';
        }
    
        //隐藏子框架
        function hideFrame(){
            $("#frameDiv").removeClass("showDiv");
            $("#frameDiv").addClass("hideDiv");
        }
        
        //删除列表项 单个删除
        function del(i){
            $('#item'+i).attr("checked","true");
            document.all.pageform.action='<%=basePath%>admin/zdxm/ZdxmServlet?action=del'; 
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
		            document.all.pageform.action='<%=basePath%>admin/zdxm/ZdxmServlet?action=del'; 
		            document.all.pageform.submit(); 
		        }
		    }else{
			    alert("请至少选中一项");
			}   
        }

        
        //跳转页面
        function goPage(i){
        	$("#pageNo").val(i);
      	    document.all.pageform.action='<%=basePath%>admin/zdxm/ZdxmServlet?action=list';
		    document.all.pageform.submit();    
        }
        
        //指定页面跳转
        function goThePage(){
            var pageNo = $("#pageNoTemp").val();
        	if( pageNo != "" && /^[0-9]*$/.test(pageNo) ){
			    if( pageNo > 0 && pageNo <= ${pager.pageCount} ) {  
			        $("#pageNo").val($("#pageNoTemp").val());
		      	    document.all.pageform.action='<%=basePath%>admin/zdxm/ZdxmServlet?action=list';
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
	      	    document.all.pageform.action='<%=basePath%>admin/zdxm/ZdxmServlet?action=list';
			    document.all.pageform.submit();
            }else{
		        alert("请输入数字！");
		    }   
        }
        
        //搜索设置
        function search(){
            $("#btnSearch").val($.trim($("#btnSearch").val()));
            document.all.pageform.action='<%=basePath%>admin/zdxm/ZdxmServlet?action=list';
		    document.all.pageform.submit();  
        }
    </script>
		
    </head>
  <body class="mainbody">
  	<form name="pageform" method="post" action="" id="form">
    	<div class="navigation">首页 &gt; 重点项目管理 &gt; 重点项目信息列表</div>
    	
    	<div class="tools_box">
	    <div class="tools_bar">
            <div class="search_box">
                                    项目类别：<select name="lb" id="lb" class="select2" ></select> 
                                    项目年份：<select name="nd" id="nd" class="select2" ></select>
			    项目名称：<input name="searchStr" type="text" id="txtKeywords" class="txtInput" value="${searchStr }"/>
                <input type="button" onclick="search()"  value="搜 索" id="btnSearch" class="btnSearch" />
		    </div>
            <a href="javascript:add()" class="tools_btn"><span><b class="add">添加项目</b></span></a>
		    <a href="javascript:void(0);" onclick="checkAll(this);" class="tools_btn"><span><b class="all">全选</b></span></a>
            <a href="javascript:delItems();"  id="btnDelete" class="tools_btn" ><span><b class="delete">批量删除</b></span></a>
        </div>
        </div>
    	
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="msgtable">
			<tr>
			  <th width="30">选择</th>
              <th width="60" align="left">项目年度</th>
              <th width="60" align="left">项目编号</th>
			  <th align="left">项目名称</th>
			  <th width="100" align="left">总投资（万元）</th>
			  <th width="120" align="left">计划投资（万元）</th>
			  <th width="100" align="left">所属区域</th>
			  <th width="80" align="left">建设年限</th>
			  <th width="40" align="left">状态</th>
			  <th width="120">操作</th>
			</tr>
			
			<c:forEach items="${pager.resultList}" var="item">
		     <tr>
		        <td align="center"><span class="checkall"><input type="checkbox" name="itemList" value="${item.id}"/></span></td>
		        <td>${item.nd }</td>
		        <td style="text-align:left;">${item.bh }</td>
		        <td style="text-align:left;">${item.mc }</td>
		        <td style="text-align:right;">${item.ztz }</td>
		        <td style="text-align:right;">${item.jhtz }</td>
		        <td>${item.dq }</td>
		        <td>${item.jsnx1 }-${item.jsnx2 }</td>
		        <td>${item.zt }</td>
		        <td align="center">
                  <a href="javascript:read(${item.id })" >详情</a>
		          <a href="javascript:edit(${item.id })" >修改</a>		          
                </td>
		      </tr>
		    </c:forEach>  
		</table>
    	
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
		   <c:when test="${pager.pageNo==pager.pageCount}">
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
    
    
          
      <div id="frameDiv" class="hideFrame" >
      
          <iframe  src="" width="100%" height="1900px" scrolling="auto" frameborder="0" name="theFrame" id="theFrame"></iframe>
      
      </div>
      
    </form>
    </body>
</html>