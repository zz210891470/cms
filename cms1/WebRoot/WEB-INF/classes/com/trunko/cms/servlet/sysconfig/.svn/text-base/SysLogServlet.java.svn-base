package com.trunko.cms.servlet.sysconfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.trunko.cms.dao.sysconfig.SysLogDao;
import com.trunko.cms.entity.WebLog;
import com.trunko.cms.util.Pager;

/**
 * 系统管理日志控制器
 * @author gjz
 *
 */
public class SysLogServlet extends HttpServlet {
	
	private int pageSize = 10;
	private int pageNo = 1;
    private Pager pager;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
         doPost(request,response);
    }


	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	   String act=request.getParameter("act");
	   
	   if(act.equals("list")){
		   getList(request,response);
	   }else if(act.equals("deleteItems")){
		   deleteItems(request,response);
	   }
	}


	private void deleteItems(HttpServletRequest request,HttpServletResponse response)
	    throws ServletException, IOException {
		 String[]  itemList=request.getParameterValues("itemList");
		 pageNo=Integer.valueOf(request.getParameter("pageNo"));
		 pageSize=Integer.valueOf(request.getParameter("pageSize"));
		 
		 SysLogDao sysLogDao=new SysLogDao();
		 if(sysLogDao.delItemList(itemList)==true){
			 response.sendRedirect("SysLogServlet?act=list&pageNo="+pageNo+"&pageSize"+pageSize);
		 }else{
			 //定位至错误页面
		 }
		 
		
	}


	/**
	 * 得到系统日志列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getList(HttpServletRequest request,HttpServletResponse response) 
        throws ServletException, IOException {
		if(!(request.getParameter("pageNo")==null||request.getParameter("pageNo").equals(""))){
			pageNo=Integer.valueOf(request.getParameter("pageNo"));
		}
		if(!(request.getParameter("pageSize")==null||request.getParameter("pageSize").equals(""))){
			pageSize=Integer.valueOf(request.getParameter("pageSize"));
		}
		SysLogDao sysLogDao=new SysLogDao();
		Pager pager=sysLogDao.getItemForPage(pageNo, pageSize);

		request.setAttribute("pager", pager);
		request.getRequestDispatcher("log_list.jsp").forward(request, response);
		
	}

    
}
