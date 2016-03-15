package com.sist.emp;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// C:\webDev\webStudy3\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\EmpSubQueryProject
/*
 *   <servlet>
    <servlet-name>emp</servlet-name>
    <servlet-class>com.sist.emp.EmpServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>emp</servlet-name>
    <url-pattern>/EmpServlet</url-pattern>
  </servlet-mapping>
 */
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}






