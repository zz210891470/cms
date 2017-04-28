package com.trunko.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.Pager;
import com.trunko.project.entity.ProCbxm;

public class CbxmSbyhDao {

	

	/**
	 * 通过Id得到对象
	 * @param id
	 * @return
	 */
	public static ProCbxm getObjByBh(String id){
		
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		
		ProCbxm item =new ProCbxm();

        String sql = "select * from tb_cb_project where id=?";
		try {
			stat = conn.prepareStatement(sql);
			stat.setString(1, id);
			rs = stat.executeQuery();	
			if(rs.next()){
				item.setId(rs.getLong("id"));
				item.setNd(rs.getLong("nd"));
				item.setBh(rs.getString("bh"));
				item.setMc(rs.getString("mc"));
				item.setDq(rs.getString("dq"));
				item.setJsgm(rs.getString("jsgm"));
				item.setJsdd(rs.getString("jsdd"));
				item.setZtz(rs.getDouble("ztz"));
				item.setShyj(rs.getString("shyj"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return item;
	}
	
	
	
	/**
	 * 得到 项目名称
	 * @return
	 */
	public static String getXmmc(int id){
		String xmmc="";
		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
        String sql = "select * from tb_cb_project where id=?";
		try {
			stat = conn.prepareStatement(sql);	
			stat.setInt(1, id);
			rs = stat.executeQuery();	
			if(rs.next()){
				xmmc=rs.getString("mc");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return xmmc;
	}
	

	/**
	 * 得到上报项目数据
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static List<ProCbxm> showXmlb(String sbyh,int nd){
		
		List<ProCbxm> itemlist = new ArrayList<ProCbxm>() ;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;

		try {

			//TODO 添加分页条件 修改表名
			String sql = "select * from tb_cb_project where sbyh='"+sbyh+"' and nd="+nd+" order by id desc  ";
				         
			stat = conn.prepareStatement(sql);	
			rs = stat.executeQuery(sql);	
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
				item.setShyj(rs.getString("shyj"));
			
				itemlist.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		
		return itemlist;
	}
	
	
	public static boolean upMsg(String id){
		
	   String sql="update tb_cb_project set zt='已提交' where id="+id;

	   if(DBHelper.executeUpdateInject(sql)>0){
		   return true;
	   }
		
	   return false;
	}
	
	/**
	 * 得到分页数据类
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static Pager getObjForPage(int pageNo, int pageSize, String searchStr , String sbyh){
		
		List<ProCbxm> itemlist = new ArrayList<ProCbxm>() ;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		
		String tempSql;
        if(searchStr==null||searchStr.equals("")){
        	tempSql="";     	
        }else{
        	tempSql=" and mc  like '%"+searchStr+"%' "; 	
        }
		
		int count=0;
		try {
			//TODO 添加分页统计条件 修改表名
			String countsql = "select count(*) as num  from tb_cb_project where sbyh='"+sbyh+"' "+tempSql;
			stat = conn.prepareStatement(countsql);	
			
			rs=stat.executeQuery(countsql);
			
			if(rs.next()){
				count = rs.getInt("num");
			}

			//TODO 添加分页条件 修改表名
			String sql = "select * from tb_cb_project where sbyh='"+sbyh+"' "+tempSql+" order by id desc limit "
				         + ((pageNo - 1) * pageSize) + " , " + pageSize;
			
			rs = stat.executeQuery(sql);	
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
				item.setXyfx(rs.getString("xyfx"));
				item.setSbdw(rs.getString("sbdw"));
				item.setLxr(rs.getString("lxr"));
				item.setLxdh(rs.getString("lxdh"));
				item.setChdw(rs.getString("chdw"));
				item.setLxr1(rs.getString("lxr1"));
				item.setLxdh1(rs.getString("lxdh1"));
				item.setBgs(rs.getString("bgs"));
                item.setBssj(rs.getDate("bssj"));
                
                item.setLb1(rs.getString("lb1"));
                item.setLb2(rs.getString("lb2"));
                item.setLb3(rs.getString("lb3"));
                
                item.setZt(rs.getString("zt"));
                item.setShyj(rs.getString("shyj"));
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
