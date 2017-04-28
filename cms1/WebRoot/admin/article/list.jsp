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
<title>��Ŀ����</title>
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
      
         
                  //       <input type="button" name="btnSearch" value="�� ��" onclick="dosearch();" id="btnSearch" class="btnSearch" />
      function dosearch(){
         $("#pageNo").val("1");
         document.all.pageform.action='<%=basePath%>admin/article/ArticleServlet?act=list';
         document.all.pageform.submit();
      }
      
        function listrelease(i){
            document.all.pageform.action='<%=basePath%>admin/article/ArticleServlet?act=listrelease&id='+i;     
			document.all.pageform.submit();   
        
        }
      
        //�༭�б���
        function edit(i){
            $("#theFrame").attr("src","<%=basePath%>admin/article/ArticleServlet?act=updatepage&id="+i);
            $("#frameDiv").removeClass("hideDiv");
            $("#frameDiv").addClass("showDiv");
        }
        
                
        //post�ύˢ��ҳ�� ����editFrame
        function hideEditFrame(){
            document.all.pageform.submit();
        }
        
        //getˢ��ҳ�� ����addFrame
        function hideAddFrame(){
            window.location.reload(true);
        }
            //�����ӿ��
        function hideFrameR(){
            $("#frameDiv").removeClass("showDiv");
            $("#frameDiv").addClass("hideDiv");
            window.location.reload(true);
        }
    
        //�����ӿ��
        function hideFrame(){
            $("#frameDiv").removeClass("showDiv");
            $("#frameDiv").addClass("hideDiv");
            window.location.reload(true);
        }

        function recycle(){
            var pid = $("#pid").val();
        
        	$("#theFrame").attr("src",'<%=basePath%>admin/article/ArticleServlet?act=recyclepage&pid='+pid);
            $("#frameDiv").removeClass("hideDiv");
            $("#frameDiv").addClass("showDiv"); 
        }
      function add(){
		    $("#theFrame").attr("src",'<%=basePath%>admin/article/ArticleServlet?act=addpage&pid='+$('#pid').val());
            $("#frameDiv").removeClass("hideDiv");
            $("#frameDiv").addClass("showDiv");  
      }
      
      function gopage(i){   
      	document.all.pageform.action='<%=basePath%>admin/article/ArticleServlet?act=list&pageNo='+i;
		document.all.pageform.submit(); 
      }
      
              //����ҳ��
        function setPageSize(){
            var pageSize = $("#pageSizeTemp").val();
	        if( pageSize != "" && /^[0-9]*$/.test(pageSize) ){
	            $("#pageSize").val(pageSize);
	      	    document.all.pageform.action='<%=basePath%>admin/article/ArticleServlet?act=list';
			    document.all.pageform.submit();
            }else{
		        alert("���������֣�");
		    }   
        }
         //ָ��ҳ����ת
        function goThePage(){
            var pageNo = $("#pageNoTemp").val();
        	if( pageNo != "" && /^[0-9]*$/.test(pageNo) ){
			    if( pageNo > 0 && pageNo <= ${pager.pageCount} ) {  
			        $("#pageNo").val($("#pageNoTemp").val());
                document.all.pageform.action='<%=basePath%>admin/article/ArticleServlet?act=list';
			    document.all.pageform.submit();   		    
				}else{
                    alert("��������ȷ��ҳ�룡");
			    }
		    }else{
		            alert("���������֣�");
		    }
        }
 
      
      function onDelete(){
           
            var num = 0;
            $("input[name='itemList']").each(function(){   
          
			     if($(this).attr("checked") != false){
	                 num++; 
	             } 
			});
            
             if(num>0){
                 if(confirm("ȷ��Ҫɾ��ѡ����?")){
	                 
			         document.all.pageform.action='<%=basePath%>admin/article/ArticleServlet?act=deleteItems';     
				     document.all.pageform.submit();   
			     }
		     }else{
			     alert("������ѡ��һ��");
			 }
      }
      

      
   /*  $(function(){

        
	    $('#txtPageNum').keypress(function (e) {
	    var keycode;
		if (navigator.appName == "Microsoft Internet Explorer") {  // IE
			key = e.keyCode;
		} else {             // Netscape/Firefox/Opera
			key = e.which;
		}

	    if (key == 13) {
	       var pagesize=$('#txtPageNum').val();      
      	   document.all.pageform.action='<%=basePath%>admin/article/ArticleServlet?act=list&pageNo=1&pageSize='+pagesize;
		   document.all.pageform.submit(); 
	    }
	    });

	 }); */
      </script>
