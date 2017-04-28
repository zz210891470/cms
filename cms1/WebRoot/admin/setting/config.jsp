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
	<title>系统基本信息配置</title>
</head>

<body class="mainbody">
<form name="form1" method="post" action="SysConfigServlet?act=save" id="form1">
	<div class="navigation">首页 &gt; 系统设置管理 &gt; 系统参数设置</div>
	<div id="contentTab">
		<ul class="tab_nav">
			<li class="selected"><a onclick="tabs('#contentTab',0);" href="javascript:;">网站基本信息</a></li>
			<li style="display:none;"><a onclick="tabs('#contentTab',1);" href="javascript:void(0);">功能权限配置</a></li>
			<li style="display:none;"><a onclick="tabs('#contentTab',2);" href="javascript:void(0);">邮件发送配置</a></li>
			<li style="display:none;"><a onclick="tabs('#contentTab',3);" href="javascript:void(0);">附件配置</a></li>
		</ul>
		<div class="tab_con" style="display:block;">
		<table class="form_table">
				<col width="180px"><col>
				<tbody>
				<tr>
					<th>站点名称：</th>
					<input name="id" type="hidden" value="${webconfig.id }" />
					<td><input name="webname" value="${webconfig.zdmc }" type="text" value="" maxlength="100" id="webname" class="txtInput normal required" /><label>*</label></td>
				</tr>
				<tr>
					<th>单位名称：</th>
					<td><input name="webcompany" value="${webconfig.dwmc }" type="text" value="" maxlength="100" id="webcompany" class="txtInput normal required" /><label>*</label></td>
				</tr>
				<tr>
					<th>网站域名：</th>
					<td><input name="weburl" value="${webconfig.wzym }" type="text" value="" maxlength="250" id="weburl" class="txtInput normal required url" /><label>*以“http://”开头</label></td>
				</tr>
				<tr>
					<th>联系电话：</th>
					<td><input name="webtel" value="${webconfig.lxdh }" type="text" value="" maxlength="50" id="webtel" class="txtInput normal" /></td>
				</tr>
				<tr>
					<th>传真号码：</th>
					<td><input name="webfax" value="${webconfig.czhm }"  type="text" value="" maxlength="50" id="webfax" class="txtInput normal" /></td>
				</tr>
				<tr>
					<th>管理员邮箱：</th>
					<td><input name="webmail" value="${webconfig.glyyx }"  type="text" value="" maxlength="100" id="webmail" class="txtInput normal email" /></td>
				</tr>
				<tr>
					<th>网站备案号：</th>
					<td><input name="webcrod" value="${webconfig.icp }"  type="text" value="" maxlength="50" id="webcrod" class="txtInput normal" /></td>
				</tr>
				<tr>
					<th>首页标题(SEO)：</th>
					<td><input name="webtitle" value="${webconfig.sybt }" type="text" value="" maxlength="250" id="webtitle" class="txtInput normal required" style="width:350px;" /><label>*自定义的首页标题</label></td>
				</tr>
				<tr>
					<th>页面关健词(SEO)：</th>
					<td><input name="webkeyword" value="${webconfig.ymgjc }" type="text" value="" maxlength="250" id="webkeyword" class="txtInput" style="width:350px;" />
						<label>页面关键词(keyword)</label></td>
				</tr>
				<tr>
					<th>页面描述(SEO)：</th>
					<td><textarea name="webdescription"  rows="2" cols="20" id="webdescription" class="small"> ${webconfig.ymms} </textarea>
						<label>页面描述(description)</label></td>
				</tr>
				<tr>
					<th>网站版权信息：</th>
					<td><textarea name="webcopyright" rows="2" cols="20" id="webcopyright" class="small">${webconfig.bqxx } </textarea><label>支持HTML格式</label></td>
				</tr>
				</tbody>
			</table>
		</div>
		<div class="tab_con">
        <table class="form_table">
            <col width="180px"><col>
            <tbody>
            <tr>
                <th>网站安装目录：</th>
                <td><input name="webpath" type="text" value="" maxlength="100" id="webpath" class="txtInput normal required" /><label>*根目录下，输入“/”；如：http://abc.com/web，输入“web/”</label></td>
            </tr>
            <tr>
                <th>网站管理目录：</th>
                <td><input name="webmanagepath"  type="text" value="" maxlength="100" id="webmanagepath" class="txtInput normal required" minlength="2" /><label>*默认是admin，如已经更改，请输入目录名</label></td>
            </tr>
            <tr>
                <th>URL重写开关：</th>
                <td>
                    <span id="staticstatus"><input id="staticstatus_0" type="radio" name="staticstatus" value="0" /><label for="staticstatus_0">关闭</label><input id="staticstatus_1" type="radio" name="staticstatus" value="1" /><label for="staticstatus_1">伪URL重写</label></span>
                    <label>(<a href="url_rewrite_list.aspx">编辑伪静态url替换规则</a>)</label>
                </td>
            </tr>
            <tr>
                <th>静态URL后缀：</th>
                <td><input name="staticextension"  type="text" value="" maxlength="100" id="staticextension" class="txtInput small required" minlength="2" /><label>*扩展名，不包括“.”，如：aspx、html</label></td>
            </tr>
            <tr>
                <th>开启会员功能：</th>
                <td>
                    <span id="memberstatus"><input id="memberstatus_0"  type="radio" name="memberstatus" value="0" /><label for="memberstatus_0">关闭</label><input id="memberstatus_1" type="radio" name="memberstatus" value="1" /><label for="memberstatus_1">开启</label></span>
                    <label></label>
                </td>
            </tr>
            <tr>
                <th>开启评论审核：</th>
                <td>
                    <span id="commentstatus"><input id="commentstatus_0" type="radio" name="commentstatus" value="0" /><label for="commentstatus_0">关闭</label><input id="commentstatus_1" type="radio" name="commentstatus" value="1" /><label for="commentstatus_1">开启</label></span>
                    <label></label>
                </td>
            </tr>
            <tr>
                <th>后台管理日志：</th>
                <td>
                    <span id="logstatus"><input id="logstatus_0" type="radio" name="logstatus" value="0" /><label for="logstatus_0">关闭</label><input id="logstatus_1" type="radio" name="logstatus" value="1" /><label for="logstatus_1">开启</label></span>
                    <label></label>
                </td>
            </tr>
            <tr>
                <th>是否关闭网站：</th>
                <td>
                    <span id="webstatus"><input id="webstatus_0" type="radio" name="webstatus" value="0" /><label for="webstatus_0">关闭</label><input id="webstatus_1" type="radio" name="webstatus" value="1"/><label for="webstatus_1">开启</label></span>
                    <label></label>
                </td>
            </tr>
            <tr>
                <th>关闭原因描述：</th>
                <td><textarea name="webclosereason"    rows="2" cols="20" id="webclosereason" class="small"></textarea><label>支持HTML格式</label></td>
            </tr>
            <tr>
                <th>网站统计代码：</th>
                <td><textarea name="webcountcode" rows="2" cols="20" id="webcountcode" class="small"></textarea><label>支持HTML格式</label></td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="tab_con">
        <table class="form_table">
            <col width="180px"><col>
            <tbody>
            <tr>
                <th>STMP服务器：</th>
                <td><input name="emailstmp" type="text" value="" maxlength="100" id="emailstmp" class="txtInput normal required" /><label>*发送邮件的SMTP服务器地址</label></td>
            </tr>
            <tr>
                <th>SMTP端口：</th>
                <td><input name="emailport" type="text" value="" maxlength="10" id="emailport" class="txtInput small required digits" /><label>*SMTP服务器的端口</label></td>
            </tr>
            <tr>
                <th>发件人地址：</th>
                <td><input name="emailfrom" type="text" value="" maxlength="100" id="emailfrom" class="txtInput normal required" /><label>*</label></td>
            </tr>
            <tr>
                <th>邮箱账号：</th>
                <td><input name="emailusername" type="text" value="" maxlength="100" id="emailusername" class="txtInput normal required" /><label>*</label></td>
            </tr>
            <tr>
                <th>邮箱密码：</th>
                <td><input name="emailpassword" type="password" maxlength="100" id="emailpassword" class="txtInput normal required" value="" /><label>*</label></td>
            </tr>
            <tr>
                <th>发件人昵称：</th>
                <td><input name="emailnickname" type="text" value="" maxlength="100" id="emailnickname" class="txtInput normal required" /><label>*显示发件人的昵称</label></td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="tab_con">
        <table class="form_table">
            <col width="180px"><col>
            <tbody>
            <tr>
                <th>附件上传目录：</th>
                <td><input name="attachpath" type="text" value="" maxlength="100" id="attachpath" class="txtInput normal required" minlength="2" /><label>*上传图片或附件的目录，自动创建在网站根目录下</label></td>
            </tr>
            <tr>
                <th>附件上传类型：</th>
                <td><input name="attachextension" type="text" value="" maxlength="250" id="attachextension" class="txtInput normal required" /><label>*以英文的逗号分隔开，如：“jpg,gif,rar”</label></td>
            </tr>
            <tr>
                <th>附件保存方式：</th>
                <td>
                    <select name="attachsave" id="attachsave" class="select2">
	<option value="1">按年月日每天一个目录</option>
	<option selected="selected" value="2">按年月/日/存入不同目录</option>

