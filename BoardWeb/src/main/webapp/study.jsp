<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action ="index.do" method="post">
	<table class="table">
		<tr><th>회원아이디 :</th><td><input type ="text" name = "id"></td></tr>
		<tr><th>회원이름 :</th><td><input type = "text" name = "name"></td></tr>
		<tr><th>비밀번호 :</th><td><input type = "password" name = "pass"></td></tr>
		<tr><th>이메일 :</th><td><input type = "email" name = "email"></td></tr>
		<tr><td colspan = "2" align ="center">
		<input class = "btn btn-success" type = "submit">
		<input type = "reset" class = "btn btn-warning" value = "Reset">
		</td></tr>
	</table>
	</form>
</body>
</html>