package com.trunko.cms.dao.sysconfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.entity.WebModel;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.Pager;


/**
 * 系统模型管理数据处理类
 * @author gjz
 *
 */
public class SysModelDao {

	public boolean update(WebModel webModel){
		String sql="update  web_model set mxbt='"+webModel.getMxbt()+"',mxpx="+webModel.getMxpx()
	     +",xtmr='"+webModel.getXtmr()+"'"
	     +" where id="+webModel.getId();
		
		System.out.println(sql);
		
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}

	    return false;
		
	}
	
	
	public WebModel getById(long id){
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        WebModel webModel=new WebModel();
		try {
			stat = conn.createStatement();
			String countsql="select * from web_model where id="+id;
			
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				webModel.setId(rs.getLong("id"));
				webModel.setMxbt(rs.getString("mxbt"));
				webModel.setMxpx(rs.getInt("mxpx"));
				webModel.setXtmr(rs.getString("xtmr"));
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webModel;
		
		
	}

	public boolean add(WebModel webModel){
		
		String sql="insert into web_model(mxbt,mxpx,xtmr) values('"+webModel.getMxbt()+"',"+webModel.getMxpx()
		    +",'"+webModel.getXtmr()+"')";
		System.out.println(sql);
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}

		return false;
	}
	
	
	public boolean delItemList(String[] ItemList){
		
	   String sql="delete from web_model where ";
		
	   for(int i=0;i<ItemList.length;i++){	   
		   sql+= " id="+ItemList[i]+"  or ";   
	   }
	   sql=sql.substring(0, sql.length()-4);
	   System.out.println(sql);
	   if(DBHelper.executeUpdateInject(sql)>0){
		   return true;
	   }
		
	   return false;
	}
	
	
	
	public Pager getItemForPage(int pageNo,int pageSize){
		
		List<WebModel> itemlist=new ArrayList<WebModel>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        int count=0;
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_model ";
			
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}

			String sql = "select * from web_model limit "+((pageNo-1)*pageSize)+" , "+pageSize;
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				WebModel webModel=new WebModel();
				webModel.setId(rs.getLong("id"));
				webModel.setMxbt(rs.getString("mxbt"));
				webModel.setMxpx(rs.getInt("mxpx"));
				webModel.setXtmr(rs.getString("xtmr"));
				
				itemlist.add(webModel);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return new Pager(pageSize, pageNo, count, itemlist);
		

	}


	
	
}
