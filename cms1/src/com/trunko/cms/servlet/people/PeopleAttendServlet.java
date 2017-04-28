package com.trunko.cms.servlet.people;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.dao.location.LmphDao;
import com.trunko.cms.dao.people.PeopleAttendDao;
import com.trunko.cms.entity.WebConsult;
import com.trunko.cms.entity.WebLeaderMail;
import com.trunko.cms.entity.WebSuggestion;

public class PeopleAttendServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          doPost(request, response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
         String act=request.getParameter("act");
    
         LmphDao lmphDao = new LmphDao();
 		 lmphDao.LmphUpdate("公众参与");
 		
         if(act.equals("consult")){
        	 submitConsult(request,response);
         }else if(act.equals("getdata")){
        	 getData(request,response);
         }else if(act.equals("question")){
        	 getQuestionData(request,response);	 
         }else if(act.equals("suggestion")){
        	 submitSuggestion(request,response);	 
         }else if(act.equals("mail")){
        	 submitMail(request,response);	 
         }else if(act.equals("getmail")){
        	 getMail(request,response);
         }

	}
	
	
	private void getMail(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {

		String pageNo=request.getParameter("pageNo");
		
		String data="[\"SUCCESS\",\"";
		PeopleAttendDao peopleAttendDao=new PeopleAttendDao();
	    data+=convert(peopleAttendDao.getMailForPage(Integer.valueOf(pageNo), 10));
		data+="\"]";
		PrintWriter out = response.getWriter();
			
	    response.setContentType("application/json; charset=utf-8");  
	    response.setHeader("pragma", "no-cache");  
	    response.setHeader("cache-control", "no-cache");  
		out.write(data);
		out.close();
    }

	
	private void submitMail(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
	         String xm=request.getParameter("xm");
	         String lxfs=request.getParameter("lxfs");
	         String bt =request.getParameter("bt");
	         String nr =request.getParameter("nr");

	         WebLeaderMail webLeaderMail=new WebLeaderMail();
	         webLeaderMail.setXm(xm);
	         webLeaderMail.setLxfs(lxfs);
	         webLeaderMail.setBt(bt);
	         webLeaderMail.setNr(nr);

	         PeopleAttendDao peopleAttendDao=new PeopleAttendDao();
	         peopleAttendDao.addMail(webLeaderMail);
	         
	         response.sendRedirect("ldxx.html");
	}

	private void submitSuggestion(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
         String xm=request.getParameter("xm");
         String lxfs=request.getParameter("lxfs");
         String bt =request.getParameter("bt");
         String nr =request.getParameter("nr");

         WebSuggestion webSuggestion=new WebSuggestion();
         webSuggestion.setXm(xm);
         webSuggestion.setLxfs(lxfs);
         webSuggestion.setBt(bt);
         webSuggestion.setNr(nr);

         PeopleAttendDao peopleAttendDao=new PeopleAttendDao();
         peopleAttendDao.addSuggestion(webSuggestion);
         
         response.sendRedirect("myzj.html");
		
	}
	

	private void getQuestionData(HttpServletRequest request,
			HttpServletResponse response) 	throws ServletException, IOException {
	   String pageNo=request.getParameter("pageNo");
		
		String data="[\"SUCCESS\",\"";
		PeopleAttendDao peopleAttendDao=new PeopleAttendDao();
	    data+=convert(peopleAttendDao.getQuestionForPage(Integer.valueOf(pageNo), 10));
		data+="\"]";
		PrintWriter out = response.getWriter();
			
        response.setContentType("application/json; charset=utf-8");  
        response.setHeader("pragma", "no-cache");  
        response.setHeader("cache-control", "no-cache");  
		out.write(data);
		out.close();
		
	}


	private void getData(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException {

		String pageNo=request.getParameter("pageNo");
		
		String data="[\"SUCCESS\",\"";
		PeopleAttendDao peopleAttendDao=new PeopleAttendDao();
	    data+=convert(peopleAttendDao.getArticleForPage(Integer.valueOf(pageNo), 10));
		data+="\"]";
		PrintWriter out = response.getWriter();
			
        response.setContentType("application/json; charset=utf-8");  
        response.setHeader("pragma", "no-cache");  
        response.setHeader("cache-control", "no-cache");  
		out.write(data);
		out.close();
	}


	private void submitConsult(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
         String xm=request.getParameter("xm");
         String lxfs=request.getParameter("lxfs");
         String bt =request.getParameter("bt");
         String nr =request.getParameter("nr");

         WebConsult webConsult=new WebConsult();
         webConsult.setXm(xm);
         webConsult.setLxfs(lxfs);
         webConsult.setBt(bt);
         webConsult.setNr(nr);

         PeopleAttendDao peopleAttendDao=new PeopleAttendDao();
         peopleAttendDao.add(webConsult);
         
         response.sendRedirect("zxzx.html");
		
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
