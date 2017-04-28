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
	    <style>
	    body{
	        background-color:#ffffff;
	    }
	</style>
	<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script>  
	<script type="text/javascript" src="../js/function.js"></script>
    <script type="text/javascript">
       function save(){
           $("#form").submit();
       }
       
       function back(){
           window.parent.hideFrame();
       }
    
    </script>
  </head>
  <body class="mainbody">
  	<form name="form" method="post" action="ZdxmSbyhServlet?action=addyb" id="form">
  	
  	<input type="hidden" value="${yf }" name="yf"/>
  	<input type="hidden" value="${id }" name="id"/>
    <table width="95%" border="0" align="center" cellspacing="0">
			<tr>
			<td width="85%" height="30">
			<p align="center"><b><font color="#336699">龙岩市重点项目月信息报表   
                <span>${yf }月份</span></font></b></td>
			</tr>
	  </table>
  <table border="1" width="100%"  align="center" cellspacing="0">
    <tr>
      <td height="30" style="width: 16%">
        <p align="center">项目名称</p>
      </td>
      <td width="75%" colspan="5">&nbsp;${zdxm.mc }</td>
    </tr>
    <tr>
      <td height="30" style="width: 16%">
        <p align="center">建设规模及内容</p>
      </td>
      <td width="75%" colspan="5" style=" padding:5px; line-height:1.5;">${zdxm.jsgm }</td>
    </tr>
    <tr>
      <td height="30" style="width: 16%">
        <p align="center">总投资（万元）</p>
      </td>
      <td width="75%" colspan="5">&nbsp;${zdxm.ztz }</td>
    </tr>
    <tr>
      <td height="30" style="width: 16%">
        <p align="center">开工日期</p>
      </td>
      <td width="75%" colspan="5">&nbsp;${zdxm.kgn } ${zdxm.kgy }</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="30" bgcolor="#FFCCCC">
        <p align="left">资金来源及到位情况（单位：万元）</p>
      </td>
    </tr>
    <tr>
      <td style="width: 16%" height="28">
        <p align="center">按投资来源渠道分</p>
      </td>
      <td width="15%">
        <p align="center">总投资</p>
      </td>
      <td width="14%">
        <p align="center">今年计划投资</p>
      </td>
      <td width="15%">
        <p align="center">当月到位资金</p>
      </td>
      <td width="15%">
        <p align="center">当年累计到位资金</p>
      </td>
      <td width="19%" align="center">开工以来累计到位资金</td>
    </tr>
    <tr>
      <td align="center" style="width: 16%" height="28">
          业主自筹</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">
          <input name="dwzj" type="text" value="0" id="dwzj" style="width:80px;" class="txtInput normal required" />
      </td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center"><input name="kgdwzj" type="text" value="0" id="kgdwzj" style="width:80px;" class="txtInput normal required" /></td>
    </tr>
    
    <tr>
      <td align="center" style="width: 16%" height="28">
          银行贷款</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">
          <input name="dwzj1" type="text" value="0" id="dwzj1" style="width:80px;" class="txtInput normal required" />
      </td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center"><input name="kgdwzj1" type="text" value="0" id="kgdwzj1" style="width:80px;" class="txtInput normal required" /></td>
    </tr>
 
     <tr>
      <td align="center" style="width: 16%" height="28">
          政府投资</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">
          <input name="dwzj2" type="text" value="0" id="dwzj2" style="width:80px;" class="txtInput normal required" />
       </td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center"><input name="kgdwzj" type="text" value="0" id="kgdwzj" style="width:80px;" class="txtInput normal required" /></td>
    </tr>
 
    <tr>
      <td height="28" style="width: 16%">
        <p align="center">合&nbsp;&nbsp;&nbsp; 计</p>
      </td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">&nbsp;</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="30" bgcolor="#FFCCCC">
        <p align="left">投资完成情况（单位：万元）</p>
      </td>
    </tr>
    <tr>
      <td width="40%" colspan="2" height="30">
        <p align="center">当月完成</p>
      </td>
      <td width="30%" colspan="2">
        <p align="center">当年累计完成</p>
      </td>
      <td width="30%" colspan="2">
        <p align="center">开工以来累计完成</p>
      </td>
    </tr>
    <tr>
      <td width="40%" colspan="2" align="center"><input name="dywc" type="text" value="0" id="dywc" style="width:80px;" class="txtInput normal required" /></td>
      <td width="30%" colspan="2" align="center">&nbsp;</td>
      <td width="30%" colspan="2" align="center">&nbsp;</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25">
        <p align="left">工程主线形象进度和已开展的主要工作</p>
      </td>
    </tr>
    <tr>
      <td width="100%" colspan="6">
          <textarea name="jdgz" rows="2" cols="20" id="jdgz" style="font-family:宋体;height:80px;width:100%;" class="txtInput normal required"></textarea>
      </td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25">
        <p align="left">开工、竣工投产时间、内容及新增生产能力</td>
    </tr>
    <tr>
      <td width="100%" colspan="6">
          <textarea name="scnl" rows="2" cols="20" id="scnl" style="font-family:宋体;height:80px;width:100%;" class="txtInput normal required"></textarea>
      </td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25">
        <p align="left">项目推进中存在的问题及拟采取的措施和办法</p>
      </td>
    </tr>
    <tr>
      <td width="100%" colspan="6">
          <textarea name="czwt" rows="2" cols="20" id="czwt" style="font-family:宋体;height:80px;width:100%;" class="txtInput normal required"></textarea>
      </td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6" height="25">
        <p align="left">需要政府及有关部门协调解决的问题</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6">
          <textarea name="zfjj" rows="2" cols="20" id="zfjj" style="font-family:宋体;height:80px;width:100%;" class="txtInput normal required"></textarea>
      </td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6" height="25">
        <p align="left">下个月（季度）工作计划、安排</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6">
          <textarea name="xyjh" rows="2" cols="20" id="xyjh" style="font-family:宋体;height:80px;width:100%;" class="txtInput normal required"></textarea>
      </td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6" height="25">
        <p align="left">参建单位新进场情况</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6">
          <textarea name="jcqk" rows="2" cols="20" id="jcqk" style="font-family:宋体;height:80px;width:100%;" class="txtInput normal required"></textarea>
      </td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6" height="25">
        <p align="left">资金说明（本年资金是否落实、到位资金是否满足建设需要或存在的其它资金问题）</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6">
          <textarea name="zjhs" rows="2" cols="20" id="zjhs" style="font-family:宋体;height:80px;width:100%;" class="txtInput normal required"></textarea>
      </td>
    </tr>
    
  </table>
  
  <div class="foot_btn_box">
         <input  type="button" value="保存"  onclick="save()" class="btnSubmit"/>
         <input  type="button" value="返回"  onclick="back()" class="btnSubmit"/>
    </div>
  </form>
  </body>
</html>
