<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
<title>ϵͳ�˺Ź���</title>
<link rel="stylesheet" type="text/css" href="../images/style.css"/>
<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script>  
<script type="text/javascript" src="../js/function.js"></script>
<script type="text/javascript">
      function add(){
        document.location.href='<%=basePath%>admin/setting/SysUserServlet?act=addpage';
		return false;   
      }
      function gopage(i){
	    var pagesize=$('#txtPageNum').val();      
      	document.location.href='<%=basePath%>admin/setting/SysUserServlet?act=list&pageNo='+i+'&pageSize='+pagesize;
		return false;
      }
      
     $(function(){
        $('#btnDelete').click(function(){
        	if(confirm("ȷ��Ҫɾ��ѡ�е����ݣ�")){
	            var pagesize=$('#txtPageNum').val();
			    document.all.pageform.action='<%=basePath%>admin/setting/SysUserServlet?act=deleteItems&pageNo=1&pageSize='+pagesize;     
				document.all.pageform.submit();   
			}
        });
        
	    $('#txtPageNum').keypress(function (e) {
	    var keycode;
		if (navigator.appName == "Microsoft Internet Explorer") {  // IE
			key = e.keyCode;
		} else {             // Netscape/Firefox/Opera
			key = e.which;
		}

	    if (key == 13) {
	       var pagesize=$('#txtPageNum').val();      
      	   document.location.href='<%=basePath%>admin/setting/SysUserServlet?act=list&pageNo=1&pageSize='+pagesize;
		   return false;
	    }
	    });
	 }); 
      </script>
</head>

<body class="mainbody">

<div class="navigation">��ҳ &gt; ϵͳ���ù��� &gt;  ϵͳ�ʺŹ���</div>
    <form name="pageform"  method="post">
    <div class="tools_box">
	    <div class="tools_bar">
	        <a href="javascript:add();" class="tools_btn"><span><b class="add">����ʺ�</b></span></a>
		    <a href="javascript:void(0);" onclick="checkAll(this);" class="tools_btn"><span><b class="all">ȫѡ</b></span></a>
            <a  id="btnDelete" class="tools_btn" href="javascript:__doPostBack('btnDelete','')"><span><b class="delete">����ɾ��</b></span></a>
        </div>
    </div>
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="msgtable">
      <tr>
        <th style="width:40px;">ѡ��</th>
        <th>�û���</th>
        <th>����</th>
        <th style="width:150px;">��ϵ�绰</th>
        <th style="width:150px;">����</th>
        <th style="width:40px;">״̬</th>
        <th style="width:80px;">����</th>
      </tr>
     <c:forEach items="${pager.resultList}" var="item">
     <tr>
        <td align="center"><span class="checkall"><input id="id" type="checkbox" name="itemList" value="${item.id}"/></span></td>
        <td>${item.yhm }</td>
        <td>${item.xm }</td>
        <td>${item.dh }</td>
        <td>${item.yx }</td>
        <td align="center">
        	<c:if test="${item.zt==1}">
          		<img title="����" src="../images/icon_correct.png" />
          	</c:if>
          	<c:if test="${item.zt==0}">
          		<img title="����" src="../images/icon_disable.png" />
          	</c:if>
        </td>
        <td align="center">
        	<a href="SysUserServlet?act=updatepage&id=${item.id}">�޸�</a>
        </td>
      </tr>
     </c:forEach> 
	 </table>
 </form>
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
	   <c:when test="${pager.pageNo==pager.pageCount||page.pageCount==0}">
   		   <span class="disabled">��һҳ</span> 
		   <span class="disabled">βҳ</span> 
	   </c:when> 
	   <c:otherwise> 
           <a href="javascript:gopage(${pager.nextPageNo})">��һҳ</a>
           <a href="javascript:gopage(${pager.lastPageNo})">βҳ</a>
	   </c:otherwise>
	  </c:choose>

      </div>
      
      <div class="left">
         ��ʾ<input  id="txtPageNum" name="txtPageNum" type="text" value="${pager.pageSize}" onchange=""  class="txtInput2 small2" />��/ҳ
      </div>
    </div>
	  <div class="line10"></div>

  </body>
</html>
