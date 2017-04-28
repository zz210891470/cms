package com.trunko.cms.servlet.sysconfig;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.dao.sysconfig.UrlManageDao;
import com.trunko.cms.entity.WebUrl;


/**
 * 友情链接控制类
 * @author jianhuang
 *
 */
public class UrlManageServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act=request.getParameter("act");
		
		if(act.equals("list")){
			getList(request,response);
		}else if(act.equals("save")){
			update(request,response);
		}else if(act.equals("delete")){
			deleteItems(request,response);
		}
		
	}
	
	private void add(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		
		WebUrl webUrl=new WebUrl();
		webUrl.setMc(request.getParameter("mc"));
		webUrl.setUrl(request.getParameter("url"));
		webUrl.setPxh(request.getParameter("pxh"));
		
		UrlManageDao urlManageDao=new UrlManageDao();
		urlManageDao.add(webUrl);
		
		getList(request, response);

	}
	
	private void update(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebUrl webUrl=new WebUrl();
		if(request.getParameter("id")!=""){
			webUrl.setId(Long.valueOf(request.getParameter("id")));
		}
		webUrl.setMc(request.getParameter("mc"));
		webUrl.setUrl(request.getParameter("url"));
		webUrl.setPxh(request.getParameter("pxh"));
		webUrl.setLb(request.getParameter("lb"));
		
		UrlManageDao urlManageDao=new UrlManageDao();
		if(request.getParameter("id")!=""){
			urlManageDao.update(webUrl);
		}else{
			urlManageDao.add(webUrl);
		}
		getList(request, response);

	}
	
    /**
     * 批量删除链接
     */
	private void deleteItems(HttpServletRequest request,HttpServletResponse response)
	    throws ServletException, IOException {
		if(request.getParameterValues("itemList")!=null){
			String[]  itemList=request.getParameterValues("itemList");
			String lb =request.getParameter("lb");
			
			UrlManageDao urlManageDao=new UrlManageDao();
			if(urlManageDao.delItemList(itemList)==true){
				response.sendRedirect("UrlManageServlet?act=list&lb="+lb);
			}
		}else{
			String lb =request.getParameter("lb");
			response.sendRedirect("UrlManageServlet?act=list&lb="+lb);
		}
	}


	/**
	 * 得到友情链接列表
	 */
	private void getList(HttpServletRequest request,HttpServletResponse response) 
        throws ServletException, IOException {
		
		String lb=request.getParameter("lb");
		UrlManageDao urlManageDao=new UrlManageDao();
		List<WebUrl> UrlList=urlManageDao.getItemList(lb);
		request.setAttribute("urllist", UrlList);
		request.setAttribute("lb", lb);
		request.getRequestDispatcher("urlmanage.jsp").forward(request, response);
	}
	
	
}
