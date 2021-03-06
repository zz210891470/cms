package com.trunko.cms.servlet.infoopen;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.dao.infoopen.InfoRegDao;
import com.trunko.cms.entity.WebInfoReg;
import com.trunko.cms.util.Pager;

public class InfoRegServlet extends HttpServlet {

	private int pageSize = 10;
	private int pageNo = 1;
	
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
		   }else if(act.equals("updatepage")){
			   goUpdatePage(request,response);
		   }else if(act.equals("update")){
			   update(request,response);
		   }
	}

	private void update(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebInfoReg webInfoReg=new WebInfoReg();
		
		if(request.getParameter("id").equals("")==false){
			try{
				Long.valueOf(request.getParameter("id"));
			}catch(Exception e){
				return;
			}
			webInfoReg.setId(Long.valueOf(request.getParameter("id")));
		}
		webInfoReg.setTopic(request.getParameter("topic"));
		webInfoReg.setContent(request.getParameter("content"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date createDate;
		try {
			createDate = sdf.parse(request.getParameter("time").toString());
			java.sql.Date d = new java.sql.Date(createDate.getTime());
			webInfoReg.setTime(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		InfoRegDao infoRegDao=new InfoRegDao();
		if(request.getParameter("id").equals("")==true){
			infoRegDao.add(webInfoReg);
		}else{
			infoRegDao.update(webInfoReg);
		}
		getList(request, response);
	}
	
	private void goUpdatePage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		try{
			Long.valueOf(request.getParameter("id"));
		}catch(Exception e){
			return;
		}
		long id=Long.valueOf(request.getParameter("id"));
		
		InfoRegDao infoRegDao=new InfoRegDao();
		WebInfoReg webInfoReg=infoRegDao.getById(id);
		request.setAttribute("item", webInfoReg);
		request.getRequestDispatcher("reg_edit.jsp").forward(request, response);
	}
	
	private void goAddPage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		
		request.getRequestDispatcher("reg_edit.jsp").forward(request, response);
	}

	private void deleteItems(HttpServletRequest request,HttpServletResponse response)
	    throws ServletException, IOException {
		 String[]  itemList=request.getParameterValues("itemList");
		 pageNo=Integer.valueOf(request.getParameter("pageNo"));
		 pageSize=Integer.valueOf(request.getParameter("pageSize"));
		 
		 InfoRegDao infoRegDao=new InfoRegDao();
			
		 if(infoRegDao.delItemList(itemList)==true){
			 response.sendRedirect("InfoRegServlet?act=list&pageNo="+pageNo+"&pageSize"+pageSize);
		 }else{
			 //��λ������ҳ��
		 }
	}

	private void getList(HttpServletRequest request,HttpServletResponse response) 
        throws ServletException, IOException {
		int pageSize = 10;
		int pageNo = 1;
		if(!(request.getParameter("pageNo")==null||request.getParameter("pageNo").equals(""))){
			pageNo=Integer.valueOf(request.getParameter("pageNo"));
		}
		if(!(request.getParameter("pageSize")==null||request.getParameter("pageSize").equals(""))){
			pageSize=Integer.valueOf(request.getParameter("pageSize"));
		}
		InfoRegDao infoRegDao=new InfoRegDao();
		Pager pager=infoRegDao.getItemForPage(pageNo, pageSize);

		request.setAttribute("pager", pager);
		request.getRequestDispatcher("reglist.jsp").forward(request, response);
		
	}

}
