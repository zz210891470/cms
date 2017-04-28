package com.trunko.cms.entity;
import java.sql.Date;
public class WebInfoReg {
	private Long	id;		//		编号
	private String	topic;	//		标题
	private String	content;//		内容
	private Date	time;//		发布日期
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
