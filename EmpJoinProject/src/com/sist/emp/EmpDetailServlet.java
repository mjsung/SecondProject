package com.sist.emp;

import java.io.*;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.dao.*;



public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out=response.getWriter();
		String empno=request.getParameter("empno");
		EmpDAO dao=EmpDAO.newInstance();
		EmpDTO d=dao.empDetail(Integer.parseInt(empno));
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h3>"+d.getEname()+"���� �� ����</h3>");
		out.println("<table border=1 width=350>");
		out.println("<tr>");
		out.println("<td width=30%>���</td>");
		out.println("<td width=70%>"+d.getEmpno()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=30%>�̸�</td>");
		out.println("<td width=70%>"+d.getEname()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=30%>����</td>");
		out.println("<td width=70%>"+d.getJob()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=30%>���/td>");
		out.println("<td width=70%>"+d.getMgr()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=30%>�Ի���</td>");
		out.println("<td width=70%>"+d.getStrDay()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=30%>�޿�</td>");
		out.println("<td width=70%>"+d.getStrSal()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=30%>������</td>");
		out.println("<td width=70%>"+d.getComm()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=30%>�μ���ȣ</td>");
		out.println("<td width=70%>"+d.getDeptno()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=30%>�μ���</td>");
		out.println("<td width=70%>"+d.getDdto().getDname()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=30%>�ٹ���</td>");
		out.println("<td width=70%>"+d.getDdto().getLoc()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=30%>�޿����</td>");
		out.println("<td width=70%>"+d.getSdto().getGrade()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan=2 align=center>");
		out.println("<a href=EmpServlet>");
		out.println("���</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

}
