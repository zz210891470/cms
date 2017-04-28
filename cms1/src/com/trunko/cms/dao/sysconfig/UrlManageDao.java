package com.trunko.cms.dao.sysconfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.entity.WebUrl;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.Pager;

/**
 * 友情连接管理数据处理对象
 * @author jianhuang
 *
 */
public class UrlManageDao {
	
	public boolean update(WebUrl webUrl){
		String sql="update  web_url set mc='"+webUrl.getMc()+"',url='"+webUrl.getUrl()
	     +"',pxh='"+webUrl.getPxh()+"',lb='"+webUrl.getLb()+"' where id="+webUrl.getId();
		
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}

	    return false;
		
	}
	
	
	public WebUrl getById(long id){
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		WebUrl webUrl=new WebUrl();
		try {
			stat = conn.createStatement();
			String countsql="select * from web_url where id="+id;
			
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				webUrl.setId(rs.getLong("id"));
				webUrl.setMc(rs.getString("mc"));
				webUrl.setUrl(rs.getString("url"));
				webUrl.setPxh(rs.getString("pxh"));
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webUrl;
		
		
	}

	public boolean add(WebUrl webUrl){
		
		String sql="insert into web_url(mc,url,pxh,lb) values('"+webUrl.getMc()+"','"+webUrl.getUrl()
		     +"','"+webUrl.getPxh()+"','"+webUrl.getLb()+"')";
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}

		return false;
	}
	
	
	public boolean delItemList(String[] ItemList){
	   String sql="delete from web_url where ";
	   for(int i=0;i<ItemList.length;i++){	   
		   sql+= " id="+ItemList[i]+"  or ";   
	   }
	   System.out.println(sql);
	   sql=sql.substring(0, sql.length()-4);
	   if(DBHelper.executeUpdateInject(sql)>0){
		   return true;
	   }
	   return false;
	}
	
	public List<WebUrl> getItemList(String lb){
		
		List<WebUrl> itemlist=new ArrayList<WebUrl>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
	
			String sql = "select * from web_url where lb='"+lb+"' order by pxh asc";
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				WebUrl webUrl=new WebUrl();
				webUrl.setId(rs.getLong("id"));
				webUrl.setMc(rs.getString("mc"));
				webUrl.setUrl(rs.getString("url"));
				webUrl.setPxh(rs.getString("pxh"));
				webUrl.setLb(rs.getString("lb"));
				itemlist.add(webUrl);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return itemlist;
	}
}
