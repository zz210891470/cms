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
	<link rel="stylesheet" type="text/css" href="<%=basePath%>admin/images/style.css"/>
	    <style>
	    body{
	        background-color:#ffffff;
	    }
	</style>
	<script type="text/javascript" src="<%=basePath%>admin/lib/jquery/jquery-1.3.2.min.js"></script>  
	<script type="text/javascript" src="<%=basePath%>admin/js/function.js"></script>
    <script type="text/javascript">
       function save(){
       	   if(document.getElementById("dywc").value==""){
       			alert("�������Ͷ�ʲ���Ϊ�գ�");
       			return;
       		}
       	   document.getElementById("zt").value="δ�ϱ�";
           $("#form").submit();
       }
       function saveup(){
       		if(document.getElementById("dywc").value==""){
       			alert("�������Ͷ�ʲ���Ϊ�գ�");
       			return;
       		}
       		if(document.getElementById("zt").value==""){
       			alert("���ٴκ˶�������ݣ��ϱ����޷������ݽ����޸ģ�");
       			document.getElementById("zt").value="���ϱ�";
       		}else{
       			if(confirm("ȷ��Ҫ�ϱ����ݣ�")){
       				$("#form").submit();
       			}
       		}
       }
       function back(){
           window.parent.hideFrame();
       }
       
    	function dwzjjs(){
    		var dwzj1=document.getElementById("dwzj1").value;
    		var dwzj2=document.getElementById("dwzj2").value;
    		var dwzj3=document.getElementById("dwzj3").value;
    		if (dwzj1=="") {
    			dwzj1 = "0";
			}
    		if (dwzj2=="") {
    			dwzj2 = "0";
			}
    		if (dwzj3=="") {
    			dwzj3 = "0";
			}
    		var hjdwzj="";
    		if(dwzj1!=""&&dwzj2!=""&&dwzj3!=""){
    			hjdwzj=parseFloat(dwzj1)+parseFloat(dwzj2)+parseFloat(dwzj3);
    			document.getElementById("span_hjdndw").innerHTML=parseFloat(hjdwzj)+parseFloat(document.getElementById("hjdndw").value);
    		}
    		document.getElementById("span_hjdydw").innerHTML=hjdwzj;
    		document.getElementById("hjdydw").value=hjdwzj;
    		if(dwzj1!=""){
    			document.getElementById("span_dndwzj").innerHTML=parseFloat(dwzj1)+parseFloat(document.getElementById("dndwzj1").value);
    		}
    		if(dwzj2!=""){
    			document.getElementById("span_dndwzj1").innerHTML=parseFloat(dwzj2)+parseFloat(document.getElementById("dndwzj2").value);
    		}
    		if(dwzj3!=""){
    			document.getElementById("span_dndwzj2").innerHTML=parseFloat(dwzj3)+parseFloat(document.getElementById("dndwzj3").value);
    		}
    		
    	}
    	
    	function kgdwzjjs(){
    		var kgdwzj1=document.getElementById("kgdwzj1").value;
    		var kgdwzj2=document.getElementById("kgdwzj2").value;
    		var kgdwzj3=document.getElementById("kgdwzj3").value;
    		if (kgdwzj1=="") {
    			kgdwzj1 = "0";
			}
    		if (kgdwzj2=="") {
    			kgdwzj2 = "0";
			}
    		if (kgdwzj3=="") {
    			kgdwzj3 = "0";
			}
    		var hjkgdw="";
    		if(kgdwzj1.value!=""&&kgdwzj2!=""&&kgdwzj3!=""){
    			hjkgdw=parseFloat(kgdwzj1)+parseFloat(kgdwzj2)+parseFloat(kgdwzj3);
    		}
    		document.getElementById("span_hjkgdw").innerHTML=hjkgdw;
    		document.getElementById("hjkgdw").value=hjkgdw;
    	}
    	function dywcjs(){
    		var dywc=document.getElementById("dywc").value;
    		if (dywc=="") {
    			dywc = "0";
			}
    		if(dywc!=""){
    			document.getElementById("span_dnwc").innerHTML=parseFloat(dywc)+parseFloat(document.getElementById("dnwc").value);
    			document.getElementById("span_kgwc").innerHTML=parseFloat(dywc)+parseFloat(document.getElementById("kgwc").value);
    		}
    	}
    </script>
  </head>
  <body class="mainbody">
  	<form name="form" method="post" action="<%=basePath%>admin/zdxm_sbyh/ZdxmSbyhServlet?action=addyb" id="form">
  	
  	<input type="hidden" value="${yf }" name="yf"/>
  	<input type="hidden" value="${id }" name="id"/>
    <table width="95%" border="0" align="center" cellspacing="0">
			<tr>
			<td width="85%" height="30">
				<b><font color="#336699">�������ص���Ŀ����Ϣ���� ${yf }�·�</font></b>
			</td>
			</tr>
	  </table>
  <table border="1" width="100%"  align="center" cellspacing="0">
    <tr>
      <td height="25" style="width: 16%" align="center">��Ŀ����</td>
      <td width="75%" colspan="5">&nbsp;${zdxm.mc }</td>
    </tr>
    <tr>
      <td height="50" style="width: 16%" align="center">�����ģ������</td>
      <td width="75%" colspan="5" style=" padding:5px; line-height:1.5;">${zdxm.jsgm }</td>
    </tr>
    <tr>
      <td height="25" style="width: 16%" align="center">��Ͷ�ʣ���Ԫ��</td>
      <td width="75%" colspan="5">&nbsp;${zdxm.ztz }</td>
    </tr>
    <tr>
      <td height="25" style="width: 16%" align="center">��������</td>
      <td width="75%" colspan="5">&nbsp;${zdxm.kgn }��${zdxm.kgy }��</td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25" bgcolor="#FFCCCC">
        <p align="left">�ʽ���Դ����λ�������λ����Ԫ��</p>
      </td>
    </tr>
    <tr>
      <td style="width: 16%" height="25" align="center">��Ͷ����Դ������</td>
      <td width="15%" align="center">��Ͷ��</td>
      <td width="14%" align="center">����ƻ�Ͷ��</td>
      <td width="15%" align="center">���µ�λ�ʽ�</td>
      <td width="15%" align="center">�����ۼ�<br/>��λ�ʽ�</td>
      <td width="19%" align="center">���������ۼ�<br/>��λ�ʽ�</td>
    </tr>
    <tr>
      <td align="center" style="width: 16%" height="25">ҵ���Գ�</td>
      <td width="15%" align="center">${zdxm.zjppzc }<input name="jhtz1" type="hidden" value="${zdxm.zjppzc}" />
      </td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">
          <input name="dwzj1" type="text" value="0" id="dwzj1" style="width:80px;" class="txtInput normal required" onchange="clearNoNum(this);dwzjjs();" />
      </td>
      <td width="15%" align="center" id="td_dndwzj1">
      	<span id="span_dndwzj">${zdxmyb.dnljdw1}</span>
      	<input name="dndwzj1" type="hidden" value="${zdxmyb.dnljdw1}" id="dndwzj1" /></td>
      <td width="15%" align="center">
      	<c:if test="${yf==1}">
      		<input name="kgdwzj1" type="text" value="0" id="kgdwzj1" style="width:80px;" class="txtInput normal required" onchange="clearNoNum(this);kgdwzjjs();" />
      	</c:if>
      	<c:if test="${yf>1}">
      		<span id="span_kgdwzj">${zdxmyb.kgljdw1}</span>
            <input name="kgdwzj1" type="hidden" value="${zdxmyb.kgljdw1}" id="kgdwzj1" />
      	</c:if>
      	</td>
    </tr>
    <tr>
      <td align="center" style="width: 16%" height="25">���д���</td>
      <td width="15%" align="center">${zdxm.zjppdk }<input name="jhtz2" type="hidden" value="${zdxm.zjppdk}" /></td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">
          <input name="dwzj2" type="text" value="0" id="dwzj2" style="width:80px;" class="txtInput normal required"  onchange="clearNoNum(this);dwzjjs();"/>
      </td>
      <td width="15%" align="center">
      	<span id="span_dndwzj1">${zdxmyb.dnljdw2}</span>
      	<input name="dndwzj2" type="hidden" value="${zdxmyb.dnljdw2}" id="dndwzj2" />
      </td>
      <td width="15%" align="center">
      	<c:if test="${yf==1}">
      		<input name="kgdwzj2" type="text" value="0" id="kgdwzj2" style="width:80px;" class="txtInput normal required" onchange="clearNoNum(this);kgdwzjjs();" />
      	</c:if>
      	<c:if test="${yf>1}">
      		<span id="span_kgdwzj1">${zdxmyb.kgljdw2}</span>
      		<input name="kgdwzj2" type="hidden" value="${zdxmyb.kgljdw2}" id="kgdwzj2" />
      	</c:if>
      </td>
    </tr>
     <tr>
      <td align="center" style="width: 16%" height="25">����Ͷ��</td>
      <td width="15%" align="center">${zdxm.zjppzf }<input name="jhtz3" type="hidden" value="${zdxm.zjppzf}" /></td>
      <td width="15%" align="center">&nbsp;</td>
      <td width="15%" align="center">
          <input name="dwzj3" type="text" value="0" id="dwzj3" style="width:80px;" class="txtInput normal required" onchange="clearNoNum(this);dwzjjs();" />
       </td>
      <td width="15%" align="center">
      	<span id="span_dndwzj2">${zdxmyb.dnljdw3}</span>
      	<input name="dndwzj3" type="hidden" value="${zdxmyb.dnljdw3}" id="dndwzj3" />
      </td>
      <td width="15%" align="center">
      	<c:if test="${yf==1}">
        	<input name="kgdwzj3" type="text" value="0" id="kgdwzj3" style="width:80px;" class="txtInput normal required" onchange="clearNoNum(this);kgdwzjjs();" />
        </c:if>
        <c:if test="${yf>1}">
      		<span id="span_gkdwzj2">${zdxmyb.kgljdw3}</span>
   	   		<input name="kgdwzj3" type="hidden" value="${zdxmyb.kgljdw3}" id="kgdwzj3" />
       	</c:if>
       </td>
    </tr>
 
    <tr>
      <td height="25" style="width: 16%" align="center">��&nbsp;&nbsp;&nbsp;�� </td>
      <td width="15%" align="center">${zdxm.ztz }</td>
      <td width="15%" align="center">${zdxm.jhtz }<input name="jhtzhj" type="hidden" value="${zdxm.jhtz }" /></td>
      <td width="15%" align="center">
      	<span id="span_hjdydw">0</span>
        <input name="hjdydw" type="hidden" value="0" id="hjdydw" />
      </td>
      <td width="15%" align="center">
      	<span id="span_hjdndw">${zdxmyb.dnljdwhj}</span>
        <input name="hjdndw" type="hidden" value="${zdxmyb.dnljdwhj}" id="hjdndw" />
      </td>
      <td width="15%" align="center">
      	<span id="span_hjkgdw">${zdxmyb.kgljdwhj}</span>
        <input name="hjkgdw" type="hidden" value="${zdxmyb.kgljdwhj}" id="hjkgdw" />
      </td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25" bgcolor="#FFCCCC" align="center">Ͷ������������λ����Ԫ��</td>
    </tr>
    <tr>
      <td width="40%" colspan="2" height="25" align="center">�������</td>
      <td width="30%" colspan="2" align="center">�����ۼ����</td>
      <td width="30%" colspan="2" align="center">���������ۼ����</td>
    </tr>
    <tr>
      <td width="40%" colspan="2" align="center"><input name="dywc" type="text" value="0" id="dywc" style="width:80px;" class="txtInput normal required" onchange="clearNoNum(this);dywcjs();" /></td>
      <td width="30%" colspan="2" align="center">
      	<span id="span_dnwc">${zdxmyb.nczbywc}</span>
        <input name="dnwc" type="hidden" value="${zdxmyb.nczbywc}" id="dnwc" />
      </td>
      <td width="30%" colspan="2" align="center">
      	<span id="span_kgwc">${zdxmyb.kgljwc}</span>
        <input name="kgwc" type="hidden" value="${zdxmyb.kgljwc}" id="kgwc" />
      </td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25" align="left">��������������Ⱥ��ѿ�չ����Ҫ����      </td>
    </tr>
    <tr>
      <td width="100%" colspan="6">
          <textarea name="xxjd" rows="2" cols="20" id="xxjd" style="font-family:����;height:80px;width:95%;" class="txtInput normal required"></textarea>
      </td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25" align="left">����������Ͷ��ʱ�䡢���ݼ�������������</td>
    </tr>
    <tr>
      <td width="100%" colspan="6">
          <textarea name="scnl" rows="2" cols="20" id="scnl" style="font-family:����;height:80px;width:95%;" class="txtInput normal required"></textarea>
      </td>
    </tr>
    <tr>
      <td width="100%" colspan="6" height="25" align="left">��Ŀ�ƽ��д��ڵ����⼰���ȡ�Ĵ�ʩ�Ͱ취
      </td>
    </tr>
    <tr>
      <td width="100%" colspan="6">
          <textarea name="czwt" rows="2" cols="20" id="czwt" style="font-family:����;height:80px;width:95%;" class="txtInput normal required"></textarea>
      </td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6" height="25" align="left">��Ҫ�������йز���Э�����������</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6">
          <textarea name="xtjj" rows="2" cols="20" id="xtjj" style="font-family:����;height:80px;width:95%;" class="txtInput normal required"></textarea>
      </td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6" height="25" align="left">�¸��£����ȣ������ƻ�������</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6">
          <textarea name="gzjh" rows="2" cols="20" id="gzjh" style="font-family:����;height:80px;width:95%;" class="txtInput normal required"></textarea>
      </td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6" height="25" align="left">�ν���λ�½������</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6">
          <textarea name="jcqk" rows="2" cols="20" id="jcqk" style="font-family:����;height:80px;width:95%;" class="txtInput normal required"></textarea>
      </td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6" height="25" align="left">�ʽ�˵���������ʽ��Ƿ���ʵ����λ�ʽ��Ƿ����㽨����Ҫ����ڵ������ʽ����⣩</td>
    </tr>
    
    <tr>
      <td width="100%" colspan="6">
          <textarea name="zjsm" rows="2" cols="20" id="zjsm" style="font-family:����;height:80px;width:95%;" class="txtInput normal required"></textarea>
      </td>
    </tr>
  </table>
  <div class="foot_btn_box">
  		<input type="hidden" id="zt" name="zt" value="" />
  		 <input  type="button" value="���沢�ϱ�"  onclick="saveup()" class="btnSubmit"/>&nbsp;&nbsp;
         <input  type="button" value="�� ��"  onclick="save()" class="btnSubmit"/>&nbsp;&nbsp;
         <input  type="button" value="�� ��"  onclick="back()" class="btnSubmit"/>
    </div>
  </form>
  </body>
</html>
