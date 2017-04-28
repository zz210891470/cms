package com.trunko.project.serlvet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.project.dao.IndustryDao;
import com.trunko.project.entity.ProIndustry;

public class IndustryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String act = request.getParameter("act");
		if(act.equals("list")){
			getList(request,response);
		}else if(act.equals("add")){
			Add(request,response);
		}else if(act.equals("del")){
			Del(request,response);
		}
	}
	
	private void Add(HttpServletRequest request,HttpServletResponse response) 
    throws ServletException, IOException {
		String lx=request.getParameter("lx");
		ProIndustry proIndustry= new ProIndustry();
		proIndustry.setLx(lx);
		proIndustry.setPid(Integer.valueOf(request.getParameter("pid")));
		proIndustry.setMc(request.getParameter("mc"));
		proIndustry.setPx(Integer.valueOf(request.getParameter("px")));
		
		IndustryDao industryDao = new IndustryDao();
		if(request.getParameter("id")!=null&&request.getParameter("id")!=""){
			proIndustry.setId(Integer.valueOf(request.getParameter("id")));
			if(industryDao.update(proIndustry)){
				getList(request,response);
			}
		}else{
			if(industryDao.insert(proIndustry)){
				getList(request,response);
			}
		}
    }
	private void Del(HttpServletRequest request,HttpServletResponse response) 
    throws ServletException, IOException {
		
		long id = Integer.valueOf(request.getParameter("id"));
		IndustryDao industryDao = new IndustryDao();
		String data="";
		if(industryDao.delete(id)){
			data="[\"SUCCESS\"]";
		}
		PrintWriter out = response.getWriter();
        response.setContentType("application/json; charset=utf-8");  
        response.setHeader("pragma", "no-cache");  
        response.setHeader("cache-control", "no-cache");  
		out.write(data);
		out.close();
    }
	
	private void getList(HttpServletRequest request,HttpServletResponse response) 
    throws ServletException, IOException {
		String lx=request.getParameter("lx");
		IndustryDao industryDao = new IndustryDao();
		List<ProIndustry> IndustryList = industryDao.getList(lx);
		request.setAttribute("IndustryList", IndustryList);
		if(lx.equals("zd")){
			request.getRequestDispatcher("zdxm/sz_fl.jsp").forward(request, response);
		}else if(lx.equals("zda")){
			request.getRequestDispatcher("zdaxm/sz_fl.jsp").forward(request, response);
		}else if(lx.equals("zs")){
			request.getRequestDispatcher("zsxm/sz_fl.jsp").forward(request, response);
		}else if(lx.equals("cb")){
			request.getRequestDispatcher("cbxm/sz_fl.jsp").forward(request, response);
		}
    }
}
