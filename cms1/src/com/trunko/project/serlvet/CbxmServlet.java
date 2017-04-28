package com.trunko.project.serlvet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.trunko.cms.util.Pager;
import com.trunko.project.dao.CbxmDao;
import com.trunko.project.dao.ZsxmDao;
import com.trunko.project.entity.ProCbxm;


public class CbxmServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		String action=request.getParameter("action");
		   
	    if(action.equals("list")){//显示列表
		    getList(request, response);
	    }
	    else if(action.equals("toAdd")){//跳转到添加页面
		    goAddPage(request, response);
	    }
	    else if(action.equals("toEdit")){//跳转到编辑页面
		    goEditPage(request, response);
	    }
	    else if(action.equals("toRead")){//跳转到浏览页面
	    	goReadPage(request, response);
	    }
	    else if(action.equals("toImport")){//跳转至导入页面
		    toImportPage(request, response);
	    }
	    else if(action.equals("sideradd")){//侧边栏录入页面
		    toSiderAddPage(request, response);
	    }
	    else if(action.equals("audit")){
	    	getAudit(request,response);
	    }
	    else if(action.equals("toAudit")){//审核
	    	goAuditPage(request,response);
	    }
	    else if(action.equals("xxhz")){   //信息汇总	
	    	Xxhz(request,response);
	    }
	    else if(action.equals("xxhzpage")){   //信息汇总 页面
	    	toXxhzPage(request,response);
	    }
	    else if(action.equals("xxfgmhzpage")){   //信息分规模汇总  add by lhanliang
	    	toFgmhzPage(request,response);
	    }
	    else if(action.equals("getGmxxInfo")){   //ajax信息分规模汇总数据
	    	getGmxxInfo(request,response);
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
	    else if(action.equals("toEdit")){//跳转到编辑页面
		    goEditPage(request, response);
	    }
	    else if(action.equals("toRead")){//跳转到浏览页面
	    	goReadPage(request, response);
	    }
	    else if(action.equals("update")){//修改列表项
		    update(request, response);
	    }
	    else if(action.equals("toImport")){//跳转至导入页面
		    toImportPage(request, response);
	    }
	    else if(action.equals("sideradd")){//侧边栏录入页面
		    toSiderAddPage(request, response);
	    }	    
	    else if(action.equals("sadd")){//侧边栏录入页面
		    sadd(request, response);
	    }
	    else if(action.equals("audit")){//审核
	    	postAudit(request,response);
	    }
	    else if(action.equals("toAudit")){//审核
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
	    else if(action.equals("xxflhzpage")){   //信息分类汇总  add by lhanliang
	    	toFlhzPage(request,response);
	    }
	    else if(action.equals("xxfjhzpage")){   //信息分级汇总  add by lhanliang
	    	toFjhzPage(request,response);
	    }
	    else if(action.equals("xxfgmhzpage")){   //信息分规模汇总  add by lhanliang
	    	toFgmhzPage(request,response);
	    }
	    else if(action.equals("getGmxxInfo")){   //ajax信息分规模汇总数据
	    	getGmxxInfo(request,response);
	    }
	    else if(action.equals("publish")){//发布信息到webinformation
	    	
	    	 publishMsg(request,response);
	    	
	    }
	}
	
	/**
	 * 信息分规模汇总 add by lhanliang
	 * @param request 请求
	 * @param response 响应
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getGmxxInfo(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String fz = request.getParameter("fz");
		if(fz.equals("lb")){
			toLbhz(request,response);
		}else if(fz.equals("dq")){
			toDqhz(request,response);
		}
		
	}
	
	/**
	 * 信息分规模类别汇总 add by lhanliang
	 * @param request 请求
	 * @param response 响应
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toLbhz(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // 年度
		
		String data = "";

		// 获取所有储备信息
		List<ProCbxm> infoList = CbxmDao.getAllProList(year);

		List<String> lb1list  =  CbxmDao.getLb1List();
		
		List<ProCbxm>  tempList = new ArrayList<ProCbxm>();
		int num = 0;
		double ztz = 0l;
		
		//100亿以上项目
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()>1000000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert("100亿以上项目（"+num+"个）")+"\" style=\"font-weight:bold\" style=\"font-weight:bold\"></td>"
             +"<td></td><td></td><td align=\"right\">"+ztz+"</td><td align=\"right\">"+year+"</td>"
	         +"<td></td><td></td></tr>";

		
		for(int i = 0; i<lb1list.size(); i++){
			String dataTmp = "";
			int numTmp = 0;
			long ztzTmp  = 0l;
			int px = 1;
			for(int j=0; j<tempList.size() ;j++){
				
				if(lb1list.get(i).equals(tempList.get(j).getLb1())){
                    dataTmp += "<tr height=\"30\"  ><td align=\"center\">"+px+"</td><td align=\"center\"  name=\""+convert(tempList.get(j).getMc())+"\"></td>"
                            +"<td align=\"left\" name=\""+convert(tempList.get(j).getJsgm())+"\"></td><td align=\"left\" name=\""+convert(tempList.get(j).getXyfx())+"\"></td>" 
                            +"<td align=\"right\">"+tempList.get(j).getZtz()+"</td><td align=\"right\">"+tempList.get(j).getBssj()+"</td>"
       	                    +"<td align=\"center\" name=\""+convert(tempList.get(j).getLxr())+"\" ></td><td align=\"center\" name=\""+convert(tempList.get(j).getLxdh())+"\" ></td></tr>";
				    px++;
				    numTmp++;
				    ztzTmp += tempList.get(j).getZtz();
				}
			}
			data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert(lb1list.get(i)+"（"+numTmp+"个）")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}
		num = 0;
		ztz =  0l;
		tempList.clear();
		//50-100项目
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=1000000 && infoList.get(j).getZtz()>500000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert("50-100亿项目（"+num+"个）")+"\" style=\"font-weight:bold\"></td>"
             +"<td></td><td></td><td align=\"right\">"+ztz+"</td><td align=\"right\">"+year+"</td>"
	         +"<td></td><td></td></tr>";

		
		for(int i = 0; i<lb1list.size(); i++){
			String dataTmp = "";
			int numTmp = 0;
			long ztzTmp  = 0l;
			int px = 1;
			for(int j=0; j<tempList.size() ;j++){
				
				if(lb1list.get(i).equals(tempList.get(j).getLb1())){
                    dataTmp += "<tr height=\"30\"  ><td align=\"center\">"+px+"</td><td align=\"center\"  name=\""+convert(tempList.get(j).getMc())+"\"></td>"
                            +"<td align=\"left\" name=\""+convert(tempList.get(j).getJsgm())+"\"></td><td align=\"left\" name=\""+convert(tempList.get(j).getXyfx())+"\"></td>" 
                            +"<td align=\"right\">"+tempList.get(j).getZtz()+"</td><td align=\"right\">"+tempList.get(j).getBssj()+"</td>"
       	                    +"<td align=\"center\" name=\""+convert(tempList.get(j).getLxr())+"\" ></td><td align=\"center\" name=\""+convert(tempList.get(j).getLxdh())+"\" ></td></tr>";
				    px++;
				    numTmp++;
				    ztzTmp += tempList.get(j).getZtz();
				}
			}
			data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert(lb1list.get(i)+"（"+numTmp+"个）")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}
		num = 0;
		ztz =  0l;
		tempList.clear();
		//20-50项目
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=500000 && infoList.get(j).getZtz()>200000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert("20-50亿项目（"+num+"个）")+"\" style=\"font-weight:bold\"></td>"
             +"<td></td><td></td><td align=\"right\">"+ztz+"</td><td align=\"right\">"+year+"</td>"
	         +"<td></td><td></td></tr>";

		
		for(int i = 0; i<lb1list.size(); i++){
			String dataTmp = "";
			int numTmp = 0;
			long ztzTmp  = 0l;
			int px = 1;
			for(int j=0; j<tempList.size() ;j++){
				
				if(lb1list.get(i).equals(tempList.get(j).getLb1())){
                    dataTmp += "<tr height=\"30\"  ><td align=\"center\">"+px+"</td><td align=\"center\"  name=\""+convert(tempList.get(j).getMc())+"\"></td>"
                            +"<td align=\"left\" name=\""+convert(tempList.get(j).getJsgm())+"\"></td><td align=\"left\" name=\""+convert(tempList.get(j).getXyfx())+"\"></td>" 
                            +"<td align=\"right\">"+tempList.get(j).getZtz()+"</td><td align=\"right\">"+tempList.get(j).getBssj()+"</td>"
       	                    +"<td align=\"center\" name=\""+convert(tempList.get(j).getLxr())+"\" ></td><td align=\"center\" name=\""+convert(tempList.get(j).getLxdh())+"\" ></td></tr>";
				    px++;
				    numTmp++;
				    ztzTmp += tempList.get(j).getZtz();
				}
			}
			data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert(lb1list.get(i)+"（"+numTmp+"个）")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}

		num = 0;
		ztz =  0l;
		tempList.clear();
		//10-20项目
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=200000 && infoList.get(j).getZtz()>100000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert("10-20亿项目（"+num+"个）")+"\" style=\"font-weight:bold\"></td>"
             +"<td></td><td></td><td align=\"right\">"+ztz+"</td><td align=\"right\">"+year+"</td>"
	         +"<td></td><td></td></tr>";

		
		for(int i = 0; i<lb1list.size(); i++){
			String dataTmp = "";
			int numTmp = 0;
			long ztzTmp  = 0l;
			int px = 1;
			for(int j=0; j<tempList.size() ;j++){
				
				if(lb1list.get(i).equals(tempList.get(j).getLb1())){
                    dataTmp += "<tr height=\"30\"  ><td align=\"center\">"+px+"</td><td align=\"center\"  name=\""+convert(tempList.get(j).getMc())+"\"></td>"
                            +"<td align=\"left\" name=\""+convert(tempList.get(j).getJsgm())+"\"></td><td align=\"left\" name=\""+convert(tempList.get(j).getXyfx())+"\"></td>" 
                            +"<td align=\"right\">"+tempList.get(j).getZtz()+"</td><td align=\"right\">"+tempList.get(j).getBssj()+"</td>"
       	                    +"<td align=\"center\" name=\""+convert(tempList.get(j).getLxr())+"\" ></td><td align=\"center\" name=\""+convert(tempList.get(j).getLxdh())+"\" ></td></tr>";
				    px++;
				    numTmp++;
				    ztzTmp += tempList.get(j).getZtz();
				}
			}
			data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert(lb1list.get(i)+"（"+numTmp+"个）")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}

		num = 0;
		ztz =  0l;
		tempList.clear();
		//5-10项目
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=100000 && infoList.get(j).getZtz()>50000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert("5-10亿项目（"+num+"个）")+"\" style=\"font-weight:bold\"></td>"
             +"<td></td><td></td><td align=\"right\">"+ztz+"</td><td align=\"right\">"+year+"</td>"
	         +"<td></td><td></td></tr>";

		
		for(int i = 0; i<lb1list.size(); i++){
			String dataTmp = "";
			int numTmp = 0;
			long ztzTmp  = 0l;
			int px = 1;
			for(int j=0; j<tempList.size() ;j++){
				
				if(lb1list.get(i).equals(tempList.get(j).getLb1())){
                    dataTmp += "<tr height=\"30\"  ><td align=\"center\">"+px+"</td><td align=\"center\"  name=\""+convert(tempList.get(j).getMc())+"\"></td>"
                            +"<td align=\"left\" name=\""+convert(tempList.get(j).getJsgm())+"\"></td><td align=\"left\" name=\""+convert(tempList.get(j).getXyfx())+"\"></td>" 
                            +"<td align=\"right\">"+tempList.get(j).getZtz()+"</td><td align=\"right\">"+tempList.get(j).getBssj()+"</td>"
       	                    +"<td align=\"center\" name=\""+convert(tempList.get(j).getLxr())+"\" ></td><td align=\"center\" name=\""+convert(tempList.get(j).getLxdh())+"\" ></td></tr>";
				    px++;
				    numTmp++;
				    ztzTmp += tempList.get(j).getZtz();
				}
			}
			data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert(lb1list.get(i)+"（"+numTmp+"个）")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}
		num = 0;
		ztz =  0l;
		tempList.clear();
		//1-5项目
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=50000 && infoList.get(j).getZtz()>10000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert("1-5亿项目（"+num+"个）")+"\" style=\"font-weight:bold\"></td>"
             +"<td></td><td></td><td align=\"right\">"+ztz+"</td><td align=\"right\">"+year+"</td>"
	         +"<td></td><td></td></tr>";

		
		for(int i = 0; i<lb1list.size(); i++){
			String dataTmp = "";
			int numTmp = 0;
			long ztzTmp  = 0l;
			int px = 1;
			for(int j=0; j<tempList.size() ;j++){
				
				if(lb1list.get(i).equals(tempList.get(j).getLb1())){
                    dataTmp += "<tr height=\"30\"  ><td align=\"center\">"+px+"</td><td align=\"center\"  name=\""+convert(tempList.get(j).getMc())+"\"></td>"
                            +"<td align=\"left\" name=\""+convert(tempList.get(j).getJsgm())+"\"></td><td align=\"left\" name=\""+convert(tempList.get(j).getXyfx())+"\"></td>" 
                            +"<td align=\"right\">"+tempList.get(j).getZtz()+"</td><td align=\"right\">"+tempList.get(j).getBssj()+"</td>"
       	                    +"<td align=\"center\" name=\""+convert(tempList.get(j).getLxr())+"\" ></td><td align=\"center\" name=\""+convert(tempList.get(j).getLxdh())+"\" ></td></tr>";
				    px++;
				    numTmp++;
				    ztzTmp += tempList.get(j).getZtz();
				}
			}
			data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert(lb1list.get(i)+"（"+numTmp+"个）")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}
		num = 0;
		ztz =  0l;
		tempList.clear();
		//1亿以下项目
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=10000 ){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert("1亿以下项目（"+num+"个）")+"\" style=\"font-weight:bold\"></td>"
             +"<td></td><td></td><td align=\"right\">"+ztz+"</td><td align=\"right\">"+year+"</td>"
	         +"<td></td><td></td></tr>";

		
		for(int i = 0; i<lb1list.size(); i++){
			String dataTmp = "";
			int numTmp = 0;
			long ztzTmp  = 0l;
			int px = 1;
			for(int j=0; j<tempList.size() ;j++){
				
				if(lb1list.get(i).equals(tempList.get(j).getLb1())){
                    dataTmp += "<tr height=\"30\"  ><td align=\"center\">"+px+"</td><td align=\"center\"  name=\""+convert(tempList.get(j).getMc())+"\"></td>"
                            +"<td align=\"left\" name=\""+convert(tempList.get(j).getJsgm())+"\"></td><td align=\"left\" name=\""+convert(tempList.get(j).getXyfx())+"\"></td>" 
                            +"<td align=\"right\">"+tempList.get(j).getZtz()+"</td><td align=\"right\">"+tempList.get(j).getBssj()+"</td>"
       	                    +"<td align=\"center\" name=\""+convert(tempList.get(j).getLxr())+"\" ></td><td align=\"center\" name=\""+convert(tempList.get(j).getLxdh())+"\" ></td></tr>";
                    
				    px++;
				    numTmp++;
				    ztzTmp += tempList.get(j).getZtz();
				}
			}
			data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert(lb1list.get(i)+"（"+numTmp+"个）")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}


        PrintWriter out = response.getWriter();
        response.setContentType("application/json; charset=utf-8");  
		out.write(data);
		out.close();
		
		
	}
	
	
	/**
	 * 信息分规模地区汇总 add by lhanliang
	 * @param request 请求
	 * @param response 响应
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toDqhz(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // 年度
		
		String data = "";

		// 获取所有储备信息
		List<ProCbxm> infoList = CbxmDao.getAllProList(year);

		List<String> dqlist  =  CbxmDao.getDqList();
		
		List<ProCbxm>  tempList = new ArrayList<ProCbxm>();
		int num = 0;
		double ztz = 0l;
		
		//100亿以上项目
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()>1000000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert("100亿以上项目（"+num+"个）")+"\" style=\"font-weight:bold\"></td>"
             +"<td></td><td></td><td align=\"right\">"+ztz+"</td><td align=\"right\">"+year+"</td>"
	         +"<td></td><td></td></tr>";

		
		for(int i = 0; i<dqlist.size(); i++){
			String dataTmp = "";
			int numTmp = 0;
			long ztzTmp  = 0l;
			int px = 1;
			for(int j=0; j<tempList.size() ;j++){
				
				if(dqlist.get(i).equals(tempList.get(j).getDq())){
                    dataTmp += "<tr height=\"30\"  ><td align=\"center\">"+px+"</td><td align=\"center\"  name=\""+convert(tempList.get(j).getMc())+"\"></td>"
                            +"<td align=\"left\" name=\""+convert(tempList.get(j).getJsgm())+"\"></td><td align=\"left\" name=\""+convert(tempList.get(j).getXyfx())+"\"></td>" 
                            +"<td align=\"right\">"+tempList.get(j).getZtz()+"</td><td align=\"right\">"+tempList.get(j).getBssj()+"</td>"
       	                    +"<td align=\"center\" name=\""+convert(tempList.get(j).getLxr())+"\" ></td><td align=\"center\" name=\""+convert(tempList.get(j).getLxdh())+"\" ></td></tr>";
				    px++;
				    numTmp++;
				    ztzTmp += tempList.get(j).getZtz();
				}
			}
			data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert(dqlist.get(i)+"（"+numTmp+"个）")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}
		
		num = 0;
		ztz =  0l;
		tempList.clear();
		//50-100项目
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=1000000 && infoList.get(j).getZtz()>500000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert("50-100亿项目（"+num+"个）")+"\" style=\"font-weight:bold\"></td>"
             +"<td></td><td></td><td align=\"right\">"+ztz+"</td><td align=\"right\">"+year+"</td>"
             +"<td></td><td></td></tr>";

		
		for(int i = 0; i<dqlist.size(); i++){
			String dataTmp = "";
			int numTmp = 0;
			long ztzTmp  = 0l;
			int px = 1;
			for(int j=0; j<tempList.size() ;j++){
				
				if(dqlist.get(i).equals(tempList.get(j).getDq())){
                    dataTmp += "<tr height=\"30\"  ><td align=\"center\">"+px+"</td><td align=\"center\"  name=\""+convert(tempList.get(j).getMc())+"\"></td>"
                            +"<td align=\"left\" name=\""+convert(tempList.get(j).getJsgm())+"\"></td><td align=\"left\" name=\""+convert(tempList.get(j).getXyfx())+"\"></td>" 
                            +"<td align=\"right\">"+tempList.get(j).getZtz()+"</td><td align=\"right\">"+tempList.get(j).getBssj()+"</td>"
       	                    +"<td align=\"center\" name=\""+convert(tempList.get(j).getLxr())+"\" ></td><td align=\"center\" name=\""+convert(tempList.get(j).getLxdh())+"\" ></td></tr>";
				    px++;
				    numTmp++;
				    ztzTmp += tempList.get(j).getZtz();
				}
			}
			data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert(dqlist.get(i)+"（"+numTmp+"个）")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
            +"<td></td><td></td></tr>"; 
			data += dataTmp;
			
		}
		num = 0;
		ztz =  0l;
		tempList.clear();
		//20-50项目
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=500000 && infoList.get(j).getZtz()>200000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert("20-50亿项目（"+num+"个）")+"\" style=\"font-weight:bold\"></td>"
             +"<td></td><td></td><td align=\"right\">"+ztz+"</td><td align=\"right\">"+year+"</td>"
             +"<td></td><td></td></tr>";

		
		for(int i = 0; i<dqlist.size(); i++){
			String dataTmp = "";
			int numTmp = 0;
			long ztzTmp  = 0l;
			int px = 1;
			for(int j=0; j<tempList.size() ;j++){
				
				if(dqlist.get(i).equals(tempList.get(j).getDq())){
                    dataTmp += "<tr height=\"30\"  ><td align=\"center\">"+px+"</td><td align=\"center\"  name=\""+convert(tempList.get(j).getMc())+"\"></td>"
                            +"<td align=\"left\" name=\""+convert(tempList.get(j).getJsgm())+"\"></td><td align=\"left\" name=\""+convert(tempList.get(j).getXyfx())+"\"></td>" 
                            +"<td align=\"right\">"+tempList.get(j).getZtz()+"</td><td align=\"right\">"+tempList.get(j).getBssj()+"</td>"
       	                    +"<td align=\"center\" name=\""+convert(tempList.get(j).getLxr())+"\" ></td><td align=\"center\" name=\""+convert(tempList.get(j).getLxdh())+"\" ></td></tr>";
				    px++;
				    numTmp++;
				    ztzTmp += tempList.get(j).getZtz();
				}
			}
			data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert(dqlist.get(i)+"（"+numTmp+"个）")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}

		num = 0;
		ztz =  0l;
		tempList.clear();
		//10-20项目
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=200000 && infoList.get(j).getZtz()>100000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert("10-20亿项目（"+num+"个）")+"\" style=\"font-weight:bold\"></td>"
             +"<td></td><td></td><td align=\"right\">"+ztz+"</td><td align=\"right\">"+year+"</td>"
	         +"<td></td><td></td></tr>";

		
		for(int i = 0; i<dqlist.size(); i++){
			String dataTmp = "";
			int numTmp = 0;
			long ztzTmp  = 0l;
			int px = 1;
			for(int j=0; j<tempList.size() ;j++){
				
				if(dqlist.get(i).equals(tempList.get(j).getDq())){
                    dataTmp += "<tr height=\"30\"  ><td align=\"center\">"+px+"</td><td align=\"center\"  name=\""+convert(tempList.get(j).getMc())+"\"></td>"
                            +"<td align=\"left\" name=\""+convert(tempList.get(j).getJsgm())+"\"></td><td align=\"left\" name=\""+convert(tempList.get(j).getXyfx())+"\"></td>" 
                            +"<td align=\"right\">"+tempList.get(j).getZtz()+"</td><td align=\"right\">"+tempList.get(j).getBssj()+"</td>"
       	                    +"<td align=\"center\" name=\""+convert(tempList.get(j).getLxr())+"\" ></td><td align=\"center\" name=\""+convert(tempList.get(j).getLxdh())+"\" ></td></tr>";
				    px++;
				    numTmp++;
				    ztzTmp += tempList.get(j).getZtz();
				}
			}
			data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert(dqlist.get(i)+"（"+numTmp+"个）")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}

		num = 0;
		ztz =  0l;
		tempList.clear();
		//5-10项目
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=100000 && infoList.get(j).getZtz()>50000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert("5-10亿项目（"+num+"个）")+"\" style=\"font-weight:bold\"></td>"
             +"<td></td><td></td><td align=\"right\">"+ztz+"</td><td align=\"right\">"+year+"</td>"
	         +"<td></td><td></td></tr>";

		
		for(int i = 0; i<dqlist.size(); i++){
			String dataTmp = "";
			int numTmp = 0;
			long ztzTmp  = 0l;
			int px = 1;
			for(int j=0; j<tempList.size() ;j++){
				
				if(dqlist.get(i).equals(tempList.get(j).getDq())){
                    dataTmp += "<tr height=\"30\"  ><td align=\"center\">"+px+"</td><td align=\"center\"  name=\""+convert(tempList.get(j).getMc())+"\"></td>"
                            +"<td align=\"left\" name=\""+convert(tempList.get(j).getJsgm())+"\"></td><td align=\"left\" name=\""+convert(tempList.get(j).getXyfx())+"\"></td>" 
                            +"<td align=\"right\">"+tempList.get(j).getZtz()+"</td><td align=\"right\">"+tempList.get(j).getBssj()+"</td>"
       	                    +"<td align=\"center\" name=\""+convert(tempList.get(j).getLxr())+"\" ></td><td align=\"center\" name=\""+convert(tempList.get(j).getLxdh())+"\" ></td></tr>";
				    px++;
				    numTmp++;
				    ztzTmp += tempList.get(j).getZtz();
				}
			}
			data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert(dqlist.get(i)+"（"+numTmp+"个）")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}
		num = 0;
		ztz =  0l;
		tempList.clear();
		//1-5项目
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=50000 && infoList.get(j).getZtz()>10000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert("1-5亿项目（"+num+"个）")+"\" style=\"font-weight:bold\"></td>"
             +"<td></td><td></td><td align=\"right\">"+ztz+"</td><td align=\"right\">"+year+"</td>"
	         +"<td></td><td></td></tr>";

		
		for(int i = 0; i<dqlist.size(); i++){
			String dataTmp = "";
			int numTmp = 0;
			long ztzTmp  = 0l;
			int px = 1;
			for(int j=0; j<tempList.size() ;j++){
				
				if(dqlist.get(i).equals(tempList.get(j).getDq())){
                    dataTmp += "<tr height=\"30\"  ><td align=\"center\">"+px+"</td><td align=\"center\"  name=\""+convert(tempList.get(j).getMc())+"\"></td>"
                            +"<td align=\"left\" name=\""+convert(tempList.get(j).getJsgm())+"\"></td><td align=\"left\" name=\""+convert(tempList.get(j).getXyfx())+"\"></td>" 
                            +"<td align=\"right\">"+tempList.get(j).getZtz()+"</td><td align=\"right\">"+tempList.get(j).getBssj()+"</td>"
       	                    +"<td align=\"center\" name=\""+convert(tempList.get(j).getLxr())+"\" ></td><td align=\"center\" name=\""+convert(tempList.get(j).getLxdh())+"\" ></td></tr>";
				    px++;
				    numTmp++;
				    ztzTmp += tempList.get(j).getZtz();
				}
			}
			data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert(dqlist.get(i)+"（"+numTmp+"个）")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}
		num = 0;
		ztz =  0l;
		tempList.clear();
		//1亿以下项目
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=10000 ){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert("1亿以下项目（"+num+"个）")+"\" style=\"font-weight:bold\"></td>"
             +"<td></td><td></td><td align=\"right\">"+ztz+"</td><td align=\"right\">"+year+"</td>"
	         +"<td></td><td></td></tr>";

		
		for(int i = 0; i<dqlist.size(); i++){
			String dataTmp = "";
			int numTmp = 0;
			long ztzTmp  = 0l;
			int px = 1;
			for(int j=0; j<tempList.size() ;j++){
				
				if(dqlist.get(i).equals(tempList.get(j).getDq())){
                    dataTmp += "<tr height=\"30\"  ><td align=\"center\">"+px+"</td><td align=\"center\"  name=\""+convert(tempList.get(j).getMc())+"\"></td>"
                            +"<td align=\"left\" name=\""+convert(tempList.get(j).getJsgm())+"\"></td><td align=\"left\" name=\""+convert(tempList.get(j).getXyfx())+"\"></td>" 
                            +"<td align=\"right\">"+tempList.get(j).getZtz()+"</td><td align=\"right\">"+tempList.get(j).getBssj()+"</td>"
       	                    +"<td align=\"center\" name=\""+convert(tempList.get(j).getLxr())+"\" ></td><td align=\"center\" name=\""+convert(tempList.get(j).getLxdh())+"\" ></td></tr>";
				    px++;
				    numTmp++;
				    ztzTmp += tempList.get(j).getZtz();
				}
			}
			data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert(dqlist.get(i)+"（"+numTmp+"个）")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}


        PrintWriter out = response.getWriter();
        response.setContentType("application/json; charset=utf-8");  
		out.write(data);
		out.close();

		
	}
	
	/**
	 * 信息分规模汇总 add by lhanliang
	 * @param request 请求
	 * @param response 响应
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toFgmhzPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // 年度
		String fz =	request.getParameter("fz");  // 分组方式


        request.setAttribute("year", year);
        request.setAttribute("fz", fz);

        
		
		// 跳转至信息分类统计页面，展示信息
		request.getRequestDispatcher("tj_tz.jsp").forward(request, response);
	}
	
	
	/**
	 * 储备项目信息汇总
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
		
	    // 获取储备项目信息
	    List<ProCbxm> itemList =   CbxmDao.showXxhzList(nd, lb1, lb2, dq, ztz1, ztz1num , ztz2, ztz2num);
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
	
		request.setAttribute("dqlist", CbxmDao.getDqList());
		request.setAttribute("lblist", CbxmDao.getLbList());
		request.getRequestDispatcher("tj_xx_page.jsp").forward(request, response);

    }
	/**
	 * 信息分类汇总 add by lhanliang
	 * @param request 请求
	 * @param response 响应
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toFlhzPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // 年度
		// 获取分类统计信息
		Map<String, List<String>> sortInfoMap = CbxmDao.getSortInfoMap(year);
		// 存放信息至request中
		request.setAttribute("sortInfoMap", sortInfoMap);
		// 跳转至信息分类统计页面，展示信息
		request.getRequestDispatcher("tj_fl.jsp").forward(request, response);
		
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
		// 获取分级统计信息
		Map<String, List<String>> areaInfoMap = CbxmDao.getAreaInfoMap(year);
		// 存放信息至request中
		request.setAttribute("areaInfoMap", areaInfoMap);
		// 跳转至信息分级统计页面，展示信息
		request.getRequestDispatcher("tj_fj.jsp").forward(request, response);
		
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
		
		String id = request.getParameter("id");
		String shyj = request.getParameter("shyj");
		CbxmDao.audit(id,"已退回",shyj);
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
		
		String id = request.getParameter("id");
		String shyj = request.getParameter("shyj");
		CbxmDao.audit(id,"已审核",shyj);

		
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideEditFrame();</script>"); 
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
		ProCbxm item = new ProCbxm();
		
		item.setNd(Long.valueOf(request.getParameter("nd")));
		item.setBh(request.getParameter("bh"));
		item.setMc(request.getParameter("mc"));
		item.setDq(request.getParameter("dq"));
		item.setJsgm(request.getParameter("jsgm"));
		item.setJsdd(request.getParameter("jsdd"));
		
		if(request.getParameter("ztz") == null || request.getParameter("ztz").equals("")){
			item.setZtz((double) 01);
		}else{
			item.setZtz(Double.valueOf(request.getParameter("ztz")));
		}

		item.setXyfx(request.getParameter("xyfx"));
		item.setSbdw(request.getParameter("sbdw"));
		item.setLxr(request.getParameter("lxr"));
		item.setLxdh(request.getParameter("lxdh"));
		item.setChdw(request.getParameter("chdw"));
		item.setLxr1(request.getParameter("lxr1"));
		item.setLxdh1(request.getParameter("lxdh1"));
		item.setBgs(request.getParameter("bgs"));
		item.setLb1(request.getParameter("lb1"));
		item.setLb2(request.getParameter("lb2"));
		
		item.setDzyx(request.getParameter("dzyx"));
		item.setDzyx1(request.getParameter("dzyx1"));
		item.setDzyx2(request.getParameter("dzyx2"));
		item.setZzdj(request.getParameter("zzdj"));
		item.setCbdw(request.getParameter("cbdw"));
		item.setLxr2(request.getParameter("lxr2"));
		item.setLxdh2(request.getParameter("lxdh2"));
		item.setHzfs(request.getParameter("hzfs"));
		item.setLygc(request.getParameter("lygc"));
		item.setJstj(request.getParameter("jstj"));
		item.setJsjjzb(request.getParameter("jsjjzb"));
		item.setTjzk(request.getParameter("tjzk"));
		item.setZt("已审核");
		item.setSbyh(request.getSession().getAttribute("yhm").toString());
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("bssj"));
			item.setBssj(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		item.setSbyh(request.getSession().getAttribute("yhm").toString());
		CbxmDao.add(item);
		request.setAttribute("dqlist",  ZsxmDao.getDqList());

		request.setAttribute("lblist", ZsxmDao.getLbList());

		request.setAttribute("status", "ok");
		request.getRequestDispatcher("add.jsp").forward(request, response);
	}
	
	
	/**
	 * 侧边栏录入页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toSiderAddPage(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
		request.setAttribute("dqlist", CbxmDao.getDqList());
		request.setAttribute("lblist", CbxmDao.getLbList());
		request.getRequestDispatcher("add.jsp").forward(request, response);
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
	 * 更新列表项
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void update(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		ProCbxm item = new ProCbxm();
		
		item.setId(Long.valueOf(request.getParameter("id")));
	    item.setNd(Long.valueOf(request.getParameter("nd")));
		item.setBh(request.getParameter("bh"));
		item.setMc(request.getParameter("mc"));
		item.setDq(request.getParameter("dq"));
		item.setJsgm(request.getParameter("jsgm"));
		item.setJsdd(request.getParameter("jsdd"));
		item.setZtz(Double.valueOf(request.getParameter("ztz")));
		item.setXyfx(request.getParameter("xyfx"));
		item.setSbdw(request.getParameter("sbdw"));
		item.setLxr(request.getParameter("lxr"));
		item.setLxdh(request.getParameter("lxdh"));
		item.setChdw(request.getParameter("chdw"));
		item.setLxr1(request.getParameter("lxr1"));
		item.setLxdh1(request.getParameter("lxdh1"));
		item.setBgs(request.getParameter("bgs"));
        
        
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("bssj"));
			item.setBssj(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
		item.setLb1(request.getParameter("lb1"));
		item.setLb2(request.getParameter("lb2"));
		item.setDzyx(request.getParameter("dzyx"));
		item.setDzyx1(request.getParameter("dzyx1"));
		item.setDzyx2(request.getParameter("dzyx2"));
		item.setZzdj(request.getParameter("zzdj"));
		item.setCbdw(request.getParameter("cbdw"));
		item.setLxr2(request.getParameter("lxr2"));
		item.setLxdh2(request.getParameter("lxdh2"));
		item.setHzfs(request.getParameter("hzfs"));
		item.setLygc(request.getParameter("lygc"));
		item.setJstj(request.getParameter("jstj"));
		item.setJsjjzb(request.getParameter("jsjjzb"));
		item.setTjzk(request.getParameter("tjzk"));
		
		CbxmDao.update(item);	
			
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
	
		ProCbxm item = CbxmDao.getObjById(id);
		
		request.setAttribute("item", item);
		request.setAttribute("dqlist", CbxmDao.getDqList());
		request.setAttribute("lblist", CbxmDao.getLbList());
		request.getRequestDispatcher("xg.jsp").forward(request, response);
	}
	/**
	 * 跳转到浏览页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goReadPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		long id   = Long.valueOf(request.getParameter("id"));
		
		ProCbxm item = CbxmDao.getObjById(id);
		
		request.setAttribute("item", item);
		request.setAttribute("dqlist", CbxmDao.getDqList());
		request.setAttribute("lblist", CbxmDao.getLbList());
		request.getRequestDispatcher("xmll.jsp").forward(request, response);
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
		
		long id   = Long.valueOf(request.getParameter("id"));
	
		ProCbxm item = CbxmDao.getObjById(id);
		
		request.setAttribute("item", item);

		request.getRequestDispatcher("ll.jsp").forward(request, response);
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
		
		ProCbxm item = new ProCbxm();
	
		item.setNd(Long.valueOf(request.getParameter("nd")));
		item.setBh(request.getParameter("bh"));
		item.setMc(request.getParameter("mc"));
		item.setDq(request.getParameter("dq"));
		item.setJsgm(request.getParameter("jsgm"));
		item.setJsdd(request.getParameter("jsdd"));
		
		if(request.getParameter("ztz") == null || request.getParameter("ztz").equals("")){
			item.setZtz((double) 0l);
		}else{
			item.setZtz(Double.valueOf(request.getParameter("ztz")));
		}

		item.setXyfx(request.getParameter("xyfx"));
		item.setSbdw(request.getParameter("sbdw"));
		item.setLxr(request.getParameter("lxr"));
		item.setLxdh(request.getParameter("lxdh"));
		item.setChdw(request.getParameter("chdw"));
		item.setLxr1(request.getParameter("lxr1"));
		item.setLxdh1(request.getParameter("lxdh1"));
		item.setBgs(request.getParameter("bgs"));
		item.setLb1(request.getParameter("lb1"));
		item.setLb2(request.getParameter("lb2"));
		
		item.setDzyx(request.getParameter("dzyx"));
		item.setDzyx1(request.getParameter("dzyx1"));
		item.setDzyx2(request.getParameter("dzyx2"));
		item.setZzdj(request.getParameter("zzdj"));
		item.setCbdw(request.getParameter("cbdw"));
		item.setLxr2(request.getParameter("lxr2"));
		item.setLxdh2(request.getParameter("lxdh2"));
		item.setHzfs(request.getParameter("hzfs"));
		item.setLygc(request.getParameter("lygc"));
		item.setJstj(request.getParameter("jstj"));
		item.setJsjjzb(request.getParameter("jsjjzb"));
		item.setTjzk(request.getParameter("tjzk"));
		item.setZt("已审核");
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd;
		try {
			dd = sdf.parse(request.getParameter("bssj"));
			item.setBssj(new java.sql.Date( dd.getTime() )  );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		

		CbxmDao.add(item);
	
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideAddFrame();</script>"); 
		out.flush();
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
		request.setAttribute("dqlist", CbxmDao.getDqList());
		request.setAttribute("lblist", CbxmDao.getLbList());
		request.getRequestDispatcher("lr.jsp").forward(request, response);
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
		 	
		if(CbxmDao.delItemList(itemList)){
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
		Pager pager = CbxmDao.getObjForPage(pageNo, pageSize,searchStr);
	
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
		Pager pager = CbxmDao.getObjForPage(pageNo, pageSize, searchStr);
	
		request.setAttribute("pager", pager);
		request.setAttribute("searchStr", searchStr);
		

		request.getRequestDispatcher("gl.jsp").forward(request, response);
		
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
		Pager pager = CbxmDao.getObjForAudit(pageNo, pageSize,searchStr);
	
		request.setAttribute("pager", pager);
		request.setAttribute("searchStr", searchStr);
		

		request.getRequestDispatcher("sh.jsp").forward(request, response);

	}
	
	
	/**
	 * post请求加载列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void postAudit(HttpServletRequest request, HttpServletResponse response) 
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
		Pager pager = CbxmDao.getObjForAudit(pageNo, pageSize, searchStr);
	
		request.setAttribute("pager", pager);
		request.setAttribute("searchStr", searchStr);
		
		request.getRequestDispatcher("sh.jsp").forward(request, response);

	}
	/**
	 * 发布
	 * @throws IOException 
	 */
	
	 public void  publishMsg(HttpServletRequest request, HttpServletResponse response) throws IOException{
		   Long id = Long.valueOf(request.getParameter("id"));
		   ProCbxm item = CbxmDao.getObjById(id);
		  boolean flag = CbxmDao.saveToWebInfo(item);
		   if(flag==true){
			   response.setContentType("application/json;charset=utf-8");
			   PrintWriter out = response.getWriter();
			   out.print("{\"result\":\"0\"}");
		   }else{
			   response.setContentType("application/json;charset=utf-8");
			   PrintWriter out = response.getWriter();
			   out.print("{\"result\":\"1\"}");
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

}
