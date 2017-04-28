<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<link rel="stylesheet" type="text/css" href="../images/style.css"/>
	<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script> 
    <script type="text/javascript" src="../js/function.js"></script>
    
    <script type="text/javascript" language="javascript">
    // 年度
    $(function(){
		var NowDate=new Date();
		var NowYear=NowDate.getFullYear();
		// 报表年份
		var outHtml="<option value='' selected>--请选择年度--</option>";
		for(var i=2010;i<=NowYear;i++){
			if(i<NowYear)
				{outHtml += "<option value='"+i+"'>"+i+"</option>";}
			else 
				{outHtml += "<option value='"+i+"' selected>"+i+"</option>";}
		}
        $("#nd").html(outHtml);
        // 项目开工年份
        var kgYearHtml = "<option value=''> </option>";
        for(var i=2010;i<=NowYear;i++){
        	kgYearHtml += "<option value='"+i+"'>"+i+"</option>";
		}
        $("#kgFromNd").html(kgYearHtml);
        $("#kgToNd").html(kgYearHtml);
     	// 报表月份
        var monthHtml = "";
        for(var i=1; i<13; i++){
			monthHtml += "<option value='"+i+"'>"+i+"</option>";
        }
        $("#fromMonth").html(monthHtml);
        $("#toMonth").html(monthHtml);

    	// 项目开工月
        var kgMonthHtml = "<option value=''></option>" + monthHtml;
        $("#kgFromMonth").html(kgMonthHtml);
        $("#kgToMonth").html(kgMonthHtml);
     });
     
       var lblist ;
       // 行业类别小类
       function lbchange(t){
           var lb2html ='<option value="" selected>--请选择行业小类--</option>'; 
           for(var i=0;i<lblist.length; i++){
                if(lblist[i].mc==$(t).val()){
                    var tempid = lblist[i].id;
                    for(var j=0;j<lblist.length; j++){
                        if(tempid == lblist[j].pid){
                            lb2html += '<option value="'+lblist[j].mc+'">'+lblist[j].mc+'</option>';
                        }
                    }
                    $("#lb2").html(lb2html);
               }
           }
       }
       // 行业类别大类
       $(function(){
           var temp = $("#lblist").val() ;
           if(temp != ""){             
               lblist = eval(temp);  
               var lb1html ='<option value="" selected>--请选择行业大类--</option>';
               for(var i=0;i<lblist.length; i++){
                   if(lblist[i].pid==0){
                      lb1html += '<option value="'+lblist[i].mc+'">'+lblist[i].mc+'</option>';
                   }
               }
               $('#lb1').html(lb1html);
           }
       });
	</script>
      
</head>

