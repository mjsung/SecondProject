package com.sist.dao;
import java.sql.*;
import java.util.*;

public class EmpDAO {
       // ����Ŭ ����  ==> Socket
          private Connection conn;
     
      // SQL ���� ����  ==> BufferedReader,OutputStream
          private PreparedStatement ps;
          
      // URL �ּ�
          private final String URL="jdbc:oracle:thin:@211.238.142.28:1521:ORCL";
          
      // �̱���
          private static EmpDAO dao;
             // ����Ŭ ������ ���� ����̹� ����
              public EmpDAO()
               {
                   try
                   {
                      Class.forName("oracle.jdbc.driver.OracleDriver");
                    }catch(Exception ex)
                   {
                        System.out.println("EmpDAO() : "+ex.getMessage());
                    }
                }
              
      // ���� ��ü ����
           public void getConnection()
           {
              try
              {
                 conn=DriverManager.getConnection(URL,"scott","tiger");
                 // conn scott/tiger
              }catch(Exception ex)
              {
                 System.out.println("getConnection() : "+ex.getMessage());  
              }
           }
           
      // ���� ����
           public void disConnection()
           {
              try
              {
                 if(ps!=null) 
                    ps.close();
                 // in.close() ,out.close()
                 if(conn!=null)
                    conn.close();
              }catch(Exception ex)
              {
                 System.out.println("disConnection() : "+ex.getMessage());
              }
           }
           
           public static EmpDAO newInstance()
           {
              if(dao==null)
                 dao=new EmpDAO();
              return dao;
           }
           
      // ��� ó��
      // 1. ��� SELECT 
           /*
            *     1. ȭ�� ���
            *     2. DAO �ۼ�
            *     3. ����Ŭ 
            *     4. ȭ�� ==> �����ͺ��̽� ���
            */
           public List<EmpDTO> empAllData()
           {
              List<EmpDTO> list=new ArrayList<EmpDTO>();
              try
              {
                 // ����
                 getConnection();
                 
                 // SQL ���� �ۼ� ed test
                 String sql="SELECT empno,ename,job,hiredate,dname "
                       + "FROM emp,dept "
                       + "WHERE emp.deptno=dept.deptno "
                       + "ORDER BY empno DESC";
                 
                 // @test
                 ps=conn.prepareStatement(sql);
                 ResultSet rs=ps.executeQuery();  //executeQuery => @
                 while(rs.next())
                 {
                    EmpDTO d=new EmpDTO();
                    d.setEmpno(rs.getInt(1));
                    d.setEname(rs.getString(2));
                    d.setJob(rs.getString(3));
                    d.setHiredate(rs.getDate(4));
                    d.setDname(rs.getString(5));
                    list.add(d);
                 }
              }catch(Exception ex)
              {
                 System.out.println("empAllData() : "+ex.getMessage());
              }
              return list;
           }
           
           // job
           public List<String> empGetJob()
           {
              List<String> list=new ArrayList<String>();
              try
              {
                    // ����
                          getConnection();
                    // SQL
                          String sql="SELECT DISTINCT job FROM emp "
                                + "WHERE ename!='KING'";
                    // ����
                          ps=conn.prepareStatement(sql);    
                    // �����
                          ResultSet rs=ps.executeQuery();
                          while(rs.next())
                          {
                             list.add(rs.getString(1));
                          }
                          rs.close();
              }catch(Exception ex)
              {
                 System.out.println("empGetJob(): "+ex.getMessage());
              }
              finally 
              {
                disConnection();
            }
              return list;
           }
           
           // mgr
           // Integer  i=10
           // int  a=i;
           
