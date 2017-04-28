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
    .showDiv{display:block;z-index:5;position:absolute;top:0;left:0;width:100%;height:auto;}
    .hideDiv{display:none;}
    </style>
	<script>
	
	    //--------
        //�༭�б���
        //--------
        function edit(i){
            $("#theFrame").attr("src","<%=basePath%>admin/zdxm_sbyh/ZdxmSbyhServlet?action=toYbEdit&id="+i);
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
        function hideFrame(){
            $("#frameDiv").removeClass("showDiv");
            $("#frameDiv").addClass("hideDiv");

        }
        
        //����б���
        function add(id){
            $("#theFrame").attr("src","<%=basePath%>admin/zdxm_sbyh/ZdxmSbyhServlet?action=yblr&id="+id);
            $("#frameDiv").removeClass("hideDiv");
            $("#frameDiv").addClass("showDiv");
        }
        
        $(function(){
           if($("#addstatus").val()=="ok"){
              alert("����������±�������д��");
           }
       });
        
	</script>
  </head>
  <body class="mainbody">
    <input id="addstatus" type="hidden" value="${addstatus }"/>
  	<form name="form" method="post" action="" id="form">
  	    <div class="tools_box">
	    <div class="tools_bar">
            <a href="javascript:add('${id }')" class="tools_btn"><span><b class="add">����±�</b></span></a>
        	<div style="text-align:center; font-size:16px; line-height:50px; font-weight:bold;">${xmmc }</div>
        </div>
        
        </div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="msgtable">
			<tr>
			  <th width="80" align="center">�±�ʱ��</th>
			  <th width="90" align="center">���µ�λ�ʽ�</th>
			  <th width="90" align="center">�������Ͷ��</th>
			  <th width="80" align="center">�ϱ�����</th>
			  <th width="80" align="center">�ϱ�״̬</th>
			  <th width="80">����</th>
			</tr>
			<c:forEach items="${itemList}" var="item">
		     <tr>
		        <td align="center">${item.yf }</td>
		        <td>${item.dwzjhj }</td>
		        <td>${item.bywc }</td>
		        <td>${item.tbsj }</td>
		        <td>${item.zt }</td>
		        <td align="center">
			  <a href="javascript:read(${item.id })" target="_self">����</a>
			  <!--����״̬�����޸ġ��ϱ���ʾ��״̬Ϊδ�ϱ�ʱ��ʾ  -->
			  <c:if test="${item.zt=='δ�ϱ�'}">
		          <a href="javascript:edit(${item.id })" target="_self">�༭</a>
		          <a href="javascript:submit(${item.id })" target="_self">�ϱ�</a>
		      </c:if>    
			</td>
		      </tr>
		    </c:forEach>  
		</table>
    </form>
          
      <div id="frameDiv" class="hideFrame" >
          <iframe  src="" width="100%" height="1800px" scrolling="auto" frameborder="0" name="theFrame" id="theFrame"></iframe>
      </div>
  </body>
</html>