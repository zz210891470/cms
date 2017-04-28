package com.trunko.cms.dao.sysconfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.entity.WebRole;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.Pager;

/**
 * 系统角色管理数据处理对象
 * @author gjz
 *
 */
public class SysRoleDao {

		public boolean update(WebRole webRole){
			String sql="update  web_role set name='"+webRole.getName()+"',power='"+webRole.getPower()
		     +"',descr='"+webRole.getDescr()+"'"
		     +" where id="+webRole.getId();
			
			System.out.println(sql);
			
			if(DBHelper.executeUpdateInject(sql)>0){
				   return true;
			}

		    return false;
			
		}
		
		
		public WebRole getById(long id){
			Connection conn = DBHelper.getConnection();
			Statement stat = null;
			ResultSet rs = null;
	        WebRole webRole=new WebRole();
			try {
				stat = conn.createStatement();
				String countsql="select * from web_role where id="+id;
				
				rs=stat.executeQuery(countsql);
				if(rs.next()){
					webRole.setId(rs.getLong("id"));
					webRole.setName(rs.getString("name"));
					webRole.setPower(rs.getString("power"));
					webRole.setDescr(rs.getString("descr"));
				}

				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBHelper.closeDB(conn, stat, rs);
			}
			return webRole;
			
			
		}

		public boolean add(WebRole webRole){
			
			String sql="insert into web_role(name,power,descr) values('"+webRole.getName()+"','"+webRole.getPower()
			    +"','"+webRole.getDescr()+"')";
			System.out.println(sql);
			if(DBHelper.executeUpdateInject(sql)>0){
				   return true;
			}

			return false;
		}
		
		
		public boolean delItemList(String[] ItemList){
			
		   String sql="delete from web_role where ";
			
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
			
			List<WebRole> itemlist=new ArrayList<WebRole>() ;
			Connection conn = DBHelper.getConnection();
			Statement stat = null;
			ResultSet rs = null;
	        int count=0;
			try {
				stat = conn.createStatement();
				String countsql="select count(*) as num from web_role ";
				
				rs=stat.executeQuery(countsql);
				if(rs.next()){
					count=rs.getInt("num");
				}

				String sql = "select * from web_role limit "+((pageNo-1)*pageSize)+" , "+pageSize;
				rs = stat.executeQuery(sql);
				
				while(rs.next()){
					WebRole webrole=new WebRole();
					webrole.setId(rs.getLong("id"));
					webrole.setName(rs.getString("name"));
					webrole.setPower(rs.getString("power"));
					webrole.setDescr(rs.getString("descr"));
					
					itemlist.add(webrole);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBHelper.closeDB(conn, stat, rs);
			}
			return new Pager(pageSize, pageNo, count, itemlist);
			

		}
	

}
