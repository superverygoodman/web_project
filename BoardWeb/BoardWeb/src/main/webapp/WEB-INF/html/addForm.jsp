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
	//�ڹ��� ����.
	String message = (String)request.getAttribute("msg");
	%>
<!--  -->
	<p><%=message %></p>
	<form action ="addMember.do">
		ȸ�����̵� : <input type ="text" name = "id"><br>
		ȸ���̸� : <input type = "text" name = "name"><br>
		��й�ȣ : <input type = "password" name = "pass"><br>
		�̸��� : <input type = "email" name = "email"><br>
		<input type = "submit">
	</form>
	
	
	
</body>
</html>