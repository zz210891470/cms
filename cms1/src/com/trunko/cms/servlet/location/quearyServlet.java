package com.trunko.cms.servlet.location;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class quearyServlet extends HttpServlet {
	
	public static String filterContent(String content){  
		   String flt ="'|and|exec|xp_cmdshell|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,";  
		   String filter[] = flt.split("|");  
		 for(int i=0;i<filter.length ; i++)  
		    {  
		      content.replace(filter[i], "");  
		    }  
		     return content;  
		  } 

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String keyword = filterContent(request.getParameter("keyword"));
		request.setAttribute("keyword", keyword);
		System.out.println(keyword);
   		request.getRequestDispatcher("queary.jsp").forward(request, response);
	}
}
