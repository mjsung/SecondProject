package com.sist.view;

import java.io.*;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 	페이지 이동(화면 전환)
 * HTML
 * 	<a> => GET 방식
 * 	<form> => GET, POST 방식
 * JavaScript
 * 	location.href="URL" => GET 방식
 * Java
 * 	response.sendRedirect() => GET 방식
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
		out.println("<h3>사원 상세보기</h3>");
		out.println("<table width=500 border=1 bordercolor=black cellspacing=0 cellpadding=0>");
		out.println("<tr>");
		out.println("<td width=20%>사번</td>");
		out.println("<td width=30%>"+d.getEmpno()+"</td>");
		out.println("<td width=20%>이름</td>");
		out.println("<td width=30%>"+d.getEname()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=20%>직위</td>");
		out.println("<td width=30%>"+d.getJob()+"</td>");
		out.println("<td width=20%>입사일</td>");
		out.println("<td width=30%>"+d.getHiredate().toString()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=20%>사수번호</td>");
		out.println("<td width=30%>"+d.getMgr()+"</td>");
		out.println("<td width=20%>부서명</td>");
		out.println("<td width=30%>"+d.getDname()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=20%>급여</td>");
		out.println("<td width=30%>"+d.getSal()+"</td>");
		out.println("<td width=20%>성과급</td>");
		out.println("<td width=30%>"+d.getComm()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan=4 align=rignt>");
		out.println("<a href=MainServlet?type=3&empno="+d.getEmpno()+">수정</a>&nbsp;");
		out.println("<a href=\"javascript:del()\">삭제</a>&nbsp;");
		out.println("<a href=EmpListServlet>목록</a>&nbsp;");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr id=\"del\" style=\"display:none\">");
		out.println("<td colspan=4 align=rignt>");
		out.println("<form method=post action=EmpDetailServlet>");
		out.println("사번:<input type=text name=empno size=12>");
		out.println("<input type=submit value=삭제>");
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
			out.println("alert(\"사번이 존재하지 않습니다\");");
			out.println("history.back();");
			out.println("</script>");
		}
	}
}


















