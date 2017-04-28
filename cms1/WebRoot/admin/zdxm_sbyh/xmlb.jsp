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
		<link rel="stylesheet" type="text/css" href="<%=basePath%>admin/images/style.css"/>
		<script type="text/javascript" src="<%=basePath%>admin/lib/jquery/jquery-1.3.2.min.js"></script>  
		<script type="text/javascript" src="<%=basePath%>admin/js/function.js"></script>
   
    <script type="text/javascript">

		function loadyb(id){
			window.parent.showyb(id);
		}
		
        //搜索设置
        function search(){
            $("#btnSearch").val($.trim($("#btnSearch").val()));
            document.all.pageform.action='<%=basePath%>admin/zdxm_sbyh/ZdxmSbyhServlet?action=xmyblb';
		    document.all.pageform.submit();  
        }
        
        $(function(){
            var NowDate=new Date();
            var NowYear=NowDate.getFullYear();
            var outHtml="";
        	for(var  i = NowYear ; i >= 2012; i--)
			{
			if(i <= NowYear && i != ${thedate} )
				{outHtml += "<option value='"+i+"'>"+i+"</option>";}
			else if(i == ${thedate} )
				{outHtml += "<option value='"+i+"' selected>"+i+"</option>";}
			}
            $("#nd").html(outHtml);
	        
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
    </script>
		
    </head>
  <body class="mainbody">
  	<form name="pageform" method="post" action="" id="form">
    	<div class="tools_box">
			<div class="tools_bar">
			<div style="margin:10px 0 0 0px;">
	            &nbsp;&nbsp;项目类别：<select name="lb" id="lb" class="select2" ></select> &nbsp;&nbsp;年度：<select name="nd" id="nd" class="select2" id="nd"></select>&nbsp;
            	<input type="button" onclick="search()"  value="确 定" id="btnSearch" class="btnSearch" />
            </div>
            </div>
        </div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="msgtable">
			<tr>
			  <th align="left" width="50">年度</th>
			  <th align="left">项目名称</th>
			</tr>
			<c:forEach items="${itemList}" var="item">
			 <tr>
			     <td>${item.nd }</td>
		         <td style="text-align:left;"><a   href="javascript:loadyb('${item.id }')" onclick="" target="_self">${item.mc }</a></td>
		      </tr>
		    </c:forEach>  
		</table>
    </form>
    </body>
</html>