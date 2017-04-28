package com.trunko.cms.servlet.sysconfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.dao.sysconfig.SysModelDao;
import com.trunko.cms.entity.WebModel;
import com.trunko.cms.util.Pager;

/**
 * 系统模型管理控制器
 * @author gjz
 *
 */
public class SysModelServlet extends HttpServlet {

	
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
	   }else if(act.equals("addpage")){
		   goAddPage(request,response);
	   }else if(act.equals("add")){
		   add(request,response);
	   }else if(act.equals("updatepage")){
		   goUpdatePage(request,response);
	   }else if(act.equals("update")){
		   update(request,response);
	   }
	}
	
	private void update(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebModel webModel=new WebModel();
		webModel.setId(Long.valueOf(request.getParameter("id")));
		webModel.setMxbt(request.getParameter("mxbt"));
		webModel.setMxpx(Integer.valueOf(request.getParameter("mxpx")));
		webModel.setXtmr(request.getParameter("xtmr"));

		
		SysModelDao sysModelDao=new SysModelDao();
		sysModelDao.update(webModel);
		
		getList(request, response);

	}
	
	private void goUpdatePage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		long id=Long.valueOf(request.getParameter("id"));
		
		SysModelDao sysModelDao=new SysModelDao();
		WebModel webModel=sysModelDao.getById(id);
		request.setAttribute("item", webModel);
		request.getRequestDispatcher("updatemodel.jsp").forward(request, response);
	}

	
	private void add(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebModel webModel=new WebModel();
		webModel.setMxbt(request.getParameter("mxbt"));
		webModel.setMxpx(Integer.valueOf(request.getParameter("mxpx")));
		webModel.setXtmr(request.getParameter("xtmr"));
		
		SysModelDao sysModelDao=new SysModelDao();
		sysModelDao.add(webModel);
		
		getList(request, response);

	}
	
	
	private void goAddPage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		
		request.getRequestDispatcher("addmodel.html").forward(request, response);
	}

	private void deleteItems(HttpServletRequest request,HttpServletResponse response)
	    throws ServletException, IOException {
		 String[]  itemList=request.getParameterValues("itemList");
		 pageNo=Integer.valueOf(request.getParameter("pageNo"));
		 pageSize=Integer.valueOf(request.getParameter("pageSize"));
		 
		 SysModelDao sysModelDao=new SysModelDao();
		 if(sysModelDao.delItemList(itemList)==true){
			 response.sendRedirect("SysModelServlet?act=list&pageNo="+pageNo+"&pageSize"+pageSize);
		 }else{
			 //定位至错误页面
		 }
		 
		
	}


	private void getList(HttpServletRequest request,HttpServletResponse response) 
        throws ServletException, IOException {
		if(!(request.getParameter("pageNo")==null||request.getParameter("pageNo").equals(""))){
			pageNo=Integer.valueOf(request.getParameter("pageNo"));
		}
		if(!(request.getParameter("pageSize")==null||request.getParameter("pageSize").equals(""))){
			pageSize=Integer.valueOf(request.getParameter("pageSize"));
		}
		SysModelDao sysModelDao=new SysModelDao();
		Pager pager=sysModelDao.getItemForPage(pageNo, pageSize);

		request.setAttribute("pager", pager);
		request.getRequestDispatcher("model_list.jsp").forward(request, response);
		
	}

}
