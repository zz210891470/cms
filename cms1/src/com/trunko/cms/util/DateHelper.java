package com.trunko.cms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @ClassName: 日期帮助类
 * 
 * @Description: 作用
 * 
 * @author lhanliang
 * 
 * @date 2014-4-22 下午02:40:43
 */
public class DateHelper {

	/**
	 * 获取当前系统时间： yyyy-MM-dd HH:mm:ss
	 * 
	 * @return String
	 */
	public static String getNowTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		return df.format(new Date());// new Date()为获取当前系统时间
	}

	/**
	 * 获取当前系统日期： yyyy-MM-dd
	 * 
	 * @return String
	 */
	public static String getNowDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		return df.format(new Date());// new Date()为获取当前系统时间
	}
	/**
	 * 获取当前系统日期： yyyy-MM-dd
	 * 
	 * @return java.sql.Date
	 * @throws ParseException 
	 */
	public static java.sql.Date getNowSqlDate() throws ParseException {
		return stringToSqlDate(getNowDate());
	}
	
	/**
	 * 字符串转日期 yyyy-MM-dd
	 * @param str
	 * @return
	 * @throws ParseException 
	 */
	public static java.sql.Date stringToSqlDate(String str) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(str);
		java.sql.Date dateVal = new java.sql.Date(date.getTime());
        return dateVal;
	}  
	/**
	 * 字符串转日期 yyyy-MM-dd HH:mm:ss
	 * @param str
	 * @return Date date
	 * @throws ParseException 
	 */
	public static Date stringToUtilDate(String str) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(str);
		return date;
	}  
}
