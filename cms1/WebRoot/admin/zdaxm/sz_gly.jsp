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
		<link href="<%=basePath%>admin/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />  
		<script src="<%=basePath%>admin/lib/ligerUI/js/core/base.js" type="text/javascript"></script>
	    <script src="<%=basePath%>admin/lib/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
	    <script src="<%=basePath%>admin/lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	    <script src="<%=basePath%>admin/lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
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
        //--------
        //�༭�б���
        //--------
        function edit(i){
            $("#theFrame").attr("src","<%=basePath%>admin/ManageServlet?action=toEdit&lx=zda&id="+i);
            doShow("frameDiv");
            doHide("listDiv");
        }
        
        //����б���
        function add(){
            $("#theFrame").attr("src","<%=basePath%>admin/ManageServlet?action=toAdd&lx=zda");
            doShow("frameDiv");
            doHide("listDiv");
            
        }
     	// ��ʾ
        function doShow(_showId){
			var showObj = document.getElementById(_showId);
			showObj.className = "showDiv";
        }
        // ����
        function doHide(_hideId){
        	var hideObj = document.getElementById(_hideId);
        	hideObj.className = "hideDiv";
        }
        //post�ύˢ��ҳ�� ����editFrame
        function hideEditFrame(){
            document.all.pageform.submit();
        }
        
        //getˢ��ҳ�� ����addFrame
        function hideAddFrame(){
             document.location.href='<%=basePath%>admin/ManageServlet?action=list&lx=zda';
        }
    
        //�����ӿ��
        function hideFrame(){
        	doShow("listDiv");
            doHide("frameDiv");
        }
        
        //ɾ���б��� ����ɾ��
        function del(i){
            $('#item'+i).attr("checked","true");
            document.all.pageform.action='<%=basePath%>admin/ManageServlet?action=del&lx=zda'; 
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
		            document.all.pageform.action='<%=basePath%>admin/ManageServlet?action=del&lx=zda'; 
		            document.all.pageform.submit(); 
		        }
		    }else{
			    alert("������ѡ��һ��");
			}   
        }

        
        //��תҳ��
        function goPage(i){
        	$("#pageNo").val(i);
      	    document.all.pageform.action='<%=basePath%>admin/ManageServlet?action=list&lx=zda';
		    document.all.pageform.submit();    
        }
        
        //ָ��ҳ����ת
        function goThePage(){
            var pageNo = $("#pageNoTemp").val();
        	if( pageNo != "" && /^[0-9]*$/.test(pageNo) ){
			    if( pageNo > 0 && pageNo <= ${pager.pageCount} ) {  
			        $("#pageNo").val($("#pageNoTemp").val());
		      	    document.all.pageform.action='<%=basePath%>admin/ManageServlet?action=list&lx=zda';
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
	      	    document.all.pageform.action='<%=basePath%>admin/ManageServlet?action=list&lx=zda';
			    document.all.pageform.submit();
            }else{
		        alert("���������֣�");
		    }   
        }
        
        //��������
        function search(){
            $("#btnSearch").val($.trim($("#btnSearch").val()));
            document.all.pageform.action='<%=basePath%>admin/ManageServlet?action=list&lx=zda';
		    document.all.pageform.submit();  
        }
    </script>
		
    </head>
  <body class="mainbody">
  	<form name="pageform" method="post" action="" id="form">
  		<div id="listDiv">
    	<div class="navigation">��ҳ &gt; �ش���Ŀ���� &gt; ��Ŀ�±��ϱ��û�����</div>
    	
    	<div class="tools_box">
	    <div class="tools_bar">
            <div class="search_box">
			    <input name="searchStr" name="searchStr" type="text" id="txtKeywords" class="txtInput" value="${searchStr }"/>
                <input type="button" onclick="search()"  value="�� ��" id="btnSearch" class="btnSearch" />
		    </div>
            <a href="javascript:add()" class="tools_btn"><span><b class="add">����û�</b></span></a>
		    <a href="javascript:void(0);" onclick="checkAll(this);" class="tools_btn"><span><b class="all">ȫѡ</b></span></a>
            <a href="javascript:delItems();"  id="btnDelete" class="tools_btn" ><span><b class="delete">����ɾ��</b></span></a>
        </div>
        </div>
    	
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="msgtable">
			<tr>
			  <th width="30">ѡ��</th>
			  <th align="left">�û���</th>
			  <th width="80" align="left">����</th>
			  <th width="80">����</th>
			</tr>
			
			<c:forEach items="${pager.resultList}" var="item">
		     <tr>
		        <td align="center"><span class="checkall">
		        <input type="checkbox" name="itemList" value="${item.id}"/>
		        </span></td>	       
		        <td><a href="javascript:edit(${item.id })">${item.yhm }</a></td>
		        <td>${item.xm }</td>
		        <td align="center">
		          <a href="javascript:edit(${item.id })" class="btnSearch">�޸�</a></td>
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
	</div>
      <div id="frameDiv" class="hideFrame" >
      
          <iframe  src="" width="100%" height="900px" scrolling="auto" frameborder="0" name="theFrame" id="theFrame"></iframe>
      
      </div>
      
    </form>
    </body>
</html>