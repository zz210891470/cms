package com.trunko.cms.dao.infoopen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.entity.WebInfoOpen;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.Pager;
public class InfoOpenDao {
	public boolean update(WebInfoOpen webInfoOpen){
		String sql="update web_infoopen set syh='"+webInfoOpen.getSyh()+"',fl='"+webInfoOpen.getFl()
	     +"',fbjg='"+webInfoOpen.getFbjg()+"',fwrq='"+webInfoOpen.getFwrq()+"',bt='"+webInfoOpen.getBt()
	     +"',wh='"+webInfoOpen.getWh()+"',ztc='"+webInfoOpen.getZtc()+"',nr='"+webInfoOpen.getNr()+"'"
	     +" where id="+webInfoOpen.getId();
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}
	    return false;
	}

	public WebInfoOpen getById(long id){
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
	    
		ResultSet rs = null;
		WebInfoOpen webInfoOpen=new WebInfoOpen();
		try {
			String countsql="select * from web_infoopen where id=?";
			stat = conn.prepareStatement(countsql);
		    stat.setLong(1, id);
		    rs = stat.executeQuery();
			if(rs.next()){
				webInfoOpen.setId(rs.getLong("id"));
				webInfoOpen.setSyh(rs.getString("syh"));
				webInfoOpen.setFl(rs.getString("fl"));
				webInfoOpen.setFbjg(rs.getString("fbjg"));
				webInfoOpen.setFwrq(rs.getDate("fwrq"));
				webInfoOpen.setBt(rs.getString("bt"));
				webInfoOpen.setWh(rs.getString("wh"));
				webInfoOpen.setZtc(rs.getString("ztc"));
				webInfoOpen.setNr(rs.getString("nr"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webInfoOpen;
	}

	public boolean add(WebInfoOpen webInfoOpen){
		
		String sql="insert into web_infoopen(syh,fl,fbjg,fwrq,bt,wh,ztc,nr) values('"+webInfoOpen.getSyh()+"','"+webInfoOpen.getFl()+"','"+webInfoOpen.getFbjg()
		     +"','"+webInfoOpen.getFwrq()+"','"+webInfoOpen.getBt()+"','"+webInfoOpen.getWh()+"','"+webInfoOpen.getZtc()+"','"+webInfoOpen.getNr()+"')";
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}
		return false;
	}
	
	public boolean delItemList(String[] ItemList){
		
	   String sql="delete from web_infoopen where ";
	   for(int i=0;i<ItemList.length;i++){	   
		   sql+= " id="+ItemList[i]+"  or ";   
	   }
	   sql=sql.substring(0, sql.length()-4);
	   if(DBHelper.executeUpdateInject(sql)>0){
		   return true;
	   }
	   return false;
	}
	
	public Pager getItemForPage(int pageNo,int pageSize){
		
		List<WebInfoOpen> itemlist=new ArrayList<WebInfoOpen>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        int count=0;
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_infoopen ";
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}
			String sql = "select * from web_infoopen limit "+((pageNo-1)*pageSize)+" , "+pageSize;
			rs = stat.executeQuery(sql);		
			while(rs.next()){
				WebInfoOpen webInfoOpen=new WebInfoOpen();
				webInfoOpen.setId(rs.getLong("id"));
				webInfoOpen.setSyh(rs.getString("syh"));
				webInfoOpen.setFl(rs.getString("fl"));
				webInfoOpen.setFbjg(rs.getString("fbjg"));
				webInfoOpen.setFwrq(rs.getDate("fwrq"));
				webInfoOpen.setBt(rs.getString("bt"));
				webInfoOpen.setWh(rs.getString("wh"));
				webInfoOpen.setZtc(rs.getString("ztc"));
				webInfoOpen.setNr(rs.getString("nr"));
				itemlist.add(webInfoOpen);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return new Pager(pageSize, pageNo, count, itemlist);
	}
}