<body class="mainbody">
	<form name="frm" id="frm" method="post" target="_blank" action="<%=basePath%>admin/zdxm/ZdxmServlet?action=ybxxhzpage">
        <table border="1" align="center" cellSpacing="0" borderColorLight="#cccccc" borderColorDark="#ffffff" style="width:500px;">
            <tbody>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4" style="width:85px;">报表年度</th>
                <td>
                    <select name="nd" class="select2" id="nd">
                    </select>&nbsp;年&nbsp;
                    <select name="fromMonth" id="fromMonth" class="select2" onclick="setMonth('fromMonth','toMonth');">
                    </select>&nbsp;月 &nbsp;至 &nbsp;
                    <select name="toMonth" id="toMonth" class="select2">
                    </select>&nbsp;月
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">行业分类</th>
                <td>
                  <input id="lblist" value="${lblist }" type="hidden"/>
 				    <select name="lb1" id="lb1" onchange="lbchange(this)"; >
					</select>&nbsp;&nbsp;&nbsp;
					<select name="lb2" id="lb2"  >
					</select>
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">所属地区</th>
                <td>
                		<select name="dq"  >
                		<option value="">--请选择地区--</option>
					    <c:forEach  items="${dqlist}" var="item">
					        <option value="${item }">${item }</option>
					    </c:forEach>
					    </select>
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">总投资</th>
                <td>
                	<SELECT name="ztz1" id="ztz1" class="select2">
                      <OPTION value="">全部</OPTION>
                      <OPTION value="dydy" >大于等于</OPTION>
                      <OPTION value="dy" >等于</OPTION>
                    </SELECT>
                      <INPUT name="ztz2" id="ztz2" value="" size="15" onkeyup="clearNoNum(this);" class="txtInput normal required" style="width:60px;"> 万元 且&nbsp;
                    <SELECT name="ztz3" id="ztz3" class="select2">
                      <OPTION value="" selected>全部</OPTION>
                      <OPTION value="xy">小于</OPTION>
                    </SELECT>
                    <INPUT name="ztz4" id="ztz4" value="" size="15" onkeyup="clearNoNum(this);" class="txtInput normal required" style="width:60px;"> 万元
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">上年完成投资</th>
                <td>
                	<SELECT name="wctz1" id="wctz1" class="select2">
                      <OPTION value="">全部</OPTION>
                      <OPTION value="dydy" >大于等于</OPTION>
                      <OPTION value="dy" >等于</OPTION>
                    </SELECT>
                      <INPUT name="wctz2" id="wctz2" value="" size="15" onkeyup="clearNoNum(this);" class="txtInput normal required" style="width:60px;"> 万元 且&nbsp;
                    <SELECT name="wctz3" id="wctz3" class="select2">
                      <OPTION value="" selected>全部</OPTION>
                      <OPTION value="xy">小于</OPTION>
                    </SELECT>
                    <INPUT name="wctz4" id="wctz4" value="" size="15" onkeyup="clearNoNum(this);" class="txtInput normal required" style="width:60px;"> 万元
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">本年计划投资</th>
                <td>
                	<SELECT name="jhtz1" id="jhtz1" class="select2">
                      <OPTION value="">全部</OPTION>
                      <OPTION value="dydy" >大于等于</OPTION>
                      <OPTION value="dy" >等于</OPTION>
                    </SELECT>
                      <INPUT name="jhtz2" id="jhtz2" value="" size="15" onkeyup="clearNoNum(this);" class="txtInput normal required" style="width:60px;"> 万元 且&nbsp;
                    <SELECT name="jhtz3" id="jhtz3" class="select2">
                      <OPTION value="" selected>全部</OPTION>
                      <OPTION value="xy" >小于</OPTION>
                    </SELECT>
                    <INPUT name="jhtz4" id="jhtz4" value="" size="15" onkeyup="clearNoNum(this);" class="txtInput normal required" style="width:60px;"> 万元
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">完成年度计划</th>
                <td>
                	<SELECT name="wcjhtz1" id="wcjhtz1" class="select2">
                      <OPTION value="">全部</OPTION>
                      <OPTION value="dydy" >大于等于</OPTION>
                      <OPTION value="dy" >等于</OPTION>
                    </SELECT>
                      <INPUT name="wcjhtz2" id="wcjhtz2" value="" size="15" onkeyup="clearNoNum(this);" class="txtInput normal required" style="width:60px;"> % &nbsp;&nbsp;&nbsp;且&nbsp;
                    <SELECT name="wcjhtz3" id="wcjhtz3" class="select2">
                      <OPTION value="" selected>全部</OPTION>
                      <OPTION value="xy" >小于</OPTION>
                    </SELECT>
                    <INPUT name="wcjhtz4" id="wcjhtz4" value="" size="15" onkeyup="clearNoNum(this);" class="txtInput normal required" style="width:60px;"> %
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">生产性项目</th>
                <td>
                	<INPUT value="" type="radio" name="sfscx" checked>全部　
                    <INPUT value="是" type="radio" name="sfscx" >是　
                    <INPUT value="否" type="radio" name="sfscx" >否 
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">重中之重项目</th>
                <td>
                	<INPUT value="" type="radio" name="sfzz" checked>全部　
                    <INPUT value="是" type="radio" name="sfzz" >是　
                    <INPUT value="否" type="radio" name="sfzz" >否
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">省属重点项目</th>
                <td>
                	<INPUT value="" type="radio" name="sfss" checked>全部　
                    <INPUT value="是" type="radio" name="sfss" >是　
                    <INPUT value="否" type="radio" name="sfss" >否
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">资源型项目 </th>
                <td>
                	<INPUT value="" type="radio" name="sfzy" checked>全部　
                    <INPUT value="是" type="radio" name="sfzy" >是　
                    <INPUT value="否" type="radio" name="sfzy" >否
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">产业分类 </th>
                <td>
                	<SELECT name="sjslb" class="select2">
                      <OPTION value="">全部</OPTION>
                      <OPTION value="机械" >机械</OPTION>
                      <OPTION value="有色金属" >有色金属</OPTION>
                      <OPTION value="烟草" >烟草</OPTION>
                      <OPTION value="能源精化" >能源精化</OPTION>
                      <OPTION value="纺织" >纺织</OPTION>
                      <OPTION value="建材" >建材</OPTION>                    
                      <OPTION value="光电新材料" >光电新材料</OPTION>
                      <OPTION value="不锈钢及特钢" >不锈钢及特钢</OPTION>
                      <OPTION value="农产品加工" >农产品加工</OPTION>
                      <OPTION value="商贸物流" >商贸物流</OPTION>
                      <OPTION value="旅游及文化创意" >旅游及文化创意</OPTION>
                      <OPTION value="电子商务" >电子商务</OPTION>
                  </SELECT>
              </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4">项目投资主体</th>
                <td>
                	<SELECT id="tzzt" name="tzztxz" class="select2">
                      <OPTION value="">全部</OPTION>
                      <OPTION value="国有独资" >国有独资</OPTION>
                      <OPTION value="国有控股与外资合资" >国有控股与外资合资</OPTION>
                      <OPTION value="国有控股与民营合资" >国有控股与民营合资</OPTION>
                      <OPTION value="民营独资" >民营独资</OPTION>
                      <OPTION value="民营控股与外资合资" >民营控股与外资合资</OPTION>
                      <OPTION value="民营控股与国有合资" >民营控股与国有合资</OPTION>
                      <OPTION value="外资独资" >外资独资</OPTION>
                      <OPTION value="外资控股与国有合资" >外资控股与国有合资</OPTION>
                      <OPTION value="外资控股与民营合资" >外资控股与民营合资</OPTION>
                      <OPTION value="其他" >其他</OPTION>
                  </SELECT>
                </td>
            </tr>
            <tr>
                <th height="25" align="left" bgcolor="#F4F4F4" style="width:85px;">项目开工时间</th>
                <td>
                    <select name="kgFromNd" class="select2" id="kgFromNd">
                    </select>&nbsp;年&nbsp;
                    <select name="kgFromMonth" id="kgFromMonth" class="select2">
                    </select>&nbsp;月 &nbsp;至 &nbsp;<select name="kgToNd" class="select2" id="kgToNd"></select>&nbsp;年&nbsp;
                    <select name="kgToMonth" id="kgToMonth" class="select2">
                    </select>&nbsp;月
                </td>
            </tr>
            <tr>
            	<td height="30" colSpan="2" align="center">
                	<input type="submit" value="确 定" class="btnSearch" />
                </td>
            </tr>
            </tbody>
        </table>
</form>
</body>
</html>
