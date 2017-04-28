package com.trunko.cms.servlet.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		
    	//判断cookies
   	    Cookie[] cookies = request.getCookies();  
        if (cookies != null && cookies.length > 0) {  
            // 遍历浏览器发送到服务器端的所有Cookie，找到自己设置的Cookie  
            for (Cookie cookie : cookies) {  
                String cookieName = cookie.getName();  
                if (cookieName.equals("loginlb")) {
               	 if(cookie.getValue().equals("sys")){
         			session = null;
        			response.sendRedirect("login.html");
        			return;
            	 }
            	 if(cookie.getValue().equals("xmgl")){
         			session = null;
        			response.sendRedirect("xmgl_login.html");
        			return;
            	 }
            	 if(cookie.getValue().equals("yb")){
         			session = null;
        			response.sendRedirect("zdxm_login.html");
        			return;
            	 }
             }
         }
     }
               	 
		
/*		if(session.getAttribute("lb").toString()=="sys")
		{
			session.invalidate();
			response.sendRedirect("login.html");
			}
		else if(session.getAttribute("lb").toString()=="xmgl")
		{
			session.invalidate();
			response.sendRedirect("xmgl_login.html");
			}
		else{
			session.invalidate();
			response.sendRedirect("zdxm_login.html");
		}*/
//		String data="[\"SUCCESS\"";
//		data+="ok";
//		data+="\"]";
//		PrintWriter out = response.getWriter();
//        response.setContentType("application/json; charset=utf-8");  
//        response.setHeader("pragma", "no-cache");  
//        response.setHeader("cache-control", "no-cache");  
//		out.write(data);
//		out.close();
	}

}
