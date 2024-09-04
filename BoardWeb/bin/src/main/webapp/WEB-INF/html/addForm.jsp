<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
	<%
	//자바의 영역.
	String message = (String)request.getAttribute("message");
	String msg = (String)request.getAttribute("msg");
	%>
<!--  -->
	<% if (message != null)  {%>
	<p style="color : red;"><%=message %></p>
	<%} %>
	<p><%=msg %></p>
	<form action ="addMember.do" method="post">
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
<jsp:include page="../includes/footer.jsp"></jsp:include>
	
	
</body>
</html>