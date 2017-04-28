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
<title>龙岩市重点项目开发建设管理办公室</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.vote_zt{width:800px;line-height:50px;font-size:20px;color:#336699;font-weight:bold;}
.vote_nr{width:800px;line-height:2;font-size:13px; margin-bottom:30px;text-align:left;}
.vote_item{width:800px;text-align:left;}
.vote_wt{line-height:28px;font-size:13px;font-weight:bold;text-align:left;}
.vote_da{line-height:28px;font-size:13px;text-align:left;}
</style>
<script type="text/javascript" src="js/js.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
   $(function(){
        $("#save").click(function(){
            var idstr="";

            $("input").each(function(){
               if($(this).attr("checked")=='checked'){            
                     idstr+=$(this).attr('value')+"-";                    
               }
            });
            $("#voteitem").attr("value",idstr);
            $("#voteform").submit();
        });
   });
</script>
</head>

<body>
<form  id="voteform" action="Vote?act=savevote" method="post">
	<div style="width:1020px;background-image:url(images/line_bg.png); margin:auto;">
	<div style=" text-align:center;"><iframe src="top.html" style="width:1000px;height:230px;" frameborder="0" scrolling="no"></iframe></div>
    <div class="mainbody" align="center" style="width:980px;min-height:500px;_height:500px;">
        <div id="main"> 
           <div class="vote_zt">${vote.zt }</div>
           <div class="vote_nr">${vote.nr }</div>
           <input id="voteitem" name="voteitems" type="hidden"/>
           <input  name="id" type="hidden" value="${vote.id }"/>
           <c:forEach items="${voteItemList}" var="item" >
               <div class="vote_item">
               	<div class="vote_wt">${item.sort }.${item.wt } </div>
               		<div class="vote_da">
               <c:set value="1" var="xuhao" />
               <c:if test="${xuhao != 1}">
                  <c:set value="1" var="xuhao" />${xuhao}.
               </c:if>
               <c:forEach items="${voteAnswersList}" var="answer" varStatus="status">
                  <c:if test="${item.type=='1'}">
                       <c:if test="${answer.wtid==item.id}">
                        ${xuhao}. <input type="radio" name="radio${item.id }" value="${answer.id }"  />${answer.da }<br/>
                      <c:set value="${xuhao+1}" var="xuhao" />
                       </c:if>
                  </c:if>
                  <c:if test="${item.type=='2'}">
                       <c:if test="${answer.wtid==item.id}">
                         ${xuhao}.<input type="checkbox"  value="${answer.id }"  />${answer.da }<br/>
                       <c:set value="${xuhao+1}" var="xuhao" />
                       </c:if>
                  </c:if>
               </c:forEach>
               <c:set value="1" var="xuhao" />
               </div>
				</div>
           </c:forEach>
           
           
        </div>
        <div>
          <table style="width:800px;text-align:left;margin-top:30px;">
             <tr>
                <td width="200">姓名：<input id="name" type="text" name="name"/>
                </td>
                <td width="200">联系方式：<input id="lxfs" type="text" name="lxfs"/>
                </td>
                <td width="80" align="center"><input type="button" value=" 提 交 " id="save"/>
                </td>
                <td width="100" align="center"><a href="Vote?act=show&id=${vote.id }" target="_self"/><font color="red">>>查看结果</font></a>
                </td>
                <td></td>
             </tr>
          </table>
        </div>
    </div>
	<div style=" text-align:center;">
	    <iframe src="footer.html" style="width:1000px;height:90px;margin-top:10px;" frameborder="0" scrolling="no"></iframe>
	</div>    
</div>

</form>
</body>
</html>