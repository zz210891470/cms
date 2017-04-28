package com.trunko.cms.servlet.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trunko.cms.dao.location.ShowArticleDao;
import com.trunko.cms.dao.main.PasswordDao;
import com.trunko.cms.dao.sysconfig.SysLogDao;
import com.trunko.cms.util.FavoritesHelper;

public class PasswordServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String doType = FavoritesHelper.nullChangeString(request.getParameter("doType")); //修改的类型：项目管理员、上报用户
		if("xmgl".equals(doType)){ // 项目管理员
			updateUserPwd(request, response);
		}else if("sbyh".equals(doType)){ // 上报用户
			updateYbUserPwd(request, response);
		}
	}

	/**
	 * 修改项目管理员的密码
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws IOException 
	 */
	private void updateYbUserPwd(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String ymm = FavoritesHelper.getEncrypt(request.getParameter("ymm"));
		String xmm = FavoritesHelper.getEncrypt(request.getParameter("xmm"));
		HttpSession session = request.getSession();
		String yhm = session.getAttribute("yhm").toString();
		PasswordDao passwordDao=new PasswordDao();
		String data="[\"SUCCESS\",\"";
		if(passwordDao.passwordUpdateYb(yhm, ymm, xmm)){
			data+="ok";
		}else{
			data+="ymmErr";
		}
		data+="\"]";
		PrintWriter out = response.getWriter();
        response.setContentType("application/json; charset=utf-8");  
        response.setHeader("pragma", "no-cache");  
        response.setHeader("cache-control", "no-cache");  
		out.write(data);
		out.close();
		
	}

	/**
	 * 修改上报用户的密码
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void updateUserPwd(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String ymm = FavoritesHelper.getEncrypt(request.getParameter("ymm"));
		String xmm = FavoritesHelper.getEncrypt(request.getParameter("xmm"));
		HttpSession session = request.getSession();
		String yhm = session.getAttribute("yhm").toString();
		PasswordDao passwordDao=new PasswordDao();
		String data="[\"SUCCESS\",\"";
		if(passwordDao.passwordUpdate(yhm, ymm, xmm)){
			data+="ok";
		}else{
			data+="ymmErr";
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
