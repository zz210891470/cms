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
		<style>
    .showDiv{display:block;z-index:5;position:absolute;top:0;left:0;width:100%;height:auto;}
    .hideDiv{display:none;}
    </style>
	<script type="text/javascript" >
		//--------
        //月报浏览
        //--------
        function read(id,yf){
            $("#theFrame").attr("src","<%=basePath%>admin/zdxm/ZdxmYbServlet?action=toYbRead&id="+id+"&yf="+yf);
            $("#frameDiv").removeClass("hideDiv");
            $("#frameDiv").addClass("showDiv");
            $("#form").addClass("hideDiv");
        }
	    //--------
        //月报编辑
        //--------
        function edit(id,yf){
            $("#theFrame").attr("src","<%=basePath%>admin/zdxm/ZdxmYbServlet?action=toYbEdit&id="+id+"&yf="+yf);
            $("#frameDiv").removeClass("hideDiv");
            $("#frameDiv").addClass("showDiv");
            $("#form").addClass("hideDiv");
        }
                        
        //post提交刷新页面 隐藏editFrame
        function hideEditFrame(){
            $("#form").submit();
        }
        
        //get刷新页面 隐藏addFrame
        function hideAddFrame(){
            window.location.reload(true);
        }

        //隐藏子框架
        function hideFrame(){
            $("#frameDiv").removeClass("showDiv");
            $("#frameDiv").addClass("hideDiv");
            $("#form").removeClass("hideDiv");
            $("#from").addClass("showDiv");

        }
	
	    $(function(){
            var NowDate=new Date();
            var NowYear=NowDate.getFullYear();
            var outYearHtml="";
            var outMonthHtml="";
            
        	for(var  i = NowYear ; i >= 2000; i--)
			{
			if(i <= NowYear && i != ${nd} )
				{outYearHtml += "<option value='"+i+"'>"+i+"</option>";}
			else if(i == ${nd} )
				{outYearHtml += "<option value='"+i+"' selected>"+i+"</option>";}
			}
			
			for(var j  = 1; j <= 12; j++){
			    if(j == ${yf}){
			      outMonthHtml += "<option value='"+j+"' selected>"+j+"</option>";
			    }else{
			      outMonthHtml += "<option value='"+j+"' >"+j+"</option>";
			    }
			}
			
            $("#nd").html(outYearHtml);
            $("#yf").html(outMonthHtml);
        });
	
	</script>
  </head>
  <body class="mainbody">
  	<form name="form" method="post" action="ZdxmYbServlet?action=ybgllist" id="form">
    	<div class="navigation">首页 &gt; 重点项目管理 &gt; 重点项目建设月报</div>
    	<div class="select_box">
    	项目类别：<select name="lb" id="lb" class="select2" >
    	       <c:if test="${lb=='在建'}">
    	       <option value="在建" selected>在建</option>
    	       <option value="预备">预备</option>
    	       <option value="前期">前期</option></c:if>
    	       <c:if test="${lb=='预备'}">
    	       <option value="在建" >在建</option>
    	       <option value="预备" selected>预备</option>
    	       <option value="前期">前期</option></c:if>
    	       <c:if test="${lb=='前期'}">
    	       <option value="在建" >在建</option>
    	       <option value="预备">预备</option>
    	        <option value="前期" selected>前期</option></c:if>
    	     </select> 
    	月报年月：<select name="nd" id="nd" class="select2" ></select> -
    	<select class="select2" id="yf" name="yf">
    	</select>
    	<input type="submit" name="btnSearch" value="查 询" id="btnSearch" class="btnSearch" />
    	</div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="msgtable">
			<tr>
			  <th align="center">项目编号</th>
			  <th align="center">项目名称</th>
              <th width="140" align="center">本月到位资金（万元）</th>
			  <th width="140" align="center">本月完成投资（万元）</th>
			  <th width="80" align="center">上报日期</th>
			  <th width="80" align="center">上报状态</th>
			  <th width="80">操作</th>
			</tr>
				<c:forEach items="${itemList}" var="item">
						<c:if test="${item.zt != '已上报'}">
							<tr>
						        <td align="center">${item.bh }</td>
						        <td align="center" style="text-align: left;padding-left: 100px;">${item.mc }</td>
				                <td>本月未上报</td>
						        <td>本月未上报</td>
						        <td>本月未上报</td>
						        <td>本月未上报</td>
						        <td align="center">
						         &nbsp;
						        </td>
				      		</tr>
						</c:if>
						<c:if test="${item.zt == '已上报'}">
							<tr>
						        <td align="center">${item.bh }</td>
						        <td align="center" style="text-align: left;padding-left: 100px;">${item.mc }</td>
				                <td>${item.dwzjhj }</td>
						        <td>${item.bywc }</td>
						        <td>${item.tbrq }</td>
						        <td>${item.zt }</td>
						        <td align="center">
						          <a href="javascript:read(${item.id },${yf })">详情</a>
						          <a href="javascript:edit(${item.id },${yf })">修改</a>
						        </td>
					      	</tr>
						</c:if>
		   		 </c:forEach>  
		</table>
    </form>
    
      <div id="frameDiv" class="hideFrame" >
          <iframe src="" width="100%" height="1350px" scrolling="auto" frameborder="0" name="theFrame" id="theFrame"></iframe>
      </div>
  </body>
</html>