package com.trunko.cms.servlet.sysconfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.dao.sysconfig.AdmanageDao;
import com.trunko.cms.entity.WebAdvert;


public class AdManageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

       doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act =request.getParameter("act");

		if(act.equals("showpage")){
			showPage(request, response);		
		}else if(act.equals("update")){
			update(request, response);
		}
		
	}

	
	private void showPage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		
		AdmanageDao admanageDao=new AdmanageDao();
		List<WebAdvert> webAdverts=admanageDao.getAllAdvert();
	    WebAdvert one=webAdverts.get(0);
	    WebAdvert two=webAdverts.get(1);
	    WebAdvert three=webAdverts.get(2);
	    WebAdvert four=webAdverts.get(3);
	    WebAdvert five=webAdverts.get(4);
	    WebAdvert six =webAdverts.get(5); 
	   
	    
	    request.setAttribute("one", one);
	    request.setAttribute("two", two);
	    request.setAttribute("three", three);
		request.setAttribute("four", four);
		request.setAttribute("five", five);
		request.setAttribute("six", six);
		request.getRequestDispatcher("admanage.jsp").forward(request, response);

	}
	
	
	private void update(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		String onestatus = request.getParameter("onestatus");
		String twostatus = request.getParameter("twostatus");
		String threestatus = request.getParameter("threestatus");
		String fourstatus =request.getParameter("fourstatus");
		String fivestatus = request.getParameter("fivestatus");
		String sixstatus =request.getParameter("sixstatus");

		if(onestatus==null){
			onestatus="0";
		}
		if(twostatus==null){
			twostatus="0";
		}
		if(threestatus==null){
			threestatus="0";
		}
		if(fourstatus==null){
			fourstatus="0";
		}
		if(fivestatus==null){
			fivestatus="0";
		}
		if(sixstatus==null){
			sixstatus="0";
		}
		
		String oneimgurl= request.getParameter("oneimgurl");
		String twoimgurl= request.getParameter("twoimgurl");
		String threeimgurl= request.getParameter("threeimgurl");
		String fourimgurl= request.getParameter("fourimgurl");
		String fiveimgurl= request.getParameter("fiveimgurl");
		String siximgurl= request.getParameter("siximgurl");
		
		String oneurl= request.getParameter("oneurl");
		String twourl= request.getParameter("twourl");
		String threeurl= request.getParameter("threeurl");
		String foururl= request.getParameter("foururl");
		String fiveurl= request.getParameter("fiveurl");
		String sixurl= request.getParameter("sixurl");
		
		if(oneurl==null){
			oneurl="";
		}
		if(twourl==null){
			twourl="";
		}
		if(threeurl==null){
			threeurl="";
		}
		if(foururl==null){
			foururl="";
		}
		if(fiveurl==null){
			fiveurl="";
		}
		if(sixurl==null){
			sixurl="";
		}
		
		String oneid =request.getParameter("oneid");
		String twoid =request.getParameter("twoid");
		String threeid =request.getParameter("threeid");
		String fourid =request.getParameter("fourid");
		String fiveid =request.getParameter("fiveid");
		String sixid =request.getParameter("sixid");
		
		WebAdvert  webAdvertOne=new WebAdvert();
		webAdvertOne.setId(Long.valueOf(oneid));
		webAdvertOne.setImgurl(oneimgurl);
		webAdvertOne.setUrl(oneurl);
		webAdvertOne.setStatus(onestatus);
		
		WebAdvert  webAdvertTwo=new WebAdvert();
		webAdvertTwo.setId(Long.valueOf(twoid));
		webAdvertTwo.setImgurl(twoimgurl);
		webAdvertTwo.setUrl(twourl);
		webAdvertTwo.setStatus(twostatus);
		
		WebAdvert  webAdvertThree=new WebAdvert();
		webAdvertThree.setId(Long.valueOf(threeid));
		webAdvertThree.setImgurl(threeimgurl);
		webAdvertThree.setUrl(threeurl);
		webAdvertThree.setStatus(threestatus);
		
		WebAdvert  webAdvertFour=new WebAdvert();
		webAdvertFour.setId(Long.valueOf(fourid));
		webAdvertFour.setImgurl(fourimgurl);
		webAdvertFour.setUrl(foururl);
		webAdvertFour.setStatus(fourstatus);
		
		WebAdvert  webAdvertFive=new WebAdvert();
		webAdvertFive.setId(Long.valueOf(fiveid));
		webAdvertFive.setImgurl(fiveimgurl);
		webAdvertFive.setUrl(fiveurl);
		webAdvertFive.setStatus(fivestatus);
		
		WebAdvert  webAdvertSix=new WebAdvert();
		webAdvertSix.setId(Long.valueOf(sixid));
		webAdvertSix.setImgurl(siximgurl);
		webAdvertSix.setUrl(sixurl);
		webAdvertSix.setStatus(sixstatus);
		

		List<WebAdvert> webAdverts=new ArrayList<WebAdvert>();
		webAdverts.add(webAdvertOne);
		webAdverts.add(webAdvertTwo);
		webAdverts.add(webAdvertThree);
		webAdverts.add(webAdvertFour);
		webAdverts.add(webAdvertFive);
		webAdverts.add(webAdvertSix);
		AdmanageDao admanageDao=new AdmanageDao();
		admanageDao.update(webAdverts);
		
	//	response.sendRedirect("AdManageServlet?act=showpage");
		
   	    response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>alert('±£´æ³É¹¦!');document.location.href='AdManageServlet?act=showpage';</script>"); 
		out.flush();
		
	}
}
