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
  <h3>���� ���� ���</h3>
  �̸�:<%=name %><br>
 ����:<%=sex %><br>
 ��ȭ:<%=tel1 %>)<%=tel2 %><br> <!--  010)111-111 -->
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
         <font color=red>��̰� �����ϴ�</font>
 <%
     }
 
     response.sendRedirect("input.jsp");
 %>
 </ul>
</body>
</html>







