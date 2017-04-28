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

public class ZdaxmSbyhDao {

	
	/**
	 * ��Ӷ���
	 * @param item
	 * @return
	 */
	public static boolean addYb(ProZdaxmYb item){

		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	

		String sql = "insert into tb_zda_month(pid,yf,bh,bywc,nczbywc,kgljwc,wcndjh,xxjd,czwt,gzjh,wcgzjd,tbsj,zt,bz)"
								            +" values("+item.getPid() +
										            " , "+item.getYf() +
										      		" ,'"+item.getBh()+
										      		"','"+item.getBywc()+
										      		"','"+item.getNczbywc()+
										      		"','"+item.getKgljwc()+
										      		"','"+item.getWcndjh()+
										      		"','"+item.getXxjd()+
										      		"','"+item.getCzwt()+
										      		"','"+item.getGzjh()+
										      		"','"+item.getWcgzjd()+
										      		"','"+item.getTbsj()+
										      		"','"+item.getZt()+
										      		"','"+item.getBz()+
										      		"' )";
		System.out.println(sql);
            
	
		try {
   			stat = conn.prepareStatement(sql);			


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
	 * ͨ��Id�õ�����
	 * @param id
	 * @return
	 */
	public static ProZdaxm getObjByBh(String id){
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		
		ProZdaxm item =new ProZdaxm();

        String sql = "select * from tb_zda_project where id=?";
        
        // ��Ŀ�±��У������ۼ����Ͷ��
		String countSql = "select sum(bywc) as dnljwc,max(kgljwc) as kgljwc from tb_zda_month where pid=?";
		try {
			stat = conn.prepareStatement(countSql);
			stat.setLong(1, FavoritesHelper.stringTolong(id));
			rs = stat.executeQuery();
			if(rs.next()){
				item.setDnljwc(rs.getFloat("dnljwc"));
				item.setKgljwc(rs.getFloat("kgljwc"));
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
	
	
	/**
	 * ��ʾ �±�¼��ҳ��
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static Integer showYblr(int id){
		
		
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		Integer yf = 0;
		try {

			//TODO ��ӷ�ҳ���� �޸ı���
			String sql = "select * from tb_zda_month where pid='"+id+"'  order by yf desc limit 0,1 ";
				         
			stat = conn.prepareStatement(sql);	
			rs = stat.executeQuery(sql);	
			if(rs.next()){		 
				yf=rs.getInt("yf");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		
		return yf;
	}
	
	/**
	 * �õ� ��Ŀ����
	 * @return
	 */
	public static String getXmmc(int id){
		String xmmc="";
		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
        String sql = "select * from tb_zda_project where id=?";
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
	 * �õ� �±������б�
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static List<ProZdaxmYb> showYblb(int id){
		
		List<ProZdaxmYb> itemlist = new ArrayList<ProZdaxmYb>() ;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;

		try {

			//TODO ��ӷ�ҳ���� �޸ı���
			String sql = "select * from tb_zda_month where pid='"+id+"'  order by yf desc  ";
				         
			stat = conn.prepareStatement(sql);	
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				ProZdaxmYb item = new ProZdaxmYb();
				
				item.setId(rs.getLong("id"));
				item.setPid(rs.getLong("pid"));
				item.setYf(rs.getString("yf"));
				item.setBh(rs.getString("bh"));
				item.setBywc(rs.getFloat("bywc"));
				item.setZt(rs.getString("zt"));
				item.setTbsj(rs.getDate("tbsj"));

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
	 * �õ��ϱ���Ŀ����
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static List<ProZdaxm> showXmlb(String sbyh,int nd){
		
		List<ProZdaxm> itemlist = new ArrayList<ProZdaxm>() ;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;

		try {

			//TODO ��ӷ�ҳ���� �޸ı���
			String sql = "select * from tb_zda_project where zt='�����' and sbyh='"+sbyh+"' and nd="+nd+" order by id desc  ";
				         
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
		
	   String sql="update tb_zda_project set zt='���ϱ�' where id="+id;

	   if(DBHelper.executeUpdateInject(sql)>0){
		   return true;
	   }
		
	   return false;
	}
	
	/**
	 * �õ���ҳ������
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static Pager getObjForPage(int pageNo, int pageSize, String searchStr , String sbyh){
		
		List<ProZdaxm> itemlist = new ArrayList<ProZdaxm>() ;
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
			//TODO ��ӷ�ҳͳ������ �޸ı���
			String countsql = "select count(*) as num  from tb_zda_project where sbyh='"+sbyh+"' "+tempSql;
			stat = conn.prepareStatement(countsql);	
			
			rs=stat.executeQuery(countsql);
			
			if(rs.next()){
				count = rs.getInt("num");
			}

			//TODO ��ӷ�ҳ���� �޸ı���
			String sql = "select * from tb_zda_project where sbyh='"+sbyh+"' "+tempSql+" order by id desc limit "
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
	 * ��ʾ �±����ҳ��
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
	 * ��ʾ �±��༭ҳ��
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
	 * �༭����
	 * @param item
	 * @return
	 */
	public static boolean editYb(ProZdaxmYb item){
		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		String sql = "update tb_zda_month set bywc=?,nczbywc=?,kgljwc=?,xxjd=?,czwt=?,gzjh=?,wcgzjd=?,bz=?,zt=? where id=?";
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
   			stat.setString(9, item.getZt());
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
	 * �ϱ�����
	 * @param item
	 * @return
	 */
	public static boolean saveUp(long id){
		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		String sql = "update tb_zda_month set zt=? where id=?";
		try {
   			stat = conn.prepareStatement(sql);
   			stat.setString(1, "���ϱ�");
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
	 * ���ݸ��������õ��±�������Ϣ
	 * @param pid
	 * @return
	 */
	public static List<ProZdaxmYb> getObjByPid(int pid){
		
		List<ProZdaxmYb> itemlist = new ArrayList<ProZdaxmYb>() ;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;

		try {

			//TODO ��ӷ�ҳ���� �޸ı���
			String sql = "select * from tb_zda_month where pid='"+pid+"' and zt='δ�ϱ�' order by yf desc  ";
				         
			stat = conn.prepareStatement(sql);	
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				ProZdaxmYb item = new ProZdaxmYb();
				
				item.setPid(rs.getLong("pid"));
				item.setId(rs.getLong("id"));
				item.setYf(rs.getString("yf"));
				item.setBh(rs.getString("bh"));
				item.setBywc(rs.getFloat("bywc"));
				item.setNczbywc(rs.getFloat("nczbywc"));
				item.setWcndjh(rs.getFloat("wcndjh"));
				item.setXxjd(rs.getString("xxjd"));
				item.setCzwt(rs.getString("czwt"));
				item.setGzjh(rs.getString("gzjh"));
				item.setWcgzjd(rs.getString("wcgzjd"));
				item.setZt(rs.getString("zt"));
				item.setTbsj(rs.getDate("tbsj"));
				item.setBz(rs.getString("bz"));

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
