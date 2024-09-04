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
		<th>제목 : </th><td>${board.title}</td>
	</tr>
	<tr>
		<th>글쓴이 : </th><td>${board.writer}</td>
	</tr>



</table>
  <div class="card-body">
    <h5 class="card-title">${board.title}</h5>
    <h6 class="card-subtitle mb-2 text-body-secondary">${board.writer} :${board.creationDate}</h6>
    <p class="card-text">${board.content}</p>
    <p>${board.viewCnt}</p>
    <p>${pages}</p>
    <p>${page}</p>
  </div>
</div>
<input type="button" onclick="location.href='boardList.do?page=${page}'" value ="목로긍로">
<input type="button" onclick="location.href='boardList.do?page=${page}'" value ="수정버튼">

<jsp:include page="../includes/footer.jsp"></jsp:include>