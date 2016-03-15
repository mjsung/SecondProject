<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--
       javax.servlet.* : �ڵ� ���� 
                ���� ��ü
         => request(*) : ������ ���� , ��û ���� , session����,cookie����,�Ӽ� �߰�
              ==> ***String request.getParameter() : ���� �����͸� �޴� ���
                  ***String[] request.getParameterValues() :  ���� �����͸� �޴� ���
                     => checkbox
                  ***getRemoteAddr() : Ŭ���̾�Ʈ�� IPȮ�� 
                  ===============
                                                ��ȸ�� ����
                  getPort() : 8080
                  getProtocol() : HTTP
                  getMethod() : GET,POST
                  MVC  => list.do
                  ***getRequestURI()
                  ***getContextPath()
                  getServerName()
                  getServetPort()
                  *.do 
                  http://localhost:8080/JSPProject/update.do ==> URL
                  ====   ========= ====
                  protocol server_name port
                  /jsp/exam.jsp ==> URI
                  =====
                  ContextPath
         => response(*)
         => session(*)
         => application(�����α�����)
         => pageContext(���Ͼ��ε�)
         => page(this)
         => out(���� ũ�⼳��)
         => exception(try~catch)
         => config(web.xml)
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
   <center>
     <h3>Request ���� ����(Ŭ���̾�Ʈ,����)</h3>
     ����� IP : <%=request.getRemoteAddr() %><br>
     �����ּ� :<%=request.getServerName() %><br>
     ������Ʈ :<%=request.getServerPort() %><br>
  ������ ���� ���:<%=request.getMethod() %><br>
  URI :<%=request.getRequestURI() %><br>
  URL :<%=request.getRequestURL() %><br>
  prototcal:<%=request.getProtocol() %><br>
  ContextPath:<%=request.getContextPath() %>
   </center>
</body>
</html>





