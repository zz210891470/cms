package com.trunko.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trunko.project.entity.ProZdaxm;
import com.trunko.project.vo.FjFlInfo;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.FavoritesHelper;
import com.trunko.cms.util.Pager;

/**
 * 重点项目数据处理类
 * 
 * @author jianhuang
 * 
 */
public class ZdaxmDao {
	
	
	/**
	 * 获取地区名称列表
	 * @return List<String> itemlist
	 */
	public static List<String> getDq1List(){
		// 地区名称列表集合
		List<String> itemlist = new ArrayList<String>() ;
		// 获取连接
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		try {
			// 重点项目所属地区查询语句
			String sql = "select * from tb_area where lx='zda' order by px asc  ";
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
	 * 获取地区名称列表
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
			String sql = "select * from tb_industry where lx='zda' and pid =0 order by px asc  ";
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
	 * 获取分级数据
	 * @param nd
	 * @param ksyf
	 * @param jsyf
	 * @param lb
	 * @return
	 */
	public static List<FjFlInfo> getFjInfoList(String  nd, String ksyf, String jsyf ){
		

		// 获取数据库连接
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		List<FjFlInfo> infoList1 = new ArrayList<FjFlInfo>();
		try {
			
			FjFlInfo info2 = new FjFlInfo();
            

			// 重点项目所属类别查询语句
			String sql = "select COUNT(*) as pnum, SUM(ztz) as ztz,p.dq as dq ," +
					     " SUM(nczbywc) as nczbywc,SUM(jhtz) as jhtz  " +
					     " from tb_zda_project p,tb_zda_month m " +
					     " where p.id=m.pid and m.yf="+jsyf+" and nd=" +nd +
					     " GROUP BY p.dq";
			
			
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
				info1.setWcbl( Double.valueOf( info1.getNczbywc()*100 ) / Double.valueOf( info1.getJhtz() ));

                infoList1.add(info1);
			}
			
			//如果开始月份不等于1，则需要将之前的统计删除
			if(!ksyf.equals("1") && infoList1.size()>0){
				// 重点项目所属类别查询语句
				sql = "select SUM(nczbywc) as nczbywc  " +
						     " from tb_zda_project p,tb_zda_month m " +
						     " where p.id=m.pid and m.yf="+(Integer.valueOf(ksyf)-1)+"  and nd=" +nd +
						     " GROUP BY p.dq";

				// 获取查询结果
				rs = stat.executeQuery(sql);
				List<Long> nczbywcList = new ArrayList<Long>();
			
				while(rs.next()){
					Long temp =rs.getLong("nczbywc");
	                nczbywcList.add(temp);

				}

				for(int i=0; i<nczbywcList.size(); i++){
                    infoList1.get(i).setNczbywc((infoList1.get(i).getNczbywc()-nczbywcList.get(i))); 
                    infoList1.get(i).setWcbl((Double.valueOf(infoList1.get(i).getNczbywc())/infoList1.get(i).getJhtz())*100d);
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
	 * 获取分类
	 * @param nd
	 * @param ksyf
	 * @param jsyf
	 * @param lb
	 * @return
	 */
	public static List<FjFlInfo> getFlInfoList(String  nd, String ksyf, String jsyf ){
		
		// 获取数据库连接
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		List<FjFlInfo> infoList1 = new ArrayList<FjFlInfo>();
		try {
			
			FjFlInfo info2 = new FjFlInfo();
            

			// 重点项目所属类别查询语句
			String sql = "select COUNT(*) as pnum, SUM(ztz) as ztz,p.lb1 as dq ," +
					     " SUM(nczbywc) as nczbywc,SUM(jhtz) as jhtz  " +
					     " from tb_zda_project p,tb_zda_month m " +
					     " where p.id=m.pid and m.yf="+jsyf+" and nd=" +nd +
					     " GROUP BY p.lb1";
			
			
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
				info1.setWcbl( Double.valueOf( info1.getNczbywc()*100 ) / Double.valueOf( info1.getJhtz() ));

                infoList1.add(info1);
			}
			
			//如果开始月份不等于1，则需要将之前的统计删除
			if(!ksyf.equals("1") && infoList1.size()>0){
				// 重点项目所属类别查询语句
				sql = "select SUM(nczbywc) as nczbywc  " +
						     " from tb_zda_project p,tb_zda_month m " +
						     " where p.id=m.pid and m.yf="+(Integer.valueOf(ksyf)-1)+"  and nd=" +nd +
						     " GROUP BY p.lb1";

				// 获取查询结果
				rs = stat.executeQuery(sql);
				List<Long> nczbywcList = new ArrayList<Long>();
			
				while(rs.next()){
					Long temp =rs.getLong("nczbywc");
	                nczbywcList.add(temp);

				}

				for(int i=0; i<nczbywcList.size(); i++){
                    infoList1.get(i).setNczbywc((infoList1.get(i).getNczbywc()-nczbywcList.get(i))); 
                    infoList1.get(i).setWcbl((Double.valueOf(infoList1.get(i).getNczbywc())/infoList1.get(i).getJhtz())*100d);
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
	 * 
	 * @param item
	 * @return
	 */
	public static boolean update(ProZdaxm item) {

		Boolean isOk = false;
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat = null;

		String sql = "update tb_zda_project set nd=?" + ",bh=?" + ",mc=?"
				+ ",dq=?" + ",jsgm=?" + ",jsdd=?" + ",ztz=?" + ",lb1=?"
				+ ",lb2=?" + ",lb3=?" + ",jsdq=?" + ",bawh=?" + ",jsnx1=?"
				+ ",jsnx2=?" + ",jhtz=?" + ",jdmb=?" + ",kgn=?" + ",kgy=?"
				+ ",jgn=?" + ",jgy=?" + ",yd=?" + ",ld=?" + ",wctz=?"
				+ " where id=?";

		System.out.println(sql);

		try {
			stat = conn.prepareStatement(sql);

			stat.setLong(1, item.getNd());
			stat.setString(2, item.getBh());
			stat.setString(3, item.getMc());
			stat.setString(4, item.getDq());
			stat.setString(5, item.getJsgm());
			stat.setString(6, item.getJsdd());
			stat.setLong(7, item.getZtz());
			stat.setString(8, item.getLb1());
			stat.setString(9, item.getLb2());
			stat.setString(10, item.getLb3());
			stat.setString(11, item.getJsdq());
			stat.setString(12, item.getBawh());
			stat.setInt(13, item.getJsnx1());
			stat.setInt(14, item.getJsnx2());
			stat.setLong(15, item.getJhtz());
			stat.setString(16, item.getJdmb());
			stat.setString(17, item.getKgn());
			stat.setString(18, item.getKgy());
			stat.setString(19, item.getJgn());
			stat.setString(20, item.getJgy());
			stat.setFloat(21, item.getYd());
			stat.setFloat(22, item.getLd());
			stat.setLong(23, item.getWctz());

			stat.setLong(24, item.getId());

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
	 * 添加对象
	 * 
	 * @param item
	 * @return
	 */
	public static boolean add(ProZdaxm item) {

		Boolean isOk = false;
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat = null;

		String sql = "insert into tb_zda_project(nd,bh,mc,dq,jsgm,jsdd,ztz,lb1,lb2,lb3,jsdq,bawh,jsnx1,jsnx2,jhtz,jdmb,kgn,kgy,jgn,jgy,yd,ld,wctz,zt,sbyh)"
				                      + " values(? ,? ,? ,? ,?   ,?   ,?  ,?  ,?  ,?  ,?   ,?   ,?    ,?    ,?   ,?   ,?  ,?  ,?  ,?  ,? ,? ,?   ,? ,?  )";
		System.out.println(sql);

		try {
			stat = conn.prepareStatement(sql);

			stat.setLong(1, item.getNd());
			stat.setString(2, item.getBh());
			stat.setString(3, item.getMc());
			stat.setString(4, item.getDq());
			stat.setString(5, item.getJsgm());
			stat.setString(6, item.getJsdd());
			stat.setLong(7, item.getZtz());
			stat.setString(8, item.getLb1());
			stat.setString(9, item.getLb2());
			stat.setString(10, item.getLb3());
			stat.setString(11, item.getJsdq());
			stat.setString(12, item.getBawh());
			stat.setInt(13, item.getJsnx1());
			stat.setInt(14, item.getJsnx2());
			stat.setLong(15, item.getJhtz());
			stat.setString(16, item.getJdmb());
			stat.setString(17, item.getKgn());
			stat.setString(18, item.getKgy());
			stat.setString(19, item.getJgn());
			stat.setString(20, item.getJgy());
			stat.setFloat(21, item.getYd());
			stat.setFloat(22, item.getLd());
			stat.setLong(23, item.getWctz());
			stat.setString(24, item.getZt());
			stat.setString(25, item.getSbyh());

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
	 * 批量或单个删除数据
	 * 
	 * @param ItemList
	 * @return
	 */
	public static boolean delItemList(String[] ItemList) {

		Boolean isOk = false;
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat = null;

		String sql = "delete from tb_zda_project where ";

		for (int i = 0; i < ItemList.length; i++) {
			sql += " id=?   or ";
		}
		sql = sql.substring(0, sql.length() - 4);

		System.out.println(sql);

		try {
			stat = conn.prepareStatement(sql);

			for (int i = 0; i < ItemList.length; i++) {
				stat.setLong((i + 1), Long.valueOf(ItemList[i]));
			}

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
	 * 通过Id得到对象
	 * 
	 * @param id
	 * @return
	 */
	public static ProZdaxm getObjById(Long id) {

		Connection conn = DBHelper.getConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;

		ProZdaxm item = new ProZdaxm();

		String sql = "select * from tb_zda_project where id=?";
		try {
			stat = conn.prepareStatement(sql);

			stat.setLong(1, id);

			rs = stat.executeQuery();

			if (rs.next()) {

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

	/**
	 * 得到分页数据类
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static Pager getObjForPage(int pageNo, int pageSize, String searchStr) {

		List<ProZdaxm> itemlist = new ArrayList<ProZdaxm>();
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;

		String tempSql;
		if (searchStr == null || searchStr.equals("")) {
			tempSql = "";
		} else {
			tempSql = " and mc  like '%" + searchStr + "%' ";
		}

		int count = 0;
		try {
			// TODO 添加分页统计条件 修改表名
			String countsql = "select count(*) as num  from tb_zda_project where zt='已审核'"
					+ tempSql;
			stat = conn.prepareStatement(countsql);

			rs = stat.executeQuery(countsql);

			if (rs.next()) {
				count = rs.getInt("num");
			}

			// TODO 添加分页条件 修改表名
			String sql = "select * from tb_zda_project where zt='已审核'" + tempSql
					+ " order by id desc limit " + ((pageNo - 1) * pageSize)
					+ " , " + pageSize;
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				ProZdaxm item = new ProZdaxm();

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
	 * 得到审核分页数据类
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static Pager getObjForAudit(int pageNo, int pageSize, String searchStr){
		
		List<ProZdaxm> itemlist = new ArrayList<ProZdaxm>();
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
			String countsql = "select count(*) as num    from tb_zda_project where zt='已上报' "+tempSql;
			stat = conn.prepareStatement(countsql);	
			
			rs=stat.executeQuery(countsql);
			
			if(rs.next()){
				count = rs.getInt("num");
			}

			//TODO 添加分页条件 修改表名
			String sql = "select * from tb_zda_project where zt='已上报'  "+tempSql+" order by id desc limit "
				         + ((pageNo - 1) * pageSize) + " , " + pageSize;
			
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				ProZdaxm item = new ProZdaxm();
				
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
			String sql = "select * from tb_industry where lx='zda' order by px asc  ";
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

	/*获得类别地区数据*/
	public static List<String> getDqList() {

		List<String> itemlist = new ArrayList<String>();
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;

		try {

			// TODO 添加分页条件 修改表名
			String sql = "select * from tb_area where lx='zda' order by px asc  ";

			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery(sql);
			while (rs.next()) {

				itemlist.add(rs.getString("mc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}

		return itemlist;

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
		String sql = "update tb_zda_project set zt='" + zt + "'" + " , shyj='"
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
	 * 获取储备项目信息汇总
	 * @param nd   年度
	 * @param lb1     类别：大类
	 * @param lb2     类别：小类
	 * @param dq   所属地区
	 * @param ztz1  判断符（全部、大于等于、等于）
	 * @param ztz1num 数值1
	 * @param ztz2  判断符（全部、小于）
	 * @param ztz2num 数值2
	 * @return List itemlist 
	 */
	public static List<ProZdaxm> showXxhzList(String nd,String  lb1,String lb2, String dq, String ztz1,String ztz1num ,String ztz2,String ztz2num){
		// 项目信息列表
		List<ProZdaxm> itemlist = new ArrayList<ProZdaxm>() ;
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
		// 替换判断符号
		tempSql = tempSql.replaceAll("dydy", ">=").replaceAll("dy", "=").replaceAll("xy", "<");
		// 构建查询语句
		String sql = "select * from tb_zda_project where zt = '已审核' "+tempSql+" order by nd desc";
		//　获取查询结果
		try {
			stat = conn.prepareStatement(sql);	
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				ProZdaxm item = new ProZdaxm();

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
	 * 导入对象
	 * @param item
	 * @return
	 */
	public static boolean xlsImport(List<ProZdaxm> itemList){

		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	

		String sql = "insert into tb_zda_project(nd,bh,mc,lb1,lb2,dq,jsdq,jsdd,jsgm,ztz,bawh,jsnx1,jsnx2,jhtz,jdmb,kgn,kgy,jgn,jgy,yd,ld,wctz,zt,shyj)"
		                              +" values";
		
		for(int i = 0; i < itemList.size(); i ++){
			
			sql += " (? ,? ,? ,?   ,?   ,?   ,?  ,?   ,? ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?  )  ,";
		}
		sql = sql.substring(0,sql.length()-2);
		System.out.println(sql);
	
		try {
   			stat = conn.prepareStatement(sql);			
            int count = 1;
   			for(int i = 0; i < itemList.size(); i ++){
   	   			
   	   			stat.setLong(count, itemList.get(i).getNd());
   	   			stat.setString(count+1, itemList.get(i).getBh());
   	   			stat.setString(count+2, itemList.get(i).getMc());
   	   			stat.setString(count+3, itemList.get(i).getLb1());
   	   			stat.setString(count+4, itemList.get(i).getLb2());
   	   			stat.setString(count+5, itemList.get(i).getDq());
   	   			stat.setString(count+6, itemList.get(i).getDq());
   	   			stat.setString(count+7, itemList.get(i).getJsdd());
   	   			stat.setString(count+8, itemList.get(i).getJsgm());
   	   			stat.setLong(count+9, itemList.get(i).getZtz());
   	   			stat.setString(count+10, itemList.get(i).getBawh());
   	   			stat.setInt(count+11, itemList.get(i).getJsnx1());
   	   			stat.setInt(count+12, itemList.get(i).getJsnx2());
   	   			stat.setLong(count+13, itemList.get(i).getJhtz());
   	   			stat.setString(count+14, itemList.get(i).getJdmb());
   	   			stat.setString(count+15, itemList.get(i).getKgn());
   	   			stat.setString(count+16, itemList.get(i).getKgy());
   	   			stat.setString(count+17, itemList.get(i).getJgn());
   	   			stat.setString(count+18, itemList.get(i).getJgy());
   	   			stat.setFloat(count+19, itemList.get(i).getYd());
   	   			stat.setFloat(count+20, itemList.get(i).getLd());
   	   			stat.setLong(count+21, itemList.get(i).getWctz());
   	   			stat.setString(count+22, itemList.get(i).getZt());
   	   			stat.setString(count+23, itemList.get(i).getShyj());

   	   			count = count + 24;
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
}
