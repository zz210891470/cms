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
	<title>ϵͳ������Ϣ����</title>
</head>

<body class="mainbody">
<form name="form1" method="post" action="SysConfigServlet?act=save" id="form1">
	<div class="navigation">��ҳ &gt; ϵͳ���ù��� &gt; ϵͳ��������</div>
	<div id="contentTab">
		<ul class="tab_nav">
			<li class="selected"><a onclick="tabs('#contentTab',0);" href="javascript:;">��վ������Ϣ</a></li>
			<li style="display:none;"><a onclick="tabs('#contentTab',1);" href="javascript:void(0);">����Ȩ������</a></li>
			<li style="display:none;"><a onclick="tabs('#contentTab',2);" href="javascript:void(0);">�ʼ���������</a></li>
			<li style="display:none;"><a onclick="tabs('#contentTab',3);" href="javascript:void(0);">��������</a></li>
		</ul>
		<div class="tab_con" style="display:block;">
		<table class="form_table">
				<col width="180px"><col>
				<tbody>
				<tr>
					<th>վ�����ƣ�</th>
					<input name="id" type="hidden" value="${webconfig.id }" />
					<td><input name="webname" value="${webconfig.zdmc }" type="text" value="" maxlength="100" id="webname" class="txtInput normal required" /><label>*</label></td>
				</tr>
				<tr>
					<th>��λ���ƣ�</th>
					<td><input name="webcompany" value="${webconfig.dwmc }" type="text" value="" maxlength="100" id="webcompany" class="txtInput normal required" /><label>*</label></td>
				</tr>
				<tr>
					<th>��վ������</th>
					<td><input name="weburl" value="${webconfig.wzym }" type="text" value="" maxlength="250" id="weburl" class="txtInput normal required url" /><label>*�ԡ�http://����ͷ</label></td>
				</tr>
				<tr>
					<th>��ϵ�绰��</th>
					<td><input name="webtel" value="${webconfig.lxdh }" type="text" value="" maxlength="50" id="webtel" class="txtInput normal" /></td>
				</tr>
				<tr>
					<th>������룺</th>
					<td><input name="webfax" value="${webconfig.czhm }"  type="text" value="" maxlength="50" id="webfax" class="txtInput normal" /></td>
				</tr>
				<tr>
					<th>����Ա���䣺</th>
					<td><input name="webmail" value="${webconfig.glyyx }"  type="text" value="" maxlength="100" id="webmail" class="txtInput normal email" /></td>
				</tr>
				<tr>
					<th>��վ�����ţ�</th>
					<td><input name="webcrod" value="${webconfig.icp }"  type="text" value="" maxlength="50" id="webcrod" class="txtInput normal" /></td>
				</tr>
				<tr>
					<th>��ҳ����(SEO)��</th>
					<td><input name="webtitle" value="${webconfig.sybt }" type="text" value="" maxlength="250" id="webtitle" class="txtInput normal required" style="width:350px;" /><label>*�Զ������ҳ����</label></td>
				</tr>
				<tr>
					<th>ҳ��ؽ���(SEO)��</th>
					<td><input name="webkeyword" value="${webconfig.ymgjc }" type="text" value="" maxlength="250" id="webkeyword" class="txtInput" style="width:350px;" />
						<label>ҳ��ؼ���(keyword)</label></td>
				</tr>
				<tr>
					<th>ҳ������(SEO)��</th>
					<td><textarea name="webdescription"  rows="2" cols="20" id="webdescription" class="small"> ${webconfig.ymms} </textarea>
						<label>ҳ������(description)</label></td>
				</tr>
				<tr>
					<th>��վ��Ȩ��Ϣ��</th>
					<td><textarea name="webcopyright" rows="2" cols="20" id="webcopyright" class="small">${webconfig.bqxx } </textarea><label>֧��HTML��ʽ</label></td>
				</tr>
				</tbody>
			</table>
		</div>
		<div class="tab_con">
        <table class="form_table">
            <col width="180px"><col>
            <tbody>
            <tr>
                <th>��վ��װĿ¼��</th>
                <td><input name="webpath" type="text" value="" maxlength="100" id="webpath" class="txtInput normal required" /><label>*��Ŀ¼�£����롰/�����磺http://abc.com/web�����롰web/��</label></td>
            </tr>
            <tr>
                <th>��վ����Ŀ¼��</th>
                <td><input name="webmanagepath"  type="text" value="" maxlength="100" id="webmanagepath" class="txtInput normal required" minlength="2" /><label>*Ĭ����admin�����Ѿ����ģ�������Ŀ¼��</label></td>
            </tr>
            <tr>
                <th>URL��д���أ�</th>
                <td>
                    <span id="staticstatus"><input id="staticstatus_0" type="radio" name="staticstatus" value="0" /><label for="staticstatus_0">�ر�</label><input id="staticstatus_1" type="radio" name="staticstatus" value="1" /><label for="staticstatus_1">αURL��д</label></span>
                    <label>(<a href="url_rewrite_list.aspx">�༭α��̬url�滻����</a>)</label>
                </td>
            </tr>
            <tr>
                <th>��̬URL��׺��</th>
                <td><input name="staticextension"  type="text" value="" maxlength="100" id="staticextension" class="txtInput small required" minlength="2" /><label>*��չ������������.�����磺aspx��html</label></td>
            </tr>
            <tr>
                <th>������Ա���ܣ�</th>
                <td>
                    <span id="memberstatus"><input id="memberstatus_0"  type="radio" name="memberstatus" value="0" /><label for="memberstatus_0">�ر�</label><input id="memberstatus_1" type="radio" name="memberstatus" value="1" /><label for="memberstatus_1">����</label></span>
                    <label></label>
                </td>
            </tr>
            <tr>
                <th>����������ˣ�</th>
                <td>
                    <span id="commentstatus"><input id="commentstatus_0" type="radio" name="commentstatus" value="0" /><label for="commentstatus_0">�ر�</label><input id="commentstatus_1" type="radio" name="commentstatus" value="1" /><label for="commentstatus_1">����</label></span>
                    <label></label>
                </td>
            </tr>
            <tr>
                <th>��̨������־��</th>
                <td>
                    <span id="logstatus"><input id="logstatus_0" type="radio" name="logstatus" value="0" /><label for="logstatus_0">�ر�</label><input id="logstatus_1" type="radio" name="logstatus" value="1" /><label for="logstatus_1">����</label></span>
                    <label></label>
                </td>
            </tr>
            <tr>
                <th>�Ƿ�ر���վ��</th>
                <td>
                    <span id="webstatus"><input id="webstatus_0" type="radio" name="webstatus" value="0" /><label for="webstatus_0">�ر�</label><input id="webstatus_1" type="radio" name="webstatus" value="1"/><label for="webstatus_1">����</label></span>
                    <label></label>
                </td>
            </tr>
            <tr>
                <th>�ر�ԭ��������</th>
                <td><textarea name="webclosereason"    rows="2" cols="20" id="webclosereason" class="small"></textarea><label>֧��HTML��ʽ</label></td>
            </tr>
            <tr>
                <th>��վͳ�ƴ��룺</th>
                <td><textarea name="webcountcode" rows="2" cols="20" id="webcountcode" class="small"></textarea><label>֧��HTML��ʽ</label></td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="tab_con">
        <table class="form_table">
            <col width="180px"><col>
            <tbody>
            <tr>
                <th>STMP��������</th>
                <td><input name="emailstmp" type="text" value="" maxlength="100" id="emailstmp" class="txtInput normal required" /><label>*�����ʼ���SMTP��������ַ</label></td>
            </tr>
            <tr>
                <th>SMTP�˿ڣ�</th>
                <td><input name="emailport" type="text" value="" maxlength="10" id="emailport" class="txtInput small required digits" /><label>*SMTP�������Ķ˿�</label></td>
            </tr>
            <tr>
                <th>�����˵�ַ��</th>
                <td><input name="emailfrom" type="text" value="" maxlength="100" id="emailfrom" class="txtInput normal required" /><label>*</label></td>
            </tr>
            <tr>
                <th>�����˺ţ�</th>
                <td><input name="emailusername" type="text" value="" maxlength="100" id="emailusername" class="txtInput normal required" /><label>*</label></td>
            </tr>
            <tr>
                <th>�������룺</th>
                <td><input name="emailpassword" type="password" maxlength="100" id="emailpassword" class="txtInput normal required" value="" /><label>*</label></td>
            </tr>
            <tr>
                <th>�������ǳƣ�</th>
                <td><input name="emailnickname" type="text" value="" maxlength="100" id="emailnickname" class="txtInput normal required" /><label>*��ʾ�����˵��ǳ�</label></td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="tab_con">
        <table class="form_table">
            <col width="180px"><col>
            <tbody>
            <tr>
                <th>�����ϴ�Ŀ¼��</th>
                <td><input name="attachpath" type="text" value="" maxlength="100" id="attachpath" class="txtInput normal required" minlength="2" /><label>*�ϴ�ͼƬ�򸽼���Ŀ¼���Զ���������վ��Ŀ¼��</label></td>
            </tr>
            <tr>
                <th>�����ϴ����ͣ�</th>
                <td><input name="attachextension" type="text" value="" maxlength="250" id="attachextension" class="txtInput normal required" /><label>*��Ӣ�ĵĶ��ŷָ������磺��jpg,gif,rar��</label></td>
            </tr>
            <tr>
                <th>�������淽ʽ��</th>
                <td>
                    <select name="attachsave" id="attachsave" class="select2">
	<option value="1">��������ÿ��һ��Ŀ¼</option>
	<option selected="selected" value="2">������/��/���벻ͬĿ¼</option>

