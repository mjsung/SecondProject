<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%	
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
%>