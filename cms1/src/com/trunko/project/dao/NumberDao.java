package com.trunko.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.util.DBHelper;

import com.trunko.project.entity.ProCbxm;
import com.trunko.project.entity.ProZdaxm;
import com.trunko.project.entity.ProZdxm;
import com.trunko.project.entity.ProZsxm;

public class NumberDao {
	
	public static boolean singleSaveZsxm(String id, String bh){
		
		
		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
        
		String sql = "update tb_zs_project set bh=?"                          
			                               +" where id=?";

		System.out.println(sql);
	
		try {
   			stat = conn.prepareStatement(sql);			

   			stat.setString(1, bh);

	
   			stat.setLong(2, Long.valueOf(id));

   			if(stat.executeUpdate() > 0){
   				isOk = true;
   			}
   			
   		} catch (SQLException e) {
   			e.printStackTrace();
   		}finally{
   			DBHelper.closeDB(conn, stat);
   		}	

	    return isOk;
	
	}
	
	/**
	 * 单独保存一条信息
	 * @param id 项目主键
	 * @param bh 项目编号
	 * @param sbyh 上报用户
	 * @return  Boolean isOk
	 */
	public static boolean singleSaveCbxm(String id, String bh, String sbyh) {

		Boolean isOk = false;
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat = null;

		String sql = "update tb_cb_project set bh=?,sbyh=? where id=?";

		System.out.println(sql);

		try {
			stat = conn.prepareStatement(sql);

			stat.setString(1, bh);
			stat.setString(2, sbyh);

			stat.setLong(3, Long.valueOf(id));

			if (stat.executeUpdate() > 0) {
				isOk = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat);
		}

		return isOk;

	}

	public static boolean singleSaveZd(String id, String bh, String sbyh){
		
		
		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
        
		String sql = "update tb_zd_project set bh=?"
			                               +",sbyh=?"
			                               +" where id=?";

		System.out.println(sql);
	
		try {
   			stat = conn.prepareStatement(sql);			

   			stat.setString(1, bh);
   			stat.setString(2, sbyh);
	
   			stat.setLong(3, Long.valueOf(id));

   			if(stat.executeUpdate() > 0){
   				isOk = true;
   			}
   			
   		} catch (SQLException e) {
   			e.printStackTrace();
   		}finally{
   			DBHelper.closeDB(conn, stat);
   		}	

	    return isOk;
	
	}
	
	public static boolean singleSaveZda(String id, String bh, String sbyh){
		
		
		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
        
		String sql = "update tb_zda_project set bh=?"
			                               +",sbyh=?"
			                               +" where id=?";

		System.out.println(sql);
	
		try {
   			stat = conn.prepareStatement(sql);			

   			stat.setString(1, bh);
   			stat.setString(2, sbyh);
	
   			stat.setLong(3, Long.valueOf(id));

   			if(stat.executeUpdate() > 0){
   				isOk = true;
   			}
   			
   		} catch (SQLException e) {
   			e.printStackTrace();
   		}finally{
   			DBHelper.closeDB(conn, stat);
   		}	

	    return isOk;
	
	}
	
