package com.trunko.cms.servlet.sysconfig;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.dao.sysconfig.SysConfigDao;
import com.trunko.cms.entity.WebConfig;

/**
 * 系统基础信息配置控制类
 * @author gjz
 *
 */
public class SysConfigServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           String act=request.getParameter("act");
           
           if(act.equals("save")){
        	   saveSysConfig(request,response);
           }else if(act.equals("getinfo")){
        	   getSysConfigInfo(request,response);
           }
	}


	private void saveSysConfig(HttpServletRequest request,HttpServletResponse response)
	        throws ServletException, IOException {
		WebConfig webConfig=new WebConfig();
		webConfig.setId(Long.valueOf(request.getParameter("id")));
		webConfig.setZdmc(request.getParameter("webname"));
		webConfig.setDwmc(request.getParameter("webcompany"));
		webConfig.setWzym(request.getParameter("weburl"));
		webConfig.setLxdh(request.getParameter("webtel"));
		webConfig.setCzhm(request.getParameter("webfax"));
		webConfig.setGlyyx(request.getParameter("webmail"));
		webConfig.setIcp(request.getParameter("webcrod"));
		webConfig.setSybt(request.getParameter("webtitle"));
		webConfig.setYmgjc(request.getParameter("webkeyword"));
		webConfig.setYmms(request.getParameter("webdescription"));
		webConfig.setBqxx(request.getParameter("webcopyright"));
		
		SysConfigDao sysConfigDao=new SysConfigDao();
		sysConfigDao.saveInfo(webConfig);
		
		response.sendRedirect("SysConfigServlet?act=getinfo");
	}
	
	private void getSysConfigInfo(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
	    WebConfig webConfig=new WebConfig();
		
		SysConfigDao sysConfigDao=new SysConfigDao();
		webConfig=sysConfigDao.getInfo();
		
		request.setAttribute("webconfig", webConfig);
	    //设置servlet的路径时，最好和要加载的页面放到同路径，这样避免了css和js的路径问题
		//用绝对路径的方式可以解决，但是页面上全是相对路径，没有去改了
		request.getRequestDispatcher("config.jsp").forward(request,response);
	}

}
