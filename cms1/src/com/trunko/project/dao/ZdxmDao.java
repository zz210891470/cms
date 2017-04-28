package com.trunko.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.trunko.project.entity.ProIndustry;
import com.trunko.project.entity.ProZdxm;
import com.trunko.project.entity.ProZdxmYb;
import com.trunko.project.vo.FjFlInfo;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.FavoritesHelper;
import com.trunko.cms.util.Pager;

/**
 * 重点项目数据处理类
 * @author jianhuang
 *
 */
public class ZdxmDao {
	
	/**
	 * 获取分类统计信息
	 * @param nd
	 * @param ksyf
	 * @param jsyf
	 * @return
	 */
	public static List<FjFlInfo> getFlInfoList(String  nd, String ksyf, String jsyf ,String lb){
	
		// 获取数据库连接
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		List<FjFlInfo> infoList1 = new ArrayList<FjFlInfo>();
		try {
			
			FjFlInfo info2 = new FjFlInfo();
            
			String tempSql = "";
			if(lb.equals("合计")){
				
				tempSql ="";
				
			}else {
				
				tempSql = " and p.lb='"+lb+"'";
				
			}
			
			// 重点项目所属类别查询语句
			String sql = "select COUNT(*) as pnum, SUM(ztz) as ztz,p.lb1 as dq ,lb,SUM(dnljdwhj) as dnljdwhj ," +
					     " SUM(nczbywc) as nczbywc,SUM(jhtz) as jhtz ,avg(wcndjh) as wcndjh , sfscx " +
					     " from tb_zd_project p,tb_zd_month m " +
					     " where p.id=m.pid and m.yf="+jsyf+" "+tempSql+" and nd=" +nd +
					     " and p.zt='已审核' GROUP BY p.lb1";
			
			System.out.println(sql);
			stat = conn.prepareStatement(sql);
			// 获取查询结果
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				FjFlInfo info1 = new FjFlInfo();
				
				
				info1.setDq(rs.getString("dq"));
				info1.setJhtz(rs.getLong("jhtz"));
				info1.setPnum(rs.getLong("pnum"));
				info1.setNczbywc(rs.getLong("nczbywc"));
				info1.setZtz(rs.getLong("ztz"));
				info1.setWcbl(info1.getNczbywc()*100d/info1.getJhtz());
				info1.setLb(rs.getString("lb"));
				info1.setDnljdwhj(rs.getLong("dnljdwhj"));
				info1.setDwwcbl( Double.valueOf( info1.getDnljdwhj()*100 ) / Double.valueOf( info1.getJhtz() ));
                info1.setSfscx(rs.getString("sfscx"));
                infoList1.add(info1);
			}
			
			//如果开始月份不等于1，则需要将之前的统计删除
			if(!ksyf.equals("1") && infoList1.size()>0){
				// 重点项目所属类别查询语句
				sql = "select SUM(nczbywc) as nczbywc ,SUM(dnljdwhj) as dnljdwhj " +
						     " from tb_zd_project p,tb_zd_month m " +
						     " where p.id=m.pid and m.yf="+(Integer.valueOf(ksyf)-1)+"  "+tempSql+"   and nd=" +nd +
						     " and p.zt='已审核' GROUP BY p.lb1";

				// 获取查询结果
				rs = stat.executeQuery(sql);
				List<Long> nczbywcList = new ArrayList<Long>();
				List<Long> dnljdwhjList = new ArrayList<Long>();
				while(rs.next()){
					Long temp =rs.getLong("nczbywc");
	                nczbywcList.add(temp);
	                Long temp1 =rs.getLong("dnljdwhj");
	                dnljdwhjList.add(temp1);
				}

				for(int i=0; i<nczbywcList.size(); i++){
                    infoList1.get(i).setNczbywc((infoList1.get(i).getNczbywc()-nczbywcList.get(i))); 
                    infoList1.get(i).setWcbl((Double.valueOf(infoList1.get(i).getNczbywc())/infoList1.get(i).getJhtz())*100d);
                    infoList1.get(i).setDnljdwhj((infoList1.get(i).getDnljdwhj()-dnljdwhjList.get(i))); 
                    infoList1.get(i).setDwwcbl((Double.valueOf(infoList1.get(i).getDnljdwhj())/infoList1.get(i).getJhtz())*100d);
				    
				}

			}

			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放连接
			DBHelper.closeDB(conn, stat, rs);
		}	
		
		return infoList1;
	}


	public static List<FjFlInfo> getCyInfoList(String  nd, String ksyf, String jsyf ,String lb){
		
		// 获取数据库连接
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		List<FjFlInfo> infoList1 = new ArrayList<FjFlInfo>();
		try {
			
			FjFlInfo info2 = new FjFlInfo();
            
			String tempSql = "";
			if(lb.equals("合计")){
				
				tempSql ="";
				
			}else {
				
				tempSql = " and p.lb='"+lb+"'";
				
			}
			
			// 重点项目所属类别查询语句
			String sql = "select COUNT(*) as pnum, SUM(ztz) as ztz,p.sjslb as dq ,lb,SUM(dnljdwhj) as dnljdwhj ," +
					     " SUM(nczbywc) as nczbywc,SUM(jhtz) as jhtz ,avg(wcndjh) as wcndjh , sfscx " +
					     " from tb_zd_project p,tb_zd_month m " +
					     " where p.id=m.pid and m.yf="+jsyf+" "+tempSql+" and nd=" +nd +
					     " and p.zt='已审核' and p.sjslb is not null GROUP BY p.sjslb";
			
			System.out.println(sql);
			stat = conn.prepareStatement(sql);
			// 获取查询结果
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				FjFlInfo info1 = new FjFlInfo();
				
				
				info1.setDq(rs.getString("dq"));
				info1.setJhtz(rs.getLong("jhtz"));
				info1.setPnum(rs.getLong("pnum"));
				info1.setNczbywc(rs.getLong("nczbywc"));
				info1.setZtz(rs.getLong("ztz"));
				info1.setWcbl(info1.getNczbywc()*100d/info1.getJhtz());
				info1.setLb(rs.getString("lb"));
				info1.setDnljdwhj(rs.getLong("dnljdwhj"));
				info1.setDwwcbl( Double.valueOf( info1.getDnljdwhj()*100 ) / Double.valueOf( info1.getJhtz() ));
                info1.setSfscx(rs.getString("sfscx"));
                infoList1.add(info1);
			}
			
			//如果开始月份不等于1，则需要将之前的统计删除
			if(!ksyf.equals("1") && infoList1.size()>0){
				// 重点项目所属类别查询语句
				sql = "select SUM(nczbywc) as nczbywc ,SUM(dnljdwhj) as dnljdwhj " +
						     " from tb_zd_project p,tb_zd_month m " +
						     " where p.id=m.pid and m.yf="+(Integer.valueOf(ksyf)-1)+"  "+tempSql+"   and nd=" +nd +
						     " and p.zt='已审核' and p.sjslb is not null GROUP BY p.sjslb";

				// 获取查询结果
				rs = stat.executeQuery(sql);
				List<Long> nczbywcList = new ArrayList<Long>();
				List<Long> dnljdwhjList = new ArrayList<Long>();
				while(rs.next()){
					Long temp =rs.getLong("nczbywc");
	                nczbywcList.add(temp);
	                Long temp1 =rs.getLong("dnljdwhj");
	                dnljdwhjList.add(temp1);
				}

				for(int i=0; i<nczbywcList.size(); i++){
                    infoList1.get(i).setNczbywc((infoList1.get(i).getNczbywc()-nczbywcList.get(i))); 
                    infoList1.get(i).setWcbl((Double.valueOf(infoList1.get(i).getNczbywc())/infoList1.get(i).getJhtz())*100d);
                    infoList1.get(i).setDnljdwhj((infoList1.get(i).getDnljdwhj()-dnljdwhjList.get(i))); 
                    infoList1.get(i).setDwwcbl((Double.valueOf(infoList1.get(i).getDnljdwhj())/infoList1.get(i).getJhtz())*100d);
				    
				}

			}

			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放连接
			DBHelper.closeDB(conn, stat, rs);
		}	
		
		return infoList1;
	}

	
