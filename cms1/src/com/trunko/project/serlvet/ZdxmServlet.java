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
	    if(action.equals("list")){//��ʾ�б�
		    getList(request, response);
	    }
	    else if(action.equals("toAdd")){//��ת������ҳ��
	    	int type = FavoritesHelper.stringToint(request.getParameter("type")); // ��ת����
		    goAddPage(request, response, type);
	    }
	    else if(action.equals("toEdit")){//��ת���༭ҳ��
		    goEditPage(request, response);
	    }
	    else if(action.equals("toRead")){//��ת���鿴����ҳ��
		    goReadPage(request, response);
	    }
	    else if(action.equals("audit")){//��ת����������ҳ��
	    	getAudit(request, response);
	    }
	    else if(action.equals("toAudit")){//���
	    	goAuditPage(request,response);
	    }
	    else if(action.equals("xxhz")){   //��Ϣ����	
	    	Xxhz(request,response);
	    }
	    else if(action.equals("ybxxhz")){   //�±���Ϣ����	
	    	ybXxhz(request,response);
	    }
	    else if(action.equals("xxhzpage")){   //��Ϣ���� ҳ��
	    	toXxhzPage(request,response);
	    }
	    else if(action.equals("getXxfjhzInfo")){   //ajax��Ϣ�ּ���������
	    	getXxfjhzInfo(request,response);
	    }
	    else if(action.equals("xxfjhzpage")){   //��Ϣ�ּ����� ҳ��
	    	toXxfjhzpage(request,response);
	    }
	    else if(action.equals("xxjdhzpage")){   //������Ȳ�ѯ
	    	toXxjdhzpage(request,response);
	    }
	    else if(action.equals("zyxxjd")){   //��Ҫ�������
	    	toZyxxjdpage(request,response);
	    }
	    else if(action.equals("xxjdhz")){   //��ת��������Ȳ�ѯ������дҳ��
	    	xxjdhz(request,response);
	    }
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
	    String action=request.getParameter("action");
	   
	    if(action.equals("list")){//��ʾ�б�
		    postList(request, response);
	    }
	    else if(action.equals("del")){//ɾ���б���
		    delItems(request, response);
	    }
	    else if(action.equals("toAdd")){//��ת������ҳ��
	    	int type = FavoritesHelper.stringToint(request.getParameter("type")); // ��ת����
		    goAddPage(request, response, type);
	    }
	    else if(action.equals("add")){//�����б���
	    	int type = FavoritesHelper.stringToint(request.getParameter("type")); // ��ת����
		    add(request, response, type);
	    }
	    else if(action.equals("toEdit")){//��ת���༭ҳ��
		    goEditPage(request, response);
	    }
	    else if(action.equals("update")){//�޸��б���
		    update(request, response);
	    }
	    else if(action.equals("audit")){//��ת����������ҳ��
	    	getAudit(request, response);
	    }
	    else if(action.equals("auditSearch")){//��ת����������ҳ��
	    	getAuditSearch(request, response);
	    }
	    else if(action.equals("toAudit")){//���
	    	goAuditPage(request,response);
	    }
	    else if(action.equals("shtg")){//���ͨ��
	    	shtg(request,response);
	    }
	    else if(action.equals("thsq")){//�˻�����
	    	thsq(request,response);
	    }
	    else if(action.equals("xxhz")){   //��Ϣ����	
	    	Xxhz(request,response);
	    }
	    else if(action.equals("xxhzpage")){   //��Ϣ���� ҳ��
	    	toXxhzPage(request,response);
	    }
	    else if(action.equals("ybxxhzpage")){   //�±���Ϣ���� ҳ��
	    	toYbxxhzPage(request,response);
	    }
	    else if(action.equals("xxflhzpage")){   //��Ϣ�������  add by lhanliang
	    	toFlhzPage(request,response);
	    }else if(action.equals("cyflhzpage")){   //����ҵ��Ϣ����
	    	toCyflhzPage(request,response);	
	    	
	    }else if(action.equals("cymxhzpage")){   //����ҵ��ϸ����
	    	toCymxhzPage(request,response);
	    }

	    else if(action.equals("getXxfjhzInfo")){   //ajax��Ϣ�ּ���������
	    	getXxfjhzInfo(request,response);
	    }
	    else if(action.equals("xxfjhzpage")){   //��Ϣ�ּ����� ҳ��
	    	toXxfjhzpage(request,response);
	    }
	    else if(action.equals("getXxflhzInfo")){   //ajax��Ϣ�ּ���������
	    	getXxflhzInfo(request,response);
	    }else if(action.equals("getFcyhzInfo")){   //ajax����ҵ�ּ���������
	    	getFcyhzInfo(request,response);
	    	
	    }else if(action.equals("getFcymxhzInfo")){ //ajax����ҵ��ϸ����
	    	getFcymxhzInfo(request,response);
	    }
	    
	    else if(action.equals("xxjdhzpage")){   //������Ȳ�ѯ
	    	toXxjdhzpage(request,response);
	    }
	    else if(action.equals("zyxxjd")){   //��Ҫ�������
	    	toZyxxjdpage(request,response);
	    }
	    else if(action.equals("zjdwqkpage")){   //�ʽ�λ���
	    	toZjdwqkpage(request,response);
	    }
	}
	
	/**
	 * �ʽ�λ���
	 * @param request ����
	 * @param response ��Ӧ
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toZjdwqkpage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String nd =	request.getParameter("year");  // ���
		String fromMonth = request.getParameter("fromMonth");  // ��ʼ�·�
		String toMonth = request.getParameter("toMonth");  // �����·�
		
		// ��ȡ�ʽ�λ���
		List<ProZdxmYb> itemList = ZdxmDao.showZjdwqkList(nd, fromMonth, toMonth);
	
		
		request.setAttribute("nd", nd);
		request.setAttribute("fromMonth", fromMonth);
		request.setAttribute("toMonth", toMonth);
		
		
		//��������
		String tableDataString = "";
		//�ϼ�����
		ProZdxmYb hj = new ProZdxmYb();
		//�ڽ�����
		ProZdxmYb zj = new ProZdxmYb();
		//Ԥ������
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
			               "<td align=\"center\" style=\"color:red;\" >�ϼ�("+itemList.size()+"��)</td>" +
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
			if(itemList.get(i).getLb().equals("�ڽ�")){
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
				           "<td align=\"center\" >һ</td>" +
			               "<td align=\"center\" >�ڽ��ص���Ŀ("+zjnum+"��)</td>" +
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
		
		//�õ��ּ��б�
		List<String> lb1list = ZdxmDao.getLb1List();
		
		
		String tempData = "";
		int lb1num = 0;
		
		for(int i = 0; i<lb1list.size(); i++){
			//�������
			ProZdxmYb templb1 = new ProZdxmYb();
			//ѭ�������б�����Ӧ������
			for(int j = 0, k = 0; j<itemList.size(); j++){
			
			   if( itemList.get(j).getLb1().equals(lb1list.get(i)) && itemList.get(j).getLb().equals("�ڽ�") ){
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
               "<td align=\"center\" >"+lb1list.get(i)+"("+lb1num+"��)</td>" +
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
			if(itemList.get(i).getLb().equals("Ԥ��")){
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
				           "<td align=\"center\" >��</td>" +
			               "<td align=\"center\" >Ԥ���ص���Ŀ("+ybnum+"��)</td>" +
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
			//�������
			ProZdxmYb templb1 = new ProZdxmYb();
			//ѭ�������б�����Ӧ������
			for(int j = 0, k = 0; j<itemList.size(); j++){
			
			   if( itemList.get(j).getLb1().equals(lb1list.get(i)) && itemList.get(j).getLb().equals("Ԥ��") ){
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
               "<td align=\"center\" >"+lb1list.get(i)+"("+lb1num+"��)</td>" +
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
		// ��ת����Ϣ����չʾ����
		request.getRequestDispatcher("tj_yb.jsp").forward(request, response);
	}
	
	
	
	
	/**
	 * ��Ҫ�������
	 * @param request ����
	 * @param response ��Ӧ
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toZyxxjdpage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String nd = request.getParameter("year");  // ���
		String fromMonth =	request.getParameter("fromMonth");  // ��ʼ�·�
		String toMonth = request.getParameter("toMonth");  // �����·�
		
		// ��Ҫ�������
		List<ProZdxmYb> itemList = ZdxmDao.showZyxxjdList(nd, fromMonth, toMonth);
	
		
		request.setAttribute("nd", nd);
		request.setAttribute("fromMonth", fromMonth);
		request.setAttribute("toMonth", toMonth);
		
		
		//��������
		String tableDataString = "";
		//�ϼ�����
		ProZdxmYb hj = new ProZdxmYb();
		//�ڽ�����
		ProZdxmYb zj = new ProZdxmYb();
		//Ԥ������
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
		
		
		tableDataString += "<b>ȫ���ص���Ŀ("+itemList.size()+"��)��</b>���Ͷ��"+hj.getNczbywc()+"����Ԫ����ռ��ȼƻ�"+getForFour(hj.getDnwctzbl())+"%����λ�ʽ�"+hj.getDnljdwhj()+"����Ԫ����ռ��ȼƻ�"+getForFour(hj.getDndwzjbl())+"%�������ۼ����Ͷ��"+hj.getKgljwc()+"����Ԫ����ռ�ܼƻ�"+getForFour(hj.getKgwctzbl())+"%����λ�ʽ�"+hj.getKgljdwhj()+"����Ԫ����ռ�ܼƻ�"+getForFour(hj.getKgdwzjbl())+"%��<br/><br/>";
		int zjnum = 0;
		for(int i = 0 ; i <itemList.size() ; i++){
			if(itemList.get(i).getLb().equals("�ڽ�")){
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

		tableDataString += "<b>һ���ڽ��ص���Ŀ("+zjnum+"��)��</b> ���Ͷ��"+zj.getNczbywc()+"����Ԫ����ռ��ȼƻ�"+getForFour(zj.getDnwctzbl())+"%����λ�ʽ�"+zj.getDnljdwhj()+"����Ԫ����ռ��ȼƻ�"+getForFour(zj.getDndwzjbl())+"%�������ۼ����Ͷ��"+zj.getKgljwc()+"����Ԫ����ռ�ܼƻ�"+getForFour(zj.getKgwctzbl())+"%����λ�ʽ�"+zj.getKgljdwhj()+"����Ԫ����ռ�ܼƻ�"+getForFour(zj.getKgdwzjbl())+"%��<br/><br/>";
		
		//�õ��ּ��б�
		List<String> lb1list = ZdxmDao.getLb1List();
		
		String tempData = "";
		int lb1num = 0;
		
		for(int i = 0; i<lb1list.size(); i++){

			//�������
			ProZdxmYb templb1 = new ProZdxmYb();
			//ѭ�������б�����Ӧ������
			for(int j = 0, k = 0; j<itemList.size(); j++){
				
				if( itemList.get(j).getLb1().equals(lb1list.get(i)) && itemList.get(j).getLb().equals("�ڽ�") ){
					k++;
					tempData += "<b>"+k+"."+itemList.get(j).getMc()+"��</b> ���Ͷ��"+itemList.get(j).getNczbywc()+"����Ԫ����ռ��ȼƻ�"+itemList.get(j).getDnwctzbl()+"%����λ�ʽ�"+itemList.get(j).getDnljdwhj()+"����Ԫ����ռ��ȼƻ�"+itemList.get(j).getDndwzjbl()+"%�������ۼ����Ͷ��"+itemList.get(j).getKgljwc()+"����Ԫ����ռ�ܼƻ�"+itemList.get(j).getKgwctzbl()+"%����λ�ʽ�"+itemList.get(j).getKgljdwhj()+"����Ԫ����ռ�ܼƻ�"+itemList.get(j).getKgdwzjbl()+"%��<br/>";
					tempData += "��������������Ⱥ��ѿ�չ����Ҫ������"+ itemList.get(j).getXxjd() +"<br/>";
					tempData += "����������Ͷ��ʱ�䡢���ݼ���������������"+ itemList.get(j).getScnl() +"<br/>";
					tempData += "��Ŀ�ƽ��д������⼰���ȡ�Ĵ�ʩ�Ͱ취��"+ itemList.get(j).getCzwt() +"<br/>";
					tempData += "��Ҫ�������йز���Э����������⣺"+ itemList.get(j).getXtjj() +"<br/>";
					tempData += "�¸��¹����ƻ������ţ�"+ itemList.get(j).getGzjh() +"<br/>";
					tempData += "�ν���λ�½��������"+ itemList.get(j).getJcqk() +"<br/>";
					tempData += "�ʽ�˵����"+ itemList.get(j).getZjsm() +"<br/><br/>";

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
			tableDataString += "<b>"+lb1list.get(i)+"("+lb1num+"��)��</b> ���Ͷ��"+templb1.getNczbywc()+"����Ԫ����ռ��ȼƻ�"+getForFour(templb1.getDnwctzbl())+"%����λ�ʽ�"+templb1.getDnljdwhj()+"����Ԫ����ռ��ȼƻ�"+getForFour(templb1.getDndwzjbl())+"%�������ۼ����Ͷ��"+templb1.getKgljwc()+"����Ԫ����ռ�ܼƻ�"+getForFour(templb1.getKgwctzbl())+"%����λ�ʽ�"+templb1.getKgljdwhj()+"����Ԫ����ռ�ܼƻ�"+getForFour(templb1.getKgdwzjbl())+"%��<br/><br/>";
			tableDataString += tempData;
			tempData = "";
			lb1num = 0;
		}
		
		int ybnum = 0;
		for(int i = 0 ; i <itemList.size() ; i++){
			if(itemList.get(i).getLb().equals("Ԥ��")){
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
		
		
		tableDataString += "<b>����Ԥ���ص���Ŀ("+ybnum+"��)��</b> ���Ͷ��"+yb.getNczbywc()+"����Ԫ����ռ��ȼƻ�"+getForFour(yb.getDnwctzbl())+"%����λ�ʽ�"+yb.getDnljdwhj()+"����Ԫ����ռ��ȼƻ�"+getForFour(yb.getDndwzjbl())+"%�������ۼ����Ͷ��"+yb.getKgljwc()+"����Ԫ����ռ�ܼƻ�"+getForFour(yb.getKgwctzbl())+"%����λ�ʽ�"+yb.getKgljdwhj()+"����Ԫ����ռ�ܼƻ�"+getForFour(yb.getKgdwzjbl())+"%��<br/><br/>";

		
		
		
		for(int i = 0; i<lb1list.size(); i++){

			//�������
			ProZdxmYb templb1 = new ProZdxmYb();
			//ѭ�������б�����Ӧ������
			for(int j = 0, k = 0; j<itemList.size(); j++){
				
				if( itemList.get(j).getLb1().equals(lb1list.get(i)) && itemList.get(j).getLb().equals("Ԥ��") ){
					k++;
					tempData += "<b>"+k+"."+itemList.get(j).getMc()+"��</b> ���Ͷ��"+itemList.get(j).getNczbywc()+"����Ԫ����ռ��ȼƻ�"+itemList.get(j).getDnwctzbl()+"%����λ�ʽ�"+itemList.get(j).getDnljdwhj()+"����Ԫ����ռ��ȼƻ�"+itemList.get(j).getDndwzjbl()+"%�������ۼ����Ͷ��"+itemList.get(j).getKgljwc()+"����Ԫ����ռ�ܼƻ�"+itemList.get(j).getKgwctzbl()+"%����λ�ʽ�"+itemList.get(j).getKgljdwhj()+"����Ԫ����ռ�ܼƻ�"+itemList.get(j).getKgdwzjbl()+"%��<br/>";
					tempData += "��������������Ⱥ��ѿ�չ����Ҫ������"+ itemList.get(j).getXxjd() +"<br/>";
					tempData += "����������Ͷ��ʱ�䡢���ݼ���������������"+ itemList.get(j).getScnl() +"<br/>";
					tempData += "��Ŀ�ƽ��д������⼰���ȡ�Ĵ�ʩ�Ͱ취��"+ itemList.get(j).getCzwt() +"<br/>";
					tempData += "��Ҫ�������йز���Э����������⣺"+ itemList.get(j).getXtjj() +"<br/>";
					tempData += "�¸��¹����ƻ������ţ�"+ itemList.get(j).getGzjh() +"<br/>";
					tempData += "�ν���λ�½��������"+ itemList.get(j).getJcqk() +"<br/>";
					tempData += "�ʽ�˵����"+ itemList.get(j).getZjsm() +"<br/><br/>";
					
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
			
			tableDataString += "<b>"+lb1list.get(i)+"("+lb1num+"��)��</b> ���Ͷ��"+templb1.getNczbywc()+"����Ԫ����ռ��ȼƻ�"+getForFour(templb1.getDnwctzbl())+"%����λ�ʽ�"+templb1.getDnljdwhj()+"����Ԫ����ռ��ȼƻ�"+getForFour(templb1.getDndwzjbl())+"%�������ۼ����Ͷ��"+templb1.getKgljwc()+"����Ԫ����ռ�ܼƻ�"+getForFour(templb1.getKgwctzbl())+"%����λ�ʽ�"+templb1.getKgljdwhj()+"����Ԫ����ռ�ܼƻ�"+getForFour(templb1.getKgdwzjbl())+"%��<br/><br/>";
			tableDataString += tempData;
			tempData = "";
			lb1num = 0;
		}
		
		request.setAttribute("tabledata", tableDataString);
		
		
		request.setAttribute("itemList", itemList);
		// ��ת����Ϣ����չʾ����
		request.getRequestDispatcher("tj_zyxxjd_page.jsp").forward(request, response);
		
	}
	/**
	 * ������Ȳ�ѯ
	 * @param request ����
	 * @param response ��Ӧ
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toXxjdhzpage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String nd =	request.getParameter("nd");  // ���
		String fromMonth = request.getParameter("fromMonth");  // ��ʼ�·�
		String toMonth = request.getParameter("toMonth");  // �����·�
		String lb1 = request.getParameter("lb1");// ��𣺴���
		String lb2 = request.getParameter("lb2");// ���С��
		String dq = request.getParameter("dq");// ��������
		
		// ��Ͷ��
		String ztz1 = request.getParameter("ztz1");// �жϷ���ȫ�������ڵ��ڡ����ڣ�
		String ztz1num = request.getParameter("ztz2");// ��ֵ1
		String ztz2 = request.getParameter("ztz3");// �жϷ���ȫ����С�ڣ�
		String ztz2num = request.getParameter("ztz4");// ��ֵ2
		// ���Ͷ��
		String wctz1 = request.getParameter("wctz1");// �жϷ���ȫ�������ڵ��ڡ����ڣ�
		String wctz1num = request.getParameter("wctz2");// ��ֵ1
		String wctz2 = request.getParameter("wctz3");// �жϷ���ȫ����С�ڣ�
		String wctz2num = request.getParameter("wctz4");// ��ֵ2
		// �ƻ�Ͷ��
		String jhtz1 = request.getParameter("jhtz1");// �жϷ���ȫ�������ڵ��ڡ����ڣ�
		String jhtz1num = request.getParameter("jhtz2");// ��ֵ1
		String jhtz2 = request.getParameter("jhtz3");// �жϷ���ȫ����С�ڣ�
		String jhtz2num = request.getParameter("jhtz4");// �жϷ���ȫ����С�ڣ�
		// �����ȼƻ�Ͷ��
		String wcjhtz1 = request.getParameter("wcjhtz1");// �жϷ���ȫ�������ڵ��ڡ����ڣ�
		String wcjhtz1num = request.getParameter("wcjhtz2");// ��ֵ1
		String wcjhtz2 = request.getParameter("wcjhtz3");// �жϷ���ȫ����С�ڣ�
		String wcjhtz2num = request.getParameter("wcjhtz4");// �жϷ���ȫ����С�ڣ�
		
		String sfscx = request.getParameter("sfscx"); // �Ƿ�������
		String sfzz = request.getParameter("sfzz"); // �Ƿ�����֮��
		String sfss = request.getParameter("sfss");  // �Ƿ�ʡ��Ŀ
		String sfzy = request.getParameter("sfzy"); // �Ƿ���Դ
		String sjslb = request.getParameter("sjslb");  // 10+3���
		String tzztxz = request.getParameter("tzztxz");  // ��ĿͶ������
		
		String kgFromNd = request.getParameter("kgFromNd");  // ��Ŀ������ݣ���ʼ��
		String kgToNd = request.getParameter("kgToNd");  // ��Ŀ������ݣ�������
		String kgFromMonth = request.getParameter("kgFromMonth");  // ��Ŀ�����·ݣ���ʼ��
		String kgToMonth = request.getParameter("kgToMonth");  // ��Ŀ�����·ݣ�������
		
		// ��ȡ�ص��±���Ŀ��Ϣ
		List<ProZdxmYb> itemList = ZdxmDao.showXxjdhzList(nd, fromMonth, toMonth, lb1, lb2, dq, ztz1, ztz1num, ztz2, ztz2num, wctz1, wctz1num, wctz2, wctz2num, jhtz1, jhtz1num, jhtz2, jhtz2num, wcjhtz1, wcjhtz1num, wcjhtz2, wcjhtz2num, sfscx, sfzz, sfss, sfzy, sjslb, tzztxz, kgFromNd, kgToNd, kgFromMonth, kgToMonth);
		
		
		request.setAttribute("nd", nd);
		request.setAttribute("fromMonth", fromMonth);
		request.setAttribute("toMonth", toMonth);
		
		
		//��������
		String tableDataString = "";
		//�ϼ�����
		ProZdxmYb hj = new ProZdxmYb();
		//�ڽ�����
		ProZdxmYb zj = new ProZdxmYb();
		//Ԥ������
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
		"<td align=\"left\" style=\"color:red;\" >�ϼ�("+itemList.size()+"��)</td>" +
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
			if(itemList.get(i).getLb().equals("�ڽ�")){
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
		"<td align=\"center\" >һ</td>" +
		"<td align=\"left\" >�ڽ��ص���Ŀ("+zjnum+"��)</td>" +
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
		
		//�õ��ּ��б�
		List<String> lb1list = ZdxmDao.getLb1List();
		
		String tempData = "";
		int lb1num = 0;
		
		for(int i = 0; i<lb1list.size(); i++){
			//�������
			ProZdxmYb templb1 = new ProZdxmYb();
			//ѭ�������б�����Ӧ������
			for(int j = 0, k = 0; j<itemList.size(); j++){
				
				if( itemList.get(j).getLb1().equals(lb1list.get(i)) && itemList.get(j).getLb().equals("�ڽ�") ){
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
			"<td align=\"left\" >"+lb1list.get(i)+"("+lb1num+"��)</td>" +
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
			if(itemList.get(i).getLb().equals("Ԥ��")){
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
		"<td align=\"center\" >��</td>" +
		"<td align=\"left\" >Ԥ���ص���Ŀ("+ybnum+"��)</td>" +
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
			//�������
			ProZdxmYb templb1 = new ProZdxmYb();
			//ѭ�������б�����Ӧ������
			for(int j = 0, k = 0; j<itemList.size(); j++){
				
				if( itemList.get(j).getLb1().equals(lb1list.get(i)) && itemList.get(j).getLb().equals("Ԥ��") ){
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
			"<td align=\"left\" >"+lb1list.get(i)+"("+lb1num+"��)</td>" +
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
		// ��ת����Ϣ����չʾ����
		request.getRequestDispatcher("tj_xxjd.jsp").forward(request, response);
		
	}
	
	
	

	

	/**
	 * ��Ϣ�ּ����� add by lhanliang
	 * @param request ����
	 * @param response ��Ӧ
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toFlhzPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // ���
		String fromMonth =	request.getParameter("fromMonth");  // ��ʼ�·�
		String toMonth = request.getParameter("toMonth");  // �����·�

        request.setAttribute("year", year);
        request.setAttribute("fromMonth", fromMonth);
        request.setAttribute("toMonth", toMonth);
        
		
		// ��ת����Ϣ����ͳ��ҳ�棬չʾ��Ϣ
		request.getRequestDispatcher("tj_fl.jsp").forward(request, response);
	}
	
	private void toCyflhzPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String year = request.getParameter("year");  // ���
		String fromMonth =	request.getParameter("fromMonth");  // ��ʼ�·�
		String toMonth = request.getParameter("toMonth");  // �����·�

        request.setAttribute("year", year);
        request.setAttribute("fromMonth", fromMonth);
        request.setAttribute("toMonth", toMonth);
        
		
		// ��ת����Ϣ����ͳ��ҳ�棬չʾ��Ϣ
		request.getRequestDispatcher("tj_fcy.jsp").forward(request, response);
		
	}
	
	private void toCymxhzPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String year = request.getParameter("year");  // ���
		String fromMonth =	request.getParameter("fromMonth");  // ��ʼ�·�
		String toMonth = request.getParameter("toMonth");  // �����·�

        request.setAttribute("year", year);
        request.setAttribute("fromMonth", fromMonth);
        request.setAttribute("toMonth", toMonth);
        
		
		// ��ת����Ϣ����ͳ��ҳ�棬չʾ��Ϣ
		request.getRequestDispatcher("tj_fcymx.jsp").forward(request, response);
		
		
	}
	
	/**
	 * ��Ϣ�ּ����� add by lhanliang
	 * @param request ����
	 * @param response ��Ӧ
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toXxfjhzpage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // ���
		String fromMonth =	request.getParameter("fromMonth");  // ��ʼ�·�
		String toMonth = request.getParameter("toMonth");  // �����·�

        request.setAttribute("year", year);
        request.setAttribute("fromMonth", fromMonth);
        request.setAttribute("toMonth", toMonth);
        
		
		// ��ת����Ϣ����ͳ��ҳ�棬չʾ��Ϣ
		request.getRequestDispatcher("tj_fj.jsp").forward(request, response);
	}
	
	
	/**
	 * ajax��ȡ��Ϣ�ּ��������� 
	 * @param request ����
	 * @param response ��Ӧ
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getXxfjhzInfo(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // ���
		String fromMonth =	request.getParameter("fromMonth");  // ��ʼ�·�
		String toMonth = request.getParameter("toMonth");  // �����·�
		
		String data = "";

		// ��ȡ����ͳ����Ϣ
		//�ϼ�
		List<FjFlInfo> infoListHj = ZdxmDao.getFjInfoList(year,fromMonth, toMonth,"�ϼ�");
		//�ڽ�
		List<FjFlInfo> infoListZj = ZdxmDao.getFjInfoList(year,fromMonth, toMonth,"�ڽ�");
		//Ԥ��
		List<FjFlInfo> infoListYb = ZdxmDao.getFjInfoList(year,fromMonth, toMonth,"Ԥ��");

		//�ϼ�
		FjFlInfo tempInfoHj = new FjFlInfo();
		FjFlInfo tempInfoZj = new FjFlInfo();
		FjFlInfo tempInfoYb = new FjFlInfo();
		FjFlInfo tempScxHj  = new FjFlInfo();
		FjFlInfo tempScxZj = new FjFlInfo();
		FjFlInfo tempScxYb = new FjFlInfo();
		
		
		//������Ԥ����Ŀ
		
		List<FjFlInfo> scxInfoList = ZdxmDao.getScxInfoList(year,fromMonth, toMonth);
		if (FavoritesHelper.isNotNull(scxInfoList)) {
			for (FjFlInfo fjFlInfo : scxInfoList) {
				if ("�ڽ�".equals(fjFlInfo.getLb())) {
					tempScxZj = fjFlInfo;
				}else if("Ԥ��".equals(fjFlInfo.getLb())){
					tempScxYb = fjFlInfo;
				}
			}
		}
		
		 //��������Ŀ�ϼ�
	    tempScxHj.setPnum(tempScxYb.getPnum() + tempScxZj.getPnum());
	    tempScxHj.setJhtz(tempScxYb.getJhtz() + tempScxZj.getJhtz());
	    tempScxHj.setNczbywc(tempScxYb.getNczbywc() + tempScxZj.getNczbywc());
	    tempScxHj.setWcbl(tempScxHj.getNczbywc()*100d/tempScxHj.getJhtz());
	    tempScxHj.setZtz(tempScxYb.getZtz() + tempScxZj.getZtz());
    	tempScxHj.setDnljdwhj(tempScxYb.getDnljdwhj() + tempScxZj.getDnljdwhj());
    	tempScxHj.setDwwcbl(tempScxHj.getDnljdwhj()*100d/tempScxHj.getJhtz());

    	
    	
		//�ڽ�
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
	    
	    
		//Ԥ��
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
	    
	    
	    
	    //�ϼ�
    	tempInfoHj.setPnum(tempInfoYb.getPnum() + tempInfoZj.getPnum());
    	tempInfoHj.setJhtz(tempInfoYb.getJhtz() + tempInfoZj.getJhtz());
    	tempInfoHj.setNczbywc(tempInfoYb.getNczbywc() + tempInfoZj.getNczbywc());
//    	tempInfoHj.setWcbl((tempInfoYb.getWcbl() + tempInfoZj.getWcbl())/2);
    	tempInfoHj.setWcbl(tempInfoHj.getNczbywc()*100d/tempInfoHj.getJhtz());
    	tempInfoHj.setZtz(tempInfoYb.getZtz() + tempInfoZj.getZtz());
	    tempInfoHj.setDnljdwhj(tempInfoYb.getDnljdwhj() + tempInfoZj.getDnljdwhj());
//	    tempInfoHj.setDwwcbl((tempInfoYb.getDwwcbl() + tempInfoZj.getDwwcbl())/2);
	    tempInfoHj.setDwwcbl(tempInfoHj.getDnljdwhj()*100d/tempInfoHj.getJhtz());
	    
	    
		data +="<tr height=\"30\"  style=\"font-weight:bold\"><td align=\"left\" name=\""+convert("�ϼ�")+"\"></td><td align=\"center\">"+tempInfoHj.getPnum()+"</td><td align=\"right\">"+tempInfoHj.getZtz()
		      +"</td><td align=\"right\">"+tempInfoHj.getJhtz()+"</td><td align=\"right\">"+tempInfoHj.getNczbywc()+"</td>"
		      +"<td align=\"right\">"+getForThree(tempInfoHj.getWcbl().toString())+"</td><td align=\"right\">"+tempInfoHj.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempInfoHj.getDwwcbl().toString())+"</td ></tr>";
		
		data +="<tr height=\"30\"  ><td align=\"center\" name=\""+convert("�ڽ�")+"\"></td><td align=\"center\">"+tempInfoZj.getPnum()+"</td><td align=\"right\">"+tempInfoZj.getZtz()
	          +"</td><td align=\"right\">"+tempInfoZj.getJhtz()+"</td><td align=\"right\">"+tempInfoZj.getNczbywc()+"</td>"
		      +"<td align=\"right\">"+getForThree(tempInfoZj.getWcbl().toString())+"</td><td align=\"right\">"+tempInfoZj.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempInfoZj.getDwwcbl().toString())+"</td ></tr>";
		
		data +="<tr height=\"30\"  ><td align=\"center\" name=\""+convert("Ԥ��")+"\"></td><td align=\"center\">"+tempInfoYb.getPnum()+"</td><td align=\"right\">"+tempInfoYb.getZtz()
	          +"</td><td align=\"right\">"+tempInfoYb.getJhtz()+"</td><td align=\"right\">"+tempInfoYb.getNczbywc()+"</td>"
		      +"<td align=\"right\">"+getForThree(tempInfoYb.getWcbl().toString())+"</td><td align=\"right\">"+tempInfoYb.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempInfoYb.getDwwcbl().toString())+"</td ></tr>";
		
		
		//�õ�����б�
		List<String> dqlist  =  ZdxmDao.getDqList();
		
		for(int i = 0; i<dqlist.size(); i++){
			//ѭ�������б�����Ӧ����������
			
			//����ϼ��б��ĳ���Ϊ0���
			if(infoListHj.size() ==0){
				
				data +="<tr height=\"30\"  style=\"font-weight:bold\" ><td align=\"left\" name=\""+convert(dqlist.get(i))+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
			      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
			}
			 
			//��־λ�Ƿ��Ѿ�ƥ����Ӧ�������
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
			
			//�ڽ�
			//���Zj�б��ĳ���Ϊ0���
			if(infoListZj.size() ==0){
				
				data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("�ڽ�")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
			      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
			}
			 
			//��־λ�Ƿ��Ѿ�ƥ����Ӧ�������
			int ZjFlag = 0;
			for(int j=0; j<infoListZj.size() && ZjFlag == 0 ;j++){
				
				if(j==(infoListZj.size()-1) && ZjFlag == 0  && !dqlist.get(i).equals(infoListZj.get(j).getDq())){
					
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("�ڽ�")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
				      +"<td align=\"right\">0</td ><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
				}
				
				if(dqlist.get(i).equals(infoListZj.get(j).getDq())){
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("�ڽ�")+"\"></td><td align=\"center\">"+infoListZj.get(j).getPnum()+"</td><td align=\"right\">"+infoListZj.get(j).getZtz()
				      +"</td><td align=\"right\">"+infoListZj.get(j).getJhtz()+"</td><td align=\"right\">"+infoListZj.get(j).getNczbywc()+"</td>"
				      +"<td align=\"right\">"+getForThree(infoListZj.get(j).getWcbl().toString())+"</td><td align=\"right\">"+infoListZj.get(j).getDnljdwhj()+"</td><td align=\"right\">"+getForThree(infoListZj.get(j).getDwwcbl().toString())+"</td ></tr>";
					ZjFlag = 1;
				}
				
				
			}
			
			//Ԥ��
			//���Yb�б��ĳ���Ϊ0���
			if(infoListYb.size() ==0){
				
				data +="<tr height=\"30\"><td  align=\"center\" name=\""+convert("Ԥ��")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
			      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
			}
			//��־λ�Ƿ��Ѿ�ƥ����Ӧ�������
			int YbFlag = 0;
			for(int j=0; j<infoListYb.size()&& YbFlag == 0 ;j++){
				
				if(j==(infoListYb.size()-1) && YbFlag == 0 && !dqlist.get(i).equals(infoListYb.get(j).getDq())){
					
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("Ԥ��")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
				      +"<td align=\"right\">0</td><td align=\"right\"></td><td align=\"right\"></td></tr>";
				}
				
				if(dqlist.get(i).equals(infoListYb.get(j).getDq())){
					data +="<tr height=\"30\"><td  align=\"center\" name=\""+convert("Ԥ��")+"\"></td><td align=\"center\">"+infoListYb.get(j).getPnum()+"</td><td align=\"right\">"+infoListYb.get(j).getZtz()
				      +"</td><td align=\"right\">"+infoListYb.get(j).getJhtz()+"</td><td align=\"right\">"+infoListYb.get(j).getNczbywc()+"</td>"
				      +"<td align=\"right\">"+getForThree(infoListYb.get(j).getWcbl().toString())+"</td><td align=\"right\">"+infoListYb.get(j).getDnljdwhj()+"</td><td align=\"right\">"+getForThree(infoListYb.get(j).getDwwcbl().toString())+"</td ></tr>";
					YbFlag = 1;
				}
				
				
			}
		}


    	
		data +="<tr height=\"30\"  style=\"font-weight:bold\"><td align=\"left\" name=\""+convert("��������Ŀ")+"\"></td><td align=\"center\">"+tempScxHj.getPnum()+"</td><td align=\"right\">"+tempScxHj.getZtz()
	         +"</td><td align=\"right\">"+tempScxHj.getJhtz()+"</td><td align=\"right\">"+tempScxHj.getNczbywc()+"</td>"
	         +"<td align=\"right\">"+getForThree(tempScxHj.getWcbl().toString())+"</td><td align=\"right\">"+tempScxHj.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempScxHj.getDwwcbl().toString())+"</td ></tr>";
	
	    data +="<tr height=\"30\"  ><td align=\"center\" name=\""+convert("�ڽ�")+"\"></td><td align=\"center\">"+tempScxZj.getPnum()+"</td><td align=\"right\">"+tempScxZj.getZtz()
             +"</td><td align=\"right\">"+tempScxZj.getJhtz()+"</td><td align=\"right\">"+tempScxZj.getNczbywc()+"</td>"
	         +"<td align=\"right\">"+getForThree(tempScxZj.getWcbl().toString())+"</td><td align=\"right\">"+tempScxZj.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempScxZj.getDwwcbl().toString())+"</td ></tr>";
	
	    data +="<tr height=\"30\"  ><td align=\"center\" name=\""+convert("Ԥ��")+"\"></td><td align=\"center\">"+tempScxYb.getPnum()+"</td><td align=\"right\">"+tempScxYb.getZtz()
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
	 * ��Ϣ�������
	 * @param request ����
	 * @param response ��Ӧ
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getXxflhzInfo(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // ���
		String fromMonth =	request.getParameter("fromMonth");  // ��ʼ�·�
		String toMonth = request.getParameter("toMonth");  // �����·�
		
		String data = "";

		// ��ȡ����ͳ����Ϣ
		//�ϼ�
		List<FjFlInfo> infoListHj = ZdxmDao.getFlInfoList(year,fromMonth, toMonth,"�ϼ�");
		//�ڽ�
		List<FjFlInfo> infoListZj = ZdxmDao.getFlInfoList(year,fromMonth, toMonth,"�ڽ�");
		//Ԥ��
		List<FjFlInfo> infoListYb = ZdxmDao.getFlInfoList(year,fromMonth, toMonth,"Ԥ��");

		//�ϼ�
		FjFlInfo tempInfoHj = new FjFlInfo();
		FjFlInfo tempInfoZj = new FjFlInfo();
		FjFlInfo tempInfoYb = new FjFlInfo();
		FjFlInfo tempScxHj  = new FjFlInfo();
		FjFlInfo tempScxZj  = new FjFlInfo();
		FjFlInfo tempScxYb  = new FjFlInfo();
		
		
		//������Ԥ����Ŀ
		int scxYbNum = 0;
	    for(FjFlInfo f:infoListYb){
	    	System.out.println(f);
	    	if("��".equals(f.getSfscx())){
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
		
		    
		
		//�������ڽ���Ŀ
		int scxZjNum = 0;
	    for(FjFlInfo f:infoListZj){
	    	if("��".equals(f.getSfscx())){
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
		
	    //��������Ŀ�ϼ�
	    tempScxHj.setPnum(tempScxYb.getPnum() + tempScxZj.getPnum());
	    tempScxHj.setJhtz(tempScxYb.getJhtz() + tempScxZj.getJhtz());
	    tempScxHj.setNczbywc(tempScxYb.getNczbywc() + tempScxZj.getNczbywc());
//    	tempScxHj.setWcbl((tempScxYb.getWcbl() + tempScxZj.getWcbl())/2);
	    tempScxHj.setWcbl(tempScxHj.getNczbywc()*100d/tempScxHj.getJhtz());
	    tempScxHj.setZtz(tempScxYb.getZtz() + tempScxZj.getZtz());
    	tempScxHj.setDnljdwhj(tempScxYb.getDnljdwhj() + tempScxZj.getDnljdwhj());
//	    tempScxHj.setDwwcbl((tempScxYb.getDwwcbl() + tempScxZj.getDwwcbl())/2);
    	tempScxHj.setDwwcbl(tempScxHj.getDnljdwhj()*100d/tempScxHj.getJhtz());

		
		
		//�ڽ�
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
	    
	    
		//Ԥ��
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
	    
	    
	    
	    //�ϼ�
    	tempInfoHj.setPnum(tempInfoYb.getPnum() + tempInfoZj.getPnum());
    	tempInfoHj.setJhtz(tempInfoYb.getJhtz() + tempInfoZj.getJhtz());
    	tempInfoHj.setNczbywc(tempInfoYb.getNczbywc() + tempInfoZj.getNczbywc());
//    	tempInfoHj.setWcbl((tempInfoYb.getWcbl() + tempInfoZj.getWcbl())/2);
    	tempInfoHj.setWcbl(tempInfoHj.getNczbywc()*100d/tempInfoHj.getJhtz());
    	tempInfoHj.setZtz(tempInfoYb.getZtz() + tempInfoZj.getZtz());
	    tempInfoHj.setDnljdwhj(tempInfoYb.getDnljdwhj() + tempInfoZj.getDnljdwhj());
//	    tempInfoHj.setDwwcbl((tempInfoYb.getDwwcbl() + tempInfoZj.getDwwcbl())/2);
	    tempInfoHj.setDwwcbl(tempInfoHj.getDnljdwhj()*100d/tempInfoHj.getJhtz());
	    
		data +="<tr height=\"30\"  style=\"font-weight:bold\"><td align=\"left\" name=\""+convert("�ϼ�")+"\"></td><td align=\"center\">"+tempInfoHj.getPnum()+"</td><td align=\"right\">"+tempInfoHj.getZtz()
		      +"</td><td align=\"right\">"+tempInfoHj.getJhtz()+"</td><td align=\"right\">"+tempInfoHj.getNczbywc()+"</td>"
		      +"<td align=\"right\">"+getForThree(tempInfoHj.getWcbl().toString())+"</td><td align=\"right\">"+tempInfoHj.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempInfoHj.getDwwcbl().toString())+"</td ></tr>";
		
		data +="<tr height=\"30\"  ><td align=\"center\" name=\""+convert("�ڽ�")+"\"></td><td align=\"center\">"+tempInfoZj.getPnum()+"</td><td align=\"right\">"+tempInfoZj.getZtz()
	          +"</td><td align=\"right\">"+tempInfoZj.getJhtz()+"</td><td align=\"right\">"+tempInfoZj.getNczbywc()+"</td>"
		      +"<td align=\"right\">"+getForThree(tempInfoZj.getWcbl().toString())+"</td><td align=\"right\">"+tempInfoZj.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempInfoZj.getDwwcbl().toString())+"</td ></tr>";
		
		data +="<tr height=\"30\"  ><td align=\"center\" name=\""+convert("Ԥ��")+"\"></td><td align=\"center\">"+tempInfoYb.getPnum()+"</td><td align=\"right\">"+tempInfoYb.getZtz()
	          +"</td><td align=\"right\">"+tempInfoYb.getJhtz()+"</td><td align=\"right\">"+tempInfoYb.getNczbywc()+"</td>"
		      +"<td align=\"right\">"+getForThree(tempInfoYb.getWcbl().toString())+"</td><td align=\"right\">"+tempInfoYb.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempInfoYb.getDwwcbl().toString())+"</td ></tr>";
		
		
		//�õ��ּ��б�
		List<String> lb1list  =  ZdxmDao.getLb1List();
		
		for(int i = 0; i<lb1list.size(); i++){
			//ѭ�������б�����Ӧ����������
			
			//����ϼ��б��ĳ���Ϊ0���
			if(infoListHj.size() ==0){
				
				data +="<tr height=\"30\"  style=\"font-weight:bold\" ><td align=\"left\" name=\""+convert(lb1list.get(i))+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
			      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
			}
			 
			//��־λ�Ƿ��Ѿ�ƥ����Ӧ�������
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
			
			//�ڽ�
			//���Zj�б��ĳ���Ϊ0���
			if(infoListZj.size() ==0){
				
				data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("�ڽ�")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
			      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
			}
			 
			//��־λ�Ƿ��Ѿ�ƥ����Ӧ�������
			int ZjFlag = 0;
			for(int j=0; j<infoListZj.size() && ZjFlag == 0 ;j++){
				
				if(j==(infoListZj.size()-1) && ZjFlag == 0  && !lb1list.get(i).equals(infoListZj.get(j).getDq())){
					
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("�ڽ�")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
				      +"<td align=\"right\">0</td ><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
				}
				
				if(lb1list.get(i).equals(infoListZj.get(j).getDq())){
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("�ڽ�")+"\"></td><td align=\"center\">"+infoListZj.get(j).getPnum()+"</td><td align=\"right\">"+infoListZj.get(j).getZtz()
				      +"</td><td align=\"right\">"+infoListZj.get(j).getJhtz()+"</td><td align=\"right\">"+infoListZj.get(j).getNczbywc()+"</td>"
				      +"<td align=\"right\">"+getForThree(infoListZj.get(j).getWcbl().toString())+"</td><td align=\"right\">"+infoListZj.get(j).getDnljdwhj()+"</td><td align=\"right\">"+getForThree(infoListZj.get(j).getDwwcbl().toString())+"</td ></tr>";
					ZjFlag = 1;
				}
				
				
			}
			
			//Ԥ��
			//���Yb�б��ĳ���Ϊ0���
			if(infoListYb.size() ==0){
				
				data +="<tr height=\"30\"><td  align=\"center\" name=\""+convert("Ԥ��")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
			      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
			}
			//��־λ�Ƿ��Ѿ�ƥ����Ӧ�������
			int YbFlag = 0;
			for(int j=0; j<infoListYb.size()&& YbFlag == 0 ;j++){
				
				if(j==(infoListYb.size()-1) && YbFlag == 0 && !lb1list.get(i).equals(infoListYb.get(j).getDq())){
					
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("Ԥ��")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
				      +"<td align=\"right\">0</td><td align=\"right\"></td><td align=\"right\"></td></tr>";
				}
				
				if(lb1list.get(i).equals(infoListYb.get(j).getDq())){
					data +="<tr height=\"30\"><td  align=\"center\" name=\""+convert("Ԥ��")+"\"></td><td align=\"center\">"+infoListYb.get(j).getPnum()+"</td><td align=\"right\">"+infoListYb.get(j).getZtz()
				      +"</td><td align=\"right\">"+infoListYb.get(j).getJhtz()+"</td><td align=\"right\">"+infoListYb.get(j).getNczbywc()+"</td>"
				      +"<td align=\"right\">"+getForThree(infoListYb.get(j).getWcbl().toString())+"</td><td align=\"right\">"+infoListYb.get(j).getDnljdwhj()+"</td><td align=\"right\">"+getForThree(infoListYb.get(j).getDwwcbl().toString())+"</td ></tr>";
					YbFlag = 1;
				}
				
				
			}
			
			
		}
		
		data +="<tr height=\"30\"  style=\"font-weight:bold\"><td align=\"left\" name=\""+convert("��������Ŀ")+"\"></td><td align=\"center\">"+tempScxHj.getPnum()+"</td><td align=\"right\">"+tempScxHj.getZtz()
             +"</td><td align=\"right\">"+tempScxHj.getJhtz()+"</td><td align=\"right\">"+tempScxHj.getNczbywc()+"</td>"
             +"<td align=\"right\">"+getForThree(tempScxHj.getWcbl().toString())+"</td><td align=\"right\">"+tempScxHj.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempScxHj.getDwwcbl().toString())+"</td ></tr>";

	    data +="<tr height=\"30\"  ><td align=\"center\" name=\""+convert("�ڽ�")+"\"></td><td align=\"center\">"+tempScxZj.getPnum()+"</td><td align=\"right\">"+tempScxZj.getZtz()
	         +"</td><td align=\"right\">"+tempScxZj.getJhtz()+"</td><td align=\"right\">"+tempScxZj.getNczbywc()+"</td>"
	         +"<td align=\"right\">"+getForThree(tempScxZj.getWcbl().toString())+"</td><td align=\"right\">"+tempScxZj.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempScxZj.getDwwcbl().toString())+"</td ></tr>";
	
	    data +="<tr height=\"30\"  ><td align=\"center\" name=\""+convert("Ԥ��")+"\"></td><td align=\"center\">"+tempScxYb.getPnum()+"</td><td align=\"right\">"+tempScxYb.getZtz()
	         +"</td><td align=\"right\">"+tempScxYb.getJhtz()+"</td><td align=\"right\">"+tempScxYb.getNczbywc()+"</td>"
	         +"<td align=\"right\">"+getForThree(tempScxYb.getWcbl().toString())+"</td><td align=\"right\">"+tempScxYb.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempScxYb.getDwwcbl().toString())+"</td ></tr>";
	         
	    data = data.replace("NaN", "0");
	    
        PrintWriter out = response.getWriter();
        response.setContentType("application/json; charset=utf-8");  
		out.write(data);
		out.close();
		
	}
	/**
	 * �ֲ�ҵ����
	 * @throws IOException 
	 */
	private void getFcyhzInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String year = request.getParameter("year");  // ���
		String fromMonth =	request.getParameter("fromMonth");  // ��ʼ�·�
		String toMonth = request.getParameter("toMonth");  // �����·�
		
		String data = "";

		// ��ȡ����ͳ����Ϣ
		//�ϼ�
		List<FjFlInfo> infoListHj = ZdxmDao.getCyInfoList(year,fromMonth, toMonth,"�ϼ�");
		//�ڽ�
		List<FjFlInfo> infoListZj = ZdxmDao.getCyInfoList(year,fromMonth, toMonth,"�ڽ�");
		//Ԥ��
		List<FjFlInfo> infoListYb = ZdxmDao.getCyInfoList(year,fromMonth, toMonth,"Ԥ��");

		//�ϼ�
		FjFlInfo tempInfoHj = new FjFlInfo();
		FjFlInfo tempInfoZj = new FjFlInfo();
		FjFlInfo tempInfoYb = new FjFlInfo();
		
		//�ڽ�
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
	    
	    
		//Ԥ��
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
	    
	    
	    
	    //�ϼ�
    	tempInfoHj.setPnum(tempInfoYb.getPnum() + tempInfoZj.getPnum());
    	tempInfoHj.setJhtz(tempInfoYb.getJhtz() + tempInfoZj.getJhtz());
    	tempInfoHj.setNczbywc(tempInfoYb.getNczbywc() + tempInfoZj.getNczbywc());
