package com.trunko.cms.webservice;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

/**
 * 
 * @ClassName: web service������
 * 
 * @Description: �ṩweb service�ӿڵĵ��ò���
 * 
 * @author lhanliang
 * 
 * @date 2014-6-17 ����11:39:45
 */
public class ServiceManager {

	/**
	 * ����web service�ӿڣ�ִ�в���
	 * 
	 * @param soap soap����
	 * @return soapResponseData �ӿڷ��صĶ�����Ϣ
	 * @throws Exception
	 */
	public String excute(Soap soap) throws Exception {
		// ��ʼ��soap������󡢹���soap������Ϣ
		SoapManager soapManager = new SoapManager();
		String soapRequestData = soapManager.getSOAPRequestData(soap);
		System.out.println(soapRequestData);
		// ���ʽӿڵ�ַ
		PostMethod postMethod = new PostMethod(Service.getWsdlUrl());
		// ��������
		byte[] b = soapRequestData.getBytes("utf-8");
		InputStream is = new ByteArrayInputStream(b, 0, b.length);
		RequestEntity re = new InputStreamRequestEntity(is, b.length,"text/xml; charset=utf-8");
		postMethod.setRequestEntity(re);
		HttpClient httpClient = new HttpClient();
		httpClient.executeMethod(postMethod);
		// ��ȡ������Ϣ
		String soapResponseData = postMethod.getResponseBodyAsString();
		return soapResponseData;
	}
}
