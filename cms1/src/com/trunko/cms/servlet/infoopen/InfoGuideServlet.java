package com.trunko.cms.servlet.infoopen;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.dao.infoopen.InfoGuideDao;
import com.trunko.cms.entity.WebInfoGuide;
import com.trunko.cms.entity.WebInfoReg;

public class InfoGuideServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act=request.getParameter("act");
		String topic = request.getParameter("topic").toString();
		if(topic.equals("gkzn")==true){
			topic="公开指南";
		}else if(topic.equals("sqgk")==true){
			topic="申请公开";
		}else if(topic.equals("sfxm")==true){
			topic="收费项目和标准";
		}else if(topic.equals("lct")==true){
			topic="申请公开流程图 ";
		}
		if(act.equals("read")){
			InfoGuideDao infoGuideDao=new InfoGuideDao();
			WebInfoGuide webInfoGuide=infoGuideDao.getByTopic(topic);
			request.setAttribute("item", webInfoGuide);
			if(topic.equals("公开指南")==true){
				request.getRequestDispatcher("infoguide.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("infoapply.jsp").forward(request, response);
			}
			
		}else if(act.equals("update")){
			WebInfoGuide webInfoGuide=new WebInfoGuide();
			webInfoGuide.setTopic(topic);
			webInfoGuide.setContent(request.getParameter("content"));
			InfoGuideDao infoGuideDao=new InfoGuideDao();
			infoGuideDao.update(webInfoGuide);
			
			infoGuideDao=new InfoGuideDao();
			webInfoGuide=infoGuideDao.getByTopic(topic);
			request.setAttribute("item", webInfoGuide);
			if(topic.equals("公开指南")==true){
				response.sendRedirect("InfoGuideServlet?act=read&topic=gkzn");
			}else{
				response.sendRedirect("InfoGuideServlet?act=read&topic=" + request.getParameter("topic").toString());
			}
		   }
	}
}
