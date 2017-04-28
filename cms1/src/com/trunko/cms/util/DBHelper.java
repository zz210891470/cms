package com.trunko.cms.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库处理类，提供简单的静态getconnection方法，以及增删改通用处理方法executeUpdate
 * @author gjz
 *
 */
public class DBHelper {


	public static Connection getConnection() {
	    Connection con = null;
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");    	
	    	//con = DriverManager.getConnection("jdbc:mysql://10.1.3.103:3306/newcms?" +
	    	//		"user=root&password=cgkj123456&useUnicode=true&autoReconnect=true&characterEncoding=UTF-8");
	    	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/com.cg?user=root&password=123&useUnicode=true&autoReconnect=true&characterEncoding=UTF-8");
	    	return con;
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	      return con;
	    }
	  }
	
	
	public static void closeDB(Connection con, Statement stat){   
	    try{	
	    	if(null != stat){
	    		stat.close();
	    	}
	    	if(null != con){
	    		con.close();
	    	}
	    }catch(Exception e){
	    	//TODO 删除错误提示打印
	    	e.printStackTrace();
	    }
    
    }
	
	public static void closeDB(Connection con,Statement stat,ResultSet rs){
		    
		    try{	
		    	if(null!=rs)
		    		rs.close();
		    	if(null!=stat)
		    		stat.close();
		    	if(null!=con)
		    		con.close();
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
	    
	    }
	
	  /**
	   * 未防止注入的通用更新方法
	   * @param sql
	   * @param flag
	   * @param params
	   * @return
	   */
      public static int executeUpdateInject(String sql){
		
  		Connection conn = getConnection();
        PreparedStatement stat =null;	
		
		int cols=0;
  		try {
   			stat = conn.prepareStatement(sql);			
         
   			cols=stat.executeUpdate();
   		} catch (SQLException e) {
   			e.printStackTrace();
   		}finally{
   		    try{	
   		    	if(null!=stat)
   		    		stat.close();
   		    	if(null!=conn)
   		    		conn.close();
   		    }catch(Exception e){
   		    	e.printStackTrace();
   		    }
   		}	
		return cols;	
	}
	 
	
	
	/**
	 * flag是参数的类型的数组，1代表int，2代表long，3代表String，4代表date
	 * @param sql
	 * @param flag
	 * @param params
	 * @return
	 */
	public static int executeUpdate(String sql,int[] flag,String... params){
		
  		Connection conn = getConnection();
        PreparedStatement stat =null;	
		
		int cols=0;
  		try {
   			stat = conn.prepareStatement(sql);			
            for(int i=0;i<flag.length;i++){
            	if(flag[i]==1){
            		stat.setInt(i+1, Integer.valueOf(params[i]));
            	}else if(flag[i]==2){
            		stat.setLong(i+1, Long.valueOf(params[i]));
            	}else if(flag[i]==3){
            		stat.setString(i+1,params[i]);
            	}else if(flag[i]==4){
            		if(params[i].equals("now")){
            			stat.setDate(i+1, new Date((new java.util.Date()).getTime()) );
            		}
            		
            	}  	
            }
   			cols=stat.executeUpdate();
   		} catch (SQLException e) {
   			e.printStackTrace();
   		}finally{
   		    try{	
   		    	if(null!=stat)
   		    		stat.close();
   		    	if(null!=conn)
   		    		conn.close();
   		    }catch(Exception e){
   		    	e.printStackTrace();
   		    }
   		}	
		return cols;	
	}
	
}
