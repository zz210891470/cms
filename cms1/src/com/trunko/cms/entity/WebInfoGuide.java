package com.trunko.cms.entity;
import java.sql.Timestamp;
public class WebInfoGuide {
	private Long	id;		//		���
	private String	topic;	//		����
	private String	content;//		����
	private Timestamp	time;//		��������
	
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
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
}
