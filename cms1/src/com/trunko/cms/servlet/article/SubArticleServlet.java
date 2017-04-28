package com.trunko.cms.servlet.article;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.trunko.cms.common.Constants;
import com.trunko.cms.dao.article.SubArticleDao;
import com.trunko.cms.dao.sysconfig.SpecialColumnDao;
import com.trunko.cms.entity.WebSubColumn;
import com.trunko.cms.entity.WebSubInfo;
import com.trunko.cms.util.Pager;

public class SubArticleServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
	   doPost(request, response);
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			 String act = request.getParameter("act");
			  if("list".equals(act)){
				 getList(request, response);
			  }else if(act.equals("deleteItems")){
				  deleteItems(request,response);
			  }else if(act.equals("addpage")){
				  goAddPage(request,response);
			  }else if(act.equals("add")){
				  add(request,response);
			  }else if(act.equals("addcontent")){
				  addContent(request,response);
			  }else if(act.equals("updatepage")){
				   goUpdatePage(request,response);
			  }else if(act.equals("update")){
				   update(request,response);
			  }else if(act.equals("updatecontent")){
				   updateContent(request,response);
			  }else if(act.equals("hasArticle")){
				    hasArticle(request,response);
			  }else if(act.equals("recyclepage")){
				  showRecyclePage(request,response);
			  }else if(act.equals("RdeleteItems")){
				  RdeleteItems(request,response);
			  }else if(act.equals("resume")){
				  resume(request,response);
			  }else if(act.equals("updateandreleasecontent")){
				  //内容模板修改并发布
				  updateandreleasecontent(request,response);
			  }else if(act.equals("saveandreleasecontent")){
				  saveandreleasecontent(request,response);
			  }else if(act.equals("preview")){
				  preview(request,response);
			  }else if(act.equals("updateandrelease")){
				  //列表页修改 并发布
				  updateandrelease(request,response);
			  }else if(act.equals("updatecaogao")){
				  //列表页修改 并发布
				  updatecaogao(request,response);
			  }else if(act.equals("saveandrelease")){
				  saveandrelease(request,response);
			  }else if(act.equals("saveandcontinue")){
				  saveandcontinue(request,response);
			  }else if(act.equals("listrelease")){
				  listrelease(request,response);
			  }
	}
	
	private void listrelease(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
	    String  id=request.getParameter("id");
		int pageNo = 1;
		int pageSize = 10;
		
		if(!(request.getParameter("pageNo")==null||request.getParameter("pageNo").equals(""))){
			pageNo=Integer.valueOf(request.getParameter("pageNo"));
		}
		if(!(request.getParameter("pageSize")==null||request.getParameter("pageSize").equals(""))){
			pageSize=Integer.valueOf(request.getParameter("pageSize"));
		}
		 Long pid=Long.valueOf(request.getParameter("pid"));
		
		 String search=request.getParameter("search");
		 SubArticleDao articleDao = new SubArticleDao();
	
		 if(articleDao.listrelease(id)==true){
		
			 getList(request, response);
		//	 response.sendRedirect("ArticleServlet?act=list&pid="+pid+"&pageNo="+pageNo+"&pageSize"+pageSize+"&search="+search);
		 }else{
			 //定位至错误页面
		 }
	}
	
	
	
	private void saveandcontinue(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebSubInfo webInfomation=new WebSubInfo();
		webInfomation.setBt(request.getParameter("bt"));
		webInfomation.setNr(request.getParameter("nr"));
		webInfomation.setZz(request.getParameter("zz"));
		webInfomation.setLjwz(request.getParameter("ljwz"));
		Long pid=Long.valueOf(request.getParameter("pid"));
		webInfomation.setLmid(pid);
		webInfomation.setLy(request.getParameter("ly"));
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("rq"));
			webInfomation.setRq(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		webInfomation.setFbr(request.getSession().getAttribute("xm").toString());
		webInfomation.setZt("草稿");
		SubArticleDao articleDao = new SubArticleDao();
		articleDao.add(webInfomation);
		
	 	 response.setContentType("text/html;charset=UTF-8"); 
    	 PrintWriter out = response.getWriter();
 		out.println("<script type='text/javascript'>alert('保存成功！');document.location.href='SubArticleServlet?act=addpage&pid="+pid+"';</script>"); 
 		out.flush();

	}
	
	
	private void saveandrelease(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebSubInfo webInfomation=new WebSubInfo();
		webInfomation.setBt(request.getParameter("bt"));
		webInfomation.setNr(request.getParameter("nr"));
		webInfomation.setZz(request.getParameter("zz"));
		webInfomation.setLjwz(request.getParameter("ljwz"));
		Long pid=Long.valueOf(request.getParameter("pid"));
		webInfomation.setLmid(pid);
		webInfomation.setLy(request.getParameter("ly"));
		webInfomation.setFbr(request.getSession().getAttribute("xm").toString());
		webInfomation.setZt("已发布");
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("rq"));
			webInfomation.setRq(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SubArticleDao articleDao = new SubArticleDao();
		articleDao.add(webInfomation);
		
   	    response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>alert('保存成功!');window.parent.hideAddFrame();</script>"); 
		out.flush();

	}
	
	private void updateandrelease(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebSubInfo webSubInfo=new WebSubInfo();
		webSubInfo.setId(Long.valueOf(request.getParameter("id")));
		webSubInfo.setBt(request.getParameter("bt"));
		webSubInfo.setNr(request.getParameter("nr"));
		webSubInfo.setZz(request.getParameter("zz"));
		webSubInfo.setLjwz(request.getParameter("ljwz"));
		webSubInfo.setLy(request.getParameter("ly"));
		webSubInfo.setFbr(request.getSession().getAttribute("xm").toString());
		webSubInfo.setZt("已发布");
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("rq"));
			webSubInfo.setRq(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SubArticleDao articleDao = new SubArticleDao();
		articleDao.updateZt(webSubInfo);
		
		
   	    response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>alert('保存成功!');window.parent.hideEditFrame();</script>"); 
		out.flush();

	}
	
	
	
	private void updatecaogao(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebSubInfo webSubInfo=new WebSubInfo();
		webSubInfo.setId(Long.valueOf(request.getParameter("id")));
		webSubInfo.setBt(request.getParameter("bt"));
		webSubInfo.setNr(request.getParameter("nr"));
		webSubInfo.setZz(request.getParameter("zz"));
		webSubInfo.setLjwz(request.getParameter("ljwz"));
		webSubInfo.setLy(request.getParameter("ly"));
		webSubInfo.setFbr(request.getSession().getAttribute("xm").toString());
		webSubInfo.setZt("草稿");
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("rq"));
			webSubInfo.setRq(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SubArticleDao articleDao = new SubArticleDao();
		articleDao.updateZt(webSubInfo);
		
		
   	    response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>alert('保存成功!');window.parent.hideEditFrame();</script>"); 
		out.flush();

	}
	
	private void preview(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		
		
		WebSubInfo webInfomation=new WebSubInfo();

		webInfomation.setBt(request.getParameter("bt"));
		webInfomation.setNr(request.getParameter("nr"));
		webInfomation.setZz(request.getParameter("zz"));
		webInfomation.setLy(request.getParameter("ly"));

//		webInfomation.setLstp(request.getParameter("lstp"));

		request.setAttribute("item", webInfomation);
		request.getRequestDispatcher("preview.jsp").forward(request, response);
		
	}
	
	private void saveandreleasecontent(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebSubInfo webInfomation=new WebSubInfo();
		webInfomation.setBt(request.getParameter("bt"));
		webInfomation.setNr(request.getParameter("nr"));
		webInfomation.setZz(request.getParameter("zz"));
		webInfomation.setLjwz(request.getParameter("ljwz"));
		Long pid=Long.valueOf(request.getParameter("pid"));
		webInfomation.setLmid(pid);
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("rq"));
			webInfomation.setRq(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		webInfomation.setFbr(request.getSession().getAttribute("xm").toString());
		webInfomation.setZt("已发布");
		SubArticleDao articleDao = new SubArticleDao();
		articleDao.add(webInfomation);
		
        getList(request, response);

	}
	
	private void updateandreleasecontent(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebSubInfo webSubInfo=new WebSubInfo();
		webSubInfo.setId(Long.valueOf(request.getParameter("id")));
		webSubInfo.setBt(request.getParameter("bt"));
		webSubInfo.setNr(request.getParameter("nr"));
		webSubInfo.setZz(request.getParameter("zz"));
		webSubInfo.setLjwz(request.getParameter("ljwz"));
        
		webSubInfo.setFbr(request.getSession().getAttribute("MM").toString());
		webSubInfo.setZt("已发布");
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("rq"));
			webSubInfo.setRq(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SubArticleDao articleDao = new SubArticleDao();
		articleDao.updateZt(webSubInfo);
		
        getList(request, response);

	}
	
	private void RdeleteItems(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
	 String[]  itemList=request.getParameterValues("itemList");
		int pageNo = 1;
		int pageSize = 10;
		
		if(!(request.getParameter("pageNo")==null||request.getParameter("pageNo").equals(""))){
			pageNo=Integer.valueOf(request.getParameter("pageNo"));
		}
		if(!(request.getParameter("pageSize")==null||request.getParameter("pageSize").equals(""))){
			pageSize=Integer.valueOf(request.getParameter("pageSize"));
		}
	
	// String search=request.getParameter("search");
	 SubArticleDao articleDao = new SubArticleDao();
	 if(articleDao.delItemListR(itemList)==true){
		 response.sendRedirect("SubArticleServlet?act=recyclepage&pageNo="+pageNo+"&pageSize"+pageSize);
	 }else{
		 //定位至错误页面
	 }
	}
	
	private void resume(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
	 String[]  itemList=request.getParameterValues("itemList");
		int pageNo = 1;
		int pageSize = 10;
		
		if(!(request.getParameter("pageNo")==null||request.getParameter("pageNo").equals(""))){
			pageNo=Integer.valueOf(request.getParameter("pageNo"));
		}
		if(!(request.getParameter("pageSize")==null||request.getParameter("pageSize").equals(""))){
			pageSize=Integer.valueOf(request.getParameter("pageSize"));
		}
	
	// String search=request.getParameter("search");
	 SubArticleDao articleDao = new SubArticleDao();
	 if(articleDao.resume(itemList)==true){
		 response.sendRedirect("SubArticleServlet?act=recyclepage&pageNo="+pageNo+"&pageSize"+pageSize);
	 }else{
		 //定位至错误页面
	 }
	}
	
	private void showRecyclePage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {

		int pageNo = 1;
		int pageSize = 10;
		
		if(!(request.getParameter("pageNo")==null||request.getParameter("pageNo").equals(""))){
			pageNo=Integer.valueOf(request.getParameter("pageNo"));
		}
		if(!(request.getParameter("pageSize")==null||request.getParameter("pageSize").equals(""))){
			pageSize=Integer.valueOf(request.getParameter("pageSize"));
		}
		String pid=request.getParameter("pid");
		String searchStr=request.getParameter("search");
		SubArticleDao articleDao = new SubArticleDao();
		Pager pager= articleDao.getRecycleForPage(pageNo, pageSize, searchStr,pid);
		
		request.setAttribute("search", searchStr);
		request.setAttribute("pager", pager);
		request.setAttribute("pid", pid);
		request.getRequestDispatcher("subrecycle.jsp").forward(request, response);
	}
	
	
	private void hasArticle(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		String data="[\"FAIL\"]";
		Long id=Long.valueOf(request.getParameter("id"));
		SubArticleDao articleDao=new SubArticleDao();
		if(articleDao.hasArticle(id)){
			
			data="[\"SUCCESS\"]";
		}
		
        PrintWriter out = response.getWriter();
		
        response.setContentType("application/json; charset=utf-8");  
        response.setHeader("pragma", "no-cache");  
        response.setHeader("cache-control", "no-cache");  
		out.write(data);
		out.close();
	}
	
	private void updateContent(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebSubInfo webSubInfo=new WebSubInfo();
		webSubInfo.setId(Long.valueOf(request.getParameter("id")));
		webSubInfo.setBt(request.getParameter("bt"));
		webSubInfo.setNr(request.getParameter("nr"));
		webSubInfo.setZz(request.getParameter("zz"));
		webSubInfo.setLjwz(request.getParameter("ljwz"));
        
		webSubInfo.setFbr(request.getSession().getAttribute("xm").toString());
		webSubInfo.setZt("草稿");
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("rq"));
			webSubInfo.setRq(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SubArticleDao articleDao = new SubArticleDao();
		articleDao.updateZt(webSubInfo);
		
        getList(request, response);

	}
	
	private void update(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebSubInfo webSubInfo=new WebSubInfo();
		webSubInfo.setId(Long.valueOf(request.getParameter("id")));
		webSubInfo.setBt(request.getParameter("bt"));
		webSubInfo.setNr(request.getParameter("nr"));
		webSubInfo.setZz(request.getParameter("zz"));
		webSubInfo.setLjwz(request.getParameter("ljwz"));
		webSubInfo.setFbr(request.getSession().getAttribute("xm").toString());

		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("rq"));
			webSubInfo.setRq(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SubArticleDao articleDao = new SubArticleDao();
		articleDao.update(webSubInfo);
		
		
   	    response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideEditFrame();</script>"); 
		out.flush();

	}
	
	private void goUpdatePage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		long id=Long.valueOf(request.getParameter("id"));

		SubArticleDao articleDao = new SubArticleDao();
		
		
		WebSubInfo webInfomation=articleDao.getById(id);
		request.setAttribute("item", webInfomation);
		request.getRequestDispatcher("subedit.jsp").forward(request, response);
	}

	
	private void add(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebSubInfo webInfomation=new WebSubInfo();
		webInfomation.setBt(request.getParameter("bt"));
		webInfomation.setNr(request.getParameter("nr"));
		webInfomation.setZz(request.getParameter("zz"));
		webInfomation.setLjwz(request.getParameter("ljwz"));
		webInfomation.setLy(request.getParameter("ly"));
		Long pid=Long.valueOf(request.getParameter("pid"));
		webInfomation.setLmid(pid);
		webInfomation.setFbr(request.getSession().getAttribute("xm").toString());
		webInfomation.setZt("草稿");
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("rq"));
			webInfomation.setRq(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SubArticleDao articleDao = new SubArticleDao();
		articleDao.add(webInfomation);
		
   	    response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideAddFrame();</script>"); 
		out.flush();

	}
	
	private void addContent(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebSubInfo webInfomation=new WebSubInfo();
		webInfomation.setBt(request.getParameter("bt"));
		webInfomation.setNr(request.getParameter("nr"));
		webInfomation.setZz(request.getParameter("zz"));
		webInfomation.setLjwz(request.getParameter("ljwz"));
		webInfomation.setLy(request.getParameter("ly"));
		Long pid=Long.valueOf(request.getParameter("pid"));
		webInfomation.setLmid(pid);
		
		webInfomation.setFbr(request.getSession().getAttribute("xm").toString());
		webInfomation.setZt("草稿");
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("rq"));
			webInfomation.setRq(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SubArticleDao articleDao = new SubArticleDao();
		articleDao.add(webInfomation);
		
        getList(request, response);

	}
	
	
   	private void goAddPage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
        String pid= request.getParameter("pid");
        request.setAttribute("pid", pid);
		request.getRequestDispatcher("subadd.jsp").forward(request, response);
	}


	private void deleteItems(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
	 String[]  itemList=request.getParameterValues("itemList");
		int pageNo = 1;
		int pageSize = 10;
		
		if(!(request.getParameter("pageNo")==null||request.getParameter("pageNo").equals(""))){
			pageNo=Integer.valueOf(request.getParameter("pageNo"));
		}
		if(!(request.getParameter("pageSize")==null||request.getParameter("pageSize").equals(""))){
			pageSize=Integer.valueOf(request.getParameter("pageSize"));
		}
	 Long pid=Long.valueOf(request.getParameter("pid"));
	
	 String search=request.getParameter("search");
	 SubArticleDao articleDao = new SubArticleDao();
	 if(articleDao.delItemList(itemList)==true){
		 response.sendRedirect("SubArticleServlet?act=list&pid="+pid+"&pageNo="+pageNo+"&pageSize"+pageSize+"&search="+search);
	 }else{
		 //定位至错误页面
	 }
	 
	
}
	
	
	
	private void getList(HttpServletRequest request,HttpServletResponse response) 
    throws ServletException, IOException {
		
        //添加后跳转到之前页面的id号记录
		
		Long ppid = Long.valueOf(request.getParameter("pid"));

		
		int pageNo = 1;
		int pageSize = 10;
		
		SpecialColumnDao specialColumnDao=new SpecialColumnDao();
		WebSubColumn webColumn=specialColumnDao.getById(ppid);
		if(webColumn.getLmmx().equals(Constants.RRMB)){
			//如果是内容模板，如果没文章就新建一篇文章，否则就是修改一篇文章
			SubArticleDao articleDao=new SubArticleDao();
			if (articleDao.hasArticle(ppid)) {			
				WebSubInfo webInfomation=articleDao.getBySjid(ppid);
				request.setAttribute("item", webInfomation);
				request.getRequestDispatcher("subeditcontent.jsp").forward(request, response);
			}else{
				request.setAttribute("pid", ppid);
				request.getRequestDispatcher("subaddcontent.jsp").forward(request, response);
			}

		}else{		
			
			if(!(request.getParameter("pageNo")==null||request.getParameter("pageNo").equals(""))){
				pageNo=Integer.valueOf(request.getParameter("pageNo"));
			}
			if(!(request.getParameter("pageSize")==null||request.getParameter("pageSize").equals(""))){
				pageSize=Integer.valueOf(request.getParameter("pageSize"));
			}
			String searchStr=request.getParameter("search");
			SubArticleDao articleDao = new SubArticleDao();
			Pager pager=articleDao.getArticleForPage(pageNo, pageSize, searchStr,ppid);
		
			request.setAttribute("pager", pager);
			request.setAttribute("pid", ppid);
			request.setAttribute("search", searchStr);
			request.getRequestDispatcher("sublist.jsp").forward(request, response);
		}
    }
}
