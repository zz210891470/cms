package com.trunko.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.Pager;
import com.trunko.project.entity.ProUser;
import com.trunko.project.entity.ProZdxm;

public class ManageDao {

	


	/**
	 * 更改对象
	 * @param item
	 * @return
	 */
	public static boolean update(ProUser item){
		
		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
        
		String sql = "update tb_user set yhm=?"
			                               +",mm=?"
			                               +",xm=?"
			                               +" where id=?";

		System.out.println(sql);
	
		try {
   			stat = conn.prepareStatement(sql);			

   			stat.setString(1, item.getYhm());
   			stat.setString(2, item.getMm());
   			stat.setString(3, item.getXm());
   			
   			stat.setLong(4, item.getId());

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
	 * 添加对象
	 * @param item
	 * @return
	 */
	public static boolean add(ProUser item){

		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	

		String sql = "insert into tb_user(yhm,mm,xm,lb)"
		                              +" values(? ,? ,? ,? )";
		System.out.println(sql);
            
	
		try {
   			stat = conn.prepareStatement(sql);			

   			stat.setString(1, item.getYhm());
   			stat.setString(2, item.getMm());
   			stat.setString(3, item.getXm());
   			stat.setString(4, item.getLb());

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
	 * 批量或单个删除数据
	 * @param ItemList
	 * @return
	 */
	public static boolean delItemList(String[] ItemList){
		
		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	

	    String sql = "delete from tb_user where ";
		
	    for(int i = 0; i < ItemList.length; i++){	   
		    sql += " id=?   or ";   
	    }
	    sql=sql.substring(0, sql.length()-4);
	    
		System.out.println(sql);
	
		try {
   			stat = conn.prepareStatement(sql);			
   		    
   			for(int i = 0; i < ItemList.length; i++){
   			    stat.setLong(( i + 1 ), Long.valueOf(ItemList[i]));
   			}

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
	 * 通过Id得到对象
	 * @param id
	 * @return
	 */
	public static ProUser getObjById(Long id){
		
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		
		ProUser item =new ProUser();

        String sql = "select * from tb_user where id=?";
		try {
			stat = conn.prepareStatement(sql);	

			stat.setLong(1, id);
		
			rs = stat.executeQuery();	
			
			if(rs.next()){

				item.setId(rs.getLong("id"));
				item.setYhm(rs.getString("yhm"));
				item.setMm(rs.getString("mm"));
				item.setLb(rs.getString("lb"));
				item.setXm(rs.getString("xm"));
	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		
		return item;
	
	}
	
	
	/**
	 * 得到分页数据类
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static Pager getObjForPage(int pageNo, int pageSize, String searchStr,String lb){
		
		List<ProUser> itemlist = new ArrayList<ProUser>() ;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		
		String tempSql = "where lb='"+lb+"'";
        if(searchStr==null||searchStr.equals("")){
        	tempSql+="";     	
        }else{
        	tempSql+=" and  yhm  like '%"+searchStr+"%' "; 	
        }
		
		int count=0;
		try {
			//TODO 添加分页统计条件 修改表名
			String countsql = "select count(*) as num  from tb_user "+tempSql;
			stat = conn.prepareStatement(countsql);	
			
			rs=stat.executeQuery(countsql);
			
			if(rs.next()){
				count = rs.getInt("num");
			}

			//TODO 添加分页条件 修改表名
			String sql = "select * from tb_user "+tempSql+" order by id desc limit "
				         + ((pageNo - 1) * pageSize) + " , " + pageSize;
			
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				ProUser item = new ProUser();
				
				item.setId(rs.getLong("id"));
				item.setYhm(rs.getString("yhm"));
				item.setMm(rs.getString("mm"));
				item.setLb(rs.getString("lb"));
				item.setXm(rs.getString("xm"));
			
				itemlist.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		
		return new Pager(pageSize, pageNo, count, itemlist);
	}
}
