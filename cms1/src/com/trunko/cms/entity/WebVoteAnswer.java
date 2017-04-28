package com.trunko.cms.entity;

public class WebVoteAnswer {

	private Long id;
	private Long wtid;  //问题id
	private String da;  //答案
	private Long ps;   //票数
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getWtid() {
		return wtid;
	}
	public void setWtid(Long wtid) {
		this.wtid = wtid;
	}
	public String getDa() {
		return da;
	}
	public void setDa(String da) {
		this.da = da;
	}
	public Long getPs() {
		return ps;
	}
	public void setPs(Long ps) {
		this.ps = ps;
	}
	
	
}
