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
	<style type="text/css">
	.table{width:100%; font-family:Verdana, Geneva, sans-serif; }
	
	</style>
	<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script>  
	<script type="text/javascript" src="../js/function.js"></script>
  	<style>
	    body{
	        background-color:#ffffff;
	    }
	</style>
	<script type="text/javascript">
		
	   function shtg(i){
	       if(confirm("���ͨ��˵����Ŀ��д��ȷ��ȷ��ͨ����")){
	            document.all.form.action='<%=basePath%>admin/cbxm/CbxmServlet?action=shtg&id='+i; 
	            document.all.form.submit(); 
	       }
	   }
	 
	   function thsq(i){
	   	   if(confirm("��Ŀ�˻�˵����Ŀ��Ϣ�����˻��޸ģ�")){
	       	    document.all.form.action='<%=basePath%>admin/cbxm/CbxmServlet?action=thsq&id='+i; 
	            document.all.form.submit(); 
	       
	       }
	   }
	   
	   function back(){
           window.parent.hideFrame();
       }
	</script>
  </head>
  <body class="mainbody">
	<form name="form" method="post" action="<%=basePath%>admin/zdxm/ZdxmServlet?action=add" id="form">
    	<div class="navigation"><a href="javascript:back();"  class="back">����</a>��ҳ &gt; �ص���Ŀ���� &gt; ��Ŀ��Ϣ����</div>
    	<div class="tab_con" style="display:block;">
    		<table class="form_table">
				<col width="150px"></col>
				<tbody>
				<tr>
					<th>��Ŀ��ȣ�</th>
					<td colspan="5">${item.nd }</td>
				</tr>
				<tr>
					<th>��Ŀ���ƣ�</th>
					<td colspan="5">${item.mc }</td>
				</tr>
				<tr>
					<th>������</th>
					<td colspan="2">
						${item.dq}
					</td>
					<th>����ص㣺</th>
					<td colspan="2">${item.jsdd }</td>
				</tr>
				<tr>
					<th>��Ŀ���</th>
					<td colspan="2">						
					    ${item.lb1}<br />
					    ${item.lb2}
					</td>
					<th>���������</th>
					<td colspan="2">
						${item.bgs}
					</td>
				</tr>
				
				<tr>
					<th>�걨��λ��</th>
					<td colspan="5">${item.sbdw }</td>
				</tr>
				<tr>
					<th>��ϵ�ˣ�</th>
					<td>${item.lxr }</td>
					<th>��ϵ�绰��</th>
					<td>${item.lxdh }</td>
					<th>�������䣺</th>
					<td>${item.dzyx }</td>
				</tr>
				<tr>
					<th>�߻���λ��</th>
					<td colspan="3">${item.chdw }</td>
					<th>���ʵȼ���</th>
					<td>${item.zzdj }</td>
				</tr>
				<tr>
					<th>��ϵ�ˣ�</th>
					<td>${item.lxr1 }</td>
					<th>��ϵ�绰��</th>
					<td>${item.lxdh1 }</td>
					<th>�������䣺</th>
					<td>${item.dzyx1 }</td>
				</tr>
				<tr>
					<th>�а쵥λ��</th>
					<td colspan="5">${item.cbdw }</td>
				</tr>
				<tr>
					<th>��ϵ�ˣ�</th>
					<td>${item.lxr2 }</td>
					<th>��ϵ�绰��</th>
					<td>${item.lxdh2 }</td>
					<th>�������䣺</th>
					<td>${item.dzyx2 }</td>
				</tr>
				<tr>
					<th>������ʽ��</th>
					<td colspan="5">
						${item.hzfs}
					</td>
				</tr>
				<tr>
					<th>��Ŀ�������������̣�</th>
					<td colspan="5">${item.lygc }</td>
				</tr>
				<tr>
					<th>��Ŀ��Ͷ�ʣ���Ԫ����</th>
					<td colspan="5">${item.ztz }</td>
				</tr>
				<tr>
					<th>�����ģ�����ݣ�</th>
					<td colspan="5">${item.jsgm }</td>
				</tr>
				<tr>
					<th>��Ŀ��Ҫ����������</th>
					<td colspan="5">${item.jstj }</td>
				</tr>
				<tr>
					<th>��Ŀ����Ч�������</th>
					<td colspan="5">${item.xyfx }</td>
				</tr>
				<tr>
					<th>��Ҫ��������ָ�꣺</th>
					<td colspan="5">${item.jsjjzb }</td>
				</tr>
				<tr>
					<th>��Ŀǰ���ƽ�״����</th>
					<td colspan="5">${item.tjzk }</td>
				</tr>
				<tr>
					<th>����ʱ�䣺</th>
					<td>${item.bssj }</td>
				</tr>
				<tr>
					<th> ��������</th>
					<td><textarea name="shyj"  rows="8" cols="30" id="webdescription" class="small" style="width:80%;">${item.shyj }</textarea></td>
				</tr>
				</tbody>
			</table>
    	</div>
    	<div class="foot_btn_box">
    	     <input  type="button" value="���ͨ��"  onclick="shtg(${item.id })" class="btnSubmit"/>
    	     <input  type="button" value="�˻�����"  onclick="thsq(${item.id })" class="btnSubmit"/>
             <input  type="button" value="����"  onclick="back()" class="btnSubmit"/>
		</div>
    </form>
  </body>
</html>
