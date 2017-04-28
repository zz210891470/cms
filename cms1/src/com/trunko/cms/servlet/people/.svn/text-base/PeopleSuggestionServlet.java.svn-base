package com.trunko.cms.servlet.people;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.dao.location.LmphDao;
import com.trunko.cms.dao.people.PeopleSuggestionDao;
import com.trunko.cms.entity.WebSuggestion;
import com.trunko.cms.util.Pager;


/**
 * 民意征集控制器
 * @author gjz
 *
 */
public class PeopleSuggestionServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
         doPost(request,response);
    }


	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	   String act=request.getParameter("act");
	   
	   LmphDao lmphDao = new LmphDao();
	   lmphDao.LmphUpdate("公众参与");
	   
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
		WebSuggestion webSuggestion=new WebSuggestion();
		webSuggestion.setId(Long.valueOf(request.getParameter("id")));
		webSuggestion.setXm(request.getParameter("xm"));
		webSuggestion.setLxfs(request.getParameter("lxfs"));
		webSuggestion.setBt(request.getParameter("bt"));
		webSuggestion.setNr(request.getParameter("nr"));

		
		PeopleSuggestionDao peopleSuggestionDao=new PeopleSuggestionDao();
		peopleSuggestionDao.update(webSuggestion);
		
		getList(request, response);

	}
	
	private void goUpdatePage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		long id=Long.valueOf(request.getParameter("id"));
		
		PeopleSuggestionDao peopleSuggestionDao=new PeopleSuggestionDao();
		WebSuggestion webSuggestion=peopleSuggestionDao.getById(id);
		request.setAttribute("item", webSuggestion);
		request.getRequestDispatcher("updatesuggestion.jsp").forward(request, response);
	}

	
	private void add(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebSuggestion webSuggestion=new WebSuggestion();
		webSuggestion.setXm(request.getParameter("xm"));
		webSuggestion.setLxfs(request.getParameter("lxfs"));
		webSuggestion.setBt(request.getParameter("bt"));
		webSuggestion.setNr(request.getParameter("nr"));
		
		PeopleSuggestionDao peopleSuggestionDao=new PeopleSuggestionDao();
		peopleSuggestionDao.add(webSuggestion);
		
		getList(request, response);

	}
	
	
	private void goAddPage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		
		request.getRequestDispatcher("addsuggestion.html").forward(request, response);
	}

	private void deleteItems(HttpServletRequest request,HttpServletResponse response)
	    throws ServletException, IOException {
		 String[]  itemList=request.getParameterValues("itemList");

		 
		 PeopleSuggestionDao peopleSuggestionDao=new PeopleSuggestionDao();
			
		 if(peopleSuggestionDao.delItemList(itemList)==true){
			 
			 getList(request,response);
		 }else{
			 //定位至错误页面
		 }
		 
		
	}


	private void getList(HttpServletRequest request,HttpServletResponse response) 
        throws ServletException, IOException {
		Integer  pageNo   = 1;
		Integer  pageSize = 10;
		
		if(!(request.getParameter("pageNo")==null||request.getParameter("pageNo").equals(""))){
			pageNo=Integer.valueOf(request.getParameter("pageNo"));
		}
		if(!(request.getParameter("pageSize")==null||request.getParameter("pageSize").equals(""))){
			pageSize=Integer.valueOf(request.getParameter("pageSize"));
		}
		PeopleSuggestionDao peopleSuggestionDao=new PeopleSuggestionDao();
		Pager pager=peopleSuggestionDao.getItemForPage(pageNo, pageSize);

		request.setAttribute("pager", pager);
		request.getRequestDispatcher("suggestion_list.jsp").forward(request, response);
		
	}


}
