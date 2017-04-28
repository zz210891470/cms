package com.trunko.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.trunko.project.entity.ProZdxm;
import com.trunko.project.entity.ProZdxmYb;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.DateHelper;
import com.trunko.cms.util.FavoritesHelper;
import com.trunko.cms.util.Pager;

/**
 * 重点项目数据处理类
 * @author jianhuang
 *
 */
public class ZdxmYbDao {

	
	/**
	 * 得到项目月报管理列表数据
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static List<ProZdxmYb> showYbglList(String nd, String yf, String lb){
		List<ProZdxmYb> itemlist = new ArrayList<ProZdxmYb>() ;
		Map<Long, ProZdxmYb> zdxmYbMap = new HashMap<Long, ProZdxmYb>();
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		List<ProZdxmYb> zdxmlist = getZdxmList(nd, lb);
		
		try {
			//TODO 添加分页条件 修改表名
			String sql =
							"SELECT zp.*,\n" +
							"			CONCAT_WS(\n" +
							"				',',\n" +
							"				CONVERT(zm.id, CHAR),\n" +
							"				CONVERT(zm.yf, CHAR),\n" +
							"				CONVERT(zm.dwzjhj, CHAR),\n" +
							"				CONVERT(zm.bywc, CHAR),\n" +
							"				CONVERT(zm.tbrq, CHAR),\n" +
							"				zm.zt\n" +
							"			) as yb\n" +
							"		FROM\n" +
							"			tb_zd_month zm,tb_zd_project zp\n" +
							"		WHERE\n" +
							"			zm.pid = zp.id\n" +
							"		AND zm.yf = "+yf+" and zp.zt = '已审核' and zp.nd = "+nd+"\n" +
							"AND zp.lb = '"+lb+"' ORDER BY zp.bh asc";
			stat = conn.prepareStatement(sql);	
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				ProZdxmYb item = new ProZdxmYb();
				item.setBh(rs.getString("bh"));
				item.setProid(rs.getLong("id"));
				item.setMc(rs.getString("mc"));

				String ybStr = rs.getString("yb");
				if (FavoritesHelper.isNotNull(ybStr)) {
					String[] yb = ybStr.split(",");
					item.setId(FavoritesHelper.stringToint(yb[0]));
					item.setYf(FavoritesHelper.stringToint(yb[1]));
					item.setDwzjhj(FavoritesHelper.stringTolong(yb[2]));
					item.setBywc(FavoritesHelper.stringTolong(yb[3]));
					item.setTbrq(DateHelper.stringToSqlDate(yb[4]));
					item.setZt(yb[5]);
				}
		
				zdxmYbMap.put(item.getProid(), item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		for (ProZdxmYb proZdxmYb : zdxmlist) {
			ProZdxmYb tempYb = zdxmYbMap.get(proZdxmYb.getProid());
			if (null != tempYb) {
				proZdxmYb.setId(tempYb.getId());
				proZdxmYb.setYf(tempYb.getYf());
				proZdxmYb.setDwzjhj(tempYb.getDwzjhj());
				proZdxmYb.setBywc(tempYb.getBywc());
				proZdxmYb.setTbrq(tempYb.getTbrq());
				proZdxmYb.setZt(tempYb.getZt());
			}
			itemlist.add(proZdxmYb);
		}
		return itemlist;
	}

	/**
	 * 获取已审核重点项目信息
	 * @return
	 */
	public static List<ProZdxmYb> getZdxmList(String nd, String lb){
		List<ProZdxmYb> itemlist = new ArrayList<ProZdxmYb>() ;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		
		String tempSql = "";
		if (FavoritesHelper.isNotNull(lb)) {
			tempSql += " and p.lb='"+ lb +"'";
		}
		if (FavoritesHelper.isNotNull(nd)) {
			tempSql += " and p.nd="+ nd +"";
		}
		try {
			//TODO 添加分页条件 修改表名
			String sql = "select p.* from tb_zd_project p where p.zt='已审核' "+tempSql+" order by p.bh asc";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				ProZdxmYb item = new ProZdxmYb();
				item.setProid(rs.getLong("id"));
				item.setNd(rs.getLong("nd"));
				item.setBh(rs.getString("bh"));
				item.setMc(rs.getString("mc"));
				
				
				itemlist.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return itemlist;
	}
	/**
	 * 获取已审核重点项目信息
	 * @return
	 */
	public static List<ProZdxmYb> getZdxmYbList(String nd, String yf, String lb){
		List<ProZdxmYb> itemlist = new ArrayList<ProZdxmYb>() ;
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat = null;	
		ResultSet rs = null;
		ResultSet ybRs = null;
		
		String tempSql = "";
		if (FavoritesHelper.isNotNull(lb)) {
			tempSql += " and p.lb='"+ lb +"'";
		}
		if (FavoritesHelper.isNotNull(nd)) {
			tempSql += " and p.nd="+ nd +"";
		}
		try {
			//TODO 添加分页条件 修改表名
			String sql = "select p.*, from tb_zd_project p,(select * from tb_zd_month where  yf="+yf+" ) as m where p.zt='已审核' and m.pid=p.id"+tempSql+" order by p.bh asc, p.id desc";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				ProZdxmYb item = new ProZdxmYb();
				item.setProid(rs.getLong("id"));
				item.setNd(rs.getLong("nd"));
				item.setBh(rs.getString("bh"));
				item.setMc(rs.getString("mc"));
				item.setZtz(rs.getLong("ztz"));
				item.setZt(rs.getString("zt"));
				
				String ybSql = "select * from tb_zd_month where pid= "+item.getProid()+" and yf="+yf;
				stat = conn.prepareStatement(ybSql);
				ybRs = stat.executeQuery(ybSql);	
				while(ybRs.next()){
					item.setId(ybRs.getLong("id"));
					item.setDwzjhj(ybRs.getLong("dwzjhj"));
					item.setBywc(ybRs.getLong("bywc"));
					item.setTbrq(ybRs.getDate("tbrq"));
				}
				
				itemlist.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return itemlist;
	}

	/**
	 * 更改对象
	 * @param item
	 * @return
	 */
	public static boolean update(ProZdxmYb item){
		
		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
        
		String sql = "update tb_zd_month set  bh=?"
			                               +",jhtz1=?"
			                               +",jhtz2=?"
				                           +",jhtz3=?"
			                               +",jhtzhj=?"
				                           +",dwzj1=?"
				                           +",dwzj2=?"
				                           +",dwzj2=?"
				                           +",yf=?"
			                               +" where id=?";

		
		System.out.println(sql);
	
		try {
   			stat = conn.prepareStatement(sql);			

   			stat.setString(1, item.getBh());
   			stat.setLong(2, item.getJhtz1());
   			stat.setLong(3, item.getJhtz1());
   			stat.setLong(4, item.getJhtz1());
   			stat.setLong(5, item.getJhtzhj());
   			stat.setLong(6, item.getDwzj1());
   			stat.setLong(7, item.getDwzj2());
   			stat.setLong(8, item.getDwzj3());
   			stat.setLong(9, item.getYf());
   			stat.setLong(10, item.getId());

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
	public static boolean add(ProZdxmYb item){

		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	

		String sql = "insert into tb_zd_month(bh,jhtz1,jhtz2,jhtz3,jhtzhj,dwzj1,dwzj2,dwzj3,yf)"
		                            +" values(? ,?    ,?    ,?    ,?     ,?    ,?    ,?    ,? )";
		System.out.println(sql);
            
	
		try {
   			stat = conn.prepareStatement(sql);			

   			stat.setString(1, item.getBh());
   			stat.setLong(2, item.getJhtz1());
   			stat.setLong(3, item.getJhtz2());
   			stat.setLong(4, item.getJhtz3());
   			stat.setLong(5, item.getJhtzhj());
   			stat.setLong(6, item.getDwzj1());
   			stat.setLong(7, item.getDwzj2());
   			stat.setLong(8, item.getDwzj3());
   			stat.setLong(9, item.getYf());

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

	    String sql = "delete from tb_zd_month where ";
		
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
	public static ProZdxmYb getObjById(Long id){
		
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		
		ProZdxmYb item =new ProZdxmYb();

        String sql = "select * from tb_zd_month where id=?";
		try {
			stat = conn.prepareStatement(sql);	

			stat.setLong(1, id);
		
			rs = stat.executeQuery();	
			
			if(rs.next()){

				item.setId(rs.getLong("id"));
				item.setBh(rs.getString("bh"));
				item.setJhtz1(rs.getLong("jhtz1"));
				item.setJhtz2(rs.getLong("jhtz2"));
				item.setJhtz3(rs.getLong("jhtz3"));
				item.setJhtzhj(rs.getLong("jhtzhj"));
				item.setDwzj1(rs.getLong("dwzj1"));
				item.setDwzj2(rs.getLong("dwzj2"));
				item.setDwzj3(rs.getLong("dwzj3"));
				item.setYf(rs.getInt("yf"));

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
	public static Pager getObjForPage(int pageNo, int pageSize, String searchStr){
		
		List<ProZdxm> itemlist = new ArrayList<ProZdxm>() ;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		
		String tempSql;
        if(searchStr==null||searchStr.equals("")){
        	tempSql="";     	
        }else{
        	tempSql=" where mc  like '%"+searchStr+"%' "; 	
        }
		
		int count=0;
		try {
			String countsql = "select count(*) as num  from tb_zd_month "+tempSql;
			stat = conn.prepareStatement(countsql);	
			
			rs=stat.executeQuery(countsql);
			
			if(rs.next()){
				count = rs.getInt("num");
			}

			String sql = "select * from tb_zd_month "+tempSql+" order by id desc limit "
				         + ((pageNo - 1) * pageSize) + " , " + pageSize;
			
			rs = stat.executeQuery(sql);	
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