           public List<Integer> empGetMgr()
           {
              List<Integer> list=new ArrayList<Integer>();
              try
              {
                    // ����
                          getConnection();
                    // SQL
                          String sql="SELECT DISTINCT mgr FROM emp "
                                + "WHERE mgr IS NOT NULL";
                    // ����
                          ps=conn.prepareStatement(sql);    
                    // �����
                          ResultSet rs=ps.executeQuery();
                          while(rs.next())
                          {
                             list.add(rs.getInt(1));
                          }
                          rs.close();
              }catch(Exception ex)
              {
                 System.out.println("empGetMgr(): "+ex.getMessage());
              }
              finally 
              {
                disConnection();
            }
              return list;
           }
           
           
       // 2. ��� INSERT   
           public void empInsert(EmpDTO d)
           {
              try
              {
                 getConnection();
                 String sql="INSERT INTO emp VALUES ((SELECT MAX(empno)+1 FROM emp),?,?,?,SYSDATE,?,?,?)";
                 ps=conn.prepareStatement(sql);
                 ps.setString(1, d.getEname());
                 ps.setString(2, d.getJob());
                 ps.setInt(3, d.getMgr());
                 ps.setInt(4, d.getSal());
                 ps.setInt(5, d.getComm());
                 ps.setInt(6, d.getDeptno());
                 ps.executeQuery();
              }catch(Exception ex)
              {
                 System.out.println("empInsert(): "+ex.getMessage());
              }
              finally
              {
                 disConnection();
              }
           }
           
           
       // 3. �󼼺��� SELECT 
           public EmpDTO empDetailData(int empno)
           {
              EmpDTO d=new EmpDTO();
              try
              {
                 getConnection();
                 String sql="SELECT empno,ename,job,hiredate,mgr,sal,comm,dname "
                       + "FROM emp,dept "
                       + "WHERE emp.deptno=dept.deptno "
                       + "AND empno="+empno;
                 ps=conn.prepareStatement(sql);
                 ResultSet rs=ps.executeQuery();
                 rs.next();
                 d.setEmpno(rs.getInt(1));
                 d.setEname(rs.getString(2));
                 d.setJob(rs.getString(3));
                 d.setHiredate(rs.getDate(4));
                 d.setMgr(rs.getInt(5));
                 d.setSal(rs.getInt(6));
                 d.setComm(rs.getInt(7));
                 d.setDname(rs.getString(8));
                 rs.close();
              }catch(Exception ex)
              {
                 System.out.println("empDetailData(): "+ex.getMessage());
              }
              finally
              {
                 disConnection();
              }
              return d;
              
           }
           
       // 4. ���� UPDATE
           public EmpDTO empUpdateData(int empno)
           {
              EmpDTO d=new EmpDTO();
              try
              {
                 getConnection();
                 String sql="SELECT ename,job,mgr,sal,comm,deptno "
                       + "FROM emp "
                       + "WHERE empno="+empno;
                 ps=conn.prepareStatement(sql);
                 ResultSet rs=ps.executeQuery();
                 rs.next();
                 
                 d.setEname(rs.getString(1));
                 d.setJob(rs.getString(2));
                 d.setMgr(rs.getInt(3));
                 d.setSal(rs.getInt(4));
                 d.setComm(rs.getInt(5));
                 d.setDeptno(rs.getInt(6));
                 rs.close();
              }catch(Exception ex)
              {
                 System.out.println("empUpdateData(): "+ex.getMessage());
              }
              finally
              {
                 disConnection();
              }
              return d;
              
           }
           
           public void empUpdate(EmpDTO d)
           {
              try
              {
                 getConnection();
                 String sql="UPDATE emp SET "
                       + "ename=?,job=?,mgr=?,sal=?,comm=?,deptno=? "
                       + "WHERE empno=?";
                 ps=conn.prepareStatement(sql);
                 ps.setString(1, d.getEname());
                 ps.setString(2, d.getJob());
                 ps.setInt(3, d.getMgr());
                 ps.setInt(4, d.getSal());
                 ps.setInt(5, d.getComm());
                 ps.setInt(6, d.getDeptno());
                 ps.setInt(7, d.getEmpno());
                 ps.executeUpdate();
              }catch(Exception ex)
              {
                 System.out.println("empUpdate(): "+ex.getMessage());
              }
              finally
              {
                 disConnection();
              }
           }
       // 5. ���� DELETE
           public boolean empDelete(int empno)
           {
              boolean bCheck=false;
              try
              {
                 getConnection();
                 String sql="SELECT COUNT(*) FROM emp "
                       + "WHERE empno=?";
                 ps=conn.prepareStatement(sql);
                 ps.setInt(1, empno);
                 ResultSet rs=ps.executeQuery();
                 rs.next();
                 int count=rs.getInt(1);
                 rs.close();
                 ps.close();
                   
                 if(count==0)
                 {
                    bCheck=false;
                 }
                 else
                 {
                    bCheck=true;
                    sql="DELETE FROM emp "
                          + "WHERE empno=?";
                    ps=conn.prepareStatement(sql);
                    ps.setInt(1, empno);
                    ps.executeUpdate();
                 }
              }catch(Exception ex)
              {
                 System.out.println("empDelete(): "+ex.getMessage());
              }
              finally
              {
                 disConnection();
              }
              return bCheck;
           }
}