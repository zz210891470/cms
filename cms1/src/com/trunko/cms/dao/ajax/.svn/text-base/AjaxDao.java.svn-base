package com.trunko.cms.dao.ajax;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.entity.WebColumn;
import com.trunko.cms.entity.WebSubColumn;
import com.trunko.cms.util.DBHelper;


/**
 * 系统管理界面侧边栏栏目数据加载
 * @author gjz
 *
 */
public class AjaxDao {
	
	/**
	 * 得到专题频道
	 * @return
	 */
	public List<WebSubColumn> getSubject(){
		
		List<WebSubColumn> columnlist=new ArrayList<WebSubColumn>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        
		try {
			stat = conn.createStatement();

			String sql = "select * from web_subcolumn where ztid=0 ";
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				WebSubColumn webColumn=new WebSubColumn();
                
				webColumn.setId(rs.getLong("id"));
				webColumn.setZtid(rs.getLong("ztid"));
				webColumn.setLmmc(rs.getString("lmmc"));
				webColumn.setLmlx(rs.getString("lmlx"));
				webColumn.setLmmx(rs.getString("lmmx"));
				webColumn.setLjdz(rs.getString("ljdz"));
				webColumn.setLmpx(rs.getInt("lmpx"));
				columnlist.add(webColumn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		
		return columnlist;
		
	}
	
	/**
	 * 得到专题下的栏目
	 * @return
	 */
	public List<WebSubColumn> getSubjectColumn(){
		
		List<WebSubColumn> columnlist=new ArrayList<WebSubColumn>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        
		try {
			stat = conn.createStatement();

			String sql = "select * from web_subcolumn where ztid!=0 ";
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
			    WebSubColumn webColumn=new WebSubColumn();
                
				webColumn.setId(rs.getLong("id"));
				webColumn.setZtid(rs.getLong("ztid"));
				webColumn.setLmmc(rs.getString("lmmc"));
				webColumn.setLmlx(rs.getString("lmlx"));
				webColumn.setLmmx(rs.getString("lmmx"));
				webColumn.setLjdz(rs.getString("ljdz"));
				webColumn.setLmpx(rs.getInt("lmpx"));
				columnlist.add(webColumn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		
		return columnlist;
		
	}
	
	
	
    /**
     * 得到系统频道数据
     * @return
     */
	public List<WebColumn> getRootColumn(){
		
		List<WebColumn> columnlist=new ArrayList<WebColumn>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        
		try {
			stat = conn.createStatement();

			String sql = "select * from web_column where sjid=0 ";
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				WebColumn webColumn=new WebColumn();
                
				webColumn.setId(rs.getLong("id"));
				webColumn.setSjid(rs.getLong("sjid"));
				webColumn.setLmjb(rs.getString("lmjb"));
				webColumn.setLmmc(rs.getString("lmmc"));
				webColumn.setLmlx(rs.getString("lmlx"));
				webColumn.setLmmx(rs.getString("lmmx"));
				webColumn.setLjdz(rs.getString("ljdz"));
				webColumn.setLmpx(rs.getInt("lmpx"));
				columnlist.add(webColumn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		
		return columnlist;
		
	}
	
	/**
	 * 得到系统栏目
	 * @return
	 */
	public List<WebColumn> getSubColumn(){
		
		List<WebColumn> columnlist=new ArrayList<WebColumn>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        
		try {
			stat = conn.createStatement();

			String sql = "select * from web_column where sjid!=0 ";
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				WebColumn webColumn=new WebColumn();
                
				webColumn.setId(rs.getLong("id"));
				webColumn.setSjid(rs.getLong("sjid"));
				webColumn.setLmjb(rs.getString("lmjb"));
				webColumn.setLmmc(rs.getString("lmmc"));
				webColumn.setLmlx(rs.getString("lmlx"));
				webColumn.setLmmx(rs.getString("lmmx"));
				webColumn.setLjdz(rs.getString("ljdz"));
				webColumn.setLmpx(rs.getInt("lmpx"));
				columnlist.add(webColumn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		
		return columnlist;
		
	}
	
	
	
}
