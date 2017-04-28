package com.trunko.cms.webservice;

/**
 * 
 * @ClassName: soap����ķ����Ͳ���ʵ����
 * 
 * @Description: ���soap����ķ����Ͳ�����Ϣ
 * 
 * @author lhanliang
 * 
 * @date 2014-6-17 ����10:57:14
 */
public class Soap {

	/**
	 * ���ݵķ���
	 */
	private String method = "";

	/**
	 * ���ݵĲ���
	 */
	private String[] params;

	/**
	 * ���ݲ�������Ӧ��ֵ
	 */
	private String[] values;

	/**
	 * ��ȡ���ݵķ���
	 * 
	 * @return
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * ���ô��ݵķ���
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * ��ȡ���ݵĲ���
	 * 
	 * @return
	 */
	public String[] getParams() {
		return params;
	}

	/**
	 * ���ô��ݵĲ���
	 */
	public void setParams(String[] params) {
		this.params = params;
	}

	/**
	 * ��ȡ���ݵĲ�����Ӧ��ֵ
	 * 
	 * @return
	 */
	public String[] getValues() {
		return values;
	}

	/**
	 * ���ô��ݵĲ�����Ӧ��ֵ
	 */
	public void setValues(String[] values) {
		this.values = values;
	}

}
