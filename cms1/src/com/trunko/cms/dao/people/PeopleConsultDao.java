package com.trunko.cms.dao.people;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.entity.WebConsult;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.Pager;

public class PeopleConsultDao {


	public boolean reply(String hfnr,Long id){
		Timestamp timestamp=new Timestamp(System.currentTimeMillis());
		String sql="update  web_consult set hfnr='"+hfnr+"', zt='�Ѵ�' , hfsj='"+timestamp
	     +"' where id="+id;
		
		System.out.println(sql);
		
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}

	    return false;
		
	}
	
	
	
	public boolean update(WebConsult webConsult){
		String sql="update  web_consult set xm='"+webConsult.getXm()+"',lxfs='"+webConsult.getLxfs()
	     +"',nr='"+webConsult.getNr()+"',bt='"+webConsult.getBt()
	     +"' where id="+webConsult.getId();
		
		System.out.println(sql);
		
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}

	    return false;
		
	}
	
	
	public WebConsult getById(long id){
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
        WebConsult webConsult=new WebConsult();
		try {
			String countsql="select * from web_consult where id=?";
			stat = conn.prepareStatement(countsql);
		    stat.setLong(1, id);
		    rs = stat.executeQuery();
			if(rs.next()){
				webConsult.setId(rs.getLong("id"));
				webConsult.setXm(rs.getString("xm"));
				webConsult.setLxfs(rs.getString("lxfs"));
				webConsult.setBt(rs.getString("bt"));
				webConsult.setSj(rs.getDate("sj"));
				webConsult.setHfsj(rs.getDate("hfsj"));
				webConsult.setZt(rs.getString("zt"));
				webConsult.setHfnr(rs.getString("hfnr"));
				webConsult.setNr(rs.getString("nr"));
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webConsult;
		
		
	}

	public boolean addReply(WebConsult webConsult){
		
/*		String sql="insert into web_consult(,answer,author,url) values('"+webConsult.getQuestion()+"','"+webConsult.getAnswer()
		     +"','"+webConsult.getAuthor()+"','"+webConsult.getUrl()+"')";
		System.out.println(sql);
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}*/

		return false;
	}
	
	
	public boolean delItemList(String[] ItemList){
		
	   String sql="delete from web_consult where ";
		
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
		
		List<WebConsult> itemlist=new ArrayList<WebConsult>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        int count=0;
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_Consult";
			
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}

			String sql = "select * from web_consult  order by id desc limit "+((pageNo-1)*pageSize)+" , "+pageSize;
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
				
				itemlist.add(webConsult);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return new Pager(pageSize, pageNo, count, itemlist);
		

	}
	
	
}
