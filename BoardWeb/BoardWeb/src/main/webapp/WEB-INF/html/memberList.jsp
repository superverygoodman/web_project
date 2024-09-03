<%@page import="com.yedam.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.service.MemberServiceImpl"%>
<%@page import="com.yedam.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원목록 출력.</title>
</head>
<body>
	<%
	MemberService svc = new MemberServiceImpl();
		List <MemberVO> list = svc.getMembers();
	%>
	<h3>회원목록</h3>
	<table border="2">
		<thead>
			<tr>
				<th>이름</th><th>회원이름</th><th>이메일</th><th>권한</th>
			</tr>
		</thead>
		<tbody>
			<% for(MemberVO member : list) { %>
			<tr>
				<td><%=member.getMemberId()%></td><td><%=member.getMemberName()%></td><td><%=member.getEmail()%></td><td><%=member.getAuthority()%></td>
			</tr>
			<%} %>
		</tbody>
	
	</table>	
</body>
</html>