package com.trunko.cms.dao.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import com.trunko.cms.entity.WebColumn;
import com.trunko.cms.entity.WebInfomation;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.FavoritesHelper;



/**
 * 前台子栏目页的数据操作类
 * @author gjz
 *
 */
public class SubColumnDao {

	
	public WebColumn getColumnById(String id){
		WebColumn webColumn=new WebColumn();
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
		String id1 =filterContent(id);

		try {
			
	
			String sql = "select * from web_column where id=?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, Integer.valueOf(id1));
			
			rs = stat.executeQuery();
			
			
			while(rs.next()){
            
				webColumn.setId(rs.getLong("id"));
				webColumn.setSjid(rs.getLong("sjid"));
				webColumn.setLmjb(rs.getString("lmjb"));
				webColumn.setLmmc(rs.getString("lmmc"));
				webColumn.setLmlx(rs.getString("lmlx"));
				webColumn.setLmmx(rs.getString("lmmx"));
				webColumn.setLjdz(rs.getString("ljdz"));
				webColumn.setLmpx(rs.getInt("lmpx"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}

		return webColumn;
		
		
	}
	
	public static String filterContent(String content){  
		   String flt ="'|and|exec|xp_cmdshell|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,";  
		   String filter[] = flt.split("|");  
		 for(int i=0;i<filter.length ; i++)  
		    {  
		      content.replace(filter[i], "");  
		    }  
		     return content;  
		  }  
	
	
	/**
	 * 得到侧边栏页面数据
	 * @return
	 */
	public List<WebColumn> getSiderList(String sjid){
		List<WebColumn> columnlist=new ArrayList<WebColumn>() ;
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
		String sjid1 =filterContent(sjid);

		try {

			String sql = "select * from web_column where sjid=? order by id asc";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, Integer.valueOf(sjid1));
			
			rs = stat.executeQuery();
			
			while(rs.next()){
                WebColumn webColumn=new WebColumn();
                
				webColumn.setId(rs.getLong("id"));
				webColumn.setSjid(rs.getLong("sjid"));
				webColumn.setLmjb(rs.getString("lmjb"));
				webColumn.setLmmc(rs.getString("lmmc"));
				webColumn.setLmlx(rs.getString("lmlx"));
				webColumn.setLmmx(rs.getString("lmmx"));
				webColumn.setLjdz(rs.getString("ljdz"));
				webColumn.setLmpx(rs.getInt("lmpx"));
				columnlist.add(webColumn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}

		return columnlist;
		
	}
	
	/**
	 * 得到内容模板数据
	 * @return
	 */
	public String getRRMBData(Long id){
	
		WebInfomation webInfomation=new WebInfomation();
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
		String data="";
		String id1 =filterContent(String.valueOf(id));

		try {

			String sql = "select * from web_infomation  where   zt='已发布' and lmid=?";
			stat = conn.prepareStatement(sql);
			stat.setLong(1,Long.valueOf(id1));
			
			rs = stat.executeQuery();
			
			if(rs.next()){
				webInfomation.setId(rs.getLong("id"));
				webInfomation.setBt(rs.getString("bt"));
				webInfomation.setBtys(rs.getString("btys"));
				webInfomation.setZy(rs.getString("zy"));
				webInfomation.setFbt(rs.getString("fbt"));
				webInfomation.setIp(rs.getString("ip"));
				webInfomation.setLjwz(rs.getString("ljwz"));
				webInfomation.setLlcs(rs.getInt("llcs"));
				webInfomation.setLmid(rs.getLong("lmid"));
				webInfomation.setLy(rs.getString("ly"));
				webInfomation.setNr(rs.getString("nr"));
				webInfomation.setSx(rs.getString("sx"));
				webInfomation.setSj(rs.getTimestamp("sj"));
				webInfomation.setPlcs(rs.getInt("plcs"));
				webInfomation.setZt(rs.getString("zt"));
				webInfomation.setZz(rs.getString("zz"));
			}
	
			
			data+="<div id='div_bt'>"+webInfomation.getBt()+"</div>";
			data+="<div id='div_nr'>"+webInfomation.getNr()+"</div>";
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}

		return data;
		
	}
	
    /**
     * 得到分页的数据信息
     * @param pageNo
     * @param pageSize
     * @param searchStr
     * @param pid
     * @return
     */
	public String getArticleForPage(int pageNo,int pageSize,Long pid){

		List<WebInfomation> informationlist = new ArrayList<WebInfomation>() ;
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
		String data="";
        int count=0;
        int pn =Integer.valueOf(filterContent(String.valueOf(pageNo)));
        int pz =Integer.valueOf(filterContent(String.valueOf(pageSize)));
        long pd =Long.valueOf(filterContent(String.valueOf(pid)));
		try {
			String countsql="select count(*) as num from web_infomation where   zt='已发布' and lmid=?";		
            stat = conn.prepareStatement(countsql);
			
			stat.setLong(1, pd);
			rs=stat.executeQuery();
			
			if(rs.next()){
				count=rs.getInt("num");
			}
			stat.close();
			rs.close();

			String sql = "select * from web_infomation where  zt='已发布' and  lmid=? order by rq desc limit "+(pn-1)*pz+" , "+pz;
            stat = conn.prepareStatement(sql);
			
			stat.setLong(1,  pd);
			rs=stat.executeQuery();
			
			while(rs.next()){
				WebInfomation webInfomation=new WebInfomation();
				webInfomation.setId(rs.getLong("id"));
				webInfomation.setBt(rs.getString("bt"));
				webInfomation.setRq(rs.getDate("rq"));
				informationlist.add(webInfomation);
			}
			
			for(WebInfomation w:informationlist){
				String tp="";
				if(w.getLstp()!=""&&w.getLstp()!=null){
					tp="<img src='images/img.gif'>&nbsp;";
				}
				if(w.getBt() != null && w.getBt().length()>40){
					w.setBt(w.getBt().substring(0,39));
				}
				data+="<div class='div_lb'><span style='float:left;'>·"+tp+"</span><a href='ShowArticle.htm?lb=info&id="+w.getId()+"' target='_blank' title=\""+w.getBt()+"\">"+w.getBt()+"</a><span>"+w.getRq()+"</span></div>";
			}
			if(data==""){
				data+="<div style='padding:30px;'>栏目暂无信息！</div>";
			}else{
				if(count>10){
					data+="<div id='bottom'><span id='pagecount' data-num='"+(count/10+2)+"'>共有"+count+"条记录&nbsp;&nbsp;第"+pn+"页/共"+((count/10)+1)+"页&nbsp;&nbsp;<a href='javascript:gopage(1,"+pd+")' >首页</a>&nbsp;&nbsp;<a href='javascript:gopage("+(pn-1)+","+pd+")' >上一页</a>&nbsp;&nbsp;<a href='javascript:gopage("+(pn+1)+","+pd+")'>下一页</a>&nbsp;&nbsp;<a href='javascript:gopage("+((count/10)+1)+","+pd+")' >末页</a></span></div>";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		System.out.println("rentrudata");
		return data;
	}

	/**
     * 得到查询结果分页的数据信息
     * @param pageNo
     * @param pageSize
     * @param searchStr
     * @param pid
     * @return
     */
	public String getquearyForPage(int pageNo,int pageSize,String keyword){
		System.out.println("querypage");
		List<WebInfomation> informationlist=new ArrayList<WebInfomation>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String data="";
        int count=0;
        int pn =Integer.valueOf(filterContent(String.valueOf(pageNo)));
        int pz =Integer.valueOf(filterContent(String.valueOf(pageSize)));
        String keywd =filterContent(String.valueOf(keyword));
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_infomation where   zt='已发布' and ( bt like '%"+keywd+"%' or nr like '%"+keywd+"%' )";		
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}

			String sql = "select * from web_infomation where   zt='已发布' and ( bt like '%"+keywd+"%' or nr like '%"+keywd+"%' ) limit "+((pn-1)*pz)+" , "+pz;
			rs = stat.executeQuery(sql);
			while(rs.next()){
				WebInfomation webInfomation=new WebInfomation();
				webInfomation.setId(rs.getLong("id"));
				webInfomation.setBt(rs.getString("bt"));
				webInfomation.setSj(rs.getTimestamp("sj"));
				webInfomation.setLstp(rs.getString("lstp"));
				webInfomation.setRq(rs.getDate("rq"));
				informationlist.add(webInfomation);
			}
			
			for(WebInfomation w:informationlist){
				String tp="";
				if(FavoritesHelper.isNotNull(w.getLstp())){
					tp="<img src='images/img.gif'>&nbsp;";
				}
				if(w.getBt() != null && w.getBt().length()>40){
					w.setBt(w.getBt().substring(0,39));
				}
				data+="<div class='div_lb'><span style='float:left;'>·"+tp+"</span><a href='ShowArticle.htm?lb=info&id="+w.getId()+"' target='_blank' title=\""+w.getBt()+"\">"+w.getBt()+"</a><span>"+w.getRq().toString()+"</span></div>";
			}
			if(data==""){
				data+="<div style='padding:30px;'>没有搜索到相关的信息！</div>";
			}else{
				if(count>10){
				    int	temp = 0;
					if (count % 10 == 0) {
						temp = count / 10;
					} else {
						temp = count / 10 + 1;
					}
					data+="<div id='bottom'><span id='pagecount' data-num='"+(count/10+2)+"'>共有"+count+"条记录&nbsp;&nbsp;第"+pn+"页/共"+temp+"页&nbsp;&nbsp;<a href=\"javascript:gopage(1,'"+keywd+"')\" >首页</a>&nbsp;&nbsp;<a href=\"javascript:gopage("+(pn-1)+",'"+keywd+"')\">上一页</a>&nbsp;&nbsp;<a href=\"javascript:gopage("+(pn+1)+",'"+keywd+"')\">下一页</a>&nbsp;&nbsp;<a href=\"javascript:gopage("+((count/10)+1)+",'"+keywd+"')\" >末页</a></span></div>";
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
     * 得到分页的数据信息
     * @param pageNo
     * @param pageSize
     * @param searchStr
     * @param pid
     * @return
     */
	public String getDownloadForPage(int pageNo,int pageSize,Long pid){
		
		List<WebInfomation> informationlist=new ArrayList<WebInfomation>() ;
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
		String data="";
        int count=0;
        int pn =Integer.valueOf(filterContent(String.valueOf(pageNo)));
        int pz =Integer.valueOf(filterContent(String.valueOf(pageSize)));
        long pd =Long.valueOf(filterContent(String.valueOf(pid)));
        
		try {
			String countsql="select count(*) as num from web_infomation where  zt='已发布'  and lmid=?";		
            stat = conn.prepareStatement(countsql);
			
			stat.setLong(1, pd);
			rs=stat.executeQuery();
			
			if(rs.next()){
				count=rs.getInt("num");
				
			}
			stat.close();
			rs.close();

			String sql = "select * from web_infomation where   zt='已发布' and lmid=? order by rq desc limit "+((pn-1)*pz)+" , "+pz;
			 stat = conn.prepareStatement(sql);
				
				stat.setLong(1, pd);
				rs=stat.executeQuery();
			
			while(rs.next()){
				WebInfomation webInfomation=new WebInfomation();
                
				webInfomation.setId(rs.getLong("id"));
				webInfomation.setBt(rs.getString("bt"));
				webInfomation.setBtys(rs.getString("btys"));
				webInfomation.setZy(rs.getString("zy"));
				webInfomation.setFbt(rs.getString("fbt"));
				webInfomation.setIp(rs.getString("ip"));
				webInfomation.setLjwz(rs.getString("ljwz"));
				webInfomation.setLlcs(rs.getInt("llcs"));
				webInfomation.setLmid(rs.getLong("lmid"));
				webInfomation.setLy(rs.getString("ly"));
				webInfomation.setNr(rs.getString("nr"));
				webInfomation.setSx(rs.getString("sx"));
				webInfomation.setSj(rs.getTimestamp("sj"));
				webInfomation.setPlcs(rs.getInt("plcs"));
				webInfomation.setZt(rs.getString("zt"));
				webInfomation.setZz(rs.getString("zz"));
				
				
				webInfomation.setLstp(rs.getString("lstp"));
				webInfomation.setRd(rs.getString("rd"));
				webInfomation.setHd(rs.getString("hd"));
				webInfomation.setGd(rs.getString("gd"));
				webInfomation.setPx(rs.getLong("px"));
				webInfomation.setRq(rs.getDate("rq"));
				informationlist.add(webInfomation);
			}
			
			for(WebInfomation w:informationlist){
				
				if(w.getBt() != null && w.getBt().length()>40){
					w.setBt(w.getBt().substring(0,39));
				}
				
				data+="<div class='div_xz'><span style='float:left;'>·"+w.getBt()+"&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"cursor:pointer;cursor: hand\"><img height=\"25px\" width=\"106px\"  onclick=\"download('"+w.getLjwz()+"')\" src=\"images/download.jpg\"/></span><input id='ljwz' value='"+w.getLjwz()+"' type='hidden'/><span>&nbsp;&nbsp"+w.getRq()+"</span><br/><span style='float:left;'>&nbsp;&nbsp;文件说明："+w.getNr()+"</span></div>";
			}
			if(data==""){
				data+="<div style='padding:30px;'>栏目暂无信息！</div>";
			}else{
				
				if(count>5){
					data+="<div id='bottom'><span id='pagecount' data-num='"+(count/10+2)+"'>第"+pn+"页/共"+((count/10)+1)+"页&nbsp;&nbsp;<a href='javascript:gopage(1,"+pd+")' >首页</a>&nbsp;&nbsp;<a href='javascript:gopage("+(pn-1)+","+pd+")' >上一页</a>&nbsp;&nbsp;<a href='javascript:gopage("+(pn+1)+","+pd+")'>下一页</a>&nbsp;&nbsp;<a href='javascript:gopage("+((count/10)+1)+","+pd+")' >末页</a></span></div>";
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
