package com.trunko.cms.servlet.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trunko.cms.dao.sysconfig.SysConfigDao;
import com.trunko.cms.dao.sysconfig.SysLogDao;
import com.trunko.cms.dao.main.LoginDao;
import com.trunko.cms.entity.WebConfig;
import com.trunko.cms.entity.WebUser;

public class WelcomeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SysConfigDao sysConfigDao=new SysConfigDao();
		WebConfig webConfig = sysConfigDao.getInfo();
		request.setAttribute("webconfig", webConfig);
		HttpSession session = request.getSession();
		request.setAttribute("uname",session.getAttribute("xm"));
		request.setAttribute("servername", request.getServerName());
		request.setAttribute("serverip", request.getRemoteAddr());
		
		SysLogDao sysLogDao=new SysLogDao();
		String yhm = session.getAttribute("yhm").toString();
		request.setAttribute("weblog", sysLogDao.getInfo(yhm));
		request.setAttribute("webloglast", sysLogDao.getInfolast(yhm));
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
	}
}
