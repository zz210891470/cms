package com.trunko.cms.entity;


/**
 * ϵͳģ���࣬���ݿ������û�У�����ǰ̨ҳ���д
 * @author gjz
 *
 */
public class WebModel {

	private Long id;
	private String mxbt;//ģ�ͱ���
	private int mxpx;  //ģ������
	private String xtmr;//�Ƿ�ϵͳĬ��
	private String mxurl;//ģ��urlλ��
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMxbt() {
		return mxbt;
	}
	public void setMxbt(String mxbt) {
		this.mxbt = mxbt;
	}
	public int getMxpx() {
		return mxpx;
	}
	public void setMxpx(int mxpx) {
		this.mxpx = mxpx;
	}
	public String getXtmr() {
		return xtmr;
	}
	public void setXtmr(String xtmr) {
		this.xtmr = xtmr;
	}
	public void setMxurl(String mxurl) {
		this.mxurl = mxurl;
	}
	public String getMxurl() {
		return mxurl;
	}

	
	
}
