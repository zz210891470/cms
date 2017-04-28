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
	<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script>  
	<script type="text/javascript" src="../js/function.js"></script>
	<style>
    .showDiv{display:block;z-index:5;position:absolute;top:0;left:0;width:100%;height:auto;}
    .hideDiv{display:none;}
    </style>
	<script>
	
	    //--------
        //编辑列表项
        //--------
        function edit(i){
            $("#theFrame").attr("src","<%=basePath%>admin/zdxm_sbyh/ZdxmSbyhServlet?action=toYbEdit&id="+i);
            $("#frameDiv").removeClass("hideDiv");
            $("#frameDiv").addClass("showDiv");
        }
        
                        
        //post提交刷新页面 隐藏editFrame
        function hideEditFrame(){
            document.all.pageform.submit();
        }
        
        //get刷新页面 隐藏addFrame
        function hideAddFrame(){
            window.location.reload(true);
        }
        
                //隐藏子框架
        function hideFrame(){
            $("#frameDiv").removeClass("showDiv");
            $("#frameDiv").addClass("hideDiv");

        }
        
        //添加列表项
        function add(id){
            $("#theFrame").attr("src","<%=basePath%>admin/zdxm_sbyh/ZdxmSbyhServlet?action=yblr&id="+id);
            $("#frameDiv").removeClass("hideDiv");
            $("#frameDiv").addClass("showDiv");
        }
        
        $(function(){
           if($("#addstatus").val()=="ok"){
              alert("本年度所有月报均已填写！");
           }
       });
        
	</script>
  </head>
  <body class="mainbody">
    <input id="addstatus" type="hidden" value="${addstatus }"/>
  	<form name="form" method="post" action="" id="form">
  	    <div class="tools_box">
	    <div class="tools_bar">
            <a href="javascript:add('${id }')" class="tools_btn"><span><b class="add">添加月报</b></span></a>
        	<div style="text-align:center; font-size:16px; line-height:50px; font-weight:bold;">${xmmc }</div>
        </div>
        
        </div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="msgtable">
			<tr>
			  <th width="80" align="center">月报时间</th>
			  <th width="90" align="center">本月到位资金</th>
			  <th width="90" align="center">本月完成投资</th>
			  <th width="80" align="center">上报日期</th>
			  <th width="80" align="center">上报状态</th>
			  <th width="80">操作</th>
			</tr>
			<c:forEach items="${itemList}" var="item">
		     <tr>
		        <td align="center">${item.yf }</td>
		        <td>${item.dwzjhj }</td>
		        <td>${item.bywc }</td>
		        <td>${item.tbsj }</td>
		        <td>${item.zt }</td>
		        <td align="center">
			  <a href="javascript:read(${item.id })" target="_self">详情</a>
			  <!--根据状态控制修改、上报显示，状态为未上报时显示  -->
			  <c:if test="${item.zt=='未上报'}">
		          <a href="javascript:edit(${item.id })" target="_self">编辑</a>
		          <a href="javascript:submit(${item.id })" target="_self">上报</a>
		      </c:if>    
			</td>
		      </tr>
		    </c:forEach>  
		</table>
    </form>
          
      <div id="frameDiv" class="hideFrame" >
          <iframe  src="" width="100%" height="1800px" scrolling="auto" frameborder="0" name="theFrame" id="theFrame"></iframe>
      </div>
  </body>
</html>