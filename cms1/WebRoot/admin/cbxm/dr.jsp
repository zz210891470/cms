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
        })//��ʼ�ϴ��ļ�ʱ��ʾһ��ͼƬ  
        .ajaxComplete(function(){  
            $(this).hide();  
        });//�ļ��ϴ���ɽ�ͼƬ��������
      
        var filename=$('#upfile').attr('value');
        filename=filename.substring(filename.lastIndexOf('\\')+1,filename.indexOf('.'));
  
    $.ajaxFileUpload({  
                url:'<%=basePath%>action/xlsupload.do?lb=cbxm&ajaxfilename='+escape(escape(filename)),//�����ļ��ϴ��ķ������������ַ  
                secureuri:false,//һ������Ϊfalse  
                fileElementId:'upfile',//�ļ��ϴ��ռ��id����  <</span>input type="file" id="file" name="file" />  
                dataType: 'json',//����ֵ���� һ������Ϊjson  
                success: function (data, status)  //�������ɹ���Ӧ������  
                {  
                    //�ӷ��������ص�json��ȡ��message�е�����,����messageΪ��struts2�ж���ĳ�Ա����  
			    	if(data[0]=="success"){
			            alert("����ɹ���");
			         }else if(data[0]=="error"){
			            alert(data[1]);
			         }
                },  
                error: function (data, status, e)//��������Ӧʧ�ܴ�����  
                {  
                    alert('����ʧ��!');  
                }  
            })  

      }else{
      
         alert("���ϴ���ʽΪxls,xlsx���ļ���");
      } 
    
        return false;  
  
    }  


	function  back(){
	
	    document.location.href="CbxmServlet?action=sideradd";
	}
		function download(){
     var filename="������Ŀ����ģ��.xls";
    document.location.href='<%=basePath%>action/filedownload.do?downloadname='+escape(escape(filename));
     return false;
    }
	
	</script>
  </head>
  <body class="mainbody">
    <div class="navigation">��ҳ &gt; ������Ŀ���� &gt; ����������Ŀ</div>
	<div style="padding:30px;">
    	<table style="width:800px;margin:30px 0 0 30px;background-color:#ccc;border-collapse: separate" border="0" cellpadding="0" cellspacing="1" align="left">
            <tr>
                <td height="30" align="left" colspan="2" style="padding-left:5px;font-weight:bolder;">����������Ŀ</td>
            </tr>
            <tr>
                <td width="80" height="100" align="center" bgcolor="White">����˵��</td>
                <td align="left" bgcolor="White" style=" line-height:2; padding:5px;">
                    ������ط�����ť����Excelģ�棬������Ϻ����Excel��Excel 2003�汾�뽫Excel�򿪺����Ϊ[ѡ�񱣴��ʽΪ(.xls)]��Excel 2007��2010�汾��Excel�����Ϊ[ѡ�񱣴��ʽΪExcel 97-2003(*.xls)]�����ϸ������ط�����Excel�����ʽ�������ݣ���Ҫ����۸ı�ͷ���� ��
                   <input id="btn_xz" type="button" value="���ط���" onclick="download()" class="btnSubmit" />
                </td>
            </tr>
            <tr>
                <td height="40" align="center" bgcolor="White">ѡ���ļ�</td>
                <td align="left" bgcolor="White">
                    <div class="fileInput left">
			          <input type="file" name="file" id="upfile" class="upfile" onchange="document.getElementById('upfileResult').innerHTML=this.value"/>
			          <input class="upFileBtn" type="button" value="�ϴ�ͼƬ" onclick="document.getElementById('upfile').click()" />
			        </div><br/>
			        <span style="font-size:14px;font-weight:600;" id="upfileResult"></span>
                </td>
            </tr>
            <tr>
                <td height="70" align="left" bgcolor="White" colspan="2" style=" padding-left:80px;">
                    <input type="button" name="btnSubmit" onclick="ajaxFileUpload()" value="�ύ����" id="btnSubmit" class="btnSubmit" />&nbsp;
					<input type="button" class="btnSubmit" value="�� ��" onclick="back();" />
                </td>
            </tr>
        </table>
	</div>
  </body>
</html>