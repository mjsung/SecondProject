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
 * let ==> 가벼운 프로그램 
 *	=> 실행순서
 *	생성자() ==> 메모리할당(tomcat)
 *=> 실행순서
 *	생성자() ==> 메모리할당(tomcat)
 *	init() ==> 멤버변수, 드라이버 등록, 파일읽기(XML)
 *	서비스 함수 ==> 관리(스레드)
 *	=====
 *		doGet
 *		doPost ==> 클라이언트로 결과값 전송
 *	=====
 *	destroy() : 메모리 해제
 */


public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException{
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * request : 사용자 요청값을 받을 때 사용
		 * response : 요청처리 후 결과값 전송
		 */
		//전송방식
		response.setContentType("text/html;charset=EUC-KR");
		//메모리에 출력
		PrintWriter out=response.getWriter();
		//s.getOutputStream() => out.write()
		//여는 태그<body> 닫는 태그</body> EMPTY태그 <br/>
		out.println("<html>");
		out.println("<body>");
		//화면 출력 부분
		out.println("<center>");
		out.println("<h3>구구단</h3>"); //제목(<b><br>)
		//h1~h6까지 있음 h6이 가장 작은 글씨
		out.println("<table border=1 width=560>");
		out.println("<tr>");
		for(int i=2;i<=9;i++)
		{
			out.println("<th>"+i+"단 </th>");
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
