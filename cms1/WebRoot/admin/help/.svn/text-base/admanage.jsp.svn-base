<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>广告管理</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>admin/images/style.css"/>
	<script type="text/javascript" src="<%=basePath%>admin/js/jquery.js"></script>  
    <script type="text/javascript" src="<%=basePath%>admin/js/ajaxfileupload.js"></script>
    <script type="text/javascript">
       $(function(){
           $('img').each(function(){		                     
		        if($(this).attr('src')=='<%=basePath%>'){
		          $(this).attr('src','<%=basePath%>images/tipnoimg.png');
		        }
           });
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
    
    function ajaxFileUpload(e){  

      var path=$(e).prev().val();
      var fileid=$(e).prev().attr('id').toString();
   
     if(path.EndWith(".jpg")||path.EndWith(".png")||path.EndWith(".gif")||path.EndWith(".zip")){
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
                fileElementId:fileid,//文件上传空间的id属性  <</span>input type="file" id="file" name="file" />  
                dataType: 'json',//返回值类型 一般设置为json  
                success: function (data, status)  //服务器成功响应处理函数  
                {  
                
      //s      $("#file").attr("value",path);
                   //从服务器返回的json中取出message中的数据,其中message为在struts2中定义的成员变量  
                    $(e).next().next().next().next().next().next().attr('src','<%=basePath%>'+data[1]);
                     $(e).next().attr('value',data[1]);

                },  
                error: function (data, status, e)//服务器响应失败处理函数  
                {  
                    alert("图片已损坏不能上传！");  
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
  <div class="navigation">首页 &gt; 辅助功能管理 &gt; 首页广告设置</div>
  <form action="<%=basePath%>admin/help/AdManageServlet?act=update" method="post">
      <div>
      <table class="form_table">
        <tbody>
          <tr>
           <th height="80" align="center" width="150" style="border-bottom:solid 1px #EDECFF; ">
                           ${one.name }：<input type="hidden" name="oneid" value="${one.id }"/>
           </th>
           <td bgcolor="White" style="border-bottom:solid 1px #EDECFF; ">
	                           状态：<c:if test="${one.status=='1' }"><input id="state1" name="onestatus" value="1" type="checkbox" checked></c:if> 
	               <c:if test="${one.status=='0'}"><input id="state1" name="onestatus" value="1" type="checkbox"></c:if><label for="state1">启用</label>
	                           修改图片：<input name="file" id="FileUpload1" type="file" /> <input type="button" value="上传"  onclick="ajaxFileUpload(this)"/><input type="hidden" name="oneimgurl" value="${one.imgurl }" /><br>
	                  	链接网址：<input type="text" value="${one.url }" name="oneurl" id="url1" /><span style="color:red">*&nbsp;链接网址请加上http://前缀</span><br/>
	            	图片预览：<img src="<%=basePath%>${one.imgurl }" /><br><br><br></td>
           </tr>
            <tr>
           <th height="80" align="center" style="border-bottom:solid 1px #EDECFF; ">
                           ${two.name }：      <input type="hidden" name="twoid" value="${two.id }"/>      
           </th>
           <td bgcolor="White" style="border-bottom:solid 1px #EDECFF; ">
	                           状态：<c:if test="${two.status=='1' }"><input id="state2" name="twostatus" value="1" type="checkbox" checked></c:if> 
	               <c:if test="${two.status=='0'}"><input id="state2" name="twostatus" value="1" type="checkbox"></c:if><label for="state2">启用</label>
			
	                           修改图片：<input name="file" id="FileUpload2" type="file" /> <input type="button" value="上传"  onclick="ajaxFileUpload(this)"/><input type="hidden" name="twoimgurl" value="${two.imgurl }" /><br>
	     	链接网址：<input type="text" value="${two.url }" name="twourl" id="url2" /><span style="color:red">*&nbsp;链接网址请加上http://前缀</span><br/>       
	            图片预览：<img src="<%=basePath%>${two.imgurl }"  /><br><br><br></td>
           </tr>
              <tr>
           <th height="80" align="center"  style="border-bottom:solid 1px #EDECFF; ">
                           ${three.name }：<input type="hidden" name="threeid" value="${three.id }"/>
           </th>
           <td bgcolor="White" style="border-bottom:solid 1px #EDECFF; ">
	                           状态：<c:if test="${three.status=='1' }"><input id="state3" name="threestatus" value="1" type="checkbox" checked></c:if> 
	                <c:if test="${three.status=='0'}"><input id="state3" name="threestatus"  value="1" type="checkbox"></c:if><label for="state3">启用</label>             
	                           修改图片：<input name="file" id="FileUpload3" type="file" /> <input type="button" value="上传"  onclick="ajaxFileUpload(this)"/> <input type="hidden" name="threeimgurl" value="${three.imgurl }" /><br>
			     链接网址：<input type="text" value="${three.url }" name="threeurl" id="url3" /><span style="color:red">*&nbsp;链接网址请加上http://前缀</span><br/>          
			    图片预览：
	           <img src="<%=basePath%>${three.imgurl }"  /><br><br><br></td>
           </tr>
             <tr>
            <th height="80" align="center" style="border-bottom:solid 1px #EDECFF; ">
                           ${four.name }：<input type="hidden" name="fourid" value="${four.id }"/>
           </th>
                 <td bgcolor="White" style="border-bottom:solid 1px #EDECFF; ">
	                           状态：<c:if test="${four.status=='1' }"><input id="state4" name="fourstatus" value="1" type="checkbox" checked></c:if> 
	                <c:if test="${four.status=='0'}"><input id="state4" name="fourstatus"  value="1" type="checkbox"></c:if>
	                <label for="state4">启用</label>             
	                           修改图片：<input name="file" id="FileUpload4" type="file" /> <input type="button" value="上传"  onclick="ajaxFileUpload(this)"/><input type="hidden" name="fourimgurl" value="${four.imgurl }" /><br>
			     链接网址：<input type="text" value="${four.url }" name="foururl" id="url4" /><span style="color:red">*&nbsp;链接网址请加上http://前缀</span><br/>          
			    图片预览：
	           <img src="<%=basePath%>${four.imgurl }"  /><br><br><br></td>
           </tr>
               <tr>
           <th height="80" align="center" style="border-bottom:solid 1px #EDECFF; ">
                           ${five.name }：<input type="hidden" name="fiveid" value="${five.id }"/>
                         
           </th>
           	<td bgcolor="White" style="border-bottom:solid 1px #EDECFF; ">
				 状态：<c:if test="${five.status=='1' }"><input id="state5" name="fivestatus" value="1"  type="checkbox" checked></c:if> 
				<c:if test="${five.status=='0'}"><input id="state5" name="fivestatus" value="1"  type="checkbox"></c:if><label for="state5">启用</label>
				修改图片：<input name="file" id="FileUpload5" type="file" /> <input type="button" value="上传"  onclick="ajaxFileUpload(this)"/><input type="hidden" name="fiveimgurl" value="${five.imgurl }" /><br>
				 链接网址：<input type="text" value="${five.url }" name="fiveurl" id="url1" /><span style="color:red">*&nbsp;链接网址请加上http://前缀</span><br/>       
				图片预览：
	           <img src="<%=basePath%>${five.imgurl }"  /><br><br><br>
	           </td>
           </tr>
                     <tr>
           <th height="80" align="center" >
                           ${six.name }：<input type="hidden" name="sixid" value="${six.id }"/>
                         
           </th>
           <td bgcolor="White">
			状态：<c:if test="${six.status=='1' }"><input id="state6" name="sixstatus"  value="1" type="checkbox" checked></c:if> 
			<c:if test="${six.status=='0'}"><input id="state6" name="sixstatus"  value="1" type="checkbox"></c:if><label for="state6">启用</label>
			修改图片：<input name="file" id="FileUpload6" type="file"  /> <input type="button" value="上传"  onclick="ajaxFileUpload(this);return false;"/>  <input type="hidden" name="siximgurl" value="${six.imgurl }" /><br>
			链接网址：<input type="text" value="${six.url }" name="sixurl" id="url1" /><span style="color:red">*&nbsp;链接网址请加上http://前缀</span><br/>       
			图片预览：
			<img src="<%=basePath%>${six.imgurl }"  /><br><br><br></td>
           </tr>
          </tbody> 
      </table>
      	<div class="foot_btn_box">
		<input type="submit" name="btnSubmit" value="提交保存" id="btnSubmit" class="btnSubmit" />
		</div>
      </div>
      </form>
  </body>
</html>
