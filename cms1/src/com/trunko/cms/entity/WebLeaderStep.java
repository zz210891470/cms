package com.trunko.cms.entity;

import java.sql.Timestamp;


public class WebLeaderStep {
	
	
	private Long Id	;//	编号
	private Long pid	;//	信件编号
	private String pzyh	;//	批转用户
	private String jsyh	;//		接收用户
	private String pzyj	;//	批转意见
	private Timestamp pzsj;//	批转时间
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getPzyh() {
		return pzyh;
	}
	public void setPzyh(String pzyh) {
		this.pzyh = pzyh;
	}
	public String getJsyh() {
		return jsyh;
	}
	public void setJsyh(String jsyh) {
		this.jsyh = jsyh;
	}
	public String getPzyj() {
		return pzyj;
	}
	public void setPzyj(String pzyj) {
		this.pzyj = pzyj;
	}
	public Timestamp getPzsj() {
		return pzsj;
	}
	public void setPzsj(Timestamp pzsj) {
		this.pzsj = pzsj;
	}

}
