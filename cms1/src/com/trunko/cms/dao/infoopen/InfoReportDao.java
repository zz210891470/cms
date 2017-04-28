package com.trunko.cms.dao.infoopen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.trunko.cms.entity.WebInfoReport;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.Pager;

public class InfoReportDao {
	public boolean update(WebInfoReport webInfoReport){
		String sql="update web_inforeport set topic='"+webInfoReport.getTopic()+"',content='"+webInfoReport.getContent()
	     +"',time='"+webInfoReport.getTime()+"'"
	     +" where id="+webInfoReport.getId();
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}
	    return false;
	}
	
	public WebInfoReport getById(long id){
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
		WebInfoReport webInfoReport=new WebInfoReport();
		try {
			String countsql="select * from web_inforeport where id=? order by time desc";
			stat = conn.prepareStatement(countsql);
		    stat.setLong(1,id);
		    rs = stat.executeQuery();
			if(rs.next()){
				webInfoReport.setId(rs.getLong("id"));
				webInfoReport.setTopic(rs.getString("topic"));
				webInfoReport.setContent(rs.getString("content"));
				webInfoReport.setTime(rs.getDate("time"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webInfoReport;
	}

	public boolean add(WebInfoReport webInfoReport){
		
		String sql="insert into web_inforeport(topic,content,time) values('"+webInfoReport.getTopic()+"','"+webInfoReport.getContent()
		     +"','"+webInfoReport.getTime()+"')";
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}
		return false;
	}
	
	public boolean delItemList(String[] ItemList){
		
	   String sql="delete from web_inforeport where ";
		
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
		
		List<WebInfoReport> itemlist=new ArrayList<WebInfoReport>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        int count=0;
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_inforeport ";
			
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}

			String sql = "select * from web_inforeport limit "+((pageNo-1)*pageSize)+" , "+pageSize;
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				WebInfoReport webInfoReport=new WebInfoReport();
				webInfoReport.setId(rs.getLong("id"));
				webInfoReport.setTopic(rs.getString("topic"));
				webInfoReport.setContent(rs.getString("content"));
				webInfoReport.setTime(rs.getDate("time"));
				itemlist.add(webInfoReport);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return new Pager(pageSize, pageNo, count, itemlist);
	}
}
