package com.sist.view;

import java.io.*;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 	������ �̵�(ȭ�� ��ȯ)
 * HTML
 * 	<a> => GET ���
 * 	<form> => GET, POST ���
 * JavaScript
 * 	location.href="URL" => GET ���
 * Java
 * 	response.sendRedirect() => GET ���
 */

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpDTO;

public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=EUC-KR");
		String empno=request.getParameter("empno");
		EmpDAO dao=new EmpDAO();
		EmpDTO d=dao.empDetailData(Integer.parseInt(empno));
		
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<script type=\"text/javascript\">");
		out.println("var i=0");
		/*
		 * var i=10 ==> i(int)
		 * var i="" ==> i(String)
		 * var i=[] ==> array
		 * var i={} ==> object
		 */
		out.println("function del(){");
		out.println("var tr=document.getElementById(\"del\")");
		out.println("if(i==0){");
		out.println("tr.style.display='';");
		out.println("i=1;");
		out.println("}else{");
		out.println("tr.style.display='none';");
		out.println("i=0;");
		out.println("}");
		out.println("}");
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h3>��� �󼼺���</h3>");
		out.println("<table width=500 border=1 bordercolor=black cellspacing=0 cellpadding=0>");
		out.println("<tr>");
		out.println("<td width=20%>���</td>");
		out.println("<td width=30%>"+d.getEmpno()+"</td>");
		out.println("<td width=20%>�̸�</td>");
		out.println("<td width=30%>"+d.getEname()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=20%>����</td>");
		out.println("<td width=30%>"+d.getJob()+"</td>");
		out.println("<td width=20%>�Ի���</td>");
		out.println("<td width=30%>"+d.getHiredate().toString()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=20%>�����ȣ</td>");
		out.println("<td width=30%>"+d.getMgr()+"</td>");
		out.println("<td width=20%>�μ���</td>");
		out.println("<td width=30%>"+d.getDname()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=20%>�޿�</td>");
		out.println("<td width=30%>"+d.getSal()+"</td>");
		out.println("<td width=20%>������</td>");
		out.println("<td width=30%>"+d.getComm()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan=4 align=rignt>");
		out.println("<a href=MainServlet?type=3&empno="+d.getEmpno()+">����</a>&nbsp;");
		out.println("<a href=\"javascript:del()\">����</a>&nbsp;");
		out.println("<a href=EmpListServlet>���</a>&nbsp;");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr id=\"del\" style=\"display:none\">");
		out.println("<td colspan=4 align=rignt>");
		out.println("<form method=post action=EmpDetailServlet>");
		out.println("���:<input type=text name=empno size=12>");
		out.println("<input type=submit value=����>");
		out.println("</form>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out=response.getWriter();
		String empno=request.getParameter("empno");
		EmpDAO dao=new EmpDAO();
		boolean bCheck=dao.empDelete(Integer.parseInt(empno));
		if(bCheck==true)
		{
			response.sendRedirect("MainServlet");
		}
		else
		{
			out.println("<script>");
			out.println("alert(\"����� �������� �ʽ��ϴ�\");");
			out.println("history.back();");
			out.println("</script>");
		}
	}
}


















