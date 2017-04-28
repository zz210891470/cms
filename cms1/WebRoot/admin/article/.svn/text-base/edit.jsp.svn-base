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
<title>栏目管理</title>
	<link rel="stylesheet" type="text/css" href="../images/style.css"/>
	<script type="text/javascript" src="../js/jquery.js"></script>  
	<script type="text/javascript" src="../js/function.js"></script>
    <script type="text/javascript" src="../js/ajaxfileupload.js"></script>
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = '<%=basePath%>admin/editor/';
    </script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>admin/editor/themes/default/css/ueditor.css"/>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>admin/editor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>admin/editor/ueditor.all.min.js"></script>
  	<style>
	    body{
	        background-color:#ffffff;
	    
	    }
	
	</style>
      <script language="javascript" type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript">
    
    function saveandrelease(){
           if($("#bt").val() != "" && $("#rq").val() ){
                      document.all.articleForm.target="_self";
               document.all.articleForm.action="<%=basePath%>admin/article/ArticleServlet?act=updateandrelease";
               document.all.articleForm.submit();
           }else{
               alert("标题和日期必须填写！");
           }
    
    }
    
         function preview(){
           if($("#bt").val() != "" && $("#rq").val() ){
                  
               document.all.articleForm.action="<%=basePath%>admin/article/ArticleServlet?act=preview";
               document.all.articleForm.target="_blank";
               document.all.articleForm.submit();
           }else{
               alert("标题和日期必须填写！");
           }
    }
    
       function savecaogao(){
           if($("#bt").val() != "" && $("#rq").val() ){
                      document.all.articleForm.target="_self";
               document.all.articleForm.action="<%=basePath%>admin/article/ArticleServlet?act=updatecaogao";
               document.all.articleForm.submit();
           }else{
               alert("标题和日期必须填写！");
           }
    
    }

    

       function save(){
         
           if($("#bt").val() != "" && $("#rq").val() ){
                      document.all.articleForm.target="_self";
                               document.all.articleForm.action="<%=basePath%>admin/article/ArticleServlet?act=update";
        
               document.all.articleForm.submit();
           
           }else{
               alert("标题和日期必须填写！");
           }
       }
           
       function back(){
           window.parent.hideFrame();
       }
       
       
    $(function(){
        if($('#smallimg').attr('src')=='<%=basePath%>'||$('#smallimg').attr('src')=='<%=basePath%>null'){
          $('#smallimg').attr('src','<%=basePath%>images/tipnoimg.png');
        }
    
    });

     String.prototype.EndWith=function(s){  
        if(s==null||s==""||this.length==0||s.length>this.length){  
            return false;  
        }  
              
        if(this.substring(this.length-s.length)==s){  
            return true;  
        }else{  
            return false;  
        }  
        return true;  
    }  
    
    
    
    function ajaxFileUpload(){  
    
      var path=$("#file").val();

      if(path.EndWith(".jpg")||path.EndWith(".png")||path.EndWith(".gif")){
        $("#loading")  
        .ajaxStart(function(){  
            $(this).show();  
        })//开始上传文件时显示一个图片  
        .ajaxComplete(function(){  
            $(this).hide();  
        });//文件上传完成将图片隐藏起来
  
  
    $.ajaxFileUpload({  
                url:'<%=basePath%>action/imgupload.do',//用于文件上传的服务器端请求地址  
                secureuri:false,//一般设置为false  
                fileElementId:'file',//文件上传空间的id属性  <</span>input type="file" id="file" name="file" />  
                dataType: 'json',//返回值类型 一般设置为json  
                success: function (data, status)  //服务器成功响应处理函数  
                {  
                
      //s      $("#file").attr("value",path);
                 //从服务器返回的json中取出message中的数据,其中message为在struts2中定义的成员变量  
                    $('#smallimg').attr('src','<%=basePath%>'+data[1]);
                    $('#lstp').attr('value',data[1]);
                    alert("图片上传成功！");
                },  
                error: function (data, status, e)//服务器响应失败处理函数  
                {  
                    alert('文件已损坏！');  
                }  
            })  

      }else{
      
         alert("请上传格式为png,gif,jpg的图片！");
      } 
    
        return false;  
  
    }  
    
    
    </script>
  
