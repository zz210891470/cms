package com.trunko.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.FavoritesHelper;
import com.trunko.cms.util.Pager;
import com.trunko.project.entity.ProZdaxm;
import com.trunko.project.entity.ProZdaxmYb;



/**
 * 重点项目数据处理类
 * @author jianhuang
 *
 */
public class ZdaxmYbDao {


	/**
	 * 得到分页数据类
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param nd
	 * @param yf
	 * @return
	 */
	public static Pager getObjForPage(int pageNo, int pageSize, String nd, String yf) {

		List<ProZdaxmYb> itemlist = new ArrayList<ProZdaxmYb>();
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;

		String tempSql = "";
		if (FavoritesHelper.isNotNull(nd)) {
			tempSql += " and m.pid in (select t.id from tb_zda_project t where t.nd="+ nd +")";
		} 
		if (FavoritesHelper.isNotNull(yf)){
			tempSql += " and m.yf="+ yf;
		}

		int count = 0;
		try {
			String countsql = "select count(*) as num  from tb_zda_month m where m.zt<>'未上报'" + tempSql;
			stat = conn.prepareStatement(countsql);
			rs = stat.executeQuery(countsql);
			if (rs.next()) {
				count = rs.getInt("num");
			}

			// TODO 添加分页条件 修改表名
			String sql = "select m.*, p.mc from tb_zda_month m,tb_zda_project p where m.pid=p.id and m.zt<>'未上报'" + tempSql
					+ " order by yf asc limit " + ((pageNo - 1) * pageSize)
					+ " , " + pageSize;
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				ProZdaxmYb item = new ProZdaxmYb();

				item.setPid(rs.getLong("pid"));
				item.setId(rs.getLong("id"));
				item.setYf(rs.getString("yf"));
				item.setBh(rs.getString("bh"));
				item.setBywc(rs.getFloat("bywc"));
				item.setNczbywc(rs.getFloat("nczbywc"));
				item.setKgljwc(rs.getFloat("kgljwc"));
				item.setWcndjh(rs.getFloat("wcndjh"));
				item.setXxjd(rs.getString("xxjd"));
				item.setCzwt(rs.getString("czwt"));
				item.setGzjh(rs.getString("gzjh"));
				item.setWcgzjd(rs.getString("wcgzjd"));
				item.setZt(rs.getString("zt"));
				item.setTbsj(rs.getDate("tbsj"));
				item.setBz(rs.getString("bz"));
				item.setMc(rs.getString("mc"));
				
				itemlist.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}

		return new Pager(pageSize, pageNo, count, itemlist);
	}
	/**
	 * 通过Id得到对象
	 * @param id
	 * @return
	 */
	public static ProZdaxm getObjById(Long id){
		
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		
		ProZdaxm item =new ProZdaxm();

        String sql = "select * from tb_zda_project where id=?";
		try {
			stat = conn.prepareStatement(sql);	

			stat.setLong(1, id);
		
			rs = stat.executeQuery();	
			
			if(rs.next()){

				item.setId(rs.getLong("id"));
				item.setNd(rs.getLong("nd"));
				item.setBh(rs.getString("bh"));
				item.setMc(rs.getString("mc"));
				item.setDq(rs.getString("dq"));
				item.setJsgm(rs.getString("jsgm"));
				item.setJsdd(rs.getString("jsdd"));
				item.setZtz(rs.getLong("ztz"));
                item.setBssj(rs.getDate("bssj"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		
		return item;
	
	}
	
	/**
	 * 显示 月报浏览页面
	 * @param id
	 * @return
	 */
	public static ProZdaxmYb showYbll(int id){		
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		ProZdaxmYb item =new ProZdaxmYb();
		try {
			String sql = "select  * from tb_zda_month where id="+id;
			stat = conn.prepareStatement(sql);	
			rs = stat.executeQuery(sql);	
			if(rs.next()){		 
				item.setPid(rs.getLong("pid"));
				item.setId(rs.getLong("id"));
				item.setYf(rs.getString("yf"));
				item.setBh(rs.getString("bh"));
				item.setBywc(rs.getFloat("bywc"));
				item.setNczbywc(rs.getFloat("nczbywc"));
				item.setKgljwc(rs.getFloat("kgljwc"));
				item.setWcndjh(rs.getFloat("wcndjh"));
				item.setXxjd(rs.getString("xxjd"));
				item.setCzwt(rs.getString("czwt"));
				item.setGzjh(rs.getString("gzjh"));
				item.setWcgzjd(rs.getString("wcgzjd"));
				item.setZt(rs.getString("zt"));
				item.setTbsj(rs.getDate("tbsj"));
				item.setBz(rs.getString("bz"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return item;
	}
	
	/**
	 * 显示 月报编辑页面
	 * @param id
	 * @return
	 */
	public static ProZdaxmYb showYbbj(int id){	
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		ProZdaxmYb item =new ProZdaxmYb();
		try {
			String sql = "select  * from tb_zda_month where id="+id;
			stat = conn.prepareStatement(sql);	
			rs = stat.executeQuery(sql);	
			if(rs.next()){		 
				item.setPid(rs.getLong("pid"));
				item.setId(rs.getLong("id"));
				item.setYf(rs.getString("yf"));
				item.setBh(rs.getString("bh"));
				item.setBywc(rs.getFloat("bywc"));
				item.setNczbywc(rs.getFloat("nczbywc"));
				item.setKgljwc(rs.getFloat("kgljwc"));
				item.setWcndjh(rs.getFloat("wcndjh"));
				item.setXxjd(rs.getString("xxjd"));
				item.setCzwt(rs.getString("czwt"));
				item.setGzjh(rs.getString("gzjh"));
				item.setWcgzjd(rs.getString("wcgzjd"));
				item.setZt(rs.getString("zt"));
				item.setTbsj(rs.getDate("tbsj"));
				item.setBz(rs.getString("bz"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return item;
	}
	/**
	 * 编辑对象
	 * @param item
	 * @return
	 */
	public static boolean editYb(ProZdaxmYb item){
		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		String sql = "update tb_zda_month set bywc=?,nczbywc=?,kgljwc=?,xxjd=?,czwt=?,gzjh=?,wcgzjd=?,bz=? where id=?";
		try {
   			stat = conn.prepareStatement(sql);
   			stat.setFloat(1, item.getBywc());
   			stat.setFloat(2, item.getNczbywc());
   			stat.setFloat(3, item.getKgljwc());
   			stat.setString(4, item.getXxjd());
   			stat.setString(5, item.getCzwt());
   			stat.setString(6, item.getGzjh());
   			stat.setString(7, item.getWcgzjd());
   			stat.setString(8, item.getBz());
   			stat.setLong(9, item.getId());
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
	public static ProZdaxm getObjByBh(String id){
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		
		ProZdaxm item =new ProZdaxm();

        String sql = "select * from tb_zda_project where id=?";
        
        // 项目月报中，当年累计完成投资
		String countSql = "select sum(bywc) as dnljwc from tb_zda_month where pid=?";
		try {
			stat = conn.prepareStatement(countSql);
			stat.setLong(1, FavoritesHelper.stringTolong(id));
			rs = stat.executeQuery();
			if(rs.next()){
				item.setDnljwc(rs.getFloat("dnljwc"));
			}
			stat = conn.prepareStatement(sql);
			stat.setLong(1, FavoritesHelper.stringTolong(id));
			rs = stat.executeQuery();
			if(rs.next()){
				item.setId(rs.getLong("id"));
				item.setNd(rs.getLong("nd"));
				item.setBh(rs.getString("bh"));
				item.setMc(rs.getString("mc"));
				item.setDq(rs.getString("dq"));
				item.setJsgm(rs.getString("jsgm"));
				item.setJsdd(rs.getString("jsdd"));
				item.setZtz(rs.getLong("ztz"));
				item.setLb1(rs.getString("lb1"));
				item.setLb2(rs.getString("lb2"));
				item.setLb3(rs.getString("lb3"));
				item.setJsdq(rs.getString("jsdq"));
				item.setBawh(rs.getString("bawh"));
				item.setJsnx1(rs.getInt("jsnx1"));
				item.setJsnx2(rs.getInt("jsnx2"));
				item.setJhtz(rs.getLong("jhtz"));
				item.setJdmb(rs.getString("jdmb"));
				item.setKgn(rs.getString("kgn"));
				item.setKgy(rs.getString("kgy"));
				item.setJgn(rs.getString("Jgn"));
				item.setJgy(rs.getString("Jgy"));
				item.setYd(rs.getFloat("yd"));
				item.setLd(rs.getFloat("ld"));
				item.setWctz(rs.getLong("wctz"));
				item.setZt(rs.getString("zt"));
				item.setShyj(rs.getString("shyj"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return item;
	}
}

