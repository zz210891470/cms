package com.trunko.cms.servlet.article;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.common.Constants;
import com.trunko.cms.dao.article.ArticleDao;
import com.trunko.cms.dao.sysconfig.SysColumnDao;
import com.trunko.cms.entity.WebColumn;
import com.trunko.cms.entity.WebInfomation;
import com.trunko.cms.util.FavoritesHelper;
import com.trunko.cms.util.Pager;



/**
 * 文章编辑类
 * @author gjz
 *
 */
public class ArticleServlet extends HttpServlet {

	
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
		  }else if(act.equals("addload")){
			  addLoad(request,response);
		  }else if(act.equals("updatepage")){
			   goUpdatePage(request,response);
		  }else if(act.equals("update")){
			   update(request,response);
		  }else if(act.equals("updatecontent")){
			   updateContent(request,response);
		  }else if(act.equals("updateload")){
			   updateLoad(request,response);
		  }else if(act.equals("hasArticle")){
			    hasArticle(request,response);
		  }else if(act.equals("downloadpage")){
			  goDownloadPage(request,response);
		  }else if(act.equals("updatedownloadpage")){
			  goUpdateDownloadPage(request,response);
		  }else if(act.equals("recyclepage")){
			  showRecyclePage(request,response);
		  }else if(act.equals("RdeleteItems")){
			  RdeleteItems(request,response);
		  }else if(act.equals("resume")){
			  resume(request,response);
		  }else if(act.equals("saveandrelease")){
			  saveandrelease(request,response);
		  }else if(act.equals("saveandcontinue")){
			  saveandcontinue(request,response);
		  }else if(act.equals("listrelease")){
			  listrelease(request,response);
		  }else if(act.equals("saveandreleasecontent")){
			  saveandreleasecontent(request,response);
		  }else if(act.equals("updateandreleasecontent")){
			  //内容模板修改并发布
			  updateandreleasecontent(request,response);
		  }else if(act.equals("updateandrelease")){
			  //列表页修改 并发布
			  updateandrelease(request,response);
		  }else if(act.equals("updatecaogao")){
			  //列表页修改 并发布
			  updatecaogao(request,response);
		  }else if(act.equals("preview")){
			  preview(request,response);
		  }
	}
	
	
	private void preview(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {

		WebInfomation webInfomation=new WebInfomation();

		webInfomation.setBt(request.getParameter("bt"));
		webInfomation.setNr(request.getParameter("nr"));
		webInfomation.setZz(request.getParameter("zz"));
		webInfomation.setLy(request.getParameter("ly"));

//		webInfomation.setLstp(request.getParameter("lstp"));
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("rq"));
			webInfomation.setRq(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			e.printStackTrace();
		}

		request.setAttribute("item", webInfomation);
		request.getRequestDispatcher("preview.jsp").forward(request, response);
		
	}
	
	private void updatecaogao(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebInfomation webInfomation=new WebInfomation();
		webInfomation.setId(Long.valueOf(request.getParameter("id")));
		webInfomation.setBt(request.getParameter("bt"));
		webInfomation.setNr(request.getParameter("nr"));
		webInfomation.setZz(request.getParameter("zz"));
		webInfomation.setLy(request.getParameter("ly"));
		webInfomation.setZy(request.getParameter("zy"));
		webInfomation.setLstp(request.getParameter("lstp"));
		webInfomation.setRd(request.getParameter("rd"));
		webInfomation.setGd(request.getParameter("gd"));
		webInfomation.setHd(request.getParameter("hd"));
		webInfomation.setFbr(request.getSession().getAttribute("xm").toString());
		webInfomation.setZt("草稿");
		webInfomation.setLjwz(request.getParameter("ljwz"));
		webInfomation.setIstop(FavoritesHelper.stringToint((request.getParameter("istop"))));
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("rq"));
			webInfomation.setRq(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		java.util.Date d = new java.util.Date();
		Timestamp t = new Timestamp(d.getTime());
		webInfomation.setSj(t);
	    System.out.println("lstp:"+request.getParameter("lstp"));


		ArticleDao articleDao = new ArticleDao();
		articleDao.updateZt(webInfomation);
		
		
   	    response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>alert('保存成功!');window.parent.hideEditFrame();</script>"); 
		out.flush();

	}
	
	private void updateandrelease(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebInfomation webInfomation=new WebInfomation();
		webInfomation.setId(Long.valueOf(request.getParameter("id")));
		webInfomation.setBt(request.getParameter("bt"));
		webInfomation.setNr(request.getParameter("nr"));
		webInfomation.setZz(request.getParameter("zz"));
		webInfomation.setLy(request.getParameter("ly"));
		webInfomation.setZy(request.getParameter("zy"));
		webInfomation.setLstp(request.getParameter("lstp"));
		webInfomation.setRd(request.getParameter("rd"));
		webInfomation.setGd(request.getParameter("gd"));
		webInfomation.setHd(request.getParameter("hd"));
		webInfomation.setFbr(request.getSession().getAttribute("xm").toString());
		webInfomation.setZt("已发布");
		webInfomation.setLjwz(request.getParameter("ljwz"));
		webInfomation.setIstop(FavoritesHelper.stringToint((request.getParameter("istop"))));
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("rq"));
			webInfomation.setRq(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		java.util.Date d = new java.util.Date();
		Timestamp t = new Timestamp(d.getTime());
		webInfomation.setSj(t);
	    System.out.println("lstp:"+request.getParameter("lstp"));


		ArticleDao articleDao = new ArticleDao();
		articleDao.updateZt(webInfomation);
		
		
   	    response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>alert('保存成功!');window.parent.hideEditFrame();</script>"); 
		out.flush();

	}
	
	private void updateandreleasecontent(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebInfomation webInfomation=new WebInfomation();
		webInfomation.setId(Long.valueOf(request.getParameter("id")));
		webInfomation.setBt(request.getParameter("bt"));
		webInfomation.setNr(request.getParameter("nr"));
		webInfomation.setZz(request.getParameter("zz"));
		webInfomation.setLy(request.getParameter("ly"));
		webInfomation.setZy(request.getParameter("zy"));
		webInfomation.setLstp(request.getParameter("lstp"));
		webInfomation.setRd(request.getParameter("rd"));
		webInfomation.setGd(request.getParameter("gd"));
		webInfomation.setHd(request.getParameter("hd"));
		webInfomation.setFbr(request.getSession().getAttribute("xm").toString());
		webInfomation.setZt("已发布");
		webInfomation.setLjwz(request.getParameter("ljwz"));
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("rq"));
			webInfomation.setRq(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		java.util.Date d = new java.util.Date();
		Timestamp t = new Timestamp(d.getTime());
		webInfomation.setSj(t);
	    System.out.println("lstp:"+request.getParameter("lstp"));


		ArticleDao articleDao = new ArticleDao();
		articleDao.updateZt(webInfomation);
		
        getList(request, response);

	}
	
	private void saveandreleasecontent(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebInfomation webInfomation=new WebInfomation();
		webInfomation.setBt(request.getParameter("bt"));
		webInfomation.setNr(request.getParameter("nr"));
		webInfomation.setZz(request.getParameter("zz"));
		webInfomation.setLy(request.getParameter("ly"));
		webInfomation.setZy(request.getParameter("zy"));
		webInfomation.setRd(request.getParameter("rd"));
		webInfomation.setGd(request.getParameter("gd"));
		webInfomation.setHd(request.getParameter("hd"));
		webInfomation.setLstp(request.getParameter("lstp"));
		webInfomation.setFbr(request.getSession().getAttribute("xm").toString());
		webInfomation.setZt("已发布");
		webInfomation.setLjwz(request.getParameter("ljwz"));
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("rq"));
			webInfomation.setRq(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.util.Date d = new java.util.Date();
		Timestamp t = new Timestamp(d.getTime());
		webInfomation.setSj(t);
		
		Long pid=Long.valueOf(request.getParameter("pid"));
		webInfomation.setLmid(pid);
		ArticleDao articleDao = new ArticleDao();
		articleDao.add(webInfomation);
		
        getList(request, response);

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
	 ArticleDao articleDao = new ArticleDao();

	 if(articleDao.listrelease(id)==true){
	
		 getList(request, response);
	//	 response.sendRedirect("ArticleServlet?act=list&pid="+pid+"&pageNo="+pageNo+"&pageSize"+pageSize+"&search="+search);
	 }else{
		 //定位至错误页面
	 }
	}
	
	
	private void saveandcontinue(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebInfomation webInfomation=new WebInfomation();
		webInfomation.setBt(request.getParameter("bt"));
		webInfomation.setNr(request.getParameter("nr"));
		webInfomation.setZz(request.getParameter("zz"));
		webInfomation.setLy(request.getParameter("ly"));
		webInfomation.setZy(request.getParameter("zy"));
		webInfomation.setRd(request.getParameter("rd"));
		webInfomation.setGd(request.getParameter("gd"));
		webInfomation.setHd(request.getParameter("hd"));
		webInfomation.setLstp(request.getParameter("lstp"));
		webInfomation.setFbr(request.getSession().getAttribute("xm").toString());
		webInfomation.setZt("草稿");
		webInfomation.setLjwz(request.getParameter("ljwz"));
		webInfomation.setIstop(FavoritesHelper.stringToint((request.getParameter("istop"))));
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("rq"));
			webInfomation.setRq(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		java.util.Date d = new java.util.Date();
		Timestamp t = new Timestamp(d.getTime());
		webInfomation.setSj(t);
		
		Long pid=Long.valueOf(request.getParameter("pid"));
		webInfomation.setLmid(pid);
		ArticleDao articleDao = new ArticleDao();
		articleDao.add(webInfomation);
		
   //	    response.sendRedirect("ArticleServlet?act=addpage&pid="+pid);
	 	response.setContentType("text/html;charset=UTF-8"); 
    	PrintWriter out = response.getWriter();
    	if ("download".equals(request.getParameter("showType"))) {
     		out.println("<script type='text/javascript'>alert('保存成功！');document.location.href='ArticleServlet?act=downloadpage&pid="+pid+"';</script>"); 
 		}else{
 			out.println("<script type='text/javascript'>alert('保存成功！');document.location.href='ArticleServlet?act=addpage&pid="+pid+"';</script>"); 
 		}
 		out.flush();

	}
	
	
	private void saveandrelease(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebInfomation webInfomation=new WebInfomation();
		webInfomation.setBt(request.getParameter("bt"));
		webInfomation.setNr(request.getParameter("nr"));
		webInfomation.setZz(request.getParameter("zz"));
		webInfomation.setLy(request.getParameter("ly"));
		webInfomation.setZy(request.getParameter("zy"));
		webInfomation.setRd(request.getParameter("rd"));
		webInfomation.setGd(request.getParameter("gd"));
		webInfomation.setHd(request.getParameter("hd"));
		webInfomation.setLstp(request.getParameter("lstp"));
		webInfomation.setFbr(request.getSession().getAttribute("xm").toString());
		webInfomation.setZt("已发布");
		webInfomation.setLjwz(request.getParameter("ljwz"));
		webInfomation.setIstop(FavoritesHelper.stringToint((request.getParameter("istop"))));
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("rq"));
			webInfomation.setRq(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		java.util.Date d = new java.util.Date();
		Timestamp t = new Timestamp(d.getTime());
		webInfomation.setSj(t);
		
		Long pid=Long.valueOf(request.getParameter("pid"));
		webInfomation.setLmid(pid);
		ArticleDao articleDao = new ArticleDao();
		articleDao.add(webInfomation);
		
   	    response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>alert('保存成功!');window.parent.hideAddFrame();</script>"); 
		out.flush();

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
	 ArticleDao articleDao = new ArticleDao();
	 if(articleDao.resume(itemList)==true){
		 showRecyclePage(request, response);
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
		ArticleDao articleDao = new ArticleDao();
		Pager pager= articleDao.getRecycleForPage(pageNo, pageSize, searchStr,pid);
		
		request.setAttribute("search", searchStr);
		request.setAttribute("pager", pager);
		request.setAttribute("pid", pid);
		request.getRequestDispatcher("recycle.jsp").forward(request, response);
	}
	
	
	private void hasArticle(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		String data="[\"FAIL\"]";
		Long id=Long.valueOf(request.getParameter("id"));
		ArticleDao articleDao=new ArticleDao();
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
	
	
	private void update(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebInfomation webInfomation=new WebInfomation();
		webInfomation.setId(Long.valueOf(request.getParameter("id")));
		webInfomation.setBt(request.getParameter("bt"));
		webInfomation.setNr(request.getParameter("nr"));
		webInfomation.setZz(request.getParameter("zz"));
		webInfomation.setLy(request.getParameter("ly"));
		webInfomation.setZy(request.getParameter("zy"));
		webInfomation.setLstp(request.getParameter("lstp"));
		webInfomation.setLjwz(request.getParameter("ljwz"));
		webInfomation.setRd(request.getParameter("rd"));
		webInfomation.setGd(request.getParameter("gd"));
		webInfomation.setHd(request.getParameter("hd"));
		webInfomation.setFbr(request.getSession().getAttribute("xm").toString());
		webInfomation.setIstop(FavoritesHelper.stringToint((request.getParameter("istop"))));
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("rq"));
			webInfomation.setRq(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		java.util.Date d = new java.util.Date();
		Timestamp t = new Timestamp(d.getTime());
		webInfomation.setSj(t);
	    System.out.println("lstp:"+request.getParameter("lstp"));


		ArticleDao articleDao = new ArticleDao();
		articleDao.update(webInfomation);
		
		
   	    response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>alert('保存成功!');window.parent.hideEditFrame();</script>"); 
		out.flush();

	}
	
	
	private void updateContent(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebInfomation webInfomation=new WebInfomation();
		webInfomation.setId(Long.valueOf(request.getParameter("id")));
		webInfomation.setBt(request.getParameter("bt"));
		webInfomation.setNr(request.getParameter("nr"));
		webInfomation.setZz(request.getParameter("zz"));
		webInfomation.setLy(request.getParameter("ly"));
		webInfomation.setZy(request.getParameter("zy"));
		webInfomation.setLstp(request.getParameter("lstp"));
		webInfomation.setRd(request.getParameter("rd"));
		webInfomation.setGd(request.getParameter("gd"));
		webInfomation.setHd(request.getParameter("hd"));
		webInfomation.setLjwz(request.getParameter("ljwz"));
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
		
		java.util.Date d = new java.util.Date();
		Timestamp t = new Timestamp(d.getTime());
		webInfomation.setSj(t);
	    System.out.println("lstp:"+request.getParameter("lstp"));


		ArticleDao articleDao = new ArticleDao();
		articleDao.updateZt(webInfomation);
		
        getList(request, response);

	}
	
	private void goUpdatePage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		long id=Long.valueOf(request.getParameter("id"));

		ArticleDao articleDao = new ArticleDao();
		
		
		WebInfomation webInfomation=articleDao.getById(id);
		request.setAttribute("item", webInfomation);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

	
	private void add(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebInfomation webInfomation=new WebInfomation();
		webInfomation.setBt(request.getParameter("bt"));
		webInfomation.setNr(request.getParameter("nr"));
		webInfomation.setZz(request.getParameter("zz"));
		webInfomation.setLy(request.getParameter("ly"));
		webInfomation.setZy(request.getParameter("zy"));
		webInfomation.setRd(request.getParameter("rd"));
		webInfomation.setGd(request.getParameter("gd"));
		webInfomation.setHd(request.getParameter("hd"));
		webInfomation.setLjwz(request.getParameter("ljwz"));
		webInfomation.setLstp(request.getParameter("lstp"));
		webInfomation.setFbr(request.getSession().getAttribute("xm").toString());
		webInfomation.setZt("草稿");
		webInfomation.setIstop(FavoritesHelper.stringToint((request.getParameter("istop"))));
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("rq"));
			webInfomation.setRq(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			e.printStackTrace();
		}

		
		java.util.Date d = new java.util.Date();
		Timestamp t = new Timestamp(d.getTime());
		webInfomation.setSj(t);
		
		Long pid=Long.valueOf(request.getParameter("pid"));
		webInfomation.setLmid(pid);
		ArticleDao articleDao = new ArticleDao();
		articleDao.add(webInfomation);
		
   	    response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>alert('保存成功！');window.parent.hideAddFrame();</script>"); 
		out.flush();

	}
	
	private void addContent(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebInfomation webInfomation=new WebInfomation();
		webInfomation.setBt(request.getParameter("bt"));
		webInfomation.setNr(request.getParameter("nr"));
		webInfomation.setZz(request.getParameter("zz"));
		webInfomation.setLy(request.getParameter("ly"));
		webInfomation.setZy(request.getParameter("zy"));
		webInfomation.setRd(request.getParameter("rd"));
		webInfomation.setGd(request.getParameter("gd"));
		webInfomation.setHd(request.getParameter("hd"));
		webInfomation.setLstp(request.getParameter("lstp"));
		webInfomation.setLjwz(request.getParameter("ljwz"));
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
		
		java.util.Date d = new java.util.Date();
		Timestamp t = new Timestamp(d.getTime());
		webInfomation.setSj(t);
		
		Long pid=Long.valueOf(request.getParameter("pid"));
		webInfomation.setLmid(pid);
		ArticleDao articleDao = new ArticleDao();
		articleDao.add(webInfomation);
		
        getList(request, response);

	}
	
	
	
   	private void goAddPage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
        String pid= request.getParameter("pid");
        request.setAttribute("pid", pid);
		request.getRequestDispatcher("add.jsp").forward(request, response);
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
	 ArticleDao articleDao = new ArticleDao();
	 if(articleDao.delItemList(itemList)==true){
		 response.sendRedirect("ArticleServlet?act=list&pid="+pid+"&pageNo="+pageNo+"&pageSize"+pageSize+"&search="+search);
	 }else{
		 //定位至错误页面
	 }
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
	 ArticleDao articleDao = new ArticleDao();
	 if(articleDao.delItemListR(itemList)==true){
		 showRecyclePage(request, response);
	 }else{
		 //定位至错误页面
	 }
	}
	
	private void getList(HttpServletRequest request,HttpServletResponse response) 
    throws ServletException, IOException {
		
		Long ppid = Long.valueOf(request.getParameter("pid"));
		System.out.println(ppid);
	     
		int pageNo = 1;
		int pageSize = 10;
		
		SysColumnDao sysColumnDao=new SysColumnDao();
		WebColumn webColumn=sysColumnDao.getById(ppid);
		if(webColumn.getLmmx().equals(Constants.RRMB)){
			//如果是内容模板，如果没文章就新建一篇文章，否则就是修改一篇文章
			ArticleDao articleDao=new ArticleDao();
			if (articleDao.hasArticle(ppid)) {			
				WebInfomation webInfomation=articleDao.getBySjid(ppid);
				request.setAttribute("pid", ppid);
				request.setAttribute("item", webInfomation);
				request.getRequestDispatcher("editcontent.jsp").forward(request, response);
			}else{
				request.setAttribute("pid", ppid);
				request.getRequestDispatcher("addcontent.jsp").forward(request, response);
			}		
		}else if(webColumn.getLmmx().equals(Constants.LBMB)){		
			//如果是列表模板则展示文章列表
			if(!(request.getParameter("pageNo")==null||request.getParameter("pageNo").equals(""))){
				pageNo=Integer.valueOf(request.getParameter("pageNo"));
			}
			if(!(request.getParameter("pageSize")==null||request.getParameter("pageSize").equals(""))){
				pageSize=Integer.valueOf(request.getParameter("pageSize"));
			}
	
			String searchStr=request.getParameter("search");
			ArticleDao articleDao = new ArticleDao();
			Pager pager=articleDao.getArticleForPage(pageNo, pageSize, searchStr,ppid);
		
			request.setAttribute("pager", pager);
			request.setAttribute("pid", ppid);
			request.setAttribute("search", searchStr);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}else if(webColumn.getLmmx().equals(Constants.XZMB)){	
			//如果是下载模板则展示下载文件列表
			if(!(request.getParameter("pageNo")==null||request.getParameter("pageNo").equals(""))){
				pageNo=Integer.valueOf(request.getParameter("pageNo"));
			}
			if(!(request.getParameter("pageSize")==null||request.getParameter("pageSize").equals(""))){
				pageSize=Integer.valueOf(request.getParameter("pageSize"));
			}
	
			String searchStr=request.getParameter("search");
			ArticleDao articleDao = new ArticleDao();
			Pager pager=articleDao.getArticleForPage(pageNo, pageSize, searchStr,ppid);
		
			request.setAttribute("pager", pager);
			request.setAttribute("pid", ppid);
			request.setAttribute("search", searchStr);
			request.getRequestDispatcher("downloadlist.jsp").forward(request, response);
			
		}
    }
	

	
	private void addLoad(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebInfomation webInfomation=new WebInfomation();
		webInfomation.setBt(request.getParameter("bt"));
		webInfomation.setNr(request.getParameter("nr"));
		webInfomation.setFbt(request.getParameter("fbt"));
		webInfomation.setLjwz(request.getParameter("ljwz"));

		
		java.util.Date d = new java.util.Date();
		Timestamp t = new Timestamp(d.getTime());
		webInfomation.setSj(t);
		
		Long pid=Long.valueOf(request.getParameter("pid"));
		webInfomation.setLmid(pid);
		ArticleDao articleDao = new ArticleDao();
		articleDao.add(webInfomation);
		
		
   	    response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>alert('保存成功！');window.parent.hideAddFrame();</script>"); 
		out.flush();

	}
	
	private void updateLoad(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		WebInfomation webInfomation=new WebInfomation();
		webInfomation.setId(Long.valueOf(request.getParameter("id")));
		webInfomation.setBt(request.getParameter("bt"));
		webInfomation.setNr(request.getParameter("nr"));
	//	webInfomation.setZz(request.getParameter("zz"));
		webInfomation.setLjwz(request.getParameter("ljwz"));

		
		java.util.Date d = new java.util.Date();
		Timestamp t = new Timestamp(d.getTime());
		webInfomation.setSj(t);

		ArticleDao articleDao = new ArticleDao();
		articleDao.update(webInfomation);
		
			
   	    response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>alert('保存成功!');window.parent.hideEditFrame();</script>"); 
		out.flush();
	}
	
	private void goUpdateDownloadPage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		long id=Long.valueOf(request.getParameter("id"));

		ArticleDao articleDao = new ArticleDao();

		WebInfomation webInfomation=articleDao.getById(id);
		request.setAttribute("item", webInfomation);
		request.getRequestDispatcher("downloadedit.jsp").forward(request, response);
	}
	
  	private void goDownloadPage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		Long pid=Long.valueOf(request.getParameter("pid"));	
		request.setAttribute("pid", pid);
		request.getRequestDispatcher("downloadadd.jsp").forward(request, response);
	}
}
