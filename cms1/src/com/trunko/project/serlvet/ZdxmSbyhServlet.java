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
import com.trunko.project.dao.AreaDao;
import com.trunko.project.dao.IndustryDao;
import com.trunko.project.dao.ZdxmDao;
import com.trunko.project.dao.ZdxmSbyhDao;
import com.trunko.project.entity.ProArea;
import com.trunko.project.entity.ProIndustry;
import com.trunko.project.entity.ProZdxm;
import com.trunko.project.entity.ProZdxmYb;

public class ZdxmSbyhServlet extends HttpServlet {
	
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
		else if(action.equals("toRead")){//跳转到浏览项目页面
		    goReadPage(request, response);
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
	    else if(action.equals("addyb")){ //添加月报保存
		    addYb(request, response);
	    }
	    else if(action.equals("edityb")){ //编辑月报保存
		    editYb(request, response);
	    }
	}
	
	/**
	 * 添加月报保存
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addYb(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		ProZdxmYb item = new ProZdxmYb();
	    item.setPid(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("id"))));
	    item.setYf(Integer.parseInt(FavoritesHelper.nullChangeInteger(request.getParameter("yf"))));
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
		    item.setKgljdwhj(Long.parseLong(FavoritesHelper.nullChangeInteger(request.getParameter("hjkgdw"))));
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
	    
	    java.util.Date d = new java.util.Date();
		Date rq = new Date(d.getTime());
		item.setTbrq(rq);
		
	    item.setZt(request.getParameter("zt"));
		ZdxmSbyhDao.addYb(item);
	
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
	    if("已上报".equals(item.getZt())){
	    	out.println("<script type='text/javascript'>alert('数据上报成功！');window.parent.hideAddFrame();</script>"); 
	    }else{
	    	out.println("<script type='text/javascript'>alert('数据保存成功！');window.parent.hideAddFrame();</script>"); 
	    }
		out.flush();
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
	    if("已上报".equals(item.getZt())){
	    	out.println("<script type='text/javascript'>alert('数据上报成功！');window.parent.hideAddFrame();</script>"); 
	    }else{
	    	out.println("<script type='text/javascript'>alert('数据保存成功！');window.parent.hideAddFrame();</script>"); 
	    } 
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
        
		ProZdxmYb proZdxmYb = ZdxmSbyhDao.showYblr(Integer.parseInt(id));
		int yf=0;
		if(proZdxmYb.getYf()==null){
			proZdxmYb.setDnljdw1(0);
			proZdxmYb.setDnljdw2(0);
			proZdxmYb.setDnljdw3(0);
			proZdxmYb.setDnljdwhj(0);
			proZdxmYb.setKgljdw1(0);
			proZdxmYb.setKgljdw2(0);
			proZdxmYb.setKgljdw3(0);
			proZdxmYb.setKgljdwhj(0);
			proZdxmYb.setNczbywc(0);
			proZdxmYb.setKgljwc(0);
			proZdxmYb.setZt("未上报");
		}
		else{
			yf=proZdxmYb.getYf();
		}
		
		if(yf == 12 ){
			request.setAttribute("addstatus", "ok");
			//调用hide 录入页面，并提示
			showYblb(request, response);
		}else {
			if(proZdxmYb.getZt().equals("未上报")==true && yf>0){
				response.setContentType("text/html;charset=UTF-8"); 
			    PrintWriter out = response.getWriter();
				out.println("<script type='text/javascript'>alert('"+yf+"月份数据未上报，不能添加月报！');window.parent.hideFrame();</script>"); 
				out.flush();
			}else{
				yf = yf+1;
				request.setAttribute("yf", yf);
				
				ProZdxm proZdxm = ZdxmSbyhDao.getObjByBh(Long.parseLong(id));
				if(proZdxmYb.getYf()==null){
					proZdxmYb.setKgljwc(proZdxm.getWctz());
				}
				request.setAttribute("zdxmyb", proZdxmYb);
				request.setAttribute("zdxm", proZdxm);
				request.setAttribute("id", id);
				request.getRequestDispatcher("yblr.jsp").forward(request, response);
			}
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
		
		request.setAttribute("zdxmyb", proZdxmYb);
		request.setAttribute("zdxm", proZdxm);
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
		if(ZdxmSbyhDao.saveUp(Long.parseLong(id))){
			response.setContentType("text/html;charset=UTF-8"); 
		    PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>parent.location.reload();</script>"); 
			out.flush();
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
		
		List<ProZdxmYb> itemList = ZdxmSbyhDao.showYblb(Integer.parseInt(id));
		request.setAttribute("itemList", itemList);
		request.setAttribute("id", id);
		request.setAttribute("xmmc", ZdxmSbyhDao.getXmmc(Integer.parseInt(id)));
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
		String lb = FavoritesHelper.nullChangeString(request.getParameter("lb"));
		List<ProZdxm> itemList = ZdxmSbyhDao.showXmlb(request.getSession().getAttribute("yhm").toString(),lb,nd);
		request.setAttribute("xmlb", lb);
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
	
		ZdxmSbyhDao.upMsg(request.getParameter("id"));
		
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
		
		// 重点项目实体
		ProZdxm item = new ProZdxm();
		// 为各属性赋值
		item.setId(Long.valueOf(request.getParameter("id")));
		item.setBh(request.getParameter("bh"));
		item.setNd(FavoritesHelper.stringTolong(request.getParameter("nd")));
	    item.setMc(request.getParameter("mc"));
	    item.setDq(request.getParameter("dq"));
	    item.setKgn(request.getParameter("kgn"));
	    item.setKgy(request.getParameter("kgy"));
	    item.setLb(request.getParameter("lb"));
	    item.setLb1(request.getParameter("lb1"));
	    item.setLb2(request.getParameter("lb2"));
	    item.setJsdq(request.getParameter("jsdq"));
	    item.setJsdd(request.getParameter("jsdd"));
	    item.setJsgm(request.getParameter("jsgm"));
	    item.setBawh(request.getParameter("bawh"));
	    item.setJsnx1(FavoritesHelper.stringToint(request.getParameter("jsnx1")));
	    item.setJsnx2(FavoritesHelper.stringToint(request.getParameter("jsnx2")));
	    item.setZtz(FavoritesHelper.stringTolong(request.getParameter("ztz")));
	    item.setWctz(FavoritesHelper.stringTolong(request.getParameter("wctz")));
	    item.setJzqk(request.getParameter("jzqk"));
	    item.setJhtz(FavoritesHelper.stringTolong(request.getParameter("jhtz")));
	    item.setTz1(FavoritesHelper.stringTolong(request.getParameter("tz1")));
	    item.setTz2(FavoritesHelper.stringTolong(request.getParameter("tz2")));
	    item.setTz3(FavoritesHelper.stringTolong(request.getParameter("tz3")));
	    item.setTz4(FavoritesHelper.stringTolong(request.getParameter("tz4")));
	    item.setTz5(FavoritesHelper.stringTolong(request.getParameter("tz5")));
	    item.setTz6(FavoritesHelper.stringTolong(request.getParameter("tz6")));
	    item.setTz7(FavoritesHelper.stringTolong(request.getParameter("tz7")));
	    item.setTz8(FavoritesHelper.stringTolong(request.getParameter("tz8")));
	    item.setTz9(FavoritesHelper.stringTolong(request.getParameter("tz9")));
	    item.setTz10(FavoritesHelper.stringTolong(request.getParameter("tz10")));
	    item.setTz11(FavoritesHelper.stringTolong(request.getParameter("tz11")));
	    item.setTz12(FavoritesHelper.stringTolong(request.getParameter("tz12")));
	    item.setGcjd(request.getParameter("gcjd"));
	    item.setDwmc(request.getParameter("dwmc"));
	    item.setZrr(request.getParameter("zrr"));
	    item.setGldw(request.getParameter("gldw"));
	    item.setZjppzc(FavoritesHelper.stringTolong(request.getParameter("zjppzc")));
	    item.setZjppdk(FavoritesHelper.stringTolong(request.getParameter("zjppdk")));
	    item.setZjppzf(FavoritesHelper.stringTolong(request.getParameter("zjppzf")));
	    item.setTzztxz(request.getParameter("ztxz"));
	    item.setSfkg(request.getParameter("sfkg"));
	    item.setKgyf(request.getParameter("kgyf"));
	    item.setCz(FavoritesHelper.stringTofloat(request.getParameter("cz")));
	    item.setSs(FavoritesHelper.stringTofloat(request.getParameter("ss")));
	    item.setJy(FavoritesHelper.stringToint(request.getParameter("jy")));
	    item.setZd(FavoritesHelper.stringTofloat(request.getParameter("zd")));
	    item.setNyd(FavoritesHelper.stringTofloat(request.getParameter("nyd")));
	    item.setNt(FavoritesHelper.stringTofloat(request.getParameter("nt")));
	    item.setLd(FavoritesHelper.stringTofloat(request.getParameter("ld")));
	    item.setSgyy(FavoritesHelper.stringTofloat(request.getParameter("sgyy")));
	    item.setHgyp(FavoritesHelper.stringTofloat(request.getParameter("hgyp")));
	    item.setYhdk(FavoritesHelper.stringTofloat(request.getParameter("yhdk")));
	    item.setSfscx(request.getParameter("sfscx"));
	    item.setSfzz(request.getParameter("sfzz"));
	    item.setSfss(request.getParameter("sfss"));
	    item.setSfzy(request.getParameter("sfzy"));
	    item.setSjslb(request.getParameter("sjslb"));

	
		ZdxmDao.update(item);	
			
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
		// 项目主键
		long id   = Long.valueOf(request.getParameter("id"));
		ProZdxm item = ZdxmDao.getObjById(id);
		request.setAttribute("dqlist",  ZdxmDao.getDqList());
		request.setAttribute("lblist", ZdxmDao.getLbList());
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
		
		// 重点项目实体
		ProZdxm item = new ProZdxm();
		// 为各属性赋值
		item.setBh(request.getParameter("bh"));
		item.setNd(FavoritesHelper.stringTolong(request.getParameter("nd")));
	    item.setMc(request.getParameter("mc"));
	    item.setDq(request.getParameter("dq"));
	    item.setKgn(request.getParameter("kgn"));
	    item.setKgy(request.getParameter("kgy"));
	    item.setLb(request.getParameter("lb"));
	    item.setLb1(request.getParameter("lb1"));
	    item.setLb2(request.getParameter("lb2"));
	    item.setJsdq(request.getParameter("jsdq"));
	    item.setJsdd(request.getParameter("jsdd"));
	    item.setJsgm(request.getParameter("jsgm"));
	    item.setBawh(request.getParameter("bawh"));
	    item.setJsnx1(FavoritesHelper.stringToint(request.getParameter("jsnx1")));
	    item.setJsnx2(FavoritesHelper.stringToint(request.getParameter("jsnx2")));
	    item.setZtz(FavoritesHelper.stringTolong(request.getParameter("ztz")));
	    item.setWctz(FavoritesHelper.stringTolong(request.getParameter("wctz")));
	    item.setJzqk(request.getParameter("jzqk"));
	    item.setJhtz(FavoritesHelper.stringTolong(request.getParameter("jhtz")));
	    item.setTz1(FavoritesHelper.stringTolong(request.getParameter("tz1")));
	    item.setTz2(FavoritesHelper.stringTolong(request.getParameter("tz2")));
	    item.setTz3(FavoritesHelper.stringTolong(request.getParameter("tz3")));
	    item.setTz4(FavoritesHelper.stringTolong(request.getParameter("tz4")));
	    item.setTz5(FavoritesHelper.stringTolong(request.getParameter("tz5")));
	    item.setTz6(FavoritesHelper.stringTolong(request.getParameter("tz6")));
	    item.setTz7(FavoritesHelper.stringTolong(request.getParameter("tz7")));
	    item.setTz8(FavoritesHelper.stringTolong(request.getParameter("tz8")));
	    item.setTz9(FavoritesHelper.stringTolong(request.getParameter("tz9")));
	    item.setTz10(FavoritesHelper.stringTolong(request.getParameter("tz10")));
	    item.setTz11(FavoritesHelper.stringTolong(request.getParameter("tz11")));
	    item.setTz12(FavoritesHelper.stringTolong(request.getParameter("tz12")));
	    item.setGcjd(request.getParameter("gcjd"));
	    item.setDwmc(request.getParameter("dwmc"));
	    item.setZrr(request.getParameter("zrr"));
	    item.setGldw(request.getParameter("gldw"));
	    item.setZjppzc(FavoritesHelper.stringTolong(request.getParameter("zjppzc")));
	    item.setZjppdk(FavoritesHelper.stringTolong(request.getParameter("zjppdk")));
	    item.setZjppzf(FavoritesHelper.stringTolong(request.getParameter("zjppzf")));
	    item.setTzztxz(request.getParameter("ztxz"));
	    item.setSfkg(request.getParameter("sfkg"));
	    item.setKgyf(request.getParameter("kgyf"));
	    item.setCz(FavoritesHelper.stringTofloat(request.getParameter("cz")));
	    item.setSs(FavoritesHelper.stringTofloat(request.getParameter("ss")));
	    item.setJy(FavoritesHelper.stringToint(request.getParameter("jy")));
	    item.setZd(FavoritesHelper.stringTofloat(request.getParameter("zd")));
	    item.setNyd(FavoritesHelper.stringTofloat(request.getParameter("nyd")));
	    item.setNt(FavoritesHelper.stringTofloat(request.getParameter("nt")));
	    item.setLd(FavoritesHelper.stringTofloat(request.getParameter("ld")));
	    item.setSgyy(FavoritesHelper.stringTofloat(request.getParameter("sgyy")));
	    item.setHgyp(FavoritesHelper.stringTofloat(request.getParameter("hgyp")));
	    item.setYhdk(FavoritesHelper.stringTofloat(request.getParameter("yhdk")));
	    item.setSfscx(request.getParameter("sfscx"));
	    item.setSfzz(request.getParameter("sfzz"));
	    item.setSfss(request.getParameter("sfss"));
	    item.setSfzy(request.getParameter("sfzy"));
	    item.setSjslb(request.getParameter("sjslb"));
	    item.setZt("未上报");
	    item.setSbyh(request.getSession().getAttribute("yhm").toString());
		ZdxmSbyhDao.add(item);
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
		request.setAttribute("dqlist",  ZdxmDao.getDqList());
		request.setAttribute("lblist", ZdxmDao.getLbList());
		request.getRequestDispatcher("xmadd.jsp").forward(request, response);
	}
	/**
	 * 跳转到项目浏览页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goReadPage(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		
		long id   = Long.valueOf(request.getParameter("id"));
		ProZdxm item = ZdxmDao.getObjById(id);
		request.setAttribute("item", item);
		request.getRequestDispatcher("xmll.jsp").forward(request, response);
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
		
		String[] itemList = {"id"};
		itemList[0] = request.getParameter("id");
		 	
		if(ZdxmDao.delItemList(itemList)){
			postList(request, response);
		}else{
			//定位至错误页面
		}	
	}

	private void toSbxmlrPage(HttpServletRequest request,HttpServletResponse response) 
	    throws ServletException, IOException {
		request.setAttribute("dqlist",  ZdxmDao.getDqList());
		request.setAttribute("lblist", ZdxmDao.getLbList());
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
	throws ServletException, IOException {// 重点项目实体
		ProZdxm item = new ProZdxm();
		// 为各属性赋值
		String bh =  request.getParameter("bh");
		if(ZdxmSbyhDao.checkIfExsitBh(bh)){
			
			item.setBh(request.getParameter("bh"));
			item.setNd(FavoritesHelper.stringTolong(request.getParameter("nd")));
		    item.setMc(request.getParameter("mc"));
		    item.setDq(request.getParameter("dq"));
		    item.setKgn(request.getParameter("kgn"));
		    item.setKgy(request.getParameter("kgy"));
		    item.setLb(request.getParameter("lb"));
		    item.setLb1(request.getParameter("lb1"));
		    item.setLb2(request.getParameter("lb2"));
		    item.setJsdq(request.getParameter("jsdq"));
		    item.setJsdd(request.getParameter("jsdd"));
		    item.setJsgm(request.getParameter("jsgm"));
		    item.setBawh(request.getParameter("bawh"));
		    item.setJsnx1(FavoritesHelper.stringToint(request.getParameter("jsnx1")));
		    item.setJsnx2(FavoritesHelper.stringToint(request.getParameter("jsnx2")));
		    item.setZtz(FavoritesHelper.stringTolong(request.getParameter("ztz")));
		    item.setWctz(FavoritesHelper.stringTolong(request.getParameter("wctz")));
		    item.setJzqk(request.getParameter("jzqk"));
		    item.setJhtz(FavoritesHelper.stringTolong(request.getParameter("jhtz")));
		    item.setTz1(FavoritesHelper.stringTolong(request.getParameter("tz1")));
		    item.setTz2(FavoritesHelper.stringTolong(request.getParameter("tz2")));
		    item.setTz3(FavoritesHelper.stringTolong(request.getParameter("tz3")));
		    item.setTz4(FavoritesHelper.stringTolong(request.getParameter("tz4")));
		    item.setTz5(FavoritesHelper.stringTolong(request.getParameter("tz5")));
		    item.setTz6(FavoritesHelper.stringTolong(request.getParameter("tz6")));
		    item.setTz7(FavoritesHelper.stringTolong(request.getParameter("tz7")));
		    item.setTz8(FavoritesHelper.stringTolong(request.getParameter("tz8")));
		    item.setTz9(FavoritesHelper.stringTolong(request.getParameter("tz9")));
		    item.setTz10(FavoritesHelper.stringTolong(request.getParameter("tz10")));
		    item.setTz11(FavoritesHelper.stringTolong(request.getParameter("tz11")));
		    item.setTz12(FavoritesHelper.stringTolong(request.getParameter("tz12")));
		    item.setGcjd(request.getParameter("gcjd"));
		    item.setDwmc(request.getParameter("dwmc"));
		    item.setZrr(request.getParameter("zrr"));
		    item.setGldw(request.getParameter("gldw"));
		    item.setZjppzc(FavoritesHelper.stringTolong(request.getParameter("zjppzc")));
		    item.setZjppdk(FavoritesHelper.stringTolong(request.getParameter("zjppdk")));
		    item.setZjppzf(FavoritesHelper.stringTolong(request.getParameter("zjppzf")));
		    item.setTzztxz(request.getParameter("ztxz"));
		    item.setSfkg(request.getParameter("sfkg"));
		    item.setKgyf(request.getParameter("kgyf"));
		    item.setCz(FavoritesHelper.stringTofloat(request.getParameter("cz")));
		    item.setSs(FavoritesHelper.stringTofloat(request.getParameter("ss")));
		    item.setJy(FavoritesHelper.stringToint(request.getParameter("jy")));
		    item.setZd(FavoritesHelper.stringTofloat(request.getParameter("zd")));
		    item.setNyd(FavoritesHelper.stringTofloat(request.getParameter("nyd")));
		    item.setNt(FavoritesHelper.stringTofloat(request.getParameter("nt")));
		    item.setLd(FavoritesHelper.stringTofloat(request.getParameter("ld")));
		    item.setSgyy(FavoritesHelper.stringTofloat(request.getParameter("sgyy")));
		    item.setHgyp(FavoritesHelper.stringTofloat(request.getParameter("hgyp")));
		    item.setYhdk(FavoritesHelper.stringTofloat(request.getParameter("yhdk")));
		    item.setSfscx(request.getParameter("sfscx"));
		    item.setSfzz(request.getParameter("sfzz"));
		    item.setSfss(request.getParameter("sfss"));
		    item.setSfzy(request.getParameter("sfzy"));
		    item.setSjslb(request.getParameter("sjslb"));
		    item.setZt("未上报");
		    item.setSbyh(request.getSession().getAttribute("yhm").toString());
		    ZdxmSbyhDao.add(item);
			// 提示保存成功
			response.setContentType("text/html;charset=UTF-8"); 
		    PrintWriter out = response.getWriter();
			out.print("<script>alert('保存成功！');location.href='ZdxmSbyhServlet?action=sbxmlr'</script>");
			out.flush();
			out.close();
			
		}else{
			
			response.setContentType("text/html;charset=UTF-8"); 
		    PrintWriter out = response.getWriter();
			out.print("<script>alert('此记录已存，请勿重复添加！');location.href='ZdxmSbyhServlet?action=sbxmlr'</script>");
			out.flush();
			out.close();
			
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
		String lb = FavoritesHelper.nullChangeString(request.getParameter("lb"));
		String nd = FavoritesHelper.nullChangeString(request.getParameter("nd"));
		String searchStr = FavoritesHelper.nullChangeString(request.getParameter("searchStr"));
		String sbyh = request.getSession().getAttribute("yhm").toString();
		Pager pager = ZdxmSbyhDao.getObjForPage(pageNo, pageSize, lb, nd, searchStr, sbyh);
	
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
	
		String lb = FavoritesHelper.nullChangeString(request.getParameter("lb"));
		String nd = FavoritesHelper.nullChangeString(request.getParameter("nd"));
		String searchStr = FavoritesHelper.nullChangeString(request.getParameter("searchStr"));
		String sbyh = request.getSession().getAttribute("yhm").toString();
		Pager pager = ZdxmSbyhDao.getObjForPage(pageNo, pageSize, lb, nd, searchStr, sbyh);
	
		request.setAttribute("pager", pager);
		request.setAttribute("xmlb", lb);
		request.setAttribute("nd", nd);
		request.setAttribute("searchStr", searchStr);
	
		request.getRequestDispatcher("gl.jsp").forward(request, response);
		
	}

}
