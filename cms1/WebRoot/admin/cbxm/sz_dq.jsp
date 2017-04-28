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
		function add(){
			document.getElementById("lb").style.display="none";
			document.getElementById("bj").style.display="";
			document.getElementById("id").value="";
			document.getElementById("mc").value="";
			document.getElementById("px").value="";
			document.getElementById("pid").options[0].selected=true;
		}
		function edit(pid,id,mc,px){
			document.getElementById("id").value=id;
			document.getElementById("mc").value=mc;
			document.getElementById("px").value=px;
			document.getElementById("lb").style.display="none";
			document.getElementById("bj").style.display="";
			for(var i=0;i<document.getElementById("pid").options.length;i++){
				if(document.getElementById("pid").options[i].value==pid){
					document.getElementById("pid").options[i].selected=true;
					break;
				}
			}
		}
		function save(){
			if(document.getElementById("mc").value==""){
				alert("地区名称不能为空！");
				return;
				}
			if(document.getElementById("px").value==""){
				alert("类别排序不能为空！");
				return;
				}
				document.getElementById("frm").submit();
		}
		function cancel(){
			document.getElementById("lb").style.display="";
			document.getElementById("bj").style.display="none";
			}
		function del(id){
			//使用ajax提交删除，返回SUCCESS后重新加载本页
			if(confirm("确定要删除地区名称？")){
         		$.post('<%=basePath%>admin/AreaServlet?act=del&id='+id, function(data){
	          	data=JSON.parse(data);
	          	if(data[0]=="SUCCESS"){
	          		location.href="<%=basePath%>admin/AreaServlet?act=list&lx=cb";
	          	}
	    		});
			}
		}
	</script>
  </head>
  <body class="mainbody">
  	<div id="lb">
        <div class="select_box">
            <input type="button" name="btnSearch" value="添 加" id="btnSearch" class="btnSearch" onclick="add();" />&nbsp;
            <span style="float:right;"><a href="#" onclick="location.href='AreaServlet?act=list&lx=cb';" target="_self">刷新</a></span>
        </div>
        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="msgtable">
            <tr>
              <th align="center">地区名称</th>
              <th align="center" width="80">排序</th>
              <th align="center" width="80">操作</th>
            </tr>
            <c:forEach items="${AreaList}" var="item">
            <tr>
                <td height="20"  style="text-align:left;">${item.mc }</td>
                <td align="center">${item.px }</td>
                <td align="center">
                    <a href="#%20" target="_self" onclick="edit('${item.pid}','${item.id}','${item.mc}','${item.px}');">修改</a>
                    <a href="#%20" target="_self" onclick="del('${item.id}');">删除</a>
                </td>
            </tr>
            </c:forEach>
        </table>
    </div>
    <div id="bj" style="display:none;">
    	<form name="frm" id="frm" method="post" target="_self" action="<%=basePath%>admin/AreaServlet?act=add">
    	<div class="select_box">
            <input type="button" name="btnSearch" value="保 存" id="btnSearch" class="btnSearch" onclick="save();" />&nbsp;&nbsp;
            <input type="button" name="btnSearch" value="取 消" id="btnSearch" class="btnSearch" onclick="cancel();" />
            <input type="hidden" name="id" id="id" value="" />
            <input type="hidden" name="lx" value="cb" />
        </div>
            <table class="form_table">
                <col width="150px"></col>
                <tbody>
                <tr style="display:none;">
                    <th>上级地区：</th>
                    <td>
                        <select name="pid" id="pid" class="select2">
                        	<option value="0">-作为一级地区-</option>
                        	<c:forEach items="${AreaList}" var="item">
                        		<c:if test="${item.pid==0}">
                        		<option value="${item.id }">${item.mc }</option>
                        		</c:if>
                        	</c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>地区名称：</th>
                    <td><input name="mc" id="mc" type="text" value="" maxlength="100"  class="txtInput normal required" /><font color="red"> *</font></td>
                </tr>
                <tr>
                    <th>类别排序：</th>
                    <td><input name="px" id="px" type="text" value="" maxlength="100" class="txtInput normal required" onkeyup="clearNoNum(this);" /><font color="red"> *</font></td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
  </body>
</html>