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
	<link rel="stylesheet" type="text/css" href="../images/style.css"/>
	<link href="../lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />  
	<script src="../lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>  
	<script src="../lib/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="../lib/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
	<script src="../lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="../lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
	<script type="text/javascript" src="../js/function.js"></script>
	
	<script type="text/javascript">
      function toSubColumn(id){
          $.post('<%=basePath%>admin/article/ArticleServlet?act=hasArticle&id='+id, function(data){
          data=JSON.parse(data);
          if(data[0]=="SUCCESS"){
            alert("该栏目下存在文章，不能再添加子栏目");  
          }else{
            document.location.href='SysColumnServlet?act=toSubColumn&pid='+id;
          }
          });
      }
      function returnuplevel(){
	      var id=$('#rid').val();  
	      if(id=="0"){
	        document.location.href='<%=basePath%>admin/setting/SysColumnServlet?act=list';
	      }else{
	        document.location.href='<%=basePath%>admin/setting/SysColumnServlet?act=toSubColumn&pid='+id;
	      }
		return false;   
      }
      function add(){
       var id=$('#pid').val();
       $.ligerDialog.open({ url: '<%=basePath%>admin/setting/SysColumnServlet?act=addSubPage&pid='+id,title: '添加栏目', width:500, height: 300, modal:false, isResize:true });
      }
      function gopage(i){
	    var pagesize=$('#txtPageNum').val();   
	     var id=$('#pid').val();    
      	document.location.href='<%=basePath%>admin/setting/SysColumnServlet?act=toSubColumn&pid='+id+'&pageNo='+i+'&pageSize='+pagesize;
		return false;
      }
      function edit(id){
      	$.ligerDialog.open({ url: 'SysColumnServlet?act=subupdatepage&id='+id,title: '编辑栏目', width:500, height: 300, modal:false, isResize:true });  
      }
      function del(id){
      	$.post('<%=basePath%>admin/article/ArticleServlet?act=hasArticle&id='+id, function(data){
          	data=JSON.parse(data);
          	if(data[0]=="SUCCESS"){
            	alert("该栏目下存在文章，不能删除该栏目");  
          	}else{
          		//判断是否有子栏目，有则不能删除
          		$.post('<%=basePath%>admin/setting/SysColumnServlet?act=hasColumn&id='+id, function(data){
	          	data=JSON.parse(data);
	          	if(data[0]=="SUCCESS"){
	            	alert("该栏目下存在子栏目，不能删除该栏目");  
	          	}else{
	          		if(confirm("确定要删除栏目？")){
	          			$.post('<%=basePath%>admin/setting/SysColumnServlet?act=deleteColumns&id='+id, function(data){
			          	data=JSON.parse(data);
			          	if(data[0]=="SUCCESS"){
			          		location.reload();
			          	}
			    		});
					}
				}
				});
			}
		});
      }
      
     $(function(){      
	    $('#txtPageNum').keypress(function (e) {
	    var keycode;
		if (navigator.appName == "Microsoft Internet Explorer") {  // IE
			key = e.keyCode;
		} else {             // Netscape/Firefox/Opera
			key = e.which;
		}

	    if (key == 13) {
	       var pagesize=$('#txtPageNum').val();     
	       var id=$('#pid').val(); 
      	   document.location.href='<%=basePath%>admin/setting/SysColumnServlet?act=toSubColumn&pid='+id+'&pageNo=1&pageSize='+pagesize;
		   return false;
	    }
	    });

	 }); 
      </script>

</head>

<body class="mainbody">

<div class="navigation">首页 &gt; 系统设置管理 &gt; 系统栏目管理</div>
    <form name="pageform"  method="post">
    <div class="tools_box">
	    <div class="tools_bar">
	        <a href="javascript:add();" class="tools_btn"><span><b class="add">添加栏目</b></span></a>
		    <a href="javascript:void(0);" onclick="checkAll(this);" class="tools_btn" style="display:none;"><span><b class="all">全选</b></span></a>
            <a id="btnDelete" class="tools_btn" href="#" style="display:none;"><span><b class="delete">批量删除</b></span></a>
            <a href="javascript:returnuplevel();" class="tools_btn"><span><b class="return">返回</b></span></a>
        </div>
    </div>
    <input type="hidden" value="${pid}" id="pid"/>
    <input type="hidden" value="${rid}" id="rid"/>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="msgtable">
      <tr>
        <th style="width:40px">选择</th>
        <th style="width:60px" >编号</th>
        <th>栏目名称</th>
        <th style="width:80px">栏目排序</th>
        <th style="width:150px">操作</th>
      </tr>
     <c:forEach items="${pager.resultList}" var="column">
     <tr>
        <td align="center" height="25">
          <span class="checkall">
          <input id="rptList_ctl01_chkId" type="checkbox" name="columnlist" value="${column.id}"/>
          </span>
        </td>
        <td align="center">${column.id }</td>
        <td align="left">${column.lmmc }</td>
        <td align="center">${column.lmpx }</td>
        <td align="center">
        	<c:if test="${column.lmmx=='栏目模板'}">
        		<a href="javascript:toSubColumn(${column.id});">子栏目管理</a>&nbsp;
        	</c:if>
        	<a href="#%20" onclick="edit('${column.id}');" target="_self">修改</a>&nbsp;
			<a href="#%20" onclick="del('${column.id}');" target="_self">删除</a>
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
   		   <span class="disabled">首页</span> 
		   <span class="disabled">上一页</span> 
	   </c:when> 
	   <c:otherwise> 
		  <a href="javascript:gopage(${pager.firstPageNo})">首页</a>
	      <a href="javascript:gopage(${pager.prePageNo})">上一页</a> 
	   </c:otherwise>
	  </c:choose>
      
      <span class="current">${pager.pageNo}页/${pager.pageCount}页</span>
      <c:choose>
	   <c:when test="${pager.pageNo==pager.pageCount||page.pageCount==0}">
   		   <span class="disabled">下一页</span> 
		   <span class="disabled">尾页</span> 
	   </c:when> 
	   <c:otherwise> 
           <a href="javascript:gopage(${pager.nextPageNo})">下一页</a>
           <a href="javascript:gopage(${pager.lastPageNo})">尾页</a>
	   </c:otherwise>
	  </c:choose>

      </div>
      <div class="left">
         显示<input  id="txtPageNum" name="txtPageNum" type="text" value="${pager.pageSize}" onchange=""  class="txtInput2 small2" />条/页
      </div>
    </div>
	  <div class="line10"></div>

  </body>
</html>