public static List<FjFlInfo> getCymxInfoList(String  nd, String ksyf, String jsyf ,String lb){
		
		// 获取数据库连接
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		List<FjFlInfo> infoList1 = new ArrayList<FjFlInfo>();
		try {
			
			FjFlInfo info2 = new FjFlInfo();
            
			String tempSql = "";
			if(lb.equals("合计")){
				
				tempSql ="";
				
			}else {
				
				tempSql = ",p.mc";
				
			}
			
			// 重点项目所属类别查询语句
			String sql = "select COUNT(*) as pnum, SUM(ztz) as ztz,p.sjslb as dq ,lb,SUM(dnljdwhj) as dnljdwhj ," +
					     " SUM(nczbywc) as nczbywc,SUM(jhtz) as jhtz ,avg(wcndjh) as wcndjh , sfscx,p.mc " +
					     " from tb_zd_project p,tb_zd_month m " +
					     " where p.id=m.pid and m.yf="+jsyf+" "+" and nd=" +nd +
					     " and p.zt='已审核' and p.sjslb is not null GROUP BY p.sjslb"+tempSql;
			
			System.out.println(sql);
			stat = conn.prepareStatement(sql);
			// 获取查询结果
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				FjFlInfo info1 = new FjFlInfo();
				
				
				info1.setDq(rs.getString("dq"));
				info1.setJhtz(rs.getLong("jhtz"));
				info1.setPnum(rs.getLong("pnum"));
				info1.setNczbywc(rs.getLong("nczbywc"));
				info1.setZtz(rs.getLong("ztz"));
				info1.setWcbl(info1.getNczbywc()*100d/info1.getJhtz());
				info1.setLb(rs.getString("lb"));
				info1.setDnljdwhj(rs.getLong("dnljdwhj"));
				info1.setDwwcbl( Double.valueOf( info1.getDnljdwhj()*100 ) / Double.valueOf( info1.getJhtz() ));
                info1.setSfscx(rs.getString("sfscx"));
                info1.setMc(rs.getString("mc"));
                infoList1.add(info1);
			}
			
			//如果开始月份不等于1，则需要将之前的统计删除
			if(!ksyf.equals("1") && infoList1.size()>0){
				// 重点项目所属类别查询语句
				sql = "select SUM(nczbywc) as nczbywc ,SUM(dnljdwhj) as dnljdwhj " +
						     " from tb_zd_project p,tb_zd_month m " +
						     " where p.id=m.pid and m.yf="+(Integer.valueOf(ksyf)-1)+" "+" and nd=" +nd +
						     " and p.zt='已审核' and p.sjslb is not null GROUP BY p.sjslb"+tempSql;

				// 获取查询结果
				rs = stat.executeQuery(sql);
				List<Long> nczbywcList = new ArrayList<Long>();
				List<Long> dnljdwhjList = new ArrayList<Long>();
				while(rs.next()){
					Long temp =rs.getLong("nczbywc");
	                nczbywcList.add(temp);
	                Long temp1 =rs.getLong("dnljdwhj");
	                dnljdwhjList.add(temp1);
				}

				for(int i=0; i<nczbywcList.size(); i++){
                    infoList1.get(i).setNczbywc((infoList1.get(i).getNczbywc()-nczbywcList.get(i))); 
                    infoList1.get(i).setWcbl((Double.valueOf(infoList1.get(i).getNczbywc())/infoList1.get(i).getJhtz())*100d);
                    infoList1.get(i).setDnljdwhj((infoList1.get(i).getDnljdwhj()-dnljdwhjList.get(i))); 
                    infoList1.get(i).setDwwcbl((Double.valueOf(infoList1.get(i).getDnljdwhj())/infoList1.get(i).getJhtz())*100d);
				    
				}

			}

			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放连接
			DBHelper.closeDB(conn, stat, rs);
		}	
		
		return infoList1;
	}

	
	
	
	/**
	 * 获取分级统计信息
	 * @param nd
	 * @param ksyf
	 * @param jsyf
	 * @return
	 */
	public static List<FjFlInfo> getFjInfoList(String  nd, String ksyf, String jsyf ,String lb){
	
		// 获取数据库连接
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		List<FjFlInfo> infoList1 = new ArrayList<FjFlInfo>();
		try {
			
			FjFlInfo info2 = new FjFlInfo();
            
			String tempSql = "";
			if(lb.equals("合计")){
				
				tempSql ="";
				
			}else {
				
				tempSql = " and p.lb='"+lb+"'";
				
			}
			
			// 重点项目所属区域查询语句
			String sql = "select COUNT(*) as pnum, SUM(ztz) as ztz,dq ,lb,SUM(dnljdwhj) as dnljdwhj ," +
					     " SUM(nczbywc) as nczbywc,SUM(jhtz) as jhtz ,avg(wcndjh) as wcndjh , sfscx " +
					     " from tb_zd_project p,tb_zd_month m " +
					     " where p.id=m.pid and m.yf="+jsyf+" "+tempSql+" and nd=" +nd +
					     " and p.zt='已审核' GROUP BY p.dq";
			
			System.out.println(sql);
			stat = conn.prepareStatement(sql);
			// 获取查询结果
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				FjFlInfo info1 = new FjFlInfo();
				
				
				info1.setDq(rs.getString("dq"));
				info1.setJhtz(rs.getLong("jhtz"));
				info1.setPnum(rs.getLong("pnum"));
				info1.setNczbywc(rs.getLong("nczbywc"));
				info1.setZtz(rs.getLong("ztz"));
				info1.setWcbl(info1.getNczbywc()*100d/info1.getJhtz());
				info1.setLb(rs.getString("lb"));
				info1.setDnljdwhj(rs.getLong("dnljdwhj"));
				info1.setDwwcbl( Double.valueOf( info1.getDnljdwhj()*100 ) / Double.valueOf( info1.getJhtz() ));
                info1.setSfscx(rs.getString("sfscx"));
                infoList1.add(info1);
			}
			
			//如果开始月份不等于1，则需要将之前的统计删除
			if(!ksyf.equals("1") && infoList1.size()>0){
				// 重点项目所属区域查询语句
				sql = "select SUM(nczbywc) as nczbywc ,SUM(dnljdwhj) as dnljdwhj " +
						     " from tb_zd_project p,tb_zd_month m " +
						     " where p.id=m.pid and m.yf="+(Integer.valueOf(ksyf)-1)+"  "+tempSql+"   and nd=" +nd +
						     " and p.zt='已审核' GROUP BY p.dq";

				// 获取查询结果
				rs = stat.executeQuery(sql);
				List<Long> nczbywcList = new ArrayList<Long>();
				List<Long> dnljdwhjList = new ArrayList<Long>();
				while(rs.next()){
					Long temp =rs.getLong("nczbywc");
	                nczbywcList.add(temp);
	                Long temp1 =rs.getLong("dnljdwhj");
	                dnljdwhjList.add(temp1);
				}

				for(int i=0; i<nczbywcList.size(); i++){
                    infoList1.get(i).setNczbywc((infoList1.get(i).getNczbywc()-nczbywcList.get(i))); 
                    infoList1.get(i).setWcbl((Double.valueOf(infoList1.get(i).getNczbywc())/infoList1.get(i).getJhtz())*100d);
                    infoList1.get(i).setDnljdwhj((infoList1.get(i).getDnljdwhj()-dnljdwhjList.get(i))); 
                    infoList1.get(i).setDwwcbl((Double.valueOf(infoList1.get(i).getDnljdwhj())/infoList1.get(i).getJhtz())*100d);
				    
				}

			}

			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放连接
			DBHelper.closeDB(conn, stat, rs);
		}	
		
		return infoList1;
	}
	/**
	 * 获取生产性项目信息
	 * @param nd
	 * @param ksyf
	 * @param jsyf
	 * @return
	 */
	public static List<FjFlInfo> getScxInfoList(String  nd, String ksyf, String jsyf){
		
		// 获取数据库连接
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat = null;	
		ResultSet rs = null;
		List<FjFlInfo> infoList1 = new ArrayList<FjFlInfo>();
		try {
			
			// 重点项目所属区域查询语句
			String sql = "select COUNT(*) as pnum, SUM(p.ztz) as ztz,SUM(dnljdwhj) as dnljdwhj , " +
					" SUM(nczbywc) as nczbywc,SUM(jhtz) as jhtz ,avg(wcndjh) as wcndjh,lb" +
					" from tb_zd_project p,tb_zd_month m " +
					" where p.id=m.pid and m.yf="+jsyf+" and p.sfscx = '是' and nd="+nd+" GROUP BY lb";
			
			System.out.println(sql);
			stat = conn.prepareStatement(sql);
			// 获取查询结果
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				FjFlInfo info1 = new FjFlInfo();
				
				
				info1.setLb(rs.getString("lb"));
				info1.setJhtz(rs.getLong("jhtz"));
				info1.setPnum(rs.getLong("pnum"));
				info1.setNczbywc(rs.getLong("nczbywc"));
				info1.setZtz(rs.getLong("ztz"));
				info1.setWcbl(info1.getNczbywc()*100d/info1.getJhtz());
				info1.setDnljdwhj(rs.getLong("dnljdwhj"));
				info1.setDwwcbl( Double.valueOf( info1.getDnljdwhj()*100 ) / Double.valueOf( info1.getJhtz() ));
				infoList1.add(info1);
			}
			
			//如果开始月份不等于1，则需要将之前的统计删除
			if(!ksyf.equals("1") && infoList1.size()>0){
				// 重点项目所属区域查询语句
				sql = "select COUNT(*) as pnum, SUM(p.ztz) as ztz,SUM(dnljdwhj) as dnljdwhj , " +
				" SUM(nczbywc) as nczbywc,SUM(jhtz) as jhtz ,avg(wcndjh) as wcndjh,lb" +
				" from tb_zd_project p,tb_zd_month m " +
				" where p.id=m.pid and m.yf="+(Integer.parseInt(ksyf)-1)+" and p.sfscx = '是' and nd="+nd+" GROUP BY lb";
				
				// 获取查询结果
				rs = stat.executeQuery(sql);
				List<Long> nczbywcList = new ArrayList<Long>();
				List<Long> dnljdwhjList = new ArrayList<Long>();
				while(rs.next()){
					Long temp =rs.getLong("nczbywc");
					nczbywcList.add(temp);
					Long temp1 =rs.getLong("dnljdwhj");
					dnljdwhjList.add(temp1);
				}
				
				for(int i=0; i<nczbywcList.size(); i++){
					infoList1.get(i).setNczbywc((infoList1.get(i).getNczbywc()-nczbywcList.get(i))); 
					infoList1.get(i).setWcbl((Double.valueOf(infoList1.get(i).getNczbywc())/infoList1.get(i).getJhtz())*100d);
					infoList1.get(i).setDnljdwhj((infoList1.get(i).getDnljdwhj()-dnljdwhjList.get(i))); 
					infoList1.get(i).setDwwcbl((Double.valueOf(infoList1.get(i).getDnljdwhj())/infoList1.get(i).getJhtz())*100d);

				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放连接
			DBHelper.closeDB(conn, stat, rs);
		}	
		
		return infoList1;
	}


	/**
	 * 更改对象
	 * @param item
	 * @return
	 */
	public static boolean update(ProZdxm item){
		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		String sql = "update tb_zd_project set nd=?,bh=?,mc=?,dq=?,lb=?,lb1=?,lb2=?,jsdq=?,jsdd=?,jsgm=?,"
			+"kgn=?,kgy=?,bawh=?,jsnx1=?,jsnx2=?,ztz=?,wctz=?,jzqk=?,jhtz=?,tz1=?,tz2=?,tz3=?,tz4=?,tz5=?,tz6=?,tz7=?,"
			+"tz8=?,tz9=?,tz10=?,tz11=?,tz12=?,gcjd=?,dwmc=?,zrr=?,gldw=?,zjppzc=?,zjppdk=?,zjppzf=?,tzztxz=?,sfkg=?,"
			+"kgyf=?,cz=?,ss=?,jy=?,zd=?,nyd=?,nt=?,ld=?,sgyy=?,hgyp=?,yhdk=?,sfscx=?,sfzz=?,sfss=?,sfzy=?,sfsjs=?,sjslb=? where id=?";
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
   			stat.setLong(58, item.getId());
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
   			stat.setString(59, "已审核");
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
	    String sql = "delete from tb_zd_project where ";
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
	public static ProZdxm getObjById(Long id){
		
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
				item.setLb(rs.getString("lb"));
				item.setLb1(rs.getString("lb1"));
				item.setLb2(rs.getString("lb2"));
				item.setBawh(rs.getString("bawh"));
				item.setJsnx1(rs.getInt("jsnx1"));
				item.setJsnx2(rs.getInt("jsnx2"));
				item.setWctz(rs.getLong("wctz"));
				item.setJzqk(rs.getString("jzqk"));
				item.setBawh(rs.getString("bawh"));
				item.setJhtz(rs.getLong("jhtz"));
				item.setTz1(rs.getLong("tz1"));
				item.setTz2(rs.getLong("tz2"));
				item.setTz3(rs.getLong("tz3"));
				item.setTz4(rs.getLong("tz4"));
				item.setTz5(rs.getLong("tz5"));
				item.setTz6(rs.getLong("tz6"));
				item.setTz7(rs.getLong("tz7"));
				item.setTz8(rs.getLong("tz8"));
				item.setTz9(rs.getLong("tz9"));
				item.setTz10(rs.getLong("tz10"));
				item.setTz11(rs.getLong("tz11"));
				item.setTz12(rs.getLong("tz12"));
				item.setGcjd(rs.getString("gcjd"));
				item.setDwmc(rs.getString("dwmc"));
				item.setZrr(rs.getString("zrr"));
				item.setGldw(rs.getString("gldw"));
				item.setZjppzc(rs.getLong("zjppzc"));
				item.setZjppdk(rs.getLong("zjppdk"));
				item.setZjppzf(rs.getLong("zjppzf"));
				item.setTzztxz(rs.getString("tzztxz"));
				item.setSfkg(rs.getString("sfkg"));
				item.setKgyf(rs.getString("kgyf"));
				item.setCz(rs.getLong("cz"));
				item.setSs(rs.getLong("ss"));
				item.setJy(rs.getInt("jy"));
				item.setZd(rs.getLong("zd"));
				item.setNyd(rs.getLong("nyd"));
				item.setNt(rs.getLong("nt"));
				item.setLd(rs.getLong("ld"));
				item.setSgyy(rs.getLong("sgyy"));
				item.setHgyp(rs.getLong("hgyp"));
				item.setYhdk(rs.getLong("yhdk"));
				item.setSfscx(rs.getString("sfscx"));
				item.setSfzy(rs.getString("sfzy"));
				item.setSfzz(rs.getString("sfzz"));
				item.setSfss(rs.getString("sfss"));
				item.setSfsjs(rs.getString("sfsjs"));
				item.setSjslb(rs.getString("sjslb"));
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
	 * 得到分页数据类
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static Pager getObjForPage(int pageNo, int pageSize, String lb, String nd, String searchStr){
		
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
        	tempSql += " and mc like '%"+searchStr+"%' "; 	
		}
		int count=0;
		try {
			//TODO 添加分页统计条件 修改表名
			String countsql = "select count(*) as num  from tb_zd_project where zt='已审核' "+tempSql;
			stat = conn.prepareStatement(countsql);	
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count = rs.getInt("num");
			}

			//TODO 添加分页条件 修改表名
			String sql = "select * from tb_zd_project where zt='已审核' "+tempSql+" order by bh asc, id desc limit "
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
				item.setJhtz(rs.getLong("jhtz"));
				item.setJsnx1(rs.getInt("jsnx1"));
				item.setJsnx2(rs.getInt("jsnx2"));
				item.setJsdd(rs.getString("jsdd"));
				item.setZtz(rs.getLong("ztz"));
				item.setZt(rs.getString("zt"));
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
	 * 获取类别列表
	 * @return String data
	 */
	public static String getLbList(){
		// 获取数据库连接
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		// 构造json格式数据对象
        String data = "";
		try {
			// 重点项目所属类别查询语句
			String sql = "select * from tb_industry where lx='zd' order by px asc  ";
			stat = conn.prepareStatement(sql);
			// 获取查询结果
			rs = stat.executeQuery(sql);	
			while(rs.next()){
                data += "{pid:'"+rs.getLong("pid")+"',";
                data += " id:'"+rs.getLong("id")+"',";
                data += " mc:'"+rs.getString("mc")+"'},";
			}
			// 如果获取的类别不为空
			if(FavoritesHelper.isNotNull(data)){
				data = data.substring(0,data.length()-1);
			}
			data = "["+data+"]";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放连接
			DBHelper.closeDB(conn, stat, rs);
		}
		return data;
		
	}

	/**
	 * 获取地区名称列表
	 * @return List<String> itemlist
	 */
	public static List<String> getDqList(){
		// 地区名称列表集合
		List<String> itemlist = new ArrayList<String>() ;
		// 获取连接
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		try {
			// 重点项目所属地区查询语句
			String sql = "select * from tb_area where lx='zd' order by px asc  ";
			stat = conn.prepareStatement(sql);	
			// 获取查询结果
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				itemlist.add(rs.getString("mc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放连接
			DBHelper.closeDB(conn, stat, rs);
		}
		return itemlist;
	}
	
	/**
	 * 获取类别名称列表
	 * @return List<String> itemlist
	 */
	public static List<String> getLb1List(){
		// 地区名称列表集合
		List<String> itemlist = new ArrayList<String>() ;
		// 获取连接
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		try {
			// 重点项目所属地区查询语句
			String sql = "select * from tb_industry where lx='zd' and pid =0 order by px asc  ";
			stat = conn.prepareStatement(sql);	
			// 获取查询结果
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				itemlist.add(rs.getString("mc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放连接
			DBHelper.closeDB(conn, stat, rs);
		}
		return itemlist;
	}
	/**
	 * 获取产业列表
	 * 
	 */
	public  static List<String> getCyList(){
		// 地区名称列表集合
		List<String> itemlist = new ArrayList<String>() ;
		// 获取连接
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		try {
			// 重点项目所属地区查询语句
			String sql = "select distinct mc from tb_chanye ";
			stat = conn.prepareStatement(sql);	
			// 获取查询结果
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				itemlist.add(rs.getString("mc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放连接
			DBHelper.closeDB(conn, stat, rs);
		}
		return itemlist;
		
		
	}
	
	/**
	 * 得到审核分页数据类
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static Pager getObjForAudit(int pageNo, int pageSize,String lb, String nd, String searchStr){
		
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
        	tempSql += " and mc like '%"+searchStr+"%' "; 	
		}
		
		int count=0;
		try {
			//TODO 添加分页统计条件 修改表名
			String countsql = "select count(*) as num    from tb_zd_project where zt='已上报' "+tempSql;
			stat = conn.prepareStatement(countsql);	
			
			rs=stat.executeQuery(countsql);
			
			if(rs.next()){
				count = rs.getInt("num");
			}

			//TODO 添加分页条件 修改表名
			String sql = "select * from tb_zd_project where zt='已上报'  "+tempSql+" order by bh asc, id desc limit "
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
				item.setJhtz(rs.getLong("jhtz"));
				item.setJsnx1(rs.getInt("jsnx1"));
				item.setJsnx2(rs.getInt("jsnx2"));
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
	

	/**
	 * 项目信息审核
	 * @param id 	项目主键
	 * @param zt	审核状态
	 * @param shyj  审核意见
	 * @return Boolean isOk
	 */
	public static boolean audit(String id, String zt, String shyj) {
		boolean isOk = false;  // 是否操作成功
		Connection conn = DBHelper.getConnection();  // 获取连接
		PreparedStatement stat = null;
		// 修改语句
		String sql = "update tb_zd_project set zt='" + zt + "'" + " , shyj='"
				+ shyj + "'" + " where id=?";
		try {
			stat = conn.prepareStatement(sql);
			stat.setLong(1, Long.valueOf(id));
			if (stat.executeUpdate() > 0) {
				isOk = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat);
		}
		return isOk;
	}

	/**
	 * 获取重点项目信息汇总
	 * @param nd   年度
	 * @param lb1     类别：大类
	 * @return List<ProZdxm> itemlist 
	 */
	public static List<ProZdxm> showZjdwList(String nd, String lb1, String lb2,
			String dq, String ztz1, String ztz1num, String ztz2,
			String ztz2num, String wctz1, String wctz1num, String wctz2,
			String wctz2num, String jhtz1, String jhtz1num, String jhtz2,
			String jhtz2num, String sfscx, String sfzz,String sfss, String sfzy, String sjslb, String tzztxz) {
		// 重点项目信息列表
		List<ProZdxm> itemlist = new ArrayList<ProZdxm>() ;
		// 获取数据库连接
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		// 构建查询语句条件
		String tempSql = "";
		
		if(nd != null && !nd.equals("")){		// 年度
			tempSql += " and nd ="+nd;	
		}

		if(lb1 != null && !lb1.equals("")){		// 类别：大类
			tempSql += " and lb1 ='"+lb1+"'";	
		}
		
		if(lb2 != null && !lb2.equals("")){		// 类别：小类
			tempSql += " and lb2 ='"+lb2+"'";	
		}
		
		if(dq != null && !dq.equals("")){		// 所属地区
			tempSql += " and dq ='"+dq+"'";	
		}
		
		//总投资
		if(ztz1 != null && !ztz1.equals("")){	 // 判断符（全部、大于等于、等于）
			if("".equals(ztz1num)){	// 如果数值1为空，则取0
				ztz1num = "0";
			}
			tempSql +=  " and ztz " + ztz1 + ztz1num;	
		}
		
		if(ztz2 != null && !ztz2.equals("")){	// 判断符（全部、小于）
			if("".equals(ztz2num)){	// 如果数值2为空，则取0
				ztz2num = "0";
			}
			tempSql += " and ztz " + ztz2 + ztz2num;
		}
		//完成投资
		if(wctz1 != null && !wctz1.equals("")){	 // 判断符（全部、大于等于、等于）
			if("".equals(wctz1num)){	// 如果数值1为空，则取0
				wctz1num = "0";
			}
			tempSql +=  " and wctz " + wctz1 + wctz1num;	
		}
		
		if(wctz2 != null && !wctz2.equals("")){	// 判断符（全部、小于）
			if("".equals(wctz2num)){	// 如果数值2为空，则取0
				wctz2num = "0";
			}
			tempSql += " and wczt " + wctz2 + wctz2num;
		}
		//计划投资
		if(jhtz1 != null && !jhtz1.equals("")){	 // 判断符（全部、大于等于、等于）
			if("".equals(jhtz1num)){	// 如果数值1为空，则取0
				jhtz1num = "0";
			}
			tempSql +=  " and jhtz " + jhtz1 + jhtz1num;	
		}
		
		if(jhtz2 != null && !jhtz2.equals("")){	// 判断符（全部、小于）
			if("".equals(jhtz2num)){	// 如果数值2为空，则取0
				jhtz2num = "0";
			}
			tempSql += " and jhtz " + jhtz2 + jhtz2num;
		}
		
		if(sfscx != null && !sfscx.equals("")){		// 是否生产性
			tempSql += " and sfscx ='"+sfscx+"'";	
		}
		
		if(sfzz != null && !sfzz.equals("")){		// 是否重中之重
			tempSql += " and sfzz ='"+sfzz+"'";	
		}
		
		if(sfss != null && !sfss.equals("")){		// 是否省项目
			tempSql += " and sfss ='"+sfss+"'";	
		}
		
		if(sfzy != null && !sfzy.equals("")){		// 是否资源
			tempSql += " and sfzy ='"+sfzy+"'";	
		}
		
		if(sjslb != null && !sjslb.equals("")){		// 10+3类别
			tempSql += " and sjslb ='"+sjslb+"'";	
		}
		
		if(tzztxz != null && !tzztxz.equals("")){		// 投资主体性质
			tempSql += " and tzztxz ='"+tzztxz+"'";	
		}
		
		// 替换判断符号
		tempSql = tempSql.replaceAll("dydy", ">=").replaceAll("dy", "=").replaceAll("xy", "<");
		// 构建查询语句
		String sql = "select * from tb_zd_project where zt = '已审核' "+tempSql+" order by bh asc";
		//　获取查询结果
		try {
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
				item.setKgn(rs.getString("kgn"));
				item.setKgy(rs.getString("kgy"));
				item.setLb(rs.getString("lb"));
				item.setLb1(rs.getString("lb1"));
				item.setLb2(rs.getString("lb2"));
				item.setBawh(rs.getString("bawh"));
				item.setJsnx1(rs.getInt("jsnx1"));
				item.setJsnx2(rs.getInt("jsnx2"));
				item.setWctz(rs.getLong("wctz"));
				item.setJzqk(rs.getString("jzqk"));
				item.setBawh(rs.getString("bawh"));
				item.setJhtz(rs.getLong("jhtz"));
				item.setTz1(rs.getLong("tz1"));
				item.setTz2(rs.getLong("tz2"));
				item.setTz3(rs.getLong("tz3"));
				item.setTz4(rs.getLong("tz4"));
				item.setTz5(rs.getLong("tz5"));
				item.setTz6(rs.getLong("tz6"));
				item.setTz7(rs.getLong("tz7"));
				item.setTz8(rs.getLong("tz8"));
				item.setTz9(rs.getLong("tz9"));
				item.setTz10(rs.getLong("tz10"));
				item.setTz11(rs.getLong("tz11"));
				item.setTz12(rs.getLong("tz12"));
				item.setGcjd(rs.getString("gcjd"));
				item.setDwmc(rs.getString("dwmc"));
				item.setZrr(rs.getString("zrr"));
				item.setGldw(rs.getString("gldw"));
				item.setZjppzc(rs.getLong("zjppzc"));
				item.setZjppdk(rs.getLong("zjppdk"));
				item.setZjppzf(rs.getLong("zjppzf"));
				item.setTzztxz(rs.getString("tzztxz"));
				item.setSfkg(rs.getString("sfkg"));
				item.setKgyf(rs.getString("kgyf"));
				item.setCz(rs.getLong("cz"));
				item.setSs(rs.getLong("ss"));
				item.setJy(rs.getInt("jy"));
				item.setZd(rs.getLong("zd"));
				item.setNyd(rs.getLong("nyd"));
				item.setNt(rs.getLong("nt"));
				item.setLd(rs.getLong("ld"));
				item.setSgyy(rs.getLong("sgyy"));
				item.setHgyp(rs.getLong("hgyp"));
				item.setYhdk(rs.getLong("yhdk"));
				item.setSfscx(rs.getString("sfscx"));
				item.setSfzy(rs.getString("sfzy"));
				item.setSfzz(rs.getString("sfzz"));
				item.setSfss(rs.getString("sfss"));
				item.setSfsjs(rs.getString("sfsjs"));
				item.setSjslb(rs.getString("sjslb"));
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
	

	/**
	 * 获取重点项目信息汇总
	 * @param nd   年度
	 * @param lb1     类别：大类
	 * @param lb2     类别：小类
	 * @param dq   所属地区
	 * @param ztz1  判断符（全部、大于等于、等于）-- 总投资
	 * @param ztz1num 数值1
	 * @param ztz2  判断符（全部、小于）
	 * @param ztz2num 数值2
	 * @param wctz1 判断符（全部、大于等于、等于）-- 完成投资
	 * @param wctz1num 数值1
	 * @param wctz2   判断符（全部、小于）
	 * @param wctz2num 数值2
	 * @param jhtz1 判断符（全部、大于等于、等于）-- 计划投资
	 * @param jhtz1num 数值1
	 * @param jhtz2  判断符（全部、小于）
	 * @param jhtz2num 数值2 
	 * @param sfscx  是否生产性
	 * @param sfzz  是否重中之重
	 * @param sfss  是否省项目
	 * @param sfzy  是否资源
	 * @param sjslb 10+3类别
	 * @param tzztxz 投资主体性质
	 * @param kgFromNd 项目开工年份（开始）
	 * @param kgToNd 项目开工年份（结束）
	 * @param kgFromMonth 项目开工月份（开始）
	 * @param kgToMonth 项目开工月份（结束）
	 * @return List<ProZdxm> itemlist 
	 */
	public static List<ProZdxm> showXxhzList(String nd, String lb1, String lb2,
			String dq, String ztz1, String ztz1num, String ztz2,
			String ztz2num, String wctz1, String wctz1num, String wctz2,
			String wctz2num, String jhtz1, String jhtz1num, String jhtz2,
			String jhtz2num, String sfscx, String sfzz,String sfss, String sfzy, String sjslb,
			String tzztxz,String kgFromNd, String kgToNd, String kgFromMonth, String kgToMonth) {
		// 重点项目信息列表
		List<ProZdxm> itemlist = new ArrayList<ProZdxm>() ;
		// 获取数据库连接
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		// 构建查询语句条件
		String tempSql = "";
		
		if(nd != null && !nd.equals("")){		// 年度
			tempSql += " and nd ="+nd;	
		}

		if(lb1 != null && !lb1.equals("")){		// 类别：大类
			tempSql += " and lb1 ='"+lb1+"'";	
		}
		
		if(lb2 != null && !lb2.equals("")){		// 类别：小类
			tempSql += " and lb2 ='"+lb2+"'";	
		}
		
		if(dq != null && !dq.equals("")){		// 所属地区
			tempSql += " and dq ='"+dq+"'";	
		}
		
		//总投资
		if(ztz1 != null && !ztz1.equals("")){	 // 判断符（全部、大于等于、等于）
			if("".equals(ztz1num)){	// 如果数值1为空，则取0
				ztz1num = "0";
			}
			tempSql +=  " and ztz " + ztz1 + ztz1num;	
		}
		
		if(ztz2 != null && !ztz2.equals("")){	// 判断符（全部、小于）
			if("".equals(ztz2num)){	// 如果数值2为空，则取0
				ztz2num = "0";
			}
			tempSql += " and ztz " + ztz2 + ztz2num;
		}
		//完成投资
		if(wctz1 != null && !wctz1.equals("")){	 // 判断符（全部、大于等于、等于）
			if("".equals(wctz1num)){	// 如果数值1为空，则取0
				wctz1num = "0";
			}
			tempSql +=  " and wctz " + wctz1 + wctz1num;	
		}
		
		if(wctz2 != null && !wctz2.equals("")){	// 判断符（全部、小于）
			if("".equals(wctz2num)){	// 如果数值2为空，则取0
				wctz2num = "0";
			}
			tempSql += " and wczt " + wctz2 + wctz2num;
		}
		//计划投资
		if(jhtz1 != null && !jhtz1.equals("")){	 // 判断符（全部、大于等于、等于）
			if("".equals(jhtz1num)){	// 如果数值1为空，则取0
				jhtz1num = "0";
			}
			tempSql +=  " and jhtz " + jhtz1 + jhtz1num;	
		}
		
		if(jhtz2 != null && !jhtz2.equals("")){	// 判断符（全部、小于）
			if("".equals(jhtz2num)){	// 如果数值2为空，则取0
				jhtz2num = "0";
			}
			tempSql += " and jhtz " + jhtz2 + jhtz2num;
		}
		
		if(sfscx != null && !sfscx.equals("")){		// 是否生产性
			tempSql += " and sfscx ='"+sfscx+"'";	
		}
		
		if(sfzz != null && !sfzz.equals("")){		// 是否重中之重
			tempSql += " and sfzz ='"+sfzz+"'";	
		}
		
		if(sfss != null && !sfss.equals("")){		// 是否省项目
			tempSql += " and sfss ='"+sfss+"'";	
		}
		
		if(sfzy != null && !sfzy.equals("")){		// 是否资源
			tempSql += " and sfzy ='"+sfzy+"'";	
		}
		
		if(sjslb != null && !sjslb.equals("")){		// 10+3类别
			tempSql += " and sjslb ='"+sjslb+"'";	
		}
		
		if(tzztxz != null && !tzztxz.equals("")){		// 投资主体性质
			tempSql += " and tzztxz ='"+tzztxz+"'";	
		}
		
		if(kgFromNd != null && !kgFromNd.equals("")){		// 项目开工年份（开始）
			tempSql += " and kgn >='"+kgFromNd+"'";	
		}
		
		if(kgToNd != null && !kgToNd.equals("")){		// 项目开工年份（结束）
			tempSql += " and kgn <='"+kgToNd+"'";	
		}
		
		if(kgFromMonth != null && !kgFromMonth.equals("")){		// 项目开工月份（开始）
			tempSql += " and kgy >='"+kgFromMonth+"'";	
		}
		
		if(kgToMonth != null && !kgToMonth.equals("")){		// 项目开工月份（结束）
			tempSql += " and kgy <='"+kgToMonth+"'";	
		}
		
		// 替换判断符号
		tempSql = tempSql.replaceAll("dydy", ">=").replaceAll("dy", "=").replaceAll("xy", "<");
		// 构建查询语句
		String sql = "select * from tb_zd_project where zt = '已审核' "+tempSql+" order by bh asc";
		//　获取查询结果
		try {
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
				item.setJsdq(rs.getString("jsdq"));
				item.setZtz(rs.getLong("ztz"));
				item.setKgn(rs.getString("kgn"));
				item.setKgy(rs.getString("kgy"));
				item.setLb(rs.getString("lb"));
				item.setLb1(rs.getString("lb1"));
				item.setLb2(rs.getString("lb2"));
				item.setBawh(rs.getString("bawh"));
				item.setJsnx1(rs.getInt("jsnx1"));
				item.setJsnx2(rs.getInt("jsnx2"));
				item.setWctz(rs.getLong("wctz"));
				item.setJzqk(rs.getString("jzqk"));
				item.setBawh(rs.getString("bawh"));
				item.setJhtz(rs.getLong("jhtz"));
				item.setTz1(rs.getLong("tz1"));
				item.setTz2(rs.getLong("tz2"));
				item.setTz3(rs.getLong("tz3"));
				item.setTz4(rs.getLong("tz4"));
				item.setTz5(rs.getLong("tz5"));
				item.setTz6(rs.getLong("tz6"));
				item.setTz7(rs.getLong("tz7"));
				item.setTz8(rs.getLong("tz8"));
				item.setTz9(rs.getLong("tz9"));
				item.setTz10(rs.getLong("tz10"));
				item.setTz11(rs.getLong("tz11"));
				item.setTz12(rs.getLong("tz12"));
				item.setGcjd(rs.getString("gcjd"));
				item.setDwmc(rs.getString("dwmc"));
				item.setZrr(rs.getString("zrr"));
				item.setGldw(rs.getString("gldw"));
				item.setZjppzc(rs.getLong("zjppzc"));
				item.setZjppdk(rs.getLong("zjppdk"));
				item.setZjppzf(rs.getLong("zjppzf"));
				item.setTzztxz(rs.getString("tzztxz"));
				item.setSfkg(rs.getString("sfkg"));
				item.setKgyf(rs.getString("kgyf"));
				item.setCz(rs.getFloat("cz"));
				item.setSs(rs.getFloat("ss"));
				item.setJy(rs.getInt("jy"));
				item.setZd(rs.getFloat("zd"));
				item.setNyd(rs.getFloat("nyd"));
				item.setNt(rs.getFloat("nt"));
				item.setLd(rs.getFloat("ld"));
				item.setSgyy(rs.getFloat("sgyy"));
				item.setHgyp(rs.getFloat("hgyp"));
				item.setYhdk(rs.getFloat("yhdk"));
				item.setSfscx(rs.getString("sfscx"));
				item.setSfzy(rs.getString("sfzy"));
				item.setSfzz(rs.getString("sfzz"));
				item.setSfss(rs.getString("sfss"));
				item.setSfsjs(rs.getString("sfsjs"));
				item.setSjslb(rs.getString("sjslb"));
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
	
	
	

	/**
	 * 获取分类汇总统计信息
	 * @param fromDate 开始日期
	 * @param toDate  结束日期
	 * @return  Map<String, List<String>> sortInfoMap
	 */
	public static Map<String, List<String>> getSortInfoMap(String fromDate, String toDate) {
		// 分类统计信息集合（key:类别名称，value:类别所对应的项目总数、总投资、完成投资）
		Map<String, List<String>> sortInfoMap = new HashMap<String, List<String>>();
		// 类别大类
		List<ProIndustry> sortList = getBigLbList();
		//　遍历类别，根据类别名称和日期查询各类别下的各项目的总数、总投资、完成投资
		if (sortList != null) { 
			for (int i = 0; i < sortList.size(); i++) {
				List<String> countList = new ArrayList<String>(); // 统计信息
				ProIndustry industry = sortList.get(i); // 类别对象
				String sortName = industry.getMc();	// 类别的名称
				// 项目信息查询语句
				String countSql = "select count(*) as num,sum(t.ztz) as num2,sum(t.wctz) as num3 from tb_zd_project t where t.lb1 = '"+ sortName +"'"; 
				if(!"".equals(fromDate) && null != fromDate){ // 如果开始日期不为空
					//countSql += " and t.bssj >= '"+ fromDate +"'";
				}
				if(!"".equals(toDate) && null != toDate){ // 如果结束日期不为空
					//countSql += " and t.bssj <= '"+ toDate +"'";
				}
				// 获取数据库连接
				Connection conn = DBHelper.getConnection();
				PreparedStatement stat = null;
				ResultSet rs = null;
				try {
					// 查询项目总数
					stat = conn.prepareStatement(countSql);	
					rs = stat.executeQuery(countSql);	
					while(rs.next()){
						countList.add(rs.getInt("num")+"");
						countList.add(rs.getInt("num2")+"");
						countList.add(rs.getInt("num3")+"");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {  // 释放连接
					DBHelper.closeDB(conn, stat, rs);
				}
				// 添加分类信息
				sortInfoMap.put(sortName, countList);
			}
		}
		return sortInfoMap;
	}
	
	/**
	 * 获取类别信息中的大类  add by lhanliang
	 * 
	 * @return List<ProIndustry> bigLbList
	 */
	public static List<ProIndustry> getBigLbList() {
		// 大类list集合
		List<ProIndustry> bigLbList = new ArrayList<ProIndustry>();
		// 获取数据库连接
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "select * from tb_industry where lx='zd' and pid=0 order by px desc  ";
		//　获取查询结果
		try {
			stat = conn.prepareStatement(sql);	
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				// 构建类别的实体对象
				ProIndustry item = new ProIndustry();

				item.setId(rs.getLong("id"));  // 主键
				item.setPid(rs.getLong("pid")); // 父类主键
				item.setMc(rs.getString("mc")); // 名称
				item.setPx(rs.getLong("px"));  // 排序号
				item.setLx(rs.getString("lx"));  // 类型
				
				bigLbList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return bigLbList;

	}


	/**
	 * 获取到位资金情况汇总
	 * @param nd
	 * @param fromMonth
	 * @param toMonth
	 * @return
	 */
	public static List<ProZdxmYb> showZjdwqkList(String nd, String fromMonth, String toMonth){
		return showYbxxhzList(nd, fromMonth, toMonth, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
	}
	/**
	 * 获取重点项目信息汇总
	 * @param nd   年度
	 * @param fromMonth 开始月份
	 * @param toMonth  结束月份
	 * @param lb1     类别：大类
	 * @param lb2     类别：小类
	 * @param dq   所属地区
	 * @param ztz1  判断符（全部、大于等于、等于）-- 总投资
	 * @param ztz1num 数值1
	 * @param ztz2  判断符（全部、小于）
	 * @param ztz2num 数值2
	 * @param wctz1 判断符（全部、大于等于、等于）-- 完成投资
	 * @param wctz1num 数值1
	 * @param wctz2   判断符（全部、小于）
	 * @param wctz2num 数值2
	 * @param jhtz1 判断符（全部、大于等于、等于）-- 计划投资
	 * @param jhtz1num 数值1
	 * @param jhtz2  判断符（全部、小于）
	 * @param jhtz2num 数值2 
	 * @param wcjhtz1 判断符（全部、大于等于、等于）-- 完成计划投资
	 * @param wcjhtz1num 数值1
	 * @param wcjhtz2  判断符（全部、小于）
	 * @param wcjhtz2num 数值2 
	 * @param sfscx  是否生产性
	 * @param sfzz  是否重中之重
	 * @param sfss  是否省项目
	 * @param sfzy  是否资源
	 * @param sjslb 10+3类别
	 * @param tzztxz 投资主体性质
	 * @param kgFromNd 项目开工年份（开始）
	 * @param kgToNd 项目开工年份（结束）
	 * @param kgFromMonth 项目开工月份（开始）
	 * @param kgToMonth 项目开工月份（结束）
	 * @return
	 */
	public static List<ProZdxmYb> showYbxxhzList(String nd, String fromMonth, String toMonth, String lb1,
			String lb2, String dq, String ztz1, String ztz1num, String ztz2,
			String ztz2num, String wctz1, String wctz1num, String wctz2,
			String wctz2num, String jhtz1, String jhtz1num, String jhtz2,
			String jhtz2num, String wcjhtz1, String wcjhtz1num, String wcjhtz2,
			String wcjhtz2num, String sfscx, String sfzz, String sfss,
			String sfzy, String sjslb, String tzztxz,String kgFromNd, String kgToNd, String kgFromMonth, String kgToMonth) {
		
		// 构建查询语句条件
		String tempSql = "";
		// 完成计划投资比例
		String wctzSql = "";
		
		if(nd != null && !nd.equals("")){		// 年度
			tempSql += " and p.nd ="+nd;	
		}

		if(lb1 != null && !lb1.equals("")){		// 类别：大类
			tempSql += " and p.lb1 ='"+lb1+"'";	
		}
		
		if(lb2 != null && !lb2.equals("")){		// 类别：小类
			tempSql += " and p.lb2 ='"+lb2+"'";	
		}
		
		if(dq != null && !dq.equals("")){		// 所属地区
			tempSql += " and p.dq ='"+dq+"'";	
		}
		
		//总投资
		if(ztz1 != null && !ztz1.equals("")){	 // 判断符（全部、大于等于、等于）
			if("".equals(ztz1num)){	// 如果数值1为空，则取0
				ztz1num = "0";
			}
			tempSql +=  " and p.ztz " + ztz1 + ztz1num;	
		}
		
		if(ztz2 != null && !ztz2.equals("")){	// 判断符（全部、小于）
			if("".equals(ztz2num)){	// 如果数值2为空，则取0
				ztz2num = "0";
			}
			tempSql += " and p.ztz " + ztz2 + ztz2num;
		}
		//完成投资
		if(wctz1 != null && !wctz1.equals("")){	 // 判断符（全部、大于等于、等于）
			if("".equals(wctz1num)){	// 如果数值1为空，则取0
				wctz1num = "0";
			}
			tempSql +=  " and p.wctz " + wctz1 + wctz1num;	
		}
		
		if(wctz2 != null && !wctz2.equals("")){	// 判断符（全部、小于）
			if("".equals(wctz2num)){	// 如果数值2为空，则取0
				wctz2num = "0";
			}
			tempSql += " and p.wctz " + wctz2 + wctz2num;
		}
		//计划投资
		if(jhtz1 != null && !jhtz1.equals("")){	 // 判断符（全部、大于等于、等于）
			if("".equals(jhtz1num)){	// 如果数值1为空，则取0
				jhtz1num = "0";
			}
			tempSql +=  " and p.jhtz " + jhtz1 + jhtz1num;	
		}
		
		if(jhtz2 != null && !jhtz2.equals("")){	// 判断符（全部、小于）
			if("".equals(jhtz2num)){	// 如果数值2为空，则取0
				jhtz2num = "0";
			}
			tempSql += " and p.jhtz " + jhtz2 + jhtz2num;
		}
		// 完成计划投资比例
		if(wcjhtz1 != null && !wcjhtz1.equals("")){	 // 判断符（全部、大于等于、等于）
			if("".equals(wcjhtz1num)){	// 如果数值1为空，则取0
				wcjhtz1num = "0";
			}else {
				wcjhtz1num = String.valueOf((Double.parseDouble(wcjhtz1num))/100);
			}
			wctzSql +=  " and t.dnwctzbl " + wcjhtz1 + wcjhtz1num;	
		}
		
		if(wcjhtz2 != null && !wcjhtz2.equals("")){	// 判断符（全部、小于）
			if("".equals(wcjhtz2num)){	// 如果数值2为空，则取0
				wcjhtz2num = "0";
			}else {
				wcjhtz2num = String.valueOf((Double.parseDouble(wcjhtz2num))/100);
			}
			wctzSql += " and t.dnwctzbl " + wcjhtz2 + wcjhtz2num;
		}
		
		if(sfscx != null && !sfscx.equals("")){		// 是否生产性
			tempSql += " and p.sfscx ='"+sfscx+"'";	
		}
		
		if(sfzz != null && !sfzz.equals("")){		// 是否重中之重
			tempSql += " and p.sfzz ='"+sfzz+"'";	
		}
		
		if(sfss != null && !sfss.equals("")){		// 是否省项目
			tempSql += " and p.sfss ='"+sfss+"'";	
		}
		
		if(sfzy != null && !sfzy.equals("")){		// 是否资源
			tempSql += " and p.sfzy ='"+sfzy+"'";	
		}
		
		if(sjslb != null && !sjslb.equals("")){		// 10+3类别
			tempSql += " and p.sjslb ='"+sjslb+"'";	
		}
		
		if(tzztxz != null && !tzztxz.equals("")){		// 投资主体性质
			tempSql += " and p.tzztxz ='"+tzztxz+"'";	
		}

		if(kgFromNd != null && !kgFromNd.equals("")){		// 项目开工年份（开始）
			tempSql += " and p.kgn >='"+kgFromNd+"'";	
		}
		
		if(kgToNd != null && !kgToNd.equals("")){		// 项目开工年份（结束）
			tempSql += " and p.kgn <='"+kgToNd+"'";	
		}
		
		if(kgFromMonth != null && !kgFromMonth.equals("")){		// 项目开工月份（开始）
			tempSql += " and p.kgy >='"+kgFromMonth+"'";	
		}
		
		if(kgToMonth != null && !kgToMonth.equals("")){		// 项目开工月份（结束）
			tempSql += " and p.kgy <='"+kgToMonth+"'";	
		}
		// 构建查询语句
		String sql = "SELECT\n" +
					"	p.id,\n" +
					"	p.nd,\n" +
					"	p.mc,\n" +
					"	p.ztz,\n" +
					"	p.wctz,\n" +
					"	p.jhtz,\n" +
					"	max(m.nczbywc)AS nczbywc,\n" +
//					"	max(m.dnljdwhj)AS dnljdwhj,\n" +
					"	(max(m.dnljdw1)+max(m.dnljdw2)+max(m.dnljdw3))AS dnljdwhj,\n" +
					"	p.wctz + max(m.nczbywc)AS kgljwc,\n" +
//					"	max(m.kgljdwhj)AS kgljdwhj,\n" +
					"	(max(m.kgljdw1)+max(m.kgljdw2)+max(m.kgljdw3))AS kgljdwhj,\n" +
					"	max(m.nczbywc)/ p.jhtz AS dnwctzbl,\n" +
//					"	max(m.dnljdwhj)/ p.jhtz AS dndwzjbl,\n" +
					"	(max(m.dnljdw1)+max(m.dnljdw2)+max(m.dnljdw3))/ p.jhtz AS dndwzjbl,\n" +
					"	p.lb AS lb,\n" +
					"	p.lb1 AS lb1,\n" +
					"	(p.wctz + max(m.nczbywc))/ p.ztz AS kgwctzbl,\n" +
//					"	max(m.kgljdwhj)/ p.ztz AS kgdwzjbl from tb_zd_project p,\n" +
					"	(max(m.kgljdw1)+max(m.kgljdw2)+max(m.kgljdw3))/ p.ztz AS kgdwzjbl from tb_zd_project p,\n" +
					"	tb_zd_month m\n" +
					" WHERE\n" +
					"	m.pid = p.id and p.zt = '已审核'" + 
					" and m.zt = '已上报'";
		if("1".equals(fromMonth)){ // 如果从1月份开始计算，则直接获取并返回结束月份的数据
			//完成计划投资
			tempSql += " and m.yf<="+ toMonth;
			sql = "select * from ("+ sql + tempSql +" group by m.pid order by p.bh asc) as t where 1=1"+wctzSql;
			// 替换判断符号
			sql = sql.replaceAll("dydy", ">=").replaceAll("dy", "=").replaceAll("xy", "<");
			List<ProZdxmYb> zdxmYbList = getZdxmYbListBySQL(sql);
			return zdxmYbList;
		}else { // 否则返回从1月份到结束月的数据减去从1月份到开始月份的数据
			// 参数条件
			fromMonth = (FavoritesHelper.stringToint(fromMonth)-1)+"";
			String paramSql = tempSql + " and m.yf<="+ fromMonth;
			// 完整的查询语句
			String searchSql = "select * from ("+ sql + paramSql +" group by m.pid order by p.bh asc) as t where 1=1"+wctzSql;
			// 转换判断符号
			searchSql = searchSql.replaceAll("dydy", ">=").replaceAll("dy", "=").replaceAll("xy", "<");
			// 获取数据
			List<ProZdxmYb> fromMonthZdxmYbList = getZdxmYbListBySQL(searchSql);
			// 参数条件
			paramSql = tempSql + " and m.yf<="+ toMonth;
			// 完整的查询语句
			searchSql = "select * from ("+ sql + paramSql +" group by m.pid order by p.bh asc) as t where 1=1"+wctzSql;
			// 转换判断符号
			searchSql = searchSql.replaceAll("dydy", ">=").replaceAll("dy", "=").replaceAll("xy", "<");
			// 获取数据
			List<ProZdxmYb> toMonthZdxmYbList = getZdxmYbListBySQL(searchSql);
			List<ProZdxmYb> zdxmYbList = new ArrayList<ProZdxmYb>();
			// 对应的数值进行相减
			if (FavoritesHelper.isNotNull(fromMonthZdxmYbList)) {
				for (int i = 0; i < fromMonthZdxmYbList.size(); i++) {
					ProZdxmYb zdxmYb = fromMonthZdxmYbList.get(i);
					ProZdxmYb zdxmYb2 = toMonthZdxmYbList.get(i);
					zdxmYb.setNczbywc(zdxmYb2.getNczbywc() - zdxmYb.getNczbywc());	// 当年完成投资
					zdxmYb.setDnwctzbl(FavoritesHelper.twoPointFloat(zdxmYb2.getDnwctzbl() - zdxmYb.getDnwctzbl())); // 完成年度计划投资比例
					zdxmYb.setDnljdwhj(zdxmYb2.getDnljdwhj() - zdxmYb.getDnljdwhj()); // 当年累计到位资金
					zdxmYb.setDndwzjbl(FavoritesHelper.twoPointFloat(zdxmYb2.getDndwzjbl() - zdxmYb.getDndwzjbl())); // 完成年度计划投资比例
					zdxmYb.setKgljwc(zdxmYb2.getKgljwc()); // 开工累计完成投资
					zdxmYb.setKgwctzbl(FavoritesHelper.twoPointFloat(zdxmYb2.getKgwctzbl())); // 开工累计完成占总投资比例
					zdxmYb.setKgljdwhj(zdxmYb2.getKgljdwhj()); // 开工累计到位资金
					zdxmYb.setKgdwzjbl(FavoritesHelper.twoPointFloat(zdxmYb2.getKgdwzjbl())); // 开工累计到位资金占总投资比例
					
					zdxmYbList.add(zdxmYb);
				}
			}
			return zdxmYbList;
		}
	}
	
	public static List<ProZdxmYb> showZyxxjdList(String nd, String fromMonth, String toMonth) {
		return showXxjdhzList(nd, fromMonth, toMonth, null,null,null,null,null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);	}
	/**
	 * 获取重点项目形象进度查询
	 * @param nd   年度
	 * @param fromMonth 开始月份
	 * @param toMonth  结束月份
	 * @param lb1     类别：大类
	 * @param lb2     类别：小类
	 * @param dq   所属地区
	 * @param ztz1  判断符（全部、大于等于、等于）-- 总投资
	 * @param ztz1num 数值1
	 * @param ztz2  判断符（全部、小于）
	 * @param ztz2num 数值2
	 * @param wctz1 判断符（全部、大于等于、等于）-- 完成投资
	 * @param wctz1num 数值1
	 * @param wctz2   判断符（全部、小于）
	 * @param wctz2num 数值2
	 * @param jhtz1 判断符（全部、大于等于、等于）-- 计划投资
	 * @param jhtz1num 数值1
	 * @param jhtz2  判断符（全部、小于）
	 * @param jhtz2num 数值2 
	 * @param wcjhtz1 判断符（全部、大于等于、等于）-- 完成计划投资
	 * @param wcjhtz1num 数值1
	 * @param wcjhtz2  判断符（全部、小于）
	 * @param wcjhtz2num 数值2 
	 * @param sfscx  是否生产性
	 * @param sfzz  是否重中之重
	 * @param sfss  是否省项目
	 * @param sfzy  是否资源
	 * @param sjslb 10+3类别
	 * @param tzztxz 投资主体性质
	 * @param kgFromNd 项目开工年份（开始）
	 * @param kgToNd 项目开工年份（结束）
	 * @param kgFromMonth 项目开工月份（开始）
	 * @param kgToMonth 项目开工月份（结束）
	 * @return
	 */
	public static List<ProZdxmYb> showXxjdhzList(String nd, String fromMonth, String toMonth, String lb1,
			String lb2, String dq, String ztz1, String ztz1num, String ztz2,
			String ztz2num, String wctz1, String wctz1num, String wctz2,
			String wctz2num, String jhtz1, String jhtz1num, String jhtz2,
			String jhtz2num, String wcjhtz1, String wcjhtz1num, String wcjhtz2,
			String wcjhtz2num, String sfscx, String sfzz, String sfss,
			String sfzy, String sjslb, String tzztxz,String kgFromNd, String kgToNd, String kgFromMonth, String kgToMonth) {
		
		// 构建查询语句条件
		String tempSql = "";
		// 完成计划投资比例
		String wctzSql = "";
		// 形象进度查询
		String xxjdSql = "";
		
		if(nd != null && !nd.equals("")){		// 年度
			tempSql += " and p.nd ="+nd;	
			xxjdSql += " and yp.nd ="+nd;	
		}

		if(toMonth != null && !toMonth.equals("")){		// 形象进度查询结束月份
			xxjdSql += " and ym.yf = " + toMonth;	
		}
		
		if(lb1 != null && !lb1.equals("")){		// 类别：大类
			tempSql += " and p.lb1 ='"+lb1+"'";	
		}
		
		if(lb2 != null && !lb2.equals("")){		// 类别：小类
			tempSql += " and p.lb2 ='"+lb2+"'";	
		}
		
		if(dq != null && !dq.equals("")){		// 所属地区
			tempSql += " and p.dq ='"+dq+"'";	
		}
		
		//总投资
		if(ztz1 != null && !ztz1.equals("")){	 // 判断符（全部、大于等于、等于）
			if("".equals(ztz1num)){	// 如果数值1为空，则取0
				ztz1num = "0";
			}
			tempSql +=  " and p.ztz " + ztz1 + ztz1num;	
		}
		
		if(ztz2 != null && !ztz2.equals("")){	// 判断符（全部、小于）
			if("".equals(ztz2num)){	// 如果数值2为空，则取0
				ztz2num = "0";
			}
			tempSql += " and p.ztz " + ztz2 + ztz2num;
		}
		//完成投资
		if(wctz1 != null && !wctz1.equals("")){	 // 判断符（全部、大于等于、等于）
			if("".equals(wctz1num)){	// 如果数值1为空，则取0
				wctz1num = "0";
			}
			tempSql +=  " and p.wctz " + wctz1 + wctz1num;	
		}
		
		if(wctz2 != null && !wctz2.equals("")){	// 判断符（全部、小于）
			if("".equals(wctz2num)){	// 如果数值2为空，则取0
				wctz2num = "0";
			}
			tempSql += " and p.wctz " + wctz2 + wctz2num;
		}
		//计划投资
		if(jhtz1 != null && !jhtz1.equals("")){	 // 判断符（全部、大于等于、等于）
			if("".equals(jhtz1num)){	// 如果数值1为空，则取0
				jhtz1num = "0";
			}
			tempSql +=  " and p.jhtz " + jhtz1 + jhtz1num;	
		}
		
		if(jhtz2 != null && !jhtz2.equals("")){	// 判断符（全部、小于）
			if("".equals(jhtz2num)){	// 如果数值2为空，则取0
				jhtz2num = "0";
			}
			tempSql += " and p.jhtz " + jhtz2 + jhtz2num;
		}
		// 完成计划投资比例
		if(wcjhtz1 != null && !wcjhtz1.equals("")){	 // 判断符（全部、大于等于、等于）
			if("".equals(wcjhtz1num)){	// 如果数值1为空，则取0
				wcjhtz1num = "0";
			}else {
				wcjhtz1num = String.valueOf((Double.parseDouble(wcjhtz1num))/100);
			}
			wctzSql +=  " and t.dnwctzbl " + wcjhtz1 + wcjhtz1num;	
		}
		
		if(wcjhtz2 != null && !wcjhtz2.equals("")){	// 判断符（全部、小于）
			if("".equals(wcjhtz2num)){	// 如果数值2为空，则取0
				wcjhtz2num = "0";
			}else {
				wcjhtz2num = String.valueOf((Double.parseDouble(wcjhtz2num))/100);
			}
			wctzSql += " and t.dnwctzbl " + wcjhtz2 + wcjhtz2num;
		}
		
		if(sfscx != null && !sfscx.equals("")){		// 是否生产性
			tempSql += " and p.sfscx ='"+sfscx+"'";	
		}
		
		if(sfzz != null && !sfzz.equals("")){		// 是否重中之重
			tempSql += " and p.sfzz ='"+sfzz+"'";	
		}
		
		if(sfss != null && !sfss.equals("")){		// 是否省项目
			tempSql += " and p.sfss ='"+sfss+"'";	
		}
		
		if(sfzy != null && !sfzy.equals("")){		// 是否资源
			tempSql += " and p.sfzy ='"+sfzy+"'";	
		}
		
		if(sjslb != null && !sjslb.equals("")){		// 10+3类别
			tempSql += " and p.sjslb ='"+sjslb+"'";	
		}
		
		if(tzztxz != null && !tzztxz.equals("")){		// 投资主体性质
			tempSql += " and p.tzztxz ='"+tzztxz+"'";	
		}
		
		if(kgFromNd != null && !kgFromNd.equals("")){		// 项目开工年份（开始）
			tempSql += " and p.kgn >='"+kgFromNd+"'";	
		}
		
		if(kgToNd != null && !kgToNd.equals("")){		// 项目开工年份（结束）
			tempSql += " and p.kgn <='"+kgToNd+"'";	
		}
		
		if(kgFromMonth != null && !kgFromMonth.equals("")){		// 项目开工月份（开始）
			tempSql += " and p.kgy >='"+kgFromMonth+"'";	
		}
		
		if(kgToMonth != null && !kgToMonth.equals("")){		// 项目开工月份（结束）
			tempSql += " and p.kgy <='"+kgToMonth+"'";	
		}
		
		// 构建查询语句
		String sql = "SELECT\n" +
					"	p.id,\n" +
					"	p.nd,\n" +
					"	p.mc,\n" +
					"	p.ztz,\n" +
					"	p.wctz,\n" +
					"	p.jhtz,\n" +
					"	max(m.nczbywc)AS nczbywc,\n" +
//					"	max(m.dnljdwhj)AS dnljdwhj,\n" +
					"	(max(m.dnljdw1)+max(m.dnljdw2)+max(m.dnljdw3))AS dnljdwhj,\n" +
					"	p.wctz + max(m.nczbywc)AS kgljwc,\n" +
//					"	max(m.kgljdwhj)AS kgljdwhj,\n" +
					"	(max(m.kgljdw1)+max(m.kgljdw2)+max(m.kgljdw3))AS kgljdwhj,\n" +
					"	max(m.nczbywc)/ p.jhtz AS dnwctzbl,\n" +
//					"	max(m.dnljdwhj)/ p.jhtz AS dndwzjbl,\n" +
					"	(max(m.dnljdw1)+max(m.dnljdw2)+max(m.dnljdw3))/ p.jhtz AS dndwzjbl,\n" +
					"	p.lb AS lb,\n" +
					"	p.lb1 AS lb1,\n" +
					"	(p.wctz + max(m.nczbywc))/ p.ztz AS kgwctzbl,\n" +
					"	max(m.kgljdwhj)/ p.ztz AS kgdwzjbl,\n" +
					"	yb.xxjd AS xxjd,\n" +
					"	yb.scnl AS scnl,\n" +
					"	yb.czwt AS czwt,\n" +
					"	yb.xtjj AS xtjj,\n" +
					"	yb.gzjh AS gzjh,\n" +
					"	yb.jcqk AS jcqk,\n" +
					"	yb.zjsm AS zjsm \n" +
					"   from tb_zd_project p,\n" +
					"	tb_zd_month m,\n" +
					"	(select yp.id,ym.xxjd,ym.scnl,ym.czwt,ym.xtjj,ym.gzjh,ym.jcqk,ym.zjsm from tb_zd_project yp, tb_zd_month ym where 1=1 "+ xxjdSql +" AND yp.id = ym.pid AND yp.zt = '已审核' AND ym.zt = '已上报' AND yp.id = ym.pid) AS yb\n" +
					" WHERE\n" +
					"	m.pid = p.id and yb.id = p.id and p.zt = '已审核'" + 
					" and m.zt = '已上报'";
		if("1".equals(fromMonth)){ // 如果从1月份开始计算，则直接获取并返回结束月份的数据
			//完成计划投资
			tempSql += " and m.yf<="+ toMonth;
			sql = "select * from ("+ sql + tempSql +" group by m.pid order by p.bh asc) as t where 1=1"+wctzSql;
			// 替换判断符号
			sql = sql.replaceAll("dydy", ">=").replaceAll("dy", "=").replaceAll("xy", "<");
			List<ProZdxmYb> zdxmYbList = getZdxmXxjdListBySQL(sql);
			return zdxmYbList;
		}else { // 否则返回从1月份到结束月的数据减去从1月份到开始月份的数据
			// 参数条件
			fromMonth = (FavoritesHelper.stringToint(fromMonth)-1)+"";
			String paramSql = tempSql + " and m.yf<="+ fromMonth;
			// 完整的查询语句
			String searchSql = "select * from ("+ sql + paramSql +" group by m.pid order by p.bh asc) as t where 1=1"+wctzSql;
			// 转换判断符号
			searchSql = searchSql.replaceAll("dydy", ">=").replaceAll("dy", "=").replaceAll("xy", "<");
			// 获取数据
			List<ProZdxmYb> fromMonthZdxmYbList = getZdxmXxjdListBySQL(searchSql);
			// 参数条件
			paramSql = tempSql + " and m.yf<="+ toMonth;
			// 完整的查询语句
			searchSql = "select * from ("+ sql + paramSql +" group by m.pid order by p.bh asc) as t where 1=1"+wctzSql;
			// 转换判断符号
			searchSql = searchSql.replaceAll("dydy", ">=").replaceAll("dy", "=").replaceAll("xy", "<");
			// 获取数据
			List<ProZdxmYb> toMonthZdxmYbList = getZdxmXxjdListBySQL(searchSql);
			List<ProZdxmYb> zdxmYbList = new ArrayList<ProZdxmYb>();
			// 对应的数值进行相减
			if (FavoritesHelper.isNotNull(fromMonthZdxmYbList)) {
				for (int i = 0; i < fromMonthZdxmYbList.size(); i++) {
					ProZdxmYb zdxmYb = fromMonthZdxmYbList.get(i);
					ProZdxmYb zdxmYb2 = toMonthZdxmYbList.get(i);
					zdxmYb.setNczbywc(zdxmYb2.getNczbywc() - zdxmYb.getNczbywc());	// 当年完成投资
					zdxmYb.setDnwctzbl(FavoritesHelper.twoPointFloat(zdxmYb2.getDnwctzbl() - zdxmYb.getDnwctzbl())); // 完成年度计划投资比例
					zdxmYb.setDnljdwhj(zdxmYb2.getDnljdwhj() - zdxmYb.getDnljdwhj()); // 当年累计到位资金
					zdxmYb.setDndwzjbl(FavoritesHelper.twoPointFloat(zdxmYb2.getDndwzjbl() - zdxmYb.getDndwzjbl())); // 完成年度计划投资比例
					zdxmYb.setKgljwc(zdxmYb2.getKgljwc()); // 开工累计完成投资
					zdxmYb.setKgwctzbl(FavoritesHelper.twoPointFloat(zdxmYb2.getKgwctzbl())); // 开工累计完成占总投资比例
					zdxmYb.setKgljdwhj(zdxmYb2.getKgljdwhj()); // 开工累计到位资金
					zdxmYb.setKgdwzjbl(FavoritesHelper.twoPointFloat(zdxmYb2.getKgdwzjbl())); // 开工累计到位资金占总投资比例
					
					zdxmYbList.add(zdxmYb);
				}
			}
			return zdxmYbList;
		}
	}
	/**
	 * 获取重点项目月报信息列表
	 * @param sql
	 * @return
	 */
	private static List<ProZdxmYb> getZdxmYbListBySQL(String sql) {
		// 重点项目月报信息列表
		List<ProZdxmYb> itemlist = new ArrayList<ProZdxmYb>() ;
		// 获取数据库连接
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		//　获取查询结果
		try {
			stat = conn.prepareStatement(sql);	
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				ProZdxmYb item = new ProZdxmYb();
				item.setId(rs.getLong("id")); // 主键
				item.setNd(rs.getLong("nd")); // 年度
				item.setMc(rs.getString("mc")); // 项目名称
				item.setZtz(rs.getLong("ztz")); // 总投资
				item.setQnwctz(rs.getLong("wctz")); // 去年完成投资
				item.setNdjhtz(rs.getLong("jhtz")); // 年度计划完成投资
				item.setNczbywc(rs.getLong("nczbywc")); // 年度完成投资
				item.setDnwctzbl(FavoritesHelper.twoPointFloat(rs.getFloat("dnwctzbl")*100));	// 年度完成投资比例			
				item.setDnljdwhj(rs.getLong("dnljdwhj")); // 当年累计到位资金
				item.setDndwzjbl(FavoritesHelper.twoPointFloat(rs.getFloat("dndwzjbl")*100));	// 年度到位资金比例			
				item.setKgljwc(rs.getLong("kgljwc")); // 开工以来累计完成投资
				item.setKgwctzbl(FavoritesHelper.twoPointFloat(rs.getFloat("kgwctzbl")*100));	// 开工累计投资比例			
				item.setKgljdwhj(rs.getLong("kgljdwhj")); // 开工以来累计到位资金
				item.setKgdwzjbl(FavoritesHelper.twoPointFloat(rs.getFloat("kgdwzjbl")*100));	// 开工累计到位资金比例			
				item.setLb(rs.getString("lb"));
				item.setLb1(rs.getString("lb1"));
				
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
	 * 获取重点项目形象进度信息
	 * @param sql
	 * @return
	 */
	private static List<ProZdxmYb> getZdxmXxjdListBySQL(String sql) {
		// 重点项目形象进度信息列表
		List<ProZdxmYb> itemlist = new ArrayList<ProZdxmYb>() ;
		// 获取数据库连接
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat = null;	
		ResultSet rs = null;
		//　获取查询结果
		try {
			stat = conn.prepareStatement(sql);	
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				ProZdxmYb item = new ProZdxmYb();
				item.setId(rs.getLong("id")); // 主键
				item.setNd(rs.getLong("nd")); // 年度
				item.setMc(rs.getString("mc")); // 项目名称
				item.setZtz(rs.getLong("ztz")); // 总投资
				item.setQnwctz(rs.getLong("wctz")); // 去年完成投资
				item.setNdjhtz(rs.getLong("jhtz")); // 年度计划完成投资
				item.setNczbywc(rs.getLong("nczbywc")); // 年度完成投资
				item.setDnwctzbl(FavoritesHelper.twoPointFloat(rs.getFloat("dnwctzbl")*100));	// 年度完成投资比例			
				item.setDnljdwhj(rs.getLong("dnljdwhj")); // 当年累计到位资金
				item.setDndwzjbl(FavoritesHelper.twoPointFloat(rs.getFloat("dndwzjbl")*100));	// 年度到位资金比例			
				item.setKgljwc(rs.getLong("kgljwc")); // 开工以来累计完成投资
				item.setKgwctzbl(FavoritesHelper.twoPointFloat(rs.getFloat("kgwctzbl")*100));	// 开工累计投资比例			
				item.setKgljdwhj(rs.getLong("kgljdwhj")); // 开工以来累计到位资金
				item.setKgdwzjbl(FavoritesHelper.twoPointFloat(rs.getFloat("kgdwzjbl")*100));	// 开工累计到位资金比例			
				item.setLb(rs.getString("lb"));
				item.setLb1(rs.getString("lb1"));
				item.setXxjd(rs.getString("xxjd"));
				item.setScnl(rs.getString("scnl"));
				item.setCzwt(rs.getString("czwt"));
				item.setXtjj(rs.getString("xtjj"));
				item.setGzjh(rs.getString("gzjh"));
				item.setJcqk(rs.getString("jcqk"));
				item.setZjsm(rs.getString("zjsm"));
				
				itemlist.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return itemlist;
	}
	
}

