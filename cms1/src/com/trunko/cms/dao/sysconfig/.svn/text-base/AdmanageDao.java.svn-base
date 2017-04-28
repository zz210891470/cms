package com.trunko.cms.dao.sysconfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.entity.WebAdvert;
import com.trunko.cms.util.DBHelper;

public class AdmanageDao {
	
	public void update(List<WebAdvert> webAdverts){
		
		for(int i=0;i<webAdverts.size();i++){
			String sql ="update web_advert set status='"+webAdverts.get(i).getStatus()
			+"', imgurl='"+webAdverts.get(i).getImgurl()+"', url='"+webAdverts.get(i).getUrl()+"' where id="+webAdverts.get(i).getId();
			
			DBHelper.executeUpdateInject(sql);
		}

	}

	public List<WebAdvert> getAllAdvert(){
		List<WebAdvert> webAdverts=new ArrayList<WebAdvert>();
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			stat = conn.createStatement();
			String countsql="select * from web_advert  order by id asc";
			
			rs=stat.executeQuery(countsql);
			while(rs.next()){
				WebAdvert webAdvert=new WebAdvert();
				webAdvert.setId(rs.getLong("id"));
				webAdvert.setName(rs.getString("name"));
				webAdvert.setImgurl(rs.getString("imgurl"));
				webAdvert.setUrl(rs.getString("url"));
				webAdvert.setStatus(rs.getString("status"));
				webAdverts.add(webAdvert);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		
		return webAdverts;

	}
	
	
	
	
	
	
}
