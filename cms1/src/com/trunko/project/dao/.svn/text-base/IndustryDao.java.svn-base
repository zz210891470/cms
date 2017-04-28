package com.trunko.project.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trunko.project.entity.ProIndustry;
import com.trunko.cms.util.DBHelper;

/**
 * 行业数据处理类
 * @author jianhuang
 *
 */
public class IndustryDao {
	/*插入数据*/
	public boolean insert(ProIndustry proIndustry){
		String sql="insert into tb_industry (pid,mc,px,lx) values("+proIndustry.getPid()+",'"+proIndustry.getMc()+"',"+proIndustry.getPx()+",'"+proIndustry.getLx()+"')";
		if(DBHelper.executeUpdateInject(sql)>0){
		   return true;
		}
		return false;
	}
	
	/*更新数据*/
	public boolean update(ProIndustry proIndustry){
		String sql="update tb_industry set pid="+proIndustry.getPid()+",mc='"+proIndustry.getMc()+"',px="+proIndustry.getPx()+" where id=" + proIndustry.getId();
		if(DBHelper.executeUpdateInject(sql)>0){
			return true;
		}
	    return false;
	}
	
	/*删除数据*/
	public boolean delete(long id){
		String sql="delete from tb_industry where id=" + id + " or pid=" + id;
		if(DBHelper.executeUpdateInject(sql)>0){
			return true;
		}
	    return false;
	}
	
	/*获取数据列表*/
	public List<ProIndustry> getList(String lx){
		List<ProIndustry> proIndustrys=new ArrayList<ProIndustry>();
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			String countsql="select * from tb_industry where lx='"+lx+"' order by px asc";
			rs=stat.executeQuery(countsql);
			while(rs.next()){
				ProIndustry proIndustry=new ProIndustry();
				proIndustry.setId(rs.getLong("id"));
				proIndustry.setPid(rs.getLong("pid"));
				proIndustry.setMc(rs.getString("mc"));
				proIndustry.setPx(rs.getLong("Px"));
				proIndustry.setLx(rs.getString("lx"));
				proIndustrys.add(proIndustry);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return proIndustrys;
	}
}