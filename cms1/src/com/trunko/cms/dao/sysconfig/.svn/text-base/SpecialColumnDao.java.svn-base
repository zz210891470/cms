package com.trunko.cms.dao.sysconfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.entity.WebSubColumn;
import com.trunko.cms.entity.WebModel;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.Pager;

/**
 * 系统专题管理数据处理对象
 * @author gjz
 *
 */
public class SpecialColumnDao {
	
	public Pager getSubColumnForPage(int pageNo,int pageSize,Long id){
		
		List<WebSubColumn> columnlist=new ArrayList<WebSubColumn>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        int count=0;
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_subcolumn where ztid="+id;
			
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}
			String sql = "select * from web_subcolumn where ztid="+id+" limit "+((pageNo-1)*pageSize)+" , "+pageSize;
			rs = stat.executeQuery(sql);
			while(rs.next()){
				WebSubColumn webSubColumn=new WebSubColumn();
				webSubColumn.setId(rs.getLong("id"));
				webSubColumn.setZtid(rs.getLong("ztid"));
				webSubColumn.setLmmc(rs.getString("lmmc"));
				webSubColumn.setLmmx(rs.getString("lmmx"));
				webSubColumn.setLmpx(rs.getInt("lmpx"));
				columnlist.add(webSubColumn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return new Pager(pageSize, pageNo, count, columnlist);
		

	}
	
	public List<WebModel>  getModelList(){
		
		List<WebModel> webModels=new ArrayList<WebModel>();
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			stat = conn.createStatement();
			String countsql="select * from web_model ";
			
			rs=stat.executeQuery(countsql);
			while(rs.next()){
				WebModel webModel=new WebModel();
				webModel.setId(rs.getLong("id"));
				webModel.setMxbt(rs.getString("mxbt"));
				webModels.add(webModel);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webModels;
	}


	public boolean update(WebSubColumn webSubColumn){
		String sql="update web_subcolumn set lmmc='"+webSubColumn.getLmmc()
	     +"',lmmx='"+webSubColumn.getLmmx()+"',lmpx="+webSubColumn.getLmpx()
	     +" where id="+webSubColumn.getId();
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}
	    return false;
	}
	
	
	public WebSubColumn getById(long id){
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        WebSubColumn webSubColumn=new WebSubColumn();
		try {
			stat = conn.createStatement();
			String countsql="select * from web_subcolumn where id="+id;
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				webSubColumn.setId(rs.getLong("id"));
				webSubColumn.setZtid(rs.getLong("ztid"));
				webSubColumn.setLmmc(rs.getString("lmmc"));
				webSubColumn.setLmmx(rs.getString("lmmx"));
				webSubColumn.setLmpx(rs.getInt("lmpx"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webSubColumn;
		
		
	}

	public boolean add(WebSubColumn webSubColumn){
		String sql="insert into web_subcolumn (lmmc,lmmx,lmpx,ztid) values('"+webSubColumn.getLmmc()
		    +"','"+webSubColumn.getLmmx()+"',"+webSubColumn.getLmpx()+","+webSubColumn.getZtid()+")";
		System.out.println(sql);
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}
		return false;
	}
	
	
	public boolean delItemList(long id){
		
	   String sql="delete from web_subcolumn where id="+id;
	   if(DBHelper.executeUpdateInject(sql)>0){
		   return true;
	   }
	   return false;
	}
	
	
	
	public Pager getItemForPage(int pageNo,int pageSize){
		
		List<WebSubColumn> itemlist=new ArrayList<WebSubColumn>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        int count=0;
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_subcolumn where ztid=0";
			
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}

			String sql = "select * from web_subcolumn where ztid=0 limit "+((pageNo-1)*pageSize)+" , "+pageSize;
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				WebSubColumn webSubColumn=new WebSubColumn();
				webSubColumn.setId(rs.getLong("id"));
				webSubColumn.setZtid(rs.getLong("ztid"));
				webSubColumn.setLmmc(rs.getString("lmmc"));
				webSubColumn.setLmmx(rs.getString("lmmx"));
				webSubColumn.setLmpx(rs.getInt("lmpx"));
				itemlist.add(webSubColumn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return new Pager(pageSize, pageNo, count, itemlist);
		

	}


	
}