//    	tempInfoHj.setWcbl((tempInfoYb.getWcbl() + tempInfoZj.getWcbl())/2);
    	tempInfoHj.setWcbl(tempInfoHj.getNczbywc()*100d/tempInfoHj.getJhtz());
    	tempInfoHj.setZtz(tempInfoYb.getZtz() + tempInfoZj.getZtz());
	    tempInfoHj.setDnljdwhj(tempInfoYb.getDnljdwhj() + tempInfoZj.getDnljdwhj());
//	    tempInfoHj.setDwwcbl((tempInfoYb.getDwwcbl() + tempInfoZj.getDwwcbl())/2);
	    tempInfoHj.setDwwcbl(tempInfoHj.getDnljdwhj()*100d/tempInfoHj.getJhtz());
	    
		data +="<tr height=\"30\"  style=\"font-weight:bold\"><td align=\"left\" name=\""+convert("�ϼ�")+"\"></td><td align=\"center\">"+tempInfoHj.getPnum()+"</td><td align=\"right\">"+tempInfoHj.getZtz()
		      +"</td><td align=\"right\">"+tempInfoHj.getJhtz()+"</td><td align=\"right\">"+tempInfoHj.getNczbywc()+"</td>"
		      +"<td align=\"right\">"+getForThree(tempInfoHj.getWcbl().toString())+"</td><td align=\"right\">"+tempInfoHj.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempInfoHj.getDwwcbl().toString())+"</td ></tr>";
		
		data +="<tr height=\"30\"  ><td align=\"center\" name=\""+convert("�ڽ�")+"\"></td><td align=\"center\">"+tempInfoZj.getPnum()+"</td><td align=\"right\">"+tempInfoZj.getZtz()
	          +"</td><td align=\"right\">"+tempInfoZj.getJhtz()+"</td><td align=\"right\">"+tempInfoZj.getNczbywc()+"</td>"
		      +"<td align=\"right\">"+getForThree(tempInfoZj.getWcbl().toString())+"</td><td align=\"right\">"+tempInfoZj.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempInfoZj.getDwwcbl().toString())+"</td ></tr>";
		
		data +="<tr height=\"30\"  ><td align=\"center\" name=\""+convert("Ԥ��")+"\"></td><td align=\"center\">"+tempInfoYb.getPnum()+"</td><td align=\"right\">"+tempInfoYb.getZtz()
	          +"</td><td align=\"right\">"+tempInfoYb.getJhtz()+"</td><td align=\"right\">"+tempInfoYb.getNczbywc()+"</td>"
		      +"<td align=\"right\">"+getForThree(tempInfoYb.getWcbl().toString())+"</td><td align=\"right\">"+tempInfoYb.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempInfoYb.getDwwcbl().toString())+"</td ></tr>";
		
		
		//�õ��ּ��б�
		List<String> lb1list  =  ZdxmDao.getCyList();
	
		for(int i = 0; i<lb1list.size(); i++){
			//ѭ�������б�����Ӧ����������
			
			//����ϼ��б��ĳ���Ϊ0���
			if(infoListHj.size() ==0){
				data +="<tr height=\"30\"  style=\"font-weight:bold\" ><td align=\"left\" name=\""+convert(lb1list.get(i))+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
			      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
			}
			 
			//��־λ�Ƿ��Ѿ�ƥ����Ӧ�������
			int HjFlag = 0;
			for(int j=0; j<infoListHj.size() && HjFlag == 0 ;j++){
				if(j==(infoListHj.size()-1) && HjFlag == 0 && !lb1list.get(i).equals(infoListHj.get(j).getDq().trim())){	
					data +="<tr height=\"30\" style=\"font-weight:bold\" ><td align=\"left\" name=\""+convert(lb1list.get(i))+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
				      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
				}
				System.out.println(infoListHj.size());
				System.out.println("1:"+lb1list.get(i));
				System.out.println("2:"+infoListHj.get(j).getDq());
				System.out.println("�Ƿ����"+lb1list.get(i).equals(infoListHj.get(j).getDq()));
				if(lb1list.get(i).equals(infoListHj.get(j).getDq().trim())){
					
					data +="<tr height=\"30\" style=\"font-weight:bold\" ><td align=\"left\" name=\""+convert(lb1list.get(i))+"\"></td><td align=\"center\">"+infoListHj.get(j).getPnum()+"</td><td align=\"right\">"+infoListHj.get(j).getZtz()
				      +"</td><td align=\"right\">"+infoListHj.get(j).getJhtz()+"</td><td align=\"right\">"+infoListHj.get(j).getNczbywc()+"</td>"
				      +"<td align=\"right\">"+getForThree(infoListHj.get(j).getWcbl().toString())+"</td><td align=\"right\">"+infoListHj.get(j).getDnljdwhj()+"</td><td align=\"right\">"+getForThree(infoListHj.get(j).getDwwcbl().toString())+"</td ></tr>";
					break;
					
				}
				
				
			}
			
			//�ڽ�
			//���Zj�б��ĳ���Ϊ0���
			if(infoListZj.size() ==0){
				
				data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("�ڽ�")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
			      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
			}
			 
			//��־λ�Ƿ��Ѿ�ƥ����Ӧ�������
			int ZjFlag = 0;
			for(int j=0; j<infoListZj.size() && ZjFlag == 0 ;j++){
				
				if(j==(infoListZj.size()-1) && ZjFlag == 0  && !lb1list.get(i).equals(infoListZj.get(j).getDq().trim())){
					
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("�ڽ�")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
				      +"<td align=\"right\">0</td ><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
				}
				
				if(lb1list.get(i).equals(infoListZj.get(j).getDq().trim())){
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("�ڽ�")+"\"></td><td align=\"center\">"+infoListZj.get(j).getPnum()+"</td><td align=\"right\">"+infoListZj.get(j).getZtz()
				      +"</td><td align=\"right\">"+infoListZj.get(j).getJhtz()+"</td><td align=\"right\">"+infoListZj.get(j).getNczbywc()+"</td>"
				      +"<td align=\"right\">"+getForThree(infoListZj.get(j).getWcbl().toString())+"</td><td align=\"right\">"+infoListZj.get(j).getDnljdwhj()+"</td><td align=\"right\">"+getForThree(infoListZj.get(j).getDwwcbl().toString())+"</td ></tr>";
					ZjFlag = 1;
				}
				
				
			}
			
			//Ԥ��
			//���Yb�б��ĳ���Ϊ0���
			if(infoListYb.size() ==0){
				
				data +="<tr height=\"30\"><td  align=\"center\" name=\""+convert("Ԥ��")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
			      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
			}
			//��־λ�Ƿ��Ѿ�ƥ����Ӧ�������
			int YbFlag = 0;
			for(int j=0; j<infoListYb.size()&& YbFlag == 0 ;j++){
				
				if(j==(infoListYb.size()-1) && YbFlag == 0 && !lb1list.get(i).equals(infoListYb.get(j).getDq().trim())){
					
					data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("Ԥ��")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
				      +"<td align=\"right\">0</td><td align=\"right\"></td><td align=\"right\"></td></tr>";
				}
				
				if(lb1list.get(i).equals(infoListYb.get(j).getDq().trim())){
					data +="<tr height=\"30\"><td  align=\"center\" name=\""+convert("Ԥ��")+"\"></td><td align=\"center\">"+infoListYb.get(j).getPnum()+"</td><td align=\"right\">"+infoListYb.get(j).getZtz()
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
	 * �ֲ�ҵ��ϸ����
	 * @throws IOException 
	 * 
	 */
	
	private void getFcymxhzInfo (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		
		
		
		String year = request.getParameter("year");  // ���
		String fromMonth =	request.getParameter("fromMonth");  // ��ʼ�·�
		String toMonth = request.getParameter("toMonth");  // �����·�
		String data = "";

		// ��ȡ����ͳ����Ϣ
		//�ϼ�
		List<FjFlInfo> infoListHj = ZdxmDao.getCymxInfoList(year,fromMonth, toMonth,"�ϼ�");
        //��ȡ��ҵ��ϸ
		List<FjFlInfo>infoListDt =ZdxmDao.getCymxInfoList(year,fromMonth, toMonth,"");

		//�ϼ�
		FjFlInfo tempInfoHj = new FjFlInfo();

		//��ϸ����ϼ�
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
	    
	    
		data +="<tr height=\"30\"  style=\"font-weight:bold\"><td align=\"left\" name=\""+convert("�ϼ�")+"\"></td><td align=\"center\">"+tempInfoHj.getPnum()+"</td><td align=\"right\">"+tempInfoHj.getZtz()
		      +"</td><td align=\"right\">"+tempInfoHj.getJhtz()+"</td><td align=\"right\">"+tempInfoHj.getNczbywc()+"</td>"
		      +"<td align=\"right\">"+getForThree(tempInfoHj.getWcbl().toString())+"</td><td align=\"right\">"+tempInfoHj.getDnljdwhj()+"</td><td align=\"right\">"+getForThree(tempInfoHj.getDwwcbl().toString())+"</td ></tr>";

		
		//�õ���ҵ�б�
		List<String> lb1list  =  ZdxmDao.getCyList();
		System.out.println(lb1list.size()+"����");
		System.out.println("�ϼƳ���"+infoListHj.size());
		for(int i = 0; i<lb1list.size(); i++){
			//ѭ�������б�����Ӧ����������
			
			//����ϼ��б��ĳ���Ϊ0���
			if(infoListHj.size() ==0){
				
				data +="<tr height=\"30\"  style=\"font-weight:bold\" ><td align=\"left\" name=\""+convert(lb1list.get(i))+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
			      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
			}
			 
			//��־λ�Ƿ��Ѿ�ƥ����Ӧ�������
			int HjFlag = 0;
			for(int j=0; j<infoListHj.size() && HjFlag == 0 ;j++){
				
				if(j==(infoListHj.size()-1) && HjFlag == 0 && !lb1list.get(i).equals(infoListHj.get(j).getDq().trim())){
					
					data +="<tr height=\"30\" style=\"font-weight:bold\" ><td align=\"left\" name=\""+convert(lb1list.get(i))+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
				      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
				}
				if(lb1list.get(i).equals(infoListHj.get(j).getDq().trim())){
					System.out.println(lb1list.get(i));
					System.out.println("�ƻ�Ͷ��"+infoListHj.get(j).getJhtz());
					System.out.println("������������"+infoListHj.get(j).getNczbywc());
					System.out.println("��ɱ���"+infoListHj.get(j).getWcbl().toString());
					System.out.println("���굽λ�ʽ�"+infoListHj.get(j).getDnljdwhj());
					data +="<tr height=\"30\" style=\"font-weight:bold\" ><td align=\"left\" name=\""+convert(lb1list.get(i))+"\"></td><td align=\"center\">"+infoListHj.get(j).getPnum()+"</td><td align=\"right\">"+infoListHj.get(j).getZtz()
				      +"</td><td align=\"right\">"+infoListHj.get(j).getJhtz()+"</td><td align=\"right\">"+infoListHj.get(j).getNczbywc()+"</td>"
				      +"<td align=\"right\">"+getForThree(infoListHj.get(j).getWcbl().toString())+"</td><td align=\"right\">"+infoListHj.get(j).getDnljdwhj()+"</td><td align=\"right\">"+getForThree(infoListHj.get(j).getDwwcbl().toString())+"</td ></tr>";
					HjFlag = 1;
					
				}
				
				
			}
			
			//��ϸ
			//�����ϸ�б��ĳ���Ϊ0���
			if(infoListDt.size() ==0){
				
				data +="<tr height=\"30\" ><td align=\"center\" name=\""+convert("��")+"\"></td><td align=\"center\">0</td><td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td>"
			      +"<td align=\"right\">0</td><td align=\"right\">0</td><td align=\"right\">0</td></tr>";
			}
			 
			//��־λ�Ƿ��Ѿ�ƥ����Ӧ�������
			
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
	 * �ص���Ŀ��Ϣ����
	 * @param request  ����
	 * @param response ��Ӧ
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toXxhzPage(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
	    String nd =	request.getParameter("nd");  // ���
	    String lb1 = request.getParameter("lb1");// ��𣺴���
	    String lb2 = request.getParameter("lb2");// ���С��
	    String dq = request.getParameter("dq");// ��������
	    
	    // ��Ͷ��
	    String ztz1 = request.getParameter("ztz1");// �жϷ���ȫ�������ڵ��ڡ����ڣ�
	    String ztz1num = request.getParameter("ztz2");// ��ֵ1
	    String ztz2 = request.getParameter("ztz3");// �жϷ���ȫ����С�ڣ�
	    String ztz2num = request.getParameter("ztz4");// ��ֵ2
	    // ���Ͷ��
	    String wctz1 = request.getParameter("wctz1");// �жϷ���ȫ�������ڵ��ڡ����ڣ�
	    String wctz1num = request.getParameter("wctz2");// ��ֵ1
	    String wctz2 = request.getParameter("wctz3");// �жϷ���ȫ����С�ڣ�
	    String wctz2num = request.getParameter("wctz4");// ��ֵ2
	    // �ƻ�Ͷ��
	    String jhtz1 = request.getParameter("jhtz1");// �жϷ���ȫ�������ڵ��ڡ����ڣ�
	    String jhtz1num = request.getParameter("jhtz2");// ��ֵ1
	    String jhtz2 = request.getParameter("jhtz3");// �жϷ���ȫ����С�ڣ�
	    String jhtz2num = request.getParameter("jhtz4");// �жϷ���ȫ����С�ڣ�
	    
	    String sfscx = request.getParameter("sfscx"); // �Ƿ�������
	    String sfzz = request.getParameter("sfzz"); // �Ƿ�����֮��
	    String sfss = request.getParameter("sfss");  // �Ƿ�ʡ��Ŀ
	    String sfzy = request.getParameter("sfzy"); // �Ƿ���Դ
	    String sjslb = request.getParameter("sjslb");  // 10+3���
	    String tzztxz = request.getParameter("tzztxz");  // ��ĿͶ������
	    
		String kgFromNd = request.getParameter("kgFromNd");  // ��Ŀ������ݣ���ʼ��
		String kgToNd = request.getParameter("kgToNd");  // ��Ŀ������ݣ�������
		String kgFromMonth = request.getParameter("kgFromMonth");  // ��Ŀ�����·ݣ���ʼ��
		String kgToMonth = request.getParameter("kgToMonth");  // ��Ŀ�����·ݣ�������
		
		
		request.setAttribute("nd", nd);
		request.setAttribute("lb1", lb1);
		request.setAttribute("lb2", lb2);
		request.setAttribute("dq", dq);
		
		String sfscxStr = "��".equals(sfscx)?"������":("��".equals(sfscx)?"��������":"");
		String sfzzStr = "��".equals(sfzz)?"����֮��":("��".equals(sfzz)?"������֮��":"");
		String sfssStr = "��".equals(sfss)?"ʡ���ص�":("��".equals(sfss)?"��ʡ���ص�":"");
		String sfzyStr = "��".equals(sfzy)?"��Դ��":("��".equals(sfzy)?"����Դ��":"");
		
		String condition = "";
		String[] conditionArry = {sfscxStr,sfzzStr,sfssStr,sfzyStr,sjslb,tzztxz};
		if (FavoritesHelper.isNotNull(conditionArry)) {
			for (int i = 0; i < conditionArry.length; i++) {
				if (FavoritesHelper.isNotNull(conditionArry[i])) {
					condition += "��" + conditionArry[i];
				}
			}
		}
		if (FavoritesHelper.isNotNull(condition)) {
			condition = "(" + condition.substring(1) + ")";
		}
		request.setAttribute("condition", condition);
	    // ��ȡ�ص���Ŀ��Ϣ
		List<ProZdxm> itemList = ZdxmDao.showXxhzList(nd, lb1, lb2, dq, ztz1,
				ztz1num, ztz2, ztz2num, wctz1, wctz1num, wctz2, wctz2num,
				jhtz1, jhtz1num, jhtz2, jhtz2num, sfscx, sfzz, sfss, sfzy,
				sjslb, tzztxz, kgFromNd, kgToNd, kgFromMonth, kgToMonth);
		
		//��������
		String tableDataString = "";
		//�ϼ�����
		ProZdxm hj = new ProZdxm();
		//�ڽ�����
		ProZdxm zj = new ProZdxm();
		//Ԥ������
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
			               "<td align=\"center\" style=\"color:red;\" >ȫ�кϼ�("+itemList.size()+"��)</td>" +
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
			if(itemList.get(i).getLb().equals("�ڽ�")){
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
				           "<td align=\"center\" >һ</td>" +
			               "<td align=\"center\" >�ڽ��ص���Ŀ("+zjnum+"��)</td>" +
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
		
		//�õ��ּ��б�
		List<String> lb1list = ZdxmDao.getLb1List();
		
		String tempData = "";
		int lb1num = 0;
		
		
		for(int i = 0; i<lb1list.size(); i++){
			//�������
			ProZdxm templb1 = new ProZdxm();
			//ѭ�������б�����Ӧ������
			for(int j = 0, k = 0; j<itemList.size(); j++){
			
			   if( itemList.get(j).getLb1().equals(lb1list.get(i)) && itemList.get(j).getLb().equals("�ڽ�") ){
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
	               "<td align=\"center\" >"+lb1list.get(i)+"("+lb1num+"��)</td>" +
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
			if(itemList.get(i).getLb().equals("Ԥ��")){
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
				           "<td align=\"center\" >��</td>" +
			               "<td align=\"center\" >Ԥ���ص���Ŀ("+ybnum+"��)</td>" +
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
			//�������
			ProZdxm templb1 = new ProZdxm();
			//ѭ�������б�����Ӧ������
			for(int j = 0, k = 0; j<itemList.size(); j++){
			
			   if( itemList.get(j).getLb1().equals(lb1list.get(i)) && itemList.get(j).getLb().equals("Ԥ��") ){
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
               "<td align=\"center\" >"+lb1list.get(i)+"("+lb1num+"��)</td>" +
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
		// ��ת����Ϣ����չʾ����
		request.getRequestDispatcher("tj_xx.jsp").forward(request, response);
    }
	/**
	 * �ص���Ŀ�±���Ϣ����
	 * @param request  ����
	 * @param response ��Ӧ
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toYbxxhzPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String nd =	request.getParameter("nd");  // ���
		String fromMonth = request.getParameter("fromMonth");  // ��ʼ�·�
		String toMonth = request.getParameter("toMonth");  // �����·�
		String lb1 = request.getParameter("lb1");// ��𣺴���
		String lb2 = request.getParameter("lb2");// ���С��
		String dq = request.getParameter("dq");// ��������
		
		// ��Ͷ��
		String ztz1 = request.getParameter("ztz1");// �жϷ���ȫ�������ڵ��ڡ����ڣ�
		String ztz1num = request.getParameter("ztz2");// ��ֵ1
		String ztz2 = request.getParameter("ztz3");// �жϷ���ȫ����С�ڣ�
		String ztz2num = request.getParameter("ztz4");// ��ֵ2
		// ���Ͷ��
		String wctz1 = request.getParameter("wctz1");// �жϷ���ȫ�������ڵ��ڡ����ڣ�
		String wctz1num = request.getParameter("wctz2");// ��ֵ1
		String wctz2 = request.getParameter("wctz3");// �жϷ���ȫ����С�ڣ�
		String wctz2num = request.getParameter("wctz4");// ��ֵ2
		// �ƻ�Ͷ��
		String jhtz1 = request.getParameter("jhtz1");// �жϷ���ȫ�������ڵ��ڡ����ڣ�
		String jhtz1num = request.getParameter("jhtz2");// ��ֵ1
		String jhtz2 = request.getParameter("jhtz3");// �жϷ���ȫ����С�ڣ�
		String jhtz2num = request.getParameter("jhtz4");// �жϷ���ȫ����С�ڣ�
		// �����ȼƻ�Ͷ��
		String wcjhtz1 = request.getParameter("wcjhtz1");// �жϷ���ȫ�������ڵ��ڡ����ڣ�
		String wcjhtz1num = request.getParameter("wcjhtz2");// ��ֵ1
		String wcjhtz2 = request.getParameter("wcjhtz3");// �жϷ���ȫ����С�ڣ�
		String wcjhtz2num = request.getParameter("wcjhtz4");// �жϷ���ȫ����С�ڣ�
		
		String sfscx = request.getParameter("sfscx"); // �Ƿ�������
		String sfzz = request.getParameter("sfzz"); // �Ƿ�����֮��
		String sfss = request.getParameter("sfss");  // �Ƿ�ʡ��Ŀ
		String sfzy = request.getParameter("sfzy"); // �Ƿ���Դ
		String sjslb = request.getParameter("sjslb");  // 10+3���
		String tzztxz = request.getParameter("tzztxz");  // ��ĿͶ������
		
		String kgFromNd = request.getParameter("kgFromNd");  // ��Ŀ������ݣ���ʼ��
		String kgToNd = request.getParameter("kgToNd");  // ��Ŀ������ݣ�������
		String kgFromMonth = request.getParameter("kgFromMonth");  // ��Ŀ�����·ݣ���ʼ��
		String kgToMonth = request.getParameter("kgToMonth");  // ��Ŀ�����·ݣ�������
		
		// ��ȡ�ص��±���Ŀ��Ϣ
		List<ProZdxmYb> itemList = ZdxmDao.showYbxxhzList(nd, fromMonth, toMonth, lb1, lb2, dq, ztz1,
				ztz1num, ztz2, ztz2num, wctz1, wctz1num, wctz2, wctz2num,
				jhtz1, jhtz1num, jhtz2, jhtz2num, wcjhtz1, wcjhtz1num, wcjhtz2, wcjhtz2num, sfscx, sfzz, sfss, sfzy,
				sjslb, tzztxz, kgFromNd, kgToNd, kgFromMonth, kgToMonth);
	
		
		request.setAttribute("nd", nd);
		request.setAttribute("fromMonth", fromMonth);
		request.setAttribute("toMonth", toMonth);
		
		
		//��������
		String tableDataString = "";
		//�ϼ�����
		ProZdxmYb hj = new ProZdxmYb();
		//�ڽ�����
		ProZdxmYb zj = new ProZdxmYb();
		//Ԥ������
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
			               "<td align=\"center\" style=\"color:red;\" >�ϼ�("+itemList.size()+"��)</td>" +
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
			if(itemList.get(i).getLb().equals("�ڽ�")){
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
				           "<td align=\"center\" >һ</td>" +
			               "<td align=\"center\" >�ڽ��ص���Ŀ("+zjnum+"��)</td>" +
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
		
		//�õ��ּ��б�
		List<String> lb1list = ZdxmDao.getLb1List();

		
		String tempData = "";
		int lb1num = 0;
		
		for(int i = 0; i<lb1list.size(); i++){
			
			//�������
			ProZdxmYb templb1 = new ProZdxmYb();
			//ѭ�������б�����Ӧ������
			for(int j = 0, k = 0; j<itemList.size(); j++){
			
			   if( itemList.get(j).getLb1().equals(lb1list.get(i)) && itemList.get(j).getLb().equals("�ڽ�") ){
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
               "<td align=\"center\" >"+lb1list.get(i)+"("+lb1num+"��)</td>" +
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
			if(itemList.get(i).getLb().equals("Ԥ��")){
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
				           "<td align=\"center\" >��</td>" +
			               "<td align=\"center\" >Ԥ���ص���Ŀ("+ybnum+"��)</td>" +
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
			//�������
			ProZdxmYb templb1 = new ProZdxmYb();
			//ѭ�������б�����Ӧ������
			for(int j = 0, k = 0; j<itemList.size(); j++){
			
			   if( itemList.get(j).getLb1().equals(lb1list.get(i)) && itemList.get(j).getLb().equals("Ԥ��") ){
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
               "<td align=\"center\" >"+lb1list.get(i)+"("+lb1num+"��)</td>" +
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
		// ��ת����Ϣ����չʾ����
		request.getRequestDispatcher("tj_yb.jsp").forward(request, response);
	}

	
	
	/**
	 * ��Ϣ����
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
	 * �±���Ϣ����
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
	 * ������Ȳ�ѯ����
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
	 * �˻�����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void thsq(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		String id = request.getParameter("id");  // ��Ŀ����
		String shyj = request.getParameter("shyj");  // ������
		ZdxmDao.audit(id,"���˻�",shyj); // �޸���Ŀ״̬��������
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideEditFrame();</script>"); 
		out.flush();
	}
	
	/**
	 * ���ͨ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void shtg(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		String id = request.getParameter("id");  // ��Ŀ����
		String shyj = request.getParameter("shyj");  // ������
		ZdxmDao.audit(id,"�����",shyj); // �޸���Ŀ״̬��������
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideEditFrame();</script>"); 
		out.flush();
	}
	/**
	 * get������ش�����б�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getAudit(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
		Integer  pageNo   = 1;	// ��ʼҳ
		Integer  pageSize = 10; // ÿҳ����
		if (!(request.getParameter("pageNo") == null || request.getParameter("pageNo").equals(""))) {
			pageNo = Integer.valueOf(request.getParameter("pageNo"));
		}
		if (!(request.getParameter("pageSize") == null || request.getParameter("pageSize").equals(""))) {
			pageSize = Integer.valueOf(request.getParameter("pageSize"));
		}
	    String searchStr = request.getParameter("searchStr"); // ��ѯ����
	    String nd = FavoritesHelper.nullChangeString(request.getParameter("nd")); //��Ŀ���
		String lb = FavoritesHelper.nullChangeString(request.getParameter("lb"));// ��Ŀ���
		if (!FavoritesHelper.isNotNull(nd)) {
	    	Calendar calendar = Calendar.getInstance();
			nd = calendar.get(Calendar.YEAR)+"";
		}
	    if (!FavoritesHelper.isNotNull(lb)) {
	    	lb = "�ڽ�";
	    }
		Pager pager = ZdxmDao.getObjForAudit(pageNo, pageSize,lb, nd, searchStr); // ��ȡ��ѯ������������ҳ������
		request.setAttribute("pager", pager);
		request.setAttribute("nd", nd);
		request.setAttribute("xmlb", lb);
		request.setAttribute("searchStr", searchStr);
		request.getRequestDispatcher("sh.jsp").forward(request, response); // ��ת�����ҳ��
	}
	/**
	 * get������ش�����б�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getAuditSearch(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		Integer  pageNo   = 1;	// ��ʼҳ
		Integer  pageSize = 10; // ÿҳ����

		if (!(request.getParameter("pageNo") == null || request.getParameter(
				"pageNo").equals(""))) {
			pageNo = Integer.valueOf(request.getParameter("pageNo"));
		}
		if (!(request.getParameter("pageSize") == null || request.getParameter(
				"pageSize").equals(""))) {
			pageSize = Integer.valueOf(request.getParameter("pageSize"));
		}
		String searchStr = request.getParameter("searchStr");
		String nd = FavoritesHelper.nullChangeString(request.getParameter("nd")); //��Ŀ���
		String lb = FavoritesHelper.nullChangeString(request.getParameter("lb"));// ��Ŀ���
		Pager pager = ZdxmDao.getObjForAudit(pageNo, pageSize, lb, nd, searchStr);
		request.setAttribute("pager", pager);
		request.setAttribute("nd", nd);
		request.setAttribute("xmlb", lb);
		request.setAttribute("searchStr", searchStr);
		request.getRequestDispatcher("sh.jsp").forward(request, response);
	}
	
	/**
	 * ��ת�����ҳ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goAuditPage(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		long id   = Long.valueOf(request.getParameter("id")); // ��Ϣ����
		ProZdxm item = ZdxmDao.getObjById(id); // ��Ϣ����
		request.setAttribute("item", item);
		request.getRequestDispatcher("ll.jsp").forward(request, response);
	}
	/**
	 * �����б���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void update(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		// �ص���Ŀʵ��
		ProZdxm item = new ProZdxm();
		// Ϊ�����Ը�ֵ
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
	    if(!"ȡ��ѡ��".equals(request.getParameter("sjslb"))){
	    	item.setSjslb(request.getParameter("sjslb"));
	    } 
	
		ZdxmDao.update(item);	
			
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
	    out.print("<script type='text/javascript'>alert('�޸ĳɹ���');window.parent.hideEditFrame();</script>");
		//out.println("<script type='text/javascript'>window.parent.hideEditFrame();</script>"); 
		out.flush();
	}
	
	/**
	 * ��ת���鿴����ҳ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goReadPage(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
		long id = Long.valueOf(request.getParameter("id")); // ��Ŀ����
		ProZdxm item = ZdxmDao.getObjById(id); // ��Ŀ��Ϣ
		request.setAttribute("item", item);
		request.getRequestDispatcher("xmll.jsp").forward(request, response);
	}
	/**
	 * ��ת���༭ҳ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goEditPage(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		// ��Ŀ����
		long id   = Long.valueOf(request.getParameter("id"));
		ProZdxm item = ZdxmDao.getObjById(id);
		request.setAttribute("dqlist",  ZdxmDao.getDqList());
		request.setAttribute("lblist", ZdxmDao.getLbList());
		request.setAttribute("item", item);
		request.getRequestDispatcher("xg.jsp").forward(request, response);
	}
	
	/**
	 * ��������
	 * @param request
	 * @param response
	 * @param type ִ�����ͣ�1������Ŀ��Ϣ�����н�����Ŀ��Ϣ¼��ҳ�棬2��ֱ�ӽ�����Ŀ��Ϣ¼��ҳ�棩
	 * @throws ServletException
	 * @throws IOException
	 */
	private void add(HttpServletRequest request, HttpServletResponse response, int type)
	throws ServletException, IOException {
		// �ص���Ŀʵ��
		ProZdxm item = new ProZdxm();
		// Ϊ�����Ը�ֵ
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
	    if(!"ȡ��ѡ��".equals(request.getParameter("sjslb"))){
	    	item.setSjslb(request.getParameter("sjslb"));
	    } 
	    item.setZt("δ�ϱ�");
	    item.setSbyh(request.getSession().getAttribute("yhm").toString());
		ZdxmDao.add(item);
		// ��ʾ����ɹ�
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
	    if (1 == type) {
	    	out.println("<script type='text/javascript'>window.parent.hideEditFrame();</script>"); 
		} else if (2 == type){
			out.print("<script>alert('����ɹ���');location.href='ZdxmServlet?action=toAdd&type=2'</script>");
		}
		out.flush();
		out.close();
	}
	
	
	/**
	 * ��ת������ҳ��
	 * @param request
	 * @param response
	 * @param type ִ�����ͣ�1������Ŀ��Ϣ�����н�����Ŀ��Ϣ¼��ҳ�棬2��ֱ�ӽ�����Ŀ��Ϣ¼��ҳ�棩
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
	 * ɾ���б���  ������post����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delItems(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		String[] itemList = request.getParameterValues("itemList");
		 	
		if(ZdxmDao.delItemList(itemList)){
			//TODO Ӧ����������ͨ�û�Ӧ��ajax���͵�ɾ����ʡ����  ��̨�û�Ҳֱ�Ӽ�¼ҳ��λ��
			postList(request, response);
		}else{
			//��λ������ҳ��
		}	
	}
	
	/**
	 * get��������б�
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
	    	lb = "�ڽ�";
	    }
	    
		Pager pager = ZdxmDao.getObjForPage(pageNo, pageSize, lb, nd, searchStr);
	
		request.setAttribute("pager", pager);
		request.setAttribute("xmlb", lb);
		request.setAttribute("nd", nd);
		request.setAttribute("searchStr", searchStr);
		request.getRequestDispatcher("gl.jsp").forward(request, response);
		
	}
	
	
	/**
	 * post��������б�
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
	* ���ַ���ת��unicode
	* @param str ��ת�ַ���
	* @return unicode�ַ���
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
		j = (c >>>8); //ȡ����8λ
		tmp = Integer.toHexString(j);
		if (tmp.length() == 1)
		sb.append("0");
		sb.append(tmp);
		j = (c & 0xFF); //ȡ����8λ
		tmp = Integer.toHexString(j);
		if (tmp.length() == 1)
		sb.append("0");
		sb.append(tmp);
	
		}
		return (new String(sb));
	}

}