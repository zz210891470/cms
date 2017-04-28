package com.trunko.cms.dao.sysconfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.entity.WebDataBackup;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.Pager;
import com.trunko.project.entity.ProCbxm;

/**
 * 
 * @ClassName: 系统数据备份数据操作类
 * 
 * @Description: 负责对数据库中的备份数据进行操作
 * 
 * @author lhanliang
 * 
 * @date 2014-4-22 上午11:45:36
 */
public class SysDataBackupDao {
	/**
	 * 分页获取备份数据列表
	 * 
	 * @param pageNo
	 *            页面起始页码
	 * @param pageSize
	 *            每页大小
	 * @return Pager
	 */
	public Pager getItemForPage(int pageNo, int pageSize) {
		// 备份数据列表
		List<WebDataBackup> itemlist = new ArrayList<WebDataBackup>();
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		int count = 0;
		try {
			// 获取总数
			stat = conn.createStatement();
			String countsql = "select count(*) as num from web_data_backup ";
			rs = stat.executeQuery(countsql);
			if (rs.next()) {
				count = rs.getInt("num");
			}
			// 获取分页数据
			String sql = "select * from web_data_backup order by id desc limit "
					+ ((pageNo - 1) * pageSize) + " , " + pageSize;
			rs = stat.executeQuery(sql);
			// 构造对象信息
			while (rs.next()) {
				WebDataBackup backup = new WebDataBackup();
				backup.setId(rs.getLong("id"));
				backup.setUserName(rs.getString("userName"));
				backup.setFileName(rs.getString("fileName"));
				backup.setCreateTime(rs.getString("createTime"));
				itemlist.add(backup);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return new Pager(pageSize, pageNo, count, itemlist);
	}

	/**
	 * 保存对象信息
	 * 
	 * @param item
	 *            实体对象
	 * @return Boolean isOk
	 */
	public boolean save(WebDataBackup item) {
		// 是否执行成功
		Boolean isOk = false;
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat = null;

		String sql = "insert into web_data_backup(userName,fileName,createTime)"
				+ " values(?,?,?)";
		try {
			stat = conn.prepareStatement(sql);

			stat.setString(1, item.getUserName());
			stat.setString(2, item.getFileName());
			stat.setString(3, item.getCreateTime());
			if (stat.executeUpdate() > 0) {
				isOk = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat);
		}
		return isOk;
	}
}
