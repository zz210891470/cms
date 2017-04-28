package com.trunko.cms.servlet.content;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.common.Constants;
import com.trunko.cms.dao.content.ContentManageDao;
import com.trunko.cms.entity.WebColumn;
import com.trunko.cms.entity.WebInfomation;
import com.trunko.cms.entity.WebModel;

public class Column extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

       doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		String type=request.getParameter("type");
		
		ContentManageDao contentManageDao=new ContentManageDao();
		
		WebColumn webColumn=contentManageDao.getColumn(type);

		WebModel webModel=contentManageDao.getModel(webColumn.getLmmx());
		
		if(webColumn.getLmmx().equals(Constants.LBMB)){
			List<WebInfomation> webInfomations=contentManageDao.getInfomationList(webColumn.getId());
			
			request.setAttribute("itemlist", webInfomations);
			request.setAttribute("column", webColumn);
			
			//模版url  生成栏目列表
			request.getRequestDispatcher(webModel.getMxurl()).forward(request, response);
	
		}else if(webColumn.getLmmx().equals(Constants.RRMB)){
			WebInfomation webInfomation=new WebInfomation();
			webInfomation=contentManageDao.getInfomationBySjid(webColumn.getId());
			
			request.setAttribute("item", webInfomation);
			request.getRequestDispatcher(webModel.getMxurl()).forward(request, response);		
		}

	}

}
