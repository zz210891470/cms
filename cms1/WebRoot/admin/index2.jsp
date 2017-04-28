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
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>CMS网站内容管理系统</title>
    <script src="lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script> 
    <link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" /> 
    <script src="lib/ligerUI/js/ligerui.all.js" type="text/javascript"></script> 
    <link rel="stylesheet" href="css/zTreeStyle.css" type="text/css"/>
	<script type="text/javascript" src="js/jquery.ztree.core-3.4.min.js"></script>
	<script src="lib/json2.js" type="text/javascript"></script> 
        <script type="text/javascript">
        
        function onClick(event, treeId, obj, clickFlag) {
			//showLog("[ "+getTime()+" onClick ]&nbsp;&nbsp;clickFlag = " + clickFlag + " (" + (clickFlag===1 ? "普通选中": (clickFlag===0 ? "<b>取消选中</b>" : "<b>追加选中</b>")) + ")");
    
		    if(obj.pId==null||(obj!=null&&obj.children!=null&&obj.children.length!=null&&obj.children.length>0)){
	    
		    }else{
		    
		       f_addTab(obj.id,obj.name,'article/ArticleServlet?act=list&pid='+obj.id);
		      // $('#home').attr('src','article/ArticleServlet?act=list&pid='+obj.id);
		    }
		}
                
        function onClick2(event, treeId, obj, clickFlag) {
			//showLog("[ "+getTime()+" onClick ]&nbsp;&nbsp;clickFlag = " + clickFlag + " (" + (clickFlag===1 ? "普通选中": (clickFlag===0 ? "<b>取消选中</b>" : "<b>追加选中</b>")) + ")");
		
		    
		    if(obj.pId==null||(obj!=null&&obj.children!=null&&obj.children.length!=null&&obj.children.length>0)){
		      
		    
		    }else{
		    
		       f_addTab(obj.id,obj.name,'article/SubArticleServlet?act=list&pid='+obj.id);
		      // $('#home').attr('src','article/ArticleServlet?act=list&pid='+obj.id);
		    }
		}
			var indexdata1;
			var indexdata2;

            var tab = null;
            var accordion = null;
            var tree = null;
            
            $(function (){
              
              $.post("AjaxServlet?act=getColumnData",function(data1){
                   if(data1=="]"){
                      indexdata1=[{id:1,pId:0,name:'没有栏目',isParent:true}];
                   }
                   else{
                      indexdata1=JSON.parse(data1);
                   }
              $.post("AjaxServlet?act=getSubData",function(data2){
                   if(data2=="]"){
                     indexdata2=[{id:1,pId:0,name:'没有栏目',isParent:true}];
                   }
                   else{
                      indexdata2=JSON.parse(data2);
                   }

                //布局
                $("#layout1").ligerLayout({ leftWidth: 180, height: '100%',topHeight: 65, bottomHeight: 25,heightDiff:0,space:4, onHeightChanged: f_heightChanged });

                var height = $(".l-layout-center").height();

                //Tab
                $("#framecenter").ligerTab({ height: height });
				
                //左边导航面板
                $("#accordion1").ligerAccordion({ height: height - 25, speed: null });

                $(".l-link").hover(function ()
                {
                    $(this).addClass("l-link-over");
                }, function ()
                {
                    $(this).removeClass("l-link-over");
                });

                var setting = {
					data: {
						simpleData: {
							enable: true
						}
					},
			        callback: {
						onClick: onClick
			        }
				};
				var setting2 = {
					data: {
						simpleData: {
							enable: true
						}
					},
			        callback: {
						onClick: onClick2
			        }
				};
                
                $(document).ready(function(){
                
					//$.fn.zTree.init($("#tree1"), setting, indexdata1);
					//$.fn.zTree.init($("#tree2"), setting2, indexdata2);
				});
                
                //树
     /*           $("#tree1").ligerTree({
                    data : indexdata1,
                    checkbox: false,
                    slide: false,
                    nodeWidth: 110,
                    attribute: ['nodename', 'url'],
                    onSelect: function (node)
                    {
                        if (!node.data.url) return;
                        var tabid = $(node.target).attr("tabid");
                        if (!tabid)
                        {
                            tabid = new Date().getTime();
                            $(node.target).attr("tabid", tabid)
                        } 
                        f_addTab(tabid, node.data.text, node.data.url);
                    }
                });
				$("#tree2").ligerTree({
                    data : indexdata2,
                    checkbox: false,
                    slide: false,
                    nodeWidth: 110,
                    attribute: ['nodename', 'url'],
                    onSelect: function (node)
                    {
                        if (!node.data.url) return;
                        var tabid = $(node.target).attr("tabid");
                        if (!tabid)
                        {
                            tabid = new Date().getTime();
                            $(node.target).attr("tabid", tabid)
                        } 
                        f_addTab(tabid, node.data.text, node.data.url);
                    }
                });*/

                tab = $("#framecenter").ligerGetTabManager();
                accordion = $("#accordion1").ligerGetAccordionManager();
            //    tree = $("#tree1").ligerGetTreeManager();
				//tree.expandAll(); //默认展开所有节点
                $("#pageloading").hide();
                },'json');
               },'json');
            });
            
            function f_heightChanged(options){
                if (tab)
                    tab.addHeight(options.diff);
                if (accordion && options.middleHeight - 24 > 0)
                    accordion.setHeight(options.middleHeight - 24);
            }
            
            function f_addTab(tabid,text, url)
            { 
                tab.addTabItem({ tabid : tabid,text: text, url: url });
            } 
             
            function logout(){
            	if(confirm("确定要退出【CMS内容管理系统】？")){
		            location.href="LogoutServlet";
		       }
            }

     </script> 
	 
