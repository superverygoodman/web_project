<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//자바의 영역.
	String message = (String)request.getAttribute("msg");
	%>
<!--  -->
	<p><%=message %></p>
	<form action ="addMember.do">
		회원아이디 : <input type ="text" name = "id"><br>
		회원이름 : <input type = "text" name = "name"><br>
		비밀번호 : <input type = "password" name = "pass"><br>
		이메일 : <input type = "email" name = "email"><br>
		<input type = "submit">
	</form>
	
	
	
</body>
</html>