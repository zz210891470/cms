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
   
    <script type="text/javascript">

		function loadyb(id){
			window.parent.showyb(id);
		}
        //搜索设置
        function search(){
            $("#btnSearch").val($.trim($("#btnSearch").val()));
            var nd=document.getElementById("nd").value;
            document.all.pageform.action='<%=basePath%>admin/zdaxm_sbyh/ZdaxmSbyhServlet?action=xmyblb&nd='+nd;
		    document.all.pageform.submit();  
        }
        
        $(function(){
            var NowDate=new Date();
            var NowYear=NowDate.getFullYear();
            var outHtml="";
        	for(var  i = 2012 ; i <= NowYear; i++)
			{
			if(i <= NowYear && i != ${thedate} )
				{outHtml += "<option value='"+i+"'>"+i+"</option>";}
			else if(i == ${thedate} )
				{outHtml += "<option value='"+i+"' selected>"+i+"</option>";}
			}
            $("#nd").html(outHtml);
        });
    </script>
		
    </head>
  <body class="mainbody">
  	<form name="pageform" method="post" action="" id="form">
    	<div class="tools_box"> 
	                    年度：<select name="nd" id="nd" class="select2" id="nd" onchange="" style="margin-top:15px;" ></select>
            <input type="button" onclick="search()"  value="确 定" id="btnSearch" class="btnSearch" />
        </div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="msgtable">
			<tr>
			  <th align="left" width="50">年度</th>
			  <th align="left">项目名称</th>
			</tr>
			<c:forEach items="${itemList}" var="item">
			 <tr>
			     <td>${item.nd }</td>
		         <td style="text-align:left;"><a href="#%20" onclick="javascript:loadyb('${item.id }');" target="_self">${item.mc }</a></td>
		      </tr>
		    </c:forEach>  
		</table>
    </form>
    </body>
</html>