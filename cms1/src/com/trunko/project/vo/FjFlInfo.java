package com.trunko.project.vo;

public class FjFlInfo {

	private String lb;   //���  �ڽ� Ԥ��
	private String lb1;  //��ҵ���
	private String dq;   //����
    private	Long ztz = 0l;  //��Ͷ��
    private Long pnum = 0l; //��Ŀ��
    private Long nczbywc = 0l; //������������ 
    private Long jhtz  = 0l;    //�ƻ�Ͷ��
    private Long dnljdwhj =0l; //���굽λ�ʽ�
    private Double dwwcbl = 0d;   //��λ�ʽ���ɱ���
    private String sfscx ;  //�Ƿ���������Ŀ
    private String type; //��ҵ���
    private String mc;//��ҵ������ľ����ҵ����
    
    
    
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
	private Double wcbl = 0d;   //��ɱ���
    
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