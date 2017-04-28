package com.trunko.cms.entity;

/**
 * 
 * @ClassName: 系统数据备份信息实体类
 * 
 * @Description: 存放系统备份信息
 * 
 * @author lhanliang
 * 
 * @date 2014-4-22 上午11:33:07
 */
public class WebDataBackup {

	private long id = 0l; // 主键

	private String userName = ""; // 备份用户

	private String fileName = ""; // 备份的文件名

	private String createTime = ""; // 备份时间

	/**
	 * 获取备份数据主键
	 * 
	 * @return long
	 */
	public long getId() {
		return id;
	}

	/**
	 * 设置备份数据主键
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 获取备份人的用户名
	 * 
	 * @return String
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置备份人的用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取备份文件名
	 * 
	 * @return String
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * 设置备份文件名
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * 获取备份时间
	 * 
	 * @return String
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * 设置备份时间
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
