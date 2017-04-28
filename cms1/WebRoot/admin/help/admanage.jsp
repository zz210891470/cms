<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>������</title>
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
        })//��ʼ�ϴ��ļ�ʱ��ʾһ��ͼƬ  
        .ajaxComplete(function(){  
            $(this).hide();  
        });//�ļ��ϴ���ɽ�ͼƬ��������
 
    	$.ajaxFileUpload({  
                url:'<%=basePath%>action/imgupload.do',//�����ļ��ϴ��ķ������������ַ  
                secureuri:false,//һ������Ϊfalse  
                fileElementId:fileid,//�ļ��ϴ��ռ��id����  <</span>input type="file" id="file" name="file" />  
                dataType: 'json',//����ֵ���� һ������Ϊjson  
                success: function (data, status)  //�������ɹ���Ӧ������  
                {  
                
      //s      $("#file").attr("value",path);
                   //�ӷ��������ص�json��ȡ��message�е�����,����messageΪ��struts2�ж���ĳ�Ա����  
                    $(e).next().next().next().next().next().next().attr('src','<%=basePath%>'+data[1]);
                     $(e).next().attr('value',data[1]);

                },  
                error: function (data, status, e)//��������Ӧʧ�ܴ�����  
                {  
                    alert("ͼƬ���𻵲����ϴ���");  
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
  <div class="navigation">��ҳ &gt; �������ܹ��� &gt; ��ҳ�������</div>
  <form action="<%=basePath%>admin/help/AdManageServlet?act=update" method="post">
      <div>
      <table class="form_table">
        <tbody>
          <tr>
           <th height="80" align="center" width="150" style="border-bottom:solid 1px #EDECFF; ">
                           ${one.name }��<input type="hidden" name="oneid" value="${one.id }"/>
           </th>
           <td bgcolor="White" style="border-bottom:solid 1px #EDECFF; ">
	                           ״̬��<c:if test="${one.status=='1' }"><input id="state1" name="onestatus" value="1" type="checkbox" checked></c:if> 
	               <c:if test="${one.status=='0'}"><input id="state1" name="onestatus" value="1" type="checkbox"></c:if><label for="state1">����</label>
	                           �޸�ͼƬ��<input name="file" id="FileUpload1" type="file" /> <input type="button" value="�ϴ�"  onclick="ajaxFileUpload(this)"/><input type="hidden" name="oneimgurl" value="${one.imgurl }" /><br>
	                  	������ַ��<input type="text" value="${one.url }" name="oneurl" id="url1" /><span style="color:red">*&nbsp;������ַ�����http://ǰ׺</span><br/>
	            	ͼƬԤ����<img src="<%=basePath%>${one.imgurl }" /><br><br><br></td>
           </tr>
            <tr>
           <th height="80" align="center" style="border-bottom:solid 1px #EDECFF; ">
                           ${two.name }��      <input type="hidden" name="twoid" value="${two.id }"/>      
           </th>
           <td bgcolor="White" style="border-bottom:solid 1px #EDECFF; ">
	                           ״̬��<c:if test="${two.status=='1' }"><input id="state2" name="twostatus" value="1" type="checkbox" checked></c:if> 
	               <c:if test="${two.status=='0'}"><input id="state2" name="twostatus" value="1" type="checkbox"></c:if><label for="state2">����</label>
			
	                           �޸�ͼƬ��<input name="file" id="FileUpload2" type="file" /> <input type="button" value="�ϴ�"  onclick="ajaxFileUpload(this)"/><input type="hidden" name="twoimgurl" value="${two.imgurl }" /><br>
	     	������ַ��<input type="text" value="${two.url }" name="twourl" id="url2" /><span style="color:red">*&nbsp;������ַ�����http://ǰ׺</span><br/>       
	            ͼƬԤ����<img src="<%=basePath%>${two.imgurl }"  /><br><br><br></td>
           </tr>
              <tr>
           <th height="80" align="center"  style="border-bottom:solid 1px #EDECFF; ">
                           ${three.name }��<input type="hidden" name="threeid" value="${three.id }"/>
           </th>
           <td bgcolor="White" style="border-bottom:solid 1px #EDECFF; ">
	                           ״̬��<c:if test="${three.status=='1' }"><input id="state3" name="threestatus" value="1" type="checkbox" checked></c:if> 
	                <c:if test="${three.status=='0'}"><input id="state3" name="threestatus"  value="1" type="checkbox"></c:if><label for="state3">����</label>             
	                           �޸�ͼƬ��<input name="file" id="FileUpload3" type="file" /> <input type="button" value="�ϴ�"  onclick="ajaxFileUpload(this)"/> <input type="hidden" name="threeimgurl" value="${three.imgurl }" /><br>
			     ������ַ��<input type="text" value="${three.url }" name="threeurl" id="url3" /><span style="color:red">*&nbsp;������ַ�����http://ǰ׺</span><br/>          
			    ͼƬԤ����
	           <img src="<%=basePath%>${three.imgurl }"  /><br><br><br></td>
           </tr>
             <tr>
            <th height="80" align="center" style="border-bottom:solid 1px #EDECFF; ">
                           ${four.name }��<input type="hidden" name="fourid" value="${four.id }"/>
           </th>
                 <td bgcolor="White" style="border-bottom:solid 1px #EDECFF; ">
	                           ״̬��<c:if test="${four.status=='1' }"><input id="state4" name="fourstatus" value="1" type="checkbox" checked></c:if> 
	                <c:if test="${four.status=='0'}"><input id="state4" name="fourstatus"  value="1" type="checkbox"></c:if>
	                <label for="state4">����</label>             
	                           �޸�ͼƬ��<input name="file" id="FileUpload4" type="file" /> <input type="button" value="�ϴ�"  onclick="ajaxFileUpload(this)"/><input type="hidden" name="fourimgurl" value="${four.imgurl }" /><br>
			     ������ַ��<input type="text" value="${four.url }" name="foururl" id="url4" /><span style="color:red">*&nbsp;������ַ�����http://ǰ׺</span><br/>          
			    ͼƬԤ����
	           <img src="<%=basePath%>${four.imgurl }"  /><br><br><br></td>
           </tr>
               <tr>
           <th height="80" align="center" style="border-bottom:solid 1px #EDECFF; ">
                           ${five.name }��<input type="hidden" name="fiveid" value="${five.id }"/>
                         
           </th>
           	<td bgcolor="White" style="border-bottom:solid 1px #EDECFF; ">
				 ״̬��<c:if test="${five.status=='1' }"><input id="state5" name="fivestatus" value="1"  type="checkbox" checked></c:if> 
				<c:if test="${five.status=='0'}"><input id="state5" name="fivestatus" value="1"  type="checkbox"></c:if><label for="state5">����</label>
				�޸�ͼƬ��<input name="file" id="FileUpload5" type="file" /> <input type="button" value="�ϴ�"  onclick="ajaxFileUpload(this)"/><input type="hidden" name="fiveimgurl" value="${five.imgurl }" /><br>
				 ������ַ��<input type="text" value="${five.url }" name="fiveurl" id="url1" /><span style="color:red">*&nbsp;������ַ�����http://ǰ׺</span><br/>       
				ͼƬԤ����
	           <img src="<%=basePath%>${five.imgurl }"  /><br><br><br>
	           </td>
           </tr>
                     <tr>
           <th height="80" align="center" >
                           ${six.name }��<input type="hidden" name="sixid" value="${six.id }"/>
                         
           </th>
           <td bgcolor="White">
			״̬��<c:if test="${six.status=='1' }"><input id="state6" name="sixstatus"  value="1" type="checkbox" checked></c:if> 
			<c:if test="${six.status=='0'}"><input id="state6" name="sixstatus"  value="1" type="checkbox"></c:if><label for="state6">����</label>
			�޸�ͼƬ��<input name="file" id="FileUpload6" type="file"  /> <input type="button" value="�ϴ�"  onclick="ajaxFileUpload(this);return false;"/>  <input type="hidden" name="siximgurl" value="${six.imgurl }" /><br>
			������ַ��<input type="text" value="${six.url }" name="sixurl" id="url1" /><span style="color:red">*&nbsp;������ַ�����http://ǰ׺</span><br/>       
			ͼƬԤ����
			<img src="<%=basePath%>${six.imgurl }"  /><br><br><br></td>
           </tr>
          </tbody> 
      </table>
      	<div class="foot_btn_box">
		<input type="submit" name="btnSubmit" value="�ύ����" id="btnSubmit" class="btnSubmit" />
		</div>
      </div>
      </form>
  </body>
</html>
