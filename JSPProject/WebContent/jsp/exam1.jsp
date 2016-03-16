<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*,java.text.*" errorPage="error.jsp"%>
<%--
  <%@ page import="java.util.*" %>
  <%@ page import="java.text.*" %>
--%>
<%--
      지시자 
    = page : JSP파일에 대한 정보 
    = tablib : 태그 라이브러리 
        <c:forEach>:for , <c:if>:if , <c:choose>:switch 
        <c:redirect> : sendRedirect()
        <fmt:formatDate> : SimpleDateFormat
    = include : JSP특정영역에 다른 JSP를 첨부해서 사용 
      RequestDispatcher => include()
    => 사용법 
       <%@ page 속성=값... import="java.io.*,java.util.*"%>
       <%@ include 속성=값...  file="fileName"%>
       <%@ taglib prefix="core" ..%>
    => JSP의 실행법 
       1)클라이언트 요청  => http://localhost:8080/jsp/exam.jsp
       2)파일 찾기 (웹서버) : .html,.htm,xml,그림파일
                   ==> 에러 (404)
                    톰캣 => 서블릿,jsp (변환)
         jsp => 1) 클래스 ( a.jsp ==> a_jsp.java ) 생성
                   => 서블릿 코드 (존재(o): 수정, 존재(x):생성)
                2) 컴파일 
                     = 에러 (500)
                3) 인터프리터 (한줄씩 메모리에 출력)
                   out.println() , <%= %>
                   JVM 
                    1) _jspInit() : init()
                    2) _jspService() : doGet,doPost
                    3) _jspDestory() : 메모리 해제
                4) _jspService() ==> 메모리에 HTML,XML을 출력
                5) 출력된 메모리를 => 클라이언트 브라우저에서 읽어서 화면에
                                           출력 
                                           
     => 지시자  : page
        page의 속성 
        language="java" : 다른언어 사용이 가능 
        info="게시판 내용보기 화면 (2016.03.14 성민재 제작)"          
        ***contentType="text/html,text/xml;charset=EUC-KR,UTF-8" 
        ***import : 자바 클래스 로딩 
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
      // 날짜 패턴 지정 (yyyy MM dd hh mm ss)
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
      String today=sdf.format(date);
      int a=10/0;
  %>
  <!-- 날짜 출력  -->
  오늘 날짜:<%= today %><br>
 a:<%=a %>
</body>
</html>







