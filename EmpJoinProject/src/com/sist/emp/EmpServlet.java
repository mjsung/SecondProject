package com.sist.emp;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;
//import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
//a.jsp ==> a_jsp.java (컴파일을 해야하기 때문에 java 파일로 바뀌는거얌! 톰캣(tomcat)은 jsp 엔진이다!)
// @WebServlet("/EmpServlet") 주소가 EmpServlet이 들어오면 아래 클래스를 실행해라! -> annotation -> xml 대체하는 프로그램

public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out=response.getWriter();
		//OutputStream out=s.getOutputStream(); 과 같은 것임!
		// /EmpServlet?page=1 라고 나올거야! url 주소를 통해서 값을 받아야해
		String strPage=request.getParameter("page");
		if(strPage==null)
		{
			strPage="1"; // page를 처음 1이라고 디폴트를 줘야함. 이단계를 안하면 오류남!
		}
		int curpage=Integer.parseInt(strPage);
		EmpDAO dao=new EmpDAO();
		ArrayList<EmpDTO> list=dao.empAllData(curpage);
		
		int totalpage=dao.empTotalPage();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<style type=text/css>");
		out.println("th,td{font-family:맑은 고딕;font-size:9pt}");
		out.println("a{text-decoration:none;color:black}");
		out.println("a:hover{text-decoration:underline;color:green}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h3><b>사원 목록<b></h3>");
		out.println("<table border=0 width=600>");
		out.println("<tr bgcolor=#ccccff>");
		out.println("<th>사번</th>");
		out.println("<th>이름</th>");
		out.println("<th>직위</th>");
		out.println("<th>부서</th>");
		out.println("<th>근무지</th>");
		out.println("<th>등급</th>");
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
		out.println("<select>"); //콤보박스
		out.println("<option>이름</option>");
		out.println("<option>부서</option>");
		out.println("<option>직위</option>");
		out.println("</select>");
		out.println("<input type=text size=10>");
		out.println("<input type=button value=찾기>");
		out.println("</td>");
		out.println("<td align=right>");
		out.println("<a href=EmpServlet?page="+(curpage>1?curpage-1:curpage)+">");
		out.println("<img src=image/prev.gif border=0></a>");
		out.println("<a href=EmpServlet?page="+(curpage<totalpage?curpage+1:curpage)+">");
		/*
		 * 	1) 404 : 파일이 존재하지 않을 때(파일명 찾기)
		 * 	2) 500 : 소스 컴파일 상에서 에러(소스 코드 찾아보기)
		 * 	3) 412 : 한글 변환 코드를 잘 못 줬을 때(EUC-KR,UTF-8)
		 * 	4) 200 : 정상 수행 ==> 화면을 출력
		 * 	5) 403 : 접속 거부
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
		out.println("&nbsp;&nbsp;"); //공백!
		out.println(curpage+" page / "+totalpage+" pages");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

}
