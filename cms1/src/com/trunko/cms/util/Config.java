package com.trunko.cms.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * 
 * @ClassName: 配置文件帮助类
 * 
 * @Description: 处理properties文件信息
 * 
 * @author lhanliang
 * 
 * @date 2014-4-22 下午05:23:08
 */
public class Config {
	
	private String cfgFileName = ""; //文件名
	private Properties properties; // properties

	public Config() {
		this.properties = new Properties();
	}

	/**
	 *  加载文件
	 * @param filename 文件名
	 */
	public void load(String filename) {
		FileInputStream fi;
		try {
			fi = new FileInputStream(getWebInfAddress() + File.separator
					+ filename);

			this.properties.load(fi);

			fi.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * 通过key获取对应的值
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		return this.properties.getProperty(key, "");
	}

	/**
	 * 获取WEB-INF路径
	 * @return
	 */
	public static String getWebInfAddress() {
		Class theClass = Config.class;
		URL u = theClass.getProtectionDomain().getCodeSource().getLocation();

		String str = u.toString();

		if (str.startsWith("jar"))
			str = str.substring(9, str.length());
		else {
			str = str.substring(6, str.length());
		}

		str = str.replaceAll("%20", " ");

		int num = str.indexOf("WEB-INF");

		str = str.substring(0, num + "WEB-INF".length());
		if (System.getProperty("os.name").toUpperCase().indexOf("LINUX") >= 0)
			str = "/" + str;

		return str;
	}
}
