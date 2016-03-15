package com.sist.emp;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;
//import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
//a.jsp ==> a_jsp.java (�������� �ؾ��ϱ� ������ java ���Ϸ� �ٲ�°ž�! ��Ĺ(tomcat)�� jsp �����̴�!)
// @WebServlet("/EmpServlet") �ּҰ� EmpServlet�� ������ �Ʒ� Ŭ������ �����ض�! -> annotation -> xml ��ü�ϴ� ���α׷�

public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out=response.getWriter();
		//OutputStream out=s.getOutputStream(); �� ���� ����!
		// /EmpServlet?page=1 ��� ���ðž�! url �ּҸ� ���ؼ� ���� �޾ƾ���
		String strPage=request.getParameter("page");
		if(strPage==null)
		{
			strPage="1"; // page�� ó�� 1�̶�� ����Ʈ�� �����. �̴ܰ踦 ���ϸ� ������!
		}
		int curpage=Integer.parseInt(strPage);
		EmpDAO dao=new EmpDAO();
		ArrayList<EmpDTO> list=dao.empAllData(curpage);
		
		int totalpage=dao.empTotalPage();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<style type=text/css>");
		out.println("th,td{font-family:���� ���;font-size:9pt}");
		out.println("a{text-decoration:none;color:black}");
		out.println("a:hover{text-decoration:underline;color:green}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h3><b>��� ���<b></h3>");
		out.println("<table border=0 width=600>");
		out.println("<tr bgcolor=#ccccff>");
		out.println("<th>���</th>");
		out.println("<th>�̸�</th>");
		out.println("<th>����</th>");
		out.println("<th>�μ�</th>");
		out.println("<th>�ٹ���</th>");
		out.println("<th>���</th>");
		out.println("</tr>");
		String color="";
		int i=0;
		for(EmpDTO d:list)
		{
			if(i%2==0)
				color="white";
			else
				color="#ccffcc";
			out.println("<tr bgcolor="+color+">");
			out.println("<td>"+d.getEmpno()+"</td>");
			out.println("<td>");
			out.println("<a href=EmpDetailServlet?empno="+d.getEmpno()+">");
			out.println(d.getEname()+"</a>");
			out.println("</td>");
			out.println("<td>"+d.getJob()+"</td>");
			out.println("<td>"+d.getDdto().getDname()+"</td>");
			out.println("<td>"+d.getDdto().getLoc()+"</td>");
			out.println("<td>"+d.getSdto().getGrade()+"</td>");
			out.println("</tr>");
			i++;
		}
		out.println("</table>");
		out.println("<hr width=600>");
		out.println("<table border=0 width=600>");
		out.println("<tr>");
		out.println("<td align=left>");
		out.println("Search:");
		out.println("<select>"); //�޺��ڽ�
		out.println("<option>�̸�</option>");
		out.println("<option>�μ�</option>");
		out.println("<option>����</option>");
		out.println("</select>");
		out.println("<input type=text size=10>");
		out.println("<input type=button value=ã��>");
		out.println("</td>");
		out.println("<td align=right>");
		out.println("<a href=EmpServlet?page="+(curpage>1?curpage-1:curpage)+">");
		out.println("<img src=image/prev.gif border=0></a>");
		out.println("<a href=EmpServlet?page="+(curpage<totalpage?curpage+1:curpage)+">");
		/*
		 * 	1) 404 : ������ �������� ���� ��(���ϸ� ã��)
		 * 	2) 500 : �ҽ� ������ �󿡼� ����(�ҽ� �ڵ� ã�ƺ���)
		 * 	3) 412 : �ѱ� ��ȯ �ڵ带 �� �� ���� ��(EUC-KR,UTF-8)
		 * 	4) 200 : ���� ���� ==> ȭ���� ���
		 * 	5) 403 : ���� �ź�
		 */
		for(int j=1;j<=totalpage;j++)
		{
			out.println("[");
			out.println("<a href=EmpServlet?page="+j+">");
			out.println(j);
			out.println("</a>");
			out.println("]");
		}
		out.println("<img src=image/next.gif border=0></a>");
		out.println("&nbsp;&nbsp;"); //����!
		out.println(curpage+" page / "+totalpage+" pages");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

}
