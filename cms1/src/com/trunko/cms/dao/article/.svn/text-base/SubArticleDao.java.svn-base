package com.trunko.cms.dao.article;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.entity.WebInfomation;
import com.trunko.cms.entity.WebSubInfo;

import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.Pager;


/**
 * 专题中的文章的增删改查
 * @author gjz
 *
 */
public class SubArticleDao {
	
	public boolean listrelease(String id){
		
		   String sql="update web_subinfo set zt='已发布' where id="+id;

		   if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		   }
			
		   return false;
		}
	
	public Pager getRecycleForPage(int pageNo,int pageSize, String searchStr,String pid){
		
		
		List<WebSubInfo> informationlist=new ArrayList<WebSubInfo>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		
        int count=0;
        
        String tempSql1="";
        
        if(searchStr==null||searchStr.equals("")){
        	tempSql1="";     	
        }else{
        	tempSql1=" and bt  like '%"+searchStr+"%' "; 	
        }
        
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_subinfo where lmid="+pid+" and  zt='已删除'"+tempSql1;		
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}

			String sql = "select * from web_subinfo where lmid="+pid+" and  zt='已删除' "+tempSql1+ " order by rq desc limit "+((pageNo-1)*pageSize)+" , "+pageSize;
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
	            WebSubInfo webInfomation=new WebSubInfo();
                
				webInfomation.setId(rs.getLong("id"));
				webInfomation.setBt(rs.getString("bt"));
				webInfomation.setBtys(rs.getString("btys"));
				webInfomation.setDd(rs.getString("dd"));
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
				webInfomation.setFbr(rs.getString("fbr"));
				webInfomation.setRq(rs.getDate("rq"));
				informationlist.add(webInfomation);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return new Pager(pageSize, pageNo, count, informationlist);
		

		
	}
	
	public WebSubInfo getBySjid(Long id){
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        WebSubInfo webInfomation=new WebSubInfo();
		try {
			stat = conn.createStatement();
			String countsql="select * from web_subinfo where lmid="+id;
			
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				webInfomation.setId(rs.getLong("id"));
				webInfomation.setBt(rs.getString("bt"));
				webInfomation.setBtys(rs.getString("btys"));
				webInfomation.setDd(rs.getString("dd"));
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
				webInfomation.setFbr(rs.getString("fbr"));
				webInfomation.setRq(rs.getDate("rq"));
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webInfomation;
		
		
		
		
	}
	  public boolean hasArticle(Long id){
	    	
	    	Connection conn = DBHelper.getConnection();
			Statement stat = null;
			ResultSet rs = null;
			try {
				stat = conn.createStatement();
				String countsql="select * from web_subinfo where lmid="+id;
				
				rs=stat.executeQuery(countsql);
				if(rs.next()){
	                return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBHelper.closeDB(conn, stat, rs);
			}
			return false;
			
	    	
	    }
	  
	  
	public boolean update(WebSubInfo webSubInfo){
		String sql="update  web_subinfo set bt='"+webSubInfo.getBt()+"',zz='"+webSubInfo.getZz()
	     +"',nr='"+webSubInfo.getNr()+"',ljwz='"+webSubInfo.getLjwz()+"',fbr='"+webSubInfo.getFbr()
	     +"',rq='"+webSubInfo.getRq()+"',ly='"+webSubInfo.getLy()+"'  where id="+webSubInfo.getId();
		
		System.out.println(sql);
		
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}

	    return false;
		
	}
	
	public boolean updateZt(WebSubInfo webSubInfo){
		String sql="update  web_subinfo set bt='"+webSubInfo.getBt()+"',zz='"+webSubInfo.getZz()
	     +"',nr='"+webSubInfo.getNr()+"',ljwz='"+webSubInfo.getLjwz()+"',zt='"+webSubInfo.getZt()
	     +"',fbr='"+webSubInfo.getFbr()+"',rq='"+webSubInfo.getRq()+"',ly='"+webSubInfo.getLy()+"' where id="+webSubInfo.getId();
		
		System.out.println(sql);
		
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}

	    return false;
		
	}
	public WebSubInfo getById(Long id){
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        WebSubInfo webSubInfo=new WebSubInfo();
		try {
			stat = conn.createStatement();
			String countsql="select * from web_subinfo where id="+id;
			
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				webSubInfo.setId(rs.getLong("id"));
				webSubInfo.setBt(rs.getString("bt"));
				webSubInfo.setBtys(rs.getString("btys"));
				webSubInfo.setDd(rs.getString("dd"));
				webSubInfo.setFbt(rs.getString("fbt"));
				webSubInfo.setIp(rs.getString("ip"));
				webSubInfo.setLjwz(rs.getString("ljwz"));
				webSubInfo.setLlcs(rs.getInt("llcs"));
				webSubInfo.setLmid(rs.getLong("lmid"));
				webSubInfo.setLy(rs.getString("ly"));
				webSubInfo.setNr(rs.getString("nr"));
				webSubInfo.setSx(rs.getString("sx"));
				webSubInfo.setSj(rs.getTimestamp("sj"));
				webSubInfo.setPlcs(rs.getInt("plcs"));
				webSubInfo.setZt(rs.getString("zt"));
				webSubInfo.setZz(rs.getString("zz"));
				webSubInfo.setRq(rs.getDate("rq"));
				webSubInfo.setFbr(rs.getString("fbr"));
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webSubInfo;
		
		
		
		
	}
	

	public boolean add(WebSubInfo webSubInfo){
		
		String sql="insert into web_subinfo(bt,zz,nr,lmid,ljwz,zt,fbr,ly,rq) values('"+webSubInfo.getBt()+"','"+webSubInfo.getZz()
		    +"','"+webSubInfo.getNr()+"',"+webSubInfo.getLmid()+",'"+webSubInfo.getLjwz()+"','"+webSubInfo.getZt()+"','"+webSubInfo.getFbr()+"','"+webSubInfo.getLy()+"','"+webSubInfo.getRq()+"')";
		System.out.println(sql);
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}

		return false;
	}


	
	public boolean delItemListR(String[] itemList){
		
		   String sql="delete from web_subinfo where ";
			
		   for(int i=0;i<itemList.length;i++){	   
			   sql+= " id="+itemList[i]+"  or ";   
		   }
		   sql=sql.substring(0, sql.length()-4);
		   System.out.println(sql);
		   if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		   }
			
		   return false;
		}
	
	
	public boolean delItemList(String[] itemList){
		
		   String sql="update web_subinfo set zt='已删除' where ";
			
		   for(int i=0;i<itemList.length;i++){	   
			   sql+= " id="+itemList[i]+"  or ";   
		   }
		   sql=sql.substring(0, sql.length()-4);
		   System.out.println(sql);
		   if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		   }
			
		   return false;
		}
	
	
	public boolean resume(String[] itemList){
		
		   String sql="update web_subinfo set zt='草稿' where ";
			
		   for(int i=0;i<itemList.length;i++){	   
			   sql+= " id="+itemList[i]+"  or ";   
		   }
		   sql=sql.substring(0, sql.length()-4);
		   System.out.println(sql);
		   if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		   }
			
		   return false;
		}
	
	
	
	
	public Pager getArticleForPage(int pageNo,int pageSize,String searchStr,Long pid){
		
		List<WebSubInfo> informationlist=new ArrayList<WebSubInfo>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		
        int count=0;
        
        String tempSql1="";
        
        if(searchStr==null||searchStr.equals("")){
        	tempSql1="";     	
        }else{
        	tempSql1=" and bt  like '%"+searchStr+"%' "; 	
        }
        
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_subinfo where zt<>'已删除' and  lmid="+pid+tempSql1;		
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}

			String sql = "select * from web_subinfo where zt<>'已删除' and  lmid="+pid+tempSql1+"  order  by rq desc limit "+((pageNo-1)*pageSize)+" , "+pageSize;
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				WebSubInfo webInfomation=new WebSubInfo();
                
				webInfomation.setId(rs.getLong("id"));
				webInfomation.setBt(rs.getString("bt"));
				webInfomation.setBtys(rs.getString("btys"));
				webInfomation.setDd(rs.getString("dd"));
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
				webInfomation.setRq(rs.getDate("rq"));
				webInfomation.setFbr(rs.getString("fbr"));
				informationlist.add(webInfomation);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return new Pager(pageSize, pageNo, count, informationlist);
		

	}

	
}
