package com.trunko.cms.entity;

import java.sql.Date;
import java.sql.Timestamp;




/**
 * ������Ϣ��������������Ϣ  ר�ⲿ��
 * @author gjz
 *
 */
public class WebSubInfo {
	private Long	Id	;//	���
	private Long	lmid;//		��Ŀid
	private String	bt	;//		����
	private String  fbr ; //    ������
	private String 	btys;//		������ɫ
	private String	fbt	;//	������
	private String	ljwz;//		������ַ
	private String	sx	;//	����
	private String	zz	;//		����
	private String	ly	;//		��Դ
	private Timestamp	sj;//	�ϴα༭ʱ��
	private String	dd	;//	����
	private Integer	llcs;//		�������
	private String 	nr	;//		����
	private String	zt	;//	״̬
	private	Integer plcs;//		���۴���
	private String	ip	;//	����IP
	private Date    rq  ;//��������
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}

	public Long getLmid() {
		return lmid;
	}
	public void setLmid(Long lmid) {
		this.lmid = lmid;
	}
	public String getBt() {
		return bt;
	}
	public void setBt(String bt) {
		this.bt = bt;
	}
	public String getBtys() {
		return btys;
	}
	public void setBtys(String btys) {
		this.btys = btys;
	}
	public String getFbt() {
		return fbt;
	}
	public void setFbt(String fbt) {
		this.fbt = fbt;
	}
	public String getLjwz() {
		return ljwz;
	}
	public void setLjwz(String ljwz) {
		this.ljwz = ljwz;
	}
	public String getSx() {
		return sx;
	}
	public void setSx(String sx) {
		this.sx = sx;
	}
	public String getZz() {
		return zz;
	}
	public void setZz(String zz) {
		this.zz = zz;
	}
	public String getLy() {
		return ly;
	}
	public void setLy(String ly) {
		this.ly = ly;
	}
	public Timestamp getSj() {
		return sj;
	}
	public void setSj(Timestamp sj) {
		this.sj = sj;
	}
	public String getDd() {
		return dd;
	}
	public void setDd(String dd) {
		this.dd = dd;
	}
	public Integer getLlcs() {
		return llcs;
	}
	public void setLlcs(Integer llcs) {
		this.llcs = llcs;
	}
	public String getNr() {
		return nr;
	}
	public void setNr(String nr) {
		this.nr = nr;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public Integer getPlcs() {
		return plcs;
	}
	public void setPlcs(Integer plcs) {
		this.plcs = plcs;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public void setFbr(String fbr) {
		this.fbr = fbr;
	}
	public String getFbr() {
		return fbr;
	}
	public void setRq(Date rq) {
		this.rq = rq;
	}
	public Date getRq() {
		return rq;
	}

}
