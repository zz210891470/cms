package com.trunko.cms.dao.sysconfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.entity.ProYbUser;
import com.trunko.cms.entity.WebLog;
import com.trunko.cms.entity.WebColumn;
import com.trunko.cms.entity.WebSubColumn;
import com.trunko.cms.entity.WebUser;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.Pager;


/**
 * 系统用户管理数据处理对象
 * @author gjz
 *
 */
public class SysUserDao {

	public List<WebColumn> lmqxList(){
		List<WebColumn> webLmqxs=new ArrayList<WebColumn>();
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			String countsql="select * from web_column where sjid=0 order by lmpx asc";
			rs=stat.executeQuery(countsql);
			while(rs.next()){
				WebColumn webLmqx=new WebColumn();
				webLmqx.setId(rs.getLong("id"));
				webLmqx.setLmmc(rs.getString("lmmc"));
				webLmqxs.add(webLmqx);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webLmqxs;
	}
	
	public List<WebColumn> lmqxList1(){
		List<WebColumn> webLmqxs=new ArrayList<WebColumn>();
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			String countsql="select * from web_column where sjid>0 order by lmpx asc";
			rs=stat.executeQuery(countsql);
			while(rs.next()){
				WebColumn webLmqx=new WebColumn();
				webLmqx.setId(rs.getLong("id"));
				webLmqx.setSjid(rs.getLong("sjid"));
				webLmqx.setLmmc(rs.getString("lmmc"));
				webLmqxs.add(webLmqx);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webLmqxs;
	}
	
	public List<WebSubColumn> ztqxList(){
		List<WebSubColumn> webZtqxs=new ArrayList<WebSubColumn>();
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			String countsql="select * from web_subcolumn where ztid=0 order by lmpx asc";
			rs=stat.executeQuery(countsql);
			while(rs.next()){
				WebSubColumn webZtqx=new WebSubColumn();
				webZtqx.setId(rs.getLong("id"));
				webZtqx.setZtid(rs.getLong("ztid"));
				webZtqx.setLmmc(rs.getString("lmmc"));
				webZtqxs.add(webZtqx);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webZtqxs;
	}
	
	public List<WebSubColumn> ztqxList1(){
		List<WebSubColumn> webZtqxs=new ArrayList<WebSubColumn>();
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			String countsql="select * from web_subcolumn where ztid>0 order by lmpx asc";
			rs=stat.executeQuery(countsql);
			while(rs.next()){
				WebSubColumn webZtqx=new WebSubColumn();
				webZtqx.setId(rs.getLong("id"));
				webZtqx.setZtid(rs.getLong("ztid"));
				webZtqx.setLmmc(rs.getString("lmmc"));
				webZtqxs.add(webZtqx);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webZtqxs;
	}

	public boolean update(WebUser webUser){
		String sql="";
		if(webUser.getMm().equals("")){
			sql="update  web_user set yhm='"+webUser.getYhm()+"',xm='"+webUser.getXm()
	     +"',yx='"+webUser.getYx()+"',dh='"+webUser.getDh()+"',qx='"+webUser.getQx()+"',zt="+webUser.getZt()
	     +" where id="+webUser.getId();
		}else{
			sql="update  web_user set yhm='"+webUser.getYhm()+"',mm='"+webUser.getMm()
		     +"',xm='"+webUser.getXm()+"',yx='"+webUser.getYx()+"',dh='"+webUser.getDh()+"',qx='"+webUser.getQx()+"',zt="+webUser.getZt()
		     +" where id="+webUser.getId();
		}
		
		System.out.println(sql);
		
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}

	    return false;
		
	}
	
	
	public WebUser getById(long id){
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        WebUser webuser=new WebUser();
		try {
			stat = conn.createStatement();
			String countsql="select * from web_user where id="+id;
			
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				webuser.setId(rs.getLong("id"));
				webuser.setXm(rs.getString("xm"));
				webuser.setYhm(rs.getString("yhm"));
				webuser.setYx(rs.getString("yx"));
				webuser.setDh(rs.getString("dh"));
				webuser.setQx(rs.getString("qx"));
				webuser.setZt(rs.getInt("Zt"));
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webuser;
		
		
	}

	public boolean add(WebUser webUser){
		
		String sql="insert into web_user(yhm,mm,xm,yx,dh,qx,zt) values('"+webUser.getYhm()+"','"+webUser.getMm()
		     +"','"+webUser.getXm()+"','"+webUser.getYx()+"','"+webUser.getDh()+"','"+webUser.getQx()+"',"+webUser.getZt()+")";
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}

		return false;
	}
	
	
	public boolean delItemList(String[] ItemList){
		
	   String sql="delete from web_user where ";
		
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
		
		List<WebUser> itemlist=new ArrayList<WebUser>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        int count=0;
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_user ";
			
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}

			String sql = "select * from web_user limit "+((pageNo-1)*pageSize)+" , "+pageSize;
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				WebUser webuser=new WebUser();
				webuser.setId(rs.getLong("id"));
				webuser.setXm(rs.getString("xm"));
				webuser.setYhm(rs.getString("yhm"));
				webuser.setYx(rs.getString("yx"));
				webuser.setDh(rs.getString("dh"));
				webuser.setQx(rs.getString("qx"));
				webuser.setZt(rs.getInt("Zt"));
				itemlist.add(webuser);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return new Pager(pageSize, pageNo, count, itemlist);
		

	}
	/**
	 * 根据用户名获取系统管理员用户信息
	 * @param loginName
	 * @return
	 */
	public WebUser getWebUserByLoginName(String loginName){
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        WebUser webuser=new WebUser();
		try {
			stat = conn.createStatement();
			String countsql="select * from web_user where yhm='"+loginName+"'";
			
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				webuser.setId(rs.getLong("id"));
				webuser.setXm(rs.getString("xm"));
				webuser.setYhm(rs.getString("yhm"));
				webuser.setYx(rs.getString("yx"));
				webuser.setDh(rs.getString("dh"));
				webuser.setQx(rs.getString("qx"));
				webuser.setZt(rs.getInt("Zt"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webuser;
	}
	/**
	 * 根据用户名获取上报用户信息
	 * @param loginName
	 * @return
	 */
	public ProYbUser getYbUserByLoginName(String loginName){
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		ProYbUser ybuser=new ProYbUser();
		try {
			stat = conn.createStatement();
			String countsql="select * from tb_user where yhm='"+loginName+"'";
			
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				ybuser.setId(rs.getLong("id"));
				ybuser.setXm(rs.getString("xm"));
				ybuser.setYhm(rs.getString("yhm"));
				ybuser.setLb(rs.getString("lb"));
				ybuser.setMm(rs.getString("mm"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return ybuser;
	}
}
