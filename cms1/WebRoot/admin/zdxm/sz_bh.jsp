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
           alert("����ɹ���");
        }
        var userList= $("#userList").val();
        if("" != userList){
          
            var userdata = eval(userList);   
            $("input[name='sbyh']").bigAutocomplete({width : "250px",
                                                     data  : userdata});
        }

        
    });
    
    $(function(){
        //��Ŀ���
        var NowDate=new Date();
        var NowYear=NowDate.getFullYear();
        var outYearHtml="";
        var nd = '${nd}';
    	for(var  i = NowYear ; i >= 2013; i--){
			if(i <= NowYear && i != nd ){
				outYearHtml += "<option value='"+i+"'>"+i+"</option>";
			}else if(i == nd ){
				outYearHtml += "<option value='"+i+"' selected>"+i+"</option>";
			}
		}
        $("#nd").html(outYearHtml);
    });
    function singlesave(id){
        var bhVal = $("#"+id+"_bh").val();  // ��Ŀ���
    	var sbyhVal = $("#"+id+"_sbyh").val(); // �ϱ��û�
        $.post("<%=basePath%>admin/NumberServlet?act=singlesave&lx=zd&id="+id+"&bh="+bhVal+"&sbyh="+sbyhVal,function(data){
           if(data=="ok"){
               
               alert("����ɹ�!");
           }else{
               alert("����ʧ�ܣ��������缰�����ʽ��");
           }   
        });
    
    }
    
    function tofresh(){
        document.all.listform.action="<%=basePath%>admin/NumberServlet?act=search&lx=zd";
        document.all.listform.submit();
    }
    
    function search(){
        
        document.all.listform.action="<%=basePath%>admin/NumberServlet?act=search&lx=zd";
        document.all.listform.submit();
    }
    
    
    function save(){
        document.all.listform.action="<%=basePath%>admin/NumberServlet?act=update&lx=zd";
        document.all.listform.submit();
		
	}
    </script>
  </head>
  <body class="mainbody">
    <form action="" name="listform" method="post">
   	<div class="select_box">
   	    <input  type="hidden" value="${status }" id="status"/>
   		��Ŀ��ȣ�<select name="nd" id="nd">
   		
   		 </select>
           ��Ŀ����/��ţ�<input name="searchstr" id="searchstr" type="text" value="${searchstr }" maxlength="100"  class="txtInput normal required" style="width:150px;" />
   		<input type="button" name="btnSearch" onclick="search();" value="�� ѯ"      id="btnSearch" class="btnSearch" />&nbsp;&nbsp;
        <input type="button" name="btnSearch" onclick="save();"   value="���������޸�" id="btnSearch" class="btnSearch"  />
        <span style="float:right;"><a href="javascript:tofresh();" target="_self">ˢ��</a></span>
   	</div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="msgtable">
		<tr>
          <th align="center" style="width:60px;">���</th>
		  <th align="center">��Ŀ����</th>
		  <th align="center" style="width:100px;">��Ŀ���</th>
		  <th align="center" style="width:120px;">�ϱ��û�</th>
	      <th align="center" style="width:80px;">����</th>  	
		</tr>
			<c:forEach items="${resultList}" var="item">
		     <tr>
		     	<td height="24" align="center">${item.nd }</td>
	            <td align="left">${item.mc }</td>
				<td align="center">
				    <input name="idlist" type="hidden" value="${item.id }"/>
	            	<input id="${item.id}_bh" name="pronum" type="text"   value="${item.bh }" maxlength="10" onkeyup="clearNoNum(this)"  class="txtInput normal required" style="width:100px;" />
	            </td>
	            <td align="center">
	            	<input id="${item.id}_sbyh" name="sbyh"   type="text"   value="${item.sbyh }" maxlength="30" class="txtInput normal required" style="width:140px;" />
	            </td>
    	    	<td align="center">
					<a  target="_self"  onclick="singlesave(${item.id });" href="#">����</a>
				</td>  	
		      </tr>
		    </c:forEach>  
		
	</table>
	</form>
	<input id="userList" type="hidden" value="${userList }"/>
  </body>
</html>