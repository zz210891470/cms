<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
<title>������������</title>
<link rel="stylesheet" type="text/css" href="../images/style.css"/>
<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script>  
<script type="text/javascript" src="../js/function.js"></script>


    <style>
    
    .showDiv{
        display:block;
        z-index:5;
        position:absolute;
        top:0;
        left:0;
        width:100%;
        height:auto;
    }
    
    .hideDiv{
        display:none;
    }
    
    </style>
    <script type="text/javascript">

        
        //ɾ���б��� ����ɾ��
        function del(i){
            $('#item'+i).attr("checked","true");
            document.all.pageform.action='<%=basePath%>admin/public/PeopleSuggestionServlet?act=deleteItems'; 
            document.all.pageform.submit(); 
        }
        
        //����ɾ���б���
        function delItems(){
            var num = 0;
            $("input[name='itemList']").each(function(){   
			    if($(this).attr("checked") != false){
	                num++; 
	            } 
			});
            
            if(num>0){
                if(confirm("ȷ��Ҫɾ��ѡ����?")){
		            document.all.pageform.action='<%=basePath%>admin/public/PeopleSuggestionServlet?act=deleteItems'; 
		            document.all.pageform.submit(); 
		        }
		    }else{
			    alert("������ѡ��һ��");
			}   
        }

        
        //��תҳ��
        function goPage(i){
        	$("#pageNo").val(i);
      	    document.all.pageform.action='<%=basePath%>admin/public/PeopleSuggestionServlet?act=list';
		    document.all.pageform.submit();    
        }
        
        //ָ��ҳ����ת
        function goThePage(){
            var pageNo = $("#pageNoTemp").val();
        	if( pageNo != "" && /^[0-9]*$/.test(pageNo) ){
			    if( pageNo > 0 && pageNo <= ${pager.pageCount} ) {  
			        $("#pageNo").val($("#pageNoTemp").val());
		      	    document.all.pageform.action='<%=basePath%>admin/public/PeopleSuggestionServlet?act=list';
				    document.all.pageform.submit();    		    
				}else{
                    alert("��������ȷ��ҳ�룡");
			    }
		    }else{
		            alert("���������֣�");
		    }
        }
        
        //����ҳ��
        function setPageSize(){
            var pageSize = $("#pageSizeTemp").val();
	        if( pageSize != "" && /^[0-9]*$/.test(pageSize) ){
	            $("#pageSize").val(pageSize);
	      	    document.all.pageform.action='<%=basePath%>admin/public/PeopleSuggestionServlet?act=list';
			    document.all.pageform.submit();
            }else{
		        alert("���������֣�");
		    }   
        }
        
        //��������
        function search(){
            $("#btnSearch").val($.trim($("#btnSearch").val()));
            document.all.pageform.action='<%=basePath%>admin/public/PeopleSuggestionServlet?act=list';
		    document.all.pageform.submit();  
        }
    </script>
</head>

<body class="mainbody">
   <form name="pageform"  method="post">
<div class="navigation">��ҳ &gt; ���ڲ������  &gt;  ������������</div>
 
    <div class="tools_box">
	    <div class="tools_bar">
	  <!--     <a href="javascript:add();" class="tools_btn"><span><b class="add">������</b></span></a>  --> 
		    <a href="javascript:void(0);" onclick="checkAll(this);" class="tools_btn"><span><b class="all">ȫѡ</b></span></a>
            <a href="javascript:delItems();"  id="btnDelete" class="tools_btn" href="javascript:__doPostBack('btnDelete','')"><span><b class="delete">����ɾ��</b></span></a>
        </div>
    </div>
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="msgtable">
      <tr>
         <th width="6%">ѡ��</th>
        <th width="8%"  align="left">����</th>
        <th width="20%" align="left">����</th>
        <th width="35%" align="left">����</th>
        <th width="15%" align="left">��ϵ��ʽ</th>
        <th width="10%" align="left">ʱ��</th>
<!--      <th width="6%">����</th>  -->  
      </tr>
     <c:forEach items="${pager.resultList}" var="item">
     <tr>
        <td align="center"><span class="checkall">
        <input id="rptList_ctl01_chkId" type="checkbox" name="itemList" value="${item.id}"/>
        </span></td>
       
        <td>${item.xm }</td>
        <td>${item.bt }</td>
        <td><a href="#" title="${item.nr }">${item.nr }</a></td>
        <td>${item.lxfs }</td>
        <td>${fn:substring(item.sj, 0, 10)}</td>
 <!--         <td align="center"><a href="PeopleSuggestionServlet?act=updatepage&id=${item.id}">�޸�</a></td>-->

      </tr>
     </c:forEach> 
	 </table>

	  <div class="line15"></div>
	<div class="page_box">
	      <div id="PageContent" class="flickr right">
		  <c:choose>
		   <c:when test="${pager.pageNo==1}">
	   		   <span class="disabled">��ҳ</span> 
			   <span class="disabled">��һҳ</span> 
		   </c:when> 
		   <c:otherwise> 
			  <a href="javascript:goPage(${pager.firstPageNo})">��ҳ</a>
		      <a href="javascript:goPage(${pager.prePageNo})">��һҳ</a> 
		   </c:otherwise>
		  </c:choose>
	      
	      <span class="current">${pager.pageNo}ҳ/${pager.pageCount}ҳ</span>
	      <c:choose>
		   <c:when test="${pager.pageNo==pager.pageCount}">
	   		   <span class="disabled">��һҳ</span> 
			   <span class="disabled">βҳ</span> 
		   </c:when> 
		   <c:otherwise> 
	           <a href="javascript:goPage(${pager.nextPageNo})">��һҳ</a>
	           <a href="javascript:goPage(${pager.lastPageNo})">βҳ</a>
		   </c:otherwise>
		  </c:choose>
		        &nbsp;&nbsp;
                           ��ת��<input type="text" id="pageNoTemp" name="pageNoTemp" value="${pager.pageNo }" size="3"/>
               <input type="hidden" id="pageNo" name="pageNo" value="${pager.pageNo }" />
           <a href="javascript:goThePage()" class="btnSearch">GO</a>
		  </div>
      
      	<div class="left">
                     ��ʾ<input  id="pageSizeTemp" name="pageSizeTemp" type="text" value="${pager.pageSize}"  class="txtInput2 small2" />��/ҳ
      	   <input  id="pageSize" name="pageSize" type="hidden" value="${pager.pageSize}"/>
      	<a href="javascript:setPageSize()" class="btnSearch">SET</a>
      	</div>

     </div>

     </form>

   


  </body>
</html>
