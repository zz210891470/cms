package com.trunko.cms.servlet.people;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.trunko.cms.dao.location.VoteDao;
import com.trunko.cms.dao.people.PeopleQuestionDao;
import com.trunko.cms.dao.people.PeopleVoteDao;
import com.trunko.cms.entity.WebVote;
import com.trunko.cms.entity.WebVoteAnswer;
import com.trunko.cms.entity.WebVoteItem;
import com.trunko.cms.util.FavoritesHelper;
import com.trunko.cms.util.Pager;

public class PeopleVoteServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
         doPost(request,response);
    }


	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	   String act=request.getParameter("act");
	   
	   if(act.equals("list")){
		   getList(request,response);
	   }else if(act.equals("deleteItems")){
		   deleteItems(request,response);
	   }else if(act.equals("addpage")){
		   goAddPage(request,response);
	   }else if(act.equals("add")){
		   add(request,response);
	   }else if(act.equals("updatepage")){
		   goUpdatePage(request,response);
	   }else if(act.equals("update")){
		   update(request,response);
	   }
	}
	
	private void update(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		
		   String id=request.getParameter("id");
		  
	       String kssj=request.getParameter("kssj");
	       String jssj=request.getParameter("jssj");
	       String bt=request.getParameter("bt");
	       String nr=request.getParameter("nr");
	       String typestr=request.getParameter("typestr");
	       String questionstr=request.getParameter("questionstr");
	       String sortstr=request.getParameter("sortstr");
	       String answerstr=request.getParameter("answerstr");
	       
	       WebVote webVote =new WebVote();
	       PeopleVoteDao peopleVoteDao=new PeopleVoteDao();
	       
	       //先把原有数据删除
	       peopleVoteDao.deleteAnswer(peopleVoteDao.getItemList(id));
	       peopleVoteDao.deleteItem(id);
	       
	       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	       Date ts_kssj;
	       Date ts_jssj;
			try {
				ts_kssj = new Date(sdf.parse(kssj).getTime());
				ts_jssj=new Date(sdf.parse(jssj).getTime());
				webVote.setKssj(ts_kssj);
				webVote.setJssj(ts_jssj);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	       webVote.setNr(nr);
	       webVote.setZt(bt);
	       webVote.setId(Long.valueOf(id));
	       
	       peopleVoteDao.update(webVote);
	       
	 
	       
	       String[] questionList=questionstr.split(";");
	       String[] typeList=typestr.split(";");
	       String[] sortList=sortstr.split(";");
	       String[] answerList=answerstr.split(";");
	       
	       for(int i=0;i<questionList.length;i++){
	    	   WebVoteItem webVoteItem=new WebVoteItem();
	    	   webVoteItem.setDcid(Long.valueOf(id));
	    	   webVoteItem.setSort(Integer.valueOf(sortList[i]));
	    	   webVoteItem.setType(Integer.valueOf(typeList[i]));
	    	   webVoteItem.setWt(questionList[i]);
	    	   
	    	   peopleVoteDao.addQuestion(webVoteItem);
	    	   
	    	   Long voteitemid=peopleVoteDao.getNewVoteItem();
	    	   String[] answerQList=answerList[i].split("-");
	    	   
	    	   List<WebVoteAnswer> webVoteAnswers=new ArrayList<WebVoteAnswer>();
	    	   for(int k=0;k<answerQList.length;k++){
	    		   WebVoteAnswer webVoteAnswer=new WebVoteAnswer();
	    		   webVoteAnswer.setDa(answerQList[k]);
	    		   webVoteAnswer.setWtid(voteitemid);	 
	    		   webVoteAnswers.add(webVoteAnswer);
	    	   }
	    	   
	    	   peopleVoteDao.addAnswer(webVoteAnswers);
		       
	       }
	       
			response.setContentType("text/html;charset=UTF-8"); 
		    PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>window.parent.hideEditFrame();</script>"); 
			out.flush();
	    

	}
	
	private void goUpdatePage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		   String id=request.getParameter("id");
			
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
	   		request.getRequestDispatcher("vote_edit.jsp").forward(request, response);
			
	}

	
	private void add(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
       String kssj=request.getParameter("kssj");
       String jssj=request.getParameter("jssj");
       String bt=request.getParameter("bt");
       String nr=request.getParameter("nr");
       String typestr=request.getParameter("typestr");
       String questionstr=request.getParameter("questionstr");
       String sortstr=request.getParameter("sortstr");
       String answerstr=request.getParameter("answerstr");
       
       WebVote webVote =new WebVote();
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
       Date ts_kssj;
       Date ts_jssj;
		try {
			ts_kssj = new Date(sdf.parse(kssj).getTime());
			ts_jssj=new Date(sdf.parse(jssj).getTime());
			webVote.setKssj(ts_kssj);
			webVote.setJssj(ts_jssj);
		} catch (ParseException e) {
			e.printStackTrace();
		}
       webVote.setNr(nr);
       webVote.setZt(bt);
 
       PeopleVoteDao peopleVoteDao=new PeopleVoteDao();
       peopleVoteDao.add(webVote);
       
       Long voteid=peopleVoteDao.getNewVote();
       
       String[] questionList=questionstr.split(";");
       String[] typeList=typestr.split(";");
       String[] sortList=sortstr.split(";");
       String[] answerList=answerstr.split(";");
       
       for(int i=0;i<questionList.length;i++){
    	   WebVoteItem webVoteItem=new WebVoteItem();
    	   webVoteItem.setDcid(voteid);
    	   webVoteItem.setSort(FavoritesHelper.stringToint(sortList[i]));
    	   webVoteItem.setType(FavoritesHelper.stringToint(typeList[i]));
    	   webVoteItem.setWt(questionList[i]);
    	   
    	   peopleVoteDao.addQuestion(webVoteItem);
    	   
    	   Long voteitemid=peopleVoteDao.getNewVoteItem();
    	   String[] answerQList=answerList[i].split("-");
    	   
    	   List<WebVoteAnswer> webVoteAnswers=new ArrayList<WebVoteAnswer>();
    	   for(int k=0;k<answerQList.length;k++){
    		   WebVoteAnswer webVoteAnswer=new WebVoteAnswer();
    		   webVoteAnswer.setDa(answerQList[k]);
    		   webVoteAnswer.setWtid(voteitemid);	 
    		   webVoteAnswers.add(webVoteAnswer);
    	   }
    	   
    	   peopleVoteDao.addAnswer(webVoteAnswers);
	       
       }
       
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideAddFrame();</script>"); 
		out.flush();

    
   	}
	
	
	private void goAddPage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
		
		request.getRequestDispatcher("vote_add.jsp").forward(request, response);
	}

	private void deleteItems(HttpServletRequest request,HttpServletResponse response)
	    throws ServletException, IOException {
		 String[]  itemList=request.getParameterValues("itemList");

		 
		 PeopleVoteDao peopleVoteDao=new PeopleVoteDao();
			
		 if(peopleVoteDao.delItemList(itemList)==true){
			 postList(request, response);
		 }else{
			 //定位至错误页面
		 }
		 
		
	}


	private void getList(HttpServletRequest request,HttpServletResponse response) 
        throws ServletException, IOException {
		
		//TODO 通过为页面排序接收条件  按照条件排序
		Integer  pageNo   = 1;
		Integer  pageSize = 10;
		if(!(request.getParameter("pageNo")==null||request.getParameter("pageNo").equals(""))){
			pageNo=Integer.valueOf(request.getParameter("pageNo"));
		}
		if(!(request.getParameter("pageSize")==null||request.getParameter("pageSize").equals(""))){
			pageSize=Integer.valueOf(request.getParameter("pageSize"));
		}
		PeopleVoteDao peopleVoteDao=new PeopleVoteDao();
		Pager pager=peopleVoteDao.getItemForPage(pageNo, pageSize);

		request.setAttribute("pager", pager);
		request.getRequestDispatcher("vote.jsp").forward(request, response);
		
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
		//TODO 通过为页面排序接收条件  按照条件排序
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
	
		PeopleVoteDao peopleVoteDao=new PeopleVoteDao();
		Pager pager=peopleVoteDao.getItemForPage(pageNo, pageSize);

		request.setAttribute("pager", pager);
		request.getRequestDispatcher("vote.jsp").forward(request, response);
		
	}

}
