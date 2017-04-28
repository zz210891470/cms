package com.trunko.cms.dao.people;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trunko.cms.entity.WebQuestion;
import com.trunko.cms.util.DBHelper;
import com.trunko.cms.util.Pager;

public class PeopleQuestionDao {

	public boolean update(WebQuestion webQuestion){
		String sql="update  web_question set question='"+webQuestion.getQuestion()+"',answer='"+webQuestion.getAnswer()
	     +"',author='"+webQuestion.getAuthor()+"',time='"+webQuestion.getTime()
	     +"' where id="+webQuestion.getId();
		
		System.out.println(sql);
		
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}

	    return false;
		
	}
	
	
	public WebQuestion getById(long id){
		Connection conn = DBHelper.getConnection();
		PreparedStatement stat =null;
		ResultSet rs = null;
        WebQuestion webQuestion=new WebQuestion();
		try {
			String countsql="select * from web_question where id=?";
			stat = conn.prepareStatement(countsql);
		    stat.setLong(1, id);
		    rs = stat.executeQuery();
			if(rs.next()){
				webQuestion.setId(rs.getLong("id"));
				webQuestion.setQuestion(rs.getString("question"));
				webQuestion.setAnswer(rs.getString("answer"));
				webQuestion.setAuthor(rs.getString("author"));
				webQuestion.setUrl(rs.getString("url"));
				webQuestion.setTime(rs.getDate("time"));
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return webQuestion;
		
		
	}

	public boolean add(WebQuestion webQuestion){
		
		String sql="insert into web_question(question,answer,author,time) values('"+webQuestion.getQuestion()+"','"+webQuestion.getAnswer()
		     +"','"+webQuestion.getAuthor()+"','"+webQuestion.getTime()+"')";
		System.out.println(sql);
		if(DBHelper.executeUpdateInject(sql)>0){
			   return true;
		}

		return false;
	}
	
	
	public boolean delItemList(String[] ItemList){
		
	   String sql="delete from web_Question where ";
		
	   for(int i=0;i<ItemList.length;i++){	   
		   sql+= " id="+ItemList[i]+"  or ";   
	   }
	   sql=sql.substring(0, sql.length()-4);
	   System.out.println(sql);
	   if(DBHelper.executeUpdateInject(sql)>0){
		   return true;
	   }
		
	   return false;
	}
	
	
	
	public Pager getItemForPage(int pageNo,int pageSize){
		
		List<WebQuestion> itemlist=new ArrayList<WebQuestion>() ;
		Connection conn = DBHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
        int count=0;
		try {
			stat = conn.createStatement();
			String countsql="select count(*) as num from web_question ";
			
			rs=stat.executeQuery(countsql);
			if(rs.next()){
				count=rs.getInt("num");
			}

			String sql = "select * from web_question order by id desc limit "+((pageNo-1)*pageSize)+" , "+pageSize;
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				WebQuestion webQuestion=new WebQuestion();
				webQuestion.setId(rs.getLong("id"));
				webQuestion.setQuestion(rs.getString("question"));
				webQuestion.setAnswer(rs.getString("answer"));
				webQuestion.setAuthor(rs.getString("author"));
				webQuestion.setUrl(rs.getString("url"));
				webQuestion.setTime(rs.getDate("time"));
				
				itemlist.add(webQuestion);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeDB(conn, stat, rs);
		}
		return new Pager(pageSize, pageNo, count, itemlist);
		

	}
	
	
}
