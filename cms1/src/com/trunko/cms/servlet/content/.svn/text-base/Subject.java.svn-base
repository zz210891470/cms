package com.trunko.cms.servlet.content;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.dao.content.ContentManageDao;
import com.trunko.cms.entity.WebSubColumn;
import com.trunko.cms.entity.WebInfomation;
import com.trunko.cms.entity.WebModel;

public class Subject extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		doPost(request, response);
    }


	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		String type=request.getParameter("type");
		
		ContentManageDao contentManageDao=new ContentManageDao();
		
		WebSubColumn webSubColumn=contentManageDao.getSubColumn(type);
		
		WebModel webModel=contentManageDao.getModel(webSubColumn.getLmmx());
		
		List<WebInfomation> webInfomations=contentManageDao.getInfomationList(webSubColumn.getId());
		
		request.setAttribute("itemlist", webInfomations);
		request.setAttribute("column", webSubColumn);
		
		//模版url  生成栏目列表
		request.getRequestDispatcher(webModel.getMxurl()).forward(request, response);

       }

}
