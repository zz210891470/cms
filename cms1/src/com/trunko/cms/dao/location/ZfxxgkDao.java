package com.trunko.cms.dao.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.entity.WebZfxxgk;
import com.trunko.cms.entity.WebInfoGuide;
import com.trunko.cms.entity.WebInfoReg;
import com.trunko.cms.entity.WebInfoReport;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.Pager;

public class ZfxxgkDao {

	/**
	 * �õ�����ģ������
	 * @return
	 */
	public String getInfoguide(String loc){
		
		WebInfoGuide webInfoGuide=new WebInfoGuide();
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String data="";

		try {
			stat = conn.createStatement();
			String bt="";
			if(loc.equals("gkzn")){
				bt="����ָ��";
			}else if(loc.equals("ysqgk")){
				bt="���빫��";
				data+="<div style='text-align:left;width:90%;'><a href='zfxxgk.htm?loc=zfxxgk&lb=ysqgk' target='_self'>�����빫��</a> | ";
				data+="<a href='zfxxgk.htm?loc=zfxxgk&lb=sfxm' target='_self'>�շ���Ŀ�ͱ�׼</a> | ";
				data+="<a href='zfxxgk.htm?loc=zfxxgk&lb=lct' target='_self'>���빫������ͼ</a></div>";
			}else if(loc.equals("sfxm")){
				bt="�շ���Ŀ�ͱ�׼";
				data+="<div style='text-align:left;width:90%;'><a href='zfxxgk.htm?loc=zfxxgk&lb=ysqgk' target='_self'>�����빫��</a> | ";
				data+="<a href='zfxxgk.htm?loc=zfxxgk&lb=sfxm' target='_self'>�շ���Ŀ�ͱ�׼</a> | ";
				data+="<a href='zfxxgk.htm?loc=zfxxgk&lb=lct' target='_self'>���빫������ͼ</a></div>";
			}else if(loc.equals("lct")){
				bt="���빫������ͼ";
				data+="<div style='text-align:left;width:90%;'><a href='zfxxgk.htm?loc=zfxxgk&lb=ysqgk' target='_self'>�����빫��</a> | ";
				data+="<a href='zfxxgk.htm?loc=zfxxgk&lb=sfxm' target='_self'>�շ���Ŀ�ͱ�׼</a> | ";
				data+="<a href='zfxxgk.htm?loc=zfxxgk&lb=lct' target='_self'>���빫������ͼ</a></div>";
			}
			String sql = "select * from web_infoguide where topic='"+bt+"'";
			rs = stat.executeQuery(sql);
			
			if(rs.next()){
				webInfoGuide.setTopic(rs.getString("topic"));
				webInfoGuide.setContent(rs.getString("content"));
			}
	
			data+="<div id='div_bt'>"+webInfoGuide.getTopic()+"</div>";
			data+="<div id='div_nr'>"+webInfoGuide.getContent()+"</div>";
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}

		return data;
		
	}
	
	public String getInfoopen(Long id){
	
		WebZfxxgk webZfxxgk=new WebZfxxgk();
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
		String data="";

		try {

			String sql = "select * from web_infoopen where id=?";
			stat = conn.prepareStatement(sql);
			stat.setLong(1, id);
			rs = stat.executeQuery();
			
			if(rs.next()){
				webZfxxgk.setId(rs.getLong("id"));
				webZfxxgk.setBt(rs.getString("syh"));
				webZfxxgk.setFl(rs.getString("fl"));
				webZfxxgk.setFbjg(rs.getString("fbjg"));
				webZfxxgk.setFwrq(rs.getDate("fwrq"));
				webZfxxgk.setBt(rs.getString("bt"));
				webZfxxgk.setWh(rs.getString("wh"));
				webZfxxgk.setZtc(rs.getString("ztc"));
				webZfxxgk.setNr(rs.getString("nr"));
			}
	
			data+="<div id='div_bt'>"+webZfxxgk.getBt()+"</div>";
			data+="<div id='div_nr'>"+webZfxxgk.getNr()+"</div>";
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}

		return data;
		
	}
	
    /**
     * �õ���ҳ��������Ϣ������Ŀ¼
     * @param pageNo
     * @param pageSize
     * @param searchStr
     * @param pid
     * @return
     */
	public String getArticleForPageGkml(int pageNo,int pageSize){
		
		List<WebZfxxgk> infoopenlist=new ArrayList<WebZfxxgk>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String data="";
        int count=0;
  
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_infoopen";		
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}

			String sql = "select * from web_infoopen limit "+((pageNo-1)*pageSize)+" , "+pageSize;
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				WebZfxxgk webZfxxgk=new WebZfxxgk();
                
