package com.trunko.project.serlvet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.util.FavoritesHelper;
import com.trunko.cms.util.Pager;
import com.trunko.project.dao.ZdxmDao;
import com.trunko.project.dao.ZdxmSbyhDao;
import com.trunko.project.dao.ZdxmYbDao;
import com.trunko.project.entity.ProZdxm;
import com.trunko.project.entity.ProZdxmYb;

public class ZdxmYbServlet extends HttpServlet {
	
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
	    else if(action.equals("ybgllist")){//显示列表
		    getYbglList(request, response);
	    }
	    else if(action.equals("toYbRead")){//月报浏览
	    	showYbll(request, response);
	    }
	    else if(action.equals("toYbEdit")){//月报编辑
	    	showYbbj(request, response);
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
	    else if(action.equals("edityb")){//修改列表项
	    	editYb(request, response);
	    }
	    else if(action.equals("ybgllist")){//显示列表
		    getYbglList(request, response);
	    }
	    else if(action.equals("toYbRead")){//月报浏览
	    	showYbll(request, response);
	    }
	    else if(action.equals("toYbEdit")){//月报编辑
	    	showYbbj(request, response);
	    }
	}
	
	/**
	 * 月报管理显示月报浏览页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showYbll(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
        String id = request.getParameter("id");
        int yf = Integer.parseInt(request.getParameter("yf"));
		ProZdxmYb proZdxmYb = ZdxmSbyhDao.showYbll(Integer.parseInt(id));
		ProZdxm proZdxm = ZdxmSbyhDao.getObjByBh(proZdxmYb.getPid());
		request.setAttribute("yf", yf);
		request.setAttribute("zdxmyb", proZdxmYb);
		request.setAttribute("zdxm", proZdxm);
		request.getRequestDispatcher("ybll.jsp").forward(request, response);
	}
	
	/**
	 * 月报管理显示月报编辑页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showYbbj(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
        String id = request.getParameter("id");
        int yf=Integer.parseInt(request.getParameter("yf"));
        
		ProZdxmYb proZdxmYb = ZdxmSbyhDao.showYbbj(Integer.parseInt(id));

		request.setAttribute("yf", yf);
		request.setAttribute("id", id);
		
		ProZdxm proZdxm = ZdxmSbyhDao.getObjByBh(proZdxmYb.getPid());
		System.out.println(proZdxmYb.getPid()+"排序ID");
		request.setAttribute("zdxmyb", proZdxmYb);
		request.setAttribute("zdxm", proZdxm);
		request.setAttribute("id", id);
		request.getRequestDispatcher("ybbj.jsp").forward(request, response);
	}
	
	
	
	/**
	 * 得到项目月报管理列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void  getYbglList(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		String nd = request.getParameter("nd");
		String yf = request.getParameter("yf");
		String lb = request.getParameter("lb");
		
		if(!FavoritesHelper.isNotNull(nd)){
			Calendar calendar = Calendar.getInstance();
			nd = calendar.get(Calendar.YEAR)+"";
		}
		if(!FavoritesHelper.isNotNull(yf)){
			Calendar calendar = Calendar.getInstance();
			yf = (calendar.get(Calendar.MONTH)+1)+"";
		}
		if(!FavoritesHelper.isNotNull(lb)){
			lb = "在建";
		}
		
		request.setAttribute("nd", nd); 
		request.setAttribute("yf", yf); 
		request.setAttribute("lb", lb); 

		//List<ProZdxmYb> itemList = ZdxmYbDao.getZdxmYbList(nd, yf, lb);

		
		List<ProZdxmYb> itemList = ZdxmYbDao.showYbglList(nd,yf,lb);
		request.setAttribute("itemList", itemList);
		request.getRequestDispatcher("yb.jsp").forward(request, response);
		
	}
	
	
	/**
	 * 编辑月报保存
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void editYb(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		ProZdxmYb item = new ProZdxmYb();
	    item.setId(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("id"))));
	    item.setJhtz1(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("jhtz1"))));
	    item.setJhtz2(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("jhtz2"))));
	    item.setJhtz3(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("jhtz3"))));
	    item.setJhtzhj(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("jhtzhj"))));
	    item.setDwzj1(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("dwzj1"))));
	    item.setDwzj2(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("dwzj2"))));
	    item.setDwzj3(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("dwzj3"))));
	    item.setDwzjhj(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("hjdydw"))));
	    item.setDnljdw1(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("dwzj1")))+Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("dndwzj1"))));
	    item.setDnljdw2(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("dwzj2")))+Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("dndwzj2"))));
	    item.setDnljdw3(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("dwzj3")))+Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("dndwzj3"))));
	    item.setDnljdwhj(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("hjdydw")))+Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("hjdndw"))));
	    if(request.getParameter("yf").equals("1")){
		    item.setKgljdw1(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("kgdwzj1"))));
		    item.setKgljdw2(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("kgdwzj2"))));
		    item.setKgljdw3(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("kgdwzj3"))));
		    item.setKgljdwhj(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("kgdwzj1")))+Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("kgdwzj2")))+Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("kgdwzj3"))));
		    item.setNczbywc(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("dywc"))));
	    }else{
	    	item.setKgljdw1(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("dwzj1")))+Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("kgdwzj1"))));
		    item.setKgljdw2(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("dwzj2")))+Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("kgdwzj2"))));
		    item.setKgljdw3(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("dwzj3")))+Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("kgdwzj3"))));
		    item.setKgljdwhj(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("hjdydw")))+Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("hjkgdw"))));
		    item.setNczbywc(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("dywc")))+Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("dnwc"))));
	    }
	    item.setBywc(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("dywc"))));
	    item.setWcndjh(Double.valueOf(FavoritesHelper.nullChangeInteger(request.getParameter("jhtzhj")))==0.0?0.0:((Double.valueOf(FavoritesHelper.nullChangeInteger(request.getParameter("dywc")))+Double.valueOf(FavoritesHelper.nullChangeInteger(request.getParameter("dnwc"))))/Double.valueOf(FavoritesHelper.nullChangeInteger(request.getParameter("jhtzhj")))));
	    item.setKgljwc(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("dywc")))+Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("kgwc"))));
	    item.setXxjd(request.getParameter("xxjd"));
	    item.setScnl(request.getParameter("scnl"));
	    item.setCzwt(request.getParameter("czwt"));
	    item.setXtjj(request.getParameter("xtjj"));
	    item.setGzjh(request.getParameter("gzjh"));
	    item.setJcqk(request.getParameter("jcqk"));
	    item.setZjsm(request.getParameter("zjsm"));
	    item.setZt(request.getParameter("zt"));
		ZdxmSbyhDao.editYb(item);
	
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
	    out.println("<script type='text/javascript'>alert('数据保存成功！');window.parent.hideAddFrame();</script>"); 
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
	
		ProZdxm item = ZdxmDao.getObjById(id);
		
		request.setAttribute("item", item);
	
		request.getRequestDispatcher("xg.jsp").forward(request, response);
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
		
		ProZdxm item = new ProZdxm();
	
	    item.setBh(request.getParameter("bh"));
	    item.setMc(request.getParameter("mc"));
	    item.setJsgm(request.getParameter("jsgm"));

	
		ZdxmDao.add(item);
	
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
		
		request.getRequestDispatcher("lr.jsp").forward(request, response);
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
		 	
		if(ZdxmDao.delItemList(itemList)){
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
		String lb = "";
		String nd = "";
	    String searchStr = request.getParameter("searchStr");
		Pager pager = ZdxmDao.getObjForPage(pageNo, pageSize, lb, nd, searchStr);
	
		request.setAttribute("pager", pager);
		request.setAttribute("searchStr", searchStr);
		
		Calendar calendar = Calendar.getInstance();
		
		
		request.setAttribute("theYear", calendar.get(Calendar.YEAR));
		request.setAttribute("theMonth", calendar.get(Calendar.MONTH) + 1);
		request.getRequestDispatcher("yb.jsp").forward(request, response);
		
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
	
		String searchStr = request.getParameter("searchStr");
		Pager pager = ZdxmYbDao.getObjForPage(pageNo, pageSize, searchStr);
	
		request.setAttribute("pager", pager);
		request.setAttribute("searchStr", searchStr);
	
		request.getRequestDispatcher("yb.jsp").forward(request, response);
		
	}

}
