package com.trunko.cms.servlet.location;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.dao.location.VoteDao;
import com.trunko.cms.entity.WebVote;
import com.trunko.cms.entity.WebVoteAnswer;
import com.trunko.cms.entity.WebVoteItem;
import com.trunko.cms.util.DateHelper;
import com.trunko.cms.util.FavoritesHelper;

public class Vote extends HttpServlet {
	public static String filterContent(String content){  
		  String flt ="'|and|exec|xp_cmdshell|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,";  
		  String filter[] = flt.split("|");  
		 for(int i=0;i<filter.length ; i++)  
		    {  
		      content.replace(filter[i], "");  
		    }  
		     return content;  
		  }  

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String act =filterContent(request.getParameter("act"));
         
        if(act.equals("getdata")){
        	getData(request, response);
        }else if(act.equals("vote")){
        	showVote(request,response);
        }else if(act.equals("savevote")){
        	saveVote(request,response);
        }else if(act.equals("show")){
        	showVotePs(request,response);
        }
	}

	

	private void showVotePs(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
		
        String id=filterContent(request.getParameter("id"));
		try{
			Long.valueOf(id);
		}catch(Exception e){
			return;
		}
		WebVote webVote;
		VoteDao voteDao=new VoteDao();
		//调查问卷
		webVote=voteDao.getVote(id);
		
		List<WebVoteItem> webVoteItems;
		//调查问题列表
		webVoteItems=voteDao.getVoteItems(id);
		
		List<Long> idList=new ArrayList<Long>();
		for(WebVoteItem w:webVoteItems){		
			idList.add(w.getId());
		}
		List<WebVoteAnswer> webVoteAnswers;
		webVoteAnswers=voteDao.getVoteAnswers(idList);

   		request.setAttribute("voteAnswersList", webVoteAnswers);
   		request.setAttribute("voteItemList", webVoteItems);
   		request.setAttribute("vote",webVote);
   		request.getRequestDispatcher("dcjg.jsp").forward(request, response);
		
		
		
	}
	
	private void saveVote(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
		String voteitems = request.getParameter("voteitems");
		String id=filterContent(request.getParameter("id"));
		try{
			Long.valueOf(id);
		}catch(Exception e){
			return;
		}
		String name=filterContent(request.getParameter("name"));
		String lxfs=filterContent(request.getParameter("lxfs"));
		VoteDao voteDao=new VoteDao();
		voteDao.saveVote(voteitems);
		if (FavoritesHelper.isNotNull(name)) {
			voteDao.saveVoteUser(id,name,lxfs);
		}
	//	request.getRequestDispatcher("").forward(request, response);
		response.sendRedirect("Vote?act=show&id="+id);
	}
	
	
	private void showVote(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
		String id=filterContent(request.getParameter("id"));
		try{
			Long.valueOf(id);
		}catch(Exception e){
			return;
		}
		WebVote webVote;
		VoteDao voteDao=new VoteDao();
		//调查问卷
		webVote=voteDao.getVote(id);
		
		List<WebVoteItem> webVoteItems;
		//调查问题列表
		webVoteItems=voteDao.getVoteItems(id);
		
		List<Long> idList=new ArrayList<Long>();
		for(WebVoteItem w:webVoteItems){		
			idList.add(w.getId());
		}
		List<WebVoteAnswer> webVoteAnswers;
		webVoteAnswers=voteDao.getVoteAnswers(idList);

   		request.setAttribute("voteAnswersList", webVoteAnswers);
   		request.setAttribute("voteItemList", webVoteItems);
   		request.setAttribute("vote",webVote);
   		if (DateHelper.getNowDate().compareTo(webVote.getJssj().toString()) > 0) {
   			request.getRequestDispatcher("show_result.jsp").forward(request, response);
   		}else{
   			request.getRequestDispatcher("dcwj.jsp").forward(request, response);
   		}
		
		
	}
	

	private void getData(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException {

		String pageNo=filterContent(request.getParameter("pageNo"));
		
		String data="[\"SUCCESS\",\"";
		VoteDao voteDao=new VoteDao();
	    data+=convert(voteDao.getVoteForPage(Integer.valueOf(pageNo), 10));
		data+="\"]";
		PrintWriter out = response.getWriter();
			
        response.setContentType("application/json; charset=utf-8");  
        response.setHeader("pragma", "no-cache");  
        response.setHeader("cache-control", "no-cache");  
		out.write(data);
		out.close();
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
		
		for (i = 0; i < str.length(); i++){
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
}
