package com.trunko.cms.dao.sysconfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.trunko.cms.entity.WebConfig;
import com.trunko.cms.entity.WebInfomation;
import com.trunko.cms.entity.WebLog;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.Pager;


/**
 * 系统日志数据处理对象
 * @author gjz
 *
 */
public class SysLogDao {

public List<WebLog> getInfo(String yhm){
	List<WebLog> webloglist=new ArrayList<WebLog>() ;
	Connection conn = DBHelper.getConnection();
	Statement stat = null;
	ResultSet rs = null;		
	try {
		stat = conn.createStatement();
		String sql="select * from web_log where yhm='"+yhm+"' order by sj desc limit 1";
		rs = stat.executeQuery(sql);
		
		while(rs.next()){
			WebLog webLog=new WebLog();
			webLog.setSj(rs.getTimestamp("sj"));
			webLog.setIp(rs.getString("ip"));
			webloglist.add(webLog);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}	finally {
		DBHelper.closeDB(conn, stat, rs);
	}
	return webloglist;
}

public List<WebLog> getInfolast(String yhm){
	List<WebLog> webloglist=new ArrayList<WebLog>() ;
	Connection conn = DBHelper.getConnection();
	Statement stat = null;
	ResultSet rs = null;		
	try {
		stat = conn.createStatement();
		String sql="select * from web_log where yhm='"+yhm+"' order by sj desc limit 1,1";
		rs = stat.executeQuery(sql);
		
		while(rs.next()){
			WebLog webLog=new WebLog();
			webLog.setSj(rs.getTimestamp("sj"));
			webLog.setIp(rs.getString("ip"));
			webloglist.add(webLog);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}	finally {
		DBHelper.closeDB(conn, stat, rs);
	}
	return webloglist;
}

	public boolean delItemList(String[] itemList){
		
	   String sql="delete from web_log where ";
		
	   for(int i=0;i<itemList.length;i++){	   
		   sql+= " id="+itemList[i]+"  or ";   
	   }
	   sql=sql.substring(0, sql.length()-4);
	   System.out.println(sql);
	   if(DBHelper.executeUpdateInject(sql)>0){
		   return true;
	   }
		
	   return false;
	}
	
	
	
	public Pager getItemForPage(int pageNo,int pageSize){
		
		List<WebLog> itemlist=new ArrayList<WebLog>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        int count=0;
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_log ";
			
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}

			String sql = "select * from web_log limit "+((pageNo-1)*pageSize)+" , "+pageSize;
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				WebLog webLog=new WebLog();
				webLog.setId(rs.getLong("id"));
				webLog.setIp(rs.getString("ip"));
				webLog.setNr(rs.getString("nr"));
				webLog.setSj(rs.getTimestamp("sj"));
				webLog.setXm(rs.getString("xm"));
				webLog.setYhm(rs.getString("yhm"));
				itemlist.add(webLog);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return new Pager(pageSize, pageNo, count, itemlist);
	}
	
	
}
