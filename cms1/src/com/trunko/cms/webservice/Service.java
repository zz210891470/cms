package com.trunko.cms.webservice;

import com.trunko.cms.common.Constants;
import com.trunko.cms.util.Config;
import com.trunko.cms.util.FavoritesHelper;

/**

 * @ClassName: 调用的web service 接口信息

 * @Description: 提供接口信息

 * @author lhanliang

 * @date 2014-6-17 上午10:14:10

 */
public class Service {

	/**
	 * 获取web service接口信息
	 * @return
	 */
	public static String getTargetNamespace(){
		// 读取配置文件，获取接口命名空间信息
		Config config = new Config();
		config.load(Constants.WEB_SERVICE);
		return FavoritesHelper.nullChangeString(config.getValue("targetNamespace"));
	}
	
	/**
	 * 获取web service接口wsdl地址
	 * @return
	 */
	public static String getWsdlUrl(){
		// 读取配置文件，获取接口wsdl地址信息
		Config config = new Config();
		config.load(Constants.WEB_SERVICE);
		return FavoritesHelper.nullChangeString(config.getValue("wsdlAddress"));
	}
}
