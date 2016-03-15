<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function send()
{
	/*
	    자바스크립트 구조 : 계층형 
	    브라우저 : window 
	    화면 : document
	   입력 : form
	  document.form.input
	  == 태그 : 객체
	*/
	var f=document.frm;
	if(f.name.value=="")
	{
		alert("이름을 입력하세요");
		f.name.focus();
		return;
	}
	f.submit();
}
</script>
</head>
<body>
   <center>
     <h3>개인 정보</h3>
     <form method=post action="output.jsp" name=frm>
     <table border=1 width=380>
       <tr>
        <td width=25%>이름</td>
        <td width=75% align=left>
         <input type=text name=name size=12>
        </td>
       </tr>
       <tr>
        <td width=25%>성별</td>
        <td width=75% align=left>
         <input type=radio name=sex value="남자" checked>남자
         <input type=radio name=sex value="여자">여자
        </td>
       </tr>
       <tr>
        <td width=25%>전화번호</td>
        <td width=75% align=left>
         <select name="tel1">
           <option>010</option>
           <option>011</option>
           <option>017</option>
         </select>
         <input type="text" size=15 name="tel2">
        </td>
       </tr>
       <tr>
        <td width=25%>취미</td>
        <td width=75% align=left>
         <input type="checkbox" name=hobby value=운동>운동
         <input type="checkbox" name=hobby value=독서>독서
         <input type="checkbox" name=hobby value=게임>게임
         <input type="checkbox" name=hobby value=등산>등산
         <input type="checkbox" name=hobby value=낚시>낚시
        </td>
       </tr>
       <tr>
        <td colspan="2" align=center>
         <input type=button value=전송 onclick="send()">
         <input type=button value=취소>
        </td>
       </tr>
     </table>
     </form>
   </center>
</body>
</html>





