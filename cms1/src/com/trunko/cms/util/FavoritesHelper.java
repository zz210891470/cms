package com.trunko.cms.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.apache.log4j.Logger;

import com.trunko.cms.encrypt.Encrypt;
import com.trunko.cms.encrypt.EncryptFactory;


/** 
 * @author lhanliang
 * @version 
 * 工具类
 */

public class FavoritesHelper {
	
	private final static Logger LOG = Logger.getLogger(FavoritesHelper.class);
	/**
	 * 布尔类型判断
	 * @param ret 1：true，0：false
	 * @return
	 */
	public static boolean intChangeBoolean(int ret){
		boolean b = false;
		if(1==ret){
			b = true;
		}
		return b;
	}
	
	/**
	 * 将布尔类型转为0或1
	 * @param b
	 * @return
	 */
	public static String booleanToString(boolean b){
		if(b){
			return "1";
		}
		return "0";
	}
	
	/**
	 * 将字符串（0,1）转为false，true
	 * @param str
	 * @return
	 */
	public static boolean stringToboolean(String str){
		if("1".equals(nullChangeString(str))){
			return true;
		}
		return false;
	}
	
	/**
	 * 布尔类型判断
	 * @param ret
	 * @return
	 */
	public static boolean intChangeBoolean(int[] ret){
		boolean b = true;
		for (int i = 0; i < ret.length; i++) {
			if(0 == ret[i]){
				b = false;
				break;
			}
		}
		return b;
	}
	
	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public static String nullChangeString(String str){
		String ret = "";
		if(null==str || "".equals(str) || "null".equals(str)){
			str = "";
		}
		ret = str;
		return ret;
	}
	/**
	 * 空转换成字符串“0”
	 * @param str
	 * @return
	 */
	public static String nullChangeInteger(String str){
		String ret = "";
		if(null==str || "".equals(str) || "null".equals(str)){
			str = "0";
		}
		ret = str;
		return ret;
	}
	
	/**
	 * 将空值转换为空格
	 * @param str
	 * @return
	 */
	public static String nullChangeSpace(String str){
		String ret = "";
		if(null==str || "".equals(str) || "null".equals(str)){
			str = "&nbsp;";
		}
		ret = str;
		return ret;
	}
	
