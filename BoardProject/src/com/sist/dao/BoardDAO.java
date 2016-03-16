package com.sist.dao;
// 이전  다음     < << [1][2][3][4][5] >> > <% %>
import java.sql.*;
import java.util.*;
public class BoardDAO {
   private Connection conn;
   private PreparedStatement ps;
   private final String URL="jdbc:oracle:thin:@211.238.142.28:1521:ORCL";
   private static BoardDAO dao;
   // Driver 등록
   public BoardDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   // ==> DriverManager
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   // (+) DB2
   }
   // 연결
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"scott","tiger");
	   }catch(Exception ex){}
   }
   // 연결 해제
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex){}
   }
   // 싱글턴 
   public static BoardDAO newInstance()
   {
	   if(dao==null)
		   dao=new BoardDAO();
	   return dao;
   }
   // 기능...
   // 1. 목록 
   public List<BoardDTO> boardListData(int page)
   {
	   List<BoardDTO> list=new ArrayList<BoardDTO>();
	   try
	   {
		   // 연결
		   getConnection();
		   int rowSize=10;
		   int start=(rowSize*page)-(rowSize-1);
		   int end=rowSize*page;
		   // 1~10 , 11~20
		   String sql="SELECT no,subject,name,regdate,hit,group_tab,num "
				     +"FROM (SELECT no,subject,name,regdate,hit,group_tab,rownum as num "
				     +"FROM (SELECT no,subject,name,regdate,hit,group_tab "
				     +"FROM board ORDER BY group_id DESC,group_step ASC))"
				     +"WHERE num BETWEEN "+start+" AND "+end;
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   BoardDTO d=new BoardDTO();
			   d.setNo(rs.getInt(1));
			   d.setSubject(rs.getString(2));
			   d.setName(rs.getString(3));
			   d.setRegdate(rs.getDate(4));
			   d.setHit(rs.getInt(5));
			   d.setGroup_tab(rs.getInt(6));
			   list.add(d);
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   finally
	   {
		   disConnection();
	   }
	   return list;
   }
   // 총페이지
   public int boardTotal()
   {
	   int total=0;
	   try
	   {
		   getConnection();
		   String sql="SELECT CEIL(COUNT(*)/10) FROM board";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   total=rs.getInt(1);
		   rs.close();
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   finally
	   {
		   disConnection();
	   }
	   return total;
   }
   // 총갯수(번호)
   public int boardCount()
   {
	   int total=0;
	   try
	   {
		   getConnection();
		   String sql="SELECT COUNT(*) FROM board";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   total=rs.getInt(1);
		   rs.close();
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   finally
	   {
		   disConnection();
	   }
	   return total;
   }
   // 내용보기
   public BoardDTO boardContentData(int no)
   {
	   BoardDTO d=new BoardDTO();
	   try
	   {
		   getConnection();
		   String sql="UPDATE board SET "
				     +"hit=hit+1 "
				     +"WHERE no=?";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, no);
		   ps.executeUpdate();
		   ps.close();
		   
		   sql="SELECT no,name,subject,content,hit,TO_CHAR(regdate,'YYYY-MM-DD (HH24\"시\" MI\"분\" SS\"초\")') "
			  +"FROM board "
			  +"WHERE no=?";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, no);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   d.setNo(rs.getInt(1));
		   d.setName(rs.getString(2));
		   d.setSubject(rs.getString(3));
		   d.setContent(rs.getString(4));
		   d.setHit(rs.getInt(5));
		   d.setStrDay(rs.getString(6));
		   rs.close();
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   finally
	   {
		   disConnection();
	   }
	   return d;
   }
}





