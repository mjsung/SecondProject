<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String strNo=request.getParameter("no");
	String strPage=request.getParameter("page");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="board.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.js"></script>
<script type="text/javascript">
//window.onload=function(){}
//$(document).ready(function{}))
/*
 * selector: ���尴ü, �±׸�, id��, Ŭ�������� ������
 	$(window), $(document)
 	$('tr'), $('td')..
 	ID => $('#id��')
 	Ŭ������ =>  $('.class��')
 	
 	�ڹٽ�ũ��Ʈ ����
	var i=0 => ����
	var i=0.0 => �Ǽ�
	var i=[] => array
	var i={} => object
	var i="" => string
 */
$(function(){
	$('#sendBtn').click(function(){
		var	name=$('#name').val();
		/*
		$('#name').val(); => get
		$('#name').val("aaa"); => set
		*/
		if(name.trim()=="")
		{
			$('#name').focus();
			return;
		}
		var	sub=$('#subject').val();
		
		if(sub.trim()=="")
		{
			$('#subject').focus();
			return;
		}
		var	cont=$('#content').val();
		
		if(cont.trim()=="")
		{
			$('#content').focus();
			return;
		}
		var	pwd=$('#pwd').val();
		
		if(pwd.trim()=="")
		{
			$('#pwd').focus();
			return;
		}
		$('#frm').submit();
	});
});
</script>
</head>
<body>
	 <center>
     <img src="image/qna.jpg" width=500 height=100>
     <p>
     <form method=post action="reply_ok.jsp" id="frm">
    <table border=1 bordercolor="black" width=500 cellpadding="0" cellspacing="0">
    	<tr>
    	<td>
    		<table border=0 width=500>
    		<tr>
    		<td width=15% align=right>�̸�</td>
    		<td width=85% align=left>
    		<input type=text name=name size=12 id="name">
    		<input type="hidden" name="pno" value="<%=strNo%>">
    		<input type="hidden" name="page" value="<%=strPage%>">
    		</td>
    		</tr>
    		<tr>
    		<td width=15% align=right>����</td>
    		<td width=85% align=left>
    		<input type=text name=subject size=53 id="subject">
    		</td>
    		</tr>
    		<tr>
    		<td width=15% align=right valign="top">����</td>
    		<td width=85% align=left>
    		<textarea rows="10" cols="50" name=content id="content"></textarea>
    		</td>
    		</tr>
    		<tr>
    		<td width=15% align=right>��й�ȣ</td>
    		<td width=85% align=left>
    		<input type="password" name=pwd size=10 id="pwd">
    		</td>
    		</tr>
    		<tr>
    		<td colspan="2" align="center">
    		<input type="button" value="�亯" id="sendBtn">
    		<input type="button" value="���"
    		onclick="javascript:history.back()"
    		>
    		</td>
    		</tr>
    		</table>
    	</td>
    	</tr>
    </table>
    </form>
    </center>
</body>
</html>