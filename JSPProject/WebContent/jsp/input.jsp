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
	    �ڹٽ�ũ��Ʈ ���� : ������ 
	    ������ : window 
	    ȭ�� : document
	   �Է� : form
	  document.form.input
	  == �±� : ��ü
	*/
	var f=document.frm;
	if(f.name.value=="")
	{
		alert("�̸��� �Է��ϼ���");
		f.name.focus();
		return;
	}
	f.submit();
}
</script>
</head>
<body>
   <center>
     <h3>���� ����</h3>
     <form method=post action="output.jsp" name=frm>
     <table border=1 width=380>
       <tr>
        <td width=25%>�̸�</td>
        <td width=75% align=left>
         <input type=text name=name size=12>
        </td>
       </tr>
       <tr>
        <td width=25%>����</td>
        <td width=75% align=left>
         <input type=radio name=sex value="����" checked>����
         <input type=radio name=sex value="����">����
        </td>
       </tr>
       <tr>
        <td width=25%>��ȭ��ȣ</td>
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
        <td width=25%>���</td>
        <td width=75% align=left>
         <input type="checkbox" name=hobby value=�>�
         <input type="checkbox" name=hobby value=����>����
         <input type="checkbox" name=hobby value=����>����
         <input type="checkbox" name=hobby value=���>���
         <input type="checkbox" name=hobby value=����>����
        </td>
       </tr>
       <tr>
        <td colspan="2" align=center>
         <input type=button value=���� onclick="send()">
         <input type=button value=���>
        </td>
       </tr>
     </table>
     </form>
   </center>
</body>
</html>