</select>
                </td>
            </tr>
            <tr>
                <th>文件上传大小：</th>
                <td><input name="attachfilesize" type="text" value="" maxlength="10" id="attachfilesize" class="txtInput small required number" />KB<label>*超过设置的文件大小不予上传，0不限制</label></td>
            </tr>
            <tr>
                <th>图片上传大小：</th>
                <td><input name="attachimgsize" type="text" value="" maxlength="10" id="attachimgsize" class="txtInput small required number" />KB<label>*超过设置的图片大小不予上传，0不限制</label></td>
            </tr>
            <tr>
                <th>图片最大尺寸：</th>
                <td>
                    <input name="attachimgmaxheight" type="text" value="" maxlength="10" id="attachimgmaxheight" class="txtInput small2 required digits" />×
                    <input name="attachimgmaxwidth" type="text" value="" maxlength="10" id="attachimgmaxwidth" class="txtInput small2 required digits" />px
                    <label>*设置图片高和宽，超出自动裁剪，0为不受限制</label>
                </td>
            </tr>
            <tr>
                <th>生成缩略图大小：</th>
                <td>
                    <input name="thumbnailheight" type="text" value="" maxlength="10" id="thumbnailheight" class="txtInput small2 required digits" />×
                    <input name="thumbnailwidth" type="text" value="" maxlength="10" id="thumbnailwidth" class="txtInput small2 required digits" />px
                    <label>*图片生成缩略图高和宽，0为不生成</label>
                </td>
            </tr>
            <tr>
                <th>图片水印类型：</th>
                <td>
                    <span id="watermarktype"><input id="watermarktype_0" type="radio" name="watermarktype" value="0" /><label for="watermarktype_0">关闭水印 </label><input id="watermarktype_1" type="radio" name="watermarktype" value="1" /><label for="watermarktype_1">文字水印 </label><input id="watermarktype_2" type="radio" name="watermarktype" value="" /><label for="watermarktype_2">图片水印 </label></span>
                </td>
            </tr>
            <tr>
                <th>图片水印位置：</th>
                <td>
                    <span id="watermarkposition"><input id="watermarkposition_0" type="radio" name="watermarkposition" value="1" /><label for="watermarkposition_0">左上 </label><input id="watermarkposition_1" type="radio" name="watermarkposition" value="2" /><label for="watermarkposition_1">中上 </label><input id="watermarkposition_2" type="radio" name="watermarkposition" value="3" /><label for="watermarkposition_2">右上 </label><input id="watermarkposition_3" type="radio" name="watermarkposition" value="4" /><label for="watermarkposition_3">左中 </label><input id="watermarkposition_4" type="radio" name="watermarkposition" value="5" /><label for="watermarkposition_4">居中 </label><input id="watermarkposition_5" type="radio" name="watermarkposition" value="6" /><label for="watermarkposition_5">右中 </label><input id="watermarkposition_6" type="radio" name="watermarkposition" value="7" /><label for="watermarkposition_6">左下 </label><input id="watermarkposition_7" type="radio" name="watermarkposition" value="8" /><label for="watermarkposition_7">中下 </label><input id="watermarkposition_8" type="radio" name="watermarkposition" value="9" /><label for="watermarkposition_8">右下 </label></span>
                </td>
            </tr>
            <tr>
                <th>图片生成质量：</th>
                <td><input name="watermarkimgquality" type="text" value="" maxlength="3" id="watermarkimgquality" class="txtInput small required digits" /><label>*只适用于加水印的jpeg格式图片.取值范围 0-100, 0质量最低, 100质量最高, 默认80</label></td>
            </tr>
            <tr>
                <th>图片水印文件：</th>
                <td><input name="watermarkpic" type="text" value="" maxlength="100" id="watermarkpic" class="txtInput normal required" /><label>*需存放在站点目录下，如图片不存在将使用文字水印</label></td>
            </tr>
            <tr>
                <th>水印透明度：</th>
                <td><input name="watermarktransparency" type="text" value="" maxlength="2" id="watermarktransparency" class="txtInput small required digits" max="10" /><label>*取值范围1--10 (10为不透明)</label></td>
            </tr>
            <tr>
                <th>水印文字：</th>
                <td><input name="watermarktext" type="text" value="" maxlength="100" id="watermarktext" class="txtInput normal required" /><label>*文字水印的内容</label></td>
            </tr>
            <tr>
                <th>文字字体：</th>
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
	<option value="仿宋_GB2312">仿宋_GB2312</option>
	<option value="宋体">宋体</option>
	<option value="新宋体">新宋体</option>
	<option value="楷体_GB2312">楷体_GB2312</option>
	<option value="黑体">黑体</option>

</select>
                    <input name="watermarkfontsize" type="text" value="" maxlength="10" id="watermarkfontsize" class="txtInput small2 required digits" />px
                    <label>*文字水印的字体和大小</label>
                </td>
            </tr>
            </tbody>
        </table>
    	</div>
		<div class="foot_btn_box">
		<input type="submit" name="btnSubmit" value="提交保存" id="btnSubmit" class="btnSubmit" />
		&nbsp;<input name="重置" type="reset" class="btnSubmit" value="重 置" />
		</div>
		<div class="line10"></div>
	</div>
</form>
</body>
</html>