</select>
                </td>
            </tr>
            <tr>
                <th>�ļ��ϴ���С��</th>
                <td><input name="attachfilesize" type="text" value="" maxlength="10" id="attachfilesize" class="txtInput small required number" />KB<label>*�������õ��ļ���С�����ϴ���0������</label></td>
            </tr>
            <tr>
                <th>ͼƬ�ϴ���С��</th>
                <td><input name="attachimgsize" type="text" value="" maxlength="10" id="attachimgsize" class="txtInput small required number" />KB<label>*�������õ�ͼƬ��С�����ϴ���0������</label></td>
            </tr>
            <tr>
                <th>ͼƬ���ߴ磺</th>
                <td>
                    <input name="attachimgmaxheight" type="text" value="" maxlength="10" id="attachimgmaxheight" class="txtInput small2 required digits" />��
                    <input name="attachimgmaxwidth" type="text" value="" maxlength="10" id="attachimgmaxwidth" class="txtInput small2 required digits" />px
                    <label>*����ͼƬ�ߺͿ������Զ��ü���0Ϊ��������</label>
                </td>
            </tr>
            <tr>
                <th>��������ͼ��С��</th>
                <td>
                    <input name="thumbnailheight" type="text" value="" maxlength="10" id="thumbnailheight" class="txtInput small2 required digits" />��
                    <input name="thumbnailwidth" type="text" value="" maxlength="10" id="thumbnailwidth" class="txtInput small2 required digits" />px
                    <label>*ͼƬ��������ͼ�ߺͿ�0Ϊ������</label>
                </td>
            </tr>
            <tr>
                <th>ͼƬˮӡ���ͣ�</th>
                <td>
                    <span id="watermarktype"><input id="watermarktype_0" type="radio" name="watermarktype" value="0" /><label for="watermarktype_0">�ر�ˮӡ </label><input id="watermarktype_1" type="radio" name="watermarktype" value="1" /><label for="watermarktype_1">����ˮӡ </label><input id="watermarktype_2" type="radio" name="watermarktype" value="" /><label for="watermarktype_2">ͼƬˮӡ </label></span>
                </td>
            </tr>
            <tr>
                <th>ͼƬˮӡλ�ã�</th>
                <td>
                    <span id="watermarkposition"><input id="watermarkposition_0" type="radio" name="watermarkposition" value="1" /><label for="watermarkposition_0">���� </label><input id="watermarkposition_1" type="radio" name="watermarkposition" value="2" /><label for="watermarkposition_1">���� </label><input id="watermarkposition_2" type="radio" name="watermarkposition" value="3" /><label for="watermarkposition_2">���� </label><input id="watermarkposition_3" type="radio" name="watermarkposition" value="4" /><label for="watermarkposition_3">���� </label><input id="watermarkposition_4" type="radio" name="watermarkposition" value="5" /><label for="watermarkposition_4">���� </label><input id="watermarkposition_5" type="radio" name="watermarkposition" value="6" /><label for="watermarkposition_5">���� </label><input id="watermarkposition_6" type="radio" name="watermarkposition" value="7" /><label for="watermarkposition_6">���� </label><input id="watermarkposition_7" type="radio" name="watermarkposition" value="8" /><label for="watermarkposition_7">���� </label><input id="watermarkposition_8" type="radio" name="watermarkposition" value="9" /><label for="watermarkposition_8">���� </label></span>
                </td>
            </tr>
            <tr>
                <th>ͼƬ����������</th>
                <td><input name="watermarkimgquality" type="text" value="" maxlength="3" id="watermarkimgquality" class="txtInput small required digits" /><label>*ֻ�����ڼ�ˮӡ��jpeg��ʽͼƬ.ȡֵ��Χ 0-100, 0�������, 100�������, Ĭ��80</label></td>
            </tr>
            <tr>
                <th>ͼƬˮӡ�ļ���</th>
                <td><input name="watermarkpic" type="text" value="" maxlength="100" id="watermarkpic" class="txtInput normal required" /><label>*������վ��Ŀ¼�£���ͼƬ�����ڽ�ʹ������ˮӡ</label></td>
            </tr>
            <tr>
                <th>ˮӡ͸���ȣ�</th>
                <td><input name="watermarktransparency" type="text" value="" maxlength="2" id="watermarktransparency" class="txtInput small required digits" max="10" /><label>*ȡֵ��Χ1--10 (10Ϊ��͸��)</label></td>
            </tr>
            <tr>
                <th>ˮӡ���֣�</th>
                <td><input name="watermarktext" type="text" value="" maxlength="100" id="watermarktext" class="txtInput normal required" /><label>*����ˮӡ������</label></td>
            </tr>
            <tr>
                <th>�������壺</th>
                <td>
                    <select name="watermarkfont" id="watermarkfont" class="select2">
	<option value="Arial">Arial</option>
	<option value="Arial Black">Arial Black</option>
	<option value="Batang">Batang</option>
	<option value="BatangChe">BatangChe</option>
	<option value="Comic Sans MS">Comic Sans MS</option>
	<option value="Courier New">Courier New</option>
	<option value="Dotum">Dotum</option>
	<option value="DotumChe">DotumChe</option>
	<option value="Estrangelo Edessa">Estrangelo Edessa</option>
	<option value="Franklin Gothic Medium">Franklin Gothic Medium</option>
	<option value="Gautami">Gautami</option>
	<option value="Georgia">Georgia</option>
	<option value="Gulim">Gulim</option>
	<option value="GulimChe">GulimChe</option>
	<option value="Gungsuh">Gungsuh</option>
	<option value="GungsuhChe">GungsuhChe</option>
	<option value="Impact">Impact</option>
	<option value="Latha">Latha</option>
	<option value="Lucida Console">Lucida Console</option>
	<option value="Lucida Sans Unicode">Lucida Sans Unicode</option>
	<option value="Mangal">Mangal</option>
	<option value="Marlett">Marlett</option>
	<option value="Microsoft Sans Serif">Microsoft Sans Serif</option>
	<option value="MingLiU">MingLiU</option>
	<option value="MS Gothic">MS Gothic</option>
	<option value="MS Mincho">MS Mincho</option>
	<option value="MS PGothic">MS PGothic</option>
	<option value="MS PMincho">MS PMincho</option>
	<option value="MS UI Gothic">MS UI Gothic</option>
	<option value="MV Boli">MV Boli</option>
	<option value="Palatino Linotype">Palatino Linotype</option>
	<option value="PMingLiU">PMingLiU</option>
	<option value="Raavi">Raavi</option>
	<option value="Shruti">Shruti</option>
	<option value="Sylfaen">Sylfaen</option>
	<option value="Symbol">Symbol</option>
	<option selected="selected" value="Tahoma">Tahoma</option>
	<option value="Times New Roman">Times New Roman</option>
	<option value="Trebuchet MS">Trebuchet MS</option>
	<option value="Tunga">Tunga</option>
	<option value="Verdana">Verdana</option>
	<option value="Webdings">Webdings</option>
	<option value="Wingdings">Wingdings</option>
	<option value="����_GB2312">����_GB2312</option>
	<option value="����">����</option>
	<option value="������">������</option>
	<option value="����_GB2312">����_GB2312</option>
	<option value="����">����</option>

</select>
                    <input name="watermarkfontsize" type="text" value="" maxlength="10" id="watermarkfontsize" class="txtInput small2 required digits" />px
                    <label>*����ˮӡ������ʹ�С</label>
                </td>
            </tr>
            </tbody>
        </table>
    	</div>
		<div class="foot_btn_box">
		<input type="submit" name="btnSubmit" value="�ύ����" id="btnSubmit" class="btnSubmit" />
		&nbsp;<input name="����" type="reset" class="btnSubmit" value="�� ��" />
		</div>
		<div class="line10"></div>
	</div>
</form>
</body>
</html>
