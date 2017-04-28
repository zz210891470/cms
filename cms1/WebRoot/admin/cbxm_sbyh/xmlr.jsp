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
           if( $("#nd").val()=="" || $("#mc").val()=="" || $("#bssj").val()==""　){
               alert("项目年度，项目名称和报送时间必须要填写！");
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
              alert("保存成功");
           }
           
           var temp = $("#lblist").val() ;
           
           if(temp != ""){             
               lblist = eval(temp);  
               var lb1html ='<option value="" selected>--请选择行业大类--</option>';
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
    	<div class="navigation">首页 &gt; 储备项目管理 &gt; 项目信息录入</div>
    	<div class="tab_con" style="display:block;">
    		<table class="form_table">
				<col width="160px"></col>
				<col width="160px"></col>
				<tbody>
				<tr>
					<th>项目年度：</th>
					<td colspan="5"><input name="nd" id="nd" type="text" value="" maxlength="4" onkeyup="clearNoNum(this)"  class="" /><span style="color:red">*</span></td>
				</tr>
				<tr>
					<th>项目名称：</th>
					<td colspan="5"><input name="mc" id="mc" type="text" value="" maxlength="100"  class="" size="35"/><span style="color:red">*</span></td>
				</tr>
				<tr>
					<th>地区：</th>
					<td colspan="2">
						<select name="dq"  >
						<option value="" selected>请选择区域</option>
					    <c:forEach  items="${dqlist}" var="item">
					        <option value="${item }">${item }</option>
					    </c:forEach>
					    </select>
					</td>
					<th>建设地点：</th>
					<td colspan="2"><input name="jsdd" type="text" value="" maxlength="100"  class="" /></td>
				</tr>
				<tr>
					<th>项目类别：</th>
					<td colspan="2">						
					    <select name="lb1" id="lb1" onchange="lbchange(this)"; >
					    </select>&nbsp;&nbsp;&nbsp;
					    <select name="lb2" id="lb2"  >
					    </select>
					</td>
					<th>报告书类别：</th>
					<td colspan="2">
						<select name="bgs" id="bgs" >
							<option value="可行性研究报告">可行性研究报告</option>
							<option value="预可行性研究报告">预可行性研究报告</option>
							<option value="项目建设书">项目建设书</option>
					    </select>
					</td>
				</tr>
				<tr>
					<th>申报单位：</th>
					<td colspan="5"><input name="sbdw"  type="text" value="" maxlength="100"  class=""  size="35"/></td>
				</tr>
				<tr>
					<th>联系人：</th>
					<td><input name="lxr"  type="text" value="" maxlength="100"  class="" /></td>
					<th>联系电话：</th>
					<td><input name="lxdh"  type="text" value="" maxlength="100"  class="" /></td>
					<th>电子邮箱：</th>
					<td><input name="dzyx"  type="text" value="" maxlength="100"  class="" /></td>
				</tr>
				<tr>
					<th>策划单位：</th>
					<td colspan="3"><input name="chdw"  type="text" value="" maxlength="100"  class="" size="35"/></td>
					<th>资质等级：</th>
					<td><input name="zzdj"  type="text" value="" maxlength="100"  class="" /></td>
				</tr>
				<tr>
					<th>联系人：</th>
					<td><input name="lxr1"  type="text" value="" maxlength="100"  class="" /></td>
					<th>联系电话：</th>
					<td><input name="lxdh1"  type="text" value="" maxlength="100"  class="" /></td>
					<th>电子邮箱：</th>
					<td><input name="dzyx1"  type="text" value="" maxlength="100"  class="" /></td>
				</tr>
				<tr>
					<th>承办单位：</th>
					<td colspan="5"><input name="cbdw"  type="text" value="" maxlength="100"  class=""  size="35"/></td>
				</tr>
				<tr>
					<th>联系人：</th>
					<td><input name="lxr2"  type="text" value="" maxlength="100"  class="" /></td>
					<th>联系电话：</th>
					<td><input name="lxdh2"  type="text" value="" maxlength="100"  class="" /></td>
					<th>电子邮箱：</th>
					<td><input name="dzyx2"  type="text" value="" maxlength="100"  class="" /></td>
				</tr>
				<tr>
					<th>合作方式：</th>
					<td colspan="5">
						<select name="hzfs" id="hzfs" >
							<option value="独资">独资</option>
							<option value="合资">合资</option>
							<option value="合作">合作</option>
					    </select>
					</td>
				</tr>
				<tr>
					<th>项目提出的理由与过程：</th>
					<td colspan="5"><textarea name="lygc"  rows="8" cols="20" id="webdescription" class="small" style="width:80%;"></textarea></td>
				</tr>
				<tr>
					<th>项目总投资（万元）：</th>
					<td colspan="5"><input name="ztz"  type="text" value=""  onkeyup="clearNoNum(this)"   maxlength="100"  class="" /></td>
				</tr>
				<tr>
					<th>项目建设规模及内容：</th>
					<td colspan="5"><textarea name="jsgm"  rows="8" cols="20" id="webdescription" class="small" style="width:80%;"></textarea></td>
				</tr>
				<tr>
					<th>项目主要建设条件：</th>
					<td colspan="5"><textarea name="jstj"  rows="8" cols="30" id="webdescription" class="small" style="width:80%;"></textarea></td>
				</tr>
				<tr>
					<th>项目经济效益分析：</th>
					<td colspan="5"><textarea name="xyfx"  rows="8" cols="30" id="webdescription" class="small" style="width:80%;"></textarea></td>
				</tr>
				<tr>
					<th>主要技术经济指标：</th>
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
					<th>项目前期推进状况：</th>
					<td colspan="5"><textarea name="tjzk"  rows="8" cols="30" id="webdescription" class="small" style="width:80%;"></textarea></td>
				</tr>
				<tr>
					<th>报送时间：</th>
					<td colspan="5"><input class="Wdate" id="bssj" type="text" onClick="WdatePicker()"  name="bssj"/> <span style="color:red;">*</span></td>
				</tr>
				</tbody>
			</table>
    	</div>
    	<div class="foot_btn_box">
			 <input  type="button" value="保存"  onclick="save()" class="btnSubmit"/>
             
		</div>
    </form>
  </body>
</html>