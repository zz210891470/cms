package com.trunko.cms.servlet.sysconfig;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.dao.sysconfig.SysRoleDao;
import com.trunko.cms.entity.WebRole;
import com.trunko.cms.util.Pager;

/**
 * 系统角色管理控制器
 * @author gjz
 *
 */
public class SysRoleServlet extends HttpServlet {
	
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
		WebRole webRole=new WebRole();
		webRole.setId(Long.valueOf(request.getParameter("id")));
		webRole.setName(request.getParameter("name"));
	//	webRole.setPower(request.getParameter("truename"));
		webRole.setDescr(request.getParameter("descr"));

		
		SysRoleDao sysRoleDao=new SysRoleDao();
		sysRoleDao.update(webRole);
		
		getList(request, response);

	}
	
	private void goUpdatePage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		long id=Long.valueOf(request.getParameter("id"));
		
		SysRoleDao sysRoleDao=new SysRoleDao();
		WebRole webRole=sysRoleDao.getById(id);
		request.setAttribute("item", webRole);
		request.getRequestDispatcher("updaterole.jsp").forward(request, response);
	}

	
	private void add(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebRole webRole=new WebRole();
		webRole.setName(request.getParameter("name"));
	//	webRole.setPower(request.getParameter("truename"));
		webRole.setDescr(request.getParameter("descr"));
		
		SysRoleDao sysRoleDao=new SysRoleDao();
		sysRoleDao.add(webRole);
		
		getList(request, response);

	}
	
	
	private void goAddPage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		
		request.getRequestDispatcher("addrole.html").forward(request, response);
	}

	private void deleteItems(HttpServletRequest request,HttpServletResponse response)
	    throws ServletException, IOException {
		 String[]  itemList=request.getParameterValues("itemList");
		 pageNo=Integer.valueOf(request.getParameter("pageNo"));
		 pageSize=Integer.valueOf(request.getParameter("pageSize"));
		 
		 SysRoleDao sysRoleDao=new SysRoleDao();
		 if(sysRoleDao.delItemList(itemList)==true){
			 response.sendRedirect("SysRoleServlet?act=list&pageNo="+pageNo+"&pageSize"+pageSize);
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
		SysRoleDao sysRoleDao=new SysRoleDao();
		Pager pager=sysRoleDao.getItemForPage(pageNo, pageSize);

		request.setAttribute("pager", pager);
		request.getRequestDispatcher("role_list.jsp").forward(request, response);
		
	}

    
}
