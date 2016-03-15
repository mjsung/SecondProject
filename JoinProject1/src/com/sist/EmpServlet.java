package com.sist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * Servlet (Server+let)===> JSP
 * let ==> ������ ���α׷� 
 *	=> �������
 *	������() ==> �޸��Ҵ�(tomcat)
 *=> �������
 *	������() ==> �޸��Ҵ�(tomcat)
 *	init() ==> �������, ����̹� ���, �����б�(XML)
 *	���� �Լ� ==> ����(������)
 *	=====
 *		doGet
 *		doPost ==> Ŭ���̾�Ʈ�� ����� ����
 *	=====
 *	destroy() : �޸� ����
 */


public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException{
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * request : ����� ��û���� ���� �� ���
		 * response : ��ûó�� �� ����� ����
		 */
		//���۹��
		response.setContentType("text/html;charset=EUC-KR");
		//�޸𸮿� ���
		PrintWriter out=response.getWriter();
		//s.getOutputStream() => out.write()
		//���� �±�<body> �ݴ� �±�</body> EMPTY�±� <br/>
		out.println("<html>");
		out.println("<body>");
		//ȭ�� ��� �κ�
		out.println("<center>");
		out.println("<h3>������</h3>"); //����(<b><br>)
		//h1~h6���� ���� h6�� ���� ���� �۾�
		out.println("<table border=1 width=560>");
		out.println("<tr>");
		for(int i=2;i<=9;i++)
		{
			out.println("<th>"+i+"�� </th>");
		}
		out.println("</tr>");
		for(int i=1;i<=9;i++)
		{
			out.println("<tr>");
			for(int j=2;j<=9;j++)
			{
				out.println("<td>");
				out.println(j+"*"+i+"="+(j*i));
				out.println("</td>");
			}
			out.println("</tr>");
		}
		out.println("<table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
