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
<title>��Ŀ����</title>
	<link rel="stylesheet" type="text/css" href="../images/style.css"/>
	<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script>  
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
       
              function save(){
         
           if($("#bt").val() != "" && $("#rq").val() ){
                      document.all.articleForm.target="_self";
                                     
               document.all.articleForm.action="<%=basePath%>admin/article/ArticleServlet?act=addcontent";
               document.all.articleForm.submit();
           
           
           }else{
               alert("��������ڱ�����д��");
           }
       }
        
         function saveandrelease(){
         
           if($("#bt").val() != "" && $("#rq").val() ){
                      document.all.articleForm.target="_self";
               document.all.articleForm.action="<%=basePath%>admin/article/ArticleServlet?act=saveandreleasecontent";
               document.all.articleForm.submit();
           
           }else{
               alert("��������ڱ�����д��");
           }
       }
       
     function preview(){
           if($("#bt").val() != "" && $("#rq").val() ){
               document.all.articleForm.action="<%=basePath%>admin/article/ArticleServlet?act=preview";
               document.all.articleForm.target="_blank";
               document.all.articleForm.submit();
           }else{
               alert("��������ڱ�����д��");
           }
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
        })//��ʼ�ϴ��ļ�ʱ��ʾһ��ͼƬ  
        .ajaxComplete(function(){  
            $(this).hide();  
        });//�ļ��ϴ���ɽ�ͼƬ��������
  
  
    $.ajaxFileUpload({  
                url:'<%=basePath%>action/imgupload.do',//�����ļ��ϴ��ķ������������ַ  
                secureuri:false,//һ������Ϊfalse  
                fileElementId:'file',//�ļ��ϴ��ռ��id����  <</span>input type="file" id="file" name="file" />  
                dataType: 'json',//����ֵ���� һ������Ϊjson  
                success: function (data, status)  //�������ɹ���Ӧ������  
                {  
                
      //s      $("#file").attr("value",path);
             //       alert(data);//�ӷ��������ص�json��ȡ��message�е�����,����messageΪ��struts2�ж���ĳ�Ա����  
                    $('#smallimg').attr('src','<%=basePath%>'+data[1]);
                    $('#lstp').attr('value',data[1]);
                    alert("ͼƬ�ϴ��ɹ���");
                },  
                error: function (data, status, e)//��������Ӧʧ�ܴ�����  
                {  
                    alert(e);  
                }  
            })  

      }else{
      
         alert("���ϴ���ʽΪpng,gif,jpg��ͼƬ��");
      } 
    
        return false;  
  
    }  
    
    
    </script>
</head>

  <body class="mainbody">
      <form name="articleForm" method="post"  id="form1">
   
   <div class="navigation">��ҳ &gt; ���¹��� &gt; �����Ϣ</div>
