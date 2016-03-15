<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--
      1) 스크립트(Html코드안에 자바사용) 
         <% 
                           자바 코드  => 문법은 자바문법이 적용
                           메소드 호출,제어문 (doGet,doPost)
                           지역변수
         %>  스크립트릿
         
         <%!
                              멤버변수(전역변수),메소드 선언
         %>  선언식
         ================ 문장이 종료하면 ;을 사용한다(대소문자 구분)
         <%= 값 %> 출력식(표현식) ==> ${}
           out.println(값);
             
      
 --%>
<%!
      int a=10;
      int b=20;
      public int add(int a,int b)
      {
    	  return a+b;
      } // Bean
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
   <%
       int c=add(10,20);
   %>
   a:<%=a %><br>
   b:<%=b %><br>
   c:<%=c %><br>
</body>
</html>



