package com.trunko.cms.servlet.sysconfig;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.common.Constants;
import com.trunko.cms.dao.sysconfig.SysDataBackupDao;
import com.trunko.cms.entity.WebDataBackup;
import com.trunko.cms.util.Config;
import com.trunko.cms.util.DateHelper;
import com.trunko.cms.util.FavoritesHelper;
import com.trunko.cms.util.Pager;

/**
 * 
 * @ClassName: ϵͳ���ݹ��������
 * 
 * @Description: ���𱸷�ϵͳ���ݹ���
 * 
 * @author lhanliang
 * 
 * @date 2014-4-22 ����11:15:01
 */
public class SysDataServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	/**
	 * ��ҳҳ���С
	 */
	private int pageSize = 10;
	
	/**
	 * ��ҳ��ʼҳ��
	 */
	private int pageNo = 1;
	
	/**
	 * ������Ϣ
	 */
	private String message = "";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ִ�в���
		String act = request.getParameter("act");

		if (act.equals("list")) { // ��ʾ���ݱ�����Ϣ�б�
			getList(request, response);
		} else if (act.equals("backup")) {
			backup(request, response);
		}
	}

	/**
	 * �õ�ϵͳ���ݱ����б�
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pageNo = request.getParameter("pageNo"); // ҳ����ʼҳ��
		String pageSize = request.getParameter("pageSize"); // ҳ���С
		if (FavoritesHelper.isNotNull(pageNo)) { // ���ݵ���ʼҳ�벻Ϊ��
			this.pageNo = Integer.valueOf(pageNo);
		}
		if (FavoritesHelper.isNotNull(pageSize)) {// ���ݵ�ҳ���С��Ϊ��
			this.pageSize = Integer.valueOf(pageSize);
		}
		// ��ҳ��ȡ������Ϣ�б�
		SysDataBackupDao backupDao = new SysDataBackupDao();
		Pager pager = backupDao.getItemForPage(this.pageNo, this.pageSize);

		request.setAttribute("pager", pager);
		request.getRequestDispatcher("data_list.jsp").forward(request, response);

	}

	/**
	 * ����ϵͳ����
	 * 
	 * @param request
	 * @param response
	 */
	public void backup(HttpServletRequest request, HttpServletResponse response) {
		try {
			Runtime rt = Runtime.getRuntime();

			// ���� ����mysql�İ�װĿ¼������
			// ��ȡ�����ļ�����ȡ������Ϣ
			Config config = new Config();
			config.load(Constants.MYSQL_CONFIG);
			String backupConfig = FavoritesHelper.nullChangeString(config.getValue("backup-config"));
			Process child = rt.exec(backupConfig);
			// ���õ�������Ϊutf-8�����������utf-8
			// �ѽ���ִ���еĿ���̨�����Ϣд��.sql�ļ����������˱����ļ���ע��������Կ���̨��Ϣ���ж�������ᵼ�½��̶����޷�����
			InputStream in = child.getInputStream();// ����̨�������Ϣ��Ϊ������

			InputStreamReader xx = new InputStreamReader(in, "utf-8");
			// �������������Ϊutf-8�����������utf-8����������ж����������

			String inStr;
			StringBuffer sb = new StringBuffer("");
			String outStr;
			// ��Ͽ���̨�����Ϣ�ַ���
			BufferedReader br = new BufferedReader(xx);
			while ((inStr = br.readLine()) != null) {
				sb.append(inStr + "\r\n");
			}
			outStr = sb.toString();
			String nowTime = DateHelper.getNowTime(); // ��ǰϵͳʱ��
			String createTime = DateHelper.getNowTime().replaceAll(":", "").replaceAll("-", "").replaceAll(" ", ""); // ����ʱ��
			String fileName = createTime + ".sql"; // �ļ���
			String filepath = request.getSession().getServletContext().getRealPath("") + "/WEB-INF/backup/" + fileName; // ����·��
			// Ҫ�����������õ�sqlĿ���ļ�
			FileOutputStream fout = new FileOutputStream(filepath);
			OutputStreamWriter writer = new OutputStreamWriter(fout, "utf-8");
			writer.write(outStr);
			writer.flush();
			in.close();
			xx.close();
			br.close();
			writer.close();
			fout.close();

			/*--------------����������Ϣ�����ݿ� --------------*/
			SysDataBackupDao backupDao = new SysDataBackupDao();
			WebDataBackup backup = new WebDataBackup();
			backup.setUserName((String) request.getSession().getAttribute("yhm"));
			backup.setFileName(fileName);
			backup.setCreateTime(nowTime);
			if (backupDao.save(backup)) { // ���ִ�гɹ��򷵻سɹ���Ϣ
				message = "[\"success\"]";
    		}else{
    			message = "[\"error\"]";
    		}
			PrintWriter out = response.getWriter();
	        response.setContentType("text/html");  
			out.write(message);
			out.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
