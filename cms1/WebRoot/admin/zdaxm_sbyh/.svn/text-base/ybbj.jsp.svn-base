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
	   		var dywc2=document.getElementById("dywc2").value;
	   		if(dywc!=""){
	   			document.getElementById("span_dnwc").innerHTML=parseFloat(parseFloat(dywc)+parseFloat(document.getElementById("dnwc2").value)-parseFloat(dywc2));
	   			document.getElementById("dnwc").value=parseFloat(parseFloat(dywc)+parseFloat(document.getElementById("dnwc2").value)-parseFloat(dywc2));
	   			if(${yf}!=1){
	    			document.getElementById("span_kgwc").innerHTML=parseFloat(parseFloat(dywc)+parseFloat(document.getElementById("kgwc2").value)-parseFloat(dywc2));
	    			document.getElementById("kgwc").value=parseFloat(parseFloat(dywc)+parseFloat(document.getElementById("kgwc2").value)-parseFloat(dywc2));
    			}
    		}
   		}
    </script>
  </head>
  <body class="mainbody">
  	<form name="form" method="post" action="ZdaxmSbyhServlet?action=edityb" id="form">
  	<input type="hidden" id="id" name="id" value="${zdaxmyb.id}"/>
    <table width="100%" border="0" align="center" cellspacing="0">
			<tr>
			<td width="85%" height="30" align="center">
				<b><font color="#336699">龙岩市重大项目月信息报表  ${yf }月份</font></b>
            </td>
			</tr>
	  </table>
  <table border="1" width="100%"  align="center" cellspacing="0">
    <tr>
      <td height="25" style="width: 16%" align="center">项目名称</td>
      <td colspan="2">&nbsp;${zdaxm.mc }</td>
    </tr>
    <tr>
      <td height="50" style="width: 16%" align="center">建设规模及内容</td>
      <td colspan="2" style=" padding:5px; line-height:1.5;">${zdaxm.jsgm }</td>
    </tr>
    <tr>
      <td height="25" style="width: 16%" align="center">总投资（万元）</td>
      <td colspan="2">&nbsp;${zdaxm.ztz }</td>
    </tr>
    <tr>
      <td height="25" style="width: 16%" align="center">开工日期</td>
      <td colspan="2">&nbsp;${zdaxm.kgn }年 ${zdaxm.kgy }月</td>
    </tr>
    <tr>
      <td width="100%" colspan="3" height="25" bgcolor="#FFCCCC" align="center">投资完成情况（单位：万元）</td>
    </tr>
    <tr>
      <td height="25" align="center">当月完成</td>
      <td align="center">当年累计完成</td>
      <td align="center">开工以来累计完成</td>
    </tr>
    <tr>
      <td height="25" align="center">
      		<input name="dywc" type="text" value="${zdaxmyb.bywc}" id="dywc" style="width:80px;" class="txtInput normal required" onkeyup="clearNoNum(this);dywcjs();" />
      		<input name="dywc2" type="hidden" value="${zdaxmyb.bywc}" id="dywc2" />
      	</td>
      <td align="center">
      	<span id="span_dnwc">${zdaxmyb.nczbywc }</span>
      	<input name="dnwc" type="hidden" value="${zdaxmyb.nczbywc}" id="dnwc" />
      	<input name="dnwc2" type="hidden" value="${zdaxmyb.nczbywc}" id="dnwc2" />
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
      <td width="100%" colspan="3" height="25" align="left">已完成工作节点</td>
    </tr>
    <tr>
      <td width="100%" colspan="3"><textarea name="wcgz" rows="2" cols="20" id="wcgz" style="font-family:宋体;height:80px;width:95%;" class="txtInput normal required">${zdaxmyb.wcgzjd}</textarea></td>
    </tr>
    <tr>
      <td width="100%" colspan="3" height="25" align="left">项目进展情况      </td>
    </tr>
    <tr>
      <td width="100%" colspan="3">
          <textarea name="jzqk" rows="2" cols="20" id="jzqk" style="font-family:宋体;height:80px;width:95%;" class="txtInput normal required">${zdaxmyb.xxjd}</textarea>
      </td>
    </tr>
    <tr>
      <td width="100%" colspan="3" height="25" align="left">存在问题</td>
    </tr>
    <tr>
      <td width="100%" colspan="3">
          <textarea name="czwt" rows="2" cols="20" id="czwt" style="font-family:宋体;height:80px;width:95%;" class="txtInput normal required">${zdaxmyb.czwt}</textarea>
      </td>
    </tr>
    
    <tr>
      <td width="100%" colspan="3" height="25" align="left">下月工作计划</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="3">
          <textarea name="gzjh" rows="2" cols="20" id="gzjh" style="font-family:宋体;height:80px;width:95%;" class="txtInput normal required">${zdaxmyb.gzjh}</textarea>
      </td>
    </tr>
    
    <tr>
      <td width="100%" colspan="3" height="25" align="left">备注</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="3">
          <textarea name="bz" rows="2" cols="20" id="bz" style="font-family:宋体;height:80px;width:95%;" class="txtInput normal required">${zdaxmyb.bz}</textarea>
      </td>
    </tr>
  </table>
  
  <div class="foot_btn_box">
  		<input type="hidden" id="zt" name="zt" value="" />
  		 <input  type="button" value="保存并上报"  onclick="saveup()" class="btnSubmit"/>&nbsp;&nbsp;
         <input  type="button" value="保 存"  onclick="save()" class="btnSubmit"/>&nbsp;&nbsp;
      <input  type="button" value="返 回"  onclick="back()" class="btnSubmit"/>    </div>
  </form>
  </body>
</html>
