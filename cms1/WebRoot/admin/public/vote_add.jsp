<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
<link rel="stylesheet" type="text/css" href="../images/style.css"/>
<script type="text/javascript" src="../lib/jquery/jquery-1.3.2.min.js"></script>  
<script type="text/javascript" src="../js/function.js"></script>
  	<style>
	    body{
	        background-color:#ffffff;
	    }
	
	</style>
	
<script type="text/javascript">
	function contains(string,substr,isIgnoreCase){
		if(isIgnoreCase){
			string=string.toLowerCase();
			substr=substr.toLowerCase();
		}
		var startChar=substr.substring(0,1);
		var strLen=substr.length;
		for(var j=0;j<string.length-strLen+1;j++){
		    if(string.charAt(j)==startChar) {
		         if(string.substring(j,j+strLen)==substr){
		             return true;
		         }   
		    }
		}
		return false;
	}


       function back(){
           window.parent.hideFrame();
       }
    question_data=1;

    function deleteItem(u){
       $(u).prev().remove();
       $(u).next().remove();
       $(u).remove();
    
    }

    function deletequestion(i){
		var deleteweizhi='#questionarea'+i;
		$(deleteweizhi).remove();
	}
	function addSingleAnswer(b){
		var addweizhi='#answer'+b;
		$(addweizhi).append('<span><input type="radio" name="RadioGroup1" value="��ѡ" /><input type="text" /></span><input type="button" value="ɾ������" onclick="javascript:deleteItem(this)" /><br />');
		
	}
	function addMultiAnswer(c){
		var addweizhi='#answer'+c;
		$(addweizhi).append('<span><input type="checkbox" name="CheckboxGroup1" value="��ѡ��"  /><input type="text" /></span><input type="button" value="ɾ������" onclick="javascript:deleteItem(this)" /><br />');
		
	}
	
	function addSingle(){
		    var singleid=question_data;

			var singlehtml='<div id="questionarea'+singleid+'" data-id="'+singleid+'" data-type="1"><div><span id="name'+singleid +'">��ѡ���飺</span><input type="text" id="question'+singleid+'" />&nbsp;&nbsp;&nbsp;&nbsp;��Ŀ����<input type="text"  name="numsort" id="sort'+singleid+'"/>&nbsp;&nbsp;<input type="button" value="���ѡ��"  data-id="'+singleid+'" onclick="addSingleAnswer('+singleid+')" />&nbsp;&nbsp;<input type="button"  data-id="'+singleid+'" value="ɾ������" onclick="deletequestion('+singleid+')"  /></div><div style="padding-left:20px;" id="answer'+singleid+'">'+	
			'<span><input type="radio" name="RadioGroup1" value="��ѡ"  /><input type="text" /></span><input type="button" value="ɾ������" onclick="javascript:deleteItem(this)" /><br />'+
			'<span><input type="radio" name="RadioGroup1" value="��ѡ"  /><input type="text" /></span><input type="button" value="ɾ������" onclick="javascript:deleteItem(this)" /><br />'+
			'</div></div>';
			$('#point').append(singlehtml);
			//var temp1=singleid;
			question_data++;
		
	}

	function addMulti(){
		    var multiid=question_data;

			var multihtml='<div id="questionarea'+multiid+'" data-id="'+multiid+'" data-type="2"><div><span id="name'+multiid+'">��ѡ���飺</span><input type="text" id="question'+multiid+'" />&nbsp;&nbsp;&nbsp;&nbsp;��Ŀ����<input type="text"  name="numsort" id="sort'+multiid+'"/>&nbsp;&nbsp;<input type="button" value="���ѡ��"  data-id="'+multiid+'" onclick="addMultiAnswer('+multiid+')"  />&nbsp;&nbsp;<input type="button"  data-id="'+multiid+'" value="ɾ������"  onclick="deletequestion('+multiid+')" /></div><div style="padding-left:20px;" id="answer'+multiid+'">'+	
			'<span><input type="checkbox" name="CheckboxGroup1" value="��ѡ��" /><input type="text" /></span><input type="button" value="ɾ������" onclick="javascript:deleteItem(this)" /><br />'+
			'<span><input type="checkbox" name="CheckboxGroup1" value="��ѡ��"  /><input type="text" /></span><input type="button" value="ɾ������" onclick="javascript:deleteItem(this)" /><br />'+
			'</div></div>';
			$('#point').append(multihtml);
		//	var temp2=multiid;
		//	question_data.push(temp2);
		question_data++;
	}
	function submitData(){
		var questionstr="";
		var typestr="";
		var answerstr="";
		var sortstr="";
		$('div[data-type]').each(function() {
			
            var findid=$(this).attr("data-id");
			questionstr+=$('#question'+findid).val()+';';
			typestr+=$(this).attr("data-type")+';';
			sortstr+=$('#sort'+findid).val()+';';
			var answertemp="";
			$('#answer'+findid).find('input[type="text"]').each(function() {
				
                answertemp+=$(this).val()+'-';
            });
			answerstr+=answertemp+';';
        });
		$('#questionstr').attr('value',questionstr);
		$('#answerstr').attr('value',answerstr);
		$('#typestr').attr('value',typestr);
		$('#sortstr').attr('value',sortstr);
		

        var num1 = 0;
		$("input[type='text']").each(function() {
		     
		     if( $(this).val()==""){
		         num1++;
		     }
		
		});

		
		var num2 = 0;
		$("input[name='numsort']").each(function() {
		     if( /^\d+$/.test($(this).val())){
		        

		     }else{
		      num2++;
		     }
		
		});
		
		
		if(num1 > 0){
			alert("�ʾ��������������򶼱�������ֵ��");
		}else{
			if(num2 >0 ){
			    alert("����ű���Ϊ���֣�");		    		
		    }else{
		        if(contains(answerstr,";;",false)){
				   alert("�����±���Ҫ��ѡ�");
				}else{
									
					document.all.dataform.action='PeopleVoteServlet?act=add';
					document.all.dataform.submit();
				}
		    }
			
		}

	}
	
