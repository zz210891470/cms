package com.trunko.cms.entity;

/**
 * 专题栏目类 
 * @author gjz
 *
 */
public class WebSubColumn {

	private long id;
	private long ztid;  //专题id
	private String lmmc;//栏目名称
	private String lmlx;//栏目类型
	private String lmmx;//栏目模型
	private String ljdz;//链接地址
	private int lmpx;//栏目排序
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getZtid() {
		return ztid;
	}
	public void setZtid(long ztid) {
		this.ztid = ztid;
	}
	public String getLmmc() {
		return lmmc;
	}
	public void setLmmc(String lmmc) {
		this.lmmc = lmmc;
	}
	public String getLmlx() {
		return lmlx;
	}
	public void setLmlx(String lmlx) {
		this.lmlx = lmlx;
	}
	public String getLmmx() {
		return lmmx;
	}
	public void setLmmx(String lmmx) {
		this.lmmx = lmmx;
	}
	public String getLjdz() {
		return ljdz;
	}
	public void setLjdz(String ljdz) {
		this.ljdz = ljdz;
	}
	public int getLmpx() {
		return lmpx;
	}
	public void setLmpx(int lmpx) {
		this.lmpx = lmpx;
	}
	
	
	
	
}