<div id="contentTab">
    <ul class="tab_nav">
        <li class="selected"><a onclick="tabs('#contentTab',0);" href="javascript:;">������Ϣ</a></li>
        <li><a onclick="tabs('#contentTab',1);" href="javascript:;">��ϸ����</a></li>
        <li style="display:none;"><a onclick="tabs('#contentTab',2);" href="javascript:;">SEOѡ��</a></li>
    </ul>

    <div class="tab_con" style="display:block;">
    <input type="hidden" name="pid" value="${pid}"/>
        <table class="form_table">
            <col width="150px"></col>
            <tbody>

            <tr>
                <th>�������ƣ�</th>
                <td><input name="bt" type="text" maxlength="100" id="bt" class="txtInput normal required" /><span style="color:red;">*</span></td>
            </tr>
            <tr>
                <th>�Ƽ����ͣ�</th>
                <td>
                    <input type="hidden" name="lstp" id="lstp" value="${item.lstp }"/>
					<input id="rd" type="checkbox" value="1" name="rd" /><label for="rd">�ȵ�</label>
					<input id="gd" type="checkbox" value="1" name="gd" /><label for="rd">����</label>
					<input id="hd" type="checkbox" value="1" name="hd" /><label for="hd">�õ�</label>
                </td>
            </tr>
            <tr>
                <th>�������ߣ�</th>
                <td><input name="zz" type="text" value="" maxlength="100" id="zz" class="txtInput normal" />
                </td>
            </tr>
                        <tr>
                <th>�������ڣ�</th>
                <td><input class="Wdate" type="text" onClick="WdatePicker()" id="rq" name="rq"/> </td>
            </tr>
            <tr>
                <th>������Դ��</th>
                <td><input name="ly" type="text" value="" maxlength="100" id="ly" class="txtInput normal" />
                </td>
            </tr>
            <tr>
                <th>����ժҪ��</th>
                <td><textarea name="zy" rows="2" cols="20" id="zy" class="small"></textarea></td>
            </tr>
            <tr>
                <th>���������</th>
                <td><input name="llcs" type="text" value="0" maxlength="10" id="llcs" class="txtInput small required digits" /></td>
            </tr>
            <tr style="display:none;">
                <th>URL���ӣ�</th>
                <td><%=basePath%>article?url=<input name="ljwz" type="text" maxlength="255" id="txtLinkUrl" class="txtInput normal" /><label>URL��ת��ַ</label></td>
            </tr>
            <tr>
                <th valign="top" style="padding-top:10px;">����ͼƬ��</th>
                <td>
                    <input type="file" id="file" name="file" /> 
                    <img src="../images/loading.gif" id="loading" style="display: none;"/>
                    <img src="<%=basePath%>${item.lstp }" style="width:150px;height:100px;" id="smallimg"  />
                    <div class="upload_btn" onclick="ajaxFileUpload()"><span id="upload">�ϴ�&nbsp;</span></div><label><br/><span style="color:red;">*��ͼƬ������ҳ�õ�ͼƬ�͹���ͼƬ��ʾ���粻��Ҫ������ʾ�������ϴ����ϴ���ʽΪjpg,png��ͼƬ</span></label>
                    <div class="clear"></div>
                    <!--��������ֵ.��ʼ-->
                    <!--
                    <input type="hidden" name="focus_photo" id="focus_photo" value=""/>
                    -->
                    <input type="hidden" name="focus_photo" id="focus_photo" />
                    <!--��������ֵ.����-->
                    <!--�ϴ���ʾ.��ʼ-->
                    <div id="show"></div>
                    <!--�ϴ���ʾ.����-->
                    <!--ͼƬ�б�.��ʼ-->
                    <div id="show_list">
                        <ul>
                          
                        </ul>
                    </div>
                    <!--ͼƬ�б�.����-->
                </td>
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

    <div class="tab_con">
        <table class="form_table">
            <col width="150px"></col>
            <tbody>
            <tr>
                <th>SEO���⣺</th>
                <td><input name="txtSeoTitle" type="text" maxlength="255" id="txtSeoTitle" class="txtInput normal" /></td>
            </tr>
            <tr>
                <th>SEO�ؽ��֣�</th>
                <td><textarea name="txtSeoKeywords" rows="2" cols="20" id="txtSeoKeywords" class="small"></textarea></td>
            </tr>
            <tr>
                <th>SEO������</th>
                <td><textarea name="txtSeoDescription" rows="2" cols="20" id="txtSeoDescription" class="small"></textarea></td>
            </tr>
            </tbody>
        </table>
    </div>


    <div class="foot_btn_box">

    <input type="button" name="btnSubmit" value="����Ϊ�ݸ�" id="btnSubmit" onclick="save()" class="btnSubmit" />
    <c:if test="${fn:contains(sessionScope.qx,'shfb')}">
       &nbsp;  <input type="button" onclick="saveandrelease()" name="btnSubmit" value="���沢����" id="sd" class="btnSubmit" />
    </c:if>
    &nbsp;<input type="button" onclick="preview()" name="btnSubmit" value="Ԥ��" id="sd" class="btnSubmit" />

    </div>
   
   
   
   </div>
   </form>
  </body>
</html>
