package com.trunko.cms.dao.main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.trunko.cms.entity.ProYbUser;
import com.trunko.cms.entity.WebUser;
import com.trunko.cms.util.DBHelper;


/**
 * 登录数据处理对象
 * @author gjz
 *
 */
public class LoginDao {

	
	public WebUser checkLogin(String yhm,String mm,String ip){
		ResultSet rs = null;
		Connection conn=DBHelper.getConnection();
		PreparedStatement stat =null;	
		
			String sql="select * from web_user where  yhm=? and mm=?";
			WebUser user=new WebUser();
			try {
				stat=conn.prepareStatement(sql);
				stat.setString(1, yhm);
				stat.setString(2, mm);
				rs=stat.executeQuery();
				if(rs.next()){
					user.setId(rs.getLong("id"));
					user.setYhm(rs.getString("yhm"));
					user.setXm(rs.getString("xm"));
					user.setQx(rs.getString("qx"));
					java.util.Date d = new java.util.Date();
					Timestamp t = new Timestamp(d.getTime());
					String sql1="insert into web_log(yhm,xm,nr,sj,ip) values('"+rs.getString("yhm")+"','"+rs.getString("xm")
				     +"','用户登录','"+t+"','"+ip+"')";
					DBHelper.executeUpdateInject(sql1);
					return user;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	finally {
				DBHelper.closeDB(conn, stat, rs);
			}
		
		return null;
	}
	
	public WebUser checkLoginYb(String yhm,String mm,String ip){
		ResultSet rs = null;
		Connection conn=DBHelper.getConnection();
		PreparedStatement stat =null;	
		String sql="select * from web_user where  yhm=? and mm=?";
		WebUser user=new WebUser();
		try {
			stat=conn.prepareStatement(sql);
			stat.setString(1, yhm);
			stat.setString(2, mm);
			rs=stat.executeQuery();
			if(rs.next()){
				user.setId(rs.getLong("id"));
				user.setYhm(rs.getString("yhm"));
				user.setXm(rs.getString("xm"));
//				user.setLb(rs.getString("lb"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return null;
	}
}
