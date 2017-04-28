package com.trunko.project.serlvet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.util.FavoritesHelper;
import com.trunko.cms.util.Pager;
import com.trunko.project.dao.ManageDao;
import com.trunko.project.entity.ProUser;

public class ManageServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		String action=request.getParameter("action");
		   
	    if(action.equals("list")){//显示列表
		    getList(request, response);
	    }
	    else if(action.equals("toAdd")){//跳转到添加页面
		    goAddPage(request, response);
	    }
	    else if(action.equals("toEdit")){//跳转到编辑页面
		    goEditPage(request, response);
	    }
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
	    String action=request.getParameter("action");
	   
	    if(action.equals("list")){//显示列表
		    postList(request, response);
	    }
	    else if(action.equals("del")){//删除列表项
		    delItems(request, response);
	    }
	    else if(action.equals("toAdd")){//跳转到添加页面
		    goAddPage(request, response);
	    }
	    else if(action.equals("add")){//添加列表项
		    add(request, response);
	    }
	    else if(action.equals("toEdit")){//跳转到编辑页面
		    goEditPage(request, response);
	    }
	    else if(action.equals("update")){//修改列表项
		    update(request, response);
	    }
	}
	
	/**
	 * 更新列表项
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void update(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		ProUser item = new ProUser();
		
		item.setId(Long.valueOf(request.getParameter("id")));
	//    item.setNd(request.getParameter("nd"));
	    item.setYhm(request.getParameter("yhm"));
	    item.setXm(request.getParameter("xm"));

	    ProUser tempUser = ManageDao.getObjById(FavoritesHelper.stringTolong(request.getParameter("id")));
	    String oldPwd = tempUser.getMm();
	    if (!oldPwd.equals(request.getParameter("mm"))) {
		    item.setMm(FavoritesHelper.getEncrypt(request.getParameter("mm")));
		}else {
			item.setMm(oldPwd);
		}
	
		ManageDao.update(item);	
			
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideEditFrame();</script>"); 
		out.flush();
	}
	
	/**
	 * 跳转到编辑页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goEditPage(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		long id   = Long.valueOf(request.getParameter("id"));
	
		ProUser item = ManageDao.getObjById(id);
		
		request.setAttribute("item", item);
	
		
		String lb = request.getParameter("lx");
		if(lb.equals("zd")){
			request.getRequestDispatcher("zdxm/sz_gly_edit.jsp").forward(request, response);
		}else if(lb.equals("zda")){
		    request.getRequestDispatcher("zdaxm/sz_gly_edit.jsp").forward(request, response);
		}else if(lb.equals("cb")){
			request.getRequestDispatcher("cbxm/sz_gly_edit.jsp").forward(request, response);
		}
	}
	
	/**
	 * 添加新项
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void add(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		ProUser item = new ProUser();
	
	    item.setYhm(request.getParameter("yhm"));
	    item.setMm(FavoritesHelper.getEncrypt(request.getParameter("mm")));
	    item.setXm(request.getParameter("xm"));
	    item.setLb(request.getParameter("lx"));

	
		ManageDao.add(item);
	
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideAddFrame();</script>"); 
		out.flush();
	}
	
	
	/**
	 * 跳转到添加页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goAddPage(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		String lb = request.getParameter("lx");
		if(lb.equals("zd")){
			request.getRequestDispatcher("zdxm/sz_gly_add.jsp").forward(request, response);
		}else if(lb.equals("zda")){
		    request.getRequestDispatcher("zdaxm/sz_gly_add.jsp").forward(request, response);
		}else if(lb.equals("cb")){
			request.getRequestDispatcher("cbxm/sz_gly_add.jsp").forward(request, response);
		}
		
	}
	
	/**
	 * 删除列表项  仅接受post请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delItems(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		String[] itemList = request.getParameterValues("itemList");
		 	
		if(ManageDao.delItemList(itemList)){
			//TODO 应该是若是普通用户应该ajax类型的删除节省流量  后台用户也直接记录页面位置
			postList(request, response);
		}else{
			//定位至错误页面
		}	
	}
	
	/**
	 * get请求加载列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getList(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
	
		Integer  pageNo   = 1;
		Integer  pageSize = 10;
	    String searchStr = request.getParameter("searchStr");
		String lb = request.getParameter("lx");

		Pager pager = ManageDao.getObjForPage(pageNo, pageSize, searchStr, lb);
	
		request.setAttribute("pager", pager);
		request.setAttribute("searchStr", searchStr);
		if(lb.equals("zd")){
		    request.getRequestDispatcher("zdxm/sz_gly.jsp").forward(request, response);
		}else if(lb.equals("zda")){
		    request.getRequestDispatcher("zdaxm/sz_gly.jsp").forward(request, response);
		}else if(lb.equals("cb")){
			request.getRequestDispatcher("cbxm/sz_gly.jsp").forward(request, response);
		}
	}
	
	
	/**
	 * post请求加载列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void postList(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
	
		Integer  pageNo   = 1;
		Integer  pageSize = 10;

		if( ! (request.getParameter("pageNo") == null ||
			   request.getParameter("pageNo").equals(""))){
			
			pageNo   = Integer.valueOf(request.getParameter("pageNo"));
		}
		if( ! (request.getParameter("pageSize") == null ||
			   request.getParameter("pageSize").equals(""))){
			
			pageSize = Integer.valueOf(request.getParameter("pageSize"));
		}
		String lb = request.getParameter("lx");
	
		String searchStr = request.getParameter("searchStr");
		Pager pager = ManageDao.getObjForPage(pageNo, pageSize, searchStr, lb);
	
		request.setAttribute("pager", pager);
		request.setAttribute("searchStr", searchStr);
	
		if(lb.equals("zd")){
		    request.getRequestDispatcher("zdxm/sz_gly.jsp").forward(request, response);
		}else if(lb.equals("zda")){
		    request.getRequestDispatcher("zdaxm/sz_gly.jsp").forward(request, response);
		}else if(lb.equals("cb")){
			request.getRequestDispatcher("cbxm/sz_gly.jsp").forward(request, response);
		}
	}
}
