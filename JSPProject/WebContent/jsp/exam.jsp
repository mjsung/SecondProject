<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--
      1) ��ũ��Ʈ(Html�ڵ�ȿ� �ڹٻ��) 
         <% 
                           �ڹ� �ڵ�  => ������ �ڹٹ����� ����
                           �޼ҵ� ȣ��,��� (doGet,doPost)
                           ��������
         %>  ��ũ��Ʈ��
         
         <%!
                              �������(��������),�޼ҵ� ����
         %>  �����
         ================ ������ �����ϸ� ;�� ����Ѵ�(��ҹ��� ����)
         <%= �� %> ��½�(ǥ����) ==> ${}
           out.println(��);
             
      
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



