package com.trunko.cms.dao.infoopen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.entity.WebInfoReg;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.Pager;
public class InfoRegDao {
	public boolean update(WebInfoReg webInfoReg){
		String sql="update web_inforeg set topic='"+webInfoReg.getTopic()+"',content='"+webInfoReg.getContent()
	     +"',time='"+webInfoReg.getTime()+"'"
	     +" where id="+webInfoReg.getId();
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}
	    return false;
	}

	public WebInfoReg getById(long id){
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
		WebInfoReg webInfoReg=new WebInfoReg();
		try {
			String countsql="select * from web_inforeg where id=? order by time desc";
			stat = conn.prepareStatement(countsql);
		    stat.setLong(1, id);
		    rs = stat.executeQuery();
			if(rs.next()){
				webInfoReg.setId(rs.getLong("id"));
				webInfoReg.setTopic(rs.getString("topic"));
				webInfoReg.setContent(rs.getString("content"));
				webInfoReg.setTime(rs.getDate("time"));
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webInfoReg;
	}

	public boolean add(WebInfoReg webInfoReg){
		
		String sql="insert into web_inforeg(topic,content,time) values('"+webInfoReg.getTopic()+"','"+webInfoReg.getContent()
		     +"','"+webInfoReg.getTime()+"')";
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}
		return false;
	}
	
	public boolean delItemList(String[] ItemList){
	   String sql="delete from web_inforeg where ";
	   for(int i=0;i<ItemList.length;i++){	   
		   sql+= " id="+ItemList[i]+"  or ";   
	   }
	   sql=sql.substring(0, sql.length()-4);
	   if(DBHelper.executeUpdateInject(sql)>0){
		   return true;
	   }
	   return false;
	}
	
	public Pager getItemForPage(int pageNo,int pageSize){
		
		List<WebInfoReg> itemlist=new ArrayList<WebInfoReg>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        int count=0;
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_inforeg ";
			
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}

			String sql = "select * from web_inforeg limit "+((pageNo-1)*pageSize)+" , "+pageSize;
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				WebInfoReg webInfoReg=new WebInfoReg();
				webInfoReg.setId(rs.getLong("id"));
				webInfoReg.setTopic(rs.getString("topic"));
				webInfoReg.setContent(rs.getString("content"));
				webInfoReg.setTime(rs.getDate("time"));
				itemlist.add(webInfoReg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return new Pager(pageSize, pageNo, count, itemlist);
	}
}