<style type="text/css"> 
	*{ scrollbar-face-color:#E6F2FD; scrollbar-highlight-color:#ffffff; scrollbar-shadow-color:#D6E4EF; scrollbar-3dlight-color:#F1F9FF; scrollbar-arrow-color:#006699;  scrollbar-track-color:#F1F9FF;  scrollbar-darkshadow-color:#F1F9FF; }
    body,html{height:100%;}
    body{ padding:0px; margin:0px;overflow:hidden; font-size:12px;}  
	form,ul,li,dl,dt,dd{ margin:0px; list-style-type:none; padding:0px; }
	table { empty-cells: show; border-collapse: collapse; }
	img{ border:0px; vertical-align:middle; }
	a{ color:#005eac; text-decoration:none;}
	a:visited,a:active{ color:#005eac; }
	a:hover{ color:#ff5500; }

    .l-link{ display:block; height:26px; line-height:26px; padding-left:10px; text-decoration:underline; color:#333;}
    .l-link2{text-decoration:underline; color:white; margin-left:2px;margin-right:2px;}
    .l-layout-top{background:#102A49; color:White;}
    .l-layout-bottom{ background:#E5EDEF; text-align:center;}
    #pageloading{position:absolute; left:0px; top:0px; background:white url('images/loading.gif') no-repeat center; width:100%; height:100%;z-index:99999;}
	
    .l-link{ display:block; line-height:22px; height:22px; padding-left:16px;border:1px solid white; margin:4px; text-decoration:none;}
    .l-link-over{ background:#FFEEAC; border:1px solid #DB9F00; text-decoration:none;} 
    .l-winbar{ background:#2B5A76; height:30px; position:absolute; left:0px; bottom:0px; width:100%; z-index:99999;}
    .space{ color:#E7E7E7;}
	
    /* 顶部 */ 
	.header{ background:url(images/head_bg.gif) repeat-x left bottom; color:#E8E8E8; font-family:Verdana, Geneva, sans-serif; }
	.logo{height:40px; width:350px; background-image:url(images/sys_logo.png); margin:5px 0 0 10px; }
	.header a{ color:#E8E8E8; text-decoration:none; }
	.header a:hover{ color:#FF0; text-decoration:none; }
	.header .header_box{ height:60px;padding-top:5px; }
	.header .header_box .header_right{float:right; margin:5px 10px auto auto; text-align:right; line-height:20px; }
	.header .header_box .header_right span{ padding-left:18px; background:url(images/memeber.gif) left center no-repeat; }
	.header .header_box .header_right span b{ font-weight:normal; color:#FF0; }

	/*导航标题ICON*/
	.menu-icon-setting,.menu-icon-member,.menu-icon-model,.menu-icon-plugins,.menu-icon-order{ display:block; float:left; margin-top:4px; width:18px; height:16px; background:url(images/menu_icons.gif) no-repeat; overflow:hidden; }
	.menu-icon-setting{ background-position:0px 0px; }
	.menu-icon-member{ background-position:0px -30px; }
	.menu-icon-model{ background-position:0px -60px; }
	.menu-icon-plugins{ background-position:0px -90px; }
	.menu-icon-order{ background-position:0px -120px; }

	/*右边Tabs标题图标*/
	.tab-icon-home{ padding-left:18px; background:url(images/home.gif) no-repeat left center; }
	
	/*左边导航样式*/
	.nlist li a{ display:block; line-height:22px; height:22px; padding-left:22px; background:url(images/nav_icon.gif) no-repeat 5px top; border:1px solid #fff; margin:3px 2px 0 2px; color:#333; text-decoration:none; }
	.nlist li a:hover{ border:1px solid #DB9F00; background:url(images/nav_icon.gif) no-repeat 5px -22px #FFEEAC; }
	.nlist li.title{ margin-top:5px; line-height:25px; font-weight:600; color:#090; padding-left:25px; background:url(images/nav_icon.gif) no-repeat 7px -50px;}
	.nlist li ul li{ margin-left:-13px; font-weight:normal; }

	.footer{height:30px; text-align:left; background:url(images/foot_bg.gif) repeat-x bottom; }
	.footer .copyright{ height:30px;line-height:30px; text-align:center; font-size:12px; color:#555;}
 </style>
</head>
<body style="padding:0px;background:url('images/head_bg_line.gif') repeat-x #e5edef" oncontextmenu="return false" ondragstart="return false" onselectstart ="return false" onselect="document.selection.empty()" oncopy="document.selection.empty()" onbeforecopy="return false">  
<div id="pageloading"></div>  
	<!--头部-->
	<div position="top" class="header">
		<div class="header_box">
			<div class="header_right">
				<span><b>${xm }</b> 您好，欢迎光临&nbsp;&nbsp;</span>
				<a href="javascript:f_addTab('password','密码修改','password.html')">密码修改</a> | 
				<a href="javascript:f_addTab('home','管理中心','WelcomeServlet')">管理中心</a> | 
				<a id="lbtnExit" href="#" onclick="logout();">安全退出</a>
			</div>
			<div class="logo"></div>
		</div>
	</div>
  <div id="layout1" style="width:99.2%; margin:0 auto;  "> 
	<!--左边-->
        <div position="left"  title="管理菜单" id="accordion1"> 
			<div title="重点项目管理" iconcss="menu-icon-order" id="tab9">
			<div style=" height:7px;"></div>
				  <ul class="nlist">
			  	  <li><a class="l-link" href="javascript:f_addTab('zdxm_ll','项目信息录入','zdxm/zdxmServlet?action=add')">项目信息录入</a></li>
				  <li><a class="l-link" href="javascript:f_addTab('zdxm_sh','项目信息审核','zdxm/zdxmServlet?action=audit')">项目信息审核</a></li>
				  <li><a class="l-link" href="javascript:f_addTab('zdxm_gl','项目信息管理','zdxm/zdxmServlet?action=list')">项目信息管理</a></li>
				  <li><a class="l-link" href="javascript:f_addTab('zdxm_yb','项目月报管理','zdxm/zdxmServlet?action=report')">项目月报管理</a></li>
				  <li><a class="l-link" href="javascript:f_addTab('zdxm_tj','项目汇总统计','zdxm/tj.html')">项目汇总统计</a></li>
				  <li><a class="l-link" href="javascript:f_addTab('zdxm_sz','项目设置管理','zdxm/sz.html')">项目设置管理</a></li>
				  </ul>
			</div> 
			<div title="重大项目管理" iconcss="menu-icon-order" id="tab10">
			<div style=" height:7px;"></div>
				  <ul class="nlist">
			 	  <li><a class="l-link" href="javascript:f_addTab('zdaxm_ll','项目信息录入','zdaxm/lr.jsp')">项目信息录入</a></li>
				  <li><a class="l-link" href="javascript:f_addTab('zdaxm_sh','项目信息审核','zdaxm/zdaxmServlet?action=audit')">项目信息审核</a></li>
				  <li><a class="l-link" href="javascript:f_addTab('zdaxm_gl','项目信息管理','zdaxm/zdaxmServlet?action=list')">项目信息管理</a></li>
				  <li><a class="l-link" href="javascript:f_addTab('zdaxm_yb','项目月报管理','zdaxm/zdaxmServlet?action=report')">项目月报管理</a></li>
				  <li><a class="l-link" href="javascript:f_addTab('zdaxm_tj','项目汇总统计','zdaxm/tj.html')">项目汇总统计</a></li>
				  <li><a class="l-link" href="javascript:f_addTab('zdaxm_sz','项目设置管理','zdaxm/sz.html')">项目设置管理</a></li>
				  </ul>
			</div> 
			<c:if test="${fn:contains(qx,'@xt')}">
			<div title="系统设置管理" iconcss="menu-icon-setting" id="tab6">
			<div style=" height:7px;"></div>
				<ul class="nlist">
				  <li><a class="l-link" href="javascript:f_addTab('config','系统参数设置','setting/SysConfigServlet?act=getinfo')">系统参数设置</a></li>
			<!--  	  <li><a class="l-link" href="javascript:f_addTab('model','系统模型管理','setting/SysModelServlet?act=list')">系统模型管理</a></li>-->
				  <li><a class="l-link" href="javascript:f_addTab('column','系统栏目管理','setting/SysColumnServlet?act=list')">系统栏目管理</a></li>
				  <li><a class="l-link" href="javascript:f_addTab('subject','专题栏目管理','setting/SpecialColumnServlet?act=list')">专题栏目管理</a></li>
				  <li style="display:none;"><a class="l-link" href="javascript:f_addTab('role','系统角色管理','setting/SysRoleServlet?act=list')">系统角色管理</a></li>
				  <li><a class="l-link" href="javascript:f_addTab('user','系统帐号管理','setting/SysUserServlet?act=list')">系统帐号管理</a></li>
				  <li><a class="l-link" href="javascript:f_addTab('log','系统日志管理','setting/SysLogServlet?act=list')">系统日志管理</a></li>
				</ul>
			</div> 
			</c:if>
        </div>
        <div position="center" id="framecenter"> 
            <div tabid="home" title="管理中心" iconcss="tab-icon-home" style="height:300px" >
                <iframe frameborder="0" name="home" id="home" src="WelcomeServlet"></iframe>
            </div> 
        </div> 
	<div position="bottom" class="footer">
		<div class="copyright">Copyright &copy; 2013-2015 龙岩市创高科技有限公司 All Rights Reserved.</div>
	</div>
    </div>
</body>
</html>
