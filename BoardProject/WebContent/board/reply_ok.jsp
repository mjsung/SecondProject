<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.sist.dao.*"%>
<%-- <%
	request.setCharacterEncoding("EUC-KR");
	
%>
<jsp:useBean id="d" class="com.sist.dao.BoardDTO">
<jsp:setProperty name="d" property="*"/>
</jsp:useBean>>
 --%>
<%
	request.setCharacterEncoding("EUC-KR");
	String pno=request.getParameter("pno");
	String strPage=request.getParameter("page");
	String name=request.getParameter("name");
	
	String subject=request.getParameter("subject");
	String content=request.getParameter("content");
	String pwd=request.getParameter("pwd");
	
	BoardDTO d=new BoardDTO();
	d.setName(name);
	d.setSubject(subject);
	d.setContent(content);
	d.setPwd(pwd);
	
	//DB����
	BoardDAO dao=BoardDAO.newInstance();
	dao.boardReply(Integer.parseInt(pno),d);
	//list.jsp�� �̵� (�����̷�Ʈ)
	response.sendRedirect("list.jsp?page="+strPage);
%>