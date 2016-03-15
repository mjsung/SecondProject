<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.sist.dao.*"%>
<%
    String strNo=request.getParameter("no");
    String strPage=request.getParameter("page");
    BoardDAO dao=BoardDAO.newInstance();
    BoardDTO d=dao.boardContentData(Integer.parseInt(strNo));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="board.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.js"></script>
<script type="text/javascript">
 var i=0;
 $(function(){
	$('#del').click(function(){
		if(i==0)
	    {
			$('#delTr').show();
			i=1;
	    }
		else
		{
			$('#delTr').hide();
		}
	});
 });
</script>
</head>
<body>
  <center>
    <img src="image/qna.jpg" width=700 height=100>
    <p>
    
        <table border=1 bordercolor="#ccccff" width=700 cellpadding="0" cellspacing="0">
	      <tr height=27>
	        <td width=20% align=center bgcolor="#ccccff">번호</td>
	        <td width=30% align=center><%=d.getNo() %></td>
	        <td width=20% align=center bgcolor="#ccccff">작성일</td>
	        <td width=30% align=center><%=d.getStrDay() %></td>
	      </tr>
	      <tr height=27>
	        <td width=20% align=center bgcolor="#ccccff">이름</td>
	        <td width=30% align=center><%=d.getName() %></td>
	        <td width=20% align=center bgcolor="#ccccff">조회수</td>
	        <td width=30% align=center><%=d.getHit() %></td>
	      </tr>
	      <tr height=27>
	        <td width=20% align=center bgcolor="#ccccff">제목</td>
	        <td colspan="3" align=left><%=d.getSubject() %></td>
	      </tr>
	      <tr>
	        <td colspan="4" align=left valign="top" height=200>
	          <pre><%=d.getContent() %></pre>
	        </td>
	      </tr>
       </table>
       <table border=0 width=700>
         <tr>
           <td align=right>
            <img src="image/btn_reply.gif">
            <img src="image/btn_modify.gif">
            <img src="image/btn_delete.gif" id="del">
            <a href="list.jsp?page=<%=strPage%>">
            <img src="image/btn_list.gif" border=0></a>
           </td>
         </tr>
         <tr style="display:none" id="delTr">
           <td align=right>
                         비밀번호:<input type="password" name=pwd size=10>
           <input type=button value=삭제>             
           </td>
         </tr>
       </table>
  </center>
</body>
</html>





