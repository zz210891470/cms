package com.trunko.cms.dao.people;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.entity.WebConsult;
import com.trunko.cms.entity.WebLeaderMail;
import com.trunko.cms.entity.WebQuestion;
import com.trunko.cms.entity.WebSuggestion;


import com.trunko.cms.util.DBHelper;

public class PeopleAttendDao {

	public boolean addMail(WebLeaderMail webLeaderMail){
		
		String sql="insert into web_leadermail(xm,lxfs,bt,nr,sj) values(?,?,?,?,?)";
		System.out.println(sql);
		if(DBHelper.executeUpdate(sql,new int[]{3,3,3,3,4},webLeaderMail.getXm(),webLeaderMail.getLxfs(),webLeaderMail.getBt(),webLeaderMail.getNr(),"now")>0){
			   return true;
		}

		return false;
	}
	
	
    public boolean addSuggestion(WebSuggestion webSuggestion){
		
		String sql="insert into web_suggestion(xm,lxfs,bt,nr,sj) values(?,?,?,?,?)";
		System.out.println(sql);
		if(DBHelper.executeUpdate(sql,new int[]{3,3,3,3,4},webSuggestion.getXm(),webSuggestion.getLxfs(),webSuggestion.getBt(),webSuggestion.getNr(),"now")>0){
			   return true;
		}

		return false;
	}
	
	  /**
     * 得到分页的数据信息
     * @param pageNo
     * @param pageSize
     * @param searchStr
     * @param pid
     * @return
     */
	public String getQuestionForPage(int pageNo,int pageSize){
		
		List<WebQuestion> questionlist=new ArrayList<WebQuestion>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String data="<ul>";
        int count=0;
  
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_question";		
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}

			String sql = "select * from web_question  limit "+((pageNo-1)*pageSize)+" , "+pageSize;
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				WebQuestion webQuestion=new WebQuestion();
				webQuestion.setId(rs.getLong("id"));
				webQuestion.setQuestion(rs.getString("question"));
				webQuestion.setAnswer(rs.getString("answer"));
				webQuestion.setAuthor(rs.getString("author"));
				webQuestion.setUrl(rs.getString("url"));
				webQuestion.setTime(rs.getDate("time"));

				questionlist.add(webQuestion);
			}
			
			for(WebQuestion w:questionlist){
				data+="<div class='div_lb'><a href='ShowArticle.htm?lb=question&id="+w.getId()+"' target='_blank' title=\""+w.getQuestion()+"\">"+w.getQuestion()+"</a><span>"+w.getTime().toString()+"</span></div>";
			}
			if(data==""){
				data+="<div style='padding:30px;'>栏目暂无信息！</div>";
			}else{
				if((count/10)>=1){
					data+="<div id='bottom'><span id='pagecount' data-num='"+(count/10+2)+"'><a href='javascript:gopage("+(pageNo-1)+")' >上一页</a>第"+pageNo+"页/共"+((count/10)+1)+"页<a href='javascript:gopage("+(pageNo+1)+")'>下一页</a></span></div>";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return data;
	}
	
	
	
	public boolean add(WebConsult webConsult){
		
		String sql="insert into web_consult(xm,lxfs,bt,nr,sj) values(?,?,?,?,?)";
		System.out.println(sql);
		if(DBHelper.executeUpdate(sql,new int[]{3,3,3,3,4},webConsult.getXm(),webConsult.getLxfs(),webConsult.getBt(),webConsult.getNr(),"now")>0){
			   return true;
		}

		return false;
	}
	
	  /**
     * 得到分页的数据信息
     * @param pageNo
     * @param pageSize
     * @param searchStr
     * @param pid
     * @return
     */
	public String getArticleForPage(int pageNo,int pageSize){
		
		List<WebConsult> consultlist=new ArrayList<WebConsult>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String data="";
        int count=0;
  
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_consult";		
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}

			String sql = "select * from web_consult  limit "+((pageNo-1)*pageSize)+" , "+pageSize;
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				WebConsult webConsult=new WebConsult();
				
				
				webConsult.setId(rs.getLong("id"));
				webConsult.setXm(rs.getString("xm"));
				webConsult.setLxfs(rs.getString("lxfs"));
				webConsult.setBt(rs.getString("bt"));
				webConsult.setSj(rs.getDate("sj"));
				webConsult.setHfsj(rs.getDate("hfsj"));
				webConsult.setZt(rs.getString("zt"));
				webConsult.setHfnr(rs.getString("hfnr"));
				webConsult.setNr(rs.getString("nr"));

				consultlist.add(webConsult);
			}
			for(WebConsult w:consultlist){
				data+="<div class='div_lb'><a href='ShowArticle.htm?lb=zxzx&id="+w.getId()+"' target='_blank' title=\""+w.getBt()+"\">"+w.getBt()+"</a><span>"+w.getSj().toString()+"</span></div>";
			}
			if(data==""){
				data+="<div style='padding:30px;'>栏目暂无信息！</div>";
			}else{
				if((count/10)>=1){
					data+="<div id='bottom'><span id='pagecount' data-num='"+(count/10+2)+"'><a href='javascript:gopage("+(pageNo-1)+")' >上一页</a>第"+pageNo+"页/共"+((count/10)+1)+"页<a href='javascript:gopage("+(pageNo+1)+")'>下一页</a></span></div>";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return data;
	}
	
	
	  /**
     * 得到分页的数据信息
     * @param pageNo
     * @param pageSize
     * @param searchStr
     * @param pid
     * @return
     */
	public String getMailForPage(int pageNo,int pageSize){
		
		List<WebLeaderMail> maillist=new ArrayList<WebLeaderMail>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String data="";
        int count=0;
  
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_leadermail";		
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}

			String sql = "select * from web_leadermail order by id desc  limit "+((pageNo-1)*pageSize)+" , "+pageSize;
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				WebLeaderMail webLeaderMail=new WebLeaderMail();
				webLeaderMail.setId(rs.getLong("id"));
				webLeaderMail.setXm(rs.getString("xm"));
				webLeaderMail.setLxfs(rs.getString("lxfs"));
				webLeaderMail.setBt(rs.getString("bt"));
				
				
				webLeaderMail.setSj(rs.getDate("sj"));
				webLeaderMail.setHfsj(rs.getDate("hfsj"));
				webLeaderMail.setZt(rs.getString("zt"));
				webLeaderMail.setHfnr(rs.getString("hfnr"));
				webLeaderMail.setNr(rs.getString("nr"));
				webLeaderMail.setLsh(rs.getString("lsh"));
				webLeaderMail.setCxmm(rs.getString("cxmm"));

				maillist.add(webLeaderMail);
			}
			
			for(WebLeaderMail w:maillist){
				data+="<div class='div_lb'><a href='ShowArticle.htm?lb=ldxx&id="+w.getId()+"' target='_blank' title=\""+w.getBt()+"\">"+w.getBt()+"</a><span>"+w.getSj().toString()+"</span></div>";
			}
			if(data==""){
				data+="<div style='padding:30px;'>栏目暂无信息！</div>";
			}else{
				if((count/10)>=1){
					data+="<div id='bottom'><span id='pagecount' data-num='"+(count/10+2)+"'><a href='javascript:gopage("+(pageNo-1)+")' >上一页</a>第"+pageNo+"页/共"+((count/10)+1)+"页<a href='javascript:gopage("+(pageNo+1)+")'>下一页</a></span></div>";
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return data;
	}
	
}
