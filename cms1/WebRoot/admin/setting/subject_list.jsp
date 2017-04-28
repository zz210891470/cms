<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GB18030" />
	<link rel="stylesheet" type="text/css" href="../images/style.css"/>
	<link href="../lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />  
	<script src="../lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>  
	<script src="../lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="../lib/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
    <script src="../lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
    <script src="../lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
	<script type="text/javascript" src="../js/function.js"></script>
	
	<script type="text/javascript">
      function add(){
		$.ligerDialog.open({ url: '<%=basePath%>admin/setting/SpecialColumnServlet?act=addpage',title: '添加专题', width:500, height: 300, modal:false, isResize:true });
      }
      function gopage(i){
	    var pagesize=$('#txtPageNum').val();      
      	document.location.href='<%=basePath%>admin/setting/SpecialColumnServlet?act=list&pageNo='+i+'&pageSize='+pagesize;
		return false;
      }
      function edit(id){
      	$.ligerDialog.open({ url: 'SpecialColumnServlet?act=updatepage&id='+id,title: '编辑专题', width:500, height: 300, modal:false, isResize:true });  
      }
      function del(id){
      	$.post('<%=basePath%>admin/article/SubArticleServlet?act=hasArticle&id='+id, function(data){
          	data=JSON.parse(data);
          	if(data[0]=="SUCCESS"){
            	alert("该专题下存在文章，不能删除该栏目");  
          	}else{
          		//判断是否有子栏目，有则不能删除
          		$.post('<%=basePath%>admin/setting/SpecialColumnServlet?act=hasColumn&id='+id, function(data){
	          	data=JSON.parse(data);
	          	if(data[0]=="SUCCESS"){
	            	alert("该专题下存在子栏目，不能删除该专题");  
	          	}else{
	          		if(confirm("确定要删除专题？")){
	          			$.post('<%=basePath%>admin/setting/SpecialColumnServlet?act=deleteItems&id='+id, function(data){
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
      	   document.location.href='<%=basePath%>admin/setting/SpecialColumnServlet?act=list&pageNo=1&pageSize='+pagesize;
		   return false;
	    }
	    });

	 }); 
      </script>
</head>

<body class="mainbody">

<div class="navigation">首页 &gt; 系统设置管理 &gt; 专题栏目管理</div>
    <form name="pageform"  method="post">
    <input type="hidden" value="0" id="pid" name="pid"/>
    <div class="tools_box">
	    <div class="tools_bar">
	        <a href="javascript:add();" class="tools_btn"><span><b class="add">添加专题</b></span></a>
		    <a href="javascript:void(0);" onclick="checkAll(this);" class="tools_btn" style="display:none;"><span><b class="all">全选</b></span></a>
            <a id="btnDelete" class="tools_btn" href="" style="display:none;"><span><b class="delete">批量删除</b></span></a>
        </div>
    </div>
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="msgtable">
      <tr>
        <th style="width:40px">选择</th>
        <th style="width:60px">编号</th>
        <th align="left" style="width:250px">专题名称</th>
        <th align="center">专题链接地址</th>
        <th style="width:80px">排序</th>
        <th style="width:150px">操作</th>
      </tr>
     <c:forEach items="${pager.resultList}" var="item">
     <tr>
        <td align="center" height="25"><input id="id" type="checkbox" name="id" value="${item.id}"/></td>
        <td align="center">${item.id }</td>
        <td align="left">${item.lmmc }</td>
        <td align="center"><%=basePath%>SubjectColumn?loc=showzt&ztid=${item.id }</td>
        <td align="center">${item.lmpx }</td>
        <td align="center">
			<a href="SpecialColumnServlet?act=toSubColumn&pid=${item.id}" target="_self">子栏目管理</a>&nbsp;
			<a href="#%20" onclick="edit('${item.id}');" target="_self">修改</a>&nbsp;
			<a href="#%20" onclick="del('${item.id}');" target="_self">删除</a>
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
