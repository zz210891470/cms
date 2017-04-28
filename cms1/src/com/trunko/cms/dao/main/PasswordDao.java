package com.trunko.cms.dao.main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import com.trunko.cms.entity.ProYbUser;
import com.trunko.cms.entity.WebUser;
import com.trunko.cms.util.DBHelper;

public class PasswordDao {
	
	public boolean passwordUpdate(String yhm,String ymm,String xmm){
		ResultSet rs = null;
		Connection conn=DBHelper.getConnection();
		PreparedStatement stat =null;	
		String sql="select * from web_user where  yhm=? and mm=?";
		WebUser user=new WebUser();
		try {
			stat=conn.prepareStatement(sql);
			stat.setString(1, yhm);
			stat.setString(2, ymm);
			rs=stat.executeQuery();
			if(rs.next()){
				String sql1="update web_user set mm='" + xmm + "' where yhm='" + yhm + "'";
				DBHelper.executeUpdateInject(sql1);
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return false;
	}
	
	public boolean passwordUpdateYb(String yhm,String ymm,String xmm){
		ResultSet rs = null;
		Connection conn=DBHelper.getConnection();
		PreparedStatement stat =null;	
		String sql="select * from tb_user where  yhm=? and mm=?";
		ProYbUser user=new ProYbUser();
		try {
			stat=conn.prepareStatement(sql);
			stat.setString(1, yhm);
			stat.setString(2, ymm);
			rs=stat.executeQuery();
			if(rs.next()){
				String sql1="update tb_user set mm='" + xmm + "' where yhm='" + yhm + "'";
				DBHelper.executeUpdateInject(sql1);
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return false;
	}
}
