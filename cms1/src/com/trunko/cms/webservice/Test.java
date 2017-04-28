package com.trunko.cms.webservice;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;

/**

 * @ClassName: ����

 * @Description: ����

 * @author lhanliang

 * @date 2014-8-7 ����04:28:02

 */
public class Test {

	public static void main(String[] args) throws Exception {
		String a = "mxdx";
		 
		String endpoint = "http://127.0.0.1:8088/userCenter/umcService?wsdl";
		// ����һ������(service)����(call) 
		org.apache.axis.client.Service service = new org.apache.axis.client.Service();
		Call call = (Call) service.createCall();// ͨ��service����call���� 
		// ����service����URL
		call.setTargetEndpointAddress(new java.net.URL(endpoint)); 

		call.setOperationName(new QName("userCenter/","getAllowApps")); 
		//Add ��net �Ǳߵķ��� "http://tempuri.org/" ���ҲҪע��Namespace �ĵ�ַ,����Ҳ�ᱨ��
		call.addParameter(new QName("userCenter/","loginName"),org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
		 // ������Ҹ���һ���ԭ������,"test" ������Ǵ������ı���,Ҳ����NET����Ĳ���,һ����Ҫ������
		// �ҵ�����֪�� ,��Ϊ����������Լ����д��,������Ǳ�NULL,������������

		call.setUseSOAPAction(true); 
		call.setReturnType(org.apache.axis.encoding.XMLType.SOAP_STRING); //���ز���������
		call.setSOAPActionURI("userCenter/getAllowApps"); //���ҲҪע�� ����Ҫ����Ҫ���õķ���Add,��ȻҲ�ᱨ��

		// Object �����װ�˲���������Ϊ"This is Test!",����processService(String arg) 
		String ret = (String) call.invoke(new Object[] {a});
		System.out.println("--------"+ret);
	}

}
