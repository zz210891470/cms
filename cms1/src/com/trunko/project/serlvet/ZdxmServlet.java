package com.trunko.project.serlvet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.util.FavoritesHelper;
import com.trunko.cms.util.Pager;
import com.trunko.project.dao.ZdxmDao;
import com.trunko.project.entity.ProZdxm;
import com.trunko.project.entity.ProZdxmYb;
import com.trunko.project.vo.FjFlInfo;

public class ZdxmServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String action=request.getParameter("action"); 
	    if(action.equals("list")){//显示列表
		    getList(request, response);
	    }
	    else if(action.equals("toAdd")){//跳转到添加页面
	    	int type = FavoritesHelper.stringToint(request.getParameter("type")); // 跳转类型
		    goAddPage(request, response, type);
	    }
	    else if(action.equals("toEdit")){//跳转到编辑页面
		    goEditPage(request, response);
	    }
	    else if(action.equals("toRead")){//跳转到查看详情页面
		    goReadPage(request, response);
	    }
	    else if(action.equals("audit")){//跳转到待审核类别页面
	    	getAudit(request, response);
	    }
	    else if(action.equals("toAudit")){//审核
	    	goAuditPage(request,response);
	    }
	    else if(action.equals("xxhz")){   //信息汇总	
	    	Xxhz(request,response);
	    }
	    else if(action.equals("ybxxhz")){   //月报信息汇总	
	    	ybXxhz(request,response);
	    }
	    else if(action.equals("xxhzpage")){   //信息汇总 页面
	    	toXxhzPage(request,response);
	    }
	    else if(action.equals("getXxfjhzInfo")){   //ajax信息分级汇总数据
	    	getXxfjhzInfo(request,response);
	    }
	    else if(action.equals("xxfjhzpage")){   //信息分级汇总 页面
	    	toXxfjhzpage(request,response);
	    }
	    else if(action.equals("xxjdhzpage")){   //形象进度查询
	    	toXxjdhzpage(request,response);
	    }
	    else if(action.equals("zyxxjd")){   //主要形象进度
	    	toZyxxjdpage(request,response);
	    }
	    else if(action.equals("xxjdhz")){   //跳转至形象进度查询条件填写页面
	    	xxjdhz(request,response);
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
	    	int type = FavoritesHelper.stringToint(request.getParameter("type")); // 跳转类型
		    goAddPage(request, response, type);
	    }
	    else if(action.equals("add")){//添加列表项
	    	int type = FavoritesHelper.stringToint(request.getParameter("type")); // 跳转类型
		    add(request, response, type);
	    }
	    else if(action.equals("toEdit")){//跳转到编辑页面
		    goEditPage(request, response);
	    }
	    else if(action.equals("update")){//修改列表项
		    update(request, response);
	    }
	    else if(action.equals("audit")){//跳转到待审核类别页面
	    	getAudit(request, response);
	    }
	    else if(action.equals("auditSearch")){//跳转到待审核类别页面
	    	getAuditSearch(request, response);
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
	    else if(action.equals("ybxxhzpage")){   //月报信息汇总 页面
	    	toYbxxhzPage(request,response);
	    }
	    else if(action.equals("xxflhzpage")){   //信息分类汇总  add by lhanliang
	    	toFlhzPage(request,response);
	    }else if(action.equals("cyflhzpage")){   //按产业信息汇总
	    	toCyflhzPage(request,response);	
	    	
	    }else if(action.equals("cymxhzpage")){   //按产业明细汇总
	    	toCymxhzPage(request,response);
	    }

	    else if(action.equals("getXxfjhzInfo")){   //ajax信息分级汇总数据
	    	getXxfjhzInfo(request,response);
	    }
	    else if(action.equals("xxfjhzpage")){   //信息分级汇总 页面
	    	toXxfjhzpage(request,response);
	    }
	    else if(action.equals("getXxflhzInfo")){   //ajax信息分级汇总数据
	    	getXxflhzInfo(request,response);
	    }else if(action.equals("getFcyhzInfo")){   //ajax按产业分级汇总数据
	    	getFcyhzInfo(request,response);
	    	
	    }else if(action.equals("getFcymxhzInfo")){ //ajax按产业明细汇总
	    	getFcymxhzInfo(request,response);
	    }
	    
	    else if(action.equals("xxjdhzpage")){   //形象进度查询
	    	toXxjdhzpage(request,response);
	    }
	    else if(action.equals("zyxxjd")){   //主要形象进度
	    	toZyxxjdpage(request,response);
	    }
	    else if(action.equals("zjdwqkpage")){   //资金到位情况
	    	toZjdwqkpage(request,response);
	    }
	}
	
	/**
	 * 资金到位情况
	 * @param request 请求
	 * @param response 响应
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toZjdwqkpage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String nd =	request.getParameter("year");  // 年度
		String fromMonth = request.getParameter("fromMonth");  // 开始月份
		String toMonth = request.getParameter("toMonth");  // 结束月份
		
		// 获取资金到位情况
		List<ProZdxmYb> itemList = ZdxmDao.showZjdwqkList(nd, fromMonth, toMonth);
	
		
		request.setAttribute("nd", nd);
		request.setAttribute("fromMonth", fromMonth);
		request.setAttribute("toMonth", toMonth);
		
		
		//报表数据
		String tableDataString = "";
		//合计数据
		ProZdxmYb hj = new ProZdxmYb();
		//在建数据
		ProZdxmYb zj = new ProZdxmYb();
		//预备数据
		ProZdxmYb yb = new ProZdxmYb();

		
		for(int i = 0 ; i <itemList.size() ; i++){
			hj.setZtz(hj.getZtz() + itemList.get(i).getZtz());
			hj.setQnwctz(hj.getQnwctz() + itemList.get(i).getQnwctz());
			hj.setNdjhtz(hj.getNdjhtz() + itemList.get(i).getNdjhtz());
			hj.setNczbywc(hj.getNczbywc() + itemList.get(i).getNczbywc());
			hj.setDnljdwhj(hj.getDnljdwhj() + itemList.get(i).getDnljdwhj());
			hj.setKgljwc(hj.getKgljwc() + itemList.get(i).getKgljwc());
			hj.setKgljdwhj(hj.getKgljdwhj() + itemList.get(i).getKgljdwhj());	
		}
		
		if(itemList.size() == 0){
			hj.setDnwctzbl(0);
			hj.setDndwzjbl(0);
			hj.setKgwctzbl(0);
			hj.setKgdwzjbl(0);
		}else {
			
			hj.setDnwctzbl(hj.getNczbywc()*10000/hj.getNdjhtz());
			hj.setDndwzjbl(hj.getDnljdwhj()*10000/hj.getNdjhtz());
			hj.setKgwctzbl(hj.getKgljwc()*10000/hj.getZtz());
			hj.setKgdwzjbl(hj.getKgljdwhj()*10000/hj.getZtz());
		}
		
		
		tableDataString += "<tr style=\"height:28px;color:red;font-weight:bold\">" +
				           "<td align=\"center\" ></td>" +
			               "<td align=\"center\" style=\"color:red;\" >合计("+itemList.size()+"项)</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getZtz()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getQnwctz()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getNdjhtz()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getNczbywc()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+getForFour(hj.getDnwctzbl())+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getDnljdwhj()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+getForFour(hj.getDndwzjbl())+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getKgljwc()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+getForFour(hj.getKgwctzbl())+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getKgljdwhj()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+getForFour(hj.getKgdwzjbl())+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >&nbsp;</td></tr>" ;

		int zjnum = 0;
		for(int i = 0 ; i <itemList.size() ; i++){
			if(itemList.get(i).getLb().equals("在建")){
				zj.setZtz(zj.getZtz() + itemList.get(i).getZtz());
				zj.setQnwctz(zj.getQnwctz() + itemList.get(i).getQnwctz());
				zj.setNdjhtz(zj.getNdjhtz() + itemList.get(i).getNdjhtz());
				zj.setNczbywc(zj.getNczbywc() + itemList.get(i).getNczbywc());
				zj.setDnljdwhj(zj.getDnljdwhj() + itemList.get(i).getDnljdwhj());
				zj.setKgljwc(zj.getKgljwc() + itemList.get(i).getKgljwc());
				zj.setKgljdwhj(zj.getKgljdwhj() + itemList.get(i).getKgljdwhj());
				zjnum++;
			}
		}
		if(zjnum == 0){
			zj.setDnwctzbl(0);
			zj.setDndwzjbl(0);
			zj.setKgwctzbl(0);
			zj.setKgdwzjbl(0);
		}else {
			zj.setDnwctzbl(zj.getNczbywc()*10000/zj.getNdjhtz());
			zj.setDndwzjbl(zj.getDnljdwhj()*10000/zj.getNdjhtz());
			zj.setKgwctzbl(zj.getKgljwc()*10000/zj.getZtz());
			zj.setKgdwzjbl(zj.getKgljdwhj()*10000/zj.getZtz());
			
		}

		
		tableDataString += "<tr style=\"height:28px;font-weight:bold\">" +
				           "<td align=\"center\" >一</td>" +
			               "<td align=\"center\" >在建重点项目("+zjnum+"项)</td>" +
				           "<td align=\"center\" >"+zj.getZtz()+"</td>" +
				           "<td align=\"center\" >"+zj.getQnwctz()+"</td>" +
				           "<td align=\"center\" >"+zj.getNdjhtz()+"</td>" +
				           "<td align=\"center\" >"+zj.getNczbywc()+"</td>" +
				           "<td align=\"center\" >"+getForFour(zj.getDnwctzbl())+"</td>" +
				           "<td align=\"center\" >"+zj.getDnljdwhj()+"</td>" +
				           "<td align=\"center\" >"+getForFour(zj.getDndwzjbl())+"</td>" +
				           "<td align=\"center\" >"+zj.getKgljwc()+"</td>" +
				           "<td align=\"center\" >"+getForFour(zj.getKgwctzbl())+"</td>" +
				           "<td align=\"center\" >"+zj.getKgljdwhj()+"</td>" +
				           "<td align=\"center\" >"+getForFour(zj.getKgdwzjbl())+"</td>" +
				           "<td align=\"center\" >&nbsp;</td></tr>" ;
		
		//得到分级列表
		List<String> lb1list = ZdxmDao.getLb1List();
		
		
		String tempData = "";
		int lb1num = 0;
		
		for(int i = 0; i<lb1list.size(); i++){
			//类别数据
			ProZdxmYb templb1 = new ProZdxmYb();
			//循环查找列表中相应的数据
			for(int j = 0, k = 0; j<itemList.size(); j++){
			
			   if( itemList.get(j).getLb1().equals(lb1list.get(i)) && itemList.get(j).getLb().equals("在建") ){
				   k++;
				   tempData += "<tr style=\"height:28px;\">" +
					           "<td align=\"center\" >"+k+"</td>" +
				               "<td align=\"left\" >"+itemList.get(j).getMc()+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getZtz()+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getQnwctz()+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getNdjhtz()+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getNczbywc()+"</td>" +
					           "<td align=\"center\" >"+getForThree(itemList.get(j).getDnwctzbl()+"")+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getDnljdwhj()+"</td>" +
					           "<td align=\"center\" >"+getForThree(itemList.get(j).getDndwzjbl()+"")+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getKgljwc()+"</td>" +
					           "<td align=\"center\" >"+getForThree(itemList.get(j).getKgwctzbl()+"")+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getKgljdwhj()+"</td>" +
					           "<td align=\"center\" >"+getForThree(itemList.get(j).getKgdwzjbl()+"")+"</td>" +
					           "<td align=\"center\" >&nbsp;</td></tr>" ;
				
				   templb1.setZtz(templb1.getZtz() + itemList.get(j).getZtz());
				   templb1.setQnwctz(templb1.getQnwctz() + itemList.get(j).getQnwctz());
				   templb1.setNdjhtz(templb1.getNdjhtz() + itemList.get(j).getNdjhtz());
				   templb1.setNczbywc(templb1.getNczbywc() + itemList.get(j).getNczbywc());
				   templb1.setDnljdwhj(templb1.getDnljdwhj() + itemList.get(j).getDnljdwhj());
				   templb1.setKgljwc(templb1.getKgljwc() + itemList.get(j).getKgljwc());
				   templb1.setKgljdwhj(templb1.getKgljdwhj() + itemList.get(j).getKgljdwhj());
				   lb1num++;
				   
			   }
			}
			if(lb1num == 0){
				templb1.setDnwctzbl(0);
				templb1.setDndwzjbl(0);
				templb1.setKgwctzbl(0);
				templb1.setKgdwzjbl(0);
			}else {
				templb1.setDnwctzbl(templb1.getNdjhtz()==0?0:(templb1.getNczbywc()*10000/templb1.getNdjhtz()));
				templb1.setDndwzjbl(templb1.getNdjhtz()==0?0:(templb1.getDnljdwhj()*10000/templb1.getNdjhtz()));
				templb1.setKgwctzbl(templb1.getZtz()==0?0:(templb1.getKgljwc()*10000/templb1.getZtz()));
				templb1.setKgdwzjbl(templb1.getZtz()==0?0:(templb1.getKgljdwhj()*10000/templb1.getZtz()));
				
			}
			
			tableDataString += "<tr style=\"height:28px;font-weight:bold\">" +
	           "<td align=\"center\" ></td>" +
               "<td align=\"center\" >"+lb1list.get(i)+"("+lb1num+"项)</td>" +
	           "<td align=\"center\" >"+templb1.getZtz()+"</td>" +
	           "<td align=\"center\" >"+templb1.getQnwctz()+"</td>" +
	           "<td align=\"center\" >"+templb1.getNdjhtz()+"</td>" +
	           "<td align=\"center\" >"+templb1.getNczbywc()+"</td>" +
	           "<td align=\"center\" >"+getForFour(templb1.getDnwctzbl())+"</td>" +
	           "<td align=\"center\" >"+templb1.getDnljdwhj()+"</td>" +
	           "<td align=\"center\" >"+getForFour(templb1.getDndwzjbl())+"</td>" +
	           "<td align=\"center\" >"+templb1.getKgljwc()+"</td>" +
	           "<td align=\"center\" >"+getForFour(templb1.getKgwctzbl())+"</td>" +
	           "<td align=\"center\" >"+templb1.getKgljdwhj()+"</td>" +
	           "<td align=\"center\" >"+getForFour(templb1.getKgdwzjbl())+"</td>" +
	           "<td align=\"center\" >&nbsp;</td></tr>" ;
			tableDataString += tempData;
		    tempData = "";
		    lb1num = 0;
		}
		
		int ybnum = 0;
		for(int i = 0 ; i <itemList.size() ; i++){
			if(itemList.get(i).getLb().equals("预备")){
				yb.setZtz(yb.getZtz() + itemList.get(i).getZtz());
				yb.setQnwctz(yb.getQnwctz() + itemList.get(i).getQnwctz());
				yb.setNdjhtz(yb.getNdjhtz() + itemList.get(i).getNdjhtz());
				yb.setNczbywc(yb.getNczbywc() + itemList.get(i).getNczbywc());
				yb.setDnljdwhj(yb.getDnljdwhj() + itemList.get(i).getDnljdwhj());
				yb.setKgljwc(yb.getKgljwc() + itemList.get(i).getKgljwc());
				yb.setKgljdwhj(yb.getKgljdwhj() + itemList.get(i).getKgljdwhj());
				ybnum++;
			}
		}
		if(ybnum == 0){
			yb.setDnwctzbl(0);
			yb.setDndwzjbl(0);
			yb.setKgwctzbl(0);
			yb.setKgdwzjbl(0);
		}else {
			yb.setDnwctzbl(yb.getNczbywc()*10000/yb.getNdjhtz());
			yb.setDndwzjbl(yb.getDnljdwhj()*10000/yb.getNdjhtz());
			yb.setKgwctzbl(yb.getKgljwc()*10000/yb.getZtz());
			yb.setKgdwzjbl(yb.getKgljdwhj()*10000/yb.getZtz());
			
		}

		
		tableDataString += "<tr style=\"height:28px;font-weight:bold\">" +
				           "<td align=\"center\" >二</td>" +
			               "<td align=\"center\" >预备重点项目("+ybnum+"项)</td>" +
				           "<td align=\"center\" >"+yb.getZtz()+"</td>" +
				           "<td align=\"center\" >"+yb.getQnwctz()+"</td>" +
				           "<td align=\"center\" >"+yb.getNdjhtz()+"</td>" +
				           "<td align=\"center\" >"+yb.getNczbywc()+"</td>" +
				           "<td align=\"center\" >"+getForFour(yb.getDnwctzbl())+"</td>" +
				           "<td align=\"center\" >"+yb.getDnljdwhj()+"</td>" +
				           "<td align=\"center\" >"+getForFour(yb.getDndwzjbl())+"</td>" +
				           "<td align=\"center\" >"+yb.getKgljwc()+"</td>" +
				           "<td align=\"center\" >"+getForFour(yb.getKgwctzbl())+"</td>" +
				           "<td align=\"center\" >"+yb.getKgljdwhj()+"</td>" +
				           "<td align=\"center\" >"+getForFour(yb.getKgdwzjbl())+"</td>" +
				           "<td align=\"center\" >&nbsp;</td></tr>" ;
		

		
		for(int i = 0; i<lb1list.size(); i++){
			//类别数据
			ProZdxmYb templb1 = new ProZdxmYb();
			//循环查找列表中相应的数据
			for(int j = 0, k = 0; j<itemList.size(); j++){
			
			   if( itemList.get(j).getLb1().equals(lb1list.get(i)) && itemList.get(j).getLb().equals("预备") ){
				   k++;
				   tempData += "<tr style=\"height:28px;\">" +
					           "<td align=\"center\" >"+k+"</td>" +
				               "<td align=\"left\" >"+itemList.get(j).getMc()+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getZtz()+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getQnwctz()+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getNdjhtz()+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getNczbywc()+"</td>" +
					           "<td align=\"center\" >"+getForThree(itemList.get(j).getDnwctzbl()+"")+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getDnljdwhj()+"</td>" +
					           "<td align=\"center\" >"+getForThree(itemList.get(j).getDndwzjbl()+"")+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getKgljwc()+"</td>" +
					           "<td align=\"center\" >"+getForThree(itemList.get(j).getKgwctzbl()+"")+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getKgljdwhj()+"</td>" +
					           "<td align=\"center\" >"+getForThree(itemList.get(j).getKgdwzjbl()+"")+"</td>" +
					           "<td align=\"center\" >&nbsp;</td></tr>" ;
				
				   templb1.setZtz(templb1.getZtz() + itemList.get(j).getZtz());
				   templb1.setQnwctz(templb1.getQnwctz() + itemList.get(j).getQnwctz());
				   templb1.setNdjhtz(templb1.getNdjhtz() + itemList.get(j).getNdjhtz());
				   templb1.setNczbywc(templb1.getNczbywc() + itemList.get(j).getNczbywc());
				   templb1.setDnljdwhj(templb1.getDnljdwhj() + itemList.get(j).getDnljdwhj());
				   templb1.setKgljwc(templb1.getKgljwc() + itemList.get(j).getKgljwc());
				   templb1.setKgljdwhj(templb1.getKgljdwhj() + itemList.get(j).getKgljdwhj());
				   lb1num++;
				   
			   }
			}
			if(lb1num == 0){
				templb1.setDnwctzbl(0);
				templb1.setDndwzjbl(0);
				templb1.setKgwctzbl(0);
				templb1.setKgdwzjbl(0);
			}else {
				templb1.setDnwctzbl(templb1.getNdjhtz()==0?0:(templb1.getNczbywc()*10000/templb1.getNdjhtz()));
				templb1.setDndwzjbl(templb1.getNdjhtz()==0?0:(templb1.getDnljdwhj()*10000/templb1.getNdjhtz()));
				templb1.setKgwctzbl(templb1.getZtz()==0?0:(templb1.getKgljwc()*10000/templb1.getZtz()));
				templb1.setKgdwzjbl(templb1.getZtz()==0?0:(templb1.getKgljdwhj()*10000/templb1.getZtz()));
				
			}
			
			tableDataString += "<tr style=\"height:28px;font-weight:bold\">" +
	           "<td align=\"center\" ></td>" +
               "<td align=\"center\" >"+lb1list.get(i)+"("+lb1num+"项)</td>" +
	           "<td align=\"center\" >"+templb1.getZtz()+"</td>" +
	           "<td align=\"center\" >"+templb1.getQnwctz()+"</td>" +
	           "<td align=\"center\" >"+templb1.getNdjhtz()+"</td>" +
	           "<td align=\"center\" >"+templb1.getNczbywc()+"</td>" +
	           "<td align=\"center\" >"+getForFour(templb1.getDnwctzbl())+"</td>" +
	           "<td align=\"center\" >"+templb1.getDnljdwhj()+"</td>" +
	           "<td align=\"center\" >"+getForFour(templb1.getDndwzjbl())+"</td>" +
	           "<td align=\"center\" >"+templb1.getKgljwc()+"</td>" +
	           "<td align=\"center\" >"+getForFour(templb1.getKgwctzbl())+"</td>" +
	           "<td align=\"center\" >"+templb1.getKgljdwhj()+"</td>" +
	           "<td align=\"center\" >"+getForFour(templb1.getKgdwzjbl())+"</td>" +
	           "<td align=\"center\" >&nbsp;</td></tr>" ;
			tableDataString += tempData;
		    tempData = "";
		    lb1num = 0;
		}
		
		
		request.setAttribute("tabledata", tableDataString);
		
		
		request.setAttribute("itemList", itemList);
		// 跳转至信息汇总展示界面
		request.getRequestDispatcher("tj_yb.jsp").forward(request, response);
	}
	
	
	
	
	/**
	 * 主要形象进度
	 * @param request 请求
	 * @param response 响应
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toZyxxjdpage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String nd = request.getParameter("year");  // 年度
		String fromMonth =	request.getParameter("fromMonth");  // 开始月份
		String toMonth = request.getParameter("toMonth");  // 结束月份
		
		// 主要形象进度
		List<ProZdxmYb> itemList = ZdxmDao.showZyxxjdList(nd, fromMonth, toMonth);
	
		
		request.setAttribute("nd", nd);
		request.setAttribute("fromMonth", fromMonth);
		request.setAttribute("toMonth", toMonth);
		
		
		//报表数据
		String tableDataString = "";
		//合计数据
		ProZdxmYb hj = new ProZdxmYb();
		//在建数据
		ProZdxmYb zj = new ProZdxmYb();
		//预备数据
		ProZdxmYb yb = new ProZdxmYb();

		
		for(int i = 0 ; i <itemList.size() ; i++){
			hj.setZtz(hj.getZtz() + itemList.get(i).getZtz());
			hj.setQnwctz(hj.getQnwctz() + itemList.get(i).getQnwctz());
			hj.setNdjhtz(hj.getNdjhtz() + itemList.get(i).getNdjhtz());
			hj.setNczbywc(hj.getNczbywc() + itemList.get(i).getNczbywc());
			hj.setDnljdwhj(hj.getDnljdwhj() + itemList.get(i).getDnljdwhj());
			hj.setKgljwc(hj.getKgljwc() + itemList.get(i).getKgljwc());
			hj.setKgljdwhj(hj.getKgljdwhj() + itemList.get(i).getKgljdwhj());	
		}
		
		if(itemList.size() == 0){
			hj.setDnwctzbl(0);
			hj.setDndwzjbl(0);
			hj.setKgwctzbl(0);
			hj.setKgdwzjbl(0);
		}else {
			hj.setDnwctzbl(hj.getNczbywc()*10000/hj.getNdjhtz());
			hj.setDndwzjbl(hj.getDnljdwhj()*10000/hj.getNdjhtz());
			hj.setKgwctzbl(hj.getKgljwc()*10000/hj.getZtz());
			hj.setKgdwzjbl(hj.getKgljdwhj()*10000/hj.getZtz());
		}
		
		
		tableDataString += "<b>全市重点项目("+itemList.size()+"项)：</b>完成投资"+hj.getNczbywc()+"（万元），占年度计划"+getForFour(hj.getDnwctzbl())+"%，到位资金"+hj.getDnljdwhj()+"（万元），占年度计划"+getForFour(hj.getDndwzjbl())+"%；开工累计完成投资"+hj.getKgljwc()+"（万元），占总计划"+getForFour(hj.getKgwctzbl())+"%，到位资金"+hj.getKgljdwhj()+"（万元），占总计划"+getForFour(hj.getKgdwzjbl())+"%；<br/><br/>";
		int zjnum = 0;
		for(int i = 0 ; i <itemList.size() ; i++){
			if(itemList.get(i).getLb().equals("在建")){
				zj.setZtz(zj.getZtz() + itemList.get(i).getZtz());
				zj.setQnwctz(zj.getQnwctz() + itemList.get(i).getQnwctz());
				zj.setNdjhtz(zj.getNdjhtz() + itemList.get(i).getNdjhtz());
				zj.setNczbywc(zj.getNczbywc() + itemList.get(i).getNczbywc());
				zj.setDnljdwhj(zj.getDnljdwhj() + itemList.get(i).getDnljdwhj());
				zj.setKgljwc(zj.getKgljwc() + itemList.get(i).getKgljwc());
				zj.setKgljdwhj(zj.getKgljdwhj() + itemList.get(i).getKgljdwhj());
				zjnum++;
			}
		}
		if(zjnum == 0){
			zj.setDnwctzbl(0);
			zj.setDndwzjbl(0);
			zj.setKgwctzbl(0);
			zj.setKgdwzjbl(0);
		}else {
			zj.setDnwctzbl(zj.getNczbywc()*10000/zj.getNdjhtz());
			zj.setDndwzjbl(zj.getDnljdwhj()*10000/zj.getNdjhtz());
			zj.setKgwctzbl(zj.getKgljwc()*10000/zj.getZtz());
			zj.setKgdwzjbl(zj.getKgljdwhj()*10000/zj.getZtz());
			
		}

		tableDataString += "<b>一、在建重点项目("+zjnum+"项)：</b> 完成投资"+zj.getNczbywc()+"（万元），占年度计划"+getForFour(zj.getDnwctzbl())+"%，到位资金"+zj.getDnljdwhj()+"（万元），占年度计划"+getForFour(zj.getDndwzjbl())+"%；开工累计完成投资"+zj.getKgljwc()+"（万元），占总计划"+getForFour(zj.getKgwctzbl())+"%，到位资金"+zj.getKgljdwhj()+"（万元），占总计划"+getForFour(zj.getKgdwzjbl())+"%；<br/><br/>";
		
		//得到分级列表
		List<String> lb1list = ZdxmDao.getLb1List();
		
		String tempData = "";
		int lb1num = 0;
		
		for(int i = 0; i<lb1list.size(); i++){

			//类别数据
			ProZdxmYb templb1 = new ProZdxmYb();
			//循环查找列表中相应的数据
			for(int j = 0, k = 0; j<itemList.size(); j++){
				
				if( itemList.get(j).getLb1().equals(lb1list.get(i)) && itemList.get(j).getLb().equals("在建") ){
					k++;
					tempData += "<b>"+k+"."+itemList.get(j).getMc()+"：</b> 完成投资"+itemList.get(j).getNczbywc()+"（万元），占年度计划"+itemList.get(j).getDnwctzbl()+"%，到位资金"+itemList.get(j).getDnljdwhj()+"（万元），占年度计划"+itemList.get(j).getDndwzjbl()+"%；开工累计完成投资"+itemList.get(j).getKgljwc()+"（万元），占总计划"+itemList.get(j).getKgwctzbl()+"%，到位资金"+itemList.get(j).getKgljdwhj()+"（万元），占总计划"+itemList.get(j).getKgdwzjbl()+"%；<br/>";
					tempData += "工程主线形象进度和已开展的主要工作："+ itemList.get(j).getXxjd() +"<br/>";
					tempData += "开工、竣工投产时间、内容及新增生产能力："+ itemList.get(j).getScnl() +"<br/>";
					tempData += "项目推进中存在问题及拟采取的措施和办法："+ itemList.get(j).getCzwt() +"<br/>";
					tempData += "需要政府及有关部门协调解决的问题："+ itemList.get(j).getXtjj() +"<br/>";
					tempData += "下个月工作计划、安排："+ itemList.get(j).getGzjh() +"<br/>";
					tempData += "参建单位新进场情况："+ itemList.get(j).getJcqk() +"<br/>";
					tempData += "资金说明："+ itemList.get(j).getZjsm() +"<br/><br/>";

					templb1.setZtz(templb1.getZtz() + itemList.get(j).getZtz());
					templb1.setQnwctz(templb1.getQnwctz() + itemList.get(j).getQnwctz());
					templb1.setNdjhtz(templb1.getNdjhtz() + itemList.get(j).getNdjhtz());
					templb1.setNczbywc(templb1.getNczbywc() + itemList.get(j).getNczbywc());
					templb1.setDnljdwhj(templb1.getDnljdwhj() + itemList.get(j).getDnljdwhj());
					templb1.setKgljwc(templb1.getKgljwc() + itemList.get(j).getKgljwc());
					templb1.setKgljdwhj(templb1.getKgljdwhj() + itemList.get(j).getKgljdwhj());
					lb1num++;
					
				}
			}
			if(lb1num == 0){
				templb1.setDnwctzbl(0);
				templb1.setDndwzjbl(0);
				templb1.setKgwctzbl(0);
				templb1.setKgdwzjbl(0);
			}else {
				templb1.setDnwctzbl(templb1.getNczbywc()*10000/templb1.getNdjhtz());
				templb1.setDndwzjbl(templb1.getDnljdwhj()*10000/templb1.getNdjhtz());
				templb1.setKgwctzbl(templb1.getKgljwc()*10000/templb1.getZtz());
				templb1.setKgdwzjbl(templb1.getKgljdwhj()*10000/templb1.getZtz());
				
			}
			tableDataString += "<b>"+lb1list.get(i)+"("+lb1num+"项)：</b> 完成投资"+templb1.getNczbywc()+"（万元），占年度计划"+getForFour(templb1.getDnwctzbl())+"%，到位资金"+templb1.getDnljdwhj()+"（万元），占年度计划"+getForFour(templb1.getDndwzjbl())+"%；开工累计完成投资"+templb1.getKgljwc()+"（万元），占总计划"+getForFour(templb1.getKgwctzbl())+"%，到位资金"+templb1.getKgljdwhj()+"（万元），占总计划"+getForFour(templb1.getKgdwzjbl())+"%；<br/><br/>";
			tableDataString += tempData;
			tempData = "";
			lb1num = 0;
		}
		
		int ybnum = 0;
		for(int i = 0 ; i <itemList.size() ; i++){
			if(itemList.get(i).getLb().equals("预备")){
				yb.setZtz(yb.getZtz() + itemList.get(i).getZtz());
				yb.setQnwctz(yb.getQnwctz() + itemList.get(i).getQnwctz());
				yb.setNdjhtz(yb.getNdjhtz() + itemList.get(i).getNdjhtz());
				yb.setNczbywc(yb.getNczbywc() + itemList.get(i).getNczbywc());
				yb.setDnljdwhj(yb.getDnljdwhj() + itemList.get(i).getDnljdwhj());
				yb.setKgljwc(yb.getKgljwc() + itemList.get(i).getKgljwc());
				yb.setKgljdwhj(yb.getKgljdwhj() + itemList.get(i).getKgljdwhj());
				ybnum++;
			}
		}
		if(ybnum == 0){
			yb.setDnwctzbl(0);
			yb.setDndwzjbl(0);
			yb.setKgwctzbl(0);
			yb.setKgdwzjbl(0);
		}else {
			yb.setDnwctzbl(yb.getNczbywc()*10000/yb.getNdjhtz());
			yb.setDndwzjbl(yb.getDnljdwhj()*10000/yb.getNdjhtz());
			yb.setKgwctzbl(yb.getKgljwc()*10000/yb.getZtz());
			yb.setKgdwzjbl(yb.getKgljdwhj()*10000/yb.getZtz());
			
		}
		
		
		tableDataString += "<b>二、预备重点项目("+ybnum+"项)：</b> 完成投资"+yb.getNczbywc()+"（万元），占年度计划"+getForFour(yb.getDnwctzbl())+"%，到位资金"+yb.getDnljdwhj()+"（万元），占年度计划"+getForFour(yb.getDndwzjbl())+"%；开工累计完成投资"+yb.getKgljwc()+"（万元），占总计划"+getForFour(yb.getKgwctzbl())+"%，到位资金"+yb.getKgljdwhj()+"（万元），占总计划"+getForFour(yb.getKgdwzjbl())+"%；<br/><br/>";

		
		
		
		for(int i = 0; i<lb1list.size(); i++){

			//类别数据
			ProZdxmYb templb1 = new ProZdxmYb();
			//循环查找列表中相应的数据
			for(int j = 0, k = 0; j<itemList.size(); j++){
				
				if( itemList.get(j).getLb1().equals(lb1list.get(i)) && itemList.get(j).getLb().equals("预备") ){
					k++;
					tempData += "<b>"+k+"."+itemList.get(j).getMc()+"：</b> 完成投资"+itemList.get(j).getNczbywc()+"（万元），占年度计划"+itemList.get(j).getDnwctzbl()+"%，到位资金"+itemList.get(j).getDnljdwhj()+"（万元），占年度计划"+itemList.get(j).getDndwzjbl()+"%；开工累计完成投资"+itemList.get(j).getKgljwc()+"（万元），占总计划"+itemList.get(j).getKgwctzbl()+"%，到位资金"+itemList.get(j).getKgljdwhj()+"（万元），占总计划"+itemList.get(j).getKgdwzjbl()+"%；<br/>";
					tempData += "工程主线形象进度和已开展的主要工作："+ itemList.get(j).getXxjd() +"<br/>";
					tempData += "开工、竣工投产时间、内容及新增生产能力："+ itemList.get(j).getScnl() +"<br/>";
					tempData += "项目推进中存在问题及拟采取的措施和办法："+ itemList.get(j).getCzwt() +"<br/>";
					tempData += "需要政府及有关部门协调解决的问题："+ itemList.get(j).getXtjj() +"<br/>";
					tempData += "下个月工作计划、安排："+ itemList.get(j).getGzjh() +"<br/>";
					tempData += "参建单位新进场情况："+ itemList.get(j).getJcqk() +"<br/>";
					tempData += "资金说明："+ itemList.get(j).getZjsm() +"<br/><br/>";
					
					templb1.setZtz(templb1.getZtz() + itemList.get(j).getZtz());
					templb1.setQnwctz(templb1.getQnwctz() + itemList.get(j).getQnwctz());
					templb1.setNdjhtz(templb1.getNdjhtz() + itemList.get(j).getNdjhtz());
					templb1.setNczbywc(templb1.getNczbywc() + itemList.get(j).getNczbywc());
					templb1.setDnljdwhj(templb1.getDnljdwhj() + itemList.get(j).getDnljdwhj());
					templb1.setKgljwc(templb1.getKgljwc() + itemList.get(j).getKgljwc());
					templb1.setKgljdwhj(templb1.getKgljdwhj() + itemList.get(j).getKgljdwhj());
					lb1num++;
					
				}
			}
			if(lb1num == 0){
				templb1.setDnwctzbl(0);
				templb1.setDndwzjbl(0);
				templb1.setKgwctzbl(0);
				templb1.setKgdwzjbl(0);
			}else {
				templb1.setDnwctzbl(templb1.getNdjhtz()==0?0:templb1.getNczbywc()*10000/templb1.getNdjhtz());
				templb1.setDndwzjbl(templb1.getNdjhtz()==0?0:templb1.getDnljdwhj()*10000/templb1.getNdjhtz());
				templb1.setKgwctzbl(templb1.getZtz()==0?0:templb1.getKgljwc()*10000/templb1.getZtz());
				templb1.setKgdwzjbl(templb1.getZtz()==0?0:templb1.getKgljdwhj()*10000/templb1.getZtz());
				
			}
			
			tableDataString += "<b>"+lb1list.get(i)+"("+lb1num+"项)：</b> 完成投资"+templb1.getNczbywc()+"（万元），占年度计划"+getForFour(templb1.getDnwctzbl())+"%，到位资金"+templb1.getDnljdwhj()+"（万元），占年度计划"+getForFour(templb1.getDndwzjbl())+"%；开工累计完成投资"+templb1.getKgljwc()+"（万元），占总计划"+getForFour(templb1.getKgwctzbl())+"%，到位资金"+templb1.getKgljdwhj()+"（万元），占总计划"+getForFour(templb1.getKgdwzjbl())+"%；<br/><br/>";
			tableDataString += tempData;
			tempData = "";
			lb1num = 0;
		}
		
		request.setAttribute("tabledata", tableDataString);
		
		
		request.setAttribute("itemList", itemList);
		// 跳转至信息汇总展示界面
		request.getRequestDispatcher("tj_zyxxjd_page.jsp").forward(request, response);
		
	}
	/**
	 * 形象进度查询
	 * @param request 请求
	 * @param response 响应
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toXxjdhzpage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String nd =	request.getParameter("nd");  // 年度
		String fromMonth = request.getParameter("fromMonth");  // 开始月份
		String toMonth = request.getParameter("toMonth");  // 结束月份
		String lb1 = request.getParameter("lb1");// 类别：大类
		String lb2 = request.getParameter("lb2");// 类别：小类
		String dq = request.getParameter("dq");// 所属地区
		
		// 总投资
		String ztz1 = request.getParameter("ztz1");// 判断符（全部、大于等于、等于）
		String ztz1num = request.getParameter("ztz2");// 数值1
		String ztz2 = request.getParameter("ztz3");// 判断符（全部、小于）
		String ztz2num = request.getParameter("ztz4");// 数值2
		// 完成投资
		String wctz1 = request.getParameter("wctz1");// 判断符（全部、大于等于、等于）
		String wctz1num = request.getParameter("wctz2");// 数值1
		String wctz2 = request.getParameter("wctz3");// 判断符（全部、小于）
		String wctz2num = request.getParameter("wctz4");// 数值2
		// 计划投资
		String jhtz1 = request.getParameter("jhtz1");// 判断符（全部、大于等于、等于）
		String jhtz1num = request.getParameter("jhtz2");// 数值1
		String jhtz2 = request.getParameter("jhtz3");// 判断符（全部、小于）
		String jhtz2num = request.getParameter("jhtz4");// 判断符（全部、小于）
		// 完成年度计划投资
		String wcjhtz1 = request.getParameter("wcjhtz1");// 判断符（全部、大于等于、等于）
		String wcjhtz1num = request.getParameter("wcjhtz2");// 数值1
		String wcjhtz2 = request.getParameter("wcjhtz3");// 判断符（全部、小于）
		String wcjhtz2num = request.getParameter("wcjhtz4");// 判断符（全部、小于）
		
		String sfscx = request.getParameter("sfscx"); // 是否生产性
		String sfzz = request.getParameter("sfzz"); // 是否重中之重
		String sfss = request.getParameter("sfss");  // 是否省项目
		String sfzy = request.getParameter("sfzy"); // 是否资源
		String sjslb = request.getParameter("sjslb");  // 10+3类别
		String tzztxz = request.getParameter("tzztxz");  // 项目投资主体
		
		String kgFromNd = request.getParameter("kgFromNd");  // 项目开工年份（开始）
		String kgToNd = request.getParameter("kgToNd");  // 项目开工年份（结束）
		String kgFromMonth = request.getParameter("kgFromMonth");  // 项目开工月份（开始）
		String kgToMonth = request.getParameter("kgToMonth");  // 项目开工月份（结束）
		
		// 获取重点月报项目信息
		List<ProZdxmYb> itemList = ZdxmDao.showXxjdhzList(nd, fromMonth, toMonth, lb1, lb2, dq, ztz1, ztz1num, ztz2, ztz2num, wctz1, wctz1num, wctz2, wctz2num, jhtz1, jhtz1num, jhtz2, jhtz2num, wcjhtz1, wcjhtz1num, wcjhtz2, wcjhtz2num, sfscx, sfzz, sfss, sfzy, sjslb, tzztxz, kgFromNd, kgToNd, kgFromMonth, kgToMonth);
		
		
		request.setAttribute("nd", nd);
		request.setAttribute("fromMonth", fromMonth);
		request.setAttribute("toMonth", toMonth);
		
		
		//报表数据
		String tableDataString = "";
		//合计数据
		ProZdxmYb hj = new ProZdxmYb();
		//在建数据
		ProZdxmYb zj = new ProZdxmYb();
		//预备数据
		ProZdxmYb yb = new ProZdxmYb();
		
		
		for(int i = 0 ; i <itemList.size() ; i++){
			hj.setZtz(hj.getZtz() + itemList.get(i).getZtz());
			hj.setQnwctz(hj.getQnwctz() + itemList.get(i).getQnwctz());
			hj.setNdjhtz(hj.getNdjhtz() + itemList.get(i).getNdjhtz());
			hj.setNczbywc(hj.getNczbywc() + itemList.get(i).getNczbywc());
			hj.setDnljdwhj(hj.getDnljdwhj() + itemList.get(i).getDnljdwhj());
			hj.setKgljwc(hj.getKgljwc() + itemList.get(i).getKgljwc());
			hj.setKgljdwhj(hj.getKgljdwhj() + itemList.get(i).getKgljdwhj());	
		}
		
		if(itemList.size() == 0){
			hj.setDnwctzbl(0);
			hj.setDndwzjbl(0);
			hj.setKgwctzbl(0);
			hj.setKgdwzjbl(0);
		}else {
			hj.setDnwctzbl(hj.getNczbywc()*10000/hj.getNdjhtz());
			hj.setDndwzjbl(hj.getDnljdwhj()*10000/hj.getNdjhtz());
			hj.setKgwctzbl(hj.getKgljwc()*10000/hj.getZtz());
			hj.setKgdwzjbl(hj.getKgljdwhj()*10000/hj.getZtz());
		}
		
		
		tableDataString += "<tr style=\"height:28px;color:red;font-weight:bold\">" +
		"<td align=\"center\" >&nbsp;</td>" +
		"<td align=\"left\" style=\"color:red;\" >合计("+itemList.size()+"项)</td>" +
		"<td align=\"right\" style=\"color:red;\" >"+hj.getZtz()+"</td>" +
		"<td align=\"right\" style=\"color:red;\" >"+hj.getQnwctz()+"</td>" +
		"<td align=\"right\" style=\"color:red;\" >"+hj.getNdjhtz()+"</td>" +
		"<td align=\"right\" style=\"color:red;\" >"+hj.getNczbywc()+"</td>" +
		"<td align=\"right\" style=\"color:red;\" >"+getForFour(hj.getDnwctzbl())+"</td>" +
		"<td align=\"right\" style=\"color:red;\" >"+hj.getDnljdwhj()+"</td>" +
		"<td align=\"right\" style=\"color:red;\" >"+getForFour(hj.getDndwzjbl())+"</td>" +
		"<td align=\"right\" style=\"color:red;\" >"+hj.getKgljwc()+"</td>" +
		"<td align=\"right\" style=\"color:red;\" >"+getForFour(hj.getKgwctzbl())+"</td>" +
		"<td align=\"right\" style=\"color:red;\" >"+hj.getKgljdwhj()+"</td>" +
		"<td align=\"right\" style=\"color:red;\" >"+getForFour(hj.getKgdwzjbl())+"</td>" +
		"<td align=\"center\" style=\"color:red;\" >&nbsp;</td>" +
		"<td align=\"center\" style=\"color:red;\" >&nbsp;</td>" +
		"<td align=\"center\" style=\"color:red;\" >&nbsp;</td>" +
		"<td align=\"center\" style=\"color:red;\" >&nbsp;</td>" +
		"<td align=\"center\" style=\"color:red;\" >&nbsp;</td>" +
		"<td align=\"center\" style=\"color:red;\" >&nbsp;</td></tr>" ;
		
		int zjnum = 0;
		for(int i = 0 ; i <itemList.size() ; i++){
			if(itemList.get(i).getLb().equals("在建")){
				zj.setZtz(zj.getZtz() + itemList.get(i).getZtz());
				zj.setQnwctz(zj.getQnwctz() + itemList.get(i).getQnwctz());
				zj.setNdjhtz(zj.getNdjhtz() + itemList.get(i).getNdjhtz());
				zj.setNczbywc(zj.getNczbywc() + itemList.get(i).getNczbywc());
				zj.setDnljdwhj(zj.getDnljdwhj() + itemList.get(i).getDnljdwhj());
				zj.setKgljwc(zj.getKgljwc() + itemList.get(i).getKgljwc());
				zj.setKgljdwhj(zj.getKgljdwhj() + itemList.get(i).getKgljdwhj());
				zjnum++;
			}
		}
		if(zjnum == 0){
			zj.setDnwctzbl(0);
			zj.setDndwzjbl(0);
			zj.setKgwctzbl(0);
			zj.setKgdwzjbl(0);
		}else {
			zj.setDnwctzbl(zj.getNczbywc()*10000/zj.getNdjhtz());
			zj.setDndwzjbl(zj.getDnljdwhj()*10000/zj.getNdjhtz());
			zj.setKgwctzbl(zj.getKgljwc()*10000/zj.getZtz());
			zj.setKgdwzjbl(zj.getKgljdwhj()*10000/zj.getZtz());
			
		}
		
		
		tableDataString += "<tr style=\"height:28px;font-weight:bold\">" +
		"<td align=\"center\" >一</td>" +
		"<td align=\"left\" >在建重点项目("+zjnum+"项)</td>" +
		"<td align=\"right\" >"+zj.getZtz()+"</td>" +
		"<td align=\"right\" >"+zj.getQnwctz()+"</td>" +
		"<td align=\"right\" >"+zj.getNdjhtz()+"</td>" +
		"<td align=\"right\" >"+zj.getNczbywc()+"</td>" +
		"<td align=\"right\" >"+getForFour(zj.getDnwctzbl())+"</td>" +
		"<td align=\"right\" >"+zj.getDnljdwhj()+"</td>" +
		"<td align=\"right\" >"+getForFour(zj.getDndwzjbl())+"</td>" +
		"<td align=\"right\" >"+zj.getKgljwc()+"</td>" +
		"<td align=\"right\" >"+getForFour(zj.getKgwctzbl())+"</td>" +
		"<td align=\"right\" >"+zj.getKgljdwhj()+"</td>" +
		"<td align=\"right\" >"+getForFour(zj.getKgdwzjbl())+"</td>" +
		"<td align=\"center\" >&nbsp;</td>" + 
		"<td align=\"center\" >&nbsp;</td>" + 
		"<td align=\"center\" >&nbsp;</td>" + 
		"<td align=\"center\" >&nbsp;</td>" + 
		"<td align=\"center\" >&nbsp;</td>" + 
		"<td align=\"center\" >&nbsp;</td></tr>" ;
		
		//得到分级列表
		List<String> lb1list = ZdxmDao.getLb1List();
		
		String tempData = "";
		int lb1num = 0;
		
		for(int i = 0; i<lb1list.size(); i++){
			//类别数据
			ProZdxmYb templb1 = new ProZdxmYb();
			//循环查找列表中相应的数据
			for(int j = 0, k = 0; j<itemList.size(); j++){
				
				if( itemList.get(j).getLb1().equals(lb1list.get(i)) && itemList.get(j).getLb().equals("在建") ){
					k++;
					tempData += "<tr style=\"height:28px;\">" +
					"<td align=\"center\" >"+k+"</td>" +
					"<td align=\"left\" >"+itemList.get(j).getMc()+"</td>" +
					"<td align=\"right\" >"+itemList.get(j).getZtz()+"</td>" +
					"<td align=\"right\" >"+itemList.get(j).getQnwctz()+"</td>" +
					"<td align=\"right\" >"+itemList.get(j).getNdjhtz()+"</td>" +
					"<td align=\"right\" >"+itemList.get(j).getNczbywc()+"</td>" +
					"<td align=\"right\" >"+getForThree(itemList.get(j).getDnwctzbl()+"")+"</td>" +
					"<td align=\"right\" >"+itemList.get(j).getDnljdwhj()+"</td>" +
					"<td align=\"right\" >"+getForThree(itemList.get(j).getDndwzjbl()+"")+"</td>" +
					"<td align=\"right\" >"+itemList.get(j).getKgljwc()+"</td>" +
					"<td align=\"right\" >"+getForThree(itemList.get(j).getKgwctzbl()+"")+"</td>" +
					"<td align=\"right\" >"+itemList.get(j).getKgljdwhj()+"</td>" +
					"<td align=\"right\" >"+getForThree(itemList.get(j).getKgdwzjbl()+"")+"</td>" +
					"<td align=\"center\" >"+itemList.get(j).getXxjd()+"&nbsp;</td>" + 
					"<td align=\"center\" >"+itemList.get(j).getScnl()+"&nbsp;</td>" + 
					"<td align=\"center\" >"+itemList.get(j).getCzwt()+"&nbsp;</td>" + 
					"<td align=\"center\" >"+itemList.get(j).getXtjj()+"&nbsp;</td>" + 
					"<td align=\"center\" >"+itemList.get(j).getGzjh()+"&nbsp;</td>" + 
					"<td align=\"center\" >&nbsp;</td></tr>" ;
					
					templb1.setZtz(templb1.getZtz() + itemList.get(j).getZtz());
					templb1.setQnwctz(templb1.getQnwctz() + itemList.get(j).getQnwctz());
					templb1.setNdjhtz(templb1.getNdjhtz() + itemList.get(j).getNdjhtz());
					templb1.setNczbywc(templb1.getNczbywc() + itemList.get(j).getNczbywc());
					templb1.setDnljdwhj(templb1.getDnljdwhj() + itemList.get(j).getDnljdwhj());
					templb1.setKgljwc(templb1.getKgljwc() + itemList.get(j).getKgljwc());
					templb1.setKgljdwhj(templb1.getKgljdwhj() + itemList.get(j).getKgljdwhj());
					lb1num++;
					
				}
			}
			if(lb1num == 0){
				templb1.setDnwctzbl(0);
				templb1.setDndwzjbl(0);
				templb1.setKgwctzbl(0);
				templb1.setKgdwzjbl(0);
			}else {
				templb1.setDnwctzbl(templb1.getNczbywc()*10000/templb1.getNdjhtz());
				templb1.setDndwzjbl(templb1.getDnljdwhj()*10000/templb1.getNdjhtz());
				templb1.setKgwctzbl(templb1.getKgljwc()*10000/templb1.getZtz());
				templb1.setKgdwzjbl(templb1.getKgljdwhj()*10000/templb1.getZtz());
				
			}
			
			tableDataString += "<tr style=\"height:28px;font-weight:bold\">" +
			"<td align=\"center\" >&nbsp;</td>" +
			"<td align=\"left\" >"+lb1list.get(i)+"("+lb1num+"项)</td>" +
			"<td align=\"right\" >"+templb1.getZtz()+"</td>" +
			"<td align=\"right\" >"+templb1.getQnwctz()+"</td>" +
			"<td align=\"right\" >"+templb1.getNdjhtz()+"</td>" +
			"<td align=\"right\" >"+templb1.getNczbywc()+"</td>" +
			"<td align=\"right\" >"+getForFour(templb1.getDnwctzbl())+"</td>" +
			"<td align=\"right\" >"+templb1.getDnljdwhj()+"</td>" +
			"<td align=\"right\" >"+getForFour(templb1.getDndwzjbl())+"</td>" +
			"<td align=\"right\" >"+templb1.getKgljwc()+"</td>" +
			"<td align=\"right\" >"+getForFour(templb1.getKgwctzbl())+"</td>" +
			"<td align=\"right\" >"+templb1.getKgljdwhj()+"</td>" +
			"<td align=\"right\" >"+getForFour(templb1.getKgdwzjbl())+"</td>" +
			"<td align=\"center\" >&nbsp;</td>" + 
			"<td align=\"center\" >&nbsp;</td>" + 
			"<td align=\"center\" >&nbsp;</td>" + 
			"<td align=\"center\" >&nbsp;</td>" + 
			"<td align=\"center\" >&nbsp;</td>" + 
			"<td align=\"center\" >&nbsp;</td></tr>" ;
			tableDataString += tempData;
			tempData = "";
			lb1num = 0;
		}
		
		int ybnum = 0;
		for(int i = 0 ; i <itemList.size() ; i++){
			if(itemList.get(i).getLb().equals("预备")){
				yb.setZtz(yb.getZtz() + itemList.get(i).getZtz());
				yb.setQnwctz(yb.getQnwctz() + itemList.get(i).getQnwctz());
				yb.setNdjhtz(yb.getNdjhtz() + itemList.get(i).getNdjhtz());
				yb.setNczbywc(yb.getNczbywc() + itemList.get(i).getNczbywc());
				yb.setDnljdwhj(yb.getDnljdwhj() + itemList.get(i).getDnljdwhj());
				yb.setKgljwc(yb.getKgljwc() + itemList.get(i).getKgljwc());
				yb.setKgljdwhj(yb.getKgljdwhj() + itemList.get(i).getKgljdwhj());
				ybnum++;
			}
		}
		if(ybnum == 0){
			yb.setDnwctzbl(0);
			yb.setDndwzjbl(0);
			yb.setKgwctzbl(0);
			yb.setKgdwzjbl(0);
		}else {
			yb.setDnwctzbl(yb.getNczbywc()*10000/yb.getNdjhtz());
			yb.setDndwzjbl(yb.getDnljdwhj()*10000/yb.getNdjhtz());
			yb.setKgwctzbl(yb.getKgljwc()*10000/yb.getZtz());
			yb.setKgdwzjbl(yb.getKgljdwhj()*10000/yb.getZtz());
			
		}
		
		
		tableDataString += "<tr style=\"height:28px;font-weight:bold\">" +
		"<td align=\"center\" >二</td>" +
		"<td align=\"left\" >预备重点项目("+ybnum+"项)</td>" +
		"<td align=\"right\" >"+yb.getZtz()+"</td>" +
		"<td align=\"right\" >"+yb.getQnwctz()+"</td>" +
		"<td align=\"right\" >"+yb.getNdjhtz()+"</td>" +
		"<td align=\"right\" >"+yb.getNczbywc()+"</td>" +
		"<td align=\"right\" >"+getForFour(yb.getDnwctzbl())+"</td>" +
		"<td align=\"right\" >"+yb.getDnljdwhj()+"</td>" +
		"<td align=\"right\" >"+getForFour(yb.getDndwzjbl())+"</td>" +
		"<td align=\"right\" >"+yb.getKgljwc()+"</td>" +
		"<td align=\"right\" >"+getForFour(yb.getKgwctzbl())+"</td>" +
		"<td align=\"right\" >"+yb.getKgljdwhj()+"</td>" +
		"<td align=\"right\" >"+getForFour(yb.getKgdwzjbl())+"</td>" +
		"<td align=\"center\" >&nbsp;</td>" + 
		"<td align=\"center\" >&nbsp;</td>" + 
		"<td align=\"center\" >&nbsp;</td>" + 
		"<td align=\"center\" >&nbsp;</td>" + 
		"<td align=\"center\" >&nbsp;</td>" + 
		"<td align=\"center\" >&nbsp;</td></tr>" ;
		
		
		
		for(int i = 0; i<lb1list.size(); i++){
			//类别数据
			ProZdxmYb templb1 = new ProZdxmYb();
			//循环查找列表中相应的数据
			for(int j = 0, k = 0; j<itemList.size(); j++){
				
				if( itemList.get(j).getLb1().equals(lb1list.get(i)) && itemList.get(j).getLb().equals("预备") ){
					k++;
					tempData += "<tr style=\"height:28px;\">" +
					"<td align=\"center\" >"+k+"</td>" +
					"<td align=\"left\" >"+itemList.get(j).getMc()+"</td>" +
					"<td align=\"right\" >"+itemList.get(j).getZtz()+"</td>" +
					"<td align=\"right\" >"+itemList.get(j).getQnwctz()+"</td>" +
					"<td align=\"right\" >"+itemList.get(j).getNdjhtz()+"</td>" +
					"<td align=\"right\" >"+itemList.get(j).getNczbywc()+"</td>" +
					"<td align=\"right\" >"+getForThree(itemList.get(j).getDnwctzbl()+"")+"</td>" +
					"<td align=\"right\" >"+itemList.get(j).getDnljdwhj()+"</td>" +
					"<td align=\"right\" >"+getForThree(itemList.get(j).getDndwzjbl()+"")+"</td>" +
					"<td align=\"right\" >"+itemList.get(j).getKgljwc()+"</td>" +
					"<td align=\"right\" >"+getForThree(itemList.get(j).getKgwctzbl()+"")+"</td>" +
					"<td align=\"right\" >"+itemList.get(j).getKgljdwhj()+"</td>" +
					"<td align=\"right\" >"+getForThree(itemList.get(j).getKgdwzjbl()+"")+"</td>" +
					"<td align=\"center\" >"+itemList.get(j).getXxjd()+"&nbsp;</td>" + 
					"<td align=\"center\" >"+itemList.get(j).getScnl()+"&nbsp;</td>" + 
					"<td align=\"center\" >"+itemList.get(j).getCzwt()+"&nbsp;</td>" + 
					"<td align=\"center\" >"+itemList.get(j).getXtjj()+"&nbsp;</td>" + 
					"<td align=\"center\" >"+itemList.get(j).getGzjh()+"&nbsp;</td>" + 
					"<td align=\"center\" >&nbsp;</td></tr>" ;
					
					templb1.setZtz(templb1.getZtz() + itemList.get(j).getZtz());
					templb1.setQnwctz(templb1.getQnwctz() + itemList.get(j).getQnwctz());
					templb1.setNdjhtz(templb1.getNdjhtz() + itemList.get(j).getNdjhtz());
					templb1.setNczbywc(templb1.getNczbywc() + itemList.get(j).getNczbywc());
					templb1.setDnljdwhj(templb1.getDnljdwhj() + itemList.get(j).getDnljdwhj());
					templb1.setKgljwc(templb1.getKgljwc() + itemList.get(j).getKgljwc());
					templb1.setKgljdwhj(templb1.getKgljdwhj() + itemList.get(j).getKgljdwhj());
					lb1num++;
					
				}
			}
			if(lb1num == 0){
				templb1.setDnwctzbl(0);
				templb1.setDndwzjbl(0);
				templb1.setKgwctzbl(0);
				templb1.setKgdwzjbl(0);
			}else {
				templb1.setDnwctzbl(templb1.getNdjhtz()==0?0:templb1.getNczbywc()*10000/templb1.getNdjhtz());
				templb1.setDndwzjbl(templb1.getNdjhtz()==0?0:templb1.getDnljdwhj()*10000/templb1.getNdjhtz());
				templb1.setKgwctzbl(templb1.getZtz()==0?0:templb1.getKgljwc()*10000/templb1.getZtz());
				templb1.setKgdwzjbl(templb1.getZtz()==0?0:templb1.getKgljdwhj()*10000/templb1.getZtz());
				
			}
			
			tableDataString += "<tr style=\"height:28px;font-weight:bold\">" +
			"<td align=\"center\" >&nbsp;</td>" +
			"<td align=\"left\" >"+lb1list.get(i)+"("+lb1num+"项)</td>" +
			"<td align=\"right\" >"+templb1.getZtz()+"</td>" +
			"<td align=\"right\" >"+templb1.getQnwctz()+"</td>" +
			"<td align=\"right\" >"+templb1.getNdjhtz()+"</td>" +
			"<td align=\"right\" >"+templb1.getNczbywc()+"</td>" +
			"<td align=\"right\" >"+getForFour(templb1.getDnwctzbl())+"</td>" +
			"<td align=\"right\" >"+templb1.getDnljdwhj()+"</td>" +
			"<td align=\"right\" >"+getForFour(templb1.getDndwzjbl())+"</td>" +
			"<td align=\"right\" >"+templb1.getKgljwc()+"</td>" +
			"<td align=\"right\" >"+getForFour(templb1.getKgwctzbl())+"</td>" +
			"<td align=\"right\" >"+templb1.getKgljdwhj()+"</td>" +
			"<td align=\"right\" >"+getForFour(templb1.getKgdwzjbl())+"</td>" +
			"<td align=\"center\" >&nbsp;</td>" + 
			"<td align=\"center\" >&nbsp;</td>" + 
			"<td align=\"center\" >&nbsp;</td>" + 
			"<td align=\"center\" >&nbsp;</td>" + 
			"<td align=\"center\" >&nbsp;</td>" + 
			"<td align=\"center\" >&nbsp;</td></tr>" ;
			tableDataString += tempData;
			tempData = "";
			lb1num = 0;
		}
		
		
		request.setAttribute("tabledata", tableDataString);
		
		
		request.setAttribute("itemList", itemList);
		// 跳转至信息汇总展示界面
		request.getRequestDispatcher("tj_xxjd.jsp").forward(request, response);
		
	}
	
	
	

	

	/**
	 * 信息分级汇总 add by lhanliang
	 * @param request 请求
	 * @param response 响应
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toFlhzPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // 年度
		String fromMonth =	request.getParameter("fromMonth");  // 开始月份
		String toMonth = request.getParameter("toMonth");  // 结束月份

        request.setAttribute("year", year);
        request.setAttribute("fromMonth", fromMonth);
        request.setAttribute("toMonth", toMonth);
        
		
		// 跳转至信息分类统计页面，展示信息
		request.getRequestDispatcher("tj_fl.jsp").forward(request, response);
	}
	
	private void toCyflhzPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String year = request.getParameter("year");  // 年度
		String fromMonth =	request.getParameter("fromMonth");  // 开始月份
		String toMonth = request.getParameter("toMonth");  // 结束月份

        request.setAttribute("year", year);
        request.setAttribute("fromMonth", fromMonth);
        request.setAttribute("toMonth", toMonth);
        
		
		// 跳转至信息分类统计页面，展示信息
		request.getRequestDispatcher("tj_fcy.jsp").forward(request, response);
		
	}
	
	private void toCymxhzPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String year = request.getParameter("year");  // 年度
		String fromMonth =	request.getParameter("fromMonth");  // 开始月份
		String toMonth = request.getParameter("toMonth");  // 结束月份

        request.setAttribute("year", year);
        request.setAttribute("fromMonth", fromMonth);
        request.setAttribute("toMonth", toMonth);
        
		
		// 跳转至信息分类统计页面，展示信息
		request.getRequestDispatcher("tj_fcymx.jsp").forward(request, response);
		
		
	}
	
	/**
	 * 信息分级汇总 add by lhanliang
	 * @param request 请求
	 * @param response 响应
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toXxfjhzpage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // 年度
		String fromMonth =	request.getParameter("fromMonth");  // 开始月份
		String toMonth = request.getParameter("toMonth");  // 结束月份

        request.setAttribute("year", year);
        request.setAttribute("fromMonth", fromMonth);
        request.setAttribute("toMonth", toMonth);
        
		
		// 跳转至信息分类统计页面，展示信息
		request.getRequestDispatcher("tj_fj.jsp").forward(request, response);
	}
	
	
	/**
	 * ajax获取信息分级汇总数据 
	 * @param request 请求
	 * @param response 响应
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getXxfjhzInfo(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // 年度
		String fromMonth =	request.getParameter("fromMonth");  // 开始月份
		String toMonth = request.getParameter("toMonth");  // 结束月份
		
		String data = "";

		// 获取分类统计信息
		//合计
		List<FjFlInfo> infoListHj = ZdxmDao.getFjInfoList(year,fromMonth, toMonth,"合计");
		//在建
		List<FjFlInfo> infoListZj = ZdxmDao.getFjInfoList(year,fromMonth, toMonth,"在建");
		//预备
		List<FjFlInfo> infoListYb = ZdxmDao.getFjInfoList(year,fromMonth, toMonth,"预备");

		//合计
		FjFlInfo tempInfoHj = new FjFlInfo();
		FjFlInfo tempInfoZj = new FjFlInfo();
		FjFlInfo tempInfoYb = new FjFlInfo();
		FjFlInfo tempScxHj  = new FjFlInfo();
		FjFlInfo tempScxZj = new FjFlInfo();
		FjFlInfo tempScxYb = new FjFlInfo();
		
		
		//生产性预备项目
		
		List<FjFlInfo> scxInfoList = ZdxmDao.getScxInfoList(year,fromMonth, toMonth);
		if (FavoritesHelper.isNotNull(scxInfoList)) {
			for (FjFlInfo fjFlInfo : scxInfoList) {
				if ("在建".equals(fjFlInfo.getLb())) {
					tempScxZj = fjFlInfo;
				}else if("预备".equals(fjFlInfo.getLb())){
					tempScxYb = fjFlInfo;
				}
			}
		}
		
		 //生产性项目合计
	    tempScxHj.setPnum(tempScxYb.getPnum() + tempScxZj.getPnum());
	    tempScxHj.setJhtz(tempScxYb.getJhtz() + tempScxZj.getJhtz());
	    tempScxHj.setNczbywc(tempScxYb.getNczbywc() + tempScxZj.getNczbywc());
	    tempScxHj.setWcbl(tempScxHj.getNczbywc()*100d/tempScxHj.getJhtz());
	    tempScxHj.setZtz(tempScxYb.getZtz() + tempScxZj.getZtz());
    	tempScxHj.setDnljdwhj(tempScxYb.getDnljdwhj() + tempScxZj.getDnljdwhj());
    	tempScxHj.setDwwcbl(tempScxHj.getDnljdwhj()*100d/tempScxHj.getJhtz());

    	
    	
		//在建
	    for(FjFlInfo f:infoListZj){
	    	tempInfoZj.setPnum(tempInfoZj.getPnum() + f.getPnum());
	    	tempInfoZj.setJhtz(tempInfoZj.getJhtz() + f.getJhtz());
	    	tempInfoZj.setNczbywc(tempInfoZj.getNczbywc() + f.getNczbywc());
	  //  	tempInfoZj.setWcbl(tempInfoZj.getWcbl() + f.getWcbl());
	    	tempInfoZj.setZtz(tempInfoZj.getZtz() + f.getZtz());
	    	tempInfoZj.setDnljdwhj(tempInfoZj.getDnljdwhj() + f.getDnljdwhj());
	   // 	tempInfoZj.setDwwcbl(Double.valueOf(tempInfoZj.getDnljdwhj())*100/Double.valueOf(tempInfoZj.getJhtz()));

	    }
	    if(infoListZj.size() == 0){
	    	tempInfoZj.setWcbl(0d);
	    	tempInfoZj.setDwwcbl(0d);
	    }else{
	    	tempInfoZj.setWcbl(tempInfoZj.getNczbywc()*100d/tempInfoZj.getJhtz());
	    	tempInfoZj.setDwwcbl(tempInfoZj.getDnljdwhj()*100d/tempInfoZj.getJhtz());
	    }
	    
	    
		//预备
	    for(FjFlInfo f:infoListYb){
	    	tempInfoYb.setPnum(tempInfoYb.getPnum() + f.getPnum());
	    	tempInfoYb.setJhtz(tempInfoYb.getJhtz() + f.getJhtz());
	    	tempInfoYb.setNczbywc(tempInfoYb.getNczbywc() + f.getNczbywc());
	   // 	tempInfoYb.setWcbl(tempInfoYb.getWcbl() + f.getWcbl());
	    	tempInfoYb.setZtz(tempInfoYb.getZtz() + f.getZtz());
	    	tempInfoYb.setDnljdwhj(tempInfoYb.getDnljdwhj() + f.getDnljdwhj());
	   // 	tempInfoYb.setDwwcbl(Double.valueOf(tempInfoYb.getDnljdwhj())*100/Double.valueOf(tempInfoZj.getJhtz()));

	    }
	    
	    if(infoListYb.size() == 0){
	    	tempInfoYb.setWcbl(0d);
	    }else{
	    	tempInfoYb.setWcbl(tempInfoYb.getNczbywc()*100d/tempInfoYb.getJhtz());
	    	tempInfoYb.setDwwcbl(tempInfoYb.getDnljdwhj()*100d/tempInfoYb.getJhtz());
	    }
	    
	    
	    
	    //合计
    	tempInfoHj.setPnum(tempInfoYb.getPnum() + tempInfoZj.getPnum());
    	tempInfoHj.setJhtz(tempInfoYb.getJhtz() + tempInfoZj.getJhtz());
    	tempInfoHj.setNczbywc(tempInfoYb.getNczbywc() + tempInfoZj.getNczbywc());
//    	tempInfoHj.setWcbl((tempInfoYb.getWcbl() + tempInfoZj.getWcbl())/2);
    	tempInfoHj.setWcbl(tempInfoHj.getNczbywc()*100d/tempInfoHj.getJhtz());
    	tempInfoHj.setZtz(tempInfoYb.getZtz() + tempInfoZj.getZtz());
	    tempInfoHj.setDnljdwhj(tempInfoYb.getDnljdwhj() + tempInfoZj.getDnljdwhj());
//	    tempInfoHj.setDwwcbl((tempInfoYb.getDwwcbl() + tempInfoZj.getDwwcbl())/2);
	    tempInfoHj.setDwwcbl(tempInfoHj.getDnljdwhj()*100d/tempInfoHj.getJhtz());
	    
	    
		data +="<tr height=\"30\"  style=\"font-weight:bold\"><td align=\"left\" name=\""+convert("合计")+"\"></td><td align=\"center\">"+tempInfoHj.getPnum()+"</td><td align=\"right\">"+tempInfoHj.getZtz()
		      +"</td><td align=\"right\">"+tempInfoHj.getJhtz()+"</td><td align=\"right\">"+tempInfoHj.getNczbywc()+"</td>"
		      +"<td align=\"right\">"+getForThree(tempInfoHj.getWcbl().toString())+"</td><td align=\"right\">"+tempInfoHj.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempInfoHj.getDwwcbl().toString())+"</td ></tr>";
		
		data +="<tr height=\"30\"  ><td align=\"center\" name=\""+convert("在建")+"\"></td><td align=\"center\">"+tempInfoZj.getPnum()+"</td><td align=\"right\">"+tempInfoZj.getZtz()
	          +"</td><td align=\"right\">"+tempInfoZj.getJhtz()+"</td><td align=\"right\">"+tempInfoZj.getNczbywc()+"</td>"
		      +"<td align=\"right\">"+getForThree(tempInfoZj.getWcbl().toString())+"</td><td align=\"right\">"+tempInfoZj.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempInfoZj.getDwwcbl().toString())+"</td ></tr>";
		
		data +="<tr height=\"30\"  ><td align=\"center\" name=\""+convert("预备")+"\"></td><td align=\"center\">"+tempInfoYb.getPnum()+"</td><td align=\"right\">"+tempInfoYb.getZtz()
	          +"</td><td align=\"right\">"+tempInfoYb.getJhtz()+"</td><td align=\"right\">"+tempInfoYb.getNczbywc()+"</td>"
		      +"<td align=\"right\">"+getForThree(tempInfoYb.getWcbl().toString())+"</td><td align=\"right\">"+tempInfoYb.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempInfoYb.getDwwcbl().toString())+"</td ></tr>";
		
		
		//得到类别列表
		List<String> dqlist  =  ZdxmDao.getDqList();
		
		for(int i = 0; i<dqlist.size(); i++){
			//循环查找列表中相应地区的数据
			
			//如果合计列表的长度为0输出
			if(infoListHj.size() ==0){
				
				data +="<tr height=\"30\"  style=\"font-weight:bold\" ><td align=\"left\" name=\""+convert(dqlist.get(i))+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
			      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
			}
			 
			//标志位是否已经匹配相应地区输出
			int HjFlag = 0;
			for(int j=0; j<infoListHj.size() && HjFlag == 0 ;j++){
				
				if(j==(infoListHj.size()-1) && HjFlag == 0 && !dqlist.get(i).equals(infoListHj.get(j).getDq())){
					
					data +="<tr height=\"30\" style=\"font-weight:bold\" ><td align=\"left\" name=\""+convert(dqlist.get(i))+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
				      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
				}
				
				if(dqlist.get(i).equals(infoListHj.get(j).getDq())){
					data +="<tr height=\"30\" style=\"font-weight:bold\" ><td align=\"left\" name=\""+convert(dqlist.get(i))+"\"></td><td align=\"center\">"+infoListHj.get(j).getPnum()+"</td><td align=\"right\">"+infoListHj.get(j).getZtz()
				      +"</td><td align=\"right\">"+infoListHj.get(j).getJhtz()+"</td><td align=\"right\">"+infoListHj.get(j).getNczbywc()+"</td>"
				      +"<td align=\"right\">"+getForThree(infoListHj.get(j).getWcbl().toString())+"</td><td align=\"right\">"+infoListHj.get(j).getDnljdwhj()+"</td><td align=\"right\">"+getForThree(infoListHj.get(j).getDwwcbl().toString())+"</td ></tr>";
					HjFlag = 1;
					
				}

			}
			
			//在建
			//如果Zj列表的长度为0输出
			if(infoListZj.size() ==0){
				
				data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("在建")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
			      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
			}
			 
			//标志位是否已经匹配相应地区输出
			int ZjFlag = 0;
			for(int j=0; j<infoListZj.size() && ZjFlag == 0 ;j++){
				
				if(j==(infoListZj.size()-1) && ZjFlag == 0  && !dqlist.get(i).equals(infoListZj.get(j).getDq())){
					
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("在建")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
				      +"<td align=\"right\">0</td ><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
				}
				
				if(dqlist.get(i).equals(infoListZj.get(j).getDq())){
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("在建")+"\"></td><td align=\"center\">"+infoListZj.get(j).getPnum()+"</td><td align=\"right\">"+infoListZj.get(j).getZtz()
				      +"</td><td align=\"right\">"+infoListZj.get(j).getJhtz()+"</td><td align=\"right\">"+infoListZj.get(j).getNczbywc()+"</td>"
				      +"<td align=\"right\">"+getForThree(infoListZj.get(j).getWcbl().toString())+"</td><td align=\"right\">"+infoListZj.get(j).getDnljdwhj()+"</td><td align=\"right\">"+getForThree(infoListZj.get(j).getDwwcbl().toString())+"</td ></tr>";
					ZjFlag = 1;
				}
				
				
			}
			
			//预备
			//如果Yb列表的长度为0输出
			if(infoListYb.size() ==0){
				
				data +="<tr height=\"30\"><td  align=\"center\" name=\""+convert("预备")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
			      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
			}
			//标志位是否已经匹配相应地区输出
			int YbFlag = 0;
			for(int j=0; j<infoListYb.size()&& YbFlag == 0 ;j++){
				
				if(j==(infoListYb.size()-1) && YbFlag == 0 && !dqlist.get(i).equals(infoListYb.get(j).getDq())){
					
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("预备")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
				      +"<td align=\"right\">0</td><td align=\"right\"></td><td align=\"right\"></td></tr>";
				}
				
				if(dqlist.get(i).equals(infoListYb.get(j).getDq())){
					data +="<tr height=\"30\"><td  align=\"center\" name=\""+convert("预备")+"\"></td><td align=\"center\">"+infoListYb.get(j).getPnum()+"</td><td align=\"right\">"+infoListYb.get(j).getZtz()
				      +"</td><td align=\"right\">"+infoListYb.get(j).getJhtz()+"</td><td align=\"right\">"+infoListYb.get(j).getNczbywc()+"</td>"
				      +"<td align=\"right\">"+getForThree(infoListYb.get(j).getWcbl().toString())+"</td><td align=\"right\">"+infoListYb.get(j).getDnljdwhj()+"</td><td align=\"right\">"+getForThree(infoListYb.get(j).getDwwcbl().toString())+"</td ></tr>";
					YbFlag = 1;
				}
				
				
			}
		}


    	
		data +="<tr height=\"30\"  style=\"font-weight:bold\"><td align=\"left\" name=\""+convert("生产性项目")+"\"></td><td align=\"center\">"+tempScxHj.getPnum()+"</td><td align=\"right\">"+tempScxHj.getZtz()
	         +"</td><td align=\"right\">"+tempScxHj.getJhtz()+"</td><td align=\"right\">"+tempScxHj.getNczbywc()+"</td>"
	         +"<td align=\"right\">"+getForThree(tempScxHj.getWcbl().toString())+"</td><td align=\"right\">"+tempScxHj.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempScxHj.getDwwcbl().toString())+"</td ></tr>";
	
	    data +="<tr height=\"30\"  ><td align=\"center\" name=\""+convert("在建")+"\"></td><td align=\"center\">"+tempScxZj.getPnum()+"</td><td align=\"right\">"+tempScxZj.getZtz()
             +"</td><td align=\"right\">"+tempScxZj.getJhtz()+"</td><td align=\"right\">"+tempScxZj.getNczbywc()+"</td>"
	         +"<td align=\"right\">"+getForThree(tempScxZj.getWcbl().toString())+"</td><td align=\"right\">"+tempScxZj.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempScxZj.getDwwcbl().toString())+"</td ></tr>";
	
	    data +="<tr height=\"30\"  ><td align=\"center\" name=\""+convert("预备")+"\"></td><td align=\"center\">"+tempScxYb.getPnum()+"</td><td align=\"right\">"+tempScxYb.getZtz()
             +"</td><td align=\"right\">"+tempScxYb.getJhtz()+"</td><td align=\"right\">"+tempScxYb.getNczbywc()+"</td>"
	         +"<td align=\"right\">"+getForThree(tempScxYb.getWcbl().toString())+"</td><td align=\"right\">"+tempScxYb.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempScxYb.getDwwcbl().toString())+"</td ></tr>";
	
	    data = data.replace("NaN", "0");
		
		
        PrintWriter out = response.getWriter();
        response.setContentType("application/json; charset=utf-8");  
		out.write(data);
		out.close();
		
	}
	
	private static String getForThree(String str){
		
		
		double d = Double.valueOf(str);
		String result = String.format("%.1f", d);
		return result;
	/*	if(str.indexOf(".") == 3){
			return str.substring(0,5);	
		}else if(str.indexOf(".") == 4){
			return str.substring(0,6);
		}
		if(str.length()>3){
			return str.substring(0,4);	
		}else{
			return str;
		}*/
	}

	private static String getForFour(float a){
		
		
		double d = Double.valueOf(a)/100;
		String result = String.format("%.1f", d);
		return result;
	/*	if(str.indexOf(".") == 3){
			return str.substring(0,5);	
		}else if(str.indexOf(".") == 4){
			return str.substring(0,6);
		}
		if(str.length()>3){
			return str.substring(0,4);	
		}else{
			return str;
		}*/
	}
	
	
	/**
	 * 信息分类汇总
	 * @param request 请求
	 * @param response 响应
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getXxflhzInfo(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // 年度
		String fromMonth =	request.getParameter("fromMonth");  // 开始月份
		String toMonth = request.getParameter("toMonth");  // 结束月份
		
		String data = "";

		// 获取分类统计信息
		//合计
		List<FjFlInfo> infoListHj = ZdxmDao.getFlInfoList(year,fromMonth, toMonth,"合计");
		//在建
		List<FjFlInfo> infoListZj = ZdxmDao.getFlInfoList(year,fromMonth, toMonth,"在建");
		//预备
		List<FjFlInfo> infoListYb = ZdxmDao.getFlInfoList(year,fromMonth, toMonth,"预备");

		//合计
		FjFlInfo tempInfoHj = new FjFlInfo();
		FjFlInfo tempInfoZj = new FjFlInfo();
		FjFlInfo tempInfoYb = new FjFlInfo();
		FjFlInfo tempScxHj  = new FjFlInfo();
		FjFlInfo tempScxZj  = new FjFlInfo();
		FjFlInfo tempScxYb  = new FjFlInfo();
		
		
		//生产性预备项目
		int scxYbNum = 0;
	    for(FjFlInfo f:infoListYb){
	    	System.out.println(f);
	    	if("是".equals(f.getSfscx())){
	    		tempScxYb.setPnum(tempScxYb.getPnum() + f.getPnum());
	    		tempScxYb.setJhtz(tempScxYb.getJhtz() + f.getJhtz());
	    		tempScxYb.setNczbywc(tempScxYb.getNczbywc() + f.getNczbywc());
		  //  	tempInfoZj.setWcbl(tempInfoZj.getWcbl() + f.getWcbl());
	    		tempScxYb.setZtz(tempScxYb.getZtz() + f.getZtz());
	    		tempScxYb.setDnljdwhj(tempScxYb.getDnljdwhj() + f.getDnljdwhj());
		   // 	tempInfoZj.setDwwcbl(Double.valueOf(tempInfoZj.getDnljdwhj())*100/Double.valueOf(tempInfoZj.getJhtz()));
                scxYbNum ++;
	    	}
	    }
	    if(scxYbNum == 0){
	    	tempScxYb.setWcbl(0d);
	    	tempScxYb.setDwwcbl(0d);
	    }else{
	    	tempScxYb.setWcbl(tempScxYb.getNczbywc()*100d/tempScxYb.getJhtz());
	    	tempScxYb.setDwwcbl(tempScxYb.getDnljdwhj()*100d/tempScxYb.getJhtz());
	    }
		
		    
		
		//生产性在建项目
		int scxZjNum = 0;
	    for(FjFlInfo f:infoListZj){
	    	if("是".equals(f.getSfscx())){
	    		tempScxZj.setPnum(tempScxZj.getPnum() + f.getPnum());
	    		tempScxZj.setJhtz(tempScxZj.getJhtz() + f.getJhtz());
	    		tempScxZj.setNczbywc(tempScxZj.getNczbywc() + f.getNczbywc());
		  //  	tempInfoZj.setWcbl(tempInfoZj.getWcbl() + f.getWcbl());
	    		tempScxZj.setZtz(tempScxZj.getZtz() + f.getZtz());
	    		tempScxZj.setDnljdwhj(tempScxZj.getDnljdwhj() + f.getDnljdwhj());
		   // 	tempInfoZj.setDwwcbl(Double.valueOf(tempInfoZj.getDnljdwhj())*100/Double.valueOf(tempInfoZj.getJhtz()));
                scxZjNum ++;
	    	}
	    }
	    if(scxZjNum == 0){
	    	tempScxZj.setWcbl(0d);
	    	tempScxZj.setDwwcbl(0d);
	    }else{
	    	tempScxZj.setWcbl(tempScxZj.getNczbywc()*100d/tempScxZj.getJhtz());
	    	tempScxZj.setDwwcbl(tempScxZj.getDnljdwhj()*100d/tempScxZj.getJhtz());
	    }
		
	    //生产性项目合计
	    tempScxHj.setPnum(tempScxYb.getPnum() + tempScxZj.getPnum());
	    tempScxHj.setJhtz(tempScxYb.getJhtz() + tempScxZj.getJhtz());
	    tempScxHj.setNczbywc(tempScxYb.getNczbywc() + tempScxZj.getNczbywc());
//    	tempScxHj.setWcbl((tempScxYb.getWcbl() + tempScxZj.getWcbl())/2);
	    tempScxHj.setWcbl(tempScxHj.getNczbywc()*100d/tempScxHj.getJhtz());
	    tempScxHj.setZtz(tempScxYb.getZtz() + tempScxZj.getZtz());
    	tempScxHj.setDnljdwhj(tempScxYb.getDnljdwhj() + tempScxZj.getDnljdwhj());
//	    tempScxHj.setDwwcbl((tempScxYb.getDwwcbl() + tempScxZj.getDwwcbl())/2);
    	tempScxHj.setDwwcbl(tempScxHj.getDnljdwhj()*100d/tempScxHj.getJhtz());

		
		
		//在建
	    for(FjFlInfo f:infoListZj){
	    	tempInfoZj.setPnum(tempInfoZj.getPnum() + f.getPnum());
	    	tempInfoZj.setJhtz(tempInfoZj.getJhtz() + f.getJhtz());
	    	tempInfoZj.setNczbywc(tempInfoZj.getNczbywc() + f.getNczbywc());
	  //  	tempInfoZj.setWcbl(tempInfoZj.getWcbl() + f.getWcbl());
	    	tempInfoZj.setZtz(tempInfoZj.getZtz() + f.getZtz());
	    	tempInfoZj.setDnljdwhj(tempInfoZj.getDnljdwhj() + f.getDnljdwhj());
	   // 	tempInfoZj.setDwwcbl(Double.valueOf(tempInfoZj.getDnljdwhj())*100/Double.valueOf(tempInfoZj.getJhtz()));

	    }
	    if(infoListZj.size() == 0){
	    	tempInfoZj.setWcbl(0d);
	    	tempInfoZj.setDwwcbl(0d);
	    }else{
	    	tempInfoZj.setWcbl(tempInfoZj.getNczbywc()*100d/tempInfoZj.getJhtz());
	    	tempInfoZj.setDwwcbl(tempInfoZj.getDnljdwhj()*100d/tempInfoZj.getJhtz());
	    }
	    
	    
		//预备
	    for(FjFlInfo f:infoListYb){
	    	tempInfoYb.setPnum(tempInfoYb.getPnum() + f.getPnum());
	    	tempInfoYb.setJhtz(tempInfoYb.getJhtz() + f.getJhtz());
	    	tempInfoYb.setNczbywc(tempInfoYb.getNczbywc() + f.getNczbywc());
	   // 	tempInfoYb.setWcbl(tempInfoYb.getWcbl() + f.getWcbl());
	    	tempInfoYb.setZtz(tempInfoYb.getZtz() + f.getZtz());
	    	tempInfoYb.setDnljdwhj(tempInfoYb.getDnljdwhj() + f.getDnljdwhj());
	   // 	tempInfoYb.setDwwcbl(Double.valueOf(tempInfoYb.getDnljdwhj())*100/Double.valueOf(tempInfoZj.getJhtz()));

	    }
	    
	    if(infoListYb.size() == 0){
	    	tempInfoYb.setWcbl(0d);
	    }else{
	    	tempInfoYb.setWcbl(tempInfoYb.getNczbywc()*100d/tempInfoYb.getJhtz());
	    	tempInfoYb.setDwwcbl(tempInfoYb.getDnljdwhj()*100d/tempInfoYb.getJhtz());
	    }
	    
	    
	    
	    //合计
    	tempInfoHj.setPnum(tempInfoYb.getPnum() + tempInfoZj.getPnum());
    	tempInfoHj.setJhtz(tempInfoYb.getJhtz() + tempInfoZj.getJhtz());
    	tempInfoHj.setNczbywc(tempInfoYb.getNczbywc() + tempInfoZj.getNczbywc());
//    	tempInfoHj.setWcbl((tempInfoYb.getWcbl() + tempInfoZj.getWcbl())/2);
    	tempInfoHj.setWcbl(tempInfoHj.getNczbywc()*100d/tempInfoHj.getJhtz());
    	tempInfoHj.setZtz(tempInfoYb.getZtz() + tempInfoZj.getZtz());
	    tempInfoHj.setDnljdwhj(tempInfoYb.getDnljdwhj() + tempInfoZj.getDnljdwhj());
//	    tempInfoHj.setDwwcbl((tempInfoYb.getDwwcbl() + tempInfoZj.getDwwcbl())/2);
	    tempInfoHj.setDwwcbl(tempInfoHj.getDnljdwhj()*100d/tempInfoHj.getJhtz());
	    
		data +="<tr height=\"30\"  style=\"font-weight:bold\"><td align=\"left\" name=\""+convert("合计")+"\"></td><td align=\"center\">"+tempInfoHj.getPnum()+"</td><td align=\"right\">"+tempInfoHj.getZtz()
		      +"</td><td align=\"right\">"+tempInfoHj.getJhtz()+"</td><td align=\"right\">"+tempInfoHj.getNczbywc()+"</td>"
		      +"<td align=\"right\">"+getForThree(tempInfoHj.getWcbl().toString())+"</td><td align=\"right\">"+tempInfoHj.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempInfoHj.getDwwcbl().toString())+"</td ></tr>";
		
		data +="<tr height=\"30\"  ><td align=\"center\" name=\""+convert("在建")+"\"></td><td align=\"center\">"+tempInfoZj.getPnum()+"</td><td align=\"right\">"+tempInfoZj.getZtz()
	          +"</td><td align=\"right\">"+tempInfoZj.getJhtz()+"</td><td align=\"right\">"+tempInfoZj.getNczbywc()+"</td>"
		      +"<td align=\"right\">"+getForThree(tempInfoZj.getWcbl().toString())+"</td><td align=\"right\">"+tempInfoZj.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempInfoZj.getDwwcbl().toString())+"</td ></tr>";
		
		data +="<tr height=\"30\"  ><td align=\"center\" name=\""+convert("预备")+"\"></td><td align=\"center\">"+tempInfoYb.getPnum()+"</td><td align=\"right\">"+tempInfoYb.getZtz()
	          +"</td><td align=\"right\">"+tempInfoYb.getJhtz()+"</td><td align=\"right\">"+tempInfoYb.getNczbywc()+"</td>"
		      +"<td align=\"right\">"+getForThree(tempInfoYb.getWcbl().toString())+"</td><td align=\"right\">"+tempInfoYb.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempInfoYb.getDwwcbl().toString())+"</td ></tr>";
		
		
		//得到分级列表
		List<String> lb1list  =  ZdxmDao.getLb1List();
		
		for(int i = 0; i<lb1list.size(); i++){
			//循环查找列表中相应地区的数据
			
			//如果合计列表的长度为0输出
			if(infoListHj.size() ==0){
				
				data +="<tr height=\"30\"  style=\"font-weight:bold\" ><td align=\"left\" name=\""+convert(lb1list.get(i))+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
			      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
			}
			 
			//标志位是否已经匹配相应地区输出
			int HjFlag = 0;
			for(int j=0; j<infoListHj.size() && HjFlag == 0 ;j++){
				
				if(j==(infoListHj.size()-1) && HjFlag == 0 && !lb1list.get(i).equals(infoListHj.get(j).getDq())){
					
					data +="<tr height=\"30\" style=\"font-weight:bold\" ><td align=\"left\" name=\""+convert(lb1list.get(i))+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
				      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
				}
				
				if(lb1list.get(i).equals(infoListHj.get(j).getDq())){
					data +="<tr height=\"30\" style=\"font-weight:bold\" ><td align=\"left\" name=\""+convert(lb1list.get(i))+"\"></td><td align=\"center\">"+infoListHj.get(j).getPnum()+"</td><td align=\"right\">"+infoListHj.get(j).getZtz()
				      +"</td><td align=\"right\">"+infoListHj.get(j).getJhtz()+"</td><td align=\"right\">"+infoListHj.get(j).getNczbywc()+"</td>"
				      +"<td align=\"right\">"+getForThree(infoListHj.get(j).getWcbl().toString())+"</td><td align=\"right\">"+infoListHj.get(j).getDnljdwhj()+"</td><td align=\"right\">"+getForThree(infoListHj.get(j).getDwwcbl().toString())+"</td ></tr>";
					HjFlag = 1;
					
				}
				
				
			}
			
			//在建
			//如果Zj列表的长度为0输出
			if(infoListZj.size() ==0){
				
				data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("在建")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
			      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
			}
			 
			//标志位是否已经匹配相应地区输出
			int ZjFlag = 0;
			for(int j=0; j<infoListZj.size() && ZjFlag == 0 ;j++){
				
				if(j==(infoListZj.size()-1) && ZjFlag == 0  && !lb1list.get(i).equals(infoListZj.get(j).getDq())){
					
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("在建")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
				      +"<td align=\"right\">0</td ><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
				}
				
				if(lb1list.get(i).equals(infoListZj.get(j).getDq())){
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("在建")+"\"></td><td align=\"center\">"+infoListZj.get(j).getPnum()+"</td><td align=\"right\">"+infoListZj.get(j).getZtz()
				      +"</td><td align=\"right\">"+infoListZj.get(j).getJhtz()+"</td><td align=\"right\">"+infoListZj.get(j).getNczbywc()+"</td>"
				      +"<td align=\"right\">"+getForThree(infoListZj.get(j).getWcbl().toString())+"</td><td align=\"right\">"+infoListZj.get(j).getDnljdwhj()+"</td><td align=\"right\">"+getForThree(infoListZj.get(j).getDwwcbl().toString())+"</td ></tr>";
					ZjFlag = 1;
				}
				
				
			}
			
			//预备
			//如果Yb列表的长度为0输出
			if(infoListYb.size() ==0){
				
				data +="<tr height=\"30\"><td  align=\"center\" name=\""+convert("预备")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
			      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
			}
			//标志位是否已经匹配相应地区输出
			int YbFlag = 0;
			for(int j=0; j<infoListYb.size()&& YbFlag == 0 ;j++){
				
				if(j==(infoListYb.size()-1) && YbFlag == 0 && !lb1list.get(i).equals(infoListYb.get(j).getDq())){
					
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("预备")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
				      +"<td align=\"right\">0</td><td align=\"right\"></td><td align=\"right\"></td></tr>";
				}
				
				if(lb1list.get(i).equals(infoListYb.get(j).getDq())){
					data +="<tr height=\"30\"><td  align=\"center\" name=\""+convert("预备")+"\"></td><td align=\"center\">"+infoListYb.get(j).getPnum()+"</td><td align=\"right\">"+infoListYb.get(j).getZtz()
				      +"</td><td align=\"right\">"+infoListYb.get(j).getJhtz()+"</td><td align=\"right\">"+infoListYb.get(j).getNczbywc()+"</td>"
				      +"<td align=\"right\">"+getForThree(infoListYb.get(j).getWcbl().toString())+"</td><td align=\"right\">"+infoListYb.get(j).getDnljdwhj()+"</td><td align=\"right\">"+getForThree(infoListYb.get(j).getDwwcbl().toString())+"</td ></tr>";
					YbFlag = 1;
				}
				
				
			}
			
			
		}
		
		data +="<tr height=\"30\"  style=\"font-weight:bold\"><td align=\"left\" name=\""+convert("生产性项目")+"\"></td><td align=\"center\">"+tempScxHj.getPnum()+"</td><td align=\"right\">"+tempScxHj.getZtz()
             +"</td><td align=\"right\">"+tempScxHj.getJhtz()+"</td><td align=\"right\">"+tempScxHj.getNczbywc()+"</td>"
             +"<td align=\"right\">"+getForThree(tempScxHj.getWcbl().toString())+"</td><td align=\"right\">"+tempScxHj.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempScxHj.getDwwcbl().toString())+"</td ></tr>";

	    data +="<tr height=\"30\"  ><td align=\"center\" name=\""+convert("在建")+"\"></td><td align=\"center\">"+tempScxZj.getPnum()+"</td><td align=\"right\">"+tempScxZj.getZtz()
	         +"</td><td align=\"right\">"+tempScxZj.getJhtz()+"</td><td align=\"right\">"+tempScxZj.getNczbywc()+"</td>"
	         +"<td align=\"right\">"+getForThree(tempScxZj.getWcbl().toString())+"</td><td align=\"right\">"+tempScxZj.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempScxZj.getDwwcbl().toString())+"</td ></tr>";
	
	    data +="<tr height=\"30\"  ><td align=\"center\" name=\""+convert("预备")+"\"></td><td align=\"center\">"+tempScxYb.getPnum()+"</td><td align=\"right\">"+tempScxYb.getZtz()
	         +"</td><td align=\"right\">"+tempScxYb.getJhtz()+"</td><td align=\"right\">"+tempScxYb.getNczbywc()+"</td>"
	         +"<td align=\"right\">"+getForThree(tempScxYb.getWcbl().toString())+"</td><td align=\"right\">"+tempScxYb.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempScxYb.getDwwcbl().toString())+"</td ></tr>";
	         
	    data = data.replace("NaN", "0");
	    
        PrintWriter out = response.getWriter();
        response.setContentType("application/json; charset=utf-8");  
		out.write(data);
		out.close();
		
	}
	/**
	 * 分产业汇总
	 * @throws IOException 
	 */
	private void getFcyhzInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String year = request.getParameter("year");  // 年度
		String fromMonth =	request.getParameter("fromMonth");  // 开始月份
		String toMonth = request.getParameter("toMonth");  // 结束月份
		
		String data = "";

		// 获取分类统计信息
		//合计
		List<FjFlInfo> infoListHj = ZdxmDao.getCyInfoList(year,fromMonth, toMonth,"合计");
		//在建
		List<FjFlInfo> infoListZj = ZdxmDao.getCyInfoList(year,fromMonth, toMonth,"在建");
		//预备
		List<FjFlInfo> infoListYb = ZdxmDao.getCyInfoList(year,fromMonth, toMonth,"预备");

		//合计
		FjFlInfo tempInfoHj = new FjFlInfo();
		FjFlInfo tempInfoZj = new FjFlInfo();
		FjFlInfo tempInfoYb = new FjFlInfo();
		
		//在建
	    for(FjFlInfo f:infoListZj){
	    	tempInfoZj.setPnum(tempInfoZj.getPnum() + f.getPnum());
	    	tempInfoZj.setJhtz(tempInfoZj.getJhtz() + f.getJhtz());
	    	tempInfoZj.setNczbywc(tempInfoZj.getNczbywc() + f.getNczbywc());
	  //  	tempInfoZj.setWcbl(tempInfoZj.getWcbl() + f.getWcbl());
	    	tempInfoZj.setZtz(tempInfoZj.getZtz() + f.getZtz());
	    	tempInfoZj.setDnljdwhj(tempInfoZj.getDnljdwhj() + f.getDnljdwhj());
	   // 	tempInfoZj.setDwwcbl(Double.valueOf(tempInfoZj.getDnljdwhj())*100/Double.valueOf(tempInfoZj.getJhtz()));

	    }
	    if(infoListZj.size() == 0){
	    	tempInfoZj.setWcbl(0d);
	    	tempInfoZj.setDwwcbl(0d);
	    }else{
	    	tempInfoZj.setWcbl(tempInfoZj.getNczbywc()*100d/tempInfoZj.getJhtz());
	    	tempInfoZj.setDwwcbl(tempInfoZj.getDnljdwhj()*100d/tempInfoZj.getJhtz());
	    }
	    
	    
		//预备
	    for(FjFlInfo f:infoListYb){
	    	tempInfoYb.setPnum(tempInfoYb.getPnum() + f.getPnum());
	    	tempInfoYb.setJhtz(tempInfoYb.getJhtz() + f.getJhtz());
	    	tempInfoYb.setNczbywc(tempInfoYb.getNczbywc() + f.getNczbywc());
	   // 	tempInfoYb.setWcbl(tempInfoYb.getWcbl() + f.getWcbl());
	    	tempInfoYb.setZtz(tempInfoYb.getZtz() + f.getZtz());
	    	tempInfoYb.setDnljdwhj(tempInfoYb.getDnljdwhj() + f.getDnljdwhj());
	   // 	tempInfoYb.setDwwcbl(Double.valueOf(tempInfoYb.getDnljdwhj())*100/Double.valueOf(tempInfoZj.getJhtz()));

	    }
	    
	    if(infoListYb.size() == 0){
	    	tempInfoYb.setWcbl(0d);
	    }else{
	    	tempInfoYb.setWcbl(tempInfoYb.getNczbywc()*100d/tempInfoYb.getJhtz());
	    	tempInfoYb.setDwwcbl(tempInfoYb.getDnljdwhj()*100d/tempInfoYb.getJhtz());
	    }
	    
	    
	    
	    //合计
    	tempInfoHj.setPnum(tempInfoYb.getPnum() + tempInfoZj.getPnum());
    	tempInfoHj.setJhtz(tempInfoYb.getJhtz() + tempInfoZj.getJhtz());
    	tempInfoHj.setNczbywc(tempInfoYb.getNczbywc() + tempInfoZj.getNczbywc());
