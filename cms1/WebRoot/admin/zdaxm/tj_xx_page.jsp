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
<title>�ޱ����ĵ�</title>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<link rel="stylesheet" type="text/css" href="../images/style.css"/>
	<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script> 
    <script type="text/javascript" src="../js/function.js"></script>
    
    <script type="text/javascript" language="javascript">
    $(function(){
		var NowDate=new Date();
		var NowYear=NowDate.getFullYear();
		var outHtml="<option value='' selected>--��ѡ�����--</option>";
		for(var i=2010;i<=NowYear;i++){
			if(i<NowYear)
				{outHtml += "<option value='"+i+"'>"+i+"</option>";}
			else 
				{outHtml += "<option value='"+i+"'>"+i+"</option>";}
		}
        $("#nd").html(outHtml);
     });
     
           var lblist ;
       function lbchange(t){
          
           var lb2html ='<option value="" selected>--��ѡ����ҵС��--</option>'; 
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
       
       $(function(){
           
           var temp = $("#lblist").val() ;
           
           if(temp != ""){             
               lblist = eval(temp);  
               var lb1html ='<option value="" selected>--��ѡ����ҵ����--</option>';
              // var lb2html =""; 
               
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
	<form name="frm" id="frm" method="post" target="_blank" action="ZdaxmServlet?action=xxhzpage">
        <table border="1" align="center" cellSpacing="0" borderColorLight="#cccccc" borderColorDark="#ffffff" style="width:500px;">
            <tbody>
            <tr>
                <th height="30" align="left" bgcolor="#F4F4F4" style="width:85px;">�������</th>
                <td>
                    <select name="nd" class="select2" id="nd">
                    </select>
                </td>
            </tr>
            <tr>
                <th height="30" align="left" bgcolor="#F4F4F4">��ҵ����</th>
                <td>
                  <input id="lblist" value="${lblist }" type="hidden"/>
 				    <select name="lb1" id="lb1" onchange="lbchange(this)"; >
					</select>&nbsp;&nbsp;&nbsp;
					<select name="lb2" id="lb2"  >
					</select>
                </td>
            </tr>
            <tr>
                <th height="30" align="left" bgcolor="#F4F4F4">��������</th>
                <td>
                		<select name="dq"  >
                		<option value="">--��ѡ�����--</option>
					    <c:forEach  items="${dqlist}" var="item">
					        <option value="${item }">${item }</option>
					    </c:forEach>
					    </select>
                </td>
            </tr>
            <tr>
                <th height="30" align="left" bgcolor="#F4F4F4">��Ͷ��</th>
                <td>
                	<SELECT name="ztz1" id="ztz1" class="select2">
                      <OPTION value="" >ȫ��</OPTION>
                      <OPTION value="dydy" >���ڵ���</OPTION>
                      <OPTION value="dy" >����</OPTION>
                    </SELECT>
                      <INPUT name="ztz2" id="ztz2" value="" size="15" onkeyup="chearNoNum(this);" class="txtInput normal required" style="width:55px;"> ��Ԫ ��&nbsp;
                    <SELECT name="ztz3" id="ztz3" class="select2">
                      <OPTION value="" selected>ȫ��</OPTION>
                      <OPTION value="xy" >С��</OPTION>
                    </SELECT>
                    <INPUT name="ztz4" id="ztz4" value="" size="15" onkeyup="chearNoNum(this);" class="txtInput normal required" style="width:55px;"> ��Ԫ
                </td>
            </tr>
            <tr>
            	<td height="30" colSpan="2" align="center">
                	<input type="submit" value="ȷ ��" class="btnSearch"/>
                </td>
            </tr>
            </tbody>
        </table>
</form>
</body>
</html>
