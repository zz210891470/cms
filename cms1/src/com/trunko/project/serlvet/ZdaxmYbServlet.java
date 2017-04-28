package com.trunko.project.serlvet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.util.FavoritesHelper;
import com.trunko.cms.util.Pager;
import com.trunko.project.dao.ZdaxmSbyhDao;
import com.trunko.project.dao.ZdaxmYbDao;
import com.trunko.project.entity.ProZdaxm;
import com.trunko.project.entity.ProZdaxmYb;

public class ZdaxmYbServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		String action=request.getParameter("action");
		   
	    if(action.equals("list")){//显示列表
		    getList(request, response);
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
		    getList(request, response);
	    }
	    else if(action.equals("edityb")){ //编辑月报保存
		    editYb(request, response);
	    }

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
		
		ProZdaxmYb item = new ProZdaxmYb();
	    item.setId(FavoritesHelper.stringTolong(request.getParameter("id")));
	    item.setBywc(FavoritesHelper.stringTofloat(request.getParameter("dywc")));
	    item.setNczbywc(FavoritesHelper.stringTofloat(request.getParameter("dnwc")));
	    item.setKgljwc(FavoritesHelper.stringTofloat(request.getParameter("kgwc")));
	    item.setXxjd(request.getParameter("jzqk"));
	    item.setCzwt(request.getParameter("czwt"));
	    item.setGzjh(request.getParameter("gzjh"));
	    item.setWcgzjd(request.getParameter("wcgz"));
	    item.setBz(request.getParameter("bz"));
		ZdaxmYbDao.editYb(item);
	
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideAddFrame();</script>"); 
		out.flush();
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
		ProZdaxmYb proZdaxmYb = ZdaxmYbDao.showYbll(Integer.parseInt(id));
		ProZdaxm proZdaxm = ZdaxmSbyhDao.getObjByBh(String.valueOf(proZdaxmYb.getPid()));
		request.setAttribute("zdaxmyb", proZdaxmYb);
		request.setAttribute("zdaxm", proZdaxm);
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
		ProZdaxmYb proZdaxmYb = ZdaxmYbDao.showYbbj(Integer.parseInt(id));
		request.setAttribute("yf", proZdaxmYb.getYf());
		request.setAttribute("id", id);
		
		ProZdaxm proZdaxm = ZdaxmYbDao.getObjByBh(String.valueOf(proZdaxmYb.getPid()));
		
		request.setAttribute("zdaxmyb", proZdaxmYb);
		request.setAttribute("zdaxm", proZdaxm);
		request.setAttribute("id", id);
		request.getRequestDispatcher("ybbj.jsp").forward(request, response);
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
		Integer  pageSize = 12;
	    String nd = request.getParameter("nd");
	    String yf = request.getParameter("yf");
	    if(!FavoritesHelper.isNotNull(nd)){ // 如果年度为空，取系统当前年份
	    	Calendar cal = Calendar.getInstance();
	    	int year = cal.get(Calendar.YEAR);
	    	nd = String.valueOf(year);
	    }
	    if(!FavoritesHelper.isNotNull(yf)){
	    	Calendar calendar = Calendar.getInstance();
			request.setAttribute("yf", calendar.get(Calendar.MONTH)+1);
			yf = (calendar.get(Calendar.MONTH)+1)+"";
	    }
		Pager pager = ZdaxmYbDao.getObjForPage(pageNo, pageSize,nd,yf);
		request.setAttribute("pager", pager);
		request.setAttribute("nd", nd);
		request.setAttribute("yf", yf);
		request.getRequestDispatcher("yb.jsp").forward(request, response);
		
	}
	
}
