package com.trunko.project.vo;

public class FjFlInfo {

	private String lb;   //类别  在建 预备
	private String lb1;  //行业类别
	private String dq;   //地区
    private	Long ztz = 0l;  //总投资
    private Long pnum = 0l; //项目数
    private Long nczbywc = 0l; //年初至本月完成 
    private Long jhtz  = 0l;    //计划投资
    private Long dnljdwhj =0l; //当年到位资金
    private Double dwwcbl = 0d;   //到位资金完成比例
    private String sfscx ;  //是否生产性项目
    private String type; //产业类别
    private String mc;//产业类下面的具体产业名称
    
    
    
    public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getDnljdwhj() {
		return dnljdwhj;
	}
	public void setDnljdwhj(Long dnljdwhj) {
		this.dnljdwhj = dnljdwhj;
	}
	public Double getDwwcbl() {
		return dwwcbl;
	}
	public void setDwwcbl(Double dwwcbl) {
		this.dwwcbl = dwwcbl;
	}
	private Double wcbl = 0d;   //完成比例
    
	public Double getWcbl() {
		return wcbl;
	}
	public void setWcbl(Double wcbl) {
		this.wcbl = wcbl;
	}
	public String getLb() {
		return lb;
	}
	public void setLb(String lb) {
		this.lb = lb;
	}
	public String getLb1() {
		return lb1;
	}
	public void setLb1(String lb1) {
		this.lb1 = lb1;
	}
	public String getDq() {
		return dq;
	}
	public void setDq(String dq) {
		this.dq = dq;
	}
	public Long getZtz() {
		return ztz;
	}
	public void setZtz(Long ztz) {
		this.ztz = ztz;
	}
	public Long getPnum() {
		return pnum;
	}
	public void setPnum(Long pnum) {
		this.pnum = pnum;
	}
	public Long getNczbywc() {
		return nczbywc;
	}
	public void setNczbywc(Long nczbywc) {
		this.nczbywc = nczbywc;
	}
	public Long getJhtz() {
		return jhtz;
	}
	public void setJhtz(Long jhtz) {
		this.jhtz = jhtz;
	}
	public void setSfscx(String sfscx) {
		this.sfscx = sfscx;
	}
	public String getSfscx() {
		return sfscx;
	}


}
