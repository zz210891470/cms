package com.trunko.cms.servlet.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.dao.main.SysnchronizedPwdDao;

public class SysnchronizedPwd extends HttpServlet {

	/**
	 * Õ¨≤Ω√‹¬Î
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String yhm = req.getParameter("username");
		String password = req.getParameter("password");
		SysnchronizedPwdDao sd = new SysnchronizedPwdDao();
		sd.sysnpwd(yhm, password);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		   doGet(req, resp);
	}
	
	
	

}
