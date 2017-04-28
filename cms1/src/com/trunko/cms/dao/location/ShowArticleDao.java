package com.trunko.cms.dao.location;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.trunko.cms.entity.WebConsult;
import com.trunko.cms.entity.WebInfomation;
import com.trunko.cms.entity.WebInfoOpen;
import com.trunko.cms.entity.WebInfoReg;
import com.trunko.cms.entity.WebInfoReport;
import com.trunko.cms.entity.WebLeaderMail;
import com.trunko.cms.entity.WebQuestion;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.FavoritesHelper;

/**
 * ǰ̨��Ϣ��ʾҳ�����ݲ�����
 * @author jianhuang
 *
 */
public class ShowArticleDao {
	/**
	 * �õ���������
	 * @return
	 */
	public String getInfoData(String id){
		
		WebInfomation webInfomation=new WebInfomation();
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
		String data="";

		try {
			String lmmc="";
			int lmid=0;
			String sql = "select *,(select lmmc from web_column where id=web_infomation.lmid) as lmmc from web_infomation  where zt='�ѷ���' and id=?";
            stat = conn.prepareStatement(sql);
			
			stat.setLong(1, Long.valueOf(id));
			rs=stat.executeQuery();
			
			
			if(rs.next()){
				lmmc=rs.getString("lmmc");
				lmid=rs.getInt("lmid");
				webInfomation.setId(rs.getLong("id"));
				webInfomation.setBt(rs.getString("bt"));
				webInfomation.setBtys(rs.getString("btys"));
				webInfomation.setZy(rs.getString("zy"));
				webInfomation.setFbt(rs.getString("fbt"));
				webInfomation.setIp(rs.getString("ip"));
				webInfomation.setLjwz(rs.getString("ljwz"));
				webInfomation.setLlcs(rs.getInt("llcs"));
				webInfomation.setLmid(rs.getLong("lmid"));
				webInfomation.setLy(rs.getString("ly"));
				webInfomation.setNr(rs.getString("nr"));
				webInfomation.setSx(rs.getString("sx"));
				webInfomation.setSj(rs.getTimestamp("sj"));
				webInfomation.setLstp(rs.getString("lstp"));
				webInfomation.setPlcs(rs.getInt("plcs"));
				webInfomation.setZt(rs.getString("zt"));
				webInfomation.setZz(rs.getString("zz"));
				webInfomation.setRq(rs.getDate("rq"));
				webInfomation.setFbr(rs.getString("fbr"));
			}
			rs.close();
			String tp="";
			if(webInfomation.getLstp()!=null && !webInfomation.getLstp().equals("")){
				tp="<br/><div style='text-align:center;'><img id='pic' style='height:200px;;width:250px' src="+webInfomation.getLstp()+"><br/><br/>";
			}
			data+="<div id='div_wz'>&nbsp;����ǰ��λ�ã���ҳ&nbsp;>&nbsp;";
			if(lmmc.equals("")||lmmc.equals("���Ŷ�̬")||lmmc.equals("֪ͨ����")||lmmc.equals("�ļ�֪ͨ")||lmmc.equals("���߷���")||lmmc.equals("���ص���")||lmmc.equals("��Ч�ܽ��赳��")){
				data+="<a href='subcolumn.htm?loc=xxgk' target='_self'>��Ϣ����</a>";
			}else if(lmmc.equals("")||lmmc.equals("�ڽ��ص���Ŀ")||lmmc.equals("Ԥ���ص���Ŀ")||lmmc.equals("������Ŀ")||lmmc.equals("������Ŀ")||lmmc.equals("��Ŀ����")||lmmc.equals("��Ŀ����")){
				data+="<a href='subcolumn.htm?loc=xmzh' target='_self'>��Ŀת��</a>";
			}else if(lmmc.equals("")||lmmc.equals("Ͷ�ʻ���")||lmmc.equals("�Ż�����")||lmmc.equals("������Ŀ")||lmmc.equals("ǰ����Ŀ")||lmmc.equals("����ͼƬר����Ŀ")){
				data+="<a href='subcolumn.htm?loc=xmzs' target='_self'>��Ŀ�ƽ�</a>";
			}else if(lmmc.equals("")||lmmc.equals("��Ŀ�߻�ָ��")||lmmc.equals("������Ŀ")){
				data+="<a href='subcolumn.htm?loc=xmch' target='_self'>��Ŀ�߻�</a>";
			}else if(lmmc.equals("")||lmmc.equals("��Ŀ����")||lmmc.equals("��Ŀ�걨")||lmmc.equals("��Ŀ����")||lmmc.equals("ר������")){
				data+="<a href='subcolumn.htm?loc=xmps' target='_self'>��Ŀ����</a>";
			}else if(lmmc.equals("")||lmmc.equals("��Ŀ���")||lmmc.equals("��Ŀ����")||lmmc.equals("������Ŀ")){
				data+="<a href='subcolumn.htm?loc=xmcb' target='_self'>��Ŀ����</a>";
			}else if(lmmc.equals("")||lmmc.equals("����ָ��")||lmmc.equals("�ļ�����")){
				data+="<a href='subcolumn.htm?loc=wsbs' target='_self'>���ϰ���</a>";
			}
			data+="&nbsp;>&nbsp;<a href='subcolumn.htm?loc=xxgk#"+lmid+"' target='_self'>"+lmmc+"</a></div>";
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
			data+="<div id='div_nr'>"+tp+webInfomation.getNr()+"</div><br style='clear:both;'/>";
			System.out.println("����:"+data);
			//�������µ����
			
			sql="update web_infomation set llcs=llcs+1 where id="+Long.valueOf(id);
			DBHelper.executeUpdateInject(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}

		return data;
		
	}
	
	//��Ϣ������Ϣ��ʾ
	public String getInfoopenData(String id){
		
		WebInfoOpen webInfoOpen=new WebInfoOpen();
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String data="";

		try {
			stat = conn.createStatement();
			String sql = "select * from web_infoopen where id="+Long.valueOf(id);
			rs = stat.executeQuery(sql);
			
			if(rs.next()){
				webInfoOpen.setId(rs.getLong("id"));
				webInfoOpen.setBt(rs.getString("syh"));
				webInfoOpen.setFl(rs.getString("fl"));
				webInfoOpen.setFbjg(rs.getString("fbjg"));
				webInfoOpen.setFwrq(rs.getDate("fwrq"));
				webInfoOpen.setBt(rs.getString("bt"));
				webInfoOpen.setWh(rs.getString("wh"));
				webInfoOpen.setZtc(rs.getString("ztc"));
				webInfoOpen.setNr(rs.getString("nr"));
			}
			rs.close();
			data+="<div id='div_wz'>&nbsp;����ǰ��λ�ã���ҳ&nbsp;>&nbsp;������Ϣ����ר��&nbsp;>&nbsp;����Ŀ¼</div>";
			data+="<div id='div_bt'>"+webInfoOpen.getBt()+"</div>";
			data+="<div id='div_nr'>"+webInfoOpen.getNr()+"</div>";
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}

		return data;
		
	}
	/**
	 * ��ȡ�쵼������Ϣ
	 * @param id
	 * @return
	 */
	public String getConsultData(String id){
		WebConsult webConsult = new WebConsult();
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String data="";

		try {
			stat = conn.createStatement();
			String sql = "select * from web_consult where id="+Long.valueOf(id);
			rs = stat.executeQuery(sql);
			
			if(rs.next()){
				webConsult.setId(rs.getLong("id"));
				webConsult.setBt(rs.getString("bt"));
				webConsult.setXm(rs.getString("xm"));
				webConsult.setLxfs(rs.getString("lxfs"));
				webConsult.setNr(rs.getString("nr"));
				webConsult.setSj(rs.getDate("sj"));
				webConsult.setHfsj(rs.getDate("hfsj"));
				webConsult.setZt(rs.getString("zt"));
				webConsult.setHfnr(rs.getString("hfnr"));
			}
			rs.close();
			data+="<div id='div_bt'>"+webConsult.getBt()+"</div><div id='div_sx'>";
			if(webConsult.getXm()!=null && !webConsult.getXm().equals("")){
			
			    data+="��ѯ�ߣ�"+webConsult.getXm()+"&nbsp;&nbsp;";
			}
			data+="���ڣ�"+webConsult.getSj();
			data+="&nbsp;&nbsp;���ֺţ�<a href='javascript:fontZoomC();'><font color='#7e7e7e'>��</font></a> <a  href='javascript:fontZoomB();'><font color='#7e7e7e'>��</font></a> <a href='javascript:fontZoomA();'><font color='#7e7e7e'>С</font></a>��</div>";
			data+="<div id='div_nr'>"+webConsult.getNr()+"</div>";
			if(FavoritesHelper.isNotNull(webConsult.getZt()) && "�Ѵ�".equals(webConsult.getZt())){
				data+="<div id='div_nr'></div>";
				data+="<div id='div_nr'><font size='3' style='font: bold;'>�ظ���</font></div>";
				data+="<div id='div_nr'>"+ webConsult.getHfnr() +"</div>";
				data+="<div id='div_nr'>ʱ�䣺"+ webConsult.getHfsj() +"</div>";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}

		return data;
		
	}
	/**
	 * ��ȡ�쵼������Ϣ
	 * @param id
	 * @return
	 */
	public String getMailData(String id){
		WebLeaderMail leaderMail = new WebLeaderMail();
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String data="";
		
		try {
			stat = conn.createStatement();
			String sql = "select * from web_leadermail where id="+Long.valueOf(id);
			rs = stat.executeQuery(sql);
			
			if(rs.next()){
				leaderMail.setId(rs.getLong("id"));
				leaderMail.setBt(rs.getString("bt"));
				leaderMail.setXm(rs.getString("xm"));
				leaderMail.setLxfs(rs.getString("lxfs"));
				leaderMail.setNr(rs.getString("nr"));
				leaderMail.setSj(rs.getDate("sj"));
				leaderMail.setHfsj(rs.getDate("hfsj"));
				leaderMail.setZt(rs.getString("zt"));
				leaderMail.setHfnr(rs.getString("hfnr"));
				leaderMail.setLsh(rs.getString("lsh"));
				leaderMail.setCxmm(rs.getString("cxmm"));
			}
			rs.close();
			data+="<div id='div_bt'>"+leaderMail.getBt()+"</div><div id='div_sx'>";
			if(leaderMail.getXm()!=null && !leaderMail.getXm().equals("")){
				
				data+="Ͷ���ߣ�"+leaderMail.getXm()+"&nbsp;&nbsp;";
			}
			data+="���ڣ�"+leaderMail.getSj();
			data+="&nbsp;&nbsp;���ֺţ�<a href='javascript:fontZoomC();'><font color='#7e7e7e'>��</font></a> <a  href='javascript:fontZoomB();'><font color='#7e7e7e'>��</font></a> <a href='javascript:fontZoomA();'><font color='#7e7e7e'>С</font></a>��</div>";
			data+="<div id='div_nr'>"+leaderMail.getNr()+"</div>";
			if(FavoritesHelper.isNotNull(leaderMail.getZt()) && "�Ѵ�".equals(leaderMail.getZt())){
				data+="<div id='div_nr'></div>";
				data+="<div id='div_nr'><font size='3' style='font: bold;'>�ظ���</font></div>";
				data+="<div id='div_nr'>"+ leaderMail.getHfnr() +"</div>";
				data+="<div id='div_nr'>ʱ�䣺"+ leaderMail.getHfsj() +"</div>";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		
		return data;
		
	}
	
	//�����涨��Ϣ��ʾ
	public String getInforegData(String id){
		
		WebInfoReg webInfoReg=new WebInfoReg();
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String data="";

		try {
			stat = conn.createStatement();

			String sql = "select * from web_inforeg where  id="+Long.valueOf(id);
			rs = stat.executeQuery(sql);
			
			if(rs.next()){
				webInfoReg.setId(rs.getLong("id"));
				webInfoReg.setTopic(rs.getString("topic"));
				webInfoReg.setContent(rs.getString("content"));
				webInfoReg.setTime(rs.getDate("time"));
			}
			rs.close();
			data+="<div id='div_wz'>&nbsp;����ǰ��λ�ã���ҳ&nbsp;>&nbsp;������Ϣ����ר��&nbsp;>&nbsp;�����涨</div>";
			data+="<div id='div_bt'>"+webInfoReg.getTopic()+"</div>";
			data+="<div id='div_nr'>"+webInfoReg.getContent()+"</div>";

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}

		return data;
	}
		
	//������ȱ�����Ϣ��ʾ
	public String getInforeportData(String id){
		
		WebInfoReport webInfoReport=new WebInfoReport();
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String data="";

		try {
			stat = conn.createStatement();

			String sql = "select * from web_inforeport where id="+Long.valueOf(id);
			rs = stat.executeQuery(sql);
			
			if(rs.next()){
				webInfoReport.setId(rs.getLong("id"));
				webInfoReport.setTopic(rs.getString("topic"));
				webInfoReport.setContent(rs.getString("content"));
				webInfoReport.setTime(rs.getDate("time"));
			}
			rs.close();
			data+="<div id='div_wz'>&nbsp;����ǰ��λ�ã���ҳ&nbsp;>&nbsp;������Ϣ����ר��&nbsp;>&nbsp;��ȱ���</div>";
			data+="<div id='div_bt'>"+webInfoReport.getTopic()+"</div>";
			data+="<div id='div_nr'>"+webInfoReport.getContent()+"</div>";

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}

		return data;
	}
	
	//����������Ϣ��ʾ
	public String getQuestionData(String id){
		
		WebQuestion webQuestion=new WebQuestion();
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String data="";

		try {
			stat = conn.createStatement();

			String sql = "select * from web_question where id="+Long.valueOf(id);
			rs = stat.executeQuery(sql);
			
			if(rs.next()){
				webQuestion.setId(rs.getLong("id"));
				webQuestion.setQuestion(rs.getString("question"));
				webQuestion.setAnswer(rs.getString("answer"));
				webQuestion.setTime(rs.getDate("time"));
			}
			rs.close();
			data+="<div id='div_wz'>&nbsp;����ǰ��λ�ã���ҳ&nbsp;>&nbsp;���ڲ���&nbsp;>&nbsp;��������</div>";
			data+="<div id='div_bt'>"+webQuestion.getQuestion()+"</div>";
			data+="<div id='div_nr'>"+webQuestion.getAnswer()+"</div>";

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}

		return data;
	}
}