</head>

  <body class="mainbody"  >
      <form name="articleForm" method="post" id="form1">
   
   <div class="navigation"><a href="javascript:window.parent.hideFrame();" class="back">后退</a>首页 &gt; 文章管理 &gt; 编辑信息</div>
<div id="contentTab">
    <ul class="tab_nav">
        <li class="selected"><a onclick="tabs('#contentTab',0);" href="javascript:;">基本信息</a></li>
        <li><a onclick="tabs('#contentTab',1);" href="javascript:;">详细内容</a></li>
        <li style="display:none;"><a onclick="tabs('#contentTab',2);" href="javascript:;">SEO选项</a></li>
    </ul>
    <input type="hidden" name="pid" value="${pid}"/>
    <input type="hidden" name="lstp" id="lstp" value="${item.lstp }"/>
    <input type="hidden" name="id" value="${item.id}"/>
    <div class="tab_con" style="display:block;">
        <table class="form_table">
            <col width="150px"></col>
            <tbody>
            <tr style="display:none;">
                <th>所属类别：</th>
                <td><select name="ddlCategoryId" id="ddlCategoryId" class="select2 required">
					<option value="">请选择类别...</option>
                 </select></td>
            </tr>
            <tr>
                <th>标题名称：</th>
                <td><input  name="bt" value="${item.bt }" type="text" maxlength="100" id="bt" class="txtInput normal required" /><span style="color:red;">*</span></td>
            </tr>
            <tr>
                <th>文章属性：</th>
                <td>
                    <span id="cblItem">
                      <c:choose>
					   <c:when test="${item.rd=='1'}">
                    	<input id="rd" type="checkbox" name="rd" value="1" checked /><label for="rd" >热点</label>
					   </c:when> 
					   <c:otherwise> 
                    	<input id="rd" type="checkbox" name="rd" value="1" /><label for="rd" >热点</label>
					   </c:otherwise>
					  </c:choose>
					  
					  <c:choose>
					   <c:when test="${item.gd=='1'}">
                    <input type="checkbox" name="gd" value="1" checked /><label for="gd" >滚动</label>
					   </c:when> 
					   <c:otherwise> 
                    <input  type="checkbox" name="gd"  value="1"/><label for="gd">滚动</label>
					   </c:otherwise>
					  </c:choose>
					  	<c:choose>
					   <c:when test="${item.hd=='1'}">
                       <input id="hd" type="checkbox" name="hd" value="1" checked/><label for="hd">幻灯</label>
                       	   </c:when> 
					   <c:otherwise> 
                       <input id="hd" type="checkbox" name="hd" value="1"/><label for="hd">幻灯</label>
                       	   </c:otherwise>
					  </c:choose>
					  	<c:choose>
					   <c:when test="${item.istop=='1'}">
                       <input id="istop" type="checkbox" name="istop" value="1" checked/><label for="istop">置顶</label>
                       	   </c:when> 
					   <c:otherwise> 
                       <input id="istop" type="checkbox" name="istop" value="1"/><label for="istop">置顶</label>
                       	   </c:otherwise>
					  </c:choose>

                </td>
            </tr>
            <tr>
                <th>文章作者：</th>
                <td><input name="zz" value="${item.zz }" type="text" value="" maxlength="100" id="txtAuthor" class="txtInput normal" />
                </td>
            </tr>
             <tr>
                <th>发布日期：</th>
                <td><input class="Wdate" type="text"   value="${item.rq }" onClick="WdatePicker()" id="rq" name="rq"/> <span style="color:red;">*</span></td>
            </tr>
            <tr>
                <th>文章来源：</th>
                <td><input name="ly" type="text" value="${item.ly }" maxlength="100" id="ly" class="txtInput normal" />
                </td>
            </tr>
            <tr>
                <th>文章摘要：</th>
                <td><textarea name="zy" rows="2" cols="20" id="zy" class="small">${item.zy }</textarea></td>
            </tr>
            <tr>
                <th>浏览次数：</th>
                <td><input name="llcs" type="text" value="${item.llcs }" maxlength="10" id="llcs" class="txtInput small required digits" /></td>
            </tr>
            <tr style="display:none;">
                <th>URL链接：</th>
                <td><%=basePath%>article?url=<input name="txtLinkUrl" type="text" maxlength="255" id="txtLinkUrl" class="txtInput normal" /><label>URL跳转地址</label></td>
            </tr>
            <tr>
                <th valign="top" style="padding-top:10px;">缩略图片：</th>
                <td>
                    <input type="file" id="file" name="file" /> 
                    <img src="../images/loading.gif" id="loading" style="display: none;"/>
                    <img src="<%=basePath%>${item.lstp }" style="width:150px;height:100px;" id="smallimg"  />
                    <div class="upload_btn" onclick="ajaxFileUpload()"><span id="upload">上传</span></div><label><br/><span style="color:red;">*该图片用于首页幻灯图片和滚动图片显示，如不需要该类显示则无需上传，上传格式为jpg,png的图片</span></label>
             
                    <div class="clear"></div>
                    <!--封面隐藏值.开始-->
                    <!--
                    <input type="hidden" name="focus_photo" id="focus_photo" value=""/>
                    -->
                    <input type="hidden" name="focus_photo" id="focus_photo" />
                    <!--封面隐藏值.结束-->
                    <!--上传提示.开始-->
                    <div id="show"></div>
                    <!--上传提示.结束-->
                    <!--图片列表.开始-->
                    <div id="show_list">
                        <ul>
                          
                        </ul>
                    </div>
                    <!--图片列表.结束-->
                </td>
            </tr>

            </tbody>
        </table>
    </div>

    <div class="tab_con">
        <table class="form_table" style="height:400px; width:100%;">
            <tr>
                <td>
	                <script type="text/plain" id="editor" name="nr" style="width:99%;">
                     ${item.nr}
	                </script> 
	                   <script type="text/javascript">
						var editor;
		                var noteEditor;
		                $(document).ready(function(){
		                        editor = new baidu.editor.ui.Editor({
								autoHeightEnabled: false,
		                        initialFrameHeight:400,
		                        textarea:'descriptionEditor'
		                    });
		                    editor.render("editor");
		               });
			</script>
                </td>
            </tr>
        </table>
    </div>

    <div class="tab_con">
        <table class="form_table">
            <col width="150px"></col>
            <tbody>
            <tr>
                <th>SEO标题：</th>
                <td><input name="seobt" type="text" maxlength="255" id="seobt" class="txtInput normal" /></td>
            </tr>
            <tr>
                <th>SEO关健字：</th>
                <td><textarea name="seogjz" rows="2" cols="20" id="seogjz" class="small"></textarea></td>
            </tr>
            <tr>
                <th>SEO描述：</th>
                <td><textarea name="seoms" rows="2" cols="20" id="seoms" class="small"></textarea></td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="foot_btn_box">
状态：${item.zt }
    <c:if test="${fn:contains(sessionScope.qx,'shfb')}">
        <input type="button" onclick="saveandrelease()" name="btnSubmit" value="保存并发布" id="sd" class="btnSubmit" />
    </c:if>
    &nbsp;<input type="button" onclick="savecaogao()" name="btnSubmit" value="保存为草稿" id="sd" class="btnSubmit" />
    &nbsp;<input type="button" onclick="save()" name="btnSubmit" value="保存并返回" id="sd" class="btnSubmit" />
    &nbsp;<input type="button" onclick="preview()" name="btnSubmit" value="预览" id="sd" class="btnSubmit" />
    &nbsp;<input name="sdfe" onclick="javascript:back();" type="button" class="btnSubmit" value="返回" />
    </div>
   
   
   
   </div>
   </form>
  </body>
</html>
