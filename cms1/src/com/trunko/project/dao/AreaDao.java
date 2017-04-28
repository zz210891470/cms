package com.trunko.project.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trunko.project.entity.ProArea;
import com.trunko.cms.util.DBHelper;

/**
 * 地区数据处理类
 * @author jianhuang
 *
 */
public class AreaDao {

	/*插入数据*/
	public boolean insert(ProArea proArea){
		String sql="insert into tb_area (pid,mc,px,lx) values("+proArea.getPid()+",'"+proArea.getMc()+"',"+proArea.getPx()+",'"+proArea.getLx()+"')";
		if(DBHelper.executeUpdateInject(sql)>0){
		   return true;
		}
		return false;
	}
	
	/*更新数据*/
	public boolean update(ProArea proArea){
		String sql="update tb_area set pid="+proArea.getPid()+",mc='"+proArea.getMc()+"',px="+proArea.getPx()+" where id=" + proArea.getId();
		if(DBHelper.executeUpdateInject(sql)>0){
			return true;
		}
	    return false;
	}
	
	/*删除数据*/
	public boolean delete(long id){
		String sql="delete from tb_area where id=" + id + " or pid=" + id;
		if(DBHelper.executeUpdateInject(sql)>0){
			return true;
		}
	    return false;
	}
	
	/*获取数据列表*/
	public List<ProArea> getList(String lx){
		List<ProArea> proAreas=new ArrayList<ProArea>();
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			String countsql="select * from tb_area where lx='"+lx+"' order by px asc";
			rs=stat.executeQuery(countsql);
			while(rs.next()){
				ProArea proArea=new ProArea();
				proArea.setId(rs.getLong("id"));
				proArea.setPid(rs.getLong("pid"));
				proArea.setMc(rs.getString("mc"));
				proArea.setPx(rs.getLong("px"));
				proArea.setLx(rs.getString("lx"));
				proAreas.add(proArea);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return proAreas;
	}
}