				webZfxxgk.setId(rs.getLong("id"));
				webZfxxgk.setBt(rs.getString("syh"));
				webZfxxgk.setFl(rs.getString("fl"));
				webZfxxgk.setFbjg(rs.getString("fbjg"));
				webZfxxgk.setFwrq(rs.getDate("fwrq"));
				webZfxxgk.setBt(rs.getString("bt"));
				webZfxxgk.setWh(rs.getString("wh"));
				webZfxxgk.setZtc(rs.getString("ztc"));
				webZfxxgk.setNr(rs.getString("nr"));
				infoopenlist.add(webZfxxgk);
			}
			
			for(WebZfxxgk w:infoopenlist){
				data+="<div class='div_lb'><span style='float:left;'>��</span><a href='ShowArticle.htm?lb=xxgk&id="+w.getId()+"' target='_blank'>"+w.getBt()+"</a><span>"+w.getFwrq().toString().split(" ")[0]+"</span></div>";
			}
			if(data==""){
				data+="<div style='padding:30px;'>��Ŀ������Ϣ��</div>";
			}else{
				if((count%10)>=1){
					data+="<div id='bottom'><span id='pagecount' data-num='"+(count/10+2)+"'>����"+count+"����¼&nbsp;&nbsp;��"+pageNo+"ҳ/��"+((count/10)+1)+"ҳ&nbsp;&nbsp;<a href='javascript:gopage(1,'gkml')' >��ҳ</a>&nbsp;&nbsp;<a href='javascript:gopage("+(pageNo-1)+",'gkml')' >��һҳ</a>&nbsp;&nbsp;<a href='javascript:gopage("+(pageNo+1)+",'gkml')'>��һҳ</a>&nbsp;&nbsp;<a href='javascript:gopage("+((count/10)+1)+",'gkml')' >ĩҳ</a></span></div>";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return data;
	}
	
	/**
     * �õ���ҳ��������Ϣ�������涨
     * @param pageNo
     * @param pageSize
     * @param searchStr
     * @param pid
     * @return
     */
	public String getArticleForPageGkgd(int pageNo,int pageSize){
		
		List<WebInfoReg> inforeglist=new ArrayList<WebInfoReg>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String data="";
        int count=0;
  
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_inforeg";		
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}

			String sql = "select * from web_inforeg limit "+((pageNo-1)*pageSize)+" , "+pageSize;
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				WebInfoReg webInfoReg=new WebInfoReg();
                
				webInfoReg.setId(rs.getLong("id"));
				webInfoReg.setTopic(rs.getString("topic"));
				webInfoReg.setContent(rs.getString("content"));
				webInfoReg.setTime(rs.getDate("time"));
				inforeglist.add(webInfoReg);
			}
			
			for(WebInfoReg w:inforeglist){
				data+="<div class='div_lb'><span style='float:left;'>��</span><a href='ShowArticle.htm?lb=gkgd&id="+w.getId()+"' target='_blank'>"+w.getTopic()+"</a><span>"+w.getTime().toString().split(" ")[0]+"</span></div>";
			}
			if(data==""){
				data+="<div style='padding:30px;'>��Ŀ������Ϣ��</div>";
			}else{
				if((count%10)>=1){
					data+="<div id='bottom'><span id='pagecount' data-num='"+(count/10+2)+"'>����"+count+"����¼&nbsp;&nbsp;��"+pageNo+"ҳ/��"+((count/10)+1)+"ҳ&nbsp;&nbsp;<a href='javascript:gopage(1,'gkgd')' >��ҳ</a>&nbsp;&nbsp;<a href='javascript:gopage("+(pageNo-1)+",'gkgd')' >��һҳ</a>&nbsp;&nbsp;<a href='javascript:gopage("+(pageNo+1)+",'gkgd')'>��һҳ</a>&nbsp;&nbsp;<a href='javascript:gopage("+((count/10)+1)+",'gkgd')' >ĩҳ</a></span></div>";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return data;
	}
	
	/**
     * �õ���ҳ��������Ϣ����ȱ���
     * @param pageNo
     * @param pageSize
     * @param searchStr
     * @param pid
     * @return
     */
	public String getArticleForPageNdbg(int pageNo,int pageSize){
		
		List<WebInfoReport> inforeportlist=new ArrayList<WebInfoReport>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String data="";
        int count=0;
  
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_inforeport";		
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}

			String sql = "select * from web_inforeport limit "+((pageNo-1)*pageSize)+" , "+pageSize;
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				WebInfoReport webInfoReport=new WebInfoReport();
                
				webInfoReport.setId(rs.getLong("id"));
				webInfoReport.setTopic(rs.getString("topic"));
				webInfoReport.setContent(rs.getString("content"));
				webInfoReport.setTime(rs.getDate("time"));
				inforeportlist.add(webInfoReport);
			}
			
			for(WebInfoReport w:inforeportlist){
				data+="<div class='div_lb'><span style='float:left;'>��</span><a href='ShowArticle.htm?lb=ndbg&id="+w.getId()+"' target='_blank'>"+w.getTopic()+"</a><span>"+w.getTime().toString().split(" ")[0]+"</span></div>";
			}
			if(data==""){
				data+="<div style='padding:30px;'>��Ŀ������Ϣ��</div>";
			}else{
				if((count%10)>=1){
					data+="<div id='bottom'><span id='pagecount' data-num='"+(count/10+2)+"'>����"+count+"����¼&nbsp;&nbsp;��"+pageNo+"ҳ/��"+((count/10)+1)+"ҳ&nbsp;&nbsp;<a href='javascript:gopage(1,'ndbg')' >��ҳ</a>&nbsp;&nbsp;<a href='javascript:gopage("+(pageNo-1)+",'ndbg')' >��һҳ</a>&nbsp;&nbsp;<a href='javascript:gopage("+(pageNo+1)+",'ndbg')'>��һҳ</a>&nbsp;&nbsp;<a href='javascript:gopage("+((count/10)+1)+",'ndbg')' >ĩҳ</a></span></div>";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return data;
	}
}