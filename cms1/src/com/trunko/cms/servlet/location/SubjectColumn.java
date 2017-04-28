package com.trunko.cms.servlet.location;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.common.Constants;
import com.trunko.cms.dao.location.SubjectColumnDao;
import com.trunko.cms.entity.WebSubColumn;

public class SubjectColumn extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String location=request.getParameter("loc");
		if(location.equals("getmaindata")){
        	showMainData(request,response);
        }else if(location.equals("getpagedata")){
        	showPageData(request,response);
        }else if(location.equals("showzt")){
        	showzt(request, response);
        }

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
		try{
			Long.valueOf(id);
		}catch(Exception e){
			return;
		}
		String pageNo=request.getParameter("pageNo");
		
		SubjectColumnDao subColumnDao=new SubjectColumnDao();
		WebSubColumn  webColumn=subColumnDao.getSubject(id);
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
			id = Long.valueOf(id).toString();
		}catch(Exception e){
			return;
		}
		id = Long.valueOf(request.getParameter("id")).toString();
		SubjectColumnDao subColumnDao=new SubjectColumnDao();
		WebSubColumn  webColumn=subColumnDao.getSubject(id);
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
	
	
	
	public void showzt(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		SubjectColumnDao  scdao = new SubjectColumnDao();
		
		String ztid = request.getParameter("ztid");
		try{
			Long.valueOf(ztid);
		}catch(Exception e){
			return;
		}
   		List<WebSubColumn> webColumns=scdao.getSiderList(ztid);
		WebSubColumn  webColumn=webColumns.get(0);
		
   		request.setAttribute("itemList", webColumns);
        request.setAttribute("item", getData(webColumn.getLmmx(),webColumn.getId(),scdao,"1"));
		request.setAttribute("zt", scdao.getSubject(ztid));
   		request.getRequestDispatcher("subjectcolumn.jsp").forward(request, response);

		
	}
	
	
	
	

	public static String getData(String type,Long id,SubjectColumnDao subColumnDao,String pageNo){
        if(type.equals(Constants.RRMB)){
    	    return subColumnDao.getRRMBData(id);
        }else if(type.equals(Constants.LBMB)){
    	    return subColumnDao.getArticleForPage(Integer.valueOf(pageNo),10,id);
        }
		
	    return "";
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