//    	tempInfoHj.setWcbl((tempInfoYb.getWcbl() + tempInfoZj.getWcbl())/2);
    	tempInfoHj.setWcbl(tempInfoHj.getNczbywc()*100d/tempInfoHj.getJhtz());
    	tempInfoHj.setZtz(tempInfoYb.getZtz() + tempInfoZj.getZtz());
	    tempInfoHj.setDnljdwhj(tempInfoYb.getDnljdwhj() + tempInfoZj.getDnljdwhj());
//	    tempInfoHj.setDwwcbl((tempInfoYb.getDwwcbl() + tempInfoZj.getDwwcbl())/2);
	    tempInfoHj.setDwwcbl(tempInfoHj.getDnljdwhj()*100d/tempInfoHj.getJhtz());
	    
		data +="<tr height=\"30\"  style=\"font-weight:bold\"><td align=\"left\" name=\""+convert("合计")+"\"></td><td align=\"center\">"+tempInfoHj.getPnum()+"</td><td align=\"right\">"+tempInfoHj.getZtz()
		      +"</td><td align=\"right\">"+tempInfoHj.getJhtz()+"</td><td align=\"right\">"+tempInfoHj.getNczbywc()+"</td>"
		      +"<td align=\"right\">"+getForThree(tempInfoHj.getWcbl().toString())+"</td><td align=\"right\">"+tempInfoHj.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempInfoHj.getDwwcbl().toString())+"</td ></tr>";
		
		data +="<tr height=\"30\"  ><td align=\"center\" name=\""+convert("在建")+"\"></td><td align=\"center\">"+tempInfoZj.getPnum()+"</td><td align=\"right\">"+tempInfoZj.getZtz()
	          +"</td><td align=\"right\">"+tempInfoZj.getJhtz()+"</td><td align=\"right\">"+tempInfoZj.getNczbywc()+"</td>"
		      +"<td align=\"right\">"+getForThree(tempInfoZj.getWcbl().toString())+"</td><td align=\"right\">"+tempInfoZj.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempInfoZj.getDwwcbl().toString())+"</td ></tr>";
		
		data +="<tr height=\"30\"  ><td align=\"center\" name=\""+convert("预备")+"\"></td><td align=\"center\">"+tempInfoYb.getPnum()+"</td><td align=\"right\">"+tempInfoYb.getZtz()
	          +"</td><td align=\"right\">"+tempInfoYb.getJhtz()+"</td><td align=\"right\">"+tempInfoYb.getNczbywc()+"</td>"
		      +"<td align=\"right\">"+getForThree(tempInfoYb.getWcbl().toString())+"</td><td align=\"right\">"+tempInfoYb.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempInfoYb.getDwwcbl().toString())+"</td ></tr>";
		
		
		//得到分级列表
		List<String> lb1list  =  ZdxmDao.getCyList();
	
		for(int i = 0; i<lb1list.size(); i++){
			//循环查找列表中相应地区的数据
			
			//如果合计列表的长度为0输出
			if(infoListHj.size() ==0){
				data +="<tr height=\"30\"  style=\"font-weight:bold\" ><td align=\"left\" name=\""+convert(lb1list.get(i))+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
			      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
			}
			 
			//标志位是否已经匹配相应地区输出
			int HjFlag = 0;
			for(int j=0; j<infoListHj.size() && HjFlag == 0 ;j++){
				if(j==(infoListHj.size()-1) && HjFlag == 0 && !lb1list.get(i).equals(infoListHj.get(j).getDq().trim())){	
					data +="<tr height=\"30\" style=\"font-weight:bold\" ><td align=\"left\" name=\""+convert(lb1list.get(i))+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
				      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
				}
				System.out.println(infoListHj.size());
				System.out.println("1:"+lb1list.get(i));
				System.out.println("2:"+infoListHj.get(j).getDq());
				System.out.println("是否相等"+lb1list.get(i).equals(infoListHj.get(j).getDq()));
				if(lb1list.get(i).equals(infoListHj.get(j).getDq().trim())){
					
					data +="<tr height=\"30\" style=\"font-weight:bold\" ><td align=\"left\" name=\""+convert(lb1list.get(i))+"\"></td><td align=\"center\">"+infoListHj.get(j).getPnum()+"</td><td align=\"right\">"+infoListHj.get(j).getZtz()
				      +"</td><td align=\"right\">"+infoListHj.get(j).getJhtz()+"</td><td align=\"right\">"+infoListHj.get(j).getNczbywc()+"</td>"
				      +"<td align=\"right\">"+getForThree(infoListHj.get(j).getWcbl().toString())+"</td><td align=\"right\">"+infoListHj.get(j).getDnljdwhj()+"</td><td align=\"right\">"+getForThree(infoListHj.get(j).getDwwcbl().toString())+"</td ></tr>";
					break;
					
				}
				
				
			}
			
			//在建
			//如果Zj列表的长度为0输出
			if(infoListZj.size() ==0){
				
				data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("在建")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
			      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
			}
			 
			//标志位是否已经匹配相应地区输出
			int ZjFlag = 0;
			for(int j=0; j<infoListZj.size() && ZjFlag == 0 ;j++){
				
				if(j==(infoListZj.size()-1) && ZjFlag == 0  && !lb1list.get(i).equals(infoListZj.get(j).getDq().trim())){
					
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("在建")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
				      +"<td align=\"right\">0</td ><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
				}
				
				if(lb1list.get(i).equals(infoListZj.get(j).getDq().trim())){
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("在建")+"\"></td><td align=\"center\">"+infoListZj.get(j).getPnum()+"</td><td align=\"right\">"+infoListZj.get(j).getZtz()
				      +"</td><td align=\"right\">"+infoListZj.get(j).getJhtz()+"</td><td align=\"right\">"+infoListZj.get(j).getNczbywc()+"</td>"
				      +"<td align=\"right\">"+getForThree(infoListZj.get(j).getWcbl().toString())+"</td><td align=\"right\">"+infoListZj.get(j).getDnljdwhj()+"</td><td align=\"right\">"+getForThree(infoListZj.get(j).getDwwcbl().toString())+"</td ></tr>";
					ZjFlag = 1;
				}
				
				
			}
			
			//预备
			//如果Yb列表的长度为0输出
			if(infoListYb.size() ==0){
				
				data +="<tr height=\"30\"><td  align=\"center\" name=\""+convert("预备")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
			      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
			}
			//标志位是否已经匹配相应地区输出
			int YbFlag = 0;
			for(int j=0; j<infoListYb.size()&& YbFlag == 0 ;j++){
				
				if(j==(infoListYb.size()-1) && YbFlag == 0 && !lb1list.get(i).equals(infoListYb.get(j).getDq().trim())){
					
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("预备")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
				      +"<td align=\"right\">0</td><td align=\"right\"></td><td align=\"right\"></td></tr>";
				}
				
				if(lb1list.get(i).equals(infoListYb.get(j).getDq().trim())){
					data +="<tr height=\"30\"><td  align=\"center\" name=\""+convert("预备")+"\"></td><td align=\"center\">"+infoListYb.get(j).getPnum()+"</td><td align=\"right\">"+infoListYb.get(j).getZtz()
				      +"</td><td align=\"right\">"+infoListYb.get(j).getJhtz()+"</td><td align=\"right\">"+infoListYb.get(j).getNczbywc()+"</td>"
				      +"<td align=\"right\">"+getForThree(infoListYb.get(j).getWcbl().toString())+"</td><td align=\"right\">"+infoListYb.get(j).getDnljdwhj()+"</td><td align=\"right\">"+getForThree(infoListYb.get(j).getDwwcbl().toString())+"</td ></tr>";
					YbFlag = 1;
				}
				
				
			}
			
			
		}
		
	     PrintWriter out = response.getWriter();
	        response.setContentType("application/json; charset=utf-8");  
			out.write(data);
			out.close();
	
		
		
		
	}
	
	/**
	 * 分产业明细汇总
	 * @throws IOException 
	 * 
	 */
	
	private void getFcymxhzInfo (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		
		
		
		String year = request.getParameter("year");  // 年度
		String fromMonth =	request.getParameter("fromMonth");  // 开始月份
		String toMonth = request.getParameter("toMonth");  // 结束月份
		String data = "";

		// 获取分类统计信息
		//合计
		List<FjFlInfo> infoListHj = ZdxmDao.getCymxInfoList(year,fromMonth, toMonth,"合计");
        //获取产业明细
		List<FjFlInfo>infoListDt =ZdxmDao.getCymxInfoList(year,fromMonth, toMonth,"");

		//合计
		FjFlInfo tempInfoHj = new FjFlInfo();

		//明细计算合计
	    for(FjFlInfo f:infoListDt){
	    	tempInfoHj.setPnum(tempInfoHj.getPnum() + f.getPnum());
	    	tempInfoHj.setJhtz(tempInfoHj.getJhtz() + f.getJhtz());
	    	tempInfoHj.setNczbywc(tempInfoHj.getNczbywc() + f.getNczbywc());
	    	tempInfoHj.setZtz(tempInfoHj.getZtz() + f.getZtz());
	    	tempInfoHj.setDnljdwhj(tempInfoHj.getDnljdwhj() + f.getDnljdwhj());
	
	    }
	
	    if(infoListDt.size() == 0){
	    	tempInfoHj.setWcbl(0d);
	    }else{
	    	tempInfoHj.setWcbl(tempInfoHj.getNczbywc()*100d/tempInfoHj.getJhtz());
	    	tempInfoHj.setDwwcbl(tempInfoHj.getDnljdwhj()*100d/tempInfoHj.getJhtz());
	    }
	    
	    
		data +="<tr height=\"30\"  style=\"font-weight:bold\"><td align=\"left\" name=\""+convert("合计")+"\"></td><td align=\"center\">"+tempInfoHj.getPnum()+"</td><td align=\"right\">"+tempInfoHj.getZtz()
		      +"</td><td align=\"right\">"+tempInfoHj.getJhtz()+"</td><td align=\"right\">"+tempInfoHj.getNczbywc()+"</td>"
		      +"<td align=\"right\">"+getForThree(tempInfoHj.getWcbl().toString())+"</td><td align=\"right\">"+tempInfoHj.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempInfoHj.getDwwcbl().toString())+"</td ></tr>";

		
		//得到产业列表
		List<String> lb1list  =  ZdxmDao.getCyList();
		System.out.println(lb1list.size()+"长度");
		System.out.println("合计长度"+infoListHj.size());
		for(int i = 0; i<lb1list.size(); i++){
			//循环查找列表中相应地区的数据
			
			//如果合计列表的长度为0输出
			if(infoListHj.size() ==0){
				
				data +="<tr height=\"30\"  style=\"font-weight:bold\" ><td align=\"left\" name=\""+convert(lb1list.get(i))+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
			      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
			}
			 
			//标志位是否已经匹配相应地区输出
			int HjFlag = 0;
			for(int j=0; j<infoListHj.size() && HjFlag == 0 ;j++){
				
				if(j==(infoListHj.size()-1) && HjFlag == 0 && !lb1list.get(i).equals(infoListHj.get(j).getDq().trim())){
					
					data +="<tr height=\"30\" style=\"font-weight:bold\" ><td align=\"left\" name=\""+convert(lb1list.get(i))+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
				      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
				}
				if(lb1list.get(i).equals(infoListHj.get(j).getDq().trim())){
					System.out.println(lb1list.get(i));
					System.out.println("计划投资"+infoListHj.get(j).getJhtz());
					System.out.println("年初至本月完成"+infoListHj.get(j).getNczbywc());
					System.out.println("完成比例"+infoListHj.get(j).getWcbl().toString());
					System.out.println("当年到位资金"+infoListHj.get(j).getDnljdwhj());
					data +="<tr height=\"30\" style=\"font-weight:bold\" ><td align=\"left\" name=\""+convert(lb1list.get(i))+"\"></td><td align=\"center\">"+infoListHj.get(j).getPnum()+"</td><td align=\"right\">"+infoListHj.get(j).getZtz()
				      +"</td><td align=\"right\">"+infoListHj.get(j).getJhtz()+"</td><td align=\"right\">"+infoListHj.get(j).getNczbywc()+"</td>"
				      +"<td align=\"right\">"+getForThree(infoListHj.get(j).getWcbl().toString())+"</td><td align=\"right\">"+infoListHj.get(j).getDnljdwhj()+"</td><td align=\"right\">"+getForThree(infoListHj.get(j).getDwwcbl().toString())+"</td ></tr>";
					HjFlag = 1;
					
				}
				
				
			}
			
			//明细
			//如果明细列表的长度为0输出
			if(infoListDt.size() ==0){
				
				data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("无")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
			      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
			}
			 
			//标志位是否已经匹配相应地区输出
			
			int Flag = 0;
			for(int j=0; j<infoListDt.size();j++){
				
//				if(j==(infoListDt.size()-1)&& !lb1list.get(i).equals(infoListDt.get(j).getDq().trim())){
//					
//					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert(infoListDt.get(j).getMc())+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
//				      +"<td align=\"right\">0</td ><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
//				}
				
				if(lb1list.get(i).equals(infoListDt.get(j).getDq().trim())){
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert(infoListDt.get(j).getMc())+"\"></td><td align=\"center\">"+infoListDt.get(j).getPnum()+"</td><td align=\"right\">"+infoListDt.get(j).getZtz()
				      +"</td><td align=\"right\">"+infoListDt.get(j).getJhtz()+"</td><td align=\"right\">"+infoListDt.get(j).getNczbywc()+"</td>"
				      +"<td align=\"right\">"+getForThree(infoListDt.get(j).getWcbl().toString())+"</td><td align=\"right\">"+infoListDt.get(j).getDnljdwhj()+"</td><td align=\"right\">"+getForThree(infoListDt.get(j).getDwwcbl().toString())+"</td ></tr>";
			
				
				}
				
				
			}
			
			
		}
		
	     PrintWriter out = response.getWriter();
	        response.setContentType("application/json; charset=utf-8");  
			out.write(data);
			out.close();
	
		
		
		
	}
	

	
	
	/**
	 * 重点项目信息汇总
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
	    
	    // 总投资
	    String ztz1 = request.getParameter("ztz1");// 判断符（全部、大于等于、等于）
	    String ztz1num = request.getParameter("ztz2");// 数值1
	    String ztz2 = request.getParameter("ztz3");// 判断符（全部、小于）
	    String ztz2num = request.getParameter("ztz4");// 数值2
	    // 完成投资
	    String wctz1 = request.getParameter("wctz1");// 判断符（全部、大于等于、等于）
	    String wctz1num = request.getParameter("wctz2");// 数值1
	    String wctz2 = request.getParameter("wctz3");// 判断符（全部、小于）
	    String wctz2num = request.getParameter("wctz4");// 数值2
	    // 计划投资
	    String jhtz1 = request.getParameter("jhtz1");// 判断符（全部、大于等于、等于）
	    String jhtz1num = request.getParameter("jhtz2");// 数值1
	    String jhtz2 = request.getParameter("jhtz3");// 判断符（全部、小于）
	    String jhtz2num = request.getParameter("jhtz4");// 判断符（全部、小于）
	    
	    String sfscx = request.getParameter("sfscx"); // 是否生产性
	    String sfzz = request.getParameter("sfzz"); // 是否重中之重
	    String sfss = request.getParameter("sfss");  // 是否省项目
	    String sfzy = request.getParameter("sfzy"); // 是否资源
	    String sjslb = request.getParameter("sjslb");  // 10+3类别
	    String tzztxz = request.getParameter("tzztxz");  // 项目投资主体
	    
		String kgFromNd = request.getParameter("kgFromNd");  // 项目开工年份（开始）
		String kgToNd = request.getParameter("kgToNd");  // 项目开工年份（结束）
		String kgFromMonth = request.getParameter("kgFromMonth");  // 项目开工月份（开始）
		String kgToMonth = request.getParameter("kgToMonth");  // 项目开工月份（结束）
		
		
		request.setAttribute("nd", nd);
		request.setAttribute("lb1", lb1);
		request.setAttribute("lb2", lb2);
		request.setAttribute("dq", dq);
		
		String sfscxStr = "是".equals(sfscx)?"生产性":("否".equals(sfscx)?"非生产性":"");
		String sfzzStr = "是".equals(sfzz)?"重中之重":("否".equals(sfzz)?"非重中之重":"");
		String sfssStr = "是".equals(sfss)?"省属重点":("否".equals(sfss)?"非省属重点":"");
		String sfzyStr = "是".equals(sfzy)?"资源型":("否".equals(sfzy)?"非资源型":"");
		
		String condition = "";
		String[] conditionArry = {sfscxStr,sfzzStr,sfssStr,sfzyStr,sjslb,tzztxz};
		if (FavoritesHelper.isNotNull(conditionArry)) {
			for (int i = 0; i < conditionArry.length; i++) {
				if (FavoritesHelper.isNotNull(conditionArry[i])) {
					condition += "、" + conditionArry[i];
				}
			}
		}
		if (FavoritesHelper.isNotNull(condition)) {
			condition = "(" + condition.substring(1) + ")";
		}
		request.setAttribute("condition", condition);
	    // 获取重点项目信息
		List<ProZdxm> itemList = ZdxmDao.showXxhzList(nd, lb1, lb2, dq, ztz1,
				ztz1num, ztz2, ztz2num, wctz1, wctz1num, wctz2, wctz2num,
				jhtz1, jhtz1num, jhtz2, jhtz2num, sfscx, sfzz, sfss, sfzy,
				sjslb, tzztxz, kgFromNd, kgToNd, kgFromMonth, kgToMonth);
		
		//报表数据
		String tableDataString = "";
		//合计数据
		ProZdxm hj = new ProZdxm();
		//在建数据
		ProZdxm zj = new ProZdxm();
		//预备数据
		ProZdxm yb = new ProZdxm();

		
		for(int i = 0 ; i <itemList.size() ; i++){
			hj.setZtz(hj.getZtz() + itemList.get(i).getZtz());
			hj.setZjppzc(hj.getZjppzc() + itemList.get(i).getZjppzc());
			hj.setZjppdk(hj.getZjppdk() + itemList.get(i).getZjppdk());
			hj.setZjppzf(hj.getZjppzf() + itemList.get(i).getZjppzf());
			hj.setWctz(hj.getWctz() + itemList.get(i).getWctz());
			hj.setJhtz(hj.getJhtz() + itemList.get(i).getJhtz());
			hj.setCz(hj.getCz() + itemList.get(i).getCz());	
			hj.setSs(hj.getSs() + itemList.get(i).getSs());
			hj.setJy(hj.getJy() + itemList.get(i).getJy());
			hj.setZd(hj.getZd() + itemList.get(i).getZd());
			hj.setNyd(hj.getNyd() + itemList.get(i).getNyd());
			hj.setNt(hj.getNt() + itemList.get(i).getNt());
			hj.setLd(hj.getLd() + itemList.get(i).getLd());
			hj.setSgyy(hj.getSgyy() + itemList.get(i).getSgyy());	
			hj.setHgyp(hj.getHgyp() + itemList.get(i).getHgyp());
			hj.setYhdk(hj.getYhdk() + itemList.get(i).getYhdk());	
		}		
		
		
		tableDataString += "<tr style=\"height:28px;color:red;font-weight:bold\">" +
				           "<td align=\"center\" ></td>" +
			               "<td align=\"center\" style=\"color:red;\" >全市合计("+itemList.size()+"项)</td>" +
				           "<td align=\"center\" style=\"color:red;\" >&nbsp;</td>"+
				           "<td align=\"center\" style=\"color:red;\" >&nbsp;</td>"+
				           "<td align=\"center\" style=\"color:red;\" >&nbsp;</td>"+
				           "<td align=\"center\" style=\"color:red;\" >&nbsp;</td>"+
				           "<td align=\"center\" style=\"color:red;\" >&nbsp;</td>"+
				           "<td align=\"center\" style=\"color:red;\" >&nbsp;</td>"+
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getZtz()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getZjppzc()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getZjppdk()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getZjppzf()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getWctz()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getJhtz()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >&nbsp;</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+String.format("%.0f", hj.getCz())+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getSs()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getJy()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getZd()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getNyd()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getNt()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getLd()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getSgyy()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getHgyp()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getYhdk()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >&nbsp;</td>" +
				           "<td align=\"center\" style=\"color:red;\" >&nbsp;</td></tr>" ;

		
		int zjnum = 0;
		for(int i = 0 ; i <itemList.size() ; i++){
			if(itemList.get(i).getLb().equals("在建")){
				zj.setZtz(zj.getZtz() + itemList.get(i).getZtz());
				zj.setZjppzc(zj.getZjppzc() + itemList.get(i).getZjppzc());
				zj.setZjppdk(zj.getZjppdk() + itemList.get(i).getZjppdk());
				zj.setZjppzf(zj.getZjppzf() + itemList.get(i).getZjppzf());
				zj.setWctz(zj.getWctz() + itemList.get(i).getWctz());
				zj.setJhtz(zj.getJhtz() + itemList.get(i).getJhtz());
				zj.setCz(zj.getCz() + itemList.get(i).getCz());	
				zj.setSs(zj.getSs() + itemList.get(i).getSs());
				zj.setJy(zj.getJy() + itemList.get(i).getJy());
				zj.setZd(zj.getZd() + itemList.get(i).getZd());
				zj.setNyd(zj.getNyd() + itemList.get(i).getNyd());
				zj.setNt(zj.getNt() + itemList.get(i).getNt());
				zj.setLd(zj.getLd() + itemList.get(i).getLd());
				zj.setSgyy(zj.getSgyy() + itemList.get(i).getSgyy());	
				zj.setHgyp(zj.getHgyp() + itemList.get(i).getHgyp());
				zj.setYhdk(zj.getYhdk() + itemList.get(i).getYhdk());	
				zjnum++;
			}
		}


		
		tableDataString += "<tr style=\"height:28px;font-weight:bold\">" +
				           "<td align=\"center\" >一</td>" +
			               "<td align=\"center\" >在建重点项目("+zjnum+"项)</td>" +
				           "<td align=\"center\" >&nbsp;</td>"+
				           "<td align=\"center\" >&nbsp;</td>"+
				           "<td align=\"center\" >&nbsp;</td>"+
				           "<td align=\"center\" >&nbsp;</td>"+
				           "<td align=\"center\"  >&nbsp;</td>"+
				           "<td align=\"center\"  >&nbsp;</td>"+
				           "<td align=\"center\" >"+zj.getZtz()+"</td>" +
				           "<td align=\"center\"  >"+zj.getZjppzc()+"</td>" +
				           "<td align=\"center\"  >"+zj.getZjppdk()+"</td>" +
				           "<td align=\"center\"  >"+zj.getZjppzf()+"</td>" +
				           "<td align=\"center\"  >"+zj.getWctz()+"</td>" +
				           "<td align=\"center\" >"+zj.getJhtz()+"</td>" +
				           "<td align=\"center\"  >&nbsp;</td>" +
				           "<td align=\"center\" >"+String.format("%.0f", zj.getCz())+"</td>" +
				           "<td align=\"center\" >"+zj.getSs()+"</td>" +
				           "<td align=\"center\"  >"+zj.getJy()+"</td>" +
				           "<td align=\"center\" >"+zj.getZd()+"</td>" +
				           "<td align=\"center\"  >"+zj.getNyd()+"</td>" +
				           "<td align=\"center\"  >"+zj.getNt()+"</td>" +
				           "<td align=\"center\"  >"+zj.getLd()+"</td>" +
				           "<td align=\"center\"  >"+zj.getSgyy()+"</td>" +
				           "<td align=\"center\"  >"+zj.getHgyp()+"</td>" +
				           "<td align=\"center\"  >"+zj.getYhdk()+"</td>" +
				           "<td align=\"center\"  >&nbsp;</td>" +
				           "<td align=\"center\"  >&nbsp;</td></tr>" ;
		
		//得到分级列表
		List<String> lb1list = ZdxmDao.getLb1List();
		
		String tempData = "";
		int lb1num = 0;
		
		
		for(int i = 0; i<lb1list.size(); i++){
			//类别数据
			ProZdxm templb1 = new ProZdxm();
			//循环查找列表中相应的数据
			for(int j = 0, k = 0; j<itemList.size(); j++){
			
			   if( itemList.get(j).getLb1().equals(lb1list.get(i)) && itemList.get(j).getLb().equals("在建") ){
				   k++;
				   tempData += "<tr style=\"height:28px;\">" +
					           "<td align=\"center\" >"+k+"</td>" +
				               "<td align=\"center\" >"+itemList.get(j).getMc()+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getTzztxz()+"</td>"+
					           "<td align=\"center\" >"+itemList.get(j).getJsdq()+"</td>"+
					           "<td align=\"center\" >"+itemList.get(j).getBawh()+"</td>"+
					           "<td align=\"center\" >"+itemList.get(j).getJsgm()+"</td>"+
					           "<td align=\"center\" >"+itemList.get(j).getJsnx1()+"-"+itemList.get(j).getJsnx2()+"</td>" +
					           "<td align=\"center\"  >"+itemList.get(j).getDwmc()+"</td>"+
					           "<td align=\"center\"  >"+itemList.get(j).getZtz()+"</td>"+
					           "<td align=\"center\"  >"+itemList.get(j).getZjppzc()+"</td>" +
					           "<td align=\"center\"  >"+itemList.get(j).getZjppdk()+"</td>" +
					           "<td align=\"center\"  >"+itemList.get(j).getZjppzf()+"</td>" +
					           "<td align=\"center\"  >"+itemList.get(j).getWctz()+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getJhtz()+"</td>" +
					           "<td align=\"center\"  >"+itemList.get(j).getGcjd()+"</td>" +
					           "<td align=\"center\" >"+String.format("%.0f", itemList.get(j).getCz())+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getSs()+"</td>" +
					           "<td align=\"center\"  >"+itemList.get(j).getJy()+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getZd()+"</td>" +
					           "<td align=\"center\"  >"+itemList.get(j).getNyd()+"</td>" +
					           "<td align=\"center\"  >"+itemList.get(j).getNt()+"</td>" +
					           "<td align=\"center\"  >"+itemList.get(j).getLd()+"</td>" +
					           "<td align=\"center\"  >"+itemList.get(j).getSgyy()+"</td>" +
					           "<td align=\"center\"  >"+itemList.get(j).getHgyp()+"</td>" +
					           "<td align=\"center\"  >"+itemList.get(j).getYhdk()+"</td>" +
					           "<td align=\"center\"  >"+itemList.get(j).getGldw()+"</td>" +
					           "<td align=\"center\"  >&nbsp;</td></tr>" ;
	
				   
				   
				   templb1.setZtz(templb1.getZtz() + itemList.get(j).getZtz());
				   templb1.setZjppzc(templb1.getZjppzc() + itemList.get(j).getZjppzc());
				   templb1.setZjppdk(templb1.getZjppdk() + itemList.get(j).getZjppdk());
				   templb1.setZjppzf(templb1.getZjppzf() + itemList.get(j).getZjppzf());
				   templb1.setWctz(templb1.getWctz() + itemList.get(j).getWctz());
				   templb1.setJhtz(templb1.getJhtz() + itemList.get(j).getJhtz());
				   templb1.setCz(templb1.getCz() + itemList.get(j).getCz());	
				   templb1.setSs(templb1.getSs() + itemList.get(j).getSs());
				   templb1.setJy(templb1.getJy() + itemList.get(j).getJy());
				   templb1.setZd(templb1.getZd() + itemList.get(j).getZd());
				   templb1.setNyd(templb1.getNyd() + itemList.get(j).getNyd());
				   templb1.setNt(templb1.getNt() + itemList.get(j).getNt());
				   templb1.setLd(templb1.getLd() + itemList.get(j).getLd());
				   templb1.setSgyy(templb1.getSgyy() + itemList.get(j).getSgyy());	
				   templb1.setHgyp(templb1.getHgyp() + itemList.get(j).getHgyp());
				   templb1.setYhdk(templb1.getYhdk() + itemList.get(j).getYhdk());	
				
				   
				   
				   
				   lb1num++;
				   
			   }
			}

			
			
			tableDataString += "<tr style=\"height:28px;font-weight:bold\">" +
		           "<td align=\"center\" ></td>" +
	               "<td align=\"center\" >"+lb1list.get(i)+"("+lb1num+"项)</td>" +
		           "<td align=\"center\" >&nbsp;</td>"+
		           "<td align=\"center\" >&nbsp;</td>"+
		           "<td align=\"center\" >&nbsp;</td>"+
		           "<td align=\"center\" >&nbsp;</td>"+
		           "<td align=\"center\"  >&nbsp;</td>"+
		           "<td align=\"center\"  >&nbsp;</td>"+
		           "<td align=\"center\" >"+templb1.getZtz()+"</td>" +
		           "<td align=\"center\"  >"+templb1.getZjppzc()+"</td>" +
		           "<td align=\"center\"  >"+templb1.getZjppdk()+"</td>" +
		           "<td align=\"center\"  >"+templb1.getZjppzf()+"</td>" +
		           "<td align=\"center\"  >"+templb1.getWctz()+"</td>" +
		           "<td align=\"center\" >"+templb1.getJhtz()+"</td>" +
		           "<td align=\"center\"  >&nbsp;</td>" +
		           "<td align=\"center\" >"+String.format("%.0f", templb1.getCz())+"</td>" +
		           "<td align=\"center\" >"+templb1.getSs()+"</td>" +
		           "<td align=\"center\"  >"+templb1.getJy()+"</td>" +
		           "<td align=\"center\" >"+templb1.getZd()+"</td>" +
		           "<td align=\"center\"  >"+templb1.getNyd()+"</td>" +
		           "<td align=\"center\"  >"+templb1.getNt()+"</td>" +
		           "<td align=\"center\"  >"+templb1.getLd()+"</td>" +
		           "<td align=\"center\"  >"+templb1.getSgyy()+"</td>" +
		           "<td align=\"center\"  >"+templb1.getHgyp()+"</td>" +
		           "<td align=\"center\"  >"+templb1.getYhdk()+"</td>" +
		           "<td align=\"center\"  >&nbsp;</td>" +
		           "<td align=\"center\"  >&nbsp;</td></tr>" ;
	           
			tableDataString += tempData;
		    tempData = "";
		    lb1num = 0;
		}
		
		int ybnum = 0;
		for(int i = 0 ; i <itemList.size() ; i++){
			if(itemList.get(i).getLb().equals("预备")){
				yb.setZtz(yb.getZtz() + itemList.get(i).getZtz());
				yb.setZjppzc(yb.getZjppzc() + itemList.get(i).getZjppzc());
				yb.setZjppdk(yb.getZjppdk() + itemList.get(i).getZjppdk());
				yb.setZjppzf(yb.getZjppzf() + itemList.get(i).getZjppzf());
				yb.setWctz(yb.getWctz() + itemList.get(i).getWctz());
				yb.setJhtz(yb.getJhtz() + itemList.get(i).getJhtz());
				yb.setCz(yb.getCz() + itemList.get(i).getCz());	
				yb.setSs(yb.getSs() + itemList.get(i).getSs());
				yb.setJy(yb.getJy() + itemList.get(i).getJy());
				yb.setZd(yb.getZd() + itemList.get(i).getZd());
				yb.setNyd(yb.getNyd() + itemList.get(i).getNyd());
				yb.setNt(yb.getNt() + itemList.get(i).getNt());
				yb.setLd(yb.getLd() + itemList.get(i).getLd());
				yb.setSgyy(yb.getSgyy() + itemList.get(i).getSgyy());	
				yb.setHgyp(yb.getHgyp() + itemList.get(i).getHgyp());
				yb.setYhdk(yb.getYhdk() + itemList.get(i).getYhdk());	
				ybnum++;
			}
		}

		
		tableDataString += "<tr style=\"height:28px;font-weight:bold\">" +
				           "<td align=\"center\" >二</td>" +
			               "<td align=\"center\" >预备重点项目("+ybnum+"项)</td>" +
				           "<td align=\"center\" >&nbsp;</td>"+
				           "<td align=\"center\" >&nbsp;</td>"+
				           "<td align=\"center\" >&nbsp;</td>"+
				           "<td align=\"center\" >&nbsp;</td>"+
				           "<td align=\"center\"  >&nbsp;</td>"+
				           "<td align=\"center\"  >&nbsp;</td>"+
				           "<td align=\"center\" >"+yb.getZtz()+"</td>" +
				           "<td align=\"center\"  >"+yb.getZjppzc()+"</td>" +
				           "<td align=\"center\"  >"+yb.getZjppdk()+"</td>" +
				           "<td align=\"center\"  >"+yb.getZjppzf()+"</td>" +
				           "<td align=\"center\"  >"+yb.getWctz()+"</td>" +
				           "<td align=\"center\" >"+yb.getJhtz()+"</td>" +
				           "<td align=\"center\"  >&nbsp;</td>" +
				           "<td align=\"center\" >"+String.format("%.0f", yb.getCz())+"</td>" +
				           "<td align=\"center\" >"+yb.getSs()+"</td>" +
				           "<td align=\"center\"  >"+yb.getJy()+"</td>" +
				           "<td align=\"center\" >"+yb.getZd()+"</td>" +
				           "<td align=\"center\"  >"+yb.getNyd()+"</td>" +
				           "<td align=\"center\"  >"+yb.getNt()+"</td>" +
				           "<td align=\"center\"  >"+yb.getLd()+"</td>" +
				           "<td align=\"center\"  >"+yb.getSgyy()+"</td>" +
				           "<td align=\"center\"  >"+yb.getHgyp()+"</td>" +
				           "<td align=\"center\"  >"+yb.getYhdk()+"</td>" +
				           "<td align=\"center\"  >&nbsp;</td>" +
				           "<td align=\"center\"  >&nbsp;</td></tr>" ;
		

		
		for(int i = 0; i<lb1list.size(); i++){
			//类别数据
			ProZdxm templb1 = new ProZdxm();
			//循环查找列表中相应的数据
			for(int j = 0, k = 0; j<itemList.size(); j++){
			
			   if( itemList.get(j).getLb1().equals(lb1list.get(i)) && itemList.get(j).getLb().equals("预备") ){
				   k++;
				   tempData += "<tr style=\"height:28px;\">" +
		           "<td align=\"center\" >"+k+"</td>" +
	               "<td align=\"center\" >"+itemList.get(j).getMc()+"</td>" +
		           "<td align=\"center\" >"+itemList.get(j).getTzztxz()+"</td>"+
		           "<td align=\"center\" >"+itemList.get(j).getJsdq()+"</td>"+
		           "<td align=\"center\" >"+itemList.get(j).getBawh()+"</td>"+
		           "<td align=\"center\" >"+itemList.get(j).getJsgm()+"</td>"+
		           "<td align=\"center\" >"+itemList.get(j).getJsnx1()+"-"+ itemList.get(j).getJsnx2() +"</td>" +
		           "<td align=\"center\"  >"+itemList.get(j).getDwmc()+"</td>"+
		           "<td align=\"center\"  >"+itemList.get(j).getZtz()+"</td>"+
		           "<td align=\"center\"  >"+itemList.get(j).getZjppzc()+"</td>" +
		           "<td align=\"center\"  >"+itemList.get(j).getZjppdk()+"</td>" +
		           "<td align=\"center\"  >"+itemList.get(j).getZjppzf()+"</td>" +
		           "<td align=\"center\"  >"+itemList.get(j).getWctz()+"</td>" +
		           "<td align=\"center\" >"+itemList.get(j).getJhtz()+"</td>" +
		           "<td align=\"center\"  >"+itemList.get(j).getGcjd()+"</td>" +
		           "<td align=\"center\" >"+String.format("%.0f", itemList.get(j).getCz())+"</td>" +
		           "<td align=\"center\" >"+itemList.get(j).getSs()+"</td>" +
		           "<td align=\"center\"  >"+itemList.get(j).getJy()+"</td>" +
		           "<td align=\"center\" >"+itemList.get(j).getZd()+"</td>" +
		           "<td align=\"center\"  >"+itemList.get(j).getNyd()+"</td>" +
		           "<td align=\"center\"  >"+itemList.get(j).getNt()+"</td>" +
		           "<td align=\"center\"  >"+itemList.get(j).getLd()+"</td>" +
		           "<td align=\"center\"  >"+itemList.get(j).getSgyy()+"</td>" +
		           "<td align=\"center\"  >"+itemList.get(j).getHgyp()+"</td>" +
		           "<td align=\"center\"  >"+itemList.get(j).getYhdk()+"</td>" +
		           "<td align=\"center\"  >"+itemList.get(j).getGldw()+"</td>" +
		           "<td align=\"center\"  >&nbsp;</td></tr>" ;
				   
				   templb1.setZtz(templb1.getZtz() + itemList.get(j).getZtz());
				   templb1.setZjppzc(templb1.getZjppzc() + itemList.get(j).getZjppzc());
				   templb1.setZjppdk(templb1.getZjppdk() + itemList.get(j).getZjppdk());
				   templb1.setZjppzf(templb1.getZjppzf() + itemList.get(j).getZjppzf());
				   templb1.setWctz(templb1.getWctz() + itemList.get(j).getWctz());
				   templb1.setJhtz(templb1.getJhtz() + itemList.get(j).getJhtz());
				   templb1.setCz(templb1.getCz() + itemList.get(j).getCz());	
				   templb1.setSs(templb1.getSs() + itemList.get(j).getSs());
				   templb1.setJy(templb1.getJy() + itemList.get(j).getJy());
				   templb1.setZd(templb1.getZd() + itemList.get(j).getZd());
				   templb1.setNyd(templb1.getNyd() + itemList.get(j).getNyd());
				   templb1.setNt(templb1.getNt() + itemList.get(j).getNt());
				   templb1.setLd(templb1.getLd() + itemList.get(j).getLd());
				   templb1.setSgyy(templb1.getSgyy() + itemList.get(j).getSgyy());	
				   templb1.setHgyp(templb1.getHgyp() + itemList.get(j).getHgyp());
				   templb1.setYhdk(templb1.getYhdk() + itemList.get(j).getYhdk());	
				
				   lb1num++;
			   }
			}

			
			tableDataString += "<tr style=\"height:28px;font-weight:bold\">" +
	           "<td align=\"center\" ></td>" +
               "<td align=\"center\" >"+lb1list.get(i)+"("+lb1num+"项)</td>" +
	           "<td align=\"center\" >&nbsp;</td>"+
	           "<td align=\"center\" >&nbsp;</td>"+
	           "<td align=\"center\" >&nbsp;</td>"+
	           "<td align=\"center\" >&nbsp;</td>"+
	           "<td align=\"center\"  >&nbsp;</td>"+
	           "<td align=\"center\"  >&nbsp;</td>"+
	           "<td align=\"center\" >"+templb1.getZtz()+"</td>" +
	           "<td align=\"center\"  >"+templb1.getZjppzc()+"</td>" +
	           "<td align=\"center\"  >"+templb1.getZjppdk()+"</td>" +
	           "<td align=\"center\"  >"+templb1.getZjppzf()+"</td>" +
	           "<td align=\"center\"  >"+templb1.getWctz()+"</td>" +
	           "<td align=\"center\" >"+templb1.getJhtz()+"</td>" +
	           "<td align=\"center\"  >&nbsp;</td>" +
	           "<td align=\"center\" >"+String.format("%.0f", templb1.getCz())+"</td>" +
	           "<td align=\"center\" >"+templb1.getSs()+"</td>" +
	           "<td align=\"center\"  >"+templb1.getJy()+"</td>" +
	           "<td align=\"center\" >"+templb1.getZd()+"</td>" +
	           "<td align=\"center\"  >"+templb1.getNyd()+"</td>" +
	           "<td align=\"center\"  >"+templb1.getNt()+"</td>" +
	           "<td align=\"center\"  >"+templb1.getLd()+"</td>" +
	           "<td align=\"center\"  >"+templb1.getSgyy()+"</td>" +
	           "<td align=\"center\"  >"+templb1.getHgyp()+"</td>" +
	           "<td align=\"center\"  >"+templb1.getYhdk()+"</td>" +
	           "<td align=\"center\"  >&nbsp;</td>" +
	           "<td align=\"center\"  >&nbsp;</td></tr>" ;
			tableDataString += tempData;
		    tempData = "";
		    lb1num = 0;
		}
		
		
		request.setAttribute("tabledata", tableDataString);

		
	    request.setAttribute("itemList", itemList);
		// 跳转至信息汇总展示界面
		request.getRequestDispatcher("tj_xx.jsp").forward(request, response);
    }
	/**
	 * 重点项目月报信息汇总
	 * @param request  请求
	 * @param response 响应
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toYbxxhzPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String nd =	request.getParameter("nd");  // 年度
		String fromMonth = request.getParameter("fromMonth");  // 开始月份
		String toMonth = request.getParameter("toMonth");  // 结束月份
		String lb1 = request.getParameter("lb1");// 类别：大类
		String lb2 = request.getParameter("lb2");// 类别：小类
		String dq = request.getParameter("dq");// 所属地区
		
		// 总投资
		String ztz1 = request.getParameter("ztz1");// 判断符（全部、大于等于、等于）
		String ztz1num = request.getParameter("ztz2");// 数值1
		String ztz2 = request.getParameter("ztz3");// 判断符（全部、小于）
		String ztz2num = request.getParameter("ztz4");// 数值2
		// 完成投资
		String wctz1 = request.getParameter("wctz1");// 判断符（全部、大于等于、等于）
		String wctz1num = request.getParameter("wctz2");// 数值1
		String wctz2 = request.getParameter("wctz3");// 判断符（全部、小于）
		String wctz2num = request.getParameter("wctz4");// 数值2
		// 计划投资
		String jhtz1 = request.getParameter("jhtz1");// 判断符（全部、大于等于、等于）
		String jhtz1num = request.getParameter("jhtz2");// 数值1
		String jhtz2 = request.getParameter("jhtz3");// 判断符（全部、小于）
		String jhtz2num = request.getParameter("jhtz4");// 判断符（全部、小于）
		// 完成年度计划投资
		String wcjhtz1 = request.getParameter("wcjhtz1");// 判断符（全部、大于等于、等于）
		String wcjhtz1num = request.getParameter("wcjhtz2");// 数值1
		String wcjhtz2 = request.getParameter("wcjhtz3");// 判断符（全部、小于）
		String wcjhtz2num = request.getParameter("wcjhtz4");// 判断符（全部、小于）
		
		String sfscx = request.getParameter("sfscx"); // 是否生产性
		String sfzz = request.getParameter("sfzz"); // 是否重中之重
		String sfss = request.getParameter("sfss");  // 是否省项目
		String sfzy = request.getParameter("sfzy"); // 是否资源
		String sjslb = request.getParameter("sjslb");  // 10+3类别
		String tzztxz = request.getParameter("tzztxz");  // 项目投资主体
		
		String kgFromNd = request.getParameter("kgFromNd");  // 项目开工年份（开始）
		String kgToNd = request.getParameter("kgToNd");  // 项目开工年份（结束）
		String kgFromMonth = request.getParameter("kgFromMonth");  // 项目开工月份（开始）
		String kgToMonth = request.getParameter("kgToMonth");  // 项目开工月份（结束）
		
		// 获取重点月报项目信息
		List<ProZdxmYb> itemList = ZdxmDao.showYbxxhzList(nd, fromMonth, toMonth, lb1, lb2, dq, ztz1,
				ztz1num, ztz2, ztz2num, wctz1, wctz1num, wctz2, wctz2num,
				jhtz1, jhtz1num, jhtz2, jhtz2num, wcjhtz1, wcjhtz1num, wcjhtz2, wcjhtz2num, sfscx, sfzz, sfss, sfzy,
				sjslb, tzztxz, kgFromNd, kgToNd, kgFromMonth, kgToMonth);
	
		
		request.setAttribute("nd", nd);
		request.setAttribute("fromMonth", fromMonth);
		request.setAttribute("toMonth", toMonth);
		
		
		//报表数据
		String tableDataString = "";
		//合计数据
		ProZdxmYb hj = new ProZdxmYb();
		//在建数据
		ProZdxmYb zj = new ProZdxmYb();
		//预备数据
		ProZdxmYb yb = new ProZdxmYb();

		
		for(int i = 0 ; i <itemList.size() ; i++){
			hj.setZtz(hj.getZtz() + itemList.get(i).getZtz());
			hj.setQnwctz(hj.getQnwctz() + itemList.get(i).getQnwctz());
			hj.setNdjhtz(hj.getNdjhtz() + itemList.get(i).getNdjhtz());
			hj.setNczbywc(hj.getNczbywc() + itemList.get(i).getNczbywc());
			hj.setDnljdwhj(hj.getDnljdwhj() + itemList.get(i).getDnljdwhj());
			hj.setKgljwc(hj.getKgljwc() + itemList.get(i).getKgljwc());
			hj.setKgljdwhj(hj.getKgljdwhj() + itemList.get(i).getKgljdwhj());	
		}
		
		if(itemList.size() == 0){
			hj.setDnwctzbl(0);
			hj.setDndwzjbl(0);
			hj.setKgwctzbl(0);
			hj.setKgdwzjbl(0);
		}else {
			hj.setDnwctzbl(hj.getNczbywc()*10000/hj.getNdjhtz());
			hj.setDndwzjbl(hj.getDnljdwhj()*10000/hj.getNdjhtz());
			hj.setKgwctzbl(hj.getKgljwc()*10000/hj.getZtz());
			hj.setKgdwzjbl(hj.getKgljdwhj()*10000/hj.getZtz());
		}
		
		
		tableDataString += "<tr style=\"height:28px;color:red;font-weight:bold\">" +
				           "<td align=\"center\" ></td>" +
			               "<td align=\"center\" style=\"color:red;\" >合计("+itemList.size()+"项)</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getZtz()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getQnwctz()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getNdjhtz()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getNczbywc()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+getForFour(hj.getDnwctzbl())+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getDnljdwhj()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+getForFour(hj.getDndwzjbl())+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getKgljwc()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+getForFour(hj.getKgwctzbl())+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+hj.getKgljdwhj()+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >"+getForFour(hj.getKgdwzjbl())+"</td>" +
				           "<td align=\"center\" style=\"color:red;\" >&nbsp;</td></tr>" ;

		int zjnum = 0;
		for(int i = 0 ; i <itemList.size() ; i++){
			if(itemList.get(i).getLb().equals("在建")){
				zj.setZtz(zj.getZtz() + itemList.get(i).getZtz());
				zj.setQnwctz(zj.getQnwctz() + itemList.get(i).getQnwctz());
				zj.setNdjhtz(zj.getNdjhtz() + itemList.get(i).getNdjhtz());
				zj.setNczbywc(zj.getNczbywc() + itemList.get(i).getNczbywc());
				zj.setDnljdwhj(zj.getDnljdwhj() + itemList.get(i).getDnljdwhj());
				zj.setKgljwc(zj.getKgljwc() + itemList.get(i).getKgljwc());
				zj.setKgljdwhj(zj.getKgljdwhj() + itemList.get(i).getKgljdwhj());
				zjnum++;
			}
		}
		if(zjnum == 0){
			zj.setDnwctzbl(0);
			zj.setDndwzjbl(0);
			zj.setKgwctzbl(0);
			zj.setKgdwzjbl(0);
		}else {
			zj.setDnwctzbl(zj.getNczbywc()*10000/zj.getNdjhtz());
			zj.setDndwzjbl(zj.getDnljdwhj()*10000/zj.getNdjhtz());
			zj.setKgwctzbl(zj.getKgljwc()*10000/zj.getZtz());
			zj.setKgdwzjbl(zj.getKgljdwhj()*10000/zj.getZtz());
			
		}

		
		tableDataString += "<tr style=\"height:28px;font-weight:bold\">" +
				           "<td align=\"center\" >一</td>" +
			               "<td align=\"center\" >在建重点项目("+zjnum+"项)</td>" +
				           "<td align=\"center\" >"+zj.getZtz()+"</td>" +
				           "<td align=\"center\" >"+zj.getQnwctz()+"</td>" +
				           "<td align=\"center\" >"+zj.getNdjhtz()+"</td>" +
				           "<td align=\"center\" >"+zj.getNczbywc()+"</td>" +
				           "<td align=\"center\" >"+getForFour(zj.getDnwctzbl())+"</td>" +
				           "<td align=\"center\" >"+zj.getDnljdwhj()+"</td>" +
				           "<td align=\"center\" >"+getForFour(zj.getDndwzjbl())+"</td>" +
				           "<td align=\"center\" >"+zj.getKgljwc()+"</td>" +
				           "<td align=\"center\" >"+getForFour(zj.getKgwctzbl())+"</td>" +
				           "<td align=\"center\" >"+zj.getKgljdwhj()+"</td>" +
				           "<td align=\"center\" >"+getForFour(zj.getKgdwzjbl())+"</td>" +
				           "<td align=\"center\" >&nbsp;</td></tr>" ;
		
		//得到分级列表
		List<String> lb1list = ZdxmDao.getLb1List();

		
		String tempData = "";
		int lb1num = 0;
		
		for(int i = 0; i<lb1list.size(); i++){
			
			//类别数据
			ProZdxmYb templb1 = new ProZdxmYb();
			//循环查找列表中相应的数据
			for(int j = 0, k = 0; j<itemList.size(); j++){
			
			   if( itemList.get(j).getLb1().equals(lb1list.get(i)) && itemList.get(j).getLb().equals("在建") ){
				   k++;
				   tempData += "<tr style=\"height:28px;\">" +
					           "<td align=\"center\" >"+k+"</td>" +
				               "<td align=\"left\" >"+itemList.get(j).getMc()+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getZtz()+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getQnwctz()+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getNdjhtz()+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getNczbywc()+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getDnwctzbl()+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getDnljdwhj()+"</td>" +
					           "<td align=\"center\" >"+getForThree(itemList.get(j).getDndwzjbl()+"")+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getKgljwc()+"</td>" +
					           "<td align=\"center\" >"+getForThree(itemList.get(j).getKgwctzbl()+"")+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getKgljdwhj()+"</td>" +
					           "<td align=\"center\" >"+getForThree(itemList.get(j).getKgdwzjbl()+"")+"</td>" +
					           "<td align=\"center\" >&nbsp;</td></tr>" ;
				
				   templb1.setZtz(templb1.getZtz() + itemList.get(j).getZtz());
				   templb1.setQnwctz(templb1.getQnwctz() + itemList.get(j).getQnwctz());
				   templb1.setNdjhtz(templb1.getNdjhtz() + itemList.get(j).getNdjhtz());
				   templb1.setNczbywc(templb1.getNczbywc() + itemList.get(j).getNczbywc());
				   templb1.setDnljdwhj(templb1.getDnljdwhj() + itemList.get(j).getDnljdwhj());
				   templb1.setKgljwc(templb1.getKgljwc() + itemList.get(j).getKgljwc());
				   templb1.setKgljdwhj(templb1.getKgljdwhj() + itemList.get(j).getKgljdwhj());
				   lb1num++;
				   
			   }
			}
			if(lb1num == 0){
				templb1.setDnwctzbl(0);
				templb1.setDndwzjbl(0);
				templb1.setKgwctzbl(0);
				templb1.setKgdwzjbl(0);
			}else {
				templb1.setDnwctzbl(templb1.getNczbywc()*10000/templb1.getNdjhtz());
				templb1.setDndwzjbl(templb1.getDnljdwhj()*10000/templb1.getNdjhtz());
				templb1.setKgwctzbl(templb1.getKgljwc()*10000/templb1.getZtz());
				templb1.setKgdwzjbl(templb1.getKgljdwhj()*10000/templb1.getZtz());
				
			}
			
			tableDataString += "<tr style=\"height:28px;font-weight:bold\">" +
	           "<td align=\"center\" ></td>" +
               "<td align=\"center\" >"+lb1list.get(i)+"("+lb1num+"项)</td>" +
	           "<td align=\"center\" >"+templb1.getZtz()+"</td>" +
	           "<td align=\"center\" >"+templb1.getQnwctz()+"</td>" +
	           "<td align=\"center\" >"+templb1.getNdjhtz()+"</td>" +
	           "<td align=\"center\" >"+templb1.getNczbywc()+"</td>" +
	           "<td align=\"center\" >"+getForFour(templb1.getDnwctzbl())+"</td>" +
	           "<td align=\"center\" >"+templb1.getDnljdwhj()+"</td>" +
	           "<td align=\"center\" >"+getForFour(templb1.getDndwzjbl())+"</td>" +
	           "<td align=\"center\" >"+templb1.getKgljwc()+"</td>" +
	           "<td align=\"center\" >"+getForFour(templb1.getKgwctzbl())+"</td>" +
	           "<td align=\"center\" >"+templb1.getKgljdwhj()+"</td>" +
	           "<td align=\"center\" >"+getForFour(templb1.getKgdwzjbl())+"</td>" +
	           "<td align=\"center\" >&nbsp;</td></tr>" ;
			tableDataString += tempData;
		    tempData = "";
		    lb1num = 0;
		}
		
		int ybnum = 0;
		for(int i = 0 ; i <itemList.size() ; i++){
			if(itemList.get(i).getLb().equals("预备")){
				yb.setZtz(yb.getZtz() + itemList.get(i).getZtz());
				yb.setQnwctz(yb.getQnwctz() + itemList.get(i).getQnwctz());
				yb.setNdjhtz(yb.getNdjhtz() + itemList.get(i).getNdjhtz());
				yb.setNczbywc(yb.getNczbywc() + itemList.get(i).getNczbywc());
				yb.setDnljdwhj(yb.getDnljdwhj() + itemList.get(i).getDnljdwhj());
				yb.setKgljwc(yb.getKgljwc() + itemList.get(i).getKgljwc());
				yb.setKgljdwhj(yb.getKgljdwhj() + itemList.get(i).getKgljdwhj());
				ybnum++;
			}
		}
		if(ybnum == 0){
			yb.setDnwctzbl(0);
			yb.setDndwzjbl(0);
			yb.setKgwctzbl(0);
			yb.setKgdwzjbl(0);
		}else {
			yb.setDnwctzbl(yb.getNczbywc()*10000/yb.getNdjhtz());
			yb.setDndwzjbl(yb.getDnljdwhj()*10000/yb.getNdjhtz());
			yb.setKgwctzbl(yb.getKgljwc()*10000/yb.getZtz());
			yb.setKgdwzjbl(yb.getKgljdwhj()*10000/yb.getZtz());
			
		}

		
		tableDataString += "<tr style=\"height:28px;font-weight:bold\">" +
				           "<td align=\"center\" >二</td>" +
			               "<td align=\"center\" >预备重点项目("+ybnum+"项)</td>" +
				           "<td align=\"center\" >"+yb.getZtz()+"</td>" +
				           "<td align=\"center\" >"+yb.getQnwctz()+"</td>" +
				           "<td align=\"center\" >"+yb.getNdjhtz()+"</td>" +
				           "<td align=\"center\" >"+yb.getNczbywc()+"</td>" +
				           "<td align=\"center\" >"+getForFour(yb.getDnwctzbl())+"</td>" +
				           "<td align=\"center\" >"+yb.getDnljdwhj()+"</td>" +
				           "<td align=\"center\" >"+getForFour(yb.getDndwzjbl())+"</td>" +
				           "<td align=\"center\" >"+yb.getKgljwc()+"</td>" +
				           "<td align=\"center\" >"+getForFour(yb.getKgwctzbl())+"</td>" +
				           "<td align=\"center\" >"+yb.getKgljdwhj()+"</td>" +
				           "<td align=\"center\" >"+getForFour(yb.getKgdwzjbl())+"</td>" +
				           "<td align=\"center\" >&nbsp;</td></tr>" ;
		

		
		for(int i = 0; i<lb1list.size(); i++){
			//类别数据
			ProZdxmYb templb1 = new ProZdxmYb();
			//循环查找列表中相应的数据
			for(int j = 0, k = 0; j<itemList.size(); j++){
			
			   if( itemList.get(j).getLb1().equals(lb1list.get(i)) && itemList.get(j).getLb().equals("预备") ){
				   k++;
				   tempData += "<tr style=\"height:28px;\">" +
					           "<td align=\"center\" >"+k+"</td>" +
				               "<td align=\"left\" >"+itemList.get(j).getMc()+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getZtz()+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getQnwctz()+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getNdjhtz()+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getNczbywc()+"</td>" +
					           "<td align=\"center\" >"+getForThree(itemList.get(j).getDnwctzbl()+"")+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getDnljdwhj()+"</td>" +
					           "<td align=\"center\" >"+getForThree(itemList.get(j).getDndwzjbl()+"")+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getKgljwc()+"</td>" +
					           "<td align=\"center\" >"+getForThree(itemList.get(j).getKgwctzbl()+"")+"</td>" +
					           "<td align=\"center\" >"+itemList.get(j).getKgljdwhj()+"</td>" +
					           "<td align=\"center\" >"+getForThree(itemList.get(j).getKgdwzjbl()+"")+"</td>" +
					           "<td align=\"center\" >&nbsp;</td></tr>" ;
				
				   templb1.setZtz(templb1.getZtz() + itemList.get(j).getZtz());
				   templb1.setQnwctz(templb1.getQnwctz() + itemList.get(j).getQnwctz());
				   templb1.setNdjhtz(templb1.getNdjhtz() + itemList.get(j).getNdjhtz());
				   templb1.setNczbywc(templb1.getNczbywc() + itemList.get(j).getNczbywc());
				   templb1.setDnljdwhj(templb1.getDnljdwhj() + itemList.get(j).getDnljdwhj());
				   templb1.setKgljwc(templb1.getKgljwc() + itemList.get(j).getKgljwc());
				   templb1.setKgljdwhj(templb1.getKgljdwhj() + itemList.get(j).getKgljdwhj());
				   lb1num++;
				   
			   }
			}
			if(lb1num == 0){
				templb1.setDnwctzbl(0);
				templb1.setDndwzjbl(0);
				templb1.setKgwctzbl(0);
				templb1.setKgdwzjbl(0);
			}else {
				templb1.setDnwctzbl(templb1.getNdjhtz()==0?0:templb1.getNczbywc()*10000/templb1.getNdjhtz());
				templb1.setDndwzjbl(templb1.getNdjhtz()==0?0:templb1.getDnljdwhj()*10000/templb1.getNdjhtz());
				templb1.setKgwctzbl(templb1.getZtz()==0?0:templb1.getKgljwc()*10000/templb1.getZtz());
				templb1.setKgdwzjbl(templb1.getZtz()==0?0:templb1.getKgljdwhj()*10000/templb1.getZtz());
				
			}
			
			tableDataString += "<tr style=\"height:28px;font-weight:bold\">" +
	           "<td align=\"center\" ></td>" +
               "<td align=\"center\" >"+lb1list.get(i)+"("+lb1num+"项)</td>" +
	           "<td align=\"center\" >"+templb1.getZtz()+"</td>" +
	           "<td align=\"center\" >"+templb1.getQnwctz()+"</td>" +
	           "<td align=\"center\" >"+templb1.getNdjhtz()+"</td>" +
	           "<td align=\"center\" >"+templb1.getNczbywc()+"</td>" +
	           "<td align=\"center\" >"+getForFour(templb1.getDnwctzbl())+"</td>" +
	           "<td align=\"center\" >"+templb1.getDnljdwhj()+"</td>" +
	           "<td align=\"center\" >"+getForFour(templb1.getDndwzjbl())+"</td>" +
	           "<td align=\"center\" >"+templb1.getKgljwc()+"</td>" +
	           "<td align=\"center\" >"+getForFour(templb1.getKgwctzbl())+"</td>" +
	           "<td align=\"center\" >"+templb1.getKgljdwhj()+"</td>" +
	           "<td align=\"center\" >"+getForFour(templb1.getKgdwzjbl())+"</td>" +
	           "<td align=\"center\" >&nbsp;</td></tr>" ;
			tableDataString += tempData;
		    tempData = "";
		    lb1num = 0;
		}
		
		
		request.setAttribute("tabledata", tableDataString);
		
		
		request.setAttribute("itemList", itemList);
		// 跳转至信息汇总展示界面
		request.getRequestDispatcher("tj_yb.jsp").forward(request, response);
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
	
		request.setAttribute("dqlist", ZdxmDao.getDqList());
		request.setAttribute("lblist", ZdxmDao.getLbList());
		request.getRequestDispatcher("tj_xx_page.jsp").forward(request, response);

    }
	/**
	 * 月报信息汇总
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void ybXxhz(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		request.setAttribute("dqlist", ZdxmDao.getDqList());
		request.setAttribute("lblist", ZdxmDao.getLbList());
		request.getRequestDispatcher("tj_yb_page.jsp").forward(request, response);
		
	}
	/**
	 * 形象进度查询汇总
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void xxjdhz(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		request.setAttribute("dqlist", ZdxmDao.getDqList());
		request.setAttribute("lblist", ZdxmDao.getLbList());
		request.getRequestDispatcher("tj_xxjd_page.jsp").forward(request, response);
		
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
		String id = request.getParameter("id");  // 项目主键
		String shyj = request.getParameter("shyj");  // 审核意见
		ZdxmDao.audit(id,"已退回",shyj); // 修改项目状态和审核意见
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
		String id = request.getParameter("id");  // 项目主键
		String shyj = request.getParameter("shyj");  // 审核意见
		ZdxmDao.audit(id,"已审核",shyj); // 修改项目状态和审核意见
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideEditFrame();</script>"); 
		out.flush();
	}
	/**
	 * get请求加载待审核列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getAudit(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
		Integer  pageNo   = 1;	// 起始页
		Integer  pageSize = 10; // 每页条数
		if (!(request.getParameter("pageNo") == null || request.getParameter("pageNo").equals(""))) {
			pageNo = Integer.valueOf(request.getParameter("pageNo"));
		}
		if (!(request.getParameter("pageSize") == null || request.getParameter("pageSize").equals(""))) {
			pageSize = Integer.valueOf(request.getParameter("pageSize"));
		}
	    String searchStr = request.getParameter("searchStr"); // 查询条件
	    String nd = FavoritesHelper.nullChangeString(request.getParameter("nd")); //项目年度
		String lb = FavoritesHelper.nullChangeString(request.getParameter("lb"));// 项目类别
		if (!FavoritesHelper.isNotNull(nd)) {
	    	Calendar calendar = Calendar.getInstance();
			nd = calendar.get(Calendar.YEAR)+"";
		}
	    if (!FavoritesHelper.isNotNull(lb)) {
	    	lb = "在建";
	    }
		Pager pager = ZdxmDao.getObjForAudit(pageNo, pageSize,lb, nd, searchStr); // 获取查询结果，存放至分页对象中
		request.setAttribute("pager", pager);
		request.setAttribute("nd", nd);
		request.setAttribute("xmlb", lb);
		request.setAttribute("searchStr", searchStr);
		request.getRequestDispatcher("sh.jsp").forward(request, response); // 跳转至审核页面
	}
	/**
	 * get请求加载待审核列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getAuditSearch(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		Integer  pageNo   = 1;	// 起始页
		Integer  pageSize = 10; // 每页条数

		if (!(request.getParameter("pageNo") == null || request.getParameter(
				"pageNo").equals(""))) {
			pageNo = Integer.valueOf(request.getParameter("pageNo"));
		}
		if (!(request.getParameter("pageSize") == null || request.getParameter(
				"pageSize").equals(""))) {
			pageSize = Integer.valueOf(request.getParameter("pageSize"));
		}
		String searchStr = request.getParameter("searchStr");
		String nd = FavoritesHelper.nullChangeString(request.getParameter("nd")); //项目年度
		String lb = FavoritesHelper.nullChangeString(request.getParameter("lb"));// 项目类别
		Pager pager = ZdxmDao.getObjForAudit(pageNo, pageSize, lb, nd, searchStr);
		request.setAttribute("pager", pager);
		request.setAttribute("nd", nd);
		request.setAttribute("xmlb", lb);
		request.setAttribute("searchStr", searchStr);
		request.getRequestDispatcher("sh.jsp").forward(request, response);
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
		long id   = Long.valueOf(request.getParameter("id")); // 信息主键
		ProZdxm item = ZdxmDao.getObjById(id); // 信息对象
		request.setAttribute("item", item);
		request.getRequestDispatcher("ll.jsp").forward(request, response);
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
		
		// 重点项目实体
		ProZdxm item = new ProZdxm();
		// 为各属性赋值
		item.setId(Long.valueOf(request.getParameter("id")));
		item.setBh(request.getParameter("bh"));
		item.setNd(FavoritesHelper.stringTolong(request.getParameter("nd")));
	    item.setMc(request.getParameter("mc"));
	    item.setDq(request.getParameter("dq"));
	    item.setKgn(request.getParameter("kgn"));
	    item.setKgy(request.getParameter("kgy"));
	    item.setLb(request.getParameter("lb"));
	    item.setLb1(request.getParameter("lb1"));
	    item.setLb2(request.getParameter("lb2"));
	    item.setJsdq(request.getParameter("jsdq"));
	    item.setJsdd(request.getParameter("jsdd"));
	    item.setJsgm(request.getParameter("jsgm"));
	    item.setBawh(request.getParameter("bawh"));
	    item.setJsnx1(FavoritesHelper.stringToint(request.getParameter("jsnx1")));
	    item.setJsnx2(FavoritesHelper.stringToint(request.getParameter("jsnx2")));
	    item.setZtz(FavoritesHelper.stringTolong(request.getParameter("ztz")));
	    item.setWctz(FavoritesHelper.stringTolong(request.getParameter("wctz")));
	    item.setJzqk(request.getParameter("jzqk"));
	    item.setJhtz(FavoritesHelper.stringTolong(request.getParameter("jhtz")));
	    item.setTz1(FavoritesHelper.stringTolong(request.getParameter("tz1")));
	    item.setTz2(FavoritesHelper.stringTolong(request.getParameter("tz2")));
	    item.setTz3(FavoritesHelper.stringTolong(request.getParameter("tz3")));
	    item.setTz4(FavoritesHelper.stringTolong(request.getParameter("tz4")));
	    item.setTz5(FavoritesHelper.stringTolong(request.getParameter("tz5")));
	    item.setTz6(FavoritesHelper.stringTolong(request.getParameter("tz6")));
	    item.setTz7(FavoritesHelper.stringTolong(request.getParameter("tz7")));
	    item.setTz8(FavoritesHelper.stringTolong(request.getParameter("tz8")));
	    item.setTz9(FavoritesHelper.stringTolong(request.getParameter("tz9")));
	    item.setTz10(FavoritesHelper.stringTolong(request.getParameter("tz10")));
	    item.setTz11(FavoritesHelper.stringTolong(request.getParameter("tz11")));
	    item.setTz12(FavoritesHelper.stringTolong(request.getParameter("tz12")));
	    item.setGcjd(request.getParameter("gcjd"));
	    item.setDwmc(request.getParameter("dwmc"));
	    item.setZrr(request.getParameter("zrr"));
	    item.setGldw(request.getParameter("gldw"));
	    item.setZjppzc(FavoritesHelper.stringTolong(request.getParameter("zjppzc")));
	    item.setZjppdk(FavoritesHelper.stringTolong(request.getParameter("zjppdk")));
	    item.setZjppzf(FavoritesHelper.stringTolong(request.getParameter("zjppzf")));
	    item.setTzztxz(request.getParameter("ztxz"));
	    item.setSfkg(request.getParameter("sfkg"));
	    item.setKgyf(request.getParameter("kgyf"));
	    item.setCz(FavoritesHelper.stringTofloat(request.getParameter("cz")));
	    item.setSs(FavoritesHelper.stringTofloat(request.getParameter("ss")));
	    item.setJy(FavoritesHelper.stringToint(request.getParameter("jy")));
	    item.setZd(FavoritesHelper.stringTofloat(request.getParameter("zd")));
	    item.setNyd(FavoritesHelper.stringTofloat(request.getParameter("nyd")));
	    item.setNt(FavoritesHelper.stringTofloat(request.getParameter("nt")));
	    item.setLd(FavoritesHelper.stringTofloat(request.getParameter("ld")));
	    item.setSgyy(FavoritesHelper.stringTofloat(request.getParameter("sgyy")));
	    item.setHgyp(FavoritesHelper.stringTofloat(request.getParameter("hgyp")));
	    item.setYhdk(FavoritesHelper.stringTofloat(request.getParameter("yhdk")));
	    item.setSfscx(request.getParameter("sfscx"));
	    item.setSfzz(request.getParameter("sfzz"));
	    item.setSfss(request.getParameter("sfss"));
	    item.setSfzy(request.getParameter("sfzy"));
	    if(!"取消选择".equals(request.getParameter("sjslb"))){
	    	item.setSjslb(request.getParameter("sjslb"));
	    } 
	
		ZdxmDao.update(item);	
			
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
	    out.print("<script type='text/javascript'>alert('修改成功！');window.parent.hideEditFrame();</script>");
		//out.println("<script type='text/javascript'>window.parent.hideEditFrame();</script>"); 
		out.flush();
	}
	
	/**
	 * 跳转到查看详情页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goReadPage(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
		long id = Long.valueOf(request.getParameter("id")); // 项目主键
		ProZdxm item = ZdxmDao.getObjById(id); // 项目信息
		request.setAttribute("item", item);
		request.getRequestDispatcher("xmll.jsp").forward(request, response);
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
		// 项目主键
		long id   = Long.valueOf(request.getParameter("id"));
		ProZdxm item = ZdxmDao.getObjById(id);
		request.setAttribute("dqlist",  ZdxmDao.getDqList());
		request.setAttribute("lblist", ZdxmDao.getLbList());
		request.setAttribute("item", item);
		request.getRequestDispatcher("xg.jsp").forward(request, response);
	}
	
	/**
	 * 添加新项
	 * @param request
	 * @param response
	 * @param type 执行类型（1：从项目信息管理中进入项目信息录入页面，2：直接进入项目信息录入页面）
	 * @throws ServletException
	 * @throws IOException
	 */
	private void add(HttpServletRequest request, HttpServletResponse response, int type)
	throws ServletException, IOException {
		// 重点项目实体
		ProZdxm item = new ProZdxm();
		// 为各属性赋值
		item.setBh(request.getParameter("bh"));
		item.setNd(FavoritesHelper.stringTolong(request.getParameter("nd")));
	    item.setMc(request.getParameter("mc"));
	    item.setDq(request.getParameter("dq"));
	    item.setKgn(request.getParameter("kgn"));
	    item.setKgy(request.getParameter("kgy"));
	    item.setLb(request.getParameter("lb"));
	    item.setLb1(request.getParameter("lb1"));
	    item.setLb2(request.getParameter("lb2"));
	    item.setJsdq(request.getParameter("jsdq"));
	    item.setJsdd(request.getParameter("jsdd"));
	    item.setJsgm(request.getParameter("jsgm"));
	    item.setBawh(request.getParameter("bawh"));
	    item.setJsnx1(FavoritesHelper.stringToint(request.getParameter("jsnx1")));
	    item.setJsnx2(FavoritesHelper.stringToint(request.getParameter("jsnx2")));
	    item.setZtz(FavoritesHelper.stringTolong(request.getParameter("ztz")));
	    item.setWctz(FavoritesHelper.stringTolong(request.getParameter("wctz")));
	    item.setJzqk(request.getParameter("jzqk"));
	    item.setJhtz(FavoritesHelper.stringTolong(request.getParameter("jhtz")));
	    item.setTz1(FavoritesHelper.stringTolong(request.getParameter("tz1")));
	    item.setTz2(FavoritesHelper.stringTolong(request.getParameter("tz2")));
	    item.setTz3(FavoritesHelper.stringTolong(request.getParameter("tz3")));
	    item.setTz4(FavoritesHelper.stringTolong(request.getParameter("tz4")));
	    item.setTz5(FavoritesHelper.stringTolong(request.getParameter("tz5")));
	    item.setTz6(FavoritesHelper.stringTolong(request.getParameter("tz6")));
	    item.setTz7(FavoritesHelper.stringTolong(request.getParameter("tz7")));
	    item.setTz8(FavoritesHelper.stringTolong(request.getParameter("tz8")));
	    item.setTz9(FavoritesHelper.stringTolong(request.getParameter("tz9")));
	    item.setTz10(FavoritesHelper.stringTolong(request.getParameter("tz10")));
	    item.setTz11(FavoritesHelper.stringTolong(request.getParameter("tz11")));
	    item.setTz12(FavoritesHelper.stringTolong(request.getParameter("tz12")));
	    item.setGcjd(request.getParameter("gcjd"));
	    item.setDwmc(request.getParameter("dwmc"));
	    item.setZrr(request.getParameter("zrr"));
	    item.setGldw(request.getParameter("gldw"));
	    item.setZjppzc(FavoritesHelper.stringTolong(request.getParameter("zjppzc")));
	    item.setZjppdk(FavoritesHelper.stringTolong(request.getParameter("zjppdk")));
	    item.setZjppzf(FavoritesHelper.stringTolong(request.getParameter("zjppzf")));
	    item.setTzztxz(request.getParameter("ztxz"));
	    item.setSfkg(request.getParameter("sfkg"));
	    item.setKgyf(request.getParameter("kgyf"));
	    item.setCz(FavoritesHelper.stringTofloat(request.getParameter("cz")));
	    item.setSs(FavoritesHelper.stringTofloat(request.getParameter("ss")));
	    item.setJy(FavoritesHelper.stringToint(request.getParameter("jy")));
	    item.setZd(FavoritesHelper.stringTofloat(request.getParameter("zd")));
	    item.setNyd(FavoritesHelper.stringTofloat(request.getParameter("nyd")));
	    item.setNt(FavoritesHelper.stringTofloat(request.getParameter("nt")));
	    item.setLd(FavoritesHelper.stringTofloat(request.getParameter("ld")));
	    item.setSgyy(FavoritesHelper.stringTofloat(request.getParameter("sgyy")));
	    item.setHgyp(FavoritesHelper.stringTofloat(request.getParameter("hgyp")));
	    item.setYhdk(FavoritesHelper.stringTofloat(request.getParameter("yhdk")));
	    item.setSfscx(request.getParameter("sfscx"));
	    item.setSfzz(request.getParameter("sfzz"));
	    item.setSfss(request.getParameter("sfss"));
	    item.setSfzy(request.getParameter("sfzy"));
	    if(!"取消选择".equals(request.getParameter("sjslb"))){
	    	item.setSjslb(request.getParameter("sjslb"));
	    } 
	    item.setZt("未上报");
	    item.setSbyh(request.getSession().getAttribute("yhm").toString());
		ZdxmDao.add(item);
		// 提示保存成功
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
	    if (1 == type) {
	    	out.println("<script type='text/javascript'>window.parent.hideEditFrame();</script>"); 
		} else if (2 == type){
			out.print("<script>alert('保存成功！');location.href='ZdxmServlet?action=toAdd&type=2'</script>");
		}
		out.flush();
		out.close();
	}
	
	
	/**
	 * 跳转到添加页面
	 * @param request
	 * @param response
	 * @param type 执行类型（1：从项目信息管理中进入项目信息录入页面，2：直接进入项目信息录入页面）
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goAddPage(HttpServletRequest request, HttpServletResponse response, int type)
	    throws ServletException, IOException {
		request.setAttribute("dqlist",  ZdxmDao.getDqList());
		request.setAttribute("lblist", ZdxmDao.getLbList());
		if (1 == type) {
			request.getRequestDispatcher("lr.jsp").forward(request, response);
		}else if (2 == type) {
			request.getRequestDispatcher("add.jsp").forward(request, response);
		}
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
		 	
		if(ZdxmDao.delItemList(itemList)){
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
		String nd = FavoritesHelper.nullChangeString(request.getParameter("nd"));
		String lb = FavoritesHelper.nullChangeString(request.getParameter("lb"));
	    String searchStr = request.getParameter("searchStr");
	    if (!FavoritesHelper.isNotNull(nd)) {
	    	Calendar calendar = Calendar.getInstance();
			nd = calendar.get(Calendar.YEAR)+"";
		}
	    if (!FavoritesHelper.isNotNull(lb)) {
	    	lb = "在建";
	    }
	    
		Pager pager = ZdxmDao.getObjForPage(pageNo, pageSize, lb, nd, searchStr);
	
		request.setAttribute("pager", pager);
		request.setAttribute("xmlb", lb);
		request.setAttribute("nd", nd);
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
		String nd = FavoritesHelper.nullChangeString(request.getParameter("nd"));
		String lb = FavoritesHelper.nullChangeString(request.getParameter("lb"));
		request.setAttribute("nd", nd);
		request.setAttribute("xmlb", lb);
		Pager pager = ZdxmDao.getObjForPage(pageNo, pageSize, lb, nd, searchStr);
	
		request.setAttribute("pager", pager);
		request.setAttribute("searchStr", searchStr);
	
		request.getRequestDispatcher("gl.jsp").forward(request, response);
		
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
