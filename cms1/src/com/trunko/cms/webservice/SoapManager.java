package com.trunko.cms.webservice;

import com.trunko.cms.util.FavoritesHelper;

/**

 * @ClassName: soap������

 * @Description: ����soap���󡢻�ȡsoap��Ӧ������

 * @author lhanliang

 * @date 2014-6-17 ����09:47:41

 */
public class SoapManager {

	/**
	 * ����soap����ͷ��
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
	 * ����soap����β��
	 * @return
	 */
	private String getFooter(){
		
		return "</soap:Body> </soap:Envelope>";
	}
	
	
	/**
	 * ����soap�����У������ʵĽӿڵķ����Ͳ�����Ϣ����
	 * @param soap soap�������
	 * @return
	 */
	public String getBody(Soap soap){
		String method = soap.getMethod();	// ����
		String[] params = soap.getParams(); // ����
		String[] values = soap.getValues(); // ��ֵ
		
		// ��ʼ����body��Ϣ
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
	 * ��ȡsoap��������
	 * @param soap
	 * @return
	 */
	public String getSOAPRequestData(Soap soap){
		
		return this.getHeader() + this.getBody(soap) + this.getFooter();
	}
}
