package com.trunko.cms.servlet.people;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.dao.location.LmphDao;
import com.trunko.cms.dao.people.PeopleQuestionDao;
import com.trunko.cms.entity.WebQuestion;
import com.trunko.cms.util.Pager;


/**
 * 常见问题控制器
 * @author gjz
 *
 */
public class PeopleQuestionServlet extends HttpServlet {



	
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
		WebQuestion webQuestion=new WebQuestion();
		webQuestion.setId(Long.valueOf(request.getParameter("id")));
		webQuestion.setQuestion(request.getParameter("question"));
		webQuestion.setAnswer(request.getParameter("answer"));
	//	webQuestion.setTime(request.getParameter("time"));
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("time"));
			webQuestion.setTime(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		webQuestion.setAuthor(request.getParameter("author"));
		webQuestion.setUrl(request.getParameter("url"));
		
		PeopleQuestionDao peopleQuestionDao=new PeopleQuestionDao();
		peopleQuestionDao.update(webQuestion);
		
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideEditFrame();</script>"); 
		out.flush();

	}
	
	private void goUpdatePage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		long id=Long.valueOf(request.getParameter("id"));
		
		PeopleQuestionDao peopleQuestionDao=new PeopleQuestionDao();
		WebQuestion webQuestion=peopleQuestionDao.getById(id);
		request.setAttribute("item", webQuestion);
		request.getRequestDispatcher("question_edit.jsp").forward(request, response);
	}

	
	private void add(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebQuestion webQuestion=new WebQuestion();

		webQuestion.setQuestion(request.getParameter("question"));
		webQuestion.setAnswer(request.getParameter("answer"));
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("time"));
			webQuestion.setTime(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		webQuestion.setAuthor(request.getParameter("author"));
	//	webQuestion.setUrl(request.getParameter("url"));
		PeopleQuestionDao peopleQuestionDao=new PeopleQuestionDao();
		peopleQuestionDao.add(webQuestion);
		
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideAddFrame();</script>"); 
		out.flush();

	}
	
	
	private void goAddPage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		
		request.getRequestDispatcher("question_add.jsp").forward(request, response);
	}

	private void deleteItems(HttpServletRequest request,HttpServletResponse response)
	    throws ServletException, IOException {
		 String[]  itemList=request.getParameterValues("itemList");

		 
		 PeopleQuestionDao peopleQuestionDao=new PeopleQuestionDao();
			
		 if(peopleQuestionDao.delItemList(itemList)==true){
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
		PeopleQuestionDao peopleQuestionDao=new PeopleQuestionDao();
		Pager pager=peopleQuestionDao.getItemForPage(pageNo, pageSize);

		request.setAttribute("pager", pager);
		request.getRequestDispatcher("question_list.jsp").forward(request, response);
		
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
	
		PeopleQuestionDao peopleQuestionDao=new PeopleQuestionDao();
		Pager pager=peopleQuestionDao.getItemForPage(pageNo, pageSize);
	
		request.setAttribute("pager", pager);
		//TODO 转发到相应页面 更改页面位置
		request.getRequestDispatcher("question_list.jsp").forward(request, response);
		
	}
}
