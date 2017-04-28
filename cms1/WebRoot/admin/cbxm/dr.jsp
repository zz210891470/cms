<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<link rel="stylesheet" type="text/css" href="../images/style.css"/>
	<style>
	.fileInput{width:90px;height:28px; background:url(../images/upFileBtn.png);overflow:hidden;position:relative;}
	.upfile{position:absolute;top:-100px;}
	.upFileBtn{width:90px;height:28px;opacity:0;filter:alpha(opacity=0);cursor:pointer;}
	</style>
	<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script>  
	<script type="text/javascript" src="../js/function.js"></script>
    <script type="text/javascript" src="../js/ajaxfileupload.js"></script>
	<script type="text/javascript">
	
	
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

      var path=$("#upfile").val();

      if(path.EndWith(".xls")||path.EndWith(".xlsx")){
        $("#loading")  
        .ajaxStart(function(){  
            $(this).show();  
        })//开始上传文件时显示一个图片  
        .ajaxComplete(function(){  
            $(this).hide();  
        });//文件上传完成将图片隐藏起来
      
        var filename=$('#upfile').attr('value');
        filename=filename.substring(filename.lastIndexOf('\\')+1,filename.indexOf('.'));
  
    $.ajaxFileUpload({  
                url:'<%=basePath%>action/xlsupload.do?lb=cbxm&ajaxfilename='+escape(escape(filename)),//用于文件上传的服务器端请求地址  
                secureuri:false,//一般设置为false  
                fileElementId:'upfile',//文件上传空间的id属性  <</span>input type="file" id="file" name="file" />  
                dataType: 'json',//返回值类型 一般设置为json  
                success: function (data, status)  //服务器成功响应处理函数  
                {  
                    //从服务器返回的json中取出message中的数据,其中message为在struts2中定义的成员变量  
			    	if(data[0]=="success"){
			            alert("导入成功！");
			         }else if(data[0]=="error"){
			            alert(data[1]);
			         }
                },  
                error: function (data, status, e)//服务器响应失败处理函数  
                {  
                    alert('导入失败!');  
                }  
            })  

      }else{
      
         alert("请上传格式为xls,xlsx的文件！");
      } 
    
        return false;  
  
    }  


	function  back(){
	
	    document.location.href="CbxmServlet?action=sideradd";
	}
		function download(){
     var filename="储备项目导入模板.xls";
    document.location.href='<%=basePath%>action/filedownload.do?downloadname='+escape(escape(filename));
     return false;
    }
	
	</script>
  </head>
  <body class="mainbody">
    <div class="navigation">首页 &gt; 储备项目管理 &gt; 批量导入项目</div>
	<div style="padding:30px;">
    	<table style="width:800px;margin:30px 0 0 30px;background-color:#ccc;border-collapse: separate" border="0" cellpadding="0" cellspacing="1" align="left">
            <tr>
                <td height="30" align="left" colspan="2" style="padding-left:5px;font-weight:bolder;">批量导入项目</td>
            </tr>
            <tr>
                <td width="80" height="100" align="center" bgcolor="White">导入说明</td>
                <td align="left" bgcolor="White" style=" line-height:2; padding:5px;">
                    点击下载范本按钮下载Excel模版，下载完毕后请打开Excel表，Excel 2003版本请将Excel打开后另存为[选择保存格式为(.xls)]，Excel 2007和2010版本打开Excel表另存为[选择保存格式为Excel 97-2003(*.xls)]，请严格按照下载范本的Excel表里格式输入内容，不要随意篡改表头名称 。
                   <input id="btn_xz" type="button" value="下载范本" onclick="download()" class="btnSubmit" />
                </td>
            </tr>
            <tr>
                <td height="40" align="center" bgcolor="White">选择文件</td>
                <td align="left" bgcolor="White">
                    <div class="fileInput left">
			          <input type="file" name="file" id="upfile" class="upfile" onchange="document.getElementById('upfileResult').innerHTML=this.value"/>
			          <input class="upFileBtn" type="button" value="上传图片" onclick="document.getElementById('upfile').click()" />
			        </div><br/>
			        <span style="font-size:14px;font-weight:600;" id="upfileResult"></span>
                </td>
            </tr>
            <tr>
                <td height="70" align="left" bgcolor="White" colspan="2" style=" padding-left:80px;">
                    <input type="button" name="btnSubmit" onclick="ajaxFileUpload()" value="提交导入" id="btnSubmit" class="btnSubmit" />&nbsp;
					<input type="button" class="btnSubmit" value="返 回" onclick="back();" />
                </td>
            </tr>
        </table>
	</div>
  </body>
</html>