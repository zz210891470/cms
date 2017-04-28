package com.trunko.cms.webservice;

/**

 * @ClassName: 类名

 * @Description: 作用

 * @author lhanliang

 * @date 2014-6-17 下午12:03:10

 */
public class RunClientTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Soap soapBean = new Soap();
		soapBean.setMethod("getAllowApps");
		String[] params = {"loginName"}; 
		String[] values = {"测试用户080701"}; 

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
