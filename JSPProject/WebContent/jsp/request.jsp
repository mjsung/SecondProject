<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--
       javax.servlet.* : 자동 포함 
                내장 객체
         => request(*) : 브라우저 정보 , 요청 정보 , session생성,cookie생성,속성 추가
              ==> ***String request.getParameter() : 단일 데이터를 받는 경우
                  ***String[] request.getParameterValues() :  다중 데이터를 받는 경우
                     => checkbox
                  ***getRemoteAddr() : 클라이언트의 IP확인 
                  ===============
                                                조회수 증가
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
         => application(서버로그파일)
         => pageContext(파일업로드)
         => page(this)
         => out(버퍼 크기설정)
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
     <h3>Request 정보 보기(클라이언트,서버)</h3>
     사용자 IP : <%=request.getRemoteAddr() %><br>
     서버주소 :<%=request.getServerName() %><br>
     서버포트 :<%=request.getServerPort() %><br>
  데이터 전송 방식:<%=request.getMethod() %><br>
  URI :<%=request.getRequestURI() %><br>
  URL :<%=request.getRequestURL() %><br>
  prototcal:<%=request.getProtocol() %><br>
  ContextPath:<%=request.getContextPath() %>
   </center>
</body>
</html>





