package com.trunko.cms.servlet.location;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.common.Constants;
import com.trunko.cms.dao.location.LmphDao;
import com.trunko.cms.dao.location.SubColumnDao;
import com.trunko.cms.entity.WebColumn;
import com.trunko.cms.entity.WebInfomation;
import com.trunko.cms.util.Escape;

public class SubColumn extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

            String location=request.getParameter("loc");

            LmphDao lmphDao = new LmphDao();
            if(location.equals("jggk")){
            	showJggk(request,response); 
            	lmphDao.LmphUpdate("机构概况");
            }else if(location.equals("xxgk")){
            	showXxgk(request,response);
            	lmphDao.LmphUpdate("信息公开");
            }else if(location.equals("wsbs")){
            	showWsbs(request,response);
            	lmphDao.LmphUpdate("网上办事");
//            else if(location.equals("xmjs")){
//            	showXmjs(request,response);
//            	lmphDao.LmphUpdate("项目建设");
           }else if(location.equals("xmzs")){//推介即招商
           	showXmzs(request,response);
            lmphDao.LmphUpdate("项目招商");
            
            } else if(location.equals("xmzh")){
                	showXmzh(request,response);

            }else if(location.equals("xmcb")){
            	showXmcb(request,response);
            	
            }
            else if(location.equals("xmch")){
            	showXmch(request,response);
            	lmphDao.LmphUpdate("项目策划");
            	
            }else if(location.equals("xmps")){
            	showXmps(request,response);
            
            }else if(location.equals("getmaindata")){
            	showMainData(request,response);
            }else if(location.equals("getpagedata")){
            	showPageData(request,response);
            }else if(location.equals("showQueary")){
            	showQueary(request,response);
            }
	}
	
	public static String getData(String type,Long id,SubColumnDao subColumnDao,String pageNo){
       if(type.equals(Constants.RRMB)){
    	   return subColumnDao.getRRMBData(id);
       }else if(type.equals(Constants.LBMB)){
    	   return subColumnDao.getArticleForPage(Integer.valueOf(pageNo),10,id);
       }else if(type.equals(Constants.XZMB)){
    	   return subColumnDao.getDownloadForPage(Integer.valueOf(pageNo),10,id);
       }
		
	   return null;
	}
	
	/**
	 * 显示列表类分页数据
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showPageData(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String id=request.getParameter("id");
		String pageNo=request.getParameter("pageNo");
		try{
			Long.valueOf(id);
		}catch(Exception e){
			return;
		}
		SubColumnDao subColumnDao=new SubColumnDao();
		WebColumn  webColumn=subColumnDao.getColumnById(id);
		String data="[\"SUCCESS\",\"";
	    data+=convert(getData(webColumn.getLmmx(),webColumn.getId(),subColumnDao,pageNo));
		data+="\"]";
		PrintWriter out = response.getWriter();
			
        response.setContentType("application/json; charset=utf-8");  
        response.setHeader("pragma", "no-cache");  
        response.setHeader("cache-control", "no-cache");  
		out.write(data);
		out.close();

	}
	
	
	
	/**
	 * 通过id查找到栏目相应的内容
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showMainData(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String id=request.getParameter("id");
		try{
			Long.valueOf(id);
		}catch(Exception e){
			return;
		}
		SubColumnDao subColumnDao=new SubColumnDao();
		WebColumn  webColumn=subColumnDao.getColumnById(id);
		System.out.println(webColumn.getId());
		String data="[\"SUCCESS\",\"";
	    data+=convert(getData(webColumn.getLmmx(),webColumn.getId(),subColumnDao,"1"));
		data+="\"]";
		PrintWriter out = response.getWriter();
			
        response.setContentType("application/json; charset=utf-8");  
        response.setHeader("pragma", "no-cache");  
        response.setHeader("cache-control", "no-cache");  
		out.write(data);
		out.close();

	}
	
	public void showJggk(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String sjid=Constants.JGGK;
		SubColumnDao subColumnDao=new SubColumnDao();
   		List<WebColumn> webColumns=subColumnDao.getSiderList(sjid);
		WebColumn  webColumn=webColumns.get(0);

   		request.setAttribute("itemList", webColumns);
        request.setAttribute("item", getData(webColumn.getLmmx(),webColumn.getId(),subColumnDao,"1"));
   		request.getRequestDispatcher("jggk.jsp").forward(request, response);

   		
	}
	
	public void showXxgk(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String sjid=Constants.XXGK;
		SubColumnDao subColumnDao=new SubColumnDao();
   		List<WebColumn> webColumns=subColumnDao.getSiderList(sjid);
   		WebColumn  webColumn=webColumns.get(0);
   		request.setAttribute("itemList", webColumns);
   		
        request.setAttribute("item", getData(webColumn.getLmmx(),webColumn.getId(),subColumnDao,"1"));
   		request.getRequestDispatcher("xxgk.jsp").forward(request, response);

	}
	public void showWsbs(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String sjid=Constants.WSBS;
		SubColumnDao subColumnDao=new SubColumnDao();
   		List<WebColumn> webColumns=subColumnDao.getSiderList(sjid);
   		WebColumn  webColumn=webColumns.get(0);
   		request.setAttribute("itemList", webColumns);
   		
        request.setAttribute("item", getData(webColumn.getLmmx(),webColumn.getId(),subColumnDao,"1"));
   		request.getRequestDispatcher("wsbs.jsp").forward(request, response);

	}
//	public void showXmjs(HttpServletRequest request, HttpServletResponse response)
//	throws ServletException, IOException {
//		String sjid=Constants.XMJS;
//		SubColumnDao subColumnDao=new SubColumnDao();
//   		List<WebColumn> webColumns=subColumnDao.getSiderList(sjid);
//   		WebColumn  webColumn=webColumns.get(0);
//   		request.setAttribute("itemList", webColumns);
//   		
//        request.setAttribute("item", getData(webColumn.getLmmx(),webColumn.getId(),subColumnDao,"1"));
//   		request.getRequestDispatcher("xmjs.jsp").forward(request, response);
//
//	}
	public void showXmzs(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String sjid=Constants.XMZS;
		SubColumnDao subColumnDao=new SubColumnDao();
   		List<WebColumn> webColumns=subColumnDao.getSiderList(sjid);
   		WebColumn  webColumn=webColumns.get(0);
   		request.setAttribute("itemList", webColumns);
   		
        request.setAttribute("item", getData(webColumn.getLmmx(),webColumn.getId(),subColumnDao,"1"));
   		request.getRequestDispatcher("xmzs.jsp").forward(request, response);

	}
	
	public void showXmzh(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String sjid=Constants.XMZH;
		SubColumnDao subColumnDao=new SubColumnDao();
   		List<WebColumn> webColumns=subColumnDao.getSiderList(sjid);
   		WebColumn  webColumn=webColumns.get(0);
   		request.setAttribute("itemList", webColumns);
   		
        request.setAttribute("item", getData(webColumn.getLmmx(),webColumn.getId(),subColumnDao,"1"));
   		request.getRequestDispatcher("xmzh.jsp").forward(request, response);

	}
	public void showXmcb(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String sjid=Constants.XMCB;
		SubColumnDao subColumnDao=new SubColumnDao();
   		List<WebColumn> webColumns=subColumnDao.getSiderList(sjid);
   		WebColumn  webColumn=webColumns.get(0);
   		request.setAttribute("itemList", webColumns);
   		
        request.setAttribute("item", getData(webColumn.getLmmx(),webColumn.getId(),subColumnDao,"1"));
   		request.getRequestDispatcher("xmcb.jsp").forward(request, response);

	}
	
	
	
	public void showXmch(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String sjid=Constants.XMCH;
		SubColumnDao subColumnDao=new SubColumnDao();
   		List<WebColumn> webColumns=subColumnDao.getSiderList(sjid);
   		WebColumn  webColumn=webColumns.get(0);
   		request.setAttribute("itemList", webColumns);
   		
        request.setAttribute("item", getData(webColumn.getLmmx(),webColumn.getId(),subColumnDao,"1"));
   		request.getRequestDispatcher("xmch.jsp").forward(request, response);

	}
	
	public void showXmps(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String sjid=Constants.XMPS;
		SubColumnDao subColumnDao=new SubColumnDao();
   		List<WebColumn> webColumns=subColumnDao.getSiderList(sjid);
   		WebColumn  webColumn=webColumns.get(0);
   		request.setAttribute("itemList", webColumns);
   		
        request.setAttribute("item", getData(webColumn.getLmmx(),webColumn.getId(),subColumnDao,"1"));
   		request.getRequestDispatcher("xmps.jsp").forward(request, response);

	}
	public void showQueary(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String keyword = request.getParameter("keyword");
		keyword=Escape.unescape(keyword);
		String pageNo=request.getParameter("pageNo");
		
		SubColumnDao subColumnDao=new SubColumnDao();
        String data="[\"SUCCESS\",\"";
	    data+=convert(subColumnDao.getquearyForPage(Integer.valueOf(pageNo),10,keyword));
		data+="\"]";
		PrintWriter out = response.getWriter();
			
        response.setContentType("application/json; charset=utf-8");  
        response.setHeader("pragma", "no-cache");  
        response.setHeader("cache-control", "no-cache");  
		out.write(data);
		out.close();
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
