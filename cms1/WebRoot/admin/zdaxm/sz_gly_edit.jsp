<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�û��༭</title>
    
   <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>admin/images/style.css"/>
	<script type="text/javascript" src="<%=basePath%>admin/lib/jquery/jquery-1.3.2.min.js"></script>  
	<script type="text/javascript" src="<%=basePath%>admin/js/function.js"></script>
	<style>
	    body{
	        background-color:#ffffff;
	    }
	
	</style>
	
	<script type="text/javascript">
       function save(){
    	   if(document.getElementById("yhm").value==""||document.getElementById("mm").value==""||document.getElementById("xm").value==""){
          		alert("�û��������롢��������Ϊ�գ�");
          		return;
          	}
           $("#form").submit();
       }
       
       function back(){
           window.parent.hideFrame();
       }
    
    </script>
  </head>
  <body class="mainbody">
	<form name="form" method="post" action="<%=basePath%>admin/ManageServlet?action=update&lx=zda" id="form">
	    	<div class="select_box">
				<input  type="button" value="����"  onclick="save()" class="btnSearch"/>
	            <input  type="button" value="����"  onclick="back()" class="btnSearch"/>
			</div>
    		<table class="form_table">
				<col width="150px"></col>
				<tbody>
				<tr>
					<th>�û�����<input type="hidden"  value="${item.id }" name="id"/></th>
					<td><input id="yhm" name="yhm" type="text" value="${item.yhm }" maxlength="100"  class="txtInput normal required" /><font color="red"> *</font></td>
				</tr>
				<tr>
					<th>���룺</th>
					<td><input id="mm" name="mm" type="password" value="${item.mm }" maxlength="100"  class="txtInput normal required" /><font color="red"> *</font></td>
				</tr>
				<tr>
					<th>������</th>
					<td><input id="xm" name="xm" type="text" value="${item.xm }" maxlength="100"  class="txtInput normal required" /><font color="red"> *</font></td>
				</tr>

				</tbody>
			</table>
    </form>
  </body>
</html>