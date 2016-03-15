package com.sist.view;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 수행방식전송 (브라우저) => html, xml
      response.setContentType("text/html;charset=EUC-KR");
      // MainServlet?type=1
      String type = request.getParameter("type");
      String file = "";
      if (type == null) {
         type = "0";
      }
      switch (Integer.parseInt(type)) {
         case 0 : {
            file = "EmpListServlet";
            break;
         }
         case 1 : {
            file = "InsertServlet";
            break;
         }
         case 2:
         {
        	 file="EmpDetailServlet";
        	break;
         }
         case 3:
         {
        	 file="EmpUpdateServlet";
         	break;
         }
      }
      PrintWriter out = response.getWriter();
      out.println("<html>");
      out.println("<body>");
      out.println("<center>");
      // 브라우저 출력
      out.println("<table border=1 bordercolor=black width=1000 height=700>");
      out.println("<tr>");
      out.println("<td height=150 colspan=2>");
      RequestDispatcher rd = request.getRequestDispatcher("HeaderServlet");
      rd.include(request, response);
      out.println("</td>");
      out.println("</tr>");
      out.println("<tr>");
      out.println("<td height=450 width=200>");
      out.println("&nbsp;");
      out.println("</td>");
      out.println("<td height=450 width=800 align=center valign=center>");
      //out.println("<td height=450 width=800 align=center style=\"margin-top:10px\">");
      rd = request.getRequestDispatcher(file);
      rd.include(request, response);
      //<jsp:include>
      out.println("</td>");
      out.println("</tr>");
      out.println("<tr>");
      out.println("<td height=100 colspan=2 align=center>");
      out.println("<address>서울시 마포구 백범로 미화빌딩 2층 쌍용강북교육센터 A강의장</address>");
      out.println("</td>");
      out.println("</tr>");
      out.println("</table>");
      out.println("</center>");
      out.println("</body>");
      out.println("</html>");
   }

}