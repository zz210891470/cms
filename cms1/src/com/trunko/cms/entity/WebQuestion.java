package com.trunko.cms.entity;

import java.sql.Date;



/**
 * ����������
 * @author gjz
 *
 */
public class WebQuestion {

	private Long id;
	private String question;  //����
	private String answer;    //��
	private Date  time;  //ʱ��
	private String author; //����
	private String url;    //����url����·��
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrl() {
		return url;
	}
	

	
}
