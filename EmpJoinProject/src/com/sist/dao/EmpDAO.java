package com.sist.dao;
import java.sql.*;
import java.util.*;

public class EmpDAO {
	
	 // ����Ŭ ���� -> socket
	private Connection conn;
	 //sql ���� ���� -> BufferedReader, OutputStream
	private PreparedStatement ps;
	 //url �ּ�
	private final String URL="jdbc:oracle:thin:@211.238.142.28:1521:ORCL";
	 //�̱���
	private static EmpDAO dao;
	 //����Ŭ ������ ���� ����̹� ��ġ
	public EmpDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	 //���� ��ü ����
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL, "scott", "tiger");
		}catch(Exception ex){}
	}
	 //���� ����
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();//in.close(), out.close()
			if(conn!=null) conn.close();
		}catch(Exception ex){}
	}
	public static EmpDAO newInstance()
	{
		if(dao==null)
		dao=new EmpDAO();
			return dao;
	}
		
	 //��� ó��
	 //1.��ü���
	public ArrayList<EmpDTO> empAllData(int page)
	{
		ArrayList<EmpDTO> list=new ArrayList<EmpDTO>();
		try
		{
			getConnection();//����
		
			int rowSize=5;
			int start=(page*rowSize)-(rowSize-1);
			int end=(page*rowSize);
			
			String sql="SELECT empno,ename,job,dname,loc,grade,rn "
					+ "FROM (SELECT empno,ename,job,dname,loc,grade,rownum as rn "
					+ "FROM (SELECT empno,ename,job,dname,loc,grade "
					+ "FROM emp,dept,salgrade "
					+ "WHERE emp.deptno=dept.deptno "
					+ "AND sal BETWEEN losal AND hisal ORDER BY sal DESC, ename ASC)) "
					+ "WHERE rn BETWEEN "+start+" AND "+end;
			
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				EmpDTO d=new EmpDTO();
				d.setEmpno(rs.getInt(1));
				d.setEname(rs.getString(2));
				d.setJob(rs.getString(3));
				d.getDdto().setDname(rs.getString(4));
				d.getDdto().setLoc(rs.getString(5));
				d.getSdto().setGrade(rs.getInt(6));
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
	public int empTotalPage()
	{
		int total=0;
		try
		{
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/5) FROM emp";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
			//total=(int)(Math.ceil(count/10.0));
			//1.4
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally
		{
			disConnection();
		}
		return total;
	}
	 //2.�󼼺���(����)
	 public EmpDTO empDetail(int empno)
	 {
		 EmpDTO d=new EmpDTO();
		 try
		 {
			 getConnection();
			 String sql="SELECT empno,ename,job,mgr,TO_CHAR(hiredate,'YYYY-MM-DD'),TO_CHAR(sal,'$99,999'),NVL(comm,0), "
			 		+ "emp.deptno,dname,loc,grade "
			 		+ "FROM emp,dept,salgrade "
			 		+ "WHERE emp.deptno=dept.deptno "
			 		+ "AND sal BETWEEN losal AND hisal "
			 		+ "AND empno=?";
			 ps=conn.prepareStatement(sql);
			 ps.setInt(1, empno);
			 ResultSet rs=ps.executeQuery();
			 rs.next();
			 d.setEmpno(rs.getInt(1));
			 d.setEname(rs.getString(2));
			 d.setJob(rs.getString(3));
			 d.setMgr(rs.getInt(4));
			 d.setStrDay(rs.getString(5));
			 d.setStrSal(rs.getString(6));
			 d.setComm(rs.getInt(7));
			 d.setDeptno(rs.getInt(8));
			 d.getDdto().setDname(rs.getString(9));
			 d.getDdto().setLoc(rs.getString(10));
			 d.getSdto().setGrade(rs.getInt(11));
			 rs.close();
		 }
		 catch(Exception ex){
			 System.out.println(ex.getMessage());
		 }
		 finally
		 {
			 disConnection();
		 }
		 return d;
	 }
}














