<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page contentType="text/html; charset=UTF-8"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="style.css" />
		<script type="text/javascript" src="js/js.js">
</script>
		<script type="text/javascript" src="js/index.js">
</script>
		<script src="Scripts/swfobject_modified.js" type="text/javascript">
</script>
		<script type="text/javascript" src="js/jquery-1.3.2.min.js">
</script>
		<script src="js/jquery.soChange-min.js" type="text/javascript">
</script>
		<style>
.hideTxt {
	width: 290px;
	white-space: nowrap;
	text-overflow: ellipsis;
	-o-text-overflow: ellipsis;
	overflow: hidden;
}

.fsize{
 font-size:13px;
}
#demo {background: #FFF;overflow:hidden;border: 0px;width: 710px;}
#indemo {float: left;width: 800%;}
#demo1 {float: left;}
#demo2 {float: left;} 

.index_left_tpxx{width:729px; height:30px; background-image:url(images/tpxx.jpg); background-repeat:no-repeat; margin-top:10px }
.index_left_tpxx1{width:727px; height:170px; border:solid 1px #ccc; background-image:url(images/t_bg.jpg); background-repeat:repeat-x;}
.index_left_tpxx2{float:left;width:195px;height:150px; margin-top:10px; margin-left:10px;}
.tpxx_img{width:193px;height:130px; border:solid 1px #ccc; text-align:center;}
.tpxx_img img{width:187px; height:124px; margin-top:3px;}
.tpxx_text{height:30px; line-height:20px; text-align:center;}
.index_left_link{width:727px;height:200px; border:solid 1px #ccc; margin-top:10px; background-image:url(images/t_bg.jpg); background-repeat:repeat-x; margin-top:10px}
.index_left_link1{width:165px;height:150px; float:left; margin-top:15px; margin-left:13px; text-align:left;}
.index_left_link2{width:165px;height:120px; border:solid 1px #ccc;margin-top:5px; overflow-y:scroll; line-height:1.5;}

</style>
		<script type="text/javascript">
function change_ph(str1, str2, str3, str4) {
	document.getElementById(str1).className = "ph_bt1";
	document.getElementById(str2).className = "ph_bt2";
	document.getElementById(str3).style.display = "";
	document.getElementById(str4).style.display = "none";
}
</script>
	</head>
	<body>
		<div id="div_top">
			<iframe src="top.html" id="topframe" name="topframe"
				style="width: 1000px; height: 225px;" frameborder="0" scrolling="no"></iframe>
		</div>
		<div id="div_midden">
			<div id="banner" style="margin-bottom: 10px;">
				<img src="images/syss.jpg" style="width: 1000px;" />
			</div>
			<div style="height: 300px;">
				<div
					style="width: 440px; height: 300px; float: left; border: solid 1px #eaeaea;">
					<iframe frameborder="0" height="300" name=focus noresize
						scrolling="no" src="pic.jsp" width="440"></iframe>
				</div>
				<div
					style="width: 540px; height: 300px; float: right; border: solid 0px #eaeaea;">
					<div
						style="background: url(images/lmbg1.gif); height: 30px; font-family: 'Microsoft Yahei'; font-size: 15px; line-height: 30px; color: #fff;">
						<span style="float: left; margin-left: 10px; letter-spacing: 4px;">
							工作动态
						</span>

					</div>
					<c:set var="lm2" value="1" scope="page"></c:set>
					<c:forEach items="${itemList}" var="item">
						<c:if test="${item.lmid==49}">
							<c:if test="${lm2<9}">
								<div style="border-bottom: 1px dashed;height:32px; line-height: 32px;color:#888">
								
									<div style="float:left;" >
										·
										<a style="color:#545454"; href="ShowArticle.htm?lb=info&id=${item.id }"
											target="_blank" title="${item.bt }">${fn:substring(item.bt,
											0, 25)}</a>
									</div>
									<div style="float: right;">
										<fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd"
											type="date" dateStyle="long" />
									</div>
								</div>
							</c:if>
							<c:set var="lm2" value="${lm2+1}"></c:set>
						</c:if>
					</c:forEach>
				</div>
			</div>
			<div style="clear: both; height: 10px;"></div>
			<div
				style="width: 240px; height: 1065px; float: left; background-color: #efefef; padding: 10px;">
				<div
					style="width: 240px; height: 30px; background: url(images/zfxxgkl.jpg);"></div>
				<div
					style="width: 238px; height: 220px; text-align: center; border: solid 1px #ccc; border-top: 0px; background: #fff;">
					<img src="images/zfxxgkl1.jpg" style="margin-top: 5px;"
						usemap="#Map" />
					<map name="Map" id="Map">
						<area shape="rect" coords="42,11,140,24"
							href="zfxxgk.htm?loc=zfxxgk&lb=gkzn" target="_blank" />
						<area shape="rect" coords="42,44,140,58"
							href="zfxxgk.htm?loc=zfxxgk&lb=gkml" target="_blank" />
						<area shape="rect" coords="42,76,140,91"
							href="zfxxgk.htm?loc=zfxxgk&lb=gkgd" target="_blank" />
						<area shape="rect" coords="42,110,140,124"
							href="zfxxgk.htm?loc=zfxxgk&lb=ysqgk" target="_blank" />
						<area shape="rect" coords="42,142,160,158"
							href="zfxxgk.htm?loc=zfxxgk&lb=ndbg" target="_blank" />
						<area shape="rect" coords="42,174,150,191" href="myzj.html"
							target="_blank" />
					</map>
				</div>
				<a href="ldxx.html" target="_blank"><img
						style="margin-top: 10px;" src="images/ldxx.jpg" />
				</a>
				<a href="admin/xmgl_login.html" target="_blank"><img
						style="margin-top: 10px;" src="images/xmglxt.jpg" />
				</a>
				<div
					style="background: url(images/wsbs.jpg); height: 38px; line-height: 30px; margin-top: 10px;">
					<span
						style="float: left; margin-left: 10px; font-family: 'Microsoft Yahei'; font-size: 15px; color: #fff;">网上办事</span>
				</div>
				<div
					style="width: 238px; height: 110px; text-align: center; border: solid 1px #ccc; border-top: 0px; background: #fff;">
					<a href="subcolumn.htm?loc=wsbs#62" target="_blank"><img
							src="images/wsbs_bszn.jpg" border="0" />
					</a>
					<a href="subcolumn.htm?loc=wsbs#63" target="_blank"><img
							src="images/wsbs_wjxz.jpg" border="0" />
					</a>
				</div>
				<div
					style="background: url(images/wsbs.jpg); height: 38px; line-height: 30px; margin-top: 10px;">
					<span
						style="float: left; margin-left: 10px; font-family: 'Microsoft Yahei'; font-size: 15px; color: #fff;">公众参与</span>
				</div>
				<div
					style="width: 238px; height: 250px; text-align: center; border: solid 1px #ccc; border-top: 0px; background: #fff;">
					<div style="width: 108px; text-align: center; margin-left: 8px; float: left;">
						<a href="zxzx.html" target="_blank"><img
								src="images/gzcy_zxzx.jpg" border="0" />
						</a>
					</div>
					<div
						style="width: 108px; text-align: center; margin-left: 8px; float: left;">
						<a href="zxzx.html" target="_blank"><img
								src="images/gzcy_jdts.jpg" border="0" />
						</a>
					</div>
					<div
						style="width: 108px; text-align: center; margin-left: 8px; margin-top: 8px; float: left;">
						<a href="myzj.html" target="_blank"><img
								src="images/gzcy_myzj.jpg" border="0" />
						</a>
					</div>
					<div
						style="width: 108px; text-align: center; margin-left: 8px; margin-top: 8px; float: left;">
						<a href="myzj.html" target="_blank"><img
								src="images/gzcy_xyxc.jpg" border="0" />
						</a>
					</div>
					<div style="clear: both; height: 1px;"></div>
					<div
						style="width: 220px; height: 200px; height: 100px; background: url(images/t_bg.jpg) repeat-x #fff; margin: 10px auto;">
						<div class="ph_bt1" id="gzcy_bt1">
							<a href="wsdc.html" target="_blank">网上调查</a>
						</div>
						<div id="gzcy_list1" style="clear: both;color:#888;text-align:left;">
							<ul class="gzcylist">
								<c:set var="vote1" value="1" scope="page"></c:set>
								<c:forEach items="${votelist}" var="vote">
									<c:if test="${vote1<5}">
										<li>
											·
											<a style="color:#545454" href="Vote?act=vote&id=${vote.id }" target="_blank"
												title="${vote.zt}">${fn:substring(vote.zt, 0, 15)}</a>
										</li>
									</c:if>
								</c:forEach>
							</ul>

						</div>
					</div>
				</div>
				<div
					style="height: 200px; border: solid 1px #ccc; background: url(images/t_bg.jpg) repeat-x #fff; margin-top: 10px;">
					<div class="ph_bt1" id="ph_bt1"
						onmouseover="change_ph('ph_bt1','ph_bt2','ph_list1','ph_list2');">
						文章排行
					</div>
					<div class="ph_bt2" id="ph_bt2"
						onmouseover="change_ph('ph_bt2','ph_bt1','ph_list2','ph_list1');">
						栏目排行
					</div>

					<div id="ph_list1" style="clear: both;color:#888;width:210px;margin:0 auto;">
						<ul class="phlist">
							<c:forEach items="${wzphlist}" var="item">
								<li style="line-height: 23px;height:23px;">
									<a style="color:#545454" href="ShowArticle.htm?lb=info&id=${item.id }"
										target="_blank">·${fn:substring(item.bt, 0, 15)}</a>
										<div style="height:1px;border-bottom: dashed 1px;width:90%;margin-left:5px"></div>
								</li>
							</c:forEach>
						</ul>
					</div>
					<div id="ph_list2" style="display: none; clear: both;color:#545454;width:210px;margin:0 auto;">
						<ul class="phlist">
							<c:forEach items="${lmphlist}" var="item">
								<li style="line-height: 25px;height:25px;">
									·${item.lmmc }&nbsp;&nbsp;[${item.llcs }]
									<div style="height:1px;border-bottom: dashed 1px;width:90%;margin-left:5px"></div>
								</li>
								
							</c:forEach>
						</ul>
					</div>
				</div>
				<div style="clear: both;"></div>
			</div>
			<div style="float: right; width: 726px; height: 1085px;">
				<div style="height: 220px;">
					<div style="float: left; width: 358px;">
						<div
							style="height: 30px; background: url(images/lmbg2.gif) repeat-x;">
							<ul class="ul_lmbt">
								<li class="li_lmbt">
									通知公告
								</li>

							</ul>
						</div>

						<c:set var="lm2" value="1" scope="page"></c:set>
						<c:forEach items="${itemList}" var="item">
							<c:if test="${item.lmid==50}">
								<c:if test="${lm2<7}">
									<div style="border-bottom: 1px dashed;height:28px; line-height: 28px;color:#888">
										<div style="float: left;" class="hideTxt">
											·<a class="fszie" style="color:#545454;" href="ShowArticle.htm?lb=info&id=${item.id }"
												target="_blank" title="${item.bt }">${fn:substring(item.bt,
												0, 25)}</a>
										</div>
										<div style="float: right;">
											<fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd"
												type="date" dateStyle="long" />
										</div>
									</div>
								</c:if>
								<c:set var="lm2" value="${lm2+1}"></c:set>
							</c:if>
						</c:forEach>
					</div>
					<div style="float: right; width: 358px;">
						<div style="height: 30px; background: url(images/lmbg2.gif) repeat-x;">
							<ul class="ul_lmbt">
								<li onmouseover="change5('xmzj')"  id="xmzj" class="li_lmbt">
									项目征集
								</li>
								<li onmouseover="change5('xmsb')"  id="xmsb">
									项目申报
								</li>
								<li onmouseover="change5('xmcs')"  id="xmcs">
									项目初审
								</li>
								<li onmouseover="change5('zjps')"  id="zjps">
									专家评审
								</li>
							</ul>
						</div>
						
						<div id="xmzj_list1">
							<ul class="xxgklist">
								<c:set var="lm13" value="1" scope="page"></c:set>
								<c:forEach items="${itemList}" var="item">
									<c:if test="${item.lmid==82}">
										<c:if test="${lm13<6}">
											<div style="border-bottom: 1px dashed; height:28px; line-height: 28px;color:#888">
											
												<div style="float: left;" class="hideTxt">
													·
													<a style="color:#545454" href="ShowArticle.htm?lb=info&id=${item.id }"
														target="_blank" title="${item.bt }">${fn:substring(item.bt,0, 18)}</a>
												</div>
												<div style="float: right;">
													<fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd"
														type="date" dateStyle="long" />
												</div>
											</div>
										</c:if>
										<c:set var="lm13" value="${lm13+1}"></c:set>
									</c:if>
								</c:forEach>
							</ul>
						</div>

						<div id="xmzj_list2" style="display: none;">
							<ul class="xxgklist">
								<c:set var="lm14" value="1" scope="page"></c:set>
								<c:forEach items="${itemList}" var="item">
									<c:if test="${item.lmid==83}">
										<c:if test="${lm14<6}">
											<div style="border-bottom: 1px dashed; height:28px; line-height: 28px;color:#888">
												
												<div style="float: left;" class="hideTxt">
													·
													<a style="color:#545454" href="ShowArticle.htm?lb=info&id=${item.id }"
														target="_blank" title="${item.bt }">${fn:substring(item.bt,
														0, 18)}</a>
												</div>
												<div style="float: right;">
													<fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd"
														type="date" dateStyle="long" />
												</div>
											</div>
										</c:if>
										<c:set var="lm14" value="${lm14+1}"></c:set>
									</c:if>
								</c:forEach>
							</ul>
						</div>

						<div id="xmzj_list3" style="display: none;">
							<ul class="xxgklist">
								<c:set var="lm15" value="1" scope="page"></c:set>
								<c:forEach items="${itemList}" var="item">
									<c:if test="${item.lmid==84}">
										<c:if test="${lm15<6}">
											<div style="border-bottom: 1px dashed; height:28px; line-height: 28px;color:#888">
												
												<div style="float: left;" class="hideTxt">
													·
													<a style="color:#545454" href="ShowArticle.htm?lb=info&id=${item.id }"
														target="_blank" title="${item.bt }">${fn:substring(item.bt,
														0, 18)}</a>
												</div>
												<div style="float: right;">
													<fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd"
														type="date" dateStyle="long" />
												</div>
											</div>
										</c:if>
										<c:set var="lm15" value="${lm15+1}"></c:set>
									</c:if>
								</c:forEach>
							</ul>
						</div>
						
						
						<div id="xmzj_list4" style="display: none;">
							<ul class="xxgklist">
								<c:set var="lm16" value="1" scope="page"></c:set>
								<c:forEach items="${itemList}" var="item">
									<c:if test="${item.lmid==85}">
										<c:if test="${lm16<6}">
											<div style="border-bottom: 1px dashed; height:28px; line-height: 28px;color:#888">
												
												<div style="float: left;" class="hideTxt">
													·
													<a style="color:#545454" href="ShowArticle.htm?lb=info&id=${item.id }"
														target="_blank" title="${item.bt }">${fn:substring(item.bt,
														0, 18)}</a>
												</div>
												<div style="float: right;">
													<fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd"
														type="date" dateStyle="long" />
												</div>
											</div>
										</c:if>
										<c:set var="lm16" value="${lm16+1}"></c:set>
									</c:if>
								</c:forEach>
							</ul>
						</div>
						
						
						
						
					</div>
				</div>
				<div style="height: 220px;">
					<div style="float: left; width: 358px;">
						<div style="height: 30px; background: url(images/lmbg2.gif) repeat-x;">
							<ul class="ul_lmbt">
								<li onmouseover="change4('xmsh')" id="xmsh">
									项目审核
								</li>
								
							    <li onmouseover="change4('xmcb')"  id="xmcb"  class="li_lmbt">
									项目储备
								</li>
								<li onmouseover="change4('cbxm')" id="cbxm">
									储备项目
								</li>
							</ul>
						</div>
						<div id="xmcb_list1">
							<ul class="xxgklist">
								<c:set var="lm17" value="1" scope="page"></c:set>
								<c:forEach items="${itemList}" var="item">
									<c:if test="${item.lmid==86}">
										<c:if test="${lm17<6}">
											<div style="border-bottom: 1px dashed; height:28px; line-height: 28px;color:#888">
											
												<div style="float: left;" class="hideTxt">
													·
													<a style="color:#545454" href="ShowArticle.htm?lb=info&id=${item.id }"
														target="_blank" title="${item.bt }">${fn:substring(item.bt,0, 18)}</a>
												</div>
												<div style="float: right;">
													<fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd"
														type="date" dateStyle="long" />
												</div>
											</div>
										</c:if>
										<c:set var="lm17" value="${lm17+1}"></c:set>
									</c:if>
								</c:forEach>
							</ul>
						</div>

						<div id="xmcb_list2" style="display: none;">
							<ul class="xxgklist">
								<c:set var="lm18" value="1" scope="page"></c:set>
								<c:forEach items="${itemList}" var="item">
									<c:if test="${item.lmid==87}">
										<c:if test="${lm18<6}">
											<div style="border-bottom: 1px dashed; height:28px; line-height: 28px;color:#888">
												
												<div style="float: left;" class="hideTxt">
													·
													<a style="color:#545454" href="ShowArticle.htm?lb=info&id=${item.id }"
														target="_blank" title="${item.bt }">${fn:substring(item.bt,
														0, 18)}</a>
												</div>
												<div style="float: right;">
													<fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd"
														type="date" dateStyle="long" />
												</div>
											</div>
										</c:if>
										<c:set var="lm18" value="${lm18+1}"></c:set>
									</c:if>
								</c:forEach>
							</ul>
						</div>
						
						<div id="xmcb_list3" style="display: none;">
							<ul class="xxgklist">
								<c:set var="lm19" value="1" scope="page"></c:set>
								<c:forEach items="${itemList}" var="item">
									<c:if test="${item.lmid==88}">
										<c:if test="${lm19<6}">
											<div style="border-bottom: 1px dashed; height:28px; line-height: 28px;color:#888">
												
												<div style="float: left;" class="hideTxt">
													·
													<a style="color:#545454" href="ShowArticle.htm?lb=info&id=${item.id }"
														target="_blank" title="${item.bt }">${fn:substring(item.bt,
														0, 18)}</a>
												</div>
												<div style="float: right;">
													<fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd"
														type="date" dateStyle="long" />
												</div>
											</div>
										</c:if>
										<c:set var="lm19" value="${lm19+1}"></c:set>
									</c:if>
								</c:forEach>
							</ul>
						</div>
						
					</div>
					<div style="float: right; width: 358px;">
						<div class="ul_lmbt"
							style="height: 30px; background: url(images/lmbg2.gif) repeat-x;">
							<ul class="ul_lmbt">
								<li id="tzhj" class="li_lmbt" onmouseover="change2('tzhj')">
									投资环境
								</li>
								<li id="yhzc" onmouseover="change2('yhzc')">
									优惠政策
								</li>
								<li id="zsxm" onmouseover="change2('zsxm')">
									招商项目
								</li>
							</ul>
						</div>
						<div id="xmjs_list9">
							<ul class="xxgklist">
								<c:set var="lm12" value="1" scope="page"></c:set>
								<c:forEach items="${itemList}" var="item">
									<c:if test="${item.lmid==56}">
										<c:if test="${lm12<6}">
											<div style="border-bottom: 1px dashed; height:28px; line-height: 28px;color:#888">
											
												<div style="float: left;" class="hideTxt">
													·
													<a style="color:#545454" href="ShowArticle.htm?lb=info&id=${item.id }"
														target="_blank" title="${item.bt }">${fn:substring(item.bt,0, 18)}</a>
												</div>
												<div style="float: right;">
													<fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd"
														type="date" dateStyle="long" />
												</div>
											</div>
										</c:if>
										<c:set var="lm12" value="${lm12+1}"></c:set>
									</c:if>
								</c:forEach>
							</ul>
						</div>

						<div id="xmjs_list8" style="display: none;">
							<ul class="xxgklist">
								<c:set var="lm11" value="1" scope="page"></c:set>
								<c:forEach items="${itemList}" var="item">
									<c:if test="${item.lmid==58}">
										<c:if test="${lm11<6}">
											<div style="border-bottom: 1px dashed; height:28px; line-height: 28px;color:#888">
												
												<div style="float: left;" class="hideTxt">
													·
													<a style="color:#545454" href="ShowArticle.htm?lb=info&id=${item.id }"
														target="_blank" title="${item.bt }">${fn:substring(item.bt,
														0, 18)}</a>
												</div>
												<div style="float: right;">
													<fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd"
														type="date" dateStyle="long" />
												</div>
											</div>
										</c:if>
										<c:set var="lm11" value="${lm11+1}"></c:set>
									</c:if>
								</c:forEach>
							</ul>
						</div>

						<div id="xmjs_list10" style="display: none;">
							<ul class="xxgklist">
								<c:set var="lm10" value="1" scope="page"></c:set>
								<c:forEach items="${itemList}" var="item">
									<c:if test="${item.lmid==57}">
										<c:if test="${lm10<6}">
											<div style="border-bottom: 1px dashed; height:28px; line-height: 28px;color:#888">
												
												<div style="float: left;" class="hideTxt">
													·
													<a style="color:#545454" href="ShowArticle.htm?lb=info&id=${item.id }"
														target="_blank" title="${item.bt }">${fn:substring(item.bt,
														0, 18)}</a>
												</div>
												<div style="float: right;">
													<fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd"
														type="date" dateStyle="long" />
												</div>
											</div>
										</c:if>
										<c:set var="lm10" value="${lm10+1}"></c:set>
									</c:if>
								</c:forEach>
							</ul>
						</div>

					</div>
				</div>
				<div
					style="float: right; width: 726px; height: 140px; margin: 10px 0px; display: none;">
					<img src="images/banner.jpg" />
				</div>
				<div style="clear: both;"></div>
				<div style="height: 220px;">
					<div style="float: left; width: 358px;">
						<div
							style="height: 30px; background: url(images/lmbg2.gif) repeat-x;">
							<ul class="ul_lmbt">
								<li onmouseover="change6('xmkg')"  id="xmkg" class="li_lmbt">
									项目开工
								</li>
								<li onmouseover="change6('xmjs')"  id="xmjs">
									项目建设
								</li>
							</ul>
						</div>
						
						<div id="xmjs_list1">
							<ul class="xxgklist">
								<c:set var="lm20" value="1" scope="page"></c:set>
								<c:forEach items="${itemList}" var="item">
									<c:if test="${item.lmid==89}">
										<c:if test="${lm20<6}">
											<div style="border-bottom: 1px dashed; height:28px; line-height: 28px;color:#888">
											
												<div style="float: left;" class="hideTxt">
													·
													<a style="color:#545454" href="ShowArticle.htm?lb=info&id=${item.id }"
														target="_blank" title="${item.bt }">${fn:substring(item.bt,0, 18)}</a>
												</div>
												<div style="float: right;">
													<fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd"
														type="date" dateStyle="long" />
												</div>
											</div>
										</c:if>
										<c:set var="lm20" value="${lm20+1}"></c:set>
									</c:if>
								</c:forEach>
							</ul>
						</div>

						<div id="xmjs_list2" style="display: none;">
							<ul class="xxgklist">
								<c:set var="lm21" value="1" scope="page"></c:set>
								<c:forEach items="${itemList}" var="item">
									<c:if test="${item.lmid==90}">
										<c:if test="${lm21<6}">
											<div style="border-bottom: 1px dashed; height:28px; line-height: 28px;color:#888">
												
												<div style="float: left;" class="hideTxt">
													·
													<a style="color:#545454" href="ShowArticle.htm?lb=info&id=${item.id }"
														target="_blank" title="${item.bt }">${fn:substring(item.bt,
														0, 18)}</a>
												</div>
												<div style="float: right;">
													<fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd"
														type="date" dateStyle="long" />
												</div>
											</div>
										</c:if>
										<c:set var="lm21" value="${lm21+1}"></c:set>
									</c:if>
								</c:forEach>
							</ul>
						</div>
					</div>
					<div style="float: right; width: 358px;">
						<div
							style="height: 30px; background: url(images/lmbg2.gif) repeat-x;">
							<ul class="ul_lmbt">
								<li id="wjtz" onmouseover="change3('wjtz')" class="li_lmbt">
									文件通知
								</li>
								<li id="zcfg" onmouseover="change3('zcfg')">
									政策法规
								</li>
								<li id="jgdj" onmouseover="change3('jgdj')">
								   机关党建
								</li>
								<li id="xnjs" onmouseover="change3('xnjs')">
									效能建设
								</li>
							</ul>
						</div>
						<div id="xxgk_list1">
							<ul class="xxgklist">
								<c:set var="lm1" value="1" scope="page"></c:set>
								<c:forEach items="${itemList}" var="item">
									<c:if test="${item.lmid==75}">
										<c:if test="${lm1<6}">
											<div style="border-bottom: 1px dashed; height:28px; line-height: 28px;color:#888">
									
												<div style="float: left;" class="hideTxt">
													·
													<a style="color:#545454" href="ShowArticle.htm?lb=info&id=${item.id }"
														target="_blank" title="${item.bt }">${fn:substring(item.bt,
														0, 18)}</a>
												</div>
												<div style="float: right;">
													<fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd"
														type="date" dateStyle="long" />
												</div>
											</div>
										</c:if>
										<c:set var="lm1" value="${lm1+1}"></c:set>
									</c:if>
								</c:forEach>
							</ul>
						</div>

						<div id="xxgk_list2" style="display: none;">
							<ul class="xxgklist">
								<c:set var="lm2" value="1" scope="page"></c:set>
								<c:forEach items="${itemList}" var="item">
									<c:if test="${item.lmid==51}">
										<c:if test="${lm2<6}">
											<div style="border-bottom: 1px dashed;height:28px; line-height: 28px;color:#888">
										
												<div style="float: left;" class="hideTxt">
													·
													<a style="color:#545454" href="ShowArticle.htm?lb=info&id=${item.id }"
														target="_blank" title="${item.bt }">${fn:substring(item.bt,
														0, 18)}</a>
												</div>
												<div style="float: right;">
													<fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd"
														type="date" dateStyle="long" />
												</div>
											</div>
										</c:if>
										<c:set var="lm2" value="${lm2+1}"></c:set>
									</c:if>
								</c:forEach>
							</ul>
						</div>

						<div id="xxgk_list3" style="display: none;">
							<ul class="xxgklist">
								<c:set var="lm3" value="1" scope="page"></c:set>
								<c:forEach items="${itemList}" var="item">
									<c:if test="${item.lmid==60}">
										<c:if test="${lm3<6}">
											<div style="border-bottom: 1px dashed; line-height: 21px;color:#888">
												&nbsp;
												<div style="float: left;" class="hideTxt">
													·
													<a style="color:#545454" href="ShowArticle.htm?lb=info&id=${item.id }"
														target="_blank" title="${item.bt }">${fn:substring(item.bt,
														0, 18)}</a>
												</div>
												<div style="float: right;">
													<fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd"
														type="date" dateStyle="long" />
												</div>
											</div>
										</c:if>
										<c:set var="lm3" value="${lm3+1}"></c:set>
									</c:if>
								</c:forEach>
							</ul>
						</div>

						<div id="xxgk_list4" style="display: none;">
							<ul class="xxgklist">
								<c:set var="lm4" value="1" scope="page"></c:set>
								<c:forEach items="${itemList}" var="item">
									<c:if test="${item.lmid==61}">
										<c:if test="${lm4<6}">
											<div style="border-bottom: 1px dashed;height:28px; line-height: 28px;color:#888">
											
												<div style="float: left;" class="hideTxt">
													·
													<a style="color:#545454" href="ShowArticle.htm?lb=info&id=${item.id }"
														target="_blank" title="${item.bt }">${fn:substring(item.bt,
														0, 18)}</a>
												</div>
												<div style="float: right;">
													<fmt:formatDate value="${item.rq }" pattern="yyyy-MM-dd"
														type="date" dateStyle="long" />
												</div>
											</div>
										</c:if>
										<c:set var="lm4" value="${lm4+1}"></c:set>
									</c:if>
								</c:forEach>
							</ul>
						</div>

					</div>
				</div>
				<div style="height: 30px; background: url(images/twxx.jpg) no-repeat;">

				</div>
				<div style="height: 180px; border: solid 1px #ccc;" class="index_left_tpxx1">
                    
                 <div id="demo" style="margin:5px auto;background-image:url();">
					<div id="indemo">
					<div id="demo1">
						<c:forEach items="${gdlist}" var="gd" varStatus="status">
						    <c:if test="${status.count<11}">		
							<div class="index_left_tpxx2"><div class="tpxx_img"><a href="ShowArticle.htm?lb=info&id=${gd.id }" target="_blank"><img src="<%=basePath%>${gd.lstp }" border="0" /></a></div>
                        	<div class="tpxx_text"><a style="color:#545454" href="ShowArticle.htm?lb=info&id=${gd.id }" target="_blank">${gd.bt }</a></div></div>
						    </c:if>
			            </c:forEach>
					</div>
					<div id="demo2"></div>
					</div>
				</div>

                         
				</div>
				<div class="index_left_link" id="link">
				  <div style="height: 30px; background: url(images/yqlj.png) no-repeat;"></div>
				    <div class="index_left_link1" style="float:left;margin-left:10px">
                    	<div>国家、省各级部门导航</div>
                        <div class="index_left_link2" style="color:#888">
	                        <ul class="link">
		                        <c:forEach items="${urllist}" var="item">
		                         <c:if test="${item.lb==1}">
		                         <li><a style="color:#545454" href="http://${item.url }" target="_blank">·${item.mc }</a></li>
	                             </c:if>
		                        </c:forEach>
	                        </ul>
                        </div>
                    </div>
                    <div class="index_left_link1" style="float:left;margin-left:15px">
                    	<div>市级各级部门导航</div>
                        <div class="index_left_link2">
                        	<ul class="link">
		                        <c:forEach items="${urllist}" var="item">
		                         <c:if test="${item.lb==2}">
		                         <li><a style="color:#545454" href="http://${item.url }" target="_blank">·${item.mc }</a></li>
	                             </c:if>
		                        </c:forEach>
	                        </ul>
                        </div>
                    </div>
                    <div class="index_left_link1" style="float:left;margin-left:15px">
                    	<div>县区各级部门导航</div>
                        <div class="index_left_link2">
                        	<ul class="link">
		                        <c:forEach items="${urllist}" var="item">
		                         <c:if test="${item.lb==3}">
		                         <li><a style="color:#545454" href="http://${item.url }" target="_blank">·${item.mc }</a></li>
	                             </c:if>
		                        </c:forEach>
	                        </ul>
                        </div>
                    </div>
                    <div class="index_left_link1" style="float:left;margin-left:15px">
                    	<div>其他导航链接</div>
                        <div class="index_left_link2">
                        	<ul class="link">
		                        <c:forEach items="${urllist}" var="item">
		                         <c:if test="${item.lb==4}">
		                         <li><a style="color:#545454" href="http://${item.url }" target="_blank">·${item.mc }</a></li>
	                             </c:if>
		                        </c:forEach>
	                        </ul>
                        </div>
                    </div>
                </div>
		
			
		</div>
		<div style="height: 0px; clear: both;"></div>
		
		<div id="div_bottom">
			<iframe src="footer.html" id="footframe" name="footframe"
				style="width: 1000px; height: 90px;" frameborder="0" scrolling="no"></iframe>
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

	</body>
</html>