</head>

<body class="mainbody">
<form name="pageform"   method="post">
   	<div class="navigation">��ҳ &gt; ���¹��� &gt; �����б�</div>
    <div class="tools_box">
	    <div class="tools_bar">
            <div class="search_box">
			    <input name="search" type="text" id="txtKeywords" class="txtInput" value="${search }"/>
              <input type="button" name="btnSearch" value="�� ��" onclick="dosearch();" id="btnSearch" class="btnSearch" />
		    </div>
            <a href="javascript:add()" class="tools_btn"><span><b class="add">�������</b></span></a>
		    <a href="javascript:void(0);" onclick="checkAll(this);" class="tools_btn"><span><b class="all">ȫѡ</b></span></a>
            <a href="javascript:onDelete();"  id="btnDelete" class="tools_btn" ><span><b class="delete">����ɾ��</b></span></a>
            <a href="javascript:recycle()" class="tools_btn"><span><b class="send">����վ</b></span></a>
        </div>
    </div>
   
   
   	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="msgtable">
      <tr>
        <th width="6%">ѡ��</th>
        <th width="40%" align="left">����</th>
        <th width="10%" align="left">������</th>
        <th width="8%" align="left">״̬</th>
        <th width="15%" align="left">����ʱ��</th>
        <th width="8%" align="left">��Դ</th>
        <th width="13%">����</th>
      </tr>
    
     <c:forEach items="${pager.resultList}" var="item">
     <tr>
        <td align="center"><span class="checkall">
        <input id="rptList_ctl01_chkId" type="checkbox" name="itemList" value="${item.id}"/>
        </span></td>
       
        <td><a href="javascript:edit(${item.id })">${item.bt }</a></td>
        <td>${item.fbr }</td>
        <td>${item.zt }</td>
        
        <td >${item.rq} </td>
        <td align="center">${item.ly }</td>
        <td align="center">
          <c:if test="${fn:contains(sessionScope.qx,'shfb')&&item.zt=='�ݸ�'}">
              <a href="javascript:listrelease(${item.id })" >����</a>&nbsp;
          </c:if>
        
          <a href="javascript:edit(${item.id })" >�޸�</a></td>
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
		  <a href="javascript:gopage(${pager.firstPageNo})">��ҳ</a>
	      <a href="javascript:gopage(${pager.prePageNo})">��һҳ</a> 
	   </c:otherwise>
	  </c:choose>
      
      <span class="current">${pager.pageNo}ҳ/${pager.pageCount}ҳ</span>
      <c:choose>
	   <c:when test="${pager.pageNo==pager.pageCount||pager.pageCount==0}">
   		   <span class="disabled">��һҳ</span> 
		   <span class="disabled">βҳ</span> 
	   </c:when> 
	   <c:otherwise> 
           <a href="javascript:gopage(${pager.nextPageNo})">��һҳ</a>
           <a href="javascript:gopage(${pager.lastPageNo})">βҳ</a>
	   </c:otherwise>
	  </c:choose>
      &nbsp;&nbsp;
               ��ת��<input type="text" id="pageNoTemp" name="pageNoTemp" value="${pager.pageNo }" size="3"/>
           <input type="hidden" id="pageNo" name="pageNo" value="${pager.pageNo }" />
           <a href="javascript:goThePage()" >GO</a>
      </div>

      <div class="left">
         ��ʾ
     <input  id="pageSizeTemp" name="pageSizeTemp" type="text" value="${pager.pageSize}"  class="txtInput2 small2" />��/ҳ
      	   <input  id="pageSize" name="pageSize" type="hidden" value="${pager.pageSize}"/>
     <a href="javascript:setPageSize()" class="btnSearch">SET</a>
      </div>

	  <input type="hidden" id="pid" name="pid" value="${pid }"/>
    </div>
	  <div class="line10"></div>
</form>

      <div id="frameDiv" class="hideFrame" >
      
          <iframe  src="" width="100%" height="700px" scrolling="auto" frameborder="0" name="theFrame" id="theFrame"></iframe>
      
      </div>
  
  </body>
  
</html>
