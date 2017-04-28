package com.trunko.cms.webservice;

import com.trunko.cms.common.Constants;
import com.trunko.cms.util.Config;
import com.trunko.cms.util.FavoritesHelper;

/**

 * @ClassName: ���õ�web service �ӿ���Ϣ

 * @Description: �ṩ�ӿ���Ϣ

 * @author lhanliang

 * @date 2014-6-17 ����10:14:10

 */
public class Service {

	/**
	 * ��ȡweb service�ӿ���Ϣ
	 * @return
	 */
	public static String getTargetNamespace(){
		// ��ȡ�����ļ�����ȡ�ӿ������ռ���Ϣ
		Config config = new Config();
		config.load(Constants.WEB_SERVICE);
		return FavoritesHelper.nullChangeString(config.getValue("targetNamespace"));
	}
	
	/**
	 * ��ȡweb service�ӿ�wsdl��ַ
	 * @return
	 */
	public static String getWsdlUrl(){
		// ��ȡ�����ļ�����ȡ�ӿ�wsdl��ַ��Ϣ
		Config config = new Config();
		config.load(Constants.WEB_SERVICE);
		return FavoritesHelper.nullChangeString(config.getValue("wsdlAddress"));
	}
}
