package com.trunko.cms.entity;

/**
 * ϵͳ��ɫ��   ���ݿ������û�У�����ǰ̨ҳ���д
 * @author gjz
 *
 */
public class WebRole {

	private Long id;
	private String name;
	private String power;
	private String descr;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}


}
