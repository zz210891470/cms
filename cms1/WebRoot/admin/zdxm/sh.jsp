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
	$(function(){
        //��Ŀ���
        var NowDate=new Date();
        var NowYear=NowDate.getFullYear();
        var outYearHtml="";
        var nd = '${nd}';
    	for(var  i = NowYear ; i >= 2000; i--){
			if(i <= NowYear && i != nd ){
				outYearHtml += "<option value='"+i+"'>"+i+"</option>";
			}else if(i == nd ){
				outYearHtml += "<option value='"+i+"' selected>"+i+"</option>";
			}
		}
        $("#nd").html(outYearHtml);
        
        // ��Ŀ���
        var lb = '${xmlb}';
        var outLbHtml="";
        if(lb=='' || lb=='�ڽ�'){
        	outLbHtml += "<option value='�ڽ�' selected>�ڽ�</option>";
        	outLbHtml += "<option value='Ԥ��'>Ԥ��</option>";
        	outLbHtml += "<option value='ǰ��'>ǰ��</option>";
        }else if(lb=='Ԥ��' ){
        	outLbHtml += "<option value='�ڽ�'>�ڽ�</option>";
        	outLbHtml += "<option value='Ԥ��' selected>Ԥ��</option>";
        	outLbHtml += "<option value='ǰ��'>ǰ��</option>";
        }else if(lb=='ǰ��' ){
        	outLbHtml += "<option value='�ڽ�'>�ڽ�</option>";
        	outLbHtml += "<option value='Ԥ��'>Ԥ��</option>";
        	outLbHtml += "<option value='ǰ��' selected>ǰ��</option>";
		}
        $("#lb").html(outLbHtml);
    });
		//�༭�б���
	    function edit(i){
	        $("#theFrame").attr("src","<%=basePath%>admin/zdxm/ZdxmServlet?action=toEdit&id="+i);
	        $("#frameDiv").removeClass("hideDiv");
	        $("#frameDiv").addClass("showDiv");
	    }
	    
	    //�����б���
	    function audit(i){
	        $("#theFrame").attr("src","<%=basePath%>admin/zdxm/ZdxmServlet?action=toAudit&id="+i);
	        $("#frameDiv").removeClass("hideDiv");
	        $("#frameDiv").addClass("showDiv");
	    }
	    
	    //post�ύˢ��ҳ�� ����editFrame
	    function hideEditFrame(){
	        document.all.pageform.submit();
	    }
	    
	    //getˢ��ҳ�� ����addFrame
	    function hideAddFrame(){
	         document.location.href='<%=basePath%>admin/zdxm/ZdxmServlet?action=audit';
	    }
	
	    //�����ӿ��
	    function hideFrame(){
	        $("#frameDiv").removeClass("showDiv");
	        $("#frameDiv").addClass("hideDiv");
	    }
	
	    
	    //��תҳ��
	    function goPage(i){
	    	$("#pageNo").val(i);
	  	    document.all.pageform.action='<%=basePath%>admin/zdxm/ZdxmServlet?action=audit';
		    document.all.pageform.submit();    
	    }
	    
	    //ָ��ҳ����ת
	    function goThePage(){
	        var pageNo = $("#pageNoTemp").val();
	    	if( pageNo != "" && /^[0-9]*$/.test(pageNo) ){
			    if( pageNo > 0 && pageNo <= ${pager.pageCount} ) {  
			        $("#pageNo").val($("#pageNoTemp").val());
		      	    document.all.pageform.action='<%=basePath%>admin/zdxm/ZdxmServlet?action=audit';
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
	      	    document.all.pageform.action='<%=basePath%>admin/zdxm/ZdxmServlet?action=audit';
			    document.all.pageform.submit();
	        }else{
		        alert("���������֣�");
		    }   
	    }
	    
	    //��������
	    function search(){
	        $("#btnSearch").val($.trim($("#btnSearch").val()));
	        document.all.pageform.action='<%=basePath%>admin/zdxm/ZdxmServlet?action=auditSearch';
		    document.all.pageform.submit();  
	    }
	    
	</script>
  </head>
  <body class="mainbody">
  	<form name="pageform" method="post" action="" id="pageform">
    	<div class="navigation">��ҳ &gt; �ص���Ŀ���� &gt; �ص���Ŀ��Ϣ���</div>
    	<div class="tools_box">
	    <div class="tools_bar">
            <div class="search_box">
			       ��Ŀ���<select name="lb" id="lb" class="select2" ></select> 
                                    ��Ŀ��ݣ�<select name="nd" id="nd" class="select2" ></select>
			    ��Ŀ���ƣ�<input name="searchStr" name="searchStr" type="text" id="txtKeywords" class="txtInput" value="${searchStr }"/>
                <input type="button" onclick="search()"  value="�� ��" id="btnSearch" class="btnSearch" />
		    </div>

        </div>
        </div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="msgtable">
			<tr>
			  <th align="left">��Ŀ���</th>
			  <th align="left">��Ŀ���</th>
			  <th align="left">��Ŀ����</th>
			  <th width="120" align="left">��Ͷ��(��Ԫ)</th>
			  <th width="120" align="left">�ƻ�Ͷ��(��Ԫ)</th>
			  <th width="80" align="left">��������</th>
			  <th width="80" align="left">��������</th>
			  <th width="80">����</th>
			</tr>
			<c:forEach items="${pager.resultList}" var="item">
		     <tr>       
		        <td>${item.nd }</td>
		        <td>${item.bh }</td>
		        <td><a href="javascript:edit(${item.id })">${item.mc }</a></td>
		        <td>${item.ztz }</td>
		        <td>${item.jhtz }</td>
		        <td align="center">${item.dq}</td>
		        <td>${item.jsnx1 }-${item.jsnx2 }</td>
		        <td align="center">
		          <a href="javascript:edit(${item.id })" >�޸�</a>
		          <a href="javascript:audit(${item.id })" >���</a></td>
		      </tr>
		    </c:forEach>
		</table>
    	
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
    <div id="frameDiv" class="hideFrame" >
      
          <iframe  src="" width="100%" height="1000px" scrolling="auto" frameborder="0" name="theFrame" id="theFrame"></iframe>
      
      </div>
    </form>
  </body>
</html>