<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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
	<meta http-equiv="Content-Type" content="text/html;charset=GB18030" />

	<meta name="baidu-site-verification" content="WZKavSItPv" />
	<title>龙岩市重点项目网 龙岩市重点项目开发建设管理办公室</title>
	<link href="style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/js.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script src="Scripts/swfobject_modified.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
	<script src="js/jquery.soChange-min.js" type="text/javascript"></script>
	<script type="text/javascript">

	    
	    function getDh(){
	        return $("#dh").val();
	    }
	    
	    function getCz(){
	        return $("#cz").val();
	    }
	    function getYx(){
	        return $("#yx").val();
	    }
	</script>

<style> 
#demo {background: #FFF;overflow:hidden;border: 0px;width: 710px;}
#indemo {float: left;width: 800%;}
#demo1 {float: left;}
#demo2 {float: left;}   

li{list-style:none;}img{border:none;}em{font-style:normal;}
a{color:#555;text-decoration:none;outline:none;blr:this.onFocus=this.blur();}
a:hover{color:#000;text-decoration:underline;}
.clear{height:0;overflow:hidden;clear:both;}
.play{width:318px;height:235px;border:#ccc 1px solid; text-align:left; }
.textbg{margin-top:205px;z-index:1;filter:alpha(opacity=40);opacity:0.4;width:318px;position:absolute;height:30px;background:#000;}
.text{margin-top:205px;z-index:2;padding-left:10px;font-size:14px;font-weight:bold;width:170px;color:#fff;line-height:30px; overflow:hidden;position:absolute;cursor:pointer;}
.num{margin:210px 5px 0 170px;z-index:3;width:145px; text-align:right;position:absolute;height:25px;}
.num a{margin:0 2px;width:20px;height:20px;font-size:14px; font-weight:bold;line-height:20px;cursor:pointer;color:#000;padding:0 5px;background:#D7D6D7;text-align:center}
.num a.on{background:#FFD116;color:#A8471C;}
.num a.on2{background:#D7D6D7;color:#000;}
.content img{width:318px;height:235px;}
 


.index_top_banner{width:980px;border:solid 1px #CCC; margin-top:10px;}
.the_left_advert{position:absolute;z-index:10;left:10px;top:180px;}
.the_right_advert{position:absolute;z-index:10;right:10px;top:180px;}
.the_tc_advert{ position:absolute; z-index:999; top:200px; left:200px;}
.the_pf_advert{ position:absolute; z-index:999;}
</style>

	<meta http-equiv="keywords" content="${config.ymgjc }"/>
	<meta http-equiv="description" content="${config.ymms }"/>

</head>

<body>
<input type="hidden" value="${config.lxdh }" id="dh"/>
<input type="hidden" value="${config.czhm }" id="cz"/>
<input type="hidden" value="${config.glyyx }" id="yx"/>
	<div style="width:1020px;background-image:url(images/line_bg.png); margin:auto;">
	<div style=" text-align:center;"><iframe src="top.html" style="width:1000px;height:265px;" frameborder="0" scrolling="no"></iframe></div>
    <div class="mainbody" align="center">
    	
          	<c:forEach items="${adverts}" var="a" >
			    <c:if test="${a.id==1&&a.status==1}">
			    <div class="index_top_banner">
			    <c:if test="${a.url!=''}">
			    <a href="${a.url }" target="_blank"></c:if>
			    	<img src="<%=basePath%>${a.imgurl}" style="width:980px; max-height:200px;"/>
			    <c:if test="${a.url!=''}">
			    </a></c:if>
			     </div>
			    </c:if>
		    </c:forEach>
       
        <div class="index_news">
            <div class="index_picnews">
            <div class="play">
				<ul>
			        <li class="textbg"></li>
			        <li class="text"></li>
			        <li class="num">
			        <c:forEach items="${hdlist}" var="hd" varStatus="status">
					    <c:if test="${status.count<6&&status.count>=1}">
					        <a>${status.count}</a>
						    
						</c:if>
				    </c:forEach>
				    </li>
			        
			        <li id="content" class="content">
			        
			        	 <c:forEach items="${hdlist}" var="hd" varStatus="status">
						    <c:if test="${status.count<6&&status.count>=1}">
						    <a href="ShowArticle.htm?lb=info&id=${hd.id }" target="_blank">
						    <img src="<%=basePath%>${hd.lstp }" width="318" height="235" alt="${fn:substring(hd.bt, 0, 10)}"  />

						    </a> 
							</c:if>
						 </c:forEach>
			        
			        </li>
			    </ul>

			</div>

			</div>
        
            
            	
		<script type=text/javascript>
		var th = n = 0, count = $(".content a").size();
		$(function(){
			var play = ".play";
			var playText = ".play .text";
			var playNum = ".play .num a";
			var playConcent = ".play .content a";
			
			$(playConcent + ":not(:first)").hide();
			$(playText).html($(playConcent + ":first").find("img").attr("alt"));
			$(playNum + ":first").addClass("on");
			$(playText).click(function(){window.open($(playConcent + ":first").attr('href'), "_blank")});
			$(playNum).click(function() {
			   var i = $(this).text() - 1;
			   n = i;
			   if (i >= count) return;
			   $(playText).html($(playConcent).eq(i).find("img").attr('alt'));
			   $(playText).unbind().click(function(){window.open($(playConcent).eq(i).attr('href'), "_blank")})
			   $(playConcent).filter(":visible").hide().parent().children().eq(i).fadeIn(1200);
			   $(this).removeClass("on").siblings().removeClass("on");
			   $(this).removeClass("on2").siblings().removeClass("on2");
			   $(this).addClass("on").siblings().addClass("on2");
			});
			th = setInterval("showAuto()", 5000);
			$(play).hover(function(){clearInterval(th)}, function(){th = setInterval("showAuto()", 5000);});
		})
		function showAuto(){
			n = n >= (count - 1) ? 0 : ++n;
			$(".num a").eq(n).trigger('click');
		}
	</script>
            
            <div class="index_newslist">
                <div class="index_newslist1" id="index_n" >
                	<div class="index_new" id="index_new" onmouseover="change_news(1);" ><a href="subcolumn.htm?loc=xxgk"  target="_blank">新闻动态</a></div>
                    <div class="index_notice" id="index_notice" onmouseover="change_news(2);"><a href="subcolumn.htm?loc=xxgk#50" target="_blank">通知公告</a></div>
                </div>
                <span class="index_more" id="index_new_more"><a href="subcolumn.htm?loc=xxgk" target="_blank">更多>></a></span>
                <span class="index_more" id="index_notice_more" style="display:none;"><a href="subcolumn.htm?loc=xxgk" target="_blank">更多>></a></span>
                <div id="index_new_list">
                    <div class="index_rdgz" style="display:none;">
                        <h3 class="newsListHot"><span><a href="ShowArticle.htm?lb=info&id=${rd.id }" target="_blank"> <em id="t1" style="color:red">${rd.bt }...</em></a><em id="t2">${rd.nr }...</em></span>
                        </h3>
                    </div>
                    <div class="index_newslist2" style="height:160px;">
                        <ul class="newsList0">
                            <c:set var="lm2" value="1" scope="page"></c:set>
                            <c:forEach items="${itemList}" var="item">
                             <c:if test="${item.lmid==49}">
                             <c:if test="${lm2<9}">
                             <li><span><fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd" type="date" dateStyle="long" /> </span>·<a href="ShowArticle.htm?lb=info&id=${item.id }" target="_blank" title="${item.bt }">${fn:substring(item.bt, 0, 25)}</a></li>
                             </c:if>
                             <c:set var="lm2" value="${lm2+1}"></c:set>
                             </c:if>
                            </c:forEach> 
                        </ul>
                    </div>
                </div>
                <div id="index_notice_list" style="display:none;">
                	<div class="index_newslist2">
                        <ul class="newsList0">
                            <c:set var="lm2" value="1" scope="page"></c:set>
                            <c:forEach items="${itemList}" var="item">
                             <c:if test="${item.lmid==50}">
                             <c:if test="${lm2<9}">
                             <li><span><fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd" type="date" dateStyle="long" /> </span>·<a href="ShowArticle.htm?lb=info&id=${item.id }" target="_blank" title="${item.bt }">${fn:substring(item.bt, 0, 25)}</a></li>
                             </c:if>
                             <c:set var="lm2" value="${lm2+1}"></c:set>
                             </c:if>
                            </c:forEach> 
                        </ul>
                    </div>
                </div>
            </div>
            <div class="index_zfxxgk">
            	<img src="images/zfxxgkl.jpg"/>
                <div style="border:solid 1px #ccc; border-top:0px;height:210px;">
                	<img src="images/zfxxgkl1.jpg" border="0" usemap="#Map"/>
                    <map name="Map" id="Map">
                      <area shape="rect" coords="42,11,140,24" href="zfxxgk.htm?loc=zfxxgk&lb=gkzn" target="_blank" />
                      <area shape="rect" coords="42,44,140,58" href="zfxxgk.htm?loc=zfxxgk&lb=gkml" target="_blank" />
                      <area shape="rect" coords="42,76,140,91" href="zfxxgk.htm?loc=zfxxgk&lb=gkgd" target="_blank" />
                      <area shape="rect" coords="42,110,140,124" href="zfxxgk.htm?loc=zfxxgk&lb=ysqgk" target="_blank" />
                      <area shape="rect" coords="42,142,160,158" href="zfxxgk.htm?loc=zfxxgk&lb=ndbg" target="_blank" />
                      <area shape="rect" coords="42,174,150,191" href="myzj.html" target="_blank" />
                    </map>
                </div>
            </div>
            </div>
            <div class="index_left">
            	<div class="index_left_xmjs" style="width:729px;">
                	
                </div>
                <div class="index_left_xmjs1" style="width:729px;">
                	<div class="xxgk_list1" id="div_xmjs1">
                    	<div style="margin:5px;">
                        	<div class="xxgk_bt1" onmouseover="change('div_xmjs1','xxgk_list1','xmjs_list1','xmjs_list2','xmjs1','xmjs2');" id="xmjs1"><a href="subcolumn.htm?loc=xmjs#67"  target="_blank">在建重点项目</a></div>
                            <div class="xxgk_bt2" onmouseover="change('div_xmjs1','xxgk_list2','xmjs_list2','xmjs_list1','xmjs2','xmjs1');" id="xmjs2"><a href="subcolumn.htm?loc=xmjs#69"  target="_blank">预备重点项目</a></div>
                        </div>
                        <div id="xmjs_list1">
                        <ul class="xxgklist">
                           <c:set var="lm9" value="1" scope="page"></c:set>
	                        <c:forEach items="${itemList}" var="item">
	                         <c:if test="${item.lmid==67}">
	                         <c:if test="${lm9<6}">
	                         <li><span><fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd" type="date" dateStyle="long" /></span>·<a href="ShowArticle.htm?lb=info&id=${item.id }" target="_blank" title="${item.bt }">${fn:substring(item.bt, 0, 18)}</a></li>
	                         </c:if>
	                         <c:set var="lm9" value="${lm9+1}"></c:set>
                             </c:if>
	                        </c:forEach>
                    	</ul>
                    	</div>
                        <div id="xmjs_list2" style="display:none;">
                        <ul class="xxgklist">
                            <c:set var="lm10" value="1" scope="page"></c:set>
	                        <c:forEach items="${itemList}" var="item">
	                         <c:if test="${item.lmid==69}">
	                         <c:if test="${lm10<6}">
	                         <li><span><fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd" type="date" dateStyle="long" /></span>·<a href="ShowArticle.htm?lb=info&id=${item.id }" target="_blank" title="${item.bt }">${fn:substring(item.bt, 0, 18)}</a></li>
	                         </c:if>
	                         <c:set var="lm10" value="${lm10+1}"></c:set>
                             </c:if>
	                        </c:forEach>
                    	</ul>
                    	</div>
                    </div>
                    <div class="xxgk_list1" id="div_xmjs2">
                    	<div style="margin:5px;">
                        	<div class="xxgk_bt1" onmouseover="change('div_xmjs2','xxgk_list1','xmjs_list3','xmjs_list4','xmjs3','xmjs4');" id="xmjs3"><a href="subcolumn.htm?loc=xmjs#70"  target="_blank">开工项目</a></div>
                            <div class="xxgk_bt2" onmouseover="change('div_xmjs2','xxgk_list2','xmjs_list4','xmjs_list3','xmjs4','xmjs3');" id="xmjs4"><a href="subcolumn.htm?loc=xmjs#71"  target="_blank">竣工项目</a></div>
                        </div>
                        <div id="xmjs_list3">
                        <ul class="xxgklist">
                            <c:set var="lm11" value="1" scope="page"></c:set>
 	                        <c:forEach items="${itemList}" var="item">
	                         <c:if test="${item.lmid==70}">
	                         <c:if test="${lm11<6}">
	                         <li><span><fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd" type="date" dateStyle="long" /></span>·<a href="ShowArticle.htm?lb=info&id=${item.id }" target="_blank" title="${item.bt }">${fn:substring(item.bt, 0, 18)}</a></li>
	                         </c:if>
	                         <c:set var="lm11" value="${lm11+1}"></c:set>
                             </c:if>
	                        </c:forEach>
	                    </ul>
                    	</div>
                        <div id="xmjs_list4" style="display:none;">
                        <ul class="xxgklist">
                             <c:set var="lm12" value="1" scope="page"></c:set>
                       	     <c:forEach items="${itemList}" var="item">
	                         <c:if test="${item.lmid==71}">
	                         <c:if test="${lm12<6}">
	                         <li><span><fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd" type="date" dateStyle="long" /></span>·<a href="ShowArticle.htm?lb=info&id=${item.id }" target="_blank" title="${item.bt }">${fn:substring(item.bt, 0, 18)}</a></li>
	                         </c:if>
	                         <c:set var="lm12" value="${lm12+1}"></c:set>
                             </c:if>
	                        </c:forEach>
	                    </ul>
                    	</div>
                    </div>
                    <div class="xxgk_list3" id="div_xmjs3">
                    	<div style="margin:5px;">
                        	<div class="xxgk_bt1" onmouseover="change1('div_xmjs3','xxgk_list3','xmjs_list5','xmjs_list6','xmjs_list7','xmjs5','xmjs6','xmjs7');" id="xmjs5"><a href="subcolumn.htm?loc=xmch#73"  target="_blank">储备项目</a></div>
                            <div class="xxgk_bt2" onmouseover="change1('div_xmjs3','xxgk_list4','xmjs_list6','xmjs_list5','xmjs_list7','xmjs6','xmjs5','xmjs7');" id="xmjs6"><a href="subcolumn.htm?loc=xmzs#59"  target="_blank">前期项目</a></div>
                            <div class="xxgk_bt2" onmouseover="change1('div_xmjs3','xxgk_list5','xmjs_list7','xmjs_list5','xmjs_list6','xmjs7','xmjs5','xmjs6');" id="xmjs7"><a href="subcolumn.htm?loc=xmch#74"  target="_blank">项目策划指南</a></div>
                        </div>
                        <div id="xmjs_list5">
                        <ul class="xxgklist">
                            <c:set var="lm11" value="1" scope="page"></c:set>
 	                        <c:forEach items="${itemList}" var="item">
	                         <c:if test="${item.lmid==73}">
	                         <c:if test="${lm11<6}">
	                         <li><span><fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd" type="date" dateStyle="long" /></span>·<a href="ShowArticle.htm?lb=info&id=${item.id }" target="_blank" title="${item.bt }">${fn:substring(item.bt, 0, 18)}</a></li>
	                         </c:if>
	                         <c:set var="lm11" value="${lm11+1}"></c:set>
                             </c:if>
	                        </c:forEach>
	                    </ul>
                    	</div>
                        <div id="xmjs_list6" style="display:none;">
                        <ul class="xxgklist">
                             <c:set var="lm12" value="1" scope="page"></c:set>
                       	     <c:forEach items="${itemList}" var="item">
	                         <c:if test="${item.lmid==59}">
	                         <c:if test="${lm12<6}">
	                         <li><span><fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd" type="date" dateStyle="long" /></span>·<a href="ShowArticle.htm?lb=info&id=${item.id }" target="_blank" title="${item.bt }">${fn:substring(item.bt, 0, 18)}</a></li>
	                         </c:if>
	                         <c:set var="lm12" value="${lm12+1}"></c:set>
                             </c:if>
	                        </c:forEach>
	                    </ul>
                    	</div>
                        <div id="xmjs_list7" style="display:none;">
                        <ul class="xxgklist">
                             <c:set var="lm12" value="1" scope="page"></c:set>
                       	     <c:forEach items="${itemList}" var="item">
	                         <c:if test="${item.lmid==74}">
	                         <c:if test="${lm12<6}">
	                         <li><span><fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd" type="date" dateStyle="long" /></span>·<a href="ShowArticle.htm?lb=info&id=${item.id }" target="_blank" title="${item.bt }">${fn:substring(item.bt, 0, 18)}</a></li>
	                         </c:if>
	                         <c:set var="lm12" value="${lm12+1}"></c:set>
                             </c:if>
	                        </c:forEach>
	                    </ul>
                    	</div>
                    </div>
                    <div class="xxgk_list3" id="div_xmjs4">
                    	<div style="margin:5px;">
                        	<div class="xxgk_bt1" onmouseover="change1('div_xmjs4','xxgk_list3','xmjs_list8','xmjs_list9','xmjs_list10','xmjs8','xmjs9','xmjs10');" id="xmjs8"><a href="subcolumn.htm?loc=xmzs#58"  target="_blank">招商项目</a></div>
                            <div class="xxgk_bt2" onmouseover="change1('div_xmjs4','xxgk_list4','xmjs_list9','xmjs_list8','xmjs_list10','xmjs9','xmjs8','xmjs10');" id="xmjs9"><a href="subcolumn.htm?loc=xmzs#56"  target="_blank">投资环境</a></div>
                            <div class="xxgk_bt2" onmouseover="change1('div_xmjs4','xxgk_list5','xmjs_list10','xmjs_list8','xmjs_list9','xmjs10','xmjs8','xmjs9');" id="xmjs10"><a href="subcolumn.htm?loc=xmzs#57"  target="_blank">优惠政策</a></div>
                        </div>
                        <div id="xmjs_list8">
                        <ul class="xxgklist">
                            <c:set var="lm11" value="1" scope="page"></c:set>
 	                        <c:forEach items="${itemList}" var="item">
	                         <c:if test="${item.lmid==58}">
	                         <c:if test="${lm11<6}">
	                         <li><span><fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd" type="date" dateStyle="long" /></span>·<a href="ShowArticle.htm?lb=info&id=${item.id }" target="_blank" title="${item.bt }">${fn:substring(item.bt, 0, 18)}</a></li>
	                         </c:if>
	                         <c:set var="lm11" value="${lm11+1}"></c:set>
                             </c:if>
	                        </c:forEach>
	                    </ul>
                    	</div>
                        <div id="xmjs_list9" style="display:none;">
                        <ul class="xxgklist">
                             <c:set var="lm12" value="1" scope="page"></c:set>
                       	     <c:forEach items="${itemList}" var="item">
	                         <c:if test="${item.lmid==56}">
	                         <c:if test="${lm12<6}">
	                         <li><span><fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd" type="date" dateStyle="long" /></span>·<a href="ShowArticle.htm?lb=info&id=${item.id }" target="_blank" title="${item.bt }">${fn:substring(item.bt, 0, 18)}</a></li>
	                         </c:if>
	                         <c:set var="lm12" value="${lm12+1}"></c:set>
                             </c:if>
	                        </c:forEach>
	                    </ul>
                    	</div>
                        <div id="xmjs_list10" style="display:none;">
                        <ul class="xxgklist">
                             <c:set var="lm12" value="1" scope="page"></c:set>
                       	     <c:forEach items="${itemList}" var="item">
	                         <c:if test="${item.lmid==57}">
	                         <c:if test="${lm12<6}">
	                         <li><span><fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd" type="date" dateStyle="long" /></span>·<a href="ShowArticle.htm?lb=info&id=${item.id }" target="_blank" title="${item.bt }">${fn:substring(item.bt, 0, 18)}</a></li>
	                         </c:if>
	                         <c:set var="lm12" value="${lm12+1}"></c:set>
                             </c:if>
	                        </c:forEach>
	                    </ul>
                    	</div>
                    </div>
                </div>
                <div class="index_left_banner">
	            <c:forEach items="${adverts}" var="a" >
				    <c:if test="${a.id==2&&a.status==1}">
				    <c:if test="${a.url!=''}">
			        <a href="${a.url }" target="_blank"></c:if>${a.url }
				    <img src="<%=basePath%>${a.imgurl}" style="height:140px;width:727px;"/>
				    <c:if test="${a.url!=''}">
				    </a></c:if>
				    </c:if>
			    </c:forEach>
                </div>
            	<div class="index_left_xxgk">
                	<span class="index_more"><a href="" target="_blank">更多>></a></span>
                </div>
                <div class="index_left_xxgk1">
                	<div class="xxgk_list1" id="div_xxgk1">
                    	<div style="margin:5px;">
                        	<div class="xxgk_bt1" onmouseover="change('div_xxgk1','xxgk_list1','xxgk_list1','xxgk_list2','xxgk_gsgg','xxgk_zcfg');" id="xxgk_gsgg"><a href="subcolumn.htm?loc=xxgk#75"  target="_blank">文件通知</a></div>
                            <div class="xxgk_bt2" onmouseover="change('div_xxgk1','xxgk_list2','xxgk_list2','xxgk_list1','xxgk_zcfg','xxgk_gsgg');" id="xxgk_zcfg"><a href="subcolumn.htm?loc=xxgk#51"  target="_blank">政策法规</a></div>
                        </div>
                        <div id="xxgk_list1">
                        <ul class="xxgklist">
                        <c:set var="lm1" value="1" scope="page"></c:set>
                        <c:forEach items="${itemList}" var="item" >
                         <c:if test="${item.lmid==75}">
                         <c:if test="${lm1<6}">
                         <li><span><fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd" type="date" dateStyle="long" /></span>·<a href="ShowArticle.htm?lb=info&id=${item.id }" target="_blank" title="${item.bt }">${fn:substring(item.bt, 0, 18)}</a></li>
                         </c:if>
                         <c:set var="lm1" value="${lm1+1}"></c:set>
                         </c:if>
                        </c:forEach>

                    	</ul>
                    	</div>
                        <div id="xxgk_list2" style="display:none;">
                        <ul class="xxgklist">
                        <c:set var="lm2" value="1" scope="page"></c:set>
                        <c:forEach items="${itemList}" var="item">
                         <c:if test="${item.lmid==51}">
                         <c:if test="${lm2<6}">
                         <li><span><fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd" type="date" dateStyle="long" /></span>·<a href="ShowArticle.htm?lb=info&id=${item.id }" target="_blank" title="${item.bt }">${fn:substring(item.bt, 0, 18)}</a></li>
                         </c:if>
                         <c:set var="lm2" value="${lm2+1}"></c:set>
                         </c:if>
                        </c:forEach>                    	
                        </ul>
                    	</div>
                    </div>
                	<div class="xxgk_list1" id="div_xxgk2">
                    	<div style="margin:5px;">
                        	<div class="xxgk_bt1" onmouseover="change('div_xxgk2','xxgk_list1','xxgk_list3','xxgk_list4','xxgk_xmgl','xxgk_ghjh');" id="xxgk_xmgl"><a href="subcolumn.htm?loc=xxgk#60"  target="_blank">机关党建</a></div>
                            <div class="xxgk_bt2" onmouseover="change('div_xxgk2','xxgk_list2','xxgk_list4','xxgk_list3','xxgk_ghjh','xxgk_xmgl');" id="xxgk_ghjh"><a href="subcolumn.htm?loc=xxgk#61"  target="_blank">效能建设</a></div>
                        </div>
                        <div id="xxgk_list3">
                            <ul class="xxgklist">
                            <c:set var="lm3" value="1" scope="page"></c:set>
                        <c:forEach items="${itemList}" var="item">
                         <c:if test="${item.lmid==60}">
                         <c:if test="${lm3<6}">
                         <li><span><fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd" type="date" dateStyle="long" /></span>·<a href="ShowArticle.htm?lb=info&id=${item.id }" target="_blank" title="${item.bt }">${fn:substring(item.bt, 0, 18)}</a></li>
                         </c:if>
                           <c:set var="lm3" value="${lm3+1}"></c:set>
                         </c:if>
                        </c:forEach>
                        </ul>
                    	</div>
                        <div id="xxgk_list4" style="display:none;">
                            <ul class="xxgklist">
                              <c:set var="lm4" value="1" scope="page"></c:set>
	                         <c:forEach items="${itemList}" var="item">
	                         <c:if test="${item.lmid==61}">
	                         <c:if test="${lm4<6}">
	                         <li><span><fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd" type="date" dateStyle="long" /></span>·<a href="ShowArticle.htm?lb=info&id=${item.id }" target="_blank" title="${item.bt }">${fn:substring(item.bt, 0, 18)}</a></li>
	                         </c:if>
	                         <c:set var="lm4" value="${lm4+1}"></c:set>
                             </c:if>
	                        </c:forEach>
                            </ul>
                    	</div>
                    </div>
                </div>
                <div class="index_left_tpxx">
                	<span class="index_more" style="display:none;"><a href="" target="_blank">更多>></a></span>
                </div>
                <div class="index_left_tpxx1">
                <div id="demo">
					<div id="indemo">
					<div id="demo1">
						<c:forEach items="${gdlist}" var="gd" varStatus="status">
						    <c:if test="${status.count<11}">		
							<div class="index_left_tpxx2"><div class="tpxx_img"><a href="ShowArticle.htm?lb=info&id=${gd.id }" target="_blank"><img src="<%=basePath%>${gd.lstp }" border="0" /></a></div>
                        	<div class="tpxx_text"><a href="ShowArticle.htm?lb=info&id=${gd.id }" target="_blank">${gd.bt }</a></div></div>
						    </c:if>
			            </c:forEach>
					</div>
					<div id="demo2"></div>
					</div>
				</div>

                </div>
                <div class="index_left_link" id="link">
                	<div style="height:30px; text-align:left;"><img src="images/yqlj.jpg"></div>
                    <div class="index_left_link1">
                    	<div>国家、省各级部门导航</div>
                        <div class="index_left_link2">
	                        <ul class="link">
		                        <c:forEach items="${urllist}" var="item">
		                         <c:if test="${item.lb==1}">
		                         <li><a href="http://${item.url }" target="_blank">·${item.mc }</a></li>
	                             </c:if>
		                        </c:forEach>
	                        </ul>
                        </div>
                    </div>
                    <div class="index_left_link1">
                    	<div>市级各级部门导航</div>
                        <div class="index_left_link2">
                        	<ul class="link">
		                        <c:forEach items="${urllist}" var="item">
		                         <c:if test="${item.lb==2}">
		                         <li><a href="http://${item.url }" target="_blank">·${item.mc }</a></li>
	                             </c:if>
		                        </c:forEach>
	                        </ul>
                        </div>
                    </div>
                    <div class="index_left_link1">
                    	<div>县区各级部门导航</div>
                        <div class="index_left_link2">
                        	<ul class="link">
		                        <c:forEach items="${urllist}" var="item">
		                         <c:if test="${item.lb==3}">
		                         <li><a href="http://${item.url }" target="_blank">·${item.mc }</a></li>
	                             </c:if>
		                        </c:forEach>
	                        </ul>
                        </div>
                    </div>
                    <div class="index_left_link1">
                    	<div>其他导航链接</div>
                        <div class="index_left_link2">
                        	<ul class="link">
		                        <c:forEach items="${urllist}" var="item">
		                         <c:if test="${item.lb==4}">
		                         <li><a href="http://${item.url }" target="_blank">·${item.mc }</a></li>
	                             </c:if>
		                        </c:forEach>
	                        </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="index_right">
            	<a href="ldxx.html" target="_blank"><img src="images/ldxx.jpg" /></a>
                <div style="height:10px;"></div>
                <a href="http://211.149.172.65:8081/" target="_blank"><img src="images/oa.jpg" /></a>
                <div style="height:10px;"></div>
                <a href="admin/xmgl_login.html" target="_blank"><img src="images/xmglxt.jpg" /></a>
                <div style="height:10px;"></div>
                <img src="images/wsbs.jpg" />
                <div style="border:solid 1px #ccc; border-top:0px;height:110px;">
                	<div style="width:70px; float:left; text-align:center; margin-left:40px;">
                    	<a href="subcolumn.htm?loc=wsbs#62" target="_blank"><img src="images/wsbs_bszn.jpg" border="0" /></a>
                    </div>
                    <div style="width:70px; float:left; text-align:center; margin-left:20px;">
                    	<a href="subcolumn.htm?loc=wsbs#63" target="_blank"><img src="images/wsbs_wjxz.jpg" border="0" /></a>
                    </div>
                </div>
                <div style="height:10px;"></div>
                <img src="images/gzcy.jpg" />
                <div style="border:solid 1px #ccc; border-top:0px;height:240px;">
                	<div style="width:108px; float:left; text-align:center; margin-left:8px;"> <a href="zxzx.html" target="_blank"><img src="images/gzcy_zxzx.jpg" border="0" /></a>
                    </div>
                    <div style="width:108px; float:left; text-align:center; margin-left:5px;"> <a href="zxzx.html" target="_blank"><img src="images/gzcy_jdts.jpg" border="0" /></a>
                    </div>
                    <div style="width:108px; float:left; text-align:center; margin-left:8px; margin-top:8px;"> <a href="myzj.html" target="_blank"><img src="images/gzcy_myzj.jpg" border="0" /></a>
                    </div>
                    <div style="width:108px; float:left; text-align:center; margin-left:5px; margin-top:8px;"> <a href="myzj.html" target="_blank"><img src="images/gzcy_xyxc.jpg" border="0" /></a>
                    </div>
                    <div style="width:220px;height:40px; float:left;  margin-left:8px; margin-top:10px; background-image:url(images/t_bg.jpg);">
                    	<div class="gzcy_bt1" id="gzcy_bt1" onmouseover="change_gzcy('gzcy_bt1','gzcy_bt2','gzcy_list1','gzcy_list2');"><div style="margin-top:10px;"><a href="wsdc.html"  target="_blank">网上调查</a></div></div>
                        <div class="gzcy_bt2" id="gzcy_bt2" onmouseover="change_gzcy('gzcy_bt2','gzcy_bt1','gzcy_list2','gzcy_list1');"><div style="margin-top:10px;"><a href="cjwt.html"  target="_blank">常见问题</a></div></div>
                    </div>
                    <div id="gzcy_list1">
                    	<ul class="gzcylist">
                        	<c:set var="vote1" value="1" scope="page"></c:set>
	                        <c:forEach items="${votelist}" var="vote">
	                         <c:if test="${vote1<5}">
	                         <li>·<a href="Vote?act=vote&id=${vote.id }" target="_blank" title="${vote.zt}">${fn:substring(vote.zt, 0, 15)}</a></li>
	                         </c:if>
	                        </c:forEach>
                    	</ul>
                    </div>
                    <div id="gzcy_list2" style="display:none;">
                    	<ul class="gzcylist">
                        <c:set var="question1" value="1" scope="page"></c:set>
	                        <c:forEach items="${questionlist}" var="question">
	                         <c:if test="${question1<5}">
	                         <li>·<a href="ShowArticle.htm?lb=question&id=${question.id }" target="_blank" title="${question.question}">${fn:substring(question.question, 0, 15)}</a></li>
	                         </c:if>
	                        </c:forEach>
                    	</ul>
                    </div>
                </div>
                 <div style="height:10px;"></div>
                    <img src="images/ztlmxx.jpg">
                    <div style="width:238px; height:303px;border:solid 1px #ccc; border-top:0px; text-align:center; padding:auto;">
                        <center>
                        	<div style="height:10px;"></div>
                            <div style="width:220px;"> <a href="SubjectColumn?loc=showzt&ztid=4" target="_blank"><img src="images/ztlm_zdxmqktb.jpg"></a>
                          </div>
                            <div style="width:220px; margin-top:8px;"> <a href="SubjectColumn?loc=showzt&ztid=12" target="_blank"><img src="images/ztlm_zdxmjb.jpg"></a>
                        </div>
                            <div style="width:220px; margin-top:8px;"> <a href="SubjectColumn?loc=showzt&ztid=19" target="_blank"><img src="images/ztlm_lysswxm.jpg"></a>
                        </div>
                            <div style="height:10px;"></div>
                        </center>
                    </div>
                    
                    <div style="width:240px;height:200px; border:solid 1px #ccc; margin-top:10px; background-image:url(images/t_bg.jpg); background-repeat:repeat-x;">
                    	<div class="ph_bt1" id="ph_bt1" onmouseover="change_ph('ph_bt1','ph_bt2','ph_list1','ph_list2');"><div style="margin-top:10px;">文章排行</div></div>
                        <div class="ph_bt2" id="ph_bt2" onmouseover="change_ph('ph_bt2','ph_bt1','ph_list2','ph_list1');"><div style="margin-top:10px;">栏目排行</div></div>
                        <div id="ph_list1">
                    	<ul class="phlist">
                        	<c:forEach items="${wzphlist}" var="item">
	                         <li><a href="ShowArticle.htm?lb=info&id=${item.id }" target="_blank">·${fn:substring(item.bt, 0, 15)}</a></li>
	                        </c:forEach>
                    	</ul>
                    </div>
                    <div id="ph_list2" style="display:none;">
                    	<ul class="phlist">
                        	<c:forEach items="${lmphlist}" var="item">
	                         <li>·${item.lmmc }&nbsp;[${item.llcs }]</li>
	                        </c:forEach>
                    	</ul>
                    </div>
                    </div>
                <div style="clear:both;"></div>
            </div>
        </div>
        <div style="clear:both;"></div>
    <div style=" text-align:center;">
	    <iframe src="footer.html" id="footframe" name="footframe" style="width:1000px;height:90px;margin-top:10px;" frameborder="0" scrolling="no"></iframe>
	</div> 
	</div>
         <!-- 滚动图片区域 -->
        <script type="text/javascript">
        
        $('#change_33 div.changeDiv').soChange({//对象指向层，层内包含图片及标题
		thumbObj:'#change_33 .ul_change_a2 span',
		thumbNowClass:'on'//自定义导航对象当前class为on
		});
	
        var speed=40;
		var tab=document.getElementById("demo");
		var tab1=document.getElementById("demo1");
		var tab2=document.getElementById("demo2");
		tab2.innerHTML=tab1.innerHTML;
		function Marquee(){
		if(tab2.offsetWidth-tab.scrollLeft<=0)
		tab.scrollLeft-=tab1.offsetWidth
		else{
		tab.scrollLeft++;
		}
		}
		var MyMar=setInterval(Marquee,speed);
		tab.onmouseover=function() {clearInterval(MyMar)};
		tab.onmouseout=function() {MyMar=setInterval(Marquee,speed)};
        </script>
        
         <c:forEach items="${adverts}" var="a" >
		    <c:if test="${a.id==3&&a.status==1}">
		    <div class="the_left_advert" id="the_left_advert">
            	<div align="right" style="position: absolute;top:0px;right:0px;margin:0px;padding:0px;z-index:2000;"><a href="javascript:;" onclick="document.getElementById('the_left_advert').style.display='none';" style="color:#000000;text-decoration:none;font-size:12px;">关闭</a></div>
		    <c:if test="${a.url!=''}">
	        <a href="${a.url }" target="_blank"></c:if>
		    <img src="<%=basePath%>${a.imgurl}" />
		    <c:if test="${a.url!=''}">
		    </a></c:if>
		    </div>
		    </c:if>
	    </c:forEach>
	    
	    <c:forEach items="${adverts}" var="a" >
		    <c:if test="${a.id==4&&a.status==1}">
		    <div class="the_right_advert" id="the_right_advert">
            	<div align="right" style="position: absolute;top:0px;right:0px;margin:0px;padding:0px;z-index:2000;"><a href="javascript:;" onclick="document.getElementById('the_right_advert').style.display='none';" style="color:#000000;text-decoration:none;font-size:12px;">关闭</a></div>
		    <c:if test="${a.url!=''}">
	        <a href="${a.url }" target="_blank"></c:if>
		    <img src="<%=basePath%>${a.imgurl}"/>
		    <c:if test="${a.url!=''}">
		    </a></c:if>
		    </div>
		    </c:if>
	    </c:forEach>
	    
	    <c:forEach items="${adverts}" var="a" >
		    <c:if test="${a.id==5&&a.status==1}">
		    <div class="the_tc_advert" id="the_tc_advert">
            	<div align="right" style="position: absolute;top:0px;right:0px;margin:0px;padding:0px;z-index:2000;"><a href="javascript:;" onclick="document.getElementById('the_tc_advert').style.display='none';" style="color:#000000;text-decoration:none;font-size:12px;">关闭</a></div>
    		<c:if test="${a.url!=''}">
	        <a href="${a.url }" target="_blank"></c:if>
		    <img src="<%=basePath%>${a.imgurl}"/>
		     <c:if test="${a.url!=''}">
		    </a></c:if>
		   
		    </div>
		    </c:if>
	    </c:forEach>
	    
	    <c:forEach items="${adverts}" var="a" >
		    <c:if test="${a.id==6&&a.status==1}">

		    <script type="text/javascript">
		    (function($){
				$.fn.floatAd = function(options){
					var defaults = {
						imgSrc : "", //漂浮图片路径
						url : "", //图片点击跳转页
						openStyle : 1, //跳转页打开方式 1为新页面打开  0为当前页打开
						speed : 10 //漂浮速度 单位毫秒
					};
					var options = $.extend(defaults,options);
					var _target = options.openStyle == 1 ?  "target='_blank'" : '' ;
					var html = "<div id='float_ad' style='position:absolute;left:0px;top:0px;z-index:1000000;cleat:both;'>";
			            html += "  <a href='" + options.url + "' " + _target + "><img src='" + options.imgSrc + "' border='0' class='float_ad_img'/></a> <a href='javascript:;' id='close_float_ad' style=''>关闭</a>";
			            html += "</div>";
			
			        $('body').append(html);
						
						
					function init(){
						var x = 0,y = 0 
						var xin = true, yin = true 
						var step = 1 
						var delay = 10 
						var obj=$("#float_ad") 
						obj.find('img.float_ad_img').load(function(){
							var float = function(){
							    var L = T = 0;
								var OW = obj.width();//当前广告的宽
								var OH = obj.height();//高
								var DW = $(document).width(); //浏览器窗口的宽
								var DH = $(document).height(); 
			
			 				    x = x + step *( xin ? 1 : -1 ); 
								if (x < L) { 
									xin = true; x = L
								} 
								if (x > DW-OW-1){//-1为了ie
									xin = false; x = DW-OW-1
								} 
								
								y = y + step * ( yin ? 1 : -1 ); 
								if (y > DH-OH-1) { 
								
									yin = false; y = DH-OH-1 ;
								}
								if (y < T) {
									yin = true; y = T
								} 
								
								var left = x ; 
								var top = y; 
								
								obj.css({'top':top,'left':left});
							}
							var itl = setInterval(float,options.speed);
							$('#float_ad').mouseover(function(){clearInterval(itl)}); 
							$('#float_ad').mouseout(function(){itl=setInterval(float, options.speed)} )
						});
						// 点击关闭
						$('#close_float_ad').live('click',function(){
						    $('#float_ad').hide();
						});
					}
			
				   init();
				
				}; //floatAd
				
			
			})(jQuery);
		    
		    </script>
		    
		   <script type="text/javascript">
				$(function(){
				
					//调用漂浮插件
					$("body").floatAd({
						imgSrc : '<%=basePath%>${a.imgurl}',
						url: '${a.url}'
					});
				})
	        </script>
		    </c:if>
	    </c:forEach>
	    
</body>
</html>
