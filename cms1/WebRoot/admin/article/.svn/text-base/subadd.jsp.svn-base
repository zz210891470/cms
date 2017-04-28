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
	<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script>  
	<script type="text/javascript" src="../js/function.js"></script>

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
  
    <script type="text/javascript">
    
        
    function saveandrelease(){
           if($("#bt").val() != "" && $("#rq").val() ){
                      document.all.articleForm.target="_self";
               document.all.articleForm.action="<%=basePath%>admin/article/SubArticleServlet?act=saveandrelease";
               document.all.articleForm.submit();
           }else{
               alert("标题和日期必须填写！");
           }
    
    }
    
    function saveandcontinue(){
           if($("#bt").val() != "" && $("#rq").val() ){
               document.all.articleForm.target="_self";
               document.all.articleForm.action="<%=basePath%>admin/article/SubArticleServlet?act=saveandcontinue";
               document.all.articleForm.submit();
           }else{
               alert("标题和日期必须填写！");
           }
    
    }
    
    function preview(){
           if($("#bt").val() != "" && $("#rq").val() ){
               document.all.articleForm.action="<%=basePath%>admin/article/SubArticleServlet?act=preview";
               document.all.articleForm.target="_blank";
               document.all.articleForm.submit();
           }else{
               alert("标题和日期必须填写！");
           }
    }
    

     function save(){
           if($("#bt").val() != "" && $("#rq").val() ){
               document.all.articleForm.target="_self";
               document.all.articleForm.action="<%=basePath%>admin/article/SubArticleServlet?act=add";
               document.all.articleForm.submit();
           }else{
               alert("标题和日期必须填写！");
           }
       }
       
       function back(){
           window.parent.hideFrame();
       }
    

    
    $(function(){
        if($('#smallimg').attr('src')=='<%=basePath%>'){
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
                    alert(data);//从服务器返回的json中取出message中的数据,其中message为在struts2中定义的成员变量  
                    $('#smallimg').attr('src','<%=basePath%>'+data[1]);
                    $('#lstp').attr('value',data[1]);
                },  
                error: function (data, status, e)//服务器响应失败处理函数  
                {  
                    alert(e);  
                }  
            })  

      }else{
      
         alert("请上传格式为png,gif,jpg的图片！");
      } 
    
        return false;  
  
    }  
    
    
    </script>

</head>

  <body class="mainbody">
      <form name="articleForm" method="post" action="<%=basePath%>admin/article/SubArticleServlet?act=add" id="form1">
   
   <div class="navigation"><a href="javascript:back();" class="back">后退</a>首页 &gt; 文章管理 &gt; 编辑信息</div>
<div id="contentTab">
    <ul class="tab_nav">
        <li class="selected"><a onclick="tabs('#contentTab',0);" href="javascript:;">基本信息</a></li>
        <li><a onclick="tabs('#contentTab',1);" href="javascript:;">详细描述</a></li>
    </ul>

    <div class="tab_con" style="display:block;">
    <input type="hidden" name="pid" value="${pid}"/>
        <table class="form_table">
            <col width="150px"></col>
            <tbody>
            <tr>
                <th>标题名称：</th>
                <td><input name="bt" type="text" maxlength="100" id="bt" class="txtInput normal required" /><span style="color:red;">*</span></td>
            </tr>

            <tr>
                <th>文章作者：</th>
                <td><input name="zz" type="text" value="管理员" maxlength="100" id="txtAuthor" class="txtInput normal" />
                </td>
            </tr>
            <script language="javascript" type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>
            <tr>
                <th>发布日期：</th>
                <td><input class="Wdate" type="text" onClick="WdatePicker()" id="rq" name="rq"/> <span style="color:red;">*</span></td>
            </tr>
            <tr>
                <th>文章来源：</th>
                <td><input name="ly" type="text" value="" maxlength="100" id="txtFrom" class="txtInput normal" />
                </td>
            </tr>
            <tr>
                <th>文章摘要：</th>
                <td><textarea name="ly" rows="2" cols="20" id="txtZhaiyao" class="small"></textarea></td>
            </tr>

            </tbody>
        </table>
    </div>

    <div class="tab_con">
        <table class="form_table" style="height:400px; width:100%;">
            <tr>
                <td>
	                <script type="text/plain" id="editor" name="nr" style="width:99%;"></script> 
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

 

    <div class="foot_btn_box">

    <c:if test="${fn:contains(sessionScope.qx,'shfb')}">
        <input type="button" onclick="saveandrelease()" name="btnSubmit" value="保存并发布" id="sd" class="btnSubmit" />
    </c:if>
    &nbsp;<input type="button" onclick="saveandcontinue()" name="btnSubmit" value="保存并继续" id="sd" class="btnSubmit" />
    &nbsp;<input type="button" onclick="save()" name="btnSubmit" value="保存并返回" id="sd" class="btnSubmit" />
    &nbsp;<input type="button" onclick="preview()" name="btnSubmit" value="预览" id="sd" class="btnSubmit" />
    &nbsp;<input name="sdfe" onclick="javascript:back();" type="button" class="btnSubmit" value="返回" />
    </div>
   
   
   
   </div>
   </form>
  </body>
</html>
