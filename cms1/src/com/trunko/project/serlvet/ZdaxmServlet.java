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
		   
	    if(action.equals("list")){//��ʾ�б�
		    getList(request, response);
	    }
	    else if(action.equals("toAdd")){//��ת�����ҳ��
		    goAddPage(request, response);
	    }
	    else if(action.equals("sideradd")){//�����¼��ҳ��
		    toSiderAddPage(request, response);
	    }
	    else if(action.equals("toEdit")){//��ת���༭ҳ��
		    goEditPage(request, response);
	    }
	    else if(action.equals("toRead")){//��ת����ϸҳ��
		    goReadPage(request, response);
	    }
	    else if(action.equals("audit")){
	    	getAudit(request,response);
	    }
	    else if(action.equals("toAudit")){//���ҳ��
	    	goAuditPage(request,response);
	    }
	    else if(action.equals("shtg")){//���ͨ��
	    	shtg(request,response);
	    }
	    else if(action.equals("thsq")){//�˻�����
	    	thsq(request,response);
	    }
	    else if(action.equals("xxhz")){   //��Ϣ����	
	    	Xxhz(request,response);
	    }
	    else if(action.equals("xxhzpage")){   //��Ϣ���� ҳ��
	    	toXxhzPage(request,response);
	    }
	    else if(action.equals("toImport")){//��ת������ҳ��
		    toImportPage(request, response);
	    }
	    else if(action.equals("xxflhzpage")){   //��Ϣ���� ҳ��
	    	toFlhzPage(request,response);
	    }
	    else if(action.equals("fjhzpage")){   //��Ϣ������� ҳ��
	    	toFjhzPage(request,response);
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
	    else if(action.equals("sideradd")){//�����¼��ҳ��
		    toSiderAddPage(request, response);
	    }	    
	    else if(action.equals("sadd")){//�����¼��ҳ��
		    sadd(request, response);
	    }
	    else if(action.equals("toRead")){//��ת����ϸҳ��
		    goReadPage(request, response);
	    }
	    else if(action.equals("toEdit")){//��ת���༭ҳ��
		    goEditPage(request, response);
	    }
	    else if(action.equals("update")){//�޸��б���
		    update(request, response);
	    }
	    else if(action.equals("audit")){ // ��ת������б�
	    	getAudit(request,response);
	    }
	    else if(action.equals("toAudit")){//���ҳ��
	    	goAuditPage(request,response);
	    }
	    else if(action.equals("shtg")){//���ͨ��
	    	shtg(request,response);
	    }
	    else if(action.equals("thsq")){//�˻�����
	    	thsq(request,response);
	    }
	    else if(action.equals("xxhz")){   //��Ϣ����	
	    	Xxhz(request,response);
	    }
	    else if(action.equals("xxhzpage")){   //��Ϣ���� ҳ��
	    	toXxhzPage(request,response);
	    }
	    else if(action.equals("flhzpage")){   //��Ϣ������� ҳ��
	    	toFlhzPage(request,response);
	    }
	    else if(action.equals("fjhzpage")){   //��Ϣ������� ҳ��
	    	toFjhzPage(request,response);
	    }
	    else if(action.equals("getXxfjhzInfo")){   //ajax��Ϣ�ּ���������
	    	getXxfjhzInfo(request,response);
	    }
	    else if(action.equals("getXxflhzInfo")){   //ajax��Ϣ�ּ���������
	    	getXxflhzInfo(request,response);
	    }
	}
	
	/**
	 * ajax��ȡ��Ϣ�ּ��������� add by lhanliang
	 * @param request ����
	 * @param response ��Ӧ
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getXxflhzInfo(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String year = request.getParameter("year");  // ���
		String fromMonth =	request.getParameter("fromMonth");  // ��ʼ�·�
		String toMonth = request.getParameter("toMonth");  // �����·�
		
        List<FjFlInfo> infoList  = ZdaxmDao.getFlInfoList(year, fromMonth, toMonth);
        String data = "";
      //�õ�����б�
		List<String> lb1list  =  ZdaxmDao.getLb1List();
		
		for(int i = 0; i<lb1list.size(); i++){		
			//ѭ�������б�����Ӧ����������

			//����б�ĳ���Ϊ0���
			if(infoList.size() ==0){
				
				data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert(lb1list.get(i))+"\"></td>" +
						"<td align=\"center\">0</td><td align=\"right\">0</td>" +
						"<td align=\"right\">0</td><td align=\"right\">0</td>"
			           +"<td align=\"right\">0</td></tr>";
			}
			 
			//��־λ�Ƿ��Ѿ�ƥ����Ӧ�������
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
	 * ajax��ȡ��Ϣ�ּ��������� add by lhanliang
	 * @param request ����
	 * @param response ��Ӧ
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getXxfjhzInfo(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // ���
		String fromMonth =	request.getParameter("fromMonth");  // ��ʼ�·�
		String toMonth = request.getParameter("toMonth");  // �����·�
		
        List<FjFlInfo> infoList  = ZdaxmDao.getFjInfoList(year, fromMonth, toMonth);
        String data = "";
      //�õ�����б�
		List<String> dqlist  =  ZdaxmDao.getDq1List();
		
		for(int i = 0; i<dqlist.size(); i++){		
			//ѭ�������б�����Ӧ����������

			//����б�ĳ���Ϊ0���
			if(infoList.size() ==0){
				
				data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert(dqlist.get(i))+"\"></td>" +
						"<td align=\"center\">0</td><td align=\"right\">0</td>" +
						"<td align=\"right\">0</td><td align=\"right\">0</td>"
			           +"<td align=\"right\">0</td></tr>";
			}
			 
			//��־λ�Ƿ��Ѿ�ƥ����Ӧ�������
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
	* ���ַ���ת��unicode
	* @param str ��ת�ַ���
	* @return unicode�ַ���
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
		j = (c >>>8); //ȡ����8λ
		tmp = Integer.toHexString(j);
		if (tmp.length() == 1)
		sb.append("0");
		sb.append(tmp);
		j = (c & 0xFF); //ȡ����8λ
		tmp = Integer.toHexString(j);
		if (tmp.length() == 1)
		sb.append("0");
		sb.append(tmp);
	
		}
		return (new String(sb));
	}
	
	
	
	/**
	 * ��Ϣ�ּ����� add by lhanliang
	 * @param request ����
	 * @param response ��Ӧ
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toFjhzPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // ���
		String fromMonth =	request.getParameter("fromMonth");  // ��ʼ�·�
		String toMonth = request.getParameter("toMonth");  // �����·�

        request.setAttribute("year", year);
        request.setAttribute("fromMonth", fromMonth);
        request.setAttribute("toMonth", toMonth);
        

		
		// ��ת����Ϣ����ͳ��ҳ�棬չʾ��Ϣ
		request.getRequestDispatcher("tj_fj.jsp").forward(request, response);
	}
	
	
	/**
	 * ��Ϣ�ּ����� add by lhanliang
	 * @param request ����
	 * @param response ��Ӧ
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toFlhzPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // ���
		String fromMonth =	request.getParameter("fromMonth");  // ��ʼ�·�
		String toMonth = request.getParameter("toMonth");  // �����·�

        request.setAttribute("year", year);
        request.setAttribute("fromMonth", fromMonth);
        request.setAttribute("toMonth", toMonth);
        
        List<FjFlInfo> infoList  = ZdaxmDao.getFlInfoList(year, fromMonth, toMonth);
        
        request.setAttribute("infoList", infoList);
		
		// ��ת����Ϣ����ͳ��ҳ�棬չʾ��Ϣ
		request.getRequestDispatcher("tj_fl.jsp").forward(request, response);
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
	 * ��Ŀ��Ϣ����
	 * @param request  ����
	 * @param response ��Ӧ
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toXxhzPage(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
	
	    String nd =	request.getParameter("nd");  // ���
	    String lb1 = request.getParameter("lb1");// ��𣺴���
	    String lb2 = request.getParameter("lb2");// ���С��
	    String dq = request.getParameter("dq");// ��������
	    
	    String ztz1 = request.getParameter("ztz1");// �жϷ���ȫ�������ڵ��ڡ����ڣ�
	    String ztz1num = request.getParameter("ztz2");// ��ֵ1
	    String ztz2 = request.getParameter("ztz3");// �жϷ���ȫ����С�ڣ�
	    String ztz2num = request.getParameter("ztz4");// ��ֵ2
		
	    // ��ȡ��Ŀ��Ϣ
	    List<ProZdaxm> itemList =   ZdaxmDao.showXxhzList(nd, lb1, lb2, dq, ztz1, ztz1num , ztz2, ztz2num);
	    request.setAttribute("itemList", itemList);
		// ��ת����Ϣ����չʾ����
		request.getRequestDispatcher("tj_xx.jsp").forward(request, response);
    }

	
	
	/**
	 * ��Ϣ����
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
	 * ��ת�����ҳ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goAuditPage(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		long id   = Long.valueOf(request.getParameter("id")); // ��Ϣ����
		ProZdaxm item = ZdaxmDao.getObjById(id); // ��Ϣ����
		request.setAttribute("item", item);
		request.getRequestDispatcher("xmll.jsp").forward(request, response);
	}
	
	/**
	 * �˻�����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void thsq(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		String id = request.getParameter("id");  // ��Ŀ����
		String shyj = request.getParameter("shyj");  // ������
		ZdaxmDao.audit(id,"���˻�",shyj); // �޸���Ŀ״̬��������
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideEditFrame();</script>"); 
		out.flush();
	}
	
	/**
	 * ���ͨ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void shtg(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		String id = request.getParameter("id");  // ��Ŀ����
		String shyj = request.getParameter("shyj");  // ������
		ZdaxmDao.audit(id,"�����",shyj); // �޸���Ŀ״̬��������
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideEditFrame();</script>"); 
		out.flush();
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
		// ���¶���
		ZdaxmDao.update(item);	
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
	 * �������
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
		item.setZt("�����");
		item.setSbyh(request.getSession().getAttribute("yhm").toString());
		ZdaxmDao.add(item);
	
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideAddFrame();</script>"); 
		out.flush();
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
		item.setZt("�����");
		item.setSbyh(request.getSession().getAttribute("yhm").toString());
		// ��������
		ZdaxmDao.add(item);
		request.setAttribute("dqlist", ZdaxmDao.getDqList());
		request.setAttribute("lblist", ZdaxmDao.getLbList());
		request.setAttribute("status", "ok");
		request.getRequestDispatcher("add.jsp").forward(request, response);
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
		
		request.setAttribute("dqlist", ZdaxmDao.getDqList());
		request.setAttribute("lblist", ZdaxmDao.getLbList());
		request.getRequestDispatcher("lr.jsp").forward(request, response);
	}
	
	/**
	 * ��ת�����ҳ��
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
	 * ɾ���б���  ������post����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delItems(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		String[] itemList = request.getParameterValues("itemList");
		 	
		if(ZdaxmDao.delItemList(itemList)){
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
		Pager pager = ZdaxmDao.getObjForPage(pageNo, pageSize,searchStr);
	
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
		Pager pager = ZdaxmDao.getObjForPage(pageNo, pageSize, searchStr);
	
		request.setAttribute("pager", pager);
		request.setAttribute("searchStr", searchStr);
	
		request.getRequestDispatcher("gl.jsp").forward(request, response);
		
	}
	
	/**
	 * ��ת���༭ҳ��
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
	 * get��������б�
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
