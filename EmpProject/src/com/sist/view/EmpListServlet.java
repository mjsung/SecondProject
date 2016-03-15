package com.sist.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.dao.*;
import java.util.*;

public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		//브라우저 출력
		out.println("<table width=600 border=0>");
		out.println("<tr>");
		out.println("<td>");
		out.println("<a href=MainServlet?type=1>등록</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<table width=600 border=0>");
		out.println("<tr bgcolor=#ccccff>");
		out.println("<th>사번</th>");
		out.println("<th>이름</th>");
		out.println("<th>직위</th>");
		out.println("<th>입사일</th>");
		out.println("<th>부서명</th>");
		out.println("</tr>");
		//목록
		EmpDAO dao=EmpDAO.newInstance();
		List<EmpDTO> list=dao.empAllData();
		for(EmpDTO d:list)
		{
			out.println("<tr>");
			out.println("<td align=center>"+d.getEmpno()+"</td>");
			out.println("<td align=center>");
			out.println("<a href=MainServlet?type=2&empno="+d.getEmpno()+">");
			out.println(d.getEname()+"</a>");
			out.println("</td>");
			out.println("<td align=center>"+d.getJob()+"</td>");
			out.println("<td align=center>"+d.getHiredate().toString()+"</td>");
			out.println("<td align=center>"+d.getDname()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<hr width=600>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

}
