package com.trunko.project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.FavoritesHelper;
import com.trunko.cms.util.Pager;
import com.trunko.project.entity.ProCbxm;
import com.trunko.project.entity.ProIndustry;

/**
 * ������Ŀ���ݴ�����
 * @author jianhuang
 *
 */
public class CbxmDao {
	
	

	/**
	 * ��ȡ��������б�
	 * @return List<String> itemlist
	 */
	public static List<String> getLb1List(){
		// ���������б�����
		List<String> itemlist = new ArrayList<String>() ;
		// ��ȡ����
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		try {
			// �ص���Ŀ����������ѯ���
			String sql = "select * from tb_industry where lx='cb' and pid =0 order by px asc  ";
			stat = conn.prepareStatement(sql);	
			// ��ȡ��ѯ���
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				itemlist.add(rs.getString("mc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ͷ�����
			DBHelper.closeDB(conn, stat, rs);
		}
		return itemlist;
	}
	
	
	public static List<ProCbxm> getAllProList(String nd){
		
		// ������Ŀ��Ϣ�б�
		List<ProCbxm> itemlist = new ArrayList<ProCbxm>() ;
		// ��ȡ���ݿ�����
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		
		// ������ѯ���
		String sql = "select * from tb_cb_project  where zt != 'δ�ϱ�' and nd="+nd;
		//����ȡ��ѯ���
		try {
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
		
		return itemlist;
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
	public static List<ProCbxm> showXxhzList(String nd,String  lb1,String lb2, String dq, String ztz1,String ztz1num ,String ztz2,String ztz2num){
		// ������Ŀ��Ϣ�б�
		List<ProCbxm> itemlist = new ArrayList<ProCbxm>() ;
		// ��ȡ���ݿ�����
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		// ������ѯ�������
		String tempSql = "";
		
		if(nd != null && !nd.equals("")){		// ���
			tempSql += " and nd ="+nd;	
		}

		if(lb1 != null && !lb1.equals("")){		// ��𣺴���
			tempSql += " and lb1 ='"+lb1+"'";	
		}
		
		if(lb2 != null && !lb2.equals("")){		// ���С��
			tempSql += " and lb2 ='"+lb2+"'";	
		}
		if(dq != null && !dq.equals("")){		// ��������
			tempSql += " and dq ='"+dq+"'";	
		}
		
		if(ztz1 != null && !ztz1.equals("")){	 // �жϷ���ȫ�������ڵ��ڡ����ڣ�
			if("".equals(ztz1num)){	// �����ֵ1Ϊ�գ���ȡ0
				ztz1num = "0";
			}
			tempSql +=  " and ztz " + ztz1 + ztz1num;	
		}
		
		if(ztz2 != null && !ztz2.equals("")){	// �жϷ���ȫ����С�ڣ�
			if("".equals(ztz2num)){	// �����ֵ2Ϊ�գ���ȡ0
				ztz2num = "0";
			}
			tempSql += " and ztz " + ztz2 + ztz2num;
		}
		// �滻�жϷ���
		tempSql = tempSql.replaceAll("dydy", ">=").replaceAll("dy", "=").replaceAll("xy", "<");
		// ������ѯ���
		String sql = "select * from tb_cb_project  where zt = '�����' "+tempSql+" order by bssj desc";
		//����ȡ��ѯ���
		try {
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
		
		return itemlist;
	}
	
	
	
	
	
	public static boolean audit(String id,String zt ,String shyj){
		
		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
        
		String sql = "update tb_cb_project set zt='"+zt+"'"
		                                   +" , shyj='"+shyj+"'"
			                               +" where id=?";

		System.out.println(sql);
	
		try {
   			stat = conn.prepareStatement(sql);			

   			stat.setLong(1, Long.valueOf(id));

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
	
	
	public static boolean commit(String id){
		
		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
        
		String sql = "update tb_cb_project set zt='���ϱ�'"
			                               +" where id=?";

		System.out.println(sql);
	
		try {
   			stat = conn.prepareStatement(sql);			

   			stat.setLong(1, Long.valueOf(id));

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
	
	
	public static String getLbList(){
		

  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
        String data = "";
		try {

			//TODO ���ӷ�ҳ���� �޸ı���
			String sql = "select * from tb_industry where lx='cb' order by px asc  ";
				         
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

	/**
	 * ��ȡ�����Ϣ�еĴ���  add by lhanliang
	 * 
	 * @return List<ProIndustry> bigLbList
	 */
	public static List<ProIndustry> getBigLbList() {
		// ����list����
		List<ProIndustry> bigLbList = new ArrayList<ProIndustry>();
		// ��ȡ���ݿ�����
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "select * from tb_industry where lx='cb' and pid=0 order by px asc  ";
		//����ȡ��ѯ���
		try {
			stat = conn.prepareStatement(sql);	
			rs = stat.executeQuery(sql);	
			while(rs.next()){
				// ��������ʵ�����
				ProIndustry item = new ProIndustry();

				item.setId(rs.getLong("id"));  // ����
				item.setPid(rs.getLong("pid")); // ��������
				item.setMc(rs.getString("mc")); // ����
				item.setPx(rs.getLong("px"));  // �����
				item.setLx(rs.getString("lx"));  // ����
				
				bigLbList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return bigLbList;

	}
	
	

	public static List<String> getDqList(){
		
		List<String> itemlist = new ArrayList<String>() ;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;

		try {

			//TODO ���ӷ�ҳ���� �޸ı���
			String sql = "select * from tb_area where lx='cb' order by px asc  ";
				         
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
	 * ���Ӷ���
	 * @param item
	 * @return
	 */
	public static boolean xlsImport(List<ProCbxm> itemList){

		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	

		String sql = "insert into tb_cb_project(nd,bh,mc,dq,jsgm,jsdd,ztz,xyfx,sbdw,lxr,lxdh,chdw,lxr1,lxdh1,bgs,bssj,zt,lb1,lb2,shyj,dzyx,dzyx1,dzyx2,zzdj,cbdw,lxr2,lxdh2,hzfs,lygc,tjzk,jsjjzb,jstj)"
		                              +" values";
		
		for(int i = 0; i < itemList.size(); i ++){
			
			sql += " (? ,? ,? ,?   ,?   ,?   ,?  ,?   ,? ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?  )  ,";
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
   	   			stat.setString(count+3, itemList.get(i).getDq());
   	   			stat.setString(count+4, itemList.get(i).getJsgm());
   	   			stat.setString(count+5, itemList.get(i).getJsdd());
   	   			stat.setDouble(count+6, itemList.get(i).getZtz());
   	   			stat.setString(count+7, itemList.get(i).getXyfx());
   	   			stat.setString(count+8, itemList.get(i).getSbdw());
   	   			stat.setString(count+9, itemList.get(i).getLxr());
   	   			stat.setString(count+10, itemList.get(i).getLxdh());
   	   			stat.setString(count+11, itemList.get(i).getChdw());
   	   			stat.setString(count+12, itemList.get(i).getLxr1());
   	   			stat.setString(count+13, itemList.get(i).getLxdh1());
   	   			stat.setString(count+14, itemList.get(i).getBgs());
   	   			stat.setDate(count+15, itemList.get(i).getBssj());
   	   			stat.setString(count+16, itemList.get(i).getZt());
   	   			stat.setString(count+17, itemList.get(i).getLb1());
   	   			stat.setString(count+18, itemList.get(i).getLb2());
   	   			stat.setString(count+19, itemList.get(i).getShyj());
	   	   		
   	   			stat.setString(count+20, itemList.get(i).getDzyx());
	   			stat.setString(count+21, itemList.get(i).getDzyx1());
	   			stat.setString(count+22, itemList.get(i).getDzyx2());
	   			stat.setString(count+23, itemList.get(i).getZzdj());
	   			stat.setString(count+24, itemList.get(i).getCbdw());
	   			stat.setString(count+25, itemList.get(i).getLxr2());
	   			stat.setString(count+26, itemList.get(i).getLxdh2());
	   			stat.setString(count+27, itemList.get(i).getHzfs());
	   			stat.setString(count+28, itemList.get(i).getLygc());
	   			stat.setString(count+29, itemList.get(i).getTjzk());
	   			stat.setString(count+30, itemList.get(i).getJsjjzb());
	   			stat.setString(count+31, itemList.get(i).getJstj());
   				
   	   			count = count + 32;
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
	public static boolean update(ProCbxm item){
		
		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
        
		String sql = "update tb_cb_project set nd=?"
				                           +",bh=?"
			                               +",mc=?"
			                               +",dq=?"
				                           +",jsgm=?"
			                               +",jsdd=?"
				                           +",ztz=?"
			                               +",xyfx=?"
				                           +",sbdw=?"
			                               +",lxr=?"
			                               +",lxdh=?"
			                               +",chdw=?"
			                               +",lxr1=?"
			                               +",lxdh1=?"
			                               +",bgs=?"
			                               +",bssj=?"
			                               +",lb1=?"
			                               +",lb2=?" 
			                               +",dzyx=?" 
			                               +",dzyx1=?" 
			                               +",dzyx2=?" 
			                               +",zzdj=?" 
			                               +",cbdw=?" 
			                               +",lxr2=?" 
			                               +",lxdh2=?" 
			                               +",hzfs=?" 
			                               +",lygc=?" 
			                               +",tjzk=?" 
			                               +",jsjjzb=?" 
			                               +",jstj=?" 
			                               +" where id=?";
		System.out.println(sql);
	
		try {
   			stat = conn.prepareStatement(sql);			

   			stat.setLong(1, item.getNd());
   			stat.setString(2, item.getBh());
   			stat.setString(3, item.getMc());
   			stat.setString(4, item.getDq());
   			stat.setString(5, item.getJsgm());
   			stat.setString(6, item.getJsdd());
   			stat.setDouble(7, item.getZtz());
   			stat.setString(8, item.getXyfx());
   			stat.setString(9, item.getSbdw());
   			stat.setString(10, item.getLxr());
   			stat.setString(11, item.getLxdh());
   			stat.setString(12, item.getChdw());
   			stat.setString(13, item.getLxr1());
   			stat.setString(14, item.getLxdh1());
   			stat.setString(15, item.getBgs());
   			stat.setDate(16, item.getBssj());
   			
   			
   			stat.setString(17, item.getLb1());
   			stat.setString(18, item.getLb2());
   			
   			stat.setString(19, item.getDzyx());
   			stat.setString(20, item.getDzyx1());
   			stat.setString(21, item.getDzyx2());
   			stat.setString(22, item.getZzdj());
   			stat.setString(23, item.getCbdw());
   			stat.setString(24, item.getLxr2());
   			stat.setString(25, item.getLxdh2());
   			stat.setString(26, item.getHzfs());
   			stat.setString(27, item.getLygc());
   			stat.setString(28, item.getTjzk());
   			stat.setString(29, item.getJsjjzb());
   			stat.setString(30, item.getJstj());
   			
   			stat.setLong(31, item.getId());
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
	 * ���Ӷ���
	 * @param item
	 * @return
	 */
	public static boolean add(ProCbxm item){

		Boolean isOk = false;
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	

		String sql = "insert into tb_cb_project(nd,bh,mc,dq,jsgm,jsdd,ztz,xyfx,sbdw,lxr,lxdh,chdw,lxr1,lxdh1,bgs,bssj,zt,lb1,lb2,sbyh,dzyx,dzyx1,dzyx2,zzdj,cbdw,lxr2,lxdh2,hzfs,lygc,tjzk,jsjjzb,jstj)"
		                              +" values(? ,? ,? ,? ,?   ,?   ,?  ,?   ,?   ,?  ,?   ,?   ,?   ,?    ,?  ,?   ,? ,?  , ? ,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		System.out.println(sql);
	
		try {
   			stat = conn.prepareStatement(sql);			

   			stat.setLong(1, item.getNd());
   			stat.setString(2, item.getBh());
   			stat.setString(3, item.getMc());
   			stat.setString(4, item.getDq());
   			stat.setString(5, item.getJsgm());
   			stat.setString(6, item.getJsdd());
   			stat.setDouble(7, item.getZtz());
   			stat.setString(8, item.getXyfx());
   			stat.setString(9, item.getSbdw());
   			stat.setString(10, item.getLxr());
   			stat.setString(11, item.getLxdh());
   			stat.setString(12, item.getChdw());
   			stat.setString(13, item.getLxr1());
   			stat.setString(14, item.getLxdh1());
   			stat.setString(15, item.getBgs());
   			stat.setDate(16, item.getBssj());

   			stat.setString(17, item.getZt());
   			stat.setString(18, item.getLb1());
   			stat.setString(19, item.getLb2());
   			stat.setString(20, item.getSbyh());
   			
   			stat.setString(21, item.getDzyx());
   			stat.setString(22, item.getDzyx1());
   			stat.setString(23, item.getDzyx2());
   			stat.setString(24, item.getZzdj());
   			stat.setString(25, item.getCbdw());
   			stat.setString(26, item.getLxr2());
   			stat.setString(27, item.getLxdh2());
   			stat.setString(28, item.getHzfs());
   			stat.setString(29, item.getLygc());
   			stat.setString(30, item.getTjzk());
   			stat.setString(31, item.getJsjjzb());
   			stat.setString(32, item.getJstj());
   			
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

	    String sql = "delete from tb_cb_project where ";
		
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
	public static ProCbxm getObjById(Long id){
		
  		Connection conn = DBHelper.getConnection();
        PreparedStatement stat = null;	
		ResultSet rs = null;
		
		ProCbxm item =new ProCbxm();

        String sql = "select * from tb_cb_project where id=?";
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
                
                item.setDzyx(rs.getString("dzyx"));
        		item.setDzyx1(rs.getString("dzyx1"));
        		item.setDzyx2(rs.getString("dzyx2"));
        		item.setZzdj(rs.getString("zzdj"));
        		item.setCbdw(rs.getString("cbdw"));
        		item.setLxr2(rs.getString("lxr2"));
        		item.setLxdh2(rs.getString("lxdh2"));
        		item.setHzfs(rs.getString("hzfs"));
        		item.setLygc(rs.getString("lygc"));
        		item.setJstj(rs.getString("jstj"));
        		item.setJsjjzb(rs.getString("jsjjzb"));
        		item.setTjzk(rs.getString("tjzk"));
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
			//TODO ���ӷ�ҳͳ������ �޸ı���
			String countsql = "select count(*) as num    from tb_cb_project where zt='�����' "+tempSql;
			stat = conn.prepareStatement(countsql);	
			
			rs=stat.executeQuery(countsql);
			
			if(rs.next()){
				count = rs.getInt("num");
			}

			//TODO ���ӷ�ҳ���� �޸ı���
			String sql = "select * from tb_cb_project where zt='�����'  "+tempSql+" order by bssj desc limit "
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
	
	/**
	 * �õ���˷�ҳ������
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static Pager getObjForAudit(int pageNo, int pageSize, String searchStr){
		
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
			//TODO ���ӷ�ҳͳ������ �޸ı���
			String countsql = "select count(*) as num  from tb_cb_project where zt='���ϱ�' "+tempSql;
			stat = conn.prepareStatement(countsql);	
			
			rs=stat.executeQuery(countsql);
			
			if(rs.next()){
				count = rs.getInt("num");
			}

			//TODO ���ӷ�ҳ���� �޸ı���
			String sql = "select * from tb_cb_project where zt='���ϱ�'  "+tempSql+" order by bssj desc limit "
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




	/**
	 * ��ȡ�������ͳ����Ϣ
	 * @param year ���
	 * @return  Map<String, List<String>> sortInfoMap
	 */
	public static Map<String, List<String>> getSortInfoMap(String year) {
		// ����ͳ����Ϣ���ϣ�key:������ƣ�value:�������Ӧ����Ŀ��������Ͷ�ʣ�
		Map<String, List<String>> sortInfoMap = new HashMap<String, List<String>>();
		// ������
		List<ProIndustry> sortList = getBigLbList();
		//��������𣬸���������ƺ����ڲ�ѯ������µĸ���Ŀ����������Ͷ��
		if (sortList != null) { 
			for (int i = 0; i < sortList.size(); i++) {
				List<String> countList = new ArrayList<String>(); // ͳ����Ϣ���ϰ�����Ŀ��������Ͷ��
				ProIndustry industry = sortList.get(i); // ������
				String sortName = industry.getMc();	// ��������
				// ��Ŀ��������Ͷ��SQL
				String countSql = "select count(*) as num,sum(t.ztz) as num1 from tb_cb_project t where t.zt = '�����' and t.lb1 = '"+ sortName +"'"; 
				if(!"".equals(year) && null != year){ // �����Ȳ�Ϊ��
					countSql += " and t.nd =" + year;
				}
				// ��ȡ���ݿ�����
				Connection conn = DBHelper.getConnection();
				PreparedStatement stat = null;
				ResultSet rs = null;
				try {
					// ��ѯ��Ŀ��������Ͷ�ʽ��
					stat = conn.prepareStatement(countSql);	
					rs = stat.executeQuery(countSql);	
					while(rs.next()){
						countList.add(rs.getInt("num")+"");
						countList.add(rs.getInt("num1")+"");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {  // �ͷ�����
					DBHelper.closeDB(conn, stat, rs);
				}
				// ���ӷ�����Ϣ
				sortInfoMap.put(sortName, countList);
			}
		}
		return sortInfoMap;
	}
	/**
	 * ��ȡ�ּ�����ͳ����Ϣ
	 * @param year ���
	 * @return  Map<String, List<String>> sortInfoMap
	 */
	public static Map<String, List<String>> getAreaInfoMap(String year) {
		// �ּ�ͳ����Ϣ���ϣ�key:�����������ƣ�value:��������Ӧ����Ŀ��������Ͷ�ʣ�
		Map<String, List<String>> areaInfoMap = new HashMap<String, List<String>>();
		// ������������
		List<String> areaList = getDqList();
		//�������������ϣ����ݵ������ƺ����ڲ�ѯ�������µĸ���Ŀ����������Ͷ��
		if (areaList != null) { 
			for (int i = 0; i < areaList.size(); i++) {
				List<String> countList = new ArrayList<String>(); // ͳ����Ϣ���ϣ�������Ŀ��������Ͷ��
				String areaName = areaList.get(i);	// ��������
				// ��Ŀ��������Ͷ��SQL
				String countSql = "select count(*) as num, sum(t.ztz) as num2 from tb_cb_project t where t.zt = '�����' and t.dq = '"+ areaName +"'"; 
				if(!"".equals(year) && null != year){ // �����Ȳ�Ϊ��
					countSql += " and t.nd =" + year;
				}
				// ��ȡ���ݿ�����
				Connection conn = DBHelper.getConnection();
				PreparedStatement stat = null;
				ResultSet rs = null;
				try {
					// ��ѯ��Ŀ��������Ͷ��SQL
					stat = conn.prepareStatement(countSql);	
					rs = stat.executeQuery(countSql);	
					while(rs.next()){
						countList.add(rs.getInt("num")+"");
						countList.add(rs.getInt("num2")+"");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {  // �ͷ�����
					DBHelper.closeDB(conn, stat, rs);
				}
				// ���ӷּ���Ϣ
				areaInfoMap.put(areaName, countList);
			}
		}
		return areaInfoMap;
	}
	
	  public  static boolean saveToWebInfo(ProCbxm item){
		  String sql="insert into web_infomation(lmid,bt,rq,nr,zt,fbr)values(?,?,?,?,?,?)";
		  Connection conn = null;
		  PreparedStatement ps = null;
		  conn =DBHelper.getConnection();
		  try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, 73);
			ps.setString(2,item.getMc() );
			ps.setDate(3, new Date(new java.util.Date().getTime()));
			
			String data="";
			
			data+="<table border='1' style='width:95%;margin:0 auto;' align='center' >";
			if(item.getDq()!=null){
				data+="<tr><td height=\"30\" width='120' align=\"center\" >��������</td><td height='30'>"+item.getDq()+"</td></tr>";
			}else{
				data+="<tr><td height='30' align=\"center\" >��������</td><td height='30'></td></tr>";
			}
			
			data+="<tr><td height=\"30\" align=\"center\" >��Ŀ����</td><td height='30'>"+item.getMc()+"</td></tr>";
			if(item.getLb2()==null){
				data+="<tr><td height='30' align=\"center\" >��ҵ���</td><td height='30'>����:"+item.getLb1()+"</br>С��:</td></tr>";
				
			}else{
				data+="<tr><td height='30' align=\"center\" >��ҵ���</td><td height='30'>����:"+item.getLb1()+"</br>С��:"
				+item.getLb2()+"</td></tr>";
			}
			
			
			data+="<tr><td height='30' align=\"center\">��ϵ��λ</td><td height='30'>"+item.getSbdw()+"</td></tr>";
			data+="<tr><td height='30' align=\"center\">��ϵ��ʽ</td><td height='30'>��ϵ��:"+item.getLxr()+"&nbsp;&nbsp;" +
					"�绰:"+item.getLxdh()+"&nbsp;&nbsp;"+"��������:"+item.getDzyx()+"</td></tr>";
			data+="<tr><td height='30' align=\"center\">�а쵥λ</td><td height='30'>"+item.getCbdw()+"</td></tr>";
			data+="<tr><td height='30' align=\"center\">��ϵ��ʽ</td><td height='30'>��ϵ��:"+item.getLxr2()+"&nbsp;&nbsp;" +
			"�绰:"+item.getLxdh2()+"&nbsp;&nbsp;"+"��������:"+item.getDzyx2()+"</td></tr>";
			data+="<tr><td height='30' align=\"center\">������ʽ</td><td height='30'>"+item.getHzfs()+"</td></tr>";
			data+="<tr><td height='30' align=\"center\">��������</td><td height='30' align=\"center\">��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��</td></tr>";
			data+="<tr><td height='30' align=\"center\">��Ŀ��������������</td><td height='30'>"+item.getLygc()+"</td></tr>";
			data+="<tr><td height='30' align=\"center\">��Ŀ�ſ�</td><td height='30'><b>�����ģ�����ݣ�</b><br/>"+item.getJsgm()+
					"<br/><b>��Ҫ����������</b><br/>"+item.getJstj()+"<br/>"+"<b>����Ч�������</b><br/>"+item.getXyfx()+"<br/>"+""+"<b>��Ҫ��������ָ�꣺</b><br/>"+item.getJsjjzb()+"</td></tr>";
			
			
			data+="<tr><td height='30' align=\"center\">��Ŀ�ƽ�״��</td><td height='30'>"+item.getTjzk()+"</td></tr></table>";

			ps.setString(4, data);
		    ps.setString(5, "�ѷ���");
		    ps.setString(6, "���������");
		    ps.executeUpdate();
		    
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DBHelper.closeDB(conn, ps);
		}
		return false;
		  	  	 
		 
	 }
	
	
}