	public static String getAllUser(){
		
		String userList = "[";
 		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		
		

        String sql = "select * from tb_user ";
		try {
			stat = conn.prepareStatement(sql);	

		
			rs = stat.executeQuery();	
			
			while(rs.next()){
				/*ProUser item =new ProUser();
				item.setId(rs.getLong("id"));
				item.setYhm(rs.getString("yhm"));
				item.setMm(rs.getString("mm"));
				item.setXm(rs.getString("xm"));
				item.setLb(rs.getString("lb"));*/

                String item = "{title:'"+rs.getString("yhm")+"'},";
                userList += item;
			}
			userList = userList.substring(0,userList.length()-1);
			userList += "]";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		
		return userList;
	
		
		
		
	}
	
	
	
	/**
	 * 批量或单个删除数据
	 * @param ItemList
	 * @return
	 */
	public static boolean updateZdItemList(String[] idList,String[] numList, String[] sbyhList){
		
		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	

	    String sql = "update tb_zd_project set bh=? ,sbyh=? where id=?";
		
		try {
   			stat = conn.prepareStatement(sql);		
   			conn.setAutoCommit(false);
   			for(int i = 0; i < idList.length; i++){
   			    stat.setString(1, numList[i]);
   			    stat.setString(2, sbyhList[i]);
   			    stat.setInt(3, Integer.valueOf(idList[i]));
   			    
   			    stat.addBatch();
   			}

   			
   			stat.executeBatch();
   			conn.commit();  //手动提交  
            System.out.println("提交成功!");  
            conn.setAutoCommit(true);
   			isOk = true;
   			
   			
   		} catch (SQLException e) {
   			e.printStackTrace();
            try {  
                conn.rollback();  
                conn.setAutoCommit(true);  
            } catch (SQLException e1) {  
                e1.printStackTrace();  
            }  
   		}finally{
   			DBHelper.closeDB(conn, stat);
   		}	

	    return isOk;

	}

	
	
	/**
	 * 多条件查询
	 * @param searchStr
	 * @param nd
	 * @return
	 */
	public static List<ProZdxm> getZdList(String searchStr,String nd){
		
		
		List<ProZdxm> itemlist = new ArrayList<ProZdxm>() ;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		
		String tempSql = "";
        if(searchStr != null && ! searchStr.equals("") ){
        	tempSql += " and ( mc  like ? or bh like ? )"; 	
        }
        
        
        if(nd != null  && !nd.equals("") ){
        	tempSql += " and nd=?"; 	
        }
        
		try {

			String sql = "select * from tb_zd_project where zt='已审核' "+tempSql+" order by bh asc,id desc ";
			stat = conn.prepareStatement(sql);
			
	        if(searchStr != null && ! searchStr.equals("") ){
	        	stat.setString(1, "%"+searchStr+"%" ); 
	        	stat.setString(2, "%"+searchStr+"%" );
	        }
	        
	        
	        if(nd != null  && !nd.equals("") && searchStr != null && ! searchStr.equals("") ){
	        	stat.setString(3, nd); 	
	        }else if(nd != null  && !nd.equals("") && ( searchStr == null || searchStr.equals("") ) ){
	        	stat.setString(1, nd); 
	        }
			
			rs = stat.executeQuery();	
			while(rs.next()){
				ProZdxm item = new ProZdxm();
				
				item.setId(rs.getLong("id"));
				item.setNd(rs.getLong("nd"));
				item.setBh(rs.getString("bh"));
				item.setMc(rs.getString("mc"));
				item.setDq(rs.getString("dq"));
				item.setJsgm(rs.getString("jsgm"));
				item.setJsdd(rs.getString("jsdd"));
				item.setZtz(rs.getLong("ztz"));
				item.setSbyh(rs.getString("sbyh"));

				
				itemlist.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		
		return  itemlist;
		
		
		
	}
	
	/**
	 * 批量修改数据
	 * @param ItemList
	 * @return
	 */
	public static boolean updateZsxmItemList(String[] idList,String[] numList){
		
		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	

	    String sql = "update tb_zs_project set bh=?   where id=? ";
		
		try {
   			stat = conn.prepareStatement(sql);		
   			conn.setAutoCommit(false);
   			for(int i = 0; i < idList.length; i++){
   			    stat.setString(1, numList[i]);

   			    stat.setInt(2, Integer.valueOf(idList[i]));
   			    
   			    stat.addBatch();
   			}

   			
   			stat.executeBatch();
   			conn.commit();  //手动提交  
            System.out.println("提交成功!");  
            conn.setAutoCommit(true);
   			isOk = true;
   			
   			
   		} catch (SQLException e) {
   			e.printStackTrace();
            try {  
                conn.rollback();  
                conn.setAutoCommit(true);  
            } catch (SQLException e1) {  
                e1.printStackTrace();  
            }  
   		}finally{
   			DBHelper.closeDB(conn, stat);
   		}	

	    return isOk;

	}

	/**
	 * 批量修改储备项目信息数据
	 * @param ItemList
	 * @return
	 */
	public static boolean updateCbxmItemList(String[] idList,String[] numList, String[] sbyhList){
		
		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	

	    String sql = "update tb_cb_project set bh=? ,sbyh=?  where id=? ";
		
		try {
   			stat = conn.prepareStatement(sql);		
   			conn.setAutoCommit(false);
   			for(int i = 0; i < idList.length; i++){
   			    stat.setString(1, numList[i]);
   			    stat.setString(2, sbyhList[i]);
   			    stat.setInt(3, Integer.valueOf(idList[i]));
   			    
   			    stat.addBatch();
   			}

   			
   			stat.executeBatch();
   			conn.commit();  //手动提交  
            System.out.println("提交成功!");  
            conn.setAutoCommit(true);
   			isOk = true;
   			
   			
   		} catch (SQLException e) {
   			e.printStackTrace();
            try {  
                conn.rollback();  
                conn.setAutoCommit(true);  
            } catch (SQLException e1) {  
                e1.printStackTrace();  
            }  
   		}finally{
   			DBHelper.closeDB(conn, stat);
   		}	

	    return isOk;

	}
	
	/**
	 * 批量修改数据
	 * @param ItemList
	 * @return
	 */
	public static boolean updateZdaItemList(String[] idList,String[] numList, String[] sbyhList){
		
		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	

	    String sql = "update tb_zda_project set bh=? ,sbyh=?  where id=? ";
		
		try {
   			stat = conn.prepareStatement(sql);		
   			conn.setAutoCommit(false);
   			for(int i = 0; i < idList.length; i++){
   			    stat.setString(1, numList[i]);
   			    stat.setString(2, sbyhList[i]);
   			    stat.setInt(3, Integer.valueOf(idList[i]));
   			    
   			    stat.addBatch();
   			}

   			
   			stat.executeBatch();
   			conn.commit();  //手动提交  
            System.out.println("提交成功!");  
            conn.setAutoCommit(true);
   			isOk = true;
   			
   			
   		} catch (SQLException e) {
   			e.printStackTrace();
            try {  
                conn.rollback();  
                conn.setAutoCommit(true);  
            } catch (SQLException e1) {  
                e1.printStackTrace();  
            }  
   		}finally{
   			DBHelper.closeDB(conn, stat);
   		}	

	    return isOk;

	}

	
	
	/**
	 * 多条件查询
	 * @param searchStr
	 * @param nd
	 * @return
	 */
	public static List<ProZdaxm> getZdaList(String searchStr,String nd){
		
		
		List<ProZdaxm> itemlist = new ArrayList<ProZdaxm>() ;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		
		String tempSql = "";
        if(searchStr != null && ! searchStr.equals("") ){
        	tempSql += " and ( mc  like ? or bh like ? )"; 	
        }
        
        if(nd != null  && !nd.equals("") ){
        	tempSql += " and nd=?"; 	
        }
        
		try {

			String sql = "select * from tb_zda_project where zt='已审核' "+tempSql+" order by bh asc,id desc ";
			stat = conn.prepareStatement(sql);
			
	        if(searchStr != null && ! searchStr.equals("") ){
	        	stat.setString(1, "%"+searchStr+"%" ); 
	        	stat.setString(2, "%"+searchStr+"%" );
	        }
	        
	        
	        if(nd != null  && !nd.equals("") && searchStr != null && ! searchStr.equals("") ){
	        	stat.setString(3, nd); 	
	        }else if(nd != null  && !nd.equals("") && ( searchStr == null || searchStr.equals("") ) ){
	        	stat.setString(1, nd); 
	        }
			
			rs = stat.executeQuery();	
			while(rs.next()){
				ProZdaxm item = new ProZdaxm();
				
				item.setId(rs.getLong("id"));
				item.setNd(rs.getLong("nd"));
				item.setBh(rs.getString("bh"));
				item.setMc(rs.getString("mc"));
				item.setDq(rs.getString("dq"));
				item.setJsgm(rs.getString("jsgm"));
				item.setJsdd(rs.getString("jsdd"));
				item.setZtz(rs.getLong("ztz"));
				item.setSbyh(rs.getString("sbyh"));
				
				itemlist.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		
		return  itemlist;
		
		
		
	}
	
	
	/**
	 * 多条件查询
	 * @param searchStr
	 * @param nd
	 * @return
	 */
	public static List<ProCbxm> getCbxmList(String searchStr,String nd){
		
		
		List<ProCbxm> itemlist = new ArrayList<ProCbxm>() ;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		
		String tempSql = "";
        if(searchStr != null && ! searchStr.equals("") ){
        	tempSql += " and ( mc  like ? or bh like ? )"; 	
        }
        
        
        if(nd != null  && !nd.equals("") ){
        	tempSql += " and nd=?"; 	
        }
        
		try {

			String sql = "select * from tb_cb_project where zt='已审核' "+tempSql+" order by bh asc,id desc ";
			stat = conn.prepareStatement(sql);
			
	        if(searchStr != null && ! searchStr.equals("") ){
	        	stat.setString(1, "%"+searchStr+"%" ); 
	        	stat.setString(2, "%"+searchStr+"%" );
	        }
	        
	        
	        if(nd != null  && !nd.equals("") && searchStr != null && ! searchStr.equals("") ){
	        	stat.setString(3, nd); 	
	        }else if(nd != null  && !nd.equals("") && ( searchStr == null || searchStr.equals("") ) ){
	        	stat.setString(1, nd); 
	        }
			rs = stat.executeQuery();	
			while(rs.next()){
				ProCbxm item = new ProCbxm();
				
				item.setId(rs.getLong("id"));
				item.setNd(rs.getLong("nd"));
				item.setBh(rs.getString("bh"));
				item.setMc(rs.getString("mc"));
				item.setDq(rs.getString("dq"));
				item.setJsgm(rs.getString("jsgm"));
				item.setJsdd(rs.getString("jsdd"));
				item.setZtz(rs.getDouble("ztz"));
				item.setSbyh(rs.getString("sbyh"));
				
				itemlist.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		
		return  itemlist;
		
		
		
	}
	
	/**
	 * 多条件查询
	 * @param searchStr
	 * @param nd
	 * @return
	 */
	public static List<ProZsxm> getZsxmList(String searchStr,String nd){
		
		
		List<ProZsxm> itemlist = new ArrayList<ProZsxm>() ;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		
		String tempSql = "   where ";
        if(searchStr != null && ! searchStr.equals("") ){
        	tempSql += " ( mc  like ? or bh like ? )   and  "; 	
        }
        
        
        if(nd != null  && !nd.equals("") ){
        	tempSql += "  nd=?         "; 	
        }
        
        tempSql = tempSql.substring(0, tempSql.length()-8);
        

		try {

			String sql = "select * from tb_zs_project "+tempSql+" order by bh asc,id desc ";
			stat = conn.prepareStatement(sql);
			
	        if(searchStr != null && ! searchStr.equals("") ){
	        	stat.setString(1, "%"+searchStr+"%" ); 
	        	stat.setString(2, "%"+searchStr+"%" );
	        }
	        
	        
	        if(nd != null  && !nd.equals("") && searchStr != null && ! searchStr.equals("") ){
	        	stat.setString(3, nd); 	
	        }else if(nd != null  && !nd.equals("") && ( searchStr == null || searchStr.equals("") ) ){
	        	stat.setString(1, nd); 
	        }
			
			rs = stat.executeQuery();	
			while(rs.next()){
				ProZsxm item = new ProZsxm();
				
				item.setId(rs.getLong("id"));
				item.setNd(rs.getLong("nd"));
				item.setBh(rs.getString("bh"));
				item.setMc(rs.getString("mc"));
				item.setJsgm(rs.getString("jsgm"));
				item.setHzfs(rs.getString("hzfs"));
				item.setLxdw(rs.getString("lxdw"));
				item.setLxr(rs.getString("lxr"));
				item.setLxdh(rs.getString("lxdh"));
				item.setQqgz(rs.getString("qqgz"));
				
				
				itemlist.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		
		return  itemlist;
		
		
		
	}
}
