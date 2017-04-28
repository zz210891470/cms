package com.trunko.cms.dao.people;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.entity.WebLeaderMail;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.Pager;

public class PeopleMailDao {

	public boolean reply(String hfnr,Long id){
		Timestamp timestamp=new Timestamp(System.currentTimeMillis());
		String sql="update  web_leadermail set hfnr='"+hfnr+"', zt='ÒÑ´ð¸´' , hfsj='"+timestamp
	     +"' where id="+id;
		
		System.out.println(sql);
		
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}

	    return false;
		
	}
	
	
	
	public boolean update(WebLeaderMail webConsult){
		String sql="update  web_leadermail set xm='"+webConsult.getXm()+"',lxfs='"+webConsult.getLxfs()
	     +"',nr='"+webConsult.getNr()+"',bt='"+webConsult.getBt()
	     +"' where id="+webConsult.getId();
		
		System.out.println(sql);
		
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}

	    return false;
		
	}
	
	
	public WebLeaderMail getById(long id){
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
        WebLeaderMail webLeaderMail=new WebLeaderMail();
		try {
			String countsql="select * from web_leadermail where id=?";
			stat = conn.prepareStatement(countsql);
		    stat.setLong(1, id);
		    rs = stat.executeQuery();
			if(rs.next()){
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
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webLeaderMail;
		
		
	}

	public boolean addReply(WebLeaderMail webConsult){
		
/*		String sql="insert into web_consult(,answer,author,url) values('"+webConsult.getQuestion()+"','"+webConsult.getAnswer()
		     +"','"+webConsult.getAuthor()+"','"+webConsult.getUrl()+"')";
		System.out.println(sql);
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}*/

		return false;
	}
	
	
	public boolean delItemList(String[] ItemList){
		
	   String sql="delete from web_leadermail where ";
		
	   for(int i=0;i<ItemList.length;i++){	   
		   sql+= " id="+ItemList[i]+"  or ";   
	   }
	   sql=sql.substring(0, sql.length()-4);
	   System.out.println(sql);
	   if(DBHelper.executeUpdateInject(sql)>0){
		   return true;
	   }
		
	   return false;
	}
	
	
	
	public Pager getItemForPage(int pageNo,int pageSize){
		
		List<WebLeaderMail> itemlist=new ArrayList<WebLeaderMail>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        int count=0;
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_leadermail";
			
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}

			String sql = "select * from web_leadermail order by id desc limit "+((pageNo-1)*pageSize)+" , "+pageSize;
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
				
				itemlist.add(webLeaderMail);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return new Pager(pageSize, pageNo, count, itemlist);
		

	}
	
}
