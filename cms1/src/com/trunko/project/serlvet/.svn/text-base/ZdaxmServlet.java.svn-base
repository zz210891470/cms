package com.trunko.project.serlvet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.util.FavoritesHelper;
import com.trunko.cms.util.Pager;
import com.trunko.project.dao.ZdaxmDao;
import com.trunko.project.entity.ProZdaxm;
import com.trunko.project.vo.FjFlInfo;

public class ZdaxmServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		String action=request.getParameter("action");
		   
	    if(action.equals("list")){//显示列表
		    getList(request, response);
	    }
	    else if(action.equals("toAdd")){//跳转到添加页面
		    goAddPage(request, response);
	    }
	    else if(action.equals("sideradd")){//侧边栏录入页面
		    toSiderAddPage(request, response);
	    }
	    else if(action.equals("toEdit")){//跳转到编辑页面
		    goEditPage(request, response);
	    }
	    else if(action.equals("toRead")){//跳转到明细页面
		    goReadPage(request, response);
	    }
	    else if(action.equals("audit")){
	    	getAudit(request,response);
	    }
	    else if(action.equals("toAudit")){//审核页面
	    	goAuditPage(request,response);
	    }
	    else if(action.equals("shtg")){//审核通过
	    	shtg(request,response);
	    }
	    else if(action.equals("thsq")){//退回申请
	    	thsq(request,response);
	    }
	    else if(action.equals("xxhz")){   //信息汇总	
	    	Xxhz(request,response);
	    }
	    else if(action.equals("xxhzpage")){   //信息汇总 页面
	    	toXxhzPage(request,response);
	    }
	    else if(action.equals("toImport")){//跳转至导入页面
		    toImportPage(request, response);
	    }
	    else if(action.equals("xxflhzpage")){   //信息汇总 页面
	    	toFlhzPage(request,response);
	    }
	    else if(action.equals("fjhzpage")){   //信息分类汇总 页面
	    	toFjhzPage(request,response);
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
	    else if(action.equals("sideradd")){//侧边栏录入页面
		    toSiderAddPage(request, response);
	    }	    
	    else if(action.equals("sadd")){//侧边栏录入页面
		    sadd(request, response);
	    }
	    else if(action.equals("toRead")){//跳转到明细页面
		    goReadPage(request, response);
	    }
	    else if(action.equals("toEdit")){//跳转到编辑页面
		    goEditPage(request, response);
	    }
	    else if(action.equals("update")){//修改列表项
		    update(request, response);
	    }
	    else if(action.equals("audit")){ // 跳转至审核列表
	    	getAudit(request,response);
	    }
	    else if(action.equals("toAudit")){//审核页面
	    	goAuditPage(request,response);
	    }
	    else if(action.equals("shtg")){//审核通过
	    	shtg(request,response);
	    }
	    else if(action.equals("thsq")){//退回申请
	    	thsq(request,response);
	    }
	    else if(action.equals("xxhz")){   //信息汇总	
	    	Xxhz(request,response);
	    }
	    else if(action.equals("xxhzpage")){   //信息汇总 页面
	    	toXxhzPage(request,response);
	    }
	    else if(action.equals("flhzpage")){   //信息分类汇总 页面
	    	toFlhzPage(request,response);
	    }
	    else if(action.equals("fjhzpage")){   //信息分类汇总 页面
	    	toFjhzPage(request,response);
	    }
	    else if(action.equals("getXxfjhzInfo")){   //ajax信息分级汇总数据
	    	getXxfjhzInfo(request,response);
	    }
	    else if(action.equals("getXxflhzInfo")){   //ajax信息分级汇总数据
	    	getXxflhzInfo(request,response);
	    }
	}
	
	/**
	 * ajax获取信息分级汇总数据 add by lhanliang
	 * @param request 请求
	 * @param response 响应
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getXxflhzInfo(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String year = request.getParameter("year");  // 年度
		String fromMonth =	request.getParameter("fromMonth");  // 开始月份
		String toMonth = request.getParameter("toMonth");  // 结束月份
		
        List<FjFlInfo> infoList  = ZdaxmDao.getFlInfoList(year, fromMonth, toMonth);
        String data = "";
      //得到类别列表
		List<String> lb1list  =  ZdaxmDao.getLb1List();
		
		for(int i = 0; i<lb1list.size(); i++){		
			//循环查找列表中相应地区的数据

			//如果列表的长度为0输出
			if(infoList.size() ==0){
				
				data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert(lb1list.get(i))+"\"></td>" +
						"<td align=\"center\">0</td><td align=\"right\">0</td>" +
						"<td align=\"right\">0</td><td align=\"right\">0</td>"
			           +"<td align=\"right\">0</td></tr>";
			}
			 
			//标志位是否已经匹配相应地区输出
			int Flag = 0;
			for(int j=0; j<infoList.size() && Flag == 0 ;j++){
				
				if(j==(infoList.size()-1) && Flag == 0  && !lb1list.get(i).equals(infoList.get(j).getDq())){
					
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert(lb1list.get(i))+"\"></td>" +
							"<td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
				           +"<td align=\"right\">0</td></tr>";
				}
				
				if(lb1list.get(i).equals(infoList.get(j).getDq())){
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert(lb1list.get(i))+"\"></td><td align=\"center\">"+infoList.get(j).getPnum()+"</td><td align=\"right\">"+infoList.get(j).getZtz()
				      +"</td><td align=\"right\">"+infoList.get(j).getJhtz()+"</td><td align=\"right\">"+infoList.get(j).getNczbywc()+"</td>"
				      +"<td align=\"right\">"+getForThree(infoList.get(j).getWcbl().toString())+"</td></tr>";
					Flag = 1;
				}
				
				
			}
	
		}
        PrintWriter out = response.getWriter();
        response.setContentType("application/json; charset=utf-8");  
		out.write(data);
		out.close();
		
	}
	
	
	/**
	 * ajax获取信息分级汇总数据 add by lhanliang
	 * @param request 请求
	 * @param response 响应
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getXxfjhzInfo(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // 年度
		String fromMonth =	request.getParameter("fromMonth");  // 开始月份
		String toMonth = request.getParameter("toMonth");  // 结束月份
		
        List<FjFlInfo> infoList  = ZdaxmDao.getFjInfoList(year, fromMonth, toMonth);
        String data = "";
      //得到类别列表
		List<String> dqlist  =  ZdaxmDao.getDq1List();
		
		for(int i = 0; i<dqlist.size(); i++){		
			//循环查找列表中相应地区的数据

			//如果列表的长度为0输出
			if(infoList.size() ==0){
				
				data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert(dqlist.get(i))+"\"></td>" +
						"<td align=\"center\">0</td><td align=\"right\">0</td>" +
						"<td align=\"right\">0</td><td align=\"right\">0</td>"
			           +"<td align=\"right\">0</td></tr>";
			}
			 
			//标志位是否已经匹配相应地区输出
			int Flag = 0;
			for(int j=0; j<infoList.size() && Flag == 0 ;j++){
				
				if(j==(infoList.size()-1) && Flag == 0  && !dqlist.get(i).equals(infoList.get(j).getDq())){
					
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert(dqlist.get(i))+"\"></td>" +
							"<td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
				           +"<td align=\"right\">0</td></tr>";
				}
				
				if(dqlist.get(i).equals(infoList.get(j).getDq())){
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert(dqlist.get(i))+"\"></td><td align=\"center\">"+infoList.get(j).getPnum()+"</td><td align=\"right\">"+infoList.get(j).getZtz()
				      +"</td><td align=\"right\">"+infoList.get(j).getJhtz()+"</td><td align=\"right\">"+infoList.get(j).getNczbywc()+"</td>"
				      +"<td align=\"right\">"+getForThree(infoList.get(j).getWcbl().toString())+"</td></tr>";
					Flag = 1;
				}
				
				
			}
	
		}
        PrintWriter out = response.getWriter();
        response.setContentType("application/json; charset=utf-8");  
		out.write(data);
		out.close();
	}
	
	
	private static String getForThree(String str){
		
		if(str.length()>3){
			return str.substring(0,4);	
		}else{
			return str;
		}
	}
	
	
	
	/**
	* 将字符串转成unicode
	* @param str 待转字符串
	* @return unicode字符串
	*/ 
	public String convert(String str)
	{
		str = (str == null ? "" : str);
		String tmp;
		StringBuffer sb = new StringBuffer(1000);
		char c;
		int i, j;
		sb.setLength(0);
		for (i = 0; i < str.length(); i++)
		{
		c = str.charAt(i);
		sb.append("\\u");
		j = (c >>>8); //取出高8位
		tmp = Integer.toHexString(j);
		if (tmp.length() == 1)
		sb.append("0");
		sb.append(tmp);
		j = (c & 0xFF); //取出低8位
		tmp = Integer.toHexString(j);
		if (tmp.length() == 1)
		sb.append("0");
		sb.append(tmp);
	
		}
		return (new String(sb));
	}
	
	
	
	/**
	 * 信息分级汇总 add by lhanliang
	 * @param request 请求
	 * @param response 响应
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toFjhzPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // 年度
		String fromMonth =	request.getParameter("fromMonth");  // 开始月份
		String toMonth = request.getParameter("toMonth");  // 结束月份

        request.setAttribute("year", year);
        request.setAttribute("fromMonth", fromMonth);
        request.setAttribute("toMonth", toMonth);
        

		
		// 跳转至信息分类统计页面，展示信息
		request.getRequestDispatcher("tj_fj.jsp").forward(request, response);
	}
	
	
	/**
	 * 信息分级汇总 add by lhanliang
	 * @param request 请求
	 * @param response 响应
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toFlhzPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // 年度
		String fromMonth =	request.getParameter("fromMonth");  // 开始月份
		String toMonth = request.getParameter("toMonth");  // 结束月份

        request.setAttribute("year", year);
        request.setAttribute("fromMonth", fromMonth);
        request.setAttribute("toMonth", toMonth);
        
        List<FjFlInfo> infoList  = ZdaxmDao.getFlInfoList(year, fromMonth, toMonth);
        
        request.setAttribute("infoList", infoList);
		
		// 跳转至信息分类统计页面，展示信息
		request.getRequestDispatcher("tj_fl.jsp").forward(request, response);
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
		
	    // 获取项目信息
	    List<ProZdaxm> itemList =   ZdaxmDao.showXxhzList(nd, lb1, lb2, dq, ztz1, ztz1num , ztz2, ztz2num);
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
	
		request.setAttribute("dqlist", ZdaxmDao.getDqList());
		request.setAttribute("lblist", ZdaxmDao.getLbList());
		request.getRequestDispatcher("tj_xx_page.jsp").forward(request, response);

    }
	/**
	 * 跳转到审核页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goAuditPage(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		long id   = Long.valueOf(request.getParameter("id")); // 信息主键
		ProZdaxm item = ZdaxmDao.getObjById(id); // 信息对象
		request.setAttribute("item", item);
		request.getRequestDispatcher("xmll.jsp").forward(request, response);
	}
	
	/**
	 * 退回申请
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void thsq(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		String id = request.getParameter("id");  // 项目主键
		String shyj = request.getParameter("shyj");  // 审核意见
		ZdaxmDao.audit(id,"已退回",shyj); // 修改项目状态和审核意见
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideEditFrame();</script>"); 
		out.flush();
	}
	
	/**
	 * 审核通过
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void shtg(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		String id = request.getParameter("id");  // 项目主键
		String shyj = request.getParameter("shyj");  // 审核意见
		ZdaxmDao.audit(id,"已审核",shyj); // 修改项目状态和审核意见
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideEditFrame();</script>"); 
		out.flush();
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
		
		ProZdaxm item = new ProZdaxm();
		
		item.setId(FavoritesHelper.stringTolong(request.getParameter("id")));
		item.setNd(FavoritesHelper.stringTolong(request.getParameter("nd")));
		item.setBh(request.getParameter("bh"));
		item.setMc(request.getParameter("mc"));
		item.setDq(request.getParameter("dq"));
		item.setJsgm(request.getParameter("jsgm"));
		item.setJsdd(request.getParameter("jsdd"));
		item.setZtz(FavoritesHelper.stringTolong(request.getParameter("ztz")));
		item.setYd(FavoritesHelper.stringTofloat(request.getParameter("yd")));
		item.setLd(FavoritesHelper.stringTofloat(request.getParameter("ld")));
		item.setLb1(request.getParameter("lb1"));
		item.setLb2(request.getParameter("lb2"));
		item.setLb3(request.getParameter("lb3"));
		item.setJsdq(request.getParameter("jsdq"));
		item.setBawh(request.getParameter("bawh"));
		item.setJsnx1(FavoritesHelper.stringToint(request.getParameter("jsnx1")));
		item.setJsnx2(FavoritesHelper.stringToint(request.getParameter("jsnx2")));
		item.setJhtz(FavoritesHelper.stringTolong(request.getParameter("jhtz")));
		item.setJdmb(request.getParameter("jdmb"));
		item.setKgn(request.getParameter("kgn"));
		item.setKgy(request.getParameter("kgy"));
		item.setJgn(request.getParameter("jgn"));
		item.setJgy(request.getParameter("jgy"));
		item.setWctz(FavoritesHelper.stringTolong(request.getParameter("wctz")));
		// 更新对象
		ZdaxmDao.update(item);	
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
		ProZdaxm item = ZdaxmDao.getObjById(id);
		request.setAttribute("dqlist", ZdaxmDao.getDqList());
		request.setAttribute("lblist", ZdaxmDao.getLbList());
		request.setAttribute("item", item);
		request.getRequestDispatcher("xg.jsp").forward(request, response);
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
		
		ProZdaxm item = new ProZdaxm();
	
		item.setNd(FavoritesHelper.stringTolong(request.getParameter("nd")));
		item.setBh(request.getParameter("bh"));
		item.setMc(request.getParameter("mc"));
		item.setDq(request.getParameter("dq"));
		item.setJsgm(request.getParameter("jsgm"));
		item.setJsdd(request.getParameter("jsdd"));
		item.setZtz(FavoritesHelper.stringTolong(request.getParameter("ztz")));
		item.setYd(FavoritesHelper.stringTofloat(request.getParameter("yd")));
		item.setLd(FavoritesHelper.stringTofloat(request.getParameter("ld")));
		item.setLb1(request.getParameter("lb1"));
		item.setLb2(request.getParameter("lb2"));
		item.setLb3(request.getParameter("lb3"));
		item.setJsdq(request.getParameter("jsdq"));
		item.setBawh(request.getParameter("bawh"));
		item.setJsnx1(FavoritesHelper.stringToint(request.getParameter("jsnx1")));
		item.setJsnx2(FavoritesHelper.stringToint(request.getParameter("jsnx2")));
		item.setJhtz(FavoritesHelper.stringTolong(request.getParameter("jhtz")));
		item.setJdmb(request.getParameter("jdmb"));
		item.setKgn(request.getParameter("kgn"));
		item.setKgy(request.getParameter("kgy"));
		item.setJgn(request.getParameter("jgn"));
		item.setJgy(request.getParameter("jgy"));
		item.setWctz(FavoritesHelper.stringTolong(request.getParameter("wctz")));
		item.setZt("已审核");
		item.setSbyh(request.getSession().getAttribute("yhm").toString());
		ZdaxmDao.add(item);
	
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideAddFrame();</script>"); 
		out.flush();
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
		
		ProZdaxm item = new ProZdaxm();
	
		item.setNd(FavoritesHelper.stringTolong(request.getParameter("nd")));
		item.setBh(request.getParameter("bh"));
		item.setMc(request.getParameter("mc"));
		item.setDq(request.getParameter("dq"));
		item.setJsgm(request.getParameter("jsgm"));
		item.setJsdd(request.getParameter("jsdd"));
		item.setZtz(FavoritesHelper.stringTolong(request.getParameter("ztz")));
		item.setYd(FavoritesHelper.stringTofloat(request.getParameter("yd")));
		item.setLd(FavoritesHelper.stringTofloat(request.getParameter("ld")));
		item.setLb1(request.getParameter("lb1"));
		item.setLb2(request.getParameter("lb2"));
		item.setLb3(request.getParameter("lb3"));
		item.setJsdq(request.getParameter("jsdq"));
		item.setBawh(request.getParameter("bawh"));
		item.setJsnx1(FavoritesHelper.stringToint(request.getParameter("jsnx1")));
		item.setJsnx2(FavoritesHelper.stringToint(request.getParameter("jsnx2")));
		item.setJhtz(FavoritesHelper.stringTolong(request.getParameter("jhtz")));
		item.setJdmb(request.getParameter("jdmb"));
		item.setKgn(request.getParameter("kgn"));
		item.setKgy(request.getParameter("kgy"));
		item.setJgn(request.getParameter("jgn"));
		item.setJgy(request.getParameter("jgy"));
		item.setWctz(FavoritesHelper.stringTolong(request.getParameter("wctz")));
		item.setZt("已审核");
		item.setSbyh(request.getSession().getAttribute("yhm").toString());
		// 新增对象
		ZdaxmDao.add(item);
		request.setAttribute("dqlist", ZdaxmDao.getDqList());
		request.setAttribute("lblist", ZdaxmDao.getLbList());
		request.setAttribute("status", "ok");
		request.getRequestDispatcher("add.jsp").forward(request, response);
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
		
		request.setAttribute("dqlist", ZdaxmDao.getDqList());
		request.setAttribute("lblist", ZdaxmDao.getLbList());
		request.getRequestDispatcher("lr.jsp").forward(request, response);
	}
	
	/**
	 * 跳转到添加页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toSiderAddPage(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		request.setAttribute("dqlist", ZdaxmDao.getDqList());
		request.setAttribute("lblist", ZdaxmDao.getLbList());
		request.getRequestDispatcher("add.jsp").forward(request, response);
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
		 	
		if(ZdaxmDao.delItemList(itemList)){
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
		Pager pager = ZdaxmDao.getObjForPage(pageNo, pageSize,searchStr);
	
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
		Pager pager = ZdaxmDao.getObjForPage(pageNo, pageSize, searchStr);
	
		request.setAttribute("pager", pager);
		request.setAttribute("searchStr", searchStr);
	
		request.getRequestDispatcher("gl.jsp").forward(request, response);
		
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

		ProZdaxm item = ZdaxmDao.getObjById(id);
		
		request.setAttribute("item", item);

		request.getRequestDispatcher("ll.jsp").forward(request, response);
	}
	
	/**
	 * get请求加载列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getAudit(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
	
		Integer  pageNo   = 1;
		Integer  pageSize = 10;
	    String searchStr = request.getParameter("searchStr");
		Pager pager = ZdaxmDao.getObjForAudit(pageNo, pageSize,searchStr);
	
		request.setAttribute("pager", pager);
		request.setAttribute("searchStr", searchStr);
		

		request.getRequestDispatcher("sh.jsp").forward(request, response);

	}

}
