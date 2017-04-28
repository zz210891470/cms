package com.trunko.cms.dao.article;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.entity.WebInfomation;

import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.Pager;



/**
 * 对文章进行增删改查
 * @author gjz
 *
 */
public class ArticleDao {

	
	public boolean listrelease(String id){
		
		   String sql="update web_infomation set zt='已发布' where id="+id;

		   if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		   }
			
		   return false;
		}
	
	
	
	public Pager getRecycleForPage(int pageNo,int pageSize, String searchStr,String pid){
		
		
		List<WebInfomation> informationlist=new ArrayList<WebInfomation>() ;
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
			String countsql="select count(*) as num from web_infomation where lmid="+pid+" and zt='已删除'"+tempSql1;		
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}

			String sql = "select * from web_infomation where lmid="+pid+" and zt='已删除' "+tempSql1+ " order by rq desc limit "+((pageNo-1)*pageSize)+" , "+pageSize;
			rs = stat.executeQuery(sql);
			
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
				
				webInfomation.setRq(rs.getDate("rq"));
				webInfomation.setLstp(rs.getString("lstp"));
				webInfomation.setRd(rs.getString("rd"));
				webInfomation.setHd(rs.getString("hd"));
				webInfomation.setGd(rs.getString("gd"));
				webInfomation.setPx(rs.getLong("px"));
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

    public boolean hasArticle(Long id){
    	
    	Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;

		try {
			stat = conn.createStatement();
			String countsql="select * from web_infomation where lmid="+id;
			
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
	
	public boolean update(WebInfomation webInfomation){
		String sql="update  web_infomation set bt='"+webInfomation.getBt()+"',zz='"+webInfomation.getZz()
	     +"',ly='"+webInfomation.getLy()+"',zy='"+webInfomation.getZy()+"',nr='"+webInfomation.getNr()+"',ljwz='"+webInfomation.getLjwz()
	     +"',lstp='"+webInfomation.getLstp()+"',rd="+webInfomation.getRd()+",hd="+webInfomation.getHd()+",gd="+webInfomation.getGd()
	     +",sj='"+webInfomation.getSj()+"',fbr='"+webInfomation.getFbr()+"',rq='"+webInfomation.getRq()+"',istop="+webInfomation.getIstop()+" where id="+webInfomation.getId();
		
		System.out.println(sql);
		
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}

	    return false;
		
	}
	
	public boolean updateZt(WebInfomation webInfomation){
		String sql="update  web_infomation set bt='"+webInfomation.getBt()+"',zz='"+webInfomation.getZz()
	     +"',ly='"+webInfomation.getLy()+"',zy='"+webInfomation.getZy()+"',nr='"+webInfomation.getNr()+"',ljwz='"+webInfomation.getLjwz()
	     +"',lstp='"+webInfomation.getLstp()+"',rd="+webInfomation.getRd()+",hd="+webInfomation.getHd()+",gd="+webInfomation.getGd()
	     +",sj='"+webInfomation.getSj()+"',zt='"+webInfomation.getZt()+"',fbr='"+webInfomation.getFbr()+"',rq='"+webInfomation.getRq()+"',istop="+webInfomation.getIstop()+"  where id="+webInfomation.getId();
		
		System.out.println(sql);
		
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}

	    return false;
		
	}
	
	public WebInfomation getBySjid(Long id){
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        WebInfomation webInfomation=new WebInfomation();
		try {
			stat = conn.createStatement();
			String countsql="select * from web_infomation where lmid="+id;
			
			rs=stat.executeQuery(countsql);
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
				webInfomation.setRq(rs.getDate("rq"));
				webInfomation.setLstp(rs.getString("lstp"));
				webInfomation.setRd(rs.getString("rd"));
				webInfomation.setHd(rs.getString("hd"));
				webInfomation.setGd(rs.getString("gd"));
				webInfomation.setPx(rs.getLong("px"));
				webInfomation.setFbr(rs.getString("fbr"));
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webInfomation;

	}
	
	public WebInfomation getById(Long id){
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        WebInfomation webInfomation=new WebInfomation();
		try {
			stat = conn.createStatement();
			String countsql="select * from web_infomation where id="+id;
			
			rs=stat.executeQuery(countsql);
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
				webInfomation.setFbr(rs.getString("fbr"));
				webInfomation.setRq(rs.getDate("rq"));
				webInfomation.setLstp(rs.getString("lstp"));
				webInfomation.setRd(rs.getString("rd"));
				webInfomation.setHd(rs.getString("hd"));
				webInfomation.setGd(rs.getString("gd"));
				webInfomation.setPx(rs.getLong("px"));
				webInfomation.setIstop(rs.getInt("istop"));
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webInfomation;
	}
	

	public boolean add(WebInfomation webInfomation){
		
		String sql="insert into web_infomation(bt,zz,ly,zy,nr,lmid,ljwz,lstp,gd,hd,rd,sj,zt,fbr,rq,istop) values('"+webInfomation.getBt()+"','"+webInfomation.getZz()+"','"+webInfomation.getLy()+"','"+webInfomation.getZy()
		    +"','"+webInfomation.getNr()+"',"+webInfomation.getLmid()+",'"+webInfomation.getLjwz()+"','"+webInfomation.getLstp()+"',"+webInfomation.getGd()
		    +","+webInfomation.getHd()+","+webInfomation.getRd()+",'"+webInfomation.getSj()+"','"+webInfomation.getZt()+"','"+webInfomation.getFbr()+"','"+webInfomation.getRq()+"',"+webInfomation.getIstop()+")";
		System.out.println(sql);
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}

		return false;
	}

	public boolean delItemListR(String[] itemList){
		
		   String sql="delete from web_infomation where ";
			
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
		
		   String sql="update web_infomation set zt='已删除' where ";
			
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
		
		   String sql="update web_infomation set zt='草稿' where ";
			
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
		
		List<WebInfomation> informationlist=new ArrayList<WebInfomation>() ;
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
			String countsql="select count(*) as num from web_infomation where zt<>'已删除' and  lmid="+pid+tempSql1;		
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}

			String sql = "select * from web_infomation where zt<>'已删除' and lmid="+pid+tempSql1+"  order by rq desc limit "+((pageNo-1)*pageSize)+" , "+pageSize;
			rs = stat.executeQuery(sql);
			
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
				
				webInfomation.setFbr(rs.getString("fbr"));
				webInfomation.setLstp(rs.getString("lstp"));
				webInfomation.setRd(rs.getString("rd"));
				webInfomation.setHd(rs.getString("hd"));
				webInfomation.setGd(rs.getString("gd"));
				webInfomation.setPx(rs.getLong("px"));
				webInfomation.setRq(rs.getDate("rq"));
				webInfomation.setIstop(rs.getInt("istop"));
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
