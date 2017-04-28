package com.trunko.project.serlvet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.project.dao.AreaDao;
import com.trunko.project.entity.ProArea;

public class AreaServlet extends HttpServlet {

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
		ProArea proArea= new ProArea();
		proArea.setLx(lx);
		proArea.setPid(Integer.valueOf(request.getParameter("pid")));
		proArea.setMc(request.getParameter("mc"));
		proArea.setPx(Integer.valueOf(request.getParameter("px")));
		
		AreaDao areaDao = new AreaDao();
		if(request.getParameter("id")!=null&&request.getParameter("id")!=""){
			proArea.setId(Integer.valueOf(request.getParameter("id")));
			if(areaDao.update(proArea)){
				getList(request,response);
			}
		}else{
			if(areaDao.insert(proArea)){
				getList(request,response);
			}
		}
    }
	private void Del(HttpServletRequest request,HttpServletResponse response) 
    throws ServletException, IOException {
		
		long id = Integer.valueOf(request.getParameter("id"));
		AreaDao areaDao = new AreaDao();
		String data="";
		if(areaDao.delete(id)){
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
		AreaDao areaDao = new AreaDao();
		List<ProArea> AreaList = areaDao.getList(lx);
		request.setAttribute("AreaList", AreaList);
		if(lx.equals("zd")){
			request.getRequestDispatcher("zdxm/sz_dq.jsp").forward(request, response);
		}else if(lx.equals("zda")){
			request.getRequestDispatcher("zdaxm/sz_dq.jsp").forward(request, response);
		}else if(lx.equals("zs")){
			request.getRequestDispatcher("zsxm/sz_dq.jsp").forward(request, response);
		}else if(lx.equals("cb")){
			request.getRequestDispatcher("cbxm/sz_dq.jsp").forward(request, response);
		}
    }
}
