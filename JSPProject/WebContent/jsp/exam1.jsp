<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*,java.text.*" errorPage="error.jsp"%>
<%--
  <%@ page import="java.util.*" %>
  <%@ page import="java.text.*" %>
--%>
<%--
      ������ 
    = page : JSP���Ͽ� ���� ���� 
    = tablib : �±� ���̺귯�� 
        <c:forEach>:for , <c:if>:if , <c:choose>:switch 
        <c:redirect> : sendRedirect()
        <fmt:formatDate> : SimpleDateFormat
    = include : JSPƯ�������� �ٸ� JSP�� ÷���ؼ� ��� 
      RequestDispatcher => include()
    => ���� 
       <%@ page �Ӽ�=��... import="java.io.*,java.util.*"%>
       <%@ include �Ӽ�=��...  file="fileName"%>
       <%@ taglib prefix="core" ..%>
    => JSP�� ����� 
       1)Ŭ���̾�Ʈ ��û  => http://localhost:8080/jsp/exam.jsp
       2)���� ã�� (������) : .html,.htm,xml,�׸�����
                   ==> ���� (404)
                    ��Ĺ => ����,jsp (��ȯ)
         jsp => 1) Ŭ���� ( a.jsp ==> a_jsp.java ) ����
                   => ���� �ڵ� (����(o): ����, ����(x):����)
                2) ������ 
                     = ���� (500)
                3) ���������� (���پ� �޸𸮿� ���)
                   out.println() , <%= %>
                   JVM 
                    1) _jspInit() : init()
                    2) _jspService() : doGet,doPost
                    3) _jspDestory() : �޸� ����
                4) _jspService() ==> �޸𸮿� HTML,XML�� ���
                5) ��µ� �޸𸮸� => Ŭ���̾�Ʈ ���������� �о ȭ�鿡
                                           ��� 
                                           
     => ������  : page
        page�� �Ӽ� 
        language="java" : �ٸ���� ����� ���� 
        info="�Խ��� ���뺸�� ȭ�� (2016.03.14 ������ ����)"          
        ***contentType="text/html,text/xml;charset=EUC-KR,UTF-8" 
        ***import : �ڹ� Ŭ���� �ε� 
        <%@ page import="java.io.*,java.util.*">
        <%@ page import="java.io.*">
        <%@ page import="java.io.*">
        ***errorPage 
          
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
  <%
      Date date=new Date();
      // ��¥ ���� ���� (yyyy MM dd hh mm ss)
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
      String today=sdf.format(date);
      int a=10/0;
  %>
  <!-- ��¥ ���  -->
  ���� ��¥:<%= today %><br>
 a:<%=a %>
</body>
</html>







