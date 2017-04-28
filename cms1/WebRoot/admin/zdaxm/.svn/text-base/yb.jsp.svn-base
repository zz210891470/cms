<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String nd = (String)request.getAttribute("nd"); // 年度
	String yf = (String)request.getAttribute("yf"); // 月份
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>admin/images/style.css"/>
	<script type="text/javascript" src="<%=basePath%>admin/lib/jquery/jquery-1.3.2.min.js"></script>  
	<script type="text/javascript" src="<%=basePath%>admin/js/function.js"></script>
		<style>
    .showDiv{display:block;z-index:5;position:absolute;top:0;left:0;width:100%;height:auto;}
    .hideDiv{display:none;}
    </style>
	<script type="text/javascript" >
	$(function(){
		var nd = "<%=nd %>"; // 年度
		var yf = "<%=yf %>"; // 月份
		var NowDate=new Date();
		var NowYear=NowDate.getFullYear();
		var yearHtml="";
		
		if(null != nd && "" != nd){
			for(var i=2010;i<=NowYear;i++){
				if(i == nd){
					yearHtml += "<option value='"+i+"' selected>"+i+"</option>";
				}else{
					yearHtml += "<option value='"+i+"'>"+i+"</option>";
				}
			}
		}else{
			for(var i=2010;i<=NowYear;i++){
				if(i<NowYear){
					yearHtml += "<option value='"+i+"'>"+i+"</option>";
				}else{
					yearHtml += "<option value='"+i+"' selected>"+i+"</option>";
				}
			}
		}
		var monthHtml="";
		if(null != yf && "" != yf){
			for(var j=1;j<13;j++){
				if(yf == j){
					monthHtml += "<option value='"+j+"' selected>"+j+"</option>";
				}else{
					monthHtml += "<option value='"+j+"'>"+j+"</option>";
				}
			}
		}else{
			for(var j=1;j<13;j++){
				monthHtml += "<option value='"+j+"'>"+j+"</option>";
			}
		}
        $("#nd").html(yearHtml);
        $("#yf").html(monthHtml);
     });

	//--------
    //月报浏览
    //--------
    function read(id){
        $("#theFrame").attr("src","<%=basePath%>admin/zdaxm/ZdaxmYbServlet?action=toYbRead&id="+id);
        $("#frameDiv").removeClass("hideDiv");
        $("#frameDiv").addClass("showDiv");
    }
    //--------
    //月报编辑
    //--------
    function edit(id){
        $("#theFrame").attr("src","<%=basePath%>admin/zdaxm/ZdaxmYbServlet?action=toYbEdit&id="+id);
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
	</script>
  </head>
  <body class="mainbody">
  	<form name="pageform" method="post" action="ZdaxmYbServlet?action=list" id="form">
    	<div class="navigation">首页 &gt; 重大项目管理 &gt; 项目月报管理</div>
    	<div class="select_box">
    	月报年月：<select name="nd" id="nd" class="select2" ></select> -
    	<select class="select2" id="yf" name="yf">
    	</select>
    	<input type="submit" name="btnSearch" value="查 询" id="btnSearch" class="btnSearch" />
    	</div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="msgtable">
			<tr>
			  <th align="center">项目名称</th>
			  <th align="center">本月完成投资</th>
			  <th align="center">当年累计完成</th>
			  <th align="center">开工以来累计完成</th>
			  <th align="center">上报日期</th>
			  <th align="center">上报状态</th>
			  <th width="150" align="center">操作</th>
			</tr>
				<c:forEach items="${pager.resultList}" var="item">
		     <tr>
		        <td>${item.mc }</td>
		       	<td>${item.bywc }</td>
		       	<td>${item.nczbywc }</td>
		       	<td>${item.kgljwc }</td>
		        <td>${item.tbsj }</td>
		        <td>${item.zt }</td>
		        <td align="center">
		          <a href="javascript:read(${item.id })" target="_self">详情</a>
		          <a href="javascript:edit(${item.id })" target="_self">修改</a>
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
