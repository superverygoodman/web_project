<%@page import="com.yedam.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<jsp:include page="../includes/header.jsp"></jsp:include><body>
	<%
	//jsp ->서블릿으로 변환되어서 실행.
	//memberList_jsp.class 실행.
	List<MemberVO> list = (List<MemberVO>) request.getAttribute("memberList");
	%>
	<h3>회원목록</h3>
	<table class="table">
		<thead>
			<tr>
				<th>이름</th><th>회원이름</th><th>이메일</th><th>권한</th>
			</tr>
		</thead>
		<tbody>
			<% for(MemberVO member : list) { %>
			<tr>
				<td><a href ="getMember.do?id=<%=member.getMemberId()%>"><%=member.getMemberId()%></a></td><td><%=member.getMemberName()%></td><td><%=member.getEmail()%></td><td><%=member.getAuthority()%></td>
			</tr>
			<%} %>
		</tbody>
	</table>
	<jsp:include page="../includes/footer.jsp"></jsp:include>>	
</body>
</html>