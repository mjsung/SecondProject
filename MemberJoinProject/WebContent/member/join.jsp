<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	td{
		font-family : 맑은 고딕;
		font-size : 9pt;
	}
</style>
</head>
<body>
<center>
<h3>Sign up</h3>
<form>
<table border=1 width=500 bordercolor=black cellspacing=0 cellpadding=0>
	<tr>
		<td>
			<table border = 0 width=500 cellspacing=0 cellpadding=0>
				<tr height=27>
					<td width=15% align=right>ID</td>
					<td width=85% align=left> &nbsp;&nbsp;<input type="text" size=12 name=id required="required">&nbsp;<input type=button value="중복체크"></td>
				</tr>
				
				<tr height=27>
					<td width=15% align=right>PWD</td>
					<td width=85% align=left> &nbsp;&nbsp;<input type="password" size=12 name=pwd>&nbsp;&nbsp;다시 입력 &nbsp;<input type="password" size=12 name=pwd1></td>
				</tr>
				
				<tr height=27>
					<td width=15% align=right>NAME</td>
					<td width=85% align=left> &nbsp;&nbsp;<input type="text" size=12 name=name></td>
				</tr>
				
				<tr height=27>
					<td width=15% align=right>SEX</td>
					<td width=85% align=left> &nbsp;&nbsp;<select name=sex><option selected>남자</option><option>여자</option></select></td>
				</tr>
				
				<tr height=27>
					<td width=15% align=right>BIRTH</td>
					<td width=85% align=left> &nbsp;&nbsp;<input type="date" size=12 name=birth></td>
				</tr>
				
				<tr height=27>
					<td width=15% align=right>EMAIL</td>
					<td width=85% align=left> &nbsp;&nbsp;<input type="email" size=45 name=email></td>
				</tr>
				
				<tr height=27>
					<td width=15% align=right>PHONE</td>
					<td width=85% align=left> &nbsp;&nbsp;<select name=tell1><option>010</option><option>011</option><option>017</option></select>&nbsp;<input type="text" size=12 name=tell2>&nbsp;-&nbsp;<input type="text" size=12 name=tell3></td>
				</tr>
				
				<tr height=27>
					<td width=15% align=right>POST</td>
					<td width=85% align=left> &nbsp;&nbsp;<input type="text" size=12 name=post1 readonly="readonly">&nbsp;-&nbsp;<input type="text" size=12 name=post2 readonly>&nbsp;<input type=button value="우편번호찾기"></td>
				</tr>
				
				<tr height=27>
					<td width=15% align=right>ADDR1</td>
					<td width=85% align=left> &nbsp;&nbsp;<input type="text" size=45 name=addr1 readonly="readonly"></td>
				</tr>
				
				<tr height=27>
					<td width=15% align=right>ADDR2</td>
					<td width=85% align=left> &nbsp;&nbsp;<input type="text" size=45 name=addr2></td>
				</tr>
				
				<tr height=27>
					<td width=15% align=right>CONTENT</td>
					<td width=85% align=left> &nbsp;&nbsp;<textarea rows="8" cols="50" name=content></textarea></td>
				</tr>
				
				<tr height=40>
					<td colspan="2" align=center><input type="button" value="확인">&nbsp;<input type="button" value="취소"></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</center>
</body>
</html>