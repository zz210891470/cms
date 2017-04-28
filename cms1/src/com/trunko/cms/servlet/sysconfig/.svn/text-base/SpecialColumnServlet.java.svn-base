package com.trunko.cms.servlet.sysconfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.dao.sysconfig.SpecialColumnDao;
import com.trunko.cms.dao.sysconfig.SpecialColumnDao;
import com.trunko.cms.dao.sysconfig.SysColumnDao;
import com.trunko.cms.entity.WebColumn;
import com.trunko.cms.entity.WebSubColumn;
import com.trunko.cms.entity.WebModel;
import com.trunko.cms.entity.WebSubColumn;
import com.trunko.cms.util.Pager;
/**
 * 专题管理控制器
 * @author gjz
 *
 */
public class SpecialColumnServlet extends HttpServlet {

	
	private int pageSize = 10;
	private int pageNo = 1;
	private Long pid=0l;

	
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
	   }else if(act.equals("addSubPage")){
   		   goAddSubPage(request,response);
   	   }else if(act.equals("toSubColumn")){
   		   goSubColumn(request,response);
   	   }else if(act.equals("addSub")){
   		   addSub(request,response);
   	   }else if(act.equals("subupdatepage")){
   		   goSubUpdatePage(request,response);
   	   }else if(act.equals("hasColumn")){
		    hasColumn(request,response);
   	   }
	}
	
	/**
	 * 删除栏目，判断是否有子栏目
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void hasColumn(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		String data="[\"FAIL\"]";
		Long id=Long.valueOf(request.getParameter("id"));
		SysColumnDao sysColumnDao = new SysColumnDao();
		if(sysColumnDao.hasColumn(id)){
			data="[\"SUCCESS\"]";
		}
        PrintWriter out = response.getWriter();
        response.setContentType("application/json; charset=utf-8");  
        response.setHeader("pragma", "no-cache");  
        response.setHeader("cache-control", "no-cache");  
		out.write(data);
		out.close();
	}
	/**
	 * 栏目修改页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
   	private void goSubUpdatePage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		long id=Long.valueOf(request.getParameter("id"));
		
		SpecialColumnDao specialColumnDao = new SpecialColumnDao();
		WebSubColumn webSubColumn=specialColumnDao.getById(id);
		
		//List<WebModel> webModelList=new ArrayList<WebModel>();
		//webModelList=specialColumnDao.getModelList();
		
		//request.setAttribute("itemList", webModelList);
		request.setAttribute("item", webSubColumn);
		request.getRequestDispatcher("updatesubjectcolumn.jsp").forward(request, response);
	}
	
	
	
 	/**
  	 * 在某频道下添加栏目
  	 * @param request
  	 * @param response
  	 * @throws ServletException
  	 * @throws IOException
  	 */
   	private void addSub(HttpServletRequest request, HttpServletResponse response) 
     throws ServletException, IOException {
   		pid=Long.valueOf(request.getParameter("pid"));
   		
   		WebSubColumn webSubColumn=new WebSubColumn();
   		webSubColumn.setLmmc(request.getParameter("lmmc"));
   		webSubColumn.setLmmx(request.getParameter("lmmx"));
   		webSubColumn.setZtid(pid);
   		webSubColumn.setLmpx(Integer.valueOf(request.getParameter("lmpx")));
   		SpecialColumnDao specialColumnDao = new SpecialColumnDao();
   		String data="";
   		if(specialColumnDao.add(webSubColumn)){
			data="<script>parent.location.reload();</script>";
		}
        PrintWriter out = response.getWriter();
		out.write(data);
		out.close();
	}

	
	
	/**
 	 * 从频道页跳转到频道内的栏目上
 	 * @param request
 	 * @param response
 	 * @throws ServletException
 	 * @throws IOException
 	 */
   	private void goSubColumn(HttpServletRequest request,HttpServletResponse response)  
   	 throws ServletException, IOException {
   		pid=Long.valueOf(request.getParameter("pid"));
		if(!(request.getParameter("pageNo")==null||request.getParameter("pageNo").equals(""))){
			pageNo=Integer.valueOf(request.getParameter("pageNo"));
		}
		if(!(request.getParameter("pageSize")==null||request.getParameter("pageSize").equals(""))){
			pageSize=Integer.valueOf(request.getParameter("pageSize"));
		}
		SpecialColumnDao specialColumnDao = new SpecialColumnDao();
		Pager pager=specialColumnDao.getSubColumnForPage(pageNo, pageSize,pid);
	
		request.setAttribute("pager", pager);
		request.setAttribute("pid", pid);
		Long rid=specialColumnDao.getById(pid).getZtid();
		request.setAttribute("rid", rid);
		request.getRequestDispatcher("subjectcolumn_list.jsp").forward(request, response);
	
		
	}
	
	
	private void goAddSubPage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		pid=Long.valueOf(request.getParameter("pid"));
		List<WebModel> webModelList=new ArrayList<WebModel>();
		SpecialColumnDao sysSubColumnDao=new SpecialColumnDao();
		webModelList=sysSubColumnDao.getModelList();
		
		request.setAttribute("itemList", webModelList);
		request.setAttribute("pid", pid);
		request.getRequestDispatcher("addsubjectcolumn.jsp").forward(request, response);
	}
	



	private void update(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		pid=Long.valueOf(request.getParameter("pid"));
		WebSubColumn webSubColumn=new WebSubColumn();
		webSubColumn.setId(Long.valueOf(request.getParameter("id")));
		webSubColumn.setLmmc(request.getParameter("lmmc"));
		webSubColumn.setLmmx(request.getParameter("lmmx"));
		webSubColumn.setLmpx(Integer.valueOf(request.getParameter("lmpx")));

		SpecialColumnDao specialColumnDao=new SpecialColumnDao();
		String data="";
		if(specialColumnDao.update(webSubColumn)){
			data="<script>parent.location.reload();</script>";
		}
        PrintWriter out = response.getWriter();
		out.write(data);
		out.close();
	}
	
	private void goUpdatePage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		long id=Long.valueOf(request.getParameter("id"));
		
		SpecialColumnDao specialColumnDao=new SpecialColumnDao();
		WebSubColumn webSubColumn=specialColumnDao.getById(id);
		request.setAttribute("item", webSubColumn);
		request.getRequestDispatcher("updatesubject.jsp").forward(request, response);
	}

	
	private void add(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebSubColumn webSubColumn=new WebSubColumn();
		webSubColumn.setLmmc(request.getParameter("lmmc"));
		webSubColumn.setLmlx(request.getParameter("lmlx"));
		webSubColumn.setLmmx(request.getParameter("lmmx"));
		webSubColumn.setZtid(0);
		webSubColumn.setLmpx(Integer.valueOf(request.getParameter("lmpx")));
		
		SpecialColumnDao sysSubColumnDao=new SpecialColumnDao();
		String data="";
		if(sysSubColumnDao.add(webSubColumn)){
			data="<script>parent.location.reload();</script>";
		}
	    PrintWriter out = response.getWriter();
		out.write(data);
		out.close();
	}
	
	
	private void goAddPage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {	
		request.getRequestDispatcher("addsubject.jsp").forward(request, response);
	}

	private void deleteItems(HttpServletRequest request,HttpServletResponse response)
	    throws ServletException, IOException {
		 long id=Long.valueOf(request.getParameter("id"));
   		 String data="[\"FAIL\"]";
		 
		 SpecialColumnDao sysRoleDao=new SpecialColumnDao();
		 if(sysRoleDao.delItemList(id)){
			 data="[\"SUCCESS\"]";
   			PrintWriter out = response.getWriter();
   			out.write(data);
   			out.close();
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
		SpecialColumnDao subColumnDao=new SpecialColumnDao();
		Pager pager=subColumnDao.getItemForPage(pageNo, pageSize);

		request.setAttribute("pager", pager);
		request.getRequestDispatcher("subject_list.jsp").forward(request, response);
		
	}


}
