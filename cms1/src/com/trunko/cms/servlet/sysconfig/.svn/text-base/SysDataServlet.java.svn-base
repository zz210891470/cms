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
 * @ClassName: 系统数据管理控制类
 * 
 * @Description: 负责备份系统数据功能
 * 
 * @author lhanliang
 * 
 * @date 2014-4-22 上午11:15:01
 */
public class SysDataServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	/**
	 * 分页页面大小
	 */
	private int pageSize = 10;
	
	/**
	 * 分页起始页码
	 */
	private int pageNo = 1;
	
	/**
	 * 返回信息
	 */
	private String message = "";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 执行操作
		String act = request.getParameter("act");

		if (act.equals("list")) { // 显示数据备份信息列表
			getList(request, response);
		} else if (act.equals("backup")) {
			backup(request, response);
		}
	}

	/**
	 * 得到系统数据备份列表
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pageNo = request.getParameter("pageNo"); // 页面起始页码
		String pageSize = request.getParameter("pageSize"); // 页面大小
		if (FavoritesHelper.isNotNull(pageNo)) { // 传递的起始页码不为空
			this.pageNo = Integer.valueOf(pageNo);
		}
		if (FavoritesHelper.isNotNull(pageSize)) {// 传递的页面大小不为空
			this.pageSize = Integer.valueOf(pageSize);
		}
		// 分页获取备份信息列表
		SysDataBackupDao backupDao = new SysDataBackupDao();
		Pager pager = backupDao.getItemForPage(this.pageNo, this.pageSize);

		request.setAttribute("pager", pager);
		request.getRequestDispatcher("data_list.jsp").forward(request, response);

	}

	/**
	 * 备份系统数据
	 * 
	 * @param request
	 * @param response
	 */
	public void backup(HttpServletRequest request, HttpServletResponse response) {
		try {
			Runtime rt = Runtime.getRuntime();

			// 调用 调用mysql的安装目录的命令
			// 读取配置文件，获取命令信息
			Config config = new Config();
			config.load(Constants.MYSQL_CONFIG);
			String backupConfig = FavoritesHelper.nullChangeString(config.getValue("backup-config"));
			Process child = rt.exec(backupConfig);
			// 设置导出编码为utf-8。这里必须是utf-8
			// 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行
			InputStream in = child.getInputStream();// 控制台的输出信息作为输入流

			InputStreamReader xx = new InputStreamReader(in, "utf-8");
			// 设置输出流编码为utf-8。这里必须是utf-8，否则从流中读入的是乱码

			String inStr;
			StringBuffer sb = new StringBuffer("");
			String outStr;
			// 组合控制台输出信息字符串
			BufferedReader br = new BufferedReader(xx);
			while ((inStr = br.readLine()) != null) {
				sb.append(inStr + "\r\n");
			}
			outStr = sb.toString();
			String nowTime = DateHelper.getNowTime(); // 当前系统时间
			String createTime = DateHelper.getNowTime().replaceAll(":", "").replaceAll("-", "").replaceAll(" ", ""); // 创建时间
			String fileName = createTime + ".sql"; // 文件名
			String filepath = request.getSession().getServletContext().getRealPath("") + "/WEB-INF/backup/" + fileName; // 保存路径
			// 要用来做导入用的sql目标文件
			FileOutputStream fout = new FileOutputStream(filepath);
			OutputStreamWriter writer = new OutputStreamWriter(fout, "utf-8");
			writer.write(outStr);
			writer.flush();
			in.close();
			xx.close();
			br.close();
			writer.close();
			fout.close();

			/*--------------保存数据信息至数据库 --------------*/
			SysDataBackupDao backupDao = new SysDataBackupDao();
			WebDataBackup backup = new WebDataBackup();
			backup.setUserName((String) request.getSession().getAttribute("yhm"));
			backup.setFileName(fileName);
			backup.setCreateTime(nowTime);
			if (backupDao.save(backup)) { // 如果执行成功则返回成功信息
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
