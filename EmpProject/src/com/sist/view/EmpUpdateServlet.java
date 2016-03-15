package com.sist.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpDTO;

public class EmpUpdateServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;


   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html;charset=EUC-KR");
      String empno=request.getParameter("empno");
      PrintWriter out=response.getWriter();
      
      out.println("<html>");
      out.println("<body>");
      out.println("<center>");   
      // ������ ���
      EmpDAO dao=new EmpDAO();
      EmpDTO d=dao.empUpdateData(Integer.parseInt(empno));
      out.println("<form action=EmpUpdateServlet method=post>");    // submit ��ư�� �������� ����Ǵ� ��
      out.println("<table  width=500 border=1 bordercolor=black cellspacing=0>"); // cellspacing = �׵θ����� 0�̸� ���ٷ� 1�̸� 2�ٷ�
      
      out.println("<tr>");
      out.println("<td width=15% align=right>�̸�</td>");
      out.println("<td width=35% align=left>");
      out.println("<input type=text size=12 name=ename value="+d.getEname()+">");
      out.println("<input type=hidden name=empno value="+empno+">");
      out.println("</td>");
      out.println("<td width=15% align=right>����</td>");
      out.println("<td width=35% align=left>");
      List<String> jList=dao.empGetJob();
      out.println("<select name=job>");
      for(String s:jList)
      {
         if(s.equals(d.getJob()))
             out.println("<option selected>"+s+"</option>");
         else
            out.println("<option>"+s+"</option>");
      }
      out.println("</select>");
      out.println("</td>");
      out.println("</tr>");
      ///////////////////////////////////////////////////////////////////
      out.println("<tr>");
      out.println("<td width=15% align=right>�����ȣ</td>");
      out.println("<td width=35% align=left>");
      List<Integer>mList=dao.empGetMgr();
      out.println("<select name=mgr>");
      for(Integer m:mList)
      {
         if(m==d.getMgr())
             out.println("<option selected>"+m+"</option>");
         else
            out.println("<option>"+m+"</option>");
      }
      out.println("</select>");
      out.println("</td>");
      //////////////////
      out.println("<td width=15% align=right>�μ���ȣ</td>");
      out.println("<td width=35% align=left>");
      out.println("<select name=deptno>");
      out.println("<option "+(d.getDeptno()==10?"selected":"")+">10</option>");
      out.println("<option "+(d.getDeptno()==20?"selected":"")+">10</option>");
      out.println("<option "+(d.getDeptno()==30?"selected":"")+">10</option>");
      out.println("<option "+(d.getDeptno()==40?"selected":"")+">10</option>");
      out.println("</select>");
      out.println("</td>");
      out.println("</tr>");
      ///////////////////////////////////////////////////////////////////////////////
      out.println("<tr>");
      out.println("<td width=15% align=right>�޿�</td>");
      out.println("<td width=35% align=left>");
      out.println("<select name=sal>");
      out.println("<option>1000</option>");
      out.println("<option>2000</option>");
      out.println("<option>3000</option>");
      out.println("<option>4000</option>");
      out.println("<option>4500</option>");
      out.println("</select>");
      out.println("</td>");
      out.println("<td width=15% align=right>������</td>");
      out.println("<td width=35% align=left>");
      out.println("<select name=comm>");
      out.println("<option>100</option>");
      out.println("<option>200</option>");
      out.println("<option>300</option>");
      out.println("<option>400</option>");
      out.println("<option>500</option>");
      out.println("</select>");
      out.println("</td>");
      out.println("</tr>");
      
      out.println("<tr>");
      out.println("<td colspan=4 align=right>");
      out.println("<input type=submit value=����>");
      out.println("<input type=button value=��� onclick=\"javascript:history.back()\">");  // ��ҹ�ư �������� �������~
      // javascript:history.back()  => ���� ȭ������ ���ư�.
      out.println("</td>");
      out.println("</tr>");
      
      out.println("</table>");
      out.println("</form>");   
      
      
      out.println("</center>");
      out.println("</body>");
      out.println("</html>");
   }
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("EUC-KR");
        String empno=request.getParameter("empno");
      String ename=request.getParameter("ename");
        //System.out.println(ename);
      String job=request.getParameter("job");
      String mgr=request.getParameter("mgr");
      String sal=request.getParameter("sal");
      String comm=request.getParameter("comm");
      String deptno=request.getParameter("deptno");
      // dto
      EmpDTO d=new EmpDTO();
      d.setEmpno(Integer.parseInt(empno));
      d.setEname(ename);
      d.setJob(job);
      d.setMgr(Integer.parseInt(mgr));
      d.setSal(Integer.parseInt(sal));
      d.setComm(Integer.parseInt(comm));
      d.setDeptno(Integer.parseInt(deptno));
      // dao
      EmpDAO dao=new EmpDAO();
      dao.empUpdate(d);
      
      response.sendRedirect("MainServlet?type=2&empno="+empno);
   }
}

