package com.trunko.cms.dao.content;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.entity.WebColumn;
import com.trunko.cms.entity.WebInfomation;
import com.trunko.cms.entity.WebModel;
import com.trunko.cms.entity.WebQuestion;
import com.trunko.cms.entity.WebSubColumn;
import com.trunko.cms.entity.WebSubInfo;
import com.trunko.cms.util.DBHelper;

public class ContentManageDao {
	
	public WebSubColumn getSubColumn(String type){
		
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
        WebSubColumn webSubColumn=new WebSubColumn();
		try {
			String countsql="select * from web_subcolumn where ljdz=?";
			stat = conn.prepareStatement(countsql);
		    stat.setString(1, type);
		    rs = stat.executeQuery();
			if(rs.next()){
				webSubColumn.setId(rs.getLong("id"));
				webSubColumn.setZtid(rs.getLong("ztid"));
				webSubColumn.setLmmc(rs.getString("lmmc"));
				webSubColumn.setLmlx(rs.getString("lmlx"));
				webSubColumn.setLmmx(rs.getString("lmmx"));
				webSubColumn.setLjdz(rs.getString("ljdz"));
				webSubColumn.setLmpx(rs.getInt("lmpx"));
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webSubColumn;
		
		
	}
	
	
	public WebQuestion getQuestion(String url){
		
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
		WebQuestion webQuestion=new WebQuestion();
		try {
			String countsql="select * from web_question where url=?";
			stat = conn.prepareStatement(countsql);
		    stat.setString(1, url);
		    rs = stat.executeQuery();
			if(rs.next()){
				webQuestion.setId(rs.getLong("id"));
				webQuestion.setQuestion(rs.getString("question"));
				webQuestion.setAnswer(rs.getString("answer"));
				webQuestion.setAuthor(rs.getString("author"));
				webQuestion.setUrl(rs.getString("url"));
				webQuestion.setTime(rs.getDate("time"));
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webQuestion;
		
		
	}
	
	
    
	
	public WebSubInfo getSubInfo(String url){
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
        WebSubInfo webInfomation=new WebSubInfo();
		try {
			String countsql="select * from web_SubInfo where ljwz=?";
			stat = conn.prepareStatement(countsql);
		    stat.setString(1, url);
		    rs = stat.executeQuery();
			if(rs.next()){
				webInfomation.setId(rs.getLong("id"));
				webInfomation.setBt(rs.getString("bt"));
				webInfomation.setBtys(rs.getString("btys"));
				webInfomation.setDd(rs.getString("dd"));
				webInfomation.setFbt(rs.getString("fbt"));
				webInfomation.setIp(rs.getString("ip"));
				webInfomation.setLjwz(rs.getString("ljwz"));
				webInfomation.setLlcs(rs.getInt("llcs"));
				webInfomation.setLmid(rs.getLong("lmid"));
				webInfomation.setLy(rs.getString("ly"));
				webInfomation.setNr(rs.getString("nr"));
				webInfomation.setSx(rs.getString("sx"));
				webInfomation.setSj(rs.getTimestamp("sj"));
				webInfomation.setPlcs(rs.getInt("plcs"));
				webInfomation.setZt(rs.getString("zt"));
				webInfomation.setZz(rs.getString("zz"));
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webInfomation;
		
		
	}
	
	public WebInfomation getInfomation(String url){
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
        WebInfomation webInfomation=new WebInfomation();
		try {
			String countsql="select * from web_Infomation where ljwz=?";
			stat = conn.prepareStatement(countsql);
		    stat.setString(1, url);
		    rs = stat.executeQuery();
			if(rs.next()){
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
				webInfomation.setPlcs(rs.getInt("plcs"));
				webInfomation.setZt(rs.getString("zt"));
				webInfomation.setZz(rs.getString("zz"));
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webInfomation;
		
		
	}
	
	public WebInfomation getInfomationBySjid(Long sjid){
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
        WebInfomation webInfomation=new WebInfomation();
		try {
			String countsql="select * from web_Infomation where lmid=?";
			stat = conn.prepareStatement(countsql);
		    stat.setLong(1, sjid);
		    rs = stat.executeQuery();
			if(rs.next()){
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
				webInfomation.setPlcs(rs.getInt("plcs"));
				webInfomation.setZt(rs.getString("zt"));
				webInfomation.setZz(rs.getString("zz"));
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webInfomation;
		
		
	}
	
	public List<WebInfomation> getInfomationList(long lmid){
		List<WebInfomation> itemlist=new ArrayList<WebInfomation>() ;
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
		try {

			String sql = "select * from web_infomation where lmid=?" ;
			stat = conn.prepareStatement(sql);
		    stat.setLong(1, lmid);
		    rs = stat.executeQuery();
			
			while(rs.next()){
				WebInfomation webInfomation=new WebInfomation();
				webInfomation.setId(rs.getLong("id"));
				webInfomation.setBt(rs.getString("bt"));
				webInfomation.setLjwz(rs.getString("ljwz"));
				webInfomation.setSj(rs.getTimestamp("sj"));
				
				itemlist.add(webInfomation);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		
		return itemlist;
	}
	
	public WebModel getModel(String name){
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
        WebModel webModel=new WebModel();
		try {
			String countsql="select * from web_model where mxbt=?";
			
			stat = conn.prepareStatement(countsql);
		    stat.setString(1, name);
		    rs = stat.executeQuery();
			if(rs.next()){
				webModel.setId(rs.getLong("id"));
				webModel.setMxbt(rs.getString("mxbt"));
				webModel.setMxpx(rs.getInt("mxpx"));
				webModel.setXtmr(rs.getString("xtmr"));
				webModel.setMxurl(rs.getString("mxurl"));
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webModel;
		
		
	}
	
	public WebColumn getColumn(String type){
		
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
        WebColumn webColumn=new WebColumn();
		try {
			String countsql="select * from web_column where ljdz=?";
			stat = conn.prepareStatement(countsql);
		    stat.setString(1, type);
		    rs = stat.executeQuery();
			if(rs.next()){
				webColumn.setId(rs.getLong("id"));
				webColumn.setSjid(rs.getLong("sjid"));
				webColumn.setLmjb(rs.getString("lmjb"));
				webColumn.setLmmc(rs.getString("lmmc"));
				webColumn.setLmlx(rs.getString("lmlx"));
				webColumn.setLmmx(rs.getString("lmmx"));
				webColumn.setLjdz(rs.getString("ljdz"));
				webColumn.setLmpx(rs.getInt("lmpx"));
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webColumn;
		
		
	}
}
