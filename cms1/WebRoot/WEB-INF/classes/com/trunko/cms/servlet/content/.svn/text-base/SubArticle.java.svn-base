package com.trunko.cms.servlet.content;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.dao.content.ContentManageDao;
import com.trunko.cms.entity.WebInfomation;
import com.trunko.cms.entity.WebSubInfo;

public class SubArticle extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

      doPost(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String url=request.getParameter("url");
		
		ContentManageDao contentManageDao=new ContentManageDao();
		
		WebSubInfo webInfomation=contentManageDao.getSubInfo(url);
	
		request.setAttribute("item", webInfomation);
		
		//模版url  生成栏目列表
		request.getRequestDispatcher("model/article_model.jsp").forward(request, response);
		
		
		}

}
