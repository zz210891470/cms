package com.trunko.project.serlvet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.util.Pager;
import com.trunko.project.dao.CbxmDao;
import com.trunko.project.dao.CbxmSbyhDao;
import com.trunko.project.dao.ZdxmDao;
import com.trunko.project.dao.ZdxmSbyhDao;
import com.trunko.project.entity.ProCbxm;
import com.trunko.project.entity.ProZdxm;
import com.trunko.project.entity.ProZdxmYb;

public class CbxmSbyhServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		String action=request.getParameter("action");
		   
	    if(action.equals("list")){//��ʾ�б�
		    getList(request, response);
	    }
	    else if(action.equals("toAdd")){//��ת�����ҳ��
		    goAddPage(request, response);
	    }
	    else if(action.equals("toEdit")){//��ת���༭ҳ��
		    goEditPage(request, response);
	    }
	    else if(action.equals("toImport")){//��ת������ҳ��
		    toImportPage(request, response);
	    }
	    else if(action.equals("sideradd")){//�����¼��ҳ��
		    toSiderAddPage(request, response);
	    }
	    else if(action.equals("toSkip")){//��ת�����ҳ��
		    goSkipPage(request, response);
	    }
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
	    String action=request.getParameter("action");
	   
	    if(action.equals("list")){//��ʾ�б�
		    postList(request, response);
	    }
	    else if(action.equals("del")){//ɾ���б���
		    delItems(request, response);
	    }
	    else if(action.equals("toAdd")){//��ת�����ҳ��
		    goAddPage(request, response);
	    }
	    else if(action.equals("add")){//����б���
		    add(request, response);
	    }
	    else if(action.equals("toEdit")){//��ת���༭ҳ��
		    goEditPage(request, response);
	    }
	    else if(action.equals("toSkip")){//��ת�����ҳ��
		    goSkipPage(request, response);
	    }
	    else if(action.equals("update")){//�޸��б���
		    update(request, response);
	    }
	    else if(action.equals("toImport")){//��ת������ҳ��
		    toImportPage(request, response);
	    }
	    else if(action.equals("sideradd")){//�����¼��ҳ��
		    toSiderAddPage(request, response);
	    }	    
	    else if(action.equals("sadd")){//�����¼��ҳ��
		    sadd(request, response);
	    }
	    else if(action.equals("upmsg")){  //�ϱ���Ŀ
	    	upMsg(request,response);
	    }
	    else if(action.equals("commit")){
	    	commit(request,response);
	    }

	}
	
	
	
	/**
	 * �����б���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void upMsg(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
		ZdxmSbyhDao.upMsg(request.getParameter("id"));
		
		postList(request, response);
		
	}
	
	
	
	/**
	 * �������
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void sadd(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		ProCbxm item = new ProCbxm();
		
		item.setNd(Long.valueOf(request.getParameter("nd")));
		item.setBh(request.getParameter("bh"));
		item.setMc(request.getParameter("mc"));
		item.setDq(request.getParameter("dq"));
		item.setJsgm(request.getParameter("jsgm"));
		item.setJsdd(request.getParameter("jsdd"));
		
		if(request.getParameter("ztz") == null || request.getParameter("ztz").equals("")){
			item.setZtz((double) 0l);
		}else{
			item.setZtz(Double.valueOf(request.getParameter("ztz")));
		}

		item.setXyfx(request.getParameter("xyfx"));
		item.setSbdw(request.getParameter("sbdw"));
		item.setLxr(request.getParameter("lxr"));
		item.setLxdh(request.getParameter("lxdh"));
		item.setChdw(request.getParameter("chdw"));
		item.setLxr1(request.getParameter("lxr1"));
		item.setLxdh1(request.getParameter("lxdh1"));
		item.setBgs(request.getParameter("bgs"));
		item.setLb1(request.getParameter("lb1"));
		item.setLb2(request.getParameter("lb2"));
		
		item.setDzyx(request.getParameter("dzyx"));
		item.setDzyx1(request.getParameter("dzyx1"));
		item.setDzyx2(request.getParameter("dzyx2"));
		item.setZzdj(request.getParameter("zzdj"));
		item.setCbdw(request.getParameter("cbdw"));
		item.setLxr2(request.getParameter("lxr2"));
		item.setLxdh2(request.getParameter("lxdh2"));
		item.setHzfs(request.getParameter("hzfs"));
		item.setLygc(request.getParameter("lygc"));
		item.setJstj(request.getParameter("jstj"));
		item.setJsjjzb(request.getParameter("jsjjzb"));
		item.setTjzk(request.getParameter("tjzk"));
		item.setZt("δ�ϱ�");
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("bssj"));
			item.setBssj(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		item.setSbyh(request.getSession().getAttribute("yhm").toString());
		CbxmDao.add(item);
	
		request.setAttribute("dqlist", CbxmDao.getDqList());
		request.setAttribute("lblist", CbxmDao.getLbList());
		request.setAttribute("status", "ok");
		request.getRequestDispatcher("xmlr.jsp").forward(request, response);
	}
	
	
	/**
	 * �����¼��ҳ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toSiderAddPage(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
		request.setAttribute("dqlist", CbxmDao.getDqList());
		request.setAttribute("lblist", CbxmDao.getLbList());
		request.getRequestDispatcher("xmlr.jsp").forward(request, response);
	}

	
	
	/**
	 * ��ת�����ҳ��
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
	 * �����б���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void update(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		ProCbxm item = new ProCbxm();
		
		item.setId(Long.valueOf(request.getParameter("id")));
	    item.setNd(Long.valueOf(request.getParameter("nd")));
		item.setBh(request.getParameter("bh"));
		item.setMc(request.getParameter("mc"));
		item.setDq(request.getParameter("dq"));
		item.setJsgm(request.getParameter("jsgm"));
		item.setJsdd(request.getParameter("jsdd"));
		item.setZtz(Double.valueOf(request.getParameter("ztz")));
		item.setXyfx(request.getParameter("xyfx"));
		item.setSbdw(request.getParameter("sbdw"));
		item.setLxr(request.getParameter("lxr"));
		item.setLxdh(request.getParameter("lxdh"));
		item.setChdw(request.getParameter("chdw"));
		item.setLxr1(request.getParameter("lxr1"));
		item.setLxdh1(request.getParameter("lxdh1"));
		item.setBgs(request.getParameter("bgs"));
        
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("bssj"));
			item.setBssj(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
		item.setLb1(request.getParameter("lb1"));
		item.setLb2(request.getParameter("lb2"));
		
		CbxmDao.update(item);	
			
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideEditFrame();</script>"); 
		out.flush();
	}
	
	/**
	 * ��ת���༭ҳ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goSkipPage(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		long id   = Long.valueOf(request.getParameter("id"));
	
		ProCbxm item = CbxmDao.getObjById(id);
		
		request.setAttribute("item", item);
		request.getRequestDispatcher("ll.jsp").forward(request, response);
	}
	
	/**
	 * ��ת���༭ҳ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goEditPage(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		long id   = Long.valueOf(request.getParameter("id"));
	
		ProCbxm item = CbxmDao.getObjById(id);
		
		request.setAttribute("item", item);
		request.setAttribute("dqlist", CbxmDao.getDqList());
		request.setAttribute("lblist", CbxmDao.getLbList());
		request.getRequestDispatcher("xg.jsp").forward(request, response);
	}
	
	/**
	 * �������
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void add(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		ProCbxm item = new ProCbxm();
	
		item.setNd(Long.valueOf(request.getParameter("nd")));
		item.setBh(request.getParameter("bh"));
		item.setMc(request.getParameter("mc"));
		item.setDq(request.getParameter("dq"));
		item.setJsgm(request.getParameter("jsgm"));
		item.setJsdd(request.getParameter("jsdd"));
		
		if(request.getParameter("ztz") == null || request.getParameter("ztz").equals("")){
			item.setZtz((double) 0l);
		}else{
			item.setZtz(Double.valueOf(request.getParameter("ztz")));
		}

		item.setXyfx(request.getParameter("xyfx"));
		item.setSbdw(request.getParameter("sbdw"));
		item.setLxr(request.getParameter("lxr"));
		item.setLxdh(request.getParameter("lxdh"));
		item.setChdw(request.getParameter("chdw"));
		item.setLxr1(request.getParameter("lxr1"));
		item.setLxdh1(request.getParameter("lxdh1"));
		item.setBgs(request.getParameter("bgs"));
		item.setLb1(request.getParameter("lb1"));
		item.setLb2(request.getParameter("lb2"));
		
		item.setShyj(request.getParameter("shyj"));
		
		item.setZt("���ϱ�");
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("bssj"));
			item.setBssj(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		

		CbxmDao.add(item);
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideAddFrame();</script>"); 
		out.flush();
	}
	
	
	/**
	 * ��ת�����ҳ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goAddPage(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		request.setAttribute("dqlist", CbxmDao.getDqList());
		request.setAttribute("lblist", CbxmDao.getLbList());
		request.getRequestDispatcher("lr.jsp").forward(request, response);
	}
	
	/**
	 * �û��ϱ�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void commit(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		String id = request.getParameter("id");
		if(CbxmDao.commit(id)){
			//TODO Ӧ����������ͨ�û�Ӧ��ajax���͵�ɾ����ʡ����  ��̨�û�Ҳֱ�Ӽ�¼ҳ��λ��
			postList(request, response);
		}else{
			//��λ������ҳ��
		}	
	}
	
	/**
	 * ɾ���б���  ������post����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delItems(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		String[] itemList = {"id"};
		itemList[0] = request.getParameter("id");
		if(CbxmDao.delItemList(itemList)){
			//TODO Ӧ����������ͨ�û�Ӧ��ajax���͵�ɾ����ʡ����  ��̨�û�Ҳֱ�Ӽ�¼ҳ��λ��
			postList(request, response);
		}else{
			//��λ������ҳ��
		}	
	}
	
	/**
	 * get��������б�
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
		String sbyh = request.getSession().getAttribute("yhm").toString();
		Pager pager = CbxmSbyhDao.getObjForPage(pageNo, pageSize, searchStr, sbyh);
		
		request.setAttribute("pager", pager);
		request.setAttribute("searchStr", searchStr);
		request.getRequestDispatcher("gl.jsp").forward(request, response);
		
	}
	
	
	/**
	 * post��������б�
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
		String sbyh = request.getSession().getAttribute("yhm").toString();
		Pager pager = CbxmSbyhDao.getObjForPage(pageNo, pageSize, searchStr, sbyh);
	
		request.setAttribute("pager", pager);
		request.setAttribute("searchStr", searchStr);
	
		request.getRequestDispatcher("gl.jsp").forward(request, response);
	}
	


}
