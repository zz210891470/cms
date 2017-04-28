package com.trunko.project.serlvet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.entity.WebInfomation;
import com.trunko.cms.util.DBHelper;

public class CbxmArticleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		     doPost(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<WebInfomation> informationlist=new ArrayList<WebInfomation>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		int count=0;
		String data1="";
		int pageNo=1;
		String pn=req.getParameter("pageNo");
		System.out.println("第几页"+pn);
		if(pn!=null){
			pageNo=Integer.parseInt(pn);
		}
		

		try {
			stat = conn.createStatement();
            String sql1= "select count(*) as num from  web_infomation where zt='已发布' and lmid='73'";
             rs = stat.executeQuery(sql1);
             while(rs.next()){
            	 count = rs.getInt("num");
             }

			String sql = "select * from web_infomation where zt='已发布' and lmid='73' order by rq desc, id desc limit "+(pageNo-1)*20+",20";
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				WebInfomation webInfomation=new WebInfomation();
                
				webInfomation.setId(rs.getLong("id"));
				webInfomation.setBt(rs.getString("bt"));
				webInfomation.setLlcs(rs.getInt("llcs"));
				webInfomation.setLmid(rs.getLong("lmid"));
				webInfomation.setSj(rs.getTimestamp("sj"));
				webInfomation.setRq(rs.getDate("rq"));
				informationlist.add(webInfomation);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		
		for(WebInfomation w:informationlist){
			
			data1+="<div class='div_lb'><a href='ShowArticle.htm?lb=info&id="+w.getId()+"' target='_blank' title=\""+w.getBt()+"\">"+w.getBt()+"</a><span>"+w.getRq()+"</span></div>";
			
		}
		
		if(data1==""){
			data1+="<div style='padding:30px;'>栏目暂无信息！</div>";
		}else{
			if(count>20){
				
				data1+="<div id='bottom'><span id='pagecount' data-num='"+(count/20+2)+"'>共有"+count+"条记录&nbsp;&nbsp;第"+pageNo+"页/共"+((count/20)+1)+"页&nbsp;&nbsp;<a href='javascript:gopage(1)' >" +
						"首页</a>&nbsp;&nbsp;<a href='javascript:gopage("+(pageNo-1)+")'>上一页</a>&nbsp;&nbsp;<a href='javascript:gopage("+(pageNo+1)+")'>下一页</a>&nbsp;&nbsp;<a href='javascript:gopage("+((count/20)+1)+")' >末页</a></span></div>";
				
			}
		}
		
		
	    String data="[\"SUCCESS\",\"";
	    data+=convert(data1);
		data+="\"]";
		PrintWriter out = resp.getWriter();
			
        resp.setContentType("application/json; charset=utf-8");  
        resp.setHeader("pragma", "no-cache");  
        resp.setHeader("cache-control", "no-cache");  
		out.write(data);
		out.close();
	
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

	


