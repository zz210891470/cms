package com.trunko.cms.entity;

public class WebVoteItem {

	
	private Long Id	;//	���
	private Long dcid	;//	����id
	private String wt	;//	����
	private Integer type; //����
	private Integer sort;//����
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


	public void setWt(String wt) {
		this.wt = wt;
	}
	public String getWt() {
		return wt;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getType() {
		return type;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getSort() {
		return sort;
	}



}
