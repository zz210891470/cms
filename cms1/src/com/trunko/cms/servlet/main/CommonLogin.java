package com.trunko.cms.servlet.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trunko.cms.dao.main.LoginDao;
import com.trunko.cms.entity.ProYbUser;
import com.trunko.cms.entity.WebUser;

public class CommonLogin extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String type = request.getParameter("type") ;
        String yhm = request.getParameter("username");
        String mm = request.getParameter("userpwd");

        HttpSession session =request.getSession();
        String ip=request.getRemoteAddr();
       	LoginDao loginDao=new LoginDao();
		
		WebUser user=loginDao.checkLogin(yhm, mm, ip);
        if(user!=null){
			session.setAttribute("id", user.getId());
			session.setAttribute("yhm", user.getYhm());
			session.setAttribute("xm", user.getXm());
			session.setAttribute("qx", user.getQx());

			session.setAttribute("lb", type);
			session.setMaxInactiveInterval(3600);
			//…Ë÷√µ«¬º“≥
			Cookie cookie = new Cookie("loginlb", type);

			cookie.setMaxAge(24*60*60);
			response.addCookie(cookie);
			
			if(type.equals("sys")){
				response.sendRedirect("admin/AjaxServlet?act=index&lb=sys");			
			}else if(type.equals("xmgl")){
				response.sendRedirect("admin/AjaxServlet?act=index&lb=xmgl");	
			}
			
        }else{
        	
        }
        
        
	}

}
