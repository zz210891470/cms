package com.trunko.cms.dao.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trunko.cms.entity.WebUser;
import com.trunko.cms.util.DBHelper;

public class SysnchronizedPwdDao {
	
	public boolean sysnpwd(String yhm,String pwd){
		
		ResultSet rs = null;
		Connection conn=DBHelper.getConnection();
		PreparedStatement stat =null;	
		String sql="select * from web_user where  yhm=? ";
		WebUser user=new WebUser();
		try {
			stat=conn.prepareStatement(sql);
			stat.setString(1, yhm);
			rs=stat.executeQuery();
			if(rs.next()){
				String sql1="update web_user set mm='" + pwd + "' where yhm='" + yhm + "'";
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
