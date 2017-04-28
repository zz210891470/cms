package com.trunko.cms.webservice;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

/**
 * 
 * @ClassName: web service管理类
 * 
 * @Description: 提供web service接口的调用操作
 * 
 * @author lhanliang
 * 
 * @date 2014-6-17 上午11:39:45
 */
public class ServiceManager {

	/**
	 * 调用web service接口，执行操作
	 * 
	 * @param soap soap对象
	 * @return soapResponseData 接口返回的对象信息
	 * @throws Exception
	 */
	public String excute(Soap soap) throws Exception {
		// 初始化soap管理对象、构造soap请求信息
		SoapManager soapManager = new SoapManager();
		String soapRequestData = soapManager.getSOAPRequestData(soap);
		System.out.println(soapRequestData);
		// 访问接口地址
		PostMethod postMethod = new PostMethod(Service.getWsdlUrl());
		// 传递请求
		byte[] b = soapRequestData.getBytes("utf-8");
		InputStream is = new ByteArrayInputStream(b, 0, b.length);
		RequestEntity re = new InputStreamRequestEntity(is, b.length,"text/xml; charset=utf-8");
		postMethod.setRequestEntity(re);
		HttpClient httpClient = new HttpClient();
		httpClient.executeMethod(postMethod);
		// 获取返回信息
		String soapResponseData = postMethod.getResponseBodyAsString();
		return soapResponseData;
	}
}
