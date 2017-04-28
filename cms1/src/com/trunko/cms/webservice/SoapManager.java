package com.trunko.cms.webservice;

import com.trunko.cms.util.FavoritesHelper;

/**

 * @ClassName: soap管理类

 * @Description: 构造soap请求、获取soap响应的数据

 * @author lhanliang

 * @date 2014-6-17 上午09:47:41

 */
public class SoapManager {

	/**
	 * 构建soap请求头部
	 * @return
	 */
	private String getHeader(){
		
		StringBuffer header = new StringBuffer();
		header.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		header.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		header.append("<soap:Body xmlns=\""+ Service.getTargetNamespace() +"\">");
		return header.toString();
		
	}
	
	/**
	 * 构建soap请求尾部
	 * @return
	 */
	private String getFooter(){
		
		return "</soap:Body> </soap:Envelope>";
	}
	
	
	/**
	 * 构造soap请求中，所访问的接口的方法和参数信息对象
	 * @param soap soap请求对象
	 * @return
	 */
	public String getBody(Soap soap){
		String method = soap.getMethod();	// 方法
		String[] params = soap.getParams(); // 参数
		String[] values = soap.getValues(); // 数值
		
		// 开始构造body信息
		StringBuffer bodyBuffer = new StringBuffer();
		if (FavoritesHelper.isNotNull(method)) {
			bodyBuffer.append("<" + method + ">");
				if (FavoritesHelper.isNotNull(params) && FavoritesHelper.isNotNull(values) && params.length == values.length) {
					for (int i = 0; i < params.length; i++) {
						bodyBuffer.append("<" + params[i] + ">");
						bodyBuffer.append(values[i]);
						bodyBuffer.append("</" + params[i] + ">");
					}
				}
			bodyBuffer.append("</" + method + ">");
		}
		
		return bodyBuffer.toString();
	}
	
	/**
	 * 获取soap请求数据
	 * @param soap
	 * @return
	 */
	public String getSOAPRequestData(Soap soap){
		
		return this.getHeader() + this.getBody(soap) + this.getFooter();
	}
}
