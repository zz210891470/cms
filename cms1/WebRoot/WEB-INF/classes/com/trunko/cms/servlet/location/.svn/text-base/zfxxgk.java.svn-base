package com.trunko.cms.servlet.location;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.common.Constants;
import com.trunko.cms.dao.location.SubColumnDao;
import com.trunko.cms.dao.location.ZfxxgkDao;
import com.trunko.cms.entity.WebColumn;
import com.trunko.cms.entity.WebZfxxgk;
import com.trunko.cms.dao.location.LmphDao;

public class zfxxgk extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String location=request.getParameter("loc");
		String pageNo=request.getParameter("pageNo");
		if(request.getParameter("pageNo")==null){
			pageNo="1";
		}
		
		LmphDao lmphDao = new LmphDao();
		lmphDao.LmphUpdate("信息公开");
		
		ZfxxgkDao zfxxgkDao=new ZfxxgkDao();
		if(location.equals("zfxxgk")){
			showZfxxgk(request,response);    	
        }else if(location.equals("gkzn")){
        	showGkzn(request,response);    	
        }else if(location.equals("ysqgk")){
        	showGkzn(request,response); 
        }else if(location.equals("sfxm")){
        	showGkzn(request,response); 
        }else if(location.equals("lct")){
        	showGkzn(request,response); 
        }else if(location.equals("gkml")){
        	String data="[\"SUCCESS\",\"";
    	    data+=convert(zfxxgkDao.getArticleForPageGkml(Integer.valueOf(pageNo),10));
    		data+="\"]";
    		PrintWriter out = response.getWriter();
    			
            response.setContentType("application/json; charset=utf-8");  
            response.setHeader("pragma", "no-cache");  
            response.setHeader("cache-control", "no-cache");  
    		out.write(data);
    		out.close();
        }else if(location.equals("gkgd")){
        	String data="[\"SUCCESS\",\"";
    	    data+=convert(zfxxgkDao.getArticleForPageGkgd(Integer.valueOf(pageNo),10));
    		data+="\"]";
    		PrintWriter out = response.getWriter();
    			
            response.setContentType("application/json; charset=utf-8");  
            response.setHeader("pragma", "no-cache");  
            response.setHeader("cache-control", "no-cache");  
    		out.write(data);
    		out.close();
        }else if(location.equals("ndbg")){
        	String data="[\"SUCCESS\",\"";
    	    data+=convert(zfxxgkDao.getArticleForPageNdbg(Integer.valueOf(pageNo),10));
    		data+="\"]";
    		PrintWriter out = response.getWriter();
    			
            response.setContentType("application/json; charset=utf-8");  
            response.setHeader("pragma", "no-cache");  
            response.setHeader("cache-control", "no-cache");  
    		out.write(data);
    		out.close();
        }
		
	}
	
	public void showGkzn(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String location=request.getParameter("loc");
		
		ZfxxgkDao zfxxgkDao=new ZfxxgkDao();
		String data="[\"SUCCESS\",\"";
	    data+=convert(zfxxgkDao.getInfoguide(location));
		data+="\"]";
		PrintWriter out = response.getWriter();
			
        response.setContentType("application/json; charset=utf-8");  
        response.setHeader("pragma", "no-cache");  
        response.setHeader("cache-control", "no-cache");  
		out.write(data);
		out.close();
	}

	public void showZfxxgk(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String location=request.getParameter("lb");
		String pageNo=request.getParameter("pageNo");
		if(request.getParameter("pageNo")==null){
			pageNo="1";
		}
		ZfxxgkDao zfxxgkDao=new ZfxxgkDao();
		if(location.equals("gkzn")){
			request.setAttribute("item", zfxxgkDao.getInfoguide(location));  	
        }else if(location.equals("ysqgk")){
        	request.setAttribute("item", zfxxgkDao.getInfoguide(location));
        }else if(location.equals("sfxm")){
        	request.setAttribute("item", zfxxgkDao.getInfoguide(location));
        }else if(location.equals("lct")){
        	request.setAttribute("item", zfxxgkDao.getInfoguide(location));
        }else if(location.equals("gkml")){
        	request.setAttribute("item",zfxxgkDao.getArticleForPageGkml(Integer.valueOf(pageNo),10));
        }else if(location.equals("gkgd")){
        	request.setAttribute("item",zfxxgkDao.getArticleForPageGkgd(Integer.valueOf(pageNo),10));
        }else if(location.equals("ndbg")){
        	request.setAttribute("item",zfxxgkDao.getArticleForPageNdbg(Integer.valueOf(pageNo),10));
        }
        
   		request.getRequestDispatcher("zfxxgk.jsp").forward(request, response);
	}
	
	/**
	* 将字符串转成unicode
	* @param str 待转字符串
	* @return unicode字符串
	*/ 
	public String convert(String str)
	{
		str = (str == null ? "" : str);
		String tmp;
		StringBuffer sb = new StringBuffer(1000);
		char c;
		int i, j;
		sb.setLength(0);
		for (i = 0; i < str.length(); i++)
		{
		c = str.charAt(i);
		sb.append("\\u");
		j = (c >>>8); //取出高8位
		tmp = Integer.toHexString(j);
		if (tmp.length() == 1)
		sb.append("0");
		sb.append(tmp);
		j = (c & 0xFF); //取出低8位
		tmp = Integer.toHexString(j);
		if (tmp.length() == 1)
		sb.append("0");
		sb.append(tmp);
	
		}
		return (new String(sb));
	} 
}
