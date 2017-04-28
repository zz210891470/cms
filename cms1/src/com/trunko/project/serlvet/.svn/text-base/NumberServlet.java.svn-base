package com.trunko.project.serlvet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.util.Escape;
import com.trunko.cms.util.FavoritesHelper;
import com.trunko.project.dao.NumberDao;
import com.trunko.project.entity.ProCbxm;
import com.trunko.project.entity.ProZdaxm;
import com.trunko.project.entity.ProZdxm;
import com.trunko.project.entity.ProZsxm;

public class NumberServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		if(act.equals("list")){
			getList(request,response);
		}else if(act.equals("update")){
			Update(request,response);
		}else if(act.equals("search")){
			search(request,response);
		}else if(act.equals("singlesave")){
			singleSave(request,response);
		}
	}
	
	private void singleSave(HttpServletRequest request,HttpServletResponse response) 
    throws ServletException, IOException {
		String lx=request.getParameter("lx");
		
		if(lx.equals("zd")){
			String data="";
			
			String sbyh = request.getParameter("sbyh") ;
			String id = request.getParameter("id");
			String bh = request.getParameter("bh");
			
			if(NumberDao.singleSaveZd(id, bh, sbyh)){
				data="ok";
			}
			
			
	        PrintWriter out = response.getWriter();
	        response.setContentType("text/html");  
			out.write(data);
			out.close();	
		}else if(lx.equals("zda")){
			String data="";
			
			String sbyh = request.getParameter("sbyh") ;
			String id = request.getParameter("id");
			String bh = request.getParameter("bh");
			
			if(NumberDao.singleSaveZda(id, bh, sbyh)){
				data="ok";
			}

	        PrintWriter out = response.getWriter();
	        response.setContentType("text/html");  
			out.write(data);
			out.close();	
		}else if(lx.equals("zs")){
			String data="";
			
			String id = request.getParameter("id");
			String bh = request.getParameter("bh");
			
			if(NumberDao.singleSaveZsxm(id, bh)){
				data="ok";
			}
			
			
	        PrintWriter out = response.getWriter();
	        response.setContentType("text/html");  
			out.write(data);
			out.close();	
			
		}else if(lx.equals("cb")){
			
			String data="";
			
			String id = request.getParameter("id");
			String bh = request.getParameter("bh");
			String sbyh = request.getParameter("sbyh");
			
			if(NumberDao.singleSaveCbxm(id, bh, sbyh)){
				data="ok";
			}
			
			
	        PrintWriter out = response.getWriter();
	        response.setContentType("text/html");  
			out.write(data);
			out.close();
		}
		
	}

	private void search(HttpServletRequest request,HttpServletResponse response) 
    throws ServletException, IOException {
		String lx=request.getParameter("lx");
			
		String searchStr = request.getParameter("searchstr");
		String nd = request.getParameter("nd");
		
		if(lx.equals("zd")){
			
		    List<ProZdxm> resultList = NumberDao.getZdList(searchStr, nd);
		    String userList = NumberDao.getAllUser();
		    request.setAttribute("resultList", resultList);
		    request.setAttribute("searchstr", searchStr);
		    request.setAttribute("nd", nd);
		    request.setAttribute("userList", userList);
		    System.out.println(userList);
			request.getRequestDispatcher("zdxm/sz_bh.jsp").forward(request, response);
		}else if(lx.equals("zda")){
			
		    List<ProZdaxm> resultList = NumberDao.getZdaList(searchStr, nd);
		    String userList = NumberDao.getAllUser();
		    request.setAttribute("resultList", resultList);
		    request.setAttribute("searchstr", searchStr);
		    request.setAttribute("nd", nd);
		    request.setAttribute("userList", userList);
			
			request.getRequestDispatcher("zdaxm/sz_bh.jsp").forward(request, response);
		}else if(lx.equals("zs")){
		    List<ProZsxm> resultList = NumberDao.getZsxmList(searchStr, nd);

		    request.setAttribute("resultList", resultList);
		    request.setAttribute("searchstr", searchStr);
		    request.setAttribute("nd", nd);
		
			request.getRequestDispatcher("zsxm/sz_bh.jsp").forward(request, response);
		}else if(lx.equals("cb")){
			
		    List<ProCbxm> resultList = NumberDao.getCbxmList(searchStr, nd);
		    String userList = NumberDao.getAllUser();
		    request.setAttribute("resultList", resultList);
		    request.setAttribute("searchstr", searchStr);
		    request.setAttribute("nd", nd);
		    request.setAttribute("userList", userList);
			request.getRequestDispatcher("cbxm/sz_bh.jsp").forward(request, response);
		}
	}
	
	
	private void Update(HttpServletRequest request,HttpServletResponse response) 
    throws ServletException, IOException {
		String lx=request.getParameter("lx");
		String[] idList = request.getParameterValues("idlist");
		String[] pronumList = request.getParameterValues("pronum");
		boolean status = false;
		if(lx.equals("zd")){
			String[] sbyhList = request.getParameterValues("sbyh");
		    status= NumberDao.updateZdItemList(idList, pronumList ,sbyhList);
		    
		}else if(lx.equals("zda")){
			String[] sbyhList = request.getParameterValues("sbyh");
		    status= NumberDao.updateZdaItemList(idList, pronumList ,sbyhList);
		    
		}else if(lx.equals("zs")){
		    status= NumberDao.updateZsxmItemList(idList, pronumList );
		    
		}else if(lx.equals("cb")){
			String[] sbyhList = request.getParameterValues("sbyh");
		    status= NumberDao.updateCbxmItemList(idList, pronumList,sbyhList );
		}
		request.setAttribute("status", status);
	    search(request,response);
	}
	
	private void getList(HttpServletRequest request,HttpServletResponse response) 
    throws ServletException, IOException {
		
		String lx=request.getParameter("lx");
		String nd = FavoritesHelper.nullChangeString(request.getParameter("nd"));
		String searchStr = FavoritesHelper.nullChangeString(request.getParameter("searchStr"));
		List resultList = null;
		String url = "";
	    if (!FavoritesHelper.isNotNull(nd)) {
	    	Calendar calendar = Calendar.getInstance();
			nd = calendar.get(Calendar.YEAR)+"";
	    }
		if(lx.equals("zd")){
			resultList = NumberDao.getZdList(searchStr, nd);
			url = "zdxm/sz_bh.jsp";
		}else if(lx.equals("zda")){
			resultList = NumberDao.getZdaList(searchStr, nd);
			url = "zdaxm/sz_bh.jsp";
		}else if(lx.equals("zs")){
			resultList = NumberDao.getZsxmList(searchStr, nd);
			url = "zsxm/sz_bh.jsp";
		}else if(lx.equals("cb")){
			resultList = NumberDao.getCbxmList(searchStr, nd);
			url = "cbxm/sz_bh.jsp";
		}
		 String userList = NumberDao.getAllUser();
		 request.setAttribute("resultList", resultList);
		 request.setAttribute("searchstr", searchStr);
		 request.setAttribute("nd", nd);
		 request.setAttribute("userList", userList);
		 request.getRequestDispatcher(url).forward(request, response);
    }
	
	
	
	
}
