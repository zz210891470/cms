<%@ page contentType="text/html; charset=UTF-8"%>     
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<link href="images/lrtk.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>/images/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/images/koala.min.1.5.js"></script>
<script type="text/javascript" src="<%=basePath%>/images/terminator2.2.min.js"></script>
</head>
<body>
<!-- 代码 开始 -->
<div id="fsD1" class="focus">  
    <div id="D1pic1" class="fPic"> 
          <c:forEach items="${hdplist}" var="hd" varStatus="status">
			 <c:if test="${status.count<6&&status.count>=1}">
		<div class="fcon" >
            <a target="_blank" href="ShowArticle.htm?lb=info&id=${hd.id }"><img src="<%=basePath%>${hd.lstp }" border="0" style="opacity: 1;" /></a>
            <span class="shadow"><a target="_blank" href="ShowArticle.htm?lb=info&id=${hd.id }">${hd.bt}</a></span>
         </div>
				    
	</c:if>
 </c:forEach>

    </div>
    <div class="fbg">  
    <div class="D1fBt" id="D1fBt">  
      <c:forEach items="${hdplist}" var="hd" varStatus="status">
	 <c:if test="${status.count<6&&status.count>=1}">
	     <a href="ShowArticle.htm?lb=info&id=${hd.id }" hidefocus="true" target="_blank" class=""><i>${status.index+1}</i></a>	    
	</c:if>
 </c:forEach>  
    </div>  
    </div>  
    <span class="prev"></span>   
    <span class="next"></span>    
</div>  
<script type="text/javascript">
	Qfast.add('widgets', { path: "images/terminator2.2.min.js", type: "js", requires: ['fx'] });  
	Qfast(false, 'widgets', function () {
		K.tabs({
			id: 'fsD1',   //焦点图包裹id  
			conId: "D1pic1",  //** 大图域包裹id  
			tabId:"D1fBt",  
			tabTn:"a",
			conCn: '.fcon', //** 大图域配置class       
			auto: 1,   //自动播放 1或0
			effect: 'fade',   //效果配置
			eType: 'click', //** 鼠标事件
			pageBt:true,//是否有按钮切换页码
			bns: ['.prev', '.next'],//** 前后按钮配置class                          
			interval: 5000  //** 停顿时间  
		}) 
	})  
</script>
<!-- 代码 结束 -->
</body>
</html>