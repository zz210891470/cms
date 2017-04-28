package com.trunko.project.serlvet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.util.FavoritesHelper;
import com.trunko.cms.util.Pager;
import com.trunko.project.dao.ZdaxmDao;
import com.trunko.project.dao.ZdaxmSbyhDao;
import com.trunko.project.entity.ProZdaxm;
import com.trunko.project.entity.ProZdaxmYb;

public class ZdaxmSbyhServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equals("sbxmlr")){
			toSbxmlrPage(request,response);
			
		}
		else if(action.equals("xmyblb")){ //项目管理列表页
		    showXmyblb(request, response);
	    }
		else if(action.equals("xmgllist")){
			getList(request, response);
			
		}else if(action.equals("toAdd")){//跳转到添加页面
		    goAddPage(request, response);
	    }
	    else if(action.equals("toEdit")){//跳转到编辑页面
		    goEditPage(request, response);
	    }
	    else if(action.equals("xmyblb")){//跳转到项目月报列表
	    	showXmyblb(request, response);
	    }
	    else if(action.equals("yblb")){//月报列表
	    	showYblb(request, response);
	    }	    
	    else if(action.equals("yblr")){//月报录入
	    	showYblr(request, response);
	    }
	    else if(action.equals("toRead")){//跳转到查看详情页面
		    goReadPage(request, response);
	    }
	    else if(action.equals("toYbRead")){//月报浏览
	    	showYbll(request, response);
	    }
	    else if(action.equals("toYbEdit")){//月报编辑
	    	showYbbj(request, response);
	    }
	    else if(action.equals("saveup")){//月报上报
	    	saveUp(request, response);
	    }
	}



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		
		if(action.equals("sbxmlr")){  //侧边栏项目录入页面显示
			toSbxmlrPage(request,response);		
		}
		else if(action.equals("xmyblb")){ //项目管理列表页
		    showXmyblb(request, response);
	    }
		else if(action.equals("xmlr")){ //侧边栏项目录入
		    Xmlr(request, response);
	    }else if(action.equals("xmgllist")){
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
	    else if(action.equals("upmsg")){  //上报项目
	    	upMsg(request,response);
	    }
	    else if(action.equals("yblb")){  //月报列表页面
	    	showYblb(request, response);
	    }
	    else if(action.equals("yblr")){   //月报录入页面
	    	showYblr(request, response);
	    }	    
	    else if(action.equals("addyb")){ //添加月报
		    addYb(request, response);
	    }
	    else if(action.equals("toYbEdit")){//月报编辑
	    	showYbbj(request, response);
	    }
	    else if(action.equals("saveup")){//月报上报
	    	saveUp(request, response);
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
	    item.setZt(request.getParameter("zt"));
		ZdaxmSbyhDao.editYb(item);
	
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideAddFrame();</script>"); 
		out.flush();
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
		ProZdaxmYb proZdaxmYb = ZdaxmSbyhDao.showYbbj(Integer.parseInt(id));
		request.setAttribute("yf", proZdaxmYb.getYf());
		request.setAttribute("id", id);
		
		ProZdaxm proZdaxm = ZdaxmSbyhDao.getObjByBh(String.valueOf(proZdaxmYb.getPid()));
		
		request.setAttribute("zdaxmyb", proZdaxmYb);
		request.setAttribute("zdaxm", proZdaxm);
		request.setAttribute("id", id);
		request.getRequestDispatcher("ybbj.jsp").forward(request, response);
	}
	/**
	 * 月报管理显示月报编辑页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void saveUp(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		String id = request.getParameter("id");
		if(ZdaxmSbyhDao.saveUp(Long.parseLong(id))){
			response.setContentType("text/html;charset=UTF-8"); 
		    PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>alert('数据上报成功！');parent.location.reload();</script>"); 
			out.flush();
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
		ProZdaxmYb proZdaxmYb = ZdaxmSbyhDao.showYbll(Integer.parseInt(id));
		ProZdaxm proZdaxm = ZdaxmSbyhDao.getObjByBh(String.valueOf(proZdaxmYb.getPid()));
		request.setAttribute("zdaxmyb", proZdaxmYb);
		request.setAttribute("zdaxm", proZdaxm);
		request.getRequestDispatcher("ybll.jsp").forward(request, response);
	}
	/**
	 * 添加新项
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addYb(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		ProZdaxmYb item = new ProZdaxmYb();
	    item.setPid(FavoritesHelper.stringTolong(request.getParameter("id")));
	    item.setYf(request.getParameter("yf"));
	    item.setBywc(FavoritesHelper.stringTofloat(request.getParameter("dywc")));
	    item.setNczbywc(FavoritesHelper.stringTofloat(request.getParameter("dnwc")));
	    item.setKgljwc(FavoritesHelper.stringTofloat(request.getParameter("kgwc")));
	    item.setXxjd(request.getParameter("jzqk"));
	    item.setCzwt(request.getParameter("czwt"));
	    item.setGzjh(request.getParameter("xyjh"));
	    item.setWcgzjd(request.getParameter("wcgz"));
	    item.setBz(request.getParameter("bz"));
	    java.util.Date d = new java.util.Date();
		Date tbsj = new Date(d.getTime());
		item.setTbsj(tbsj);
		item.setZt(request.getParameter("zt"));
		
		ZdaxmSbyhDao.addYb(item);
	
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideAddFrame();</script>"); 
		out.flush();
	}
	
	
	/**
	 * 月报管理显示月报录入页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showYblr(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
        String id = request.getParameter("id");
		Integer yf = ZdaxmSbyhDao.showYblr(Integer.parseInt(id));
		// 获取未上报信息
		List<ProZdaxmYb> zdaxmYbList = ZdaxmSbyhDao.getObjByPid(Integer.parseInt(id));
		if(yf == 12 ){
			request.setAttribute("addstatus", "ok");
		
			//调用hide 录入页面，并提示
			showYblb(request, response);
		}else {
			if(FavoritesHelper.isNotNull(zdaxmYbList) && ("未上报".equals(zdaxmYbList.get(0).getZt())) ){
				response.setContentType("text/html;charset=UTF-8"); 
			    PrintWriter out = response.getWriter();
				out.println("<script type='text/javascript'>alert('"+zdaxmYbList.get(0).getYf()+"月份数据未上报，不能添加月报！');window.parent.hideFrame();</script>"); 
				out.flush();
			}else{
				
				yf = yf+1;
				request.setAttribute("yf", yf);
				ProZdaxm proZdaxm = ZdaxmSbyhDao.getObjByBh(id);
				request.setAttribute("zdaxm", proZdaxm);
				request.setAttribute("id", id);
				request.getRequestDispatcher("yblr.jsp").forward(request, response);
			}
		}

		
	}
	
	/**
	 * 月报管理显示项目列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showYblb(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
        String id = request.getParameter("id");
		
		List<ProZdaxmYb> itemList = ZdaxmSbyhDao.showYblb(Integer.parseInt(id));
		request.setAttribute("itemList", itemList);
		request.setAttribute("id", id);
		request.setAttribute("xmmc", ZdaxmSbyhDao.getXmmc(Integer.parseInt(id)));
        request.setAttribute("listnum", itemList.size());
		request.getRequestDispatcher("yb.jsp").forward(request, response);
	}
	
	/**
	 * 月报管理显示项目列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showXmyblb(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		int nd;
		if(request.getParameter("nd")==null||request.getParameter("nd")==""){
			Calendar calendar = Calendar.getInstance();
			request.setAttribute("thedate", calendar.get(Calendar.YEAR));
			nd = calendar.get(Calendar.YEAR);
		}else{
			request.setAttribute("thedate", request.getParameter("nd"));
			nd =  Integer.parseInt(request.getParameter("nd"));
		}
		
		List<ProZdaxm> itemList = ZdaxmSbyhDao.showXmlb(request.getSession().getAttribute("yhm").toString(),nd);
		request.setAttribute("itemList", itemList);
		request.getRequestDispatcher("xmlb.jsp").forward(request, response);
		
	}
	
	
	/**
	 * 更新列表项
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void upMsg(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
		ZdaxmSbyhDao.upMsg(request.getParameter("id"));
		
		postList(request, response);
		
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
		
		ProZdaxm item = new ProZdaxm();
		
		item.setId(FavoritesHelper.stringTolong(request.getParameter("id")));
		item.setNd(FavoritesHelper.stringTolong(request.getParameter("nd")));
		item.setBh(request.getParameter("bh"));
		item.setMc(request.getParameter("mc"));
		item.setDq(request.getParameter("dq"));
		item.setJsgm(request.getParameter("jsgm"));
		item.setJsdd(request.getParameter("jsdd"));
		item.setZtz(FavoritesHelper.stringTolong(request.getParameter("ztz")));
		item.setYd(FavoritesHelper.stringTofloat(request.getParameter("yd")));
		item.setLd(FavoritesHelper.stringTofloat(request.getParameter("ld")));
		item.setLb1(request.getParameter("lb1"));
		item.setLb2(request.getParameter("lb2"));
		item.setLb3(request.getParameter("lb3"));
		item.setJsdq(request.getParameter("jsdq"));
		item.setBawh(request.getParameter("bawh"));
		item.setJsnx1(FavoritesHelper.stringToint(request.getParameter("jsnx1")));
		item.setJsnx2(FavoritesHelper.stringToint(request.getParameter("jsnx2")));
		item.setJhtz(FavoritesHelper.stringTolong(request.getParameter("jhtz")));
		item.setJdmb(request.getParameter("jdmb"));
		item.setKgn(request.getParameter("kgn"));
		item.setKgy(request.getParameter("kgy"));
		item.setJgn(request.getParameter("jgn"));
		item.setJgy(request.getParameter("jgy"));
		item.setWctz(FavoritesHelper.stringTolong(request.getParameter("wctz")));
		// 更新对象
		ZdaxmDao.update(item);	
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
		ProZdaxm item = ZdaxmDao.getObjById(id);
		request.setAttribute("dqlist",  ZdaxmDao.getDqList());
		request.setAttribute("lblist", ZdaxmDao.getLbList());
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
		
		ProZdaxm item = new ProZdaxm();
		
		item.setNd(FavoritesHelper.stringTolong(request.getParameter("nd")));
		item.setBh(request.getParameter("bh"));
		item.setMc(request.getParameter("mc"));
		item.setDq(request.getParameter("dq"));
		item.setJsgm(request.getParameter("jsgm"));
		item.setJsdd(request.getParameter("jsdd"));
		item.setZtz(FavoritesHelper.stringTolong(request.getParameter("ztz")));
		item.setYd(FavoritesHelper.stringTofloat(request.getParameter("yd")));
		item.setLd(FavoritesHelper.stringTofloat(request.getParameter("ld")));
		item.setLb1(request.getParameter("lb1"));
		item.setLb2(request.getParameter("lb2"));
		item.setLb3(request.getParameter("lb3"));
		item.setJsdq(request.getParameter("jsdq"));
		item.setBawh(request.getParameter("bawh"));
		item.setJsnx1(FavoritesHelper.stringToint(request.getParameter("jsnx1")));
		item.setJsnx2(FavoritesHelper.stringToint(request.getParameter("jsnx2")));
		item.setJhtz(FavoritesHelper.stringTolong(request.getParameter("jhtz")));
		item.setJdmb(request.getParameter("jdmb"));
		item.setKgn(request.getParameter("kgn"));
		item.setKgy(request.getParameter("kgy"));
		item.setJgn(request.getParameter("jgn"));
		item.setJgy(request.getParameter("jgy"));
		item.setWctz(FavoritesHelper.stringTolong(request.getParameter("wctz")));
		item.setZt("未上报");
		item.setSbyh(request.getSession().getAttribute("yhm").toString());
		// 新增对象
		ZdaxmDao.add(item);
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
		request.setAttribute("dqlist",  ZdaxmDao.getDqList());
		request.setAttribute("lblist", ZdaxmDao.getLbList());
		request.getRequestDispatcher("xmadd.jsp").forward(request, response);
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
		 	
		if(ZdaxmDao.delItemList(itemList)){
			//TODO 应该是若是普通用户应该ajax类型的删除节省流量  后台用户也直接记录页面位置
			postList(request, response);
		}else{
			//定位至错误页面
		}	
	}

	private void toSbxmlrPage(HttpServletRequest request,HttpServletResponse response) 
	    throws ServletException, IOException {
		
		request.setAttribute("dqlist",  ZdaxmDao.getDqList());
		request.setAttribute("lblist", ZdaxmDao.getLbList());
		request.getRequestDispatcher("xmlr.jsp").forward(request, response);
	}
	
	
	/**
	 * 侧边栏的项目录入
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void Xmlr(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		ProZdaxm item = new ProZdaxm();
		
		item.setNd(FavoritesHelper.stringTolong(request.getParameter("nd")));
		item.setBh(request.getParameter("bh"));
		item.setMc(request.getParameter("mc"));
		item.setDq(request.getParameter("dq"));
		item.setJsgm(request.getParameter("jsgm"));
		item.setJsdd(request.getParameter("jsdd"));
		item.setZtz(FavoritesHelper.stringTolong(request.getParameter("ztz")));
		item.setYd(FavoritesHelper.stringTofloat(request.getParameter("yd")));
		item.setLd(FavoritesHelper.stringTofloat(request.getParameter("ld")));
		item.setLb1(request.getParameter("lb1"));
		item.setLb2(request.getParameter("lb2"));
		item.setLb3(request.getParameter("lb3"));
		item.setJsdq(request.getParameter("jsdq"));
		item.setBawh(request.getParameter("bawh"));
		item.setJsnx1(FavoritesHelper.stringToint(request.getParameter("jsnx1")));
		item.setJsnx2(FavoritesHelper.stringToint(request.getParameter("jsnx2")));
		item.setJhtz(FavoritesHelper.stringTolong(request.getParameter("jhtz")));
		item.setJdmb(request.getParameter("jdmb"));
		item.setKgn(request.getParameter("kgn"));
		item.setKgy(request.getParameter("kgy"));
		item.setJgn(request.getParameter("jgn"));
		item.setJgy(request.getParameter("jgy"));
		item.setWctz(FavoritesHelper.stringTolong(request.getParameter("wctz")));
		item.setZt("未上报");
		item.setSbyh(request.getSession().getAttribute("yhm").toString());
		// 新增对象
		ZdaxmDao.add(item);
		
		request.setAttribute("dqlist",  ZdaxmDao.getDqList());
		request.setAttribute("lblist", ZdaxmDao.getLbList());
		//录入成功后 界面弹出成功提醒
		request.setAttribute("status", "ok");
		request.getRequestDispatcher("xmlr.jsp").forward(request, response);
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
	    String sbyh = request.getSession().getAttribute("yhm").toString();
		Pager pager = ZdaxmSbyhDao.getObjForPage(pageNo, pageSize, searchStr, sbyh);
	
		request.setAttribute("pager", pager);
		request.setAttribute("searchStr", searchStr);
		request.getRequestDispatcher("gl.jsp").forward(request, response);
		
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
		String sbyh = request.getSession().getAttribute("yhm").toString();
		Pager pager = ZdaxmSbyhDao.getObjForPage(pageNo, pageSize, searchStr, sbyh);
	
		request.setAttribute("pager", pager);
		request.setAttribute("searchStr", searchStr);
	
		request.getRequestDispatcher("gl.jsp").forward(request, response);
		
	}

	/**
	 * 跳转到查看详情页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goReadPage(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
		String id = request.getParameter("id"); // 项目主键
		ProZdaxm item = ZdaxmSbyhDao.getObjByBh(id); // 项目信息
		request.setAttribute("item", item);
		request.getRequestDispatcher("ll.jsp").forward(request, response);
	}
}
