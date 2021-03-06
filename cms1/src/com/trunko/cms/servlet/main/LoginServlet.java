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
import com.trunko.cms.util.Escape;
import com.trunko.cms.util.FavoritesHelper;


/**
 * ��¼������
 * @author gjz
 *
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			String yzm=request.getParameter("yzm");
			String yhm=Escape.unescape( request.getParameter("yhm"));
			String mm=FavoritesHelper.getEncrypt(request.getParameter("mm"));
			String yhlx=request.getParameter("yhlx");
			
			String ip=request.getRemoteAddr();
			HttpSession session =request.getSession();
			String data="[\"SUCCESS\",\"";
			if(!yzm.equals(session.getAttribute("randCheckCode")))
			{
				data+="yzmErr";
			}else
			{
				LoginDao loginDao=new LoginDao();
				if(yhlx.equals("sys")||yhlx.equals("xmgl")){
					WebUser user=loginDao.checkLogin(yhm, mm, ip);
					if(user!=null)
					{
						session.setAttribute("id", user.getId());
						session.setAttribute("yhm", user.getYhm());
						session.setAttribute("xm", user.getXm());
						session.setAttribute("qx", user.getQx());

						session.setAttribute("lb",yhlx);
						session.setMaxInactiveInterval(3600);
						//���õ�¼ҳ
						Cookie cookie = new Cookie("loginlb",yhlx);

						cookie.setMaxAge(24*60*60);
						response.addCookie(cookie);
						
						data+="ok";
					}else{
						data+="yhmErr";
					}
				}else{
					WebUser user=loginDao.checkLoginYb(yhm, mm,ip); //�±��û�
					if(user!=null)
					{
						session.setAttribute("id", user.getId());
						session.setAttribute("yhm", user.getYhm());
						session.setAttribute("xm", user.getXm());
		//				session.setAttribute("lb", user.getLb());
						session.setMaxInactiveInterval(3600);
						
						//���õ�¼ҳ
						Cookie cookie = new Cookie("loginlb",yhlx);

						cookie.setMaxAge(24*60*60);
						response.addCookie(cookie);
						
						data+="ok";
					}else{
						data+="yhmErr";
					}
				}
			}
			data+="\"]";
			PrintWriter out = response.getWriter();
	        response.setContentType("application/json; charset=utf-8");  
	        response.setHeader("pragma", "no-cache");  
	        response.setHeader("cache-control", "no-cache");  
			out.write(data);
			out.close();
	}
}
