package com.trunko.cms.servlet.location;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.trunko.cms.dao.location.IndexDao;
import com.trunko.cms.dao.sysconfig.SysConfigDao;
import com.trunko.cms.entity.WebAdvert;
import com.trunko.cms.entity.WebConfig;
import com.trunko.cms.entity.WebInfomation;
import com.trunko.cms.entity.WebQuestion;
import com.trunko.cms.entity.WebVote;
import com.trunko.cms.entity.WebUrl;
import com.trunko.cms.entity.WebLmph;

/**
 * 首页信息转发控制显示
 * @author gjz
 *
 */
public class Index extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		IndexDao indexDao=new IndexDao();
   		List<WebInfomation> webInfomations=indexDao.getAllArticle();
		List<WebInfomation> HDList=indexDao.getHDList();
		List<WebInfomation> GDList=indexDao.getGDList();
		List<WebQuestion> QuestionList=indexDao.getQuestionList();
		List<WebVote> VoteList=indexDao.getVoteList();
		List<WebUrl> UrlList=indexDao.getUrlList();
		List<WebInfomation> wzphList=indexDao.getWzphList();
		List<WebLmph> lmphList=indexDao.getLmphList();
		WebInfomation RD =indexDao.getRD();
		List<WebAdvert> webAdverts=indexDao.getAllAdverts();
		if(RD != null){
			if(RD.getBt() != null && RD.getBt().length()>15){
			RD.setBt(RD.getBt().substring(0,15));
			}
			if(RD.getNr() != null && RD.getNr().length()>20){
			RD.setNr(RD.getNr().substring(0,20));
			}
		}
		
	    
		
		SysConfigDao sysConfigDao=new SysConfigDao();
		WebConfig webConfig=sysConfigDao.getInfo();
		
		request.setAttribute("config", webConfig);
		
		request.setAttribute("adverts", webAdverts);
   		request.setAttribute("itemList", webInfomations);
   		request.setAttribute("hdlist", HDList);
   		request.setAttribute("gdlist", GDList);
   		request.setAttribute("rd",RD);
   		request.setAttribute("questionlist", QuestionList);
   		request.setAttribute("votelist", VoteList);
   		request.setAttribute("urllist", UrlList);
   		request.setAttribute("wzphlist", wzphList);
   		request.setAttribute("lmphlist", lmphList);
   		request.getSession().setAttribute("hdplist", HDList);
   		request.getRequestDispatcher("index.jsp").forward(request, response);
   		
		
		}

}
