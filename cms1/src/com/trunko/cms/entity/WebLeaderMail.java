package com.trunko.cms.entity;

import java.sql.Date;


public class WebLeaderMail {

	private Long Id	;//		编号
	private String xm	;//	姓名
	private String lxfs	;//		联系方式
	private String bt	;//		标题
	private String nr	;//		内容
	private Date sj	;//		时间
	private String lsh		;//		流水号
	private String cxmm		;//		查询密码
	private String zt		;//	回复状态
	private String hfyh		;//		回复用户
	private String hfnr		;//		回复内容
	private Date hfsj	;//		回复时间
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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
	public String getBt() {
		return bt;
	}
	public void setBt(String bt) {
		this.bt = bt;
	}
	public String getNr() {
		return nr;
	}
	public void setNr(String nr) {
		this.nr = nr;
	}

	public String getLsh() {
		return lsh;
	}
	public void setLsh(String lsh) {
		this.lsh = lsh;
	}
	public String getCxmm() {
		return cxmm;
	}
	public void setCxmm(String cxmm) {
		this.cxmm = cxmm;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public String getHfyh() {
		return hfyh;
	}
	public void setHfyh(String hfyh) {
		this.hfyh = hfyh;
	}
	public String getHfnr() {
		return hfnr;
	}
	public void setHfnr(String hfnr) {
		this.hfnr = hfnr;
	}
	public Date getSj() {
		return sj;
	}
	public void setSj(Date sj) {
		this.sj = sj;
	}
	public Date getHfsj() {
		return hfsj;
	}
	public void setHfsj(Date hfsj) {
		this.hfsj = hfsj;
	}


	
	
	
}
