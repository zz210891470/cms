package com.trunko.cms.webservice;

/**

 * @ClassName: ����

 * @Description: ����

 * @author lhanliang

 * @date 2014-6-17 ����12:03:10

 */
public class RunClientTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Soap soapBean = new Soap();
		soapBean.setMethod("getAllowApps");
		String[] params = {"loginName"}; 
		String[] values = {"�����û�080701"}; 

		soapBean.setParams(params);
		soapBean.setValues(values);
		
		ServiceManager serviceManager = new ServiceManager();
		try {
			System.out.println(serviceManager.excute(soapBean));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
