<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>글 상세 페이지 <h3>
	<% 
	BoardVO board = (BoardVO)request.getAttribute("board");
	%>
<table class="table">

	<tr>
		<th>글번호 : </th><td>${board.boardNo}</td>
	</tr>
	<tr>
		<th>제목 : </th><td>${board.title}</td>
	</tr>
	<tr>
		<th>글쓴이 : </th><td>${board.writer}</td>
	</tr>
	<tr>
		<th>글내용 : </th><td>${board.content}</td>
	</tr>
	<tr>
		<th>조회수 : </th><td>${board.viewCnt}</td>
	</tr>
	<tr>
		<th>작성일 : </th><td>${board.creationDate}</td>
	</tr>



</table>

<input type="button" onclick="location.href='boardList.do?page=${page}'" value ="목록으로">
<input type="button" onclick="location.href='modifyBoard.do?page=${page}&bno=${bno}'" value ="수정버튼">
<input type="button" onclick="location.href='removeBoard.do?page=${page}&bno=${bno}'" value ="삭제버튼">

<jsp:include page="../includes/footer.jsp"></jsp:include>