package com.sist.dao;
import java.sql.*;
import java.util.*;
/*
 *   수집 : sqoop , flume
 *   검색 : 루씬
 *   분석 : MapReduce , 사용자 정의(형태소), hive,pig
 *       ====================================
 *            zookipper
 *   디비 : 몽고디비, My-SQL (분산데이터베이스):HBASE
 *   통계 : R
 *   시각화 : d3
 *   ========================================
 *   보안 , 스파크 , YARN
 *   ===
 *   
 */
public class EmpDAO {
   private Connection conn;
   private PreparedStatement ps;
   private final String URL="jdbc:oracle:thin:@211.238.142.20:1521:ORCL";
   public EmpDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
   }
   // ==> DBCP
   public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL, "scott", "tiger");
		}catch(Exception ex){}
	}
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();//in.close(), out.close() 통신을 끊고
			if(conn!=null) conn.close(); //전화를 닫아라(소켓)
		}catch(Exception ex){}
	}
	public ArrayList<EmpDTO> empAllData()
	{
		ArrayList<EmpDTO> list=new ArrayList<EmpDTO>();
		try
		{
			getConnection();
			String sql="SELECT * FROM emp";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				EmpDTO d=new EmpDTO();
				d.setEmpno(rs.getInt(1));
				d.setEname(rs.getString(2));
				d.setJob(rs.getString(3));
				d.setMgr(rs.getInt(4));
				d.setHiredate(rs.getDate(5));
				d.setSal(rs.getInt(6));
				d.setComm(rs.getInt(7));
				d.setDeptno(rs.getInt(8));
							
				list.add(d);
			}
			rs.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally
		{
			disConnection();
		}
			
		return list;
	}
	public ArrayList<DeptDTO> deptAllData()
	{
		ArrayList<DeptDTO> list=new ArrayList<DeptDTO>();
		try
		{
			getConnection();
			String sql="Select * FROM dept";
			
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				DeptDTO d=new DeptDTO();
				d.setDeptno(rs.getInt(1));
				d.setDname(rs.getString(2));
				d.setLoc(rs.getString(3));
				
				list.add(d);
			}
			rs.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally
		{
			disConnection();
		}
			
		return list;
	}
}












