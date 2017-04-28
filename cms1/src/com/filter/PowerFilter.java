package com.filter;


import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class  PowerFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		String currentURL = request.getRequestURI();
 
		HttpSession session = request.getSession(false);
		
		if(currentURL.contains("admin")){		
			/*if(currentURL.endsWith(".jsp")){
				if(currentURL.contains("editor")){
					filterChain.doFilter(request, response);
				}else{
		       	 	 response.setContentType("text/html;charset=UTF-8"); 
		        	 PrintWriter out = response.getWriter();
		     		out.println("<script type='text/javascript'>alert('无此页面！');document.location.href='"+request.getContextPath()+"/404.html';</script>"); 
		     		out.flush();
				}

			//	response.sendRedirect(request.getContextPath()+ "/admin/login.html");
				return; 
			}else*/
				if(currentURL.contains("Servlet")){
				if(currentURL.contains("LoginServlet") || currentURL.contains("CommonLogin")){
					filterChain.doFilter(request, response);
				}else{
					if (session == null || session.getAttribute("yhm") == null) {
						
		        	 	response.setContentType("text/html;charset=UTF-8"); 
			        	PrintWriter out = response.getWriter();  
			        	
			        	//判断cookies
			        	 Cookie[] cookies = request.getCookies();  
			             if (cookies != null && cookies.length > 0) {  
			                 // 遍历浏览器发送到服务器端的所有Cookie，找到自己设置的Cookie  
			                 for (Cookie cookie : cookies) {  
			                     String cookieName = cookie.getName();  
			                     if (cookieName.equals("loginlb")) {
			                    	 if(cookie.getValue().equals("sys")){
					 			     	 out.println("<script type='text/javascript'>alert('登录超时，请重新登录！');top.location.href='"+request.getContextPath()+"/admin/login.html';</script>"); 
								     	 out.flush();
			                    	 }
			                    	 if(cookie.getValue().equals("xmgl")){
					 			     	 out.println("<script type='text/javascript'>alert('登录超时，请重新登录！');top.location.href='"+request.getContextPath()+"/admin/xmgl_login.html';</script>"); 
								     	 out.flush();
			                    	 }
			                    	 if(cookie.getValue().equals("yb")){
					 			     	 out.println("<script type='text/javascript'>alert('登录超时，请重新登录！');top.location.href='"+request.getContextPath()+"/admin/zdxm_login.html';</script>"); 
								     	 out.flush();
			                    	 }
			                     }
			                 }
			             }
			        	
			        	

				//		response.sendRedirect(request.getContextPath()+ "/admin/login.html");
						return; 
					}else{

					    session.setMaxInactiveInterval(3600);
					    filterChain.doFilter(request, response);
						
					}
				}
			}else{
				filterChain.doFilter(request, response);
			}
		}else{
			filterChain.doFilter(request, response);
		}
					                       
	}
             


	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}