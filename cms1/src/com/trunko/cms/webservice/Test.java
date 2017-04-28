package com.trunko.cms.webservice;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;

/**

 * @ClassName: 类名

 * @Description: 作用

 * @author lhanliang

 * @date 2014-8-7 下午04:28:02

 */
public class Test {

	public static void main(String[] args) throws Exception {
		String a = "mxdx";
		 
		String endpoint = "http://127.0.0.1:8088/userCenter/umcService?wsdl";
		// 创建一个服务(service)调用(call) 
		org.apache.axis.client.Service service = new org.apache.axis.client.Service();
		Call call = (Call) service.createCall();// 通过service创建call对象 
		// 设置service所在URL
		call.setTargetEndpointAddress(new java.net.URL(endpoint)); 

		call.setOperationName(new QName("userCenter/","getAllowApps")); 
		//Add 是net 那边的方法 "http://tempuri.org/" 这个也要注意Namespace 的地址,不带也会报错
		call.addParameter(new QName("userCenter/","loginName"),org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
		 // 这就是我搞了一天的原因所在,"test" 这个就是传参数的变量,也就是NET方面的参数,一定不要带错了
		// 我当初不知道 ,以为这个参数是自己随便写的,结果总是报NULL,真是气死人了

		call.setUseSOAPAction(true); 
		call.setReturnType(org.apache.axis.encoding.XMLType.SOAP_STRING); //返回参数的类型
		call.setSOAPActionURI("userCenter/getAllowApps"); //这个也要注意 就是要加上要调用的方法Add,不然也会报错

		// Object 数组封装了参数，参数为"This is Test!",调用processService(String arg) 
		String ret = (String) call.invoke(new Object[] {a});
		System.out.println("--------"+ret);
	}

}
