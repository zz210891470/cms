package com.trunko.cms.dao.sysconfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.entity.WebColumn;
import com.trunko.cms.entity.WebModel;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.Pager;



/**
 * 系统栏目管理数据处理类
 * @author cxp
 *
 */
public class SysColumnDao {
	
	public boolean hasColumn(Long id){
    	
    	Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			String countsql="select * from web_column where sjid="+id;
			rs=stat.executeQuery(countsql);
			if(rs.next()){
                return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return false;
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

	
	public boolean update(WebColumn webColumn){
		String sql="update web_column set lmmc='"+webColumn.getLmmc()
	     +"',lmmx='"+webColumn.getLmmx()+"',lmpx="+webColumn.getLmpx()+" where id="+webColumn.getId();
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}
	    return false;
	}
	
	
	public WebColumn getById(long id){
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        WebColumn webColumn=new WebColumn();
		try {
			stat = conn.createStatement();
			String countsql="select * from web_column where id="+id;
			
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				webColumn.setId(rs.getLong("id"));
				webColumn.setSjid(rs.getLong("sjid"));
				webColumn.setLmmc(rs.getString("lmmc"));
				webColumn.setLmmx(rs.getString("lmmx"));
				webColumn.setLmpx(rs.getInt("lmpx"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webColumn;
	}

	public boolean add(WebColumn webColumn){
		String sql="insert into web_column(lmmc,lmpx,sjid,lmmx) values('"+webColumn.getLmmc()+"',"+webColumn.getLmpx()+","+webColumn.getSjid()+",'"+webColumn.getLmmx()+"')";
		if(DBHelper.executeUpdateInject(sql)>0){
		   return true;
		}
		return false;
	}
	public boolean delArticleList(String[] ColumnList){
		   String sql="delete from web_infomation where ";
		   for(int i=0;i<ColumnList.length;i++){	   
			   sql+= " lmid="+ColumnList[i]+"  or ";   
		   }
		   sql=sql.substring(0, sql.length()-4);
		   if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		   }
		   return false;
		}
	
	public boolean delColumnList(long id){
	   String sql="delete from web_column where id="+id;
	   if(DBHelper.executeUpdateInject(sql)>0){
		   return true;
	   }
	   return false;
	}
	
	public Pager getSubColumnForPage(int pageNo,int pageSize,Long id){
		List<WebColumn> columnlist=new ArrayList<WebColumn>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        int count=0;
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_column where sjid="+id;
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}
			String sql = "select * from web_column where sjid="+id+" order by lmpx asc limit "+((pageNo-1)*pageSize)+" , "+pageSize;
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
		return new Pager(pageSize, pageNo, count, columnlist);
	}

	
	
	public Pager getColumnForPage(int pageNo,int pageSize){
		
		List<WebColumn> columnlist=new ArrayList<WebColumn>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        int count=0;
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_column where sjid=0";
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}
			String sql = "select * from web_column where sjid=0 order by lmpx asc limit "+((pageNo-1)*pageSize)+" , "+pageSize;
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
		return new Pager(pageSize, pageNo, count, columnlist);
	}
}
