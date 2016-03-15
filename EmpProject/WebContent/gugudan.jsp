<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<%--
	<c:forEach var="i" begin=1 end=9>
		<c:forEach var="j" begin=2 end=9>
		${j+"*"+i+"="+j*i}
		</c:forEach>
	</c:forEach>
 --%>
<body>
	<center>
	<h3>구구단</h3>
	<table	border=1 width=600>
	<tr>
	<%
		for(int i=2;i<=9;i++)
		{
			%>
			<td><%=i+"단"%></td>
		<%
		}
	%>
	
	</tr>
	<%
		for(int i=1;i<=9;i++)
		{
			%>
			<tr>
			<%
			for(int j=2;j<=9;j++)
			{
				%>
				<td><%= j+"*"+i+"="+j*i %></td>
	<%	
			}
	%>
			</tr>
	<%
		}
	%>
	</table>
	</center>
	
</body>
</html>