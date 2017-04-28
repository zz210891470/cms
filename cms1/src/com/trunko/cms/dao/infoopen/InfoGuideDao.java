package com.trunko.cms.dao.infoopen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.trunko.cms.entity.WebInfoGuide;
import com.trunko.cms.util.DBHelper;
public class InfoGuideDao {
	public boolean update(WebInfoGuide webInfoGuide){
		String sql="update web_infoguide set content='"+webInfoGuide.getContent()+"' where topic='"+webInfoGuide.getTopic()+"'";
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}
	    return false;
	}

	public WebInfoGuide getByTopic(String topic){
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
	    
		ResultSet rs = null;
		WebInfoGuide webInfoGuide=new WebInfoGuide();
		try {
			String countsql="select * from web_infoguide where topic=?";
			stat = conn.prepareStatement(countsql);
		    stat.setString(1, topic);
		    rs = stat.executeQuery();
			if(rs.next()){
				webInfoGuide.setTopic(rs.getString("topic"));
				webInfoGuide.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webInfoGuide;
	}
}