<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--
     insert.jsp ==> insert_ok.jsp(sendRedirect)
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
  <%
       request.setCharacterEncoding("EUC-KR");
       //POST
       String name=request.getParameter("name");
       String sex=request.getParameter("sex");
       String tel1=request.getParameter("tel1");
       String tel2=request.getParameter("tel2");
       String[] hobby=request.getParameterValues("hobby");
  %>
  <h3>개인 정보 출력</h3>
  이름:<%=name %><br>
 성별:<%=sex %><br>
 전화:<%=tel1 %>)<%=tel2 %><br> <!--  010)111-111 -->
 <ul>
 <%
     try{
          for(String ho:hobby)
          {
 %>
           <li><%=ho %></li>   
 <% 
          }
     }catch(Exception ex)
     {
 %>
         <font color=red>취미가 없습니다</font>
 <%
     }
 
     response.sendRedirect("input.jsp");
 %>
 </ul>
</body>
</html>







