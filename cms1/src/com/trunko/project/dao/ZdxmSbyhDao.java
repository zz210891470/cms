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
import com.trunko.project.entity.ProZdxm;
import com.trunko.project.entity.ProZdxmYb;

public class ZdxmSbyhDao {	
	
	
	
	/**
	 * 添加对象
	 * @param item
	 * @return
	 */
	public static boolean addYb(ProZdxmYb item){
		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		String sql = "insert into tb_zd_month (pid,yf,jhtz1,jhtz2,jhtz3,jhtzhj,dwzj1,dwzj2,dwzj3,dwzjhj,dnljdw1,dnljdw2,dnljdw3,dnljdwhj,kgljdw1,kgljdw2,kgljdw3,kgljdwhj,"
		       +"bywc,nczbywc,wcndjh,kgljwc,xxjd,scnl,czwt,xtjj,gzjh,jcqk,zjsm,tbrq,zt) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
   			stat = conn.prepareStatement(sql);
   			stat.setLong(1, item.getPid());
   			stat.setInt(2, item.getYf());
   			stat.setLong(3, item.getJhtz1());
   			stat.setLong(4, item.getJhtz2());
   			stat.setLong(5, item.getJhtz3());
   			stat.setLong(6, item.getJhtzhj());
   			stat.setLong(7, item.getDwzj1());
   			stat.setLong(8, item.getDwzj2());
   			stat.setLong(9, item.getDwzj3());
   			stat.setLong(10, item.getDwzjhj());
   			stat.setLong(11, item.getDnljdw1());
   			stat.setLong(12, item.getDnljdw2());
   			stat.setLong(13, item.getDnljdw3());
   			stat.setLong(14, item.getDnljdwhj());
   			stat.setLong(15, item.getKgljdw1());
   			stat.setLong(16, item.getKgljdw2());
   			stat.setLong(17, item.getKgljdw3());
   			stat.setLong(18, item.getKgljdwhj());
   			stat.setLong(19, item.getBywc());
   			stat.setLong(20, item.getNczbywc());
   			stat.setDouble(21, item.getWcndjh());
   			stat.setLong(22, item.getKgljwc());
   			stat.setString(23, item.getXxjd());
   			stat.setString(24, item.getScnl());
   			stat.setString(25, item.getCzwt());
   			stat.setString(26, item.getXtjj());
   			stat.setString(27, item.getGzjh());
   			stat.setString(28, item.getJcqk());
   			stat.setString(29, item.getZjsm());
   			stat.setDate(30, item.getTbrq());
   			stat.setString(31, item.getZt());
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
	 * 编辑对象
	 * @param item
	 * @return
	 */
	public static boolean editYb(ProZdxmYb item){
		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		String sql = "update tb_zd_month set jhtz1=?,jhtz2=?,jhtz3=?,jhtzhj=?,dwzj1=?,dwzj2=?,dwzj3=?," +
				"dwzjhj=?,dnljdw1=?,dnljdw2=?,dnljdw3=?,dnljdwhj=?,kgljdw1=?,kgljdw2=?,kgljdw3=?,kgljdwhj=?," +
		        "bywc=?,nczbywc=?,wcndjh=?,kgljwc=?,xxjd=?,scnl=?,czwt=?,xtjj=?,gzjh=?,jcqk=?,zjsm=?,zt=?" +
		        " where id=?";
		try {
   			stat = conn.prepareStatement(sql);
   			stat.setLong(1, item.getJhtz1());
   			stat.setLong(2, item.getJhtz2());
   			stat.setLong(3, item.getJhtz3());
   			stat.setLong(4, item.getJhtzhj());
   			stat.setLong(5, item.getDwzj1());
   			stat.setLong(6, item.getDwzj2());
   			stat.setLong(7, item.getDwzj3());
   			stat.setLong(8, item.getDwzjhj());
   			stat.setLong(9, item.getDnljdw1());
   			stat.setLong(10, item.getDnljdw2());
   			stat.setLong(11, item.getDnljdw3());
   			stat.setLong(12, item.getDnljdwhj());
   			stat.setLong(13, item.getKgljdw1());
   			stat.setLong(14, item.getKgljdw2());
   			stat.setLong(15, item.getKgljdw3());
   			stat.setLong(16, item.getKgljdwhj());
   			stat.setLong(17, item.getBywc());
   			stat.setLong(18, item.getNczbywc());
   			stat.setDouble(19, item.getWcndjh());
   			stat.setLong(20, item.getKgljwc());
   			stat.setString(21, item.getXxjd());
   			stat.setString(22, item.getScnl());
   			stat.setString(23, item.getCzwt());
   			stat.setString(24, item.getXtjj());
   			stat.setString(25, item.getGzjh());
   			stat.setString(26, item.getJcqk());
   			stat.setString(27, item.getZjsm());
   			stat.setString(28, item.getZt());
   			stat.setLong(29, item.getId());
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
	 * 上报对象
	 * @param item
	 * @return
	 */
	public static boolean saveUp(long id){
		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		String sql = "update tb_zd_month set zt=? where id=?";
		try {
   			stat = conn.prepareStatement(sql);
   			stat.setString(1, "已上报");
   			stat.setLong(2, id);
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
	public static ProZdxm getObjByBh(long id){		
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;		
		ProZdxm item =new ProZdxm();
        String sql = "select * from tb_zd_project where id=?";
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
				item.setKgn(rs.getString("kgn"));
				item.setKgy(rs.getString("kgy"));
				item.setWctz(rs.getLong("wctz"));
				item.setJhtz(rs.getLong("jhtz"));
				item.setZjppzc(rs.getLong("zjppzc"));
				item.setZjppdk(rs.getLong("zjppdk"));
				item.setZjppzf(rs.getLong("zjppzf"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return item;
	}
	
	
	/**
	 * 显示 月报录入页面
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static ProZdxmYb showYblr(int id){		
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		ProZdxmYb item =new ProZdxmYb();
		try {
			//TODO 添加分页条件 修改表名
			String sql = "select  * from tb_zd_month where pid="+id+"  order by yf desc  ";				         
			stat = conn.prepareStatement(sql);	
			rs = stat.executeQuery(sql);	
			if(rs.next()){		 
				item.setYf(rs.getInt("yf"));
				item.setDnljdw1(rs.getLong("dnljdw1"));
				item.setDnljdw2(rs.getLong("dnljdw2"));
				item.setDnljdw3(rs.getLong("dnljdw3"));
//				item.setDnljdwhj(rs.getLong("dnljdwhj"));
				item.setDnljdwhj(item.getDnljdw1()+item.getDnljdw2()+item.getDnljdw3());
				item.setKgljdw1(rs.getLong("kgljdw1"));
				item.setKgljdw2(rs.getLong("kgljdw2"));
				item.setKgljdw3(rs.getLong("kgljdw3"));
//				item.setKgljdwhj(rs.getLong("kgljdwhj"));
				item.setKgljdwhj(item.getKgljdw1()+item.getKgljdw2()+item.getKgljdw3());
				item.setNczbywc(rs.getLong("nczbywc"));
				item.setKgljwc(rs.getLong("kgljwc"));
				item.setZt(rs.getString("zt"));
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
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static ProZdxmYb showYbll(int id){		
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		ProZdxmYb item =new ProZdxmYb();
		try {
			String sql = "select  * from tb_zd_month where id="+id;
			stat = conn.prepareStatement(sql);	
			rs = stat.executeQuery(sql);	
			if(rs.next()){		 
				item.setPid(rs.getLong("pid"));
				item.setDwzj1(rs.getLong("dwzj1"));
				item.setDwzj2(rs.getLong("dwzj2"));
				item.setDwzj3(rs.getLong("dwzj3"));
//				item.setDwzjhj(rs.getLong("dwzjhj"));
				item.setDwzjhj(item.getDwzj1()+item.getDwzj2()+item.getDwzj3());
				item.setDnljdw1(rs.getLong("dnljdw1"));
				item.setDnljdw2(rs.getLong("dnljdw2"));
				item.setDnljdw3(rs.getLong("dnljdw3"));
//				item.setDnljdwhj(rs.getLong("dnljdwhj"));
				item.setDnljdwhj(item.getDnljdw1()+item.getDnljdw2()+item.getDnljdw3());
				item.setKgljdw1(rs.getLong("kgljdw1"));
				item.setKgljdw2(rs.getLong("kgljdw2"));
				item.setKgljdw3(rs.getLong("kgljdw3"));
//				item.setKgljdwhj(rs.getLong("kgljdwhj"));
				item.setKgljdwhj(item.getKgljdw1()+item.getKgljdw2()+item.getKgljdw3());
				item.setBywc(rs.getLong("bywc"));
				item.setNczbywc(rs.getLong("nczbywc"));
				item.setKgljwc(rs.getLong("kgljwc"));
				item.setXxjd(rs.getString("xxjd"));
				item.setScnl(rs.getString("scnl"));
				item.setCzwt(rs.getString("czwt"));
				item.setXtjj(rs.getString("xtjj"));
				item.setGzjh(rs.getString("gzjh"));
				item.setJcqk(rs.getString("jcqk"));
				item.setZjsm(rs.getString("zjsm"));
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
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static ProZdxmYb showYbbj(int id){	
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		ProZdxmYb item =new ProZdxmYb();
		try {
			String sql = "select  * from tb_zd_month where id="+id;
			stat = conn.prepareStatement(sql);	
			rs = stat.executeQuery(sql);	
			if(rs.next()){		 
				item.setPid(rs.getLong("pid"));
				item.setDwzj1(rs.getLong("dwzj1"));
				item.setDwzj2(rs.getLong("dwzj2"));
				item.setDwzj3(rs.getLong("dwzj3"));
//				item.setDwzjhj(rs.getLong("dwzjhj"));
				item.setDwzjhj(item.getDwzj1()+item.getDwzj2()+item.getDwzj3());
				item.setDnljdw1(rs.getLong("dnljdw1")-rs.getLong("dwzj1"));
				item.setDnljdw2(rs.getLong("dnljdw2")-rs.getLong("dwzj2"));
				item.setDnljdw3(rs.getLong("dnljdw3")-rs.getLong("dwzj3"));
//				item.setDnljdwhj(rs.getLong("dnljdwhj")-rs.getLong("dwzjhj"));
				item.setDnljdwhj(item.getDnljdw1()+item.getDnljdw2()+item.getDnljdw3());
				System.out.println(item.getDnljdwhj()+"当年");
				item.setKgljdw1(rs.getLong("kgljdw1"));
				item.setKgljdw2(rs.getLong("kgljdw2"));
				item.setKgljdw3(rs.getLong("kgljdw3"));
//				item.setKgljdwhj(rs.getLong("kgljdwhj"));
				item.setKgljdwhj(item.getKgljdw1()+item.getKgljdw2()+item.getKgljdw3());
				item.setBywc(rs.getLong("bywc"));
				item.setNczbywc(rs.getLong("nczbywc")-rs.getLong("bywc"));
				item.setKgljwc(rs.getLong("kgljwc")-rs.getLong("bywc"));
				item.setXxjd(rs.getString("xxjd"));
				item.setScnl(rs.getString("scnl"));
				item.setCzwt(rs.getString("czwt"));
				item.setXtjj(rs.getString("xtjj"));
				item.setGzjh(rs.getString("gzjh"));
				item.setJcqk(rs.getString("jcqk"));
				item.setZjsm(rs.getString("zjsm"));
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
        String sql = "select * from tb_zd_project where id=?";
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
	 * 得到 月报数据列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static List<ProZdxmYb> showYblb(int id){		
		List<ProZdxmYb> itemlist = new ArrayList<ProZdxmYb>() ;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		try {
			//TODO 添加分页条件 修改表名
			String sql = "select * from tb_zd_month where pid="+id+"  order by yf asc";				         
			stat = conn.prepareStatement(sql);	
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				ProZdxmYb item = new ProZdxmYb();
				
				item.setId(rs.getLong("id"));
				item.setYf(rs.getInt("yf"));
				item.setBh(rs.getString("bh"));
				item.setBywc(rs.getLong("bywc"));
				item.setDwzjhj(rs.getLong("dwzjhj"));
				item.setTbrq(rs.getDate("tbrq"));
				item.setZt(rs.getString("zt"));
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
	 * 得到上报项目数据
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static List<ProZdxm> showXmlb(String sbyh,String lb, int nd){
		List<ProZdxm> itemlist = new ArrayList<ProZdxm>() ;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		String tempSql = "";
		if ( FavoritesHelper.isNotNull(lb) ) {
			tempSql += " and lb='"+ lb +"'"; 
		}
		if ( nd > 0 ) {
			tempSql += " and nd="+ nd; 
		}
		try {
			//TODO 添加分页条件 修改表名
			String sql = "select * from tb_zd_project where sbyh='"+sbyh+"' and zt='已审核' "+ tempSql +" order by id desc  ";
				         
			stat = conn.prepareStatement(sql);	
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
				item.setJhtz(rs.getLong("jhtz"));
				item.setZt(rs.getString("zt"));
			
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
	   String sql="update tb_zd_project set zt='已上报' where id="+id;
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
	public static Pager getObjForPage(int pageNo, int pageSize, String lb, String nd, String searchStr , String sbyh){
		
		List<ProZdxm> itemlist = new ArrayList<ProZdxm>() ;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		String tempSql = "";
		if (FavoritesHelper.isNotNull(lb)) {
			tempSql += " and lb='"+ lb +"'";
		}
		if (FavoritesHelper.isNotNull(nd)) {
			tempSql += " and nd='"+ nd +"'";
		}
		if (FavoritesHelper.isNotNull(searchStr)) {
        	tempSql +=" and mc like '%"+searchStr+"%' "; 	
		}
		int count=0;
		try {
			//TODO 添加分页统计条件 修改表名
			String countsql = "select count(*) as num  from tb_zd_project where sbyh='"+sbyh+"' "+tempSql;
			stat = conn.prepareStatement(countsql);	
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count = rs.getInt("num");
			}
			//TODO 添加分页条件 修改表名
			String sql = "select * from tb_zd_project where sbyh='"+sbyh+"' "+tempSql+" order by id desc limit "
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
				item.setZt(rs.getString("zt"));
				item.setLb1(rs.getString("lb1"));
				item.setLb2(rs.getString("lb2"));
				item.setJhtz(rs.getLong("jhtz"));
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
	 * 添加对象
	 * @param item
	 * @return
	 */
	public static boolean add(ProZdxm item){

		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		String sql = "insert into tb_zd_project(nd,bh,mc,dq,lb,lb1,lb2,jsdq,jsdd,jsgm,kgn,kgy,bawh,jsnx1,jsnx2,ztz,wctz,jzqk,jhtz,tz1,tz2,tz3,tz4,tz5,tz6,tz7,tz8,tz9,tz10,tz11,tz12,gcjd,dwmc,zrr,gldw,zjppzc,zjppdk,zjppzf,tzztxz,sfkg,kgyf,cz,ss,jy,zd,nyd,nt,ld,sgyy,hgyp,yhdk,sfscx,sfzz,sfss,sfzy,sfsjs,sjslb,sbyh,zt)"
		             +" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		System.out.println(sql);
		try {
   			stat = conn.prepareStatement(sql);			
   			stat.setLong(1, item.getNd());
   			stat.setString(2, item.getBh());
   			stat.setString(3, item.getMc());
   			stat.setString(4, item.getDq());
   			stat.setString(5, item.getLb());
   			stat.setString(6, item.getLb1());
   			stat.setString(7, item.getLb2());
   			stat.setString(8, item.getJsdq());
   			stat.setString(9, item.getJsdd());
   			stat.setString(10, item.getJsgm());
   			stat.setString(11, item.getKgn());
   			stat.setString(12, item.getKgy());
   			stat.setString(13, item.getBawh());
   			stat.setInt(14, item.getJsnx1());
   			stat.setInt(15, item.getJsnx2());
   			stat.setLong(16, item.getZtz());
   			stat.setLong(17, item.getWctz());
   			stat.setString(18, item.getJzqk());
   			stat.setLong(19, item.getJhtz());
   			stat.setLong(20, item.getTz1());
   			stat.setLong(21, item.getTz2());
   			stat.setLong(22, item.getTz3());
   			stat.setLong(23, item.getTz4());
   			stat.setLong(24, item.getTz5());
   			stat.setLong(25, item.getTz6());
   			stat.setLong(26, item.getTz7());
   			stat.setLong(27, item.getTz8());
   			stat.setLong(28, item.getTz9());
   			stat.setLong(29, item.getTz10());
   			stat.setLong(30, item.getTz11());
   			stat.setLong(31, item.getTz12());
   			stat.setString(32, item.getGcjd());
   			stat.setString(33, item.getDwmc());
   			stat.setString(34, item.getZrr());
   			stat.setString(35, item.getGldw());
   			stat.setLong(36, item.getZjppzc());
   			stat.setLong(37, item.getZjppdk());
   			stat.setLong(38, item.getZjppzf());
   			stat.setString(39, item.getTzztxz());
   			stat.setString(40, item.getSfkg());
   			stat.setString(41, item.getKgyf());
   			stat.setFloat(42, item.getCz());
   			stat.setFloat(43, item.getSs());
   			stat.setInt(44, item.getJy());
   			stat.setFloat(45, item.getZd());
   			stat.setFloat(46, item.getNyd());
   			stat.setFloat(47, item.getNt());
   			stat.setFloat(48, item.getLd());
   			stat.setFloat(49, item.getSgyy());
   			stat.setFloat(50, item.getHgyp());
   			stat.setFloat(51, item.getYhdk());
   			stat.setString(52, item.getSfscx());
   			stat.setString(53, item.getSfzz());
   			stat.setString(54, item.getSfss());
   			stat.setString(55, item.getSfzy());
   			stat.setString(56, item.getSfsjs());
   			stat.setString(57, item.getSjslb());			
   			stat.setString(58, item.getSbyh());
   			stat.setString(59, item.getZt());
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
	
	
	 public static boolean checkIfExsitBh(String bh){
		 
	  		Connection conn = DBHelper.getConnection();
	        PreparedStatement stat = null;	
	        ResultSet rs = null;
			String sql = "select * from tb_zd_project where bh=?";
			System.out.println(sql);
			try {
	   			stat = conn.prepareStatement(sql);
	   			stat.setString(1,bh);
	   		    rs = stat.executeQuery();
	   		    while(!rs.next()){
	   		    	return true;
	   		    }
	   			}catch(Exception e){
	   				e.printStackTrace();
	   			}finally{
	   				DBHelper.closeDB(conn, stat,rs);
	   			}
			 
		 
		return false;
		 
		 
		 
	 }
	
}



 
 
