package com.trunko.cms.entity;

public class WebVoteUser {
	
	private Long Id	;//	编号
	private Long dcid;//	调查id
	private String xm;//	姓名
	private String lxfs;//	联系方式
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Long getDcid() {
		return dcid;
	}
	public void setDcid(Long dcid) {
		this.dcid = dcid;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getLxfs() {
		return lxfs;
	}
	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}
	
	

}
