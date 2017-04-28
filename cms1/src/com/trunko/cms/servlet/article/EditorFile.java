package com.trunko.cms.servlet.article;

import java.io.IOException;
import com.trunko.cms.entity.Uploader;
		
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditorFile extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type=request.getParameter("type");
		if(type.equals("image")){
			uploadImage(request, response);
		}else if(type.equals("file")){
			
		}

	}
	

	public void uploadImage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	    request.setCharacterEncoding("gbk");
		response.setCharacterEncoding("gbk");
	    Uploader up = new Uploader(request);
	    up.setSavePath("upload");
	    String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
	    up.setAllowFiles(fileType);
	    up.setMaxSize(10000); //µ¥Î»KB
	    try {
			up.upload();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    response.getWriter().print("{'original':'"+up.getOriginalName()+"','url':'"+up.getUrl()+"','title':'"+up.getTitle()+"','state':'"+up.getState()+"'}");
		
	}

	public void uploadFile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
