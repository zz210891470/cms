package com.trunko.project.serlvet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.util.Pager;
import com.trunko.project.dao.ZsxmDao;
import com.trunko.project.entity.ProZsxm;


/**
 * 控制类  招商项目列表页增删改查
 * @author gjz
 *
 */
public class ZsxmServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		String action=request.getParameter("action");
		   
	    if(action.equals("list")){//显示列表
		    getList(request, response);
	    }
	    else if(action.equals("toAdd")){//跳转到添加页面
		    goAddPage(request, response);
	    }
	    else if(action.equals("toEdit")){//跳转到编辑页面
		    goEditPage(request, response);
	    }
	    else if(action.equals("toImport")){//跳转至导入页面
		    toImportPage(request, response);
	    }
	    else if(action.equals("sideradd")){//侧边栏录入页面
		    toSiderAddPage(request, response);
	    }
	    else if(action.equals("toRead")){//跳转到编辑页面
		    goReadPage(request, response);
	    }
	    else if(action.equals("xxhz")){   //信息汇总	
	    	Xxhz(request,response);
	    }
	    else if(action.equals("xxhzpage")){   //信息汇总 页面
	    	toXxhzPage(request,response);
	    }
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
	    String action=request.getParameter("action");
	   
	    if(action.equals("list")){//显示列表
		    postList(request, response);
	    }
	    else if(action.equals("del")){//删除列表项
		    delItems(request, response);
	    }
	    else if(action.equals("toAdd")){//跳转到添加页面
		    goAddPage(request, response);
	    }
	    else if(action.equals("add")){//添加列表项
		    add(request, response);
	    }
	    else if(action.equals("toEdit")){//跳转到编辑页面
		    goEditPage(request, response);
	    }
	    else if(action.equals("toRead")){//跳转到编辑页面
		    goReadPage(request, response);
	    }
	    else if(action.equals("update")){//修改列表项
		    update(request, response);
	    }
	    else if(action.equals("toImport")){//跳转至导入页面
		    toImportPage(request, response);
	    }
	    else if(action.equals("sideradd")){//侧边栏录入页面
		    toSiderAddPage(request, response);
	    }	    
	    else if(action.equals("sadd")){//侧边栏录入页面
		    sadd(request, response);
	    }
	    else if(action.equals("xxhz")){   //信息汇总	
	    	Xxhz(request,response);
	    }
	    else if(action.equals("xxhzpage")){   //信息汇总 页面
	    	toXxhzPage(request,response);
	    }
	}
	
	
	/**
	 * 项目信息汇总
	 * @param request  请求
	 * @param response 响应
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toXxhzPage(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
	
	    String nd =	request.getParameter("nd");  // 年度
	    String lb1 = request.getParameter("lb1");// 类别：大类
	    String lb2 = request.getParameter("lb2");// 类别：小类
	    String dq = request.getParameter("dq");// 所属地区
	    
	    String ztz1 = request.getParameter("ztz1");// 判断符（全部、大于等于、等于）
	    String ztz1num = request.getParameter("ztz2");// 数值1
	    String ztz2 = request.getParameter("ztz3");// 判断符（全部、小于）
	    String ztz2num = request.getParameter("ztz4");// 数值2
		
	    // 获取招商项目信息
	    List<ProZsxm> itemList = ZsxmDao.showXxhzList(nd, lb1, lb2, dq, ztz1, ztz1num , ztz2, ztz2num);
	    request.setAttribute("itemList", itemList);
		// 跳转至信息汇总展示界面
		request.getRequestDispatcher("tj_xx.jsp").forward(request, response);
    }

	
	
	/**
	 * 信息汇总
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void Xxhz(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		// 地区集合
		request.setAttribute("dqlist", ZsxmDao.getDqList());
		// 类别集合
		request.setAttribute("lblist", ZsxmDao.getLbList());
		// 跳转到选择条件页面
		request.getRequestDispatcher("tj_xx_page.jsp").forward(request, response);

    }
	/**
	 * 添加新项
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void sadd(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		
		ProZsxm item = new ProZsxm();

		item.setNd(Long.valueOf(request.getParameter("nd")));
        item.setBh(request.getParameter("bh"));
        item.setMc(request.getParameter("mc"));
        item.setJsgm(request.getParameter("jsgm"));
        item.setHzfs(request.getParameter("hzfs"));
        item.setLxdw(request.getParameter("lxdw"));
        item.setLxr(request.getParameter("lxr"));
        item.setLxdh(request.getParameter("lxdh"));
        item.setQqgz(request.getParameter("qqgz"));
        item.setZtz(request.getParameter("ztz"));
        item.setDq(request.getParameter("dq"));
		item.setLb1(request.getParameter("lb1"));
		item.setLb2(request.getParameter("lb2"));
		ZsxmDao.add(item);

		request.setAttribute("status", "ok");
		request.setAttribute("dqlist",  ZsxmDao.getDqList());

		request.setAttribute("lblist", ZsxmDao.getLbList());
		request.getRequestDispatcher("add.jsp").forward(request, response);
	}
	
	
	/**
	 * 侧边栏录入页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toSiderAddPage(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
		request.setAttribute("dqlist",  ZsxmDao.getDqList());

		request.setAttribute("lblist", ZsxmDao.getLbList());
		request.getRequestDispatcher("add.jsp").forward(request, response);
	}

	
	
	/**
	 * 跳转到添加页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toImportPage(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
		
		
		
		request.getRequestDispatcher("dr.jsp").forward(request, response);
	}
	
	
	
	
	/**
	 * 更新列表项
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void update(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		ProZsxm item = new ProZsxm();
		
		item.setId(Long.valueOf(request.getParameter("id")));
        item.setNd(Long.valueOf(request.getParameter("nd")));
        item.setBh(request.getParameter("bh"));
        item.setMc(request.getParameter("mc"));
        item.setJsgm(request.getParameter("jsgm"));
        item.setHzfs(request.getParameter("hzfs"));
        item.setLxdw(request.getParameter("lxdw"));
        item.setLxr(request.getParameter("lxr"));
        item.setLxdh(request.getParameter("lxdh"));
        item.setQqgz(request.getParameter("qqgz"));
        item.setDq(request.getParameter("dq"));
        item.setZtz(request.getParameter("ztz"));
		item.setLb1(request.getParameter("lb1"));
		item.setLb2(request.getParameter("lb2"));
		ZsxmDao.update(item);	
			
   	    response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideEditFrame();</script>"); 
		out.flush();
	}
	
	/**
	 * 跳转到编辑页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goEditPage(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
		
		long id   = Long.valueOf(request.getParameter("id"));

		ProZsxm item = ZsxmDao.getObjById(id);
		
		request.setAttribute("item", item);
		request.setAttribute("dqlist",  ZsxmDao.getDqList());

		request.setAttribute("lblist", ZsxmDao.getLbList());
		request.getRequestDispatcher("xg.jsp").forward(request, response);
	}

	
	/**
	 * 跳转到编辑页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goReadPage(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
		
		long id   = Long.valueOf(request.getParameter("id"));

		ProZsxm item = ZsxmDao.getObjById(id);
		
		request.setAttribute("item", item);

		request.getRequestDispatcher("ll.jsp").forward(request, response);
	}
	
	/**
	 * 添加新项
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void add(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		
		ProZsxm item = new ProZsxm();

		item.setNd(Long.valueOf(request.getParameter("nd")));
        item.setBh(request.getParameter("bh"));
        item.setMc(request.getParameter("mc"));
        item.setDq(request.getParameter("dq"));
        item.setJsgm(request.getParameter("jsgm"));
        item.setHzfs(request.getParameter("hzfs"));
        item.setLxdw(request.getParameter("lxdw"));
        item.setLxr(request.getParameter("lxr"));
        item.setLxdh(request.getParameter("lxdh"));
        item.setQqgz(request.getParameter("qqgz"));
        item.setZtz(request.getParameter("ztz"));
		item.setLb1(request.getParameter("lb1"));
		item.setLb2(request.getParameter("lb2"));
		ZsxmDao.add(item);

   	    response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideAddFrame();</script>"); 
		out.flush();
	}
	
	
	/**
	 * 跳转到添加页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goAddPage(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
		
		request.setAttribute("dqlist",  ZsxmDao.getDqList());

		request.setAttribute("lblist", ZsxmDao.getLbList());
		request.getRequestDispatcher("lr.jsp").forward(request, response);
	}

	/**
	 * 删除列表项  仅接受post请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delItems(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		String[] itemList = request.getParameterValues("itemList");
		 	
		if(ZsxmDao.delItemList(itemList)){
			//TODO 应该是若是普通用户应该ajax类型的删除节省流量  后台用户也直接记录页面位置
			postList(request, response);
		}else{
			//定位至错误页面
		}	
	}
	
    /**
     * get请求加载列表
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
	private void getList(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

		Integer  pageNo   = 1;
		Integer  pageSize = 10;
	    String searchStr = request.getParameter("searchStr");
		Pager pager = ZsxmDao.getObjForPage(pageNo, pageSize,searchStr);

		request.setAttribute("pager", pager);
		request.setAttribute("searchStr", searchStr);
		request.getRequestDispatcher("gl.jsp").forward(request, response);
		
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
	
		String searchStr = request.getParameter("searchStr");
		Pager pager = ZsxmDao.getObjForPage(pageNo, pageSize, searchStr);
	
		request.setAttribute("pager", pager);
		request.setAttribute("searchStr", searchStr);

		request.getRequestDispatcher("gl.jsp").forward(request, response);
		
	}

}
