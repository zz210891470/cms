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

import com.trunko.cms.dao.infoopen.InfoOpenDao;
import com.trunko.cms.entity.WebInfoOpen;
import com.trunko.cms.util.Pager;

public class InfoOpenServlet extends HttpServlet {


	
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
		WebInfoOpen webInfoOpen=new WebInfoOpen();
		
		if(request.getParameter("id").equals("")==false){
			try{
				Long.valueOf(request.getParameter("id"));
			}catch(Exception e){
				return;
			}
			webInfoOpen.setId(Long.valueOf(request.getParameter("id")));
		}
		webInfoOpen.setSyh(request.getParameter("syh"));
		webInfoOpen.setFl(request.getParameter("fl"));
		webInfoOpen.setFbjg(request.getParameter("fbjg"));
		webInfoOpen.setWh(request.getParameter("wh"));
		webInfoOpen.setBt(request.getParameter("bt"));
		webInfoOpen.setZtc(request.getParameter("ztc"));
		webInfoOpen.setNr(request.getParameter("nr"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date createDate;
		try {
			createDate = sdf.parse(request.getParameter("fwrq").toString());
			java.sql.Date d = new java.sql.Date(createDate.getTime());
			webInfoOpen.setFwrq(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		InfoOpenDao infoOpenDao=new InfoOpenDao();
		if(request.getParameter("id").equals("")==true){
			infoOpenDao.add(webInfoOpen);
		}else{
			infoOpenDao.update(webInfoOpen);
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
		InfoOpenDao infoOpenDao=new InfoOpenDao();
		WebInfoOpen webInfoOpen=infoOpenDao.getById(id);
		request.setAttribute("item", webInfoOpen);
		request.getRequestDispatcher("info_edit.jsp").forward(request, response);
	}
	
	private void goAddPage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		
		request.getRequestDispatcher("info_edit.jsp").forward(request, response);
	}

	private void deleteItems(HttpServletRequest request,HttpServletResponse response)
	    throws ServletException, IOException {
		 int pageSize = 10;
		 int pageNo = 1;
		 String[]  itemList=request.getParameterValues("itemList");
		 pageNo=Integer.valueOf(request.getParameter("pageNo"));
		 pageSize=Integer.valueOf(request.getParameter("pageSize"));
		 
		 InfoOpenDao infoOpenDao=new InfoOpenDao();
			
		 if(infoOpenDao.delItemList(itemList)==true){
			 response.sendRedirect("InfoOpenServlet?act=list&pageNo="+pageNo+"&pageSize"+pageSize);
		 }else{
			 //定位至错误页面
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
		InfoOpenDao infoOpenDao=new InfoOpenDao();
		Pager pager=infoOpenDao.getItemForPage(pageNo, pageSize);

		request.setAttribute("pager", pager);
		request.getRequestDispatcher("infolist.jsp").forward(request, response);
		
	}

}