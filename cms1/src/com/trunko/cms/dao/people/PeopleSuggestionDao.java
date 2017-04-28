package com.trunko.cms.dao.people;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.entity.WebSuggestion;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.Pager;


/**
 * 民意征集数据处理类
 * @author gjz
 *
 */
public class PeopleSuggestionDao {


	public boolean update(WebSuggestion webSuggestion){
		String sql="update  web_suggestion set xm='"+webSuggestion.getXm()+"',lxfs='"+webSuggestion.getLxfs()
	     +"',bt='"+webSuggestion.getBt()+"',nr='"+webSuggestion.getNr()+"',sj='"+webSuggestion.getSj()
	     +"' where id="+webSuggestion.getId();
		
		System.out.println(sql);
		
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}

	    return false;
		
	}
	
	
	public WebSuggestion getById(long id){
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
        WebSuggestion webSuggestion=new WebSuggestion();
		try {
			String countsql="select * from web_suggestion where id=?";
			stat = conn.prepareStatement(countsql);
		    stat.setLong(1, id);
		    rs = stat.executeQuery();
			if(rs.next()){
				webSuggestion.setId(rs.getLong("id"));
				webSuggestion.setXm(rs.getString("xm"));
				webSuggestion.setLxfs(rs.getString("lxfs"));
				webSuggestion.setBt(rs.getString("Bt"));
				webSuggestion.setNr(rs.getString("nr"));
				webSuggestion.setSj(rs.getDate("sj"));
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webSuggestion;
		
		
	}

	public boolean add(WebSuggestion webSuggestion){
		
		String sql="insert into web_suggestion(xm,lxfs,bt,nr,sj) values('"+webSuggestion.getXm()+"','"+webSuggestion.getLxfs()
		     +"','"+webSuggestion.getBt()+"','"+webSuggestion.getNr()+"','"+webSuggestion.getSj()+"')";
		System.out.println(sql);
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}

		return false;
	}
	
	
	public boolean delItemList(String[] ItemList){
		
	   String sql="delete from web_suggestion where ";
		
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
		
		List<WebSuggestion> itemlist=new ArrayList<WebSuggestion>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        int count=0;
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_suggestion ";
			
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}

			String sql = "select * from web_suggestion order by id desc limit "+((pageNo-1)*pageSize)+" , "+pageSize;
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				WebSuggestion webSuggestion=new WebSuggestion();
				webSuggestion.setId(rs.getLong("id"));
				webSuggestion.setXm(rs.getString("xm"));
				webSuggestion.setLxfs(rs.getString("lxfs"));
				webSuggestion.setBt(rs.getString("Bt"));
				webSuggestion.setNr(rs.getString("nr"));
				webSuggestion.setSj(rs.getDate("sj"));
				
				itemlist.add(webSuggestion);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return new Pager(pageSize, pageNo, count, itemlist);
		

	}
	
	
}