</script>
<script language="javascript" type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>


<title>�ޱ����ĵ�</title>
</head>

<body class="mainbody">

<div class="navigation"><a href="javascript:back();" class="back">����</a>��ҳ &gt; ���ڲ������ &gt; ���ϵ������</div>
    <div id="contentTab">
    <ul class="tab_nav">
        <li class="selected"><a onclick="tabs('#contentTab',0);" href="javascript:;">������ϵ���</a></li>
        <li><a onclick="tabs('#contentTab',1);" href="javascript:;">��ӵ���ѡ��</a></li>
    </ul>
    <form id="dataform" name="dataform" method="post" >
    <input type="hidden" name="typestr" id="typestr"/>
    <input type="hidden" name="questionstr" id="questionstr"/>
    <input type="hidden" name="answerstr" id="answerstr"/>
    <input type="hidden" name="sortstr" id="sortstr"/>
    <div class="tab_con" style="display:block;">
        <table class="form_table">
            <col width="150px"></col>
            <tbody>
            <tr>
                <th>��ʼʱ�䣺</th>
                <td><input class="Wdate" type="text" onClick="WdatePicker()" name="kssj"/><font color="red">&nbsp;*</font></td>
            </tr>
            <tr>
                <th>����ʱ�䣺</th>
                <td><input class="Wdate" type="text" onClick="WdatePicker()" name="jssj"/><font color="red">&nbsp;*</font></td>
            </tr>
            <tr>
                <th>������⣺</th>
                <td><input  type="text"  name="bt"/><font color="red">&nbsp;*</font></td>
            </tr>
            <tr>
                <th height="200">����˵����</th>
                <td><textarea  cols="40" rows="8" name="nr" ></textarea></td>
            </tr>

         </tbody>
       </table>
    </div>
    </form>
    <div class="tab_con">
    	<div style="height:35px;">
    		<input type="button" value="���뵥ѡ" onclick="addSingle()" /> 
    		<input type="button" value="�����ѡ" onclick="addMulti()" /> 
    	</div>
    	<table class="form_table">
            <tr>
                <td id="point">

                </td>
            </tr>
       </table>
    </div>
</div>

	<div class="foot_btn_box">

			 <input  type="button" value="����"  onclick="submitData()" class="btnSubmit"/>
             <input  type="button" value="����"  onclick="back()" class="btnSubmit"/>
		</div>
        
        
</body>
</html>
