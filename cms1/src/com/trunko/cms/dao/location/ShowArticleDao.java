package com.trunko.cms.dao.location;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.trunko.cms.entity.WebConsult;
import com.trunko.cms.entity.WebInfomation;
import com.trunko.cms.entity.WebInfoOpen;
import com.trunko.cms.entity.WebInfoReg;
import com.trunko.cms.entity.WebInfoReport;
import com.trunko.cms.entity.WebLeaderMail;
import com.trunko.cms.entity.WebQuestion;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.FavoritesHelper;

/**
 * 前台信息显示页的数据操作类
 * @author jianhuang
 *
 */
public class ShowArticleDao {
	/**
	 * 得到内容数据
	 * @return
	 */
	public String getInfoData(String id){
		
		WebInfomation webInfomation=new WebInfomation();
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
		String data="";

		try {
			String lmmc="";
			int lmid=0;
			String sql = "select *,(select lmmc from web_column where id=web_infomation.lmid) as lmmc from web_infomation  where zt='已发布' and id=?";
            stat = conn.prepareStatement(sql);
			
			stat.setLong(1, Long.valueOf(id));
			rs=stat.executeQuery();
			
			
			if(rs.next()){
				lmmc=rs.getString("lmmc");
				lmid=rs.getInt("lmid");
				webInfomation.setId(rs.getLong("id"));
				webInfomation.setBt(rs.getString("bt"));
				webInfomation.setBtys(rs.getString("btys"));
				webInfomation.setZy(rs.getString("zy"));
				webInfomation.setFbt(rs.getString("fbt"));
				webInfomation.setIp(rs.getString("ip"));
				webInfomation.setLjwz(rs.getString("ljwz"));
				webInfomation.setLlcs(rs.getInt("llcs"));
				webInfomation.setLmid(rs.getLong("lmid"));
				webInfomation.setLy(rs.getString("ly"));
				webInfomation.setNr(rs.getString("nr"));
				webInfomation.setSx(rs.getString("sx"));
				webInfomation.setSj(rs.getTimestamp("sj"));
				webInfomation.setLstp(rs.getString("lstp"));
				webInfomation.setPlcs(rs.getInt("plcs"));
				webInfomation.setZt(rs.getString("zt"));
				webInfomation.setZz(rs.getString("zz"));
				webInfomation.setRq(rs.getDate("rq"));
				webInfomation.setFbr(rs.getString("fbr"));
			}
			rs.close();
			String tp="";
			if(webInfomation.getLstp()!=null && !webInfomation.getLstp().equals("")){
				tp="<br/><div style='text-align:center;'><img id='pic' style='height:200px;;width:250px' src="+webInfomation.getLstp()+"><br/><br/>";
			}
			data+="<div id='div_wz'>&nbsp;您当前的位置：首页&nbsp;>&nbsp;";
			if(lmmc.equals("")||lmmc.equals("新闻动态")||lmmc.equals("通知公告")||lmmc.equals("文件通知")||lmmc.equals("政策法规")||lmmc.equals("机关党建")||lmmc.equals("机效能建设党建")){
				data+="<a href='subcolumn.htm?loc=xxgk' target='_self'>信息公开</a>";
			}else if(lmmc.equals("")||lmmc.equals("在建重点项目")||lmmc.equals("预备重点项目")||lmmc.equals("开工项目")||lmmc.equals("竣工项目")||lmmc.equals("项目开工")||lmmc.equals("项目建设")){
				data+="<a href='subcolumn.htm?loc=xmzh' target='_self'>项目转化</a>";
			}else if(lmmc.equals("")||lmmc.equals("投资环境")||lmmc.equals("优惠政策")||lmmc.equals("招商项目")||lmmc.equals("前期项目")||lmmc.equals("滚动图片专用栏目")){
				data+="<a href='subcolumn.htm?loc=xmzs' target='_self'>项目推介</a>";
			}else if(lmmc.equals("")||lmmc.equals("项目策划指南")||lmmc.equals("储备项目")){
				data+="<a href='subcolumn.htm?loc=xmch' target='_self'>项目策划</a>";
			}else if(lmmc.equals("")||lmmc.equals("项目征集")||lmmc.equals("项目申报")||lmmc.equals("项目初审")||lmmc.equals("专家评审")){
				data+="<a href='subcolumn.htm?loc=xmps' target='_self'>项目评审</a>";
			}else if(lmmc.equals("")||lmmc.equals("项目审核")||lmmc.equals("项目储备")||lmmc.equals("储备项目")){
				data+="<a href='subcolumn.htm?loc=xmcb' target='_self'>项目储备</a>";
			}else if(lmmc.equals("")||lmmc.equals("办事指南")||lmmc.equals("文件下载")){
				data+="<a href='subcolumn.htm?loc=wsbs' target='_self'>网上办事</a>";
			}
			data+="&nbsp;>&nbsp;<a href='subcolumn.htm?loc=xxgk#"+lmid+"' target='_self'>"+lmmc+"</a></div>";
			data+="<div id='div_bt'>"+webInfomation.getBt()+"</div><div id='div_sx'>";
			if(webInfomation.getZz()!=null && !webInfomation.getZz().equals("")){
			
			    data+="作者："+webInfomation.getZz()+"&nbsp;&nbsp;";
			}
			if(webInfomation.getLy()!=null && !webInfomation.getLy().equals("")){
			    data+="来源："+webInfomation.getLy()+"&nbsp;&nbsp;";
			}
			data+="编辑："+webInfomation.getFbr()+"&nbsp;&nbsp;";
			data+="日期："+webInfomation.getRq();
			data+="&nbsp;&nbsp;【字号：<a href='javascript:fontZoomC();'><font color='#7e7e7e'>大</font></a> <a  href='javascript:fontZoomB();'><font color='#7e7e7e'>中</font></a> <a href='javascript:fontZoomA();'><font color='#7e7e7e'>小</font></a>】</div>";
			data+="<div id='div_nr'>"+tp+webInfomation.getNr()+"</div><br style='clear:both;'/>";
			System.out.println("内容:"+data);
			//更新文章点击率
			
			sql="update web_infomation set llcs=llcs+1 where id="+Long.valueOf(id);
			DBHelper.executeUpdateInject(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}

		return data;
		
	}
	
	//信息公开信息显示
	public String getInfoopenData(String id){
		
		WebInfoOpen webInfoOpen=new WebInfoOpen();
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String data="";

		try {
			stat = conn.createStatement();
			String sql = "select * from web_infoopen where id="+Long.valueOf(id);
			rs = stat.executeQuery(sql);
			
			if(rs.next()){
				webInfoOpen.setId(rs.getLong("id"));
				webInfoOpen.setBt(rs.getString("syh"));
				webInfoOpen.setFl(rs.getString("fl"));
				webInfoOpen.setFbjg(rs.getString("fbjg"));
				webInfoOpen.setFwrq(rs.getDate("fwrq"));
				webInfoOpen.setBt(rs.getString("bt"));
				webInfoOpen.setWh(rs.getString("wh"));
				webInfoOpen.setZtc(rs.getString("ztc"));
				webInfoOpen.setNr(rs.getString("nr"));
			}
			rs.close();
			data+="<div id='div_wz'>&nbsp;您当前的位置：首页&nbsp;>&nbsp;政府信息公开专栏&nbsp;>&nbsp;公开目录</div>";
			data+="<div id='div_bt'>"+webInfoOpen.getBt()+"</div>";
			data+="<div id='div_nr'>"+webInfoOpen.getNr()+"</div>";
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}

		return data;
		
	}
	/**
	 * 获取领导信箱信息
	 * @param id
	 * @return
	 */
	public String getConsultData(String id){
		WebConsult webConsult = new WebConsult();
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String data="";

		try {
			stat = conn.createStatement();
			String sql = "select * from web_consult where id="+Long.valueOf(id);
			rs = stat.executeQuery(sql);
			
			if(rs.next()){
				webConsult.setId(rs.getLong("id"));
				webConsult.setBt(rs.getString("bt"));
				webConsult.setXm(rs.getString("xm"));
				webConsult.setLxfs(rs.getString("lxfs"));
				webConsult.setNr(rs.getString("nr"));
				webConsult.setSj(rs.getDate("sj"));
				webConsult.setHfsj(rs.getDate("hfsj"));
				webConsult.setZt(rs.getString("zt"));
				webConsult.setHfnr(rs.getString("hfnr"));
			}
			rs.close();
			data+="<div id='div_bt'>"+webConsult.getBt()+"</div><div id='div_sx'>";
			if(webConsult.getXm()!=null && !webConsult.getXm().equals("")){
			
			    data+="咨询者："+webConsult.getXm()+"&nbsp;&nbsp;";
			}
			data+="日期："+webConsult.getSj();
			data+="&nbsp;&nbsp;【字号：<a href='javascript:fontZoomC();'><font color='#7e7e7e'>大</font></a> <a  href='javascript:fontZoomB();'><font color='#7e7e7e'>中</font></a> <a href='javascript:fontZoomA();'><font color='#7e7e7e'>小</font></a>】</div>";
			data+="<div id='div_nr'>"+webConsult.getNr()+"</div>";
			if(FavoritesHelper.isNotNull(webConsult.getZt()) && "已答复".equals(webConsult.getZt())){
				data+="<div id='div_nr'></div>";
				data+="<div id='div_nr'><font size='3' style='font: bold;'>回复：</font></div>";
				data+="<div id='div_nr'>"+ webConsult.getHfnr() +"</div>";
				data+="<div id='div_nr'>时间："+ webConsult.getHfsj() +"</div>";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}

		return data;
		
	}
	/**
	 * 获取领导信箱信息
	 * @param id
	 * @return
	 */
	public String getMailData(String id){
		WebLeaderMail leaderMail = new WebLeaderMail();
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String data="";
		
		try {
			stat = conn.createStatement();
			String sql = "select * from web_leadermail where id="+Long.valueOf(id);
			rs = stat.executeQuery(sql);
			
			if(rs.next()){
				leaderMail.setId(rs.getLong("id"));
				leaderMail.setBt(rs.getString("bt"));
				leaderMail.setXm(rs.getString("xm"));
				leaderMail.setLxfs(rs.getString("lxfs"));
				leaderMail.setNr(rs.getString("nr"));
				leaderMail.setSj(rs.getDate("sj"));
				leaderMail.setHfsj(rs.getDate("hfsj"));
				leaderMail.setZt(rs.getString("zt"));
				leaderMail.setHfnr(rs.getString("hfnr"));
				leaderMail.setLsh(rs.getString("lsh"));
				leaderMail.setCxmm(rs.getString("cxmm"));
			}
			rs.close();
			data+="<div id='div_bt'>"+leaderMail.getBt()+"</div><div id='div_sx'>";
			if(leaderMail.getXm()!=null && !leaderMail.getXm().equals("")){
				
				data+="投递者："+leaderMail.getXm()+"&nbsp;&nbsp;";
			}
			data+="日期："+leaderMail.getSj();
			data+="&nbsp;&nbsp;【字号：<a href='javascript:fontZoomC();'><font color='#7e7e7e'>大</font></a> <a  href='javascript:fontZoomB();'><font color='#7e7e7e'>中</font></a> <a href='javascript:fontZoomA();'><font color='#7e7e7e'>小</font></a>】</div>";
			data+="<div id='div_nr'>"+leaderMail.getNr()+"</div>";
			if(FavoritesHelper.isNotNull(leaderMail.getZt()) && "已答复".equals(leaderMail.getZt())){
				data+="<div id='div_nr'></div>";
				data+="<div id='div_nr'><font size='3' style='font: bold;'>回复：</font></div>";
				data+="<div id='div_nr'>"+ leaderMail.getHfnr() +"</div>";
				data+="<div id='div_nr'>时间："+ leaderMail.getHfsj() +"</div>";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		
		return data;
		
	}
	
	//公开规定信息显示
	public String getInforegData(String id){
		
		WebInfoReg webInfoReg=new WebInfoReg();
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String data="";

		try {
			stat = conn.createStatement();

			String sql = "select * from web_inforeg where  id="+Long.valueOf(id);
			rs = stat.executeQuery(sql);
			
			if(rs.next()){
				webInfoReg.setId(rs.getLong("id"));
				webInfoReg.setTopic(rs.getString("topic"));
				webInfoReg.setContent(rs.getString("content"));
				webInfoReg.setTime(rs.getDate("time"));
			}
			rs.close();
			data+="<div id='div_wz'>&nbsp;您当前的位置：首页&nbsp;>&nbsp;政府信息公开专栏&nbsp;>&nbsp;公开规定</div>";
			data+="<div id='div_bt'>"+webInfoReg.getTopic()+"</div>";
			data+="<div id='div_nr'>"+webInfoReg.getContent()+"</div>";

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}

		return data;
	}
		
	//公开年度报告信息显示
	public String getInforeportData(String id){
		
		WebInfoReport webInfoReport=new WebInfoReport();
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String data="";

		try {
			stat = conn.createStatement();

			String sql = "select * from web_inforeport where id="+Long.valueOf(id);
			rs = stat.executeQuery(sql);
			
			if(rs.next()){
				webInfoReport.setId(rs.getLong("id"));
				webInfoReport.setTopic(rs.getString("topic"));
				webInfoReport.setContent(rs.getString("content"));
				webInfoReport.setTime(rs.getDate("time"));
			}
			rs.close();
			data+="<div id='div_wz'>&nbsp;您当前的位置：首页&nbsp;>&nbsp;政府信息公开专栏&nbsp;>&nbsp;年度报告</div>";
			data+="<div id='div_bt'>"+webInfoReport.getTopic()+"</div>";
			data+="<div id='div_nr'>"+webInfoReport.getContent()+"</div>";

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}

		return data;
	}
	
	//常见问题信息显示
	public String getQuestionData(String id){
		
		WebQuestion webQuestion=new WebQuestion();
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String data="";

		try {
			stat = conn.createStatement();

			String sql = "select * from web_question where id="+Long.valueOf(id);
			rs = stat.executeQuery(sql);
			
			if(rs.next()){
				webQuestion.setId(rs.getLong("id"));
				webQuestion.setQuestion(rs.getString("question"));
				webQuestion.setAnswer(rs.getString("answer"));
				webQuestion.setTime(rs.getDate("time"));
			}
			rs.close();
			data+="<div id='div_wz'>&nbsp;您当前的位置：首页&nbsp;>&nbsp;公众参与&nbsp;>&nbsp;常见问题</div>";
			data+="<div id='div_bt'>"+webQuestion.getQuestion()+"</div>";
			data+="<div id='div_nr'>"+webQuestion.getAnswer()+"</div>";

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}

		return data;
	}
}