	/**
	 * 过滤过长字符
	 * @param str 需要被过滤的值
	 * @param length 保留长度
	 * @return
	 */
	public static String fillterString(String str,int length){
		String s = "";
		if(isNotNull(str)){
			if(str.length() > length){
				s = str.substring(0,length)+"...";
			}else{
				s = str;
			}
		}
		return s;
	}
	
	
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str){
		boolean b = false;
		if(null!=str && !"".equals(str) && !"null".equals(str)){
			b = true;
		}
		return b;
	}
	
	/**
	 * 字符型转为整型
	 * @param str
	 * @return
	 */
	public static int stringToint(String str){
		int count = 0;
		if(isNotNull(str)){
			str = str.trim();
			count = Integer.parseInt(str);
		}
		return count;
	}
	
	/**
	 * 字符串转换成长整型
	 * @param str
	 * @return
	 */
	public static long stringTolong(String str){
		long count = 0;
		if(isNotNull(str)){
			str = str.trim();
			count = Long.parseLong(str);
		}
		return count;
	}
	/**
	 * 字符串转换成浮点型
	 * @param str
	 * @return
	 */
	public static float stringTofloat(String str){
		float count = 0;
		if(isNotNull(str)){
			str = str.trim();
			count = Float.parseFloat(str);
		}
		return count;
	}
	
	/**
	 * 判断list对象是否为空
	 * @param list
	 * @return
	 */
	public static boolean isNotNull(List list){
		boolean b = false;
		if(null!=list && !list.isEmpty()){
			b = true;
		}
		return b;
	}
	/**
	 * 判断数组对象是否为空
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String[] str){
		boolean b = false;
		if(null!=str && str.length!=0){
			b = true;
		}
		return b;
	}
	
	/**
	 * 计算两个日期之间的工作小时 计算工作小时，根据传入的开始时间与结束时间来计算 这里传入的是字符值
	 * 
	 * @param startTime
	 *            开始日期
	 * @param endTime
	 *            结束日期
	 * @return
	 */
	public static int differDate(String startTime, String endTime) {
		String datePattern = "yyyy-MM-dd";

		SimpleDateFormat sf = new SimpleDateFormat(datePattern);

		Date date1 = null;
		Date date2 = null;
		long diffday = 0;
		try {
			date1 = sf.parse(startTime);
			date2 = sf.parse(endTime);
			//日期相减得到相差的日期 
			diffday = (date1.getTime()-date2.getTime())/(24*60*60*1000)>0 ? (date1.getTime()-date2.getTime())/(24*60*60*1000): 
			   (date2.getTime()-date1.getTime())/(24*60*60*1000); 
			//System.out.println("相差的日期: " +diffday); 
		} catch (ParseException e) {
			return 0;
		}

		return (int)diffday;
	}
	
	/**
	 * 判断是否为中文
	 * @param str
	 * @return
	 */
	public static boolean isCN(String str){
	    char[] chars=str.toCharArray(); 
	    boolean isGB2312=false; 
	    for(int i=0;i<chars.length;i++){
	                byte[] bytes=(""+chars[i]).getBytes(); 
	                if(bytes.length==2){ 
	                            int[] ints=new int[2]; 
	                            ints[0]=bytes[0]& 0xff; 
	                            ints[1]=bytes[1]& 0xff; 
	                            if(ints[0]>=0x81 && ints[0]<=0xFE && ints[1]>=0x40 && ints[1]<=0xFE){ 
	                                        isGB2312=true; 
	                                        break; 
	                            } 
	                } 
	    } 
	    return isGB2312; 
	}
	
	/**
	 * sql语句查询条件中的特殊符号过滤
	 * @param validate_sql
	 * @return
	 */
	public static String changeValidateSQL(String validate_sql) {
		if(isNotNull(validate_sql)){
			validate_sql = validate_sql.replaceAll("$$and", " and ");
			validate_sql = validate_sql.replaceAll("$$or", " or ");
			validate_sql = validate_sql.replaceAll("$$equal", " = ");
			validate_sql = validate_sql.replaceAll("$$notequal", " != ");
			validate_sql = validate_sql.replaceAll("$$big", " > ");
			validate_sql = validate_sql.replaceAll("$$small", " < ");
			validate_sql = validate_sql.replaceAll("$$bigequal", " >= ");
			validate_sql = validate_sql.replaceAll("$$smallequal", " <= ");
			validate_sql = validate_sql.replaceAll("$$like", " like ");
			validate_sql = validate_sql.replaceAll("$$wlike", " like ");
			validate_sql = validate_sql.replaceAll("$$rlike", " like ");
			validate_sql = validate_sql.replaceAll("$$nlike", " not like ");
			validate_sql = validate_sql.replaceAll("$$null", " is null ");
			validate_sql = validate_sql.replaceAll("$$notnull", " is not null ");
			validate_sql = validate_sql.replaceAll("!@$and!@$", " and ");
			validate_sql = validate_sql.replaceAll("!@$or!@$", " or ");
			validate_sql = validate_sql.replaceAll("!!!", "'");
			validate_sql = validate_sql.replaceAll("||", "%");
		}else{
			validate_sql = "";
		}
		return validate_sql;
	}
	
	/**
	 * 将Blob转成String
	 * @param blob
	 * @return
	 */
	public static String getStringByBlob(Blob blob) {
		String str = "";
		try {
			InputStream ins = blob.getBinaryStream();
			int contentLength = (int) blob.length();
			byte[] ba = new byte[contentLength];
			ins.read(ba);
			str = new String(ba);
		} catch (IOException io) {
			LOG.error(io.getMessage(), io);
		} catch (SQLException e) {
			LOG.error(e.getMessage(), e);
		}
		return str;
	}
	
	
	/**
	 * 将Clob转成String
	 * @param clob
	 * @return
	 */
	public static String getStringByBlob(Clob clob) {
		String str = "";
		try {
			InputStream ins = clob.getAsciiStream();
			int contentLength = (int) clob.length();
			byte[] ba = new byte[contentLength];
			ins.read(ba);
			str = new String(ba);
		} catch (IOException io) {
			LOG.error(io.getMessage(), io);
		} catch (SQLException e) {
			LOG.error(e.getMessage(), e);
		}
		return str;
	}
	
	/**
	 * 将Clob转成String
	 * @param clob
	 * @return
	 */
	public static String getStringByClob(Clob clob) {
		if (clob == null) {
			return null;
		}
		StringBuffer sb = new StringBuffer(65535);// 64K
		Reader clobStream = null;
		try {
			clobStream = clob.getCharacterStream();
			char[] b = new char[60000];// 每次获取60K
			int i = 0;
			while ((i = clobStream.read(b)) != -1) {
				sb.append(b, 0, i);
			}
		} catch (Exception ex) {
			sb = null;
		} finally {
			try {
				if (clobStream != null)
					clobStream.close();
			} catch (Exception e) {
			}
		}
		if (sb == null)
			return null;
		else
			return sb.toString();
	}

	
	public static String getContentType(String fileType){
		String contentType = "";
		fileType = changeDaToXiao(fileType);
		if(".asf".equals(fileType)){ 
			contentType = "video/x-ms-asf";
		}else if(".avi".equals(fileType)){
			contentType = "video/avi";
		}else if(".doc".equals(fileType)){
			contentType = "application/msword";
		}else if(".docx".equals(fileType)){
			contentType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
		}else if(".xls".equals(fileType)){
			contentType = "application/vnd.ms-excel";
		}else if(".xlsx".equals(fileType)){
			contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		}else if(".pdf".equals(fileType)){
			contentType = "application/pdf";
		}else if(".ppt".equals(fileType)){
			contentType = "application/vnd.ms-powerpoint";
		}else if(".gif".equals(fileType)){
			contentType = "image/gif";
		}else if(".jpg".equals(fileType)){
			contentType = "image/jpeg";
		}else if(".jpeg".equals(fileType)){
			contentType = "image/jpeg";
		}else if(".bmp".equals(fileType)){
			contentType = "image/bmp";
		}else if(".txt".equals(fileType)){
			contentType = "application/text";
		}else if(".wav".equals(fileType)){
			contentType = "audio/wav";
		}else if(".mp3".equals(fileType)){
			contentType = "audio/mpeg3";
		}else if(".mpg".equals(fileType) || "mpeg".equals(fileType)){
			contentType = "video/mpeg";
		}else if(".txt".equals(fileType)){
			contentType = "application/text";
		}else if(".zip".equals(fileType)){
			contentType = "application/zip";
		}else if(".rtf".equals(fileType)){
			contentType = "application/rtf";
		}else if(".html".equals(fileType)){
			contentType = "text/html";
		}else if(".asp".equals(fileType)){
			contentType = "text/asp";
		}else{
			contentType = "application/octet-stream";
		}
		return contentType;
	}
	
	/**
	 * 大写转为小写
	 * @param str
	 * @return
	 */
	public static String changeDaToXiao(String str){
		String txt = "";
		for (int i = 0; i < str.toCharArray().length; i++) {
			int ascii = str.charAt(i);
			if(ascii>=65 && ascii<=90){
				txt += (char)(ascii+32);
			}else{
				txt += str.toCharArray()[i];
			}
		}
		return txt;
	}
	
	/**
	 * 小写转为大写
	 * @param str
	 * @return
	 */
	public static String changeXiaoToDa(String str){
		String txt = "";
		for (int i = 0; i < str.toCharArray().length; i++) {
			int ascii = str.charAt(i);
			if(ascii>=97 && ascii<=122){
				txt += (char)(ascii-32);
			}else{
				txt += str.toCharArray()[i];
			}
		}
		return txt;
	}
	
	/**
	 * 判断是否数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){   
		if (!isNotNull(str)) {
			return false;
		}
		for (int i = str.length(); --i >= 0;) {
			int chr = str.charAt(i);
			if (chr < 48 || chr > 57)
				return false;
		}
		return true;
	} 
	
	/**
	 * 将数组转化成sql 的in查询
	 *    如：[1],[2],[3],[4],[5] 转化为 1,2,3,4,5
	 * @param str
	 * @return
	 */
	public static String getDouHaoForStr(String[] str){
		String params = "";
		if(null!=str){
			for (int i = 0; i < str.length; i++) {
				params += ","+str[i];
			}
		}
		
		if(!"".equals(params)){
			params = params.substring(1);
		}else{
			params = "";
		}
		return params;
	}
	
	/**
	 * 将数组转化成sql 的in查询
	 *    如：1,2,3,4,5 转化为 '1','2','3','4','5'
	 * @param str
	 * @return
	 */
	public static String getSQLInByStr(String[] str){
		String params = "";
		if(null!=str){
			for (int i = 0; i < str.length; i++) {
				params += ",'"+str[i]+"'";
			}
		}
		
		if(!"".equals(params)){
			params = params.substring(1);
		}else{
			params = "''";
		}
		return params;
	}
	
	/**
	 * 字符串转日期
	 * @param str
	 * @return
	 * @throws ParseException 
	 */
	public static java.sql.Date stringToDate(String str) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(str);
		java.sql.Date dateVal = new java.sql.Date(date.getTime());
        return dateVal;
	}
	
	/**
	 * 保留float类型两位小数，四舍五入
	 * @param fl
	 * @return
	 */
	public static float twoPointFloat(float fl) {
		return (float)(Math.round(fl*100))/100;
	}
	
	/**
	 * 保留float类型三位小数，四舍五入
	 * @param fl
	 * @return
	 */
	public static float threePointFloat(float fl) {
		return (float)(Math.round(fl*1000))/1000;
	}
	
	/**
	 * 将字符串转成unicode
	 * 
	 * @param str
	 *            待转字符串
	 * @return unicode字符串
	 */
	public static String convert(String str) {
		str = (str == null ? "" : str);
		String tmp;
		StringBuffer sb = new StringBuffer(1000);
		char c;
		int i, j;
		sb.setLength(0);
		for (i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			sb.append("\\u");
			j = (c >>> 8); // 取出高8位
			tmp = Integer.toHexString(j);
			if (tmp.length() == 1)
				sb.append("0");
			sb.append(tmp);
			j = (c & 0xFF); // 取出低8位
			tmp = Integer.toHexString(j);
			if (tmp.length() == 1)
				sb.append("0");
			sb.append(tmp);

		}
		return (new String(sb));
	}
	/**
	 * 转换密码 md5加密
	 * 
	 * @param pwd
	 * @return
	 */
	public static String getEncrypt(String pwd){
		String	encryptPassword="";
		Encrypt ent=EncryptFactory.getEncrypt("com.trunko.cms.encrypt.MD5Encrypt");
			try {
			 	encryptPassword=ent.encrypt(pwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
		    return encryptPassword.toUpperCase(); 
	}
}
