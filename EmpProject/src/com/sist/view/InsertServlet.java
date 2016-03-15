package com.sist.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.sist.dao.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		//브라우저 출력
		EmpDAO dao=new EmpDAO();
		out.println("<form action=InsertServlet method=post>");
		out.println("<table width=500 bordercolor=black cellspacing=0>");
		out.println("<tr>");
		out.println("<td width=15% align=right>이름</td>");
		out.println("<td width=35% align=left>");
		out.println("<input type=text size=12 name=ename>");
		out.println("</td>");
		out.println("<td width=15% align=right>직위</td>");
		out.println("<td width=35% align=left>");
		List<String> jList=dao.empGetJob();
		out.println("<select name=job>");
		for(String s:jList)
		{
			out.println("<option>"+s+"</option>");
		}
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=15% align=right>사수번호</td>");
		out.println("<td width=35% align=left>");
		List<Integer> mList=dao.empGetMgr();
		out.println("<select name=mgr>");
		for(int m:mList)
		{
			out.println("<option>"+m+"</option>");
		}
		out.println("</select>");
		out.println("</td>");
		out.println("<td width=15% align=right>부서번호</td>");
		out.println("<td width=35% align=left>");
		out.println("<select name=deptno>");
		out.println("<option>10</option>");
		out.println("<option>20</option>");
		out.println("<option>30</option>");
		out.println("<option>40</option>");
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=15% align=right>급여</td>");
		out.println("<td width=35% align=left>");
		out.println("<select name=sal>");
		out.println("<option>1000</option>");
		out.println("<option>2000</option>");
		out.println("<option>3000</option>");
		out.println("<option>4000</option>");
		out.println("<option>4500</option>");
		out.println("</select>");
		out.println("</td>");
		out.println("<td width=15% align=right>성과급</td>");
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
		out.println("<td colspan=4 align=center>");
		out.println("<input type=submit value=등록>");
		out.println("<input type=button value=취소 onclick=\"javascript:history.back()\">");
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
		String ename=request.getParameter("ename");
		System.out.println(ename);
		String job=request.getParameter("job");
		String mgr=request.getParameter("mgr");
		String sal=request.getParameter("sal");
		String comm=request.getParameter("comm");
		String deptno=request.getParameter("deptno");
		EmpDTO d=new EmpDTO();
		EmpDAO dao=EmpDAO.newInstance();
		d.setEname(ename);
		d.setJob(job);
		d.setMgr(Integer.parseInt(mgr));
		d.setSal(Integer.parseInt(sal));
		d.setComm(Integer.parseInt(comm));
		d.setDeptno(Integer.parseInt(deptno));
		dao.empInsert(d);
		response.sendRedirect("MainServlet");
	}
}
