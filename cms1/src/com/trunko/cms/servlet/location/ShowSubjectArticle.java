package com.trunko.cms.servlet.location;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trunko.cms.dao.location.ShowArticleDao;
import com.trunko.cms.entity.WebInfomation;
import com.trunko.cms.entity.WebSubInfo;
import com.trunko.cms.util.DBHelper;

public class ShowSubjectArticle extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	    String id =request.getParameter("id");

		try{
			Long.valueOf(id);
		}catch(Exception e){
			return;
		}
		String data="[\"SUCCESS\",\"";
	    data+=convert(getData(id));
		data+="\"]";
		PrintWriter out = response.getWriter();
			
        response.setContentType("application/json; charset=utf-8");  
        response.setHeader("pragma", "no-cache");  
        response.setHeader("cache-control", "no-cache");  
		out.write(data);
		out.close();

	    
	}
	
	
	
	/**
	 * �õ���������
	 * @return
	 */
	public static String getData(String id){
		
		WebSubInfo webInfomation=new WebSubInfo();
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
		String data="";

		try {
			
			String lmmc="";
			String sql = "select *,(select lmmc from web_subcolumn where id=web_subinfo.lmid) as lmmc from web_subinfo where zt='�ѷ���' and id=?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, Integer.valueOf(id));
			
			rs = stat.executeQuery();
			
			if(rs.next()){
				lmmc=rs.getString("lmmc");
				webInfomation.setId(rs.getLong("id"));
				webInfomation.setBt(rs.getString("bt"));
				webInfomation.setBtys(rs.getString("btys"));
				webInfomation.setFbt(rs.getString("fbt"));
				webInfomation.setIp(rs.getString("ip"));
				webInfomation.setLjwz(rs.getString("ljwz"));
				webInfomation.setLlcs(rs.getInt("llcs"));
				webInfomation.setLmid(rs.getLong("lmid"));
				webInfomation.setLy(rs.getString("ly"));
				webInfomation.setNr(rs.getString("nr"));
				webInfomation.setSx(rs.getString("sx"));
				webInfomation.setSj(rs.getTimestamp("sj"));
				webInfomation.setPlcs(rs.getInt("plcs"));
				webInfomation.setZt(rs.getString("zt"));
				webInfomation.setZz(rs.getString("zz"));
				webInfomation.setRq(rs.getDate("rq"));
				webInfomation.setFbr(rs.getString("fbr"));
			}

			data+="<div id='div_wz'>&nbsp;����ǰ��λ�ã���ҳ&nbsp;>&nbsp;ר����Ŀ&nbsp;>&nbsp;"+lmmc+"</div>";
			data+="<div id='div_bt'>"+webInfomation.getBt()+"</div><div id='div_sx'>";
			if(webInfomation.getZz()!=null && !webInfomation.getZz().equals("")){
			
			    data+="���ߣ�"+webInfomation.getZz()+"&nbsp;&nbsp;";
			}
			if(webInfomation.getLy()!=null && !webInfomation.getLy().equals("")){
			    data+="��Դ��"+webInfomation.getLy()+"&nbsp;&nbsp;";
			}
			data+="�༭��"+webInfomation.getFbr()+"&nbsp;&nbsp;";
			data+="���ڣ�"+webInfomation.getRq();

			data+="&nbsp;&nbsp;���ֺţ�<a href='javascript:fontZoomC();'><font color='#7e7e7e'>��</font></a> <a  href='javascript:fontZoomB();'><font color='#7e7e7e'>��</font></a> <a href='javascript:fontZoomA();'><font color='#7e7e7e'>С</font></a>��</div>";
			data+="<div id='div_nr'>"+webInfomation.getNr()+"</div>";
			
			//�������µ����
			sql="update web_subinfo set llcs=llcs+1 where id="+id;
			DBHelper.executeUpdateInject(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}

		return data;
		
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
