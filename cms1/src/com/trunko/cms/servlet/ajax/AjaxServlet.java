package com.trunko.cms.servlet.ajax;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trunko.cms.dao.ajax.AjaxDao;
import com.trunko.cms.entity.WebColumn;
import com.trunko.cms.entity.WebSubColumn;

public class AjaxServlet extends HttpServlet {

	private String ZtreeJson="";
	private String ZtreeJson2="";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String act=request.getParameter("act");
		   
		   if(act.equals("getColumnData")){
			   getColumnData(request,response);
		   }else if(act.equals("getSubData")){
			   getSubData(request,response);
		   }else if(act.equals("index")){ 
			   String lb=request.getParameter("lb");
			   if(lb.equals("xmgl")){
				   HttpSession session = request.getSession();
				   request.setAttribute("qx", session.getAttribute("qx").toString());
				   request.setAttribute("xm", session.getAttribute("xm").toString());
				   request.getRequestDispatcher("proindex.jsp").forward(request, response);
			   }else {
				   HttpSession session = request.getSession();
				   request.setAttribute("qx", session.getAttribute("qx").toString());
				   request.setAttribute("xm", session.getAttribute("xm").toString());
				   request.getRequestDispatcher("index.jsp").forward(request, response);
			   }

		   }else if(act.equals("index_yb")){
			   HttpSession session = request.getSession();
			   request.setAttribute("xm", session.getAttribute("xm").toString());
			   //request.setAttribute("lb", session.getAttribute("lb").toString());
			   request.getRequestDispatcher("zdxm_index.jsp").forward(request, response);
		   }else if(act.equals("gbxls")){
			   xlsExportGb(request,response);
		   }
		   else if(act.equals("utfxls")){
			   xlsExportUtf(request,response);
		   }
	}
	
	private void xlsExportUtf(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException, IOException {
		String enFileName = URLEncoder.encode(request.getParameter("title"), "utf-8"); 
		response.setHeader("Content-disposition","attachment;filename="+enFileName+".xls");
	
 
		OutputStream  out = response.getOutputStream();
        response.setContentType("application/vnd.x-msexcel,charset=utf-8");  
        response.setCharacterEncoding("utf-8");
      
        byte[] buf = ("<table border=\"1\" cellSpacing=\"0\" cellPadding=\"0\" width=\"750\" >"+request.getParameter("content").toString()+"</table>").getBytes("utf-8");  
          
        out.write(buf);  
       

		out.close();
	}
	
	
	private void xlsExportGb(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException, IOException {
		String enFileName = URLEncoder.encode(request.getParameter("title"), "utf-8"); 
		response.setHeader("Content-disposition","attachment;filename="+enFileName+".xls");
	
 
		OutputStream  out = response.getOutputStream();
        response.setContentType("application/vnd.x-msexcel,charset=gb18030");  
        response.setCharacterEncoding("gb18030");

        byte[] buf = ("<table border=\"1\" cellSpacing=\"0\" cellPadding=\"0\" width=\"750\" >"+request.getParameter("content").toString()+"</table>").getBytes("gb18030");  
          
        out.write(buf);  
        out.flush();

		out.close();
	}
	

	private void getSubData(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException, IOException {
	
		String data="[";
		String qx="";
		HttpSession session = request.getSession();
		qx= session.getAttribute("qx").toString();
		AjaxDao ajaxDao=new AjaxDao();
		List<WebSubColumn> rootColumnList=ajaxDao.getSubject();
		List<WebSubColumn> subColumnList=ajaxDao.getSubjectColumn();
		
		for(WebSubColumn wc:rootColumnList){
			if(qx.indexOf(String.valueOf(wc.getId()))>0){
	        data+="{\"id\":\""+wc.getId()+"\",\"pId\":\""+wc.getZtid()+"\",\"name\":\""+convert(wc.getLmmc())+"\",\"isParent\":\"true\"},";
	        getZtreeJson2(wc.getId(),subColumnList,qx);
			}
	        data+=ZtreeJson2;
	        ZtreeJson2="";	
		}

		data=data.substring(0,data.length()-1);
		data+="]";
		ZtreeJson2="";
        PrintWriter out = response.getWriter();
		
        response.setContentType("application/json; charset=utf-8");  
        response.setHeader("pragma", "no-cache");  
        response.setHeader("cache-control", "no-cache");  
		out.write(data);
		out.close();
		
	}
	public void  getZtreeJson2(Long id,List<WebSubColumn> wscs,String qx){
		
		for(WebSubColumn wsc:wscs){
			if(wsc.getZtid()==id){
				if(qx.indexOf(String.valueOf(wsc.getId()))>0){
				 ZtreeJson2+="{\"id\":\""+wsc.getId()+"\",\"pId\":\""+wsc.getZtid()+"\",\"name\":\""+convert(wsc.getLmmc())+"\"},";
	             getZtreeJson2(wsc.getId(), wscs,qx);
				}
			}
		}
		
	}
	
	private void getColumnData(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException, IOException {
		String data="[";
		String qx="";
		HttpSession session = request.getSession();
		qx= session.getAttribute("qx").toString();
		AjaxDao ajaxDao=new AjaxDao();
		List<WebColumn> rootColumnList=ajaxDao.getRootColumn();
		List<WebColumn> subColumnList=ajaxDao.getSubColumn();
		
		for(WebColumn wc:rootColumnList){
			if(qx.indexOf(String.valueOf(wc.getId()))>0){
				data+="{\"id\":\""+wc.getId()+"\",\"pId\":\""+wc.getSjid()+"\",\"name\":\""+convert(wc.getLmmc())+"\",\"isParent\":\"true\"},";
				getZtreeJson(wc.getId(),subColumnList,qx);
			}
	        data+=ZtreeJson;
	        ZtreeJson="";	
		}
		data=data.substring(0,data.length()-1);
		data+="]";
		ZtreeJson="";
        PrintWriter out = response.getWriter();
        response.setContentType("application/json; charset=utf-8");  
        response.setHeader("pragma", "no-cache");  
        response.setHeader("cache-control", "no-cache");  
		out.write(data);
		out.close();
		
	}
	
	public void  getZtreeJson(Long id,List<WebColumn> wcs,String qx){
		for(WebColumn wc:wcs){
			if(wc.getSjid()==id){
				if(qx.indexOf(String.valueOf(wc.getId()))>0){
				 ZtreeJson+="{\"id\":\""+wc.getId()+"\",\"pId\":\""+wc.getSjid()+"\",\"name\":\""+convert(wc.getLmmc())+"\"},";
	             getZtreeJson(wc.getId(), wcs,qx);
				}
			}
		}
		
	}

	
	
	

	/*	
	 * 
	 * 		for(WebColumn wc:rootColumnList){
	        data+="{\"id\":\""+wc.getId()+"\",\"pid\":\""+wc.getSjid()+"\",\"name\":\""+convert(wc.getLmmc())+"\",\"isParent\":\"true\"},";
	        getZtreeJson(wc.getId(),subColumnList);
	        data+=ZtreeJson;
	        ZtreeJson="";	
		}
	 * 
	 * 
	 * 
	 * 	for(WebColumn wc:rootColumnList){
	        data+="{\"id\":\""+wc.getId()+"\",\"pid\":\""+wc.getSjid()+"\",\"name\":\""+convert(wc.getLmmc())+"\",\"isParent\":\"true\"},";
			}
			
			for(WebColumn wcc:subColumnList){		
				data+="{\"id\":\""+wcc.getId()+"\",\"pid\":\""+wcc.getSjid()+"\",\"name\":\""+convert(wcc.getLmmc())+"\"},";		
			}
			for(WebColumn wc:rootColumnList){
				data+="{\"id\":\""+wc.getId()+"\",\"pId\":\""+wc.getSjid()+"\",\"name\":\""+convert(wc.getLmmc())+"\",\"isParent\":\"true\"},";
			
				for(WebColumn wcc:subColumnList){	
					if(wc.getId()==wcc.getSjid()){
					data+="{\"id\":\""+wcc.getId()+"\",\"pId\":\""+wcc.getSjid()+"\",\"name\":\""+convert(wcc.getLmmc())+"\"},";		
				
					}
				}
			}*/
	
	
/*  private void getColumnData(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException, IOException {
		String data="[";
		
		
		AjaxDao ajaxDao=new AjaxDao();
		List<WebColumn> rootColumnList=ajaxDao.getRootColumn();
		List<WebColumn> subColumnList=ajaxDao.getSubColumn();
		
		
		for(WebColumn wc:rootColumnList){
			
		    data+="{\"text\":\""+convert(wc.getLmmc())+"\",\"isexpand\":\"false\",\"children\":[";
			
		    if(subColumnList.size()>0){
		    for(WebColumn sc:subColumnList){			
				if(wc.getId()==sc.getSjid()){
					data+="{\"url\":\""+convert("article/ArticleServlet?act=list&pid="+sc.getId())+"\",\"text\":\""+convert(sc.getLmmc())+"\"},";
					
				}
				
			}	
		    data=data.substring(0,data.length()-1);
		    data+="]},";
		    }else{
			    data=data.substring(0,data.length()-1);
			    data+="\"\"},";
		    }
		    
		}
		data=data.substring(0,data.length()-1);
		data+="]";
	
		System.out.println(data);
        PrintWriter out = response.getWriter();
		
        response.setContentType("application/json; charset=utf-8");  
        response.setHeader("pragma", "no-cache");  
        response.setHeader("cache-control", "no-cache");  
		out.write(data);
		out.close();
		
	}*/
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
