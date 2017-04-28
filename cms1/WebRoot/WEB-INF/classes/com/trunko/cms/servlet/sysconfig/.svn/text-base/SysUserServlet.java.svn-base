package com.trunko.cms.servlet.sysconfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.dao.sysconfig.SysUserDao;
import com.trunko.cms.entity.WebColumn;
import com.trunko.cms.entity.WebSubColumn;
import com.trunko.cms.entity.WebUser;
import com.trunko.cms.util.FavoritesHelper;
import com.trunko.cms.util.Pager;


/**
 * 系统用户管理控制器
 * @author gjz
 *
 */
public class SysUserServlet extends HttpServlet {
	
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
		
		String qx = ",";   
		String[] qx1 = request.getParameterValues("qx");   
		if(qx1 != null ){
			for (int i = 0; i < qx1.length; i++) {   
			   qx += qx1[i]+",";   
			}   
		}
		WebUser webUser=new WebUser();
		webUser.setId(Long.valueOf(request.getParameter("id")));
		webUser.setYhm(request.getParameter("username"));
		webUser.setXm(request.getParameter("truename"));
		webUser.setMm(FavoritesHelper.getEncrypt(request.getParameter("password")));
		webUser.setZt(Integer.valueOf(request.getParameter("state")));
		webUser.setQx(qx);
		webUser.setYx(request.getParameter("mail"));
		webUser.setDh(request.getParameter("phone"));
		
		SysUserDao sysUserDao=new SysUserDao();
		sysUserDao.update(webUser);
		
		getList(request, response);

	}
	
	private void goUpdatePage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		long id=Long.valueOf(request.getParameter("id"));
		
		SysUserDao sysUserDao=new SysUserDao();
		WebUser webUser=sysUserDao.getById(id);
		request.setAttribute("item", webUser);
		
		List<WebColumn> lmqx=new ArrayList<WebColumn>();
		List<WebColumn> lmqx1=new ArrayList<WebColumn>();
		List<WebSubColumn> ztqx=new ArrayList<WebSubColumn>();
		List<WebSubColumn> ztqx1=new ArrayList<WebSubColumn>();

		lmqx=sysUserDao.lmqxList();
		lmqx1=sysUserDao.lmqxList1();
		ztqx=sysUserDao.ztqxList();
		ztqx1=sysUserDao.ztqxList1();
		request.setAttribute("lmqx", lmqx);
		request.setAttribute("lmqx1", lmqx1);
		request.setAttribute("ztqx", ztqx);
		request.setAttribute("ztqx1", ztqx1);
		
		request.getRequestDispatcher("updateuser.jsp").forward(request, response);
	}

	
	private void add(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		String qx = "";   
		String[] qx1 = request.getParameterValues("qx"); 
		
		if(qx1 != null){
			for (int i = 0; i < qx1.length; i++) {   
			   qx += qx1[i];   
			}  
		}
		
		WebUser webUser=new WebUser();
		webUser.setYhm(request.getParameter("username"));
		webUser.setXm(request.getParameter("truename"));
		webUser.setMm(FavoritesHelper.getEncrypt(request.getParameter("password")));
		webUser.setZt(Integer.valueOf(request.getParameter("state")));
		webUser.setQx(qx);
		webUser.setYx(request.getParameter("mail"));
		webUser.setDh(request.getParameter("phone"));
		
		SysUserDao sysUserDao=new SysUserDao();
		sysUserDao.add(webUser);
		getList(request, response);
	}
	
	
	private void goAddPage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		List<WebColumn> lmqx=new ArrayList<WebColumn>();
		List<WebColumn> lmqx1=new ArrayList<WebColumn>();
		List<WebSubColumn> ztqx=new ArrayList<WebSubColumn>();
		List<WebSubColumn> ztqx1=new ArrayList<WebSubColumn>();
		SysUserDao sysUserDao=new SysUserDao();
		lmqx=sysUserDao.lmqxList();
		lmqx1=sysUserDao.lmqxList1();
		ztqx=sysUserDao.ztqxList();
		ztqx1=sysUserDao.ztqxList1();
		request.setAttribute("lmqx", lmqx);
		request.setAttribute("lmqx1", lmqx1);
		request.setAttribute("ztqx", ztqx);
		request.setAttribute("ztqx1", ztqx1);
		request.getRequestDispatcher("adduser.jsp").forward(request, response);
	}

	private void deleteItems(HttpServletRequest request,HttpServletResponse response)
	    throws ServletException, IOException {
		 String[]  itemList=request.getParameterValues("itemList");
		 pageNo=Integer.valueOf(request.getParameter("pageNo"));
		 pageSize=Integer.valueOf(request.getParameter("pageSize"));
		 
		 SysUserDao sysUserDao=new SysUserDao();
		 if(sysUserDao.delItemList(itemList)==true){
			 response.sendRedirect("SysUserServlet?act=list&pageNo="+pageNo+"&pageSize"+pageSize);
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
		SysUserDao sysUserDao=new SysUserDao();
		Pager pager=sysUserDao.getItemForPage(pageNo, pageSize);

		request.setAttribute("pager", pager);
		request.getRequestDispatcher("user_list.jsp").forward(request, response);
	}
}


