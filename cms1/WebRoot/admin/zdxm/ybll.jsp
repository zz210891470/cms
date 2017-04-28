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
    <script type="text/javascript">
       function back(){
           window.parent.hideFrame();
       }
    
    </script>
  </head>
  <body class="mainbody" style="background:#FFFFFF;">
  	<form name="form" method="post" action="" id="form">
    <table width="95%" border="0" align="center" cellspacing="0">
			<tr>
			<td width="85%" height="30">
				<b><font color="#336699">龙岩市重点项目月信息报表  ${yf }月份</font></b>
			</td>
			</tr>
	  </table>
  <table border="1" width="100%"  align="center" cellspacing="0">
    <tr>
      <td height="25" style="width: 16%" align="center">项目名称</td>
      <td width="75%" colspan="5">&nbsp;${zdxm.mc }</td>
    </tr>
    <tr>
      <td height="50" style="width: 16%" align="center">建设规模及内容</td>
      <td width="75%" colspan="5" style=" padding:5px; line-height:1.5;">${zdxm.jsgm }</td>
    </tr>
    <tr>
      <td height="25" style="width: 16%" align="center">总投资（万元）</td>
      <td width="75%" colspan="5">&nbsp;${zdxm.ztz }</td>
    </tr>
    <tr>
      <td height="25" style="width: 16%" align="center">开工日期</td>
      <td width="75%" colspan="5">&nbsp;${zdxm.kgn }年${zdxm.kgy }月</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25" bgcolor="#FFCCCC">
        <p align="left">资金来源及到位情况（单位：万元）</p>
      </td>
    </tr>
    <tr>
      <td style="width: 16%" height="25" align="center">按投资来源渠道分</td>
      <td width="15%" align="center">总投资</td>
      <td width="14%" align="center">今年计划投资</td>
      <td width="15%" align="center">当月到位资金</td>
      <td width="15%" align="center">当年累计<br/>到位资金</td>
      <td width="19%" align="center">开工以来累计<br/>到位资金</td>
    </tr>
    <tr>
      <td align="center" style="width: 16%" height="25">业主自筹</td>
      <td width="15%" align="center">${zdxm.zjppzc }</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">${zdxmyb.dwzj1}</td>
      <td width="15%" align="center">${zdxmyb.dnljdw1}</td>
      <td width="15%" align="center">${zdxmyb.kgljdw1}</td>
    </tr>
    <tr>
      <td align="center" style="width: 16%" height="25">银行贷款</td>
      <td width="15%" align="center">${zdxm.zjppdk }</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">${zdxmyb.dwzj2}</td>
      <td width="15%" align="center">${zdxmyb.dnljdw2}</td>
      <td width="15%" align="center">${zdxmyb.kgljdw2}</td>
    </tr>
     <tr>
      <td align="center" style="width: 16%" height="25">政府投资</td>
      <td width="15%" align="center">${zdxm.zjppzf }</td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">${zdxmyb.dwzj3}</td>
      <td width="15%" align="center">${zdxmyb.dnljdw3}</td>
      <td width="15%" align="center">${zdxmyb.kgljdw3}</td>
    </tr>
    <tr>
      <td height="25" style="width: 16%" align="center">合&nbsp;&nbsp;&nbsp;计 </td>
      <td width="15%" align="center">${zdxm.ztz }</td>
      <td width="15%" align="center">${zdxm.jhtz }</td>
      <td width="15%" align="center">${zdxmyb.dwzjhj }</td>
      <td width="15%" align="center">${zdxmyb.dnljdwhj }</td>
      <td width="15%" align="center">${zdxmyb.kgljdwhj }</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25" bgcolor="#FFCCCC" align="center">投资完成情况（单位：万元）</td>
    </tr>
    <tr>
      <td width="40%" colspan="2" height="25" align="center">当月完成</td>
      <td width="30%" colspan="2" align="center">当年累计完成</td>
      <td width="30%" colspan="2" align="center">开工以来累计完成</td>
    </tr>
    <tr>
      <td width="40%" colspan="2" align="center" height="25">${zdxmyb.bywc}</td>
      <td width="30%" colspan="2" align="center">${zdxmyb.nczbywc}</td>
      <td width="30%" colspan="2" align="center">${zdxmyb.kgljwc}</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25" align="left">工程主线形象进度和已开展的主要工作      </td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="50" style="line-height:1.5; padding:5px;">${zdxmyb.xxjd}</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25" align="left">开工、竣工投产时间、内容及新增生产能力</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="50" style="line-height:1.5; padding:5px;">${zdxmyb.scnl}</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25" align="left">项目推进中存在的问题及拟采取的措施和办法
      </td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="50" style="line-height:1.5; padding:5px;">${zdxmyb.czwt}</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6" height="25" align="left">需要政府及有关部门协调解决的问题</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6" height="50" style="line-height:1.5; padding:5px;">${zdxmyb.xtjj}</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6" height="25" align="left">下个月（季度）工作计划、安排</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="50" style="line-height:1.5; padding:5px;">${zdxmyb.gzjh}</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25" align="left">参建单位新进场情况</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="50" style="line-height:1.5; padding:5px;">${zdxmyb.jcqk}</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25" align="left">资金说明（本年资金是否落实、到位资金是否满足建设需要或存在的其它资金问题）</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="50" style="line-height:1.5; padding:5px;">${zdxmyb.zjsm}</td>
    </tr>
  </table>
  <div class="foot_btn_box">
  		<input type="hidden" id="zt" name="zt" value="" />
         <input  type="button" value="返 回"  onclick="back()" class="btnSubmit"/>
    </div>
  </form>
  </body>
</html>