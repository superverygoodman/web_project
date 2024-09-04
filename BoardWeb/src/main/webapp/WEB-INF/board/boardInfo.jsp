<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>글 상세 페이지 <h3>
	<% 
	BoardVO board = (BoardVO)request.getAttribute("board");
	%>
<form action="modifyControl.do">
<input type="hidden" value="${board.boardNo}" name="bno">
<input type="hidden" value="${page}" name="page">
<table class="table">
	<tr>
		<th>글번호 : </th><td>${board.boardNo}</td>
	</tr>
	<tr>
		<th>제목 : </th><td><input type ="text" value="${board.title}" name="title"></td>
	</tr>
	<tr>
		<th>글쓴이 : </th><td>${board.writer}</td>
	</tr>
	<tr>
		<th>글내용 : </th><td><input type ="text" value="${board.content}" name="content"></td>
	</tr>
	<tr>
		<th>조회수 : </th><td>${board.viewCnt}</td>
	</tr>
	<tr>
		<th>작성일 : </th><td>${board.creationDate}</td>
	</tr>
</table>
<button type="submit" >저장</button>
<button >취소</button>
</form>


</table>


<jsp:include page="../includes/footer.jsp"></jsp:include>