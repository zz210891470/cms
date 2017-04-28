package com.trunko.cms.servlet.people;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.dao.location.LmphDao;
import com.trunko.cms.dao.people.PeopleMailDao;
import com.trunko.cms.entity.WebLeaderMail;
import com.trunko.cms.util.Pager;

public class PeopleMailServlet extends HttpServlet {


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
	   }else if(act.equals("detail")){
		   goDetailPage(request,response);
	   }else if(act.equals("replypage")){
		   goReplyPage(request,response);
	   }else if(act.equals("reply")){
		   reply(request,response);
	   }
	}
	
	private void reply(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		Long id=Long.valueOf(request.getParameter("id"));
		String hfnr=request.getParameter("hfnr");
		PeopleMailDao peopleMailDao=new PeopleMailDao();
		
		if(peopleMailDao.reply(hfnr, id)){
			response.setContentType("text/html;charset=UTF-8"); 
		    PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>window.parent.hideEditFrame();</script>"); 
			out.flush();
		}

	}
	
	
	private void goReplyPage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		
		Long id=Long.valueOf(request.getParameter("id"));
		PeopleMailDao peopleMailDao=new PeopleMailDao();
		WebLeaderMail webLeaderMail=peopleMailDao.getById(id);
		
		request.setAttribute("item", webLeaderMail);
		request.getRequestDispatcher("mail_reply.jsp").forward(request, response);

	}
	
	private void goDetailPage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		Long id=Long.valueOf(request.getParameter("id"));
		PeopleMailDao peopleMailDao=new PeopleMailDao();
		WebLeaderMail webLeaderMail=peopleMailDao.getById(id);
		
		request.setAttribute("item", webLeaderMail);
		request.getRequestDispatcher("mail_read.jsp").forward(request, response);

	}
	

	


	private void deleteItems(HttpServletRequest request,HttpServletResponse response)
	    throws ServletException, IOException {
		 String[]  itemList=request.getParameterValues("itemList");

		 
		 PeopleMailDao peopleMailDao=new PeopleMailDao();
			
		 if(peopleMailDao.delItemList(itemList)==true){
		     postList(request, response);
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
		PeopleMailDao peopleMailDao=new PeopleMailDao();
		Pager pager=peopleMailDao.getItemForPage(pageNo, pageSize);

		request.setAttribute("pager", pager);
		request.getRequestDispatcher("mail.jsp").forward(request, response);
		
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
		//TODO 通过为页面排序接收条件  按照条件排序
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
	
		PeopleMailDao peopleMailDao=new PeopleMailDao();
		Pager pager=peopleMailDao.getItemForPage(pageNo, pageSize);
	
		request.setAttribute("pager", pager);
		//TODO 转发到相应页面 更改页面位置
		request.getRequestDispatcher("mail.jsp").forward(request, response);
		
	}
	
}
