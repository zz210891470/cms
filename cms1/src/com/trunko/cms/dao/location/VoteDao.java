package com.trunko.cms.dao.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.entity.WebVote;
import com.trunko.cms.entity.WebVoteAnswer;
import com.trunko.cms.entity.WebVoteItem;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.DateHelper;

public class VoteDao {
	
	
	public boolean saveVote(String idstr){
		String sql="update web_voteanswer set ps=ps+1 where ";
		String[] idlist= idstr.split("-");
		for(String s:idlist){
			sql+=" id="+s+" or";
		}
		sql=sql.substring(0,sql.length()-2);
		
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}

	    return false;
	}
	
	public List<WebVoteAnswer> getVoteAnswers(List<Long> idList){
	
		List<WebVoteAnswer> answerlist=new ArrayList<WebVoteAnswer>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;

  
		try {
			if(idList.size()>0){
			stat = conn.createStatement();
			String temp="";
			for(Long id:idList){
				temp+=" wtid="+id+" or";
			}
			
			temp=temp.substring(0,temp.length()-2);
			
			String countsql="select * from web_voteanswer where "+temp+" order by id asc";		
			System.out.println(countsql);
			rs=stat.executeQuery(countsql);
		
			while(rs.next()){
				WebVoteAnswer webVoteAnswer=new WebVoteAnswer();

				webVoteAnswer.setId(rs.getLong("id"));
				webVoteAnswer.setWtid(rs.getLong("wtid"));
				webVoteAnswer.setDa(rs.getString("da"));
				webVoteAnswer.setPs(rs.getLong("ps"));

				answerlist.add(webVoteAnswer);
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return answerlist;
		
	}
	
	public List<WebVoteItem> getVoteItems(String id){
		
		List<WebVoteItem> votelist=new ArrayList<WebVoteItem>() ;
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;

  
		try {
			String countsql="select * from web_voteitem where dcid=? order by sort asc";		
			
			stat = conn.prepareStatement(countsql);
			stat.setLong(1, Long.valueOf(id));
			rs = stat.executeQuery();

			
			while(rs.next()){
				WebVoteItem webVoteItem=new WebVoteItem();

				webVoteItem.setId(rs.getLong("id"));
				webVoteItem.setDcid(rs.getLong("dcid"));
				webVoteItem.setWt(rs.getString("wt"));
				webVoteItem.setType(rs.getInt("type"));
				webVoteItem.setSort(rs.getInt("sort"));
				votelist.add(webVoteItem);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return votelist;
	}

	
	
	public WebVote getVote(String id){
		WebVote webVote=new WebVote();
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
  
		try {
			String countsql="select * from web_vote where id=? order by kssj desc";		
			stat = conn.prepareStatement(countsql);
			stat.setLong(1, Long.valueOf(id));
			rs = stat.executeQuery();
			
			while(rs.next()){
				
				webVote.setId(rs.getLong("id"));
				webVote.setKssj(rs.getDate("kssj"));
				webVote.setJssj(rs.getDate("jssj"));
				webVote.setZt(rs.getString("zt"));
				webVote.setNr(rs.getString("nr"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webVote;
		
		
	}
	
	  /**
     * 得到分页的数据信息
     * @param pageNo
     * @param pageSize
     * @param searchStr
     * @param pid
     * @return
     */
	public String getVoteForPage(int pageNo,int pageSize){
		
		List<WebVote> votelist=new ArrayList<WebVote>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String data="";
        int count=0;
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_vote where kssj<='"+ DateHelper.getNowDate() +"'";		
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}
			String sql = "select * from web_vote where kssj<='"+ DateHelper.getNowDate() +"' limit "+((pageNo-1)*pageSize)+" , "+pageSize;
			rs = stat.executeQuery(sql);
			while(rs.next()){
				WebVote webVote=new WebVote();
				webVote.setId(rs.getLong("id"));
				webVote.setKssj(rs.getDate("kssj"));
				webVote.setJssj(rs.getDate("jssj"));
				webVote.setZt(rs.getString("zt"));
				webVote.setNr(rs.getString("nr"));
				votelist.add(webVote);
			}
			
			for(WebVote w:votelist){
				data+="<div class='div_lb'><a href='Vote?act=vote&id="+w.getId()+"' target='_blank'>"+w.getZt()+"</a><span>"+w.getKssj().toString().split(" ")[0]+" 至 "+w.getJssj().toString().split(" ")[0]+"</span></div>";
			
			}
			if(data==""){
				data+="<div style='padding:30px;'>栏目暂无信息！</div>";
			}else{
				if((count%10)>=1){
					data+="<div id='bottom'><span id='pagecount' data-num='"+(count/10+2)+"'>共有"+count+"条记录&nbsp;&nbsp;第"+pageNo+"页/共"+((count/10)+1)+"页&nbsp;&nbsp;<a href='javascript:gopage(1,)' >首页</a>&nbsp;&nbsp;<a href='javascript:gopage("+(pageNo-1)+")' >上一页</a>&nbsp;&nbsp;<a href='javascript:gopage("+(pageNo+1)+")'>下一页</a>&nbsp;&nbsp;<a href='javascript:gopage("+((count/10)+1)+")' >末页</a></span></div>";
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
	 * 保存投票者信息
	 * @param dcid 调查问卷主键
	 * @param name 投票者姓名
	 * @param lxfs 联系方式
	 */
	public void saveVoteUser(String dcid, String name, String lxfs) {
		String sql="insert into web_voteuser(dcid,xm,lxfs) values("+ dcid +",'"+ name +"','"+ lxfs +"')";
		DBHelper.executeUpdateInject(sql);
	}
	
}
