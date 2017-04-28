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

	<script type="text/javascript" src="<%=basePath%>admin/lib/jquery-1.7.min.js"></script>  
	<script type="text/javascript" src="../js/function.js"></script>
    <script language="javascript" type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>
     <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = '<%=basePath%>admin/editor/';
    </script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>admin/editor/themes/default/css/ueditor.css"/>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>admin/editor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>admin/editor/ueditor.all.min.js"></script>
    
		<style type="text/css">
	.table{width:100%; font-family:Verdana, Geneva, sans-serif; }
	
	</style>
	<style>
	    body{
	        background-color:#ffffff;
	    }
	
	</style>
	
	<script type="text/javascript">
       function save(){
           if( $("#nd").val()=="" || $("#mc").val()=="" || $("#bssj").val()==""��){
               alert("��Ŀ��ȣ���Ŀ���ƺͱ���ʱ�����Ҫ��д��");
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
           if($("#status").val()=="ok"){
              alert("����ɹ�");
           }
           
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
  <input id="status" value="${status }" type="hidden"/>
	<form name="form" method="post" action="<%=basePath%>admin/cbxm_sbyh/CbxmSbyhServlet?action=sadd" id="form">
    	<div class="navigation">��ҳ &gt; ������Ŀ���� &gt; ��Ŀ��Ϣ¼��</div>
    	<div class="tab_con" style="display:block;">
    		<table class="form_table">
				<col width="160px"></col>
				<col width="160px"></col>
				<tbody>
				<tr>
					<th>��Ŀ��ȣ�</th>
					<td colspan="5"><input name="nd" id="nd" type="text" value="" maxlength="4" onkeyup="clearNoNum(this)"  class="" /><span style="color:red">*</span></td>
				</tr>
				<tr>
					<th>��Ŀ���ƣ�</th>
					<td colspan="5"><input name="mc" id="mc" type="text" value="" maxlength="100"  class="" size="35"/><span style="color:red">*</span></td>
				</tr>
				<tr>
					<th>������</th>
					<td colspan="2">
						<select name="dq"  >
						<option value="" selected>��ѡ������</option>
					    <c:forEach  items="${dqlist}" var="item">
					        <option value="${item }">${item }</option>
					    </c:forEach>
					    </select>
					</td>
					<th>����ص㣺</th>
					<td colspan="2"><input name="jsdd" type="text" value="" maxlength="100"  class="" /></td>
				</tr>
				<tr>
					<th>��Ŀ���</th>
					<td colspan="2">						
					    <select name="lb1" id="lb1" onchange="lbchange(this)"; >
					    </select>&nbsp;&nbsp;&nbsp;
					    <select name="lb2" id="lb2"  >
					    </select>
					</td>
					<th>���������</th>
					<td colspan="2">
						<select name="bgs" id="bgs" >
							<option value="�������о�����">�������о�����</option>
							<option value="Ԥ�������о�����">Ԥ�������о�����</option>
							<option value="��Ŀ������">��Ŀ������</option>
					    </select>
					</td>
				</tr>
				<tr>
					<th>�걨��λ��</th>
					<td colspan="5"><input name="sbdw"  type="text" value="" maxlength="100"  class=""  size="35"/></td>
				</tr>
				<tr>
					<th>��ϵ�ˣ�</th>
					<td><input name="lxr"  type="text" value="" maxlength="100"  class="" /></td>
					<th>��ϵ�绰��</th>
					<td><input name="lxdh"  type="text" value="" maxlength="100"  class="" /></td>
					<th>�������䣺</th>
					<td><input name="dzyx"  type="text" value="" maxlength="100"  class="" /></td>
				</tr>
				<tr>
					<th>�߻���λ��</th>
					<td colspan="3"><input name="chdw"  type="text" value="" maxlength="100"  class="" size="35"/></td>
					<th>���ʵȼ���</th>
					<td><input name="zzdj"  type="text" value="" maxlength="100"  class="" /></td>
				</tr>
				<tr>
					<th>��ϵ�ˣ�</th>
					<td><input name="lxr1"  type="text" value="" maxlength="100"  class="" /></td>
					<th>��ϵ�绰��</th>
					<td><input name="lxdh1"  type="text" value="" maxlength="100"  class="" /></td>
					<th>�������䣺</th>
					<td><input name="dzyx1"  type="text" value="" maxlength="100"  class="" /></td>
				</tr>
				<tr>
					<th>�а쵥λ��</th>
					<td colspan="5"><input name="cbdw"  type="text" value="" maxlength="100"  class=""  size="35"/></td>
				</tr>
				<tr>
					<th>��ϵ�ˣ�</th>
					<td><input name="lxr2"  type="text" value="" maxlength="100"  class="" /></td>
					<th>��ϵ�绰��</th>
					<td><input name="lxdh2"  type="text" value="" maxlength="100"  class="" /></td>
					<th>�������䣺</th>
					<td><input name="dzyx2"  type="text" value="" maxlength="100"  class="" /></td>
				</tr>
				<tr>
					<th>������ʽ��</th>
					<td colspan="5">
						<select name="hzfs" id="hzfs" >
							<option value="����">����</option>
							<option value="����">����</option>
							<option value="����">����</option>
					    </select>
					</td>
				</tr>
				<tr>
					<th>��Ŀ�������������̣�</th>
					<td colspan="5"><textarea name="lygc"  rows="8" cols="20" id="webdescription" class="small" style="width:80%;"></textarea></td>
				</tr>
				<tr>
					<th>��Ŀ��Ͷ�ʣ���Ԫ����</th>
					<td colspan="5"><input name="ztz"  type="text" value=""  onkeyup="clearNoNum(this)"   maxlength="100"  class="" /></td>
				</tr>
				<tr>
					<th>��Ŀ�����ģ�����ݣ�</th>
					<td colspan="5"><textarea name="jsgm"  rows="8" cols="20" id="webdescription" class="small" style="width:80%;"></textarea></td>
				</tr>
				<tr>
					<th>��Ŀ��Ҫ����������</th>
					<td colspan="5"><textarea name="jstj"  rows="8" cols="30" id="webdescription" class="small" style="width:80%;"></textarea></td>
				</tr>
				<tr>
					<th>��Ŀ����Ч�������</th>
					<td colspan="5"><textarea name="xyfx"  rows="8" cols="30" id="webdescription" class="small" style="width:80%;"></textarea></td>
				</tr>
				<tr>
					<th>��Ҫ��������ָ�꣺</th>
					<td colspan="5">
					 <script type="text/plain" id="editor" name="jsjjzb" style="width:99%;">
                     ${item.jsjjzb }
	                </script> 
	                   <script type="text/javascript">
						var editor;
		                var noteEditor;
		                $(document).ready(function(){
		                        editor = new baidu.editor.ui.Editor({
								autoHeightEnabled: false,
		                        initialFrameHeight:300,
		                        initialFrameWidth:825,
		                        textarea:'descriptionEditor'
		                    });
		                    editor.render("editor");
		               });
			</script>
					</td>
				</tr>
				<tr>
					<th>��Ŀǰ���ƽ�״����</th>
					<td colspan="5"><textarea name="tjzk"  rows="8" cols="30" id="webdescription" class="small" style="width:80%;"></textarea></td>
				</tr>
				<tr>
					<th>����ʱ�䣺</th>
					<td colspan="5"><input class="Wdate" id="bssj" type="text" onClick="WdatePicker()"  name="bssj"/> <span style="color:red;">*</span></td>
				</tr>
				</tbody>
			</table>
    	</div>
    	<div class="foot_btn_box">
			 <input  type="button" value="����"  onclick="save()" class="btnSubmit"/>
             
		</div>
    </form>
  </body>
</html>