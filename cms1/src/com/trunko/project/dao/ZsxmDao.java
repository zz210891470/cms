package com.trunko.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trunko.project.entity.ProZsxm;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.FavoritesHelper;
import com.trunko.cms.util.Pager;

/**
 * ������Ŀ���ݴ�����
 * @author jianhuang
 *
 */
public class ZsxmDao {
	
	
	/**
	 * �õ�����б�
	 * @return
	 */
	public static String getLbList(){
		

  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
        String data = "";
		try {

			//TODO ��ӷ�ҳ���� �޸ı���
			String sql = "select * from tb_industry where lx='zs' order by px asc  ";
				         
			stat = conn.prepareStatement(sql);	
			rs = stat.executeQuery(sql);	
			while(rs.next()){
                data += "{pid:'"+rs.getLong("pid")+"',";
                data += " id:'"+rs.getLong("id")+"',";
                data += " mc:'"+rs.getString("mc")+"'},";
				
			}
			// �����ȡ�����Ϊ��
			if(FavoritesHelper.isNotNull(data)){
				data = data.substring(0,data.length()-1);
			}
			data = "["+data+"]";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		
		return data;
		
	}

	
	
	public static List<String> getDqList(){
		
		List<String> itemlist = new ArrayList<String>() ;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;

		try {

			//TODO ��ӷ�ҳ���� �޸ı���
			String sql = "select * from tb_area where lx='zs' order by px asc  ";
				         
			stat = conn.prepareStatement(sql);	
			rs = stat.executeQuery(sql);	
			while(rs.next()){

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
	 * ��Ӷ���
	 * @param item
	 * @return
	 */
	public static boolean xlsImport(List<ProZsxm> itemList){

		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	

		String sql = "insert into tb_zs_project(nd,bh,mc,jsgm,hzfs,lxdw,lxr,lxdh,qqgz,dq,lb1,lb2,ztz)"
		                              +" values";
		
		for(int i = 0; i < itemList.size(); i ++){
			
			sql += " (? ,? ,? ,?   ,?   ,?   ,?  ,?   ,?   ,?   ,?   ,?   ,?   )  ,";
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
   	   			stat.setString(count+3, itemList.get(i).getJsgm());
   	   			stat.setString(count+4, itemList.get(i).getHzfs());
   	   			stat.setString(count+5, itemList.get(i).getLxdw());
   	   			stat.setString(count+6, itemList.get(i).getLxr());
   	   			stat.setString(count+7, itemList.get(i).getLxdh());
   	   			stat.setString(count+8, itemList.get(i).getQqgz());
   	   			stat.setString(count+9, itemList.get(i).getDq());
   	   			stat.setString(count+10, itemList.get(i).getLb1());
   	   			stat.setString(count+11, itemList.get(i).getLb2());
   	   			stat.setString(count+12, itemList.get(i).getZtz());
   				
   	   			count = count + 13;
   				
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
	 * ���Ķ���
	 * @param item
	 * @return
	 */
	public static boolean update(ProZsxm item){
		
		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	

		String sql = "update tb_zs_project set nd=?"
				                           +",bh=?"
			                               +",mc=?"
				                           +",jsgm=?"
			                               +",hzfs=?"
				                           +",lxdw=?"
			                               +",lxr=?"
				                           +",lxdh=?"
			                               +",qqgz=?"
			                               +",ztz=?"
			                               +",dq=?"
			                               +",lb1=?"
			                               +",lb2=?"
			                               +" where id=?";
		
		System.out.println(sql);
	
		try {
   			stat = conn.prepareStatement(sql);			


   			stat.setLong(1, item.getNd());
   			stat.setString(2, item.getBh());
   			stat.setString(3, item.getMc());
   			stat.setString(4, item.getJsgm());
   			stat.setString(5, item.getHzfs());
   			stat.setString(6, item.getLxdw());
   			stat.setString(7, item.getLxr());
   			stat.setString(8, item.getLxdh());
   			stat.setString(9, item.getQqgz());
   			
   			if(item.getZtz() == null || item.getZtz().equals("") ){
   				stat.setLong(10, 0);
   			}else {
   				stat.setLong(10, Long.valueOf(item.getZtz()));
   			}
   			stat.setString(11, item.getDq());
   			stat.setString(12, item.getLb1());
   			stat.setString(13, item.getLb2());
   			stat.setLong(14, item.getId());

   			
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
	 * ��Ӷ���
	 * @param item
	 * @return
	 */
	public static boolean add(ProZsxm item){

		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	

		String sql = "insert into tb_zs_project(nd,bh,mc,jsgm,hzfs,lxdw,lxr,lxdh,qqgz,ztz,dq,lb1,lb2)"
		                              +" values(? ,? ,? ,?   ,?   ,?   ,?  ,?   ,?   ,?  ,? ,?  ,?)";
		System.out.println(sql);
	
		try {
   			stat = conn.prepareStatement(sql);			

   			stat.setLong(1, item.getNd());
   			stat.setString(2, item.getBh());
   			stat.setString(3, item.getMc());
   			stat.setString(4, item.getJsgm());
   			stat.setString(5, item.getHzfs());
   			stat.setString(6, item.getLxdw());
   			stat.setString(7, item.getLxr());
   			stat.setString(8, item.getLxdh());
   			stat.setString(9, item.getQqgz());
   			if(item.getZtz() == null || item.getZtz().equals("") ){
   				stat.setLong(10, 0);
   			}else {
   				stat.setLong(10, Long.valueOf(item.getZtz()));
   			}
   			
   			stat.setString(11, item.getDq());

   			stat.setString(12, item.getLb1());
   			stat.setString(13, item.getLb2());
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
	 * �����򵥸�ɾ������
	 * @param ItemList
	 * @return
	 */
	public static boolean delItemList(String[] ItemList){
		
		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	

	    String sql = "delete from tb_zs_project where ";
		
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
	 * ͨ��Id�õ�����
	 * @param id
	 * @return
	 */
	public static ProZsxm getObjById(Long id){
		
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		
		ProZsxm item =new ProZsxm();

        String sql = "select * from tb_zs_project where id=?";
		try {
			stat = conn.prepareStatement(sql);	

			stat.setLong(1, id);
		
			rs = stat.executeQuery();	
			
			if(rs.next()){

				item.setId(rs.getLong("id"));
				item.setNd(rs.getLong("nd"));
				item.setBh(rs.getString("bh"));
				item.setMc(rs.getString("mc"));
				item.setJsgm(rs.getString("jsgm"));
				item.setHzfs(rs.getString("hzfs"));
				item.setLxdw(rs.getString("lxdw"));
				item.setLxr(rs.getString("lxr"));
				item.setLxdh(rs.getString("lxdh"));
				item.setQqgz(rs.getString("qqgz"));
				item.setZtz(rs.getString("ztz"));
				item.setDq(rs.getString("dq"));
				item.setLb1(rs.getString("lb1"));
				item.setLb2(rs.getString("lb2"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		
		return item;
	
	}
	
	
	/**
	 * �õ���ҳ������
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static Pager getObjForPage(int pageNo, int pageSize, String searchStr){
		
		List<ProZsxm> itemlist = new ArrayList<ProZsxm>() ;
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
			//TODO ��ӷ�ҳͳ������ �޸ı���
			String countsql = "select count(*) as num  from tb_zs_project "+tempSql;
			stat = conn.prepareStatement(countsql);	
			
			rs=stat.executeQuery(countsql);
			
			if(rs.next()){
				count = rs.getInt("num");
			}

			//TODO ��ӷ�ҳ���� �޸ı���
			String sql = "select * from tb_zs_project "+tempSql+" order by id desc limit "
				         + ((pageNo - 1) * pageSize) + " , " + pageSize;
			
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				ProZsxm item = new ProZsxm();
				
				item.setId(rs.getLong("id"));
				item.setNd(rs.getLong("nd"));
				item.setBh(rs.getString("bh"));
				item.setMc(rs.getString("mc"));
				item.setJsgm(rs.getString("jsgm"));
				item.setHzfs(rs.getString("hzfs"));
				item.setLxdw(rs.getString("lxdw"));
				item.setLxr(rs.getString("lxr"));
				item.setLxdh(rs.getString("lxdh"));
				item.setQqgz(rs.getString("qqgz"));
				item.setZtz(rs.getString("ztz"));
				item.setDq(rs.getString("dq"));
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
	 * ��ȡ������Ŀ��Ϣ����
	 * @param nd   ���
	 * @param lb1     ��𣺴���
	 * @param lb2     ���С��
	 * @param dq   ��������
	 * @param ztz1  �жϷ���ȫ�������ڵ��ڡ����ڣ�
	 * @param ztz1num ��ֵ1
	 * @param ztz2  �жϷ���ȫ����С�ڣ�
	 * @param ztz2num ��ֵ2
	 * @return List itemlist 
	 */
	public static List<ProZsxm> showXxhzList(String nd,String  lb1,String lb2, String dq, String ztz1,String ztz1num ,String ztz2,String ztz2num){
		// ������Ŀ��Ϣ�б�
		List<ProZsxm> itemlist = new ArrayList<ProZsxm>() ;
		// ��ȡ���ݿ�����
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		// ������ѯ�������
		String tempSql = " where ";
		
		if(nd != null && !nd.equals("")){		// ���
			tempSql += " nd ="+nd+"      and ";	
		}

		if(lb1 != null && !lb1.equals("")){		// ��𣺴���
			tempSql += " lb1 ='"+lb1+"'      and ";	
		}
		
		if(lb2 != null && !lb2.equals("")){		// ���С��
			tempSql += " lb2 ='"+lb2+"'      and ";	
		}
		if(dq != null && !dq.equals("")){		// ��������
			tempSql += " dq ='"+dq+"'      and ";	
		}
		
		if(ztz1 != null && !ztz1.equals("")){	 // �жϷ���ȫ�������ڵ��ڡ����ڣ�
			if("".equals(ztz1num)){	// �����ֵ1Ϊ�գ���ȡ0
				ztz1num = "0";
			}
			tempSql +=  " ztz " + ztz1 + ztz1num+"      and ";	
		}
		
		if(ztz2 != null && !ztz2.equals("")){	// �жϷ���ȫ����С�ڣ�
			if("".equals(ztz2num)){	// �����ֵ2Ϊ�գ���ȡ0
				ztz2num = "0";
			}
			tempSql += " ztz " + ztz2 + ztz2num+"      and ";
		}
		// �滻�жϷ���
		tempSql = tempSql.replaceAll("dydy", ">=").replaceAll("dy", "=").replaceAll("xy", "<");
		// ��ȡ��ѯ���
		tempSql = tempSql.substring(0,tempSql.length()-6);
		// ������ѯ���
		String sql = "select * from tb_zs_project  "+tempSql+"  order by nd desc";
		//����ȡ��ѯ���
		try {
			stat = conn.prepareStatement(sql);	
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				ProZsxm item = new ProZsxm();

				item.setId(rs.getLong("id"));
				item.setNd(rs.getLong("nd"));
				item.setBh(rs.getString("bh"));
				item.setMc(rs.getString("mc"));
				item.setDq(rs.getString("dq"));
				item.setJsgm(rs.getString("jsgm"));
				item.setHzfs(rs.getString("hzfs"));
				item.setLxr(rs.getString("lxr"));
				item.setLxdh(rs.getString("lxdh"));
				item.setLxdw(rs.getString("lxdw"));
				item.setQqgz(rs.getString("qqgz"));
				item.setZtz(rs.getString("ztz"));
				item.setDq(rs.getString("dq"));
                item.setLb(rs.getString("lb"));
                item.setLb1(rs.getString("lb1"));
                item.setLb2(rs.getString("lb2"));
                item.setLb3(rs.getString("lb3"));
                
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
