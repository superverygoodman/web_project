<%@page import="com.yedam.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<jsp:include page="../includes/header.jsp"></jsp:include><body>
	<%
	//jsp ->�������� ��ȯ�Ǿ ����.
	//memberList_jsp.class ����.
	List<MemberVO> list = (List<MemberVO>) request.getAttribute("memberList");
	%>
	<h3>ȸ�����</h3>
	<table class="table">
		<thead>
			<tr>
				<th>�̸�</th><th>ȸ���̸�</th><th>�̸���</th><th>����</th>
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