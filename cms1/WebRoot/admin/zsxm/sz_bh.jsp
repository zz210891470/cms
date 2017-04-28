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
	<link rel="stylesheet" type="text/css" href="<%=basePath%>admin/js/autocomplete.css"/>
	<script type="text/javascript" src="<%=basePath%>admin/lib/jquery-1.7.min.js"></script>  
	<script type="text/javascript" src="<%=basePath%>admin/js/function.js"></script>
	
	<script type="text/javascript" src="<%=basePath%>admin/js/autocomplete.js"></script>

    <script type="text/javascript">
    $(function(){
        if("true" == $("#status").val()){
           alert("保存成功！");
        }

    });
    
    
    function singlesave(id){
        var bhVal = $("#"+id+"_val").val();

        $.post("<%=basePath%>admin/NumberServlet?act=singlesave&lx=zs&id="+id+"&bh="+bhVal,function(data){
           if(data=="ok"){
               
               alert("保存成功!");
           }else{
               alert("保存失败，请检查网络及输入格式！");
           }   
        });
    
    }
    
    function tofresh(){
        document.all.listform.action="<%=basePath%>admin/NumberServlet?act=search&lx=zs";
        document.all.listform.submit();
    }
    
    function search(){
        
        document.all.listform.action="<%=basePath%>admin/NumberServlet?act=search&lx=zs";
        document.all.listform.submit();
    }
    
    
    function save(){
        document.all.listform.action="<%=basePath%>admin/NumberServlet?act=update&lx=zs";
        document.all.listform.submit();
		
	}
    </script>
  </head>
  <body class="mainbody">
    <form action="" name="listform" method="post">
   	<div class="select_box">
   	    <input  type="hidden" value="${status }" id="status"/>
   		项目年度：<input name="nd" id="nd" type="text" value="${nd }" maxlength="4" onkeyup="clearNoNum(this)"  class="txtInput normal required" style="width:40px;" />
           项目名称/编号：<input name="searchstr" id="searchstr" type="text" value="${searchstr }" maxlength="100"  class="txtInput normal required" style="width:150px;" />
   		<input type="button" name="btnSearch" onclick="search();" value="查 询"      id="btnSearch" class="btnSearch" />&nbsp;&nbsp;
        <input type="button" name="btnSearch" onclick="save();"   value="批量保存修改" id="btnSearch" class="btnSearch"  />
        <span style="float:right;"><a href="javascript:tofresh();" target="_self">刷新</a></span>
   	</div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="msgtable">
		<tr>
          <th align="center" style="width:60px;">年度</th>
		  <th align="center">项目名称</th>
		  <th align="center" style="width:100px;">项目编号</th>
	      <th align="center" style="width:80px;">操作</th>  	
		</tr>
			<c:forEach items="${resultList}" var="item">
		     <tr>
		     	<td height="24" align="center">${item.nd }</td>
	            <td align="left">${item.mc }</td>
				<td align="center">
				    <input name="idlist" type="hidden" value="${item.id }"/>
	            	<input id="${item.id}_val" name="pronum" type="text"   value="${item.bh }" maxlength="10" onkeyup="clearNoNum(this)"  class="txtInput normal required" style="width:100px;" />
	            </td>
    	    	<td align="center">
					<a  target="_self"  onclick="singlesave(${item.id });" href="#">保存</a>
				</td>  	
		      </tr>
		    </c:forEach>  
		
	</table>
	</form>
	<input id="userList" type="hidden" value="${userList }"/>
  </body>
</html>