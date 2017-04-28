package com.trunko.cms.servlet.sysconfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.trunko.cms.dao.article.ArticleDao;
import com.trunko.cms.dao.sysconfig.SpecialColumnDao;
import com.trunko.cms.dao.sysconfig.SysColumnDao;
import com.trunko.cms.entity.WebColumn;
import com.trunko.cms.entity.WebModel;
import com.trunko.cms.entity.WebSubColumn;
import com.trunko.cms.util.FavoritesHelper;
import com.trunko.cms.util.Pager;

/**
 * 系统栏目管理控制器
 * @author cxp
 *
 */
@SuppressWarnings("serial")
public class SysColumnServlet extends HttpServlet {

	static Logger logger = Logger.getLogger("cms");
	
	private int pageSize = 10;
	private int pageNo = 1;
	private Long pid=0l;

	//private Pager pager;
    
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         doPost(request, response);
	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       String act = request.getParameter("act");
       if("list".equals(act)){
           getList(request,response);
       }else if(act.equals("deleteColumns")){
           deleteColumns(request,response);
   	   }else if(act.equals("addpage")){
   		   goAddPage(request,response);
   	   }else if(act.equals("add")){
   		   add(request,response);
   	   }else if(act.equals("updatepage")){
   		   goUpdatePage(request,response);
   	   }else if(act.equals("update")){
   		   update(request,response);
   	   }else if(act.equals("toSubColumn")){
   		   goSubColumn(request,response);
   	   }else if(act.equals("addSubPage")){
   		   goAddSubPage(request,response);
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
		
		SysColumnDao sysColumnDao = new SysColumnDao();
		WebColumn webColumn=sysColumnDao.getById(id);
		
		List<WebModel> webModelList=new ArrayList<WebModel>();
		webModelList=sysColumnDao.getModelList();
		
		request.setAttribute("itemList", webModelList);
		request.setAttribute("column", webColumn);
		request.getRequestDispatcher("updatesubcolumn.jsp").forward(request, response);
	}
	
	
	
  	/**
  	 * 在某频道/上级栏目下添加栏目
  	 * @param request
  	 * @param response
  	 * @throws ServletException
  	 * @throws IOException
  	 */
   	private void addSub(HttpServletRequest request, HttpServletResponse response) 
     throws ServletException, IOException {
   		
   		pid=Long.valueOf(request.getParameter("pid"));
   		WebColumn webColumn=new WebColumn();
   		webColumn.setLmmc(request.getParameter("lmmc"));
   		webColumn.setLmmx(request.getParameter("lmmx"));
   		webColumn.setSjid(pid);
   		webColumn.setLmpx(Integer.valueOf(FavoritesHelper.stringToint(request.getParameter("lmpx"))));
   		
   		SysColumnDao sysColumnDao = new SysColumnDao();
   		String data="";
   		if(sysColumnDao.add(webColumn)){
			data="<script>parent.location.reload();</script>";
		}
        PrintWriter out = response.getWriter();
		out.write(data);
		out.close();
	}


	/**
   	 * 栏目页下的添加页面  得到上级 频道id，模板列表
   	 */
 	private void goAddSubPage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
 		pid=Long.valueOf(request.getParameter("pid"));
		List<WebModel> webModelList=new ArrayList<WebModel>();
		SysColumnDao sysColumnDao = new SysColumnDao();
		webModelList=sysColumnDao.getModelList();
		request.setAttribute("itemList", webModelList);
		request.setAttribute("pid", pid);
		request.getRequestDispatcher("addsubcolumn.jsp").forward(request, response);
	}
   	
 	
 	/**
 	 * 从频道页/上级栏目跳转到频道内/上级栏目内的栏目上
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
		SysColumnDao sysColumnDao = new SysColumnDao();
		Pager pager=sysColumnDao.getSubColumnForPage(pageNo, pageSize,pid);
	
		request.setAttribute("pager", pager);
		request.setAttribute("pid", pid);
		Long rid=sysColumnDao.getById(pid).getSjid();
		request.setAttribute("rid", rid);
		request.getRequestDispatcher("subcolumn_list.jsp").forward(request, response);
	
		
	}


	private void update(HttpServletRequest request,HttpServletResponse response)
       throws ServletException, IOException {
		pid=Long.valueOf(request.getParameter("pid"));
   		WebColumn webColumn = new WebColumn();
   		webColumn.setId(Long.valueOf(request.getParameter("id")));
   		webColumn.setLmmc(request.getParameter("lmmc"));
   		webColumn.setLmmx(request.getParameter("lmmx"));
   		webColumn.setLmpx(Integer.valueOf(request.getParameter("lmpx")));

   		SysColumnDao sysColumnDao = new SysColumnDao();
   		String data="";
   		if(sysColumnDao.update(webColumn)){
			data="<script>parent.location.reload();</script>";
		}
        PrintWriter out = response.getWriter();
		out.write(data);
		out.close();

   	}
   	
   	private void goUpdatePage(HttpServletRequest request,HttpServletResponse response)
       throws ServletException, IOException {
   		long id=Long.valueOf(request.getParameter("id"));
   		
   		SysColumnDao sysColumnDao = new SysColumnDao();
   		WebColumn webColumn=sysColumnDao.getById(id);
   		request.setAttribute("column", webColumn);
   		request.getRequestDispatcher("updatecolumn.jsp").forward(request, response);
   	}

   	
   	private void add(HttpServletRequest request,HttpServletResponse response)
       throws ServletException, IOException {
   		WebColumn webColumn=new WebColumn();
   		webColumn.setLmmc(request.getParameter("lmmc"));
   		webColumn.setSjid(0);
   		webColumn.setLmpx(Integer.valueOf(request.getParameter("lmpx")));
   		SysColumnDao sysColumnDao = new SysColumnDao();
   		String data="";
   		if(sysColumnDao.add(webColumn)){
			data="<script>parent.location.reload();</script>";
		}
        PrintWriter out = response.getWriter();
		out.write(data);
		out.close();
   	}
   	
   	private void goAddPage(HttpServletRequest request,HttpServletResponse response)
       throws ServletException, IOException {
   		
   		request.getRequestDispatcher("addcolumn.jsp").forward(request, response);
   	}

   	private void deleteColumns(HttpServletRequest request,HttpServletResponse response)
   	    throws ServletException, IOException {
   		long id=Long.valueOf(request.getParameter("id"));
   		 String data="[\"FAIL\"]";
   		 SysColumnDao sysColumnDao = new SysColumnDao();
   		 if(sysColumnDao.delColumnList(id)){
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
		SysColumnDao sysColumnDao = new SysColumnDao();
		Pager pager=sysColumnDao.getColumnForPage(pageNo, pageSize);
	
		request.setAttribute("pager", pager);
		request.getRequestDispatcher("column_list.jsp").forward(request, response);
	
    }

}
