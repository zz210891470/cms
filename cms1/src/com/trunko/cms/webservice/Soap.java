package com.trunko.cms.webservice;

/**
 * 
 * @ClassName: soap请求的方法和参数实体类
 * 
 * @Description: 存放soap请求的方法和参数信息
 * 
 * @author lhanliang
 * 
 * @date 2014-6-17 上午10:57:14
 */
public class Soap {

	/**
	 * 传递的方法
	 */
	private String method = "";

	/**
	 * 传递的参数
	 */
	private String[] params;

	/**
	 * 传递参数所对应的值
	 */
	private String[] values;

	/**
	 * 获取传递的方法
	 * 
	 * @return
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * 设置传递的方法
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * 获取传递的参数
	 * 
	 * @return
	 */
	public String[] getParams() {
		return params;
	}

	/**
	 * 设置传递的参数
	 */
	public void setParams(String[] params) {
		this.params = params;
	}

	/**
	 * 获取传递的参数对应的值
	 * 
	 * @return
	 */
	public String[] getValues() {
		return values;
	}

	/**
	 * 设置传递的参数对应的值
	 */
	public void setValues(String[] values) {
		this.values = values;
	}

}
