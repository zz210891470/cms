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
	    <style>
	    body{
	        background-color:#ffffff;
	    }
	</style>
	<script type="text/javascript" src="<%=basePath%>admin/lib/jquery/jquery-1.3.2.min.js"></script>  
	<script type="text/javascript" src="<%=basePath%>admin/js/function.js"></script>
    <script type="text/javascript">
      function save(){
       	   if(document.getElementById("dywc").value==""){
       			alert("当月完成投资不能为空！");
       			return;
       		}
       	   document.getElementById("zt").value="未上报";
           $("#form").submit();
       }
       function saveup(){
       		if(document.getElementById("dywc").value==""){
       			alert("当月完成投资不能为空！");
       			return;
       		}
       		if(document.getElementById("zt").value==""){
       			alert("请再次核对填报的数据，上报后将无法对数据进行修改！");
       			document.getElementById("zt").value="已上报";
       		}else{
       			if(confirm("确定要上报数据？")){
       				$("#form").submit();
       			}
       		}
       }
       function back(){
           window.parent.hideFrame();
       }
    
		function dywcjs(){
    		var dywc=document.getElementById("dywc").value;
    		if(dywc!=""){
    			document.getElementById("span_dnwc").innerHTML=parseFloat(parseFloat(dywc)+parseFloat(document.getElementById("dnwc2").value));
    			document.getElementById("dnwc").value=parseFloat(parseFloat(dywc)+parseFloat(document.getElementById("dnwc2").value));
    			if(${yf}!=1){
	    			document.getElementById("span_kgwc").innerHTML=parseFloat(parseFloat(dywc)+parseFloat(document.getElementById("kgwc2").value));
	    			document.getElementById("kgwc").value=parseFloat(parseFloat(dywc)+parseFloat(document.getElementById("kgwc2").value));
    			}
    		}
    	}
    </script>
  </head>
  <body class="mainbody">
  	<form name="form" method="post" action="ZdaxmSbyhServlet?action=addyb" id="form">
  	
  	<input type="hidden" value="${yf }" name="yf"/>
  	<input type="hidden" value="${id }" name="id"/>
    <table width="95%" border="0" align="center" cellspacing="0">
			<tr>
			<td width="85%" height="30" align="center">
            	<b><font color="#336699">龙岩市重大项目月信息报表${yf }月份</font></b>
            </td>
			</tr>
	  </table>
  <table border="1" width="100%"  align="center" cellspacing="0">
    <tr>
      <td height="30" style="width: 16%">
        <p align="center">项目名称</p>
      </td>
      <td colspan="2">&nbsp;${zdaxm.mc }</td>
    </tr>
    <tr>
      <td height="30" style="width: 16%">
        <p align="center">建设规模及内容</p>
      </td>
      <td style=" padding:5px; line-height:1.5;" colspan="2">${zdaxm.jsgm }</td>
    </tr>
    <tr>
      <td height="30" style="width: 16%">
        <p align="center">总投资（万元）</p>
      </td>
      <td colspan="2">&nbsp;${zdaxm.ztz }</td>
    </tr>
    <tr>
      <td height="30" style="width: 16%">
        <p align="center">开工日期</p>
      </td>
      <td colspan="2">&nbsp;${zdaxm.kgn }年${zdaxm.kgy }月</td>
    </tr>
    <tr>
      <td width="100%" colspan="3" height="30" bgcolor="#FFCCCC">
        <p align="left">投资完成情况（单位：万元）</p>
      </td>
    </tr>
    <tr>
      <td height="30">
        <p align="center">当月完成</p>
      </td>
      <td>
        <p align="center">当年累计完成</p>
      </td>
      <td>
        <p align="center">开工以来累计完成</p>
      </td>
    </tr>
    <tr>
      <td align="center" height="30"><input name="dywc" type="text" value="0" id="dywc" onkeyup="clearNoNum(this);dywcjs();" style="width:80px;" class="txtInput normal required" /></td>
      <td align="center">
      	<span id="span_dnwc">${zdaxm.dnljwc }</span>
      	<input name="dnwc" type="hidden" value="${zdaxm.dnljwc}" id="dnwc" />
      	<input name="dnwc2" type="hidden" value="${zdaxm.dnljwc}" id="dnwc2" />
      </td>
      <c:if test="${yf>1}">
	      <td align="center">
	      	<span id="span_kgwc">${zdaxm.kgljwc}</span>
	      	<input name="kgwc" type="hidden" value="${zdaxm.kgljwc}" id="kgwc" />
	      	<input name="kgwc2" type="hidden" value="${zdaxm.kgljwc}" id="kgwc2" />
	      </td>
      </c:if>
      <c:if test="${yf==1}">
     	 <td align="center">
	      	<input name="kgwc" type="text" value="${zdaxm.kgljwc}" id="kgwc" onkeyup="clearNoNum(this);"/>
	      </td>
      </c:if>
    </tr>
    <tr>
      <td width="100%" colspan="3" height="25">
        <p align="left">已完成工作节点</p>
      </td>
    </tr>
    <tr>
      <td width="100%" colspan="3">
          <textarea name="wcgz" rows="2" cols="20" id="wcgz" style="font-family:宋体;height:80px;width:100%;" class="txtInput normal required"></textarea>
      </td>
    </tr>
    <tr>
      <td width="100%" colspan="3" height="25">
        <p align="left">项目进展情况</td>
    </tr>
    <tr>
      <td width="100%" colspan="3">
          <textarea name="jzqk" rows="2" cols="20" id="jzqk" style="font-family:宋体;height:80px;width:100%;" class="txtInput normal required"></textarea>
      </td>
    </tr>
    <tr>
      <td width="100%" colspan="3" height="25">
        <p align="left">存在问题</p>
      </td>
    </tr>
    <tr>
      <td width="100%" colspan="3">
          <textarea name="czwt" rows="2" cols="20" id="czwt" style="font-family:宋体;height:80px;width:100%;" class="txtInput normal required"></textarea>
      </td>
    </tr>
    
    <tr>
      <td width="100%" colspan="3" height="25">
        <p align="left">下月工作计划</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="3">
          <textarea name="xyjh" rows="2" cols="20" id="xyjh" style="font-family:宋体;height:80px;width:100%;" class="txtInput normal required"></textarea>
      </td>
    </tr>
    
    <tr>
      <td width="100%" colspan="3" height="25">
        <p align="left">备注</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="3">
          <textarea name="bz" rows="2" cols="20" id="bz" style="font-family:宋体;height:80px;width:100%;" class="txtInput normal required"></textarea>
      </td>
    </tr>
    
  </table>
  
  <div class="foot_btn_box">
		<input type="hidden" id="zt" name="zt" value="" />
  		 <input  type="button" value="保存并上报"  onclick="saveup()" class="btnSubmit"/>&nbsp;&nbsp;
         <input  type="button" value="保 存"  onclick="save()" class="btnSubmit"/>&nbsp;&nbsp;
         <input  type="button" value="返 回"  onclick="back()" class="btnSubmit"/>
    </div>
  </form>
  </body>
</html>
