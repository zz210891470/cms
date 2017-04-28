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
		   
	    if(action.equals("list")){//��ʾ�б�
		    getList(request, response);
	    }
	    else if(action.equals("toAdd")){//��ת������ҳ��
		    goAddPage(request, response);
	    }
	    else if(action.equals("toEdit")){//��ת���༭ҳ��
		    goEditPage(request, response);
	    }
	    else if(action.equals("toRead")){//��ת�����ҳ��
	    	goReadPage(request, response);
	    }
	    else if(action.equals("toImport")){//��ת������ҳ��
		    toImportPage(request, response);
	    }
	    else if(action.equals("sideradd")){//�����¼��ҳ��
		    toSiderAddPage(request, response);
	    }
	    else if(action.equals("audit")){
	    	getAudit(request,response);
	    }
	    else if(action.equals("toAudit")){//���
	    	goAuditPage(request,response);
	    }
	    else if(action.equals("xxhz")){   //��Ϣ����	
	    	Xxhz(request,response);
	    }
	    else if(action.equals("xxhzpage")){   //��Ϣ���� ҳ��
	    	toXxhzPage(request,response);
	    }
	    else if(action.equals("xxfgmhzpage")){   //��Ϣ�ֹ�ģ����  add by lhanliang
	    	toFgmhzPage(request,response);
	    }
	    else if(action.equals("getGmxxInfo")){   //ajax��Ϣ�ֹ�ģ��������
	    	getGmxxInfo(request,response);
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
		    goAddPage(request, response);
	    }
	    else if(action.equals("add")){//�����б���
		    add(request, response);
	    }
	    else if(action.equals("toEdit")){//��ת���༭ҳ��
		    goEditPage(request, response);
	    }
	    else if(action.equals("toRead")){//��ת�����ҳ��
	    	goReadPage(request, response);
	    }
	    else if(action.equals("update")){//�޸��б���
		    update(request, response);
	    }
	    else if(action.equals("toImport")){//��ת������ҳ��
		    toImportPage(request, response);
	    }
	    else if(action.equals("sideradd")){//�����¼��ҳ��
		    toSiderAddPage(request, response);
	    }	    
	    else if(action.equals("sadd")){//�����¼��ҳ��
		    sadd(request, response);
	    }
	    else if(action.equals("audit")){//���
	    	postAudit(request,response);
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
	    else if(action.equals("xxflhzpage")){   //��Ϣ�������  add by lhanliang
	    	toFlhzPage(request,response);
	    }
	    else if(action.equals("xxfjhzpage")){   //��Ϣ�ּ�����  add by lhanliang
	    	toFjhzPage(request,response);
	    }
	    else if(action.equals("xxfgmhzpage")){   //��Ϣ�ֹ�ģ����  add by lhanliang
	    	toFgmhzPage(request,response);
	    }
	    else if(action.equals("getGmxxInfo")){   //ajax��Ϣ�ֹ�ģ��������
	    	getGmxxInfo(request,response);
	    }
	    else if(action.equals("publish")){//������Ϣ��webinformation
	    	
	    	 publishMsg(request,response);
	    	
	    }
	}
	
	/**
	 * ��Ϣ�ֹ�ģ���� add by lhanliang
	 * @param request ����
	 * @param response ��Ӧ
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
	 * ��Ϣ�ֹ�ģ������ add by lhanliang
	 * @param request ����
	 * @param response ��Ӧ
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toLbhz(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // ���
		
		String data = "";

		// ��ȡ���д�����Ϣ
		List<ProCbxm> infoList = CbxmDao.getAllProList(year);

		List<String> lb1list  =  CbxmDao.getLb1List();
		
		List<ProCbxm>  tempList = new ArrayList<ProCbxm>();
		int num = 0;
		double ztz = 0l;
		
		//100��������Ŀ
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()>1000000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert("100��������Ŀ��"+num+"����")+"\" style=\"font-weight:bold\" style=\"font-weight:bold\"></td>"
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
			data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert(lb1list.get(i)+"��"+numTmp+"����")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}
		num = 0;
		ztz =  0l;
		tempList.clear();
		//50-100��Ŀ
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=1000000 && infoList.get(j).getZtz()>500000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert("50-100����Ŀ��"+num+"����")+"\" style=\"font-weight:bold\"></td>"
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
			data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert(lb1list.get(i)+"��"+numTmp+"����")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}
		num = 0;
		ztz =  0l;
		tempList.clear();
		//20-50��Ŀ
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=500000 && infoList.get(j).getZtz()>200000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert("20-50����Ŀ��"+num+"����")+"\" style=\"font-weight:bold\"></td>"
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
			data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert(lb1list.get(i)+"��"+numTmp+"����")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}

		num = 0;
		ztz =  0l;
		tempList.clear();
		//10-20��Ŀ
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=200000 && infoList.get(j).getZtz()>100000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert("10-20����Ŀ��"+num+"����")+"\" style=\"font-weight:bold\"></td>"
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
			data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert(lb1list.get(i)+"��"+numTmp+"����")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}

		num = 0;
		ztz =  0l;
		tempList.clear();
		//5-10��Ŀ
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=100000 && infoList.get(j).getZtz()>50000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert("5-10����Ŀ��"+num+"����")+"\" style=\"font-weight:bold\"></td>"
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
			data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert(lb1list.get(i)+"��"+numTmp+"����")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}
		num = 0;
		ztz =  0l;
		tempList.clear();
		//1-5��Ŀ
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=50000 && infoList.get(j).getZtz()>10000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert("1-5����Ŀ��"+num+"����")+"\" style=\"font-weight:bold\"></td>"
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
			data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert(lb1list.get(i)+"��"+numTmp+"����")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}
		num = 0;
		ztz =  0l;
		tempList.clear();
		//1��������Ŀ
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=10000 ){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert("1��������Ŀ��"+num+"����")+"\" style=\"font-weight:bold\"></td>"
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
			data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert(lb1list.get(i)+"��"+numTmp+"����")+"\"></td>"
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
	 * ��Ϣ�ֹ�ģ�������� add by lhanliang
	 * @param request ����
	 * @param response ��Ӧ
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toDqhz(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // ���
		
		String data = "";

		// ��ȡ���д�����Ϣ
		List<ProCbxm> infoList = CbxmDao.getAllProList(year);

		List<String> dqlist  =  CbxmDao.getDqList();
		
		List<ProCbxm>  tempList = new ArrayList<ProCbxm>();
		int num = 0;
		double ztz = 0l;
		
		//100��������Ŀ
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()>1000000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert("100��������Ŀ��"+num+"����")+"\" style=\"font-weight:bold\"></td>"
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
			data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert(dqlist.get(i)+"��"+numTmp+"����")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}
		
		num = 0;
		ztz =  0l;
		tempList.clear();
		//50-100��Ŀ
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=1000000 && infoList.get(j).getZtz()>500000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert("50-100����Ŀ��"+num+"����")+"\" style=\"font-weight:bold\"></td>"
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
			data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert(dqlist.get(i)+"��"+numTmp+"����")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
            +"<td></td><td></td></tr>"; 
			data += dataTmp;
			
		}
		num = 0;
		ztz =  0l;
		tempList.clear();
		//20-50��Ŀ
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=500000 && infoList.get(j).getZtz()>200000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert("20-50����Ŀ��"+num+"����")+"\" style=\"font-weight:bold\"></td>"
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
			data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert(dqlist.get(i)+"��"+numTmp+"����")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}

		num = 0;
		ztz =  0l;
		tempList.clear();
		//10-20��Ŀ
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=200000 && infoList.get(j).getZtz()>100000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert("10-20����Ŀ��"+num+"����")+"\" style=\"font-weight:bold\"></td>"
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
			data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert(dqlist.get(i)+"��"+numTmp+"����")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}

		num = 0;
		ztz =  0l;
		tempList.clear();
		//5-10��Ŀ
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=100000 && infoList.get(j).getZtz()>50000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert("5-10����Ŀ��"+num+"����")+"\" style=\"font-weight:bold\"></td>"
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
			data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert(dqlist.get(i)+"��"+numTmp+"����")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}
		num = 0;
		ztz =  0l;
		tempList.clear();
		//1-5��Ŀ
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=50000 && infoList.get(j).getZtz()>10000){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert("1-5����Ŀ��"+num+"����")+"\" style=\"font-weight:bold\"></td>"
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
			data +="<tr height=\"30\"  ><td></td><td align=\"center\" name=\""+convert(dqlist.get(i)+"��"+numTmp+"����")+"\"></td>"
            +"<td></td><td></td><td align=\"right\">"+ztzTmp+"</td><td align=\"right\">"+year+"</td>"
	        +"<td></td><td></td></tr>";
			data += dataTmp;
			
		}
		num = 0;
		ztz =  0l;
		tempList.clear();
		//1��������Ŀ
		for(int j=0; j<infoList.size() ;j++){
			if(infoList.get(j).getZtz()<=10000 ){
				tempList.add(infoList.get(j));
				num++;
				ztz += tempList.get(j).getZtz();
			}
			
		}
		
		data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert("1��������Ŀ��"+num+"����")+"\" style=\"font-weight:bold\"></td>"
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
			data +="<tr height=\"30\"  ><td></td><td align=\"center\"  name=\""+convert(dqlist.get(i)+"��"+numTmp+"����")+"\"></td>"
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
	 * ��Ϣ�ֹ�ģ���� add by lhanliang
	 * @param request ����
	 * @param response ��Ӧ
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toFgmhzPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // ���
		String fz =	request.getParameter("fz");  // ���鷽ʽ


        request.setAttribute("year", year);
        request.setAttribute("fz", fz);

        
		
		// ��ת����Ϣ����ͳ��ҳ�棬չʾ��Ϣ
		request.getRequestDispatcher("tj_tz.jsp").forward(request, response);
	}
	
	
	/**
	 * ������Ŀ��Ϣ����
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
	    
	    String ztz1 = request.getParameter("ztz1");// �жϷ���ȫ�������ڵ��ڡ����ڣ�
	    String ztz1num = request.getParameter("ztz2");// ��ֵ1
	    String ztz2 = request.getParameter("ztz3");// �жϷ���ȫ����С�ڣ�
	    String ztz2num = request.getParameter("ztz4");// ��ֵ2
		
	    // ��ȡ������Ŀ��Ϣ
	    List<ProCbxm> itemList =   CbxmDao.showXxhzList(nd, lb1, lb2, dq, ztz1, ztz1num , ztz2, ztz2num);
	    request.setAttribute("itemList", itemList);
		// ��ת����Ϣ����չʾ����
		request.getRequestDispatcher("tj_xx.jsp").forward(request, response);
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
	
		request.setAttribute("dqlist", CbxmDao.getDqList());
		request.setAttribute("lblist", CbxmDao.getLbList());
		request.getRequestDispatcher("tj_xx_page.jsp").forward(request, response);

    }
	/**
	 * ��Ϣ������� add by lhanliang
	 * @param request ����
	 * @param response ��Ӧ
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toFlhzPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // ���
		// ��ȡ����ͳ����Ϣ
		Map<String, List<String>> sortInfoMap = CbxmDao.getSortInfoMap(year);
		// �����Ϣ��request��
		request.setAttribute("sortInfoMap", sortInfoMap);
		// ��ת����Ϣ����ͳ��ҳ�棬չʾ��Ϣ
		request.getRequestDispatcher("tj_fl.jsp").forward(request, response);
		
	}
	/**
	 * ��Ϣ�ּ����� add by lhanliang
	 * @param request ����
	 * @param response ��Ӧ
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toFjhzPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year = request.getParameter("year");  // ���
		// ��ȡ�ּ�ͳ����Ϣ
		Map<String, List<String>> areaInfoMap = CbxmDao.getAreaInfoMap(year);
		// �����Ϣ��request��
		request.setAttribute("areaInfoMap", areaInfoMap);
		// ��ת����Ϣ�ּ�ͳ��ҳ�棬չʾ��Ϣ
		request.getRequestDispatcher("tj_fj.jsp").forward(request, response);
		
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
		
		String id = request.getParameter("id");
		String shyj = request.getParameter("shyj");
		CbxmDao.audit(id,"���˻�",shyj);
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
		
		String id = request.getParameter("id");
		String shyj = request.getParameter("shyj");
		CbxmDao.audit(id,"�����",shyj);

		
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>window.parent.hideEditFrame();</script>"); 
		out.flush();
	}
	
	
	
	
	/**
	 * ��������
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
		item.setZt("�����");
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
	 * �����¼��ҳ��
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
	 * ��ת������ҳ��
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
	 * �����б���
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
	 * ��ת���༭ҳ��
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
	 * ��ת�����ҳ��
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
	 * ��ת�����ҳ��
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
	 * ��������
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
		item.setZt("�����");
		
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
	 * ��ת������ҳ��
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
	 * ɾ���б���  ������post����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delItems(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		String[] itemList = request.getParameterValues("itemList");
		 	
		if(CbxmDao.delItemList(itemList)){
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
	    String searchStr = request.getParameter("searchStr");
		Pager pager = CbxmDao.getObjForPage(pageNo, pageSize,searchStr);
	
		request.setAttribute("pager", pager);
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
		Pager pager = CbxmDao.getObjForPage(pageNo, pageSize, searchStr);
	
		request.setAttribute("pager", pager);
		request.setAttribute("searchStr", searchStr);
		

		request.getRequestDispatcher("gl.jsp").forward(request, response);
		
	}

	
	/**
	 * get��������б�
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
	 * post��������б�
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
	 * ����
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