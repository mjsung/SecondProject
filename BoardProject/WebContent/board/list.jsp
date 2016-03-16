<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*,com.sist.dao.*"%>
<%
    int curpage=0;
    int totalpage=0;
    BoardDAO dao=BoardDAO.newInstance();
    // ���������� => ����ڷκ��� �޴´� 
    String strPage=request.getParameter("page");
    if(strPage==null)
    	strPage="1";
    curpage=Integer.parseInt(strPage);
    totalpage=dao.boardTotal();
    List<BoardDTO> list=dao.boardListData(curpage);
    int count=dao.boardCount();
    count=count-((curpage*10)-10);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="board.css">
</head>
<body>
   <center>
     <img src="image/qna.jpg" width=700 height=100>
     <p>
     <table border=0 width=700>
       <tr>
        <td align=left>
        <a href="insert.jsp">
         <img src="image/btn_write.gif" border=0></a>
        </td>
       </tr>
     </table>
     <table border=0 width=700>
      <tr bgcolor=#ccccff>
        <th width=10%>��ȣ</th>
        <th width=45%>����</th>
        <th width=15%>�̸�</th>
        <th width=20%>�ۼ���</th>
        <th width=10%>��ȸ��</th>
      </tr>
      <%
          int j=0;
          String color="white";
          for(BoardDTO d:list)
          {
        	  if(j%2==0)
        		  color="white";
        	  else
        		  color="rgb(231,206,255)";
      %>
              <tr bgcolor=<%=color %>>
                <td width=10% align=center><%=count-- %></td>
		        <td width=45% align=left>
		         <%
		            if(d.getGroup_tab()>0)
		            {
		            	for(int i=0;i<d.getGroup_tab();i++)
		            	{
		         %>
		                     &nbsp;&nbsp;
		         <%
		            	}
		         %>
		                <img src="image/icon_reply.gif">
		         <%
		            }
		         %>
		         <a href="content.jsp?no=<%=d.getNo()%>&page=<%=curpage%>"><%=d.getSubject() %></a>
		         <%
		            String today=new SimpleDateFormat("yyyy-MM-dd").
		                        format(new Date());
		            String dbday=d.getRegdate().toString();
		            if(today.equals(dbday))
		            {
		         %>
		              &nbsp;<sup><img src="image/icon_new (2).gif"></sup>
		         <%
		            }
		         %>
		        </td>
		        <td width=15% align=center><%=d.getName() %></td>
		        <td width=20% align=center><%=d.getRegdate().toString() %></td>
		        <td width=10% align=center><%=d.getHit() %></td>
              </tr>
      <%
             j++;
          }
      %>
     </table>
     <hr width=700>
     <table border=0 width=700>
      <tr>
       <td align=left>
        <select name=fs>
         <option value="name">�̸�</option>
         <option value="subject">����</option>
         <option value="content">����</option>
        </select>
        <input type=text name=ss size=12>
        <input type=image src="image/btn_search.gif">
       </td>
       <td align="right">
        <a href="list.jsp?page=1">
        <img src="image/begin.gif" border=0></a>
        <a href="list.jsp?page=<%=curpage>1?curpage-1:curpage%>">
        <img src="image/prev.gif" border=0></a>
        [1][2][3][4][5]
        <a href="list.jsp?page=<%=curpage<totalpage?curpage+1:curpage%>">
        <img src="image/next.gif" border=0></a>
        <a href="list.jsp?page=<%=totalpage%>">
        <img src="image/end.gif" border=0></a>
        &nbsp;&nbsp;
        <%=curpage %> page / <%=totalpage %> pages
       </td>
      </tr>
     </table>
   </center>
</body>
</html>






