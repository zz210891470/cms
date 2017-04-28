package com.trunko.cms.dao.sysconfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trunko.cms.entity.WebConfig;
import com.trunko.cms.util.DBHelper;


/**
 * 系统配置数据处理对象
 * @author gjz
 *
 */
public class SysConfigDao {

	public boolean saveInfo(WebConfig config){
		String sql="update web_config set zdmc ='"+config.getZdmc()+" ',dwmc='" +config.getDwmc()+"',wzym='"
		+config.getWzym()+"', lxdh='"+config.getLxdh()+"',czhm='"+config.getCzhm()+"',glyyx='"+config.getGlyyx()+"',icp='"
		+config.getIcp()+"',sybt='"+config.getSybt()+"',ymgjc='"+config.getYmgjc()+"',ymms='"+config.getYmms()+"',bqxx='"
		+config.getBqxx()+"'"
		          +" where id="+config.getId()+"";
		
		DBHelper.executeUpdateInject(sql);
	
		return false;
	}
	
	public WebConfig getInfo(){
		
		ResultSet rs = null;
		Connection con=DBHelper.getConnection();
		PreparedStatement stat =null;	
		String sql="select * from web_config";
		
		WebConfig webConfig=new WebConfig();
		
		
		try {
			stat=con.prepareStatement(sql);

			rs=stat.executeQuery();
			if(rs.next()){
                webConfig.setBcfs(rs.getString("bcfs"));
                webConfig.setBqxx(rs.getString("bqxx"));
                webConfig.setCzhm(rs.getString("czhm"));
                webConfig.setDlcwcs(rs.getInt("dlcwcs"));		
				webConfig.setFjml(rs.getString("fjml"));
				webConfig.setFjrdz(rs.getString("fjrdz"));
				webConfig.setFjrnc(rs.getString("fjrnc"));
				webConfig.setFllx(rs.getString("fllx"));
				webConfig.setFwtj(rs.getString("fwtj"));
				webConfig.setGbwz(rs.getString("gbwz"));
				webConfig.setGbyy(rs.getString("gbyy"));
				webConfig.setGlyyx(rs.getString("glyyx"));
				webConfig.setIcp(rs.getString("icp"));
				webConfig.setId(rs.getLong("id"));
				webConfig.setLxdh(rs.getString("lxdh"));
				webConfig.setMmgq(rs.getInt("mmgq"));
				webConfig.setSltc(rs.getInt("sltc"));
				webConfig.setSltk(rs.getInt("sltk"));
				webConfig.setStmp(rs.getString("stmp"));
				webConfig.setStmpdk(rs.getString("stmpdk"));
				webConfig.setSybt(rs.getString("sybt"));
				webConfig.setSytmd(rs.getInt("sytmd"));
                webConfig.setSywj(rs.getString("sywj"));
                webConfig.setSywz(rs.getString("sywz"));
                webConfig.setSywzi(rs.getString("sywzi"));
                webConfig.setTjdm(rs.getString("tjdm"));
                webConfig.setTpcd(rs.getInt("tpcd"));
                webConfig.setTpdx(rs.getInt("tpdx"));
                webConfig.setTpkd(rs.getInt("tpkd"));
                webConfig.setTpsy(rs.getString("tpsy"));
                webConfig.setWjdx(rs.getInt("wjdx"));
                webConfig.setWzym(rs.getString("wzym"));
                webConfig.setYmgjc(rs.getString("ymgjc"));
                webConfig.setYmms(rs.getString("ymms"));
                webConfig.setYxmm(rs.getString("yxmm"));
                webConfig.setYxzh(rs.getString("yxzh"));
                webConfig.setZdmc(rs.getString("zdmc"));
                webConfig.setDwmc(rs.getString("dwmc"));
                webConfig.setZyzt(rs.getString("zyzt"));
                webConfig.setZyztdx(rs.getInt("zyztdx"));
                
				
				return webConfig;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			DBHelper.closeDB(con, stat, rs);
		}
		
		return null;

	}
	
}
