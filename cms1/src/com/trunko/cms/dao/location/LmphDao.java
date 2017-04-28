package com.trunko.cms.dao.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.trunko.cms.util.DBHelper;


/**
 * 更新栏目浏览排行数据操作类
 * @author jianhuang
 *
 */
public class LmphDao {

	public boolean LmphUpdate(String lmmc){
		
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
		try {
			String sql="update web_lmph set llcs=llcs+1 where lmmc=?";
            stat = conn.prepareStatement(sql);
			
			stat.setString(1, lmmc);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return true;
	}
}
