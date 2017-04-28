<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<link rel="stylesheet" type="text/css" href="../images/style.css"/>
	<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script>  
	<script type="text/javascript" src="../js/function.js"></script>
	
	<style>
	    body{
	        background-color:#ffffff;
	    }
	
	</style>
	
	<script type="text/javascript">
       function save(){
           if( $("#nd").val()=="" ||  $("#mc").val()=="" ��){
               alert("��Ŀ��Ⱥ���Ŀ���Ʊ���Ҫ��д��");
           }else{
               $("#form").submit();
           }

       }
       
       function back(){
           window.parent.hideFrame();
       }
       
       var lblist ;
       function lbchange(t){
          
           var lb2html =""; 
           if($(t).val()==''){
               lb2html += '<option value="">δѡ��</option>';
               $("#lb2").html(lb2html);
           }
           for(var i=0;i<lblist.length; i++){
                if(lblist[i].mc==$(t).val()){
                    var tempid = lblist[i].id;
                    for(var j=0;j<lblist.length; j++){
                        if(tempid == lblist[j].pid){
                            lb2html += '<option value="'+lblist[j].mc+'">'+lblist[j].mc+'</option>';
                        }
                 
                    }
                    $("#lb2").html(lb2html);
               }
           }
       }
       
       $(function(){

           
           var temp = $("#lblist").val() ;
           
           if(temp != ""){             
               lblist = eval(temp);  
               var lb1html ='<option value="" selected>--��ѡ����ҵ����--</option>';
              // var lb2html =""; 
               
               for(var i=0;i<lblist.length; i++){
                   if(lblist[i].pid==0){
                      lb1html += '<option value="'+lblist[i].mc+'">'+lblist[i].mc+'</option>';
                   }
               }
               
               $('#lb1').html(lb1html);
                       
           }
           
       });
    
    </script>
  </head>
  <body class="mainbody">
  <input id="lblist" value="${lblist }" type="hidden"/>	
	<form name="form" method="post" action="<%=basePath%>admin/zsxm/ZsxmServlet?action=add" id="form">
    	<div class="navigation">��ҳ &gt; ������Ŀ���� &gt; ��Ŀ��Ϣ¼��</div>
    	<div class="tab_con" style="display:block;">
    		<table class="form_table">
				<col width="150px"></col>
				<tbody>
				<tr>
					<th>��Ŀ��ȣ�</th>
					<td><input name="nd" id="nd" type="text" value="" maxlength="4" onkeyup="clearNoNum(this)"  class="txtInput normal required" /><span style="color:red">*</span></td>
				</tr>
				
				<tr>
					<th>��Ŀ���ƣ�</th>
					<td><input name="mc" id="mc" type="text" value="" maxlength="100"  class="txtInput normal required" /><span style="color:red">*</span></td>
				</tr>
				<tr>
					<th>������</th>
					<td>
					    <select name="dq"  >
					    <option value="" selected>��ѡ������</option>
					    <c:forEach  items="${dqlist}" var="item">
					        <option value="${item }">${item }</option>
					    </c:forEach>
					    </select>
					</td>
				</tr>
				<tr>
					<th>��Ŀ���</th>
					<td>		
					    <select name="lb1" id="lb1" onchange="lbchange(this)"; >

					    </select>&nbsp;&nbsp;&nbsp;
					    <select name="lb2" id="lb2"  >
					    </select>
					</td>
				</tr>
				<tr>
					<th>��Ͷ��(��Ԫ)��</th>
					<td><input name="ztz" type="text" value="" onkeyup="clearNoNum(this)" maxlength="100"  class="txtInput normal required" /></td>
				</tr>
				<tr>
					<th>�����ģ�����ݣ�</th>
					<td><textarea name="jsgm"  rows="8" cols="20" id="webdescription" class="small" style="width:80%;"></textarea></td>
				</tr>
				<tr>
					<th>������ʽ��</th>
					<td><input name="hzfs"  type="text" value="" maxlength="100"  class="txtInput normal required" /></td>
				</tr>
				<tr>
					<th>��ϵ��λ��</th>
					<td><input name="lxdw"  type="text" value="" maxlength="100"  class="txtInput normal required" /></td>
				</tr>
				<tr>
					<th>��ϵ�ˣ�</th>
					<td><input name="lxr"  type="text" value="" maxlength="100"  class="txtInput normal required" /></td>
				</tr>
				<tr>
					<th>��ϵ�绰��</th>
					<td><input name="lxdh"  type="text" value="" maxlength="100"  class="txtInput normal required" /></td>
				</tr>
				<tr>
					<th>ǰ�ڹ�����չ�����</th>
					<td><textarea name="qqgz"  rows="8" cols="30" id="webdescription" class="small" style="width:80%;"></textarea></td>
				</tr>
				</tbody>
			</table>
    	</div>
    	<div class="foot_btn_box">
			 <input  type="button" value="����"  onclick="save()" class="btnSubmit"/>
             <input  type="button" value="����"  onclick="back()" class="btnSubmit"/>
		</div>
    </form>
  </body>
</html>
